package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Atomics {
    private Atomics() {
    }

    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference();
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(int r10) {
        return new AtomicReferenceArray(r10);
    }

    public static <V> AtomicReference<V> newReference(@NullableDecl V r10) {
        return new AtomicReference(r10);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] r10) {
        return new AtomicReferenceArray(r10);
    }
}
