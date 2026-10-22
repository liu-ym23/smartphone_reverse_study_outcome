package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class FilterKey {

    @JsonProperty("FilterRules")
    private List<FilterRule> rules;

    public static final class FilterKeyBuilder {
        private List<FilterRule> rules;

        public FilterKey build() {
            FilterKey filterKey = new FilterKey();
            filterKey.setRules(this.rules);
            return filterKey;
        }

        public FilterKeyBuilder rules(List<FilterRule> list) {
            this.rules = list;
            return this;
        }

        private FilterKeyBuilder() {
        }
    }

    public static FilterKeyBuilder builder() {
        return new FilterKeyBuilder();
    }

    public List<FilterRule> getRules() {
        return this.rules;
    }

    public FilterKey setRules(List<FilterRule> list) {
        this.rules = list;
        return this;
    }

    public String toString() {
        return a.r(new StringBuilder("FilterKey{rules="), this.rules, '}');
    }
}
