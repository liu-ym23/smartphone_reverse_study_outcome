package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final v f15049a = new v(k.f14992c, w0.b.f15100q);

    public static final v a(h hVar, w0.c cVar, k0.s sVar, int i) {
        if (hVar.equals(k.f14992c) && cVar.equals(w0.b.f15100q)) {
            sVar.X(345884104);
            sVar.q(false);
            return f15049a;
        }
        sVar.X(345937951);
        boolean z10 = true;
        boolean z11 = (((i & 14) ^ 6) > 4 && sVar.f(hVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !sVar.f(cVar)) && (i & 48) != 32) {
            z10 = false;
        }
        boolean z12 = z11 | z10;
        Object objM = sVar.M();
        if (z12 || objM == k0.m.f6974a) {
            objM = new v(hVar, cVar);
            sVar.i0(objM);
        }
        v vVar = (v) objM;
        sVar.q(false);
        return vVar;
    }
}
