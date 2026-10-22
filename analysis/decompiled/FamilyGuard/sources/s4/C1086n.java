package s4;

import x4.C1310j;

/* renamed from: s4.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1086n {
    public static final void a(InterfaceC1080k<?> interfaceC1080k, X x5) {
        c(interfaceC1080k, new Y(x5));
    }

    public static final <T> C1082l<T> b(Z3.e<? super T> eVar) {
        if (!(eVar instanceof C1310j)) {
            return new C1082l<>(eVar, 1);
        }
        C1082l<T> c1082lN = ((C1310j) eVar).n();
        if (c1082lN != null) {
            if (!c1082lN.N()) {
                c1082lN = null;
            }
            if (c1082lN != null) {
                return c1082lN;
            }
        }
        return new C1082l<>(eVar, 2);
    }

    public static final <T> void c(InterfaceC1080k<? super T> interfaceC1080k, InterfaceC1078j interfaceC1078j) {
        if (!(interfaceC1080k instanceof C1082l)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((C1082l) interfaceC1080k).G(interfaceC1078j);
    }
}
