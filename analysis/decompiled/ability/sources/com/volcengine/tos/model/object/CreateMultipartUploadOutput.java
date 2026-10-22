package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class CreateMultipartUploadOutput {
    private String bucket;
    private String encodingType;
    private String key;
    private RequestInfo requestInfo;
    private String sseCustomerAlgorithm;
    private String sseCustomerKey;
    private String sseCustomerMD5;
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKey() {
        return this.key;
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

    public String getSseCustomerMD5() {
        return this.sseCustomerMD5;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public CreateMultipartUploadOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CreateMultipartUploadOutput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public CreateMultipartUploadOutput setKey(String str) {
        this.key = str;
        return this;
    }

    public CreateMultipartUploadOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public CreateMultipartUploadOutput setSseCustomerAlgorithm(String str) {
        this.sseCustomerAlgorithm = str;
        return this;
    }

    public CreateMultipartUploadOutput setSseCustomerKey(String str) {
        this.sseCustomerKey = str;
        return this;
    }

    public CreateMultipartUploadOutput setSseCustomerMD5(String str) {
        this.sseCustomerMD5 = str;
        return this;
    }

    public CreateMultipartUploadOutput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateMultipartUploadOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', sseCustomerAlgorithm='");
        sb.append(this.sseCustomerAlgorithm);
        sb.append("', sseCustomerMD5='");
        sb.append(this.sseCustomerMD5);
        sb.append("', sseCustomerKey='");
        sb.append(this.sseCustomerKey);
        sb.append("', encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
