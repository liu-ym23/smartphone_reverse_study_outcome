package p;

/* loaded from: classes.dex */
public final class v0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f8194a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0 f8195b;

    public v0(y0 y0Var, w0 w0Var) {
        this.f8194a = y0Var;
        this.f8195b = w0Var;
    }

    @Override // p.i0
    public final float a(float f10) {
        y0 y0Var = this.f8194a;
        long jD = y0Var.d(y0Var.g(f10));
        y0 y0Var2 = this.f8195b.f8200a;
        y0Var2.f8222g = 2;
        o.t0 t0Var = y0Var2.f8217b;
        return y0Var.c(y0Var.f((t0Var == null || !(y0Var2.f8216a.l() || y0Var2.f8216a.a())) ? y0.a(y0Var2, y0Var2.f8223h, jD, 2) : t0Var.d(jD, y0Var2.f8222g, y0Var2.f8225j)));
    }
}
