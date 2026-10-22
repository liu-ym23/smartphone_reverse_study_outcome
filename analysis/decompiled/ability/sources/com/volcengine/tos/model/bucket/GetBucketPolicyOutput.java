package com.volcengine.tos.model.bucket;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetBucketPolicyOutput {
    private String policy;
    private RequestInfo requestInfo;

    public String getPolicy() {
        return this.policy;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetBucketPolicyOutput setPolicy(String str) {
        this.policy = str;
        return this;
    }

    public GetBucketPolicyOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketPolicyOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", policy='");
        return a.q(sb, this.policy, "'}");
    }
}
