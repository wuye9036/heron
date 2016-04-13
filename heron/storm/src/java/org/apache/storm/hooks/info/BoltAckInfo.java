// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.storm.hooks.info;

import org.apache.storm.tuple.Tuple;

public class BoltAckInfo {
  public Tuple tuple;
  public int ackingTaskId;
  public Long processLatencyMs; // null if it wasn't sampled
  
  public BoltAckInfo(Tuple tuple, int ackingTaskId, Long processLatencyMs) {
    this.tuple = tuple;
    this.ackingTaskId = ackingTaskId;
    this.processLatencyMs = processLatencyMs;
  }

  public BoltAckInfo(com.twitter.heron.api.hooks.info.BoltAckInfo info) {
    this.tuple = new org.apache.storm.tuple.TupleImpl(info.getTuple());
    this.ackingTaskId = info.getAckingTaskId();
    this.processLatencyMs = info.getProcessLatencyMs();
  }
}
