package v3;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public sc.c f14701a;

    /* renamed from: b, reason: collision with root package name */
    public sa.c f14702b;

    /* renamed from: c, reason: collision with root package name */
    public l5.j f14703c;

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f14702b.f12170f).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [v3.p0] */
    /* JADX WARN: Type inference failed for: r6v1, types: [sc.a] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4, types: [sc.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(xb.l r7, pb.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof v3.n0
            if (r0 == 0) goto L13
            r0 = r8
            v3.n0 r0 = (v3.n0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            v3.n0 r0 = new v3.n0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f14688g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L38
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f14686c
            sc.a r6 = (sc.a) r6
            id.c.I(r8)     // Catch: java.lang.Throwable -> L2f
            goto L61
        L2f:
            r7 = move-exception
            goto L65
        L31:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L38:
            sc.c r6 = r0.f14687f
            java.lang.Object r7 = r0.f14686c
            xb.l r7 = (xb.l) r7
            id.c.I(r8)
            goto L54
        L42:
            id.c.I(r8)
            sc.c r6 = r6.f14701a
            r0.f14686c = r7
            r0.f14687f = r6
            r0.i = r4
            java.lang.Object r8 = r6.d(r0)
            if (r8 != r1) goto L54
            goto L60
        L54:
            r0.f14686c = r6     // Catch: java.lang.Throwable -> L2f
            r0.f14687f = r5     // Catch: java.lang.Throwable -> L2f
            r0.i = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = r7.invoke(r0)     // Catch: java.lang.Throwable -> L2f
            if (r8 != r1) goto L61
        L60:
            return r1
        L61:
            r6.e(r5)
            return r8
        L65:
            r6.e(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.p0.b(xb.l, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(xb.p r7, pb.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof v3.o0
            if (r0 == 0) goto L13
            r0 = r8
            v3.o0 r0 = (v3.o0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            v3.o0 r0 = new v3.o0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f14696g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2e
            boolean r6 = r0.f14695f
            sc.c r7 = r0.f14694c
            id.c.I(r8)     // Catch: java.lang.Throwable -> L2c
            goto L53
        L2c:
            r8 = move-exception
            goto L5e
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L35:
            id.c.I(r8)
            sc.c r6 = r6.f14701a
            boolean r8 = r6.f()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L59
            r0.f14694c = r6     // Catch: java.lang.Throwable -> L59
            r0.f14695f = r8     // Catch: java.lang.Throwable -> L59
            r0.i = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L59
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L53:
            if (r6 == 0) goto L58
            r7.e(r4)
        L58:
            return r8
        L59:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L5e:
            if (r6 == 0) goto L63
            r7.e(r4)
        L63:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.p0.c(xb.p, pb.c):java.lang.Object");
    }
}
