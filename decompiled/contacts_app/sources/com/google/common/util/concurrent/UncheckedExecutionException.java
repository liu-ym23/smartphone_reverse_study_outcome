package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    protected UncheckedExecutionException(@Nullable String r1) {
        super(r1);
    }

    public UncheckedExecutionException(@Nullable String r1, @Nullable Throwable r2) {
        super(r1, r2);
    }

    public UncheckedExecutionException(@Nullable Throwable r1) {
        super(r1);
    }
}
