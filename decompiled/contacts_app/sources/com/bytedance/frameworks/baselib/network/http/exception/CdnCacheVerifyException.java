package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CdnCacheVerifyException extends IOException {
    public CdnCacheVerifyException() {
    }

    public CdnCacheVerifyException(String r1) {
        super(r1);
    }

    public CdnCacheVerifyException(Throwable r1) {
        initCause(r1);
    }

    public CdnCacheVerifyException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
