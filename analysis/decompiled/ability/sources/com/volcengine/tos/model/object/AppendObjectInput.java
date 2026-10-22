package com.volcengine.tos.model.object;

import U6.a;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppendObjectInput {
    private String bucket;
    private transient InputStream content;
    private long contentLength;
    private a dataTransferListener;
    private String key;
    private long offset;
    private ObjectMetaRequestOptions options;
    private String preHashCrc64ecma;
    private W6.a rateLimiter;

    public static final class AppendObjectInputBuilder {
        private String bucket;
        private transient InputStream content;
        private long contentLength;
        private a dataTransferListener;
        private String key;
        private long offset;
        private ObjectMetaRequestOptions options;
        private String preHashCrc64ecma;
        private W6.a rateLimiter;

        public AppendObjectInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public AppendObjectInput build() {
            AppendObjectInput appendObjectInput = new AppendObjectInput();
            appendObjectInput.key = this.key;
            appendObjectInput.content = this.content;
            appendObjectInput.preHashCrc64ecma = this.preHashCrc64ecma;
            appendObjectInput.offset = this.offset;
            appendObjectInput.contentLength = this.contentLength;
            appendObjectInput.bucket = this.bucket;
            AppendObjectInput.access$702(appendObjectInput, null);
            AppendObjectInput.access$802(appendObjectInput, null);
            appendObjectInput.options = this.options;
            return appendObjectInput;
        }

        public AppendObjectInputBuilder content(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public AppendObjectInputBuilder contentLength(long j5) {
            this.contentLength = j5;
            return this;
        }

        public AppendObjectInputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public AppendObjectInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public AppendObjectInputBuilder offset(long j5) {
            this.offset = j5;
            return this;
        }

        public AppendObjectInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public AppendObjectInputBuilder preHashCrc64ecma(String str) {
            this.preHashCrc64ecma = str;
            return this;
        }

        public AppendObjectInputBuilder rateLimit(W6.a aVar) {
            return this;
        }

        private AppendObjectInputBuilder() {
        }
    }

    public static /* synthetic */ a access$702(AppendObjectInput appendObjectInput, a aVar) {
        appendObjectInput.getClass();
        return aVar;
    }

    public static /* synthetic */ W6.a access$802(AppendObjectInput appendObjectInput, W6.a aVar) {
        appendObjectInput.getClass();
        return aVar;
    }

    public static AppendObjectInputBuilder builder() {
        return new AppendObjectInputBuilder();
    }

    public Map<String, String> getAllSettedHeaders() {
        if (this.options == null) {
            return null;
        }
        return this.options.headers();
    }

    public String getBucket() {
        return this.bucket;
    }

    public InputStream getContent() {
        return this.content;
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

    public long getOffset() {
        return this.offset;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public String getPreHashCrc64ecma() {
        return this.preHashCrc64ecma;
    }

    public W6.a getRateLimiter() {
        return null;
    }

    public AppendObjectInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public AppendObjectInput setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    public AppendObjectInput setContentLength(long j5) {
        this.contentLength = j5;
        return this;
    }

    public AppendObjectInput setDataTransferListener(a aVar) {
        return this;
    }

    public AppendObjectInput setKey(String str) {
        this.key = str;
        return this;
    }

    public AppendObjectInput setOffset(long j5) {
        this.offset = j5;
        return this;
    }

    public AppendObjectInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public AppendObjectInput setPreHashCrc64ecma(String str) {
        this.preHashCrc64ecma = str;
        return this;
    }

    public AppendObjectInput setRateLimiter(W6.a aVar) {
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppendObjectInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', offset=");
        sb.append(this.offset);
        sb.append(", contentLength=");
        sb.append(this.contentLength);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", options=");
        sb.append(this.options);
        sb.append(", dataTransferListener=null, preHashCrc64ecma='");
        return B7.a.q(sb, this.preHashCrc64ecma, "', rateLimit=null}");
    }
}
