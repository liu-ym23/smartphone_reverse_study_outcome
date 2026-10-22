package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketMirrorBackInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Rules")
    private List<MirrorBackRule> rules;

    public static final class PutBucketMirrorBackInputBuilder {
        private String bucket;
        private List<MirrorBackRule> rules;

        public PutBucketMirrorBackInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketMirrorBackInput build() {
            PutBucketMirrorBackInput putBucketMirrorBackInput = new PutBucketMirrorBackInput();
            putBucketMirrorBackInput.setBucket(this.bucket);
            putBucketMirrorBackInput.setRules(this.rules);
            return putBucketMirrorBackInput;
        }

        public PutBucketMirrorBackInputBuilder rules(List<MirrorBackRule> list) {
            this.rules = list;
            return this;
        }

        private PutBucketMirrorBackInputBuilder() {
        }
    }

    public static PutBucketMirrorBackInputBuilder builder() {
        return new PutBucketMirrorBackInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<MirrorBackRule> getRules() {
        return this.rules;
    }

    public PutBucketMirrorBackInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketMirrorBackInput setRules(List<MirrorBackRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketMirrorBackInput{bucket='");
        sb.append(this.bucket);
        sb.append("', rules=");
        return a.r(sb, this.rules, '}');
    }
}
