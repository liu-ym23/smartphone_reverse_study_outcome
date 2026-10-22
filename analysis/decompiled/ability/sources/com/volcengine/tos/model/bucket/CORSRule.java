package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class CORSRule {

    @JsonProperty("AllowedHeaders")
    private List<String> allowedHeaders;

    @JsonProperty("AllowedMethods")
    private List<String> allowedMethods;

    @JsonProperty("AllowedOrigins")
    private List<String> allowedOrigins;

    @JsonProperty("ExposeHeaders")
    private List<String> exposeHeaders;

    @JsonProperty("MaxAgeSeconds")
    private int maxAgeSeconds;

    public static final class CORSRuleBuilder {
        private List<String> allowedHeaders;
        private List<String> allowedMethods;
        private List<String> allowedOrigins;
        private List<String> exposeHeaders;
        private int maxAgeSeconds;

        public CORSRuleBuilder allowedHeaders(List<String> list) {
            this.allowedHeaders = list;
            return this;
        }

        public CORSRuleBuilder allowedMethods(List<String> list) {
            this.allowedMethods = list;
            return this;
        }

        public CORSRuleBuilder allowedOrigins(List<String> list) {
            this.allowedOrigins = list;
            return this;
        }

        public CORSRule build() {
            CORSRule cORSRule = new CORSRule();
            cORSRule.setAllowedOrigins(this.allowedOrigins);
            cORSRule.setAllowedMethods(this.allowedMethods);
            cORSRule.setAllowedHeaders(this.allowedHeaders);
            cORSRule.setExposeHeaders(this.exposeHeaders);
            cORSRule.setMaxAgeSeconds(this.maxAgeSeconds);
            return cORSRule;
        }

        public CORSRuleBuilder exposeHeaders(List<String> list) {
            this.exposeHeaders = list;
            return this;
        }

        public CORSRuleBuilder maxAgeSeconds(int i) {
            this.maxAgeSeconds = i;
            return this;
        }

        private CORSRuleBuilder() {
        }
    }

    public static CORSRuleBuilder builder() {
        return new CORSRuleBuilder();
    }

    public List<String> getAllowedHeaders() {
        return this.allowedHeaders;
    }

    public List<String> getAllowedMethods() {
        return this.allowedMethods;
    }

    public List<String> getAllowedOrigins() {
        return this.allowedOrigins;
    }

    public List<String> getExposeHeaders() {
        return this.exposeHeaders;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public CORSRule setAllowedHeaders(List<String> list) {
        this.allowedHeaders = list;
        return this;
    }

    public CORSRule setAllowedMethods(List<String> list) {
        this.allowedMethods = list;
        return this;
    }

    public CORSRule setAllowedOrigins(List<String> list) {
        this.allowedOrigins = list;
        return this;
    }

    public CORSRule setExposeHeaders(List<String> list) {
        this.exposeHeaders = list;
        return this;
    }

    public CORSRule setMaxAgeSeconds(int i) {
        this.maxAgeSeconds = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CORSRule{, allowedOrigins=");
        sb.append(this.allowedOrigins);
        sb.append(", allowedMethods=");
        sb.append(this.allowedMethods);
        sb.append(", allowedHeaders=");
        sb.append(this.allowedHeaders);
        sb.append(", exposeHeaders=");
        sb.append(this.exposeHeaders);
        sb.append(", maxAgeSeconds=");
        return a.o(sb, this.maxAgeSeconds, '}');
    }
}
