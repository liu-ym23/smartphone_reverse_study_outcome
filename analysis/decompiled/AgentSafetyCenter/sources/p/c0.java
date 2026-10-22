package p;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f9529a = n0.f9597a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f9530b = q.a.f10066c;

    /* renamed from: c, reason: collision with root package name */
    public long[] f9531c = o.f9599b;

    /* renamed from: d, reason: collision with root package name */
    public int f9532d = Reader.READ_DONE;

    /* renamed from: e, reason: collision with root package name */
    public int f9533e = Reader.READ_DONE;

    /* renamed from: f, reason: collision with root package name */
    public int f9534f;

    /* renamed from: g, reason: collision with root package name */
    public int f9535g;

    /* renamed from: h, reason: collision with root package name */
    public int f9536h;

    public c0(int i) {
        if (i >= 0) {
            f(n0.d(i));
        } else {
            g5.f.s("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean a(Object obj) {
        int i = this.f9535g;
        int iD = d(obj);
        this.f9530b[iD] = obj;
        long[] jArr = this.f9531c;
        int i3 = this.f9532d;
        jArr[iD] = (i3 & 2147483647L) | 4611686016279904256L;
        if (i3 != Integer.MAX_VALUE) {
            jArr[i3] = ((iD & 2147483647L) << 31) | (jArr[i3] & (-4611686016279904257L));
        }
        this.f9532d = iD;
        if (this.f9533e == Integer.MAX_VALUE) {
            this.f9533e = iD;
        }
        return this.f9535g != i;
    }

    public final void b() {
        this.f9535g = 0;
        long[] jArr = this.f9529a;
        if (jArr != n0.f9597a) {
            kb.k.n0(jArr, -9187201950435737472L);
            long[] jArr2 = this.f9529a;
            int i = this.f9534f;
            int i3 = i >> 3;
            long j10 = 255 << ((i & 7) << 3);
            jArr2[i3] = (jArr2[i3] & (~j10)) | j10;
        }
        kb.k.m0(null, 0, this.f9530b, this.f9534f);
        kb.k.n0(this.f9531c, 4611686018427387903L);
        this.f9532d = Reader.READ_DONE;
        this.f9533e = Reader.READ_DONE;
        this.f9536h = n0.a(this.f9534f) - this.f9535g;
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
            int r5 = r0.f9534f
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f9529a
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
            java.lang.Object[] r15 = r0.f9530b
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
        throw new UnsupportedOperationException("Method not decompiled: p.c0.c(java.lang.Object):boolean");
    }

    public final int d(Object obj) {
        int i;
        long j10;
        long j11;
        long j12;
        char c9;
        long[] jArr;
        long[] jArr2;
        long j13;
        int i3 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i10 = iHashCode ^ (iHashCode << 16);
        int i11 = i10 >>> 7;
        int i12 = i10 & 127;
        int i13 = this.f9534f;
        int i14 = i11 & i13;
        int i15 = 0;
        while (true) {
            long[] jArr3 = this.f9529a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j14 = ((jArr3[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr3[i16] >>> i17);
            long j15 = i12;
            long j16 = j14 ^ (j15 * 72340172838076673L);
            long j17 = (j16 - 72340172838076673L) & (~j16) & (-9187201950435737472L);
            while (j17 != 0) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j17) >> 3) + i14) & i13;
                int i18 = i3;
                if (yb.k.a(this.f9530b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j17 &= j17 - 1;
                i3 = i18;
            }
            int i19 = i3;
            if ((j14 & ((~j14) << 6) & (-9187201950435737472L)) != 0) {
                int iE = e(i11);
                long j18 = 255;
                if (this.f9536h != 0 || ((this.f9529a[iE >> 3] >> ((iE & 7) << 3)) & 255) == 254) {
                    i = 0;
                    j10 = j15;
                    j11 = 255;
                    j12 = 128;
                } else {
                    int i20 = this.f9534f;
                    if (i20 > 8) {
                        c9 = 31;
                        j12 = 128;
                        if (Long.compareUnsigned(this.f9535g * 32, i20 * 25) <= 0) {
                            long[] jArr4 = this.f9529a;
                            if (jArr4 == null) {
                                i = 0;
                                j10 = j15;
                                j11 = 255;
                            } else {
                                int i21 = this.f9534f;
                                Object[] objArr = this.f9530b;
                                long[] jArr5 = this.f9531c;
                                long[] jArr6 = new long[i21];
                                Arrays.fill(jArr6, 0, i21, 9223372034707292159L);
                                i = 0;
                                int i22 = (i21 + 7) >> 3;
                                int i23 = 0;
                                while (i23 < i22) {
                                    long j19 = j18;
                                    long j20 = jArr4[i23] & (-9187201950435737472L);
                                    int i24 = i23;
                                    jArr4[i24] = ((~j20) + (j20 >>> 7)) & (-72340172838076674L);
                                    i23 = i24 + 1;
                                    j18 = j19;
                                }
                                j11 = j18;
                                int length = jArr4.length;
                                int i25 = length - 1;
                                int i26 = length - 2;
                                jArr4[i26] = (jArr4[i26] & 72057594037927935L) | (-72057594037927936L);
                                jArr4[i25] = jArr4[0];
                                int i27 = 0;
                                while (i27 != i21) {
                                    int i28 = i27 >> 3;
                                    int i29 = (i27 & 7) << 3;
                                    long j21 = (jArr4[i28] >> i29) & j11;
                                    if (j21 != 128 && j21 == 254) {
                                        Object obj2 = objArr[i27];
                                        int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i19;
                                        int i30 = (iHashCode2 ^ (iHashCode2 << 16)) >>> 7;
                                        int iE2 = e(i30);
                                        int i31 = i30 & i21;
                                        if (((iE2 - i31) & i21) / 8 == ((i27 - i31) & i21) / 8) {
                                            int i32 = i21;
                                            Object[] objArr2 = objArr;
                                            jArr4[i28] = (jArr4[i28] & (~(j11 << i29))) | ((r17 & 127) << i29);
                                            if (jArr6[i27] == 9223372034707292159L) {
                                                long j22 = i27;
                                                jArr6[i27] = j22 | (j22 << 32);
                                            }
                                            jArr4[jArr4.length - 1] = jArr4[0];
                                            i27++;
                                            i21 = i32;
                                            objArr = objArr2;
                                        } else {
                                            int i33 = i21;
                                            Object[] objArr3 = objArr;
                                            int i34 = iE2 >> 3;
                                            long j23 = jArr4[i34];
                                            int i35 = (iE2 & 7) << 3;
                                            if (((j23 >> i35) & j11) == 128) {
                                                jArr4[i34] = (j23 & (~(j11 << i35))) | ((r17 & 127) << i35);
                                                jArr4[i28] = (jArr4[i28] & (~(j11 << i29))) | (128 << i29);
                                                objArr3[iE2] = objArr3[i27];
                                                objArr3[i27] = null;
                                                jArr5[iE2] = jArr5[i27];
                                                jArr5[i27] = 4611686018427387903L;
                                                int i36 = (int) ((jArr6[i27] >> 32) & 4294967295L);
                                                int i37 = Reader.READ_DONE;
                                                if (i36 != Integer.MAX_VALUE) {
                                                    j13 = j15;
                                                    jArr6[i36] = iE2 | (jArr6[i36] & (-4294967296L));
                                                    jArr6[i27] = (jArr6[i27] & 4294967295L) | (-4294967296L);
                                                    i37 = Reader.READ_DONE;
                                                } else {
                                                    j13 = j15;
                                                    jArr6[i27] = (Reader.READ_DONE << 32) | iE2;
                                                }
                                                jArr6[iE2] = (i27 << 32) | i37;
                                            } else {
                                                j13 = j15;
                                                jArr4[i34] = ((r17 & 127) << i35) | (j23 & (~(j11 << i35)));
                                                Object obj3 = objArr3[iE2];
                                                objArr3[iE2] = objArr3[i27];
                                                objArr3[i27] = obj3;
                                                long j24 = jArr5[iE2];
                                                jArr5[iE2] = jArr5[i27];
                                                jArr5[i27] = j24;
                                                int i38 = (int) ((jArr6[i27] >> 32) & 4294967295L);
                                                if (i38 != Integer.MAX_VALUE) {
                                                    long j25 = iE2;
                                                    jArr6[i38] = (jArr6[i38] & (-4294967296L)) | j25;
                                                    jArr6[i27] = (jArr6[i27] & 4294967295L) | (j25 << 32);
                                                } else {
                                                    long j26 = iE2;
                                                    jArr6[i27] = j26 | (j26 << 32);
                                                    i38 = i27;
                                                }
                                                jArr6[iE2] = (i38 << 32) | i27;
                                                i27--;
                                            }
                                            jArr4[jArr4.length - 1] = jArr4[0];
                                            i27++;
                                            i21 = i33;
                                            objArr = objArr3;
                                            j15 = j13;
                                        }
                                    } else {
                                        i27++;
                                    }
                                }
                                j10 = j15;
                                this.f9536h = n0.a(this.f9534f) - this.f9535g;
                                long[] jArr7 = this.f9531c;
                                int length2 = jArr7.length;
                                for (int i39 = 0; i39 < length2; i39++) {
                                    long j27 = jArr7[i39];
                                    jArr7[i39] = (((j27 & (-4611686018427387904L)) | (((int) ((j27 >> 31) & 2147483647L)) == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr6[r4] & 4294967295L))) << 31) | (((int) (j27 & 2147483647L)) == Integer.MAX_VALUE ? Reader.READ_DONE : (int) (jArr6[r6] & 4294967295L));
                                }
                                int i40 = this.f9532d;
                                if (i40 != Integer.MAX_VALUE) {
                                    this.f9532d = (int) (jArr6[i40] & 4294967295L);
                                }
                                int i41 = this.f9533e;
                                if (i41 != Integer.MAX_VALUE) {
                                    this.f9533e = (int) (jArr6[i41] & 4294967295L);
                                }
                            }
                        }
                        iE = e(i11);
                    } else {
                        c9 = 31;
                        j12 = 128;
                    }
                    i = 0;
                    j10 = j15;
                    j11 = 255;
                    int iB = n0.b(this.f9534f);
                    long[] jArr8 = this.f9529a;
                    Object[] objArr4 = this.f9530b;
                    long[] jArr9 = this.f9531c;
                    int i42 = this.f9534f;
                    int[] iArr = new int[i42];
                    f(iB);
                    long[] jArr10 = this.f9529a;
                    Object[] objArr5 = this.f9530b;
                    long[] jArr11 = this.f9531c;
                    int i43 = this.f9534f;
                    int i44 = 0;
                    while (i44 < i42) {
                        if (((jArr8[i44 >> 3] >> ((i44 & 7) << 3)) & 255) < j12) {
                            Object obj4 = objArr4[i44];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i19;
                            int i45 = iHashCode3 ^ (iHashCode3 << 16);
                            int iE3 = e(i45 >>> 7);
                            jArr = jArr10;
                            jArr2 = jArr8;
                            long j28 = i45 & 127;
                            int i46 = iE3 >> 3;
                            int i47 = (iE3 & 7) << 3;
                            long j29 = (jArr[i46] & (~(255 << i47))) | (j28 << i47);
                            jArr[i46] = j29;
                            jArr[(((iE3 - 7) & i43) + (i43 & 7)) >> 3] = j29;
                            objArr5[iE3] = obj4;
                            jArr11[iE3] = jArr9[i44];
                            iArr[i44] = iE3;
                        } else {
                            jArr = jArr10;
                            jArr2 = jArr8;
                        }
                        i44++;
                        jArr8 = jArr2;
                        jArr10 = jArr;
                    }
                    long[] jArr12 = this.f9531c;
                    int length3 = jArr12.length;
                    for (int i48 = 0; i48 < length3; i48++) {
                        long j30 = jArr12[i48];
                        jArr12[i48] = (((j30 & (-4611686018427387904L)) | (((int) ((j30 >> c9) & 2147483647L)) == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[r4])) << c9) | (((int) (j30 & 2147483647L)) == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[r6]);
                    }
                    int i49 = this.f9532d;
                    if (i49 != Integer.MAX_VALUE) {
                        this.f9532d = iArr[i49];
                    }
                    int i50 = this.f9533e;
                    if (i50 != Integer.MAX_VALUE) {
                        this.f9533e = iArr[i50];
                    }
                    iE = e(i11);
                }
                this.f9535g++;
                int i51 = this.f9536h;
                long[] jArr13 = this.f9529a;
                int i52 = iE >> 3;
                long j31 = jArr13[i52];
                int i53 = (iE & 7) << 3;
                if (((j31 >> i53) & j11) == j12) {
                    i = 1;
                }
                this.f9536h = i51 - i;
                int i54 = this.f9534f;
                long j32 = (j31 & (~(j11 << i53))) | (j10 << i53);
                jArr13[i52] = j32;
                jArr13[(((iE - 7) & i54) + (i54 & 7)) >> 3] = j32;
                return iE;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
            i3 = i19;
        }
    }

    public final int e(int i) {
        int i3 = this.f9534f;
        int i10 = i & i3;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f9529a;
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
            boolean r1 = r15 instanceof p.c0
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            p.c0 r15 = (p.c0) r15
            int r1 = r15.f9535g
            int r3 = r14.f9535g
            if (r1 == r3) goto L13
            return r2
        L13:
            java.lang.Object[] r1 = r14.f9530b
            long[] r14 = r14.f9529a
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
        throw new UnsupportedOperationException("Method not decompiled: p.c0.equals(java.lang.Object):boolean");
    }

    public final void f(int i) {
        long[] jArr;
        long[] jArr2;
        int iMax = i > 0 ? Math.max(7, n0.c(i)) : 0;
        this.f9534f = iMax;
        if (iMax == 0) {
            jArr = n0.f9597a;
        } else {
            int i3 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr3 = new long[i3];
            Arrays.fill(jArr3, 0, i3, -9187201950435737472L);
            jArr = jArr3;
        }
        this.f9529a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        this.f9536h = n0.a(this.f9534f) - this.f9535g;
        this.f9530b = iMax == 0 ? q.a.f10066c : new Object[iMax];
        if (iMax == 0) {
            jArr2 = o.f9599b;
        } else {
            long[] jArr4 = new long[iMax];
            Arrays.fill(jArr4, 0, iMax, 4611686018427387903L);
            jArr2 = jArr4;
        }
        this.f9531c = jArr2;
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
    public final boolean g(java.lang.Object r18) {
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
            int r5 = r0.f9534f
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f9529a
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
            java.lang.Object[] r15 = r0.f9530b
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
            r0.h(r11)
        L78:
            return r2
        L79:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: p.c0.g(java.lang.Object):boolean");
    }

    public final void h(int i) {
        this.f9535g--;
        long[] jArr = this.f9529a;
        int i3 = this.f9534f;
        int i10 = i >> 3;
        int i11 = (i & 7) << 3;
        long j10 = (jArr[i10] & (~(255 << i11))) | (254 << i11);
        jArr[i10] = j10;
        jArr[(((i - 7) & i3) + (i3 & 7)) >> 3] = j10;
        this.f9530b[i] = null;
        long[] jArr2 = this.f9531c;
        long j11 = jArr2[i];
        int i12 = (int) ((j11 >> 31) & 2147483647L);
        int i13 = (int) (j11 & 2147483647L);
        if (i12 != Integer.MAX_VALUE) {
            jArr2[i12] = (jArr2[i12] & (-2147483648L)) | (i13 & 2147483647L);
        } else {
            this.f9532d = i13;
        }
        if (i13 != Integer.MAX_VALUE) {
            jArr2[i13] = ((i12 & 2147483647L) << 31) | (jArr2[i13] & (-4611686016279904257L));
        } else {
            this.f9533e = i12;
        }
        jArr2[i] = 4611686018427387903L;
    }

    public final int hashCode() {
        int iHashCode = (this.f9534f * 31) + this.f9535g;
        Object[] objArr = this.f9530b;
        long[] jArr = this.f9529a;
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(java.util.Collection r17) {
        /*
            r16 = this;
            r0 = r16
            r17.getClass()
            java.lang.Object[] r1 = r0.f9530b
            int r2 = r0.f9535g
            long[] r3 = r0.f9529a
            int r4 = r3.length
            int r4 = r4 + (-2)
            r5 = 0
            if (r4 < 0) goto L54
            r6 = r5
        L12:
            r7 = r3[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L4f
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r5
        L2c:
            if (r11 >= r9) goto L4d
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L49
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r17
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r14 = r1[r12]
            boolean r13 = kb.l.s0(r13, r14)
            if (r13 != 0) goto L49
            r0.h(r12)
        L49:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L2c
        L4d:
            if (r9 != r10) goto L54
        L4f:
            if (r6 == r4) goto L54
            int r6 = r6 + 1
            goto L12
        L54:
            int r0 = r0.f9535g
            if (r2 == r0) goto L5a
            r0 = 1
            return r0
        L5a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.c0.i(java.util.Collection):boolean");
    }

    public final String toString() {
        a2.m mVar = new a2.m(this, 7);
        StringBuilder sb2 = new StringBuilder("[");
        Object[] objArr = this.f9530b;
        long[] jArr = this.f9531c;
        int i = this.f9533e;
        int i3 = 0;
        while (true) {
            if (i == Integer.MAX_VALUE) {
                sb2.append((CharSequence) "]");
                break;
            }
            int i10 = (int) ((jArr[i] >> 31) & 2147483647L);
            Object obj = objArr[i];
            if (i3 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append((CharSequence) mVar.invoke(obj));
            i3++;
            i = i10;
        }
        return sb2.toString();
    }
}
