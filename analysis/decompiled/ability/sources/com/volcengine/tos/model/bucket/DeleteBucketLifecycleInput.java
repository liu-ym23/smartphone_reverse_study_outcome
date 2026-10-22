package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketLifecycleInput {
    private String bucket;

    public static final class DeleteBucketLifecycleInputBuilder {
        private String bucket;

        public DeleteBucketLifecycleInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketLifecycleInput build() {
            DeleteBucketLifecycleInput deleteBucketLifecycleInput = new DeleteBucketLifecycleInput();
            deleteBucketLifecycleInput.setBucket(this.bucket);
            return deleteBucketLifecycleInput;
        }

        private DeleteBucketLifecycleInputBuilder() {
        }
    }

    public static DeleteBucketLifecycleInputBuilder builder() {
        return new DeleteBucketLifecycleInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketLifecycleInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketLifecycleInput{bucket='"), this.bucket, "'}");
    }
}
