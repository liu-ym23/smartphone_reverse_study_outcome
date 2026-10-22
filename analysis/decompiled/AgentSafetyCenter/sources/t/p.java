package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends yb.l implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f13048c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f13049f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.a f13050g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(boolean z10, String str, xb.a aVar) {
        super(3);
        this.f13048c = z10;
        this.f13049f = str;
        this.f13050g = aVar;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        v.k kVar;
        k0.s sVar = (k0.s) obj2;
        ((Number) obj3).intValue();
        sVar.X(-756081143);
        n0 n0Var = (n0) sVar.j(androidx.compose.foundation.c.f862a);
        if (n0Var instanceof t0) {
            sVar.X(617140216);
            sVar.q(false);
            kVar = null;
        } else {
            sVar.X(617248189);
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = t0.a.a();
                sVar.i0(objM);
            }
            kVar = (v.k) objM;
            sVar.q(false);
        }
        v.k kVar2 = kVar;
        w0.m mVarC = androidx.compose.foundation.a.c(w0.j.f15113c, kVar2, n0Var, this.f13048c, this.f13049f, null, this.f13050g);
        sVar.q(false);
        return mVarC;
    }
}
