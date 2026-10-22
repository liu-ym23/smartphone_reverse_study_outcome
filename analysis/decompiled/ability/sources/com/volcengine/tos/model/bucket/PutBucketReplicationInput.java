package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketReplicationInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Role")
    private String role;

    @JsonProperty("Rules")
    private List<ReplicationRule> rules;

    public static final class PutBucketReplicationInputBuilder {
        private String bucket;
        private String role;
        private List<ReplicationRule> rules;

        public PutBucketReplicationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketReplicationInput build() {
            PutBucketReplicationInput putBucketReplicationInput = new PutBucketReplicationInput();
            putBucketReplicationInput.setBucket(this.bucket);
            putBucketReplicationInput.setRole(this.role);
            putBucketReplicationInput.setRules(this.rules);
            return putBucketReplicationInput;
        }

        public PutBucketReplicationInputBuilder role(String str) {
            this.role = str;
            return this;
        }

        public PutBucketReplicationInputBuilder rules(List<ReplicationRule> list) {
            this.rules = list;
            return this;
        }

        private PutBucketReplicationInputBuilder() {
        }
    }

    public static PutBucketReplicationInputBuilder builder() {
        return new PutBucketReplicationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getRole() {
        return this.role;
    }

    public List<ReplicationRule> getRules() {
        return this.rules;
    }

    public PutBucketReplicationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketReplicationInput setRole(String str) {
        this.role = str;
        return this;
    }

    public PutBucketReplicationInput setRules(List<ReplicationRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketReplicationInput{bucket='");
        sb.append(this.bucket);
        sb.append("', role='");
        sb.append(this.role);
        sb.append("', rules=");
        return a.r(sb, this.rules, '}');
    }
}
