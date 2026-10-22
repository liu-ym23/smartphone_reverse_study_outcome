package com.volcengine.tos.model.bucket;

import com.stepos.statsrpk.service.c;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class DeleteBucketWebsiteOutput {
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public DeleteBucketWebsiteOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return c.g(new StringBuilder("DeleteBucketWebsiteOutput{requestInfo="), this.requestInfo, '}');
    }
}
