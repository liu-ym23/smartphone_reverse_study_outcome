package r;

/* loaded from: classes.dex */
public final class q extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1.s[] f8929g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r f8930h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8931i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i1.m0 f8932j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int[] f8933k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(g1.s[] sVarArr, r rVar, int i2, i1.m0 m0Var, int[] iArr) {
        super(1);
        this.f8929g = sVarArr;
        this.f8930h = rVar;
        this.f8931i = i2;
        this.f8932j = m0Var;
        this.f8933k = iArr;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g1.r rVar = (g1.r) obj;
        g1.s[] sVarArr = this.f8929g;
        int length = sVarArr.length;
        int i2 = 0;
        int i10 = 0;
        while (i2 < length) {
            g1.s sVar = sVarArr[i2];
            int i11 = i10 + 1;
            q7.k.b(sVar);
            sVar.g();
            d2.l lVarC0 = this.f8932j.c0();
            n0.c cVar = this.f8930h.f8936b;
            int i12 = this.f8931i - sVar.f3756f;
            float f10 = cVar.f6787a;
            float f11 = i12 / 2.0f;
            if (lVarC0 != d2.l.f2793f) {
                f10 *= -1;
            }
            g1.r.g(rVar, sVar, Math.round((1 + f10) * f11), this.f8933k[i10]);
            i2++;
            i10 = i11;
        }
        return c7.r.f1986a;
    }
}
