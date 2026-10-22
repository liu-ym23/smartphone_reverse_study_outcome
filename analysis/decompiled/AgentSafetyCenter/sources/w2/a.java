package w2;

import java.util.ArrayList;
import x2.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: p0, reason: collision with root package name */
    public e[] f15128p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f15129q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f15130r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f15131s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f15132t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f15133u0;

    public final void N(int i, ArrayList arrayList, m mVar) {
        for (int i3 = 0; i3 < this.f15129q0; i3++) {
            e eVar = this.f15128p0[i3];
            ArrayList arrayList2 = mVar.f15553a;
            if (!arrayList2.contains(eVar)) {
                arrayList2.add(eVar);
            }
        }
        for (int i10 = 0; i10 < this.f15129q0; i10++) {
            x2.g.b(this.f15128p0[i10], i, arrayList, mVar);
        }
    }

    public final boolean O() {
        int i;
        int i3;
        int i10;
        boolean z10 = true;
        int i11 = 0;
        while (true) {
            i = this.f15129q0;
            if (i11 >= i) {
                break;
            }
            e eVar = this.f15128p0[i11];
            if ((this.f15131s0 || eVar.c()) && ((((i3 = this.f15130r0) == 0 || i3 == 1) && !eVar.y()) || (((i10 = this.f15130r0) == 2 || i10 == 3) && !eVar.z()))) {
                z10 = false;
            }
            i11++;
        }
        if (!z10 || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i12 = 0; i12 < this.f15129q0; i12++) {
            e eVar2 = this.f15128p0[i12];
            if (this.f15131s0 || eVar2.c()) {
                if (!z11) {
                    int i13 = this.f15130r0;
                    if (i13 == 0) {
                        iMax = eVar2.g(2).c();
                    } else if (i13 == 1) {
                        iMax = eVar2.g(4).c();
                    } else if (i13 == 2) {
                        iMax = eVar2.g(3).c();
                    } else if (i13 == 3) {
                        iMax = eVar2.g(5).c();
                    }
                    z11 = true;
                }
                int i14 = this.f15130r0;
                if (i14 == 0) {
                    iMax = Math.min(iMax, eVar2.g(2).c());
                } else if (i14 == 1) {
                    iMax = Math.max(iMax, eVar2.g(4).c());
                } else if (i14 == 2) {
                    iMax = Math.min(iMax, eVar2.g(3).c());
                } else if (i14 == 3) {
                    iMax = Math.max(iMax, eVar2.g(5).c());
                }
            }
        }
        int i15 = iMax + this.f15132t0;
        int i16 = this.f15130r0;
        if (i16 == 0 || i16 == 1) {
            F(i15, i15);
        } else {
            G(i15, i15);
        }
        this.f15133u0 = true;
        return true;
    }

    public final int P() {
        int i = this.f15130r0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // w2.e
    public final void b(u2.c cVar, boolean z10) {
        boolean z11;
        int i;
        int i3;
        d[] dVarArr = this.P;
        d dVar = this.H;
        dVarArr[0] = dVar;
        int i10 = 2;
        d dVar2 = this.I;
        dVarArr[2] = dVar2;
        d dVar3 = this.J;
        dVarArr[1] = dVar3;
        d dVar4 = this.K;
        dVarArr[3] = dVar4;
        for (d dVar5 : dVarArr) {
            dVar5.i = cVar.k(dVar5);
        }
        int i11 = this.f15130r0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        d dVar6 = dVarArr[i11];
        if (!this.f15133u0) {
            O();
        }
        if (this.f15133u0) {
            this.f15133u0 = false;
            int i12 = this.f15130r0;
            if (i12 == 0 || i12 == 1) {
                cVar.d(dVar.i, this.X);
                cVar.d(dVar3.i, this.X);
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    cVar.d(dVar2.i, this.Y);
                    cVar.d(dVar4.i, this.Y);
                    return;
                }
                return;
            }
        }
        for (int i13 = 0; i13 < this.f15129q0; i13++) {
            e eVar = this.f15128p0[i13];
            if ((this.f15131s0 || eVar.c()) && ((((i3 = this.f15130r0) == 0 || i3 == 1) && eVar.f15184o0[0] == 3 && eVar.H.f15155f != null && eVar.J.f15155f != null) || ((i3 == 2 || i3 == 3) && eVar.f15184o0[1] == 3 && eVar.I.f15155f != null && eVar.K.f15155f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = dVar.e() || dVar3.e();
        boolean z13 = dVar2.e() || dVar4.e();
        int i14 = !(!z11 && (((i = this.f15130r0) == 0 && z12) || ((i == 2 && z13) || ((i == 1 && z12) || (i == 3 && z13))))) ? 4 : 5;
        int i15 = 0;
        while (i15 < this.f15129q0) {
            e eVar2 = this.f15128p0[i15];
            if (this.f15131s0 || eVar2.c()) {
                u2.e eVarK = cVar.k(eVar2.P[this.f15130r0]);
                d[] dVarArr2 = eVar2.P;
                int i16 = this.f15130r0;
                d dVar7 = dVarArr2[i16];
                dVar7.i = eVarK;
                d dVar8 = dVar7.f15155f;
                int i17 = (dVar8 == null || dVar8.f15153d != this) ? 0 : dVar7.f15156g;
                if (i16 == 0 || i16 == i10) {
                    u2.e eVar3 = dVar6.i;
                    int i18 = this.f15132t0 - i17;
                    u2.b bVarL = cVar.l();
                    u2.e eVarM = cVar.m();
                    eVarM.f14017h = 0;
                    bVarL.c(eVar3, eVarK, eVarM, i18);
                    cVar.c(bVarL);
                } else {
                    u2.e eVar4 = dVar6.i;
                    int i19 = this.f15132t0 + i17;
                    u2.b bVarL2 = cVar.l();
                    u2.e eVarM2 = cVar.m();
                    eVarM2.f14017h = 0;
                    bVarL2.b(eVar4, eVarK, eVarM2, i19);
                    cVar.c(bVarL2);
                }
                cVar.e(dVar6.i, eVarK, this.f15132t0 + i17, i14);
            }
            i15++;
            i10 = 2;
        }
        int i20 = this.f15130r0;
        if (i20 == 0) {
            cVar.e(dVar3.i, dVar.i, 0, 8);
            cVar.e(dVar.i, this.S.J.i, 0, 4);
            cVar.e(dVar.i, this.S.H.i, 0, 0);
            return;
        }
        if (i20 == 1) {
            cVar.e(dVar.i, dVar3.i, 0, 8);
            cVar.e(dVar.i, this.S.H.i, 0, 4);
            cVar.e(dVar.i, this.S.J.i, 0, 0);
        } else if (i20 == 2) {
            cVar.e(dVar4.i, dVar2.i, 0, 8);
            cVar.e(dVar2.i, this.S.K.i, 0, 4);
            cVar.e(dVar2.i, this.S.I.i, 0, 0);
        } else if (i20 == 3) {
            cVar.e(dVar2.i, dVar4.i, 0, 8);
            cVar.e(dVar2.i, this.S.I.i, 0, 4);
            cVar.e(dVar2.i, this.S.K.i, 0, 0);
        }
    }

    @Override // w2.e
    public final boolean c() {
        return true;
    }

    @Override // w2.e
    public final String toString() {
        String strN = androidx.activity.b.n(new StringBuilder("[Barrier] "), this.f15169g0, " {");
        for (int i = 0; i < this.f15129q0; i++) {
            e eVar = this.f15128p0[i];
            if (i > 0) {
                strN = strN.concat(", ");
            }
            StringBuilder sbC = c.c(strN);
            sbC.append(eVar.f15169g0);
            strN = sbC.toString();
        }
        return strN.concat("}");
    }

    @Override // w2.e
    public final boolean y() {
        return this.f15133u0;
    }

    @Override // w2.e
    public final boolean z() {
        return this.f15133u0;
    }
}
