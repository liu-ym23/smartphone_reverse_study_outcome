package rc;

/* loaded from: classes5.dex */
public class J extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public static final Cc.c f39104n = new Cc.c(102, 102, 102);

    /* renamed from: o, reason: collision with root package name */
    public static final Cc.c f39105o = new Cc.c(153, 153, 255);

    /* renamed from: p, reason: collision with root package name */
    public static final Cc.b f39106p = new Cc.b(3.8f, 0, 0, 4.0f);

    public J(float f10, float f11) {
        this.f39307f = 0.0f;
        this.f39306e = f11;
        this.f39305d = f10;
        this.f39308g = 0.0f;
    }

    public static void r(Cc.f fVar, float f10, float f11) {
        fVar.d(f39105o);
        fVar.l(f10, f11);
        fVar.n(0, 0, 8, 8, 0, 360);
        fVar.d(Cc.c.f1975j);
        fVar.s(0, 0, 8, 8, 0, 360);
        fVar.l(-f10, -f11);
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        Ec.a aVarC = fVar.c();
        Cc.c cVarK = fVar.k();
        Cc.j jVarI = fVar.i();
        float f12 = this.f39306e;
        fVar.l(((0.25f * f12) / 2.15f) + f10, f11 - (f12 * 0.81395346f));
        fVar.d(f39104n);
        fVar.v(f39106p);
        float f13 = this.f39306e;
        fVar.e((f13 * 0.05f) / 2.15f, (f13 * 0.05f) / 2.15f);
        fVar.p(-0.4537856055185257d, 20.5d, 17.5d);
        fVar.s(0, 0, 43, 32, 0, 360);
        fVar.p(0.4537856055185257d, 20.5d, 17.5d);
        fVar.v(jVarI);
        r(fVar, 16.0f, -5.0f);
        r(fVar, -1.0f, 7.0f);
        r(fVar, 5.0f, 28.0f);
        r(fVar, 27.0f, 24.0f);
        r(fVar, 36.0f, 3.0f);
        fVar.v(jVarI);
        fVar.f(aVarC);
        fVar.d(cVarK);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return 0;
    }
}
