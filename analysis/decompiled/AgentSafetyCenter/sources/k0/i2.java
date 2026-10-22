package k0;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    public f2 f6938a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f6939b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f6940c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f6941d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f6942e;

    /* renamed from: f, reason: collision with root package name */
    public p.u f6943f;

    /* renamed from: g, reason: collision with root package name */
    public int f6944g;

    /* renamed from: h, reason: collision with root package name */
    public int f6945h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f6946j;

    /* renamed from: k, reason: collision with root package name */
    public int f6947k;

    /* renamed from: l, reason: collision with root package name */
    public int f6948l;

    /* renamed from: m, reason: collision with root package name */
    public int f6949m;

    /* renamed from: n, reason: collision with root package name */
    public int f6950n;

    /* renamed from: o, reason: collision with root package name */
    public int f6951o;

    /* renamed from: p, reason: collision with root package name */
    public r0 f6952p;

    /* renamed from: q, reason: collision with root package name */
    public r0 f6953q;

    /* renamed from: r, reason: collision with root package name */
    public r0 f6954r;

    /* renamed from: s, reason: collision with root package name */
    public p.u f6955s;

    /* renamed from: t, reason: collision with root package name */
    public int f6956t;

    /* renamed from: u, reason: collision with root package name */
    public int f6957u;

    /* renamed from: v, reason: collision with root package name */
    public int f6958v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6959w;

    /* renamed from: x, reason: collision with root package name */
    public p.t f6960x;

    public static int i(int i, int i3, int i10, int i11) {
        return i > i3 ? -(((i11 - i10) - i) + 1) : i;
    }

    public static void y(i2 i2Var) {
        int i = i2Var.f6958v;
        int iR = i2Var.r(i);
        int[] iArr = i2Var.f6939b;
        int i3 = (iR * 5) + 1;
        int i10 = iArr[i3];
        if ((i10 & 134217728) != 0) {
            return;
        }
        int i11 = (i10 & (-134217729)) | 134217728;
        iArr[i3] = i11;
        if ((67108864 & i11) != 0) {
            return;
        }
        i2Var.S(i2Var.D(iArr, i));
    }

    public final void A(int i) {
        b bVar;
        int i3;
        b bVar2;
        int i10;
        int i11;
        int i12 = this.f6945h;
        int i13 = this.f6944g;
        if (i13 != i) {
            if (!this.f6941d.isEmpty()) {
                int iO = o() - this.f6945h;
                ArrayList arrayList = this.f6941d;
                if (i13 < i) {
                    for (int iB = h2.b(arrayList, i13, iO); iB < this.f6941d.size() && (i10 = (bVar2 = (b) this.f6941d.get(iB)).f6864a) < 0 && (i11 = i10 + iO) < i; iB++) {
                        bVar2.f6864a = i11;
                    }
                } else {
                    for (int iB2 = h2.b(arrayList, i, iO); iB2 < this.f6941d.size() && (i3 = (bVar = (b) this.f6941d.get(iB2)).f6864a) >= 0; iB2++) {
                        bVar.f6864a = -(iO - i3);
                    }
                }
            }
            if (i12 > 0) {
                int[] iArr = this.f6939b;
                int i14 = i * 5;
                int i15 = i12 * 5;
                int i16 = i13 * 5;
                if (i < i13) {
                    kb.k.f0(i15 + i14, i14, iArr, iArr, i16);
                } else {
                    kb.k.f0(i16, i16 + i15, iArr, iArr, i14 + i15);
                }
            }
            if (i < i13) {
                i13 = i + i12;
            }
            int iO2 = o();
            if (i13 >= iO2) {
                t.c("Check failed");
            }
            while (i13 < iO2) {
                int i17 = (i13 * 5) + 2;
                int i18 = this.f6939b[i17];
                int iP = i18 > -2 ? i18 : (p() + i18) - (-2);
                if (iP >= i) {
                    iP = -((p() - iP) - (-2));
                }
                if (iP != i18) {
                    this.f6939b[i17] = iP;
                }
                i13++;
                if (i13 == i) {
                    i13 += i12;
                }
            }
        }
        this.f6944g = i;
    }

    public final void B(int i, int i3) {
        int i10 = this.f6948l;
        int i11 = this.f6947k;
        int i12 = this.f6949m;
        if (i11 != i) {
            Object[] objArr = this.f6940c;
            if (i < i11) {
                System.arraycopy(objArr, i, objArr, i + i10, i11 - i);
            } else {
                int i13 = i11 + i10;
                System.arraycopy(objArr, i13, objArr, i11, (i + i10) - i13);
            }
        }
        int iMin = Math.min(i3 + 1, p());
        if (i12 != iMin) {
            int length = this.f6940c.length - i10;
            if (iMin < i12) {
                int iR = r(iMin);
                int iR2 = r(i12);
                int i14 = this.f6944g;
                while (iR < iR2) {
                    int i15 = (iR * 5) + 4;
                    int i16 = this.f6939b[i15];
                    if (!(i16 >= 0)) {
                        t.c("Unexpected anchor value, expected a positive anchor");
                    }
                    this.f6939b[i15] = -((length - i16) + 1);
                    iR++;
                    if (iR == i14) {
                        iR += this.f6945h;
                    }
                }
            } else {
                int iR3 = r(i12);
                int iR4 = r(iMin);
                while (iR3 < iR4) {
                    int i17 = (iR3 * 5) + 4;
                    int i18 = this.f6939b[i17];
                    if (!(i18 < 0)) {
                        t.c("Unexpected anchor value, expected a negative anchor");
                    }
                    this.f6939b[i17] = i18 + length + 1;
                    iR3++;
                    if (iR3 == this.f6944g) {
                        iR3 += this.f6945h;
                    }
                }
            }
            this.f6949m = iMin;
        }
        this.f6947k = i;
    }

    public final Object C(int i) {
        int iR = r(i);
        int[] iArr = this.f6939b;
        if ((iArr[(iR * 5) + 1] & 1073741824) != 0) {
            return this.f6940c[h(g(iArr, iR))];
        }
        return null;
    }

    public final int D(int[] iArr, int i) {
        int i3 = iArr[(r(i) * 5) + 2];
        return i3 > -2 ? i3 : (p() + i3) - (-2);
    }

    public final Object E(Object obj) {
        if (this.f6950n > 0) {
            w(1, this.f6958v);
        }
        Object[] objArr = this.f6940c;
        int i = this.i;
        this.i = i + 1;
        Object obj2 = objArr[h(i)];
        if (this.i > this.f6946j) {
            t.c("Writing to an invalid slot");
        }
        this.f6940c[h(this.i - 1)] = obj;
        return obj2;
    }

    public final void F() {
        int i;
        p.t tVar = this.f6960x;
        if (tVar != null) {
            while (tVar.f9630b != 0) {
                int iC = z.C(tVar);
                int iR = r(iC);
                int iT = iC + 1;
                int iT2 = t(iC) + iC;
                while (true) {
                    if (iT >= iT2) {
                        i = 0;
                        break;
                    } else {
                        if ((this.f6939b[(r(iT) * 5) + 1] & 201326592) != 0) {
                            i = 1;
                            break;
                        }
                        iT += t(iT);
                    }
                }
                int[] iArr = this.f6939b;
                int i3 = (iR * 5) + 1;
                int i10 = iArr[i3];
                if (((67108864 & i10) != 0 ? 1 : 0) != i) {
                    iArr[i3] = (i << 26) | ((-67108865) & i10);
                    int iD = D(iArr, iC);
                    if (iD >= 0) {
                        z.k(tVar, iD);
                    }
                }
            }
        }
    }

    public final boolean G() {
        if (!(this.f6950n == 0)) {
            t.c("Cannot remove group while inserting");
        }
        int i = this.f6956t;
        int i3 = this.i;
        int iG = g(this.f6939b, r(i));
        int iK = K();
        N(this.f6958v);
        p.t tVar = this.f6960x;
        if (tVar != null) {
            while (true) {
                int i10 = tVar.f9630b;
                if (i10 == 0) {
                    break;
                }
                if (i10 == 0) {
                    g5.f.m("IntList is empty.");
                    return false;
                }
                if (tVar.f9629a[0] < i) {
                    break;
                }
                z.C(tVar);
            }
        }
        boolean zH = H(i, this.f6956t - i);
        I(iG, this.i - iG, i - 1);
        this.f6956t = i;
        this.i = i3;
        this.f6951o -= iK;
        return zH;
    }

    public final boolean H(int i, int i3) {
        if (i3 > 0) {
            ArrayList arrayList = this.f6941d;
            A(i);
            if (!arrayList.isEmpty()) {
                HashMap map = this.f6942e;
                int i10 = i + i3;
                int iB = h2.b(this.f6941d, i10, o() - this.f6945h);
                if (iB >= this.f6941d.size()) {
                    iB--;
                }
                int i11 = iB + 1;
                int i12 = 0;
                while (iB >= 0) {
                    b bVar = (b) this.f6941d.get(iB);
                    int iC = c(bVar);
                    if (iC < i) {
                        break;
                    }
                    if (iC < i10) {
                        bVar.f6864a = Integer.MIN_VALUE;
                        if (map != null) {
                        }
                        if (i12 == 0) {
                            i12 = iB + 1;
                        }
                        i11 = iB;
                    }
                    iB--;
                }
                z = i11 < i12;
                if (z) {
                    this.f6941d.subList(i11, i12).clear();
                }
            }
            this.f6944g = i;
            this.f6945h += i3;
            int i13 = this.f6949m;
            if (i13 > i) {
                this.f6949m = Math.max(i, i13 - i3);
            }
            int i14 = this.f6957u;
            if (i14 >= this.f6944g) {
                this.f6957u = i14 - i3;
            }
            int i15 = this.f6958v;
            if (i15 >= 0 && (this.f6939b[(r(i15) * 5) + 1] & 67108864) != 0) {
                S(i15);
            }
        }
        return z;
    }

    public final void I(int i, int i3, int i10) {
        if (i3 > 0) {
            int i11 = this.f6948l;
            int i12 = i + i3;
            B(i12, i10);
            this.f6947k = i;
            this.f6948l = i11 + i3;
            kb.k.m0(null, i, this.f6940c, i12);
            int i13 = this.f6946j;
            if (i13 >= i) {
                this.f6946j = i13 - i3;
            }
        }
    }

    public final Object J(int i, int i3, Object obj) {
        int iM = M(this.f6939b, r(i));
        int iG = g(this.f6939b, r(i + 1));
        int i10 = iM + i3;
        if (i10 < iM || i10 >= iG) {
            t.c("Write to an invalid slot index " + i3 + " for group " + i);
        }
        int iH = h(i10);
        Object[] objArr = this.f6940c;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    public final int K() {
        int iR = r(this.f6956t);
        int iA = h2.a(this.f6939b, iR) + this.f6956t;
        this.f6956t = iA;
        this.i = g(this.f6939b, r(iA));
        int i = this.f6939b[(iR * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & 67108863;
    }

    public final void L() {
        int i = this.f6957u;
        this.f6956t = i;
        this.i = g(this.f6939b, r(i));
    }

    public final int M(int[] iArr, int i) {
        if (i >= o()) {
            return this.f6940c.length - this.f6948l;
        }
        int iC = h2.c(iArr, i);
        return iC < 0 ? (this.f6940c.length - this.f6948l) + iC + 1 : iC;
    }

    public final q0 N(int i) {
        b bVarQ;
        HashMap map = this.f6942e;
        if (map == null || (bVarQ = Q(i)) == null) {
            return null;
        }
        return (q0) map.get(bVarQ);
    }

    public final void O() {
        if (this.f6950n != 0) {
            t.c("Key must be supplied when inserting");
        }
        y0 y0Var = m.f6974a;
        P(0, y0Var, false, y0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(int i, Object obj, boolean z10, Object obj2) {
        int i3;
        int i10 = this.f6958v;
        Object[] objArr = this.f6950n > 0;
        this.f6954r.c(this.f6951o);
        y0 y0Var = m.f6974a;
        if (objArr == true) {
            int i11 = this.f6956t;
            int iG = g(this.f6939b, r(i11));
            v(1);
            this.i = iG;
            this.f6946j = iG;
            int iR = r(i11);
            int i12 = obj != y0Var ? 1 : 0;
            int i13 = (z10 || obj2 == y0Var) ? 0 : 1;
            int i14 = i(iG, this.f6947k, this.f6948l, this.f6940c.length);
            if (i14 >= 0 && this.f6949m < i11) {
                i14 = -(((this.f6940c.length - this.f6948l) - i14) + 1);
            }
            int[] iArr = this.f6939b;
            int i15 = this.f6958v;
            int i16 = iR * 5;
            iArr[i16] = i;
            iArr[i16 + 1] = ((z10 ? 1 : 0) << 30) | (i12 << 29) | (i13 << 28);
            iArr[i16 + 2] = i15;
            iArr[i16 + 3] = 0;
            iArr[i16 + 4] = i14;
            int i17 = (z10 ? 1 : 0) + i12 + i13;
            if (i17 > 0) {
                w(i17, i11);
                Object[] objArr2 = this.f6940c;
                int i18 = this.i;
                if (z10) {
                    objArr2[i18] = obj2;
                    i18++;
                }
                if (i12 != 0) {
                    objArr2[i18] = obj;
                    i18++;
                }
                if (i13 != 0) {
                    objArr2[i18] = obj2;
                    i18++;
                }
                this.i = i18;
            }
            this.f6951o = 0;
            i3 = i11 + 1;
            this.f6958v = i11;
            this.f6956t = i3;
            if (i10 >= 0) {
                N(i10);
            }
        } else {
            this.f6952p.c(i10);
            this.f6953q.c((o() - this.f6945h) - this.f6957u);
            int i19 = this.f6956t;
            int iR2 = r(i19);
            if (!yb.k.a(obj2, y0Var)) {
                if (z10) {
                    T(this.f6956t, obj2);
                } else {
                    R(obj2);
                }
            }
            this.i = M(this.f6939b, iR2);
            this.f6946j = g(this.f6939b, r(this.f6956t + 1));
            int[] iArr2 = this.f6939b;
            int i20 = iR2 * 5;
            this.f6951o = iArr2[i20 + 1] & 67108863;
            this.f6958v = i19;
            this.f6956t = i19 + 1;
            i3 = i19 + iArr2[i20 + 3];
        }
        this.f6957u = i3;
    }

    public final b Q(int i) {
        ArrayList arrayList;
        int iE;
        if (i < 0 || i >= p() || (iE = h2.e((arrayList = this.f6941d), i, p())) < 0) {
            return null;
        }
        return (b) arrayList.get(iE);
    }

    public final void R(Object obj) {
        int iR = r(this.f6956t);
        int i = (iR * 5) + 1;
        if ((this.f6939b[i] & 268435456) == 0) {
            t.c("Updating the data of a group that was not created with a data slot");
        }
        Object[] objArr = this.f6940c;
        int[] iArr = this.f6939b;
        objArr[h(Integer.bitCount(iArr[i] >> 29) + g(iArr, iR))] = obj;
    }

    public final void S(int i) {
        if (i >= 0) {
            p.t tVar = this.f6960x;
            if (tVar == null) {
                tVar = new p.t();
                this.f6960x = tVar;
            }
            z.k(tVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.r(r5)
            int[] r1 = r4.f6939b
            int r2 = r1.length
            if (r0 >= r2) goto L15
            int r2 = r0 * 5
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r2 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r2
            if (r1 == 0) goto L15
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L2e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Updating the node of a group at "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " that was not created with as a node group"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            k0.t.c(r5)
        L2e:
            java.lang.Object[] r5 = r4.f6940c
            int[] r1 = r4.f6939b
            int r0 = r4.g(r1, r0)
            int r4 = r4.h(r0)
            r5[r4] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.i2.T(int, java.lang.Object):void");
    }

    public final void a(int i) {
        boolean z10 = false;
        if (!(i >= 0)) {
            t.c("Cannot seek backwards");
        }
        if (!(this.f6950n <= 0)) {
            q1.b("Cannot call seek() while inserting");
        }
        if (i == 0) {
            return;
        }
        int i3 = this.f6956t + i;
        if (i3 >= this.f6958v && i3 <= this.f6957u) {
            z10 = true;
        }
        if (!z10) {
            t.c("Cannot seek outside the current group (" + this.f6958v + '-' + this.f6957u + ')');
        }
        this.f6956t = i3;
        int iG = g(this.f6939b, r(i3));
        this.i = iG;
        this.f6946j = iG;
    }

    public final b b(int i) {
        ArrayList arrayList = this.f6941d;
        int iE = h2.e(arrayList, i, p());
        if (iE >= 0) {
            return (b) arrayList.get(iE);
        }
        if (i > this.f6944g) {
            i = -(p() - i);
        }
        b bVar = new b(i);
        arrayList.add(-(iE + 1), bVar);
        return bVar;
    }

    public final int c(b bVar) {
        int i = bVar.f6864a;
        return i < 0 ? p() + i : i;
    }

    public final void d() {
        int i = this.f6950n;
        this.f6950n = i + 1;
        if (i == 0) {
            this.f6953q.c((o() - this.f6945h) - this.f6957u);
        }
    }

    public final void e(boolean z10) {
        f2 f2Var = this.f6938a;
        this.f6959w = true;
        if (z10 && this.f6952p.f7030b == 0) {
            A(p());
            B(this.f6940c.length - this.f6948l, this.f6944g);
            int i = this.f6947k;
            kb.k.m0(null, i, this.f6940c, this.f6948l + i);
            F();
        }
        int[] iArr = this.f6939b;
        int i3 = this.f6944g;
        Object[] objArr = this.f6940c;
        int i10 = this.f6947k;
        ArrayList arrayList = this.f6941d;
        HashMap map = this.f6942e;
        p.u uVar = this.f6943f;
        if (!f2Var.f6905k) {
            q1.a("Unexpected writer close()");
        }
        f2Var.f6905k = false;
        f2Var.f6900c = iArr;
        f2Var.f6901f = i3;
        f2Var.f6902g = objArr;
        f2Var.f6903h = i10;
        f2Var.f6907m = arrayList;
        f2Var.f6908n = map;
        f2Var.f6909o = uVar;
    }

    public final int f(int i) {
        return g(this.f6939b, r(i));
    }

    public final int g(int[] iArr, int i) {
        if (i >= o()) {
            return this.f6940c.length - this.f6948l;
        }
        int i3 = iArr[(i * 5) + 4];
        return i3 < 0 ? (this.f6940c.length - this.f6948l) + i3 + 1 : i3;
    }

    public final int h(int i) {
        return (this.f6948l * (i < this.f6947k ? 0 : 1)) + i;
    }

    public final void j() {
        p.a0 a0Var;
        r0 r0Var = this.f6954r;
        boolean z10 = this.f6950n > 0;
        int i = this.f6956t;
        int i3 = this.f6957u;
        int i10 = this.f6958v;
        int iR = r(i10);
        int i11 = this.f6951o;
        int i12 = i - i10;
        int i13 = iR * 5;
        int i14 = i13 + 1;
        boolean z11 = (this.f6939b[i14] & 1073741824) != 0;
        if (z10) {
            p.u uVar = this.f6955s;
            if (uVar != null && (a0Var = (p.a0) uVar.b(i10)) != null) {
                Object[] objArr = a0Var.f9516a;
                int i15 = a0Var.f9517b;
                for (int i16 = 0; i16 < i15; i16++) {
                    E(objArr[i16]);
                }
            }
            int[] iArr = this.f6939b;
            iArr[i13 + 3] = i12;
            h2.d(iR, i11, iArr);
            int iB = r0Var.b();
            if (z11) {
                i11 = 1;
            }
            this.f6951o = iB + i11;
            int iD = D(this.f6939b, i10);
            this.f6958v = iD;
            int iP = iD < 0 ? p() : r(iD + 1);
            int iG = iP >= 0 ? g(this.f6939b, iP) : 0;
            this.i = iG;
            this.f6946j = iG;
            return;
        }
        if (i != i3) {
            t.c("Expected to be at the end of a group");
        }
        int iA = h2.a(this.f6939b, iR);
        int[] iArr2 = this.f6939b;
        int i17 = iArr2[i14] & 67108863;
        iArr2[i13 + 3] = i12;
        h2.d(iR, i11, iArr2);
        int iB2 = this.f6952p.b();
        this.f6957u = (o() - this.f6945h) - this.f6953q.b();
        this.f6958v = iB2;
        int iD2 = D(this.f6939b, i10);
        int iB3 = r0Var.b();
        this.f6951o = iB3;
        if (iD2 == iB2) {
            this.f6951o = iB3 + (z11 ? 0 : i11 - i17);
            return;
        }
        int i18 = i12 - iA;
        int i19 = z11 ? 0 : i11 - i17;
        if (i18 != 0 || i19 != 0) {
            while (iD2 != 0 && iD2 != iB2 && (i19 != 0 || i18 != 0)) {
                int iR2 = r(iD2);
                if (i18 != 0) {
                    this.f6939b[(iR2 * 5) + 3] = h2.a(this.f6939b, iR2) + i18;
                }
                if (i19 != 0) {
                    int[] iArr3 = this.f6939b;
                    h2.d(iR2, (iArr3[(iR2 * 5) + 1] & 67108863) + i19, iArr3);
                }
                int[] iArr4 = this.f6939b;
                if ((iArr4[(iR2 * 5) + 1] & 1073741824) != 0) {
                    i19 = 0;
                }
                iD2 = D(iArr4, iD2);
            }
        }
        this.f6951o += i19;
    }

    public final void k() {
        if (this.f6950n <= 0) {
            q1.b("Unbalanced begin/end insert");
        }
        int i = this.f6950n - 1;
        this.f6950n = i;
        if (i == 0) {
            if (this.f6954r.f7030b != this.f6952p.f7030b) {
                t.c("startGroup/endGroup mismatch while inserting");
            }
            this.f6957u = (o() - this.f6945h) - this.f6953q.b();
        }
    }

    public final void l(int i) {
        boolean z10 = false;
        if (!(this.f6950n <= 0)) {
            t.c("Cannot call ensureStarted() while inserting");
        }
        int i3 = this.f6958v;
        if (i3 != i) {
            if (i >= i3 && i < this.f6957u) {
                z10 = true;
            }
            if (!z10) {
                t.c("Started group at " + i + " must be a subgroup of the group at " + i3);
            }
            int i10 = this.f6956t;
            int i11 = this.i;
            int i12 = this.f6946j;
            this.f6956t = i;
            O();
            this.f6956t = i10;
            this.i = i11;
            this.f6946j = i12;
        }
    }

    public final void m(int i, int i3, int i10) {
        if (i >= this.f6944g) {
            i = -((p() - i) + 2);
        }
        while (i10 < i3) {
            this.f6939b[(r(i10) * 5) + 2] = i;
            int iA = h2.a(this.f6939b, r(i10)) + i10;
            m(i10, iA, i10 + 1);
            i10 = iA;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e7, code lost:
    
        g5.f.q("Index must be between 0 and size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ec, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(int r19, xb.p r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.i2.n(int, xb.p):void");
    }

    public final int o() {
        return this.f6939b.length / 5;
    }

    public final int p() {
        return o() - this.f6945h;
    }

    public final Object q(int i) {
        int iR = r(i);
        int[] iArr = this.f6939b;
        int i3 = (iR * 5) + 1;
        if ((iArr[i3] & 268435456) == 0) {
            return m.f6974a;
        }
        return this.f6940c[Integer.bitCount(iArr[i3] >> 29) + g(iArr, iR)];
    }

    public final int r(int i) {
        return (this.f6945h * (i < this.f6944g ? 0 : 1)) + i;
    }

    public final Object s(int i) {
        int iR = r(i);
        int[] iArr = this.f6939b;
        int i3 = iR * 5;
        int i10 = iArr[i3 + 1];
        if ((536870912 & i10) == 0) {
            return null;
        }
        return this.f6940c[Integer.bitCount(i10 >> 30) + iArr[i3 + 4]];
    }

    public final int t(int i) {
        return h2.a(this.f6939b, r(i));
    }

    public final String toString() {
        return "SlotWriter(current = " + this.f6956t + " end=" + this.f6957u + " size = " + p() + " gap=" + this.f6944g + '-' + (this.f6944g + this.f6945h) + ')';
    }

    public final boolean u(int i, int i3) {
        int iO;
        int iT;
        r0 r0Var = this.f6952p;
        if (i3 == this.f6958v) {
            iO = this.f6957u;
        } else {
            if (i3 > r0Var.a(0)) {
                iT = t(i3);
            } else {
                int[] iArr = r0Var.f7029a;
                int iMin = Math.min(iArr.length, r0Var.f7030b);
                int i10 = 0;
                while (true) {
                    if (i10 >= iMin) {
                        i10 = -1;
                        break;
                    }
                    if (iArr[i10] == i3) {
                        break;
                    }
                    i10++;
                }
                if (i10 < 0) {
                    iT = t(i3);
                } else {
                    iO = (o() - this.f6945h) - this.f6953q.f7029a[i10];
                }
            }
            iO = iT + i3;
        }
        return i > i3 && i < iO;
    }

    public final void v(int i) {
        if (i > 0) {
            int i3 = this.f6956t;
            A(i3);
            int i10 = this.f6944g;
            int i11 = this.f6945h;
            int[] iArr = this.f6939b;
            int length = iArr.length / 5;
            int i12 = length - i11;
            if (i11 < i) {
                int iMax = Math.max(Math.max(length * 2, i12 + i), 32);
                int[] iArr2 = new int[iMax * 5];
                int i13 = iMax - i12;
                kb.k.f0(0, 0, iArr, iArr2, i10 * 5);
                kb.k.f0((i10 + i13) * 5, (i11 + i10) * 5, iArr, iArr2, length * 5);
                this.f6939b = iArr2;
                i11 = i13;
            }
            int i14 = this.f6957u;
            if (i14 >= i10) {
                this.f6957u = i14 + i;
            }
            int i15 = i10 + i;
            this.f6944g = i15;
            this.f6945h = i11 - i;
            int i16 = i(i12 > 0 ? f(i3 + i) : 0, this.f6949m >= i10 ? this.f6947k : 0, this.f6948l, this.f6940c.length);
            for (int i17 = i10; i17 < i15; i17++) {
                this.f6939b[(i17 * 5) + 4] = i16;
            }
            int i18 = this.f6949m;
            if (i18 >= i10) {
                this.f6949m = i18 + i;
            }
        }
    }

    public final void w(int i, int i3) {
        if (i > 0) {
            B(this.i, i3);
            int i10 = this.f6947k;
            int i11 = this.f6948l;
            if (i11 < i) {
                Object[] objArr = this.f6940c;
                int length = objArr.length;
                int i12 = length - i11;
                int iMax = Math.max(Math.max(length * 2, i12 + i), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i13 = 0; i13 < iMax; i13++) {
                    objArr2[i13] = null;
                }
                int i14 = iMax - i12;
                int i15 = i11 + i10;
                System.arraycopy(objArr, 0, objArr2, 0, i10);
                System.arraycopy(objArr, i15, objArr2, i10 + i14, length - i15);
                this.f6940c = objArr2;
                i11 = i14;
            }
            int i16 = this.f6946j;
            if (i16 >= i10) {
                this.f6946j = i16 + i;
            }
            this.f6947k = i10 + i;
            this.f6948l = i11 - i;
        }
    }

    public final boolean x(int i) {
        return (this.f6939b[(r(i) * 5) + 1] & 1073741824) != 0;
    }

    public final void z(f2 f2Var, int i) {
        if (this.f6950n <= 0) {
            t.c("Check failed");
        }
        if (i == 0 && this.f6956t == 0 && this.f6938a.f6901f == 0) {
            int iA = h2.a(f2Var.f6900c, i);
            int i3 = f2Var.f6901f;
            if (iA == i3) {
                int[] iArr = this.f6939b;
                Object[] objArr = this.f6940c;
                ArrayList arrayList = this.f6941d;
                HashMap map = this.f6942e;
                p.u uVar = this.f6943f;
                int[] iArr2 = f2Var.f6900c;
                Object[] objArr2 = f2Var.f6902g;
                int i10 = f2Var.f6903h;
                HashMap map2 = f2Var.f6908n;
                p.u uVar2 = f2Var.f6909o;
                this.f6939b = iArr2;
                this.f6940c = objArr2;
                this.f6941d = f2Var.f6907m;
                this.f6944g = i3;
                this.f6945h = (iArr2.length / 5) - i3;
                this.f6947k = i10;
                this.f6948l = objArr2.length - i10;
                this.f6949m = i3;
                this.f6942e = map2;
                this.f6943f = uVar2;
                f2Var.f6900c = iArr;
                f2Var.f6901f = 0;
                f2Var.f6902g = objArr;
                f2Var.f6903h = 0;
                f2Var.f6907m = arrayList;
                f2Var.f6908n = map;
                f2Var.f6909o = uVar;
                return;
            }
        }
        i2 i2VarD = f2Var.d();
        try {
            z.u(i2VarD, i, this, true, true, false);
            i2VarD.e(true);
        } catch (Throwable th) {
            i2VarD.e(false);
            throw th;
        }
    }
}
