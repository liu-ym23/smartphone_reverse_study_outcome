package k;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f5453a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f5454b;

    /* renamed from: c, reason: collision with root package name */
    public int f5455c;

    /* renamed from: d, reason: collision with root package name */
    public int f5456d;

    /* renamed from: e, reason: collision with root package name */
    public int f5457e;

    public b0(int i2) {
        this.f5453a = g0.f5491a;
        this.f5454b = l.a.f5726c;
        if (i2 >= 0) {
            f(g0.d(i2));
        } else {
            l.a.c("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean a(Object obj) {
        int i2 = this.f5456d;
        this.f5454b[d(obj)] = obj;
        return this.f5456d != i2;
    }

    public final void b() {
        this.f5456d = 0;
        long[] jArr = this.f5453a;
        if (jArr != g0.f5491a) {
            d7.n.e0(jArr);
            long[] jArr2 = this.f5453a;
            int i2 = this.f5455c;
            int i10 = i2 >> 3;
            long j2 = 255 << ((i2 & 7) << 3);
            jArr2[i10] = (jArr2[i10] & (~j2)) | j2;
        }
        d7.n.d0(this.f5454b, 0, this.f5455c);
        this.f5457e = g0.a(this.f5455c) - this.f5456d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0.f5455c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f5453a
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L47:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L66
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.f5454b
            r15 = r15[r11]
            boolean r15 = q7.k.a(r15, r1)
            if (r15 == 0) goto L60
            goto L70
        L60:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L47
        L66:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L74
            r11 = -1
        L70:
            if (r11 < 0) goto L73
            return r12
        L73:
            return r2
        L74:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b0.c(java.lang.Object):boolean");
    }

    public final int d(Object obj) {
        long j2;
        long j4;
        long j10;
        long[] jArr;
        long[] jArr2;
        int i2;
        Object[] objArr;
        int i10;
        int i11 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i12 = iHashCode ^ (iHashCode << 16);
        int i13 = i12 >>> 7;
        int i14 = i12 & 127;
        int i15 = this.f5455c;
        int i16 = i13 & i15;
        int i17 = 0;
        while (true) {
            long[] jArr3 = this.f5453a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j11 = ((jArr3[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr3[i18] >>> i19);
            long j12 = i14;
            int i20 = i14;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L);
            while (j14 != 0) {
                int iNumberOfTrailingZeros = (i16 + (Long.numberOfTrailingZeros(j14) >> 3)) & i15;
                int i21 = i11;
                if (q7.k.a(this.f5454b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j14 &= j14 - 1;
                i11 = i21;
            }
            int i22 = i11;
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iE = e(i13);
                long j15 = 255;
                if (this.f5457e != 0 || ((this.f5453a[iE >> 3] >> ((iE & 7) << 3)) & 255) == 254) {
                    j2 = 255;
                    j4 = j12;
                    j10 = 128;
                } else {
                    int i23 = this.f5455c;
                    if (i23 > 8) {
                        int i24 = 8;
                        if (Long.compareUnsigned(this.f5456d * 32, i23 * 25) <= 0) {
                            long[] jArr4 = this.f5453a;
                            int i25 = this.f5455c;
                            Object[] objArr2 = this.f5454b;
                            int i26 = (i25 + 7) >> 3;
                            int i27 = 0;
                            j10 = 128;
                            while (i27 < i26) {
                                long j16 = j15;
                                long j17 = jArr4[i27] & (-9187201950435737472L);
                                jArr4[i27] = (-72340172838076674L) & ((~j17) + (j17 >>> 7));
                                i27++;
                                i24 = i24;
                                j12 = j12;
                                j15 = j16;
                            }
                            j2 = j15;
                            j4 = j12;
                            int i28 = i24;
                            int iI0 = d7.n.i0(jArr4);
                            int i29 = iI0 - 1;
                            long j18 = 72057594037927935L;
                            jArr4[i29] = (jArr4[i29] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[iI0] = jArr4[0];
                            int i30 = 0;
                            while (i30 != i25) {
                                int i31 = i30 >> 3;
                                int i32 = (i30 & 7) << 3;
                                long j19 = (jArr4[i31] >> i32) & j2;
                                if (j19 != 128 && j19 == 254) {
                                    Object obj2 = objArr2[i30];
                                    int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i22;
                                    int i33 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                    int iE2 = e(i33);
                                    int i34 = i33 & i25;
                                    if (((iE2 - i34) & i25) / i28 == ((i30 - i34) & i25) / i28) {
                                        long j20 = j18;
                                        jArr4[i31] = ((r7 & 127) << i32) | ((~(j2 << i32)) & jArr4[i31]);
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j20) | Long.MIN_VALUE;
                                        i30++;
                                        j18 = j20;
                                    } else {
                                        long j21 = j18;
                                        int i35 = iE2 >> 3;
                                        long j22 = jArr4[i35];
                                        int i36 = (iE2 & 7) << 3;
                                        if (((j22 >> i36) & j2) == 128) {
                                            i10 = i28;
                                            i2 = i25;
                                            objArr = objArr2;
                                            jArr4[i35] = ((~(j2 << i36)) & j22) | ((r7 & 127) << i36);
                                            jArr4[i31] = (jArr4[i31] & (~(j2 << i32))) | (128 << i32);
                                            objArr[iE2] = objArr[i30];
                                            objArr[i30] = null;
                                        } else {
                                            i2 = i25;
                                            objArr = objArr2;
                                            i10 = i28;
                                            jArr4[i35] = ((r7 & 127) << i36) | ((~(j2 << i36)) & j22);
                                            Object obj3 = objArr[iE2];
                                            objArr[iE2] = objArr[i30];
                                            objArr[i30] = obj3;
                                            i30--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j21) | Long.MIN_VALUE;
                                        i30++;
                                        j18 = j21;
                                        i28 = i10;
                                        i25 = i2;
                                        objArr2 = objArr;
                                    }
                                } else {
                                    i30++;
                                }
                            }
                            this.f5457e = g0.a(this.f5455c) - this.f5456d;
                        }
                        iE = e(i13);
                    }
                    j2 = 255;
                    j4 = j12;
                    j10 = 128;
                    int iB = g0.b(this.f5455c);
                    long[] jArr5 = this.f5453a;
                    Object[] objArr3 = this.f5454b;
                    int i37 = this.f5455c;
                    f(iB);
                    long[] jArr6 = this.f5453a;
                    Object[] objArr4 = this.f5454b;
                    int i38 = this.f5455c;
                    int i39 = 0;
                    while (i39 < i37) {
                        if (((jArr5[i39 >> 3] >> ((i39 & 7) << 3)) & 255) < 128) {
                            Object obj4 = objArr3[i39];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i22;
                            int i40 = iHashCode3 ^ (iHashCode3 << 16);
                            int iE3 = e(i40 >>> 7);
                            long j23 = i40 & 127;
                            int i41 = iE3 >> 3;
                            int i42 = (iE3 & 7) << 3;
                            jArr = jArr6;
                            jArr2 = jArr5;
                            long j24 = (jArr6[i41] & (~(255 << i42))) | (j23 << i42);
                            jArr[i41] = j24;
                            jArr[(((iE3 - 7) & i38) + (i38 & 7)) >> 3] = j24;
                            objArr4[iE3] = obj4;
                        } else {
                            jArr = jArr6;
                            jArr2 = jArr5;
                        }
                        i39++;
                        jArr5 = jArr2;
                        jArr6 = jArr;
                    }
                    iE = e(i13);
                }
                this.f5456d++;
                int i43 = this.f5457e;
                long[] jArr7 = this.f5453a;
                int i44 = iE >> 3;
                long j25 = jArr7[i44];
                int i45 = (iE & 7) << 3;
                this.f5457e = i43 - (((j25 >> i45) & j2) == j10 ? 1 : 0);
                int i46 = this.f5455c;
                long j26 = (j25 & (~(j2 << i45))) | (j4 << i45);
                jArr7[i44] = j26;
                jArr7[(((iE - 7) & i46) + (i46 & 7)) >> 3] = j26;
                return iE;
            }
            i17 += 8;
            i16 = (i16 + i17) & i15;
            i14 = i20;
            i11 = i22;
        }
    }

    public final int e(int i2) {
        int i10 = this.f5455c;
        int i11 = i2 & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.f5453a;
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 1
            if (r15 != r14) goto L4
            return r0
        L4:
            boolean r1 = r15 instanceof k.b0
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            k.b0 r15 = (k.b0) r15
            int r1 = r15.f5456d
            int r3 = r14.f5456d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.lang.Object[] r1 = r14.f5454b
            long[] r14 = r14.f5453a
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L59
            r4 = r2
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L54
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L37:
            if (r9 >= r7) goto L52
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r10 = r15.c(r10)
            if (r10 != 0) goto L4e
            return r2
        L4e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L52:
            if (r7 != r8) goto L59
        L54:
            if (r4 == r3) goto L59
            int r4 = r4 + 1
            goto L1d
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b0.equals(java.lang.Object):boolean");
    }

    public final void f(int i2) {
        long[] jArr;
        int iMax = i2 > 0 ? Math.max(7, g0.c(i2)) : 0;
        this.f5455c = iMax;
        if (iMax == 0) {
            jArr = g0.f5491a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            d7.n.e0(jArr);
        }
        this.f5453a = jArr;
        int i10 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j2)) | j2;
        this.f5457e = g0.a(this.f5455c) - this.f5456d;
        this.f5454b = iMax == 0 ? l.a.f5726c : new Object[iMax];
    }

    public final boolean g() {
        return this.f5456d == 0;
    }

    public final boolean h() {
        return this.f5456d != 0;
    }

    public final int hashCode() {
        int iHashCode = (this.f5455c * 31) + this.f5456d;
        Object[] objArr = this.f5454b;
        long[] jArr = this.f5453a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j2 = jArr[i2];
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((255 & j2) < 128) {
                            Object obj = objArr[(i2 << 3) + i11];
                            if (!q7.k.a(obj, this)) {
                                iHashCode += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j2 >>= 8;
                    }
                    if (i10 != 8) {
                        return iHashCode;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return iHashCode;
    }

    public final void i(Object obj) {
        this.f5454b[d(obj)] = obj;
    }

    public final void j(b0 b0Var) {
        q7.k.e(b0Var, "elements");
        Object[] objArr = b0Var.f5454b;
        long[] jArr = b0Var.f5453a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        i(objArr[(i2 << 3) + i11]);
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0.f5455c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f5453a
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L47:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L66
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.f5454b
            r15 = r15[r11]
            boolean r15 = q7.k.a(r15, r1)
            if (r15 == 0) goto L60
            goto L70
        L60:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L47
        L66:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L79
            r11 = -1
        L70:
            if (r11 < 0) goto L73
            r2 = r12
        L73:
            if (r2 == 0) goto L78
            r0.l(r11)
        L78:
            return r2
        L79:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b0.k(java.lang.Object):boolean");
    }

    public final void l(int i2) {
        this.f5456d--;
        long[] jArr = this.f5453a;
        int i10 = this.f5455c;
        int i11 = i2 >> 3;
        int i12 = (i2 & 7) << 3;
        long j2 = (jArr[i11] & (~(255 << i12))) | (254 << i12);
        jArr[i11] = j2;
        jArr[(((i2 - 7) & i10) + (i10 & 7)) >> 3] = j2;
        this.f5454b[i2] = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[PHI: r7
      0x0066: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x0026, B:21:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "["
            r1.append(r2)
            java.lang.Object[] r2 = r0.f5454b
            long[] r3 = r0.f5453a
            int r4 = r3.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L6b
            r5 = 0
            r6 = r5
            r7 = r6
        L18:
            r8 = r3[r6]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L66
            int r10 = r6 - r4
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L32:
            if (r12 >= r10) goto L64
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L60
            int r13 = r6 << 3
            int r13 = r13 + r12
            r13 = r2[r13]
            r14 = -1
            if (r7 != r14) goto L4b
            java.lang.String r0 = "..."
            r1.append(r0)
            goto L70
        L4b:
            if (r7 == 0) goto L52
            java.lang.String r14 = ", "
            r1.append(r14)
        L52:
            if (r13 != r0) goto L57
            java.lang.String r13 = "(this)"
            goto L5b
        L57:
            java.lang.String r13 = java.lang.String.valueOf(r13)
        L5b:
            r1.append(r13)
            int r7 = r7 + 1
        L60:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L32
        L64:
            if (r10 != r11) goto L6b
        L66:
            if (r6 == r4) goto L6b
            int r6 = r6 + 1
            goto L18
        L6b:
            java.lang.String r0 = "]"
            r1.append(r0)
        L70:
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "toString(...)"
            q7.k.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b0.toString():java.lang.String");
    }

    public /* synthetic */ b0() {
        this(6);
    }
}
