package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@NullableDecl String r10) {
        super(r10);
    }

    public UncheckedExecutionException(@NullableDecl String r10, @NullableDecl Throwable r11) {
        super(r10, r11);
    }

    public UncheckedExecutionException(@NullableDecl Throwable r10) {
        super(r10);
    }
}
