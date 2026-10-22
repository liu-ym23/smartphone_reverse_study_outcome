package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/* loaded from: classes3.dex */
public class FetchObjectInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("ContentMD5")
    private String hexMD5;

    @JsonProperty("IgnoreSameKey")
    private boolean ignoreSameKey;

    @JsonIgnore
    private String key;

    @JsonIgnore
    private ObjectMetaRequestOptions options;

    @JsonProperty("URL")
    private String url;

    public static final class FetchObjectInputBuilder {
        private String bucket;
        private String hexMD5;
        private boolean ignoreSameKey;
        private String key;
        private ObjectMetaRequestOptions options;
        private String url;

        public FetchObjectInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public FetchObjectInput build() {
            FetchObjectInput fetchObjectInput = new FetchObjectInput();
            fetchObjectInput.setBucket(this.bucket);
            fetchObjectInput.setKey(this.key);
            fetchObjectInput.setOptions(this.options);
            fetchObjectInput.setUrl(this.url);
            fetchObjectInput.setIgnoreSameKey(this.ignoreSameKey);
            fetchObjectInput.setHexMD5(this.hexMD5);
            return fetchObjectInput;
        }

        public FetchObjectInputBuilder hexMD5(String str) {
            this.hexMD5 = str;
            return this;
        }

        public FetchObjectInputBuilder ignoreSameKey(boolean z10) {
            this.ignoreSameKey = z10;
            return this;
        }

        public FetchObjectInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public FetchObjectInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public FetchObjectInputBuilder url(String str) {
            this.url = str;
            return this;
        }

        private FetchObjectInputBuilder() {
        }
    }

    public static FetchObjectInputBuilder builder() {
        return new FetchObjectInputBuilder();
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

    public FetchObjectInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public FetchObjectInput setHexMD5(String str) {
        this.hexMD5 = str;
        return this;
    }

    public FetchObjectInput setIgnoreSameKey(boolean z10) {
        this.ignoreSameKey = z10;
        return this;
    }

    public FetchObjectInput setKey(String str) {
        this.key = str;
        return this;
    }

    public FetchObjectInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public FetchObjectInput setUrl(String str) {
        this.url = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FetchObjectInput{bucket='");
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
