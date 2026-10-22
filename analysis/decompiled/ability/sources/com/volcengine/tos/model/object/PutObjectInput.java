package com.volcengine.tos.model.object;

import U6.a;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class PutObjectInput {
    private InputStream content;
    private PutObjectBasicInput putObjectBasicInput = new PutObjectBasicInput();

    public static final class PutObjectInputBuilder {
        private InputStream content;
        private PutObjectBasicInput putObjectBasicInput;

        public PutObjectInputBuilder bucket(String str) {
            this.putObjectBasicInput.setBucket(str);
            return this;
        }

        public PutObjectInput build() {
            PutObjectInput putObjectInput = new PutObjectInput();
            putObjectInput.setPutObjectBasicInput(this.putObjectBasicInput);
            putObjectInput.setContent(this.content);
            return putObjectInput;
        }

        public PutObjectInputBuilder callback(String str) {
            this.putObjectBasicInput.setCallback(str);
            return this;
        }

        public PutObjectInputBuilder callbackVar(String str) {
            this.putObjectBasicInput.setCallbackVar(str);
            return this;
        }

        public PutObjectInputBuilder content(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public PutObjectInputBuilder contentLength(long j5) {
            this.putObjectBasicInput.setContentLength(j5);
            return this;
        }

        public PutObjectInputBuilder dataTransferListener(a aVar) {
            this.putObjectBasicInput.setDataTransferListener(aVar);
            return this;
        }

        public PutObjectInputBuilder key(String str) {
            this.putObjectBasicInput.setKey(str);
            return this;
        }

        public PutObjectInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.putObjectBasicInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        @Deprecated
        public PutObjectInputBuilder putObjectBasicInput(PutObjectBasicInput putObjectBasicInput) {
            this.putObjectBasicInput = putObjectBasicInput;
            return this;
        }

        public PutObjectInputBuilder rateLimiter(W6.a aVar) {
            this.putObjectBasicInput.setRateLimiter(aVar);
            return this;
        }

        public PutObjectInputBuilder readLimit(int i) {
            this.putObjectBasicInput.setReadLimit(i);
            return this;
        }

        private PutObjectInputBuilder() {
            this.putObjectBasicInput = new PutObjectBasicInput();
        }
    }

    public static PutObjectInputBuilder builder() {
        return new PutObjectInputBuilder();
    }

    public String getBucket() {
        return this.putObjectBasicInput.getBucket();
    }

    public String getCallback() {
        return this.putObjectBasicInput.getCallback();
    }

    public String getCallbackVar() {
        return this.putObjectBasicInput.getCallbackVar();
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        return this.putObjectBasicInput.getContentLength();
    }

    public a getDataTransferListener() {
        this.putObjectBasicInput.getDataTransferListener();
        return null;
    }

    public String getKey() {
        return this.putObjectBasicInput.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.putObjectBasicInput.getOptions();
    }

    @Deprecated
    public PutObjectBasicInput getPutObjectBasicInput() {
        return this.putObjectBasicInput;
    }

    public W6.a getRateLimiter() {
        this.putObjectBasicInput.getRateLimiter();
        return null;
    }

    public int getReadLimit() {
        return this.putObjectBasicInput.getReadLimit();
    }

    public PutObjectInput setBucket(String str) {
        this.putObjectBasicInput.setBucket(str);
        return this;
    }

    public PutObjectInput setCallback(String str) {
        this.putObjectBasicInput.setCallback(str);
        return this;
    }

    public PutObjectInput setCallbackVar(String str) {
        this.putObjectBasicInput.setCallbackVar(str);
        return this;
    }

    public PutObjectInput setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    public PutObjectInput setContentLength(long j5) {
        this.putObjectBasicInput.setContentLength(j5);
        return this;
    }

    public PutObjectInput setDataTransferListener(a aVar) {
        this.putObjectBasicInput.setDataTransferListener(aVar);
        return this;
    }

    public PutObjectInput setKey(String str) {
        this.putObjectBasicInput.setKey(str);
        return this;
    }

    public PutObjectInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.putObjectBasicInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    @Deprecated
    public PutObjectInput setPutObjectBasicInput(PutObjectBasicInput putObjectBasicInput) {
        this.putObjectBasicInput = putObjectBasicInput;
        return this;
    }

    public PutObjectInput setRateLimiter(W6.a aVar) {
        this.putObjectBasicInput.setRateLimiter(aVar);
        return this;
    }

    public PutObjectInput setReadLimit(int i) {
        this.putObjectBasicInput.setReadLimit(i);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutObjectInput{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', contentLength=");
        sb.append(getContentLength());
        sb.append(", options=");
        sb.append(getOptions());
        sb.append(", dataTransferListener=null, rateLimit=null, callback='");
        getDataTransferListener();
        getRateLimiter();
        sb.append(getCallback());
        sb.append("', callbackVar='");
        sb.append(getCallbackVar());
        sb.append("'}");
        return sb.toString();
    }
}
