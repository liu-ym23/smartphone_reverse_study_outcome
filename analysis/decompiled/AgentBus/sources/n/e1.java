package n;

/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6605a = 0;

    static {
        s7.a.G(c7.h.f1971g, d1.f6600g);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [p7.k, q7.m] */
    /* JADX WARN: Type inference failed for: r6v1, types: [p7.k, q7.m] */
    public static final u0 a(b1 b1Var, q6.b bVar, String str, b0.p pVar) {
        t0 t0Var;
        boolean zF = pVar.f(b1Var);
        Object objJ = pVar.J();
        Object obj = b0.k.f1229a;
        if (zF || objJ == obj) {
            objJ = new u0(str, b1Var, bVar);
            pVar.b0(objJ);
        }
        u0 u0Var = (u0) objJ;
        boolean zF2 = pVar.f(b1Var) | pVar.h(u0Var);
        Object objJ2 = pVar.J();
        if (zF2 || objJ2 == obj) {
            objJ2 = new g1.y(11, b1Var, u0Var);
            pVar.b0(objJ2);
        }
        b0.b.d(u0Var, (p7.k) objJ2, pVar);
        if (b1Var.g() && (t0Var = (t0) u0Var.f6739b.getValue()) != null) {
            b1 b1Var2 = u0Var.f6740c;
            t0Var.f6732f.g(t0Var.f6734h.invoke(b1Var2.f().f6741a), t0Var.f6734h.invoke(b1Var2.f().f6742b), (v) t0Var.f6733g.invoke(b1Var2.f()));
        }
        return u0Var;
    }
}
