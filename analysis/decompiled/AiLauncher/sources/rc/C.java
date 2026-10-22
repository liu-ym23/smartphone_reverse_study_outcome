package rc;

/* loaded from: classes5.dex */
public class C extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public int f39024n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f39025o;

    /* renamed from: p, reason: collision with root package name */
    public float f39026p;

    /* renamed from: q, reason: collision with root package name */
    public float f39027q;

    public C(int i10, float f10, float f11, float f12, boolean z10) {
        this.f39024n = i10;
        this.f39305d = (i10 * (f11 + f12)) + (2.0f * f12);
        this.f39306e = f10;
        this.f39307f = 0.0f;
        this.f39025o = z10;
        this.f39026p = f12;
        this.f39027q = f11;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        Ec.a aVarC = fVar.c();
        Cc.j jVarI = fVar.i();
        double dG = aVarC.g();
        double dH = aVarC.h();
        if (dG == dH) {
            Ec.a aVarClone = aVarC.clone();
            aVarClone.k(1.0d / dG, 1.0d / dH);
            fVar.f(aVarClone);
        } else {
            dG = 1.0d;
        }
        int i10 = 0;
        fVar.v(new Cc.b((float) (this.f39027q * dG), 0, 0));
        float f12 = 2.0f;
        float f13 = this.f39027q / 2.0f;
        Ec.b bVar = new Ec.b();
        float f14 = this.f39026p;
        float f15 = (float) (((f10 + f14) * dG) + ((f14 / 2.0f) * dG));
        int iRound = (int) Math.round((f14 + this.f39027q) * dG);
        while (i10 < this.f39024n) {
            double d10 = f15 + (f13 * dG);
            double d11 = dG;
            int i11 = iRound;
            bVar.a(d10, (f11 - this.f39306e) * dG, d10, f11 * d11);
            fVar.t(bVar);
            f15 += i11;
            i10++;
            iRound = i11;
            f12 = f12;
            dG = d11;
        }
        double d12 = dG;
        float f16 = f12;
        float f17 = f15;
        if (this.f39025o) {
            float f18 = this.f39026p;
            float f19 = this.f39306e;
            bVar.a((f10 + f18) * d12, (f11 - (f19 / f16)) * d12, f17 - ((f18 * d12) / 2.0d), (f11 - (f19 / f16)) * d12);
            fVar.t(bVar);
        }
        fVar.f(aVarC);
        fVar.v(jVarI);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return -1;
    }
}
