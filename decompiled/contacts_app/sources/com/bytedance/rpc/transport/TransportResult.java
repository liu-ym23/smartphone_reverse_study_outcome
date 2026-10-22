package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TransportResult {
    long mContentLength;
    String mContentType;
    Object mData;
    RpcException mError;
    Map<String, String> mHeaders;
    int mHttpCode;
    String mHttpMsg;
    long mRequestFinishedTime;
    int mRequestId;
    long mRequestReceivedTime;
    long mRequestSerializeTime;
    long mRequestTransformTime;

    /* JADX INFO: renamed from: com.bytedance.rpc.transport.TransportResult$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        long mContentLength;
        String mContentType;
        Object mData;
        RpcException mError;
        Map<String, String> mHeaders;
        int mHttpCode;
        String mHttpMsg;
        long mRequestFinishedTime;
        int mRequestId;
        long mRequestReceivedTime;
        long mRequestSerializeTime;
        long mRequestTransformTime;

        private Builder self() {
            return this;
        }

        public Builder() {
        }

        public Builder setRequestId(int r1) {
            this.mRequestId = r1;
            return self();
        }

        public Builder setRequestReceivedTime(long r1) {
            this.mRequestReceivedTime = r1;
            return self();
        }

        public Builder setRequestTransformTime(long r1) {
            this.mRequestTransformTime = r1;
            return self();
        }

        public Builder setRequestSerializeTime(long r1) {
            this.mRequestSerializeTime = r1;
            return self();
        }

        public Builder setRequestFinishedTime(long r1) {
            this.mRequestFinishedTime = r1;
            return self();
        }

        public Builder setHttpCode(int r1) {
            this.mHttpCode = r1;
            return self();
        }

        public Builder setHttpMsg(String r1) {
            this.mHttpMsg = r1;
            return self();
        }

        public Builder setContentType(String r1) {
            this.mContentType = r1;
            return self();
        }

        public Builder setContentLength(long r1) {
            this.mContentLength = r1;
            return self();
        }

        public Builder setResult(Object r2) {
            if ((r2 instanceof Throwable) == true) goto L5;
            this.mData = r2;
        L12:
            return self();
        L5:
            if ((r2 instanceof RpcException) == false) goto L9;
            RpcException r3 = (RpcException) r2;
            this.mError = r3;
            if (r3.isHttpError() == false) goto L12;
            this.mHttpCode = this.mError.getCode();
            this.mHttpMsg = this.mError.getMessage();
            goto L12
        L9:
            this.mError = RpcException.from((Throwable) r2).build();
            goto L12
        }

        public Builder setHeaders(Map<String, String> r1) {
            this.mHeaders = r1;
            return self();
        }

        public TransportResult build() {
            return new TransportResult(this, null);
        }
    }

    /* synthetic */ TransportResult(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private TransportResult(Builder r3) {
        this.mRequestId = r3.mRequestId;
        this.mRequestReceivedTime = r3.mRequestReceivedTime;
        this.mRequestTransformTime = r3.mRequestTransformTime;
        this.mRequestSerializeTime = r3.mRequestSerializeTime;
        this.mRequestFinishedTime = r3.mRequestFinishedTime;
        this.mHttpCode = r3.mHttpCode;
        this.mHttpMsg = r3.mHttpMsg;
        this.mContentType = r3.mContentType;
        this.mContentLength = r3.mContentLength;
        this.mData = r3.mData;
        this.mError = r3.mError;
        this.mHeaders = r3.mHeaders;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public long getRequestReceivedTime() {
        return this.mRequestReceivedTime;
    }

    public long getRequestTransformTime() {
        return this.mRequestTransformTime;
    }

    public long getRequestSerializeTime() {
        return this.mRequestSerializeTime;
    }

    public long getRequestFinishedTime() {
        return this.mRequestFinishedTime;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public String getHttpMsg() {
        return this.mHttpMsg;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public Object getData() {
        return this.mData;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public RpcException getError() {
        return this.mError;
    }

    public boolean isTransportSuccess() {
        if (this.mError != null) goto L5;
        return true;
    L5:
        return false;
    }
}
