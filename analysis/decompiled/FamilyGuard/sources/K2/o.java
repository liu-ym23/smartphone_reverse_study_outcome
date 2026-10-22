package K2;

import K2.o;
import M2.C0374k;
import M2.C0378o;
import M2.M;
import M2.T;
import M2.a0;
import W3.C0403n;
import java.util.List;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3626h;

    /* renamed from: i, reason: collision with root package name */
    private static final o f3627i;

    /* renamed from: j, reason: collision with root package name */
    private static final o f3628j;

    /* renamed from: k, reason: collision with root package name */
    private static final o f3629k;

    /* renamed from: l, reason: collision with root package name */
    private static final o f3630l;

    /* renamed from: m, reason: collision with root package name */
    private static final o f3631m;

    /* renamed from: n, reason: collision with root package name */
    private static final o f3632n;

    /* renamed from: o, reason: collision with root package name */
    private static final o f3633o;

    /* renamed from: p, reason: collision with root package name */
    private static final o f3634p;

    /* renamed from: q, reason: collision with root package name */
    private static final o f3635q;

    /* renamed from: a, reason: collision with root package name */
    private final float f3636a;

    /* renamed from: b, reason: collision with root package name */
    private final i4.p<C0378o, Float, V3.v> f3637b;

    /* renamed from: c, reason: collision with root package name */
    private final i4.p<a0, Float, V3.v> f3638c;

    /* renamed from: d, reason: collision with root package name */
    private final i4.p<M, Float, V3.v> f3639d;

    /* renamed from: e, reason: collision with root package name */
    private final i4.p<T, Float, V3.v> f3640e;

    /* renamed from: f, reason: collision with root package name */
    private final i4.p<C0374k, Float, V3.v> f3641f;

    /* renamed from: g, reason: collision with root package name */
    private final i4.p<M2.A, Float, V3.v> f3642g;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final o l(final float f5, final float f6, final float f7, final float f8, final int i5, final List<V3.m<Integer, Integer>> list) {
            return new o(24.0f, new i4.p() { // from class: K2.j
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return o.a.m(f5, (C0378o) obj, ((Float) obj2).floatValue());
                }
            }, new i4.p() { // from class: K2.k
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return o.a.n(f6, (a0) obj, ((Float) obj2).floatValue());
                }
            }, new i4.p() { // from class: K2.l
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return o.a.o(i5, f7, f8, (M) obj, ((Float) obj2).floatValue());
                }
            }, new i4.p() { // from class: K2.m
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return o.a.p((T) obj, ((Float) obj2).floatValue());
                }
            }, new i4.p() { // from class: K2.n
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return o.a.q(list, (C0374k) obj, ((Float) obj2).floatValue());
                }
            }, null, 64, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V3.v m(float f5, C0378o c0378o, float f6) {
            j4.k.g(c0378o, "$this$GlassEffect");
            c0378o.n(f5);
            c0378o.o(16777215);
            c0378o.l(0.0f);
            return V3.v.f5542a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V3.v n(float f5, a0 a0Var, float f6) {
            j4.k.g(a0Var, "$this$GlassEffect");
            a0Var.J(0.0f);
            a0Var.H(4.0f);
            a0Var.C(f5);
            a0Var.I(4.0f);
            double radians = Math.toRadians(270.0d);
            double radians2 = Math.toRadians(45.0d);
            a0Var.D((float) Math.cos(radians));
            a0Var.E((float) Math.sin(radians));
            a0Var.F((float) Math.cos(radians2));
            a0Var.G((float) Math.sin(radians2));
            a0Var.u(1.0f);
            a0Var.v(true);
            a0Var.z(p.b(13421772, 20));
            a0Var.x(p.b(13684944, 20));
            return V3.v.f5542a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V3.v o(int i5, float f5, float f6, M m5, float f7) {
            j4.k.g(m5, "$this$GlassEffect");
            m5.l(true);
            m5.k(p.b(16777215, i5));
            m5.p(f5 * f7);
            m5.m(f6);
            return V3.v.f5542a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V3.v p(T t5, float f5) {
            j4.k.g(t5, "$this$GlassEffect");
            t5.l(true);
            t5.m(45.0f);
            t5.n(130.0f);
            t5.k(3.0f);
            t5.j(0.2f);
            return V3.v.f5542a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V3.v q(List list, C0374k c0374k, float f5) {
            j4.k.g(c0374k, "$this$GlassEffect");
            c0374k.f(list);
            return V3.v.f5542a;
        }

        public final o g() {
            return o.f3627i;
        }

        public final o h() {
            return o.f3635q;
        }

        public final o i() {
            return o.f3633o;
        }

        public final o j() {
            return o.f3632n;
        }

        public final o k() {
            return o.f3630l;
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        f3626h = aVar;
        f3627i = aVar.l(18.0f, 0.35f, 22.0f, 0.6f, 15, C0403n.k(V3.r.a(4, Integer.valueOf(p.b(16777215, 4))), V3.r.a(1, Integer.valueOf(p.b(1052688, 100)))));
        f3628j = aVar.l(150.0f, 0.35f, 22.0f, 0.8f, 15, C0403n.k(V3.r.a(4, Integer.valueOf(p.b(16777215, 6))), V3.r.a(1, Integer.valueOf(p.b(1052688, 100))), V3.r.a(0, Integer.valueOf(p.b(0, 50)))));
        f3629k = new o(0.0f, new i4.p() { // from class: K2.b
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.m((C0378o) obj, ((Float) obj2).floatValue());
            }
        }, new i4.p() { // from class: K2.c
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.n((a0) obj, ((Float) obj2).floatValue());
            }
        }, new i4.p() { // from class: K2.d
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.i((M) obj, ((Float) obj2).floatValue());
            }
        }, new i4.p() { // from class: K2.e
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.j((T) obj, ((Float) obj2).floatValue());
            }
        }, new i4.p() { // from class: K2.f
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.k((C0374k) obj, ((Float) obj2).floatValue());
            }
        }, new i4.p() { // from class: K2.g
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.l((M2.A) obj, ((Float) obj2).floatValue());
            }
        });
        f3630l = aVar.l(18.0f, 0.4f, 22.0f, 0.6f, 15, C0403n.k(V3.r.a(4, Integer.valueOf(p.b(16777215, 50))), V3.r.a(0, Integer.valueOf(p.b(0, 4)))));
        f3631m = aVar.l(18.0f, 0.4f, 22.0f, 0.6f, 15, C0403n.k(V3.r.a(4, Integer.valueOf(p.b(16777215, 50))), V3.r.a(0, Integer.valueOf(p.b(0, 4)))));
        f3632n = aVar.l(150.0f, 0.4f, 22.0f, 0.6f, 15, C0403n.k(V3.r.a(4, Integer.valueOf(p.b(16777215, 70))), V3.r.a(0, Integer.valueOf(p.b(0, 4)))));
        f3633o = aVar.l(18.0f, 0.27f, 22.0f, 0.6f, 10, C0403n.k(V3.r.a(1, Integer.valueOf(p.b(16777215, 4))), V3.r.a(0, Integer.valueOf(p.b(0, 5)))));
        f3634p = aVar.l(90.0f, 0.27f, 22.0f, 0.6f, 10, C0403n.k(V3.r.a(1, Integer.valueOf(p.b(16777215, 4))), V3.r.a(0, Integer.valueOf(p.b(0, 5)))));
        f3635q = aVar.l(90.0f, 0.27f, 22.0f, 0.6f, 10, C0403n.k(V3.r.a(3, Integer.valueOf(p.b(5066061, 100))), V3.r.a(4, Integer.valueOf(p.b(2236962, 70)))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(float f5, i4.p<? super C0378o, ? super Float, V3.v> pVar, i4.p<? super a0, ? super Float, V3.v> pVar2, i4.p<? super M, ? super Float, V3.v> pVar3, i4.p<? super T, ? super Float, V3.v> pVar4, i4.p<? super C0374k, ? super Float, V3.v> pVar5, i4.p<? super M2.A, ? super Float, V3.v> pVar6) {
        j4.k.g(pVar, "blur");
        j4.k.g(pVar2, "stroke");
        j4.k.g(pVar3, "innerShadow");
        j4.k.g(pVar4, "refraction");
        j4.k.g(pVar5, "blend");
        j4.k.g(pVar6, "glassText");
        this.f3636a = f5;
        this.f3637b = pVar;
        this.f3638c = pVar2;
        this.f3639d = pVar3;
        this.f3640e = pVar4;
        this.f3641f = pVar5;
        this.f3642g = pVar6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v i(M m5, float f5) {
        j4.k.g(m5, "$this$GlassEffect");
        m5.k(-16777216);
        m5.p(f5 * 9.0f);
        m5.m(0.6f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v j(T t5, float f5) {
        j4.k.g(t5, "$this$GlassEffect");
        t5.l(true);
        t5.m(8.0f);
        t5.n(14.0f);
        t5.k(0.0f);
        t5.j(0.0f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v k(C0374k c0374k, float f5) {
        j4.k.g(c0374k, "$this$GlassEffect");
        c0374k.f(C0403n.k(V3.r.a(8, -1), V3.r.a(1, 1728053247)));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v l(M2.A a6, float f5) {
        j4.k.g(a6, "$this$GlassEffect");
        a6.j(96.0f);
        a6.i(0.0f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v m(C0378o c0378o, float f5) {
        j4.k.g(c0378o, "$this$GlassEffect");
        c0378o.n(60.0f);
        c0378o.o(16777215);
        c0378o.k(0.0f);
        c0378o.l(0.0f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v n(a0 a0Var, float f5) {
        j4.k.g(a0Var, "$this$GlassEffect");
        a0Var.J(0.0f);
        a0Var.C(0.25f);
        a0Var.I(2.0f);
        a0Var.H(5.0f);
        a0Var.u(0.2f);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        a0Var.D((float) Math.cos(radians));
        a0Var.E((float) Math.sin(radians));
        a0Var.F((float) Math.cos(radians2));
        a0Var.G((float) Math.sin(radians2));
        a0Var.v(true);
        a0Var.z(-3355444);
        a0Var.x(-3092272);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v o(C0374k c0374k, float f5) {
        j4.k.g(c0374k, "<this>");
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v p(M2.A a6, float f5) {
        j4.k.g(a6, "<this>");
        return V3.v.f5542a;
    }

    public final i4.p<T, Float, V3.v> A() {
        return this.f3640e;
    }

    public final i4.p<a0, Float, V3.v> B() {
        return this.f3638c;
    }

    public final C0374k C(float f5) {
        C0374k c0374k = new C0374k();
        this.f3641f.invoke(c0374k, Float.valueOf(f5));
        return c0374k;
    }

    public final C0378o D(float f5) {
        C0378o c0378o = new C0378o();
        this.f3637b.invoke(c0378o, Float.valueOf(f5));
        return c0378o;
    }

    public final M E(float f5) {
        M m5 = new M();
        this.f3639d.invoke(m5, Float.valueOf(f5));
        return m5;
    }

    public final T F(float f5) {
        T t5 = new T();
        this.f3640e.invoke(t5, Float.valueOf(f5));
        return t5;
    }

    public final a0 G(float f5) {
        a0 a0Var = new a0();
        this.f3638c.invoke(a0Var, Float.valueOf(f5));
        return a0Var;
    }

    public final i4.p<C0374k, Float, V3.v> v() {
        return this.f3641f;
    }

    public final i4.p<C0378o, Float, V3.v> w() {
        return this.f3637b;
    }

    public final float x() {
        return this.f3636a;
    }

    public final i4.p<M2.A, Float, V3.v> y() {
        return this.f3642g;
    }

    public final i4.p<M, Float, V3.v> z() {
        return this.f3639d;
    }

    public /* synthetic */ o(float f5, i4.p pVar, i4.p pVar2, i4.p pVar3, i4.p pVar4, i4.p pVar5, i4.p pVar6, int i5, j4.g gVar) {
        this(f5, pVar, pVar2, pVar3, pVar4, (i5 & 32) != 0 ? new i4.p() { // from class: K2.h
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.o((C0374k) obj, ((Float) obj2).floatValue());
            }
        } : pVar5, (i5 & 64) != 0 ? new i4.p() { // from class: K2.i
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return o.p((M2.A) obj, ((Float) obj2).floatValue());
            }
        } : pVar6);
    }
}
