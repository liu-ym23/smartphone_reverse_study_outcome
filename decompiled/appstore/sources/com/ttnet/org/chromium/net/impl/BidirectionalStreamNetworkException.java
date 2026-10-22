package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public BidirectionalStreamNetworkException(String r10, int r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r10 = this.mCronetInternalErrorCode;
        if (r10 != (-358)) goto L5;
        return true;
    L5:
        if (r10 != (-352)) goto L7;
        return true;
    L7:
        return super.immediatelyRetryable();
    }
}
