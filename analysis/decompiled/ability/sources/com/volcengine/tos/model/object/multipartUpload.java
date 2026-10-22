package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class multipartUpload {

    @JsonProperty("Bucket")
    private String bucket;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("UploadId")
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public multipartUpload setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public multipartUpload setKey(String str) {
        this.key = str;
        return this;
    }

    public multipartUpload setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("multipartUpload{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        return a.q(sb, this.uploadID, "'}");
    }
}
