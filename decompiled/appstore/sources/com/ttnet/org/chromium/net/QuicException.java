package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QuicException extends NetworkException {
    public QuicException(String r10, Throwable r11) {
        super(r10, r11);
    }

    public abstract int getQuicDetailedErrorCode();
}
