package y;

/* loaded from: classes.dex */
public final class v extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0.m f11529g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f11530h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float f11531i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f11532j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f11533k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(n0.m mVar, long j2, float f10, long j4, int i2, int i10) {
        super(2);
        this.f11529g = mVar;
        this.f11530h = j2;
        this.f11531i = f10;
        this.f11532j = j4;
        this.f11533k = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iS = b0.b.s(439);
        y.a(this.f11529g, this.f11530h, this.f11531i, this.f11532j, this.f11533k, (b0.p) obj, iS);
        return c7.r.f1986a;
    }
}
