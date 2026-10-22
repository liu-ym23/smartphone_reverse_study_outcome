package d9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: d9.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1389j implements Iterator, T7.a {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
