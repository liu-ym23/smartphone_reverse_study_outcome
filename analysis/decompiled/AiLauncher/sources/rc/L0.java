package rc;

/* loaded from: classes5.dex */
public class L0 extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public AbstractC5284h f39124n;

    /* renamed from: o, reason: collision with root package name */
    public double f39125o;

    /* renamed from: p, reason: collision with root package name */
    public double f39126p;

    public L0(AbstractC5284h abstractC5284h, double d10, double d11) {
        this.f39124n = abstractC5284h;
        this.f39125o = (Double.isNaN(d10) || Double.isInfinite(d10)) ? 0.0d : d10;
        this.f39126p = (Double.isNaN(d11) || Double.isInfinite(d11)) ? 0.0d : d11;
        this.f39305d = abstractC5284h.f39305d * ((float) Math.abs(this.f39125o));
        double d12 = this.f39126p;
        this.f39306e = (d12 > 0.0d ? abstractC5284h.f39306e : -abstractC5284h.f39307f) * ((float) d12);
        this.f39307f = (d12 > 0.0d ? abstractC5284h.f39307f : -abstractC5284h.f39306e) * ((float) d12);
        this.f39308g = abstractC5284h.f39308g * ((float) d12);
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        double d10 = this.f39125o;
        if (d10 == 0.0d || this.f39126p == 0.0d) {
            return;
        }
        float f12 = d10 < 0.0d ? this.f39305d : 0.0f;
        fVar.l(f10 + f12, f11);
        fVar.e(this.f39125o, this.f39126p);
        this.f39124n.c(fVar, 0.0f, 0.0f);
        fVar.e(1.0d / this.f39125o, 1.0d / this.f39126p);
        fVar.l((-f10) - f12, -f11);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39124n.i();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public L0(AbstractC5284h abstractC5284h, float f10) {
        double d10 = f10;
        this(abstractC5284h, d10, d10);
    }
}
