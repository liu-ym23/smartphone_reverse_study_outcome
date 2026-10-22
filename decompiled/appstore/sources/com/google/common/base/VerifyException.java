package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@NullableDecl String r10) {
        super(r10);
    }

    public VerifyException(@NullableDecl Throwable r10) {
        super(r10);
    }

    public VerifyException(@NullableDecl String r10, @NullableDecl Throwable r11) {
        super(r10, r11);
    }
}
