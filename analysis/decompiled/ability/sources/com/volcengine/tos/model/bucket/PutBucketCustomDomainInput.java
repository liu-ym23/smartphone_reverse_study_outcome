package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class PutBucketCustomDomainInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("CustomDomainRule")
    private CustomDomainRule rule;

    public static final class PutBucketCustomDomainInputBuilder {
        private String bucket;
        private CustomDomainRule rule;

        public PutBucketCustomDomainInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketCustomDomainInput build() {
            PutBucketCustomDomainInput putBucketCustomDomainInput = new PutBucketCustomDomainInput();
            putBucketCustomDomainInput.setBucket(this.bucket);
            putBucketCustomDomainInput.setRule(this.rule);
            return putBucketCustomDomainInput;
        }

        public PutBucketCustomDomainInputBuilder rule(CustomDomainRule customDomainRule) {
            this.rule = customDomainRule;
            return this;
        }

        private PutBucketCustomDomainInputBuilder() {
        }
    }

    public static PutBucketCustomDomainInputBuilder builder() {
        return new PutBucketCustomDomainInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public CustomDomainRule getRule() {
        return this.rule;
    }

    public PutBucketCustomDomainInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketCustomDomainInput setRule(CustomDomainRule customDomainRule) {
        this.rule = customDomainRule;
        return this;
    }

    public String toString() {
        return "PutBucketCustomDomainInput{bucket='" + this.bucket + "', rule=" + this.rule + '}';
    }
}
