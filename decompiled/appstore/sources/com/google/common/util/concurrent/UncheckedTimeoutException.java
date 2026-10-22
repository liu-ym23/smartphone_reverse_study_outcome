package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@NullableDecl String r10) {
        super(r10);
    }

    public UncheckedTimeoutException(@NullableDecl Throwable r10) {
        super(r10);
    }

    public UncheckedTimeoutException(@NullableDecl String r10, @NullableDecl Throwable r11) {
        super(r10, r11);
    }
}
