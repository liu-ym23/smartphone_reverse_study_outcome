package g0;

import b0.u1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final k f3687e = new k(0, 0, new Object[0], null);

    /* renamed from: a, reason: collision with root package name */
    public int f3688a;

    /* renamed from: b, reason: collision with root package name */
    public int f3689b;

    /* renamed from: c, reason: collision with root package name */
    public final i0.b f3690c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f3691d;

    public k(int i2, int i10, Object[] objArr, i0.b bVar) {
        this.f3688a = i2;
        this.f3689b = i10;
        this.f3690c = bVar;
        this.f3691d = objArr;
    }

    public static k j(int i2, Object obj, Object obj2, int i10, Object obj3, Object obj4, int i11, i0.b bVar) {
        if (i11 > 30) {
            return new k(0, 0, new Object[]{obj, obj2, obj3, obj4}, bVar);
        }
        int iC = ib.c.C(i2, i11);
        int iC2 = ib.c.C(i10, i11);
        if (iC != iC2) {
            return new k((1 << iC) | (1 << iC2), 0, iC < iC2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, bVar);
        }
        return new k(0, 1 << iC, new Object[]{j(i2, obj, obj2, i10, obj3, obj4, i11 + 5, bVar)}, bVar);
    }

    public final Object[] a(int i2, int i10, int i11, Object obj, Object obj2, int i12, i0.b bVar) {
        Object obj3 = this.f3691d[i2];
        k kVarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, x(i2), i11, obj, obj2, i12 + 5, bVar);
        int iT = t(i10);
        int i13 = iT + 1;
        Object[] objArr = this.f3691d;
        Object[] objArr2 = new Object[objArr.length - 1];
        d7.n.a0(objArr, objArr2, 0, i2, 6);
        d7.n.Y(objArr, objArr2, i2, i2 + 2, i13);
        objArr2[iT - 1] = kVarJ;
        d7.n.Y(objArr, objArr2, iT, i13, objArr.length);
        return objArr2;
    }

    public final int b() {
        if (this.f3689b == 0) {
            return this.f3691d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f3688a);
        int length = this.f3691d.length;
        for (int i2 = iBitCount * 2; i2 < length; i2++) {
            iBitCount += s(i2).b();
        }
        return iBitCount;
    }

    public final boolean c(Object obj) {
        v7.b bVarL = nb.i.L(nb.i.N(0, this.f3691d.length), 2);
        int i2 = bVarL.f10523f;
        int i10 = bVarL.f10524g;
        int i11 = bVarL.f10525h;
        if ((i11 > 0 && i2 <= i10) || (i11 < 0 && i10 <= i2)) {
            while (!q7.k.a(obj, this.f3691d[i2])) {
                if (i2 != i10) {
                    i2 += i11;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean d(int i2, int i10, Object obj) {
        int iC = 1 << ib.c.C(i2, i10);
        if (h(iC)) {
            return q7.k.a(obj, this.f3691d[f(iC)]);
        }
        if (!i(iC)) {
            return false;
        }
        k kVarS = s(t(iC));
        return i10 == 30 ? kVarS.c(obj) : kVarS.d(i2, i10 + 5, obj);
    }

    public final boolean e(k kVar) {
        if (this == kVar) {
            return true;
        }
        if (this.f3689b == kVar.f3689b && this.f3688a == kVar.f3688a) {
            int length = this.f3691d.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f3691d[i2] == kVar.f3691d[i2]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f(int i2) {
        return Integer.bitCount(this.f3688a & (i2 - 1)) * 2;
    }

    public final Object g(int i2, int i10, Object obj) {
        int iC = 1 << ib.c.C(i2, i10);
        if (h(iC)) {
            int iF = f(iC);
            if (q7.k.a(obj, this.f3691d[iF])) {
                return x(iF);
            }
            return null;
        }
        if (!i(iC)) {
            return null;
        }
        k kVarS = s(t(iC));
        if (i10 != 30) {
            return kVarS.g(i2, i10 + 5, obj);
        }
        v7.b bVarL = nb.i.L(nb.i.N(0, kVarS.f3691d.length), 2);
        int i11 = bVarL.f10523f;
        int i12 = bVarL.f10524g;
        int i13 = bVarL.f10525h;
        if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
            return null;
        }
        while (!q7.k.a(obj, kVarS.f3691d[i11])) {
            if (i11 == i12) {
                return null;
            }
            i11 += i13;
        }
        return kVarS.x(i11);
    }

    public final boolean h(int i2) {
        return (this.f3688a & i2) != 0;
    }

    public final boolean i(int i2) {
        return (this.f3689b & i2) != 0;
    }

    public final k k(int i2, j0.g gVar) {
        gVar.f(gVar.size() - 1);
        gVar.f5079h = x(i2);
        Object[] objArr = this.f3691d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f3690c != gVar.f5077f) {
            return new k(0, 0, ib.c.e(i2, objArr), gVar.f5077f);
        }
        this.f3691d = ib.c.e(i2, objArr);
        return this;
    }

    public final k l(int i2, Object obj, Object obj2, int i10, j0.g gVar) {
        j0.g gVar2;
        k kVarL;
        int iC = 1 << ib.c.C(i2, i10);
        boolean zH = h(iC);
        i0.b bVar = this.f3690c;
        if (zH) {
            int iF = f(iC);
            if (!q7.k.a(obj, this.f3691d[iF])) {
                gVar.f(gVar.size() + 1);
                i0.b bVar2 = gVar.f5077f;
                if (bVar != bVar2) {
                    return new k(this.f3688a ^ iC, this.f3689b | iC, a(iF, iC, i2, obj, obj2, i10, bVar2), bVar2);
                }
                this.f3691d = a(iF, iC, i2, obj, obj2, i10, bVar2);
                this.f3688a ^= iC;
                this.f3689b |= iC;
                return this;
            }
            gVar.f5079h = x(iF);
            if (x(iF) == obj2) {
                return this;
            }
            if (bVar == gVar.f5077f) {
                this.f3691d[iF + 1] = obj2;
                return this;
            }
            gVar.f5080i++;
            Object[] objArr = this.f3691d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iF + 1] = obj2;
            return new k(this.f3688a, this.f3689b, objArrCopyOf, gVar.f5077f);
        }
        if (!i(iC)) {
            gVar.f(gVar.size() + 1);
            i0.b bVar3 = gVar.f5077f;
            int iF2 = f(iC);
            if (bVar != bVar3) {
                return new k(this.f3688a | iC, this.f3689b, ib.c.c(this.f3691d, iF2, obj, obj2), bVar3);
            }
            this.f3691d = ib.c.c(this.f3691d, iF2, obj, obj2);
            this.f3688a |= iC;
            return this;
        }
        int iT = t(iC);
        k kVarS = s(iT);
        if (i10 == 30) {
            v7.b bVarL = nb.i.L(nb.i.N(0, kVarS.f3691d.length), 2);
            int i11 = bVarL.f10523f;
            int i12 = bVarL.f10524g;
            int i13 = bVarL.f10525h;
            if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
                gVar.f(gVar.size() + 1);
                kVarL = new k(0, 0, ib.c.c(kVarS.f3691d, 0, obj, obj2), gVar.f5077f);
                gVar2 = gVar;
            } else {
                while (!q7.k.a(obj, kVarS.f3691d[i11])) {
                    if (i11 == i12) {
                        gVar.f(gVar.size() + 1);
                        kVarL = new k(0, 0, ib.c.c(kVarS.f3691d, 0, obj, obj2), gVar.f5077f);
                        break;
                    }
                    i11 += i13;
                }
                gVar.f5079h = kVarS.x(i11);
                if (kVarS.f3690c == gVar.f5077f) {
                    kVarS.f3691d[i11 + 1] = obj2;
                    kVarL = kVarS;
                } else {
                    gVar.f5080i++;
                    Object[] objArr2 = kVarS.f3691d;
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, objArr2.length);
                    q7.k.d(objArrCopyOf2, "copyOf(...)");
                    objArrCopyOf2[i11 + 1] = obj2;
                    kVarL = new k(0, 0, objArrCopyOf2, gVar.f5077f);
                }
                gVar2 = gVar;
            }
        } else {
            gVar2 = gVar;
            kVarL = kVarS.l(i2, obj, obj2, i10 + 5, gVar2);
        }
        return kVarS == kVarL ? this : r(iT, kVarL, gVar2.f5077f);
    }

    public final k m(k kVar, int i2, i0.a aVar, j0.g gVar) {
        Object[] objArr;
        k kVarJ;
        j0.g gVar2 = gVar;
        if (this == kVar) {
            aVar.f4393a += b();
            return this;
        }
        int i10 = 0;
        if (i2 > 30) {
            i0.b bVar = gVar2.f5077f;
            int i11 = kVar.f3689b;
            Object[] objArr2 = this.f3691d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + kVar.f3691d.length);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            int length = this.f3691d.length;
            v7.b bVarL = nb.i.L(nb.i.N(0, kVar.f3691d.length), 2);
            int i12 = bVarL.f10523f;
            int i13 = bVarL.f10524g;
            int i14 = bVarL.f10525h;
            if ((i14 > 0 && i12 <= i13) || (i14 < 0 && i13 <= i12)) {
                while (true) {
                    if (c(kVar.f3691d[i12])) {
                        aVar.f4393a++;
                    } else {
                        Object[] objArr3 = kVar.f3691d;
                        objArrCopyOf[length] = objArr3[i12];
                        objArrCopyOf[length + 1] = objArr3[i12 + 1];
                        length += 2;
                    }
                    if (i12 == i13) {
                        break;
                    }
                    i12 += i14;
                }
            }
            if (length != this.f3691d.length) {
                if (length == kVar.f3691d.length) {
                    return kVar;
                }
                if (length == objArrCopyOf.length) {
                    return new k(0, 0, objArrCopyOf, bVar);
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
                q7.k.d(objArrCopyOf2, "copyOf(...)");
                return new k(0, 0, objArrCopyOf2, bVar);
            }
        } else {
            int i15 = this.f3689b | kVar.f3689b;
            int i16 = this.f3688a;
            int i17 = kVar.f3688a;
            int i18 = (i16 ^ i17) & (~i15);
            int i19 = i16 & i17;
            int i20 = i18;
            while (i19 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i19);
                if (q7.k.a(this.f3691d[f(iLowestOneBit)], kVar.f3691d[kVar.f(iLowestOneBit)])) {
                    i20 |= iLowestOneBit;
                } else {
                    i15 |= iLowestOneBit;
                }
                i19 ^= iLowestOneBit;
            }
            if ((i15 & i20) != 0) {
                u1.b("Check failed.");
            }
            k kVar2 = (q7.k.a(this.f3690c, gVar2.f5077f) && this.f3688a == i20 && this.f3689b == i15) ? this : new k(i20, i15, new Object[Integer.bitCount(i15) + (Integer.bitCount(i20) * 2)], null);
            int i21 = i15;
            int i22 = 0;
            while (i21 != 0) {
                int iLowestOneBit2 = Integer.lowestOneBit(i21);
                Object[] objArr4 = kVar2.f3691d;
                int length2 = (objArr4.length - 1) - i22;
                if (i(iLowestOneBit2)) {
                    kVarJ = s(t(iLowestOneBit2));
                    if (kVar.i(iLowestOneBit2)) {
                        kVarJ = kVarJ.m(kVar.s(kVar.t(iLowestOneBit2)), i2 + 5, aVar, gVar2);
                        objArr = objArr4;
                    } else {
                        if (kVar.h(iLowestOneBit2)) {
                            int iF = kVar.f(iLowestOneBit2);
                            Object obj = kVar.f3691d[iF];
                            Object objX = kVar.x(iF);
                            int size = gVar2.size();
                            objArr = objArr4;
                            kVarJ = kVarJ.l(obj != null ? obj.hashCode() : i10, obj, objX, i2 + 5, gVar2);
                            if (gVar.size() == size) {
                                aVar.f4393a++;
                            }
                        } else {
                            objArr = objArr4;
                        }
                        gVar2 = gVar;
                    }
                } else {
                    objArr = objArr4;
                    if (kVar.i(iLowestOneBit2)) {
                        k kVarS = kVar.s(kVar.t(iLowestOneBit2));
                        if (h(iLowestOneBit2)) {
                            int iF2 = f(iLowestOneBit2);
                            Object obj2 = this.f3691d[iF2];
                            int i23 = i2 + 5;
                            if (kVarS.d(obj2 != null ? obj2.hashCode() : 0, i23, obj2)) {
                                aVar.f4393a++;
                                gVar2 = gVar;
                                kVarJ = kVarS;
                            } else {
                                gVar2 = gVar;
                                kVarJ = kVarS.l(obj2 != null ? obj2.hashCode() : 0, obj2, x(iF2), i23, gVar2);
                            }
                        } else {
                            gVar2 = gVar;
                            kVarJ = kVarS;
                        }
                    } else {
                        gVar2 = gVar;
                        int iF3 = f(iLowestOneBit2);
                        Object obj3 = this.f3691d[iF3];
                        Object objX2 = x(iF3);
                        int iF4 = kVar.f(iLowestOneBit2);
                        Object obj4 = kVar.f3691d[iF4];
                        kVarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, objX2, obj4 != null ? obj4.hashCode() : 0, obj4, kVar.x(iF4), i2 + 5, gVar2.f5077f);
                    }
                }
                objArr[length2] = kVarJ;
                i22++;
                i21 ^= iLowestOneBit2;
                i10 = 0;
            }
            int i24 = 0;
            while (i20 != 0) {
                int iLowestOneBit3 = Integer.lowestOneBit(i20);
                int i25 = i24 * 2;
                if (kVar.h(iLowestOneBit3)) {
                    int iF5 = kVar.f(iLowestOneBit3);
                    Object[] objArr5 = kVar2.f3691d;
                    objArr5[i25] = kVar.f3691d[iF5];
                    objArr5[i25 + 1] = kVar.x(iF5);
                    if (h(iLowestOneBit3)) {
                        aVar.f4393a++;
                    }
                } else {
                    int iF6 = f(iLowestOneBit3);
                    Object[] objArr6 = kVar2.f3691d;
                    objArr6[i25] = this.f3691d[iF6];
                    objArr6[i25 + 1] = x(iF6);
                }
                i24++;
                i20 ^= iLowestOneBit3;
            }
            if (!e(kVar2)) {
                return kVar.e(kVar2) ? kVar : kVar2;
            }
        }
        return this;
    }

    public final k n(int i2, Object obj, int i10, j0.g gVar) {
        k kVarN;
        int iC = 1 << ib.c.C(i2, i10);
        if (h(iC)) {
            int iF = f(iC);
            if (q7.k.a(obj, this.f3691d[iF])) {
                return p(iF, iC, gVar);
            }
        } else if (i(iC)) {
            int iT = t(iC);
            k kVarS = s(iT);
            if (i10 == 30) {
                v7.b bVarL = nb.i.L(nb.i.N(0, kVarS.f3691d.length), 2);
                int i11 = bVarL.f10523f;
                int i12 = bVarL.f10524g;
                int i13 = bVarL.f10525h;
                if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
                    kVarN = kVarS;
                    break;
                }
                while (!q7.k.a(obj, kVarS.f3691d[i11])) {
                    if (i11 == i12) {
                        kVarN = kVarS;
                        break;
                    }
                    i11 += i13;
                }
                kVarN = kVarS.k(i11, gVar);
            } else {
                kVarN = kVarS.n(i2, obj, i10 + 5, gVar);
            }
            return q(kVarS, kVarN, iT, iC, gVar.f5077f);
        }
        return this;
    }

    public final k o(int i2, Object obj, Object obj2, int i10, j0.g gVar) {
        j0.g gVar2;
        k kVarO;
        int iC = 1 << ib.c.C(i2, i10);
        if (h(iC)) {
            int iF = f(iC);
            return (q7.k.a(obj, this.f3691d[iF]) && q7.k.a(obj2, x(iF))) ? p(iF, iC, gVar) : this;
        }
        if (!i(iC)) {
            return this;
        }
        int iT = t(iC);
        k kVarS = s(iT);
        if (i10 == 30) {
            v7.b bVarL = nb.i.L(nb.i.N(0, kVarS.f3691d.length), 2);
            int i11 = bVarL.f10523f;
            int i12 = bVarL.f10524g;
            int i13 = bVarL.f10525h;
            if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
                kVarO = kVarS;
                gVar2 = gVar;
            } else {
                while (true) {
                    if (!q7.k.a(obj, kVarS.f3691d[i11]) || !q7.k.a(obj2, kVarS.x(i11))) {
                        if (i11 == i12) {
                            break;
                        }
                        i11 += i13;
                    } else {
                        kVarO = kVarS.k(i11, gVar);
                        break;
                    }
                }
                kVarO = kVarS;
                gVar2 = gVar;
            }
        } else {
            gVar2 = gVar;
            kVarO = kVarS.o(i2, obj, obj2, i10 + 5, gVar2);
        }
        return q(kVarS, kVarO, iT, iC, gVar2.f5077f);
    }

    public final k p(int i2, int i10, j0.g gVar) {
        gVar.f(gVar.size() - 1);
        gVar.f5079h = x(i2);
        Object[] objArr = this.f3691d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f3690c != gVar.f5077f) {
            return new k(i10 ^ this.f3688a, this.f3689b, ib.c.e(i2, objArr), gVar.f5077f);
        }
        this.f3691d = ib.c.e(i2, objArr);
        this.f3688a ^= i10;
        return this;
    }

    public final k q(k kVar, k kVar2, int i2, int i10, i0.b bVar) {
        i0.b bVar2 = this.f3690c;
        if (kVar2 != null) {
            return (bVar2 == bVar || kVar != kVar2) ? r(i2, kVar2, bVar) : this;
        }
        Object[] objArr = this.f3691d;
        if (objArr.length == 1) {
            return null;
        }
        if (bVar2 != bVar) {
            return new k(this.f3688a, this.f3689b ^ i10, ib.c.f(i2, objArr), bVar);
        }
        this.f3691d = ib.c.f(i2, objArr);
        this.f3689b ^= i10;
        return this;
    }

    public final k r(int i2, k kVar, i0.b bVar) {
        Object[] objArr = this.f3691d;
        if (objArr.length == 1 && kVar.f3691d.length == 2 && kVar.f3689b == 0) {
            kVar.f3688a = this.f3689b;
            return kVar;
        }
        if (this.f3690c == bVar) {
            objArr[i2] = kVar;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i2] = kVar;
        return new k(this.f3688a, this.f3689b, objArrCopyOf, bVar);
    }

    public final k s(int i2) {
        Object obj = this.f3691d[i2];
        q7.k.c(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (k) obj;
    }

    public final int t(int i2) {
        return (this.f3691d.length - 1) - Integer.bitCount(this.f3689b & (i2 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d4, code lost:
    
        if (r13 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dd, code lost:
    
        if (r13 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e0, code lost:
    
        r13.f2768h = w(r11, r4, (g0.k) r13.f2768h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ea, code lost:
    
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d1.b u(int r12, int r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.k.u(int, int, java.lang.Object, java.lang.Object):d1.b");
    }

    public final k v(int i2, int i10, Object obj) {
        k kVarV;
        int iC = 1 << ib.c.C(i2, i10);
        if (h(iC)) {
            int iF = f(iC);
            if (!q7.k.a(obj, this.f3691d[iF])) {
                return this;
            }
            Object[] objArr = this.f3691d;
            if (objArr.length != 2) {
                return new k(this.f3688a ^ iC, this.f3689b, ib.c.e(iF, objArr), null);
            }
        } else {
            if (!i(iC)) {
                return this;
            }
            int iT = t(iC);
            k kVarS = s(iT);
            if (i10 == 30) {
                v7.b bVarL = nb.i.L(nb.i.N(0, kVarS.f3691d.length), 2);
                int i11 = bVarL.f10523f;
                int i12 = bVarL.f10524g;
                int i13 = bVarL.f10525h;
                if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
                    kVarV = kVarS;
                    break;
                }
                while (!q7.k.a(obj, kVarS.f3691d[i11])) {
                    if (i11 == i12) {
                        kVarV = kVarS;
                        break;
                    }
                    i11 += i13;
                }
                Object[] objArr2 = kVarS.f3691d;
                kVarV = objArr2.length == 2 ? null : new k(0, 0, ib.c.e(i11, objArr2), null);
            } else {
                kVarV = kVarS.v(i2, i10 + 5, obj);
            }
            if (kVarV != null) {
                return kVarS != kVarV ? w(iT, iC, kVarV) : this;
            }
            Object[] objArr3 = this.f3691d;
            if (objArr3.length != 1) {
                return new k(this.f3688a, this.f3689b ^ iC, ib.c.f(iT, objArr3), null);
            }
        }
        return null;
    }

    public final k w(int i2, int i10, k kVar) {
        Object[] objArr = kVar.f3691d;
        if (objArr.length != 2 || kVar.f3689b != 0) {
            Object[] objArr2 = this.f3691d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[i2] = kVar;
            return new k(this.f3688a, this.f3689b, objArrCopyOf, null);
        }
        if (this.f3691d.length == 1) {
            kVar.f3688a = this.f3689b;
            return kVar;
        }
        int iF = f(i10);
        Object[] objArr3 = this.f3691d;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length + 1);
        q7.k.d(objArrCopyOf2, "copyOf(...)");
        d7.n.Y(objArrCopyOf2, objArrCopyOf2, i2 + 2, i2 + 1, objArr3.length);
        d7.n.Y(objArrCopyOf2, objArrCopyOf2, iF + 2, iF, i2);
        objArrCopyOf2[iF] = obj;
        objArrCopyOf2[iF + 1] = obj2;
        return new k(this.f3688a ^ i10, this.f3689b ^ i10, objArrCopyOf2, null);
    }

    public final Object x(int i2) {
        return this.f3691d[i2 + 1];
    }
}
