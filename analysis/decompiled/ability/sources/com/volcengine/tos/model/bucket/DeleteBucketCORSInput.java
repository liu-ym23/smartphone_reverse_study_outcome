package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketCORSInput {
    private String bucket;

    public static final class DeleteBucketCORSInputBuilder {
        private String bucket;

        public DeleteBucketCORSInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketCORSInput build() {
            DeleteBucketCORSInput deleteBucketCORSInput = new DeleteBucketCORSInput();
            deleteBucketCORSInput.setBucket(this.bucket);
            return deleteBucketCORSInput;
        }

        private DeleteBucketCORSInputBuilder() {
        }
    }

    public static DeleteBucketCORSInputBuilder builder() {
        return new DeleteBucketCORSInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketCORSInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketCORSInput{bucket='"), this.bucket, "'}");
    }
}
