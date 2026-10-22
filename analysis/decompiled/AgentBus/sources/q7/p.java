package q7;

/* loaded from: classes.dex */
public final class p extends q implements w7.s {
    public p(w7.f fVar, String str, String str2) {
        super(!(fVar instanceof w7.d) ? 1 : 0, ((d) fVar).c(), b.f8796f, str, str2);
    }

    @Override // w7.s
    public final Object get(Object obj) {
        return ((z7.s) b()).h(obj);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return get(obj);
    }

    @Override // q7.c
    public final w7.c x() {
        return w.f8821a.f(this);
    }

    @Override // w7.t
    public final w7.r b() {
        return ((w7.s) z()).b();
    }
}
