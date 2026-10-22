package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5138c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w.l0 f5139f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s0.c f5140g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(long j10, w.l0 l0Var, s0.c cVar) {
        super(2);
        this.f5138c = j10;
        this.f5139f = l0Var;
        this.f5140g = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            p5.f.c(this.f5138c, ((v1) sVar.j(w1.f5235a)).f5223m, s0.h.d(1327513942, new k(1, this.f5139f, this.f5140g), sVar), sVar, 384);
        }
        return jb.v.f6774a;
    }
}
