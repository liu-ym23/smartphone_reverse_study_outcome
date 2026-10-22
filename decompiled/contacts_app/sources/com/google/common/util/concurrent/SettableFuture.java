package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(@Nullable V r1) {
        return super.set(r1);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable r1) {
        return super.setException(r1);
    }
}
