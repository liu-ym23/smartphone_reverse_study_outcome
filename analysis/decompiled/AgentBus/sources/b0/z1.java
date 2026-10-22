package b0;

/* loaded from: classes.dex */
public final class z1 {

    /* renamed from: a, reason: collision with root package name */
    public x f1441a;

    /* renamed from: b, reason: collision with root package name */
    public int f1442b;

    /* renamed from: c, reason: collision with root package name */
    public a f1443c;

    /* renamed from: d, reason: collision with root package name */
    public p7.n f1444d;

    /* renamed from: e, reason: collision with root package name */
    public int f1445e;

    /* renamed from: f, reason: collision with root package name */
    public k.y f1446f;

    /* renamed from: g, reason: collision with root package name */
    public k.a0 f1447g;

    public z1(x xVar) {
        this.f1441a = xVar;
    }

    public static boolean a(i0 i0Var, k.a0 a0Var) {
        q7.k.c(i0Var, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        return !q7.k.a(i0Var.g().f1170f, a0Var.g(i0Var));
    }

    public final boolean b() {
        if (this.f1441a != null) {
            a aVar = this.f1443c;
            if (aVar != null ? aVar.a() : false) {
                return true;
            }
        }
        return false;
    }

    public final t0 c(Object obj) {
        t0 t0VarN;
        x xVar = this.f1441a;
        return (xVar == null || (t0VarN = xVar.n(this, obj)) == null) ? t0.f1370f : t0VarN;
    }

    public final void d() {
        x xVar = this.f1441a;
        if (xVar != null) {
            xVar.f1407t = true;
            xVar.f1410w.getClass();
        }
        this.f1441a = null;
        this.f1446f = null;
        this.f1447g = null;
        this.f1444d = null;
    }

    public final void e(boolean z4) {
        int i2 = this.f1442b;
        this.f1442b = z4 ? i2 | 32 : i2 & (-33);
    }
}
