package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public class PreSignedURLInput {
    private String alternativeEndpoint;
    private String bucket;
    private long expires;
    private Map<String, String> header;
    private String httpMethod;
    private Boolean isCustomDomain;
    private String key;
    private Map<String, String> query;

    public static final class PreSignedURLInputBuilder {
        private String alternativeEndpoint;
        private String bucket;
        private long expires;
        private Map<String, String> header;
        private String httpMethod;
        private boolean isCustomDomain;
        private String key;
        private Map<String, String> query;

        public PreSignedURLInputBuilder alternativeEndpoint(String str) {
            this.alternativeEndpoint = str;
            return this;
        }

        public PreSignedURLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PreSignedURLInput build() {
            PreSignedURLInput preSignedURLInput = new PreSignedURLInput();
            preSignedURLInput.expires = this.expires;
            preSignedURLInput.query = this.query;
            preSignedURLInput.alternativeEndpoint = this.alternativeEndpoint;
            preSignedURLInput.bucket = this.bucket;
            preSignedURLInput.header = this.header;
            preSignedURLInput.httpMethod = this.httpMethod;
            preSignedURLInput.key = this.key;
            preSignedURLInput.isCustomDomain = Boolean.valueOf(this.isCustomDomain);
            return preSignedURLInput;
        }

        public PreSignedURLInputBuilder expires(long j5) {
            this.expires = j5;
            return this;
        }

        public PreSignedURLInputBuilder header(Map<String, String> map) {
            this.header = map;
            return this;
        }

        public PreSignedURLInputBuilder httpMethod(String str) {
            this.httpMethod = str;
            return this;
        }

        public PreSignedURLInputBuilder isCustomDomain(boolean z10) {
            this.isCustomDomain = z10;
            return this;
        }

        public PreSignedURLInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PreSignedURLInputBuilder query(Map<String, String> map) {
            this.query = map;
            return this;
        }

        private PreSignedURLInputBuilder() {
        }
    }

    public static PreSignedURLInputBuilder builder() {
        return new PreSignedURLInputBuilder();
    }

    public String getAlternativeEndpoint() {
        return this.alternativeEndpoint;
    }

    public String getBucket() {
        return this.bucket;
    }

    public long getExpires() {
        return this.expires;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getKey() {
        return this.key;
    }

    public Map<String, String> getQuery() {
        return this.query;
    }

    public Boolean isCustomDomain() {
        return this.isCustomDomain;
    }

    public PreSignedURLInput setAlternativeEndpoint(String str) {
        this.alternativeEndpoint = str;
        return this;
    }

    public PreSignedURLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PreSignedURLInput setCustomDomain(Boolean bool) {
        this.isCustomDomain = bool;
        return this;
    }

    public PreSignedURLInput setExpires(long j5) {
        this.expires = j5;
        return this;
    }

    public PreSignedURLInput setHeader(Map<String, String> map) {
        this.header = map;
        return this;
    }

    public PreSignedURLInput setHttpMethod(String str) {
        this.httpMethod = str;
        return this;
    }

    public PreSignedURLInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PreSignedURLInput setQuery(Map<String, String> map) {
        this.query = map;
        return this;
    }

    public String toString() {
        return "PreSignedURLInput{httpMethod='" + this.httpMethod + "', bucket='" + this.bucket + "', key='" + this.key + "', expires=" + this.expires + ", header=" + this.header + ", query=" + this.query + ", alternativeEndpoint='" + this.alternativeEndpoint + "', isCustomDomain=" + this.isCustomDomain + '}';
    }
}
