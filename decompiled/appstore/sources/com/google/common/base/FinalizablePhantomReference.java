package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    public FinalizablePhantomReference(T r10, FinalizableReferenceQueue r11) {
        super(r10, r11.queue);
        r11.cleanUp();
    }
}
