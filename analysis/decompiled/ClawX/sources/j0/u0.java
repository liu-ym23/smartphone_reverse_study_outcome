package j0;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final i6.c f3442a = new i6.c();

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.m f3443b = new androidx.emoji2.text.m(12);

    /* renamed from: c, reason: collision with root package name */
    public final d6.e f3444c = new d6.e(new t0(2, null));

    public u0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f3443b.f621a).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [j0.u0] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v6, types: [i6.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(p5.l r7, h5.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof j0.r0
            if (r0 == 0) goto L13
            r0 = r8
            j0.r0 r0 = (j0.r0) r0
            int r1 = r0.f3424e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3424e = r1
            goto L18
        L13:
            j0.r0 r0 = new j0.r0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3423c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3424e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f3421a
            i6.a r6 = (i6.a) r6
            a.a.c0(r8)     // Catch: java.lang.Throwable -> L2f
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
            i6.c r6 = r0.f3422b
            java.lang.Object r7 = r0.f3421a
            p5.l r7 = (p5.l) r7
            a.a.c0(r8)
            goto L55
        L43:
            a.a.c0(r8)
            r0.f3421a = r7
            i6.c r6 = r6.f3442a
            r0.f3422b = r6
            r0.f3424e = r4
            java.lang.Object r8 = r6.c(r0)
            if (r8 != r1) goto L55
            goto L61
        L55:
            r0.f3421a = r6     // Catch: java.lang.Throwable -> L2f
            r0.f3422b = r5     // Catch: java.lang.Throwable -> L2f
            r0.f3424e = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = r7.invoke(r0)     // Catch: java.lang.Throwable -> L2f
            if (r8 != r1) goto L62
        L61:
            return r1
        L62:
            i6.c r6 = (i6.c) r6
            r6.e(r5)
            return r8
        L68:
            i6.c r6 = (i6.c) r6
            r6.e(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.u0.b(p5.l, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(p5.p r7, h5.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof j0.s0
            if (r0 == 0) goto L13
            r0 = r8
            j0.s0 r0 = (j0.s0) r0
            int r1 = r0.f3432e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3432e = r1
            goto L18
        L13:
            j0.s0 r0 = new j0.s0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3431c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3432e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            boolean r6 = r0.f3430b
            i6.c r7 = r0.f3429a
            a.a.c0(r8)     // Catch: java.lang.Throwable -> L2c
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
            a.a.c0(r8)
            i6.c r6 = r6.f3442a
            boolean r8 = r6.d()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L5a
            r0.f3429a = r6     // Catch: java.lang.Throwable -> L5a
            r0.f3430b = r8     // Catch: java.lang.Throwable -> L5a
            r0.f3432e = r3     // Catch: java.lang.Throwable -> L5a
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
        throw new UnsupportedOperationException("Method not decompiled: j0.u0.c(p5.p, h5.c):java.lang.Object");
    }
}
