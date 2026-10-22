package b0;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class s2 {

    /* renamed from: a, reason: collision with root package name */
    public final p2 f1346a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1347b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1348c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f1349d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f1350e;

    /* renamed from: f, reason: collision with root package name */
    public k.t f1351f;

    /* renamed from: g, reason: collision with root package name */
    public int f1352g;

    /* renamed from: h, reason: collision with root package name */
    public int f1353h;

    /* renamed from: i, reason: collision with root package name */
    public int f1354i;

    /* renamed from: j, reason: collision with root package name */
    public int f1355j;

    /* renamed from: k, reason: collision with root package name */
    public int f1356k;

    /* renamed from: l, reason: collision with root package name */
    public int f1357l;

    /* renamed from: m, reason: collision with root package name */
    public int f1358m;

    /* renamed from: n, reason: collision with root package name */
    public int f1359n;

    /* renamed from: o, reason: collision with root package name */
    public int f1360o;

    /* renamed from: p, reason: collision with root package name */
    public final r0 f1361p;

    /* renamed from: q, reason: collision with root package name */
    public final r0 f1362q;

    /* renamed from: r, reason: collision with root package name */
    public final r0 f1363r;

    /* renamed from: s, reason: collision with root package name */
    public k.t f1364s;

    /* renamed from: t, reason: collision with root package name */
    public int f1365t;

    /* renamed from: u, reason: collision with root package name */
    public int f1366u;

    /* renamed from: v, reason: collision with root package name */
    public int f1367v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1368w;

    /* renamed from: x, reason: collision with root package name */
    public k.s f1369x;

    public s2(p2 p2Var) {
        this.f1346a = p2Var;
        int[] iArr = p2Var.f1306f;
        this.f1347b = iArr;
        Object[] objArr = p2Var.f1308h;
        this.f1348c = objArr;
        this.f1349d = p2Var.f1314n;
        this.f1350e = p2Var.f1315o;
        this.f1351f = p2Var.f1316p;
        int i2 = p2Var.f1307g;
        this.f1352g = i2;
        this.f1353h = (iArr.length / 5) - i2;
        int i10 = p2Var.f1309i;
        this.f1356k = i10;
        this.f1357l = objArr.length - i10;
        this.f1358m = i2;
        this.f1361p = new r0();
        this.f1362q = new r0();
        this.f1363r = new r0();
        this.f1366u = i2;
        this.f1367v = -1;
    }

    public static int i(int i2, int i10, int i11, int i12) {
        return i2 > i10 ? -(((i12 - i11) - i2) + 1) : i2;
    }

    public final Object A(int i2) {
        int iQ = q(i2);
        int[] iArr = this.f1347b;
        if ((iArr[(iQ * 5) + 1] & 1073741824) != 0) {
            return this.f1348c[h(g(iQ, iArr))];
        }
        return null;
    }

    public final int B(int i2, int[] iArr) {
        int i10 = iArr[(q(i2) * 5) + 2];
        return i10 > -2 ? i10 : (o() + i10) - (-2);
    }

    public final Object C(Object obj) {
        if (this.f1359n > 0) {
            v(1, this.f1367v);
        }
        Object[] objArr = this.f1348c;
        int i2 = this.f1354i;
        this.f1354i = i2 + 1;
        Object obj2 = objArr[h(i2)];
        if (this.f1354i > this.f1355j) {
            s.c("Writing to an invalid slot");
        }
        this.f1348c[h(this.f1354i - 1)] = obj;
        return obj2;
    }

    public final void D() {
        int i2;
        k.s sVar = this.f1369x;
        if (sVar != null) {
            while (sVar.f5530b != 0) {
                int iR = b.r(sVar);
                int iQ = q(iR);
                int iS = iR + 1;
                int iS2 = s(iR) + iR;
                while (true) {
                    if (iS >= iS2) {
                        i2 = 0;
                        break;
                    } else {
                        if ((this.f1347b[(q(iS) * 5) + 1] & 201326592) != 0) {
                            i2 = 1;
                            break;
                        }
                        iS += s(iS);
                    }
                }
                int[] iArr = this.f1347b;
                int i10 = (iQ * 5) + 1;
                int i11 = iArr[i10];
                if (((67108864 & i11) != 0 ? 1 : 0) != i2) {
                    iArr[i10] = (i2 << 26) | ((-67108865) & i11);
                    int iB = B(iR, iArr);
                    if (iB >= 0) {
                        b.g(sVar, iB);
                    }
                }
            }
        }
    }

    public final boolean E() {
        if (!(this.f1359n == 0)) {
            s.c("Cannot remove group while inserting");
        }
        int i2 = this.f1365t;
        int i10 = this.f1354i;
        int iG = g(q(i2), this.f1347b);
        int I = I();
        L(this.f1367v);
        k.s sVar = this.f1369x;
        if (sVar != null) {
            while (true) {
                int i11 = sVar.f5530b;
                if (i11 == 0) {
                    break;
                }
                if (i11 == 0) {
                    l.a.e("IntList is empty.");
                    throw null;
                }
                if (sVar.f5529a[0] < i2) {
                    break;
                }
                b.r(sVar);
            }
        }
        boolean zF = F(i2, this.f1365t - i2);
        G(iG, this.f1354i - iG, i2 - 1);
        this.f1365t = i2;
        this.f1354i = i10;
        this.f1360o -= I;
        return zF;
    }

    public final boolean F(int i2, int i10) {
        if (i10 > 0) {
            ArrayList arrayList = this.f1349d;
            y(i2);
            if (!arrayList.isEmpty()) {
                HashMap map = this.f1350e;
                int i11 = i2 + i10;
                int iB = r2.b(this.f1349d, i11, n() - this.f1353h);
                if (iB >= this.f1349d.size()) {
                    iB--;
                }
                int i12 = iB + 1;
                int i13 = 0;
                while (iB >= 0) {
                    a aVar = (a) this.f1349d.get(iB);
                    int iC = c(aVar);
                    if (iC < i2) {
                        break;
                    }
                    if (iC < i11) {
                        aVar.f1096a = Integer.MIN_VALUE;
                        if (map != null) {
                        }
                        if (i13 == 0) {
                            i13 = iB + 1;
                        }
                        i12 = iB;
                    }
                    iB--;
                }
                z = i12 < i13;
                if (z) {
                    this.f1349d.subList(i12, i13).clear();
                }
            }
            this.f1352g = i2;
            this.f1353h += i10;
            int i14 = this.f1358m;
            if (i14 > i2) {
                this.f1358m = Math.max(i2, i14 - i10);
            }
            int i15 = this.f1366u;
            if (i15 >= this.f1352g) {
                this.f1366u = i15 - i10;
            }
            int i16 = this.f1367v;
            if (i16 >= 0 && (this.f1347b[(q(i16) * 5) + 1] & 67108864) != 0) {
                Q(i16);
            }
        }
        return z;
    }

    public final void G(int i2, int i10, int i11) {
        if (i10 > 0) {
            int i12 = this.f1357l;
            int i13 = i2 + i10;
            z(i13, i11);
            this.f1356k = i2;
            this.f1357l = i12 + i10;
            d7.n.d0(this.f1348c, i2, i13);
            int i14 = this.f1355j;
            if (i14 >= i2) {
                this.f1355j = i14 - i10;
            }
        }
    }

    public final Object H(int i2, int i10, Object obj) {
        int iK = K(q(i2), this.f1347b);
        int iG = g(q(i2 + 1), this.f1347b);
        int i11 = iK + i10;
        if (i11 < iK || i11 >= iG) {
            s.c("Write to an invalid slot index " + i10 + " for group " + i2);
        }
        int iH = h(i11);
        Object[] objArr = this.f1348c;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    public final int I() {
        int iQ = q(this.f1365t);
        int iA = r2.a(iQ, this.f1347b) + this.f1365t;
        this.f1365t = iA;
        this.f1354i = g(q(iA), this.f1347b);
        int i2 = this.f1347b[(iQ * 5) + 1];
        if ((1073741824 & i2) != 0) {
            return 1;
        }
        return i2 & 67108863;
    }

    public final void J() {
        int i2 = this.f1366u;
        this.f1365t = i2;
        this.f1354i = g(q(i2), this.f1347b);
    }

    public final int K(int i2, int[] iArr) {
        if (i2 >= n()) {
            return this.f1348c.length - this.f1357l;
        }
        int iC = r2.c(i2, iArr);
        return iC < 0 ? (this.f1348c.length - this.f1357l) + iC + 1 : iC;
    }

    public final q0 L(int i2) {
        a aVarO;
        HashMap map = this.f1350e;
        if (map == null || (aVarO = O(i2)) == null) {
            return null;
        }
        return (q0) map.get(aVarO);
    }

    public final void M() {
        if (this.f1359n != 0) {
            s.c("Key must be supplied when inserting");
        }
        b1 b1Var = k.f1229a;
        N(0, b1Var, b1Var, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(int i2, Object obj, Object obj2, boolean z4) {
        int i10;
        int i11 = this.f1367v;
        Object[] objArr = this.f1359n > 0;
        this.f1363r.c(this.f1360o);
        b1 b1Var = k.f1229a;
        if (objArr == true) {
            int i12 = this.f1365t;
            int iG = g(q(i12), this.f1347b);
            u(1);
            this.f1354i = iG;
            this.f1355j = iG;
            int iQ = q(i12);
            int i13 = obj != b1Var ? 1 : 0;
            int i14 = (z4 || obj2 == b1Var) ? 0 : 1;
            int i15 = i(iG, this.f1356k, this.f1357l, this.f1348c.length);
            if (i15 >= 0 && this.f1358m < i12) {
                i15 = -(((this.f1348c.length - this.f1357l) - i15) + 1);
            }
            int[] iArr = this.f1347b;
            int i16 = this.f1367v;
            int i17 = iQ * 5;
            iArr[i17] = i2;
            iArr[i17 + 1] = ((z4 ? 1 : 0) << 30) | (i13 << 29) | (i14 << 28);
            iArr[i17 + 2] = i16;
            iArr[i17 + 3] = 0;
            iArr[i17 + 4] = i15;
            int i18 = (z4 ? 1 : 0) + i13 + i14;
            if (i18 > 0) {
                v(i18, i12);
                Object[] objArr2 = this.f1348c;
                int i19 = this.f1354i;
                if (z4) {
                    objArr2[i19] = obj2;
                    i19++;
                }
                if (i13 != 0) {
                    objArr2[i19] = obj;
                    i19++;
                }
                if (i14 != 0) {
                    objArr2[i19] = obj2;
                    i19++;
                }
                this.f1354i = i19;
            }
            this.f1360o = 0;
            i10 = i12 + 1;
            this.f1367v = i12;
            this.f1365t = i10;
            if (i11 >= 0) {
                L(i11);
            }
        } else {
            this.f1361p.c(i11);
            this.f1362q.c((n() - this.f1353h) - this.f1366u);
            int i20 = this.f1365t;
            int iQ2 = q(i20);
            if (!q7.k.a(obj2, b1Var)) {
                if (z4) {
                    R(this.f1365t, obj2);
                } else {
                    P(obj2);
                }
            }
            this.f1354i = K(iQ2, this.f1347b);
            this.f1355j = g(q(this.f1365t + 1), this.f1347b);
            int[] iArr2 = this.f1347b;
            int i21 = iQ2 * 5;
            this.f1360o = iArr2[i21 + 1] & 67108863;
            this.f1367v = i20;
            this.f1365t = i20 + 1;
            i10 = i20 + iArr2[i21 + 3];
        }
        this.f1366u = i10;
    }

    public final a O(int i2) {
        ArrayList arrayList;
        int iE;
        if (i2 < 0 || i2 >= o() || (iE = r2.e((arrayList = this.f1349d), i2, o())) < 0) {
            return null;
        }
        return (a) arrayList.get(iE);
    }

    public final void P(Object obj) {
        int iQ = q(this.f1365t);
        int i2 = (iQ * 5) + 1;
        if ((this.f1347b[i2] & 268435456) == 0) {
            s.c("Updating the data of a group that was not created with a data slot");
        }
        Object[] objArr = this.f1348c;
        int[] iArr = this.f1347b;
        objArr[h(Integer.bitCount(iArr[i2] >> 29) + g(iQ, iArr))] = obj;
    }

    public final void Q(int i2) {
        if (i2 >= 0) {
            k.s sVar = this.f1369x;
            if (sVar == null) {
                sVar = new k.s();
                this.f1369x = sVar;
            }
            b.g(sVar, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.q(r5)
            int[] r1 = r4.f1347b
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
            b0.s.c(r5)
        L2e:
            java.lang.Object[] r5 = r4.f1348c
            int[] r1 = r4.f1347b
            int r0 = r4.g(r0, r1)
            int r4 = r4.h(r0)
            r5[r4] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.s2.R(int, java.lang.Object):void");
    }

    public final void a(int i2) {
        boolean z4 = false;
        if (!(i2 >= 0)) {
            s.c("Cannot seek backwards");
        }
        if (!(this.f1359n <= 0)) {
            u1.b("Cannot call seek() while inserting");
        }
        if (i2 == 0) {
            return;
        }
        int i10 = this.f1365t + i2;
        if (i10 >= this.f1367v && i10 <= this.f1366u) {
            z4 = true;
        }
        if (!z4) {
            s.c("Cannot seek outside the current group (" + this.f1367v + '-' + this.f1366u + ')');
        }
        this.f1365t = i10;
        int iG = g(q(i10), this.f1347b);
        this.f1354i = iG;
        this.f1355j = iG;
    }

    public final a b(int i2) {
        ArrayList arrayList = this.f1349d;
        int iE = r2.e(arrayList, i2, o());
        if (iE >= 0) {
            return (a) arrayList.get(iE);
        }
        if (i2 > this.f1352g) {
            i2 = -(o() - i2);
        }
        a aVar = new a(i2);
        arrayList.add(-(iE + 1), aVar);
        return aVar;
    }

    public final int c(a aVar) {
        int i2 = aVar.f1096a;
        return i2 < 0 ? o() + i2 : i2;
    }

    public final void d() {
        int i2 = this.f1359n;
        this.f1359n = i2 + 1;
        if (i2 == 0) {
            this.f1362q.c((n() - this.f1353h) - this.f1366u);
        }
    }

    public final void e(boolean z4) {
        this.f1368w = true;
        if (z4 && this.f1361p.f1328b == 0) {
            y(o());
            z(this.f1348c.length - this.f1357l, this.f1352g);
            int i2 = this.f1356k;
            d7.n.d0(this.f1348c, i2, this.f1357l + i2);
            D();
        }
        int[] iArr = this.f1347b;
        int i10 = this.f1352g;
        Object[] objArr = this.f1348c;
        int i11 = this.f1356k;
        ArrayList arrayList = this.f1349d;
        HashMap map = this.f1350e;
        k.t tVar = this.f1351f;
        p2 p2Var = this.f1346a;
        if (!p2Var.f1312l) {
            u1.a("Unexpected writer close()");
        }
        p2Var.f1312l = false;
        p2Var.f1306f = iArr;
        p2Var.f1307g = i10;
        p2Var.f1308h = objArr;
        p2Var.f1309i = i11;
        p2Var.f1314n = arrayList;
        p2Var.f1315o = map;
        p2Var.f1316p = tVar;
    }

    public final int f(int i2) {
        return g(q(i2), this.f1347b);
    }

    public final int g(int i2, int[] iArr) {
        if (i2 >= n()) {
            return this.f1348c.length - this.f1357l;
        }
        int i10 = iArr[(i2 * 5) + 4];
        return i10 < 0 ? (this.f1348c.length - this.f1357l) + i10 + 1 : i10;
    }

    public final int h(int i2) {
        return (this.f1357l * (i2 < this.f1356k ? 0 : 1)) + i2;
    }

    public final void j() {
        k.z zVar;
        boolean z4 = this.f1359n > 0;
        int i2 = this.f1365t;
        int i10 = this.f1366u;
        int i11 = this.f1367v;
        int iQ = q(i11);
        int i12 = this.f1360o;
        int i13 = i2 - i11;
        int i14 = iQ * 5;
        int i15 = i14 + 1;
        boolean z10 = (this.f1347b[i15] & 1073741824) != 0;
        r0 r0Var = this.f1363r;
        if (z4) {
            k.t tVar = this.f1364s;
            if (tVar != null && (zVar = (k.z) tVar.b(i11)) != null) {
                Object[] objArr = zVar.f5556a;
                int i16 = zVar.f5557b;
                for (int i17 = 0; i17 < i16; i17++) {
                    C(objArr[i17]);
                }
            }
            int[] iArr = this.f1347b;
            iArr[i14 + 3] = i13;
            r2.d(iQ, i12, iArr);
            int iB = r0Var.b();
            if (z10) {
                i12 = 1;
            }
            this.f1360o = iB + i12;
            int iB2 = B(i11, this.f1347b);
            this.f1367v = iB2;
            int iO = iB2 < 0 ? o() : q(iB2 + 1);
            int iG = iO >= 0 ? g(iO, this.f1347b) : 0;
            this.f1354i = iG;
            this.f1355j = iG;
            return;
        }
        if (i2 != i10) {
            s.c("Expected to be at the end of a group");
        }
        int[] iArr2 = this.f1347b;
        int i18 = i14 + 3;
        int i19 = iArr2[i18];
        int i20 = iArr2[i15] & 67108863;
        iArr2[i18] = i13;
        r2.d(iQ, i12, iArr2);
        int iB3 = this.f1361p.b();
        this.f1366u = (n() - this.f1353h) - this.f1362q.b();
        this.f1367v = iB3;
        int iB4 = B(i11, this.f1347b);
        int iB5 = r0Var.b();
        this.f1360o = iB5;
        if (iB4 == iB3) {
            this.f1360o = iB5 + (z10 ? 0 : i12 - i20);
            return;
        }
        int i21 = i13 - i19;
        int i22 = z10 ? 0 : i12 - i20;
        if (i21 != 0 || i22 != 0) {
            while (iB4 != 0 && iB4 != iB3 && (i22 != 0 || i21 != 0)) {
                int iQ2 = q(iB4);
                if (i21 != 0) {
                    int[] iArr3 = this.f1347b;
                    int i23 = (iQ2 * 5) + 3;
                    iArr3[i23] = iArr3[i23] + i21;
                }
                if (i22 != 0) {
                    int[] iArr4 = this.f1347b;
                    r2.d(iQ2, (iArr4[(iQ2 * 5) + 1] & 67108863) + i22, iArr4);
                }
                int[] iArr5 = this.f1347b;
                if ((iArr5[(iQ2 * 5) + 1] & 1073741824) != 0) {
                    i22 = 0;
                }
                iB4 = B(iB4, iArr5);
            }
        }
        this.f1360o += i22;
    }

    public final void k() {
        if (this.f1359n <= 0) {
            u1.b("Unbalanced begin/end insert");
        }
        int i2 = this.f1359n - 1;
        this.f1359n = i2;
        if (i2 == 0) {
            if (this.f1363r.f1328b != this.f1361p.f1328b) {
                s.c("startGroup/endGroup mismatch while inserting");
            }
            this.f1366u = (n() - this.f1353h) - this.f1362q.b();
        }
    }

    public final void l(int i2) {
        boolean z4 = false;
        if (!(this.f1359n <= 0)) {
            s.c("Cannot call ensureStarted() while inserting");
        }
        int i10 = this.f1367v;
        if (i10 != i2) {
            if (i2 >= i10 && i2 < this.f1366u) {
                z4 = true;
            }
            if (!z4) {
                s.c("Started group at " + i2 + " must be a subgroup of the group at " + i10);
            }
            int i11 = this.f1365t;
            int i12 = this.f1354i;
            int i13 = this.f1355j;
            this.f1365t = i2;
            M();
            this.f1365t = i11;
            this.f1354i = i12;
            this.f1355j = i13;
        }
    }

    public final void m(int i2, int i10, int i11) {
        if (i2 >= this.f1352g) {
            i2 = -((o() - i2) + 2);
        }
        while (i11 < i10) {
            this.f1347b[(q(i11) * 5) + 2] = i2;
            int i12 = this.f1347b[(q(i11) * 5) + 3] + i11;
            m(i11, i12, i11 + 1);
            i11 = i12;
        }
    }

    public final int n() {
        return this.f1347b.length / 5;
    }

    public final int o() {
        return n() - this.f1353h;
    }

    public final Object p(int i2) {
        int iQ = q(i2);
        int[] iArr = this.f1347b;
        int i10 = (iQ * 5) + 1;
        if ((iArr[i10] & 268435456) == 0) {
            return k.f1229a;
        }
        return this.f1348c[Integer.bitCount(iArr[i10] >> 29) + g(iQ, iArr)];
    }

    public final int q(int i2) {
        return (this.f1353h * (i2 < this.f1352g ? 0 : 1)) + i2;
    }

    public final Object r(int i2) {
        int iQ = q(i2);
        int[] iArr = this.f1347b;
        int i10 = iQ * 5;
        int i11 = iArr[i10 + 1];
        if ((536870912 & i11) == 0) {
            return null;
        }
        return this.f1348c[Integer.bitCount(i11 >> 30) + iArr[i10 + 4]];
    }

    public final int s(int i2) {
        return r2.a(q(i2), this.f1347b);
    }

    public final boolean t(int i2, int i10) {
        int iN;
        int iS;
        if (i10 == this.f1367v) {
            iN = this.f1366u;
        } else {
            r0 r0Var = this.f1361p;
            if (i10 > r0Var.a(0)) {
                iS = s(i10);
            } else {
                int[] iArr = r0Var.f1327a;
                int iMin = Math.min(iArr.length, r0Var.f1328b);
                int i11 = 0;
                while (true) {
                    if (i11 >= iMin) {
                        i11 = -1;
                        break;
                    }
                    if (iArr[i11] == i10) {
                        break;
                    }
                    i11++;
                }
                if (i11 < 0) {
                    iS = s(i10);
                } else {
                    iN = (n() - this.f1353h) - this.f1362q.f1327a[i11];
                }
            }
            iN = iS + i10;
        }
        return i2 > i10 && i2 < iN;
    }

    public final String toString() {
        return "SlotWriter(current = " + this.f1365t + " end=" + this.f1366u + " size = " + o() + " gap=" + this.f1352g + '-' + (this.f1352g + this.f1353h) + ')';
    }

    public final void u(int i2) {
        if (i2 > 0) {
            int i10 = this.f1365t;
            y(i10);
            int i11 = this.f1352g;
            int i12 = this.f1353h;
            int[] iArr = this.f1347b;
            int length = iArr.length / 5;
            int i13 = length - i12;
            if (i12 < i2) {
                int iMax = Math.max(Math.max(length * 2, i13 + i2), 32);
                int[] iArr2 = new int[iMax * 5];
                int i14 = iMax - i13;
                d7.n.W(iArr, iArr2, 0, 0, i11 * 5);
                d7.n.W(iArr, iArr2, (i11 + i14) * 5, (i12 + i11) * 5, length * 5);
                this.f1347b = iArr2;
                i12 = i14;
            }
            int i15 = this.f1366u;
            if (i15 >= i11) {
                this.f1366u = i15 + i2;
            }
            int i16 = i11 + i2;
            this.f1352g = i16;
            this.f1353h = i12 - i2;
            int i17 = i(i13 > 0 ? f(i10 + i2) : 0, this.f1358m >= i11 ? this.f1356k : 0, this.f1357l, this.f1348c.length);
            for (int i18 = i11; i18 < i16; i18++) {
                this.f1347b[(i18 * 5) + 4] = i17;
            }
            int i19 = this.f1358m;
            if (i19 >= i11) {
                this.f1358m = i19 + i2;
            }
        }
    }

    public final void v(int i2, int i10) {
        if (i2 > 0) {
            z(this.f1354i, i10);
            int i11 = this.f1356k;
            int i12 = this.f1357l;
            if (i12 < i2) {
                Object[] objArr = this.f1348c;
                int length = objArr.length;
                int i13 = length - i12;
                int iMax = Math.max(Math.max(length * 2, i13 + i2), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i14 = 0; i14 < iMax; i14++) {
                    objArr2[i14] = null;
                }
                int i15 = iMax - i13;
                int i16 = i12 + i11;
                System.arraycopy(objArr, 0, objArr2, 0, i11);
                System.arraycopy(objArr, i16, objArr2, i11 + i15, length - i16);
                this.f1348c = objArr2;
                i12 = i15;
            }
            int i17 = this.f1355j;
            if (i17 >= i11) {
                this.f1355j = i17 + i2;
            }
            this.f1356k = i11 + i2;
            this.f1357l = i12 - i2;
        }
    }

    public final boolean w(int i2) {
        return (this.f1347b[(q(i2) * 5) + 1] & 1073741824) != 0;
    }

    public final void x(p2 p2Var, int i2) {
        if (this.f1359n <= 0) {
            s.c("Check failed");
        }
        if (i2 == 0 && this.f1365t == 0 && this.f1346a.f1307g == 0) {
            int[] iArr = p2Var.f1306f;
            int i10 = iArr[(i2 * 5) + 3];
            int i11 = p2Var.f1307g;
            if (i10 == i11) {
                int[] iArr2 = this.f1347b;
                Object[] objArr = this.f1348c;
                ArrayList arrayList = this.f1349d;
                HashMap map = this.f1350e;
                k.t tVar = this.f1351f;
                Object[] objArr2 = p2Var.f1308h;
                int i12 = p2Var.f1309i;
                HashMap map2 = p2Var.f1315o;
                k.t tVar2 = p2Var.f1316p;
                this.f1347b = iArr;
                this.f1348c = objArr2;
                this.f1349d = p2Var.f1314n;
                this.f1352g = i11;
                this.f1353h = (iArr.length / 5) - i11;
                this.f1356k = i12;
                this.f1357l = objArr2.length - i12;
                this.f1358m = i11;
                this.f1350e = map2;
                this.f1351f = tVar2;
                p2Var.f1306f = iArr2;
                p2Var.f1307g = 0;
                p2Var.f1308h = objArr;
                p2Var.f1309i = 0;
                p2Var.f1314n = arrayList;
                p2Var.f1315o = map;
                p2Var.f1316p = tVar;
                return;
            }
        }
        s2 s2VarH = p2Var.h();
        try {
            b.m(s2VarH, i2, this, true, true, false);
            s2VarH.e(true);
        } catch (Throwable th) {
            s2VarH.e(false);
            throw th;
        }
    }

    public final void y(int i2) {
        a aVar;
        int i10;
        a aVar2;
        int i11;
        int i12;
        int i13 = this.f1353h;
        int i14 = this.f1352g;
        if (i14 != i2) {
            if (!this.f1349d.isEmpty()) {
                int iN = n() - this.f1353h;
                if (i14 < i2) {
                    for (int iB = r2.b(this.f1349d, i14, iN); iB < this.f1349d.size() && (i11 = (aVar2 = (a) this.f1349d.get(iB)).f1096a) < 0 && (i12 = i11 + iN) < i2; iB++) {
                        aVar2.f1096a = i12;
                    }
                } else {
                    for (int iB2 = r2.b(this.f1349d, i2, iN); iB2 < this.f1349d.size() && (i10 = (aVar = (a) this.f1349d.get(iB2)).f1096a) >= 0; iB2++) {
                        aVar.f1096a = -(iN - i10);
                    }
                }
            }
            if (i13 > 0) {
                int[] iArr = this.f1347b;
                int i15 = i2 * 5;
                int i16 = i13 * 5;
                int i17 = i14 * 5;
                if (i2 < i14) {
                    d7.n.W(iArr, iArr, i16 + i15, i15, i17);
                } else {
                    d7.n.W(iArr, iArr, i17, i17 + i16, i15 + i16);
                }
            }
            if (i2 < i14) {
                i14 = i2 + i13;
            }
            int iN2 = n();
            if (i14 >= iN2) {
                s.c("Check failed");
            }
            while (i14 < iN2) {
                int i18 = (i14 * 5) + 2;
                int i19 = this.f1347b[i18];
                int iO = i19 > -2 ? i19 : (o() + i19) - (-2);
                if (iO >= i2) {
                    iO = -((o() - iO) - (-2));
                }
                if (iO != i19) {
                    this.f1347b[i18] = iO;
                }
                i14++;
                if (i14 == i2) {
                    i14 += i13;
                }
            }
        }
        this.f1352g = i2;
    }

    public final void z(int i2, int i10) {
        int i11 = this.f1357l;
        int i12 = this.f1356k;
        int i13 = this.f1358m;
        if (i12 != i2) {
            Object[] objArr = this.f1348c;
            if (i2 < i12) {
                System.arraycopy(objArr, i2, objArr, i2 + i11, i12 - i2);
            } else {
                int i14 = i12 + i11;
                System.arraycopy(objArr, i14, objArr, i12, (i2 + i11) - i14);
            }
        }
        int iMin = Math.min(i10 + 1, o());
        if (i13 != iMin) {
            int length = this.f1348c.length - i11;
            if (iMin < i13) {
                int iQ = q(iMin);
                int iQ2 = q(i13);
                int i15 = this.f1352g;
                while (iQ < iQ2) {
                    int i16 = (iQ * 5) + 4;
                    int i17 = this.f1347b[i16];
                    if (!(i17 >= 0)) {
                        s.c("Unexpected anchor value, expected a positive anchor");
                    }
                    this.f1347b[i16] = -((length - i17) + 1);
                    iQ++;
                    if (iQ == i15) {
                        iQ += this.f1353h;
                    }
                }
            } else {
                int iQ3 = q(i13);
                int iQ4 = q(iMin);
                while (iQ3 < iQ4) {
                    int i18 = (iQ3 * 5) + 4;
                    int i19 = this.f1347b[i18];
                    if (!(i19 < 0)) {
                        s.c("Unexpected anchor value, expected a negative anchor");
                    }
                    this.f1347b[i18] = i19 + length + 1;
                    iQ3++;
                    if (iQ3 == this.f1352g) {
                        iQ3 += this.f1353h;
                    }
                }
            }
            this.f1358m = iMin;
        }
        this.f1356k = i2;
    }
}
