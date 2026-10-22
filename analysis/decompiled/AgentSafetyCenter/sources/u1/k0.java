package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public g0 f13843a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13844b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13845c;

    /* renamed from: d, reason: collision with root package name */
    public c0 f13846d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13847e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13848f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13849g;

    /* renamed from: h, reason: collision with root package name */
    public int f13850h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13851j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13852k;

    /* renamed from: l, reason: collision with root package name */
    public int f13853l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13854m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13855n;

    /* renamed from: o, reason: collision with root package name */
    public int f13856o;

    /* renamed from: p, reason: collision with root package name */
    public x0 f13857p;

    /* renamed from: q, reason: collision with root package name */
    public t0 f13858q;

    public final g1 a() {
        return this.f13843a.H.f13744d;
    }

    public final void b() {
        c0 c0Var = this.f13843a.I.f13846d;
        if (c0Var == c0.f13738g || c0Var == c0.f13739h) {
            if (this.f13857p.E) {
                g(true);
            } else {
                f(true);
            }
        }
        if (c0Var == c0.f13739h) {
            t0 t0Var = this.f13858q;
            if (t0Var == null || !t0Var.f13936y) {
                h(true);
            } else {
                i(true);
            }
        }
    }

    public final void c(long j10) {
        t0 t0Var = this.f13858q;
        if (t0Var != null) {
            c0 c0Var = c0.f13737f;
            k0 k0Var = t0Var.f13921j;
            k0Var.f13846d = c0Var;
            g0 g0Var = k0Var.f13843a;
            k0Var.f13847e = false;
            p1 snapshotObserver = ((v1.t) j0.a(g0Var)).getSnapshotObserver();
            r0 r0Var = new r0(t0Var, j10);
            snapshotObserver.getClass();
            if (g0Var.f13794k != null) {
                snapshotObserver.a(g0Var, snapshotObserver.f13896b, r0Var);
            } else {
                snapshotObserver.a(g0Var, snapshotObserver.f13897c, r0Var);
            }
            k0Var.f13848f = true;
            k0Var.f13849g = true;
            boolean zQ = f.q(g0Var);
            x0 x0Var = k0Var.f13857p;
            if (zQ) {
                x0Var.f13972z = true;
                x0Var.A = true;
            } else {
                x0Var.f13971y = true;
            }
            k0Var.f13846d = c0.i;
        }
    }

    public final void d(int i) {
        int i3 = this.f13853l;
        this.f13853l = i;
        if ((i3 == 0) != (i == 0)) {
            g0 g0VarT = this.f13843a.t();
            k0 k0Var = g0VarT != null ? g0VarT.I : null;
            if (k0Var != null) {
                int i10 = k0Var.f13853l;
                if (i == 0) {
                    k0Var.d(i10 - 1);
                } else {
                    k0Var.d(i10 + 1);
                }
            }
        }
    }

    public final void e(int i) {
        int i3 = this.f13856o;
        this.f13856o = i;
        if ((i3 == 0) != (i == 0)) {
            g0 g0VarT = this.f13843a.t();
            k0 k0Var = g0VarT != null ? g0VarT.I : null;
            if (k0Var != null) {
                int i10 = k0Var.f13856o;
                if (i == 0) {
                    k0Var.e(i10 - 1);
                } else {
                    k0Var.e(i10 + 1);
                }
            }
        }
    }

    public final void f(boolean z10) {
        if (this.f13852k != z10) {
            this.f13852k = z10;
            if (z10 && !this.f13851j) {
                d(this.f13853l + 1);
            } else {
                if (z10 || this.f13851j) {
                    return;
                }
                d(this.f13853l - 1);
            }
        }
    }

    public final void g(boolean z10) {
        if (this.f13851j != z10) {
            this.f13851j = z10;
            if (z10 && !this.f13852k) {
                d(this.f13853l + 1);
            } else {
                if (z10 || this.f13852k) {
                    return;
                }
                d(this.f13853l - 1);
            }
        }
    }

    public final void h(boolean z10) {
        if (this.f13855n != z10) {
            this.f13855n = z10;
            if (z10 && !this.f13854m) {
                e(this.f13856o + 1);
            } else {
                if (z10 || this.f13854m) {
                    return;
                }
                e(this.f13856o - 1);
            }
        }
    }

    public final void i(boolean z10) {
        if (this.f13854m != z10) {
            this.f13854m = z10;
            if (z10 && !this.f13855n) {
                e(this.f13856o + 1);
            } else {
                if (z10 || this.f13855n) {
                    return;
                }
                e(this.f13856o - 1);
            }
        }
    }

    public final void j() {
        g0 g0Var = this.f13843a;
        x0 x0Var = this.f13857p;
        k0 k0Var = x0Var.f13956j;
        if ((x0Var.f13968v != null || k0Var.a().v() != null) && x0Var.f13967u) {
            x0Var.f13967u = false;
            x0Var.f13968v = k0Var.a().v();
            g0 g0VarT = g0Var.t();
            if (g0VarT != null) {
                g0.V(g0VarT, false, 7);
            }
        }
        t0 t0Var = this.f13858q;
        if (t0Var != null) {
            k0 k0Var2 = t0Var.f13921j;
            if (t0Var.A == null) {
                p0 p0VarF0 = k0Var2.a().F0();
                p0VarF0.getClass();
                if (p0VarF0.f13889s.v() == null) {
                    return;
                }
            }
            if (t0Var.f13937z) {
                t0Var.f13937z = false;
                p0 p0VarF02 = k0Var2.a().F0();
                p0VarF02.getClass();
                t0Var.A = p0VarF02.f13889s.v();
                if (f.q(g0Var)) {
                    g0 g0VarT2 = g0Var.t();
                    if (g0VarT2 != null) {
                        g0.V(g0VarT2, false, 7);
                        return;
                    }
                    return;
                }
                g0 g0VarT3 = g0Var.t();
                if (g0VarT3 != null) {
                    g0.T(g0VarT3, false, 7);
                }
            }
        }
    }
}
