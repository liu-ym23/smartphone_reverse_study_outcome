package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class RenameObjectInput {
    private String bucket;
    private String key;
    private String newKey;

    public static final class RenameObjectInputBuilder {
        private String bucket;
        private String key;
        private String newKey;

        public RenameObjectInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public RenameObjectInput build() {
            RenameObjectInput renameObjectInput = new RenameObjectInput();
            renameObjectInput.setBucket(this.bucket);
            renameObjectInput.setKey(this.key);
            renameObjectInput.setNewKey(this.newKey);
            return renameObjectInput;
        }

        public RenameObjectInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public RenameObjectInputBuilder newKey(String str) {
            this.newKey = str;
            return this;
        }

        private RenameObjectInputBuilder() {
        }
    }

    public static RenameObjectInputBuilder builder() {
        return new RenameObjectInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getNewKey() {
        return this.newKey;
    }

    public RenameObjectInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public RenameObjectInput setKey(String str) {
        this.key = str;
        return this;
    }

    public RenameObjectInput setNewKey(String str) {
        this.newKey = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RenameObjectInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', newKey='");
        return a.q(sb, this.newKey, "'}");
    }
}
