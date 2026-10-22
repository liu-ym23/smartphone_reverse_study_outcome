package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class UploadFileOutput {
    private String bucket;
    private CompleteMultipartUploadOutput completeMultipartUploadOutput;
    private String objectKey;
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public CompleteMultipartUploadOutput getCompleteMultipartUploadOutput() {
        return this.completeMultipartUploadOutput;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadFileOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadFileOutput setCompleteMultipartUploadOutput(CompleteMultipartUploadOutput completeMultipartUploadOutput) {
        this.completeMultipartUploadOutput = completeMultipartUploadOutput;
        return this;
    }

    public UploadFileOutput setObjectKey(String str) {
        this.objectKey = str;
        return this;
    }

    public UploadFileOutput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileOutput{completeMultipartUploadOutput=");
        sb.append(this.completeMultipartUploadOutput);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', objectKey='");
        sb.append(this.objectKey);
        sb.append("', uploadID='");
        return a.q(sb, this.uploadID, "'}");
    }
}
