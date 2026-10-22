package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends p0 {
    @Override // u1.o0
    public final int b0(s1.l lVar) {
        t0 t0Var = this.f13889s.f13810s.I.f13858q;
        t0Var.getClass();
        h0 h0Var = t0Var.f13933v;
        if (!t0Var.f13926o) {
            k0 k0Var = t0Var.f13921j;
            if (k0Var.f13846d == c0.f13737f) {
                h0Var.f13827f = true;
                if (h0Var.f13823b) {
                    k0Var.f13848f = true;
                    k0Var.f13849g = true;
                }
            } else {
                h0Var.f13828g = true;
            }
        }
        r rVar = t0Var.f().S;
        if (rVar != null) {
            rVar.f13882o = true;
        }
        t0Var.z();
        r rVar2 = t0Var.f().S;
        if (rVar2 != null) {
            rVar2.f13882o = false;
        }
        Integer num = (Integer) h0Var.i.get(lVar);
        int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
        this.f13894x.h(iIntValue, lVar);
        return iIntValue;
    }

    @Override // s1.e0
    public final s1.o0 q(long j10) {
        U(j10);
        g1 g1Var = this.f13889s;
        m0.e eVarX = g1Var.f13810s.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            t0 t0Var = ((g0) objArr[i3]).I.f13858q;
            t0Var.getClass();
            t0Var.f13925n = e0.f13767g;
        }
        g0 g0Var = g1Var.f13810s;
        p0.w0(this, g0Var.f13809z.c(this, g0Var.l(), j10));
        return this;
    }

    @Override // u1.p0
    public final void x0() {
        t0 t0Var = this.f13889s.f13810s.I.f13858q;
        t0Var.getClass();
        t0Var.d0();
    }
}
