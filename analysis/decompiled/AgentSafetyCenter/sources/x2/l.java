package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends n {

    /* renamed from: k, reason: collision with root package name */
    public e f15550k;

    /* renamed from: l, reason: collision with root package name */
    public a f15551l;

    @Override // x2.d
    public final void a(d dVar) {
        float f5;
        float f10;
        float f11;
        int i;
        if (s.f.c(this.f15566j) == 3) {
            w2.e eVar = this.f15559b;
            l(eVar.I, eVar.K, 1);
            return;
        }
        f fVar = this.f15562e;
        if (fVar.f15536c && !fVar.f15542j && this.f15561d == 3) {
            w2.e eVar2 = this.f15559b;
            int i3 = eVar2.f15188s;
            if (i3 == 2) {
                w2.e eVar3 = eVar2.S;
                if (eVar3 != null) {
                    if (eVar3.f15166e.f15562e.f15542j) {
                        fVar.d((int) ((r5.f15540g * eVar2.f15195z) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                f fVar2 = eVar2.f15164d.f15562e;
                if (fVar2.f15542j) {
                    int i10 = eVar2.W;
                    if (i10 == -1) {
                        f5 = fVar2.f15540g;
                        f10 = eVar2.V;
                    } else if (i10 == 0) {
                        f11 = fVar2.f15540g * eVar2.V;
                        i = (int) (f11 + 0.5f);
                        fVar.d(i);
                    } else if (i10 != 1) {
                        i = 0;
                        fVar.d(i);
                    } else {
                        f5 = fVar2.f15540g;
                        f10 = eVar2.V;
                    }
                    f11 = f5 / f10;
                    i = (int) (f11 + 0.5f);
                    fVar.d(i);
                }
            }
        }
        e eVar4 = this.f15565h;
        boolean z10 = eVar4.f15536c;
        ArrayList arrayList = eVar4.f15544l;
        if (z10) {
            e eVar5 = this.i;
            boolean z11 = eVar5.f15536c;
            ArrayList arrayList2 = eVar5.f15544l;
            if (z11) {
                if (eVar4.f15542j && eVar5.f15542j && fVar.f15542j) {
                    return;
                }
                if (!fVar.f15542j && this.f15561d == 3) {
                    w2.e eVar6 = this.f15559b;
                    if (eVar6.f15187r == 0 && !eVar6.w()) {
                        e eVar7 = (e) arrayList.get(0);
                        e eVar8 = (e) arrayList2.get(0);
                        int i11 = eVar7.f15540g + eVar4.f15539f;
                        int i12 = eVar8.f15540g + eVar5.f15539f;
                        eVar4.d(i11);
                        eVar5.d(i12);
                        fVar.d(i12 - i11);
                        return;
                    }
                }
                if (!fVar.f15542j && this.f15561d == 3 && this.f15558a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    e eVar9 = (e) arrayList.get(0);
                    int i13 = (((e) arrayList2.get(0)).f15540g + eVar5.f15539f) - (eVar9.f15540g + eVar4.f15539f);
                    int i14 = fVar.f15545m;
                    if (i13 < i14) {
                        fVar.d(i13);
                    } else {
                        fVar.d(i14);
                    }
                }
                if (fVar.f15542j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    e eVar10 = (e) arrayList.get(0);
                    e eVar11 = (e) arrayList2.get(0);
                    int i15 = eVar10.f15540g;
                    int i16 = eVar4.f15539f + i15;
                    int i17 = eVar11.f15540g;
                    int i18 = eVar5.f15539f + i17;
                    float f12 = this.f15559b.f15165d0;
                    if (eVar10 == eVar11) {
                        f12 = 0.5f;
                    } else {
                        i15 = i16;
                        i17 = i18;
                    }
                    eVar4.d((int) ((((i17 - i15) - fVar.f15540g) * f12) + i15 + 0.5f));
                    eVar5.d(eVar4.f15540g + fVar.f15540g);
                }
            }
        }
    }

    @Override // x2.n
    public final void d() {
        w2.e eVar;
        w2.e eVar2;
        w2.e eVar3;
        w2.e eVar4;
        e eVar5 = this.f15550k;
        w2.e eVar6 = this.f15559b;
        boolean z10 = eVar6.f15158a;
        f fVar = this.f15562e;
        if (z10) {
            fVar.d(eVar6.i());
        }
        boolean z11 = fVar.f15542j;
        ArrayList arrayList = fVar.f15543k;
        ArrayList arrayList2 = fVar.f15544l;
        e eVar7 = this.i;
        e eVar8 = this.f15565h;
        if (!z11) {
            w2.e eVar9 = this.f15559b;
            this.f15561d = eVar9.f15184o0[1];
            if (eVar9.E) {
                this.f15551l = new a(this);
            }
            int i = this.f15561d;
            if (i != 3) {
                if (i == 4 && (eVar4 = this.f15559b.S) != null && eVar4.f15184o0[1] == 1) {
                    int i3 = (eVar4.i() - this.f15559b.I.d()) - this.f15559b.K.d();
                    n.b(eVar8, eVar4.f15166e.f15565h, this.f15559b.I.d());
                    n.b(eVar7, eVar4.f15166e.i, -this.f15559b.K.d());
                    fVar.d(i3);
                    return;
                }
                if (i == 1) {
                    fVar.d(this.f15559b.i());
                }
            }
        } else if (this.f15561d == 4 && (eVar2 = (eVar = this.f15559b).S) != null && eVar2.f15184o0[1] == 1) {
            n.b(eVar8, eVar2.f15166e.f15565h, eVar.I.d());
            n.b(eVar7, eVar2.f15166e.i, -this.f15559b.K.d());
            return;
        }
        boolean z12 = fVar.f15542j;
        if (z12) {
            w2.e eVar10 = this.f15559b;
            if (eVar10.f15158a) {
                w2.d[] dVarArr = eVar10.P;
                w2.d dVar = dVarArr[2];
                w2.d dVar2 = dVar.f15155f;
                if (dVar2 != null && dVarArr[3].f15155f != null) {
                    boolean zW = eVar10.w();
                    w2.e eVar11 = this.f15559b;
                    if (zW) {
                        eVar8.f15539f = eVar11.P[2].d();
                        eVar7.f15539f = -this.f15559b.P[3].d();
                    } else {
                        e eVarH = n.h(eVar11.P[2]);
                        if (eVarH != null) {
                            n.b(eVar8, eVarH, this.f15559b.P[2].d());
                        }
                        e eVarH2 = n.h(this.f15559b.P[3]);
                        if (eVarH2 != null) {
                            n.b(eVar7, eVarH2, -this.f15559b.P[3].d());
                        }
                        eVar8.f15535b = true;
                        eVar7.f15535b = true;
                    }
                    w2.e eVar12 = this.f15559b;
                    if (eVar12.E) {
                        n.b(eVar5, eVar8, eVar12.Z);
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    e eVarH3 = n.h(dVar);
                    if (eVarH3 != null) {
                        n.b(eVar8, eVarH3, this.f15559b.P[2].d());
                        n.b(eVar7, eVar8, fVar.f15540g);
                        w2.e eVar13 = this.f15559b;
                        if (eVar13.E) {
                            n.b(eVar5, eVar8, eVar13.Z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w2.d dVar3 = dVarArr[3];
                if (dVar3.f15155f != null) {
                    e eVarH4 = n.h(dVar3);
                    if (eVarH4 != null) {
                        n.b(eVar7, eVarH4, -this.f15559b.P[3].d());
                        n.b(eVar8, eVar7, -fVar.f15540g);
                    }
                    w2.e eVar14 = this.f15559b;
                    if (eVar14.E) {
                        n.b(eVar5, eVar8, eVar14.Z);
                        return;
                    }
                    return;
                }
                w2.d dVar4 = dVarArr[4];
                if (dVar4.f15155f != null) {
                    e eVarH5 = n.h(dVar4);
                    if (eVarH5 != null) {
                        n.b(eVar5, eVarH5, 0);
                        n.b(eVar8, eVar5, -this.f15559b.Z);
                        n.b(eVar7, eVar8, fVar.f15540g);
                        return;
                    }
                    return;
                }
                if ((eVar10 instanceof w2.a) || eVar10.S == null || eVar10.g(7).f15155f != null) {
                    return;
                }
                w2.e eVar15 = this.f15559b;
                n.b(eVar8, eVar15.S.f15166e.f15565h, eVar15.q());
                n.b(eVar7, eVar8, fVar.f15540g);
                w2.e eVar16 = this.f15559b;
                if (eVar16.E) {
                    n.b(eVar5, eVar8, eVar16.Z);
                    return;
                }
                return;
            }
        }
        if (z12 || this.f15561d != 3) {
            fVar.b(this);
        } else {
            w2.e eVar17 = this.f15559b;
            int i10 = eVar17.f15188s;
            if (i10 == 2) {
                w2.e eVar18 = eVar17.S;
                if (eVar18 != null) {
                    f fVar2 = eVar18.f15166e.f15562e;
                    arrayList2.add(fVar2);
                    fVar2.f15543k.add(fVar);
                    fVar.f15535b = true;
                    arrayList.add(eVar8);
                    arrayList.add(eVar7);
                }
            } else if (i10 == 3 && !eVar17.w()) {
                w2.e eVar19 = this.f15559b;
                if (eVar19.f15187r != 3) {
                    f fVar3 = eVar19.f15164d.f15562e;
                    arrayList2.add(fVar3);
                    fVar3.f15543k.add(fVar);
                    fVar.f15535b = true;
                    arrayList.add(eVar8);
                    arrayList.add(eVar7);
                }
            }
        }
        w2.e eVar20 = this.f15559b;
        w2.d[] dVarArr2 = eVar20.P;
        w2.d dVar5 = dVarArr2[2];
        w2.d dVar6 = dVar5.f15155f;
        if (dVar6 != null && dVarArr2[3].f15155f != null) {
            boolean zW2 = eVar20.w();
            w2.e eVar21 = this.f15559b;
            if (zW2) {
                eVar8.f15539f = eVar21.P[2].d();
                eVar7.f15539f = -this.f15559b.P[3].d();
            } else {
                e eVarH6 = n.h(eVar21.P[2]);
                e eVarH7 = n.h(this.f15559b.P[3]);
                if (eVarH6 != null) {
                    eVarH6.b(this);
                }
                if (eVarH7 != null) {
                    eVarH7.b(this);
                }
                this.f15566j = 4;
            }
            if (this.f15559b.E) {
                c(eVar5, eVar8, 1, this.f15551l);
            }
        } else if (dVar6 != null) {
            e eVarH8 = n.h(dVar5);
            if (eVarH8 != null) {
                n.b(eVar8, eVarH8, this.f15559b.P[2].d());
                c(eVar7, eVar8, 1, fVar);
                if (this.f15559b.E) {
                    c(eVar5, eVar8, 1, this.f15551l);
                }
                if (this.f15561d == 3) {
                    w2.e eVar22 = this.f15559b;
                    if (eVar22.V > 0.0f) {
                        j jVar = eVar22.f15164d;
                        if (jVar.f15561d == 3) {
                            jVar.f15562e.f15543k.add(fVar);
                            arrayList2.add(this.f15559b.f15164d.f15562e);
                            fVar.f15534a = this;
                        }
                    }
                }
            }
        } else {
            w2.d dVar7 = dVarArr2[3];
            if (dVar7.f15155f != null) {
                e eVarH9 = n.h(dVar7);
                if (eVarH9 != null) {
                    n.b(eVar7, eVarH9, -this.f15559b.P[3].d());
                    c(eVar8, eVar7, -1, fVar);
                    if (this.f15559b.E) {
                        c(eVar5, eVar8, 1, this.f15551l);
                    }
                }
            } else {
                w2.d dVar8 = dVarArr2[4];
                if (dVar8.f15155f != null) {
                    e eVarH10 = n.h(dVar8);
                    if (eVarH10 != null) {
                        n.b(eVar5, eVarH10, 0);
                        c(eVar8, eVar5, -1, this.f15551l);
                        c(eVar7, eVar8, 1, fVar);
                    }
                } else if (!(eVar20 instanceof w2.a) && (eVar3 = eVar20.S) != null) {
                    n.b(eVar8, eVar3.f15166e.f15565h, eVar20.q());
                    c(eVar7, eVar8, 1, fVar);
                    if (this.f15559b.E) {
                        c(eVar5, eVar8, 1, this.f15551l);
                    }
                    if (this.f15561d == 3) {
                        w2.e eVar23 = this.f15559b;
                        if (eVar23.V > 0.0f) {
                            j jVar2 = eVar23.f15164d;
                            if (jVar2.f15561d == 3) {
                                jVar2.f15562e.f15543k.add(fVar);
                                arrayList2.add(this.f15559b.f15164d.f15562e);
                                fVar.f15534a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            fVar.f15536c = true;
        }
    }

    @Override // x2.n
    public final void e() {
        e eVar = this.f15565h;
        if (eVar.f15542j) {
            this.f15559b.Y = eVar.f15540g;
        }
    }

    @Override // x2.n
    public final void f() {
        this.f15560c = null;
        this.f15565h.c();
        this.i.c();
        this.f15550k.c();
        this.f15562e.c();
        this.f15564g = false;
    }

    @Override // x2.n
    public final boolean k() {
        return this.f15561d != 3 || this.f15559b.f15188s == 0;
    }

    public final void m() {
        this.f15564g = false;
        e eVar = this.f15565h;
        eVar.c();
        eVar.f15542j = false;
        e eVar2 = this.i;
        eVar2.c();
        eVar2.f15542j = false;
        e eVar3 = this.f15550k;
        eVar3.c();
        eVar3.f15542j = false;
        this.f15562e.f15542j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f15559b.f15169g0;
    }
}
