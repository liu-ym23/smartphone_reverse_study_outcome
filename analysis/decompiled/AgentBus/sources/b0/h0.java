package b0;

/* loaded from: classes.dex */
public final class h0 extends l0.x {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f1166h = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f1167c;

    /* renamed from: d, reason: collision with root package name */
    public int f1168d;

    /* renamed from: e, reason: collision with root package name */
    public k.y f1169e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1170f;

    /* renamed from: g, reason: collision with root package name */
    public int f1171g;

    public h0(long j2) {
        super(j2);
        k.y yVar = k.e0.f5483a;
        q7.k.c(yVar, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.emptyObjectIntMap>");
        this.f1169e = yVar;
        this.f1170f = f1166h;
    }

    @Override // l0.x
    public final void a(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
        h0 h0Var = (h0) xVar;
        this.f1169e = h0Var.f1169e;
        this.f1170f = h0Var.f1170f;
        this.f1171g = h0Var.f1171g;
    }

    @Override // l0.x
    public final l0.x b(long j2) {
        return new h0(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(b0.i0 r7, l0.f r8) {
        /*
            r6 = this;
            java.lang.Object r0 = l0.m.f5774c
            monitor-enter(r0)
            long r1 = r6.f1167c     // Catch: java.lang.Throwable -> L1a
            long r3 = r8.g()     // Catch: java.lang.Throwable -> L1a
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L1c
            int r1 = r6.f1168d     // Catch: java.lang.Throwable -> L1a
            int r4 = r8.h()     // Catch: java.lang.Throwable -> L1a
            if (r1 == r4) goto L18
            goto L1c
        L18:
            r1 = r3
            goto L1d
        L1a:
            r6 = move-exception
            goto L47
        L1c:
            r1 = r2
        L1d:
            monitor-exit(r0)
            java.lang.Object r4 = r6.f1170f
            java.lang.Object r5 = b0.h0.f1166h
            if (r4 == r5) goto L2f
            if (r1 == 0) goto L30
            int r4 = r6.f1171g
            int r7 = r6.d(r7, r8)
            if (r4 != r7) goto L2f
            goto L30
        L2f:
            r2 = r3
        L30:
            if (r2 == 0) goto L46
            if (r1 == 0) goto L46
            monitor-enter(r0)
            long r3 = r8.g()     // Catch: java.lang.Throwable -> L43
            r6.f1167c = r3     // Catch: java.lang.Throwable -> L43
            int r7 = r8.h()     // Catch: java.lang.Throwable -> L43
            r6.f1168d = r7     // Catch: java.lang.Throwable -> L43
            monitor-exit(r0)
            return r2
        L43:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        L46:
            return r2
        L47:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.h0.c(b0.i0, l0.f):boolean");
    }

    public final int d(i0 i0Var, l0.f fVar) {
        k.y yVar;
        int iIdentityHashCode;
        int i2;
        int i10;
        int i11;
        int i12;
        int i13;
        l0.x xVarJ;
        synchronized (l0.m.f5774c) {
            yVar = this.f1169e;
        }
        int i14 = 7;
        if (yVar.f5554e == 0) {
            return 7;
        }
        d0.e eVarI = b.i();
        Object[] objArr = eVarI.f2749f;
        int i15 = eVarI.f2751h;
        boolean z4 = false;
        for (int i16 = 0; i16 < i15; i16++) {
            ((n) objArr[i16]).b();
        }
        try {
            Object[] objArr2 = yVar.f5551b;
            int[] iArr = yVar.f5552c;
            long[] jArr = yVar.f5550a;
            int length = jArr.length - 2;
            if (length >= 0) {
                iIdentityHashCode = 7;
                int i17 = 0;
                while (true) {
                    long j2 = jArr[i17];
                    if ((((~j2) << i14) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i18 = 8;
                        int i19 = 8 - ((~(i17 - length)) >>> 31);
                        int i20 = z4 ? 1 : 0;
                        while (i20 < i19) {
                            if ((255 & j2) < 128) {
                                int i21 = (i17 << 3) + i20;
                                i11 = i14;
                                l0.v vVar = (l0.v) objArr2[i21];
                                i13 = i18;
                                if (iArr[i21] != 1) {
                                    i12 = length;
                                } else {
                                    if (vVar instanceof i0) {
                                        i0 i0Var2 = (i0) vVar;
                                        xVarJ = i0Var2.e((h0) l0.m.j(i0Var2.f1187h, fVar), fVar, z4, i0Var2.f1186g);
                                    } else {
                                        xVarJ = l0.m.j(vVar.a(), fVar);
                                    }
                                    i12 = length;
                                    iIdentityHashCode = (((iIdentityHashCode * 31) + System.identityHashCode(xVarJ)) * 31) + Long.hashCode(xVarJ.f5813a);
                                }
                            } else {
                                i11 = i14;
                                i12 = length;
                                i13 = i18;
                            }
                            j2 >>= i13;
                            i20++;
                            i14 = i11;
                            i18 = i13;
                            length = i12;
                            z4 = false;
                        }
                        i2 = i14;
                        i10 = length;
                        if (i19 != i18) {
                            break;
                        }
                    } else {
                        i2 = i14;
                        i10 = length;
                    }
                    if (i17 == i10) {
                        i14 = iIdentityHashCode;
                        break;
                    }
                    i17++;
                    i14 = i2;
                    length = i10;
                    z4 = false;
                }
            }
            iIdentityHashCode = i14;
            Object[] objArr3 = eVarI.f2749f;
            int i22 = eVarI.f2751h;
            for (int i23 = 0; i23 < i22; i23++) {
                ((n) objArr3[i23]).a();
            }
            return iIdentityHashCode;
        } catch (Throwable th) {
            Object[] objArr4 = eVarI.f2749f;
            int i24 = eVarI.f2751h;
            for (int i25 = 0; i25 < i24; i25++) {
                ((n) objArr4[i25]).a();
            }
            throw th;
        }
    }
}
