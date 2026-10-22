package com.bytedance.rpc;

import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.log.DefaultErrorFormatter;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class RpcException extends RuntimeException implements Serializable {
    private static final List<Converter> mConverters = null;
    private int mCode;
    private long mErrorTime;
    private boolean mHttpProtocolError;
    private int mRequestId;
    private String mSource;
    private Map<Class<?>, Object> mTags;

    /* JADX INFO: renamed from: com.bytedance.rpc.RpcException$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Throwable mCause;
        private int mCode;
        private long mErrorTime;
        private boolean mHttpProtocolError;
        private String mMsg;
        private int mRequestId;
        private String mSource;
        private Map<Class<?>, Object> mTags;

        private Builder self() {
            return this;
        }

        /* synthetic */ Builder(int r1, String r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        /* synthetic */ Builder(RpcException r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ Builder(Throwable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Builder(RpcException r1) {
            this(r1);
        }

        private Builder(Throwable r3) {
            this.mCause = r3;
            this.mCode = ErrorCode.UNKNOWN;
            if ((r3 instanceof RpcException) == false) goto L5;
            RpcException r4 = (RpcException) r3;
            this.mHttpProtocolError = RpcException.access$300(r4);
            this.mCode = RpcException.access$400(r4);
            this.mMsg = r4.getMessage();
            this.mRequestId = RpcException.access$500(r4);
            this.mCause = r4.getCause();
            this.mErrorTime = RpcException.access$600(r4);
            this.mTags = RpcException.access$700(r4);
            this.mSource = RpcException.access$800(r4);
            return;
        L5:
            this.mTags = new HashMap(2);
            Iterator r0 = RpcException.access$900().iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            ((Converter) r0.next()).convert(r3, this);
            goto L7
        }

        private Builder(int r1, String r2, boolean r3) {
            this.mCode = r1;
            this.mMsg = r2;
            this.mHttpProtocolError = r3;
            this.mTags = new HashMap(2);
        }

        public Builder setTag(Class<?> r2, Object r3) {
            this.mTags.put(r2, r3);
            return self();
        }

        public Builder setHttpProtocolError(boolean r1) {
            this.mHttpProtocolError = r1;
            return self();
        }

        public Builder setSource(String r1) {
            this.mSource = r1;
            return self();
        }

        public Builder setRequestId(int r1) {
            this.mRequestId = r1;
            return self();
        }

        public Builder setCode(int r1) {
            this.mCode = r1;
            return self();
        }

        public Builder setMessage(String r1) {
            this.mMsg = r1;
            return self();
        }

        public Builder setInfo(int r1, String r2) {
            this.mCode = r1;
            this.mMsg = r2;
            return self();
        }

        public RpcException build() {
            if (RpcUtils.isInvisible(this.mMsg) == false) goto L8;
            Throwable r0 = this.mCause;
            if (r0 != null) goto L7;
            String r1 = "";
        L9:
            RpcException r2 = new RpcException(r1, this.mCause, null);
            RpcException.access$402(r2, this.mCode);
            RpcException.access$502(r2, this.mRequestId);
            RpcException.access$302(r2, this.mHttpProtocolError);
            if (RpcException.access$602(r2, this.mErrorTime) != 0) goto L12;
            RpcException.access$602(r2, System.currentTimeMillis());
        L12:
            RpcException.access$702(r2, this.mTags);
            RpcException.access$802(r2, this.mSource);
            return r2;
        L7:
            r1 = r0.getMessage();
            goto L9
        L8:
            r1 = this.mMsg;
            goto L9
        }

        public RpcException apply(RpcException r2) {
            if (r2 == null) goto L4;
            RpcException.access$402(r2, this.mCode);
            RpcException.access$502(r2, this.mRequestId);
            RpcException.access$702(r2, this.mTags);
            RpcException.access$802(r2, this.mSource);
            return r2;
        L4:
            return build();
        }
    }

    public interface Converter {
        void convert(Throwable r1, Builder r2);
    }

    public interface ErrorCode {
        public static final int CANCEL_TIMEOUT = 987654324;
        public static final int CANCEL_USER = 987654323;
        public static final int IGNORE = 987654322;
        public static final int NULL_RESPONSE_BODY = 987654326;
        public static final int OK = 0;
        public static final int RPCINTERCEPTED = 987654325;
        public static final int UNKNOWN = 987654321;
    }

    /* synthetic */ RpcException(String r1, Throwable r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ boolean access$300(RpcException r0) {
        return r0.mHttpProtocolError;
    }

    static /* synthetic */ boolean access$302(RpcException r0, boolean r1) {
        r0.mHttpProtocolError = r1;
        return r1;
    }

    static /* synthetic */ int access$400(RpcException r0) {
        return r0.mCode;
    }

    static /* synthetic */ int access$402(RpcException r0, int r1) {
        r0.mCode = r1;
        return r1;
    }

    static /* synthetic */ int access$500(RpcException r0) {
        return r0.mRequestId;
    }

    static /* synthetic */ int access$502(RpcException r0, int r1) {
        r0.mRequestId = r1;
        return r1;
    }

    static /* synthetic */ long access$600(RpcException r2) {
        return r2.mErrorTime;
    }

    static /* synthetic */ long access$602(RpcException r0, long r1) {
        r0.mErrorTime = r1;
        return r1;
    }

    static /* synthetic */ Map access$700(RpcException r0) {
        return r0.mTags;
    }

    static /* synthetic */ Map access$702(RpcException r0, Map r1) {
        r0.mTags = r1;
        return r1;
    }

    static /* synthetic */ String access$800(RpcException r0) {
        return r0.mSource;
    }

    static /* synthetic */ String access$802(RpcException r0, String r1) {
        r0.mSource = r1;
        return r1;
    }

    static /* synthetic */ List access$900() {
        return mConverters;
    }

    static {
        mConverters = new ArrayList();
    }

    public static void addConverter(Converter r1) {
        mConverters.add(r1);
    }

    public static boolean removeConverter(Converter r1) {
        return mConverters.remove(r1);
    }

    private RpcException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public Object getTag(Class<?> r1) {
        Map<Class<?>, Object> r0 = this.mTags;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(r1);
    }

    public int getCode() {
        return this.mCode;
    }

    public long getErrorTime() {
        return this.mErrorTime;
    }

    public String getResource() {
        return this.mSource;
    }

    public boolean isTimeout() {
        int r0 = this.mCode;
        if (r0 != 987654324) goto L6;
        return true;
    L6:
        if (r0 != 987654321) goto L16;
        Throwable r4 = getLastCause();
        if (r4 == null) goto L15;
        if ((r4 instanceof TimeoutException) == false) goto L12;
        return true;
    L12:
        if ((r4 instanceof SocketTimeoutException) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public final Throwable getLastCause() {
        return getFinalCause(getCause());
    }

    public static final Throwable getFinalCause(Throwable r0) {
        return DefaultErrorFormatter.getLastCause(r0);
    }

    public boolean isCanceled() {
        if (this.mCode != 987654323) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHttpError() {
        return this.mHttpProtocolError;
    }

    public boolean isIgnored() {
        if (this.mCode != 987654322) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RpcException{code=" + this.mCode + ", reason=" + getMessage() + ", httpProtocolError=" + this.mHttpProtocolError + ", requestId=" + this.mRequestId + ", errorTime=" + this.mErrorTime + ", source='" + this.mSource + "', cause=" + getLastCause() + ", tags=" + this.mTags + '}';
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    public static Builder from(Throwable r2) {
        return new Builder(r2, null);
    }

    public static Builder fromHttp(int r3, String r4) {
        return new Builder(r3, r4, true, null);
    }

    public static Builder fromNew(int r3, String r4) {
        return new Builder(r3, r4, false, null);
    }

    public static RpcException ignore(String r1, int r2) {
        return fromNew(ErrorCode.IGNORE, r1).setRequestId(r2).build();
    }
}
