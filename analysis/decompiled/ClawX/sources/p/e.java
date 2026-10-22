package p;

import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public o.e f4603a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4604b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4605c;
    public o.e d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f4606e;

    /* renamed from: f, reason: collision with root package name */
    public r.f f4607f;

    /* renamed from: g, reason: collision with root package name */
    public b f4608g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f4609h;

    public final void a(f fVar, int i8, ArrayList arrayList, l lVar) {
        o oVar = fVar.d;
        l lVar2 = oVar.f4635c;
        f fVar2 = oVar.f4640i;
        f fVar3 = oVar.f4639h;
        if (lVar2 == null) {
            o.e eVar = this.f4603a;
            if (oVar == eVar.d || oVar == eVar.f4219e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f4624a = null;
                lVar.f4625b = new ArrayList();
                lVar.f4624a = oVar;
                arrayList.add(lVar);
            }
            oVar.f4635c = lVar;
            lVar.f4625b.add(oVar);
            ArrayList arrayList2 = fVar3.f4619k;
            int size = arrayList2.size();
            int i9 = 0;
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                d dVar = (d) obj;
                if (dVar instanceof f) {
                    a((f) dVar, i8, arrayList, lVar);
                }
            }
            ArrayList arrayList3 = fVar2.f4619k;
            int size2 = arrayList3.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayList3.get(i11);
                i11++;
                d dVar2 = (d) obj2;
                if (dVar2 instanceof f) {
                    a((f) dVar2, i8, arrayList, lVar);
                }
            }
            if (i8 == 1 && (oVar instanceof m)) {
                ArrayList arrayList4 = ((m) oVar).f4626k.f4619k;
                int size3 = arrayList4.size();
                int i12 = 0;
                while (i12 < size3) {
                    Object obj3 = arrayList4.get(i12);
                    i12++;
                    d dVar3 = (d) obj3;
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i8, arrayList, lVar);
                    }
                }
            }
            ArrayList arrayList5 = fVar3.f4620l;
            int size4 = arrayList5.size();
            int i13 = 0;
            while (i13 < size4) {
                Object obj4 = arrayList5.get(i13);
                i13++;
                a((f) obj4, i8, arrayList, lVar);
            }
            ArrayList arrayList6 = fVar2.f4620l;
            int size5 = arrayList6.size();
            int i14 = 0;
            while (i14 < size5) {
                Object obj5 = arrayList6.get(i14);
                i14++;
                a((f) obj5, i8, arrayList, lVar);
            }
            if (i8 == 1 && (oVar instanceof m)) {
                ArrayList arrayList7 = ((m) oVar).f4626k.f4620l;
                int size6 = arrayList7.size();
                while (i9 < size6) {
                    Object obj6 = arrayList7.get(i9);
                    i9++;
                    a((f) obj6, i8, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(o.e r25) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.b(o.e):void");
    }

    public final void c() {
        o.e eVar = this.f4603a;
        ArrayList arrayList = this.f4609h;
        ArrayList arrayList2 = this.f4606e;
        arrayList2.clear();
        o.e eVar2 = this.d;
        eVar2.d.f();
        eVar2.f4219e.f();
        arrayList2.add(eVar2.d);
        arrayList2.add(eVar2.f4219e);
        ArrayList arrayList3 = eVar2.f4249p0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList3.get(i8);
            i8++;
            o.d dVar = (o.d) obj;
            if (dVar instanceof o.h) {
                i iVar = new i(dVar);
                dVar.d.f();
                dVar.f4219e.f();
                iVar.f4637f = ((o.h) dVar).f4291t0;
                arrayList2.add(iVar);
            } else {
                if (dVar.u()) {
                    if (dVar.f4214b == null) {
                        dVar.f4214b = new c(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f4214b);
                } else {
                    arrayList2.add(dVar.d);
                }
                if (dVar.v()) {
                    if (dVar.f4216c == null) {
                        dVar.f4216c = new c(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f4216c);
                } else {
                    arrayList2.add(dVar.f4219e);
                }
                if (dVar instanceof o.i) {
                    arrayList2.add(new j(dVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i9 = 0;
        while (i9 < size2) {
            Object obj2 = arrayList2.get(i9);
            i9++;
            ((o) obj2).f();
        }
        int size3 = arrayList2.size();
        int i10 = 0;
        while (i10 < size3) {
            Object obj3 = arrayList2.get(i10);
            i10++;
            o oVar = (o) obj3;
            if (oVar.f4634b != eVar2) {
                oVar.d();
            }
        }
        arrayList.clear();
        e(eVar.d, 0, arrayList);
        e(eVar.f4219e, 1, arrayList);
        this.f4604b = false;
    }

    public final int d(o.e eVar, int i8) {
        ArrayList arrayList;
        int i9;
        long jMax;
        float f3;
        o.e eVar2 = eVar;
        ArrayList arrayList2 = this.f4609h;
        int size = arrayList2.size();
        long j4 = 0;
        int i10 = 0;
        long jMax2 = 0;
        while (i10 < size) {
            o oVar = ((l) arrayList2.get(i10)).f4624a;
            if (!(oVar instanceof c) ? !(i8 != 0 ? (oVar instanceof m) : (oVar instanceof k)) : ((c) oVar).f4637f != i8) {
                f fVar = (i8 == 0 ? eVar2.d : eVar2.f4219e).f4639h;
                f fVar2 = (i8 == 0 ? eVar2.d : eVar2.f4219e).f4640i;
                f fVar3 = oVar.f4639h;
                f fVar4 = oVar.f4640i;
                boolean zContains = fVar3.f4620l.contains(fVar);
                boolean zContains2 = fVar4.f4620l.contains(fVar2);
                long j8 = oVar.j();
                if (zContains && zContains2) {
                    long jB = l.b(fVar3, j4);
                    arrayList = arrayList2;
                    long jA = l.a(fVar4, j4);
                    long j9 = jB - j8;
                    int i11 = fVar4.f4614f;
                    i9 = i10;
                    if (j9 >= (-i11)) {
                        j9 += i11;
                    }
                    long j10 = fVar3.f4614f;
                    long j11 = ((-jA) - j8) - j10;
                    if (j11 >= j10) {
                        j11 -= j10;
                    }
                    o.d dVar = oVar.f4634b;
                    if (i8 == 0) {
                        f3 = dVar.f4217c0;
                    } else if (i8 == 1) {
                        f3 = dVar.f4218d0;
                    } else {
                        dVar.getClass();
                        f3 = -1.0f;
                    }
                    float f7 = f3 > 0.0f ? (long) ((j9 / (1.0f - f3)) + (j11 / f3)) : 0L;
                    jMax = (fVar3.f4614f + ((((long) ((f7 * f3) + 0.5f)) + j8) + ((long) (((1.0f - f3) * f7) + 0.5f)))) - fVar4.f4614f;
                } else {
                    arrayList = arrayList2;
                    i9 = i10;
                    jMax = zContains ? Math.max(l.b(fVar3, fVar3.f4614f), fVar3.f4614f + j8) : zContains2 ? Math.max(-l.a(fVar4, fVar4.f4614f), (-fVar4.f4614f) + j8) : (oVar.j() + fVar3.f4614f) - fVar4.f4614f;
                }
            } else {
                arrayList = arrayList2;
                jMax = j4;
                i9 = i10;
            }
            jMax2 = Math.max(jMax2, jMax);
            i10 = i9 + 1;
            arrayList2 = arrayList;
            eVar2 = eVar;
            j4 = 0;
        }
        return (int) jMax2;
    }

    public final void e(o oVar, int i8, ArrayList arrayList) {
        f fVar = oVar.f4639h;
        f fVar2 = oVar.f4640i;
        ArrayList arrayList2 = fVar.f4619k;
        int size = arrayList2.size();
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            d dVar = (d) obj;
            if (dVar instanceof f) {
                a((f) dVar, i8, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f4639h, i8, arrayList, null);
            }
        }
        ArrayList arrayList3 = fVar2.f4619k;
        int size2 = arrayList3.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList3.get(i11);
            i11++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof f) {
                a((f) dVar2, i8, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f4640i, i8, arrayList, null);
            }
        }
        if (i8 == 1) {
            ArrayList arrayList4 = ((m) oVar).f4626k.f4619k;
            int size3 = arrayList4.size();
            while (i9 < size3) {
                Object obj3 = arrayList4.get(i9);
                i9++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof f) {
                    a((f) dVar3, i8, arrayList, null);
                }
            }
        }
    }

    public final void f(int i8, int i9, int i10, int i11, o.d dVar) {
        b bVar = this.f4608g;
        bVar.f4592a = i8;
        bVar.f4593b = i10;
        bVar.f4594c = i9;
        bVar.d = i11;
        this.f4607f.b(dVar, bVar);
        dVar.J(bVar.f4595e);
        dVar.G(bVar.f4596f);
        dVar.D = bVar.f4598h;
        dVar.D(bVar.f4597g);
    }

    public final void g() {
        a aVar;
        e eVar = this;
        ArrayList arrayList = eVar.f4603a.f4249p0;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            o.d dVar = (o.d) arrayList.get(i8);
            if (!dVar.f4212a) {
                int[] iArr = dVar.f4239o0;
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = dVar.f4241q;
                int i13 = dVar.f4242r;
                boolean z = i10 == 2 || (i10 == 3 && i12 == 1);
                boolean z2 = i11 == 2 || (i11 == 3 && i13 == 1);
                g gVar = dVar.d.f4636e;
                boolean z8 = gVar.f4618j;
                g gVar2 = dVar.f4219e.f4636e;
                boolean z9 = gVar2.f4618j;
                boolean z10 = z;
                if (z8 && z9) {
                    eVar.f(1, gVar.f4615g, 1, gVar2.f4615g, dVar);
                    dVar.f4212a = true;
                } else if (z8 && z2) {
                    f(1, gVar.f4615g, 2, gVar2.f4615g, dVar);
                    if (i11 == 3) {
                        dVar.f4219e.f4636e.f4621m = dVar.k();
                    } else {
                        dVar.f4219e.f4636e.d(dVar.k());
                        dVar.f4212a = true;
                    }
                } else if (z9 && z10) {
                    f(2, gVar.f4615g, 1, gVar2.f4615g, dVar);
                    if (i10 == 3) {
                        dVar.d.f4636e.f4621m = dVar.n();
                    } else {
                        dVar.d.f4636e.d(dVar.n());
                        dVar.f4212a = true;
                    }
                }
                if (dVar.f4212a && (aVar = dVar.f4219e.f4627l) != null) {
                    aVar.d(dVar.Z);
                }
                eVar = this;
            }
            i8 = i9;
        }
    }
}
