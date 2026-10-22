package w2;

import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import od.n;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends e {
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
    public final x2.b K0;

    /* renamed from: p0, reason: collision with root package name */
    public ArrayList f15196p0 = new ArrayList();

    /* renamed from: q0, reason: collision with root package name */
    public final m f15197q0;

    /* renamed from: r0, reason: collision with root package name */
    public final n f15198r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f15199s0;

    /* renamed from: t0, reason: collision with root package name */
    public z2.e f15200t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f15201u0;

    /* renamed from: v0, reason: collision with root package name */
    public final u2.c f15202v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f15203w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f15204x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f15205y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f15206z0;

    public f() {
        m mVar = new m(24);
        mVar.f9741f = new ArrayList();
        mVar.f9742g = new x2.b();
        mVar.f9743h = this;
        VarHandle.storeStoreFence();
        this.f15197q0 = mVar;
        n nVar = new n();
        nVar.f9471b = true;
        nVar.f9472c = true;
        nVar.f9475f = new ArrayList();
        new ArrayList();
        nVar.f9476g = null;
        nVar.f9477h = new x2.b();
        nVar.i = new ArrayList();
        nVar.f9473d = this;
        nVar.f9474e = this;
        this.f15198r0 = nVar;
        this.f15200t0 = null;
        this.f15201u0 = false;
        u2.c cVar = new u2.c();
        cVar.f13997a = false;
        cVar.f13998b = 0;
        cVar.f14000d = 32;
        cVar.f14001e = 32;
        cVar.f14002f = null;
        cVar.f14003g = false;
        cVar.f14004h = new boolean[32];
        cVar.i = 1;
        cVar.f14005j = 0;
        cVar.f14006k = 32;
        cVar.f14008m = new u2.e[u2.c.f13996q];
        cVar.f14009n = 0;
        cVar.f14002f = new u2.b[32];
        cVar.s();
        m mVar2 = new m(21);
        mVar2.f9741f = new m3.c();
        mVar2.f9742g = new m3.c();
        mVar2.f9743h = new u2.e[32];
        cVar.f14007l = mVar2;
        u2.d dVar = new u2.d(mVar2);
        dVar.f14011f = new u2.e[128];
        dVar.f14012g = new u2.e[128];
        dVar.f14013h = 0;
        p5.e eVar = new p5.e(11);
        eVar.f9723g = dVar;
        VarHandle.storeStoreFence();
        dVar.i = eVar;
        cVar.f13999c = dVar;
        cVar.f14010o = new u2.b(mVar2);
        VarHandle.storeStoreFence();
        this.f15202v0 = cVar;
        this.f15205y0 = 0;
        this.f15206z0 = 0;
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
        this.K0 = new x2.b();
    }

    public static void R(e eVar, z2.e eVar2, x2.b bVar) {
        int i;
        int i3;
        if (eVar2 == null) {
            return;
        }
        int i10 = eVar.f0;
        int[] iArr = eVar.f15189t;
        if (i10 == 8 || (eVar instanceof g) || (eVar instanceof a)) {
            bVar.f15527e = 0;
            bVar.f15528f = 0;
            return;
        }
        int[] iArr2 = eVar.f15184o0;
        bVar.f15523a = iArr2[0];
        bVar.f15524b = iArr2[1];
        bVar.f15525c = eVar.o();
        bVar.f15526d = eVar.i();
        bVar.i = false;
        bVar.f15531j = 0;
        boolean z10 = bVar.f15523a == 3;
        boolean z11 = bVar.f15524b == 3;
        boolean z12 = z10 && eVar.V > 0.0f;
        boolean z13 = z11 && eVar.V > 0.0f;
        if (z10 && eVar.r(0) && eVar.f15187r == 0 && !z12) {
            bVar.f15523a = 2;
            if (z11 && eVar.f15188s == 0) {
                bVar.f15523a = 1;
            }
            z10 = false;
        }
        if (z11 && eVar.r(1) && eVar.f15188s == 0 && !z13) {
            bVar.f15524b = 2;
            if (z10 && eVar.f15187r == 0) {
                bVar.f15524b = 1;
            }
            z11 = false;
        }
        if (eVar.y()) {
            bVar.f15523a = 1;
            z10 = false;
        }
        if (eVar.z()) {
            bVar.f15524b = 1;
            z11 = false;
        }
        if (z12) {
            if (iArr[0] == 4) {
                bVar.f15523a = 1;
            } else if (!z11) {
                if (bVar.f15524b == 1) {
                    i3 = bVar.f15526d;
                } else {
                    bVar.f15523a = 2;
                    eVar2.b(eVar, bVar);
                    i3 = bVar.f15528f;
                }
                bVar.f15523a = 1;
                bVar.f15525c = (int) (eVar.V * i3);
            }
        }
        if (z13) {
            if (iArr[1] == 4) {
                bVar.f15524b = 1;
            } else if (!z10) {
                if (bVar.f15523a == 1) {
                    i = bVar.f15525c;
                } else {
                    bVar.f15524b = 2;
                    eVar2.b(eVar, bVar);
                    i = bVar.f15527e;
                }
                bVar.f15524b = 1;
                int i11 = eVar.W;
                float f5 = eVar.V;
                if (i11 == -1) {
                    bVar.f15526d = (int) (i / f5);
                } else {
                    bVar.f15526d = (int) (f5 * i);
                }
            }
        }
        eVar2.b(eVar, bVar);
        eVar.K(bVar.f15527e);
        eVar.H(bVar.f15528f);
        eVar.E = bVar.f15530h;
        int i12 = bVar.f15529g;
        eVar.Z = i12;
        eVar.E = i12 > 0;
        bVar.f15531j = 0;
    }

    @Override // w2.e
    public final void A() {
        this.f15202v0.t();
        this.f15203w0 = 0;
        this.f15204x0 = 0;
        this.f15196p0.clear();
        super.A();
    }

    @Override // w2.e
    public final void C(m mVar) {
        super.C(mVar);
        int size = this.f15196p0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.f15196p0.get(i)).C(mVar);
        }
    }

    @Override // w2.e
    public final void L(boolean z10, boolean z11) {
        super.L(z10, z11);
        int size = this.f15196p0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.f15196p0.get(i)).L(z10, z11);
        }
    }

    public final void N(e eVar, int i) {
        if (i == 0) {
            int i3 = this.f15205y0 + 1;
            b[] bVarArr = this.B0;
            if (i3 >= bVarArr.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.B0;
            int i10 = this.f15205y0;
            bVarArr2[i10] = new b(eVar, 0, this.f15201u0);
            this.f15205y0 = i10 + 1;
            return;
        }
        if (i == 1) {
            int i11 = this.f15206z0 + 1;
            b[] bVarArr3 = this.A0;
            if (i11 >= bVarArr3.length) {
                this.A0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.A0;
            int i12 = this.f15206z0;
            bVarArr4[i12] = new b(eVar, 1, this.f15201u0);
            this.f15206z0 = i12 + 1;
        }
    }

    public final void O(u2.c cVar) {
        f fVar;
        u2.c cVar2;
        boolean zS = S(64);
        b(cVar, zS);
        int size = this.f15196p0.size();
        boolean z10 = false;
        for (int i = 0; i < size; i++) {
            e eVar = (e) this.f15196p0.get(i);
            boolean[] zArr = eVar.R;
            zArr[0] = false;
            zArr[1] = false;
            if (eVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = (e) this.f15196p0.get(i3);
                if (eVar2 instanceof a) {
                    a aVar = (a) eVar2;
                    for (int i10 = 0; i10 < aVar.f15129q0; i10++) {
                        e eVar3 = aVar.f15128p0[i10];
                        if (aVar.f15131s0 || eVar3.c()) {
                            int i11 = aVar.f15130r0;
                            if (i11 == 0 || i11 == 1) {
                                eVar3.R[0] = true;
                            } else if (i11 == 2 || i11 == 3) {
                                eVar3.R[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.J0;
        hashSet.clear();
        for (int i12 = 0; i12 < size; i12++) {
            e eVar4 = (e) this.f15196p0.get(i12);
            eVar4.getClass();
            if (eVar4 instanceof g) {
                eVar4.b(cVar, zS);
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            if (it.hasNext()) {
                ((e) it.next()).getClass();
                od.f.j();
                return;
            } else if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).b(cVar, zS);
                }
                hashSet.clear();
            }
        }
        if (u2.c.f13995p) {
            HashSet hashSet2 = new HashSet();
            for (int i13 = 0; i13 < size; i13++) {
                e eVar5 = (e) this.f15196p0.get(i13);
                eVar5.getClass();
                if (!(eVar5 instanceof g)) {
                    hashSet2.add(eVar5);
                }
            }
            fVar = this;
            cVar2 = cVar;
            fVar.a(this, cVar2, hashSet2, this.f15184o0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                e eVar6 = (e) it3.next();
                h.b(fVar, cVar2, eVar6);
                eVar6.b(cVar2, zS);
            }
        } else {
            fVar = this;
            cVar2 = cVar;
            for (int i14 = 0; i14 < size; i14++) {
                e eVar7 = (e) fVar.f15196p0.get(i14);
                if (eVar7 instanceof f) {
                    int[] iArr = eVar7.f15184o0;
                    int i15 = iArr[0];
                    int i16 = iArr[1];
                    if (i15 == 2) {
                        eVar7.I(1);
                    }
                    if (i16 == 2) {
                        eVar7.J(1);
                    }
                    eVar7.b(cVar2, zS);
                    if (i15 == 2) {
                        eVar7.I(i15);
                    }
                    if (i16 == 2) {
                        eVar7.J(i16);
                    }
                } else {
                    h.b(fVar, cVar2, eVar7);
                    if (!(eVar7 instanceof g)) {
                        eVar7.b(cVar2, zS);
                    }
                }
            }
        }
        if (fVar.f15205y0 > 0) {
            h.a(fVar, cVar2, null, 0);
        }
        if (fVar.f15206z0 > 0) {
            h.a(fVar, cVar2, null, 1);
        }
    }

    public final boolean P(int i, boolean z10) {
        boolean z11;
        n nVar = this.f15198r0;
        ArrayList arrayList = (ArrayList) nVar.f9475f;
        f fVar = (f) nVar.f9473d;
        boolean z12 = false;
        int iH = fVar.h(0);
        int iH2 = fVar.h(1);
        int iP = fVar.p();
        int iQ = fVar.q();
        if (z10 && (iH == 2 || iH2 == 2)) {
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                Object obj = arrayList.get(i3);
                i3++;
                x2.n nVar2 = (x2.n) obj;
                if (nVar2.f15563f == i && !nVar2.k()) {
                    z10 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z10 && iH == 2) {
                    fVar.I(1);
                    fVar.K(nVar.d(fVar, 0));
                    fVar.f15164d.f15562e.d(fVar.o());
                }
            } else if (z10 && iH2 == 2) {
                fVar.J(1);
                fVar.H(nVar.d(fVar, 1));
                fVar.f15166e.f15562e.d(fVar.i());
            }
        }
        int[] iArr = fVar.f15184o0;
        if (i == 0) {
            int i10 = iArr[0];
            if (i10 == 1 || i10 == 4) {
                int iO = fVar.o() + iP;
                fVar.f15164d.i.d(iO);
                fVar.f15164d.f15562e.d(iO - iP);
                z11 = true;
            }
            z11 = false;
        } else {
            int i11 = iArr[1];
            if (i11 == 1 || i11 == 4) {
                int i12 = fVar.i() + iQ;
                fVar.f15166e.i.d(i12);
                fVar.f15166e.f15562e.d(i12 - iQ);
                z11 = true;
            }
            z11 = false;
        }
        nVar.g();
        int size2 = arrayList.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList.get(i13);
            i13++;
            x2.n nVar3 = (x2.n) obj2;
            if (nVar3.f15563f == i && (nVar3.f15559b != fVar || nVar3.f15564g)) {
                nVar3.e();
            }
        }
        int size3 = arrayList.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size3) {
                z12 = true;
                break;
            }
            Object obj3 = arrayList.get(i14);
            i14++;
            x2.n nVar4 = (x2.n) obj3;
            if (nVar4.f15563f == i && (z11 || nVar4.f15559b != fVar)) {
                if (!nVar4.f15565h.f15542j || !nVar4.i.f15542j || (!(nVar4 instanceof x2.c) && !nVar4.f15562e.f15542j)) {
                    break;
                }
            }
        }
        fVar.I(iH);
        fVar.J(iH2);
        return z12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x080e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x081b A[LOOP:14: B:481:0x0819->B:482:0x081b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x08eb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q() {
        /*
            Method dump skipped, instructions count: 2314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.f.Q():void");
    }

    public final boolean S(int i) {
        return (this.C0 & i) == i;
    }

    @Override // w2.e
    public final void l(StringBuilder sb2) {
        sb2.append(this.f15173j + ":{\n");
        StringBuilder sb3 = new StringBuilder("  actualWidth:");
        sb3.append(this.T);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.U);
        sb2.append("\n");
        ArrayList arrayList = this.f15196p0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((e) obj).l(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }
}
