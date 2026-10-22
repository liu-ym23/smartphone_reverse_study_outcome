package com.volcengine.tos.model.object;

import B7.a;
import Y6.d;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = d.class)
/* loaded from: classes3.dex */
public class PostSignatureCondition {
    private String key;
    private String operator;
    private String value;

    public static final class PostSignatureConditionBuilder {
        private String key;
        private String operator;
        private String value;

        public PostSignatureCondition build() {
            PostSignatureCondition postSignatureCondition = new PostSignatureCondition();
            postSignatureCondition.setKey(this.key);
            postSignatureCondition.setValue(this.value);
            postSignatureCondition.setOperator(this.operator);
            return postSignatureCondition;
        }

        public PostSignatureConditionBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PostSignatureConditionBuilder operator(String str) {
            this.operator = str;
            return this;
        }

        public PostSignatureConditionBuilder value(String str) {
            this.value = str;
            return this;
        }

        private PostSignatureConditionBuilder() {
        }
    }

    public PostSignatureCondition() {
    }

    public static PostSignatureConditionBuilder builder() {
        return new PostSignatureConditionBuilder();
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

    public PostSignatureCondition setKey(String str) {
        this.key = str;
        return this;
    }

    public PostSignatureCondition setOperator(String str) {
        this.operator = str;
        return this;
    }

    public PostSignatureCondition setValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PostSignatureCondition{key='");
        sb.append(this.key);
        sb.append("', value='");
        sb.append(this.value);
        sb.append("', operator='");
        return a.q(sb, this.operator, "'}");
    }

    public PostSignatureCondition(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public PostSignatureCondition(String str, String str2, String str3) {
        this.key = str;
        this.value = str2;
        this.operator = str3;
    }
}
