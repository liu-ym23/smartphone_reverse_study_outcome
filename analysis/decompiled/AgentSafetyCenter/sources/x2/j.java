package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f15547k = new int[2];

    public static void m(int[] iArr, int i, int i3, int i10, int i11, float f5, int i12) {
        int i13 = i3 - i;
        int i14 = i11 - i10;
        if (i12 != -1) {
            if (i12 == 0) {
                iArr[0] = (int) ((i14 * f5) + 0.5f);
                iArr[1] = i14;
                return;
            } else {
                if (i12 != 1) {
                    return;
                }
                iArr[0] = i13;
                iArr[1] = (int) ((i13 * f5) + 0.5f);
                return;
            }
        }
        int i15 = (int) ((i14 * f5) + 0.5f);
        int i16 = (int) ((i13 / f5) + 0.5f);
        if (i15 <= i13) {
            iArr[0] = i15;
            iArr[1] = i14;
        } else if (i16 <= i14) {
            iArr[0] = i13;
            iArr[1] = i16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // x2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(x2.d r24) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.j.a(x2.d):void");
    }

    @Override // x2.n
    public final void d() {
        w2.e eVar;
        w2.e eVar2;
        int i;
        w2.e eVar3;
        w2.e eVar4;
        int i3;
        w2.e eVar5 = this.f15559b;
        boolean z10 = eVar5.f15158a;
        f fVar = this.f15562e;
        if (z10) {
            fVar.d(eVar5.o());
        }
        boolean z11 = fVar.f15542j;
        ArrayList arrayList = fVar.f15543k;
        ArrayList arrayList2 = fVar.f15544l;
        e eVar6 = this.i;
        e eVar7 = this.f15565h;
        if (!z11) {
            w2.e eVar8 = this.f15559b;
            int i10 = eVar8.f15184o0[0];
            this.f15561d = i10;
            if (i10 != 3) {
                if (i10 == 4 && (eVar4 = eVar8.S) != null && ((i3 = eVar4.f15184o0[0]) == 1 || i3 == 4)) {
                    int iO = (eVar4.o() - this.f15559b.H.d()) - this.f15559b.J.d();
                    n.b(eVar7, eVar4.f15164d.f15565h, this.f15559b.H.d());
                    n.b(eVar6, eVar4.f15164d.i, -this.f15559b.J.d());
                    fVar.d(iO);
                    return;
                }
                if (i10 == 1) {
                    fVar.d(eVar8.o());
                }
            }
        } else if (this.f15561d == 4 && (eVar2 = (eVar = this.f15559b).S) != null && ((i = eVar2.f15184o0[0]) == 1 || i == 4)) {
            n.b(eVar7, eVar2.f15164d.f15565h, eVar.H.d());
            n.b(eVar6, eVar2.f15164d.i, -this.f15559b.J.d());
            return;
        }
        if (fVar.f15542j) {
            w2.e eVar9 = this.f15559b;
            if (eVar9.f15158a) {
                w2.d[] dVarArr = eVar9.P;
                w2.d dVar = dVarArr[0];
                w2.d dVar2 = dVar.f15155f;
                if (dVar2 != null && dVarArr[1].f15155f != null) {
                    boolean zV = eVar9.v();
                    w2.e eVar10 = this.f15559b;
                    if (zV) {
                        eVar7.f15539f = eVar10.P[0].d();
                        eVar6.f15539f = -this.f15559b.P[1].d();
                        return;
                    }
                    e eVarH = n.h(eVar10.P[0]);
                    if (eVarH != null) {
                        n.b(eVar7, eVarH, this.f15559b.P[0].d());
                    }
                    e eVarH2 = n.h(this.f15559b.P[1]);
                    if (eVarH2 != null) {
                        n.b(eVar6, eVarH2, -this.f15559b.P[1].d());
                    }
                    eVar7.f15535b = true;
                    eVar6.f15535b = true;
                    return;
                }
                if (dVar2 != null) {
                    e eVarH3 = n.h(dVar);
                    if (eVarH3 != null) {
                        n.b(eVar7, eVarH3, this.f15559b.P[0].d());
                        n.b(eVar6, eVar7, fVar.f15540g);
                        return;
                    }
                    return;
                }
                w2.d dVar3 = dVarArr[1];
                if (dVar3.f15155f != null) {
                    e eVarH4 = n.h(dVar3);
                    if (eVarH4 != null) {
                        n.b(eVar6, eVarH4, -this.f15559b.P[1].d());
                        n.b(eVar7, eVar6, -fVar.f15540g);
                        return;
                    }
                    return;
                }
                if ((eVar9 instanceof w2.a) || eVar9.S == null || eVar9.g(7).f15155f != null) {
                    return;
                }
                w2.e eVar11 = this.f15559b;
                n.b(eVar7, eVar11.S.f15164d.f15565h, eVar11.p());
                n.b(eVar6, eVar7, fVar.f15540g);
                return;
            }
        }
        if (this.f15561d == 3) {
            w2.e eVar12 = this.f15559b;
            int i11 = eVar12.f15187r;
            if (i11 == 2) {
                w2.e eVar13 = eVar12.S;
                if (eVar13 != null) {
                    f fVar2 = eVar13.f15166e.f15562e;
                    arrayList2.add(fVar2);
                    fVar2.f15543k.add(fVar);
                    fVar.f15535b = true;
                    arrayList.add(eVar7);
                    arrayList.add(eVar6);
                }
            } else if (i11 == 3) {
                if (eVar12.f15188s == 3) {
                    eVar7.f15534a = this;
                    eVar6.f15534a = this;
                    l lVar = eVar12.f15166e;
                    lVar.f15565h.f15534a = this;
                    lVar.i.f15534a = this;
                    fVar.f15534a = this;
                    if (eVar12.w()) {
                        arrayList2.add(this.f15559b.f15166e.f15562e);
                        this.f15559b.f15166e.f15562e.f15543k.add(fVar);
                        l lVar2 = this.f15559b.f15166e;
                        lVar2.f15562e.f15534a = this;
                        arrayList2.add(lVar2.f15565h);
                        arrayList2.add(this.f15559b.f15166e.i);
                        this.f15559b.f15166e.f15565h.f15543k.add(fVar);
                        this.f15559b.f15166e.i.f15543k.add(fVar);
                    } else {
                        boolean zV2 = this.f15559b.v();
                        w2.e eVar14 = this.f15559b;
                        if (zV2) {
                            eVar14.f15166e.f15562e.f15544l.add(fVar);
                            arrayList.add(this.f15559b.f15166e.f15562e);
                        } else {
                            eVar14.f15166e.f15562e.f15544l.add(fVar);
                        }
                    }
                } else {
                    f fVar3 = eVar12.f15166e.f15562e;
                    arrayList2.add(fVar3);
                    fVar3.f15543k.add(fVar);
                    this.f15559b.f15166e.f15565h.f15543k.add(fVar);
                    this.f15559b.f15166e.i.f15543k.add(fVar);
                    fVar.f15535b = true;
                    arrayList.add(eVar7);
                    arrayList.add(eVar6);
                    eVar7.f15544l.add(fVar);
                    eVar6.f15544l.add(fVar);
                }
            }
        }
        w2.e eVar15 = this.f15559b;
        w2.d[] dVarArr2 = eVar15.P;
        w2.d dVar4 = dVarArr2[0];
        w2.d dVar5 = dVar4.f15155f;
        if (dVar5 != null && dVarArr2[1].f15155f != null) {
            boolean zV3 = eVar15.v();
            w2.e eVar16 = this.f15559b;
            if (zV3) {
                eVar7.f15539f = eVar16.P[0].d();
                eVar6.f15539f = -this.f15559b.P[1].d();
                return;
            }
            e eVarH5 = n.h(eVar16.P[0]);
            e eVarH6 = n.h(this.f15559b.P[1]);
            if (eVarH5 != null) {
                eVarH5.b(this);
            }
            if (eVarH6 != null) {
                eVarH6.b(this);
            }
            this.f15566j = 4;
            return;
        }
        if (dVar5 != null) {
            e eVarH7 = n.h(dVar4);
            if (eVarH7 != null) {
                n.b(eVar7, eVarH7, this.f15559b.P[0].d());
                c(eVar6, eVar7, 1, fVar);
                return;
            }
            return;
        }
        w2.d dVar6 = dVarArr2[1];
        if (dVar6.f15155f != null) {
            e eVarH8 = n.h(dVar6);
            if (eVarH8 != null) {
                n.b(eVar6, eVarH8, -this.f15559b.P[1].d());
                c(eVar7, eVar6, -1, fVar);
                return;
            }
            return;
        }
        if ((eVar15 instanceof w2.a) || (eVar3 = eVar15.S) == null) {
            return;
        }
        n.b(eVar7, eVar3.f15164d.f15565h, eVar15.p());
        c(eVar6, eVar7, 1, fVar);
    }

    @Override // x2.n
    public final void e() {
        e eVar = this.f15565h;
        if (eVar.f15542j) {
            this.f15559b.X = eVar.f15540g;
        }
    }

    @Override // x2.n
    public final void f() {
        this.f15560c = null;
        this.f15565h.c();
        this.i.c();
        this.f15562e.c();
        this.f15564g = false;
    }

    @Override // x2.n
    public final boolean k() {
        return this.f15561d != 3 || this.f15559b.f15187r == 0;
    }

    public final void n() {
        this.f15564g = false;
        e eVar = this.f15565h;
        eVar.c();
        eVar.f15542j = false;
        e eVar2 = this.i;
        eVar2.c();
        eVar2.f15542j = false;
        this.f15562e.f15542j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f15559b.f15169g0;
    }
}
