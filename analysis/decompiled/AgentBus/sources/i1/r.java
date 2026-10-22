package i1;

import android.graphics.Paint;
import java.util.List;

/* loaded from: classes.dex */
public final class r extends d1 {
    public static final h4.s U;
    public final u1 S;
    public q T;

    static {
        h4.s sVarE = u0.z.e();
        sVarE.e(u0.m.f9913c);
        ((Paint) sVarE.f4155g).setStrokeWidth(1.0f);
        sVarE.k(1);
        U = sVarE;
    }

    public r(f0 f0Var) {
        super(f0Var);
        u1 u1Var = new u1();
        u1Var.f6800i = 0;
        this.S = u1Var;
        u1Var.f6804m = this;
        this.T = f0Var.f4458l != null ? new q(this) : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [d0.e] */
    @Override // i1.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F0(i1.b1 r18, long r19, i1.p r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.r.F0(i1.b1, long, i1.p, int, boolean):void");
    }

    @Override // g1.s
    public final void M(long j2, float f10, p7.k kVar) {
        Q0(j2, f10, kVar);
        if (this.f4531o) {
            return;
        }
        this.f4437t.I.f4507o.V();
    }

    @Override // i1.d1
    public final void P0(u0.l lVar, x0.b bVar) {
        f0 f0Var = this.f4437t;
        k1 k1VarW = l.w(f0Var);
        d0.e eVarR = f0Var.r();
        Object[] objArr = eVarR.f2749f;
        int i2 = eVarR.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            if (f0Var2.C()) {
                f0Var2.g(lVar, bVar);
            }
        }
        if (((j1.y) k1VarW).getShowLayoutBounds()) {
            long j2 = this.f3758h;
            lVar.l(0.5f, 0.5f, ((int) (j2 >> 32)) - 0.5f, ((int) (j2 & 4294967295L)) - 0.5f, U);
        }
    }

    @Override // i1.m0
    public final int S(g1.f fVar) {
        q qVar = this.T;
        if (qVar != null) {
            return qVar.S(fVar);
        }
        v0 v0Var = this.f4437t.I.f4507o;
        g0 g0Var = v0Var.A;
        if (v0Var.f4607k.f4495c == b0.f4408f) {
            g0Var.f4482d = true;
            if (g0Var.f4480b) {
                v0Var.f4621y = true;
                v0Var.f4622z = true;
            }
        } else {
            g0Var.f4483e = true;
        }
        v0Var.l().f4532p = true;
        v0Var.q();
        v0Var.l().f4532p = false;
        Integer num = (Integer) g0Var.f4485g.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // g1.o
    public final g1.s b(long j2) {
        List listF;
        P(j2);
        f0 f0Var = this.f4437t;
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((f0) objArr[i10]).I.f4507o.f4613q = d0.f4435h;
        }
        g1.p pVar = f0Var.f4472z;
        v0 v0Var = f0Var.I.f4507o;
        d0.e eVar = v0Var.B;
        i0 i0Var = v0Var.f4607k;
        i0Var.f4493a.V();
        if (v0Var.C) {
            f0 f0Var2 = i0Var.f4493a;
            d0.e eVarS2 = f0Var2.s();
            Object[] objArr2 = eVarS2.f2749f;
            int i11 = eVarS2.f2751h;
            for (int i12 = 0; i12 < i11; i12++) {
                f0 f0Var3 = (f0) objArr2[i12];
                if (eVar.f2751h <= i12) {
                    eVar.b(f0Var3.I.f4507o);
                } else {
                    v0 v0Var2 = f0Var3.I.f4507o;
                    Object[] objArr3 = eVar.f2749f;
                    Object obj = objArr3[i12];
                    objArr3[i12] = v0Var2;
                }
            }
            eVar.k(((d0.b) f0Var2.i()).f2743f.f2751h, eVar.f2751h);
            v0Var.C = false;
            listF = eVar.f();
        } else {
            listF = eVar.f();
        }
        T0(pVar.b(this, listF, j2));
        L0();
        return this;
    }

    @Override // i1.d1
    public final void u0() {
        if (this.T == null) {
            this.T = new q(this);
        }
    }

    @Override // i1.d1
    public final n0 x0() {
        return this.T;
    }

    @Override // i1.d1
    public final n0.l z0() {
        return this.S;
    }
}
