package r;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final r f8907a = new r(i.f8867b, n0.b.f6784r);

    public static final r a(g gVar, n0.c cVar, b0.p pVar, int i2) {
        if (gVar.equals(i.f8867b) && cVar.equals(n0.b.f6784r)) {
            pVar.S(345884104);
            pVar.q(false);
            return f8907a;
        }
        pVar.S(345937951);
        boolean z4 = true;
        boolean z10 = (((i2 & 14) ^ 6) > 4 && pVar.f(gVar)) || (i2 & 6) == 4;
        if ((((i2 & 112) ^ 48) <= 32 || !pVar.f(cVar)) && (i2 & 48) != 32) {
            z4 = false;
        }
        boolean z11 = z10 | z4;
        Object objJ = pVar.J();
        if (z11 || objJ == b0.k.f1229a) {
            objJ = new r(gVar, cVar);
            pVar.b0(objJ);
        }
        r rVar = (r) objJ;
        pVar.q(false);
        return rVar;
    }
}
