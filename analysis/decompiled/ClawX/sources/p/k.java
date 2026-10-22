package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f4623k = new int[2];

    public static void m(int[] iArr, int i8, int i9, int i10, int i11, float f3, int i12) {
        int i13 = i9 - i8;
        int i14 = i11 - i10;
        if (i12 != -1) {
            if (i12 == 0) {
                iArr[0] = (int) ((i14 * f3) + 0.5f);
                iArr[1] = i14;
                return;
            } else {
                if (i12 != 1) {
                    return;
                }
                iArr[0] = i13;
                iArr[1] = (int) ((i13 * f3) + 0.5f);
                return;
            }
        }
        int i15 = (int) ((i14 * f3) + 0.5f);
        int i16 = (int) ((i13 / f3) + 0.5f);
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
    @Override // p.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(p.d r24) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.k.a(p.d):void");
    }

    @Override // p.o
    public final void d() {
        o.d dVar;
        o.d dVar2;
        int i8;
        o.d dVar3;
        o.d dVar4;
        int i9;
        o.d dVar5 = this.f4634b;
        boolean z = dVar5.f4212a;
        g gVar = this.f4636e;
        if (z) {
            gVar.d(dVar5.n());
        }
        boolean z2 = gVar.f4618j;
        ArrayList arrayList = gVar.f4619k;
        ArrayList arrayList2 = gVar.f4620l;
        f fVar = this.f4640i;
        f fVar2 = this.f4639h;
        if (!z2) {
            o.d dVar6 = this.f4634b;
            int i10 = dVar6.f4239o0[0];
            this.d = i10;
            if (i10 != 3) {
                if (i10 == 4 && (dVar4 = dVar6.S) != null && ((i9 = dVar4.f4239o0[0]) == 1 || i9 == 4)) {
                    int iN = (dVar4.n() - this.f4634b.H.e()) - this.f4634b.J.e();
                    o.b(fVar2, dVar4.d.f4639h, this.f4634b.H.e());
                    o.b(fVar, dVar4.d.f4640i, -this.f4634b.J.e());
                    gVar.d(iN);
                    return;
                }
                if (i10 == 1) {
                    gVar.d(dVar6.n());
                }
            }
        } else if (this.d == 4 && (dVar2 = (dVar = this.f4634b).S) != null && ((i8 = dVar2.f4239o0[0]) == 1 || i8 == 4)) {
            o.b(fVar2, dVar2.d.f4639h, dVar.H.e());
            o.b(fVar, dVar2.d.f4640i, -this.f4634b.J.e());
            return;
        }
        if (gVar.f4618j) {
            o.d dVar7 = this.f4634b;
            if (dVar7.f4212a) {
                o.c[] cVarArr = dVar7.P;
                o.c cVar = cVarArr[0];
                o.c cVar2 = cVar.f4208f;
                if (cVar2 != null && cVarArr[1].f4208f != null) {
                    if (dVar7.u()) {
                        fVar2.f4614f = this.f4634b.P[0].e();
                        fVar.f4614f = -this.f4634b.P[1].e();
                        return;
                    }
                    f fVarH = o.h(this.f4634b.P[0]);
                    if (fVarH != null) {
                        o.b(fVar2, fVarH, this.f4634b.P[0].e());
                    }
                    f fVarH2 = o.h(this.f4634b.P[1]);
                    if (fVarH2 != null) {
                        o.b(fVar, fVarH2, -this.f4634b.P[1].e());
                    }
                    fVar2.f4611b = true;
                    fVar.f4611b = true;
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar2, fVarH3, this.f4634b.P[0].e());
                        o.b(fVar, fVar2, gVar.f4615g);
                        return;
                    }
                    return;
                }
                o.c cVar3 = cVarArr[1];
                if (cVar3.f4208f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar, fVarH4, -this.f4634b.P[1].e());
                        o.b(fVar2, fVar, -gVar.f4615g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof o.i) || dVar7.S == null || dVar7.i(7).f4208f != null) {
                    return;
                }
                o.d dVar8 = this.f4634b;
                o.b(fVar2, dVar8.S.d.f4639h, dVar8.o());
                o.b(fVar, fVar2, gVar.f4615g);
                return;
            }
        }
        if (this.d == 3) {
            o.d dVar9 = this.f4634b;
            int i11 = dVar9.f4241q;
            if (i11 == 2) {
                o.d dVar10 = dVar9.S;
                if (dVar10 != null) {
                    g gVar2 = dVar10.f4219e.f4636e;
                    arrayList2.add(gVar2);
                    gVar2.f4619k.add(gVar);
                    gVar.f4611b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                }
            } else if (i11 == 3) {
                if (dVar9.f4242r == 3) {
                    fVar2.f4610a = this;
                    fVar.f4610a = this;
                    m mVar = dVar9.f4219e;
                    mVar.f4639h.f4610a = this;
                    mVar.f4640i.f4610a = this;
                    gVar.f4610a = this;
                    if (dVar9.v()) {
                        arrayList2.add(this.f4634b.f4219e.f4636e);
                        this.f4634b.f4219e.f4636e.f4619k.add(gVar);
                        m mVar2 = this.f4634b.f4219e;
                        mVar2.f4636e.f4610a = this;
                        arrayList2.add(mVar2.f4639h);
                        arrayList2.add(this.f4634b.f4219e.f4640i);
                        this.f4634b.f4219e.f4639h.f4619k.add(gVar);
                        this.f4634b.f4219e.f4640i.f4619k.add(gVar);
                    } else if (this.f4634b.u()) {
                        this.f4634b.f4219e.f4636e.f4620l.add(gVar);
                        arrayList.add(this.f4634b.f4219e.f4636e);
                    } else {
                        this.f4634b.f4219e.f4636e.f4620l.add(gVar);
                    }
                } else {
                    g gVar3 = dVar9.f4219e.f4636e;
                    arrayList2.add(gVar3);
                    gVar3.f4619k.add(gVar);
                    this.f4634b.f4219e.f4639h.f4619k.add(gVar);
                    this.f4634b.f4219e.f4640i.f4619k.add(gVar);
                    gVar.f4611b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                    fVar2.f4620l.add(gVar);
                    fVar.f4620l.add(gVar);
                }
            }
        }
        o.d dVar11 = this.f4634b;
        o.c[] cVarArr2 = dVar11.P;
        o.c cVar4 = cVarArr2[0];
        o.c cVar5 = cVar4.f4208f;
        if (cVar5 != null && cVarArr2[1].f4208f != null) {
            if (dVar11.u()) {
                fVar2.f4614f = this.f4634b.P[0].e();
                fVar.f4614f = -this.f4634b.P[1].e();
                return;
            }
            f fVarH5 = o.h(this.f4634b.P[0]);
            f fVarH6 = o.h(this.f4634b.P[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f4641j = 4;
            return;
        }
        if (cVar5 != null) {
            f fVarH7 = o.h(cVar4);
            if (fVarH7 != null) {
                o.b(fVar2, fVarH7, this.f4634b.P[0].e());
                c(fVar, fVar2, 1, gVar);
                return;
            }
            return;
        }
        o.c cVar6 = cVarArr2[1];
        if (cVar6.f4208f != null) {
            f fVarH8 = o.h(cVar6);
            if (fVarH8 != null) {
                o.b(fVar, fVarH8, -this.f4634b.P[1].e());
                c(fVar2, fVar, -1, gVar);
                return;
            }
            return;
        }
        if ((dVar11 instanceof o.i) || (dVar3 = dVar11.S) == null) {
            return;
        }
        o.b(fVar2, dVar3.d.f4639h, dVar11.o());
        c(fVar, fVar2, 1, gVar);
    }

    @Override // p.o
    public final void e() {
        f fVar = this.f4639h;
        if (fVar.f4618j) {
            this.f4634b.X = fVar.f4615g;
        }
    }

    @Override // p.o
    public final void f() {
        this.f4635c = null;
        this.f4639h.c();
        this.f4640i.c();
        this.f4636e.c();
        this.f4638g = false;
    }

    @Override // p.o
    public final boolean k() {
        return this.d != 3 || this.f4634b.f4241q == 0;
    }

    public final void n() {
        this.f4638g = false;
        f fVar = this.f4639h;
        fVar.c();
        fVar.f4618j = false;
        f fVar2 = this.f4640i;
        fVar2.c();
        fVar2.f4618j = false;
        this.f4636e.f4618j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f4634b.f4224g0;
    }
}
