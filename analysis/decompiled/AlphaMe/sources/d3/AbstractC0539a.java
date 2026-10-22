package d3;

/* renamed from: d3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0539a {

    /* renamed from: a, reason: collision with root package name */
    public static final X.r f12442a = new X.r("NO_DECISION", 4);

    /* renamed from: b, reason: collision with root package name */
    public static final X.r f12443b = new X.r("UNDEFINED", 4);

    /* renamed from: c, reason: collision with root package name */
    public static final X.r f12444c = new X.r("REUSABLE_CLAIMED", 4);

    /* renamed from: d, reason: collision with root package name */
    public static final X.r f12445d = new X.r("CONDITION_FALSE", 4);

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[Catch: all -> 0x007b, DONT_GENERATE, TryCatch #1 {all -> 0x007b, blocks: (B:17:0x0052, B:19:0x0060, B:21:0x0066, B:34:0x00a1, B:24:0x007d, B:26:0x008b, B:31:0x0098, B:33:0x009e, B:39:0x00ae, B:42:0x00b7, B:41:0x00b4, B:29:0x0091), top: B:52:0x0052, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(kotlin.coroutines.Continuation r6, java.lang.Object r7, kotlin.jvm.functions.Function1 r8) {
        /*
            boolean r0 = r6 instanceof d3.i
            if (r0 == 0) goto Lc1
            d3.i r6 = (d3.i) r6
            java.lang.Throwable r0 = kotlin.Result.m25exceptionOrNullimpl(r7)
            if (r0 != 0) goto L16
            if (r8 == 0) goto L14
            Z2.s r0 = new Z2.s
            r0.<init>(r7, r8)
            goto L1d
        L14:
            r0 = r7
            goto L1d
        L16:
            Z2.r r8 = new Z2.r
            r1 = 0
            r8.<init>(r0, r1)
            r0 = r8
        L1d:
            Z2.A r8 = r6.f12455d
            kotlin.coroutines.Continuation r1 = r6.f12456e
            kotlin.coroutines.CoroutineContext r2 = r1.get$context()
            boolean r8 = r8.isDispatchNeeded(r2)
            r2 = 1
            if (r8 == 0) goto L3b
            r6.f12457f = r0
            r6.f2188c = r2
            kotlin.coroutines.CoroutineContext r7 = r1.get$context()
            Z2.A r8 = r6.f12455d
            r8.dispatch(r7, r6)
            goto Lc4
        L3b:
            Z2.V r8 = Z2.G0.a()
            boolean r3 = r8.u()
            if (r3 == 0) goto L4e
            r6.f12457f = r0
            r6.f2188c = r2
            r8.l(r6)
            goto Lc4
        L4e:
            r8.m(r2)
            r3 = 0
            kotlin.coroutines.CoroutineContext r4 = r1.get$context()     // Catch: java.lang.Throwable -> L7b
            Z2.n0 r5 = Z2.n0.f2230a     // Catch: java.lang.Throwable -> L7b
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7b
            Z2.o0 r4 = (Z2.o0) r4     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L7d
            boolean r5 = r4.a()     // Catch: java.lang.Throwable -> L7b
            if (r5 != 0) goto L7d
            Z2.x0 r4 = (Z2.x0) r4     // Catch: java.lang.Throwable -> L7b
            java.util.concurrent.CancellationException r7 = r4.C()     // Catch: java.lang.Throwable -> L7b
            r6.b(r0, r7)     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r7 = kotlin.Result.m22constructorimpl(r7)     // Catch: java.lang.Throwable -> L7b
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L7b
            goto La1
        L7b:
            r7 = move-exception
            goto Lb8
        L7d:
            java.lang.Object r0 = r6.f12458g     // Catch: java.lang.Throwable -> L7b
            kotlin.coroutines.CoroutineContext r4 = r1.get$context()     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r0 = d3.B.b(r4, r0)     // Catch: java.lang.Throwable -> L7b
            X.r r5 = d3.B.f12433a     // Catch: java.lang.Throwable -> L7b
            if (r0 == r5) goto L90
            Z2.I0 r5 = Z2.AbstractC0149x.b(r1, r4, r0)     // Catch: java.lang.Throwable -> L7b
            goto L91
        L90:
            r5 = r3
        L91:
            r1.resumeWith(r7)     // Catch: java.lang.Throwable -> Lab
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lab
            if (r5 == 0) goto L9e
            boolean r7 = r5.a0()     // Catch: java.lang.Throwable -> L7b
            if (r7 == 0) goto La1
        L9e:
            d3.B.a(r4, r0)     // Catch: java.lang.Throwable -> L7b
        La1:
            boolean r7 = r8.C()     // Catch: java.lang.Throwable -> L7b
            if (r7 != 0) goto La1
        La7:
            r8.e(r2)
            goto Lc4
        Lab:
            r7 = move-exception
            if (r5 == 0) goto Lb4
            boolean r1 = r5.a0()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto Lb7
        Lb4:
            d3.B.a(r4, r0)     // Catch: java.lang.Throwable -> L7b
        Lb7:
            throw r7     // Catch: java.lang.Throwable -> L7b
        Lb8:
            r6.f(r7, r3)     // Catch: java.lang.Throwable -> Lbc
            goto La7
        Lbc:
            r6 = move-exception
            r8.e(r2)
            throw r6
        Lc1:
            r6.resumeWith(r7)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.AbstractC0539a.a(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }
}
