package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Condition {

    @JsonProperty("HttpCode")
    private int httpCode;

    @JsonProperty("KeyPrefix")
    private String keyPrefix;

    @JsonProperty("KeySuffix")
    private String keySuffix;

    public static final class ConditionBuilder {
        private int httpCode;
        private String keyPrefix;
        private String keySuffix;

        public Condition build() {
            Condition condition = new Condition();
            condition.setHttpCode(this.httpCode);
            condition.setKeyPrefix(this.keyPrefix);
            condition.setKeySuffix(this.keySuffix);
            return condition;
        }

        public ConditionBuilder httpCode(int i) {
            this.httpCode = i;
            return this;
        }

        public ConditionBuilder keyPrefix(String str) {
            this.keyPrefix = str;
            return this;
        }

        public ConditionBuilder keySuffix(String str) {
            this.keySuffix = str;
            return this;
        }

        private ConditionBuilder() {
        }
    }

    public static ConditionBuilder builder() {
        return new ConditionBuilder();
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public String getKeySuffix() {
        return this.keySuffix;
    }

    public Condition setHttpCode(int i) {
        this.httpCode = i;
        return this;
    }

    public Condition setKeyPrefix(String str) {
        this.keyPrefix = str;
        return this;
    }

    public Condition setKeySuffix(String str) {
        this.keySuffix = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Condition{httpCode=");
        sb.append(this.httpCode);
        sb.append(", keyPrefix='");
        sb.append(this.keyPrefix);
        sb.append("', keySuffix='");
        return a.q(sb, this.keySuffix, "'}");
    }
}
