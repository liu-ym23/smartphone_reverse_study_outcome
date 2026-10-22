package com.ttnet.org.chromium.net.impl;

/* JADX INFO: compiled from: BidirectionalStreamNetworkException.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends NetworkExceptionImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38076a = true;

    static {
    }

    public a(String r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.o
    public boolean immediatelyRetryable() {
        int r0 = this.mCronetInternalErrorCode;
        if (r0 == (-358)) goto L9;
        if (r0 == (-352)) goto L9;
        return super.immediatelyRetryable();
    L9:
        if (f38076a == false) goto L11;
        return true;
    L11:
        if (this.mErrorCode != 11) goto L14;
        return true;
    L14:
        throw new AssertionError();
    }
}
