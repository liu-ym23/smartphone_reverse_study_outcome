package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;

@Deprecated
/* loaded from: classes3.dex */
public class CopyObjectOutput {
    private String crc64;

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty("LastModified")
    private Date lastModified;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("SourceVersionId")
    private String sourceVersionID;

    @JsonProperty("VersionId")
    private String versionID;

    public String getCrc64() {
        return this.crc64;
    }

    public String getEtag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSourceVersionID() {
        return this.sourceVersionID;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public CopyObjectOutput setCrc64(String str) {
        this.crc64 = str;
        return this;
    }

    public CopyObjectOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CopyObjectOutput setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public CopyObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public CopyObjectOutput setSourceVersionID(String str) {
        this.sourceVersionID = str;
        return this;
    }

    public CopyObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CopyObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', sourceVersionID='");
        sb.append(this.sourceVersionID);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', crc64=");
        return a.g('}', this.crc64, sb);
    }
}
