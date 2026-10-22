package k;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public long[] f5550a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f5551b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f5552c;

    /* renamed from: d, reason: collision with root package name */
    public int f5553d;

    /* renamed from: e, reason: collision with root package name */
    public int f5554e;

    /* renamed from: f, reason: collision with root package name */
    public int f5555f;

    public y(int i2) {
        this.f5550a = g0.f5491a;
        this.f5551b = l.a.f5726c;
        this.f5552c = l.f5505a;
        if (i2 >= 0) {
            f(g0.d(i2));
        } else {
            l.a.c("Capacity must be a positive value.");
            throw null;
        }
    }

    public final void a() {
        this.f5554e = 0;
        long[] jArr = this.f5550a;
        if (jArr != g0.f5491a) {
            d7.n.e0(jArr);
            long[] jArr2 = this.f5550a;
            int i2 = this.f5553d;
            int i10 = i2 >> 3;
            long j2 = 255 << ((i2 & 7) << 3);
            jArr2[i10] = (jArr2[i10] & (~j2)) | j2;
        }
        d7.n.d0(this.f5551b, 0, this.f5553d);
        this.f5555f = g0.a(this.f5553d) - this.f5554e;
    }

    public final int b(int i2) {
        int i10 = this.f5553d;
        int i11 = i2 & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.f5550a;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j2 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j4 = j2 & ((~j2) << 7) & (-9187201950435737472L);
            if (j4 != 0) {
                return (i11 + (Long.numberOfTrailingZeros(j4) >> 3)) & i10;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final int c(Object obj) {
        long j2;
        long j4;
        long j10;
        long[] jArr;
        long[] jArr2;
        int i2;
        Object[] objArr;
        int i10 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f5553d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr3 = this.f5550a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr3[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr3[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L);
            while (j14 != 0) {
                int iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                int i20 = i10;
                if (q7.k.a(this.f5551b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j14 &= j14 - 1;
                i10 = i20;
            }
            int i21 = i10;
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iB = b(i12);
                long j15 = 255;
                if (this.f5555f != 0 || ((this.f5550a[iB >> 3] >> ((iB & 7) << 3)) & 255) == 254) {
                    j2 = 255;
                    j4 = j12;
                    j10 = 128;
                } else {
                    int i22 = this.f5553d;
                    if (i22 > 8) {
                        int i23 = 8;
                        if (Long.compareUnsigned(this.f5554e * 32, i22 * 25) <= 0) {
                            long[] jArr4 = this.f5550a;
                            int i24 = this.f5553d;
                            Object[] objArr2 = this.f5551b;
                            int[] iArr = this.f5552c;
                            j10 = 128;
                            int i25 = (i24 + 7) >> 3;
                            int i26 = 0;
                            while (i26 < i25) {
                                long j16 = j15;
                                long j17 = jArr4[i26] & (-9187201950435737472L);
                                jArr4[i26] = (-72340172838076674L) & ((~j17) + (j17 >>> 7));
                                i26++;
                                i23 = i23;
                                j12 = j12;
                                j15 = j16;
                            }
                            j2 = j15;
                            j4 = j12;
                            int i27 = i23;
                            int iI0 = d7.n.i0(jArr4);
                            int i28 = iI0 - 1;
                            long j18 = 72057594037927935L;
                            jArr4[i28] = (jArr4[i28] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[iI0] = jArr4[0];
                            int i29 = 0;
                            while (i29 != i24) {
                                int i30 = i29 >> 3;
                                int i31 = (i29 & 7) << 3;
                                long j19 = (jArr4[i30] >> i31) & j2;
                                if (j19 != 128 && j19 == 254) {
                                    Object obj2 = objArr2[i29];
                                    int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i21;
                                    int i32 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                    int iB2 = b(i32);
                                    int i33 = i32 & i24;
                                    long j20 = j18;
                                    if (((iB2 - i33) & i24) / 8 == ((i29 - i33) & i24) / i27) {
                                        jArr4[i30] = ((r8 & 127) << i31) | (jArr4[i30] & (~(j2 << i31)));
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j20) | Long.MIN_VALUE;
                                        i29++;
                                        i27 = i27;
                                        j18 = j20;
                                    } else {
                                        int i34 = i27;
                                        int i35 = iB2 >> 3;
                                        long j21 = jArr4[i35];
                                        int i36 = (iB2 & 7) << 3;
                                        if (((j21 >> i36) & j2) == 128) {
                                            i2 = i24;
                                            objArr = objArr2;
                                            jArr4[i35] = ((~(j2 << i36)) & j21) | ((r8 & 127) << i36);
                                            jArr4[i30] = (jArr4[i30] & (~(j2 << i31))) | (128 << i31);
                                            objArr[iB2] = objArr[i29];
                                            objArr[i29] = null;
                                            iArr[iB2] = iArr[i29];
                                            iArr[i29] = 0;
                                        } else {
                                            i2 = i24;
                                            objArr = objArr2;
                                            jArr4[i35] = ((r8 & 127) << i36) | ((~(j2 << i36)) & j21);
                                            Object obj3 = objArr[iB2];
                                            objArr[iB2] = objArr[i29];
                                            objArr[i29] = obj3;
                                            int i37 = iArr[iB2];
                                            iArr[iB2] = iArr[i29];
                                            iArr[i29] = i37;
                                            i29--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j20) | Long.MIN_VALUE;
                                        i29++;
                                        i24 = i2;
                                        i27 = i34;
                                        j18 = j20;
                                        objArr2 = objArr;
                                    }
                                } else {
                                    i29++;
                                }
                            }
                            this.f5555f = g0.a(this.f5553d) - this.f5554e;
                        }
                        iB = b(i12);
                    }
                    j2 = 255;
                    j4 = j12;
                    j10 = 128;
                    int iB3 = g0.b(this.f5553d);
                    long[] jArr5 = this.f5550a;
                    Object[] objArr3 = this.f5551b;
                    int[] iArr2 = this.f5552c;
                    int i38 = this.f5553d;
                    f(iB3);
                    long[] jArr6 = this.f5550a;
                    Object[] objArr4 = this.f5551b;
                    int[] iArr3 = this.f5552c;
                    int i39 = this.f5553d;
                    int i40 = 0;
                    while (i40 < i38) {
                        if (((jArr5[i40 >> 3] >> ((i40 & 7) << 3)) & 255) < 128) {
                            Object obj4 = objArr3[i40];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i21;
                            int i41 = iHashCode3 ^ (iHashCode3 << 16);
                            int iB4 = b(i41 >>> 7);
                            jArr = jArr6;
                            jArr2 = jArr5;
                            long j22 = i41 & 127;
                            int i42 = iB4 >> 3;
                            int i43 = (iB4 & 7) << 3;
                            long j23 = (jArr[i42] & (~(255 << i43))) | (j22 << i43);
                            jArr[i42] = j23;
                            jArr[(((iB4 - 7) & i39) + (i39 & 7)) >> 3] = j23;
                            objArr4[iB4] = obj4;
                            iArr3[iB4] = iArr2[i40];
                        } else {
                            jArr = jArr6;
                            jArr2 = jArr5;
                        }
                        i40++;
                        jArr5 = jArr2;
                        jArr6 = jArr;
                    }
                    iB = b(i12);
                }
                this.f5554e++;
                int i44 = this.f5555f;
                long[] jArr7 = this.f5550a;
                int i45 = iB >> 3;
                long j24 = jArr7[i45];
                int i46 = (iB & 7) << 3;
                this.f5555f = i44 - (((j24 >> i46) & j2) == j10 ? 1 : 0);
                int i47 = this.f5553d;
                long j25 = (j24 & (~(j2 << i46))) | (j4 << i46);
                jArr7[i45] = j25;
                jArr7[(((iB - 7) & i47) + (i47 & 7)) >> 3] = j25;
                return ~iB;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
            i10 = i21;
        }
    }

    public final int d(Object obj) {
        int i2 = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i10 = iHashCode ^ (iHashCode << 16);
        int i11 = i10 & 127;
        int i12 = this.f5553d;
        int i13 = i10 >>> 7;
        while (true) {
            int i14 = i13 & i12;
            long[] jArr = this.f5550a;
            int i15 = i14 >> 3;
            int i16 = (i14 & 7) << 3;
            long j2 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j4 = (i11 * 72340172838076673L) ^ j2;
            for (long j10 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i14) & i12;
                if (q7.k.a(this.f5551b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i2 += 8;
            i13 = i14 + i2;
        }
    }

    public final int e(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f5552c[iD];
        }
        l.a.e("There is no key " + obj + " in the map");
        throw null;
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
            boolean r3 = r1 instanceof k.y
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            k.y r1 = (k.y) r1
            int r3 = r1.f5554e
            int r5 = r0.f5554e
            if (r3 == r5) goto L17
            return r4
        L17:
            java.lang.Object[] r3 = r0.f5551b
            int[] r5 = r0.f5552c
            long[] r0 = r0.f5550a
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
            int[] r15 = r1.f5552c
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
        throw new UnsupportedOperationException("Method not decompiled: k.y.equals(java.lang.Object):boolean");
    }

    public final void f(int i2) {
        long[] jArr;
        int iMax = i2 > 0 ? Math.max(7, g0.c(i2)) : 0;
        this.f5553d = iMax;
        if (iMax == 0) {
            jArr = g0.f5491a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            d7.n.e0(jArr);
        }
        this.f5550a = jArr;
        int i10 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j2)) | j2;
        this.f5555f = g0.a(this.f5553d) - this.f5554e;
        this.f5551b = new Object[iMax];
        this.f5552c = new int[iMax];
    }

    public final void g(int i2) {
        this.f5554e--;
        long[] jArr = this.f5550a;
        int i10 = this.f5553d;
        int i11 = i2 >> 3;
        int i12 = (i2 & 7) << 3;
        long j2 = (jArr[i11] & (~(255 << i12))) | (254 << i12);
        jArr[i11] = j2;
        jArr[(((i2 - 7) & i10) + (i10 & 7)) >> 3] = j2;
        this.f5551b[i2] = null;
    }

    public final void h(int i2, Object obj) {
        int iC = c(obj);
        if (iC < 0) {
            iC = ~iC;
        }
        this.f5551b[iC] = obj;
        this.f5552c[iC] = i2;
    }

    public final int hashCode() {
        Object[] objArr = this.f5551b;
        int[] iArr = this.f5552c;
        long[] jArr = this.f5550a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        int i12 = (i2 << 3) + i11;
                        Object obj = objArr[i12];
                        iHashCode += Integer.hashCode(iArr[i12]) ^ (obj != null ? obj.hashCode() : 0);
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return iHashCode;
                }
            }
            if (i2 == length) {
                return iHashCode;
            }
            i2++;
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
            int r1 = r0.f5554e
            if (r1 != 0) goto L9
            java.lang.String r0 = "{}"
            return r0
        L9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "{"
            r1.<init>(r2)
            java.lang.Object[] r2 = r0.f5551b
            int[] r3 = r0.f5552c
            long[] r4 = r0.f5550a
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
            int r14 = r0.f5554e
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
            java.lang.String r1 = "toString(...)"
            q7.k.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.y.toString():java.lang.String");
    }

    public /* synthetic */ y() {
        this(6);
    }
}
