package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketReplicationOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("Rules")
    private List<ReplicationRule> rules;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<ReplicationRule> getRules() {
        return this.rules;
    }

    public GetBucketReplicationOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetBucketReplicationOutput setRules(List<ReplicationRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketReplicationOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", rules=");
        return a.r(sb, this.rules, '}');
    }
}
