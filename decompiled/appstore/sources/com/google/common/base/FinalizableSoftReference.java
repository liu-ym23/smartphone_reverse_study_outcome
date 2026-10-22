package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    public FinalizableSoftReference(T r10, FinalizableReferenceQueue r11) {
        super(r10, r11.queue);
        r11.cleanUp();
    }
}
