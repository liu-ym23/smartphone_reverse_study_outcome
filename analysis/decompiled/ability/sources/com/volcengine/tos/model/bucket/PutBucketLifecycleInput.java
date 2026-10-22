package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketLifecycleInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Rules")
    private List<LifecycleRule> rules;

    public static final class PutBucketLifecycleInputBuilder {
        private String bucket;
        private List<LifecycleRule> rules;

        public PutBucketLifecycleInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketLifecycleInput build() {
            PutBucketLifecycleInput putBucketLifecycleInput = new PutBucketLifecycleInput();
            putBucketLifecycleInput.setBucket(this.bucket);
            putBucketLifecycleInput.setRules(this.rules);
            return putBucketLifecycleInput;
        }

        public PutBucketLifecycleInputBuilder rules(List<LifecycleRule> list) {
            this.rules = list;
            return this;
        }

        private PutBucketLifecycleInputBuilder() {
        }
    }

    public static PutBucketLifecycleInputBuilder builder() {
        return new PutBucketLifecycleInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<LifecycleRule> getRules() {
        return this.rules;
    }

    public PutBucketLifecycleInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketLifecycleInput setRules(List<LifecycleRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketLifecycleInput{bucket='");
        sb.append(this.bucket);
        sb.append("', rules=");
        return a.r(sb, this.rules, '}');
    }
}
