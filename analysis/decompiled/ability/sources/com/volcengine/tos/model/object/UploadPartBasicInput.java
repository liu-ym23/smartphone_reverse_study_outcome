package com.volcengine.tos.model.object;

import U6.a;
import java.util.Map;

/* loaded from: classes3.dex */
public class UploadPartBasicInput {
    private String bucket;
    private a dataTransferListener;
    private String key;
    private ObjectMetaRequestOptions options;
    private int partNumber;
    private W6.a rateLimiter;
    private int readLimit;
    private String uploadID;

    public static final class UploadPartBasicInputBuilder {
        private String bucket;
        private a dataTransferListener;
        private String key;
        private ObjectMetaRequestOptions options;
        private int partNumber;
        private W6.a rateLimiter;
        private String uploadID;

        public UploadPartBasicInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public UploadPartBasicInput build() {
            UploadPartBasicInput uploadPartBasicInput = new UploadPartBasicInput();
            uploadPartBasicInput.bucket = this.bucket;
            UploadPartBasicInput.access$202(uploadPartBasicInput, null);
            uploadPartBasicInput.partNumber = this.partNumber;
            uploadPartBasicInput.key = this.key;
            uploadPartBasicInput.uploadID = this.uploadID;
            uploadPartBasicInput.options = this.options;
            UploadPartBasicInput.access$702(uploadPartBasicInput, null);
            return uploadPartBasicInput;
        }

        public UploadPartBasicInputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public UploadPartBasicInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public UploadPartBasicInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public UploadPartBasicInputBuilder partNumber(int i) {
            this.partNumber = i;
            return this;
        }

        public UploadPartBasicInputBuilder rateLimiter(W6.a aVar) {
            return this;
        }

        public UploadPartBasicInputBuilder uploadID(String str) {
            this.uploadID = str;
            return this;
        }

        private UploadPartBasicInputBuilder() {
        }
    }

    public static /* synthetic */ a access$202(UploadPartBasicInput uploadPartBasicInput, a aVar) {
        uploadPartBasicInput.getClass();
        return aVar;
    }

    public static /* synthetic */ W6.a access$702(UploadPartBasicInput uploadPartBasicInput, W6.a aVar) {
        uploadPartBasicInput.getClass();
        return aVar;
    }

    public static UploadPartBasicInputBuilder builder() {
        return new UploadPartBasicInputBuilder();
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

    public a getDataTransferListener() {
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public W6.a getRateLimiter() {
        return null;
    }

    public int getReadLimit() {
        return this.readLimit;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadPartBasicInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadPartBasicInput setDataTransferListener(a aVar) {
        return this;
    }

    public UploadPartBasicInput setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadPartBasicInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public UploadPartBasicInput setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartBasicInput setRateLimiter(W6.a aVar) {
        return this;
    }

    public UploadPartBasicInput setReadLimit(int i) {
        this.readLimit = i;
        return this;
    }

    public UploadPartBasicInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        return "UploadPartBasicInput{bucket='" + this.bucket + "', key='" + this.key + "', uploadID='" + this.uploadID + "', partNumber=" + this.partNumber + ", options=" + this.options + ", dataTransferListener=null, rateLimit=null}";
    }
}
