package i1;

/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public n0.l f4631a;

    /* renamed from: b, reason: collision with root package name */
    public int f4632b;

    /* renamed from: c, reason: collision with root package name */
    public d0.e f4633c;

    /* renamed from: d, reason: collision with root package name */
    public d0.e f4634d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4635e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a1 f4636f;

    public y0(a1 a1Var, n0.l lVar, int i2, d0.e eVar, d0.e eVar2, boolean z4) {
        this.f4636f = a1Var;
        this.f4631a = lVar;
        this.f4632b = i2;
        this.f4633c = eVar;
        this.f4634d = eVar2;
        this.f4635e = z4;
    }

    public final boolean a(int i2, int i10) {
        d0.e eVar = this.f4633c;
        int i11 = this.f4632b;
        n0.k kVar = (n0.k) eVar.f2749f[i2 + i11];
        n0.k kVar2 = (n0.k) this.f4634d.f2749f[i11 + i10];
        return q7.k.a(kVar, kVar2) || kVar.getClass() == kVar2.getClass();
    }
}
