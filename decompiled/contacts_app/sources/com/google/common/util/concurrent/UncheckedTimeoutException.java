package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@Nullable String r1) {
        super(r1);
    }

    public UncheckedTimeoutException(@Nullable Throwable r1) {
        super(r1);
    }

    public UncheckedTimeoutException(@Nullable String r1, @Nullable Throwable r2) {
        super(r1, r2);
    }
}
