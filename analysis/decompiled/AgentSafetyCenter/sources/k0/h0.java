package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends u0.x {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f6924h = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f6925c;

    /* renamed from: d, reason: collision with root package name */
    public int f6926d;

    /* renamed from: e, reason: collision with root package name */
    public p.z f6927e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6928f;

    /* renamed from: g, reason: collision with root package name */
    public int f6929g;

    public h0(long j10) {
        super(j10);
        p.z zVar = p.j0.f9585a;
        zVar.getClass();
        this.f6927e = zVar;
        this.f6928f = f6924h;
    }

    @Override // u0.x
    public final void a(u0.x xVar) {
        xVar.getClass();
        h0 h0Var = (h0) xVar;
        this.f6927e = h0Var.f6927e;
        this.f6928f = h0Var.f6928f;
        this.f6929g = h0Var.f6929g;
    }

    @Override // u0.x
    public final u0.x b(long j10) {
        return new h0(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(k0.i0 r7, u0.f r8) {
        /*
            r6 = this;
            java.lang.Object r0 = u0.m.f13676c
            monitor-enter(r0)
            long r1 = r6.f6925c     // Catch: java.lang.Throwable -> L1a
            long r3 = r8.g()     // Catch: java.lang.Throwable -> L1a
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L1c
            int r1 = r6.f6926d     // Catch: java.lang.Throwable -> L1a
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
            java.lang.Object r4 = r6.f6928f
            java.lang.Object r5 = k0.h0.f6924h
            if (r4 == r5) goto L2f
            if (r1 == 0) goto L30
            int r4 = r6.f6929g
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
            r6.f6925c = r3     // Catch: java.lang.Throwable -> L43
            int r7 = r8.h()     // Catch: java.lang.Throwable -> L43
            r6.f6926d = r7     // Catch: java.lang.Throwable -> L43
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
        throw new UnsupportedOperationException("Method not decompiled: k0.h0.c(k0.i0, u0.f):boolean");
    }

    public final int d(i0 i0Var, u0.f fVar) {
        p.z zVar;
        int iIdentityHashCode;
        int i;
        int i3;
        int i10;
        int i11;
        int i12;
        u0.x xVarJ;
        synchronized (u0.m.f13676c) {
            zVar = this.f6927e;
        }
        int i13 = 7;
        if (zVar.f9654e == 0) {
            return 7;
        }
        m0.e eVarP = z.p();
        Object[] objArr = eVarP.f8158c;
        int i14 = eVarP.f8160g;
        boolean z10 = false;
        for (int i15 = 0; i15 < i14; i15++) {
            ((q) objArr[i15]).b();
        }
        try {
            Object[] objArr2 = zVar.f9651b;
            int[] iArr = zVar.f9652c;
            long[] jArr = zVar.f9650a;
            int length = jArr.length - 2;
            if (length >= 0) {
                iIdentityHashCode = 7;
                int i16 = 0;
                while (true) {
                    long j10 = jArr[i16];
                    if ((((~j10) << i13) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i17 = 8;
                        int i18 = 8 - ((~(i16 - length)) >>> 31);
                        int i19 = z10 ? 1 : 0;
                        while (i19 < i18) {
                            if ((255 & j10) < 128) {
                                int i20 = (i16 << 3) + i19;
                                i10 = i13;
                                u0.v vVar = (u0.v) objArr2[i20];
                                i12 = i17;
                                if (iArr[i20] != 1) {
                                    i11 = length;
                                } else {
                                    if (vVar instanceof i0) {
                                        i0 i0Var2 = (i0) vVar;
                                        xVarJ = i0Var2.g((h0) u0.m.j(i0Var2.f6936h, fVar), fVar, z10, i0Var2.f6934f);
                                    } else {
                                        xVarJ = u0.m.j(vVar.a(), fVar);
                                    }
                                    i11 = length;
                                    iIdentityHashCode = (((iIdentityHashCode * 31) + System.identityHashCode(xVarJ)) * 31) + Long.hashCode(xVarJ.f13713a);
                                }
                            } else {
                                i10 = i13;
                                i11 = length;
                                i12 = i17;
                            }
                            j10 >>= i12;
                            i19++;
                            i13 = i10;
                            i17 = i12;
                            length = i11;
                            z10 = false;
                        }
                        i = i13;
                        i3 = length;
                        if (i18 != i17) {
                            break;
                        }
                    } else {
                        i = i13;
                        i3 = length;
                    }
                    if (i16 == i3) {
                        i13 = iIdentityHashCode;
                        break;
                    }
                    i16++;
                    i13 = i;
                    length = i3;
                    z10 = false;
                }
            }
            iIdentityHashCode = i13;
            Object[] objArr3 = eVarP.f8158c;
            int i21 = eVarP.f8160g;
            for (int i22 = 0; i22 < i21; i22++) {
                ((q) objArr3[i22]).a();
            }
            return iIdentityHashCode;
        } catch (Throwable th) {
            Object[] objArr4 = eVarP.f8158c;
            int i23 = eVarP.f8160g;
            for (int i24 = 0; i24 < i23; i24++) {
                ((q) objArr4[i24]).a();
            }
            throw th;
        }
    }
}
