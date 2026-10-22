package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public class HeadObjectV2Input {
    private String bucket;
    private String key;
    private ObjectMetaRequestOptions options;
    private String versionID;

    public static final class HeadObjectInputV2Builder {
        private String bucket;
        private String key;
        private ObjectMetaRequestOptions options;
        private String versionID;

        public HeadObjectInputV2Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public HeadObjectInputV2Builder buckets(String str) {
            this.bucket = str;
            return this;
        }

        public HeadObjectV2Input build() {
            HeadObjectV2Input headObjectV2Input = new HeadObjectV2Input();
            headObjectV2Input.bucket = this.bucket;
            headObjectV2Input.key = this.key;
            headObjectV2Input.versionID = this.versionID;
            headObjectV2Input.options = this.options;
            return headObjectV2Input;
        }

        public HeadObjectInputV2Builder key(String str) {
            this.key = str;
            return this;
        }

        public HeadObjectInputV2Builder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public HeadObjectInputV2Builder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private HeadObjectInputV2Builder() {
        }
    }

    public static HeadObjectInputV2Builder builder() {
        return new HeadObjectInputV2Builder();
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

    public String getKey() {
        return this.key;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public HeadObjectV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public HeadObjectV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public HeadObjectV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public HeadObjectV2Input setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "HeadObjectV2Input{bucket='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', options=" + this.options + '}';
    }
}
