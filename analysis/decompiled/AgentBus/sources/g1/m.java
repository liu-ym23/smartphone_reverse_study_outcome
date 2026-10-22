package g1;

import i1.m0;

/* loaded from: classes.dex */
public final class m extends r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3751g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3752h;

    public /* synthetic */ m(int i2, Object obj) {
        this.f3751g = i2;
        this.f3752h = obj;
    }

    @Override // g1.r
    public float b(h hVar) {
        float fIntBitsToFloat;
        int iL0;
        switch (this.f3751g) {
            case 0:
                p7.n nVar = hVar.f3735a;
                if (nVar != null) {
                    return ((Number) nVar.invoke(this, Float.valueOf(Float.NaN))).floatValue();
                }
                m0 m0Var = (m0) this.f3752h;
                if (m0Var.f4532p) {
                    return Float.NaN;
                }
                m0 m0Var2 = m0Var;
                while (true) {
                    eb.p pVar = m0Var2.f4534r;
                    if (!Float.isNaN((pVar == null || (iL0 = d7.n.l0((h[]) pVar.f3319b, hVar)) < 0) ? Float.NaN : ((float[]) pVar.f3320c)[iL0])) {
                        m0Var2.Q(m0Var.d0(), hVar);
                        k kVarA0 = m0Var2.a0();
                        k kVarA02 = m0Var.a0();
                        switch (hVar.f3736b) {
                            case 0:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (kVarA02.e(kVarA0, (Float.floatToRawIntBits(r2) & 4294967295L) | (Float.floatToRawIntBits(((int) (kVarA0.x() >> 32)) / 2.0f) << 32)) & 4294967295L));
                                break;
                            default:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (kVarA02.e(kVarA0, (Float.floatToRawIntBits(r2) << 32) | (Float.floatToRawIntBits(((int) (kVarA0.x() & 4294967295L)) / 2.0f) & 4294967295L)) >> 32));
                                break;
                        }
                        return fIntBitsToFloat;
                    }
                    m0 m0VarF0 = m0Var2.f0();
                    if (m0VarF0 == null) {
                        m0Var2.Q(m0Var.d0(), hVar);
                        return Float.NaN;
                    }
                    m0Var2 = m0VarF0;
                }
                break;
            default:
                return super.b(hVar);
        }
    }

    @Override // d2.c
    public final float c() {
        switch (this.f3751g) {
            case 0:
                return ((m0) this.f3752h).c();
            default:
                return ((j1.y) this.f3752h).getDensity().c();
        }
    }

    @Override // g1.r
    public final d2.l e() {
        switch (this.f3751g) {
            case 0:
                return ((m0) this.f3752h).c0();
            default:
                return ((j1.y) this.f3752h).getLayoutDirection();
        }
    }

    @Override // g1.r
    public final int f() {
        switch (this.f3751g) {
            case 0:
                return ((m0) this.f3752h).G();
            default:
                return ((j1.y) this.f3752h).getRoot().I.f4507o.f3756f;
        }
    }

    @Override // d2.c
    public final float j() {
        switch (this.f3751g) {
            case 0:
                return ((m0) this.f3752h).j();
            default:
                return ((j1.y) this.f3752h).getDensity().j();
        }
    }
}
