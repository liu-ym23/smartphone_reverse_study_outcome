package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketRenameInput {
    private String bucket;

    public static final class DeleteBucketRenameInputBuilder {
        private String bucket;

        public DeleteBucketRenameInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketRenameInput build() {
            DeleteBucketRenameInput deleteBucketRenameInput = new DeleteBucketRenameInput();
            deleteBucketRenameInput.setBucket(this.bucket);
            return deleteBucketRenameInput;
        }

        private DeleteBucketRenameInputBuilder() {
        }
    }

    public static DeleteBucketRenameInputBuilder builder() {
        return new DeleteBucketRenameInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketRenameInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketRenameInput{bucket='"), this.bucket, "'}");
    }
}
