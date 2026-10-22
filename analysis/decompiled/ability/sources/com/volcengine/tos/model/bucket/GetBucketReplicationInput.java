package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketReplicationInput {
    private String bucket;
    private String ruleID;

    public static final class GetBucketReplicationInputBuilder {
        private String bucket;
        private String ruleID;

        public GetBucketReplicationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketReplicationInput build() {
            GetBucketReplicationInput getBucketReplicationInput = new GetBucketReplicationInput();
            getBucketReplicationInput.setBucket(this.bucket);
            getBucketReplicationInput.setRuleID(this.ruleID);
            return getBucketReplicationInput;
        }

        public GetBucketReplicationInputBuilder ruleID(String str) {
            this.ruleID = str;
            return this;
        }

        private GetBucketReplicationInputBuilder() {
        }
    }

    public static GetBucketReplicationInputBuilder builder() {
        return new GetBucketReplicationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getRuleID() {
        return this.ruleID;
    }

    public GetBucketReplicationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public GetBucketReplicationInput setRuleID(String str) {
        this.ruleID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketReplicationInput{bucket='");
        sb.append(this.bucket);
        sb.append("', ruleID='");
        return a.q(sb, this.ruleID, "'}");
    }
}
