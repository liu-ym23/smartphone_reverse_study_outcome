package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public class CreateMultipartUploadInput {
    private String bucket;
    private String encodingType;
    private String key;
    private ObjectMetaRequestOptions options;

    public static final class CreateMultipartUploadInputBuilder {
        private String bucket;
        private String encodingType;
        private String key;
        private ObjectMetaRequestOptions options;

        public CreateMultipartUploadInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public CreateMultipartUploadInput build() {
            CreateMultipartUploadInput createMultipartUploadInput = new CreateMultipartUploadInput();
            createMultipartUploadInput.setBucket(this.bucket);
            createMultipartUploadInput.setKey(this.key);
            createMultipartUploadInput.setEncodingType(this.encodingType);
            createMultipartUploadInput.setOptions(this.options);
            return createMultipartUploadInput;
        }

        public CreateMultipartUploadInputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public CreateMultipartUploadInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public CreateMultipartUploadInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        private CreateMultipartUploadInputBuilder() {
        }
    }

    public static CreateMultipartUploadInputBuilder builder() {
        return new CreateMultipartUploadInputBuilder();
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

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public CreateMultipartUploadInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CreateMultipartUploadInput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public CreateMultipartUploadInput setKey(String str) {
        this.key = str;
        return this;
    }

    public CreateMultipartUploadInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public String toString() {
        return "CreateMultipartUploadInput{bucket='" + this.bucket + "', key='" + this.key + "', encodingType='" + this.encodingType + "', options=" + this.options + '}';
    }
}
