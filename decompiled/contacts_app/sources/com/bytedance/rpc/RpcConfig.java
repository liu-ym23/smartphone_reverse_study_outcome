package com.bytedance.rpc;

import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcConfig {
    public static final int BASEURL = 8;
    public static final int GZIP = 16;
    public static final int HEADERS = 2;
    public static final int QUERIES = 4;
    public static final int TIMEOUT = 1;
    private String mBaseUrl;
    private int mChangedFlag;
    private long mConnectTimeout;
    private Map<String, String> mHeaders;
    private Map<String, String> mQueries;
    private long mReadTimeout;
    private boolean mRequestGzip;
    private long mWriteTimeout;

    /* JADX INFO: renamed from: com.bytedance.rpc.RpcConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mBaseUrl;
        private long mConnectTimeout;
        private Map<String, String> mHeaders;
        private Map<String, String> mQueries;
        private long mReadTimeout;
        private boolean mRequestGzip;
        private long mWriteTimeout;

        private void checkParams() {
        }

        private Builder self() {
            return this;
        }

        /* synthetic */ Builder(RpcConfig r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ long access$000(Builder r2) {
            return r2.mConnectTimeout;
        }

        static /* synthetic */ long access$100(Builder r2) {
            return r2.mReadTimeout;
        }

        static /* synthetic */ long access$200(Builder r2) {
            return r2.mWriteTimeout;
        }

        static /* synthetic */ String access$300(Builder r0) {
            return r0.mBaseUrl;
        }

        static /* synthetic */ Map access$400(Builder r0) {
            return r0.mHeaders;
        }

        static /* synthetic */ Map access$500(Builder r0) {
            return r0.mQueries;
        }

        static /* synthetic */ boolean access$600(Builder r0) {
            return r0.mRequestGzip;
        }

        private Builder(RpcConfig r3) {
            this.mConnectTimeout = RpcConfig.access$800(r3);
            this.mReadTimeout = RpcConfig.access$900(r3);
            this.mWriteTimeout = RpcConfig.access$1000(r3);
            this.mBaseUrl = RpcConfig.access$1100(r3);
            this.mRequestGzip = RpcConfig.access$1200(r3);
            this.mHeaders = new HashMap(RpcConfig.access$1300(r3));
            this.mQueries = new HashMap(RpcConfig.access$1400(r3));
        }

        Builder() {
            this.mHeaders = new HashMap();
            this.mQueries = new HashMap();
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

        public Builder setRequestGzip(boolean r1) {
            this.mRequestGzip = r1;
            return self();
        }

        public Builder setBaseUrl(String r1) {
            this.mBaseUrl = r1;
            return self();
        }

        public Builder addHeader(String r2, String r3) {
            return put(this.mHeaders, r2, r3);
        }

        public Builder addHeader(Map<String, String> r2) {
            return put(this.mHeaders, r2);
        }

        public Builder addQuery(String r2, String r3) {
            return put(this.mQueries, r2, r3);
        }

        public Builder addQuery(Map<String, String> r2) {
            return put(this.mQueries, r2);
        }

        private Builder put(Map<String, String> r2, String r3, String r4) {
            if (RpcUtils.isVisible(r3) == false) goto L8;
            if (r4 != null) goto L6;
            r2.remove(r3);
            goto L8
        L6:
            r2.put(r3, r4);
        L8:
            return self();
        }

        private Builder put(Map<String, String> r2, Map<String, String> r3) {
            if (r3 == null) goto L7;
            if (r3.isEmpty() == true) goto L7;
            r2.putAll(r3);
        L7:
            return self();
        }

        public RpcConfig build(RpcConfig... r7) {
            checkParams();
            if (r7 == null) goto L13;
            if (r7.length == 0) goto L13;
            int r0 = r7.length;
            int r2 = 0;
        L8:
            if (r2 >= r0) goto L11;
            RpcConfig r3 = r7[r2];
            RpcConfig.access$802(r3, this.mConnectTimeout);
            RpcConfig.access$902(r3, this.mReadTimeout);
            RpcConfig.access$1002(r3, this.mWriteTimeout);
            RpcConfig.access$1102(r3, this.mBaseUrl);
            RpcConfig.access$1302(r3, this.mHeaders);
            RpcConfig.access$1402(r3, this.mQueries);
            RpcConfig.access$1202(r3, this.mRequestGzip);
            r2 = r2 + 1;
            goto L8
        L11:
            return r7[0];
        L13:
            return new RpcConfig(this, null);
        }
    }

    /* synthetic */ RpcConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ long access$1000(RpcConfig r2) {
        return r2.mWriteTimeout;
    }

    static /* synthetic */ long access$1002(RpcConfig r0, long r1) {
        r0.mWriteTimeout = r1;
        return r1;
    }

    static /* synthetic */ String access$1100(RpcConfig r0) {
        return r0.mBaseUrl;
    }

    static /* synthetic */ String access$1102(RpcConfig r0, String r1) {
        r0.mBaseUrl = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1200(RpcConfig r0) {
        return r0.mRequestGzip;
    }

    static /* synthetic */ boolean access$1202(RpcConfig r0, boolean r1) {
        r0.mRequestGzip = r1;
        return r1;
    }

    static /* synthetic */ Map access$1300(RpcConfig r0) {
        return r0.mHeaders;
    }

    static /* synthetic */ Map access$1302(RpcConfig r0, Map r1) {
        r0.mHeaders = r1;
        return r1;
    }

    static /* synthetic */ Map access$1400(RpcConfig r0) {
        return r0.mQueries;
    }

    static /* synthetic */ Map access$1402(RpcConfig r0, Map r1) {
        r0.mQueries = r1;
        return r1;
    }

    static /* synthetic */ long access$800(RpcConfig r2) {
        return r2.mConnectTimeout;
    }

    static /* synthetic */ long access$802(RpcConfig r0, long r1) {
        r0.mConnectTimeout = r1;
        return r1;
    }

    static /* synthetic */ long access$900(RpcConfig r2) {
        return r2.mReadTimeout;
    }

    static /* synthetic */ long access$902(RpcConfig r0, long r1) {
        r0.mReadTimeout = r1;
        return r1;
    }

    private RpcConfig(Builder r3) {
        this.mChangedFlag = 0;
        this.mConnectTimeout = Builder.access$000(r3);
        this.mReadTimeout = Builder.access$100(r3);
        this.mWriteTimeout = Builder.access$200(r3);
        this.mBaseUrl = Builder.access$300(r3);
        this.mHeaders = Builder.access$400(r3);
        this.mQueries = Builder.access$500(r3);
        this.mRequestGzip = Builder.access$600(r3);
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

    public boolean isRequestGzip() {
        return this.mRequestGzip;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public Map<String, String> getQueries() {
        return this.mQueries;
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    public boolean equals(Object r7) {
        boolean r0 = super.equals(r7);
        if (r0 == false) goto L5;
    L27:
        return r0;
    L5:
        if ((r7 instanceof RpcConfig) == false) goto L27;
        RpcConfig r8 = (RpcConfig) r7;
        if (this.mConnectTimeout == r8.mConnectTimeout) goto L9;
    L26:
        return false;
    L9:
        if (this.mReadTimeout != r8.mReadTimeout) goto L26;
        if (this.mWriteTimeout != r8.mWriteTimeout) goto L26;
        if (this.mRequestGzip != r8.mRequestGzip) goto L26;
        if (TextUtils.equals(this.mBaseUrl, r8.mBaseUrl) == true) goto L19;
        return false;
    L19:
        if (equalOfSimpleObject(this.mHeaders, r8.mHeaders) == true) goto L22;
        return false;
    L22:
        if (equalOfSimpleObject(this.mQueries, r8.mQueries) == true) goto L24;
        return false;
    L24:
        return true;
    }

    int computeChangedFlag(RpcConfig r6, boolean r7) {
        if (r6 != null) goto L6;
        return 31;
    L6:
        if (equalOfSimpleObject(this.mBaseUrl, r6.mBaseUrl) == true) goto L8;
        int r0 = 8;
    L10:
        if (equalOfSimpleObject(this.mHeaders, r6.mHeaders) == true) goto L13;
        r0 = r0 | 2;
    L13:
        if (equalOfSimpleObject(this.mQueries, r6.mQueries) == true) goto L16;
        r0 = r0 | 4;
    L16:
        if (this.mConnectTimeout == r6.mConnectTimeout) goto L18;
    L21:
        r0 = r0 | 1;
    L23:
        if (this.mRequestGzip == r6.mRequestGzip) goto L25;
        r0 = r0 | 16;
    L25:
        if (r7 == false) goto L28;
        if (r0 == 0) goto L28;
        this.mChangedFlag = r0;
    L28:
        return r0;
    L18:
        if (this.mReadTimeout != r6.mReadTimeout) goto L21;
        if (this.mWriteTimeout == r6.mWriteTimeout) goto L23;
    L8:
        r0 = 0;
        goto L10
    }

    public final boolean changed(int r2) {
        if (r2 != 0) goto L6;
        return false;
    L6:
        if ((this.mChangedFlag & r2) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean equalOfSimpleObject(Object r1, Object r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 == null) goto L10;
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r1.equals(r2) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public String toString() {
        return "RpcConfig{mBaseUrl='" + this.mBaseUrl + "', mHeaders=" + this.mHeaders + ", mQueries=" + this.mQueries + ", mConnectTimeout=" + this.mConnectTimeout + ", mReadTimeout=" + this.mReadTimeout + ", mWriteTimeout=" + this.mWriteTimeout + ", mRequestGzip=" + this.mRequestGzip + ", mChangedFlag=" + this.mChangedFlag + '}';
    }
}
