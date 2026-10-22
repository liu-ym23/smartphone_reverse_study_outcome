package u;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public static final r f13126e = new r(0, 0, new Object[0], null);

    /* renamed from: a, reason: collision with root package name */
    public int f13127a;

    /* renamed from: b, reason: collision with root package name */
    public int f13128b;

    /* renamed from: c, reason: collision with root package name */
    public final w.b f13129c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f13130d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public r<K, V> f13131a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13132b;

        public a(r<K, V> rVar, int i10) {
            this.f13131a = rVar;
            this.f13132b = i10;
        }
    }

    public r(int i10, int i11, Object[] objArr, w.b bVar) {
        this.f13127a = i10;
        this.f13128b = i11;
        this.f13129c = bVar;
        this.f13130d = objArr;
    }

    public static r j(int i10, Object obj, Object obj2, int i11, Object obj3, Object obj4, int i12, w.b bVar) {
        if (i12 > 30) {
            return new r(0, 0, new Object[]{obj, obj2, obj3, obj4}, bVar);
        }
        int iC = y.C(i10, i12);
        int iC2 = y.C(i11, i12);
        if (iC != iC2) {
            return new r((1 << iC) | (1 << iC2), 0, iC < iC2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, bVar);
        }
        return new r(0, 1 << iC, new Object[]{j(i10, obj, obj2, i11, obj3, obj4, i12 + 5, bVar)}, bVar);
    }

    public final Object[] a(int i10, int i11, int i12, K k9, V v3, int i13, w.b bVar) {
        Object obj = this.f13130d[i10];
        r rVarJ = j(obj != null ? obj.hashCode() : 0, obj, x(i10), i12, k9, v3, i13 + 5, bVar);
        int iT = t(i11);
        int i14 = iT + 1;
        Object[] objArr = this.f13130d;
        Object[] objArr2 = new Object[objArr.length - 1];
        b1.t(objArr, objArr2, 0, i10, 6);
        b1.q(objArr, objArr2, i10, i10 + 2, i14);
        objArr2[iT - 1] = rVarJ;
        b1.q(objArr, objArr2, iT, i14, objArr.length);
        return objArr2;
    }

    public final int b() {
        if (this.f13128b == 0) {
            return this.f13130d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f13127a);
        int length = this.f13130d.length;
        for (int i10 = iBitCount * 2; i10 < length; i10++) {
            iBitCount += s(i10).b();
        }
        return iBitCount;
    }

    public final boolean c(K k9) {
        dc.c cVarD0 = dc.h.d0(dc.h.e0(0, this.f13130d.length), 2);
        int i10 = cVarD0.f8451a;
        int i11 = cVarD0.f8452b;
        int i12 = cVarD0.f8453c;
        if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
            while (!kotlin.jvm.internal.g.b(k9, this.f13130d[i10])) {
                if (i10 != i11) {
                    i10 += i12;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(int i10, int i11, Object obj) {
        int iC = 1 << y.C(i10, i11);
        if (h(iC)) {
            return kotlin.jvm.internal.g.b(obj, this.f13130d[f(iC)]);
        }
        if (!i(iC)) {
            return false;
        }
        r<K, V> rVarS = s(t(iC));
        return i11 == 30 ? rVarS.c(obj) : rVarS.d(i10, i11 + 5, obj);
    }

    public final boolean e(r<K, V> rVar) {
        if (this == rVar) {
            return true;
        }
        if (this.f13128b == rVar.f13128b && this.f13127a == rVar.f13127a) {
            int length = this.f13130d.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (this.f13130d[i10] == rVar.f13130d[i10]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f(int i10) {
        return Integer.bitCount(this.f13127a & (i10 - 1)) * 2;
    }

    public final Object g(int i10, int i11, Object obj) {
        int iC = 1 << y.C(i10, i11);
        if (h(iC)) {
            int iF = f(iC);
            if (kotlin.jvm.internal.g.b(obj, this.f13130d[iF])) {
                return x(iF);
            }
            return null;
        }
        if (!i(iC)) {
            return null;
        }
        r<K, V> rVarS = s(t(iC));
        if (i11 != 30) {
            return rVarS.g(i10, i11 + 5, obj);
        }
        dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVarS.f13130d.length), 2);
        int i12 = cVarD0.f8451a;
        int i13 = cVarD0.f8452b;
        int i14 = cVarD0.f8453c;
        if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
            return null;
        }
        while (!kotlin.jvm.internal.g.b(obj, rVarS.f13130d[i12])) {
            if (i12 == i13) {
                return null;
            }
            i12 += i14;
        }
        return rVarS.x(i12);
    }

    public final boolean h(int i10) {
        return (this.f13127a & i10) != 0;
    }

    public final boolean i(int i10) {
        return (this.f13128b & i10) != 0;
    }

    public final r<K, V> k(int i10, f<K, V> fVar) {
        fVar.b(fVar.size() - 1);
        fVar.f13114d = x(i10);
        Object[] objArr = this.f13130d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f13129c != fVar.f13112b) {
            return new r<>(0, 0, y.g(objArr, i10), fVar.f13112b);
        }
        this.f13130d = y.g(objArr, i10);
        return this;
    }

    public final r<K, V> l(int i10, K k9, V v3, int i11, f<K, V> fVar) {
        f<K, V> fVar2;
        r<K, V> rVarL;
        int iC = 1 << y.C(i10, i11);
        boolean zH = h(iC);
        w.b bVar = this.f13129c;
        if (zH) {
            int iF = f(iC);
            if (!kotlin.jvm.internal.g.b(k9, this.f13130d[iF])) {
                fVar.b(fVar.size() + 1);
                w.b bVar2 = fVar.f13112b;
                if (bVar != bVar2) {
                    return new r<>(this.f13127a ^ iC, this.f13128b | iC, a(iF, iC, i10, k9, v3, i11, bVar2), bVar2);
                }
                this.f13130d = a(iF, iC, i10, k9, v3, i11, bVar2);
                this.f13127a ^= iC;
                this.f13128b |= iC;
                return this;
            }
            fVar.f13114d = x(iF);
            if (x(iF) == v3) {
                return this;
            }
            if (bVar == fVar.f13112b) {
                this.f13130d[iF + 1] = v3;
                return this;
            }
            fVar.f13115e++;
            Object[] objArr = this.f13130d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iF + 1] = v3;
            return new r<>(this.f13127a, this.f13128b, objArrCopyOf, fVar.f13112b);
        }
        if (!i(iC)) {
            fVar.b(fVar.size() + 1);
            w.b bVar3 = fVar.f13112b;
            int iF2 = f(iC);
            if (bVar != bVar3) {
                return new r<>(this.f13127a | iC, this.f13128b, y.f(this.f13130d, iF2, k9, v3), bVar3);
            }
            this.f13130d = y.f(this.f13130d, iF2, k9, v3);
            this.f13127a |= iC;
            return this;
        }
        int iT = t(iC);
        r<K, V> rVarS = s(iT);
        if (i11 == 30) {
            dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVarS.f13130d.length), 2);
            int i12 = cVarD0.f8451a;
            int i13 = cVarD0.f8452b;
            int i14 = cVarD0.f8453c;
            if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
                fVar.b(fVar.size() + 1);
                rVarL = new r<>(0, 0, y.f(rVarS.f13130d, 0, k9, v3), fVar.f13112b);
                fVar2 = fVar;
            } else {
                while (!kotlin.jvm.internal.g.b(k9, rVarS.f13130d[i12])) {
                    if (i12 == i13) {
                        fVar.b(fVar.size() + 1);
                        rVarL = new r<>(0, 0, y.f(rVarS.f13130d, 0, k9, v3), fVar.f13112b);
                        break;
                    }
                    i12 += i14;
                }
                fVar.f13114d = rVarS.x(i12);
                if (rVarS.f13129c == fVar.f13112b) {
                    rVarS.f13130d[i12 + 1] = v3;
                    rVarL = rVarS;
                } else {
                    fVar.f13115e++;
                    Object[] objArr2 = rVarS.f13130d;
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, objArr2.length);
                    kotlin.jvm.internal.g.e(objArrCopyOf2, "copyOf(...)");
                    objArrCopyOf2[i12 + 1] = v3;
                    rVarL = new r<>(0, 0, objArrCopyOf2, fVar.f13112b);
                }
                fVar2 = fVar;
            }
        } else {
            fVar2 = fVar;
            rVarL = rVarS.l(i10, k9, v3, i11 + 5, fVar2);
        }
        return rVarS == rVarL ? this : r(iT, rVarL, fVar2.f13112b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final r<K, V> m(r<K, V> rVar, int i10, w.a aVar, f<K, V> fVar) {
        Object[] objArr;
        r rVarJ;
        f<K, V> fVar2 = fVar;
        if (this == rVar) {
            aVar.f13527a += b();
            return this;
        }
        int i11 = 0;
        if (i10 > 30) {
            w.b bVar = fVar2.f13112b;
            int i12 = rVar.f13128b;
            Object[] objArr2 = this.f13130d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + rVar.f13130d.length);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            int length = this.f13130d.length;
            dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVar.f13130d.length), 2);
            int i13 = cVarD0.f8451a;
            int i14 = cVarD0.f8452b;
            int i15 = cVarD0.f8453c;
            if ((i15 > 0 && i13 <= i14) || (i15 < 0 && i14 <= i13)) {
                while (true) {
                    if (c(rVar.f13130d[i13])) {
                        aVar.f13527a++;
                    } else {
                        Object[] objArr3 = rVar.f13130d;
                        objArrCopyOf[length] = objArr3[i13];
                        objArrCopyOf[length + 1] = objArr3[i13 + 1];
                        length += 2;
                    }
                    if (i13 == i14) {
                        break;
                    }
                    i13 += i15;
                }
            }
            if (length != this.f13130d.length) {
                if (length == rVar.f13130d.length) {
                    return rVar;
                }
                if (length == objArrCopyOf.length) {
                    return new r<>(0, 0, objArrCopyOf, bVar);
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
                kotlin.jvm.internal.g.e(objArrCopyOf2, "copyOf(...)");
                return new r<>(0, 0, objArrCopyOf2, bVar);
            }
        } else {
            int i16 = this.f13128b | rVar.f13128b;
            int i17 = this.f13127a;
            int i18 = rVar.f13127a;
            int i19 = (i17 ^ i18) & (~i16);
            int i20 = i17 & i18;
            int i21 = i19;
            while (i20 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i20);
                if (kotlin.jvm.internal.g.b(this.f13130d[f(iLowestOneBit)], rVar.f13130d[rVar.f(iLowestOneBit)])) {
                    i21 |= iLowestOneBit;
                } else {
                    i16 |= iLowestOneBit;
                }
                i20 ^= iLowestOneBit;
            }
            if ((i16 & i21) != 0) {
                androidx.compose.runtime.f.b("Check failed.");
            }
            r<K, V> rVar2 = (kotlin.jvm.internal.g.b(this.f13129c, fVar2.f13112b) && this.f13127a == i21 && this.f13128b == i16) ? this : new r<>(i21, i16, new Object[Integer.bitCount(i16) + (Integer.bitCount(i21) * 2)], null);
            int i22 = i16;
            int i23 = 0;
            while (i22 != 0) {
                int iLowestOneBit2 = Integer.lowestOneBit(i22);
                Object[] objArr4 = rVar2.f13130d;
                int length2 = (objArr4.length - 1) - i23;
                if (i(iLowestOneBit2)) {
                    r rVarS = s(t(iLowestOneBit2));
                    if (rVar.i(iLowestOneBit2)) {
                        rVarJ = rVarS.m(rVar.s(rVar.t(iLowestOneBit2)), i10 + 5, aVar, fVar2);
                        objArr = objArr4;
                    } else {
                        if (rVar.h(iLowestOneBit2)) {
                            int iF = rVar.f(iLowestOneBit2);
                            Object obj = rVar.f13130d[iF];
                            V vX = rVar.x(iF);
                            int size = fVar2.size();
                            Object[] objArr5 = objArr4;
                            r rVarL = rVarS.l(obj != null ? obj.hashCode() : i11, obj, vX, i10 + 5, fVar2);
                            rVarJ = rVarL;
                            objArr = objArr5;
                            if (fVar.size() == size) {
                                aVar.f13527a++;
                                rVarJ = rVarL;
                                objArr = objArr5;
                            }
                        } else {
                            objArr = objArr4;
                            rVarJ = rVarS;
                        }
                        fVar2 = fVar;
                    }
                } else {
                    objArr = objArr4;
                    if (rVar.i(iLowestOneBit2)) {
                        r rVar3 = (r<K, V>) rVar.s(rVar.t(iLowestOneBit2));
                        if (h(iLowestOneBit2)) {
                            int iF2 = f(iLowestOneBit2);
                            Object obj2 = this.f13130d[iF2];
                            int i24 = i10 + 5;
                            if (rVar3.d(obj2 != null ? obj2.hashCode() : 0, i24, obj2)) {
                                aVar.f13527a++;
                                fVar2 = fVar;
                                rVarJ = rVar3;
                            } else {
                                fVar2 = fVar;
                                rVarJ = rVar3.l(obj2 != null ? obj2.hashCode() : 0, obj2, x(iF2), i24, fVar2);
                            }
                        } else {
                            fVar2 = fVar;
                            rVarJ = rVar3;
                        }
                    } else {
                        fVar2 = fVar;
                        int iF3 = f(iLowestOneBit2);
                        Object obj3 = this.f13130d[iF3];
                        Object objX = x(iF3);
                        int iF4 = rVar.f(iLowestOneBit2);
                        Object obj4 = rVar.f13130d[iF4];
                        rVarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, objX, obj4 != null ? obj4.hashCode() : 0, obj4, rVar.x(iF4), i10 + 5, fVar2.f13112b);
                    }
                }
                objArr[length2] = rVarJ;
                i23++;
                i22 ^= iLowestOneBit2;
                i11 = 0;
            }
            int i25 = 0;
            while (i21 != 0) {
                int iLowestOneBit3 = Integer.lowestOneBit(i21);
                int i26 = i25 * 2;
                if (rVar.h(iLowestOneBit3)) {
                    int iF5 = rVar.f(iLowestOneBit3);
                    Object[] objArr6 = rVar2.f13130d;
                    objArr6[i26] = rVar.f13130d[iF5];
                    objArr6[i26 + 1] = rVar.x(iF5);
                    if (h(iLowestOneBit3)) {
                        aVar.f13527a++;
                    }
                } else {
                    int iF6 = f(iLowestOneBit3);
                    Object[] objArr7 = rVar2.f13130d;
                    objArr7[i26] = this.f13130d[iF6];
                    objArr7[i26 + 1] = x(iF6);
                }
                i25++;
                i21 ^= iLowestOneBit3;
            }
            if (!e(rVar2)) {
                return rVar.e(rVar2) ? rVar : rVar2;
            }
        }
        return this;
    }

    public final r<K, V> n(int i10, K k9, int i11, f<K, V> fVar) {
        r<K, V> rVarN;
        int iC = 1 << y.C(i10, i11);
        if (h(iC)) {
            int iF = f(iC);
            if (kotlin.jvm.internal.g.b(k9, this.f13130d[iF])) {
                return p(iF, iC, fVar);
            }
        } else if (i(iC)) {
            int iT = t(iC);
            r<K, V> rVarS = s(iT);
            if (i11 == 30) {
                dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVarS.f13130d.length), 2);
                int i12 = cVarD0.f8451a;
                int i13 = cVarD0.f8452b;
                int i14 = cVarD0.f8453c;
                if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
                    rVarN = rVarS;
                    break;
                }
                while (!kotlin.jvm.internal.g.b(k9, rVarS.f13130d[i12])) {
                    if (i12 == i13) {
                        rVarN = rVarS;
                        break;
                    }
                    i12 += i14;
                }
                rVarN = rVarS.k(i12, fVar);
            } else {
                rVarN = rVarS.n(i10, k9, i11 + 5, fVar);
            }
            return q(rVarS, rVarN, iT, iC, fVar.f13112b);
        }
        return this;
    }

    public final r<K, V> o(int i10, K k9, V v3, int i11, f<K, V> fVar) {
        f<K, V> fVar2;
        r<K, V> rVarO;
        int iC = 1 << y.C(i10, i11);
        if (h(iC)) {
            int iF = f(iC);
            return (kotlin.jvm.internal.g.b(k9, this.f13130d[iF]) && kotlin.jvm.internal.g.b(v3, x(iF))) ? p(iF, iC, fVar) : this;
        }
        if (!i(iC)) {
            return this;
        }
        int iT = t(iC);
        r<K, V> rVarS = s(iT);
        if (i11 == 30) {
            dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVarS.f13130d.length), 2);
            int i12 = cVarD0.f8451a;
            int i13 = cVarD0.f8452b;
            int i14 = cVarD0.f8453c;
            if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
                rVarO = rVarS;
                fVar2 = fVar;
            } else {
                while (true) {
                    if (!kotlin.jvm.internal.g.b(k9, rVarS.f13130d[i12]) || !kotlin.jvm.internal.g.b(v3, rVarS.x(i12))) {
                        if (i12 == i13) {
                            break;
                        }
                        i12 += i14;
                    } else {
                        rVarO = rVarS.k(i12, fVar);
                        break;
                    }
                }
                rVarO = rVarS;
                fVar2 = fVar;
            }
        } else {
            fVar2 = fVar;
            rVarO = rVarS.o(i10, k9, v3, i11 + 5, fVar2);
        }
        return q(rVarS, rVarO, iT, iC, fVar2.f13112b);
    }

    public final r<K, V> p(int i10, int i11, f<K, V> fVar) {
        fVar.b(fVar.size() - 1);
        fVar.f13114d = x(i10);
        Object[] objArr = this.f13130d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f13129c != fVar.f13112b) {
            return new r<>(i11 ^ this.f13127a, this.f13128b, y.g(objArr, i10), fVar.f13112b);
        }
        this.f13130d = y.g(objArr, i10);
        this.f13127a ^= i11;
        return this;
    }

    public final r<K, V> q(r<K, V> rVar, r<K, V> rVar2, int i10, int i11, w.b bVar) {
        w.b bVar2 = this.f13129c;
        if (rVar2 != null) {
            return (bVar2 == bVar || rVar != rVar2) ? r(i10, rVar2, bVar) : this;
        }
        Object[] objArr = this.f13130d;
        if (objArr.length == 1) {
            return null;
        }
        if (bVar2 != bVar) {
            return new r<>(this.f13127a, this.f13128b ^ i11, y.h(objArr, i10), bVar);
        }
        this.f13130d = y.h(objArr, i10);
        this.f13128b ^= i11;
        return this;
    }

    public final r<K, V> r(int i10, r<K, V> rVar, w.b bVar) {
        Object[] objArr = this.f13130d;
        if (objArr.length == 1 && rVar.f13130d.length == 2 && rVar.f13128b == 0) {
            rVar.f13127a = this.f13128b;
            return rVar;
        }
        if (this.f13129c == bVar) {
            objArr[i10] = rVar;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i10] = rVar;
        return new r<>(this.f13127a, this.f13128b, objArrCopyOf, bVar);
    }

    public final r<K, V> s(int i10) {
        Object obj = this.f13130d[i10];
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (r) obj;
    }

    public final int t(int i10) {
        return (this.f13130d.length - 1) - Integer.bitCount(this.f13128b & (i10 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d0, code lost:
    
        if (r13 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
    
        if (r13 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        r13.f13131a = w(r11, r4, r13.f13131a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e4, code lost:
    
        return r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u.r.a u(int r12, int r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.r.u(int, int, java.lang.Object, java.lang.Object):u.r$a");
    }

    public final r v(int i10, int i11, Object obj) {
        r<K, V> rVarV;
        int iC = 1 << y.C(i10, i11);
        if (h(iC)) {
            int iF = f(iC);
            if (!kotlin.jvm.internal.g.b(obj, this.f13130d[iF])) {
                return this;
            }
            Object[] objArr = this.f13130d;
            if (objArr.length != 2) {
                return new r(this.f13127a ^ iC, this.f13128b, y.g(objArr, iF), null);
            }
        } else {
            if (!i(iC)) {
                return this;
            }
            int iT = t(iC);
            r<K, V> rVarS = s(iT);
            if (i11 == 30) {
                dc.c cVarD0 = dc.h.d0(dc.h.e0(0, rVarS.f13130d.length), 2);
                int i12 = cVarD0.f8451a;
                int i13 = cVarD0.f8452b;
                int i14 = cVarD0.f8453c;
                if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
                    rVarV = rVarS;
                    break;
                }
                while (!kotlin.jvm.internal.g.b(obj, rVarS.f13130d[i12])) {
                    if (i12 == i13) {
                        rVarV = rVarS;
                        break;
                    }
                    i12 += i14;
                }
                Object[] objArr2 = rVarS.f13130d;
                rVarV = objArr2.length == 2 ? null : new r<>(0, 0, y.g(objArr2, i12), null);
            } else {
                rVarV = rVarS.v(i10, i11 + 5, obj);
            }
            if (rVarV != null) {
                return rVarS != rVarV ? w(iT, iC, rVarV) : this;
            }
            Object[] objArr3 = this.f13130d;
            if (objArr3.length != 1) {
                return new r(this.f13127a, this.f13128b ^ iC, y.h(objArr3, iT), null);
            }
        }
        return null;
    }

    public final r<K, V> w(int i10, int i11, r<K, V> rVar) {
        Object[] objArr = rVar.f13130d;
        if (objArr.length != 2 || rVar.f13128b != 0) {
            Object[] objArr2 = this.f13130d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[i10] = rVar;
            return new r<>(this.f13127a, this.f13128b, objArrCopyOf, null);
        }
        if (this.f13130d.length == 1) {
            rVar.f13127a = this.f13128b;
            return rVar;
        }
        int iF = f(i11);
        Object[] objArr3 = this.f13130d;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length + 1);
        kotlin.jvm.internal.g.e(objArrCopyOf2, "copyOf(...)");
        b1.q(objArrCopyOf2, objArrCopyOf2, i10 + 2, i10 + 1, objArr3.length);
        b1.q(objArrCopyOf2, objArrCopyOf2, iF + 2, iF, i10);
        objArrCopyOf2[iF] = obj;
        objArrCopyOf2[iF + 1] = obj2;
        return new r<>(this.f13127a ^ i11, this.f13128b ^ i11, objArrCopyOf2, null);
    }

    public final V x(int i10) {
        return (V) this.f13130d[i10 + 1];
    }
}
