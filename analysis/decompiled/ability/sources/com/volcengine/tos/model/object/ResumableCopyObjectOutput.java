package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class ResumableCopyObjectOutput {
    private String bucket;
    private String encodingType;
    private String etag;
    private String hashCrc64ecma;
    private String key;
    private String location;
    private RequestInfo requestInfo;
    private String ssecAlgorithm;
    private String ssecKeyMD5;
    private String uploadID;
    private String versionID;

    public String getBucket() {
        return this.bucket;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getKey() {
        return this.key;
    }

    public String getLocation() {
        return this.location;
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

    public String getUploadID() {
        return this.uploadID;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public ResumableCopyObjectOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ResumableCopyObjectOutput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ResumableCopyObjectOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ResumableCopyObjectOutput setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public ResumableCopyObjectOutput setKey(String str) {
        this.key = str;
        return this;
    }

    public ResumableCopyObjectOutput setLocation(String str) {
        this.location = str;
        return this;
    }

    public ResumableCopyObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ResumableCopyObjectOutput setSsecAlgorithm(String str) {
        this.ssecAlgorithm = str;
        return this;
    }

    public ResumableCopyObjectOutput setSsecKeyMD5(String str) {
        this.ssecKeyMD5 = str;
        return this;
    }

    public ResumableCopyObjectOutput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public ResumableCopyObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResumableCopyObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', location='");
        sb.append(this.location);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', hashCrc64ecma='");
        sb.append(this.hashCrc64ecma);
        sb.append("', ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
