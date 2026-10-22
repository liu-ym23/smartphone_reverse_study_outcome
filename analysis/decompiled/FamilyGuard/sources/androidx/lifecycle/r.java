package androidx.lifecycle;

import s4.F0;

/* loaded from: classes.dex */
public final class r {
    public static final AbstractC0534n a(AbstractC0533m abstractC0533m) {
        C0535o c0535o;
        j4.k.g(abstractC0533m, "<this>");
        do {
            C0535o c0535o2 = (C0535o) abstractC0533m.c().get();
            if (c0535o2 != null) {
                return c0535o2;
            }
            c0535o = new C0535o(abstractC0533m, F0.b(null, 1, null).C(s4.W.c().h0()));
        } while (!abstractC0533m.c().compareAndSet(null, c0535o));
        c0535o.d();
        return c0535o;
    }
}
