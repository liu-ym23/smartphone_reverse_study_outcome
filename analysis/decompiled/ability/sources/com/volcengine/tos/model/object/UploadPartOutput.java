package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volcengine.tos.model.RequestInfo;
import java.io.Serializable;

@Deprecated
/* loaded from: classes3.dex */
public class UploadPartOutput implements MultipartUploadedPart, Serializable {
    private String etag;
    private int partNumber;

    @JsonIgnore
    private RequestInfo requestInfo;
    private String sseCustomerAlgorithm;
    private String sseCustomerMD5;

    public String getEtag() {
        return this.etag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public String getSseCustomerMD5() {
        return this.sseCustomerMD5;
    }

    public UploadPartOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadPartOutput setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public UploadPartOutput setSseCustomerAlgorithm(String str) {
        this.sseCustomerAlgorithm = str;
        return this;
    }

    public UploadPartOutput setSseCustomerMD5(String str) {
        this.sseCustomerMD5 = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", partNumber=");
        sb.append(this.partNumber);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', sseCustomerAlgorithm='");
        sb.append(this.sseCustomerAlgorithm);
        sb.append("', sseCustomerMD5='");
        return a.q(sb, this.sseCustomerMD5, "'}");
    }

    @Override // com.volcengine.tos.model.object.MultipartUploadedPart
    public InnerUploadedPart uploadedPart() {
        return new InnerUploadedPart(this.partNumber, this.etag);
    }
}
