package com.volcengine.tos.model.object;

import B7.a;
import Y6.d;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = d.class)
/* loaded from: classes3.dex */
public class PolicySignatureCondition {
    private String key;
    private String operator;
    private String value;

    public static final class PolicySignatureConditionBuilder {
        private String key;
        private String operator;
        private String value;

        public PolicySignatureCondition build() {
            PolicySignatureCondition policySignatureCondition = new PolicySignatureCondition();
            policySignatureCondition.setKey(this.key);
            policySignatureCondition.setValue(this.value);
            policySignatureCondition.setOperator(this.operator);
            return policySignatureCondition;
        }

        public PolicySignatureConditionBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PolicySignatureConditionBuilder operator(String str) {
            this.operator = str;
            return this;
        }

        public PolicySignatureConditionBuilder value(String str) {
            this.value = str;
            return this;
        }

        private PolicySignatureConditionBuilder() {
        }
    }

    public static PolicySignatureConditionBuilder builder() {
        return new PolicySignatureConditionBuilder();
    }

    public String getKey() {
        return this.key;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getValue() {
        return this.value;
    }

    public PolicySignatureCondition setKey(String str) {
        this.key = str;
        return this;
    }

    public PolicySignatureCondition setOperator(String str) {
        this.operator = str;
        return this;
    }

    public PolicySignatureCondition setValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicySignatureCondition{key='");
        sb.append(this.key);
        sb.append("', value='");
        sb.append(this.value);
        sb.append("', operator='");
        return a.q(sb, this.operator, "'}");
    }
}
