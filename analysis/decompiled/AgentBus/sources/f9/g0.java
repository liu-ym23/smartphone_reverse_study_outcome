package f9;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class g0 implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public Iterator f3558f;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3558f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f3558f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
