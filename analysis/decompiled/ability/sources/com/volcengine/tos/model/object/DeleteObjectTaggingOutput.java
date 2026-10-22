package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class DeleteObjectTaggingOutput {
    private RequestInfo requestInfo;
    private String versionID;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public DeleteObjectTaggingOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public DeleteObjectTaggingOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectTaggingOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
