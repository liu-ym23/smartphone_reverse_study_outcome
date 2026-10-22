package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    protected ExecutionError() {
    }

    protected ExecutionError(@Nullable String r1) {
        super(r1);
    }

    public ExecutionError(@Nullable String r1, @Nullable Error r2) {
        super(r1, r2);
    }

    public ExecutionError(@Nullable Error r1) {
        super(r1);
    }
}
