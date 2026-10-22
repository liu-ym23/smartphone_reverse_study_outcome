package n;

/* loaded from: classes.dex */
public final class q0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q7.v f6706g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6707h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f6708i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ n f6709j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f6710k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ float f6711l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ p7.k f6712m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(q7.v vVar, Object obj, e eVar, n nVar, i iVar, float f10, p7.k kVar) {
        super(1);
        this.f6706g = vVar;
        this.f6707h = obj;
        this.f6708i = eVar;
        this.f6709j = nVar;
        this.f6710k = iVar;
        this.f6711l = f10;
        this.f6712m = kVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        e eVar = this.f6708i;
        g gVar = new g(this.f6707h, eVar.e(), this.f6709j, jLongValue, eVar.f(), jLongValue, new p0(this.f6710k, 0));
        d.f(gVar, jLongValue, this.f6711l, this.f6708i, this.f6710k, this.f6712m);
        this.f6706g.f8820f = gVar;
        return c7.r.f1986a;
    }
}
