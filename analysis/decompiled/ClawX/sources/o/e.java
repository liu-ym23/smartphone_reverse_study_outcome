package o;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends d {
    public b[] A0;
    public b[] B0;
    public int C0;
    public boolean D0;
    public boolean E0;
    public WeakReference F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public final HashSet J0;
    public final p.b K0;

    /* renamed from: p0, reason: collision with root package name */
    public ArrayList f4249p0 = new ArrayList();

    /* renamed from: q0, reason: collision with root package name */
    public final a4.d f4250q0 = new a4.d(this);

    /* renamed from: r0, reason: collision with root package name */
    public final p.e f4251r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f4252s0;

    /* renamed from: t0, reason: collision with root package name */
    public r.f f4253t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f4254u0;

    /* renamed from: v0, reason: collision with root package name */
    public final m.c f4255v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f4256w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f4257x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f4258y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f4259z0;

    public e() {
        p.e eVar = new p.e();
        eVar.f4604b = true;
        eVar.f4605c = true;
        eVar.f4606e = new ArrayList();
        new ArrayList();
        eVar.f4607f = null;
        eVar.f4608g = new p.b();
        eVar.f4609h = new ArrayList();
        eVar.f4603a = this;
        eVar.d = this;
        this.f4251r0 = eVar;
        this.f4253t0 = null;
        this.f4254u0 = false;
        this.f4255v0 = new m.c();
        this.f4258y0 = 0;
        this.f4259z0 = 0;
        this.A0 = new b[4];
        this.B0 = new b[4];
        this.C0 = 257;
        this.D0 = false;
        this.E0 = false;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = new HashSet();
        this.K0 = new p.b();
    }

    public static void Q(d dVar, r.f fVar, p.b bVar) {
        int i8;
        int i9;
        if (fVar == null) {
            return;
        }
        int i10 = dVar.f4222f0;
        int[] iArr = dVar.f4243s;
        if (i10 == 8 || (dVar instanceof h) || (dVar instanceof a)) {
            bVar.f4595e = 0;
            bVar.f4596f = 0;
            return;
        }
        int[] iArr2 = dVar.f4239o0;
        bVar.f4592a = iArr2[0];
        bVar.f4593b = iArr2[1];
        bVar.f4594c = dVar.n();
        bVar.d = dVar.k();
        bVar.f4599i = false;
        bVar.f4600j = 0;
        boolean z = bVar.f4592a == 3;
        boolean z2 = bVar.f4593b == 3;
        boolean z8 = z && dVar.V > 0.0f;
        boolean z9 = z2 && dVar.V > 0.0f;
        if (z && dVar.q(0) && dVar.f4241q == 0 && !z8) {
            bVar.f4592a = 2;
            if (z2 && dVar.f4242r == 0) {
                bVar.f4592a = 1;
            }
            z = false;
        }
        if (z2 && dVar.q(1) && dVar.f4242r == 0 && !z9) {
            bVar.f4593b = 2;
            if (z && dVar.f4241q == 0) {
                bVar.f4593b = 1;
            }
            z2 = false;
        }
        if (dVar.x()) {
            bVar.f4592a = 1;
            z = false;
        }
        if (dVar.y()) {
            bVar.f4593b = 1;
            z2 = false;
        }
        if (z8) {
            if (iArr[0] == 4) {
                bVar.f4592a = 1;
            } else if (!z2) {
                if (bVar.f4593b == 1) {
                    i9 = bVar.d;
                } else {
                    bVar.f4592a = 2;
                    fVar.b(dVar, bVar);
                    i9 = bVar.f4596f;
                }
                bVar.f4592a = 1;
                bVar.f4594c = (int) (dVar.V * i9);
            }
        }
        if (z9) {
            if (iArr[1] == 4) {
                bVar.f4593b = 1;
            } else if (!z) {
                if (bVar.f4592a == 1) {
                    i8 = bVar.f4594c;
                } else {
                    bVar.f4593b = 2;
                    fVar.b(dVar, bVar);
                    i8 = bVar.f4595e;
                }
                bVar.f4593b = 1;
                if (dVar.W == -1) {
                    bVar.d = (int) (i8 / dVar.V);
                } else {
                    bVar.d = (int) (dVar.V * i8);
                }
            }
        }
        fVar.b(dVar, bVar);
        dVar.J(bVar.f4595e);
        dVar.G(bVar.f4596f);
        dVar.D = bVar.f4598h;
        dVar.D(bVar.f4597g);
        bVar.f4600j = 0;
    }

    @Override // o.d
    public final void C(a4.d dVar) {
        super.C(dVar);
        int size = this.f4249p0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((d) this.f4249p0.get(i8)).C(dVar);
        }
    }

    @Override // o.d
    public final void K(boolean z, boolean z2) {
        super.K(z, z2);
        int size = this.f4249p0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((d) this.f4249p0.get(i8)).K(z, z2);
        }
    }

    public final void M(d dVar, int i8) {
        if (i8 == 0) {
            int i9 = this.f4258y0 + 1;
            b[] bVarArr = this.B0;
            if (i9 >= bVarArr.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.B0;
            int i10 = this.f4258y0;
            bVarArr2[i10] = new b(dVar, 0, this.f4254u0);
            this.f4258y0 = i10 + 1;
            return;
        }
        if (i8 == 1) {
            int i11 = this.f4259z0 + 1;
            b[] bVarArr3 = this.A0;
            if (i11 >= bVarArr3.length) {
                this.A0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.A0;
            int i12 = this.f4259z0;
            bVarArr4[i12] = new b(dVar, 1, this.f4254u0);
            this.f4259z0 = i12 + 1;
        }
    }

    public final void N(m.c cVar) {
        e eVar;
        m.c cVar2;
        boolean zR = R(64);
        b(cVar, zR);
        int size = this.f4249p0.size();
        boolean z = false;
        for (int i8 = 0; i8 < size; i8++) {
            d dVar = (d) this.f4249p0.get(i8);
            boolean[] zArr = dVar.R;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i9 = 0; i9 < size; i9++) {
                d dVar2 = (d) this.f4249p0.get(i9);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i10 = 0; i10 < aVar.f4294q0; i10++) {
                        d dVar3 = aVar.f4293p0[i10];
                        if (aVar.f4185s0 || dVar3.c()) {
                            int i11 = aVar.f4184r0;
                            if (i11 == 0 || i11 == 1) {
                                dVar3.R[0] = true;
                            } else if (i11 == 2 || i11 == 3) {
                                dVar3.R[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.J0;
        hashSet.clear();
        for (int i12 = 0; i12 < size; i12++) {
            d dVar4 = (d) this.f4249p0.get(i12);
            dVar4.getClass();
            boolean z2 = dVar4 instanceof g;
            if (z2 || (dVar4 instanceof h)) {
                if (z2) {
                    hashSet.add(dVar4);
                } else {
                    dVar4.b(cVar, zR);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) ((d) it.next());
                for (int i13 = 0; i13 < gVar.f4294q0; i13++) {
                    if (hashSet.contains(gVar.f4293p0[i13])) {
                        gVar.b(cVar, zR);
                        hashSet.remove(gVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b(cVar, zR);
                }
                hashSet.clear();
            }
        }
        if (m.c.f3855p) {
            HashSet hashSet2 = new HashSet();
            for (int i14 = 0; i14 < size; i14++) {
                d dVar5 = (d) this.f4249p0.get(i14);
                dVar5.getClass();
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    hashSet2.add(dVar5);
                }
            }
            eVar = this;
            cVar2 = cVar;
            eVar.a(this, cVar2, hashSet2, this.f4239o0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                d dVar6 = (d) it3.next();
                j.b(eVar, cVar2, dVar6);
                dVar6.b(cVar2, zR);
            }
        } else {
            eVar = this;
            cVar2 = cVar;
            for (int i15 = 0; i15 < size; i15++) {
                d dVar7 = (d) eVar.f4249p0.get(i15);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.f4239o0;
                    int i16 = iArr[0];
                    int i17 = iArr[1];
                    if (i16 == 2) {
                        dVar7.H(1);
                    }
                    if (i17 == 2) {
                        dVar7.I(1);
                    }
                    dVar7.b(cVar2, zR);
                    if (i16 == 2) {
                        dVar7.H(i16);
                    }
                    if (i17 == 2) {
                        dVar7.I(i17);
                    }
                } else {
                    j.b(eVar, cVar2, dVar7);
                    if (!(dVar7 instanceof g) && !(dVar7 instanceof h)) {
                        dVar7.b(cVar2, zR);
                    }
                }
            }
        }
        if (eVar.f4258y0 > 0) {
            j.a(eVar, cVar2, null, 0);
        }
        if (eVar.f4259z0 > 0) {
            j.a(eVar, cVar2, null, 1);
        }
    }

    public final boolean O(int i8, boolean z) {
        boolean z2;
        boolean z8;
        p.e eVar = this.f4251r0;
        ArrayList arrayList = eVar.f4606e;
        e eVar2 = eVar.f4603a;
        boolean z9 = false;
        int iJ = eVar2.j(0);
        int[] iArr = eVar2.f4239o0;
        int iJ2 = eVar2.j(1);
        int iO = eVar2.o();
        int iP = eVar2.p();
        if (z && (iJ == 2 || iJ2 == 2)) {
            int size = arrayList.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    z8 = z;
                    break;
                }
                Object obj = arrayList.get(i9);
                i9++;
                o oVar = (o) obj;
                if (oVar.f4637f == i8 && !oVar.k()) {
                    z8 = false;
                    break;
                }
            }
            if (i8 == 0) {
                if (z8 && iJ == 2) {
                    eVar2.H(1);
                    eVar2.J(eVar.d(eVar2, 0));
                    eVar2.d.f4636e.d(eVar2.n());
                }
            } else if (z8 && iJ2 == 2) {
                eVar2.I(1);
                eVar2.G(eVar.d(eVar2, 1));
                eVar2.f4219e.f4636e.d(eVar2.k());
            }
        }
        if (i8 == 0) {
            int i10 = iArr[0];
            if (i10 == 1 || i10 == 4) {
                int iN = eVar2.n() + iO;
                eVar2.d.f4640i.d(iN);
                eVar2.d.f4636e.d(iN - iO);
                z2 = true;
            }
            z2 = false;
        } else {
            int i11 = iArr[1];
            if (i11 == 1 || i11 == 4) {
                int iK = eVar2.k() + iP;
                eVar2.f4219e.f4640i.d(iK);
                eVar2.f4219e.f4636e.d(iK - iP);
                z2 = true;
            }
            z2 = false;
        }
        eVar.g();
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            o oVar2 = (o) obj2;
            if (oVar2.f4637f == i8 && (oVar2.f4634b != eVar2 || oVar2.f4638g)) {
                oVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size3) {
                z9 = true;
                break;
            }
            Object obj3 = arrayList.get(i13);
            i13++;
            o oVar3 = (o) obj3;
            if (oVar3.f4637f == i8 && (z2 || oVar3.f4634b != eVar2)) {
                if (!oVar3.f4639h.f4618j || !oVar3.f4640i.f4618j || (!(oVar3 instanceof p.c) && !oVar3.f4636e.f4618j)) {
                    break;
                }
            }
        }
        eVar2.H(iJ);
        eVar2.I(iJ2);
        return z9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0671 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x081d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x082a A[LOOP:14: B:488:0x0828->B:489:0x082a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x090b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P() {
        /*
            Method dump skipped, instructions count: 2329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.e.P():void");
    }

    public final boolean R(int i8) {
        return (this.C0 & i8) == i8;
    }

    @Override // o.d
    public final void z() {
        this.f4255v0.t();
        this.f4256w0 = 0;
        this.f4257x0 = 0;
        this.f4249p0.clear();
        super.z();
    }
}
