package la;

/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.x f5944a = new f8.x("NO_VALUE", 3);

    /* renamed from: b, reason: collision with root package name */
    public static final f8.x f5945b = new f8.x("NONE", 3);

    /* renamed from: c, reason: collision with root package name */
    public static final f8.x f5946c = new f8.x("PENDING", 3);

    public static final j0 a(int i2, int i10, ka.a aVar) {
        if (i2 < 0) {
            throw new IllegalArgumentException(n.f.c(i2, "replay cannot be negative, but was ").toString());
        }
        if (i10 < 0) {
            throw new IllegalArgumentException(n.f.c(i10, "extraBufferCapacity cannot be negative, but was ").toString());
        }
        if (i2 <= 0 && i10 <= 0 && aVar != ka.a.f5661f) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
        }
        int i11 = i10 + i2;
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        return new j0(i2, i11, aVar);
    }

    public static /* synthetic */ j0 b(int i2, int i10, int i11) {
        ka.a aVar = ka.a.f5662g;
        if ((i11 & 1) != 0) {
            i2 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            aVar = ka.a.f5661f;
        }
        return a(i2, i10, aVar);
    }

    public static final u0 c(Object obj) {
        if (obj == null) {
            obj = ma.c.f6481b;
        }
        return new u0(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(la.w0 r5, s2.l r6, java.lang.Throwable r7, i7.c r8) {
        /*
            boolean r0 = r8 instanceof la.m
            if (r0 == 0) goto L13
            r0 = r8
            la.m r0 = (la.m) r0
            int r1 = r0.f5957h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5957h = r1
            goto L18
        L13:
            la.m r0 = new la.m
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f5956g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5957h
            c7.r r3 = c7.r.f1986a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            java.lang.Throwable r7 = r0.f5955f
            w7.e0.N(r8)     // Catch: java.lang.Throwable -> L2b
            goto L42
        L2b:
            r5 = move-exception
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            w7.e0.N(r8)
            r0.f5955f = r7     // Catch: java.lang.Throwable -> L2b
            r0.f5957h = r4     // Catch: java.lang.Throwable -> L2b
            r6.j(r5, r7, r0)     // Catch: java.lang.Throwable -> L2b
            if (r3 != r1) goto L42
            return r1
        L42:
            return r3
        L43:
            if (r7 == 0) goto L4a
            if (r7 == r5) goto L4a
            ib.k.e(r5, r7)
        L4a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.d(la.w0, s2.l, java.lang.Throwable, i7.c):java.lang.Object");
    }

    public static final void e(Object[] objArr, long j2, Object obj) {
        objArr[((int) j2) & (objArr.length - 1)] = obj;
    }

    public static j f(j jVar, int i2) {
        ka.a aVar = ka.a.f5661f;
        if (i2 < 0 && i2 != -2 && i2 != -1) {
            throw new IllegalArgumentException(n.f.c(i2, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
        }
        if (i2 == -1) {
            aVar = ka.a.f5662g;
            i2 = 0;
        }
        int i10 = i2;
        ka.a aVar2 = aVar;
        return jVar instanceof ma.o ? ma.n.fuse$default((ma.o) jVar, null, i10, aVar2, 1, null) : new ma.g(i10, g7.m.f3866f, aVar2, jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final h4.s g(la.j r7, int r8) {
        /*
            ka.j r0 = ka.k.f5709d
            r0.getClass()
            int r0 = ka.j.f5708b
            if (r8 >= r0) goto La
            goto Lb
        La:
            r0 = r8
        Lb:
            int r0 = r0 - r8
            boolean r1 = r7 instanceof ma.e
            if (r1 == 0) goto L3b
            r1 = r7
            ma.e r1 = (ma.e) r1
            ka.a r2 = r1.f6484h
            la.j r3 = r1.d()
            if (r3 == 0) goto L3b
            h4.s r7 = new h4.s
            int r4 = r1.f6483g
            r5 = -3
            if (r4 == r5) goto L29
            r5 = -2
            if (r4 == r5) goto L29
            if (r4 == 0) goto L29
            r0 = r4
            goto L35
        L29:
            ka.a r5 = ka.a.f5661f
            r6 = 0
            if (r2 != r5) goto L32
            if (r4 != 0) goto L35
        L30:
            r0 = r6
            goto L35
        L32:
            if (r8 != 0) goto L30
            r0 = 1
        L35:
            g7.l r8 = r1.f6482f
            r7.<init>(r0, r8, r2, r3)
            return r7
        L3b:
            h4.s r8 = new h4.s
            ka.a r1 = ka.a.f5661f
            g7.m r2 = g7.m.f3866f
            r8.<init>(r0, r2, r1, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.g(la.j, int):h4.s");
    }

    public static final j h(j jVar) {
        return ((jVar instanceof s0) || (jVar instanceof h)) ? jVar : new h(jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0056, B:29:0x006b, B:31:0x0073, B:20:0x0047, B:24:0x0052), top: B:52:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0085 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(la.k r7, ka.x r8, boolean r9, g7.d r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof la.l
            if (r0 == 0) goto L13
            r0 = r10
            la.l r0 = (la.l) r0
            int r1 = r0.f5952k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5952k = r1
            goto L18
        L13:
            la.l r0 = new la.l
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f5951j
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5952k
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            boolean r9 = r0.f5950i
            ka.b r7 = r0.f5949h
            ka.x r8 = r0.f5948g
            la.k r2 = r0.f5947f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r2
            goto L56
        L35:
            r7 = move-exception
            goto L90
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            boolean r9 = r0.f5950i
            ka.b r7 = r0.f5949h
            ka.x r8 = r0.f5948g
            la.k r2 = r0.f5947f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L35
            goto L6b
        L4b:
            w7.e0.N(r10)
            boolean r10 = r7 instanceof la.w0
            if (r10 != 0) goto Lab
            ka.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L56:
            r0.f5947f = r7     // Catch: java.lang.Throwable -> L35
            r0.f5948g = r8     // Catch: java.lang.Throwable -> L35
            r0.f5949h = r10     // Catch: java.lang.Throwable -> L35
            r0.f5950i = r9     // Catch: java.lang.Throwable -> L35
            r0.f5952k = r5     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L67
            goto L87
        L67:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L6b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L88
            java.lang.Object r10 = r7.c()     // Catch: java.lang.Throwable -> L35
            r0.f5947f = r2     // Catch: java.lang.Throwable -> L35
            r0.f5948g = r8     // Catch: java.lang.Throwable -> L35
            r0.f5949h = r7     // Catch: java.lang.Throwable -> L35
            r0.f5950i = r9     // Catch: java.lang.Throwable -> L35
            r0.f5952k = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L32
        L87:
            return r1
        L88:
            if (r9 == 0) goto L8d
            r8.d(r3)
        L8d:
            c7.r r7 = c7.r.f1986a
            return r7
        L90:
            throw r7     // Catch: java.lang.Throwable -> L91
        L91:
            r10 = move-exception
            if (r9 == 0) goto Laa
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9b
            r3 = r7
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
        L9b:
            if (r3 != 0) goto La7
            java.util.concurrent.CancellationException r3 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r3.<init>(r9)
            r3.initCause(r7)
        La7:
            r8.d(r3)
        Laa:
            throw r10
        Lab:
            la.w0 r7 = (la.w0) r7
            java.lang.Throwable r7 = r7.f6023f
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.i(la.k, ka.x, boolean, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(la.j r6, i7.c r7) {
        /*
            f8.x r0 = ma.c.f6481b
            boolean r1 = r7 instanceof la.x
            if (r1 == 0) goto L15
            r1 = r7
            la.x r1 = (la.x) r1
            int r2 = r1.f6027i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f6027i = r2
            goto L1a
        L15:
            la.x r1 = new la.x
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.f6026h
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f6027i
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            la.v r6 = r1.f6025g
            q7.v r2 = r1.f6024f
            w7.e0.N(r7)     // Catch: ma.a -> L2d
            goto L65
        L2d:
            r7 = move-exception
            goto L5a
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            w7.e0.N(r7)
            q7.v r7 = new q7.v
            r7.<init>()
            r7.f8820f = r0
            la.v r3 = new la.v
            r5 = 0
            r3.<init>(r7, r5)
            r1.f6024f = r7     // Catch: ma.a -> L56
            r1.f6025g = r3     // Catch: ma.a -> L56
            r1.f6027i = r4     // Catch: ma.a -> L56
            java.lang.Object r6 = r6.x(r3, r1)     // Catch: ma.a -> L56
            if (r6 != r2) goto L54
            return r2
        L54:
            r2 = r7
            goto L65
        L56:
            r6 = move-exception
            r2 = r7
            r7 = r6
            r6 = r3
        L5a:
            java.lang.Object r3 = r7.f6475f
            if (r3 != r6) goto L72
            g7.l r6 = r1.getContext()
            ia.d0.h(r6)
        L65:
            java.lang.Object r6 = r2.f8820f
            if (r6 == r0) goto L6a
            return r6
        L6a:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Expected at least one element"
            r6.<init>(r7)
            throw r6
        L72:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.j(la.j, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(la.j r7, p7.n r8, i7.c r9) {
        /*
            f8.x r0 = ma.c.f6481b
            boolean r1 = r9 instanceof la.y
            if (r1 == 0) goto L15
            r1 = r9
            la.y r1 = (la.y) r1
            int r2 = r1.f6031i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f6031i = r2
            goto L1a
        L15:
            la.y r1 = new la.y
            r1.<init>(r9)
        L1a:
            java.lang.Object r9 = r1.f6030h
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f6031i
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            la.g r7 = r1.f6029g
            q7.v r8 = r1.f6028f
            w7.e0.N(r9)     // Catch: ma.a -> L2d
            goto L66
        L2d:
            r9 = move-exception
            goto L5b
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            w7.e0.N(r9)
            q7.v r9 = new q7.v
            r9.<init>()
            r9.f8820f = r0
            la.g r3 = new la.g
            r5 = 2
            r6 = 0
            r3.<init>(r5, r8, r9, r6)
            r1.f6028f = r9     // Catch: ma.a -> L57
            r1.f6029g = r3     // Catch: ma.a -> L57
            r1.f6031i = r4     // Catch: ma.a -> L57
            java.lang.Object r7 = r7.x(r3, r1)     // Catch: ma.a -> L57
            if (r7 != r2) goto L55
            return r2
        L55:
            r8 = r9
            goto L66
        L57:
            r7 = move-exception
            r8 = r9
            r9 = r7
            r7 = r3
        L5b:
            java.lang.Object r2 = r9.f6475f
            if (r2 != r7) goto L73
            g7.l r7 = r1.getContext()
            ia.d0.h(r7)
        L66:
            java.lang.Object r7 = r8.f8820f
            if (r7 == r0) goto L6b
            return r7
        L6b:
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException
            java.lang.String r8 = "Expected at least one element matching the predicate"
            r7.<init>(r8)
            throw r7
        L73:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.k(la.j, p7.n, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(la.j r5, i7.c r6) {
        /*
            boolean r0 = r6 instanceof la.z
            if (r0 == 0) goto L13
            r0 = r6
            la.z r0 = (la.z) r0
            int r1 = r0.f6035i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6035i = r1
            goto L18
        L13:
            la.z r0 = new la.z
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f6034h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f6035i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            la.v r5 = r0.f6033g
            q7.v r1 = r0.f6032f
            w7.e0.N(r6)     // Catch: ma.a -> L2b
            goto L61
        L2b:
            r6 = move-exception
            goto L56
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            w7.e0.N(r6)
            q7.v r6 = new q7.v
            r6.<init>()
            la.v r2 = new la.v
            r4 = 1
            r2.<init>(r6, r4)
            r0.f6032f = r6     // Catch: ma.a -> L52
            r0.f6033g = r2     // Catch: ma.a -> L52
            r0.f6035i = r3     // Catch: ma.a -> L52
            java.lang.Object r5 = r5.x(r2, r0)     // Catch: ma.a -> L52
            if (r5 != r1) goto L50
            return r1
        L50:
            r1 = r6
            goto L61
        L52:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L56:
            java.lang.Object r2 = r6.f6475f
            if (r2 != r5) goto L64
            g7.l r5 = r0.getContext()
            ia.d0.h(r5)
        L61:
            java.lang.Object r5 = r1.f8820f
            return r5
        L64:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: la.k0.l(la.j, i7.c):java.lang.Object");
    }

    public static final j m(g0 g0Var, g7.l lVar, int i2, ka.a aVar) {
        return ((i2 == 0 || i2 == -3) && aVar == ka.a.f5661f) ? g0Var : new ma.g(i2, lVar, aVar, g0Var);
    }
}
