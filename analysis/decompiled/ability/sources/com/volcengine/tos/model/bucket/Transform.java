package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Transform {

    @JsonProperty("ReplaceKeyPrefix")
    private ReplaceKeyPrefix replaceKeyPrefix;

    @JsonProperty("WithKeyPrefix")
    private String withKeyPrefix;

    @JsonProperty("WithKeySuffix")
    private String withKeySuffix;

    public static final class TransformBuilder {
        private ReplaceKeyPrefix replaceKeyPrefix;
        private String withKeyPrefix;
        private String withKeySuffix;

        public Transform build() {
            Transform transform = new Transform();
            transform.setWithKeyPrefix(this.withKeyPrefix);
            transform.setWithKeySuffix(this.withKeySuffix);
            transform.setReplaceKeyPrefix(this.replaceKeyPrefix);
            return transform;
        }

        public TransformBuilder replaceKeyPrefix(ReplaceKeyPrefix replaceKeyPrefix) {
            this.replaceKeyPrefix = replaceKeyPrefix;
            return this;
        }

        public TransformBuilder withKeyPrefix(String str) {
            this.withKeyPrefix = str;
            return this;
        }

        public TransformBuilder withKeySuffix(String str) {
            this.withKeySuffix = str;
            return this;
        }

        private TransformBuilder() {
        }
    }

    public static TransformBuilder builder() {
        return new TransformBuilder();
    }

    public ReplaceKeyPrefix getReplaceKeyPrefix() {
        return this.replaceKeyPrefix;
    }

    public String getWithKeyPrefix() {
        return this.withKeyPrefix;
    }

    public String getWithKeySuffix() {
        return this.withKeySuffix;
    }

    public Transform setReplaceKeyPrefix(ReplaceKeyPrefix replaceKeyPrefix) {
        this.replaceKeyPrefix = replaceKeyPrefix;
        return this;
    }

    public Transform setWithKeyPrefix(String str) {
        this.withKeyPrefix = str;
        return this;
    }

    public Transform setWithKeySuffix(String str) {
        this.withKeySuffix = str;
        return this;
    }

    public String toString() {
        return "Transform{withKeyPrefix='" + this.withKeyPrefix + "', withKeySuffix='" + this.withKeySuffix + "', replaceKeyPrefix=" + this.replaceKeyPrefix + '}';
    }
}
