package t;

import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import v.C0943c;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f15277p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f15278q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final g f15281c;

    /* renamed from: f, reason: collision with root package name */
    public c[] f15284f;

    /* renamed from: l, reason: collision with root package name */
    public final d f15290l;

    /* renamed from: o, reason: collision with root package name */
    public c f15293o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f15279a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f15280b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f15282d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f15283e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15285g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f15286h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f15287i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f15288j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f15289k = 32;

    /* renamed from: m, reason: collision with root package name */
    public i[] f15291m = new i[f15278q];

    /* renamed from: n, reason: collision with root package name */
    public int f15292n = 0;

    public e() {
        this.f15284f = null;
        this.f15284f = new c[32];
        s();
        d dVar = new d(0);
        this.f15290l = dVar;
        g gVar = new g(dVar);
        gVar.f15297f = new i[128];
        gVar.f15298g = 0;
        gVar.f15299h = new android.support.v4.media.session.c(gVar, gVar);
        this.f15281c = gVar;
        this.f15293o = new c(dVar);
    }

    public static int n(C0943c c0943c) {
        i iVar = c0943c.f15523i;
        if (iVar != null) {
            return (int) (iVar.f15305e + 0.5f);
        }
        return 0;
    }

    public final i a(int i4) {
        i iVar = (i) ((f) this.f15290l.f15275c).b();
        if (iVar == null) {
            iVar = new i(i4);
            iVar.f15312l = i4;
        } else {
            iVar.c();
            iVar.f15312l = i4;
        }
        int i5 = this.f15292n;
        int i6 = f15278q;
        if (i5 >= i6) {
            int i7 = i6 * 2;
            f15278q = i7;
            this.f15291m = (i[]) Arrays.copyOf(this.f15291m, i7);
        }
        i[] iVarArr = this.f15291m;
        int i8 = this.f15292n;
        this.f15292n = i8 + 1;
        iVarArr[i8] = iVar;
        return iVar;
    }

    public final void b(i iVar, i iVar2, int i4, float f4, i iVar3, i iVar4, int i5, int i6) {
        c cVarL = l();
        if (iVar2 == iVar3) {
            cVarL.f15270d.d(iVar, 1.0f);
            cVarL.f15270d.d(iVar4, 1.0f);
            cVarL.f15270d.d(iVar2, -2.0f);
        } else if (f4 == 0.5f) {
            cVarL.f15270d.d(iVar, 1.0f);
            cVarL.f15270d.d(iVar2, -1.0f);
            cVarL.f15270d.d(iVar3, -1.0f);
            cVarL.f15270d.d(iVar4, 1.0f);
            if (i4 > 0 || i5 > 0) {
                cVarL.f15268b = (-i4) + i5;
            }
        } else if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            cVarL.f15270d.d(iVar, -1.0f);
            cVarL.f15270d.d(iVar2, 1.0f);
            cVarL.f15268b = i4;
        } else if (f4 >= 1.0f) {
            cVarL.f15270d.d(iVar4, -1.0f);
            cVarL.f15270d.d(iVar3, 1.0f);
            cVarL.f15268b = -i5;
        } else {
            float f5 = 1.0f - f4;
            cVarL.f15270d.d(iVar, f5 * 1.0f);
            cVarL.f15270d.d(iVar2, f5 * (-1.0f));
            cVarL.f15270d.d(iVar3, (-1.0f) * f4);
            cVarL.f15270d.d(iVar4, 1.0f * f4);
            if (i4 > 0 || i5 > 0) {
                cVarL.f15268b = (i5 * f4) + ((-i4) * f5);
            }
        }
        if (i6 != 8) {
            cVarL.a(this, i6);
        }
        c(cVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(t.c r17) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.e.c(t.c):void");
    }

    public final void d(i iVar, int i4) {
        int i5 = iVar.f15303c;
        if (i5 == -1) {
            iVar.d(this, i4);
            for (int i6 = 0; i6 < this.f15280b + 1; i6++) {
                i iVar2 = ((i[]) this.f15290l.f15276d)[i6];
            }
            return;
        }
        if (i5 == -1) {
            c cVarL = l();
            cVarL.f15267a = iVar;
            float f4 = i4;
            iVar.f15305e = f4;
            cVarL.f15268b = f4;
            cVarL.f15271e = true;
            c(cVarL);
            return;
        }
        c cVar = this.f15284f[i5];
        if (cVar.f15271e) {
            cVar.f15268b = i4;
            return;
        }
        if (cVar.f15270d.f() == 0) {
            cVar.f15271e = true;
            cVar.f15268b = i4;
            return;
        }
        c cVarL2 = l();
        if (i4 < 0) {
            cVarL2.f15268b = i4 * (-1);
            cVarL2.f15270d.d(iVar, 1.0f);
        } else {
            cVarL2.f15268b = i4;
            cVarL2.f15270d.d(iVar, -1.0f);
        }
        c(cVarL2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(t.i r6, t.i r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = 8
            if (r9 != r0) goto L15
            boolean r1 = r7.f15306f
            if (r1 == 0) goto L15
            int r1 = r6.f15303c
            r2 = -1
            if (r1 != r2) goto L15
            float r7 = r7.f15305e
            float r8 = (float) r8
            float r7 = r7 + r8
            r6.d(r5, r7)
            return
        L15:
            t.c r1 = r5.l()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r8 == 0) goto L37
            if (r8 >= 0) goto L25
            int r8 = r8 * (-1)
            r4 = 1
            goto L26
        L25:
            r4 = 0
        L26:
            float r8 = (float) r8
            r1.f15268b = r8
            if (r4 != 0) goto L2c
            goto L37
        L2c:
            t.b r8 = r1.f15270d
            r8.d(r6, r2)
            t.b r6 = r1.f15270d
            r6.d(r7, r3)
            goto L41
        L37:
            t.b r8 = r1.f15270d
            r8.d(r6, r3)
            t.b r6 = r1.f15270d
            r6.d(r7, r2)
        L41:
            if (r9 == r0) goto L46
            r1.a(r5, r9)
        L46:
            r5.c(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t.e.e(t.i, t.i, int, int):void");
    }

    public final void f(i iVar, i iVar2, int i4, int i5) {
        c cVarL = l();
        i iVarM = m();
        iVarM.f15304d = 0;
        cVarL.b(iVar, iVar2, iVarM, i4);
        if (i5 != 8) {
            cVarL.f15270d.d(j(i5), (int) (cVarL.f15270d.e(iVarM) * (-1.0f)));
        }
        c(cVarL);
    }

    public final void g(i iVar, i iVar2, int i4, int i5) {
        c cVarL = l();
        i iVarM = m();
        iVarM.f15304d = 0;
        cVarL.c(iVar, iVar2, iVarM, i4);
        if (i5 != 8) {
            cVarL.f15270d.d(j(i5), (int) (cVarL.f15270d.e(iVarM) * (-1.0f)));
        }
        c(cVarL);
    }

    public final void h(c cVar) {
        int i4;
        if (cVar.f15271e) {
            cVar.f15267a.d(this, cVar.f15268b);
        } else {
            c[] cVarArr = this.f15284f;
            int i5 = this.f15288j;
            cVarArr[i5] = cVar;
            i iVar = cVar.f15267a;
            iVar.f15303c = i5;
            this.f15288j = i5 + 1;
            iVar.e(this, cVar);
        }
        if (this.f15279a) {
            int i6 = 0;
            while (i6 < this.f15288j) {
                if (this.f15284f[i6] == null) {
                    System.out.println("WTF");
                }
                c cVar2 = this.f15284f[i6];
                if (cVar2 != null && cVar2.f15271e) {
                    cVar2.f15267a.d(this, cVar2.f15268b);
                    ((f) this.f15290l.f15274b).a(cVar2);
                    this.f15284f[i6] = null;
                    int i7 = i6 + 1;
                    int i8 = i7;
                    while (true) {
                        i4 = this.f15288j;
                        if (i7 >= i4) {
                            break;
                        }
                        c[] cVarArr2 = this.f15284f;
                        int i9 = i7 - 1;
                        c cVar3 = cVarArr2[i7];
                        cVarArr2[i9] = cVar3;
                        i iVar2 = cVar3.f15267a;
                        if (iVar2.f15303c == i7) {
                            iVar2.f15303c = i9;
                        }
                        i8 = i7;
                        i7++;
                    }
                    if (i8 < i4) {
                        this.f15284f[i8] = null;
                    }
                    this.f15288j = i4 - 1;
                    i6--;
                }
                i6++;
            }
            this.f15279a = false;
        }
    }

    public final void i() {
        for (int i4 = 0; i4 < this.f15288j; i4++) {
            c cVar = this.f15284f[i4];
            cVar.f15267a.f15305e = cVar.f15268b;
        }
    }

    public final i j(int i4) {
        if (this.f15287i + 1 >= this.f15283e) {
            o();
        }
        i iVarA = a(4);
        int i5 = this.f15280b + 1;
        this.f15280b = i5;
        this.f15287i++;
        iVarA.f15302b = i5;
        iVarA.f15304d = i4;
        ((i[]) this.f15290l.f15276d)[i5] = iVarA;
        g gVar = this.f15281c;
        gVar.f15299h.f2364b = iVarA;
        float[] fArr = iVarA.f15308h;
        Arrays.fill(fArr, Property.DEFAULT_FLOAT_VALUE);
        fArr[iVarA.f15304d] = 1.0f;
        gVar.j(iVarA);
        return iVarA;
    }

    public final i k(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f15287i + 1 >= this.f15283e) {
            o();
        }
        if (obj instanceof C0943c) {
            C0943c c0943c = (C0943c) obj;
            iVar = c0943c.f15523i;
            if (iVar == null) {
                c0943c.k();
                iVar = c0943c.f15523i;
            }
            int i4 = iVar.f15302b;
            d dVar = this.f15290l;
            if (i4 == -1 || i4 > this.f15280b || ((i[]) dVar.f15276d)[i4] == null) {
                if (i4 != -1) {
                    iVar.c();
                }
                int i5 = this.f15280b + 1;
                this.f15280b = i5;
                this.f15287i++;
                iVar.f15302b = i5;
                iVar.f15312l = 1;
                ((i[]) dVar.f15276d)[i5] = iVar;
            }
        }
        return iVar;
    }

    public final c l() {
        d dVar = this.f15290l;
        c cVar = (c) ((f) dVar.f15274b).b();
        if (cVar == null) {
            return new c(dVar);
        }
        cVar.f15267a = null;
        cVar.f15270d.clear();
        cVar.f15268b = Property.DEFAULT_FLOAT_VALUE;
        cVar.f15271e = false;
        return cVar;
    }

    public final i m() {
        if (this.f15287i + 1 >= this.f15283e) {
            o();
        }
        i iVarA = a(3);
        int i4 = this.f15280b + 1;
        this.f15280b = i4;
        this.f15287i++;
        iVarA.f15302b = i4;
        ((i[]) this.f15290l.f15276d)[i4] = iVarA;
        return iVarA;
    }

    public final void o() {
        int i4 = this.f15282d * 2;
        this.f15282d = i4;
        this.f15284f = (c[]) Arrays.copyOf(this.f15284f, i4);
        d dVar = this.f15290l;
        dVar.f15276d = (i[]) Arrays.copyOf((i[]) dVar.f15276d, this.f15282d);
        int i5 = this.f15282d;
        this.f15286h = new boolean[i5];
        this.f15283e = i5;
        this.f15289k = i5;
    }

    public final void p() {
        g gVar = this.f15281c;
        if (gVar.e()) {
            i();
            return;
        }
        if (!this.f15285g) {
            q(gVar);
            return;
        }
        for (int i4 = 0; i4 < this.f15288j; i4++) {
            if (!this.f15284f[i4].f15271e) {
                q(gVar);
                return;
            }
        }
        i();
    }

    public final void q(g gVar) {
        int i4 = 0;
        while (true) {
            if (i4 >= this.f15288j) {
                break;
            }
            c cVar = this.f15284f[i4];
            int i5 = 1;
            if (cVar.f15267a.f15312l != 1) {
                float f4 = cVar.f15268b;
                float f5 = Property.DEFAULT_FLOAT_VALUE;
                if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                    boolean z4 = false;
                    int i6 = 0;
                    while (!z4) {
                        i6 += i5;
                        float f6 = Float.MAX_VALUE;
                        int i7 = -1;
                        int i8 = -1;
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < this.f15288j) {
                            c cVar2 = this.f15284f[i9];
                            if (cVar2.f15267a.f15312l != i5 && !cVar2.f15271e && cVar2.f15268b < f5) {
                                int iF = cVar2.f15270d.f();
                                int i11 = 0;
                                while (i11 < iF) {
                                    i iVarH = cVar2.f15270d.h(i11);
                                    float fE = cVar2.f15270d.e(iVarH);
                                    if (fE > f5) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f7 = iVarH.f15307g[i12] / fE;
                                            if ((f7 < f6 && i12 == i10) || i12 > i10) {
                                                i10 = i12;
                                                i8 = iVarH.f15302b;
                                                i7 = i9;
                                                f6 = f7;
                                            }
                                        }
                                    }
                                    i11++;
                                    f5 = Property.DEFAULT_FLOAT_VALUE;
                                }
                            }
                            i9++;
                            f5 = Property.DEFAULT_FLOAT_VALUE;
                            i5 = 1;
                        }
                        if (i7 != -1) {
                            c cVar3 = this.f15284f[i7];
                            cVar3.f15267a.f15303c = -1;
                            cVar3.g(((i[]) this.f15290l.f15276d)[i8]);
                            i iVar = cVar3.f15267a;
                            iVar.f15303c = i7;
                            iVar.e(this, cVar3);
                        } else {
                            z4 = true;
                        }
                        if (i6 > this.f15287i / 2) {
                            z4 = true;
                        }
                        f5 = Property.DEFAULT_FLOAT_VALUE;
                        i5 = 1;
                    }
                }
            }
            i4++;
        }
        r(gVar);
        i();
    }

    public final void r(c cVar) {
        for (int i4 = 0; i4 < this.f15287i; i4++) {
            this.f15286h[i4] = false;
        }
        boolean z4 = false;
        int i5 = 0;
        while (!z4) {
            i5++;
            if (i5 >= this.f15287i * 2) {
                return;
            }
            i iVar = cVar.f15267a;
            if (iVar != null) {
                this.f15286h[iVar.f15302b] = true;
            }
            i iVarD = cVar.d(this.f15286h);
            if (iVarD != null) {
                boolean[] zArr = this.f15286h;
                int i6 = iVarD.f15302b;
                if (zArr[i6]) {
                    return;
                } else {
                    zArr[i6] = true;
                }
            }
            if (iVarD != null) {
                float f4 = Float.MAX_VALUE;
                int i7 = -1;
                for (int i8 = 0; i8 < this.f15288j; i8++) {
                    c cVar2 = this.f15284f[i8];
                    if (cVar2.f15267a.f15312l != 1 && !cVar2.f15271e && cVar2.f15270d.g(iVarD)) {
                        float fE = cVar2.f15270d.e(iVarD);
                        if (fE < Property.DEFAULT_FLOAT_VALUE) {
                            float f5 = (-cVar2.f15268b) / fE;
                            if (f5 < f4) {
                                i7 = i8;
                                f4 = f5;
                            }
                        }
                    }
                }
                if (i7 > -1) {
                    c cVar3 = this.f15284f[i7];
                    cVar3.f15267a.f15303c = -1;
                    cVar3.g(iVarD);
                    i iVar2 = cVar3.f15267a;
                    iVar2.f15303c = i7;
                    iVar2.e(this, cVar3);
                }
            } else {
                z4 = true;
            }
        }
    }

    public final void s() {
        for (int i4 = 0; i4 < this.f15288j; i4++) {
            c cVar = this.f15284f[i4];
            if (cVar != null) {
                ((f) this.f15290l.f15274b).a(cVar);
            }
            this.f15284f[i4] = null;
        }
    }

    public final void t() {
        d dVar;
        int i4 = 0;
        while (true) {
            dVar = this.f15290l;
            i[] iVarArr = (i[]) dVar.f15276d;
            if (i4 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i4];
            if (iVar != null) {
                iVar.c();
            }
            i4++;
        }
        f fVar = (f) dVar.f15275c;
        i[] iVarArr2 = this.f15291m;
        int length = this.f15292n;
        fVar.getClass();
        if (length > iVarArr2.length) {
            length = iVarArr2.length;
        }
        for (int i5 = 0; i5 < length; i5++) {
            i iVar2 = iVarArr2[i5];
            int i6 = fVar.f15296c;
            Object[] objArr = fVar.f15295b;
            if (i6 < objArr.length) {
                objArr[i6] = iVar2;
                fVar.f15296c = i6 + 1;
            }
        }
        this.f15292n = 0;
        Arrays.fill((i[]) dVar.f15276d, (Object) null);
        this.f15280b = 0;
        g gVar = this.f15281c;
        gVar.f15298g = 0;
        gVar.f15268b = Property.DEFAULT_FLOAT_VALUE;
        this.f15287i = 1;
        for (int i7 = 0; i7 < this.f15288j; i7++) {
            c cVar = this.f15284f[i7];
        }
        s();
        this.f15288j = 0;
        this.f15293o = new c(dVar);
    }
}
