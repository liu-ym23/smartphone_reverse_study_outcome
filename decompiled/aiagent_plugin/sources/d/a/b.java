package d.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T> implements d.h.b.a.a, Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f38367b;

    public abstract void a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public b() {
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int r0 = this.f38366a;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    L11:
        return c();
    }

    @Override // java.util.Iterator
    public T next() {
        int r0 = this.f38366a;
        if (r0 != 1) goto L7;
        this.f38366a = 0;
        return this.f38367b;
    L7:
        if (r0 == 2) goto L13;
        if (c() == false) goto L13;
        this.f38366a = 0;
        return this.f38367b;
    L13:
        throw new NoSuchElementException();
    }

    private final boolean c() {
        this.f38366a = 3;
        a();
        if (this.f38366a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a(T r1) {
        this.f38367b = r1;
        this.f38366a = 1;
    }

    public final void b() {
        this.f38366a = 2;
    }
}
