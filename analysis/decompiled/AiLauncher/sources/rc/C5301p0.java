package rc;

/* renamed from: rc.p0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5301p0 extends H {
    public C5301p0(H h10) {
        super(h10.f39094n, h10.f39095o, h10.f39096p);
    }

    @Override // rc.H, rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        this.f39094n.c(fVar, this.f39096p + f10 + this.f39095o, f11);
        Cc.j jVarI = fVar.i();
        fVar.v(new Cc.b(this.f39095o, 0, 0));
        float f12 = this.f39095o;
        float f13 = f12 / 2.0f;
        float fMin = Math.min(this.f39305d - f12, (this.f39306e + this.f39307f) - f12) * 0.5f;
        float f14 = f10 + f13;
        float f15 = this.f39306e;
        float f16 = (f11 - f15) + f13;
        float f17 = this.f39305d;
        float f18 = this.f39095o;
        fVar.r(new Ec.e(f14, f16, f17 - f18, (f15 + this.f39307f) - f18, fMin, fMin));
        fVar.v(jVarI);
    }

    @Override // rc.H, rc.AbstractC5284h
    public int i() {
        return this.f39094n.i();
    }
}
