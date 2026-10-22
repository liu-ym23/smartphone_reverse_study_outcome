package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketPolicyInput {
    private String bucket;

    public static final class GetBucketPolicyInputBuilder {
        private String bucket;

        public GetBucketPolicyInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketPolicyInput build() {
            GetBucketPolicyInput getBucketPolicyInput = new GetBucketPolicyInput();
            getBucketPolicyInput.bucket = this.bucket;
            return getBucketPolicyInput;
        }

        private GetBucketPolicyInputBuilder() {
        }
    }

    public static GetBucketPolicyInputBuilder builder() {
        return new GetBucketPolicyInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketPolicyInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketPolicyInput{bucket='"), this.bucket, "'}");
    }
}
