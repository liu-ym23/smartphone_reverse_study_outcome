package b0;

/* loaded from: classes.dex */
public final class n2 implements ia.b0, k2 {

    /* renamed from: i, reason: collision with root package name */
    public static final g f1246i = new g();

    /* renamed from: f, reason: collision with root package name */
    public final g7.l f1247f;

    /* renamed from: g, reason: collision with root package name */
    public final n2 f1248g = this;

    /* renamed from: h, reason: collision with root package name */
    public volatile g7.l f1249h;

    public n2(g7.l lVar) {
        this.f1247f = lVar;
    }

    public final void a() {
        synchronized (this.f1248g) {
            try {
                g7.l lVar = this.f1249h;
                if (lVar == null) {
                    this.f1249h = f1246i;
                } else {
                    n0 n0Var = new n0(0);
                    ia.g1 g1Var = (ia.g1) lVar.o(ia.z.f5027g);
                    if (g1Var != null) {
                        g1Var.d(n0Var);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // b0.k2
    public final void c() {
    }

    @Override // b0.k2
    public final void f() {
        a();
    }

    @Override // b0.k2
    public final void h() {
        a();
    }

    @Override // ia.b0
    public final g7.l k() {
        g7.l lVarQ;
        g7.l lVar = this.f1249h;
        if (lVar == null || lVar == f1246i) {
            m0.c cVar = (m0.c) this.f1247f.o(m0.c.f6123g);
            g7.l m2Var = cVar != null ? new m2(cVar, this) : g7.m.f3866f;
            synchronized (this.f1248g) {
                try {
                    g7.l lVar2 = this.f1249h;
                    if (lVar2 == null) {
                        g7.l lVar3 = this.f1247f;
                        lVarQ = lVar3.Q(new ia.i1((ia.g1) lVar3.o(ia.z.f5027g))).Q(g7.m.f3866f).Q(m2Var);
                    } else if (lVar2 == f1246i) {
                        g7.l lVar4 = this.f1247f;
                        ia.i1 i1Var = new ia.i1((ia.g1) lVar4.o(ia.z.f5027g));
                        i1Var.B(new n0(0));
                        lVarQ = lVar4.Q(i1Var).Q(g7.m.f3866f).Q(m2Var);
                    } else {
                        lVarQ = lVar2;
                    }
                    this.f1249h = lVarQ;
                } catch (Throwable th) {
                    throw th;
                }
            }
            lVar = lVarQ;
        }
        q7.k.b(lVar);
        return lVar;
    }
}
