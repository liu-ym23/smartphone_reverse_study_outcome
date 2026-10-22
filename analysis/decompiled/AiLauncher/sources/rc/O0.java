package rc;

import Ec.d;

/* loaded from: classes5.dex */
public class O0 extends H {

    /* renamed from: s, reason: collision with root package name */
    public float f39142s;

    public O0(H h10, float f10) {
        super(h10.f39094n, h10.f39095o, h10.f39096p);
        this.f39142s = f10;
        this.f39307f += f10;
        this.f39305d += f10;
    }

    @Override // rc.H, rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        float f12 = this.f39095o;
        float f13 = f12 / 2.0f;
        this.f39094n.c(fVar, this.f39096p + f10 + f12, f11);
        Cc.j jVarI = fVar.i();
        fVar.v(new Cc.b(this.f39095o, 0, 0));
        float f14 = this.f39306e;
        float f15 = this.f39305d;
        float f16 = this.f39142s;
        float f17 = this.f39095o;
        fVar.h(new d.a(f10 + f13, (f11 - f14) + f13, (f15 - f16) - f17, ((f14 + this.f39307f) - f16) - f17));
        float fAbs = (float) Math.abs(1.0d / fVar.c().g());
        fVar.v(new Cc.b(fAbs, 0, 0));
        float f18 = this.f39142s;
        fVar.j(new d.a((f10 + f18) - fAbs, ((this.f39307f + f11) - f18) - fAbs, this.f39305d - f18, f18));
        float f19 = f10 + this.f39305d;
        float f20 = this.f39142s;
        float f21 = (f19 - f20) - fAbs;
        float f22 = this.f39306e;
        fVar.j(new d.a(f21, (f11 - f22) + f13 + f20, f20, ((this.f39307f + f22) - (2.0f * f20)) - f13));
        fVar.v(jVarI);
    }

    @Override // rc.H, rc.AbstractC5284h
    public int i() {
        return this.f39094n.i();
    }
}
