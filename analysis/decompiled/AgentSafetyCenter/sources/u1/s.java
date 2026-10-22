package u1;

import android.graphics.Paint;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends g1 {
    public static final d1.f T;
    public x1 R;
    public r S;

    static {
        d1.f fVarF = d1.f0.f();
        fVarF.e(d1.p.f3021d);
        ((Paint) fVarF.f2968b).setStrokeWidth(1.0f);
        fVarF.j(1);
        T = fVarF;
    }

    @Override // u1.g1
    public final void C0() {
        if (this.S == null) {
            this.S = new r(this);
        }
    }

    @Override // u1.g1
    public final p0 F0() {
        return this.S;
    }

    @Override // u1.g1
    public final w0.l H0() {
        return this.R;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [m0.e] */
    @Override // u1.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N0(u1.d r18, long r19, u1.q r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.s.N0(u1.d, long, u1.q, int, boolean):void");
    }

    @Override // s1.o0
    public final void R(long j10, float f5, xb.l lVar) {
        W0(j10, f5, lVar);
        if (this.f13881n) {
            return;
        }
        this.f13810s.I.f13857p.f0();
    }

    @Override // u1.g1
    public final void V0(d1.o oVar, g1.b bVar) {
        g0 g0Var = this.f13810s;
        n1 n1VarA = j0.a(g0Var);
        m0.e eVarW = g0Var.w();
        Object[] objArr = eVarW.f8158c;
        int i = eVarW.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (g0Var2.H()) {
                g0Var2.i(oVar, bVar);
            }
        }
        if (((v1.t) n1VarA).getShowLayoutBounds()) {
            long j10 = this.f11279g;
            oVar.b(0.5f, 0.5f, ((int) (j10 >> 32)) - 0.5f, ((int) (j10 & 4294967295L)) - 0.5f, T);
        }
    }

    @Override // u1.o0
    public final int b0(s1.l lVar) {
        r rVar = this.S;
        if (rVar != null) {
            return rVar.b0(lVar);
        }
        x0 x0Var = this.f13810s.I.f13857p;
        h0 h0Var = x0Var.B;
        if (!x0Var.f13963q) {
            if (x0Var.f13956j.f13846d == c0.f13736c) {
                h0Var.f13827f = true;
                if (h0Var.f13823b) {
                    x0Var.f13972z = true;
                    x0Var.A = true;
                }
            } else {
                h0Var.f13828g = true;
            }
        }
        x0Var.f().f13882o = true;
        x0Var.z();
        x0Var.f().f13882o = false;
        Integer num = (Integer) h0Var.i.get(lVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // s1.e0
    public final s1.o0 q(long j10) {
        U(j10);
        g0 g0Var = this.f13810s;
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            ((g0) objArr[i3]).I.f13857p.f13962p = e0.f13767g;
        }
        Z0(g0Var.f13809z.c(this, g0Var.I.f13857p.Z(), j10));
        S0();
        return this;
    }
}
