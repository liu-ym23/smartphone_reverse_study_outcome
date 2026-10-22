package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class DeleteObjectOutput {
    private boolean deleteMarker;
    private RequestInfo requestInfo;
    private String versionID;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isDeleteMarker() {
        return this.deleteMarker;
    }

    public DeleteObjectOutput setDeleteMarker(boolean z10) {
        this.deleteMarker = z10;
        return this;
    }

    public DeleteObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public DeleteObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", deleteMarker=");
        sb.append(this.deleteMarker);
        sb.append(", versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
