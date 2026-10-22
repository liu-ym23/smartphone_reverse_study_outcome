package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketCORSInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("CORSRules")
    private List<CORSRule> rules;

    public static final class PutBucketCORSBuilder {
        private String bucket;
        private List<CORSRule> rules;

        public PutBucketCORSBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketCORSInput build() {
            PutBucketCORSInput putBucketCORSInput = new PutBucketCORSInput();
            putBucketCORSInput.setBucket(this.bucket);
            putBucketCORSInput.setRules(this.rules);
            return putBucketCORSInput;
        }

        public PutBucketCORSBuilder rules(List<CORSRule> list) {
            this.rules = list;
            return this;
        }

        private PutBucketCORSBuilder() {
        }
    }

    public static PutBucketCORSBuilder builder() {
        return new PutBucketCORSBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<CORSRule> getRules() {
        return this.rules;
    }

    public PutBucketCORSInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketCORSInput setRules(List<CORSRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketCORS{bucket='");
        sb.append(this.bucket);
        sb.append("', rules=");
        return a.r(sb, this.rules, '}');
    }
}
