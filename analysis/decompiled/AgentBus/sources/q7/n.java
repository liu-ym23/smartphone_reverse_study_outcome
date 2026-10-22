package q7;

import java.util.Objects;

/* loaded from: classes.dex */
public final class n extends q implements w7.j, w7.k {
    public n(w7.d dVar, String str, String str2) {
        super(!Objects.nonNull(dVar) ? 1 : 0, ((d) dVar).c(), b.f8796f, str, str2);
    }

    @Override // w7.j
    public final void e(Object obj, Object obj2) {
        ((z7.s) g()).h(obj, obj2);
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
        return w.f8821a.d(this);
    }

    @Override // w7.t
    public final w7.r b() {
        return ((w7.j) z()).b();
    }

    @Override // w7.k
    public final w7.i g() {
        return ((w7.j) z()).g();
    }

    public n(String str, String str2) {
        super(1, p1.u.class, b.f8796f, str, str2);
    }
}
