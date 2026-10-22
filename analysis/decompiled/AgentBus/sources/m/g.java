package m;

/* loaded from: classes.dex */
public final class g extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f6062g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n0.m f6063h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y f6064i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f6065j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f6066k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j0.d f6067l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(boolean z4, n0.m mVar, y yVar, z zVar, String str, j0.d dVar, int i2) {
        super(2);
        this.f6062g = z4;
        this.f6063h = mVar;
        this.f6064i = yVar;
        this.f6065j = zVar;
        this.f6066k = str;
        this.f6067l = dVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iS = b0.b.s(1600519);
        androidx.compose.animation.a.b(this.f6062g, this.f6063h, this.f6064i, this.f6065j, this.f6066k, this.f6067l, (b0.p) obj, iS);
        return c7.r.f1986a;
    }
}
