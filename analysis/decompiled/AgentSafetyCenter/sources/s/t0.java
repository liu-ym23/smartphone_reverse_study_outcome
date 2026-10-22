package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yb.u f11122c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f11123f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f11124g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f11125h;
    public final /* synthetic */ i i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f11126j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ xb.l f11127k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(yb.u uVar, Object obj, e eVar, n nVar, i iVar, float f5, xb.l lVar) {
        super(1);
        this.f11122c = uVar;
        this.f11123f = obj;
        this.f11124g = eVar;
        this.f11125h = nVar;
        this.i = iVar;
        this.f11126j = f5;
        this.f11127k = lVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        e eVar = this.f11124g;
        g gVar = new g(this.f11123f, eVar.c(), this.f11125h, jLongValue, eVar.g(), jLongValue, new s0(0, this.i));
        d.j(gVar, jLongValue, this.f11126j, this.f11124g, this.i, this.f11127k);
        this.f11122c.f16098c = gVar;
        return jb.v.f6774a;
    }
}
