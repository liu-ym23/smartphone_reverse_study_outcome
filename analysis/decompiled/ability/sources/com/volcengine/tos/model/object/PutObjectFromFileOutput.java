package com.volcengine.tos.model.object;

import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class PutObjectFromFileOutput {
    private PutObjectOutput putObjectOutput;

    public PutObjectFromFileOutput() {
        this.putObjectOutput = new PutObjectOutput();
    }

    public String getEtag() {
        return this.putObjectOutput.getEtag();
    }

    public String getHashCrc64ecma() {
        return this.putObjectOutput.getHashCrc64ecma();
    }

    @Deprecated
    public PutObjectOutput getPutObjectOutput() {
        return this.putObjectOutput;
    }

    public RequestInfo getRequestInfo() {
        return this.putObjectOutput.getRequestInfo();
    }

    public String getSseCustomerAlgorithm() {
        return this.putObjectOutput.getSseCustomerAlgorithm();
    }

    public String getSseCustomerKey() {
        return this.putObjectOutput.getSseCustomerKey();
    }

    public String getSseCustomerKeyMD5() {
        return this.putObjectOutput.getSseCustomerKeyMD5();
    }

    public String getVersionID() {
        return this.putObjectOutput.getVersionID();
    }

    public PutObjectFromFileOutput setEtag(String str) {
        this.putObjectOutput.setEtag(str);
        return this;
    }

    public PutObjectFromFileOutput setHashCrc64ecma(String str) {
        this.putObjectOutput.setHashCrc64ecma(str);
        return this;
    }

    @Deprecated
    public PutObjectFromFileOutput setPutObjectOutput(PutObjectOutput putObjectOutput) {
        this.putObjectOutput = putObjectOutput;
        return this;
    }

    public PutObjectFromFileOutput setRequestInfo(RequestInfo requestInfo) {
        this.putObjectOutput.setRequestInfo(requestInfo);
        return this;
    }

    public PutObjectFromFileOutput setSseCustomerAlgorithm(String str) {
        this.putObjectOutput.setSseCustomerAlgorithm(str);
        return this;
    }

    public PutObjectFromFileOutput setSseCustomerKey(String str) {
        this.putObjectOutput.setSseCustomerKey(str);
        return this;
    }

    public PutObjectFromFileOutput setSseCustomerKeyMD5(String str) {
        this.putObjectOutput.setSseCustomerKeyMD5(str);
        return this;
    }

    public PutObjectFromFileOutput setVersionID(String str) {
        this.putObjectOutput.setVersionID(str);
        return this;
    }

    public String toString() {
        return "PutObjectFromFileOutput{requestInfo=" + getRequestInfo() + ", etag='" + getEtag() + "', versionID='" + getVersionID() + "', hashCrc64ecma=" + getHashCrc64ecma() + ", sseCustomerAlgorithm='" + getSseCustomerAlgorithm() + "', sseCustomerKeyMD5='" + getSseCustomerKeyMD5() + "', sseCustomerKey='" + getSseCustomerKey() + "'}";
    }

    @Deprecated
    public PutObjectFromFileOutput(PutObjectOutput putObjectOutput) {
        new PutObjectOutput();
        this.putObjectOutput = putObjectOutput;
    }
}
