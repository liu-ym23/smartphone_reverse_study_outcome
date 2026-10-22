package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends j {

    /* renamed from: f, reason: collision with root package name */
    public int f9631f;

    public u(int i) {
        this.f9580a = n0.f9597a;
        this.f9581b = l.f9589a;
        this.f9582c = q.a.f10066c;
        if (i >= 0) {
            f(n0.d(i));
        } else {
            g5.f.s("Capacity must be a positive value.");
            throw null;
        }
    }

    public final void c() {
        this.f9584e = 0;
        long[] jArr = this.f9580a;
        if (jArr != n0.f9597a) {
            kb.k.n0(jArr, -9187201950435737472L);
            long[] jArr2 = this.f9580a;
            int i = this.f9583d;
            int i3 = i >> 3;
            long j10 = 255 << ((i & 7) << 3);
            jArr2[i3] = (jArr2[i3] & (~j10)) | j10;
        }
        kb.k.m0(null, 0, this.f9582c, this.f9583d);
        this.f9631f = n0.a(this.f9583d) - this.f9584e;
    }

    public final int d(int i) {
        long j10;
        long j11;
        int i3;
        long j12;
        long[] jArr;
        long[] jArr2;
        int[] iArr;
        Object[] objArr;
        int i10;
        int i11 = -862048943;
        int iHashCode = Integer.hashCode(i) * (-862048943);
        int i12 = iHashCode ^ (iHashCode << 16);
        int i13 = i12 >>> 7;
        int i14 = i12 & 127;
        int i15 = this.f9583d;
        int i16 = i13 & i15;
        int i17 = 0;
        while (true) {
            long[] jArr3 = this.f9580a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            int i20 = 1;
            long j13 = ((jArr3[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr3[i18] >>> i19);
            long j14 = i14;
            int i21 = i17;
            int i22 = 0;
            long j15 = j13 ^ (j14 * 72340172838076673L);
            long j16 = (~j15) & (j15 - 72340172838076673L) & (-9187201950435737472L);
            while (j16 != 0) {
                int iNumberOfTrailingZeros = (i16 + (Long.numberOfTrailingZeros(j16) >> 3)) & i15;
                int i23 = i11;
                int i24 = i22;
                if (this.f9581b[iNumberOfTrailingZeros] == i) {
                    return iNumberOfTrailingZeros;
                }
                j16 &= j16 - 1;
                i11 = i23;
                i22 = i24;
            }
            int i25 = i11;
            int i26 = i22;
            if ((((~j13) << 6) & j13 & (-9187201950435737472L)) != 0) {
                int iE = e(i13);
                long j17 = 255;
                if (this.f9631f != 0 || ((this.f9580a[iE >> 3] >> ((iE & 7) << 3)) & 255) == 254) {
                    j10 = 255;
                    j11 = j14;
                    i3 = 1;
                    j12 = 128;
                } else {
                    int i27 = this.f9583d;
                    if (i27 > 8) {
                        j12 = 128;
                        if (Long.compareUnsigned(this.f9584e * 32, i27 * 25) <= 0) {
                            long[] jArr4 = this.f9580a;
                            int i28 = this.f9583d;
                            int[] iArr2 = this.f9581b;
                            Object[] objArr2 = this.f9582c;
                            int i29 = (i28 + 7) >> 3;
                            int i30 = i26;
                            while (i30 < i29) {
                                long j18 = j17;
                                long j19 = jArr4[i30] & (-9187201950435737472L);
                                jArr4[i30] = (-72340172838076674L) & ((~j19) + (j19 >>> 7));
                                i30++;
                                j14 = j14;
                                j17 = j18;
                            }
                            j10 = j17;
                            j11 = j14;
                            int iQ0 = kb.k.q0(jArr4);
                            int i31 = iQ0 - 1;
                            long j20 = 72057594037927935L;
                            jArr4[i31] = (jArr4[i31] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[iQ0] = jArr4[i26];
                            int i32 = i26;
                            while (i32 != i28) {
                                int i33 = i32 >> 3;
                                int i34 = (i32 & 7) << 3;
                                long j21 = (jArr4[i33] >> i34) & j10;
                                if (j21 != 128 && j21 == 254) {
                                    int iHashCode2 = Integer.hashCode(iArr2[i32]) * i25;
                                    int i35 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                    int iE2 = e(i35);
                                    int i36 = i35 & i28;
                                    if (((iE2 - i36) & i28) / 8 == ((i32 - i36) & i28) / 8) {
                                        long j22 = j20;
                                        jArr4[i33] = ((r8 & 127) << i34) | ((~(j10 << i34)) & jArr4[i33]);
                                        jArr4[jArr4.length - i20] = (jArr4[i26] & j22) | Long.MIN_VALUE;
                                        i32++;
                                        j20 = j22;
                                    } else {
                                        long j23 = j20;
                                        int i37 = iE2 >> 3;
                                        long j24 = jArr4[i37];
                                        int i38 = (iE2 & 7) << 3;
                                        if (((j24 >> i38) & j10) == 128) {
                                            i10 = i20;
                                            iArr = iArr2;
                                            objArr = objArr2;
                                            jArr4[i37] = ((~(j10 << i38)) & j24) | ((r8 & 127) << i38);
                                            jArr4[i33] = (jArr4[i33] & (~(j10 << i34))) | (128 << i34);
                                            iArr[iE2] = iArr[i32];
                                            iArr[i32] = i26;
                                            objArr[iE2] = objArr[i32];
                                            objArr[i32] = null;
                                        } else {
                                            iArr = iArr2;
                                            objArr = objArr2;
                                            i10 = i20;
                                            jArr4[i37] = ((r8 & 127) << i38) | ((~(j10 << i38)) & j24);
                                            int i39 = iArr[iE2];
                                            iArr[iE2] = iArr[i32];
                                            iArr[i32] = i39;
                                            Object obj = objArr[iE2];
                                            objArr[iE2] = objArr[i32];
                                            objArr[i32] = obj;
                                            i32--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[i26] & j23) | Long.MIN_VALUE;
                                        i32++;
                                        j20 = j23;
                                        i20 = i10;
                                        iArr2 = iArr;
                                        objArr2 = objArr;
                                    }
                                } else {
                                    i32++;
                                }
                            }
                            i3 = i20;
                            this.f9631f = n0.a(this.f9583d) - this.f9584e;
                        }
                        iE = e(i13);
                    } else {
                        j12 = 128;
                    }
                    j10 = 255;
                    j11 = j14;
                    i3 = 1;
                    int iB = n0.b(this.f9583d);
                    long[] jArr5 = this.f9580a;
                    int[] iArr3 = this.f9581b;
                    Object[] objArr3 = this.f9582c;
                    int i40 = this.f9583d;
                    f(iB);
                    long[] jArr6 = this.f9580a;
                    int[] iArr4 = this.f9581b;
                    Object[] objArr4 = this.f9582c;
                    int i41 = this.f9583d;
                    int i42 = i26;
                    while (i42 < i40) {
                        if (((jArr5[i42 >> 3] >> ((i42 & 7) << 3)) & 255) < j12) {
                            int i43 = iArr3[i42];
                            int iHashCode3 = Integer.hashCode(i43) * i25;
                            int i44 = iHashCode3 ^ (iHashCode3 << 16);
                            int iE3 = e(i44 >>> 7);
                            long j25 = i44 & 127;
                            int i45 = iE3 >> 3;
                            int i46 = (iE3 & 7) << 3;
                            jArr = jArr6;
                            jArr2 = jArr5;
                            long j26 = (jArr6[i45] & (~(255 << i46))) | (j25 << i46);
                            jArr[i45] = j26;
                            jArr[(((iE3 - 7) & i41) + (i41 & 7)) >> 3] = j26;
                            iArr4[iE3] = i43;
                            objArr4[iE3] = objArr3[i42];
                        } else {
                            jArr = jArr6;
                            jArr2 = jArr5;
                        }
                        i42++;
                        jArr5 = jArr2;
                        jArr6 = jArr;
                    }
                    iE = e(i13);
                }
                this.f9584e++;
                int i47 = this.f9631f;
                long[] jArr7 = this.f9580a;
                int i48 = iE >> 3;
                long j27 = jArr7[i48];
                int i49 = (iE & 7) << 3;
                if (((j27 >> i49) & j10) != j12) {
                    i3 = i26;
                }
                this.f9631f = i47 - i3;
                int i50 = this.f9583d;
                long j28 = (j27 & (~(j10 << i49))) | (j11 << i49);
                jArr7[i48] = j28;
                jArr7[(((iE - 7) & i50) + (i50 & 7)) >> 3] = j28;
                return iE;
            }
            i17 = i21 + 8;
            i16 = (i16 + i17) & i15;
            i11 = i25;
        }
    }

    public final int e(int i) {
        int i3 = this.f9583d;
        int i10 = i & i3;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f9580a;
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

    public final void f(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, n0.c(i)) : 0;
        this.f9583d = iMax;
        if (iMax == 0) {
            jArr = n0.f9597a;
        } else {
            int i3 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i3];
            Arrays.fill(jArr2, 0, i3, -9187201950435737472L);
            jArr = jArr2;
        }
        this.f9580a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        this.f9631f = n0.a(this.f9583d) - this.f9584e;
        this.f9581b = new int[iMax];
        this.f9582c = new Object[iMax];
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(int r14) {
        /*
            r13 = this;
            int r0 = java.lang.Integer.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f9583d
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.f9580a
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r4 = r4[r5]
            int r9 = 64 - r6
            long r4 = r4 << r9
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3e:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L59
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.f9581b
            r11 = r11[r10]
            if (r11 != r14) goto L53
            goto L63
        L53:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L59:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L96
            r10 = -1
        L63:
            r14 = 0
            if (r10 < 0) goto L95
            int r0 = r13.f9584e
            int r0 = r0 + (-1)
            r13.f9584e = r0
            long[] r0 = r13.f9580a
            int r1 = r13.f9583d
            int r2 = r10 >> 3
            r3 = r10 & 7
            int r3 = r3 << 3
            r4 = r0[r2]
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 << r3
            long r6 = ~r6
            long r4 = r4 & r6
            r6 = 254(0xfe, double:1.255E-321)
            long r6 = r6 << r3
            long r3 = r4 | r6
            r0[r2] = r3
            int r2 = r10 + (-7)
            r2 = r2 & r1
            r1 = r1 & 7
            int r2 = r2 + r1
            int r1 = r2 >> 3
            r0[r1] = r3
            java.lang.Object[] r13 = r13.f9582c
            r0 = r13[r10]
            r13[r10] = r14
            return r0
        L95:
            return r14
        L96:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: p.u.g(int):java.lang.Object");
    }

    public final void h(int i, Object obj) {
        int iD = d(i);
        this.f9581b[iD] = i;
        this.f9582c[iD] = obj;
    }

    public /* synthetic */ u() {
        this(6);
    }
}
