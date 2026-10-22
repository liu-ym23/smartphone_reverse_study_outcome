package n;

/* loaded from: classes.dex */
public final class r0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q7.v f6718g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f6719h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f6720i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f6721j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ p7.k f6722k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(q7.v vVar, float f10, e eVar, i iVar, p7.k kVar) {
        super(1);
        this.f6718g = vVar;
        this.f6719h = f10;
        this.f6720i = eVar;
        this.f6721j = iVar;
        this.f6722k = kVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        Object obj2 = this.f6718g.f8820f;
        q7.k.b(obj2);
        d.f((g) obj2, jLongValue, this.f6719h, this.f6720i, this.f6721j, this.f6722k);
        return c7.r.f1986a;
    }
}
