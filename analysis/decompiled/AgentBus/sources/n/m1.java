package n;

/* loaded from: classes.dex */
public final class m1 implements i1 {

    /* renamed from: f, reason: collision with root package name */
    public final k.s f6661f;

    /* renamed from: g, reason: collision with root package name */
    public final k.t f6662g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6663h;

    /* renamed from: i, reason: collision with root package name */
    public final t f6664i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f6665j;

    /* renamed from: k, reason: collision with root package name */
    public float[] f6666k;

    /* renamed from: l, reason: collision with root package name */
    public n f6667l;

    /* renamed from: m, reason: collision with root package name */
    public n f6668m;

    /* renamed from: n, reason: collision with root package name */
    public n f6669n;

    /* renamed from: o, reason: collision with root package name */
    public n f6670o;

    /* renamed from: p, reason: collision with root package name */
    public float[] f6671p;

    /* renamed from: q, reason: collision with root package name */
    public float[] f6672q;

    /* renamed from: r, reason: collision with root package name */
    public a7.d f6673r;

    public m1(k.s sVar, k.t tVar, int i2, t tVar2) {
        this.f6661f = sVar;
        this.f6662g = tVar;
        this.f6663h = i2;
        this.f6664i = tVar2;
    }

    public final int b(int i2) {
        int i10;
        k.s sVar = this.f6661f;
        int i11 = sVar.f5530b;
        int i12 = 0;
        if (i11 < 0) {
            j0.a("fromIndex(0) > toIndex(" + i11 + ')');
        }
        if (i11 > sVar.f5530b) {
            throw new IndexOutOfBoundsException(f.c(i11, "Index out of range: "));
        }
        int i13 = i11 - 1;
        while (true) {
            if (i12 <= i13) {
                i10 = (i12 + i13) >>> 1;
                int iC = sVar.c(i10);
                if (iC >= i2) {
                    if (iC <= i2) {
                        break;
                    }
                    i13 = i10 - 1;
                } else {
                    i12 = i10 + 1;
                }
            } else {
                i10 = -(i12 + 1);
                break;
            }
        }
        return i10 < -1 ? -(i10 + 2) : i10;
    }

    public final float d(int i2, int i10, boolean z4) {
        t tVar;
        float f10;
        k.s sVar = this.f6661f;
        if (i2 >= sVar.f5530b - 1) {
            f10 = i10;
        } else {
            int iC = sVar.c(i2);
            int iC2 = sVar.c(i2 + 1);
            if (i10 != iC) {
                int i11 = iC2 - iC;
                l1 l1Var = (l1) this.f6662g.b(iC);
                if (l1Var == null || (tVar = l1Var.f6654b) == null) {
                    tVar = this.f6664i;
                }
                float f11 = i11;
                float fA = tVar.a((i10 - iC) / f11);
                return z4 ? fA : ((f11 * fA) + iC) / 1000;
            }
            f10 = iC;
        }
        return f10 / 1000;
    }

    public final void e(n nVar, n nVar2, n nVar3) {
        float[] fArr;
        float[] fArr2;
        boolean z4 = this.f6673r != null;
        n nVar4 = this.f6667l;
        k.t tVar = this.f6662g;
        k.s sVar = this.f6661f;
        if (nVar4 == null) {
            this.f6667l = nVar.c();
            this.f6668m = nVar3.c();
            int i2 = sVar.f5530b;
            float[] fArr3 = new float[i2];
            for (int i10 = 0; i10 < i2; i10++) {
                fArr3[i10] = sVar.c(i10) / 1000;
            }
            this.f6666k = fArr3;
            int i11 = sVar.f5530b;
            int[] iArr = new int[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = 0;
            }
            this.f6665j = iArr;
        }
        if (z4) {
            if (this.f6673r != null) {
                n nVar5 = this.f6669n;
                if (nVar5 == null) {
                    q7.k.j("lastInitialValue");
                    throw null;
                }
                if (nVar5.equals(nVar)) {
                    n nVar6 = this.f6670o;
                    if (nVar6 == null) {
                        q7.k.j("lastTargetValue");
                        throw null;
                    }
                    if (nVar6.equals(nVar2)) {
                        return;
                    }
                }
            }
            this.f6669n = nVar;
            this.f6670o = nVar2;
            int iB = nVar.b() + (nVar.b() % 2);
            this.f6671p = new float[iB];
            this.f6672q = new float[iB];
            int i13 = sVar.f5530b;
            float[][] fArr4 = new float[i13][];
            for (int i14 = 0; i14 < i13; i14++) {
                int iC = sVar.c(i14);
                if (iC != 0) {
                    if (iC != this.f6663h) {
                        fArr = new float[iB];
                        Object objB = tVar.b(iC);
                        q7.k.b(objB);
                        n nVar7 = ((l1) objB).f6653a;
                        for (int i15 = 0; i15 < iB; i15++) {
                            fArr[i15] = nVar7.a(i15);
                        }
                    } else if (tVar.a(iC)) {
                        fArr = new float[iB];
                        Object objB2 = tVar.b(iC);
                        q7.k.b(objB2);
                        n nVar8 = ((l1) objB2).f6653a;
                        for (int i16 = 0; i16 < iB; i16++) {
                            fArr[i16] = nVar8.a(i16);
                        }
                    } else {
                        fArr2 = new float[iB];
                        for (int i17 = 0; i17 < iB; i17++) {
                            fArr2[i17] = nVar2.a(i17);
                        }
                    }
                    fArr2 = fArr;
                } else if (tVar.a(iC)) {
                    fArr = new float[iB];
                    Object objB3 = tVar.b(iC);
                    q7.k.b(objB3);
                    n nVar9 = ((l1) objB3).f6653a;
                    for (int i18 = 0; i18 < iB; i18++) {
                        fArr[i18] = nVar9.a(i18);
                    }
                    fArr2 = fArr;
                } else {
                    fArr2 = new float[iB];
                    for (int i19 = 0; i19 < iB; i19++) {
                        fArr2[i19] = nVar.a(i19);
                    }
                }
                fArr4[i14] = fArr2;
            }
            int[] iArr2 = this.f6665j;
            if (iArr2 == null) {
                q7.k.j("modes");
                throw null;
            }
            float[] fArr5 = this.f6666k;
            if (fArr5 == null) {
                q7.k.j("times");
                throw null;
            }
            this.f6673r = new a7.d(iArr2, fArr5, fArr4);
        }
    }

    @Override // n.i1
    public final int m() {
        return 0;
    }

    @Override // n.h1
    public final n r(long j2, n nVar, n nVar2, n nVar3) throws Throwable {
        int i2 = 0;
        long jL = nb.i.l((j2 / 1000000) - 0, 0L, this.f6663h);
        if (jL < 0) {
            return nVar3;
        }
        e(nVar, nVar2, nVar3);
        if (this.f6673r == null) {
            n nVarS = s((jL - 1) * 1000000, nVar, nVar2, nVar3);
            n nVarS2 = s(jL * 1000000, nVar, nVar2, nVar3);
            int iB = nVarS.b();
            while (i2 < iB) {
                n nVar4 = this.f6668m;
                if (nVar4 == null) {
                    q7.k.j("velocityVector");
                    throw null;
                }
                nVar4.e(i2, (nVarS.a(i2) - nVarS2.a(i2)) * 1000.0f);
                i2++;
            }
            n nVar5 = this.f6668m;
            if (nVar5 != null) {
                return nVar5;
            }
            q7.k.j("velocityVector");
            throw null;
        }
        int i10 = (int) jL;
        float fD = d(b(i10), i10, false);
        a7.d dVar = this.f6673r;
        if (dVar == null) {
            q7.k.j("arcSpline");
            throw null;
        }
        float[] fArr = this.f6672q;
        if (fArr == null) {
            q7.k.j("slopeArray");
            throw null;
        }
        p[][] pVarArr = (p[][]) dVar.f411g;
        float f10 = pVarArr[0][0].f6684a;
        if (fD < f10) {
            fD = f10;
        } else if (fD > pVarArr[pVarArr.length - 1][0].f6685b) {
            fD = pVarArr[pVarArr.length - 1][0].f6685b;
        }
        int length = pVarArr.length;
        boolean z4 = false;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < fArr.length) {
                p pVar = pVarArr[i11][i13];
                if (fD <= pVar.f6685b) {
                    if (pVar.f6701r) {
                        fArr[i12] = pVar.f6697n;
                        fArr[i12 + 1] = pVar.f6698o;
                    } else {
                        pVar.c(fD);
                        fArr[i12] = pVarArr[i11][i13].a();
                        fArr[i12 + 1] = pVarArr[i11][i13].b();
                    }
                    z4 = true;
                }
                i12 += 2;
                i13++;
            }
            if (z4) {
                break;
            }
        }
        float[] fArr2 = this.f6672q;
        if (fArr2 == null) {
            q7.k.j("slopeArray");
            throw null;
        }
        int length2 = fArr2.length;
        while (i2 < length2) {
            n nVar6 = this.f6668m;
            if (nVar6 == null) {
                q7.k.j("velocityVector");
                throw null;
            }
            float[] fArr3 = this.f6672q;
            if (fArr3 == null) {
                q7.k.j("slopeArray");
                throw null;
            }
            nVar6.e(i2, fArr3[i2]);
            i2++;
        }
        n nVar7 = this.f6668m;
        if (nVar7 != null) {
            return nVar7;
        }
        q7.k.j("velocityVector");
        throw null;
    }

    @Override // n.h1
    public final n s(long j2, n nVar, n nVar2, n nVar3) throws Throwable {
        int i2;
        Throwable th;
        int length;
        int i10;
        boolean z4;
        n nVar4 = nVar;
        n nVar5 = nVar2;
        int i11 = 0;
        int i12 = this.f6663h;
        int iL = (int) nb.i.l((j2 / 1000000) - 0, 0L, i12);
        k.t tVar = this.f6662g;
        if (tVar.a(iL)) {
            Object objB = tVar.b(iL);
            q7.k.b(objB);
            return ((l1) objB).f6653a;
        }
        if (iL >= i12) {
            return nVar5;
        }
        if (iL <= 0) {
            return nVar4;
        }
        e(nVar4, nVar5, nVar3);
        boolean z10 = true;
        if (this.f6673r == null) {
            int iB = b(iL);
            float fD = d(iB, iL, true);
            k.s sVar = this.f6661f;
            int iC = sVar.c(iB);
            if (tVar.a(iC)) {
                Object objB2 = tVar.b(iC);
                q7.k.b(objB2);
                nVar4 = ((l1) objB2).f6653a;
            }
            int iC2 = sVar.c(iB + 1);
            if (tVar.a(iC2)) {
                Object objB3 = tVar.b(iC2);
                q7.k.b(objB3);
                nVar5 = ((l1) objB3).f6653a;
            }
            n nVar6 = this.f6667l;
            if (nVar6 == null) {
                q7.k.j("valueVector");
                throw null;
            }
            int iB2 = nVar6.b();
            for (int i13 = 0; i13 < iB2; i13++) {
                n nVar7 = this.f6667l;
                if (nVar7 == null) {
                    q7.k.j("valueVector");
                    throw null;
                }
                float fA = nVar4.a(i13);
                float fA2 = nVar5.a(i13);
                q6.b bVar = g1.f6621a;
                nVar7.e(i13, (fA2 * fD) + ((1 - fD) * fA));
            }
            n nVar8 = this.f6667l;
            if (nVar8 != null) {
                return nVar8;
            }
            q7.k.j("valueVector");
            throw null;
        }
        float fD2 = d(b(iL), iL, false);
        a7.d dVar = this.f6673r;
        if (dVar == null) {
            q7.k.j("arcSpline");
            throw null;
        }
        float[] fArr = this.f6671p;
        if (fArr == null) {
            q7.k.j("posArray");
            throw null;
        }
        p[][] pVarArr = (p[][]) dVar.f411g;
        float f10 = pVarArr[0][0].f6684a;
        if (fD2 >= f10 && fD2 <= pVarArr[pVarArr.length - 1][0].f6685b) {
            int length2 = pVarArr.length;
            int i14 = 0;
            boolean z11 = false;
            while (true) {
                if (i14 >= length2) {
                    i2 = i11;
                    th = null;
                    break;
                }
                int i15 = i11;
                int i16 = i15;
                while (i15 < fArr.length) {
                    p pVar = pVarArr[i14][i16];
                    if (fD2 <= pVar.f6685b) {
                        if (pVar.f6701r) {
                            float f11 = pVar.f6684a;
                            i10 = i11;
                            float f12 = pVar.f6694k;
                            float f13 = pVar.f6686c;
                            z4 = z10;
                            fArr[i15] = ((pVar.f6688e - f13) * (fD2 - f11) * f12) + f13;
                            float f14 = (fD2 - f11) * f12;
                            float f15 = pVar.f6687d;
                            fArr[i15 + 1] = ((pVar.f6689f - f15) * f14) + f15;
                        } else {
                            i10 = i11;
                            z4 = z10;
                            pVar.c(fD2);
                            p pVar2 = pVarArr[i14][i16];
                            fArr[i15] = (pVar2.f6695l * pVar2.f6691h) + pVar2.f6697n;
                            fArr[i15 + 1] = (pVar2.f6696m * pVar2.f6692i) + pVar2.f6698o;
                        }
                        z11 = z4;
                    } else {
                        i10 = i11;
                        z4 = z10;
                    }
                    i15 += 2;
                    i16++;
                    i11 = i10;
                    z10 = z4;
                }
                i2 = i11;
                boolean z12 = z10;
                th = null;
                if (z11) {
                    break;
                }
                i14++;
                i11 = i2;
                z10 = z12;
            }
        } else {
            i2 = 0;
            th = null;
            if (fD2 > pVarArr[pVarArr.length - 1][0].f6685b) {
                length = pVarArr.length - 1;
                f10 = pVarArr[pVarArr.length - 1][0].f6685b;
            } else {
                length = 0;
            }
            float f16 = fD2 - f10;
            int i17 = 0;
            int i18 = 0;
            while (i17 < fArr.length) {
                p pVar3 = pVarArr[length][i18];
                if (pVar3.f6701r) {
                    float f17 = pVar3.f6684a;
                    float f18 = pVar3.f6694k;
                    float f19 = pVar3.f6686c;
                    fArr[i17] = (pVar3.f6697n * f16) + ((pVar3.f6688e - f19) * (f10 - f17) * f18) + f19;
                    float f20 = (f10 - f17) * f18;
                    float f21 = pVar3.f6687d;
                    fArr[i17 + 1] = (pVar3.f6698o * f16) + ((pVar3.f6689f - f21) * f20) + f21;
                } else {
                    pVar3.c(f10);
                    p pVar4 = pVarArr[length][i18];
                    fArr[i17] = (pVar4.a() * f16) + (pVar4.f6695l * pVar4.f6691h) + pVar4.f6697n;
                    p pVar5 = pVarArr[length][i18];
                    fArr[i17 + 1] = (pVar5.b() * f16) + (pVar5.f6696m * pVar5.f6692i) + pVar5.f6698o;
                }
                i17 += 2;
                i18++;
            }
        }
        float[] fArr2 = this.f6671p;
        if (fArr2 == null) {
            q7.k.j("posArray");
            throw th;
        }
        int length3 = fArr2.length;
        for (int i19 = i2; i19 < length3; i19++) {
            n nVar9 = this.f6667l;
            if (nVar9 == null) {
                q7.k.j("valueVector");
                throw th;
            }
            float[] fArr3 = this.f6671p;
            if (fArr3 == null) {
                q7.k.j("posArray");
                throw th;
            }
            nVar9.e(i19, fArr3[i19]);
        }
        n nVar10 = this.f6667l;
        if (nVar10 != null) {
            return nVar10;
        }
        q7.k.j("valueVector");
        throw th;
    }

    @Override // n.i1
    public final int v() {
        return this.f6663h;
    }
}
