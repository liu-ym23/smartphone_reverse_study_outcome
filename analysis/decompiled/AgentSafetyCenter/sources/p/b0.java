package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f9519a = n0.f9597a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f9520b = q.a.f10066c;

    /* renamed from: c, reason: collision with root package name */
    public long[] f9521c = m.f9591a;

    /* renamed from: d, reason: collision with root package name */
    public int f9522d;

    /* renamed from: e, reason: collision with root package name */
    public int f9523e;

    /* renamed from: f, reason: collision with root package name */
    public int f9524f;

    public b0(int i) {
        if (i >= 0) {
            d(n0.d(i));
        } else {
            g5.f.s("Capacity must be a positive value.");
            throw null;
        }
    }

    public final int a(int i) {
        int i3 = this.f9522d;
        int i10 = i & i3;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f9519a;
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

    public final int b(Object obj) {
        int i = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i10 = i3 & 127;
        int i11 = this.f9522d;
        int i12 = i3 >>> 7;
        while (true) {
            int i13 = i12 & i11;
            long[] jArr = this.f9519a;
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j10 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j11 = (i10 * 72340172838076673L) ^ j10;
            for (long j12 = (~j11) & (j11 - 72340172838076673L) & (-9187201950435737472L); j12 != 0; j12 &= j12 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j12) >> 3) + i13) & i11;
                if (yb.k.a(this.f9520b[iNumberOfTrailingZeros], obj)) {
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

    public final long c(Object obj) {
        int iB = b(obj);
        if (iB >= 0) {
            return this.f9521c[iB];
        }
        od.f.f("There is no key ", obj, " in the map");
        return 0L;
    }

    public final void d(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, n0.c(i)) : 0;
        this.f9522d = iMax;
        if (iMax == 0) {
            jArr = n0.f9597a;
        } else {
            int i3 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i3];
            Arrays.fill(jArr2, 0, i3, -9187201950435737472L);
            jArr = jArr2;
        }
        this.f9519a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        this.f9524f = n0.a(this.f9522d) - this.f9523e;
        this.f9520b = new Object[iMax];
        this.f9521c = new long[iMax];
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0071, code lost:
    
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x007f, code lost:
    
        r2 = a(r4);
        r11 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0087, code lost:
    
        if (r39.f9524f != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:
    
        if (((r39.f9519a[r2 >> 3] >> ((r2 & 7) << 3)) & 255) != 254) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009d, code lost:
    
        r29 = r9;
        r27 = 255;
        r18 = 1;
        r34 = 0;
        r22 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
    
        r2 = r39.f9522d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ad, code lost:
    
        if (r2 <= 8) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00af, code lost:
    
        r22 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c1, code lost:
    
        if (java.lang.Long.compareUnsigned(r39.f9523e * 32, r2 * 25) > 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c3, code lost:
    
        r2 = r39.f9519a;
        r3 = r39.f9522d;
        r5 = r39.f9520b;
        r6 = r39.f9521c;
        r13 = (r3 + 7) >> 3;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d2, code lost:
    
        if (r7 >= r13) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d4, code lost:
    
        r8 = r2[r7] & (-9187201950435737472L);
        r2[r7] = (-72340172838076674L) & ((~r8) + (r8 >>> 7));
        r7 = r7 + 1;
        r11 = r11;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f0, code lost:
    
        r29 = r9;
        r27 = r11;
        r12 = 7;
        r7 = kb.k.q0(r2);
        r8 = r7 - 1;
        r2[r8] = (r2[r8] & 72057594037927935L) | (-72057594037927936L);
        r2[r7] = r2[0];
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x010f, code lost:
    
        if (r7 == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0111, code lost:
    
        r8 = r7 >> 3;
        r11 = (r7 & 7) << 3;
        r9 = (r2[r8] >> r11) & r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011e, code lost:
    
        if (r9 != 128) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0120, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0125, code lost:
    
        if (r9 == 254) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0128, code lost:
    
        r9 = r5[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x012a, code lost:
    
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x012c, code lost:
    
        r9 = r9.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0131, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0132, code lost:
    
        r9 = r9 * r21;
        r10 = (r9 ^ (r9 << 16)) >>> 7;
        r13 = a(r10);
        r10 = r10 & r3;
        r31 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x014d, code lost:
    
        if ((((r13 - r10) & r3) / 8) != (((r7 - r10) & r3) / 8)) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014f, code lost:
    
        r34 = r15;
        r2[r8] = ((r9 & 127) << r11) | (r2[r8] & (~(r27 << r11)));
        r2[r2.length - 1] = (r2[r34] & 72057594037927935L) | Long.MIN_VALUE;
        r7 = r7 + 1;
        r14 = r14;
        r12 = r31;
        r15 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0174, code lost:
    
        r18 = r14;
        r34 = r15;
        r10 = r13 >> 3;
        r14 = r2[r10];
        r12 = (r13 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0186, code lost:
    
        if (((r14 >> r12) & r27) != 128) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0188, code lost:
    
        r35 = r5;
        r36 = r6;
        r2[r10] = ((~(r27 << r12)) & r14) | ((r9 & 127) << r12);
        r2[r8] = (r2[r8] & (~(r27 << r11))) | (128 << r11);
        r35[r13] = r35[r7];
        r35[r7] = null;
        r36[r13] = r36[r7];
        r36[r7] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01b3, code lost:
    
        r35 = r5;
        r36 = r6;
        r2[r10] = ((r9 & 127) << r12) | ((~(r27 << r12)) & r14);
        r5 = r35[r13];
        r35[r13] = r35[r7];
        r35[r7] = r5;
        r5 = r36[r13];
        r36[r13] = r36[r7];
        r36[r7] = r5;
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01d4, code lost:
    
        r2[r2.length - 1] = (r2[r34] & 72057594037927935L) | Long.MIN_VALUE;
        r7 = r7 + 1;
        r14 = r18;
        r12 = r31;
        r15 = r34;
        r5 = r35;
        r6 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01ed, code lost:
    
        r18 = r14;
        r34 = r15;
        r39.f9524f = p.n0.a(r39.f9522d) - r39.f9523e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0200, code lost:
    
        r29 = r9;
        r27 = 255;
        r18 = 1;
        r34 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x020b, code lost:
    
        r22 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x020e, code lost:
    
        r2 = p.n0.b(r39.f9522d);
        r3 = r39.f9519a;
        r5 = r39.f9520b;
        r6 = r39.f9521c;
        r7 = r39.f9522d;
        d(r2);
        r2 = r39.f9519a;
        r8 = r39.f9520b;
        r9 = r39.f9521c;
        r10 = r39.f9522d;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0229, code lost:
    
        if (r11 >= r7) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0238, code lost:
    
        if (((r3[r11 >> 3] >> ((r11 & 7) << 3)) & 255) >= r22) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x023a, code lost:
    
        r12 = r5[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023c, code lost:
    
        if (r12 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x023e, code lost:
    
        r13 = r12.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0243, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0245, code lost:
    
        r13 = r13 * r21;
        r13 = r13 ^ (r13 << 16);
        r14 = a(r13 >>> 7);
        r15 = r2;
        r1 = r13 & 127;
        r13 = r14 >> 3;
        r16 = (r14 & 7) << 3;
        r1 = (r15[r13] & (~(255 << r16))) | (r1 << r16);
        r15[r13] = r1;
        r15[(((r14 - 7) & r10) + (r10 & 7)) >> 3] = r1;
        r8[r14] = r12;
        r9[r14] = r6[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x027b, code lost:
    
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x027c, code lost:
    
        r11 = r11 + 1;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0282, code lost:
    
        r2 = a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0286, code lost:
    
        r39.f9523e++;
        r1 = r39.f9524f;
        r3 = r39.f9519a;
        r4 = r2 >> 3;
        r5 = r3[r4];
        r7 = (r2 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x029e, code lost:
    
        if (((r5 >> r7) & r27) != r22) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02a1, code lost:
    
        r18 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02a3, code lost:
    
        r39.f9524f = r1 - r18;
        r1 = r39.f9522d;
        r5 = (r5 & (~(r27 << r7))) | (r29 << r7);
        r3[r4] = r5;
        r3[(((r2 - 7) & r1) + (r1 & 7)) >> 3] = r5;
        r13 = ~r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r40, long r41) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.b0.e(java.lang.Object, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
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
            boolean r3 = r1 instanceof p.b0
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            p.b0 r1 = (p.b0) r1
            int r3 = r1.f9523e
            int r5 = r0.f9523e
            if (r3 == r5) goto L17
            return r4
        L17:
            java.lang.Object[] r3 = r0.f9520b
            long[] r5 = r0.f9521c
            long[] r0 = r0.f9519a
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L69
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
            if (r10 == 0) goto L64
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L3d:
            if (r12 >= r10) goto L62
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L5e
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r15 = r5[r13]
            int r13 = r1.b(r14)
            if (r13 < 0) goto L5d
            long[] r14 = r1.f9521c
            r13 = r14[r13]
            int r13 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r13 == 0) goto L5e
        L5d:
            return r4
        L5e:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L3d
        L62:
            if (r10 != r11) goto L69
        L64:
            if (r7 == r6) goto L69
            int r7 = r7 + 1
            goto L23
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p.b0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Object[] objArr = this.f9520b;
        long[] jArr = this.f9521c;
        long[] jArr2 = this.f9519a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j10 = jArr2[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(jArr[i11]);
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

    public final String toString() {
        int i;
        int i3;
        if (this.f9523e == 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder("{");
        Object[] objArr = this.f9520b;
        long[] jArr = this.f9521c;
        long[] jArr2 = this.f9519a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                long j10 = jArr2[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j10) < 128) {
                            int i14 = (i10 << 3) + i13;
                            Object obj = objArr[i14];
                            i3 = i10;
                            long j11 = jArr[i14];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb2.append(obj);
                            sb2.append("=");
                            sb2.append(j11);
                            i11++;
                            if (i11 < this.f9523e) {
                                sb2.append(", ");
                            }
                        } else {
                            i3 = i10;
                        }
                        j10 >>= 8;
                        i13++;
                        i10 = i3;
                    }
                    int i15 = i10;
                    if (i12 != 8) {
                        break;
                    }
                    i = i15;
                } else {
                    i = i10;
                }
                if (i == length) {
                    break;
                }
                i10 = i + 1;
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
