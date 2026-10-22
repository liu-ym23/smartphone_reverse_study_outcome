package com.volcengine.tos.model.bucket;

import com.stepos.statsrpk.service.c;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class PutBucketCORSOutput {
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public PutBucketCORSOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return c.g(new StringBuilder("PutBucketCORSOutput{requestInfo="), this.requestInfo, '}');
    }
}
