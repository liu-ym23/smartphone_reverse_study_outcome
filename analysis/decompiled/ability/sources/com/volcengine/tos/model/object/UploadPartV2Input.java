package com.volcengine.tos.model.object;

import U6.a;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class UploadPartV2Input {
    private transient InputStream content;
    private long contentLength;
    private UploadPartBasicInput uploadPartBasicInput = new UploadPartBasicInput();

    public static final class UploadPartV2InputBuilder {
        private transient InputStream content;
        private long contentLength;
        private UploadPartBasicInput uploadPartBasicInput;

        public UploadPartV2InputBuilder bucket(String str) {
            this.uploadPartBasicInput.setBucket(str);
            return this;
        }

        public UploadPartV2Input build() {
            UploadPartV2Input uploadPartV2Input = new UploadPartV2Input();
            uploadPartV2Input.uploadPartBasicInput = this.uploadPartBasicInput;
            uploadPartV2Input.content = this.content;
            uploadPartV2Input.contentLength = this.contentLength;
            return uploadPartV2Input;
        }

        public UploadPartV2InputBuilder content(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public UploadPartV2InputBuilder contentLength(long j5) {
            this.contentLength = j5;
            return this;
        }

        public UploadPartV2InputBuilder dataTransferListener(a aVar) {
            this.uploadPartBasicInput.setDataTransferListener(aVar);
            return this;
        }

        public UploadPartV2InputBuilder key(String str) {
            this.uploadPartBasicInput.setKey(str);
            return this;
        }

        public UploadPartV2InputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.uploadPartBasicInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        public UploadPartV2InputBuilder partNumber(int i) {
            this.uploadPartBasicInput.setPartNumber(i);
            return this;
        }

        public UploadPartV2InputBuilder rateLimiter(W6.a aVar) {
            this.uploadPartBasicInput.setRateLimiter(aVar);
            return this;
        }

        public UploadPartV2InputBuilder readLimit(int i) {
            this.uploadPartBasicInput.setReadLimit(i);
            return this;
        }

        public UploadPartV2InputBuilder uploadID(String str) {
            this.uploadPartBasicInput.setUploadID(str);
            return this;
        }

        @Deprecated
        public UploadPartV2InputBuilder uploadPartBasicInput(UploadPartBasicInput uploadPartBasicInput) {
            this.uploadPartBasicInput = uploadPartBasicInput;
            return this;
        }

        private UploadPartV2InputBuilder() {
            this.uploadPartBasicInput = new UploadPartBasicInput();
        }
    }

    public static UploadPartV2InputBuilder builder() {
        return new UploadPartV2InputBuilder();
    }

    public String getBucket() {
        return this.uploadPartBasicInput.getBucket();
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public a getDataTransferListener() {
        this.uploadPartBasicInput.getDataTransferListener();
        return null;
    }

    public String getKey() {
        return this.uploadPartBasicInput.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.uploadPartBasicInput.getOptions();
    }

    public int getPartNumber() {
        return this.uploadPartBasicInput.getPartNumber();
    }

    public W6.a getRateLimiter() {
        this.uploadPartBasicInput.getRateLimiter();
        return null;
    }

    public int getReadLimit() {
        return this.uploadPartBasicInput.getReadLimit();
    }

    public String getUploadID() {
        return this.uploadPartBasicInput.getUploadID();
    }

    @Deprecated
    public UploadPartBasicInput getUploadPartBasicInput() {
        return this.uploadPartBasicInput;
    }

    public UploadPartV2Input setBucket(String str) {
        this.uploadPartBasicInput.setBucket(str);
        return this;
    }

    public UploadPartV2Input setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    public UploadPartV2Input setContentLength(long j5) {
        this.contentLength = j5;
        return this;
    }

    public UploadPartV2Input setDataTransferListener(a aVar) {
        this.uploadPartBasicInput.setDataTransferListener(aVar);
        return this;
    }

    public UploadPartV2Input setKey(String str) {
        this.uploadPartBasicInput.setKey(str);
        return this;
    }

    public UploadPartV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.uploadPartBasicInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    public UploadPartV2Input setPartNumber(int i) {
        this.uploadPartBasicInput.setPartNumber(i);
        return this;
    }

    public UploadPartV2Input setRateLimiter(W6.a aVar) {
        this.uploadPartBasicInput.setRateLimiter(aVar);
        return this;
    }

    public UploadPartV2Input setReadLimit(int i) {
        this.uploadPartBasicInput.setReadLimit(i);
        return this;
    }

    public UploadPartV2Input setUploadID(String str) {
        this.uploadPartBasicInput.setUploadID(str);
        return this;
    }

    @Deprecated
    public UploadPartV2Input setUploadPartBasicInput(UploadPartBasicInput uploadPartBasicInput) {
        this.uploadPartBasicInput = uploadPartBasicInput;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartV2Input{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', uploadID='");
        sb.append(getUploadID());
        sb.append("', partNumber=");
        sb.append(getPartNumber());
        sb.append(", options=");
        sb.append(getOptions());
        sb.append(", dataTransferListener=null, rateLimit=null, contentLength=");
        getDataTransferListener();
        getRateLimiter();
        return B7.a.p(sb, this.contentLength, '}');
    }
}
