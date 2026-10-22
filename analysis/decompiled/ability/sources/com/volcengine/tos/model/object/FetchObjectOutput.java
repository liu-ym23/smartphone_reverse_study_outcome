package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class FetchObjectOutput {

    @JsonProperty("ETag")
    private String etag;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonIgnore
    private String ssecAlgorithm;

    @JsonIgnore
    private String ssecKeyMD5;

    @JsonIgnore
    private String versionID;

    public String getEtag() {
        return this.etag;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSsecAlgorithm() {
        return this.ssecAlgorithm;
    }

    public String getSsecKeyMD5() {
        return this.ssecKeyMD5;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public FetchObjectOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public FetchObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public FetchObjectOutput setSsecAlgorithm(String str) {
        this.ssecAlgorithm = str;
        return this;
    }

    public FetchObjectOutput setSsecKeyMD5(String str) {
        this.ssecKeyMD5 = str;
        return this;
    }

    public FetchObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FetchObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        return a.q(sb, this.ssecKeyMD5, "'}");
    }
}
