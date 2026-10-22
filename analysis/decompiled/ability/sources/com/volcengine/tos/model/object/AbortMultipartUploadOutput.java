package com.volcengine.tos.model.object;

import com.stepos.statsrpk.service.c;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class AbortMultipartUploadOutput {
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public AbortMultipartUploadOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return c.g(new StringBuilder("AbortMultipartUploadOutput{requestInfo="), this.requestInfo, '}');
    }
}
