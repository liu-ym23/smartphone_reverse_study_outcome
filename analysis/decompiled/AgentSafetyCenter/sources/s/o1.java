package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 implements k1 {

    /* renamed from: c, reason: collision with root package name */
    public p.t f11064c;

    /* renamed from: f, reason: collision with root package name */
    public p.u f11065f;

    /* renamed from: g, reason: collision with root package name */
    public int f11066g;

    /* renamed from: h, reason: collision with root package name */
    public v f11067h;
    public int[] i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f11068j;

    /* renamed from: k, reason: collision with root package name */
    public n f11069k;

    /* renamed from: l, reason: collision with root package name */
    public n f11070l;

    /* renamed from: m, reason: collision with root package name */
    public n f11071m;

    /* renamed from: n, reason: collision with root package name */
    public n f11072n;

    /* renamed from: o, reason: collision with root package name */
    public float[] f11073o;

    /* renamed from: p, reason: collision with root package name */
    public float[] f11074p;

    /* renamed from: q, reason: collision with root package name */
    public a2.i f11075q;

    public final int c(int i) {
        int i3;
        p.t tVar = this.f11064c;
        int i10 = tVar.f9630b;
        if (i10 < 0) {
            m0.a("fromIndex(0) > toIndex(" + i10 + ')');
        }
        if (i10 > tVar.f9630b) {
            g5.f.q(k0.a.j(i10, "Index out of range: "));
            return 0;
        }
        int i11 = i10 - 1;
        int i12 = 0;
        while (true) {
            if (i12 <= i11) {
                i3 = (i12 + i11) >>> 1;
                int iC = tVar.c(i3);
                if (iC >= i) {
                    if (iC <= i) {
                        break;
                    }
                    i11 = i3 - 1;
                } else {
                    i12 = i3 + 1;
                }
            } else {
                i3 = -(i12 + 1);
                break;
            }
        }
        return i3 < -1 ? -(i3 + 2) : i3;
    }

    public final float d(int i, int i3, boolean z10) {
        v vVar;
        float f5;
        p.t tVar = this.f11064c;
        if (i >= tVar.f9630b - 1) {
            f5 = i3;
        } else {
            int iC = tVar.c(i);
            int iC2 = tVar.c(i + 1);
            if (i3 != iC) {
                int i10 = iC2 - iC;
                n1 n1Var = (n1) this.f11065f.b(iC);
                if (n1Var == null || (vVar = n1Var.f11061b) == null) {
                    vVar = this.f11067h;
                }
                float f10 = i10;
                float fA = vVar.a((i3 - iC) / f10);
                return z10 ? fA : ((f10 * fA) + iC) / 1000;
            }
            f5 = iC;
        }
        return f5 / 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(s.n r35, s.n r36, s.n r37) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.o1.e(s.n, s.n, s.n):void");
    }

    @Override // s.j1
    public final n h(long j10, n nVar, n nVar2, n nVar3) throws Throwable {
        int i = 0;
        long jR = p5.f.r((j10 / 1000000) - 0, 0L, this.f11066g);
        if (jR < 0) {
            return nVar3;
        }
        e(nVar, nVar2, nVar3);
        if (this.f11075q != null) {
            int i3 = (int) jR;
            float fD = d(c(i3), i3, false);
            a2.i iVar = this.f11075q;
            if (iVar == null) {
                yb.k.f("arcSpline");
                throw null;
            }
            float[] fArr = this.f11074p;
            if (fArr == null) {
                yb.k.f("slopeArray");
                throw null;
            }
            p[][] pVarArr = (p[][]) iVar.f49f;
            float f5 = pVarArr[0][0].f11077a;
            if (fD < f5) {
                fD = f5;
            } else if (fD > pVarArr[pVarArr.length - 1][0].f11078b) {
                fD = pVarArr[pVarArr.length - 1][0].f11078b;
            }
            int length = pVarArr.length;
            boolean z10 = false;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = 0;
                int i12 = 0;
                while (i11 < fArr.length) {
                    p pVar = pVarArr[i10][i12];
                    if (fD <= pVar.f11078b) {
                        if (pVar.f11093r) {
                            fArr[i11] = pVar.f11089n;
                            fArr[i11 + 1] = pVar.f11090o;
                        } else {
                            pVar.c(fD);
                            fArr[i11] = pVarArr[i10][i12].a();
                            fArr[i11 + 1] = pVarArr[i10][i12].b();
                        }
                        z10 = true;
                    }
                    i11 += 2;
                    i12++;
                }
                if (z10) {
                    break;
                }
            }
            float[] fArr2 = this.f11074p;
            if (fArr2 == null) {
                yb.k.f("slopeArray");
                throw null;
            }
            int length2 = fArr2.length;
            while (true) {
                n nVar4 = this.f11070l;
                if (i >= length2) {
                    if (nVar4 != null) {
                        return nVar4;
                    }
                    yb.k.f("velocityVector");
                    throw null;
                }
                if (nVar4 == null) {
                    yb.k.f("velocityVector");
                    throw null;
                }
                float[] fArr3 = this.f11074p;
                if (fArr3 == null) {
                    yb.k.f("slopeArray");
                    throw null;
                }
                nVar4.e(fArr3[i], i);
                i++;
            }
        } else {
            n nVarK = k((jR - 1) * 1000000, nVar, nVar2, nVar3);
            n nVarK2 = k(jR * 1000000, nVar, nVar2, nVar3);
            int iB = nVarK.b();
            while (true) {
                n nVar5 = this.f11070l;
                if (i >= iB) {
                    if (nVar5 != null) {
                        return nVar5;
                    }
                    yb.k.f("velocityVector");
                    throw null;
                }
                if (nVar5 == null) {
                    yb.k.f("velocityVector");
                    throw null;
                }
                nVar5.e((nVarK.a(i) - nVarK2.a(i)) * 1000.0f, i);
                i++;
            }
        }
    }

    @Override // s.j1
    public final n k(long j10, n nVar, n nVar2, n nVar3) throws Throwable {
        int i;
        Throwable th;
        int length;
        int i3;
        boolean z10;
        n nVar4 = nVar;
        n nVar5 = nVar2;
        p.t tVar = this.f11064c;
        int i10 = 0;
        int i11 = this.f11066g;
        int iR = (int) p5.f.r((j10 / 1000000) - 0, 0L, i11);
        p.u uVar = this.f11065f;
        if (uVar.a(iR)) {
            Object objB = uVar.b(iR);
            objB.getClass();
            return ((n1) objB).f11060a;
        }
        if (iR >= i11) {
            return nVar5;
        }
        if (iR <= 0) {
            return nVar4;
        }
        e(nVar4, nVar5, nVar3);
        boolean z11 = true;
        if (this.f11075q != null) {
            float fD = d(c(iR), iR, false);
            a2.i iVar = this.f11075q;
            if (iVar == null) {
                yb.k.f("arcSpline");
                throw null;
            }
            float[] fArr = this.f11073o;
            if (fArr == null) {
                yb.k.f("posArray");
                throw null;
            }
            p[][] pVarArr = (p[][]) iVar.f49f;
            float f5 = pVarArr[0][0].f11077a;
            if (fD >= f5 && fD <= pVarArr[pVarArr.length - 1][0].f11078b) {
                int length2 = pVarArr.length;
                int i12 = 0;
                boolean z12 = false;
                while (true) {
                    if (i12 >= length2) {
                        i = i10;
                        th = null;
                        break;
                    }
                    int i13 = i10;
                    int i14 = i13;
                    while (i13 < fArr.length) {
                        p pVar = pVarArr[i12][i14];
                        if (fD <= pVar.f11078b) {
                            if (pVar.f11093r) {
                                float f10 = pVar.f11077a;
                                i3 = i10;
                                float f11 = pVar.f11086k;
                                float f12 = pVar.f11079c;
                                z10 = z11;
                                fArr[i13] = k0.a.f(pVar.f11081e, f12, (fD - f10) * f11, f12);
                                float f13 = (fD - f10) * f11;
                                float f14 = pVar.f11080d;
                                fArr[i13 + 1] = k0.a.f(pVar.f11082f, f14, f13, f14);
                            } else {
                                i3 = i10;
                                z10 = z11;
                                pVar.c(fD);
                                p pVar2 = pVarArr[i12][i14];
                                fArr[i13] = (pVar2.f11087l * pVar2.f11084h) + pVar2.f11089n;
                                fArr[i13 + 1] = (pVar2.f11088m * pVar2.i) + pVar2.f11090o;
                            }
                            z12 = z10;
                        } else {
                            i3 = i10;
                            z10 = z11;
                        }
                        i13 += 2;
                        i14++;
                        i10 = i3;
                        z11 = z10;
                    }
                    i = i10;
                    boolean z13 = z11;
                    th = null;
                    if (z12) {
                        break;
                    }
                    i12++;
                    i10 = i;
                    z11 = z13;
                }
            } else {
                i = 0;
                th = null;
                if (fD > pVarArr[pVarArr.length - 1][0].f11078b) {
                    length = pVarArr.length - 1;
                    f5 = pVarArr[pVarArr.length - 1][0].f11078b;
                } else {
                    length = 0;
                }
                float f15 = fD - f5;
                int i15 = 0;
                int i16 = 0;
                while (i15 < fArr.length) {
                    p pVar3 = pVarArr[length][i16];
                    if (pVar3.f11093r) {
                        float f16 = pVar3.f11077a;
                        float f17 = pVar3.f11086k;
                        float f18 = pVar3.f11079c;
                        fArr[i15] = (pVar3.f11089n * f15) + k0.a.f(pVar3.f11081e, f18, (f5 - f16) * f17, f18);
                        float f19 = (f5 - f16) * f17;
                        float f20 = pVar3.f11080d;
                        fArr[i15 + 1] = (pVar3.f11090o * f15) + k0.a.f(pVar3.f11082f, f20, f19, f20);
                    } else {
                        pVar3.c(f5);
                        p pVar4 = pVarArr[length][i16];
                        fArr[i15] = (pVar4.a() * f15) + (pVar4.f11087l * pVar4.f11084h) + pVar4.f11089n;
                        p pVar5 = pVarArr[length][i16];
                        fArr[i15 + 1] = (pVar5.b() * f15) + (pVar5.f11088m * pVar5.i) + pVar5.f11090o;
                    }
                    i15 += 2;
                    i16++;
                }
            }
            float[] fArr2 = this.f11073o;
            if (fArr2 == null) {
                yb.k.f("posArray");
                throw th;
            }
            int length3 = fArr2.length;
            int i17 = i;
            while (true) {
                n nVar6 = this.f11069k;
                if (i17 >= length3) {
                    if (nVar6 != null) {
                        return nVar6;
                    }
                    yb.k.f("valueVector");
                    throw th;
                }
                if (nVar6 == null) {
                    yb.k.f("valueVector");
                    throw th;
                }
                float[] fArr3 = this.f11073o;
                if (fArr3 == null) {
                    yb.k.f("posArray");
                    throw th;
                }
                nVar6.e(fArr3[i17], i17);
                i17++;
            }
        } else {
            int iC = c(iR);
            float fD2 = d(iC, iR, true);
            int iC2 = tVar.c(iC);
            if (uVar.a(iC2)) {
                Object objB2 = uVar.b(iC2);
                objB2.getClass();
                nVar4 = ((n1) objB2).f11060a;
            }
            int iC3 = tVar.c(iC + 1);
            if (uVar.a(iC3)) {
                Object objB3 = uVar.b(iC3);
                objB3.getClass();
                nVar5 = ((n1) objB3).f11060a;
            }
            n nVar7 = this.f11069k;
            if (nVar7 == null) {
                yb.k.f("valueVector");
                throw null;
            }
            int iB = nVar7.b();
            int i18 = 0;
            while (true) {
                n nVar8 = this.f11069k;
                if (i18 >= iB) {
                    if (nVar8 != null) {
                        return nVar8;
                    }
                    yb.k.f("valueVector");
                    throw null;
                }
                if (nVar8 == null) {
                    yb.k.f("valueVector");
                    throw null;
                }
                float fA = nVar4.a(i18);
                float fA2 = nVar5.a(i18);
                n6.a aVar = i1.f11026a;
                nVar8.e((fA2 * fD2) + ((1 - fD2) * fA), i18);
                i18++;
            }
        }
    }

    @Override // s.k1
    public final int o() {
        return 0;
    }

    @Override // s.k1
    public final int r() {
        return this.f11066g;
    }
}
