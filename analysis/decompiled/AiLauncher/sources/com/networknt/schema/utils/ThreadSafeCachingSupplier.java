package com.networknt.schema.utils;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class ThreadSafeCachingSupplier<T> implements Supplier<T> {
    private volatile T cache = null;
    private volatile Supplier<T> delegate;

    public ThreadSafeCachingSupplier(Supplier<T> supplier) {
        this.delegate = supplier;
    }

    @Override // java.util.function.Supplier
    public T get() {
        if (this.delegate == null) {
            return this.cache;
        }
        synchronized (this) {
            try {
                if (this.delegate != null) {
                    this.cache = this.delegate.get();
                    this.delegate = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.cache;
    }
}
