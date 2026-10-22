package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @NullableDecl
    private T nextOrNull;

    public AbstractSequentialIterator(@NullableDecl T r10) {
        this.nextOrNull = r10;
    }

    @NullableDecl
    public abstract T computeNext(T r10);

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
        T r10 = this.nextOrNull;     // Catch: Throwable -> L7
        this.nextOrNull = computeNext(r10);
        return r10;
    L7:
        th = move-exception;
        this.nextOrNull = computeNext(this.nextOrNull);
        throw th;
    L11:
        throw new NoSuchElementException();
    }
}
