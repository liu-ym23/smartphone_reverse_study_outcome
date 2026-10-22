package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ xb.p f5004c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.p f5005f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d1.j0 f5006g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f5007h;
    public final /* synthetic */ float i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f5008j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f5009k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5010l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ xb.p f5011m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ s0.c f5012n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(xb.p pVar, xb.p pVar2, d1.j0 j0Var, long j10, float f5, long j11, long j12, long j13, xb.p pVar3, s0.c cVar) {
        super(2);
        this.f5004c = pVar;
        this.f5005f = pVar2;
        this.f5006g = j0Var;
        this.f5007h = j10;
        this.i = f5;
        this.f5008j = j11;
        this.f5009k = j12;
        this.f5010l = j13;
        this.f5011m = pVar3;
        this.f5012n = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            s0.c cVarD = s0.h.d(1163543932, new h(this.f5011m, this.f5012n, 1), sVar);
            int i = j0.c.f6421a;
            m.a(cVarD, null, this.f5004c, this.f5005f, this.f5006g, this.f5007h, this.i, b0.e(26, sVar), this.f5008j, this.f5009k, this.f5010l, sVar, 6);
        }
        return jb.v.f6774a;
    }
}
