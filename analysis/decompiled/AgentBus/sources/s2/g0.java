package s2;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final ra.d f9368a = new ra.d();

    /* renamed from: b, reason: collision with root package name */
    public final o4.d0 f9369b = new o4.d0(8);

    /* renamed from: c, reason: collision with root package name */
    public final a7.d f9370c = new a7.d(new h5.c(2, null, 2));

    public g0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f9369b.f7326g).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [s2.g0] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v6, types: [ra.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(p7.k r7, i7.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof s2.e0
            if (r0 == 0) goto L13
            r0 = r8
            s2.e0 r0 = (s2.e0) r0
            int r1 = r0.f9358j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9358j = r1
            goto L18
        L13:
            s2.e0 r0 = new s2.e0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f9356h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9358j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f9354f
            ra.b r6 = (ra.b) r6
            w7.e0.N(r8)     // Catch: java.lang.Throwable -> L2f
            goto L62
        L2f:
            r7 = move-exception
            goto L68
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            ra.d r6 = r0.f9355g
            java.lang.Object r7 = r0.f9354f
            p7.k r7 = (p7.k) r7
            w7.e0.N(r8)
            goto L55
        L43:
            w7.e0.N(r8)
            r0.f9354f = r7
            ra.d r6 = r6.f9368a
            r0.f9355g = r6
            r0.f9358j = r4
            java.lang.Object r8 = r6.c(r0, r5)
            if (r8 != r1) goto L55
            goto L61
        L55:
            r0.f9354f = r6     // Catch: java.lang.Throwable -> L2f
            r0.f9355g = r5     // Catch: java.lang.Throwable -> L2f
            r0.f9358j = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = r7.invoke(r0)     // Catch: java.lang.Throwable -> L2f
            if (r8 != r1) goto L62
        L61:
            return r1
        L62:
            ra.d r6 = (ra.d) r6
            r6.e(r5)
            return r8
        L68:
            ra.d r6 = (ra.d) r6
            r6.e(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.g0.b(p7.k, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(p7.n r7, i7.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof s2.f0
            if (r0 == 0) goto L13
            r0 = r8
            s2.f0 r0 = (s2.f0) r0
            int r1 = r0.f9363j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9363j = r1
            goto L18
        L13:
            s2.f0 r0 = new s2.f0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f9361h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9363j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            boolean r6 = r0.f9360g
            ra.d r7 = r0.f9359f
            w7.e0.N(r8)     // Catch: java.lang.Throwable -> L2c
            goto L54
        L2c:
            r8 = move-exception
            goto L5f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            w7.e0.N(r8)
            ra.d r6 = r6.f9368a
            boolean r8 = r6.d(r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L5a
            r0.f9359f = r6     // Catch: java.lang.Throwable -> L5a
            r0.f9360g = r8     // Catch: java.lang.Throwable -> L5a
            r0.f9363j = r3     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L5a
            if (r7 != r1) goto L50
            return r1
        L50:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L54:
            if (r6 == 0) goto L59
            r7.e(r4)
        L59:
            return r8
        L5a:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L5f:
            if (r6 == 0) goto L64
            r7.e(r4)
        L64:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.g0.c(p7.n, i7.c):java.lang.Object");
    }
}
