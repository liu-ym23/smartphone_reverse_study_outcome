package M2;

import L2.e;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class Y implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4037a;

    public Y(e.c cVar) {
        j4.k.g(cVar, "token");
        this.f4037a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        Class<?>[] clsArr = {eVar.j(), eVar.k(), eVar.k(), eVar.k(), eVar.l()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        eVar.g(obj, "setGlassStroke", clsArr, bool, fValueOf, fValueOf, fValueOf, 0);
        eVar.g(obj, "setAmbient", new Class[]{eVar.k()}, fValueOf);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(a0 a0Var, Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        eVar.g(obj, "setGlassStroke", new Class[]{eVar.j(), eVar.k(), eVar.k(), eVar.k(), eVar.l()}, Boolean.valueOf(a0Var.l()), Float.valueOf(a0Var.t()), Float.valueOf(a0Var.r()), Float.valueOf(a0Var.m()), Integer.valueOf(a0Var.g()));
        eVar.g(obj, "setStrokeSpread", new Class[]{eVar.k()}, Float.valueOf(a0Var.s()));
        eVar.g(obj, "setLightDirs", new Class[]{eVar.k(), eVar.k(), eVar.k(), eVar.k()}, Float.valueOf(a0Var.n()), Float.valueOf(a0Var.o()), Float.valueOf(a0Var.p()), Float.valueOf(a0Var.q()));
        eVar.g(obj, "setAmbient", new Class[]{eVar.k()}, Float.valueOf(a0Var.e()));
        eVar.g(obj, "setAnisoRim", new Class[]{eVar.j()}, Boolean.valueOf(a0Var.f()));
        eVar.g(obj, "setEdgeColors", new Class[]{eVar.l(), eVar.l()}, Integer.valueOf(a0Var.j()), Integer.valueOf(a0Var.h()));
        eVar.g(obj, "setDarkWidth", new Class[]{eVar.k()}, Float.valueOf(a0Var.i()));
        eVar.g(obj, "setEdgeWidth", new Class[]{eVar.k()}, Float.valueOf(a0Var.k()));
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4037a.c(new InterfaceC0772l() { // from class: M2.W
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return Y.d(obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final a0 a0Var = e6 instanceof a0 ? (a0) e6 : null;
        if (a0Var == null) {
            return;
        }
        this.f4037a.b(new InterfaceC0772l() { // from class: M2.X
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return Y.f(a0Var, obj);
            }
        });
    }
}
