package r;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f8860a = new i0(i.f8866a, n0.b.f6781o);

    public static final i0 a(c cVar, n0.d dVar, b0.p pVar, int i2) {
        if (q7.k.a(cVar, i.f8866a) && dVar.equals(n0.b.f6781o)) {
            pVar.S(-849160037);
            pVar.q(false);
            return f8860a;
        }
        pVar.S(-849109166);
        boolean z4 = true;
        boolean z10 = (((i2 & 14) ^ 6) > 4 && pVar.f(cVar)) || (i2 & 6) == 4;
        if ((((i2 & 112) ^ 48) <= 32 || !pVar.f(dVar)) && (i2 & 48) != 32) {
            z4 = false;
        }
        boolean z11 = z10 | z4;
        Object objJ = pVar.J();
        if (z11 || objJ == b0.k.f1229a) {
            objJ = new i0(cVar, dVar);
            pVar.b0(objJ);
        }
        i0 i0Var = (i0) objJ;
        pVar.q(false);
        return i0Var;
    }
}
