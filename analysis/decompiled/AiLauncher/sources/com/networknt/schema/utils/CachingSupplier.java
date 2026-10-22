package com.networknt.schema.utils;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class CachingSupplier<T> implements Supplier<T> {
    private T cache = null;
    private Supplier<T> delegate;

    public CachingSupplier(Supplier<T> supplier) {
        this.delegate = supplier;
    }

    @Override // java.util.function.Supplier
    public T get() {
        Supplier<T> supplier;
        if (this.cache == null && (supplier = this.delegate) != null) {
            this.cache = supplier.get();
            this.delegate = null;
        }
        return this.cache;
    }
}
