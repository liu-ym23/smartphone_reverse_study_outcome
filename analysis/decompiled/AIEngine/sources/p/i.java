package p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public long[] f11374a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f11375b;

    /* renamed from: c, reason: collision with root package name */
    public int f11376c;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bf, code lost:
    
        r29 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c9, code lost:
    
        if (((r2 & ((~r2) << 6)) & (-9187201950435737472L)) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cb, code lost:
    
        r10 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long[] jArr = this.f11375b;
        long[] jArr2 = this.f11374a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int iHashCode = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        iHashCode = Long.hashCode(jArr[(i10 << 3) + i12]) + iHashCode;
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return iHashCode;
                }
            }
            if (i10 == length) {
                return iHashCode;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[PHI: r5
      0x005b: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:6:0x0024, B:18:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r15 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "["
            r0.append(r1)
            long[] r1 = r15.f11375b
            long[] r15 = r15.f11374a
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L60
            r3 = 0
            r4 = r3
            r5 = r4
        L16:
            r6 = r15[r4]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L5b
            int r8 = r4 - r2
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r3
        L30:
            if (r10 >= r8) goto L59
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L55
            int r11 = r4 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            r13 = -1
            if (r5 != r13) goto L49
            java.lang.String r15 = "..."
            r0.append(r15)
            goto L65
        L49:
            if (r5 == 0) goto L50
            java.lang.String r13 = ", "
            r0.append(r13)
        L50:
            r0.append(r11)
            int r5 = r5 + 1
        L55:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L30
        L59:
            if (r8 != r9) goto L60
        L5b:
            if (r4 == r2) goto L60
            int r4 = r4 + 1
            goto L16
        L60:
            java.lang.String r15 = "]"
            r0.append(r15)
        L65:
            java.lang.String r15 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.g.e(r15, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p.i.toString():java.lang.String");
    }
}
