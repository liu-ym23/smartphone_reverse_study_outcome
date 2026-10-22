package l0;

import java.util.HashMap;
import k.b0;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final c6.d f5772a = new c6.d(22);

    /* renamed from: b, reason: collision with root package name */
    public static final i5.l f5773b = new i5.l(15);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5774c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static k f5775d;

    /* renamed from: e, reason: collision with root package name */
    public static long f5776e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f5777f;

    /* renamed from: g, reason: collision with root package name */
    public static final ab.x f5778g;

    /* renamed from: h, reason: collision with root package name */
    public static Object f5779h;

    /* renamed from: i, reason: collision with root package name */
    public static Object f5780i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f5781j;

    /* renamed from: k, reason: collision with root package name */
    public static final j0.a f5782k;

    static {
        k kVar = k.f5764j;
        f5775d = kVar;
        long j2 = 1;
        f5776e = j2 + j2;
        i iVar = new i();
        iVar.f5755c = new long[16];
        iVar.f5756d = new int[16];
        int[] iArr = new int[16];
        int i2 = 0;
        while (i2 < 16) {
            int i10 = i2 + 1;
            iArr[i2] = i10;
            i2 = i10;
        }
        iVar.f5757e = iArr;
        f5777f = iVar;
        ab.x xVar = new ab.x(3, (byte) 0);
        xVar.f669c = new int[16];
        xVar.f670d = new j0.l[16];
        f5778g = xVar;
        d7.z zVar = d7.z.f2978f;
        f5779h = zVar;
        f5780i = zVar;
        long j4 = f5776e;
        f5776e = j2 + j4;
        a aVar = new a(j4, kVar, null, new c6.d(21));
        f5775d = f5775d.j(aVar.f5749b);
        f5781j = aVar;
        f5782k = new j0.a(0);
    }

    public static final void a() {
        f(f5772a);
    }

    public static final p7.k b(p7.k kVar, p7.k kVar2) {
        return (kVar == null || kVar2 == null || kVar == kVar2) ? kVar == null ? kVar2 : kVar : new l(kVar, kVar2, 1);
    }

    public static final HashMap c(long j2, b bVar, k kVar) {
        long[] jArr;
        k kVar2;
        long[] jArr2;
        k kVar3;
        int i2;
        x xVarS;
        long j4 = j2;
        b0 b0VarX = bVar.x();
        if (b0VarX != null) {
            k kVarI = bVar.d().j(bVar.g()).i(bVar.f5738j);
            Object[] objArr = b0VarX.f5454b;
            long[] jArr3 = b0VarX.f5453a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i10 = 0;
                HashMap map = null;
                while (true) {
                    long j10 = jArr3[i10];
                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i11 = 8;
                        int i12 = 8 - ((~(i10 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j10 & 255) < 128) {
                                v vVar = (v) objArr[(i10 << 3) + i13];
                                x xVarA = vVar.a();
                                jArr2 = jArr3;
                                i2 = i11;
                                x xVarS2 = s(xVarA, j4, kVar);
                                if (xVarS2 == null || (xVarS = s(xVarA, j4, kVarI)) == null || xVarS2.equals(xVarS)) {
                                    kVar3 = kVarI;
                                } else {
                                    kVar3 = kVarI;
                                    x xVarS3 = s(xVarA, bVar.g(), bVar.d());
                                    if (xVarS3 == null) {
                                        r();
                                        throw null;
                                    }
                                    x xVarH = vVar.h(xVarS, xVarS2, xVarS3);
                                    if (xVarH == null) {
                                        return null;
                                    }
                                    if (map == null) {
                                        map = new HashMap();
                                    }
                                    map.put(xVarS2, xVarH);
                                    map = map;
                                }
                            } else {
                                jArr2 = jArr3;
                                kVar3 = kVarI;
                                i2 = i11;
                            }
                            j10 >>= i2;
                            i13++;
                            j4 = j2;
                            i11 = i2;
                            jArr3 = jArr2;
                            kVarI = kVar3;
                        }
                        jArr = jArr3;
                        kVar2 = kVarI;
                        if (i12 != i11) {
                            return map;
                        }
                    } else {
                        jArr = jArr3;
                        kVar2 = kVarI;
                    }
                    if (i10 == length) {
                        return map;
                    }
                    i10++;
                    j4 = j2;
                    jArr3 = jArr;
                    kVarI = kVar2;
                }
            }
        }
        return null;
    }

    public static final void d(f fVar) {
        long j2;
        if (f5775d.h(fVar.g())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("Snapshot is not open: snapshotId=");
        sb2.append(fVar.g());
        sb2.append(", disposed=");
        sb2.append(fVar.f5750c);
        sb2.append(", applied=");
        b bVar = fVar instanceof b ? (b) fVar : null;
        sb2.append(bVar != null ? Boolean.valueOf(bVar.f5741m) : "read-only");
        sb2.append(", lowestPin=");
        synchronized (f5774c) {
            i iVar = f5777f;
            j2 = iVar.f5753a > 0 ? ((long[]) iVar.f5755c)[0] : -1L;
        }
        sb2.append(j2);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public static final k e(k kVar, long j2, long j4) {
        while (q7.k.g(j2, j4) < 0) {
            kVar = kVar.j(j2);
            j2++;
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(p7.k r15) {
        /*
            l0.a r0 = l0.m.f5781j
            java.lang.Object r1 = l0.m.f5774c
            monitor-enter(r1)
            k.b0 r2 = r0.f5736h     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto L13
            j0.a r3 = l0.m.f5782k     // Catch: java.lang.Throwable -> L10
            r4 = 1
            r3.addAndGet(r4)     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r15 = move-exception
            goto L97
        L13:
            java.lang.Object r15 = v(r0, r15)     // Catch: java.lang.Throwable -> L10
            monitor-exit(r1)
            r1 = 0
            if (r2 == 0) goto L44
            r3 = -1
            java.lang.Object r4 = l0.m.f5779h     // Catch: java.lang.Throwable -> L36
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L36
            r6 = r1
        L23:
            if (r6 >= r5) goto L38
            java.lang.Object r7 = r4.get(r6)     // Catch: java.lang.Throwable -> L36
            p7.n r7 = (p7.n) r7     // Catch: java.lang.Throwable -> L36
            d0.h r8 = new d0.h     // Catch: java.lang.Throwable -> L36
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L36
            r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L36
            int r6 = r6 + 1
            goto L23
        L36:
            r15 = move-exception
            goto L3e
        L38:
            j0.a r0 = l0.m.f5782k
            r0.addAndGet(r3)
            goto L44
        L3e:
            j0.a r0 = l0.m.f5782k
            r0.addAndGet(r3)
            throw r15
        L44:
            java.lang.Object r0 = l0.m.f5774c
            monitor-enter(r0)
            g()     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L93
            java.lang.Object[] r3 = r2.f5454b     // Catch: java.lang.Throwable -> L86
            long[] r2 = r2.f5453a     // Catch: java.lang.Throwable -> L86
            int r4 = r2.length     // Catch: java.lang.Throwable -> L86
            int r4 = r4 + (-2)
            if (r4 < 0) goto L93
            r5 = r1
        L56:
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L86
            long r8 = ~r6     // Catch: java.lang.Throwable -> L86
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L8e
            int r8 = r5 - r4
            int r8 = ~r8     // Catch: java.lang.Throwable -> L86
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r1
        L70:
            if (r10 >= r8) goto L8c
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L88
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r3[r11]     // Catch: java.lang.Throwable -> L86
            l0.v r11 = (l0.v) r11     // Catch: java.lang.Throwable -> L86
            q(r11)     // Catch: java.lang.Throwable -> L86
            goto L88
        L86:
            r15 = move-exception
            goto L95
        L88:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L70
        L8c:
            if (r8 != r9) goto L93
        L8e:
            if (r5 == r4) goto L93
            int r5 = r5 + 1
            goto L56
        L93:
            monitor-exit(r0)
            return r15
        L95:
            monitor-exit(r0)
            throw r15
        L97:
            monitor-exit(r1)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.m.f(p7.k):java.lang.Object");
    }

    public static final void g() {
        ab.x xVar = f5778g;
        int i2 = xVar.f668b;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= i2) {
                break;
            }
            j0.l lVar = ((j0.l[]) xVar.f670d)[i10];
            Object obj = lVar != null ? lVar.get() : null;
            if (obj != null && p((v) obj)) {
                if (i11 != i10) {
                    ((j0.l[]) xVar.f670d)[i11] = lVar;
                    int[] iArr = (int[]) xVar.f669c;
                    iArr[i11] = iArr[i10];
                }
                i11++;
            }
            i10++;
        }
        for (int i12 = i11; i12 < i2; i12++) {
            ((j0.l[]) xVar.f670d)[i12] = null;
            ((int[]) xVar.f669c)[i12] = 0;
        }
        if (i11 != i2) {
            xVar.f668b = i11;
        }
    }

    public static final f h(f fVar, p7.k kVar, boolean z4) {
        boolean z10 = fVar instanceof b;
        if (z10 || fVar == null) {
            return new z(z10 ? (b) fVar : null, kVar, null, false, z4);
        }
        return new a0(fVar, kVar, false, z4);
    }

    public static final x i(x xVar) {
        x xVarS;
        f fVarK = k();
        x xVarS2 = s(xVar, fVarK.g(), fVarK.d());
        if (xVarS2 != null) {
            return xVarS2;
        }
        synchronized (f5774c) {
            f fVarK2 = k();
            xVarS = s(xVar, fVarK2.g(), fVarK2.d());
        }
        if (xVarS != null) {
            return xVarS;
        }
        r();
        throw null;
    }

    public static final x j(x xVar, f fVar) {
        x xVarS;
        x xVarS2 = s(xVar, fVar.g(), fVar.d());
        if (xVarS2 != null) {
            return xVarS2;
        }
        synchronized (f5774c) {
            xVarS = s(xVar, fVar.g(), fVar.d());
        }
        if (xVarS != null) {
            return xVarS;
        }
        r();
        throw null;
    }

    public static final f k() {
        f fVar = (f) f5773b.z();
        return fVar == null ? f5781j : fVar;
    }

    public static final p7.k l(p7.k kVar, p7.k kVar2, boolean z4) {
        if (!z4) {
            kVar2 = null;
        }
        return (kVar == null || kVar2 == null || kVar == kVar2) ? kVar == null ? kVar2 : kVar : new l(kVar, kVar2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r3 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final l0.x m(l0.x r10, l0.v r11) {
        /*
            l0.x r0 = r11.a()
            long r1 = l0.m.f5776e
            l0.i r3 = l0.m.f5777f
            int r4 = r3.f5753a
            if (r4 <= 0) goto L13
            java.lang.Object r1 = r3.f5755c
            long[] r1 = (long[]) r1
            r2 = 0
            r1 = r1[r2]
        L13:
            r3 = 1
            long r3 = (long) r3
            long r1 = r1 - r3
            r3 = 0
            r4 = r3
        L18:
            if (r0 == 0) goto L4a
            long r5 = r0.f5813a
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L23
            goto L43
        L23:
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L47
            int r7 = q7.k.g(r5, r1)
            if (r7 > 0) goto L47
            l0.k r7 = l0.k.f5764j
            boolean r5 = r7.h(r5)
            if (r5 != 0) goto L47
            if (r4 != 0) goto L39
            r4 = r0
            goto L47
        L39:
            long r1 = r0.f5813a
            long r5 = r4.f5813a
            int r1 = q7.k.g(r1, r5)
            if (r1 >= 0) goto L45
        L43:
            r3 = r0
            goto L4a
        L45:
            r3 = r4
            goto L4a
        L47:
            l0.x r0 = r0.f5814b
            goto L18
        L4a:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 == 0) goto L54
            r3.f5813a = r0
            return r3
        L54:
            l0.x r10 = r10.b(r0)
            l0.x r0 = r11.a()
            r10.f5814b = r0
            r11.f(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.m.m(l0.x, l0.v):l0.x");
    }

    public static final void n(f fVar, v vVar) {
        fVar.t(fVar.h() + 1);
        p7.k kVarI = fVar.i();
        if (kVarI != null) {
            kVarI.invoke(vVar);
        }
    }

    public static final x o(x xVar, w wVar, f fVar, x xVar2) {
        x xVarM;
        if (fVar.f()) {
            fVar.n(wVar);
        }
        long jG = fVar.g();
        if (xVar2.f5813a == jG) {
            return xVar2;
        }
        synchronized (f5774c) {
            xVarM = m(xVar, wVar);
        }
        xVarM.f5813a = jG;
        if (xVar2.f5813a != 1) {
            fVar.n(wVar);
        }
        return xVarM;
    }

    public static final boolean p(v vVar) {
        x xVar;
        long j2 = f5776e;
        i iVar = f5777f;
        if (iVar.f5753a > 0) {
            j2 = ((long[]) iVar.f5755c)[0];
        }
        x xVar2 = null;
        x xVarA = null;
        int i2 = 0;
        for (x xVarA2 = vVar.a(); xVarA2 != null; xVarA2 = xVarA2.f5814b) {
            long j4 = xVarA2.f5813a;
            if (j4 != 0) {
                if (q7.k.g(j4, j2) >= 0) {
                    i2++;
                } else if (xVar2 == null) {
                    i2++;
                    xVar2 = xVarA2;
                } else {
                    if (q7.k.g(xVarA2.f5813a, xVar2.f5813a) < 0) {
                        xVar = xVar2;
                        xVar2 = xVarA2;
                    } else {
                        xVar = xVarA2;
                    }
                    if (xVarA == null) {
                        xVarA = vVar.a();
                        x xVar3 = xVarA;
                        while (true) {
                            if (xVarA == null) {
                                xVarA = xVar3;
                                break;
                            }
                            if (q7.k.g(xVarA.f5813a, j2) >= 0) {
                                break;
                            }
                            if (q7.k.g(xVar3.f5813a, xVarA.f5813a) < 0) {
                                xVar3 = xVarA;
                            }
                            xVarA = xVarA.f5814b;
                        }
                    }
                    xVar2.f5813a = 0L;
                    xVar2.a(xVarA);
                    xVar2 = xVar;
                }
            }
        }
        return i2 > 1;
    }

    public static final void q(v vVar) {
        if (p(vVar)) {
            ab.x xVar = f5778g;
            int i2 = xVar.f668b;
            int iIdentityHashCode = System.identityHashCode(vVar);
            int i10 = -1;
            if (i2 > 0) {
                int i11 = xVar.f668b - 1;
                int i12 = 0;
                while (true) {
                    if (i12 > i11) {
                        i10 = -(i12 + 1);
                        break;
                    }
                    int i13 = (i12 + i11) >>> 1;
                    int i14 = ((int[]) xVar.f669c)[i13];
                    if (i14 < iIdentityHashCode) {
                        i12 = i13 + 1;
                    } else if (i14 > iIdentityHashCode) {
                        i11 = i13 - 1;
                    } else {
                        j0.l lVar = ((j0.l[]) xVar.f670d)[i13];
                        if (vVar == (lVar != null ? lVar.get() : null)) {
                            i10 = i13;
                        } else {
                            for (int i15 = i13 - 1; -1 < i15 && ((int[]) xVar.f669c)[i15] == iIdentityHashCode; i15--) {
                                j0.l lVar2 = ((j0.l[]) xVar.f670d)[i15];
                                if ((lVar2 != null ? lVar2.get() : null) == vVar) {
                                    i10 = i15;
                                    break;
                                }
                            }
                            i13++;
                            int i16 = xVar.f668b;
                            while (true) {
                                if (i13 >= i16) {
                                    i10 = -(xVar.f668b + 1);
                                    break;
                                } else {
                                    if (((int[]) xVar.f669c)[i13] != iIdentityHashCode) {
                                        i10 = -(i13 + 1);
                                        break;
                                    }
                                    j0.l lVar3 = ((j0.l[]) xVar.f670d)[i13];
                                    if ((lVar3 != null ? lVar3.get() : null) == vVar) {
                                        break;
                                    } else {
                                        i13++;
                                    }
                                }
                            }
                            i10 = i13;
                        }
                    }
                }
                if (i10 >= 0) {
                    return;
                }
            }
            int i17 = -(i10 + 1);
            j0.l[] lVarArr = (j0.l[]) xVar.f670d;
            int length = lVarArr.length;
            if (i2 == length) {
                int i18 = length * 2;
                j0.l[] lVarArr2 = new j0.l[i18];
                int[] iArr = new int[i18];
                int i19 = i17 + 1;
                System.arraycopy(lVarArr, i17, lVarArr2, i19, i2 - i17);
                System.arraycopy((j0.l[]) xVar.f670d, 0, lVarArr2, 0, i17);
                d7.n.W((int[]) xVar.f669c, iArr, i19, i17, i2);
                d7.n.Z((int[]) xVar.f669c, iArr, 0, i17, 6);
                xVar.f670d = lVarArr2;
                xVar.f669c = iArr;
            } else {
                int i20 = i17 + 1;
                System.arraycopy(lVarArr, i17, lVarArr, i20, i2 - i17);
                int[] iArr2 = (int[]) xVar.f669c;
                d7.n.W(iArr2, iArr2, i20, i17, i2);
            }
            ((j0.l[]) xVar.f670d)[i17] = new j0.l(vVar);
            ((int[]) xVar.f669c)[i17] = iIdentityHashCode;
            xVar.f668b++;
        }
    }

    public static final void r() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final x s(x xVar, long j2, k kVar) {
        x xVar2 = null;
        while (xVar != null) {
            long j4 = xVar.f5813a;
            if (j4 != 0 && q7.k.g(j4, j2) <= 0 && !kVar.h(j4) && (xVar2 == null || q7.k.g(xVar2.f5813a, xVar.f5813a) < 0)) {
                xVar2 = xVar;
            }
            xVar = xVar.f5814b;
        }
        if (xVar2 != null) {
            return xVar2;
        }
        return null;
    }

    public static final x t(x xVar, v vVar) {
        x xVarS;
        f fVarK = k();
        p7.k kVarE = fVarK.e();
        if (kVarE != null) {
            kVarE.invoke(vVar);
        }
        x xVarS2 = s(xVar, fVarK.g(), fVarK.d());
        if (xVarS2 != null) {
            return xVarS2;
        }
        synchronized (f5774c) {
            f fVarK2 = k();
            x xVarA = vVar.a();
            q7.k.c(xVarA, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            xVarS = s(xVarA, fVarK2.g(), fVarK2.d());
            if (xVarS == null) {
                r();
                throw null;
            }
        }
        return xVarS;
    }

    public static final void u(int i2) {
        i iVar = f5777f;
        int i10 = ((int[]) iVar.f5757e)[i2];
        iVar.c(i10, iVar.f5753a - 1);
        iVar.f5753a--;
        long[] jArr = (long[]) iVar.f5755c;
        long j2 = jArr[i10];
        int i11 = i10;
        while (i11 > 0) {
            int i12 = ((i11 + 1) >> 1) - 1;
            if (q7.k.g(jArr[i12], j2) <= 0) {
                break;
            }
            iVar.c(i12, i11);
            i11 = i12;
        }
        long[] jArr2 = (long[]) iVar.f5755c;
        int i13 = iVar.f5753a >> 1;
        while (i10 < i13) {
            int i14 = (i10 + 1) << 1;
            int i15 = i14 - 1;
            if (i14 < iVar.f5753a && q7.k.g(jArr2[i14], jArr2[i15]) < 0) {
                if (q7.k.g(jArr2[i14], jArr2[i10]) >= 0) {
                    break;
                }
                iVar.c(i14, i10);
                i10 = i14;
            } else {
                if (q7.k.g(jArr2[i15], jArr2[i10]) >= 0) {
                    break;
                }
                iVar.c(i15, i10);
                i10 = i15;
            }
        }
        ((int[]) iVar.f5757e)[i2] = iVar.f5754b;
        iVar.f5754b = i2;
    }

    public static final Object v(a aVar, p7.k kVar) {
        long j2 = aVar.f5749b;
        Object objInvoke = kVar.invoke(f5775d.f(j2));
        long j4 = f5776e;
        f5776e = 1 + j4;
        k kVarF = f5775d.f(j2);
        f5775d = kVarF;
        aVar.f5749b = j4;
        aVar.f5748a = kVarF;
        aVar.f5735g = 0;
        aVar.f5736h = null;
        aVar.o();
        f5775d = f5775d.j(j4);
        return objInvoke;
    }

    public static final x w(x xVar, v vVar, f fVar) {
        x xVarS;
        if (fVar.f()) {
            fVar.n(vVar);
        }
        long jG = fVar.g();
        x xVarS2 = s(xVar, jG, fVar.d());
        if (xVarS2 == null) {
            r();
            throw null;
        }
        if (xVarS2.f5813a == fVar.g()) {
            return xVarS2;
        }
        synchronized (f5774c) {
            xVarS = s(vVar.a(), jG, fVar.d());
            if (xVarS == null) {
                r();
                throw null;
            }
            if (xVarS.f5813a != jG) {
                x xVarM = m(xVarS, vVar);
                xVarM.a(xVarS);
                xVarM.f5813a = fVar.g();
                xVarS = xVarM;
            }
        }
        if (xVarS2.f5813a != 1) {
            fVar.n(vVar);
        }
        return xVarS;
    }
}
