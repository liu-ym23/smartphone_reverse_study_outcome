package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketPolicyInput {
    private String bucket;

    public static final class DeleteBucketPolicyInputBuilder {
        private String bucket;

        public DeleteBucketPolicyInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketPolicyInput build() {
            DeleteBucketPolicyInput deleteBucketPolicyInput = new DeleteBucketPolicyInput();
            deleteBucketPolicyInput.bucket = this.bucket;
            return deleteBucketPolicyInput;
        }

        private DeleteBucketPolicyInputBuilder() {
        }
    }

    public static DeleteBucketPolicyInputBuilder builder() {
        return new DeleteBucketPolicyInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketPolicyInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketPolicyInput{bucket='"), this.bucket, "'}");
    }
}
