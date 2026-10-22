package com.volcengine.tos.model.bucket;

import com.stepos.statsrpk.service.c;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class PutBucketLifecycleOutput {
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public PutBucketLifecycleOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return c.g(new StringBuilder("PutBucketLifecycleOutput{requestInfo="), this.requestInfo, '}');
    }
}
