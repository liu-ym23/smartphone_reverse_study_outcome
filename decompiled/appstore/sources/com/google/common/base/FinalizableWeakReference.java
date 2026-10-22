package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(T r10, FinalizableReferenceQueue r11) {
        super(r10, r11.queue);
        r11.cleanUp();
    }
}
