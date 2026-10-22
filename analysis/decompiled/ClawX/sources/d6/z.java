package d6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.emoji2.text.r f1922a = new androidx.emoji2.text.r("NONE", 1);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.r f1923b = new androidx.emoji2.text.r("PENDING", 1);

    public static final y a(Object obj) {
        if (obj == null) {
            obj = e6.i.f2386a;
        }
        return new y(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(d6.b0 r4, j0.n r5, java.lang.Throwable r6, h5.c r7) {
        /*
            boolean r0 = r7 instanceof d6.g
            if (r0 == 0) goto L13
            r0 = r7
            d6.g r0 = (d6.g) r0
            int r1 = r0.f1869c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1869c = r1
            goto L18
        L13:
            d6.g r0 = new d6.g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f1868b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f1869c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r6 = r0.f1867a
            a.a.c0(r7)     // Catch: java.lang.Throwable -> L29
            goto L41
        L29:
            r4 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r7)
            r0.f1867a = r6     // Catch: java.lang.Throwable -> L29
            r0.f1869c = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L41
            return r1
        L41:
            b5.a0 r4 = b5.a0.f883a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            a.a.a(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.z.b(d6.b0, j0.n, java.lang.Throwable, h5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0056, B:29:0x006b, B:31:0x0073, B:20:0x0047, B:24:0x0052), top: B:52:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v5, types: [c6.q] */
    /* JADX WARN: Type inference failed for: r8v7, types: [c6.q] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0085 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(d6.c r7, c6.o r8, boolean r9, h5.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof d6.f
            if (r0 == 0) goto L13
            r0 = r10
            d6.f r0 = (d6.f) r0
            int r1 = r0.f1866f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1866f = r1
            goto L18
        L13:
            d6.f r0 = new d6.f
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f1865e
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f1866f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            boolean r9 = r0.d
            c6.b r7 = r0.f1864c
            c6.q r8 = r0.f1863b
            d6.c r2 = r0.f1862a
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L35
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
            boolean r9 = r0.d
            c6.b r7 = r0.f1864c
            c6.q r8 = r0.f1863b
            d6.c r2 = r0.f1862a
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L35
            goto L6b
        L4b:
            a.a.c0(r10)
            boolean r10 = r7 instanceof d6.b0
            if (r10 != 0) goto Lab
            c6.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L56:
            r0.f1862a = r7     // Catch: java.lang.Throwable -> L35
            r0.f1863b = r8     // Catch: java.lang.Throwable -> L35
            r0.f1864c = r10     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f1866f = r5     // Catch: java.lang.Throwable -> L35
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
            r0.f1862a = r2     // Catch: java.lang.Throwable -> L35
            r0.f1863b = r8     // Catch: java.lang.Throwable -> L35
            r0.f1864c = r7     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f1866f = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L32
        L87:
            return r1
        L88:
            if (r9 == 0) goto L8d
            r8.e(r3)
        L8d:
            b5.a0 r7 = b5.a0.f883a
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
            r8.e(r3)
        Laa:
            throw r10
        Lab:
            d6.b0 r7 = (d6.b0) r7
            java.lang.Throwable r7 = r7.f1855a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.z.c(d6.c, c6.o, boolean, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(d6.b r6, h5.c r7) {
        /*
            boolean r0 = r7 instanceof d6.r
            if (r0 == 0) goto L13
            r0 = r7
            d6.r r0 = (d6.r) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            d6.r r0 = new d6.r
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f1905c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            androidx.emoji2.text.r r3 = e6.i.f2386a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            d6.q r6 = r0.f1904b
            kotlin.jvm.internal.y r1 = r0.f1903a
            a.a.c0(r7)     // Catch: e6.a -> L2d
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
            a.a.c0(r7)
            kotlin.jvm.internal.y r7 = new kotlin.jvm.internal.y
            r7.<init>()
            r7.f3686a = r3
            d6.q r2 = new d6.q
            r5 = 0
            r2.<init>(r5, r7)
            r0.f1903a = r7     // Catch: e6.a -> L56
            r0.f1904b = r2     // Catch: e6.a -> L56
            r0.d = r4     // Catch: e6.a -> L56
            java.lang.Object r6 = r6.collect(r2, r0)     // Catch: e6.a -> L56
            if (r6 != r1) goto L54
            return r1
        L54:
            r1 = r7
            goto L65
        L56:
            r6 = move-exception
            r1 = r7
            r7 = r6
            r6 = r2
        L5a:
            java.lang.Object r2 = r7.f2369a
            if (r2 != r6) goto L72
            f5.h r6 = r0.getContext()
            a6.i0.h(r6)
        L65:
            java.lang.Object r6 = r1.f3686a
            if (r6 == r3) goto L6a
            return r6
        L6a:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Expected at least one element"
            r6.<init>(r7)
            throw r6
        L72:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.z.d(d6.b, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(d6.b r5, p5.p r6, h5.c r7) {
        /*
            boolean r0 = r7 instanceof d6.t
            if (r0 == 0) goto L13
            r0 = r7
            d6.t r0 = (d6.t) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            d6.t r0 = new d6.t
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f1912c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            d6.p r5 = r0.f1911b
            kotlin.jvm.internal.y r6 = r0.f1910a
            a.a.c0(r7)     // Catch: e6.a -> L2b
            goto L61
        L2b:
            r7 = move-exception
            goto L56
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            a.a.c0(r7)
            kotlin.jvm.internal.y r7 = new kotlin.jvm.internal.y
            r7.<init>()
            d6.p r2 = new d6.p
            r4 = 1
            r2.<init>(r6, r7, r4)
            r0.f1910a = r7     // Catch: e6.a -> L52
            r0.f1911b = r2     // Catch: e6.a -> L52
            r0.d = r3     // Catch: e6.a -> L52
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: e6.a -> L52
            if (r5 != r1) goto L50
            return r1
        L50:
            r6 = r7
            goto L61
        L52:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r2
        L56:
            java.lang.Object r1 = r7.f2369a
            if (r1 != r5) goto L64
            f5.h r5 = r0.getContext()
            a6.i0.h(r5)
        L61:
            java.lang.Object r5 = r6.f3686a
            return r5
        L64:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.z.e(d6.b, p5.p, h5.c):java.lang.Object");
    }

    public static final b f(w wVar, f5.h hVar, int i8, c6.a aVar) {
        return ((((i8 < 0 || i8 >= 2) && i8 != -2) || aVar != c6.a.f1103b) && !((i8 == 0 || i8 == -3) && aVar == c6.a.f1102a)) ? new e6.e(wVar, hVar, i8, aVar) : wVar;
    }
}
