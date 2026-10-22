package g9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class g implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final C7.i f4505a;

    public g(Object[] array) {
        kotlin.jvm.internal.k.f(array, "array");
        this.f4505a = kotlin.jvm.internal.k.j(array);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4505a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f4505a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
