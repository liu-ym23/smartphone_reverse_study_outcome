package com.volcengine.tos.model.bucket;

import com.stepos.statsrpk.service.c;
import com.volcengine.tos.model.RequestInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DeleteBucketOutput implements Serializable {
    private RequestInfo requestInfo;

    public DeleteBucketOutput(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public DeleteBucketOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return c.g(new StringBuilder("DeleteBucketOutput{requestInfo="), this.requestInfo, '}');
    }
}
