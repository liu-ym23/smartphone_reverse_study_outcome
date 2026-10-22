package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class PutBucketPolicyInput {
    private String bucket;
    private String policy;

    public static final class PutBucketPolicyInputBuilder {
        private String bucket;
        private String policy;

        public PutBucketPolicyInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketPolicyInput build() {
            PutBucketPolicyInput putBucketPolicyInput = new PutBucketPolicyInput();
            putBucketPolicyInput.bucket = this.bucket;
            putBucketPolicyInput.policy = this.policy;
            return putBucketPolicyInput;
        }

        public PutBucketPolicyInputBuilder policy(String str) {
            this.policy = str;
            return this;
        }

        private PutBucketPolicyInputBuilder() {
        }
    }

    public static PutBucketPolicyInputBuilder builder() {
        return new PutBucketPolicyInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getPolicy() {
        return this.policy;
    }

    public PutBucketPolicyInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketPolicyInput setPolicy(String str) {
        this.policy = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketPolicyInput{bucket='");
        sb.append(this.bucket);
        sb.append("', policy='");
        return a.q(sb, this.policy, "'}");
    }
}
