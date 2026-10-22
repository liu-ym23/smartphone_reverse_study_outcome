package rc;

/* loaded from: classes5.dex */
public class X extends AbstractC5284h {

    /* renamed from: p, reason: collision with root package name */
    public static Cc.e f39177p = new Cc.e("Serif", 0, 10);

    /* renamed from: n, reason: collision with root package name */
    public Dc.b f39178n;

    /* renamed from: o, reason: collision with root package name */
    public float f39179o;

    public X(String str, int i10, float f10, Cc.e eVar, boolean z10) {
        this.f39179o = f10;
        Dc.b bVar = new Dc.b(str, eVar.d(i10), null);
        this.f39178n = bVar;
        Ec.d dVarB = bVar.b();
        this.f39306e = ((-dVarB.d()) * f10) / 10.0f;
        this.f39307f = ((dVarB.a() * f10) / 10.0f) - this.f39306e;
        this.f39305d = (((dVarB.b() + dVarB.c()) + 0.4f) * f10) / 10.0f;
    }

    public static void r(String str) {
        f39177p = new Cc.e(str, 0, 10);
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        fVar.l(f10, f11);
        float f12 = this.f39179o;
        fVar.e(f12 * 0.1d, f12 * 0.1d);
        this.f39178n.a(fVar, 0, 0);
        float f13 = this.f39179o;
        fVar.e(10.0f / f13, 10.0f / f13);
        fVar.l(-f10, -f11);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return 0;
    }

    public X(String str, int i10, float f10) {
        this(str, i10, f10, f39177p, true);
    }
}
