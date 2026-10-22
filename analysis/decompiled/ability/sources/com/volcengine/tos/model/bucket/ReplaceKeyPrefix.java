package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class ReplaceKeyPrefix {

    @JsonProperty("KeyPrefix")
    private String keyPrefix;

    @JsonProperty("ReplaceWith")
    private String replaceWith;

    public static final class ReplaceKeyPrefixBuilder {
        private String keyPrefix;
        private String replaceWith;

        public ReplaceKeyPrefix build() {
            ReplaceKeyPrefix replaceKeyPrefix = new ReplaceKeyPrefix();
            replaceKeyPrefix.setKeyPrefix(this.keyPrefix);
            replaceKeyPrefix.setReplaceWith(this.replaceWith);
            return replaceKeyPrefix;
        }

        public ReplaceKeyPrefixBuilder keyPrefix(String str) {
            this.keyPrefix = str;
            return this;
        }

        public ReplaceKeyPrefixBuilder replaceWith(String str) {
            this.replaceWith = str;
            return this;
        }

        private ReplaceKeyPrefixBuilder() {
        }
    }

    public static ReplaceKeyPrefixBuilder builder() {
        return new ReplaceKeyPrefixBuilder();
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public String getReplaceWith() {
        return this.replaceWith;
    }

    public ReplaceKeyPrefix setKeyPrefix(String str) {
        this.keyPrefix = str;
        return this;
    }

    public ReplaceKeyPrefix setReplaceWith(String str) {
        this.replaceWith = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReplaceKeyPrefix{keyPrefix='");
        sb.append(this.keyPrefix);
        sb.append("', replaceWith='");
        return a.q(sb, this.replaceWith, "'}");
    }
}
