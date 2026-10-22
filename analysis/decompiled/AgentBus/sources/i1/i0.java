package i1;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f4493a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4494b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4496d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4497e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4498f;

    /* renamed from: g, reason: collision with root package name */
    public int f4499g;

    /* renamed from: h, reason: collision with root package name */
    public int f4500h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4501i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4502j;

    /* renamed from: k, reason: collision with root package name */
    public int f4503k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4504l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4505m;

    /* renamed from: n, reason: collision with root package name */
    public int f4506n;

    /* renamed from: p, reason: collision with root package name */
    public r0 f4508p;

    /* renamed from: c, reason: collision with root package name */
    public b0 f4495c = b0.f4412j;

    /* renamed from: o, reason: collision with root package name */
    public final v0 f4507o = new v0(this);

    public i0(f0 f0Var) {
        this.f4493a = f0Var;
    }

    public final d1 a() {
        return (d1) this.f4493a.H.f4402h;
    }

    public final void b() {
        b0 b0Var = this.f4493a.I.f4495c;
        if (b0Var == b0.f4410h || b0Var == b0.f4411i) {
            if (this.f4507o.D) {
                g(true);
            } else {
                f(true);
            }
        }
        if (b0Var == b0.f4411i) {
            r0 r0Var = this.f4508p;
            if (r0Var == null || !r0Var.f4581y) {
                h(true);
            } else {
                i(true);
            }
        }
    }

    public final void c(long j2) {
        r0 r0Var = this.f4508p;
        if (r0Var != null) {
            b0 b0Var = b0.f4409g;
            i0 i0Var = r0Var.f4567k;
            i0Var.f4495c = b0Var;
            v0 v0Var = i0Var.f4507o;
            f0 f0Var = i0Var.f4493a;
            i0Var.f4496d = false;
            m1 snapshotObserver = ((j1.y) l.w(f0Var)).getSnapshotObserver();
            p0 p0Var = new p0(r0Var, j2);
            snapshotObserver.getClass();
            if (f0Var.f4458l != null) {
                snapshotObserver.a(f0Var, snapshotObserver.f4537b, p0Var);
            } else {
                snapshotObserver.a(f0Var, snapshotObserver.f4538c, p0Var);
            }
            i0Var.f4497e = true;
            i0Var.f4498f = true;
            if (l.q(f0Var)) {
                v0Var.f4621y = true;
                v0Var.f4622z = true;
            } else {
                v0Var.f4620x = true;
            }
            i0Var.f4495c = b0.f4412j;
        }
    }

    public final void d(int i2) {
        int i10 = this.f4503k;
        this.f4503k = i2;
        if ((i10 == 0) != (i2 == 0)) {
            f0 f0VarN = this.f4493a.n();
            i0 i0Var = f0VarN != null ? f0VarN.I : null;
            if (i0Var != null) {
                if (i2 == 0) {
                    i0Var.d(i0Var.f4503k - 1);
                } else {
                    i0Var.d(i0Var.f4503k + 1);
                }
            }
        }
    }

    public final void e(int i2) {
        int i10 = this.f4506n;
        this.f4506n = i2;
        if ((i10 == 0) != (i2 == 0)) {
            f0 f0VarN = this.f4493a.n();
            i0 i0Var = f0VarN != null ? f0VarN.I : null;
            if (i0Var != null) {
                if (i2 == 0) {
                    i0Var.e(i0Var.f4506n - 1);
                } else {
                    i0Var.e(i0Var.f4506n + 1);
                }
            }
        }
    }

    public final void f(boolean z4) {
        if (this.f4502j != z4) {
            this.f4502j = z4;
            if (z4 && !this.f4501i) {
                d(this.f4503k + 1);
            } else {
                if (z4 || this.f4501i) {
                    return;
                }
                d(this.f4503k - 1);
            }
        }
    }

    public final void g(boolean z4) {
        if (this.f4501i != z4) {
            this.f4501i = z4;
            if (z4 && !this.f4502j) {
                d(this.f4503k + 1);
            } else {
                if (z4 || this.f4502j) {
                    return;
                }
                d(this.f4503k - 1);
            }
        }
    }

    public final void h(boolean z4) {
        if (this.f4505m != z4) {
            this.f4505m = z4;
            if (z4 && !this.f4504l) {
                e(this.f4506n + 1);
            } else {
                if (z4 || this.f4504l) {
                    return;
                }
                e(this.f4506n - 1);
            }
        }
    }

    public final void i(boolean z4) {
        if (this.f4504l != z4) {
            this.f4504l = z4;
            if (z4 && !this.f4505m) {
                e(this.f4506n + 1);
            } else {
                if (z4 || this.f4505m) {
                    return;
                }
                e(this.f4506n - 1);
            }
        }
    }

    public final void j() {
        v0 v0Var = this.f4507o;
        i0 i0Var = v0Var.f4607k;
        Object obj = v0Var.f4617u;
        f0 f0Var = this.f4493a;
        if ((obj != null || i0Var.a().g() != null) && v0Var.f4616t) {
            v0Var.f4616t = false;
            v0Var.f4617u = i0Var.a().g();
            f0 f0VarN = f0Var.n();
            if (f0VarN != null) {
                f0.M(f0VarN, false, 7);
            }
        }
        r0 r0Var = this.f4508p;
        if (r0Var != null) {
            i0 i0Var2 = r0Var.f4567k;
            if (r0Var.A == null) {
                n0 n0VarX0 = i0Var2.a().x0();
                q7.k.b(n0VarX0);
                if (n0VarX0.f4544t.g() == null) {
                    return;
                }
            }
            if (r0Var.f4582z) {
                r0Var.f4582z = false;
                n0 n0VarX02 = i0Var2.a().x0();
                q7.k.b(n0VarX02);
                r0Var.A = n0VarX02.f4544t.g();
                if (l.q(f0Var)) {
                    f0 f0VarN2 = f0Var.n();
                    if (f0VarN2 != null) {
                        f0.M(f0VarN2, false, 7);
                        return;
                    }
                    return;
                }
                f0 f0VarN3 = f0Var.n();
                if (f0VarN3 != null) {
                    f0.K(f0VarN3, false, 7);
                }
            }
        }
    }
}
