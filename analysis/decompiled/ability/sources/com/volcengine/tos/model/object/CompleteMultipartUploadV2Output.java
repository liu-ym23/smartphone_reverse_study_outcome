package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class CompleteMultipartUploadV2Output {

    @JsonProperty("Bucket")
    private String bucket;
    private String callbackResult;

    @JsonProperty("ETag")
    private String etag;
    private String hashCrc64ecma;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Location")
    private String location;
    private RequestInfo requestInfo;

    @JsonProperty("CompletedParts")
    private List<UploadedPartV2> uploadedPartV2List;
    private String versionID;

    public String getBucket() {
        return this.bucket;
    }

    public String getCallbackResult() {
        return this.callbackResult;
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

    public List<UploadedPartV2> getUploadedPartV2List() {
        return this.uploadedPartV2List;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public CompleteMultipartUploadV2Output setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setCallbackResult(String str) {
        this.callbackResult = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setKey(String str) {
        this.key = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setLocation(String str) {
        this.location = str;
        return this;
    }

    public CompleteMultipartUploadV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public CompleteMultipartUploadV2Output setUploadedPartV2List(List<UploadedPartV2> list) {
        this.uploadedPartV2List = list;
        return this;
    }

    public CompleteMultipartUploadV2Output setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', location='");
        sb.append(this.location);
        sb.append("', uploadedPartV2List=");
        sb.append(this.uploadedPartV2List);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', hashCrc64ecma='");
        sb.append(this.hashCrc64ecma);
        sb.append("', callbackResult='");
        return a.q(sb, this.callbackResult, "'}");
    }
}
