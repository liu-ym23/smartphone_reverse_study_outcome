package la;

import java.util.Arrays;

/* loaded from: classes.dex */
public class j0 extends ma.b implements c0, j, ma.o {

    /* renamed from: j, reason: collision with root package name */
    public final int f5936j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5937k;

    /* renamed from: l, reason: collision with root package name */
    public final ka.a f5938l;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f5939m;

    /* renamed from: n, reason: collision with root package name */
    public long f5940n;

    /* renamed from: o, reason: collision with root package name */
    public long f5941o;

    /* renamed from: p, reason: collision with root package name */
    public int f5942p;

    /* renamed from: q, reason: collision with root package name */
    public int f5943q;

    public j0(int i2, int i10, ka.a aVar) {
        this.f5936j = i2;
        this.f5937k = i10;
        this.f5938l = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:15:0x0031, B:32:0x0079, B:34:0x0081, B:38:0x0094, B:41:0x009b, B:42:0x009f, B:43:0x00a0, B:22:0x004b), top: B:52:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [ma.b] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [la.j0] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [la.k] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [ma.d] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [la.l0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [la.l0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:16:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(la.j0 r8, la.k r9, g7.d r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof la.i0
            if (r0 == 0) goto L13
            r0 = r10
            la.i0 r0 = (la.i0) r0
            int r1 = r0.f5935l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5935l = r1
            goto L18
        L13:
            la.i0 r0 = new la.i0
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f5933j
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5935l
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L5e
            r8 = 1
            if (r2 == r8) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            ia.g1 r8 = r0.f5932i
            la.l0 r9 = r0.f5931h
            la.k r2 = r0.f5930g
            la.j0 r5 = r0.f5929f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L38
        L34:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L76
        L38:
            r8 = move-exception
            goto Lb4
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            ia.g1 r8 = r0.f5932i
            la.l0 r9 = r0.f5931h
            la.k r2 = r0.f5930g
            la.j0 r5 = r0.f5929f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L38
            goto L79
        L4f:
            la.l0 r9 = r0.f5931h
            la.k r8 = r0.f5930g
            la.j0 r2 = r0.f5929f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L5b
            r10 = r8
            r8 = r2
            goto L6a
        L5b:
            r8 = move-exception
            r5 = r2
            goto Lb4
        L5e:
            w7.e0.N(r10)
            ma.d r10 = r8.a()
            la.l0 r10 = (la.l0) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L6a:
            g7.l r2 = r0.getContext()     // Catch: java.lang.Throwable -> Lb1
            ia.z r5 = ia.z.f5027g     // Catch: java.lang.Throwable -> Lb1
            g7.j r2 = r2.o(r5)     // Catch: java.lang.Throwable -> Lb1
            ia.g1 r2 = (ia.g1) r2     // Catch: java.lang.Throwable -> Lb1
        L76:
            r5 = r8
            r8 = r2
            r2 = r10
        L79:
            java.lang.Object r10 = r5.p(r9)     // Catch: java.lang.Throwable -> L38
            f8.x r6 = la.k0.f5944a     // Catch: java.lang.Throwable -> L38
            if (r10 != r6) goto L92
            r0.f5929f = r5     // Catch: java.lang.Throwable -> L38
            r0.f5930g = r2     // Catch: java.lang.Throwable -> L38
            r0.f5931h = r9     // Catch: java.lang.Throwable -> L38
            r0.f5932i = r8     // Catch: java.lang.Throwable -> L38
            r0.f5935l = r4     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r5.f(r9, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L79
            goto Lb0
        L92:
            if (r8 == 0) goto La0
            boolean r6 = r8.b()     // Catch: java.lang.Throwable -> L38
            if (r6 == 0) goto L9b
            goto La0
        L9b:
            java.util.concurrent.CancellationException r8 = r8.E()     // Catch: java.lang.Throwable -> L38
            throw r8     // Catch: java.lang.Throwable -> L38
        La0:
            r0.f5929f = r5     // Catch: java.lang.Throwable -> L38
            r0.f5930g = r2     // Catch: java.lang.Throwable -> L38
            r0.f5931h = r9     // Catch: java.lang.Throwable -> L38
            r0.f5932i = r8     // Catch: java.lang.Throwable -> L38
            r0.f5935l = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L34
        Lb0:
            return
        Lb1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        Lb4:
            r5.d(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: la.j0.h(la.j0, la.k, g7.d):void");
    }

    @Override // ma.o
    public final j E(g7.l lVar, int i2, ka.a aVar) {
        return k0.m(this, lVar, i2, aVar);
    }

    @Override // la.c0
    public final void I() throws Throwable {
        j0 j0Var;
        synchronized (this) {
            try {
                j0Var = this;
                try {
                    j0Var.q(l() + this.f5942p, this.f5941o, l() + this.f5942p, l() + this.f5942p + this.f5943q);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                j0Var = this;
            }
        }
    }

    @Override // la.c0
    public final boolean M(Object obj) {
        int i2;
        boolean z4;
        g7.d[] dVarArrK = ma.c.f6480a;
        synchronized (this) {
            if (n(obj)) {
                dVarArrK = k(dVarArrK);
                z4 = true;
            } else {
                z4 = false;
            }
        }
        for (g7.d dVar : dVarArrK) {
            if (dVar != null) {
                dVar.resumeWith(c7.r.f1986a);
            }
        }
        return z4;
    }

    @Override // ma.b
    public final ma.d b() {
        l0 l0Var = new l0();
        l0Var.f5953a = -1L;
        return l0Var;
    }

    @Override // ma.b
    public final ma.d[] c() {
        return new l0[2];
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    @Override // la.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, g7.d r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r7.M(r8)
            if (r0 == 0) goto L9
            c7.r r7 = c7.r.f1986a
            return r7
        L9:
            ia.m r5 = new ia.m
            g7.d r9 = ib.k.C(r9)
            r6 = 1
            r5.<init>(r6, r9)
            r5.s()
            g7.d[] r9 = ma.c.f6480a
            monitor-enter(r7)
            boolean r0 = r7.n(r8)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L30
            c7.r r8 = c7.r.f1986a     // Catch: java.lang.Throwable -> L2b
            r5.resumeWith(r8)     // Catch: java.lang.Throwable -> L2b
            g7.d[] r8 = r7.k(r9)     // Catch: java.lang.Throwable -> L2b
            r9 = 0
            r1 = r7
            goto L59
        L2b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L8e
        L30:
            la.h0 r0 = new la.h0     // Catch: java.lang.Throwable -> L8b
            long r1 = r7.l()     // Catch: java.lang.Throwable -> L8b
            int r3 = r7.f5942p     // Catch: java.lang.Throwable -> L86
            int r4 = r7.f5943q     // Catch: java.lang.Throwable -> L86
            int r3 = r3 + r4
            long r3 = (long) r3
            long r2 = r1 + r3
            r1 = r7
            r4 = r8
            r0.<init>(r1, r2, r4, r5)     // Catch: java.lang.Throwable -> L54
            r1.j(r0)     // Catch: java.lang.Throwable -> L54
            int r7 = r1.f5943q     // Catch: java.lang.Throwable -> L54
            int r7 = r7 + r6
            r1.f5943q = r7     // Catch: java.lang.Throwable -> L54
            int r7 = r1.f5937k     // Catch: java.lang.Throwable -> L54
            if (r7 != 0) goto L57
            g7.d[] r9 = r1.k(r9)     // Catch: java.lang.Throwable -> L54
            goto L57
        L54:
            r0 = move-exception
        L55:
            r8 = r0
            goto L8e
        L57:
            r8 = r9
            r9 = r0
        L59:
            monitor-exit(r1)
            if (r9 == 0) goto L65
            ia.h r7 = new ia.h
            r0 = 2
            r7.<init>(r0, r9)
            r5.v(r7)
        L65:
            int r7 = r8.length
            r9 = 0
        L67:
            if (r9 >= r7) goto L75
            r0 = r8[r9]
            if (r0 == 0) goto L72
            c7.r r1 = c7.r.f1986a
            r0.resumeWith(r1)
        L72:
            int r9 = r9 + 1
            goto L67
        L75:
            java.lang.Object r7 = r5.r()
            h7.a r8 = h7.a.f4212f
            if (r7 != r8) goto L7e
            goto L80
        L7e:
            c7.r r7 = c7.r.f1986a
        L80:
            if (r7 != r8) goto L83
            return r7
        L83:
            c7.r r7 = c7.r.f1986a
            return r7
        L86:
            r0 = move-exception
            r1 = r7
            r7 = r0
            r8 = r7
            goto L8e
        L8b:
            r0 = move-exception
            r1 = r7
            goto L55
        L8e:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: la.j0.emit(java.lang.Object, g7.d):java.lang.Object");
    }

    public final Object f(l0 l0Var, i0 i0Var) {
        ia.m mVar = new ia.m(1, ib.k.C(i0Var));
        mVar.s();
        synchronized (this) {
            try {
                if (o(l0Var) < 0) {
                    l0Var.f5954b = mVar;
                } else {
                    mVar.resumeWith(c7.r.f1986a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objR = mVar.r();
        return objR == h7.a.f4212f ? objR : c7.r.f1986a;
    }

    public final void g() {
        if (this.f5937k != 0 || this.f5943q > 1) {
            Object[] objArr = this.f5939m;
            q7.k.b(objArr);
            while (this.f5943q > 0) {
                long jL = l();
                int i2 = this.f5942p;
                int i10 = this.f5943q;
                if (objArr[((int) ((jL + (i2 + i10)) - 1)) & (objArr.length - 1)] != k0.f5944a) {
                    return;
                }
                this.f5943q = i10 - 1;
                k0.e(objArr, l() + this.f5942p + this.f5943q, null);
            }
        }
    }

    public final void i() {
        ma.d[] dVarArr;
        Object[] objArr = this.f5939m;
        q7.k.b(objArr);
        k0.e(objArr, l(), null);
        this.f5942p--;
        long jL = l() + 1;
        if (this.f5940n < jL) {
            this.f5940n = jL;
        }
        if (this.f5941o < jL) {
            if (this.f6477g != 0 && (dVarArr = this.f6476f) != null) {
                for (ma.d dVar : dVarArr) {
                    if (dVar != null) {
                        l0 l0Var = (l0) dVar;
                        long j2 = l0Var.f5953a;
                        if (j2 >= 0 && j2 < jL) {
                            l0Var.f5953a = jL;
                        }
                    }
                }
            }
            this.f5941o = jL;
        }
    }

    public final void j(Object obj) {
        int i2 = this.f5942p + this.f5943q;
        Object[] objArrM = this.f5939m;
        if (objArrM == null) {
            objArrM = m(null, 0, 2);
        } else if (i2 >= objArrM.length) {
            objArrM = m(objArrM, i2, objArrM.length * 2);
        }
        k0.e(objArrM, l() + i2, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final g7.d[] k(g7.d[] dVarArr) {
        ma.d[] dVarArr2;
        l0 l0Var;
        ia.m mVar;
        int length = dVarArr.length;
        if (this.f6477g != 0 && (dVarArr2 = this.f6476f) != null) {
            int length2 = dVarArr2.length;
            int i2 = 0;
            dVarArr = dVarArr;
            while (i2 < length2) {
                ma.d dVar = dVarArr2[i2];
                if (dVar != null && (mVar = (l0Var = (l0) dVar).f5954b) != null && o(l0Var) >= 0) {
                    int length3 = dVarArr.length;
                    dVarArr = dVarArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(dVarArr, Math.max(2, dVarArr.length * 2));
                        q7.k.d(CopyOf, "copyOf(...)");
                        dVarArr = CopyOf;
                    }
                    dVarArr[length] = mVar;
                    l0Var.f5954b = null;
                    length++;
                }
                i2++;
                dVarArr = dVarArr;
            }
        }
        return dVarArr;
    }

    public final long l() {
        return Math.min(this.f5941o, this.f5940n);
    }

    public final Object[] m(Object[] objArr, int i2, int i10) {
        if (i10 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i10];
        this.f5939m = objArr2;
        if (objArr != null) {
            long jL = l();
            for (int i11 = 0; i11 < i2; i11++) {
                long j2 = i11 + jL;
                k0.e(objArr2, j2, objArr[((int) j2) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.f6477g
            int r2 = r12.f5936j
            r9 = 1
            if (r1 != 0) goto L23
            if (r2 != 0) goto Lb
            goto L7f
        Lb:
            r12.j(r13)
            int r1 = r12.f5942p
            int r1 = r1 + r9
            r12.f5942p = r1
            if (r1 <= r2) goto L18
            r12.i()
        L18:
            long r1 = r12.l()
            int r3 = r12.f5942p
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.f5941o = r1
            return r9
        L23:
            int r1 = r12.f5942p
            int r3 = r12.f5937k
            if (r1 < r3) goto L47
            long r4 = r12.f5941o
            long r6 = r12.f5940n
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L47
            ka.a r1 = r12.f5938l
            int r1 = r1.ordinal()
            if (r1 == 0) goto L45
            if (r1 == r9) goto L47
            r0 = 2
            if (r1 != r0) goto L3f
            goto L7f
        L3f:
            a4.u r0 = new a4.u
            r0.<init>()
            throw r0
        L45:
            r0 = 0
            return r0
        L47:
            r12.j(r13)
            int r1 = r12.f5942p
            int r1 = r1 + r9
            r12.f5942p = r1
            if (r1 <= r3) goto L54
            r12.i()
        L54:
            long r3 = r12.l()
            int r1 = r12.f5942p
            long r5 = (long) r1
            long r3 = r3 + r5
            long r5 = r12.f5940n
            long r3 = r3 - r5
            int r1 = (int) r3
            if (r1 <= r2) goto L7f
            r1 = 1
            long r1 = r1 + r5
            long r3 = r12.f5941o
            long r5 = r12.l()
            int r7 = r12.f5942p
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.l()
            int r10 = r12.f5942p
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.f5943q
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.q(r1, r3, r5, r7)
        L7f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: la.j0.n(java.lang.Object):boolean");
    }

    public final long o(l0 l0Var) {
        long j2 = l0Var.f5953a;
        if (j2 >= l() + this.f5942p && (this.f5937k > 0 || j2 > l() || this.f5943q == 0)) {
            return -1L;
        }
        return j2;
    }

    public final Object p(l0 l0Var) {
        Object obj;
        g7.d[] dVarArrR = ma.c.f6480a;
        synchronized (this) {
            try {
                long jO = o(l0Var);
                if (jO < 0) {
                    obj = k0.f5944a;
                } else {
                    long j2 = l0Var.f5953a;
                    Object[] objArr = this.f5939m;
                    q7.k.b(objArr);
                    Object obj2 = objArr[((int) jO) & (objArr.length - 1)];
                    if (obj2 instanceof h0) {
                        obj2 = ((h0) obj2).f5925h;
                    }
                    l0Var.f5953a = jO + 1;
                    Object obj3 = obj2;
                    dVarArrR = r(j2);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (g7.d dVar : dVarArrR) {
            if (dVar != null) {
                dVar.resumeWith(c7.r.f1986a);
            }
        }
        return obj;
    }

    public final void q(long j2, long j4, long j10, long j11) {
        long jMin = Math.min(j4, j2);
        for (long jL = l(); jL < jMin; jL++) {
            Object[] objArr = this.f5939m;
            q7.k.b(objArr);
            k0.e(objArr, jL, null);
        }
        this.f5940n = j2;
        this.f5941o = j4;
        this.f5942p = (int) (j10 - jMin);
        this.f5943q = (int) (j11 - j10);
    }

    public final g7.d[] r(long j2) {
        long j4;
        long j10;
        long j11;
        g7.d[] dVarArr;
        g7.d[] dVarArr2;
        ma.d[] dVarArr3;
        f8.x xVar = k0.f5944a;
        g7.d[] dVarArr4 = ma.c.f6480a;
        if (j2 <= this.f5941o) {
            long jL = l();
            long j12 = this.f5942p + jL;
            int i2 = this.f5937k;
            if (i2 == 0 && this.f5943q > 0) {
                j12++;
            }
            int i10 = 0;
            if (this.f6477g != 0 && (dVarArr3 = this.f6476f) != null) {
                for (ma.d dVar : dVarArr3) {
                    if (dVar != null) {
                        long j13 = ((l0) dVar).f5953a;
                        if (j13 >= 0 && j13 < j12) {
                            j12 = j13;
                        }
                    }
                }
            }
            if (j12 > this.f5941o) {
                long jL2 = l() + this.f5942p;
                int iMin = this.f6477g > 0 ? Math.min(this.f5943q, i2 - ((int) (jL2 - j12))) : this.f5943q;
                long j14 = this.f5943q + jL2;
                if (iMin > 0) {
                    j11 = 1;
                    Object[] objArr = this.f5939m;
                    q7.k.b(objArr);
                    j4 = jL;
                    g7.d[] dVarArr5 = new g7.d[iMin];
                    long j15 = jL2;
                    while (true) {
                        if (jL2 >= j14) {
                            dVarArr2 = dVarArr5;
                            j10 = j12;
                            break;
                        }
                        dVarArr2 = dVarArr5;
                        Object obj = objArr[(objArr.length - 1) & ((int) jL2)];
                        if (obj != xVar) {
                            q7.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                            h0 h0Var = (h0) obj;
                            int i11 = i10 + 1;
                            j10 = j12;
                            dVarArr2[i10] = h0Var.f5926i;
                            k0.e(objArr, jL2, xVar);
                            k0.e(objArr, j15, h0Var.f5925h);
                            j15++;
                            if (i11 >= iMin) {
                                break;
                            }
                            i10 = i11;
                        } else {
                            j10 = j12;
                        }
                        jL2++;
                        dVarArr5 = dVarArr2;
                        j12 = j10;
                    }
                    jL2 = j15;
                    dVarArr = dVarArr2;
                } else {
                    j4 = jL;
                    j10 = j12;
                    j11 = 1;
                    dVarArr = dVarArr4;
                }
                int i12 = (int) (jL2 - j4);
                long j16 = this.f6477g == 0 ? jL2 : j10;
                long jMax = Math.max(this.f5940n, jL2 - Math.min(this.f5936j, i12));
                if (i2 == 0 && jMax < j14) {
                    Object[] objArr2 = this.f5939m;
                    q7.k.b(objArr2);
                    if (q7.k.a(objArr2[((int) jMax) & (objArr2.length - 1)], xVar)) {
                        jL2 += j11;
                        jMax += j11;
                    }
                }
                q(jMax, j16, jL2, j14);
                g();
                return dVarArr.length == 0 ? dVarArr : k(dVarArr);
            }
        }
        return dVarArr4;
    }

    @Override // la.j
    public final Object x(k kVar, g7.d dVar) throws Throwable {
        h(this, kVar, dVar);
        return h7.a.f4212f;
    }
}
