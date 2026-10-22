package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public long[] f9650a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f9651b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f9652c;

    /* renamed from: d, reason: collision with root package name */
    public int f9653d;

    /* renamed from: e, reason: collision with root package name */
    public int f9654e;

    /* renamed from: f, reason: collision with root package name */
    public int f9655f;

    public z(int i) {
        this.f9650a = n0.f9597a;
        this.f9651b = q.a.f10066c;
        this.f9652c = l.f9589a;
        if (i >= 0) {
            f(n0.d(i));
        } else {
            g5.f.s("Capacity must be a positive value.");
            throw null;
        }
    }

    public final void a() {
        this.f9654e = 0;
        long[] jArr = this.f9650a;
        if (jArr != n0.f9597a) {
            kb.k.n0(jArr, -9187201950435737472L);
            long[] jArr2 = this.f9650a;
            int i = this.f9653d;
            int i3 = i >> 3;
            long j10 = 255 << ((i & 7) << 3);
            jArr2[i3] = (jArr2[i3] & (~j10)) | j10;
        }
        kb.k.m0(null, 0, this.f9651b, this.f9653d);
        this.f9655f = n0.a(this.f9653d) - this.f9654e;
    }

    public final int b(int i) {
        int i3 = this.f9653d;
        int i10 = i & i3;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f9650a;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j10 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j11 = j10 & ((~j10) << 7) & (-9187201950435737472L);
            if (j11 != 0) {
                return (i10 + (Long.numberOfTrailingZeros(j11) >> 3)) & i3;
            }
            i11 += 8;
            i10 = (i10 + i11) & i3;
        }
    }

    public final int c(Object obj) {
        long j10;
        long j11;
        long j12;
        long[] jArr;
        long[] jArr2;
        int i;
        Object[] objArr;
        int i3 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i10 = iHashCode ^ (iHashCode << 16);
        int i11 = i10 >>> 7;
        int i12 = i10 & 127;
        int i13 = this.f9653d;
        int i14 = i11 & i13;
        int i15 = 0;
        while (true) {
            long[] jArr3 = this.f9650a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j13 = ((jArr3[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr3[i16] >>> i17);
            long j14 = i12;
            int i18 = i12;
            long j15 = j13 ^ (j14 * 72340172838076673L);
            long j16 = (~j15) & (j15 - 72340172838076673L) & (-9187201950435737472L);
            while (j16 != 0) {
                int iNumberOfTrailingZeros = (i14 + (Long.numberOfTrailingZeros(j16) >> 3)) & i13;
                int i19 = i3;
                if (yb.k.a(this.f9651b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j16 &= j16 - 1;
                i3 = i19;
            }
            int i20 = i3;
            if ((((~j13) << 6) & j13 & (-9187201950435737472L)) != 0) {
                int iB = b(i11);
                long j17 = 255;
                if (this.f9655f != 0 || ((this.f9650a[iB >> 3] >> ((iB & 7) << 3)) & 255) == 254) {
                    j10 = 255;
                    j11 = j14;
                    j12 = 128;
                } else {
                    int i21 = this.f9653d;
                    if (i21 > 8) {
                        int i22 = 8;
                        if (Long.compareUnsigned(this.f9654e * 32, i21 * 25) <= 0) {
                            long[] jArr4 = this.f9650a;
                            int i23 = this.f9653d;
                            Object[] objArr2 = this.f9651b;
                            int[] iArr = this.f9652c;
                            j12 = 128;
                            int i24 = (i23 + 7) >> 3;
                            int i25 = 0;
                            while (i25 < i24) {
                                long j18 = j17;
                                long j19 = jArr4[i25] & (-9187201950435737472L);
                                jArr4[i25] = (-72340172838076674L) & ((~j19) + (j19 >>> 7));
                                i25++;
                                i22 = i22;
                                j14 = j14;
                                j17 = j18;
                            }
                            j10 = j17;
                            j11 = j14;
                            int i26 = i22;
                            int iQ0 = kb.k.q0(jArr4);
                            int i27 = iQ0 - 1;
                            long j20 = 72057594037927935L;
                            jArr4[i27] = (jArr4[i27] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[iQ0] = jArr4[0];
                            int i28 = 0;
                            while (i28 != i23) {
                                int i29 = i28 >> 3;
                                int i30 = (i28 & 7) << 3;
                                long j21 = (jArr4[i29] >> i30) & j10;
                                if (j21 != 128 && j21 == 254) {
                                    Object obj2 = objArr2[i28];
                                    int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i20;
                                    int i31 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                    int iB2 = b(i31);
                                    int i32 = i31 & i23;
                                    long j22 = j20;
                                    if (((iB2 - i32) & i23) / 8 == ((i28 - i32) & i23) / i26) {
                                        jArr4[i29] = ((r8 & 127) << i30) | (jArr4[i29] & (~(j10 << i30)));
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j22) | Long.MIN_VALUE;
                                        i28++;
                                        i26 = i26;
                                        j20 = j22;
                                    } else {
                                        int i33 = i26;
                                        int i34 = iB2 >> 3;
                                        long j23 = jArr4[i34];
                                        int i35 = (iB2 & 7) << 3;
                                        if (((j23 >> i35) & j10) == 128) {
                                            i = i23;
                                            objArr = objArr2;
                                            jArr4[i34] = ((~(j10 << i35)) & j23) | ((r8 & 127) << i35);
                                            jArr4[i29] = (jArr4[i29] & (~(j10 << i30))) | (128 << i30);
                                            objArr[iB2] = objArr[i28];
                                            objArr[i28] = null;
                                            iArr[iB2] = iArr[i28];
                                            iArr[i28] = 0;
                                        } else {
                                            i = i23;
                                            objArr = objArr2;
                                            jArr4[i34] = ((r8 & 127) << i35) | ((~(j10 << i35)) & j23);
                                            Object obj3 = objArr[iB2];
                                            objArr[iB2] = objArr[i28];
                                            objArr[i28] = obj3;
                                            int i36 = iArr[iB2];
                                            iArr[iB2] = iArr[i28];
                                            iArr[i28] = i36;
                                            i28--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j22) | Long.MIN_VALUE;
                                        i28++;
                                        i23 = i;
                                        i26 = i33;
                                        j20 = j22;
                                        objArr2 = objArr;
                                    }
                                } else {
                                    i28++;
                                }
                            }
                            this.f9655f = n0.a(this.f9653d) - this.f9654e;
                        }
                        iB = b(i11);
                    }
                    j10 = 255;
                    j11 = j14;
                    j12 = 128;
                    int iB3 = n0.b(this.f9653d);
                    long[] jArr5 = this.f9650a;
                    Object[] objArr3 = this.f9651b;
                    int[] iArr2 = this.f9652c;
                    int i37 = this.f9653d;
                    f(iB3);
                    long[] jArr6 = this.f9650a;
                    Object[] objArr4 = this.f9651b;
                    int[] iArr3 = this.f9652c;
                    int i38 = this.f9653d;
                    int i39 = 0;
                    while (i39 < i37) {
                        if (((jArr5[i39 >> 3] >> ((i39 & 7) << 3)) & 255) < 128) {
                            Object obj4 = objArr3[i39];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i20;
                            int i40 = iHashCode3 ^ (iHashCode3 << 16);
                            int iB4 = b(i40 >>> 7);
                            jArr = jArr6;
                            jArr2 = jArr5;
                            long j24 = i40 & 127;
                            int i41 = iB4 >> 3;
                            int i42 = (iB4 & 7) << 3;
                            long j25 = (jArr[i41] & (~(255 << i42))) | (j24 << i42);
                            jArr[i41] = j25;
                            jArr[(((iB4 - 7) & i38) + (i38 & 7)) >> 3] = j25;
                            objArr4[iB4] = obj4;
                            iArr3[iB4] = iArr2[i39];
                        } else {
                            jArr = jArr6;
                            jArr2 = jArr5;
                        }
                        i39++;
                        jArr5 = jArr2;
                        jArr6 = jArr;
                    }
                    iB = b(i11);
                }
                this.f9654e++;
                int i43 = this.f9655f;
                long[] jArr7 = this.f9650a;
                int i44 = iB >> 3;
                long j26 = jArr7[i44];
                int i45 = (iB & 7) << 3;
                this.f9655f = i43 - (((j26 >> i45) & j10) == j12 ? 1 : 0);
                int i46 = this.f9653d;
                long j27 = (j26 & (~(j10 << i45))) | (j11 << i45);
                jArr7[i44] = j27;
                jArr7[(((iB - 7) & i46) + (i46 & 7)) >> 3] = j27;
                return ~iB;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
            i12 = i18;
            i3 = i20;
        }
    }

    public final int d(Object obj) {
        int i = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i10 = i3 & 127;
        int i11 = this.f9653d;
        int i12 = i3 >>> 7;
        while (true) {
            int i13 = i12 & i11;
            long[] jArr = this.f9650a;
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j10 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j11 = (i10 * 72340172838076673L) ^ j10;
            for (long j12 = (~j11) & (j11 - 72340172838076673L) & (-9187201950435737472L); j12 != 0; j12 &= j12 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j12) >> 3) + i13) & i11;
                if (yb.k.a(this.f9651b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j10 & ((~j10) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i12 = i13 + i;
        }
    }

    public final int e(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f9652c[iD];
        }
        od.f.f("There is no key ", obj, " in the map");
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof p.z
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            p.z r1 = (p.z) r1
            int r3 = r1.f9654e
            int r5 = r0.f9654e
            if (r3 == r5) goto L17
            return r4
        L17:
            java.lang.Object[] r3 = r0.f9651b
            int[] r5 = r0.f9652c
            long[] r0 = r0.f9650a
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L67
            r7 = r4
        L23:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L62
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L3d:
            if (r12 >= r10) goto L60
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L5c
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r5[r13]
            int r14 = r1.d(r14)
            if (r14 < 0) goto L5b
            int[] r15 = r1.f9652c
            r14 = r15[r14]
            if (r13 == r14) goto L5c
        L5b:
            return r4
        L5c:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L3d
        L60:
            if (r10 != r11) goto L67
        L62:
            if (r7 == r6) goto L67
            int r7 = r7 + 1
            goto L23
        L67:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p.z.equals(java.lang.Object):boolean");
    }

    public final void f(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, n0.c(i)) : 0;
        this.f9653d = iMax;
        if (iMax == 0) {
            jArr = n0.f9597a;
        } else {
            int i3 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i3];
            Arrays.fill(jArr2, 0, i3, -9187201950435737472L);
            jArr = jArr2;
        }
        this.f9650a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        this.f9655f = n0.a(this.f9653d) - this.f9654e;
        this.f9651b = new Object[iMax];
        this.f9652c = new int[iMax];
    }

    public final void g(int i) {
        this.f9654e--;
        long[] jArr = this.f9650a;
        int i3 = this.f9653d;
        int i10 = i >> 3;
        int i11 = (i & 7) << 3;
        long j10 = (jArr[i10] & (~(255 << i11))) | (254 << i11);
        jArr[i10] = j10;
        jArr[(((i - 7) & i3) + (i3 & 7)) >> 3] = j10;
        this.f9651b[i] = null;
    }

    public final void h(int i, Object obj) {
        int iC = c(obj);
        if (iC < 0) {
            iC = ~iC;
        }
        this.f9651b[iC] = obj;
        this.f9652c[iC] = i;
    }

    public final int hashCode() {
        Object[] objArr = this.f9651b;
        int[] iArr = this.f9652c;
        long[] jArr = this.f9650a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        iHashCode += Integer.hashCode(iArr[i11]) ^ (obj != null ? obj.hashCode() : 0);
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[PHI: r8
      0x006a: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x002c, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.f9654e
            if (r1 != 0) goto L9
            java.lang.String r0 = "{}"
            return r0
        L9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "{"
            r1.<init>(r2)
            java.lang.Object[] r2 = r0.f9651b
            int[] r3 = r0.f9652c
            long[] r4 = r0.f9650a
            int r5 = r4.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L6f
            r6 = 0
            r7 = r6
            r8 = r7
        L1e:
            r9 = r4[r7]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L6a
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L38:
            if (r13 >= r11) goto L68
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L64
            int r14 = r7 << 3
            int r14 = r14 + r13
            r15 = r2[r14]
            r14 = r3[r14]
            if (r15 != r0) goto L4e
            java.lang.String r15 = "(this)"
        L4e:
            r1.append(r15)
            java.lang.String r15 = "="
            r1.append(r15)
            r1.append(r14)
            int r8 = r8 + 1
            int r14 = r0.f9654e
            if (r8 >= r14) goto L64
            java.lang.String r14 = ", "
            r1.append(r14)
        L64:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L38
        L68:
            if (r11 != r12) goto L6f
        L6a:
            if (r7 == r5) goto L6f
            int r7 = r7 + 1
            goto L1e
        L6f:
            r0 = 125(0x7d, float:1.75E-43)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.z.toString():java.lang.String");
    }

    public /* synthetic */ z() {
        this(6);
    }
}
