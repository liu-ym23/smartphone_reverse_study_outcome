package M2;

import L2.j;
import i4.InterfaceC0772l;

/* renamed from: M2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0372i implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f4064a;

    public C0372i(j.c cVar) {
        j4.k.g(cVar, "token");
        this.f4064a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.C0(false);
        aVar.S(0.0f);
        aVar.T(false);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(a0 a0Var, j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.C0(a0Var.l());
        aVar.G0(a0Var.t());
        aVar.E0(a0Var.r());
        aVar.D0(a0Var.m());
        aVar.F0(a0Var.s());
        aVar.B0(a0Var.g());
        aVar.t0(a0Var.n());
        aVar.u0(a0Var.o());
        aVar.v0(a0Var.p());
        aVar.w0(a0Var.q());
        aVar.S(a0Var.e());
        aVar.T(a0Var.f());
        aVar.k0(a0Var.j());
        aVar.g0(a0Var.h());
        aVar.h0(a0Var.i());
        aVar.l0(a0Var.k());
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4064a.c(new InterfaceC0772l() { // from class: M2.g
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0372i.d((j.a) obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final a0 a0Var = e6 instanceof a0 ? (a0) e6 : null;
        if (a0Var == null) {
            return;
        }
        this.f4064a.b(new InterfaceC0772l() { // from class: M2.h
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0372i.f(a0Var, (j.a) obj);
            }
        });
    }
}
