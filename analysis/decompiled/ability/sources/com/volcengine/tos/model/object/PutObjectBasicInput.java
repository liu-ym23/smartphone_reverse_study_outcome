package com.volcengine.tos.model.object;

import U6.a;
import java.util.Map;

/* loaded from: classes3.dex */
public class PutObjectBasicInput {
    private String bucket;
    private String callback;
    private String callbackVar;
    private long contentLength;
    private a dataTransferListener;
    private String key;
    private ObjectMetaRequestOptions options;
    private W6.a rateLimiter;
    private int readLimit;

    public static final class PutObjectBasicInputBuilder {
        private String bucket;
        private String callback;
        private String callbackVar;
        private long contentLength;
        private a dataTransferListener;
        private String key;
        private ObjectMetaRequestOptions options;
        private W6.a rateLimit;

        public PutObjectBasicInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutObjectBasicInput build() {
            PutObjectBasicInput putObjectBasicInput = new PutObjectBasicInput();
            putObjectBasicInput.key = this.key;
            putObjectBasicInput.bucket = this.bucket;
            putObjectBasicInput.contentLength = this.contentLength;
            PutObjectBasicInput.access$402(putObjectBasicInput, null);
            putObjectBasicInput.options = this.options;
            PutObjectBasicInput.access$602(putObjectBasicInput, null);
            putObjectBasicInput.callback = this.callback;
            putObjectBasicInput.callbackVar = this.callbackVar;
            return putObjectBasicInput;
        }

        public PutObjectBasicInputBuilder callback(String str) {
            this.callback = str;
            return this;
        }

        public PutObjectBasicInputBuilder callbackVar(String str) {
            this.callbackVar = str;
            return this;
        }

        public PutObjectBasicInputBuilder contentLength(long j5) {
            this.contentLength = j5;
            return this;
        }

        public PutObjectBasicInputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public PutObjectBasicInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PutObjectBasicInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public PutObjectBasicInputBuilder rateLimiter(W6.a aVar) {
            return this;
        }

        private PutObjectBasicInputBuilder() {
        }
    }

    public static /* synthetic */ a access$402(PutObjectBasicInput putObjectBasicInput, a aVar) {
        putObjectBasicInput.getClass();
        return aVar;
    }

    public static /* synthetic */ W6.a access$602(PutObjectBasicInput putObjectBasicInput, W6.a aVar) {
        putObjectBasicInput.getClass();
        return aVar;
    }

    public static PutObjectBasicInputBuilder builder() {
        return new PutObjectBasicInputBuilder();
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

    public String getCallback() {
        return this.callback;
    }

    public String getCallbackVar() {
        return this.callbackVar;
    }

    public long getContentLength() {
        return this.contentLength;
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

    public W6.a getRateLimiter() {
        return null;
    }

    public int getReadLimit() {
        return this.readLimit;
    }

    public PutObjectBasicInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutObjectBasicInput setCallback(String str) {
        this.callback = str;
        return this;
    }

    public PutObjectBasicInput setCallbackVar(String str) {
        this.callbackVar = str;
        return this;
    }

    public PutObjectBasicInput setContentLength(long j5) {
        this.contentLength = j5;
        return this;
    }

    public PutObjectBasicInput setDataTransferListener(a aVar) {
        return this;
    }

    public PutObjectBasicInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PutObjectBasicInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public PutObjectBasicInput setRateLimiter(W6.a aVar) {
        return this;
    }

    public PutObjectBasicInput setReadLimit(int i) {
        this.readLimit = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutObjectBasicInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', contentLength=");
        sb.append(this.contentLength);
        sb.append(", options=");
        sb.append(this.options);
        sb.append(", dataTransferListener=null, callback='");
        sb.append(this.callback);
        sb.append("', callbackVar='");
        return B7.a.q(sb, this.callbackVar, "', rateLimiter=null}");
    }
}
