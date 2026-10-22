package com.volcengine.tos.model.object;

import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class UploadPartFromFileOutput {
    private UploadPartV2Output uploadPartV2Output;

    public UploadPartFromFileOutput() {
        this.uploadPartV2Output = new UploadPartV2Output();
    }

    public String getEtag() {
        return this.uploadPartV2Output.getEtag();
    }

    public String getHashCrc64ecma() {
        return this.uploadPartV2Output.getHashCrc64ecma();
    }

    public int getPartNumber() {
        return this.uploadPartV2Output.getPartNumber();
    }

    public RequestInfo getRequestInfo() {
        return this.uploadPartV2Output.getRequestInfo();
    }

    public String getSsecAlgorithm() {
        return this.uploadPartV2Output.getSsecAlgorithm();
    }

    public String getSsecKeyMD5() {
        return this.uploadPartV2Output.getSsecKeyMD5();
    }

    @Deprecated
    public UploadPartV2Output getUploadPartV2Output() {
        return this.uploadPartV2Output;
    }

    public UploadPartFromFileOutput setEtag(String str) {
        this.uploadPartV2Output.setEtag(str);
        return this;
    }

    public UploadPartFromFileOutput setHashCrc64ecma(String str) {
        this.uploadPartV2Output.setHashCrc64ecma(str);
        return this;
    }

    public UploadPartFromFileOutput setPartNumber(int i) {
        this.uploadPartV2Output.setPartNumber(i);
        return this;
    }

    public UploadPartFromFileOutput setRequestInfo(RequestInfo requestInfo) {
        this.uploadPartV2Output.setRequestInfo(requestInfo);
        return this;
    }

    public UploadPartFromFileOutput setSsecAlgorithm(String str) {
        this.uploadPartV2Output.setSsecAlgorithm(str);
        return this;
    }

    public UploadPartFromFileOutput setSsecKeyMD5(String str) {
        this.uploadPartV2Output.setSsecKeyMD5(str);
        return this;
    }

    public String toString() {
        return "UploadPartFromFileOutput{requestInfo=" + getRequestInfo() + ", partNumber=" + getPartNumber() + ", etag='" + getEtag() + "', ssecAlgorithm='" + getSsecAlgorithm() + "', ssecKeyMD5='" + getSsecKeyMD5() + "', hashCrc64ecma=" + getHashCrc64ecma() + '}';
    }

    @Deprecated
    public UploadPartFromFileOutput(UploadPartV2Output uploadPartV2Output) {
        new UploadPartV2Output();
        this.uploadPartV2Output = uploadPartV2Output;
    }
}
