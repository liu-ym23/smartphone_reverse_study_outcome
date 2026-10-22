package i1;

import java.util.List;

/* loaded from: classes.dex */
public final class q extends n0 {
    @Override // i1.m0
    public final int S(g1.f fVar) {
        r0 r0Var = this.f4544t.f4437t.I.f4508p;
        q7.k.b(r0Var);
        g0 g0Var = r0Var.f4578v;
        i0 i0Var = r0Var.f4567k;
        if (i0Var.f4495c == b0.f4409g) {
            g0Var.f4482d = true;
            if (g0Var.f4480b) {
                i0Var.f4497e = true;
                i0Var.f4498f = true;
            }
        } else {
            g0Var.f4483e = true;
        }
        q qVar = r0Var.l().T;
        if (qVar != null) {
            qVar.f4532p = true;
        }
        r0Var.q();
        q qVar2 = r0Var.l().T;
        if (qVar2 != null) {
            qVar2.f4532p = false;
        }
        Integer num = (Integer) g0Var.f4485g.get(fVar);
        int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
        this.f4549y.h(iIntValue, fVar);
        return iIntValue;
    }

    @Override // g1.o
    public final g1.s b(long j2) {
        List listF;
        P(j2);
        d1 d1Var = this.f4544t;
        d0.e eVarS = d1Var.f4437t.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            r0 r0Var = ((f0) objArr[i10]).I.f4508p;
            q7.k.b(r0Var);
            r0Var.f4571o = d0.f4435h;
        }
        f0 f0Var = d1Var.f4437t;
        g1.p pVar = f0Var.f4472z;
        r0 r0Var2 = f0Var.I.f4508p;
        q7.k.b(r0Var2);
        d0.e eVar = r0Var2.f4579w;
        i0 i0Var = r0Var2.f4567k;
        i0Var.f4493a.i();
        if (r0Var2.f4580x) {
            f0 f0Var2 = i0Var.f4493a;
            d0.e eVarS2 = f0Var2.s();
            Object[] objArr2 = eVarS2.f2749f;
            int i11 = eVarS2.f2751h;
            for (int i12 = 0; i12 < i11; i12++) {
                f0 f0Var3 = (f0) objArr2[i12];
                if (eVar.f2751h <= i12) {
                    r0 r0Var3 = f0Var3.I.f4508p;
                    q7.k.b(r0Var3);
                    eVar.b(r0Var3);
                } else {
                    r0 r0Var4 = f0Var3.I.f4508p;
                    q7.k.b(r0Var4);
                    Object[] objArr3 = eVar.f2749f;
                    Object obj = objArr3[i12];
                    objArr3[i12] = r0Var4;
                }
            }
            eVar.k(((d0.b) f0Var2.i()).f2743f.f2751h, eVar.f2751h);
            r0Var2.f4580x = false;
            listF = eVar.f();
        } else {
            listF = eVar.f();
        }
        n0.o0(this, pVar.b(this, listF, j2));
        return this;
    }

    @Override // i1.n0
    public final void p0() {
        r0 r0Var = this.f4544t.f4437t.I.f4508p;
        q7.k.b(r0Var);
        r0Var.V();
    }
}
