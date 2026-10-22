package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

@Deprecated
/* loaded from: classes3.dex */
public class UploadPartCopyOutput implements MultipartUploadedPart {
    private String crc64;

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty("LastModified")
    private String lastModified;

    @JsonProperty("PartNumber")
    private int partNumber;

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

    public String getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
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

    public UploadPartCopyOutput setCrc64(String str) {
        this.crc64 = str;
        return this;
    }

    public UploadPartCopyOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadPartCopyOutput setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public UploadPartCopyOutput setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartCopyOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public UploadPartCopyOutput setSourceVersionID(String str) {
        this.sourceVersionID = str;
        return this;
    }

    public UploadPartCopyOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartCopyOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', sourceVersionID='");
        sb.append(this.sourceVersionID);
        sb.append("', partNumber=");
        sb.append(this.partNumber);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', crc64=");
        return a.g('}', this.crc64, sb);
    }

    @Override // com.volcengine.tos.model.object.MultipartUploadedPart
    public InnerUploadedPart uploadedPart() {
        return new InnerUploadedPart(this.partNumber, this.etag);
    }
}
