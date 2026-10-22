package r;

/* loaded from: classes.dex */
public final class x extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8946g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8947h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g1.s f8948i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8949j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i2, g1.s sVar, int i10) {
        super(1);
        this.f8947h = i2;
        this.f8948i = sVar;
        this.f8949j = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f8946g) {
            case 0:
                g1.r.g((g1.r) obj, this.f8948i, this.f8947h, this.f8949j);
                break;
            default:
                g1.r.g((g1.r) obj, this.f8948i, s7.a.U((this.f8947h - r0.f3756f) / 2.0f), s7.a.U((this.f8949j - r0.f3757g) / 2.0f));
                break;
        }
        return c7.r.f1986a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(g1.s sVar, int i2, int i10) {
        super(1);
        this.f8948i = sVar;
        this.f8947h = i2;
        this.f8949j = i10;
    }
}
