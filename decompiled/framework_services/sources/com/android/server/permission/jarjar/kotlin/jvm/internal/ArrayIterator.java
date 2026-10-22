package com.android.server.permission.jarjar.kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int index;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ArrayIterator(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        this.array = r2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        T[] r0 = this.array;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r1 = this.index;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.index = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r0[r1];
    L4:
        e = move-exception;
        this.index--;
        throw new NoSuchElementException(e.getMessage());
    }
}
