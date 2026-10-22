package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketInput {
    private String bucket;

    public static final class DeleteBucketInputBuilder {
        private String bucket;

        public DeleteBucketInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketInput build() {
            DeleteBucketInput deleteBucketInput = new DeleteBucketInput();
            deleteBucketInput.bucket = this.bucket;
            return deleteBucketInput;
        }

        private DeleteBucketInputBuilder() {
        }
    }

    public static DeleteBucketInputBuilder builder() {
        return new DeleteBucketInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketInput{bucket='"), this.bucket, "'}");
    }
}
