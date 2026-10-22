package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QuicException extends NetworkException {
    public abstract int getQuicDetailedErrorCode();

    protected QuicException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
