package nc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final pc.t f8871a = new pc.t("NO_VALUE");

    /* renamed from: b, reason: collision with root package name */
    public static final pc.t f8872b = new pc.t("NONE");

    /* renamed from: c, reason: collision with root package name */
    public static final pc.t f8873c = new pc.t("PENDING");

    public static final t0 a(Object obj) {
        if (obj == null) {
            obj = oc.c.f9367b;
        }
        return new t0(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(nc.v0 r4, v3.m r5, java.lang.Throwable r6, pb.c r7) {
        /*
            boolean r0 = r7 instanceof nc.j
            if (r0 == 0) goto L13
            r0 = r7
            nc.j r0 = (nc.j) r0
            int r1 = r0.f8859g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8859g = r1
            goto L18
        L13:
            nc.j r0 = new nc.j
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8858f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8859g
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2b
            java.lang.Throwable r6 = r0.f8857c
            id.c.I(r7)     // Catch: java.lang.Throwable -> L29
            goto L40
        L29:
            r4 = move-exception
            goto L43
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L32:
            id.c.I(r7)
            r0.f8857c = r6     // Catch: java.lang.Throwable -> L29
            r0.f8859g = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L40
            return r1
        L40:
            jb.v r4 = jb.v.f6774a
            return r4
        L43:
            if (r6 == 0) goto L4a
            if (r6 == r4) goto L4a
            com.stepos.statsrpk.h.b(r4, r6)
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.k0.b(nc.v0, v3.m, java.lang.Throwable, pb.c):java.lang.Object");
    }

    public static final void c(Object[] objArr, long j10, Object obj) {
        objArr[((int) j10) & (objArr.length - 1)] = obj;
    }

    public static g d(g gVar, int i) {
        mc.a aVar = mc.a.f8550c;
        if (i < 0 && i != -2 && i != -1) {
            od.f.c(k0.a.j(i, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was "));
            return null;
        }
        if (i == -1) {
            aVar = mc.a.f8551f;
            i = 0;
        }
        int i3 = i;
        mc.a aVar2 = aVar;
        return gVar instanceof oc.r ? oc.c.a((oc.r) gVar, null, i3, aVar2, 1) : new oc.g(gVar, null, i3, aVar2, 2);
    }

    public static final c e(xb.p pVar) {
        return new c(pVar, nb.h.f8811c, -2, mc.a.f8550c);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable f(nc.c0 r5, nc.h r6, pb.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof nc.o
            if (r0 == 0) goto L13
            r0 = r7
            nc.o r0 = (nc.o) r0
            int r1 = r0.f8894g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8894g = r1
            goto L18
        L13:
            nc.o r0 = new nc.o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8893f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8894g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2c
            yb.u r5 = r0.f8892c
            id.c.I(r7)     // Catch: java.lang.Throwable -> L2a
            goto L51
        L2a:
            r6 = move-exception
            goto L59
        L2c:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r3
        L32:
            id.c.I(r7)
            yb.u r7 = new yb.u
            r7.<init>()
            nc.e r2 = new nc.e     // Catch: java.lang.Throwable -> L52
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L57
            r2.f8837f = r6     // Catch: java.lang.Throwable -> L57
            r2.f8838g = r7     // Catch: java.lang.Throwable -> L57
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L57
            r0.f8892c = r7     // Catch: java.lang.Throwable -> L52
            r0.f8894g = r4     // Catch: java.lang.Throwable -> L52
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: java.lang.Throwable -> L52
            if (r5 != r1) goto L51
            return r1
        L51:
            return r3
        L52:
            r6 = move-exception
        L53:
            r5 = r7
            goto L59
        L55:
            r6 = r5
            goto L53
        L57:
            r5 = move-exception
            goto L55
        L59:
            java.lang.Object r5 = r5.f16098c
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            if (r5 == 0) goto L65
            boolean r7 = r5.equals(r6)
            if (r7 != 0) goto L87
        L65:
            nb.g r7 = r0.getContext()
            kc.w0 r0 = kc.w0.f7498c
            nb.e r7 = r7.get(r0)
            kc.x0 r7 = (kc.x0) r7
            if (r7 == 0) goto L88
            boolean r0 = r7.isCancelled()
            if (r0 != 0) goto L7a
            goto L88
        L7a:
            java.util.concurrent.CancellationException r7 = r7.o()
            if (r7 == 0) goto L88
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L87
            goto L88
        L87:
            throw r6
        L88:
            if (r5 != 0) goto L8b
            return r6
        L8b:
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException
            if (r7 == 0) goto L93
            com.stepos.statsrpk.h.b(r5, r6)
            throw r5
        L93:
            com.stepos.statsrpk.h.b(r6, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.k0.f(nc.c0, nc.h, pb.c):java.io.Serializable");
    }

    public static final g g(g gVar) {
        if ((gVar instanceof r0) || (gVar instanceof f)) {
            return gVar;
        }
        f fVar = new f();
        fVar.f8840c = gVar;
        VarHandle.storeStoreFence();
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0055, B:29:0x006a, B:31:0x0072, B:20:0x0046, B:24:0x0051), top: B:52:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0084 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(nc.h r7, mc.i r8, boolean r9, pb.c r10) {
        /*
            boolean r0 = r10 instanceof nc.i
            if (r0 == 0) goto L13
            r0 = r10
            nc.i r0 = (nc.i) r0
            int r1 = r0.f8850j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8850j = r1
            goto L18
        L13:
            nc.i r0 = new nc.i
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.i
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8850j
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4a
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L37
            boolean r9 = r0.f8849h
            mc.b r7 = r0.f8848g
            mc.i r8 = r0.f8847f
            nc.h r2 = r0.f8846c
            id.c.I(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r2
            goto L55
        L35:
            r7 = move-exception
            goto L8f
        L37:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L3e:
            boolean r9 = r0.f8849h
            mc.b r7 = r0.f8848g
            mc.i r8 = r0.f8847f
            nc.h r2 = r0.f8846c
            id.c.I(r10)     // Catch: java.lang.Throwable -> L35
            goto L6a
        L4a:
            id.c.I(r10)
            boolean r10 = r7 instanceof nc.v0
            if (r10 != 0) goto Laa
            mc.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L55:
            r0.f8846c = r7     // Catch: java.lang.Throwable -> L35
            r0.f8847f = r8     // Catch: java.lang.Throwable -> L35
            r0.f8848g = r10     // Catch: java.lang.Throwable -> L35
            r0.f8849h = r9     // Catch: java.lang.Throwable -> L35
            r0.f8850j = r5     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L66
            goto L86
        L66:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L6a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L87
            java.lang.Object r10 = r7.c()     // Catch: java.lang.Throwable -> L35
            r0.f8846c = r2     // Catch: java.lang.Throwable -> L35
            r0.f8847f = r8     // Catch: java.lang.Throwable -> L35
            r0.f8848g = r7     // Catch: java.lang.Throwable -> L35
            r0.f8849h = r9     // Catch: java.lang.Throwable -> L35
            r0.f8850j = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L32
        L86:
            return r1
        L87:
            if (r9 == 0) goto L8c
            r8.e(r3)
        L8c:
            jb.v r7 = jb.v.f6774a
            return r7
        L8f:
            throw r7     // Catch: java.lang.Throwable -> L90
        L90:
            r10 = move-exception
            if (r9 == 0) goto La9
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9a
            r3 = r7
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
        L9a:
            if (r3 != 0) goto La6
            java.util.concurrent.CancellationException r3 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r3.<init>(r9)
            r3.initCause(r7)
        La6:
            r8.e(r3)
        La9:
            throw r10
        Laa:
            nc.v0 r7 = (nc.v0) r7
            java.lang.Throwable r7 = r7.f8939c
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.k0.h(nc.h, mc.i, boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(nc.g r7, nb.c r8) {
        /*
            pc.t r0 = oc.c.f9367b
            boolean r1 = r8 instanceof nc.y
            if (r1 == 0) goto L15
            r1 = r8
            nc.y r1 = (nc.y) r1
            int r2 = r1.f8948h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f8948h = r2
            goto L1a
        L15:
            nc.y r1 = new nc.y
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.f8947g
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f8948h
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L36
            if (r3 != r5) goto L30
            e9.u r7 = r1.f8946f
            yb.u r1 = r1.f8945c
            id.c.I(r8)     // Catch: oc.a -> L2e
            goto L62
        L2e:
            r8 = move-exception
            goto L5e
        L30:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            return r4
        L36:
            id.c.I(r8)
            yb.u r8 = new yb.u
            r8.<init>()
            r8.f16098c = r0
            e9.u r3 = new e9.u
            r6 = 4
            r3.<init>(r6)
            r3.f3726f = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            r1.f8945c = r8     // Catch: oc.a -> L5a
            r1.f8946f = r3     // Catch: oc.a -> L5a
            r1.f8948h = r5     // Catch: oc.a -> L5a
            java.lang.Object r7 = r7.collect(r3, r1)     // Catch: oc.a -> L5a
            if (r7 != r2) goto L58
            return r2
        L58:
            r1 = r8
            goto L62
        L5a:
            r7 = move-exception
            r1 = r8
            r8 = r7
            r7 = r3
        L5e:
            java.lang.Object r2 = r8.f9361c
            if (r2 != r7) goto L6d
        L62:
            java.lang.Object r7 = r1.f16098c
            if (r7 == r0) goto L67
            return r7
        L67:
            java.lang.String r7 = "Expected at least one element"
            g5.f.m(r7)
            return r4
        L6d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.k0.i(nc.g, nb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(nc.g r6, xb.p r7, pb.c r8) {
        /*
            pc.t r0 = oc.c.f9367b
            boolean r1 = r8 instanceof nc.z
            if (r1 == 0) goto L15
            r1 = r8
            nc.z r1 = (nc.z) r1
            int r2 = r1.i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.i = r2
            goto L1a
        L15:
            nc.z r1 = new nc.z
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.f8952h
            ob.a r2 = ob.a.f9351c
            int r3 = r1.i
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L33
            g0.f r6 = r1.f8951g
            yb.u r7 = r1.f8950f
            pb.i r1 = r1.f8949c
            xb.p r1 = (xb.p) r1
            id.c.I(r8)     // Catch: oc.a -> L31
            goto L6f
        L31:
            r8 = move-exception
            goto L6b
        L33:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L3a:
            id.c.I(r8)
            yb.u r8 = new yb.u
            r8.<init>()
            r8.f16098c = r0
            g0.f r3 = new g0.f
            r5 = 4
            r3.<init>(r5)
            r3.f4141g = r7
            r3.f4140f = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            r5 = r7
            pb.i r5 = (pb.i) r5     // Catch: oc.a -> L66
            r1.f8949c = r5     // Catch: oc.a -> L66
            r1.f8950f = r8     // Catch: oc.a -> L66
            r1.f8951g = r3     // Catch: oc.a -> L66
            r1.i = r4     // Catch: oc.a -> L66
            java.lang.Object r6 = r6.collect(r3, r1)     // Catch: oc.a -> L66
            if (r6 != r2) goto L63
            return r2
        L63:
            r1 = r7
            r7 = r8
            goto L6f
        L66:
            r6 = move-exception
            r1 = r7
            r7 = r8
            r8 = r6
            r6 = r3
        L6b:
            java.lang.Object r2 = r8.f9361c
            if (r2 != r6) goto L88
        L6f:
            java.lang.Object r6 = r7.f16098c
            if (r6 == r0) goto L74
            return r6
        L74:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Expected at least one element matching the predicate "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L88:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.k0.j(nc.g, xb.p, pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final l5.j k(xb.p pVar) {
        l5.j jVar = new l5.j(1);
        jVar.f7749f = (pb.i) pVar;
        VarHandle.storeStoreFence();
        return jVar;
    }

    public static final g l(g0 g0Var, nb.g gVar, int i, mc.a aVar) {
        return ((i == 0 || i == -3) && aVar == mc.a.f8550c) ? g0Var : new oc.g(g0Var, gVar, i, aVar);
    }

    public static final f0 m(l5.j jVar, pc.c cVar, q0 q0Var, Float f5) {
        mc.i.f8593b.getClass();
        mc.h hVar = mc.h.f8591a;
        mc.a aVar = mc.a.f8550c;
        p5.u uVar = new p5.u(8, jVar, nb.h.f8811c);
        t0 t0VarA = a(f5);
        kc.w.t(cVar, (nb.g) uVar.f9808g, q0Var.equals(n0.f8890a) ? kc.u.f7481c : kc.u.f7484h, new androidx.lifecycle.i0(q0Var, (g) uVar.f9807f, t0VarA, f5, null, 6));
        return new f0(t0VarA);
    }
}
