package com.bytedance.rpc.transport;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TransportResponse {
    private TransportInput mBody;
    private Map<String, String> mHeaders;
    private int mHttpCode;
    private String mHttpMsg;

    /* JADX INFO: renamed from: com.bytedance.rpc.transport.TransportResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private TransportInput mBody;
        private Map<String, String> mHeaders;
        private int mHttpCode;
        private String mHttpMsg;

        private Builder self() {
            return this;
        }

        /* synthetic */ Builder(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ Builder(TransportResponse r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.mHttpCode;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.mHttpMsg;
        }

        static /* synthetic */ Map access$200(Builder r0) {
            return r0.mHeaders;
        }

        static /* synthetic */ TransportInput access$300(Builder r0) {
            return r0.mBody;
        }

        private Builder(int r1) {
            this.mHttpCode = r1;
        }

        private Builder(TransportResponse r2) {
            this.mHttpCode = TransportResponse.access$600(r2);
            this.mHttpMsg = TransportResponse.access$700(r2);
            this.mHeaders = TransportResponse.access$800(r2);
            this.mBody = TransportResponse.access$900(r2);
        }

        public Builder setHttpCode(int r1) {
            this.mHttpCode = r1;
            return self();
        }

        public Builder setHttpMsg(String r1) {
            this.mHttpMsg = r1;
            return self();
        }

        public Builder setHeaders(Map<String, String> r1) {
            this.mHeaders = r1;
            return self();
        }

        public Builder setBody(TransportInput r1) {
            this.mBody = r1;
            return self();
        }

        public TransportResponse build() {
            return new TransportResponse(this, null);
        }
    }

    /* synthetic */ TransportResponse(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int access$600(TransportResponse r0) {
        return r0.mHttpCode;
    }

    static /* synthetic */ String access$700(TransportResponse r0) {
        return r0.mHttpMsg;
    }

    static /* synthetic */ Map access$800(TransportResponse r0) {
        return r0.mHeaders;
    }

    static /* synthetic */ TransportInput access$900(TransportResponse r0) {
        return r0.mBody;
    }

    private TransportResponse(Builder r2) {
        this.mHttpCode = Builder.access$000(r2);
        this.mHttpMsg = Builder.access$100(r2);
        this.mHeaders = Builder.access$200(r2);
        this.mBody = Builder.access$300(r2);
    }

    public String getContentType() {
        TransportInput r0 = this.mBody;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.contentType();
    }

    public long getContentLength() {
        TransportInput r2 = this.mBody;
        if (r2 == null) goto L12;
        return r2.contentLength();
    L6:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L12:
        return 0;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public String getHttpMsg() {
        return this.mHttpMsg;
    }

    public TransportInput getBody() {
        return this.mBody;
    }

    public boolean isSuccessful() {
        int r1 = this.mHttpCode;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    public static Builder newBuilder(int r2) {
        return new Builder(r2, null);
    }
}
