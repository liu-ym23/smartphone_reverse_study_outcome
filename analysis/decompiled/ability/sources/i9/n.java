package i9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class n implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f4626a;
    public final /* synthetic */ o b;

    public n(o oVar) {
        this.b = oVar;
        this.f4626a = oVar.f4627a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4626a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.b.b.invoke(this.f4626a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
