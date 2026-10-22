package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final r0 f15023a = new r0(k.f14990a, w0.b.f15097n);

    public static final r0 a(f fVar, w0.d dVar, k0.s sVar, int i) {
        if (fVar.equals(k.f14990a) && dVar.equals(w0.b.f15097n)) {
            sVar.X(-849160037);
            sVar.q(false);
            return f15023a;
        }
        sVar.X(-849109166);
        boolean z10 = true;
        boolean z11 = (((i & 14) ^ 6) > 4 && sVar.f(fVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !sVar.f(dVar)) && (i & 48) != 32) {
            z10 = false;
        }
        boolean z12 = z11 | z10;
        Object objM = sVar.M();
        if (z12 || objM == k0.m.f6974a) {
            objM = new r0(fVar, dVar);
            sVar.i0(objM);
        }
        r0 r0Var = (r0) objM;
        sVar.q(false);
        return r0Var;
    }
}
