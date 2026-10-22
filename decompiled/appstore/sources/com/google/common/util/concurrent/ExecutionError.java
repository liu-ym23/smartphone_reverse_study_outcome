package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(@NullableDecl String r10) {
        super(r10);
    }

    public ExecutionError(@NullableDecl String r10, @NullableDecl Error r11) {
        super(r10, r11);
    }

    public ExecutionError(@NullableDecl Error r10) {
        super(r10);
    }
}
