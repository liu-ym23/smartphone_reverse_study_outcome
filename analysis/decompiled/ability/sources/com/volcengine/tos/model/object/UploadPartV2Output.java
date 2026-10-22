package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class UploadPartV2Output {
    private String etag;
    private String hashCrc64ecma;
    private int partNumber;
    private RequestInfo requestInfo;
    private String ssecAlgorithm;
    private String ssecKeyMD5;

    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public int getPartNumber() {
        return this.partNumber;
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

    public UploadPartV2Output setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadPartV2Output setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public UploadPartV2Output setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public UploadPartV2Output setSsecAlgorithm(String str) {
        this.ssecAlgorithm = str;
        return this;
    }

    public UploadPartV2Output setSsecKeyMD5(String str) {
        this.ssecKeyMD5 = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", partNumber=");
        sb.append(this.partNumber);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', hashCrc64ecma=");
        return a.g('}', this.hashCrc64ecma, sb);
    }
}
