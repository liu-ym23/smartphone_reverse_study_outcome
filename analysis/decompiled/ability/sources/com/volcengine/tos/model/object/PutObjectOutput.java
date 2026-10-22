package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class PutObjectOutput {
    private String callbackResult;

    @Deprecated
    private String crc64;

    @JsonProperty("ETag")
    private String etag;
    private String hashCrc64ecma;

    @JsonIgnore
    private RequestInfo requestInfo;
    private String sseCustomerAlgorithm;
    private String sseCustomerKey;
    private String sseCustomerKeyMD5;

    @JsonProperty("VersionId")
    private String versionID;

    public String getCallbackResult() {
        return this.callbackResult;
    }

    @Deprecated
    public String getCrc64() {
        return this.hashCrc64ecma;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public String getSseCustomerKey() {
        return this.sseCustomerKey;
    }

    public String getSseCustomerKeyMD5() {
        return this.sseCustomerKeyMD5;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public PutObjectOutput setCallbackResult(String str) {
        this.callbackResult = str;
        return this;
    }

    @Deprecated
    public PutObjectOutput setCrc64(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public PutObjectOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public PutObjectOutput setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public PutObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public PutObjectOutput setSseCustomerAlgorithm(String str) {
        this.sseCustomerAlgorithm = str;
        return this;
    }

    public PutObjectOutput setSseCustomerKey(String str) {
        this.sseCustomerKey = str;
        return this;
    }

    public PutObjectOutput setSseCustomerKeyMD5(String str) {
        this.sseCustomerKeyMD5 = str;
        return this;
    }

    public PutObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', hashCrc64ecma=");
        sb.append(this.hashCrc64ecma);
        sb.append(", sseCustomerAlgorithm='");
        sb.append(this.sseCustomerAlgorithm);
        sb.append("', sseCustomerKeyMD5='");
        sb.append(this.sseCustomerKeyMD5);
        sb.append("', sseCustomerKey='");
        sb.append(this.sseCustomerKey);
        sb.append("', callbackResult='");
        return a.q(sb, this.callbackResult, "'}");
    }
}
