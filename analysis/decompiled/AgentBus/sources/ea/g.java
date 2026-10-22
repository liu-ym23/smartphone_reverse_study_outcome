package ea;

import g0.l;
import g0.n;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class g implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3235f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3236g;

    public g(Object[] objArr) {
        q7.k.e(objArr, "array");
        this.f3236g = q7.k.h(objArr);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3235f) {
            case 0:
                return ((d7.c) this.f3236g).hasNext();
            default:
                return ((g0.e) this.f3236g).f3677h;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3235f) {
            case 0:
                return ((d7.c) this.f3236g).next();
            default:
                return (Map.Entry) ((g0.e) this.f3236g).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3235f) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                ((g0.e) this.f3236g).remove();
                return;
        }
    }

    public g(j0.g gVar) {
        l[] lVarArr = new l[8];
        for (int i2 = 0; i2 < 8; i2++) {
            lVarArr[i2] = new n(this);
        }
        this.f3236g = new g0.e(gVar, lVarArr);
    }
}
