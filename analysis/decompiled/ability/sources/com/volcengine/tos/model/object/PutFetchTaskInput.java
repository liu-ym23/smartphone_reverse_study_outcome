package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/* loaded from: classes3.dex */
public class PutFetchTaskInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("ContentMD5")
    private String hexMD5;

    @JsonProperty("IgnoreSameKey")
    private boolean ignoreSameKey;

    @JsonProperty("Object")
    private String key;

    @JsonIgnore
    private ObjectMetaRequestOptions options;

    @JsonProperty("URL")
    private String url;

    public static final class PutFetchTaskInputBuilder {
        private String bucket;
        private String hexMD5;
        private boolean ignoreSameKey;
        private String key;
        private ObjectMetaRequestOptions options;
        private String url;

        public PutFetchTaskInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutFetchTaskInput build() {
            PutFetchTaskInput putFetchTaskInput = new PutFetchTaskInput();
            putFetchTaskInput.setBucket(this.bucket);
            putFetchTaskInput.setKey(this.key);
            putFetchTaskInput.setOptions(this.options);
            putFetchTaskInput.setUrl(this.url);
            putFetchTaskInput.setIgnoreSameKey(this.ignoreSameKey);
            putFetchTaskInput.setHexMD5(this.hexMD5);
            return putFetchTaskInput;
        }

        public PutFetchTaskInputBuilder hexMD5(String str) {
            this.hexMD5 = str;
            return this;
        }

        public PutFetchTaskInputBuilder ignoreSameKey(boolean z10) {
            this.ignoreSameKey = z10;
            return this;
        }

        public PutFetchTaskInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PutFetchTaskInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public PutFetchTaskInputBuilder url(String str) {
            this.url = str;
            return this;
        }

        private PutFetchTaskInputBuilder() {
        }
    }

    public static PutFetchTaskInputBuilder builder() {
        return new PutFetchTaskInputBuilder();
    }

    public Map<String, String> getAllSettedHeaders() {
        ObjectMetaRequestOptions objectMetaRequestOptions = this.options;
        if (objectMetaRequestOptions == null) {
            return null;
        }
        return objectMetaRequestOptions.headers();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getHexMD5() {
        return this.hexMD5;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isIgnoreSameKey() {
        return this.ignoreSameKey;
    }

    public PutFetchTaskInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutFetchTaskInput setHexMD5(String str) {
        this.hexMD5 = str;
        return this;
    }

    public PutFetchTaskInput setIgnoreSameKey(boolean z10) {
        this.ignoreSameKey = z10;
        return this;
    }

    public PutFetchTaskInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PutFetchTaskInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public PutFetchTaskInput setUrl(String str) {
        this.url = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutFetchTaskInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', options=");
        sb.append(this.options);
        sb.append(", url='");
        sb.append(this.url);
        sb.append("', ignoreSameKey=");
        sb.append(this.ignoreSameKey);
        sb.append(", hexMD5='");
        return a.q(sb, this.hexMD5, "'}");
    }
}
