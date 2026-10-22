package o;

/* loaded from: classes.dex */
public final class z0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a1 f7167g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f7168h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g1.s f7169i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(a1 a1Var, int i2, g1.s sVar) {
        super(1);
        this.f7167g = a1Var;
        this.f7168h = i2;
        this.f7169i = sVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g1.r rVar = (g1.r) obj;
        a1 a1Var = this.f7167g;
        int i2 = -nb.i.k(a1Var.f7014t.f7159f.e(), 0, this.f7168h);
        boolean z4 = a1Var.f7015u;
        int i10 = z4 ? 0 : i2;
        if (!z4) {
            i2 = 0;
        }
        rVar.f3755f = true;
        g1.r.k(rVar, this.f7169i, i10, i2);
        rVar.f3755f = false;
        return c7.r.f1986a;
    }
}
