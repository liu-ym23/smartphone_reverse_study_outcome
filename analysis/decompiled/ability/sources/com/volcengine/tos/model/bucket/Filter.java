package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Filter {

    @JsonProperty("TOSKey")
    private FilterKey key;

    public static final class FilterBuilder {
        private FilterKey key;

        public Filter build() {
            Filter filter = new Filter();
            filter.setKey(this.key);
            return filter;
        }

        public FilterBuilder key(FilterKey filterKey) {
            this.key = filterKey;
            return this;
        }

        private FilterBuilder() {
        }
    }

    public static FilterBuilder builder() {
        return new FilterBuilder();
    }

    public FilterKey getKey() {
        return this.key;
    }

    public Filter setKey(FilterKey filterKey) {
        this.key = filterKey;
        return this;
    }

    public String toString() {
        return "Filter{key=" + this.key + '}';
    }
}
