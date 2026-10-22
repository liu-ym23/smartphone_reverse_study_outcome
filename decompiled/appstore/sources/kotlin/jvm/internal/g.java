package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f21168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21169b;

    public g(Object[] r10) {
        q.g(r10, "array");
        this.f21168a = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21169b >= this.f21168a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object[] r10 = this.f21168a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.f21169b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f21169b = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.f21169b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
