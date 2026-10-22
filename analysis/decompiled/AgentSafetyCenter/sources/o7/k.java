package o7;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public m f9259c;

    /* renamed from: f, reason: collision with root package name */
    public m f9260f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f9261g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f9262h;
    public final /* synthetic */ int i;

    public k(n nVar, int i) {
        this.i = i;
        this.f9262h = nVar;
        this.f9259c = nVar.f9278j.f9268h;
        this.f9261g = nVar.i;
    }

    public final Object a() {
        return b();
    }

    public final m b() {
        m mVar = this.f9259c;
        n nVar = this.f9262h;
        if (mVar == nVar.f9278j) {
            g5.f.k();
            return null;
        }
        if (nVar.i != this.f9261g) {
            throw new ConcurrentModificationException();
        }
        this.f9259c = mVar.f9268h;
        this.f9260f = mVar;
        return mVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9259c != this.f9262h.f9278j;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.i) {
            case 1:
                return b().f9269j;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        m mVar = this.f9260f;
        if (mVar == null) {
            throw new IllegalStateException();
        }
        n nVar = this.f9262h;
        nVar.c(mVar, true);
        this.f9260f = null;
        this.f9261g = nVar.i;
    }
}
