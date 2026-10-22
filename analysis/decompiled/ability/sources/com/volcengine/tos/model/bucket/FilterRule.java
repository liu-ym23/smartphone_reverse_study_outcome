package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class FilterRule {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private String value;

    public static final class FilterRuleBuilder {
        private String name;
        private String value;

        public FilterRule build() {
            FilterRule filterRule = new FilterRule();
            filterRule.setName(this.name);
            filterRule.setValue(this.value);
            return filterRule;
        }

        public FilterRuleBuilder name(String str) {
            this.name = str;
            return this;
        }

        public FilterRuleBuilder value(String str) {
            this.value = str;
            return this;
        }

        private FilterRuleBuilder() {
        }
    }

    public static FilterRuleBuilder builder() {
        return new FilterRuleBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public FilterRule setName(String str) {
        this.name = str;
        return this;
    }

    public FilterRule setValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FilterRule{name='");
        sb.append(this.name);
        sb.append("', value='");
        return a.q(sb, this.value, "'}");
    }
}
