package rc;

/* renamed from: rc.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5296n extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public final C5298o f39361n;

    /* renamed from: o, reason: collision with root package name */
    public final float f39362o;

    /* renamed from: p, reason: collision with root package name */
    public float f39363p;

    /* renamed from: q, reason: collision with root package name */
    public final char[] f39364q = new char[1];

    public C5296n(C5292l c5292l) {
        this.f39361n = c5292l.b();
        this.f39362o = c5292l.h().d();
        this.f39305d = c5292l.i();
        this.f39306e = c5292l.f();
        this.f39307f = c5292l.c();
        this.f39363p = c5292l.g();
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        Ec.a aVarC = fVar.c();
        fVar.l(f10, f11);
        Cc.e eVarF = F.f(this.f39361n.f39368b);
        if (Math.abs(this.f39362o - a1.f39202h) > 1.0E-7f) {
            float f12 = this.f39362o;
            float f13 = a1.f39202h;
            fVar.e(f12 / f13, f12 / f13);
        }
        if (fVar.a() != eVarF) {
            fVar.u(eVarF);
        }
        char[] cArr = this.f39364q;
        cArr[0] = this.f39361n.f39367a;
        fVar.b(cArr, 0, 1, 0, 0);
        fVar.f(aVarC);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39361n.f39368b;
    }

    public void r() {
        this.f39305d += this.f39363p;
        this.f39363p = 0.0f;
    }

    public String toString() {
        return super.toString() + "=" + this.f39361n.f39367a;
    }
}
