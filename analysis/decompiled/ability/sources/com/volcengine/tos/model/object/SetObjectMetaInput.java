package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public class SetObjectMetaInput {
    private String bucket;
    private String key;
    private ObjectMetaRequestOptions options;
    private String versionID;

    public static final class SetObjectMetaInputBuilder {
        private String bucket;
        private String key;
        private ObjectMetaRequestOptions options;
        private String versionID;

        public SetObjectMetaInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public SetObjectMetaInput build() {
            SetObjectMetaInput setObjectMetaInput = new SetObjectMetaInput();
            setObjectMetaInput.bucket = this.bucket;
            setObjectMetaInput.key = this.key;
            setObjectMetaInput.versionID = this.versionID;
            setObjectMetaInput.options = this.options;
            return setObjectMetaInput;
        }

        public SetObjectMetaInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public SetObjectMetaInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public SetObjectMetaInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private SetObjectMetaInputBuilder() {
        }
    }

    public static SetObjectMetaInputBuilder builder() {
        return new SetObjectMetaInputBuilder();
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

    public SetObjectMetaInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public SetObjectMetaInput setKey(String str) {
        this.key = str;
        return this;
    }

    public SetObjectMetaInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public SetObjectMetaInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "SetObjectMetaInput{bucket='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', options=" + this.options + '}';
    }
}
