package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;

/* loaded from: classes3.dex */
public class UploadPartCopyV2Output {
    private String copySourceVersionID;
    private String etag;
    private Date lastModified;
    private int partNumber;
    private RequestInfo requestInfo;

    public UploadPartCopyV2Output copySourceVersionID(String str) {
        this.copySourceVersionID = str;
        return this;
    }

    public UploadPartCopyV2Output etag(String str) {
        this.etag = str;
        return this;
    }

    public String getCopySourceVersionID() {
        return this.copySourceVersionID;
    }

    public String getEtag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public UploadPartCopyV2Output lastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public UploadPartCopyV2Output partNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartCopyV2Output requestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartCopyV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", partNumber=");
        sb.append(this.partNumber);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", copySourceVersionID='");
        return a.q(sb, this.copySourceVersionID, "'}");
    }
}
