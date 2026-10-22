package com.google.common.base;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    protected FinalizableWeakReference(T r2, FinalizableReferenceQueue r3) {
        super(r2, r3.queue);
        r3.cleanUp();
    }
}
