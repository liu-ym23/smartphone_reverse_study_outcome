package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteObjectTaggingInput {
    private String bucket;
    private String key;
    private String versionID;

    public static final class DeleteObjectTaggingInputBuilder {
        private String bucket;
        private String key;
        private String versionID;

        public DeleteObjectTaggingInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteObjectTaggingInput build() {
            DeleteObjectTaggingInput deleteObjectTaggingInput = new DeleteObjectTaggingInput();
            deleteObjectTaggingInput.setBucket(this.bucket);
            deleteObjectTaggingInput.setKey(this.key);
            deleteObjectTaggingInput.setVersionID(this.versionID);
            return deleteObjectTaggingInput;
        }

        public DeleteObjectTaggingInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public DeleteObjectTaggingInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private DeleteObjectTaggingInputBuilder() {
        }
    }

    public static DeleteObjectTaggingInputBuilder builder() {
        return new DeleteObjectTaggingInputBuilder();
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

    public DeleteObjectTaggingInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DeleteObjectTaggingInput setKey(String str) {
        this.key = str;
        return this;
    }

    public DeleteObjectTaggingInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectTaggingInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
