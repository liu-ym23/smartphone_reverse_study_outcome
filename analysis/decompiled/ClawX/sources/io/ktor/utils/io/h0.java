package io.ktor.utils.io;

import a6.k1;
import a6.v1;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f3201a = new e0();

    /* renamed from: b, reason: collision with root package name */
    public static final j0 f3202b = new j0(null);

    public static p0 a(byte[] content) {
        int length = content.length;
        kotlin.jvm.internal.p.e(content, "content");
        j6.a aVar = new j6.a();
        aVar.s(content, length);
        return new p0(aVar);
    }

    public static final void b(p pVar) {
        kotlin.jvm.internal.p.e(pVar, "<this>");
        pVar.c(new IOException("Channel was cancelled"));
    }

    public static final void c(d0 d0Var, Throwable th) throws Throwable {
        kotlin.jvm.internal.p.e(d0Var, "<this>");
        if (th != null) {
            ((m) d0Var).c(th);
            return;
        }
        k1 k1Var = new k1(1, d0Var, d0.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0, 1);
        e0 e0Var = f3201a;
        try {
            f6.a.h(b8.h.u(new g5.b(k1Var)), b5.a0.f883a);
        } catch (Throwable th2) {
            a.a.D(e0Var, th2);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009d, code lost:
    
        if (r1.d(r7, r13) == r2) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10, types: [io.ktor.utils.io.d0] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.d0] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d9 -> B:44:0x00dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(io.ktor.utils.io.p r17, io.ktor.utils.io.d0 r18, long r19, h5.c r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.d(io.ktor.utils.io.p, io.ktor.utils.io.d0, long, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:26:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.ktor.utils.io.p r10, long r11, h5.c r13) throws java.io.EOFException {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.r
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.r r0 = (io.ktor.utils.io.r) r0
            int r1 = r0.f3238e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3238e = r1
            goto L18
        L13:
            io.ktor.utils.io.r r0 = new io.ktor.utils.io.r
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.d
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3238e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r10 = r0.f3237c
            long r4 = r0.f3236b
            io.ktor.utils.io.p r12 = r0.f3235a
            a.a.c0(r13)
            goto L5d
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            a.a.c0(r13)
            r4 = r11
        L39:
            r6 = 0
            int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r13 <= 0) goto L75
            boolean r13 = r10.e()
            if (r13 != 0) goto L75
            int r13 = g(r10)
            if (r13 != 0) goto L60
            r0.f3235a = r10
            r0.f3236b = r4
            r0.f3237c = r11
            r0.f3238e = r3
            java.lang.Object r13 = r10.d(r3, r0)
            if (r13 != r1) goto L5a
            return r1
        L5a:
            r8 = r11
            r12 = r10
            r10 = r8
        L5d:
            r8 = r10
            r10 = r12
            r11 = r8
        L60:
            j6.a r13 = r10.b()
            long r6 = x.f.W(r13)
            long r6 = java.lang.Math.min(r11, r6)
            j6.a r13 = r10.b()
            x.f.E(r13, r6)
            long r11 = r11 - r6
            goto L39
        L75:
            long r4 = r4 - r11
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.e(io.ktor.utils.io.p, long, h5.c):java.lang.Object");
    }

    public static final Object f(d0 d0Var, h5.c cVar) throws Throwable {
        Object objG;
        kotlin.jvm.internal.p.e(d0Var, "<this>");
        m mVar = (m) d0Var;
        Throwable thA = mVar.a();
        if (thA != null) {
            throw thA;
        }
        if (d0Var instanceof m) {
        }
        return (((int) mVar.j().f3512c) < 1048576 || (objG = mVar.g(cVar)) != g5.a.f2984a) ? b5.a0.f883a : objG;
    }

    public static final int g(p pVar) {
        kotlin.jvm.internal.p.e(pVar, "<this>");
        j6.a aVarB = pVar.b();
        aVarB.getClass();
        return (int) aVarB.f3512c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Comparable h(io.ktor.utils.io.p r4, int r5, h5.c r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.s
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.s r0 = (io.ktor.utils.io.s) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.s r0 = new io.ktor.utils.io.s
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3243c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.f3242b
            io.ktor.utils.io.p r4 = r0.f3241a
            a.a.c0(r6)
            goto L4a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r6)
            boolean r6 = r4.e()
            if (r6 == 0) goto L3d
            goto L52
        L3d:
            r0.f3241a = r4
            r0.f3242b = r5
            r0.d = r3
            java.lang.Object r6 = r4.d(r5, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L54
        L52:
            r4 = 0
            return r4
        L54:
            j6.a r4 = r4.b()
            j6.e r4 = r4.peek()
            byte[] r4 = j6.k.e(r4, r5)
            k6.a r5 = new k6.a
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.h(io.ktor.utils.io.p, int, h5.c):java.lang.Comparable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(io.ktor.utils.io.p r5, byte[] r6, int r7, h5.c r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.t
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.t r0 = (io.ktor.utils.io.t) r0
            int r1 = r0.f3247e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3247e = r1
            goto L18
        L13:
            io.ktor.utils.io.t r0 = new io.ktor.utils.io.t
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3247e
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            int r7 = r0.f3246c
            byte[] r6 = r0.f3245b
            io.ktor.utils.io.p r5 = r0.f3244a
            a.a.c0(r8)
            goto L5e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            a.a.c0(r8)
            boolean r8 = r5.e()
            if (r8 == 0) goto L45
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r3)
            return r5
        L45:
            j6.a r8 = r5.b()
            boolean r8 = r8.q()
            if (r8 == 0) goto L5e
            r0.f3244a = r5
            r0.f3245b = r6
            r0.f3246c = r7
            r0.f3247e = r4
            java.lang.Object r8 = r5.d(r4, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            boolean r8 = r5.e()
            if (r8 == 0) goto L6a
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r3)
            return r5
        L6a:
            j6.a r5 = r5.b()
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.p.e(r5, r8)
            java.lang.String r8 = "buffer"
            kotlin.jvm.internal.p.e(r6, r8)
            r8 = 0
            int r5 = r5.b(r8, r7, r6)
            if (r5 != r3) goto L80
            goto L81
        L80:
            r8 = r5
        L81:
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.i(io.ktor.utils.io.p, byte[], int, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(io.ktor.utils.io.p r4, h5.c r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.u
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.u r0 = (io.ktor.utils.io.u) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.u r0 = new io.ktor.utils.io.u
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f3250c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            j6.a r4 = r0.f3249b
            io.ktor.utils.io.p r2 = r0.f3248a
            a.a.c0(r5)
            r5 = r4
            r4 = r2
            goto L3d
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.a.c0(r5)
            j6.a r5 = new j6.a
            r5.<init>()
        L3d:
            boolean r2 = r4.e()
            if (r2 != 0) goto L57
            j6.a r2 = r4.b()
            r5.j(r2)
            r0.f3248a = r4
            r0.f3249b = r5
            r0.d = r3
            java.lang.Object r2 = r4.d(r3, r0)
            if (r2 != r1) goto L3d
            return r1
        L57:
            java.lang.Throwable r4 = r4.a()
            if (r4 != 0) goto L5e
            return r5
        L5e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.j(io.ktor.utils.io.p, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(io.ktor.utils.io.p r4, h5.c r5) throws java.io.EOFException {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.v
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.v r0 = (io.ktor.utils.io.v) r0
            int r1 = r0.f3253c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3253c = r1
            goto L18
        L13:
            io.ktor.utils.io.v r0 = new io.ktor.utils.io.v
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f3252b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3253c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.p r4 = r0.f3251a
            a.a.c0(r5)
            goto L49
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r5)
            j6.a r5 = r4.b()
            boolean r5 = r5.q()
            if (r5 == 0) goto L49
            r0.f3251a = r4
            r0.f3253c = r3
            java.lang.Object r5 = r4.d(r3, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            j6.a r5 = r4.b()
            boolean r5 = r5.q()
            if (r5 != 0) goto L60
            j6.a r4 = r4.b()
            byte r4 = r4.readByte()
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
            return r4
        L60:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r5 = "Not enough data available"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.k(io.ktor.utils.io.p, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004f -> B:24:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:23:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(io.ktor.utils.io.p r11, int r12, h5.c r13) throws java.io.EOFException {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.w
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.w r0 = (io.ktor.utils.io.w) r0
            int r1 = r0.f3257e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3257e = r1
            goto L18
        L13:
            io.ktor.utils.io.w r0 = new io.ktor.utils.io.w
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.d
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3257e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r11 = r0.f3256c
            j6.a r12 = r0.f3255b
            io.ktor.utils.io.p r2 = r0.f3254a
            a.a.c0(r13)
            goto L62
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            a.a.c0(r13)
            j6.a r13 = new j6.a
            r13.<init>()
            r10 = r13
            r13 = r12
            r12 = r10
        L40:
            long r4 = r12.f3512c
            long r6 = (long) r13
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L94
            j6.a r2 = r11.b()
            boolean r2 = r2.q()
            if (r2 == 0) goto L64
            r0.f3254a = r11
            r0.f3255b = r12
            r0.f3256c = r13
            r0.f3257e = r3
            java.lang.Object r2 = r11.d(r3, r0)
            if (r2 != r1) goto L60
            return r1
        L60:
            r2 = r11
            r11 = r13
        L62:
            r13 = r11
            r11 = r2
        L64:
            boolean r2 = r11.e()
            if (r2 != 0) goto L94
            j6.a r2 = r11.b()
            long r4 = x.f.W(r2)
            long r6 = (long) r13
            long r8 = r12.f3512c
            long r8 = r6 - r8
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 <= 0) goto L86
            j6.a r2 = r11.b()
            long r4 = r12.f3512c
            long r6 = r6 - r4
            r2.e(r12, r6)
            goto L40
        L86:
            j6.a r2 = r11.b()
            long r4 = r2.l(r12)
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r4)
            goto L40
        L94:
            long r0 = r12.f3512c
            long r2 = (long) r13
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 < 0) goto L9c
            return r12
        L9c:
            java.io.EOFException r11 = new java.io.EOFException
            java.lang.String r0 = "Not enough data available, required "
            java.lang.String r1 = " bytes but only "
            java.lang.StringBuilder r13 = a8.b.s(r13, r0, r1)
            long r0 = r12.f3512c
            java.lang.String r12 = " available"
            java.lang.String r12 = a8.b.r(r13, r0, r12)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.l(io.ktor.utils.io.p, int, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(io.ktor.utils.io.p r4, h5.c r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.x
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.x r0 = (io.ktor.utils.io.x) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.x r0 = new io.ktor.utils.io.x
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f3260c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            j6.a r4 = r0.f3259b
            io.ktor.utils.io.p r2 = r0.f3258a
            a.a.c0(r5)
            r5 = r4
            r4 = r2
            goto L3d
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.a.c0(r5)
            j6.a r5 = new j6.a
            r5.<init>()
        L3d:
            boolean r2 = r4.e()
            if (r2 != 0) goto L57
            j6.a r2 = r4.b()
            r5.j(r2)
            r0.f3258a = r4
            r0.f3259b = r5
            r0.d = r3
            java.lang.Object r2 = r4.d(r3, r0)
            if (r2 != r1) goto L3d
            return r1
        L57:
            java.lang.Throwable r4 = r4.a()
            if (r4 != 0) goto L61
            r5.getClass()
            return r5
        L61:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.m(io.ktor.utils.io.p, h5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (r18.d(1, r2) == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014a, code lost:
    
        r16 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0151, code lost:
    
        if (r13.f3512c >= r4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0153, code lost:
    
        r2.f3261a = r9;
        r2.f3262b = r15;
        r2.f3263c = r14;
        r2.d = r13;
        r2.f3264e = r4;
        r2.f3265f = r0;
        r2.f3267h = 3;
        r8 = 1;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0167, code lost:
    
        if (r9.d(1, r2) != r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0169, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018d, code lost:
    
        throw new x4.a("Line exceeds limit of " + r4 + " characters");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01b0: INVOKE (r14 I:java.lang.AutoCloseable), (r1 I:java.lang.Throwable) STATIC call: k4.v.l(java.lang.AutoCloseable, java.lang.Throwable):void A[MD:(java.lang.AutoCloseable, java.lang.Throwable):void throws java.lang.Exception (m)] (LINE:433), block:B:81:0x01b0 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5 A[Catch: all -> 0x0048, LOOP:0: B:38:0x00b5->B:61:0x0145, LOOP_START, TryCatch #0 {all -> 0x0048, blocks: (B:14:0x003f, B:36:0x00af, B:38:0x00b5, B:40:0x00bf, B:42:0x00cb, B:44:0x00d5, B:49:0x00ef, B:51:0x00fc, B:53:0x0117, B:52:0x0112, B:57:0x012c, B:61:0x0145, B:62:0x014a, B:64:0x0153, B:68:0x0172, B:69:0x018d, B:70:0x018e, B:74:0x019a, B:76:0x01a0, B:21:0x005e), top: B:83:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:14:0x003f, B:36:0x00af, B:38:0x00b5, B:40:0x00bf, B:42:0x00cb, B:44:0x00d5, B:49:0x00ef, B:51:0x00fc, B:53:0x0117, B:52:0x0112, B:57:0x012c, B:61:0x0145, B:62:0x014a, B:64:0x0153, B:68:0x0172, B:69:0x018d, B:70:0x018e, B:74:0x019a, B:76:0x01a0, B:21:0x005e), top: B:83:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0112 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:14:0x003f, B:36:0x00af, B:38:0x00b5, B:40:0x00bf, B:42:0x00cb, B:44:0x00d5, B:49:0x00ef, B:51:0x00fc, B:53:0x0117, B:52:0x0112, B:57:0x012c, B:61:0x0145, B:62:0x014a, B:64:0x0153, B:68:0x0172, B:69:0x018d, B:70:0x018e, B:74:0x019a, B:76:0x01a0, B:21:0x005e), top: B:83:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018e A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:14:0x003f, B:36:0x00af, B:38:0x00b5, B:40:0x00bf, B:42:0x00cb, B:44:0x00d5, B:49:0x00ef, B:51:0x00fc, B:53:0x0117, B:52:0x0112, B:57:0x012c, B:61:0x0145, B:62:0x014a, B:64:0x0153, B:68:0x0172, B:69:0x018d, B:70:0x018e, B:74:0x019a, B:76:0x01a0, B:21:0x005e), top: B:83:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [j6.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.Appendable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0167 -> B:67:0x016a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n(io.ktor.utils.io.p r18, m4.c r19, int r20, int r21, h5.c r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.n(io.ktor.utils.io.p, m4.c, int, int, h5.c):java.lang.Object");
    }

    public static final void o(int i8, int i9) throws IOException {
        List list = o0.f3224b;
        if ((i8 | i9) == i8) {
            return;
        }
        throw new IOException("Unexpected line ending " + ((Object) o0.a(i9)) + ", while expected " + ((Object) o0.a(i8)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0159, code lost:
    
        if (q(r14, r11, r12, r8, r2) == r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01a1 -> B:71:0x01f7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01da -> B:70:0x01dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(io.ktor.utils.io.p r22, k6.a r23, io.ktor.utils.io.d0 r24, long r25, boolean r27, h5.c r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.p(io.ktor.utils.io.p, k6.a, io.ktor.utils.io.d0, long, boolean, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(io.ktor.utils.io.d0 r4, byte[] r5, kotlin.jvm.internal.w r6, kotlin.jvm.internal.x r7, h5.c r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.a0
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.a0 r0 = (io.ktor.utils.io.a0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.a0 r0 = new io.ktor.utils.io.a0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f3176c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.x r7 = r0.f3175b
            kotlin.jvm.internal.w r6 = r0.f3174a
            a.a.c0(r8)
            goto L45
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r8)
            int r8 = r6.f3684a
            r0.f3174a = r6
            r0.f3175b = r7
            r0.d = r3
            java.lang.Object r4 = t(r4, r5, r8, r0)
            if (r4 != r1) goto L45
            return r1
        L45:
            long r4 = r7.f3685a
            int r8 = r6.f3684a
            long r0 = (long) r8
            long r4 = r4 + r0
            r7.f3685a = r4
            r4 = 0
            r6.f3684a = r4
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.q(io.ktor.utils.io.d0, byte[], kotlin.jvm.internal.w, kotlin.jvm.internal.x, h5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (e(r5, r6, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(io.ktor.utils.io.p r5, k6.a r6, h5.c r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.b0
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.b0 r0 = (io.ktor.utils.io.b0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.b0 r0 = new io.ktor.utils.io.b0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3181c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.a.c0(r7)
            goto L65
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            k6.a r6 = r0.f3180b
            io.ktor.utils.io.p r5 = r0.f3179a
            a.a.c0(r7)
            goto L4d
        L3a:
            a.a.c0(r7)
            byte[] r7 = r6.f3656a
            int r7 = r7.length
            r0.f3179a = r5
            r0.f3180b = r6
            r0.d = r4
            java.lang.Comparable r7 = h(r5, r7, r0)
            if (r7 != r1) goto L4d
            goto L64
        L4d:
            boolean r7 = kotlin.jvm.internal.p.a(r7, r6)
            if (r7 == 0) goto L68
            byte[] r6 = r6.f3656a
            int r6 = r6.length
            long r6 = (long) r6
            r2 = 0
            r0.f3179a = r2
            r0.f3180b = r2
            r0.d = r3
            java.lang.Object r5 = e(r5, r6, r0)
            if (r5 != r1) goto L65
        L64:
            return r1
        L65:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L68:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.r(io.ktor.utils.io.p, k6.a, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v2, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable s(io.ktor.utils.io.p r4, h5.c r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.c0
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.c0 r0 = (io.ktor.utils.io.c0) r0
            int r1 = r0.f3184b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3184b = r1
            goto L18
        L13:
            io.ktor.utils.io.c0 r0 = new io.ktor.utils.io.c0
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f3183a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3184b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.a.c0(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.a.c0(r5)
            r0.f3184b = r3
            java.lang.Object r5 = j(r4, r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            j6.a r5 = (j6.a) r5
            long r0 = r5.f3512c
            int r4 = (int) r0
            byte[] r4 = j6.k.e(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.s(io.ktor.utils.io.p, h5.c):java.io.Serializable");
    }

    public static final Object t(d0 d0Var, byte[] bArr, int i8, h5.c cVar) throws Throwable {
        m mVar = (m) d0Var;
        mVar.j().s(bArr, i8);
        Object objF = f(mVar, cVar);
        return objF == g5.a.f2984a ? objF : b5.a0.f883a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [io.ktor.utils.io.d0, io.ktor.utils.io.m] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object u(io.ktor.utils.io.d0 r16, j6.j r17, h5.c r18) throws java.io.EOFException {
        /*
            r0 = r18
            boolean r1 = r0 instanceof io.ktor.utils.io.f0
            if (r1 == 0) goto L15
            r1 = r0
            io.ktor.utils.io.f0 r1 = (io.ktor.utils.io.f0) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.d = r2
            goto L1a
        L15:
            io.ktor.utils.io.f0 r1 = new io.ktor.utils.io.f0
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f3191c
            g5.a r2 = g5.a.f2984a
            int r3 = r1.d
            r4 = 1
            if (r3 == 0) goto L39
            if (r3 != r4) goto L31
            j6.j r3 = r1.f3190b
            io.ktor.utils.io.m r5 = r1.f3189a
            a.a.c0(r0)
            r0 = r3
            r3 = r1
            r1 = r0
            r0 = r5
            goto L41
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            a.a.c0(r0)
            r0 = r16
            r3 = r1
            r1 = r17
        L41:
            boolean r5 = r1.q()
            if (r5 != 0) goto Lae
            io.ktor.utils.io.m r0 = (io.ktor.utils.io.m) r0
            j6.a r5 = r0.j()
            long r6 = x.f.W(r1)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L91
            r10 = r6
        L58:
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 <= 0) goto L84
            long r12 = r1.m(r5, r10)
            r14 = -1
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 == 0) goto L68
            long r10 = r10 - r12
            goto L58
        L68:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Source exhausted before reading "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r2 = " bytes. Only "
            r1.append(r2)
            long r6 = r6 - r10
            java.lang.String r2 = " were read."
            java.lang.String r1 = a8.b.r(r1, r6, r2)
            r0.<init>(r1)
            throw r0
        L84:
            r3.f3189a = r0
            r3.f3190b = r1
            r3.d = r4
            java.lang.Object r5 = f(r0, r3)
            if (r5 != r2) goto L41
            return r2
        L91:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "byteCount ("
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r1 = ") < 0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        Lae:
            b5.a0 r0 = b5.a0.f883a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h0.u(io.ktor.utils.io.d0, j6.j, h5.c):java.lang.Object");
    }

    public static q0 v(a6.f0 f0Var, f5.h coroutineContext, p5.p pVar, int i8) {
        if ((i8 & 1) != 0) {
            coroutineContext = f5.i.f2626a;
        }
        kotlin.jvm.internal.p.e(f0Var, "<this>");
        kotlin.jvm.internal.p.e(coroutineContext, "coroutineContext");
        m mVar = new m();
        v1 v1VarQ = a6.i0.q(f0Var, coroutineContext, new g0(pVar, mVar, null), 2);
        v1VarQ.A(new c5.a(6, mVar));
        return new q0(mVar, v1VarQ);
    }
}
