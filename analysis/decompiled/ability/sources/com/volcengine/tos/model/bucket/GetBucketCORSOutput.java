package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketCORSOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("CORSRules")
    private List<CORSRule> rules;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<CORSRule> getRules() {
        return this.rules;
    }

    public GetBucketCORSOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetBucketCORSOutput setRules(List<CORSRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketCORSOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", rules=");
        return a.r(sb, this.rules, '}');
    }
}
