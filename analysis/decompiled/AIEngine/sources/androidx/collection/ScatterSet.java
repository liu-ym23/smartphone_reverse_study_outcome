package androidx.collection;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ScatterSet<E> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f972a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f973b;

    /* renamed from: c, reason: collision with root package name */
    public int f974c;

    /* renamed from: d, reason: collision with root package name */
    public int f975d;

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
    
        r25 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        if (((((~r10) << 6) & r10) & (-9187201950435737472L)) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d6, code lost:
    
        r23 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = (this.f974c * 31) + this.f975d;
        Object[] objArr = this.f973b;
        long[] jArr = this.f972a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j10 = jArr[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j10) < 128) {
                            Object obj = objArr[(i10 << 3) + i12];
                            if (!g.b(obj, this)) {
                                iHashCode += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j10 >>= 8;
                    }
                    if (i11 != 8) {
                        return iHashCode;
                    }
                }
                if (i10 == length) {
                    break;
                }
                i10++;
            }
        }
        return iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[PHI: r7
      0x0065: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x0028, B:18:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            androidx.collection.ScatterSet$toString$1 r1 = new androidx.collection.ScatterSet$toString$1
            r1.<init>(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "["
            r2.<init>(r3)
            java.lang.Object[] r3 = r0.f973b
            long[] r0 = r0.f972a
            int r4 = r0.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L6a
            r5 = 0
            r6 = r5
            r7 = r6
        L1a:
            r8 = r0[r6]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L65
            int r10 = r6 - r4
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L34:
            if (r12 >= r10) goto L63
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L5f
            int r13 = r6 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            r14 = -1
            if (r7 != r14) goto L4d
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L6f
        L4d:
            if (r7 == 0) goto L54
            java.lang.String r14 = ", "
            r2.append(r14)
        L54:
            java.lang.Object r13 = r1.invoke(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r2.append(r13)
            int r7 = r7 + 1
        L5f:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L34
        L63:
            if (r10 != r11) goto L6a
        L65:
            if (r6 == r4) goto L6a
            int r6 = r6 + 1
            goto L1a
        L6a:
            java.lang.String r0 = "]"
            r2.append(r0)
        L6f:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.g.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.toString():java.lang.String");
    }
}
