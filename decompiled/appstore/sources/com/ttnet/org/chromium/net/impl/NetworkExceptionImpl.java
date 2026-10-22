package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkException;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18727a = 0;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    static {
    }

    public NetworkExceptionImpl(String r10, int r11, int r12) {
        super(r10, null);
        this.mErrorCode = r11;
        this.mCronetInternalErrorCode = r12;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r10 = new StringBuilder(super.getMessage());
        r10.append(", ErrorCode=");
        r10.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode == 0) goto L5;
        r10.append(", InternalErrorCode=");
        r10.append(this.mCronetInternalErrorCode);
    L5:
        r10.append(", Retryable=");
        r10.append(immediatelyRetryable());
        return r10.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r10 = this.mErrorCode;
        if (r10 != 3) goto L5;
        return true;
    L5:
        if (r10 != 4) goto L7;
        return true;
    L7:
        if (r10 != 5) goto L9;
        return true;
    L9:
        if (r10 != 6) goto L11;
        return true;
    L11:
        if (r10 == 8) goto L19;
        return false;
    L19:
        return true;
    }
}
