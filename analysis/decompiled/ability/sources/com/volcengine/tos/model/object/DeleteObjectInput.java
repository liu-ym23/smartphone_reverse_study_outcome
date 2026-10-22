package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteObjectInput {
    private String bucket;
    private String key;
    private String versionID;

    public static final class Builder {
        private String bucket;
        private String key;
        private String versionID;

        public Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteObjectInput build() {
            DeleteObjectInput deleteObjectInput = new DeleteObjectInput();
            deleteObjectInput.bucket = this.bucket;
            deleteObjectInput.versionID = this.versionID;
            deleteObjectInput.key = this.key;
            return deleteObjectInput;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public DeleteObjectInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DeleteObjectInput setKey(String str) {
        this.key = str;
        return this;
    }

    public DeleteObjectInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
