package u1;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 extends s1.o0 implements s1.e0, a, z0 {
    public boolean A;
    public h0 B;
    public m0.e C;
    public boolean D;
    public boolean E;
    public long F;
    public w0 G;
    public w0 H;
    public float I;
    public boolean J;
    public xb.l K;
    public long L;
    public float M;
    public w0 N;
    public boolean O;

    /* renamed from: j, reason: collision with root package name */
    public k0 f13956j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13957k;

    /* renamed from: l, reason: collision with root package name */
    public int f13958l;

    /* renamed from: m, reason: collision with root package name */
    public int f13959m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13960n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13961o;

    /* renamed from: p, reason: collision with root package name */
    public e0 f13962p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13963q;

    /* renamed from: r, reason: collision with root package name */
    public long f13964r;

    /* renamed from: s, reason: collision with root package name */
    public xb.l f13965s;

    /* renamed from: t, reason: collision with root package name */
    public float f13966t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13967u;

    /* renamed from: v, reason: collision with root package name */
    public Object f13968v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13969w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13970x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13971y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13972z;

    @Override // u1.a
    public final boolean A() {
        return this.f13969w;
    }

    @Override // u1.a
    public final void F() {
        g0.V(this.f13956j.f13843a, false, 7);
    }

    @Override // s1.o0
    public final int H(s1.l lVar) {
        h0 h0Var = this.B;
        k0 k0Var = this.f13956j;
        g0 g0VarT = k0Var.f13843a.t();
        if ((g0VarT != null ? g0VarT.I.f13846d : null) == c0.f13736c) {
            h0Var.f13824c = true;
        } else {
            g0 g0VarT2 = k0Var.f13843a.t();
            if ((g0VarT2 != null ? g0VarT2.I.f13846d : null) == c0.f13738g) {
                h0Var.f13825d = true;
            }
        }
        this.f13963q = true;
        int iH = k0Var.a().H(lVar);
        this.f13963q = false;
        return iH;
    }

    @Override // s1.o0
    public final int I() {
        return this.f13956j.a().I();
    }

    @Override // s1.o0
    public final int L() {
        return this.f13956j.a().L();
    }

    @Override // s1.o0
    public final void R(long j10, float f5, xb.l lVar) throws Throwable {
        boolean z10;
        s1.n0 placementScope;
        k0 k0Var = this.f13956j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        boolean z11 = true;
        try {
            this.f13970x = true;
            if (!o2.i.b(j10, this.f13964r) || this.O) {
                if (k0Var.f13852k || k0Var.f13851j || this.O) {
                    this.f13972z = true;
                    this.O = false;
                }
                d0();
            }
            t0 t0Var = k0Var.f13858q;
            if (t0Var != null) {
                k0 k0Var2 = t0Var.f13921j;
                if (f.q(k0Var2.f13843a)) {
                    z10 = true;
                } else {
                    if (t0Var.f13932u == q0.f13908g && !k0Var2.f13844b) {
                        k0Var2.f13845c = true;
                    }
                    z10 = k0Var2.f13845c;
                }
                if (z10) {
                    g1 g1Var = k0Var.a().f13812u;
                    if (g1Var == null || (placementScope = g1Var.f13883p) == null) {
                        placementScope = ((v1.t) j0.a(g0Var2)).getPlacementScope();
                    }
                    t0 t0Var2 = k0Var.f13858q;
                    t0Var2.getClass();
                    g0 g0VarT = g0Var2.t();
                    if (g0VarT != null) {
                        g0VarT.I.f13850h = 0;
                    }
                    t0Var2.f13924m = Reader.READ_DONE;
                    placementScope.g(t0Var2, (int) (j10 >> 32), (int) (4294967295L & j10), 0.0f);
                }
            }
            t0 t0Var3 = k0Var.f13858q;
            if (t0Var3 == null || t0Var3.f13927p) {
                z11 = false;
            }
            if (z11) {
                r1.a.b("Error: Placement happened before lookahead.");
            }
            l0(j10, f5, lVar);
        } catch (Throwable th) {
            g0Var.Y(th);
            throw null;
        }
    }

    public final List Z() {
        m0.e eVar = this.C;
        k0 k0Var = this.f13956j;
        k0Var.f13843a.f0();
        if (!this.D) {
            return eVar.f();
        }
        g0 g0Var = k0Var.f13843a;
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (eVar.f8160g <= i3) {
                eVar.b(g0Var2.I.f13857p);
            } else {
                x0 x0Var = g0Var2.I.f13857p;
                Object[] objArr2 = eVar.f8158c;
                Object obj = objArr2[i3];
                objArr2[i3] = x0Var;
            }
        }
        eVar.l(((m0.b) g0Var.m()).f8152c.f8160g, eVar.f8160g);
        this.D = false;
        return eVar.f();
    }

    @Override // u1.a
    public final h0 b() {
        return this.B;
    }

    public final void b0() {
        boolean z10 = this.f13969w;
        this.f13969w = true;
        g0 g0Var = this.f13956j.f13843a;
        c1 c1Var = g0Var.H;
        if (!z10) {
            c1Var.f13743c.T0();
            if (g0Var.q()) {
                g0.V(g0Var, true, 6);
            } else if (g0Var.I.f13847e) {
                g0.T(g0Var, true, 6);
            }
        }
        g1 g1Var = c1Var.f13743c.f13811t;
        for (g1 g1Var2 = c1Var.f13744d; !yb.k.a(g1Var2, g1Var) && g1Var2 != null; g1Var2 = g1Var2.f13811t) {
            if (g1Var2.L) {
                g1Var2.O0();
            }
        }
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (g0Var2.u() != Integer.MAX_VALUE) {
                g0Var2.I.f13857p.b0();
                g0.W(g0Var2);
            }
        }
    }

    public final void c0() {
        k0 k0Var = this.f13956j;
        if (this.f13969w) {
            this.f13969w = false;
            c1 c1Var = k0Var.f13843a.H;
            g1 g1Var = c1Var.f13743c.f13811t;
            for (g1 g1Var2 = c1Var.f13744d; !yb.k.a(g1Var2, g1Var) && g1Var2 != null; g1Var2 = g1Var2.f13811t) {
                w0.l lVarJ0 = g1Var2.J0(h1.g(1048576));
                if (lVarJ0 != null && (lVarJ0.f15114c.f15117h & 1048576) != 0) {
                    boolean zG = h1.g(1048576);
                    w0.l lVarH0 = g1Var2.H0();
                    if (zG || (lVarH0 = lVarH0.i) != null) {
                        for (w0.l lVarJ02 = g1Var2.J0(zG); lVarJ02 != null && (lVarJ02.f15117h & 1048576) != 0; lVarJ02 = lVarJ02.f15118j) {
                            if ((lVarJ02.f15116g & 1048576) != 0) {
                                w0.l lVarE = lVarJ02;
                                m0.e eVar = null;
                                while (lVarE != null) {
                                    if ((lVarE.f15116g & 1048576) != 0 && (lVarE instanceof m)) {
                                        int i = 0;
                                        for (w0.l lVar = ((m) lVarE).f13866t; lVar != null; lVar = lVar.f15118j) {
                                            if ((lVar.f15116g & 1048576) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    lVarE = lVar;
                                                } else {
                                                    if (eVar == null) {
                                                        eVar = new m0.e(new w0.l[16]);
                                                    }
                                                    if (lVarE != null) {
                                                        eVar.b(lVarE);
                                                        lVarE = null;
                                                    }
                                                    eVar.b(lVar);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    lVarE = f.e(eVar);
                                }
                            }
                            if (lVarJ02 != lVarH0) {
                            }
                        }
                    }
                }
                g1Var2.Y0();
            }
            m0.e eVarX = k0Var.f13843a.x();
            Object[] objArr = eVarX.f8158c;
            int i3 = eVarX.f8160g;
            for (int i10 = 0; i10 < i3; i10++) {
                ((g0) objArr[i10]).I.f13857p.c0();
            }
        }
    }

    @Override // u1.a
    public final void d(a2.m mVar) {
        m0.e eVarX = this.f13956j.f13843a.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            mVar.invoke(((g0) objArr[i3]).I.f13857p);
        }
    }

    public final void d0() {
        k0 k0Var = this.f13956j;
        if (k0Var.f13853l > 0) {
            m0.e eVarX = k0Var.f13843a.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                g0 g0Var = (g0) objArr[i3];
                k0 k0Var2 = g0Var.I;
                boolean z10 = k0Var2.f13851j;
                x0 x0Var = k0Var2.f13857p;
                if ((z10 || k0Var2.f13852k) && !x0Var.f13972z) {
                    g0Var.U(false);
                }
                x0Var.d0();
            }
        }
    }

    @Override // u1.a
    public final s f() {
        return this.f13956j.f13843a.H.f13743c;
    }

    public final void f0() {
        this.J = true;
        k0 k0Var = this.f13956j;
        g0 g0VarT = k0Var.f13843a.t();
        float f5 = f().E;
        g0 g0Var = k0Var.f13843a;
        c1 c1Var = g0Var.H;
        g1 g1Var = c1Var.f13744d;
        s sVar = c1Var.f13743c;
        while (g1Var != sVar) {
            g1Var.getClass();
            y yVar = (y) g1Var;
            f5 += yVar.E;
            g1Var = yVar.f13811t;
        }
        if (f5 != this.I) {
            this.I = f5;
            if (g0VarT != null) {
                g0VarT.M();
            }
            if (g0VarT != null) {
                g0VarT.A();
            }
        }
        if (this.f13969w) {
            g0Var.H.f13743c.T0();
        } else {
            if (g0VarT != null) {
                g0VarT.A();
            }
            b0();
            if (this.f13957k && g0VarT != null) {
                g0VarT.U(false);
            }
        }
        if (g0VarT != null) {
            k0 k0Var2 = g0VarT.I;
            if (!this.f13957k && k0Var2.f13846d == c0.f13738g) {
                if (this.f13959m != Integer.MAX_VALUE) {
                    r1.a.b("Place was called on a node which was placed already");
                }
                int i = k0Var2.i;
                this.f13959m = i;
                k0Var2.i = i + 1;
            }
        } else {
            this.f13959m = 0;
        }
        z();
    }

    @Override // u1.a
    public final a h() {
        k0 k0Var;
        g0 g0VarT = this.f13956j.f13843a.t();
        if (g0VarT == null || (k0Var = g0VarT.I) == null) {
            return null;
        }
        return k0Var.f13857p;
    }

    public final void h0(long j10) {
        k0 k0Var = this.f13956j;
        c0 c0Var = k0Var.f13846d;
        g0 g0Var = k0Var.f13843a;
        c0 c0Var2 = c0.i;
        if (c0Var != c0Var2) {
            r1.a.b("layout state is not idle before measure starts");
        }
        this.F = j10;
        c0 c0Var3 = c0.f13736c;
        k0Var.f13846d = c0Var3;
        this.f13971y = false;
        p1 snapshotObserver = ((v1.t) j0.a(g0Var)).getSnapshotObserver();
        snapshotObserver.a(g0Var, snapshotObserver.f13897c, this.G);
        if (k0Var.f13846d == c0Var3) {
            this.f13972z = true;
            this.A = true;
            k0Var.f13846d = c0Var2;
        }
    }

    public final void l0(long j10, float f5, xb.l lVar) {
        k0 k0Var = this.f13956j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        if (g0Var.S) {
            r1.a.a("place is called on a deactivated node");
        }
        k0Var.f13846d = c0.f13738g;
        this.f13964r = j10;
        this.f13966t = f5;
        this.f13965s = lVar;
        this.J = false;
        n1 n1VarA = j0.a(g0Var2);
        if (this.f13972z || !this.f13969w) {
            this.B.f13828g = false;
            k0Var.f(false);
            this.K = lVar;
            this.L = j10;
            this.M = f5;
            p1 snapshotObserver = ((v1.t) n1VarA).getSnapshotObserver();
            snapshotObserver.a(g0Var2, snapshotObserver.f13900f, this.N);
        } else {
            g1 g1VarA = k0Var.a();
            g1VarA.W0(o2.i.d(j10, g1VarA.i), f5, lVar);
            f0();
        }
        k0Var.f13846d = c0.i;
        this.f13961o = true;
    }

    public final boolean o0(long j10) throws Throwable {
        k0 k0Var = this.f13956j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        try {
            if (g0Var.S) {
                r1.a.a("measure is called on a deactivated node");
            }
            n1 n1VarA = j0.a(g0Var2);
            g0 g0VarT = g0Var2.t();
            boolean z10 = true;
            g0Var2.G = g0Var2.G || (g0VarT != null && g0VarT.G);
            if (!g0Var2.q() && o2.a.c(this.f11280h, j10)) {
                ((v1.t) n1VarA).k(g0Var2, false);
                g0Var2.X();
                return false;
            }
            this.B.f13827f = false;
            m0.e eVarX = g0Var2.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                ((g0) objArr[i3]).I.f13857p.B.f13824c = false;
            }
            this.f13960n = true;
            long j11 = k0Var.a().f11279g;
            U(j10);
            h0(j10);
            if (o2.k.b(k0Var.a().f11279g, j11) && k0Var.a().f11277c == this.f11277c && k0Var.a().f11278f == this.f11278f) {
                z10 = false;
            }
            S((k0Var.a().f11278f & 4294967295L) | (k0Var.a().f11277c << 32));
            return z10;
        } catch (Throwable th) {
            g0Var.Y(th);
            throw null;
        }
    }

    @Override // s1.e0
    public final s1.o0 q(long j10) throws Throwable {
        e0 e0Var;
        k0 k0Var = this.f13956j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        e0 e0Var2 = g0Var.E;
        e0 e0Var3 = e0.f13767g;
        if (e0Var2 == e0Var3) {
            g0Var.e();
        }
        if (f.q(g0Var2)) {
            t0 t0Var = k0Var.f13858q;
            t0Var.getClass();
            t0Var.f13925n = e0Var3;
            t0Var.q(j10);
        }
        g0 g0VarT = g0Var2.t();
        if (g0VarT != null) {
            k0 k0Var2 = g0VarT.I;
            if (this.f13962p != e0Var3 && !g0Var2.G) {
                r1.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = k0Var2.f13846d.ordinal();
            if (iOrdinal == 0) {
                e0Var = e0.f13765c;
            } else {
                if (iOrdinal != 2) {
                    ad.o.n(k0Var2.f13846d, "Measurable could be only measured from the parent's measure or layout block. Parents state is ");
                    return null;
                }
                e0Var = e0.f13766f;
            }
            this.f13962p = e0Var;
        } else {
            this.f13962p = e0Var3;
        }
        o0(j10);
        return this;
    }

    @Override // u1.a
    public final void requestLayout() {
        this.f13956j.f13843a.U(false);
    }

    @Override // s1.o0, s1.e0
    public final Object v() {
        return this.f13968v;
    }

    @Override // u1.z0
    public final void y(boolean z10) {
        k0 k0Var = this.f13956j;
        if (z10 != k0Var.a().f13880m) {
            k0Var.a().f13880m = z10;
            this.O = true;
        }
    }

    @Override // u1.a
    public final void z() {
        k0 k0Var = this.f13956j;
        this.E = true;
        h0 h0Var = this.B;
        h0Var.h();
        if (this.f13972z) {
            m0.e eVarX = k0Var.f13843a.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                g0 g0Var = (g0) objArr[i3];
                if (g0Var.q() && g0Var.r() == e0.f13765c && g0.O(g0Var)) {
                    g0.V(k0Var.f13843a, false, 7);
                }
            }
        }
        if (this.A || (!this.f13963q && !f().f13882o && this.f13972z)) {
            this.f13972z = false;
            c0 c0Var = k0Var.f13846d;
            k0Var.f13846d = c0.f13738g;
            k0Var.g(false);
            g0 g0Var2 = k0Var.f13843a;
            p1 snapshotObserver = ((v1.t) j0.a(g0Var2)).getSnapshotObserver();
            snapshotObserver.a(g0Var2, snapshotObserver.f13899e, this.H);
            k0Var.f13846d = c0Var;
            if (f().f13882o && k0Var.f13851j) {
                requestLayout();
            }
            this.A = false;
        }
        if (h0Var.f13825d) {
            h0Var.f13826e = true;
        }
        if (h0Var.f13823b && h0Var.e()) {
            h0Var.g();
        }
        this.E = false;
    }
}
