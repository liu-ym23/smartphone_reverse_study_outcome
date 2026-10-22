package m;

import n.b1;

/* loaded from: classes.dex */
public final class d extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b1 f6047g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n0.m f6048h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y f6049i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f6050j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ j0.d f6051k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6052l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b1 b1Var, n0.m mVar, y yVar, z zVar, j0.d dVar, int i2) {
        super(2);
        this.f6047g = b1Var;
        this.f6048h = mVar;
        this.f6049i = yVar;
        this.f6050j = zVar;
        this.f6051k = dVar;
        this.f6052l = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        androidx.compose.animation.a.a(this.f6047g, this.f6048h, this.f6049i, this.f6050j, this.f6051k, (b0.p) obj, b0.b.s(this.f6052l | 1));
        return c7.r.f1986a;
    }
}
