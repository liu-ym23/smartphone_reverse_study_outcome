package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcDataBuilder;
import com.bytedance.rpc.internal.RpcUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TransportRequest {
    private long mConnectTimeout;
    private RpcDataBuilder.SerializerData mData;
    private boolean mParamsNeed;
    private boolean mPostMethod;
    private long mReadTimeout;
    private int mRequestId;
    private String mUrl;
    private long mWriteTimeout;

    /* JADX INFO: renamed from: com.bytedance.rpc.transport.TransportRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mBaseUrl;
        private long mConnectTimeout;
        private RpcDataBuilder.SerializerData mData;
        private boolean mParamsNeed;
        private String mPath;
        private boolean mPostMethod;
        private long mReadTimeout;
        private int mRequestId;
        private long mWriteTimeout;

        private Builder self() {
            return this;
        }

        /* synthetic */ Builder(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ Builder(TransportRequest r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.mRequestId;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.mPostMethod;
        }

        static /* synthetic */ boolean access$200(Builder r0) {
            return r0.mParamsNeed;
        }

        static /* synthetic */ long access$300(Builder r2) {
            return r2.mConnectTimeout;
        }

        static /* synthetic */ long access$400(Builder r2) {
            return r2.mReadTimeout;
        }

        static /* synthetic */ long access$500(Builder r2) {
            return r2.mWriteTimeout;
        }

        static /* synthetic */ RpcDataBuilder.SerializerData access$600(Builder r0) {
            return r0.mData;
        }

        private Builder(int r1) {
            this.mRequestId = r1;
            this.mData = new RpcDataBuilder().build();
        }

        private Builder(TransportRequest r3) {
            String[] r0 = RpcUtils.getBaseUrlAndPath(TransportRequest.access$900(r3));
            this.mRequestId = TransportRequest.access$1000(r3);
            this.mPath = r0[1];
            this.mBaseUrl = r0[0];
            this.mPostMethod = TransportRequest.access$1100(r3);
            this.mParamsNeed = TransportRequest.access$1200(r3);
            this.mConnectTimeout = TransportRequest.access$1300(r3);
            this.mReadTimeout = TransportRequest.access$1400(r3);
            this.mWriteTimeout = TransportRequest.access$1500(r3);
            this.mData = TransportRequest.access$1600(r3);
        }

        public Builder setSerializerData(RpcDataBuilder.SerializerData r1) {
            if (r1 == null) goto L4;
            this.mData = r1;
        L4:
            return this;
        }

        public Builder setMethod(boolean r1) {
            this.mPostMethod = r1;
            return self();
        }

        public Builder setParamsNeed(boolean r1) {
            this.mParamsNeed = r1;
            return self();
        }

        public Builder setBaseUrl(String r1) {
            this.mBaseUrl = r1;
            return self();
        }

        public Builder setPath(String r1) {
            this.mPath = r1;
            return self();
        }

        public Builder setUrl(String r2) {
            String[] r3 = RpcUtils.getBaseUrlAndPath(r2);
            this.mBaseUrl = r3[0];
            this.mPath = r3[1];
            return self();
        }

        public Builder setConnectTimeout(long r1) {
            this.mConnectTimeout = r1;
            return self();
        }

        public Builder setReadTimeout(long r1) {
            this.mReadTimeout = r1;
            return self();
        }

        public Builder setWriteTimeout(long r1) {
            this.mWriteTimeout = r1;
            return self();
        }

        public TransportRequest build() {
            String r0 = RpcUtils.replacePathParamsWithQuery(this.mPath, this.mData.getQueries(), true);
            return new TransportRequest(this, RpcUtils.composeUrl(this.mBaseUrl, r0));
        }
    }

    static /* synthetic */ int access$1000(TransportRequest r0) {
        return r0.mRequestId;
    }

    static /* synthetic */ boolean access$1100(TransportRequest r0) {
        return r0.mPostMethod;
    }

    static /* synthetic */ boolean access$1200(TransportRequest r0) {
        return r0.mParamsNeed;
    }

    static /* synthetic */ long access$1300(TransportRequest r2) {
        return r2.mConnectTimeout;
    }

    static /* synthetic */ long access$1400(TransportRequest r2) {
        return r2.mReadTimeout;
    }

    static /* synthetic */ long access$1500(TransportRequest r2) {
        return r2.mWriteTimeout;
    }

    static /* synthetic */ RpcDataBuilder.SerializerData access$1600(TransportRequest r0) {
        return r0.mData;
    }

    static /* synthetic */ String access$900(TransportRequest r0) {
        return r0.mUrl;
    }

    TransportRequest(Builder r3, String r4) {
        this.mUrl = r4;
        this.mRequestId = Builder.access$000(r3);
        this.mPostMethod = Builder.access$100(r3);
        this.mParamsNeed = Builder.access$200(r3);
        this.mConnectTimeout = Builder.access$300(r3);
        this.mReadTimeout = Builder.access$400(r3);
        this.mWriteTimeout = Builder.access$500(r3);
        this.mData = Builder.access$600(r3);
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public RpcDataBuilder.SerializerData getRequestData() {
        return this.mData;
    }

    public boolean isPostMethod() {
        return this.mPostMethod;
    }

    public boolean isPostForm() {
        if (this.mPostMethod == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mData.isFormData() == false) goto L7;
        return true;
    }

    public boolean isMutiData() {
        if (this.mPostMethod == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mData.isMutiData() == false) goto L7;
        return true;
    }

    public RpcDataBuilder.SerializerData getData() {
        return this.mData;
    }

    public boolean isParamsNeed() {
        return this.mParamsNeed;
    }

    public long getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public long getReadTimeout() {
        return this.mReadTimeout;
    }

    public long getWriteTimeout() {
        return this.mWriteTimeout;
    }

    public static Builder newBuilder(int r2) {
        return new Builder(r2, null);
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    public void clear() {
        this.mUrl = null;
    }
}
