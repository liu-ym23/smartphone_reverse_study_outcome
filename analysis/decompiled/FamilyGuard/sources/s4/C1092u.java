package s4;

import a4.C0428b;

/* renamed from: s4.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1092u<T> extends u0 implements InterfaceC1091t<T> {
    public C1092u(n0 n0Var) {
        super(true);
        g0(n0Var);
    }

    @Override // s4.InterfaceC1091t
    public boolean L(Throwable th) {
        return l0(new C1096y(th, false, 2, null));
    }

    @Override // s4.InterfaceC1091t
    public boolean O(T t5) {
        return l0(t5);
    }

    @Override // s4.P
    public Object T(Z3.e<? super T> eVar) throws Throwable {
        Object objN = n(eVar);
        C0428b.e();
        return objN;
    }

    @Override // s4.u0
    public boolean Y() {
        return true;
    }
}
