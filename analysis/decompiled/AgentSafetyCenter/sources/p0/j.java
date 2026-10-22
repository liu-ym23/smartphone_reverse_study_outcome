package p0;

import h5.t;
import java.util.Arrays;
import k0.q1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f9671e = new j(0, 0, new Object[0], null);

    /* renamed from: a, reason: collision with root package name */
    public int f9672a;

    /* renamed from: b, reason: collision with root package name */
    public int f9673b;

    /* renamed from: c, reason: collision with root package name */
    public final r0.b f9674c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f9675d;

    public j(int i, int i3, Object[] objArr, r0.b bVar) {
        this.f9672a = i;
        this.f9673b = i3;
        this.f9674c = bVar;
        this.f9675d = objArr;
    }

    public static j j(int i, Object obj, Object obj2, int i3, Object obj3, Object obj4, int i10, r0.b bVar) {
        if (i10 > 30) {
            return new j(0, 0, new Object[]{obj, obj2, obj3, obj4}, bVar);
        }
        int iE = t.E(i, i10);
        int iE2 = t.E(i3, i10);
        if (iE != iE2) {
            return new j((1 << iE) | (1 << iE2), 0, iE < iE2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, bVar);
        }
        return new j(0, 1 << iE, new Object[]{j(i, obj, obj2, i3, obj3, obj4, i10 + 5, bVar)}, bVar);
    }

    public final Object[] a(int i, int i3, int i10, Object obj, Object obj2, int i11, r0.b bVar) {
        Object obj3 = this.f9675d[i];
        j jVarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, x(i), i10, obj, obj2, i11 + 5, bVar);
        int iT = t(i3);
        int i12 = iT + 1;
        Object[] objArr = this.f9675d;
        Object[] objArr2 = new Object[objArr.length - 1];
        kb.k.k0(objArr, objArr2, 0, i, 6);
        kb.k.i0(objArr, objArr2, i, i + 2, i12);
        objArr2[iT - 1] = jVarJ;
        kb.k.i0(objArr, objArr2, iT, i12, objArr.length);
        return objArr2;
    }

    public final int b() {
        if (this.f9673b == 0) {
            return this.f9675d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f9672a);
        int length = this.f9675d.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += s(i).b();
        }
        return iBitCount;
    }

    public final boolean c(Object obj) {
        ec.f fVarL = p5.f.L(p5.f.O(0, this.f9675d.length), 2);
        int i = fVarL.f3758c;
        int i3 = fVarL.f3759f;
        int i10 = fVarL.f3760g;
        if ((i10 > 0 && i <= i3) || (i10 < 0 && i3 <= i)) {
            while (!yb.k.a(obj, this.f9675d[i])) {
                if (i != i3) {
                    i += i10;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean d(int i, int i3, Object obj) {
        int iE = 1 << t.E(i, i3);
        if (h(iE)) {
            return yb.k.a(obj, this.f9675d[f(iE)]);
        }
        if (!i(iE)) {
            return false;
        }
        j jVarS = s(t(iE));
        return i3 == 30 ? jVarS.c(obj) : jVarS.d(i, i3 + 5, obj);
    }

    public final boolean e(j jVar) {
        if (this == jVar) {
            return true;
        }
        if (this.f9673b == jVar.f9673b && this.f9672a == jVar.f9672a) {
            int length = this.f9675d.length;
            for (int i = 0; i < length; i++) {
                if (this.f9675d[i] == jVar.f9675d[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f(int i) {
        return Integer.bitCount(this.f9672a & (i - 1)) * 2;
    }

    public final Object g(int i, int i3, Object obj) {
        int iE = 1 << t.E(i, i3);
        if (h(iE)) {
            int iF = f(iE);
            if (yb.k.a(obj, this.f9675d[iF])) {
                return x(iF);
            }
            return null;
        }
        if (!i(iE)) {
            return null;
        }
        j jVarS = s(t(iE));
        if (i3 != 30) {
            return jVarS.g(i, i3 + 5, obj);
        }
        ec.f fVarL = p5.f.L(p5.f.O(0, jVarS.f9675d.length), 2);
        int i10 = fVarL.f3758c;
        int i11 = fVarL.f3759f;
        int i12 = fVarL.f3760g;
        if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
            return null;
        }
        while (!yb.k.a(obj, jVarS.f9675d[i10])) {
            if (i10 == i11) {
                return null;
            }
            i10 += i12;
        }
        return jVarS.x(i10);
    }

    public final boolean h(int i) {
        return (this.f9672a & i) != 0;
    }

    public final boolean i(int i) {
        return (this.f9673b & i) != 0;
    }

    public final j k(int i, s0.f fVar) {
        fVar.e(fVar.i - 1);
        fVar.f11178g = x(i);
        Object[] objArr = this.f9675d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f9674c != fVar.f11176c) {
            return new j(0, 0, t.j(objArr, i), fVar.f11176c);
        }
        this.f9675d = t.j(objArr, i);
        return this;
    }

    public final j l(int i, Object obj, Object obj2, int i3, s0.f fVar) {
        s0.f fVar2;
        j jVarL;
        int iE = 1 << t.E(i, i3);
        boolean zH = h(iE);
        r0.b bVar = this.f9674c;
        if (zH) {
            int iF = f(iE);
            if (!yb.k.a(obj, this.f9675d[iF])) {
                fVar.e(fVar.i + 1);
                r0.b bVar2 = fVar.f11176c;
                if (bVar != bVar2) {
                    return new j(this.f9672a ^ iE, this.f9673b | iE, a(iF, iE, i, obj, obj2, i3, bVar2), bVar2);
                }
                this.f9675d = a(iF, iE, i, obj, obj2, i3, bVar2);
                this.f9672a ^= iE;
                this.f9673b |= iE;
                return this;
            }
            fVar.f11178g = x(iF);
            if (x(iF) == obj2) {
                return this;
            }
            if (bVar == fVar.f11176c) {
                this.f9675d[iF + 1] = obj2;
                return this;
            }
            fVar.f11179h++;
            Object[] objArr = this.f9675d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            objArrCopyOf[iF + 1] = obj2;
            return new j(this.f9672a, this.f9673b, objArrCopyOf, fVar.f11176c);
        }
        if (!i(iE)) {
            fVar.e(fVar.i + 1);
            r0.b bVar3 = fVar.f11176c;
            int iF2 = f(iE);
            Object[] objArr2 = this.f9675d;
            if (bVar != bVar3) {
                return new j(this.f9672a | iE, this.f9673b, t.i(objArr2, iF2, obj, obj2), bVar3);
            }
            this.f9675d = t.i(objArr2, iF2, obj, obj2);
            this.f9672a |= iE;
            return this;
        }
        int iT = t(iE);
        j jVarS = s(iT);
        if (i3 == 30) {
            ec.f fVarL = p5.f.L(p5.f.O(0, jVarS.f9675d.length), 2);
            int i10 = fVarL.f3758c;
            int i11 = fVarL.f3759f;
            int i12 = fVarL.f3760g;
            if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                fVar.e(fVar.i + 1);
                jVarL = new j(0, 0, t.i(jVarS.f9675d, 0, obj, obj2), fVar.f11176c);
                fVar2 = fVar;
            } else {
                while (!yb.k.a(obj, jVarS.f9675d[i10])) {
                    if (i10 == i11) {
                        fVar.e(fVar.i + 1);
                        jVarL = new j(0, 0, t.i(jVarS.f9675d, 0, obj, obj2), fVar.f11176c);
                        break;
                    }
                    i10 += i12;
                }
                fVar.f11178g = jVarS.x(i10);
                if (jVarS.f9674c == fVar.f11176c) {
                    jVarS.f9675d[i10 + 1] = obj2;
                    jVarL = jVarS;
                } else {
                    fVar.f11179h++;
                    Object[] objArr3 = jVarS.f9675d;
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length);
                    objArrCopyOf2[i10 + 1] = obj2;
                    jVarL = new j(0, 0, objArrCopyOf2, fVar.f11176c);
                }
                fVar2 = fVar;
            }
        } else {
            fVar2 = fVar;
            jVarL = jVarS.l(i, obj, obj2, i3 + 5, fVar2);
        }
        return jVarS == jVarL ? this : r(iT, jVarL, fVar2.f11176c);
    }

    public final j m(j jVar, int i, r0.a aVar, s0.f fVar) {
        Object[] objArr;
        j jVarJ;
        if (this == jVar) {
            aVar.f10362a += b();
            return this;
        }
        int i3 = 0;
        if (i > 30) {
            r0.b bVar = fVar.f11176c;
            int i10 = jVar.f9673b;
            Object[] objArr2 = this.f9675d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + jVar.f9675d.length);
            int length = this.f9675d.length;
            ec.f fVarL = p5.f.L(p5.f.O(0, jVar.f9675d.length), 2);
            int i11 = fVarL.f3758c;
            int i12 = fVarL.f3759f;
            int i13 = fVarL.f3760g;
            if ((i13 > 0 && i11 <= i12) || (i13 < 0 && i12 <= i11)) {
                while (true) {
                    if (c(jVar.f9675d[i11])) {
                        aVar.f10362a++;
                    } else {
                        Object[] objArr3 = jVar.f9675d;
                        objArrCopyOf[length] = objArr3[i11];
                        objArrCopyOf[length + 1] = objArr3[i11 + 1];
                        length += 2;
                    }
                    if (i11 == i12) {
                        break;
                    }
                    i11 += i13;
                }
            }
            if (length != this.f9675d.length) {
                return length == jVar.f9675d.length ? jVar : length == objArrCopyOf.length ? new j(0, 0, objArrCopyOf, bVar) : new j(0, 0, Arrays.copyOf(objArrCopyOf, length), bVar);
            }
        } else {
            int i14 = this.f9673b | jVar.f9673b;
            int i15 = this.f9672a;
            int i16 = jVar.f9672a;
            int i17 = (i15 ^ i16) & (~i14);
            int i18 = i15 & i16;
            int i19 = i17;
            while (i18 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i18);
                if (yb.k.a(this.f9675d[f(iLowestOneBit)], jVar.f9675d[jVar.f(iLowestOneBit)])) {
                    i19 |= iLowestOneBit;
                } else {
                    i14 |= iLowestOneBit;
                }
                i18 ^= iLowestOneBit;
            }
            if ((i14 & i19) != 0) {
                q1.b("Check failed.");
            }
            j jVar2 = (yb.k.a(this.f9674c, fVar.f11176c) && this.f9672a == i19 && this.f9673b == i14) ? this : new j(i19, i14, new Object[Integer.bitCount(i14) + (Integer.bitCount(i19) * 2)], null);
            int i20 = i14;
            int i21 = 0;
            while (i20 != 0) {
                int iLowestOneBit2 = Integer.lowestOneBit(i20);
                Object[] objArr4 = jVar2.f9675d;
                int length2 = (objArr4.length - 1) - i21;
                if (i(iLowestOneBit2)) {
                    jVarJ = s(t(iLowestOneBit2));
                    if (jVar.i(iLowestOneBit2)) {
                        jVarJ = jVarJ.m(jVar.s(jVar.t(iLowestOneBit2)), i + 5, aVar, fVar);
                        objArr = objArr4;
                    } else if (jVar.h(iLowestOneBit2)) {
                        int iF = jVar.f(iLowestOneBit2);
                        Object obj = jVar.f9675d[iF];
                        Object objX = jVar.x(iF);
                        int i22 = fVar.i;
                        objArr = objArr4;
                        jVarJ = jVarJ.l(obj != null ? obj.hashCode() : i3, obj, objX, i + 5, fVar);
                        if (fVar.i == i22) {
                            aVar.f10362a++;
                        }
                    } else {
                        objArr = objArr4;
                    }
                } else {
                    objArr = objArr4;
                    if (jVar.i(iLowestOneBit2)) {
                        j jVarS = jVar.s(jVar.t(iLowestOneBit2));
                        if (h(iLowestOneBit2)) {
                            int iF2 = f(iLowestOneBit2);
                            Object obj2 = this.f9675d[iF2];
                            int i23 = i + 5;
                            if (jVarS.d(obj2 != null ? obj2.hashCode() : 0, i23, obj2)) {
                                aVar.f10362a++;
                                jVarJ = jVarS;
                            } else {
                                jVarJ = jVarS.l(obj2 != null ? obj2.hashCode() : 0, obj2, x(iF2), i23, fVar);
                            }
                        } else {
                            jVarJ = jVarS;
                        }
                    } else {
                        int iF3 = f(iLowestOneBit2);
                        Object obj3 = this.f9675d[iF3];
                        Object objX2 = x(iF3);
                        int iF4 = jVar.f(iLowestOneBit2);
                        Object obj4 = jVar.f9675d[iF4];
                        jVarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, objX2, obj4 != null ? obj4.hashCode() : 0, obj4, jVar.x(iF4), i + 5, fVar.f11176c);
                    }
                }
                objArr[length2] = jVarJ;
                i21++;
                i20 ^= iLowestOneBit2;
                i3 = 0;
            }
            int i24 = 0;
            while (i19 != 0) {
                int iLowestOneBit3 = Integer.lowestOneBit(i19);
                int i25 = i24 * 2;
                if (jVar.h(iLowestOneBit3)) {
                    int iF5 = jVar.f(iLowestOneBit3);
                    Object[] objArr5 = jVar2.f9675d;
                    objArr5[i25] = jVar.f9675d[iF5];
                    objArr5[i25 + 1] = jVar.x(iF5);
                    if (h(iLowestOneBit3)) {
                        aVar.f10362a++;
                    }
                } else {
                    int iF6 = f(iLowestOneBit3);
                    Object[] objArr6 = jVar2.f9675d;
                    objArr6[i25] = this.f9675d[iF6];
                    objArr6[i25 + 1] = x(iF6);
                }
                i24++;
                i19 ^= iLowestOneBit3;
            }
            if (!e(jVar2)) {
                return jVar.e(jVar2) ? jVar : jVar2;
            }
        }
        return this;
    }

    public final j n(int i, Object obj, int i3, s0.f fVar) {
        j jVarN;
        int iE = 1 << t.E(i, i3);
        if (h(iE)) {
            int iF = f(iE);
            if (yb.k.a(obj, this.f9675d[iF])) {
                return p(iF, iE, fVar);
            }
        } else if (i(iE)) {
            int iT = t(iE);
            j jVarS = s(iT);
            if (i3 == 30) {
                ec.f fVarL = p5.f.L(p5.f.O(0, jVarS.f9675d.length), 2);
                int i10 = fVarL.f3758c;
                int i11 = fVarL.f3759f;
                int i12 = fVarL.f3760g;
                if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                    jVarN = jVarS;
                    break;
                }
                while (!yb.k.a(obj, jVarS.f9675d[i10])) {
                    if (i10 == i11) {
                        jVarN = jVarS;
                        break;
                    }
                    i10 += i12;
                }
                jVarN = jVarS.k(i10, fVar);
            } else {
                jVarN = jVarS.n(i, obj, i3 + 5, fVar);
            }
            return q(jVarS, jVarN, iT, iE, fVar.f11176c);
        }
        return this;
    }

    public final j o(int i, Object obj, Object obj2, int i3, s0.f fVar) {
        s0.f fVar2;
        j jVarO;
        int iE = 1 << t.E(i, i3);
        if (h(iE)) {
            int iF = f(iE);
            return (yb.k.a(obj, this.f9675d[iF]) && yb.k.a(obj2, x(iF))) ? p(iF, iE, fVar) : this;
        }
        if (!i(iE)) {
            return this;
        }
        int iT = t(iE);
        j jVarS = s(iT);
        if (i3 == 30) {
            ec.f fVarL = p5.f.L(p5.f.O(0, jVarS.f9675d.length), 2);
            int i10 = fVarL.f3758c;
            int i11 = fVarL.f3759f;
            int i12 = fVarL.f3760g;
            if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                jVarO = jVarS;
                fVar2 = fVar;
            } else {
                while (true) {
                    if (!yb.k.a(obj, jVarS.f9675d[i10]) || !yb.k.a(obj2, jVarS.x(i10))) {
                        if (i10 == i11) {
                            break;
                        }
                        i10 += i12;
                    } else {
                        jVarO = jVarS.k(i10, fVar);
                        break;
                    }
                }
                jVarO = jVarS;
                fVar2 = fVar;
            }
        } else {
            fVar2 = fVar;
            jVarO = jVarS.o(i, obj, obj2, i3 + 5, fVar2);
        }
        return q(jVarS, jVarO, iT, iE, fVar2.f11176c);
    }

    public final j p(int i, int i3, s0.f fVar) {
        fVar.e(fVar.i - 1);
        fVar.f11178g = x(i);
        Object[] objArr = this.f9675d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.f9674c != fVar.f11176c) {
            return new j(i3 ^ this.f9672a, this.f9673b, t.j(objArr, i), fVar.f11176c);
        }
        this.f9675d = t.j(objArr, i);
        this.f9672a ^= i3;
        return this;
    }

    public final j q(j jVar, j jVar2, int i, int i3, r0.b bVar) {
        r0.b bVar2 = this.f9674c;
        if (jVar2 != null) {
            return (bVar2 == bVar || jVar != jVar2) ? r(i, jVar2, bVar) : this;
        }
        Object[] objArr = this.f9675d;
        if (objArr.length == 1) {
            return null;
        }
        if (bVar2 != bVar) {
            return new j(this.f9672a, this.f9673b ^ i3, t.k(objArr, i), bVar);
        }
        this.f9675d = t.k(objArr, i);
        this.f9673b ^= i3;
        return this;
    }

    public final j r(int i, j jVar, r0.b bVar) {
        Object[] objArr = this.f9675d;
        if (objArr.length == 1 && jVar.f9675d.length == 2 && jVar.f9673b == 0) {
            jVar.f9672a = this.f9673b;
            return jVar;
        }
        if (this.f9674c == bVar) {
            objArr[i] = jVar;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        objArrCopyOf[i] = jVar;
        return new j(this.f9672a, this.f9673b, objArrCopyOf, bVar);
    }

    public final j s(int i) {
        Object obj = this.f9675d[i];
        obj.getClass();
        return (j) obj;
    }

    public final int t(int i) {
        return (this.f9675d.length - 1) - Integer.bitCount(this.f9673b & (i - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c6, code lost:
    
        if (r13 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cf, code lost:
    
        if (r13 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d2, code lost:
    
        r13.f15390g = w(r11, r4, (p0.j) r13.f15390g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dc, code lost:
    
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final wd.a u(java.lang.Object r12, int r13, int r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.j.u(java.lang.Object, int, int, java.lang.Object):wd.a");
    }

    public final j v(int i, int i3, Object obj) {
        j jVarV;
        int iE = 1 << t.E(i, i3);
        if (h(iE)) {
            int iF = f(iE);
            if (!yb.k.a(obj, this.f9675d[iF])) {
                return this;
            }
            Object[] objArr = this.f9675d;
            if (objArr.length != 2) {
                return new j(this.f9672a ^ iE, this.f9673b, t.j(objArr, iF), null);
            }
        } else {
            if (!i(iE)) {
                return this;
            }
            int iT = t(iE);
            j jVarS = s(iT);
            if (i3 == 30) {
                ec.f fVarL = p5.f.L(p5.f.O(0, jVarS.f9675d.length), 2);
                int i10 = fVarL.f3758c;
                int i11 = fVarL.f3759f;
                int i12 = fVarL.f3760g;
                if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                    jVarV = jVarS;
                    break;
                }
                while (!yb.k.a(obj, jVarS.f9675d[i10])) {
                    if (i10 == i11) {
                        jVarV = jVarS;
                        break;
                    }
                    i10 += i12;
                }
                Object[] objArr2 = jVarS.f9675d;
                jVarV = objArr2.length == 2 ? null : new j(0, 0, t.j(objArr2, i10), null);
            } else {
                jVarV = jVarS.v(i, i3 + 5, obj);
            }
            if (jVarV != null) {
                return jVarS != jVarV ? w(iT, iE, jVarV) : this;
            }
            Object[] objArr3 = this.f9675d;
            if (objArr3.length != 1) {
                return new j(this.f9672a, this.f9673b ^ iE, t.k(objArr3, iT), null);
            }
        }
        return null;
    }

    public final j w(int i, int i3, j jVar) {
        Object[] objArr = jVar.f9675d;
        if (objArr.length != 2 || jVar.f9673b != 0) {
            Object[] objArr2 = this.f9675d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            objArrCopyOf[i] = jVar;
            return new j(this.f9672a, this.f9673b, objArrCopyOf, null);
        }
        if (this.f9675d.length == 1) {
            jVar.f9672a = this.f9673b;
            return jVar;
        }
        int iF = f(i3);
        Object[] objArr3 = this.f9675d;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length + 1);
        kb.k.i0(objArrCopyOf2, objArrCopyOf2, i + 2, i + 1, objArr3.length);
        kb.k.i0(objArrCopyOf2, objArrCopyOf2, iF + 2, iF, i);
        objArrCopyOf2[iF] = obj;
        objArrCopyOf2[iF + 1] = obj2;
        return new j(this.f9672a ^ i3, this.f9673b ^ i3, objArrCopyOf2, null);
    }

    public final Object x(int i) {
        return this.f9675d[i + 1];
    }
}
