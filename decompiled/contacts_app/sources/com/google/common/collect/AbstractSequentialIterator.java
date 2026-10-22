package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T nextOrNull;

    protected abstract T computeNext(T r1);

    protected AbstractSequentialIterator(@Nullable T r1) {
        this.nextOrNull = r1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextOrNull == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext() == false) goto L11;
        T r0 = this.nextOrNull;     // Catch: Throwable -> L7
        this.nextOrNull = computeNext(r0);
        return r0;
    L7:
        th = move-exception;
        this.nextOrNull = computeNext(this.nextOrNull);
        throw th;
    L11:
        throw new NoSuchElementException();
    }
}
