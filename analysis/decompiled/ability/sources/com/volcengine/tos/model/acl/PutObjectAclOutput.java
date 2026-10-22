package com.volcengine.tos.model.acl;

import com.volcengine.tos.model.RequestInfo;

@Deprecated
/* loaded from: classes3.dex */
public class PutObjectAclOutput {
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public PutObjectAclOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }
}
