package com.google.common.base;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    protected FinalizableSoftReference(T r2, FinalizableReferenceQueue r3) {
        super(r2, r3.queue);
        r3.cleanUp();
    }
}
