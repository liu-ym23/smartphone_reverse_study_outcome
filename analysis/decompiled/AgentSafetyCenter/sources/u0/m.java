package u0;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import p.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final t0.d f13674a = new t0.d(3);

    /* renamed from: b, reason: collision with root package name */
    public static final p5.m f13675b = new p5.m();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f13676c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static k f13677d;

    /* renamed from: e, reason: collision with root package name */
    public static long f13678e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f13679f;

    /* renamed from: g, reason: collision with root package name */
    public static final b2.a f13680g;

    /* renamed from: h, reason: collision with root package name */
    public static Object f13681h;
    public static Object i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f13682j;

    /* renamed from: k, reason: collision with root package name */
    public static final s0.a f13683k;

    static {
        k kVar = k.i;
        f13677d = kVar;
        long j10 = 1;
        f13678e = j10 + j10;
        i iVar = new i();
        iVar.f13659c = new long[16];
        iVar.f13660d = new int[16];
        int[] iArr = new int[16];
        int i3 = 0;
        while (i3 < 16) {
            int i10 = i3 + 1;
            iArr[i3] = i10;
            i3 = i10;
        }
        iVar.f13661e = iArr;
        f13679f = iVar;
        b2.a aVar = new b2.a(4);
        aVar.f1861c = new int[16];
        aVar.f1862d = new s0.l[16];
        f13680g = aVar;
        kb.s sVar = kb.s.f7404c;
        f13681h = sVar;
        i = sVar;
        long j11 = f13678e;
        f13678e = j10 + j11;
        a aVar2 = new a(j11, kVar, null, new t0.d(2));
        f13677d = f13677d.e(aVar2.f13653b);
        f13682j = aVar2;
        f13683k = new s0.a(0);
    }

    public static final void a() {
        f(f13674a);
    }

    public static final xb.l b(xb.l lVar, xb.l lVar2) {
        if (lVar == null || lVar2 == null || lVar == lVar2) {
            return lVar == null ? lVar2 : lVar;
        }
        l lVar3 = new l(1);
        lVar3.f13672f = lVar;
        lVar3.f13673g = lVar2;
        VarHandle.storeStoreFence();
        return lVar3;
    }

    public static final HashMap c(long j10, b bVar, k kVar) {
        long[] jArr;
        k kVar2;
        long[] jArr2;
        k kVar3;
        int i3;
        x xVarS;
        long j11 = j10;
        g0 g0VarX = bVar.x();
        if (g0VarX != null) {
            k kVarD = bVar.d().e(bVar.g()).d(bVar.f13642j);
            Object[] objArr = g0VarX.f9561b;
            long[] jArr3 = g0VarX.f9560a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i10 = 0;
                HashMap map = null;
                while (true) {
                    long j12 = jArr3[i10];
                    if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i11 = 8;
                        int i12 = 8 - ((~(i10 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j12 & 255) < 128) {
                                v vVar = (v) objArr[(i10 << 3) + i13];
                                x xVarA = vVar.a();
                                jArr2 = jArr3;
                                i3 = i11;
                                x xVarS2 = s(xVarA, j11, kVar);
                                if (xVarS2 == null || (xVarS = s(xVarA, j11, kVarD)) == null || xVarS2.equals(xVarS)) {
                                    kVar3 = kVarD;
                                } else {
                                    kVar3 = kVarD;
                                    x xVarS3 = s(xVarA, bVar.g(), bVar.d());
                                    if (xVarS3 == null) {
                                        r();
                                        throw null;
                                    }
                                    x xVarD = vVar.d(xVarS, xVarS2, xVarS3);
                                    if (xVarD == null) {
                                        return null;
                                    }
                                    if (map == null) {
                                        map = new HashMap();
                                    }
                                    map.put(xVarS2, xVarD);
                                    map = map;
                                }
                            } else {
                                jArr2 = jArr3;
                                kVar3 = kVarD;
                                i3 = i11;
                            }
                            j12 >>= i3;
                            i13++;
                            j11 = j10;
                            i11 = i3;
                            jArr3 = jArr2;
                            kVarD = kVar3;
                        }
                        jArr = jArr3;
                        kVar2 = kVarD;
                        if (i12 != i11) {
                            return map;
                        }
                    } else {
                        jArr = jArr3;
                        kVar2 = kVarD;
                    }
                    if (i10 == length) {
                        return map;
                    }
                    i10++;
                    j11 = j10;
                    jArr3 = jArr;
                    kVarD = kVar2;
                }
            }
        }
        return null;
    }

    public static final void d(f fVar) {
        long j10;
        if (f13677d.c(fVar.g())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("Snapshot is not open: snapshotId=");
        sb2.append(fVar.g());
        sb2.append(", disposed=");
        sb2.append(fVar.f13654c);
        sb2.append(", applied=");
        b bVar = fVar instanceof b ? (b) fVar : null;
        sb2.append(bVar != null ? Boolean.valueOf(bVar.f13645m) : "read-only");
        sb2.append(", lowestPin=");
        synchronized (f13676c) {
            i iVar = f13679f;
            j10 = iVar.f13657a > 0 ? ((long[]) iVar.f13659c)[0] : -1L;
        }
        sb2.append(j10);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public static final k e(k kVar, long j10, long j11) {
        while (yb.k.c(j10, j11) < 0) {
            kVar = kVar.e(j10);
            j10++;
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(xb.l r15) {
        /*
            u0.a r0 = u0.m.f13682j
            java.lang.Object r1 = u0.m.f13676c
            monitor-enter(r1)
            p.g0 r2 = r0.f13641h     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto L13
            s0.a r3 = u0.m.f13683k     // Catch: java.lang.Throwable -> L10
            r4 = 1
            r3.addAndGet(r4)     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r15 = move-exception
            goto L96
        L13:
            java.lang.Object r15 = v(r0, r15)     // Catch: java.lang.Throwable -> L10
            monitor-exit(r1)
            r1 = 0
            if (r2 == 0) goto L43
            r3 = -1
            java.lang.Object r4 = u0.m.f13681h     // Catch: java.lang.Throwable -> L35
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L35
            r6 = r1
        L23:
            if (r6 >= r5) goto L37
            java.lang.Object r7 = r4.get(r6)     // Catch: java.lang.Throwable -> L35
            xb.p r7 = (xb.p) r7     // Catch: java.lang.Throwable -> L35
            m0.h r8 = com.stepos.statsrpk.h.K(r2)     // Catch: java.lang.Throwable -> L35
            r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L35
            int r6 = r6 + 1
            goto L23
        L35:
            r15 = move-exception
            goto L3d
        L37:
            s0.a r0 = u0.m.f13683k
            r0.addAndGet(r3)
            goto L43
        L3d:
            s0.a r0 = u0.m.f13683k
            r0.addAndGet(r3)
            throw r15
        L43:
            java.lang.Object r0 = u0.m.f13676c
            monitor-enter(r0)
            g()     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L92
            java.lang.Object[] r3 = r2.f9561b     // Catch: java.lang.Throwable -> L85
            long[] r2 = r2.f9560a     // Catch: java.lang.Throwable -> L85
            int r4 = r2.length     // Catch: java.lang.Throwable -> L85
            int r4 = r4 + (-2)
            if (r4 < 0) goto L92
            r5 = r1
        L55:
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L85
            long r8 = ~r6     // Catch: java.lang.Throwable -> L85
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L8d
            int r8 = r5 - r4
            int r8 = ~r8     // Catch: java.lang.Throwable -> L85
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r1
        L6f:
            if (r10 >= r8) goto L8b
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L87
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r3[r11]     // Catch: java.lang.Throwable -> L85
            u0.v r11 = (u0.v) r11     // Catch: java.lang.Throwable -> L85
            q(r11)     // Catch: java.lang.Throwable -> L85
            goto L87
        L85:
            r15 = move-exception
            goto L94
        L87:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L6f
        L8b:
            if (r8 != r9) goto L92
        L8d:
            if (r5 == r4) goto L92
            int r5 = r5 + 1
            goto L55
        L92:
            monitor-exit(r0)
            return r15
        L94:
            monitor-exit(r0)
            throw r15
        L96:
            monitor-exit(r1)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.m.f(xb.l):java.lang.Object");
    }

    public static final void g() {
        b2.a aVar = f13680g;
        int i3 = aVar.f1860b;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= i3) {
                break;
            }
            s0.l lVar = ((s0.l[]) aVar.f1862d)[i10];
            Object obj = lVar != null ? lVar.get() : null;
            if (obj != null && p((v) obj)) {
                if (i11 != i10) {
                    ((s0.l[]) aVar.f1862d)[i11] = lVar;
                    int[] iArr = (int[]) aVar.f1861c;
                    iArr[i11] = iArr[i10];
                }
                i11++;
            }
            i10++;
        }
        for (int i12 = i11; i12 < i3; i12++) {
            ((s0.l[]) aVar.f1862d)[i12] = null;
            ((int[]) aVar.f1861c)[i12] = 0;
        }
        if (i11 != i3) {
            aVar.f1860b = i11;
        }
    }

    public static final f h(f fVar, xb.l lVar, boolean z10) {
        boolean z11 = fVar instanceof b;
        if (z11 || fVar == null) {
            return new z(z11 ? (b) fVar : null, lVar, null, false, z10);
        }
        return new a0(fVar, lVar, false, z10);
    }

    public static final x i(x xVar) {
        x xVarS;
        f fVarK = k();
        x xVarS2 = s(xVar, fVarK.g(), fVarK.d());
        if (xVarS2 != null) {
            return xVarS2;
        }
        synchronized (f13676c) {
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
        synchronized (f13676c) {
            xVarS = s(xVar, fVar.g(), fVar.d());
        }
        if (xVarS != null) {
            return xVarS;
        }
        r();
        throw null;
    }

    public static final f k() {
        f fVar = (f) f13675b.w();
        return fVar == null ? f13682j : fVar;
    }

    public static final xb.l l(xb.l lVar, xb.l lVar2, boolean z10) {
        if (!z10) {
            lVar2 = null;
        }
        if (lVar == null || lVar2 == null || lVar == lVar2) {
            return lVar == null ? lVar2 : lVar;
        }
        l lVar3 = new l(0);
        lVar3.f13672f = lVar;
        lVar3.f13673g = lVar2;
        VarHandle.storeStoreFence();
        return lVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r3 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u0.x m(u0.x r10, u0.v r11) {
        /*
            u0.x r0 = r11.a()
            long r1 = u0.m.f13678e
            u0.i r3 = u0.m.f13679f
            int r4 = r3.f13657a
            if (r4 <= 0) goto L13
            java.lang.Object r1 = r3.f13659c
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
            long r5 = r0.f13713a
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L23
            goto L43
        L23:
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L47
            int r7 = yb.k.c(r5, r1)
            if (r7 > 0) goto L47
            u0.k r7 = u0.k.i
            boolean r5 = r7.c(r5)
            if (r5 != 0) goto L47
            if (r4 != 0) goto L39
            r4 = r0
            goto L47
        L39:
            long r1 = r0.f13713a
            long r5 = r4.f13713a
            int r1 = yb.k.c(r1, r5)
            if (r1 >= 0) goto L45
        L43:
            r3 = r0
            goto L4a
        L45:
            r3 = r4
            goto L4a
        L47:
            u0.x r0 = r0.f13714b
            goto L18
        L4a:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 == 0) goto L54
            r3.f13713a = r0
            return r3
        L54:
            u0.x r10 = r10.b(r0)
            u0.x r0 = r11.a()
            r10.f13714b = r0
            r11.c(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.m.m(u0.x, u0.v):u0.x");
    }

    public static final void n(f fVar, v vVar) {
        fVar.t(fVar.h() + 1);
        xb.l lVarI = fVar.i();
        if (lVarI != null) {
            lVarI.invoke(vVar);
        }
    }

    public static final x o(x xVar, w wVar, f fVar, x xVar2) {
        x xVarM;
        if (fVar.f()) {
            fVar.n(wVar);
        }
        long jG = fVar.g();
        if (xVar2.f13713a == jG) {
            return xVar2;
        }
        synchronized (f13676c) {
            xVarM = m(xVar, wVar);
        }
        xVarM.f13713a = jG;
        if (xVar2.f13713a != 1) {
            fVar.n(wVar);
        }
        return xVarM;
    }

    public static final boolean p(v vVar) {
        x xVar;
        long j10 = f13678e;
        i iVar = f13679f;
        if (iVar.f13657a > 0) {
            j10 = ((long[]) iVar.f13659c)[0];
        }
        x xVar2 = null;
        x xVarA = null;
        int i3 = 0;
        for (x xVarA2 = vVar.a(); xVarA2 != null; xVarA2 = xVarA2.f13714b) {
            long j11 = xVarA2.f13713a;
            if (j11 != 0) {
                if (yb.k.c(j11, j10) >= 0) {
                    i3++;
                } else if (xVar2 == null) {
                    i3++;
                    xVar2 = xVarA2;
                } else {
                    if (yb.k.c(xVarA2.f13713a, xVar2.f13713a) < 0) {
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
                            if (yb.k.c(xVarA.f13713a, j10) >= 0) {
                                break;
                            }
                            if (yb.k.c(xVar3.f13713a, xVarA.f13713a) < 0) {
                                xVar3 = xVarA;
                            }
                            xVarA = xVarA.f13714b;
                        }
                    }
                    xVar2.f13713a = 0L;
                    xVar2.a(xVarA);
                    xVar2 = xVar;
                }
            }
        }
        return i3 > 1;
    }

    public static final void q(v vVar) {
        if (p(vVar)) {
            b2.a aVar = f13680g;
            int i3 = aVar.f1860b;
            int iIdentityHashCode = System.identityHashCode(vVar);
            int i10 = -1;
            if (i3 > 0) {
                int i11 = aVar.f1860b - 1;
                int i12 = 0;
                while (true) {
                    if (i12 > i11) {
                        i10 = -(i12 + 1);
                        break;
                    }
                    int i13 = (i12 + i11) >>> 1;
                    int i14 = ((int[]) aVar.f1861c)[i13];
                    if (i14 < iIdentityHashCode) {
                        i12 = i13 + 1;
                    } else if (i14 > iIdentityHashCode) {
                        i11 = i13 - 1;
                    } else {
                        s0.l lVar = ((s0.l[]) aVar.f1862d)[i13];
                        if (vVar == (lVar != null ? lVar.get() : null)) {
                            i10 = i13;
                        } else {
                            for (int i15 = i13 - 1; -1 < i15 && ((int[]) aVar.f1861c)[i15] == iIdentityHashCode; i15--) {
                                s0.l lVar2 = ((s0.l[]) aVar.f1862d)[i15];
                                if ((lVar2 != null ? lVar2.get() : null) == vVar) {
                                    i10 = i15;
                                    break;
                                }
                            }
                            i13++;
                            int i16 = aVar.f1860b;
                            while (true) {
                                if (i13 >= i16) {
                                    i10 = -(aVar.f1860b + 1);
                                    break;
                                } else {
                                    if (((int[]) aVar.f1861c)[i13] != iIdentityHashCode) {
                                        i10 = -(i13 + 1);
                                        break;
                                    }
                                    s0.l lVar3 = ((s0.l[]) aVar.f1862d)[i13];
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
            s0.l[] lVarArr = (s0.l[]) aVar.f1862d;
            int length = lVarArr.length;
            if (i3 == length) {
                int i18 = length * 2;
                s0.l[] lVarArr2 = new s0.l[i18];
                int[] iArr = new int[i18];
                int i19 = i17 + 1;
                System.arraycopy(lVarArr, i17, lVarArr2, i19, i3 - i17);
                System.arraycopy((s0.l[]) aVar.f1862d, 0, lVarArr2, 0, i17);
                kb.k.f0(i19, i17, (int[]) aVar.f1861c, iArr, i3);
                kb.k.j0(0, i17, (int[]) aVar.f1861c, iArr, 6);
                aVar.f1862d = lVarArr2;
                aVar.f1861c = iArr;
            } else {
                int i20 = i17 + 1;
                System.arraycopy(lVarArr, i17, lVarArr, i20, i3 - i17);
                int[] iArr2 = (int[]) aVar.f1861c;
                kb.k.f0(i20, i17, iArr2, iArr2, i3);
            }
            ((s0.l[]) aVar.f1862d)[i17] = new s0.l(vVar);
            ((int[]) aVar.f1861c)[i17] = iIdentityHashCode;
            aVar.f1860b++;
        }
    }

    public static final void r() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final x s(x xVar, long j10, k kVar) {
        x xVar2 = null;
        while (xVar != null) {
            long j11 = xVar.f13713a;
            if (j11 != 0 && yb.k.c(j11, j10) <= 0 && !kVar.c(j11) && (xVar2 == null || yb.k.c(xVar2.f13713a, xVar.f13713a) < 0)) {
                xVar2 = xVar;
            }
            xVar = xVar.f13714b;
        }
        if (xVar2 != null) {
            return xVar2;
        }
        return null;
    }

    public static final x t(x xVar, v vVar) {
        x xVarS;
        f fVarK = k();
        xb.l lVarE = fVarK.e();
        if (lVarE != null) {
            lVarE.invoke(vVar);
        }
        x xVarS2 = s(xVar, fVarK.g(), fVarK.d());
        if (xVarS2 != null) {
            return xVarS2;
        }
        synchronized (f13676c) {
            f fVarK2 = k();
            x xVarA = vVar.a();
            xVarA.getClass();
            xVarS = s(xVarA, fVarK2.g(), fVarK2.d());
            if (xVarS == null) {
                r();
                throw null;
            }
        }
        return xVarS;
    }

    public static final void u(int i3) {
        i iVar = f13679f;
        int i10 = ((int[]) iVar.f13661e)[i3];
        iVar.b(i10, iVar.f13657a - 1);
        iVar.f13657a--;
        long[] jArr = (long[]) iVar.f13659c;
        long j10 = jArr[i10];
        int i11 = i10;
        while (i11 > 0) {
            int i12 = ((i11 + 1) >> 1) - 1;
            if (yb.k.c(jArr[i12], j10) <= 0) {
                break;
            }
            iVar.b(i12, i11);
            i11 = i12;
        }
        long[] jArr2 = (long[]) iVar.f13659c;
        int i13 = iVar.f13657a >> 1;
        while (i10 < i13) {
            int i14 = (i10 + 1) << 1;
            int i15 = i14 - 1;
            if (i14 < iVar.f13657a && yb.k.c(jArr2[i14], jArr2[i15]) < 0) {
                if (yb.k.c(jArr2[i14], jArr2[i10]) >= 0) {
                    break;
                }
                iVar.b(i14, i10);
                i10 = i14;
            } else {
                if (yb.k.c(jArr2[i15], jArr2[i10]) >= 0) {
                    break;
                }
                iVar.b(i15, i10);
                i10 = i15;
            }
        }
        ((int[]) iVar.f13661e)[i3] = iVar.f13658b;
        iVar.f13658b = i3;
    }

    public static final Object v(a aVar, xb.l lVar) {
        long j10 = aVar.f13653b;
        Object objInvoke = lVar.invoke(f13677d.b(j10));
        long j11 = f13678e;
        f13678e = 1 + j11;
        k kVarB = f13677d.b(j10);
        f13677d = kVarB;
        aVar.f13653b = j11;
        aVar.f13652a = kVarB;
        aVar.f13640g = 0;
        aVar.f13641h = null;
        aVar.o();
        f13677d = f13677d.e(j11);
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
        if (xVarS2.f13713a == fVar.g()) {
            return xVarS2;
        }
        synchronized (f13676c) {
            xVarS = s(vVar.a(), jG, fVar.d());
            if (xVarS == null) {
                r();
                throw null;
            }
            if (xVarS.f13713a != jG) {
                x xVarM = m(xVarS, vVar);
                xVarM.a(xVarS);
                xVarM.f13713a = fVar.g();
                xVarS = xVarM;
            }
        }
        if (xVarS2.f13713a != 1) {
            fVar.n(vVar);
        }
        return xVarS;
    }
}
