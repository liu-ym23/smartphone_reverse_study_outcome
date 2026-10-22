package com.android.contacts.common.vcard;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProcessorBase implements RunnableFuture<Object> {
    public abstract boolean cancel(boolean r1);

    public abstract int getType();

    public abstract boolean isCancelled();

    public abstract boolean isDone();

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public abstract void run();

    public ProcessorBase() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r1, TimeUnit r3) {
        throw new UnsupportedOperationException();
    }
}
