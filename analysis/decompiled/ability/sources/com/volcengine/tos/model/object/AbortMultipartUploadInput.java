package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class AbortMultipartUploadInput {
    private String bucket;
    private String key;
    private String uploadID;

    public static final class AbortMultipartUploadInputBuilder {
        private String bucket;
        private String key;
        private String uploadID;

        public AbortMultipartUploadInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public AbortMultipartUploadInput build() {
            AbortMultipartUploadInput abortMultipartUploadInput = new AbortMultipartUploadInput();
            abortMultipartUploadInput.setBucket(this.bucket);
            abortMultipartUploadInput.setKey(this.key);
            abortMultipartUploadInput.setUploadID(this.uploadID);
            return abortMultipartUploadInput;
        }

        public AbortMultipartUploadInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public AbortMultipartUploadInputBuilder uploadID(String str) {
            this.uploadID = str;
            return this;
        }

        private AbortMultipartUploadInputBuilder() {
        }
    }

    public AbortMultipartUploadInput() {
    }

    public static AbortMultipartUploadInputBuilder builder() {
        return new AbortMultipartUploadInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public AbortMultipartUploadInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public AbortMultipartUploadInput setKey(String str) {
        this.key = str;
        return this;
    }

    public AbortMultipartUploadInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AbortMultipartUploadInput{key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        return a.q(sb, this.uploadID, "'}");
    }

    public AbortMultipartUploadInput(String str, String str2) {
        this.key = str;
        this.uploadID = str2;
    }
}
