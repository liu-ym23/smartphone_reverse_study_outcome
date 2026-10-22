package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends o {

    /* renamed from: k, reason: collision with root package name */
    public f f4626k;

    /* renamed from: l, reason: collision with root package name */
    public a f4627l;

    @Override // p.d
    public final void a(d dVar) {
        float f3;
        float f7;
        float f9;
        int i8;
        if (m.f.a(this.f4641j) == 3) {
            o.d dVar2 = this.f4634b;
            l(dVar2.I, dVar2.K, 1);
            return;
        }
        g gVar = this.f4636e;
        if (gVar.f4612c && !gVar.f4618j && this.d == 3) {
            o.d dVar3 = this.f4634b;
            int i9 = dVar3.f4242r;
            if (i9 == 2) {
                o.d dVar4 = dVar3.S;
                if (dVar4 != null) {
                    if (dVar4.f4219e.f4636e.f4618j) {
                        gVar.d((int) ((r5.f4615g * dVar3.y) + 0.5f));
                    }
                }
            } else if (i9 == 3) {
                g gVar2 = dVar3.d.f4636e;
                if (gVar2.f4618j) {
                    int i10 = dVar3.W;
                    if (i10 == -1) {
                        f3 = gVar2.f4615g;
                        f7 = dVar3.V;
                    } else if (i10 == 0) {
                        f9 = gVar2.f4615g * dVar3.V;
                        i8 = (int) (f9 + 0.5f);
                        gVar.d(i8);
                    } else if (i10 != 1) {
                        i8 = 0;
                        gVar.d(i8);
                    } else {
                        f3 = gVar2.f4615g;
                        f7 = dVar3.V;
                    }
                    f9 = f3 / f7;
                    i8 = (int) (f9 + 0.5f);
                    gVar.d(i8);
                }
            }
        }
        f fVar = this.f4639h;
        boolean z = fVar.f4612c;
        ArrayList arrayList = fVar.f4620l;
        if (z) {
            f fVar2 = this.f4640i;
            boolean z2 = fVar2.f4612c;
            ArrayList arrayList2 = fVar2.f4620l;
            if (z2) {
                if (fVar.f4618j && fVar2.f4618j && gVar.f4618j) {
                    return;
                }
                if (!gVar.f4618j && this.d == 3) {
                    o.d dVar5 = this.f4634b;
                    if (dVar5.f4241q == 0 && !dVar5.v()) {
                        f fVar3 = (f) arrayList.get(0);
                        f fVar4 = (f) arrayList2.get(0);
                        int i11 = fVar3.f4615g + fVar.f4614f;
                        int i12 = fVar4.f4615g + fVar2.f4614f;
                        fVar.d(i11);
                        fVar2.d(i12);
                        gVar.d(i12 - i11);
                        return;
                    }
                }
                if (!gVar.f4618j && this.d == 3 && this.f4633a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar5 = (f) arrayList.get(0);
                    int i13 = (((f) arrayList2.get(0)).f4615g + fVar2.f4614f) - (fVar5.f4615g + fVar.f4614f);
                    int i14 = gVar.f4621m;
                    if (i13 < i14) {
                        gVar.d(i13);
                    } else {
                        gVar.d(i14);
                    }
                }
                if (gVar.f4618j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar6 = (f) arrayList.get(0);
                    f fVar7 = (f) arrayList2.get(0);
                    int i15 = fVar6.f4615g;
                    int i16 = fVar.f4614f + i15;
                    int i17 = fVar7.f4615g;
                    int i18 = fVar2.f4614f + i17;
                    float f10 = this.f4634b.f4218d0;
                    if (fVar6 == fVar7) {
                        f10 = 0.5f;
                    } else {
                        i15 = i16;
                        i17 = i18;
                    }
                    fVar.d((int) ((((i17 - i15) - gVar.f4615g) * f10) + i15 + 0.5f));
                    fVar2.d(fVar.f4615g + gVar.f4615g);
                }
            }
        }
    }

    @Override // p.o
    public final void d() {
        o.d dVar;
        o.d dVar2;
        o.d dVar3;
        o.d dVar4;
        f fVar = this.f4626k;
        o.d dVar5 = this.f4634b;
        boolean z = dVar5.f4212a;
        g gVar = this.f4636e;
        if (z) {
            gVar.d(dVar5.k());
        }
        boolean z2 = gVar.f4618j;
        ArrayList arrayList = gVar.f4619k;
        ArrayList arrayList2 = gVar.f4620l;
        f fVar2 = this.f4640i;
        f fVar3 = this.f4639h;
        if (!z2) {
            o.d dVar6 = this.f4634b;
            this.d = dVar6.f4239o0[1];
            if (dVar6.D) {
                this.f4627l = new a(this);
            }
            int i8 = this.d;
            if (i8 != 3) {
                if (i8 == 4 && (dVar4 = this.f4634b.S) != null && dVar4.f4239o0[1] == 1) {
                    int iK = (dVar4.k() - this.f4634b.I.e()) - this.f4634b.K.e();
                    o.b(fVar3, dVar4.f4219e.f4639h, this.f4634b.I.e());
                    o.b(fVar2, dVar4.f4219e.f4640i, -this.f4634b.K.e());
                    gVar.d(iK);
                    return;
                }
                if (i8 == 1) {
                    gVar.d(this.f4634b.k());
                }
            }
        } else if (this.d == 4 && (dVar2 = (dVar = this.f4634b).S) != null && dVar2.f4239o0[1] == 1) {
            o.b(fVar3, dVar2.f4219e.f4639h, dVar.I.e());
            o.b(fVar2, dVar2.f4219e.f4640i, -this.f4634b.K.e());
            return;
        }
        boolean z8 = gVar.f4618j;
        if (z8) {
            o.d dVar7 = this.f4634b;
            if (dVar7.f4212a) {
                o.c[] cVarArr = dVar7.P;
                o.c cVar = cVarArr[2];
                o.c cVar2 = cVar.f4208f;
                if (cVar2 != null && cVarArr[3].f4208f != null) {
                    if (dVar7.v()) {
                        fVar3.f4614f = this.f4634b.P[2].e();
                        fVar2.f4614f = -this.f4634b.P[3].e();
                    } else {
                        f fVarH = o.h(this.f4634b.P[2]);
                        if (fVarH != null) {
                            o.b(fVar3, fVarH, this.f4634b.P[2].e());
                        }
                        f fVarH2 = o.h(this.f4634b.P[3]);
                        if (fVarH2 != null) {
                            o.b(fVar2, fVarH2, -this.f4634b.P[3].e());
                        }
                        fVar3.f4611b = true;
                        fVar2.f4611b = true;
                    }
                    o.d dVar8 = this.f4634b;
                    if (dVar8.D) {
                        o.b(fVar, fVar3, dVar8.Z);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar3, fVarH3, this.f4634b.P[2].e());
                        o.b(fVar2, fVar3, gVar.f4615g);
                        o.d dVar9 = this.f4634b;
                        if (dVar9.D) {
                            o.b(fVar, fVar3, dVar9.Z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                o.c cVar3 = cVarArr[3];
                if (cVar3.f4208f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar2, fVarH4, -this.f4634b.P[3].e());
                        o.b(fVar3, fVar2, -gVar.f4615g);
                    }
                    o.d dVar10 = this.f4634b;
                    if (dVar10.D) {
                        o.b(fVar, fVar3, dVar10.Z);
                        return;
                    }
                    return;
                }
                o.c cVar4 = cVarArr[4];
                if (cVar4.f4208f != null) {
                    f fVarH5 = o.h(cVar4);
                    if (fVarH5 != null) {
                        o.b(fVar, fVarH5, 0);
                        o.b(fVar3, fVar, -this.f4634b.Z);
                        o.b(fVar2, fVar3, gVar.f4615g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof o.i) || dVar7.S == null || dVar7.i(7).f4208f != null) {
                    return;
                }
                o.d dVar11 = this.f4634b;
                o.b(fVar3, dVar11.S.f4219e.f4639h, dVar11.p());
                o.b(fVar2, fVar3, gVar.f4615g);
                o.d dVar12 = this.f4634b;
                if (dVar12.D) {
                    o.b(fVar, fVar3, dVar12.Z);
                    return;
                }
                return;
            }
        }
        if (z8 || this.d != 3) {
            gVar.b(this);
        } else {
            o.d dVar13 = this.f4634b;
            int i9 = dVar13.f4242r;
            if (i9 == 2) {
                o.d dVar14 = dVar13.S;
                if (dVar14 != null) {
                    g gVar2 = dVar14.f4219e.f4636e;
                    arrayList2.add(gVar2);
                    gVar2.f4619k.add(gVar);
                    gVar.f4611b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            } else if (i9 == 3 && !dVar13.v()) {
                o.d dVar15 = this.f4634b;
                if (dVar15.f4241q != 3) {
                    g gVar3 = dVar15.d.f4636e;
                    arrayList2.add(gVar3);
                    gVar3.f4619k.add(gVar);
                    gVar.f4611b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            }
        }
        o.d dVar16 = this.f4634b;
        o.c[] cVarArr2 = dVar16.P;
        o.c cVar5 = cVarArr2[2];
        o.c cVar6 = cVar5.f4208f;
        if (cVar6 != null && cVarArr2[3].f4208f != null) {
            if (dVar16.v()) {
                fVar3.f4614f = this.f4634b.P[2].e();
                fVar2.f4614f = -this.f4634b.P[3].e();
            } else {
                f fVarH6 = o.h(this.f4634b.P[2]);
                f fVarH7 = o.h(this.f4634b.P[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f4641j = 4;
            }
            if (this.f4634b.D) {
                c(fVar, fVar3, 1, this.f4627l);
            }
        } else if (cVar6 != null) {
            f fVarH8 = o.h(cVar5);
            if (fVarH8 != null) {
                o.b(fVar3, fVarH8, this.f4634b.P[2].e());
                c(fVar2, fVar3, 1, gVar);
                if (this.f4634b.D) {
                    c(fVar, fVar3, 1, this.f4627l);
                }
                if (this.d == 3) {
                    o.d dVar17 = this.f4634b;
                    if (dVar17.V > 0.0f) {
                        k kVar = dVar17.d;
                        if (kVar.d == 3) {
                            kVar.f4636e.f4619k.add(gVar);
                            arrayList2.add(this.f4634b.d.f4636e);
                            gVar.f4610a = this;
                        }
                    }
                }
            }
        } else {
            o.c cVar7 = cVarArr2[3];
            if (cVar7.f4208f != null) {
                f fVarH9 = o.h(cVar7);
                if (fVarH9 != null) {
                    o.b(fVar2, fVarH9, -this.f4634b.P[3].e());
                    c(fVar3, fVar2, -1, gVar);
                    if (this.f4634b.D) {
                        c(fVar, fVar3, 1, this.f4627l);
                    }
                }
            } else {
                o.c cVar8 = cVarArr2[4];
                if (cVar8.f4208f != null) {
                    f fVarH10 = o.h(cVar8);
                    if (fVarH10 != null) {
                        o.b(fVar, fVarH10, 0);
                        c(fVar3, fVar, -1, this.f4627l);
                        c(fVar2, fVar3, 1, gVar);
                    }
                } else if (!(dVar16 instanceof o.i) && (dVar3 = dVar16.S) != null) {
                    o.b(fVar3, dVar3.f4219e.f4639h, dVar16.p());
                    c(fVar2, fVar3, 1, gVar);
                    if (this.f4634b.D) {
                        c(fVar, fVar3, 1, this.f4627l);
                    }
                    if (this.d == 3) {
                        o.d dVar18 = this.f4634b;
                        if (dVar18.V > 0.0f) {
                            k kVar2 = dVar18.d;
                            if (kVar2.d == 3) {
                                kVar2.f4636e.f4619k.add(gVar);
                                arrayList2.add(this.f4634b.d.f4636e);
                                gVar.f4610a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            gVar.f4612c = true;
        }
    }

    @Override // p.o
    public final void e() {
        f fVar = this.f4639h;
        if (fVar.f4618j) {
            this.f4634b.Y = fVar.f4615g;
        }
    }

    @Override // p.o
    public final void f() {
        this.f4635c = null;
        this.f4639h.c();
        this.f4640i.c();
        this.f4626k.c();
        this.f4636e.c();
        this.f4638g = false;
    }

    @Override // p.o
    public final boolean k() {
        return this.d != 3 || this.f4634b.f4242r == 0;
    }

    public final void m() {
        this.f4638g = false;
        f fVar = this.f4639h;
        fVar.c();
        fVar.f4618j = false;
        f fVar2 = this.f4640i;
        fVar2.c();
        fVar2.f4618j = false;
        f fVar3 = this.f4626k;
        fVar3.c();
        fVar3.f4618j = false;
        this.f4636e.f4618j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f4634b.f4224g0;
    }
}
