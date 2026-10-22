package fa;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class o implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final Iterator f3640f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p f3641g;

    public o(p pVar) {
        this.f3641g = pVar;
        this.f3640f = pVar.f3642a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3640f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f3641g.f3643b.invoke(this.f3640f.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
