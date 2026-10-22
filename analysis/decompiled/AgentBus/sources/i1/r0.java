package i1;

/* loaded from: classes.dex */
public final class r0 extends g1.s implements g1.o, a, x0 {
    public Object A;
    public boolean B;

    /* renamed from: k, reason: collision with root package name */
    public final i0 f4567k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4568l;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4572p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4573q;

    /* renamed from: r, reason: collision with root package name */
    public d2.a f4574r;

    /* renamed from: t, reason: collision with root package name */
    public p7.k f4576t;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4581y;

    /* renamed from: m, reason: collision with root package name */
    public int f4569m = Integer.MAX_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public int f4570n = Integer.MAX_VALUE;

    /* renamed from: o, reason: collision with root package name */
    public d0 f4571o = d0.f4435h;

    /* renamed from: s, reason: collision with root package name */
    public long f4575s = 0;

    /* renamed from: u, reason: collision with root package name */
    public o0 f4577u = o0.f4555h;

    /* renamed from: v, reason: collision with root package name */
    public final g0 f4578v = new g0(this, 1);

    /* renamed from: w, reason: collision with root package name */
    public final d0.e f4579w = new d0.e(new r0[16]);

    /* renamed from: x, reason: collision with root package name */
    public boolean f4580x = true;

    /* renamed from: z, reason: collision with root package name */
    public boolean f4582z = true;

    public r0(i0 i0Var) {
        this.f4567k = i0Var;
        this.A = i0Var.f4507o.f4617u;
    }

    @Override // i1.a
    public final g0 A() {
        return this.f4578v;
    }

    @Override // i1.a
    public final void C() {
        f0.K(this.f4567k.f4493a, false, 7);
    }

    @Override // g1.s
    public final void M(long j2, float f10, p7.k kVar) throws Throwable {
        W(j2, kVar);
    }

    public final void Q(boolean z4) {
        i0 i0Var = this.f4567k;
        if (z4 && i0Var.f4494b) {
            return;
        }
        if (z4 || i0Var.f4494b) {
            this.f4577u = o0.f4555h;
            d0.e eVarS = i0Var.f4493a.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                r0 r0Var = ((f0) objArr[i10]).I.f4508p;
                q7.k.b(r0Var);
                r0Var.Q(true);
            }
        }
    }

    public final void S() {
        o0 o0Var = this.f4577u;
        i0 i0Var = this.f4567k;
        boolean z4 = i0Var.f4494b;
        f0 f0Var = i0Var.f4493a;
        if (z4) {
            this.f4577u = o0.f4554g;
        } else {
            this.f4577u = o0.f4553f;
        }
        if (o0Var != o0.f4553f && i0Var.f4496d) {
            f0.K(f0Var, true, 6);
        }
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            r0 r0Var = f0Var2.I.f4508p;
            if (r0Var == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
            }
            if (r0Var.f4570n != Integer.MAX_VALUE) {
                r0Var.S();
                f0.N(f0Var2);
            }
        }
    }

    public final void T() {
        i0 i0Var = this.f4567k;
        if (i0Var.f4506n > 0) {
            d0.e eVarS = i0Var.f4493a.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                f0 f0Var = (f0) objArr[i10];
                i0 i0Var2 = f0Var.I;
                if ((i0Var2.f4504l || i0Var2.f4505m) && !i0Var2.f4497e) {
                    f0Var.J(false);
                }
                r0 r0Var = i0Var2.f4508p;
                if (r0Var != null) {
                    r0Var.T();
                }
            }
        }
    }

    public final void V() {
        b0 b0Var;
        this.B = true;
        i0 i0Var = this.f4567k;
        f0 f0VarN = i0Var.f4493a.n();
        o0 o0Var = this.f4577u;
        if ((o0Var != o0.f4553f && !i0Var.f4494b) || (o0Var != o0.f4554g && i0Var.f4494b)) {
            S();
            if (this.f4568l && f0VarN != null) {
                f0VarN.J(false);
            }
        }
        if (f0VarN != null) {
            i0 i0Var2 = f0VarN.I;
            if (!this.f4568l && ((b0Var = i0Var2.f4495c) == b0.f4410h || b0Var == b0.f4411i)) {
                if (this.f4570n != Integer.MAX_VALUE) {
                    f1.a.b("Place was called on a node which was placed already");
                }
                int i2 = i0Var2.f4499g;
                this.f4570n = i2;
                i0Var2.f4499g = i2 + 1;
            }
        } else {
            this.f4570n = 0;
        }
        q();
    }

    public final void W(long j2, p7.k kVar) throws Throwable {
        i0 i0Var = this.f4567k;
        f0 f0Var = i0Var.f4493a;
        f0 f0Var2 = i0Var.f4493a;
        try {
            f0 f0VarN = f0Var.n();
            b0 b0Var = f0VarN != null ? f0VarN.I.f4495c : null;
            b0 b0Var2 = b0.f4411i;
            if (b0Var == b0Var2) {
                i0Var.f4494b = false;
            }
            if (f0Var2.P) {
                f1.a.a("place is called on a deactivated node");
            }
            i0Var.f4495c = b0Var2;
            this.f4572p = true;
            this.B = false;
            if (!d2.i.a(j2, this.f4575s)) {
                if (i0Var.f4505m || i0Var.f4504l) {
                    i0Var.f4497e = true;
                }
                T();
            }
            k1 k1VarW = l.w(f0Var2);
            if (i0Var.f4497e || !u()) {
                i0Var.h(false);
                this.f4578v.f4483e = false;
                m1 snapshotObserver = ((j1.y) k1VarW).getSnapshotObserver();
                q0 q0Var = new q0(this, k1VarW, j2);
                snapshotObserver.getClass();
                if (f0Var2.f4458l != null) {
                    snapshotObserver.a(f0Var2, snapshotObserver.f4542g, q0Var);
                } else {
                    snapshotObserver.a(f0Var2, snapshotObserver.f4541f, q0Var);
                }
            } else {
                n0 n0VarX0 = i0Var.a().x0();
                q7.k.b(n0VarX0);
                n0VarX0.q0(d2.i.c(j2, n0VarX0.f3760j));
                V();
            }
            this.f4575s = j2;
            this.f4576t = kVar;
            i0Var.f4495c = b0.f4412j;
        } catch (Throwable th) {
            f0Var.P(th);
            throw null;
        }
    }

    public final boolean Z(long j2) throws Throwable {
        long j4;
        i0 i0Var = this.f4567k;
        f0 f0Var = i0Var.f4493a;
        f0 f0Var2 = i0Var.f4493a;
        try {
            if (f0Var.P) {
                f1.a.a("measure is called on a deactivated node");
            }
            f0 f0VarN = f0Var2.n();
            f0Var2.G = f0Var2.G || (f0VarN != null && f0VarN.G);
            if (!f0Var2.I.f4496d) {
                d2.a aVar = this.f4574r;
                if (aVar == null ? false : d2.a.b(aVar.f2778a, j2)) {
                    k1 k1Var = f0Var2.f4464r;
                    if (k1Var != null) {
                        ((j1.y) k1Var).i(f0Var2, true);
                    }
                    f0Var2.O();
                    return false;
                }
            }
            this.f4574r = new d2.a(j2);
            P(j2);
            this.f4578v.f4482d = false;
            d0.e eVarS = f0Var2.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                r0 r0Var = ((f0) objArr[i10]).I.f4508p;
                q7.k.b(r0Var);
                r0Var.f4578v.getClass();
            }
            if (this.f4573q) {
                j4 = this.f3758h;
            } else {
                long j10 = Integer.MIN_VALUE;
                j4 = (j10 & 4294967295L) | (j10 << 32);
            }
            this.f4573q = true;
            n0 n0VarX0 = i0Var.a().x0();
            if (!(n0VarX0 != null)) {
                f1.a.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            i0Var.c(j2);
            N((n0VarX0.f3757g & 4294967295L) | (n0VarX0.f3756f << 32));
            return (((int) (j4 >> 32)) == n0VarX0.f3756f && ((int) (j4 & 4294967295L)) == n0VarX0.f3757g) ? false : true;
        } catch (Throwable th) {
            f0Var.P(th);
            throw null;
        }
    }

    @Override // g1.o
    public final g1.s b(long j2) {
        d0 d0Var;
        i0 i0Var = this.f4567k;
        f0 f0Var = i0Var.f4493a;
        f0 f0Var2 = i0Var.f4493a;
        f0 f0VarN = f0Var.n();
        if ((f0VarN != null ? f0VarN.I.f4495c : null) != b0.f4409g) {
            f0 f0VarN2 = f0Var2.n();
            if (f0VarN2 != null) {
                b0 b0Var = f0VarN2.I.f4495c;
            }
            b0 b0Var2 = b0.f4411i;
        }
        f0 f0VarN3 = f0Var2.n();
        if (f0VarN3 != null) {
            i0 i0Var2 = f0VarN3.I;
            if (this.f4571o != d0.f4435h && !f0Var2.G) {
                f1.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = i0Var2.f4495c.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                d0Var = d0.f4433f;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + i0Var2.f4495c);
                }
                d0Var = d0.f4434g;
            }
            this.f4571o = d0Var;
        } else {
            this.f4571o = d0.f4435h;
        }
        if (f0Var2.E == d0.f4435h) {
            f0Var2.c();
        }
        Z(j2);
        return this;
    }

    @Override // g1.s, g1.o
    public final Object g() {
        return this.A;
    }

    @Override // i1.x0
    public final void i(boolean z4) {
        n0 n0VarX0;
        i0 i0Var = this.f4567k;
        n0 n0VarX02 = i0Var.a().x0();
        if (Boolean.valueOf(z4).equals(n0VarX02 != null ? Boolean.valueOf(n0VarX02.f4530n) : null) || (n0VarX0 = i0Var.a().x0()) == null) {
            return;
        }
        n0VarX0.f4530n = z4;
    }

    @Override // i1.a
    public final void k(c1.w wVar) throws Throwable {
        d0.e eVarS = this.f4567k.f4493a.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            r0 r0Var = ((f0) objArr[i10]).I.f4508p;
            q7.k.b(r0Var);
            wVar.invoke(r0Var);
        }
    }

    @Override // i1.a
    public final r l() {
        return (r) this.f4567k.f4493a.H.f4401g;
    }

    @Override // i1.a
    public final a m() {
        i0 i0Var;
        f0 f0VarN = this.f4567k.f4493a.n();
        if (f0VarN == null || (i0Var = f0VarN.I) == null) {
            return null;
        }
        return i0Var.f4508p;
    }

    @Override // i1.a
    public final void q() {
        this.f4581y = true;
        g0 g0Var = this.f4578v;
        g0Var.h();
        i0 i0Var = this.f4567k;
        boolean z4 = i0Var.f4497e;
        f0 f0Var = i0Var.f4493a;
        if (z4) {
            d0.e eVarS = f0Var.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                f0 f0Var2 = (f0) objArr[i10];
                i0 i0Var2 = f0Var2.I;
                if (i0Var2.f4496d && f0Var2.m() == d0.f4433f) {
                    r0 r0Var = i0Var2.f4508p;
                    q7.k.b(r0Var);
                    r0 r0Var2 = i0Var2.f4508p;
                    d2.a aVar = r0Var2 != null ? r0Var2.f4574r : null;
                    q7.k.b(aVar);
                    if (r0Var.Z(aVar.f2778a)) {
                        f0.K(f0Var, false, 7);
                    }
                }
            }
        }
        q qVar = l().T;
        q7.k.b(qVar);
        if (i0Var.f4498f || (!qVar.f4532p && i0Var.f4497e)) {
            i0Var.f4497e = false;
            b0 b0Var = i0Var.f4495c;
            i0Var.f4495c = b0.f4411i;
            k1 k1VarW = l.w(f0Var);
            i0Var.i(false);
            m1 snapshotObserver = ((j1.y) k1VarW).getSnapshotObserver();
            a8.e eVar = new a8.e(7, this, qVar);
            snapshotObserver.getClass();
            if (f0Var.f4458l != null) {
                snapshotObserver.a(f0Var, snapshotObserver.f4543h, eVar);
            } else {
                snapshotObserver.a(f0Var, snapshotObserver.f4540e, eVar);
            }
            i0Var.f4495c = b0Var;
            if (i0Var.f4504l && qVar.f4532p) {
                requestLayout();
            }
            i0Var.f4498f = false;
        }
        if (g0Var.f4480b && g0Var.e()) {
            g0Var.g();
        }
        this.f4581y = false;
    }

    @Override // i1.a
    public final void requestLayout() {
        this.f4567k.f4493a.J(false);
    }

    @Override // i1.a
    public final boolean u() {
        return this.f4577u != o0.f4555h;
    }
}
