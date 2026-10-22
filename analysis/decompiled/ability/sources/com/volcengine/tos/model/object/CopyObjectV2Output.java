package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;

/* loaded from: classes3.dex */
public class CopyObjectV2Output {
    private String copySourceVersionID;

    @JsonProperty("ETag")
    private String etag;
    private String hashCrc64ecma;
    private Date lastModified;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("LastModified")
    private String versionID;

    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSourceVersionID() {
        return this.copySourceVersionID;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public CopyObjectV2Output setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CopyObjectV2Output setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public CopyObjectV2Output setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public CopyObjectV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public CopyObjectV2Output setSourceVersionID(String str) {
        this.copySourceVersionID = str;
        return this;
    }

    public CopyObjectV2Output setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CopyObjectV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', copySourceVersionID='");
        sb.append(this.copySourceVersionID);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", hashCrc64ecma='");
        return a.q(sb, this.hashCrc64ecma, "'}");
    }
}
