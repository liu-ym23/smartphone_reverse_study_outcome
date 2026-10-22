package d.h.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes4.dex */
final class b<T> implements d.h.b.a.a, Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[] f38486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38487b;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public b(T[] r2) {
        o.e(r2, "array");
        this.f38486a = r2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f38487b >= this.f38486a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        T[] r0 = this.f38486a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r1 = this.f38487b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f38487b = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r0[r1];
    L4:
        e = move-exception;
        this.f38487b--;
        throw new NoSuchElementException(e.getMessage());
    }
}
