package d7;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d0 implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2954f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Iterator f2955g;

    /* renamed from: h, reason: collision with root package name */
    public int f2956h;

    public d0(Iterator it) {
        q7.k.e(it, "iterator");
        this.f2955g = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f2954f) {
            case 0:
                return this.f2955g.hasNext();
        }
        while (true) {
            int i2 = this.f2956h;
            it = this.f2955g;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.f2956h--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f2954f) {
            case 0:
                int i2 = this.f2956h;
                this.f2956h = i2 + 1;
                if (i2 >= 0) {
                    return new c0(i2, this.f2955g.next());
                }
                s.z0();
                throw null;
        }
        while (true) {
            int i10 = this.f2956h;
            it = this.f2955g;
            if (i10 > 0 && it.hasNext()) {
                it.next();
                this.f2956h--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f2954f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d0(fa.b bVar) {
        this.f2955g = bVar.f3615a.iterator();
        this.f2956h = bVar.f3616b;
    }
}
