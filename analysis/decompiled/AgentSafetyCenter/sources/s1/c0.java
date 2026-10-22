package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends n0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11221f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11222g;

    public /* synthetic */ c0(int i) {
        this.f11221f = i;
    }

    @Override // o2.c
    public final float T() {
        switch (this.f11221f) {
            case 0:
                return ((u1.o0) this.f11222g).T();
            default:
                return ((v1.t) this.f11222g).getDensity().T();
        }
    }

    @Override // o2.c
    public final float a() {
        switch (this.f11221f) {
            case 0:
                return ((u1.o0) this.f11222g).a();
            default:
                return ((v1.t) this.f11222g).getDensity().a();
        }
    }

    @Override // s1.n0
    public float c(n nVar) {
        float fIntBitsToFloat;
        int iR0;
        switch (this.f11221f) {
            case 0:
                xb.p pVar = nVar.f11268a;
                if (pVar != null) {
                    return ((Number) pVar.invoke(this, Float.valueOf(Float.NaN))).floatValue();
                }
                u1.o0 o0Var = (u1.o0) this.f11222g;
                if (o0Var.f13882o) {
                    return Float.NaN;
                }
                u1.o0 o0Var2 = o0Var;
                while (true) {
                    ed.o oVar = o0Var2.f13884q;
                    if (!Float.isNaN((oVar == null || (iR0 = kb.k.r0((n[]) oVar.f3838b, nVar)) < 0) ? Float.NaN : ((float[]) oVar.f3839c)[iR0])) {
                        o0Var2.Z(o0Var.o0(), nVar);
                        q qVarH0 = o0Var2.h0();
                        q qVarH02 = o0Var.h0();
                        switch (nVar.f11269b) {
                            case 0:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (qVarH02.B(qVarH0, (Float.floatToRawIntBits(r2) & 4294967295L) | (Float.floatToRawIntBits(((int) (qVarH0.l() >> 32)) / 2.0f) << 32)) & 4294967295L));
                                break;
                            default:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (qVarH02.B(qVarH0, (Float.floatToRawIntBits(r2) << 32) | (Float.floatToRawIntBits(((int) (qVarH0.l() & 4294967295L)) / 2.0f) & 4294967295L)) >> 32));
                                break;
                        }
                        return fIntBitsToFloat;
                    }
                    u1.o0 o0VarQ0 = o0Var2.q0();
                    if (o0VarQ0 == null) {
                        o0Var2.Z(o0Var.o0(), nVar);
                        return Float.NaN;
                    }
                    o0Var2 = o0VarQ0;
                }
                break;
            default:
                return super.c(nVar);
        }
    }

    @Override // s1.n0
    public final o2.l d() {
        switch (this.f11221f) {
            case 0:
                return ((u1.o0) this.f11222g).getLayoutDirection();
            default:
                return ((v1.t) this.f11222g).getLayoutDirection();
        }
    }

    @Override // s1.n0
    public final int f() {
        switch (this.f11221f) {
            case 0:
                return ((u1.o0) this.f11222g).L();
            default:
                return ((v1.t) this.f11222g).getRoot().I.f13857p.f11277c;
        }
    }
}
