package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketLifecycleOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("Rules")
    private List<LifecycleRule> rules;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<LifecycleRule> getRules() {
        return this.rules;
    }

    public GetBucketLifecycleOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetBucketLifecycleOutput setRules(List<LifecycleRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketLifecycleOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", rules=");
        return a.r(sb, this.rules, '}');
    }
}
