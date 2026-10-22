package H8;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class F implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f765a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f765a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f765a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
