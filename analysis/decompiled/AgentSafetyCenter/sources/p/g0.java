package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f9560a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f9561b;

    /* renamed from: c, reason: collision with root package name */
    public int f9562c;

    /* renamed from: d, reason: collision with root package name */
    public int f9563d;

    /* renamed from: e, reason: collision with root package name */
    public int f9564e;

    public g0(int i) {
        this.f9560a = n0.f9597a;
        this.f9561b = q.a.f10066c;
        if (i >= 0) {
            f(n0.d(i));
        } else {
            g5.f.s("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean a(Object obj) {
        int i = this.f9563d;
        this.f9561b[d(obj)] = obj;
        return this.f9563d != i;
    }

    public final void b() {
        this.f9563d = 0;
        long[] jArr = this.f9560a;
        if (jArr != n0.f9597a) {
            kb.k.n0(jArr, -9187201950435737472L);
            long[] jArr2 = this.f9560a;
            int i = this.f9562c;
            int i3 = i >> 3;
            long j10 = 255 << ((i & 7) << 3);
            jArr2[i3] = (jArr2[i3] & (~j10)) | j10;
        }
        kb.k.m0(null, 0, this.f9561b, this.f9562c);
        this.f9564e = n0.a(this.f9562c) - this.f9563d;
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
            int r5 = r0.f9562c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f9560a
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
            java.lang.Object[] r15 = r0.f9561b
            r15 = r15[r11]
            boolean r15 = yb.k.a(r15, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p.g0.c(java.lang.Object):boolean");
    }

    public final int d(Object obj) {
        long j10;
        long j11;
        long j12;
        long[] jArr;
        long[] jArr2;
        int i;
        Object[] objArr;
        int i3;
        int i10 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f9562c;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr3 = this.f9560a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j13 = ((jArr3[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr3[i17] >>> i18);
            long j14 = i13;
            int i19 = i13;
            long j15 = j13 ^ (j14 * 72340172838076673L);
            long j16 = (~j15) & (j15 - 72340172838076673L) & (-9187201950435737472L);
            while (j16 != 0) {
                int iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j16) >> 3)) & i14;
                int i20 = i10;
                if (yb.k.a(this.f9561b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j16 &= j16 - 1;
                i10 = i20;
            }
            int i21 = i10;
            if ((((~j13) << 6) & j13 & (-9187201950435737472L)) != 0) {
                int iE = e(i12);
                long j17 = 255;
                if (this.f9564e != 0 || ((this.f9560a[iE >> 3] >> ((iE & 7) << 3)) & 255) == 254) {
                    j10 = 255;
                    j11 = j14;
                    j12 = 128;
                } else {
                    int i22 = this.f9562c;
                    if (i22 > 8) {
                        int i23 = 8;
                        if (Long.compareUnsigned(this.f9563d * 32, i22 * 25) <= 0) {
                            long[] jArr4 = this.f9560a;
                            int i24 = this.f9562c;
                            Object[] objArr2 = this.f9561b;
                            int i25 = (i24 + 7) >> 3;
                            int i26 = 0;
                            j12 = 128;
                            while (i26 < i25) {
                                long j18 = j17;
                                long j19 = jArr4[i26] & (-9187201950435737472L);
                                jArr4[i26] = (-72340172838076674L) & ((~j19) + (j19 >>> 7));
                                i26++;
                                i23 = i23;
                                j14 = j14;
                                j17 = j18;
                            }
                            j10 = j17;
                            j11 = j14;
                            int i27 = i23;
                            int iQ0 = kb.k.q0(jArr4);
                            int i28 = iQ0 - 1;
                            long j20 = 72057594037927935L;
                            jArr4[i28] = (jArr4[i28] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[iQ0] = jArr4[0];
                            int i29 = 0;
                            while (i29 != i24) {
                                int i30 = i29 >> 3;
                                int i31 = (i29 & 7) << 3;
                                long j21 = (jArr4[i30] >> i31) & j10;
                                if (j21 != 128 && j21 == 254) {
                                    Object obj2 = objArr2[i29];
                                    int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i21;
                                    int i32 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                    int iE2 = e(i32);
                                    int i33 = i32 & i24;
                                    if (((iE2 - i33) & i24) / i27 == ((i29 - i33) & i24) / i27) {
                                        long j22 = j20;
                                        jArr4[i30] = ((r7 & 127) << i31) | ((~(j10 << i31)) & jArr4[i30]);
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j22) | Long.MIN_VALUE;
                                        i29++;
                                        j20 = j22;
                                    } else {
                                        long j23 = j20;
                                        int i34 = iE2 >> 3;
                                        long j24 = jArr4[i34];
                                        int i35 = (iE2 & 7) << 3;
                                        if (((j24 >> i35) & j10) == 128) {
                                            i3 = i27;
                                            i = i24;
                                            objArr = objArr2;
                                            jArr4[i34] = ((~(j10 << i35)) & j24) | ((r7 & 127) << i35);
                                            jArr4[i30] = (jArr4[i30] & (~(j10 << i31))) | (128 << i31);
                                            objArr[iE2] = objArr[i29];
                                            objArr[i29] = null;
                                        } else {
                                            i = i24;
                                            objArr = objArr2;
                                            i3 = i27;
                                            jArr4[i34] = ((r7 & 127) << i35) | ((~(j10 << i35)) & j24);
                                            Object obj3 = objArr[iE2];
                                            objArr[iE2] = objArr[i29];
                                            objArr[i29] = obj3;
                                            i29--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j23) | Long.MIN_VALUE;
                                        i29++;
                                        j20 = j23;
                                        i27 = i3;
                                        i24 = i;
                                        objArr2 = objArr;
                                    }
                                } else {
                                    i29++;
                                }
                            }
                            this.f9564e = n0.a(this.f9562c) - this.f9563d;
                        }
                        iE = e(i12);
                    }
                    j10 = 255;
                    j11 = j14;
                    j12 = 128;
                    int iB = n0.b(this.f9562c);
                    long[] jArr5 = this.f9560a;
                    Object[] objArr3 = this.f9561b;
                    int i36 = this.f9562c;
                    f(iB);
                    long[] jArr6 = this.f9560a;
                    Object[] objArr4 = this.f9561b;
                    int i37 = this.f9562c;
                    int i38 = 0;
                    while (i38 < i36) {
                        if (((jArr5[i38 >> 3] >> ((i38 & 7) << 3)) & 255) < 128) {
                            Object obj4 = objArr3[i38];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i21;
                            int i39 = iHashCode3 ^ (iHashCode3 << 16);
                            int iE3 = e(i39 >>> 7);
                            long j25 = i39 & 127;
                            int i40 = iE3 >> 3;
                            int i41 = (iE3 & 7) << 3;
                            jArr = jArr6;
                            jArr2 = jArr5;
                            long j26 = (jArr6[i40] & (~(255 << i41))) | (j25 << i41);
                            jArr[i40] = j26;
                            jArr[(((iE3 - 7) & i37) + (i37 & 7)) >> 3] = j26;
                            objArr4[iE3] = obj4;
                        } else {
                            jArr = jArr6;
                            jArr2 = jArr5;
                        }
                        i38++;
                        jArr5 = jArr2;
                        jArr6 = jArr;
                    }
                    iE = e(i12);
                }
                this.f9563d++;
                int i42 = this.f9564e;
                long[] jArr7 = this.f9560a;
                int i43 = iE >> 3;
                long j27 = jArr7[i43];
                int i44 = (iE & 7) << 3;
                this.f9564e = i42 - (((j27 >> i44) & j10) == j12 ? 1 : 0);
                int i45 = this.f9562c;
                long j28 = (j27 & (~(j10 << i44))) | (j11 << i44);
                jArr7[i43] = j28;
                jArr7[(((iE - 7) & i45) + (i45 & 7)) >> 3] = j28;
                return iE;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
            i10 = i21;
        }
    }

    public final int e(int i) {
        int i3 = this.f9562c;
        int i10 = i & i3;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f9560a;
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
            boolean r1 = r15 instanceof p.g0
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            p.g0 r15 = (p.g0) r15
            int r1 = r15.f9563d
            int r3 = r14.f9563d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.lang.Object[] r1 = r14.f9561b
            long[] r14 = r14.f9560a
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
        throw new UnsupportedOperationException("Method not decompiled: p.g0.equals(java.lang.Object):boolean");
    }

    public final void f(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, n0.c(i)) : 0;
        this.f9562c = iMax;
        if (iMax == 0) {
            jArr = n0.f9597a;
        } else {
            int i3 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i3];
            Arrays.fill(jArr2, 0, i3, -9187201950435737472L);
            jArr = jArr2;
        }
        this.f9560a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        this.f9564e = n0.a(this.f9562c) - this.f9563d;
        this.f9561b = iMax == 0 ? q.a.f10066c : new Object[iMax];
    }

    public final boolean g() {
        return this.f9563d == 0;
    }

    public final boolean h() {
        return this.f9563d != 0;
    }

    public final int hashCode() {
        int iHashCode = (this.f9562c * 31) + this.f9563d;
        Object[] objArr = this.f9561b;
        long[] jArr = this.f9560a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j10 = jArr[i];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i3; i10++) {
                        if ((255 & j10) < 128) {
                            Object obj = objArr[(i << 3) + i10];
                            if (!yb.k.a(obj, this)) {
                                iHashCode += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j10 >>= 8;
                    }
                    if (i3 != 8) {
                        return iHashCode;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return iHashCode;
    }

    public final void i(Object obj) {
        this.f9561b[d(obj)] = obj;
    }

    public final void j(g0 g0Var) {
        g0Var.getClass();
        Object[] objArr = g0Var.f9561b;
        long[] jArr = g0Var.f9560a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        i(objArr[(i << 3) + i10]);
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
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
            int r5 = r0.f9562c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f9560a
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
            java.lang.Object[] r15 = r0.f9561b
            r15 = r15[r11]
            boolean r15 = yb.k.a(r15, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p.g0.k(java.lang.Object):boolean");
    }

    public final void l(int i) {
        this.f9563d--;
        long[] jArr = this.f9560a;
        int i3 = this.f9562c;
        int i10 = i >> 3;
        int i11 = (i & 7) << 3;
        long j10 = (jArr[i10] & (~(255 << i11))) | (254 << i11);
        jArr[i10] = j10;
        jArr[(((i - 7) & i3) + (i3 & 7)) >> 3] = j10;
        this.f9561b[i] = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[PHI: r7
      0x0067: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x002a, B:18:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            a2.m r1 = new a2.m
            r2 = 8
            r1.<init>(r0, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "["
            r2.<init>(r3)
            java.lang.Object[] r3 = r0.f9561b
            long[] r0 = r0.f9560a
            int r4 = r0.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L6c
            r5 = 0
            r6 = r5
            r7 = r6
        L1c:
            r8 = r0[r6]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L67
            int r10 = r6 - r4
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L36:
            if (r12 >= r10) goto L65
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L61
            int r13 = r6 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            r14 = -1
            if (r7 != r14) goto L4f
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L71
        L4f:
            if (r7 == 0) goto L56
            java.lang.String r14 = ", "
            r2.append(r14)
        L56:
            java.lang.Object r13 = r1.invoke(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r2.append(r13)
            int r7 = r7 + 1
        L61:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L36
        L65:
            if (r10 != r11) goto L6c
        L67:
            if (r6 == r4) goto L6c
            int r6 = r6 + 1
            goto L1c
        L6c:
            java.lang.String r0 = "]"
            r2.append(r0)
        L71:
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.g0.toString():java.lang.String");
    }

    public /* synthetic */ g0() {
        this(6);
    }
}
