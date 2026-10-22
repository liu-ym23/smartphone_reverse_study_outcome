package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

@Deprecated
/* loaded from: classes3.dex */
public class CompleteMultipartUploadOutput {
    private String crc64;
    private RequestInfo requestInfo;
    private String versionID;

    public String getCrc64() {
        return this.crc64;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public CompleteMultipartUploadOutput setCrc64(String str) {
        this.crc64 = str;
        return this;
    }

    public CompleteMultipartUploadOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public CompleteMultipartUploadOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', crc64=");
        return a.g('}', this.crc64, sb);
    }
}
