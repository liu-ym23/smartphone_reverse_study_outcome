package r3;

import K2.o;
import M2.C0374k;
import M2.C0378o;
import M2.M;
import M2.T;
import M2.a0;
import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.List;

/* renamed from: r3.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1003H {

    /* renamed from: a, reason: collision with root package name */
    public static final C1003H f20004a = new C1003H();

    private C1003H() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K2.A C(final float f5, K2.A a6) {
        j4.k.g(a6, "builder");
        K2.F f6 = K2.F.f3603a;
        return a6.i(f6.b(), new InterfaceC0772l() { // from class: r3.t
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.D((C0378o) obj);
            }
        }).i(f6.f(), new InterfaceC0772l() { // from class: r3.u
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.E((a0) obj);
            }
        }).i(f6.d(), new InterfaceC0772l() { // from class: r3.v
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.F(f5, (M) obj);
            }
        }).i(f6.e(), new InterfaceC0772l() { // from class: r3.w
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.G((T) obj);
            }
        }).i(f6.a(), new InterfaceC0772l() { // from class: r3.x
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.H((C0374k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v D(C0378o c0378o) {
        j4.k.g(c0378o, "$this$apply");
        c0378o.n(30.0f);
        c0378o.o(16777215);
        c0378o.l(0.06f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v E(a0 a0Var) {
        j4.k.g(a0Var, "$this$apply");
        a0Var.J(1.0f);
        a0Var.C(0.18f);
        a0Var.I(4.0f);
        a0Var.H(4.0f);
        a0Var.y(1.0f);
        a0Var.A(1.0f);
        a0Var.v(true);
        a0Var.u(1.0f);
        a0Var.z(866559654);
        a0Var.x(866559654);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        a0Var.D((float) Math.cos(radians));
        a0Var.E((float) Math.sin(radians));
        a0Var.F((float) Math.cos(radians2));
        a0Var.G((float) Math.sin(radians2));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v F(float f5, M m5) {
        j4.k.g(m5, "$this$apply");
        m5.k(855638015);
        m5.p(f5 * 6.0f);
        m5.m(0.15f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v G(T t5) {
        j4.k.g(t5, "$this$apply");
        t5.l(true);
        t5.m(64.0f);
        t5.n(99.0f);
        t5.k(20.0f);
        t5.j(0.2f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v H(C0374k c0374k) {
        j4.k.g(c0374k, "$this$apply");
        c0374k.f(C0403n.b(V3.r.a(0, 731486617)));
        return V3.v.f5542a;
    }

    private final InterfaceC1005a I(K2.o oVar, float f5, float f6, List<V3.m<Integer, Integer>> list, Integer num, Integer num2, Float f7) {
        final C0378o c0378oD = oVar.D(f5);
        final a0 a0VarG = oVar.G(f5);
        final M mE = oVar.E(f5);
        final T tF = oVar.F(f5);
        final C0374k c0374kC = oVar.C(f5);
        mE.m(mE.g() * f6);
        if (f7 != null) {
            tF.m(f7.floatValue());
        }
        if (num != null) {
            a0VarG.z(num.intValue());
        }
        if (num2 != null) {
            a0VarG.x(num2.intValue());
        }
        if (list != null) {
            c0374kC.f(list);
        }
        return new InterfaceC1005a() { // from class: r3.p
            @Override // r3.InterfaceC1005a
            public final K2.A a(K2.A a6) {
                return C1003H.K(c0378oD, a0VarG, mE, tF, c0374kC, a6);
            }
        };
    }

    static /* synthetic */ InterfaceC1005a J(C1003H c1003h, K2.o oVar, float f5, float f6, List list, Integer num, Integer num2, Float f7, int i5, Object obj) {
        Float f8;
        C1003H c1003h2;
        K2.o oVar2;
        float f9;
        if ((i5 & 4) != 0) {
            f6 = 1.0f;
        }
        float f10 = f6;
        List list2 = (i5 & 8) != 0 ? null : list;
        Integer num3 = (i5 & 16) != 0 ? null : num;
        Integer num4 = (i5 & 32) != 0 ? null : num2;
        if ((i5 & 64) != 0) {
            f8 = null;
            oVar2 = oVar;
            f9 = f5;
            c1003h2 = c1003h;
        } else {
            f8 = f7;
            c1003h2 = c1003h;
            oVar2 = oVar;
            f9 = f5;
        }
        return c1003h2.I(oVar2, f9, f10, list2, num3, num4, f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K2.A K(final C0378o c0378o, final a0 a0Var, final M m5, final T t5, final C0374k c0374k, K2.A a6) {
        j4.k.g(a6, "builder");
        K2.F f5 = K2.F.f3603a;
        return a6.i(f5.b(), new InterfaceC0772l() { // from class: r3.A
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.L(c0378o, (C0378o) obj);
            }
        }).i(f5.f(), new InterfaceC0772l() { // from class: r3.B
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.M(a0Var, (a0) obj);
            }
        }).i(f5.d(), new InterfaceC0772l() { // from class: r3.C
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.N(m5, (M) obj);
            }
        }).i(f5.e(), new InterfaceC0772l() { // from class: r3.D
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.O(t5, (T) obj);
            }
        }).i(f5.a(), new InterfaceC0772l() { // from class: r3.E
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.P(c0374k, (C0374k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v L(C0378o c0378o, C0378o c0378o2) {
        j4.k.g(c0378o2, "$this$apply");
        C1004I.e(c0378o2, c0378o);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v M(a0 a0Var, a0 a0Var2) {
        j4.k.g(a0Var2, "$this$apply");
        C1004I.h(a0Var2, a0Var);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v N(M m5, M m6) {
        j4.k.g(m6, "$this$apply");
        C1004I.f(m6, m5);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v O(T t5, T t6) {
        j4.k.g(t6, "$this$apply");
        C1004I.g(t6, t5);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v P(C0374k c0374k, C0374k c0374k2) {
        j4.k.g(c0374k2, "$this$apply");
        c0374k2.f(c0374k.e());
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K2.A t(final float f5, K2.A a6) {
        j4.k.g(a6, "builder");
        K2.F f6 = K2.F.f3603a;
        return a6.i(f6.b(), new InterfaceC0772l() { // from class: r3.F
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.u((C0378o) obj);
            }
        }).i(f6.f(), new InterfaceC0772l() { // from class: r3.G
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.v((a0) obj);
            }
        }).i(f6.d(), new InterfaceC0772l() { // from class: r3.q
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.w(f5, (M) obj);
            }
        }).i(f6.e(), new InterfaceC0772l() { // from class: r3.r
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.x((T) obj);
            }
        }).i(f6.a(), new InterfaceC0772l() { // from class: r3.s
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1003H.y((C0374k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v u(C0378o c0378o) {
        j4.k.g(c0378o, "$this$apply");
        c0378o.n(30.0f);
        c0378o.o(16777215);
        c0378o.l(0.06f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v v(a0 a0Var) {
        j4.k.g(a0Var, "$this$apply");
        a0Var.J(1.0f);
        a0Var.C(0.18f);
        a0Var.I(4.0f);
        a0Var.H(4.0f);
        a0Var.y(1.0f);
        a0Var.A(1.0f);
        a0Var.v(true);
        a0Var.u(1.0f);
        a0Var.z(-2136562010);
        a0Var.x(866559654);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        a0Var.D((float) Math.cos(radians));
        a0Var.E((float) Math.sin(radians));
        a0Var.F((float) Math.cos(radians2));
        a0Var.G((float) Math.sin(radians2));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v w(float f5, M m5) {
        j4.k.g(m5, "$this$apply");
        m5.k(855638015);
        m5.p(f5 * 6.0f);
        m5.m(0.15f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v x(T t5) {
        j4.k.g(t5, "$this$apply");
        t5.l(true);
        t5.m(64.0f);
        t5.n(99.0f);
        t5.k(20.0f);
        t5.j(0.2f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v y(C0374k c0374k) {
        j4.k.g(c0374k, "$this$apply");
        c0374k.f(C0403n.b(V3.r.a(0, 731486617)));
        return V3.v.f5542a;
    }

    public final InterfaceC1005a A(float f5) {
        return J(this, K2.o.f3626h.k(), f5, 0.5f, null, null, null, Float.valueOf(30.0f), 56, null);
    }

    public final InterfaceC1005a B(final float f5) {
        return new InterfaceC1005a() { // from class: r3.z
            @Override // r3.InterfaceC1005a
            public final K2.A a(K2.A a6) {
                return C1003H.C(f5, a6);
            }
        };
    }

    public final InterfaceC1005a Q(K2.o oVar, float f5) {
        j4.k.g(oVar, "effect");
        o.a aVar = K2.o.f3626h;
        if (j4.k.b(oVar, aVar.k())) {
            return A(f5);
        }
        if (j4.k.b(oVar, aVar.i())) {
            return z(f5);
        }
        return null;
    }

    public final InterfaceC1005a s(final float f5) {
        return new InterfaceC1005a() { // from class: r3.y
            @Override // r3.InterfaceC1005a
            public final K2.A a(K2.A a6) {
                return C1003H.t(f5, a6);
            }
        };
    }

    public final InterfaceC1005a z(float f5) {
        return J(this, K2.o.f3626h.i(), f5, 0.0f, null, null, null, Float.valueOf(30.0f), 60, null);
    }
}
