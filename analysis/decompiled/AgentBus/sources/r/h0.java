package r;

/* loaded from: classes.dex */
public final class h0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1.s[] f8862g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i0 f8863h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8864i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int[] f8865j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(g1.s[] sVarArr, i0 i0Var, int i2, int[] iArr) {
        super(1);
        this.f8862g = sVarArr;
        this.f8863h = i0Var;
        this.f8864i = i2;
        this.f8865j = iArr;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g1.r rVar = (g1.r) obj;
        g1.s[] sVarArr = this.f8862g;
        int length = sVarArr.length;
        int i2 = 0;
        int i10 = 0;
        while (i2 < length) {
            g1.s sVar = sVarArr[i2];
            q7.k.b(sVar);
            sVar.g();
            g1.r.g(rVar, sVar, this.f8865j[i10], Math.round((1 + this.f8863h.f8871b.f6788a) * ((this.f8864i - sVar.f3757g) / 2.0f)));
            i2++;
            i10++;
        }
        return c7.r.f1986a;
    }
}
