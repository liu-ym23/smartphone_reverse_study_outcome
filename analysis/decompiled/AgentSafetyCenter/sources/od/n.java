package od;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9470a = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9471b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9472c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9473d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9474e;

    /* renamed from: f, reason: collision with root package name */
    public Serializable f9475f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9476g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9477h;
    public Object i;

    public n(boolean z10, boolean z11, z zVar, Long l2, Long l10, Long l11, Long l12, Map map) {
        map.getClass();
        this.f9471b = z10;
        this.f9472c = z11;
        this.f9473d = zVar;
        this.f9474e = l2;
        this.f9475f = l10;
        this.f9476g = l11;
        this.f9477h = l12;
        this.i = kb.w.R(map);
    }

    public void a(x2.e eVar, int i, ArrayList arrayList, x2.k kVar) {
        x2.n nVar = eVar.f15537d;
        x2.k kVar2 = nVar.f15560c;
        x2.e eVar2 = nVar.i;
        x2.e eVar3 = nVar.f15565h;
        if (kVar2 == null) {
            w2.f fVar = (w2.f) this.f9473d;
            if (nVar == fVar.f15164d || nVar == fVar.f15166e) {
                return;
            }
            if (kVar == null) {
                kVar = new x2.k();
                kVar.f15548a = null;
                kVar.f15549b = new ArrayList();
                kVar.f15548a = nVar;
                arrayList.add(kVar);
            }
            nVar.f15560c = kVar;
            kVar.f15549b.add(nVar);
            ArrayList arrayList2 = eVar3.f15543k;
            int size = arrayList2.size();
            int i3 = 0;
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                x2.d dVar = (x2.d) obj;
                if (dVar instanceof x2.e) {
                    a((x2.e) dVar, i, arrayList, kVar);
                }
            }
            ArrayList arrayList3 = eVar2.f15543k;
            int size2 = arrayList3.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayList3.get(i11);
                i11++;
                x2.d dVar2 = (x2.d) obj2;
                if (dVar2 instanceof x2.e) {
                    a((x2.e) dVar2, i, arrayList, kVar);
                }
            }
            if (i == 1 && (nVar instanceof x2.l)) {
                ArrayList arrayList4 = ((x2.l) nVar).f15550k.f15543k;
                int size3 = arrayList4.size();
                int i12 = 0;
                while (i12 < size3) {
                    Object obj3 = arrayList4.get(i12);
                    i12++;
                    x2.d dVar3 = (x2.d) obj3;
                    if (dVar3 instanceof x2.e) {
                        a((x2.e) dVar3, i, arrayList, kVar);
                    }
                }
            }
            ArrayList arrayList5 = eVar3.f15544l;
            int size4 = arrayList5.size();
            int i13 = 0;
            while (i13 < size4) {
                Object obj4 = arrayList5.get(i13);
                i13++;
                a((x2.e) obj4, i, arrayList, kVar);
            }
            ArrayList arrayList6 = eVar2.f15544l;
            int size5 = arrayList6.size();
            int i14 = 0;
            while (i14 < size5) {
                Object obj5 = arrayList6.get(i14);
                i14++;
                a((x2.e) obj5, i, arrayList, kVar);
            }
            if (i == 1 && (nVar instanceof x2.l)) {
                ArrayList arrayList7 = ((x2.l) nVar).f15550k.f15544l;
                int size6 = arrayList7.size();
                while (i3 < size6) {
                    Object obj6 = arrayList7.get(i3);
                    i3++;
                    a((x2.e) obj6, i, arrayList, kVar);
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
    public void b(w2.f r25) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: od.n.b(w2.f):void");
    }

    public void c() {
        w2.f fVar = (w2.f) this.f9473d;
        ArrayList arrayList = (ArrayList) this.i;
        ArrayList arrayList2 = (ArrayList) this.f9475f;
        arrayList2.clear();
        w2.f fVar2 = (w2.f) this.f9474e;
        fVar2.f15164d.f();
        fVar2.f15166e.f();
        arrayList2.add(fVar2.f15164d);
        arrayList2.add(fVar2.f15166e);
        ArrayList arrayList3 = fVar2.f15196p0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            w2.e eVar = (w2.e) obj;
            if (eVar instanceof w2.g) {
                x2.h hVar = new x2.h(eVar);
                eVar.f15164d.f();
                eVar.f15166e.f();
                hVar.f15563f = ((w2.g) eVar).f15211t0;
                arrayList2.add(hVar);
            } else {
                if (eVar.v()) {
                    if (eVar.f15160b == null) {
                        eVar.f15160b = new x2.c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f15160b);
                } else {
                    arrayList2.add(eVar.f15164d);
                }
                if (eVar.w()) {
                    if (eVar.f15162c == null) {
                        eVar.f15162c = new x2.c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f15162c);
                } else {
                    arrayList2.add(eVar.f15166e);
                }
                if (eVar instanceof w2.a) {
                    arrayList2.add(new x2.i(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            ((x2.n) obj2).f();
        }
        int size3 = arrayList2.size();
        int i10 = 0;
        while (i10 < size3) {
            Object obj3 = arrayList2.get(i10);
            i10++;
            x2.n nVar = (x2.n) obj3;
            if (nVar.f15559b != fVar2) {
                nVar.d();
            }
        }
        arrayList.clear();
        e(fVar.f15164d, 0, arrayList);
        e(fVar.f15166e, 1, arrayList);
        this.f9471b = false;
    }

    public int d(w2.f fVar, int i) {
        ArrayList arrayList;
        int i3;
        long jMax;
        float f5;
        w2.f fVar2 = fVar;
        ArrayList arrayList2 = (ArrayList) this.i;
        int size = arrayList2.size();
        long j10 = 0;
        int i10 = 0;
        long jMax2 = 0;
        while (i10 < size) {
            x2.n nVar = ((x2.k) arrayList2.get(i10)).f15548a;
            if (!(nVar instanceof x2.c) ? !(i != 0 ? (nVar instanceof x2.l) : (nVar instanceof x2.j)) : ((x2.c) nVar).f15563f != i) {
                x2.e eVar = (i == 0 ? fVar2.f15164d : fVar2.f15166e).f15565h;
                x2.e eVar2 = (i == 0 ? fVar2.f15164d : fVar2.f15166e).i;
                x2.e eVar3 = nVar.f15565h;
                x2.e eVar4 = nVar.i;
                boolean zContains = eVar3.f15544l.contains(eVar);
                boolean zContains2 = eVar4.f15544l.contains(eVar2);
                long j11 = nVar.j();
                if (zContains && zContains2) {
                    long jB = x2.k.b(eVar3, j10);
                    arrayList = arrayList2;
                    long jA = x2.k.a(eVar4, j10);
                    long j12 = jB - j11;
                    int i11 = eVar4.f15539f;
                    i3 = i10;
                    if (j12 >= (-i11)) {
                        j12 += i11;
                    }
                    long j13 = eVar3.f15539f;
                    long j14 = ((-jA) - j11) - j13;
                    if (j14 >= j13) {
                        j14 -= j13;
                    }
                    w2.e eVar5 = nVar.f15559b;
                    if (i == 0) {
                        f5 = eVar5.f15163c0;
                    } else if (i == 1) {
                        f5 = eVar5.f15165d0;
                    } else {
                        eVar5.getClass();
                        f5 = -1.0f;
                    }
                    float f10 = f5 > 0.0f ? (long) ((j12 / (1.0f - f5)) + (j14 / f5)) : 0L;
                    jMax = (eVar3.f15539f + ((((long) ((f10 * f5) + 0.5f)) + j11) + ((long) k0.a.f(1.0f, f5, f10, 0.5f)))) - eVar4.f15539f;
                } else {
                    arrayList = arrayList2;
                    i3 = i10;
                    jMax = zContains ? Math.max(x2.k.b(eVar3, eVar3.f15539f), eVar3.f15539f + j11) : zContains2 ? Math.max(-x2.k.a(eVar4, eVar4.f15539f), (-eVar4.f15539f) + j11) : (nVar.j() + eVar3.f15539f) - eVar4.f15539f;
                }
            } else {
                arrayList = arrayList2;
                jMax = j10;
                i3 = i10;
            }
            jMax2 = Math.max(jMax2, jMax);
            i10 = i3 + 1;
            arrayList2 = arrayList;
            fVar2 = fVar;
            j10 = 0;
        }
        return (int) jMax2;
    }

    public void e(x2.n nVar, int i, ArrayList arrayList) {
        x2.e eVar = nVar.f15565h;
        x2.e eVar2 = nVar.i;
        ArrayList arrayList2 = eVar.f15543k;
        int size = arrayList2.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            x2.d dVar = (x2.d) obj;
            if (dVar instanceof x2.e) {
                a((x2.e) dVar, i, arrayList, null);
            } else if (dVar instanceof x2.n) {
                a(((x2.n) dVar).f15565h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = eVar2.f15543k;
        int size2 = arrayList3.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList3.get(i11);
            i11++;
            x2.d dVar2 = (x2.d) obj2;
            if (dVar2 instanceof x2.e) {
                a((x2.e) dVar2, i, arrayList, null);
            } else if (dVar2 instanceof x2.n) {
                a(((x2.n) dVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((x2.l) nVar).f15550k.f15543k;
            int size3 = arrayList4.size();
            while (i3 < size3) {
                Object obj3 = arrayList4.get(i3);
                i3++;
                x2.d dVar3 = (x2.d) obj3;
                if (dVar3 instanceof x2.e) {
                    a((x2.e) dVar3, i, arrayList, null);
                }
            }
        }
    }

    public void f(int i, int i3, int i10, int i11, w2.e eVar) {
        x2.b bVar = (x2.b) this.f9477h;
        bVar.f15523a = i;
        bVar.f15524b = i10;
        bVar.f15525c = i3;
        bVar.f15526d = i11;
        ((z2.e) this.f9476g).b(eVar, bVar);
        eVar.K(bVar.f15527e);
        eVar.H(bVar.f15528f);
        eVar.E = bVar.f15530h;
        int i12 = bVar.f15529g;
        eVar.Z = i12;
        eVar.E = i12 > 0;
    }

    public void g() {
        x2.a aVar;
        n nVar = this;
        ArrayList arrayList = ((w2.f) nVar.f9473d).f15196p0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i3 = i + 1;
            w2.e eVar = (w2.e) arrayList.get(i);
            if (!eVar.f15158a) {
                int[] iArr = eVar.f15184o0;
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = eVar.f15187r;
                int i13 = eVar.f15188s;
                boolean z10 = i10 == 2 || (i10 == 3 && i12 == 1);
                boolean z11 = i11 == 2 || (i11 == 3 && i13 == 1);
                x2.f fVar = eVar.f15164d.f15562e;
                boolean z12 = fVar.f15542j;
                x2.f fVar2 = eVar.f15166e.f15562e;
                boolean z13 = fVar2.f15542j;
                boolean z14 = z10;
                if (z12 && z13) {
                    nVar.f(1, fVar.f15540g, 1, fVar2.f15540g, eVar);
                    eVar.f15158a = true;
                } else if (z12 && z11) {
                    f(1, fVar.f15540g, 2, fVar2.f15540g, eVar);
                    x2.l lVar = eVar.f15166e;
                    if (i11 == 3) {
                        lVar.f15562e.f15545m = eVar.i();
                    } else {
                        lVar.f15562e.d(eVar.i());
                        eVar.f15158a = true;
                    }
                } else if (z13 && z14) {
                    f(2, fVar.f15540g, 1, fVar2.f15540g, eVar);
                    x2.j jVar = eVar.f15164d;
                    if (i10 == 3) {
                        jVar.f15562e.f15545m = eVar.o();
                    } else {
                        jVar.f15562e.d(eVar.o());
                        eVar.f15158a = true;
                    }
                }
                if (eVar.f15158a && (aVar = eVar.f15166e.f15551l) != null) {
                    aVar.d(eVar.Z);
                }
                nVar = this;
            }
            i = i3;
        }
    }

    public String toString() {
        switch (this.f9470a) {
            case 0:
                Map map = (Map) this.i;
                Long l2 = (Long) this.f9477h;
                Long l10 = (Long) this.f9476g;
                Long l11 = (Long) this.f9475f;
                Long l12 = (Long) this.f9474e;
                ArrayList arrayList = new ArrayList();
                if (this.f9471b) {
                    arrayList.add("isRegularFile");
                }
                if (this.f9472c) {
                    arrayList.add("isDirectory");
                }
                if (l12 != null) {
                    arrayList.add("byteCount=" + l12);
                }
                if (l11 != null) {
                    arrayList.add("createdAt=" + l11);
                }
                if (l10 != null) {
                    arrayList.add("lastModifiedAt=" + l10);
                }
                if (l2 != null) {
                    arrayList.add("lastAccessedAt=" + l2);
                }
                if (!map.isEmpty()) {
                    arrayList.add("extras=" + map);
                }
                return kb.l.B0(arrayList, ", ", "FileMetadata(", ")", null, 56);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ n() {
    }

    public /* synthetic */ n(boolean z10, boolean z11, z zVar, Long l2, Long l10, Long l11, Long l12) {
        this(z10, z11, zVar, l2, l10, l11, l12, kb.t.f7405c);
    }
}
