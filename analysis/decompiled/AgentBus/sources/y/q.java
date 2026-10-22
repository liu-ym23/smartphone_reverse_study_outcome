package y;

/* loaded from: classes.dex */
public final class q extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0.m f11514g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f11515h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f11516i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f11517j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f11518k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n0.m mVar, float f10, long j2, int i2, int i10) {
        super(2);
        this.f11514g = mVar;
        this.f11515h = f10;
        this.f11516i = j2;
        this.f11517j = i2;
        this.f11518k = i10;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        a0.b(this.f11514g, this.f11515h, this.f11516i, (b0.p) obj, b0.b.s(this.f11517j | 1), this.f11518k);
        return c7.r.f1986a;
    }
}
