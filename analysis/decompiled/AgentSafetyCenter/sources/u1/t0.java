package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends s1.o0 implements s1.e0, a, z0 {
    public Object A;
    public boolean B;

    /* renamed from: j, reason: collision with root package name */
    public k0 f13921j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13922k;

    /* renamed from: l, reason: collision with root package name */
    public int f13923l;

    /* renamed from: m, reason: collision with root package name */
    public int f13924m;

    /* renamed from: n, reason: collision with root package name */
    public e0 f13925n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13926o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13927p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13928q;

    /* renamed from: r, reason: collision with root package name */
    public o2.a f13929r;

    /* renamed from: s, reason: collision with root package name */
    public long f13930s;

    /* renamed from: t, reason: collision with root package name */
    public xb.l f13931t;

    /* renamed from: u, reason: collision with root package name */
    public q0 f13932u;

    /* renamed from: v, reason: collision with root package name */
    public h0 f13933v;

    /* renamed from: w, reason: collision with root package name */
    public m0.e f13934w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13935x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13936y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13937z;

    @Override // u1.a
    public final boolean A() {
        return this.f13932u != q0.f13908g;
    }

    @Override // u1.a
    public final void F() {
        g0.T(this.f13921j.f13843a, false, 7);
    }

    @Override // s1.o0
    public final int H(s1.l lVar) {
        h0 h0Var = this.f13933v;
        k0 k0Var = this.f13921j;
        g0 g0VarT = k0Var.f13843a.t();
        if ((g0VarT != null ? g0VarT.I.f13846d : null) == c0.f13737f) {
            h0Var.f13824c = true;
        } else {
            g0 g0VarT2 = k0Var.f13843a.t();
            if ((g0VarT2 != null ? g0VarT2.I.f13846d : null) == c0.f13739h) {
                h0Var.f13825d = true;
            }
        }
        this.f13926o = true;
        p0 p0VarF0 = k0Var.a().F0();
        p0VarF0.getClass();
        int iH = p0VarF0.H(lVar);
        this.f13926o = false;
        return iH;
    }

    @Override // s1.o0
    public final void R(long j10, float f5, xb.l lVar) throws Throwable {
        f0(j10, lVar);
    }

    public final void Z(boolean z10) {
        k0 k0Var = this.f13921j;
        if (z10 && k0Var.f13845c) {
            return;
        }
        if (z10 || k0Var.f13845c) {
            this.f13932u = q0.f13908g;
            m0.e eVarX = k0Var.f13843a.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                t0 t0Var = ((g0) objArr[i3]).I.f13858q;
                t0Var.getClass();
                t0Var.Z(true);
            }
        }
    }

    @Override // u1.a
    public final h0 b() {
        return this.f13933v;
    }

    public final void b0() {
        q0 q0Var = this.f13932u;
        k0 k0Var = this.f13921j;
        boolean z10 = k0Var.f13845c;
        g0 g0Var = k0Var.f13843a;
        if (z10) {
            this.f13932u = q0.f13907f;
        } else {
            this.f13932u = q0.f13906c;
        }
        if (q0Var != q0.f13906c && k0Var.f13847e) {
            g0.T(g0Var, true, 6);
        }
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            t0 t0Var = g0Var2.I.f13858q;
            if (t0Var == null) {
                g5.f.s("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
                return;
            }
            if (t0Var.f13924m != Integer.MAX_VALUE) {
                t0Var.b0();
                g0.W(g0Var2);
            }
        }
    }

    public final void c0() {
        k0 k0Var = this.f13921j;
        if (k0Var.f13856o > 0) {
            m0.e eVarX = k0Var.f13843a.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                g0 g0Var = (g0) objArr[i3];
                k0 k0Var2 = g0Var.I;
                if ((k0Var2.f13854m || k0Var2.f13855n) && !k0Var2.f13848f) {
                    g0Var.S(false);
                }
                t0 t0Var = k0Var2.f13858q;
                if (t0Var != null) {
                    t0Var.c0();
                }
            }
        }
    }

    @Override // u1.a
    public final void d(a2.m mVar) {
        m0.e eVarX = this.f13921j.f13843a.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            t0 t0Var = ((g0) objArr[i3]).I.f13858q;
            t0Var.getClass();
            mVar.invoke(t0Var);
        }
    }

    public final void d0() {
        c0 c0Var;
        this.B = true;
        k0 k0Var = this.f13921j;
        g0 g0VarT = k0Var.f13843a.t();
        q0 q0Var = this.f13932u;
        if ((q0Var != q0.f13906c && !k0Var.f13845c) || (q0Var != q0.f13907f && k0Var.f13845c)) {
            b0();
            if (this.f13922k && g0VarT != null) {
                g0VarT.S(false);
            }
        }
        if (g0VarT != null) {
            k0 k0Var2 = g0VarT.I;
            if (!this.f13922k && ((c0Var = k0Var2.f13846d) == c0.f13738g || c0Var == c0.f13739h)) {
                if (this.f13924m != Integer.MAX_VALUE) {
                    r1.a.b("Place was called on a node which was placed already");
                }
                int i = k0Var2.f13850h;
                this.f13924m = i;
                k0Var2.f13850h = i + 1;
            }
        } else {
            this.f13924m = 0;
        }
        z();
    }

    @Override // u1.a
    public final s f() {
        return this.f13921j.f13843a.H.f13743c;
    }

    public final void f0(long j10, xb.l lVar) throws Throwable {
        k0 k0Var = this.f13921j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        try {
            g0 g0VarT = g0Var.t();
            c0 c0Var = g0VarT != null ? g0VarT.I.f13846d : null;
            c0 c0Var2 = c0.f13739h;
            if (c0Var == c0Var2) {
                k0Var.f13845c = false;
            }
            if (g0Var2.S) {
                r1.a.a("place is called on a deactivated node");
            }
            k0Var.f13846d = c0Var2;
            this.f13927p = true;
            this.B = false;
            if (!o2.i.b(j10, this.f13930s)) {
                if (k0Var.f13855n || k0Var.f13854m) {
                    k0Var.f13848f = true;
                }
                c0();
            }
            n1 n1VarA = j0.a(g0Var2);
            if (k0Var.f13848f || !A()) {
                k0Var.h(false);
                this.f13933v.f13828g = false;
                p1 snapshotObserver = ((v1.t) n1VarA).getSnapshotObserver();
                s0 s0Var = new s0(this, n1VarA, j10);
                snapshotObserver.getClass();
                if (g0Var2.f13794k != null) {
                    snapshotObserver.a(g0Var2, snapshotObserver.f13901g, s0Var);
                } else {
                    snapshotObserver.a(g0Var2, snapshotObserver.f13900f, s0Var);
                }
            } else {
                p0 p0VarF0 = k0Var.a().F0();
                p0VarF0.getClass();
                p0VarF0.y0(o2.i.d(j10, p0VarF0.i));
                d0();
            }
            this.f13930s = j10;
            this.f13931t = lVar;
            k0Var.f13846d = c0.i;
        } catch (Throwable th) {
            g0Var.Y(th);
            throw null;
        }
    }

    @Override // u1.a
    public final a h() {
        k0 k0Var;
        g0 g0VarT = this.f13921j.f13843a.t();
        if (g0VarT == null || (k0Var = g0VarT.I) == null) {
            return null;
        }
        return k0Var.f13858q;
    }

    public final boolean h0(long j10) throws Throwable {
        long j11;
        k0 k0Var = this.f13921j;
        g0 g0Var = k0Var.f13843a;
        g0 g0Var2 = k0Var.f13843a;
        try {
            if (g0Var.S) {
                r1.a.a("measure is called on a deactivated node");
            }
            g0 g0VarT = g0Var2.t();
            g0Var2.G = g0Var2.G || (g0VarT != null && g0VarT.G);
            if (!g0Var2.I.f13847e) {
                o2.a aVar = this.f13929r;
                if (aVar == null ? false : o2.a.c(aVar.f9108a, j10)) {
                    n1 n1Var = g0Var2.f13800q;
                    if (n1Var != null) {
                        ((v1.t) n1Var).k(g0Var2, true);
                    }
                    g0Var2.X();
                    return false;
                }
            }
            this.f13929r = o2.a.a(j10);
            U(j10);
            this.f13933v.f13827f = false;
            m0.e eVarX = g0Var2.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                t0 t0Var = ((g0) objArr[i3]).I.f13858q;
                t0Var.getClass();
                t0Var.f13933v.f13824c = false;
            }
            if (this.f13928q) {
                j11 = this.f11279g;
            } else {
                long j12 = Integer.MIN_VALUE;
                j11 = (j12 & 4294967295L) | (j12 << 32);
            }
            this.f13928q = true;
            p0 p0VarF0 = k0Var.a().F0();
            if (!(p0VarF0 != null)) {
                r1.a.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            k0Var.c(j10);
            S((p0VarF0.f11278f & 4294967295L) | (p0VarF0.f11277c << 32));
            return (((int) (j11 >> 32)) == p0VarF0.f11277c && ((int) (j11 & 4294967295L)) == p0VarF0.f11278f) ? false : true;
        } catch (Throwable th) {
            g0Var.Y(th);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // s1.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.o0 q(long r6) {
        /*
            r5 = this;
            u1.k0 r0 = r5.f13921j
            u1.g0 r1 = r0.f13843a
            u1.g0 r2 = r0.f13843a
            u1.g0 r1 = r1.t()
            r3 = 0
            if (r1 == 0) goto L12
            u1.k0 r1 = r1.I
            u1.c0 r1 = r1.f13846d
            goto L13
        L12:
            r1 = r3
        L13:
            u1.c0 r4 = u1.c0.f13737f
            if (r1 == r4) goto L25
            u1.g0 r1 = r2.t()
            if (r1 == 0) goto L21
            u1.k0 r1 = r1.I
            u1.c0 r3 = r1.f13846d
        L21:
            u1.c0 r1 = u1.c0.f13739h
            if (r3 != r1) goto L28
        L25:
            r1 = 0
            r0.f13844b = r1
        L28:
            u1.g0 r0 = r2.t()
            if (r0 == 0) goto L63
            u1.k0 r0 = r0.I
            u1.e0 r1 = r5.f13925n
            u1.e0 r3 = u1.e0.f13767g
            if (r1 == r3) goto L40
            boolean r1 = r2.G
            if (r1 == 0) goto L3b
            goto L40
        L3b:
            java.lang.String r1 = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()"
            r1.a.b(r1)
        L40:
            u1.c0 r1 = r0.f13846d
            int r1 = r1.ordinal()
            if (r1 == 0) goto L5e
            r3 = 1
            if (r1 == r3) goto L5e
            r3 = 2
            if (r1 == r3) goto L5b
            r3 = 3
            if (r1 != r3) goto L52
            goto L5b
        L52:
            java.lang.String r5 = "Measurable could be only measured from the parent's measure or layout block. Parents state is "
            u1.c0 r6 = r0.f13846d
            ad.o.n(r6, r5)
            r5 = 0
            return r5
        L5b:
            u1.e0 r0 = u1.e0.f13766f
            goto L60
        L5e:
            u1.e0 r0 = u1.e0.f13765c
        L60:
            r5.f13925n = r0
            goto L67
        L63:
            u1.e0 r0 = u1.e0.f13767g
            r5.f13925n = r0
        L67:
            u1.e0 r0 = r2.E
            u1.e0 r1 = u1.e0.f13767g
            if (r0 != r1) goto L70
            r2.e()
        L70:
            r5.h0(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.t0.q(long):s1.o0");
    }

    @Override // u1.a
    public final void requestLayout() {
        this.f13921j.f13843a.S(false);
    }

    @Override // s1.o0, s1.e0
    public final Object v() {
        return this.A;
    }

    @Override // u1.z0
    public final void y(boolean z10) {
        p0 p0VarF0;
        k0 k0Var = this.f13921j;
        p0 p0VarF02 = k0Var.a().F0();
        if (Boolean.valueOf(z10).equals(p0VarF02 != null ? Boolean.valueOf(p0VarF02.f13880m) : null) || (p0VarF0 = k0Var.a().F0()) == null) {
            return;
        }
        p0VarF0.f13880m = z10;
    }

    @Override // u1.a
    public final void z() {
        this.f13936y = true;
        h0 h0Var = this.f13933v;
        h0Var.h();
        k0 k0Var = this.f13921j;
        boolean z10 = k0Var.f13848f;
        g0 g0Var = k0Var.f13843a;
        if (z10) {
            m0.e eVarX = g0Var.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                g0 g0Var2 = (g0) objArr[i3];
                k0 k0Var2 = g0Var2.I;
                if (k0Var2.f13847e && g0Var2.s() == e0.f13765c) {
                    t0 t0Var = k0Var2.f13858q;
                    t0Var.getClass();
                    t0 t0Var2 = k0Var2.f13858q;
                    o2.a aVar = t0Var2 != null ? t0Var2.f13929r : null;
                    aVar.getClass();
                    if (t0Var.h0(aVar.f9108a)) {
                        g0.T(g0Var, false, 7);
                    }
                }
            }
        }
        r rVar = f().S;
        rVar.getClass();
        if (k0Var.f13849g || (!this.f13926o && !rVar.f13882o && k0Var.f13848f)) {
            k0Var.f13848f = false;
            c0 c0Var = k0Var.f13846d;
            k0Var.f13846d = c0.f13739h;
            n1 n1VarA = j0.a(g0Var);
            k0Var.i(false);
            p1 snapshotObserver = ((v1.t) n1VarA).getSnapshotObserver();
            a1.b bVar = new a1.b(12, this, rVar);
            snapshotObserver.getClass();
            if (g0Var.f13794k != null) {
                snapshotObserver.a(g0Var, snapshotObserver.f13902h, bVar);
            } else {
                snapshotObserver.a(g0Var, snapshotObserver.f13899e, bVar);
            }
            k0Var.f13846d = c0Var;
            if (k0Var.f13854m && rVar.f13882o) {
                requestLayout();
            }
            k0Var.f13849g = false;
        }
        if (h0Var.f13825d) {
            h0Var.f13826e = true;
        }
        if (h0Var.f13823b && h0Var.e()) {
            h0Var.g();
        }
        this.f13936y = false;
    }
}
