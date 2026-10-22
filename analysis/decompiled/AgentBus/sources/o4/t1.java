package o4;

import com.stepos.agentbus.config.EnvProvider;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class t1 {
    public final la.e0 A;
    public final la.j0 B;
    public final la.j0 C;
    public final c7.o D;
    public volatile i0 E;
    public volatile boolean F;
    public volatile boolean G;
    public volatile Boolean H;
    public volatile boolean I;
    public volatile ia.w1 J;
    public volatile ia.w1 K;
    public volatile String L;
    public final ConcurrentHashMap.KeySetView M;

    /* renamed from: a, reason: collision with root package name */
    public final ia.b0 f7573a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f7574b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f7575c;

    /* renamed from: d, reason: collision with root package name */
    public final p7.o f7576d;

    /* renamed from: e, reason: collision with root package name */
    public final p7.n f7577e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.o f7578f;

    /* renamed from: g, reason: collision with root package name */
    public final p7.n f7579g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f7580h;

    /* renamed from: i, reason: collision with root package name */
    public final b0.y f7581i;

    /* renamed from: j, reason: collision with root package name */
    public final p7.a f7582j;

    /* renamed from: k, reason: collision with root package name */
    public final k5.t f7583k;

    /* renamed from: l, reason: collision with root package name */
    public final p7.a f7584l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7585m;

    /* renamed from: n, reason: collision with root package name */
    public final i7.i f7586n;

    /* renamed from: o, reason: collision with root package name */
    public final i7.i f7587o;

    /* renamed from: p, reason: collision with root package name */
    public final i7.i f7588p;

    /* renamed from: q, reason: collision with root package name */
    public final f f7589q;

    /* renamed from: r, reason: collision with root package name */
    public final z5.c f7590r;

    /* renamed from: s, reason: collision with root package name */
    public final EnvProvider f7591s;

    /* renamed from: t, reason: collision with root package name */
    public final p7.a f7592t;

    /* renamed from: u, reason: collision with root package name */
    public final w f7593u;

    /* renamed from: v, reason: collision with root package name */
    public final p7.a f7594v;

    /* renamed from: w, reason: collision with root package name */
    public b0.r f7595w;

    /* renamed from: x, reason: collision with root package name */
    public final f1 f7596x;

    /* renamed from: y, reason: collision with root package name */
    public final f1 f7597y;

    /* renamed from: z, reason: collision with root package name */
    public final la.j0 f7598z;

    /* JADX WARN: Multi-variable type inference failed */
    public t1(ia.b0 b0Var, c0 c0Var, d0 d0Var, p7.o oVar, p7.n nVar, p7.o oVar2, s1.t tVar, p7.n nVar2, b0.y yVar, p7.a aVar, k5.t tVar2, p7.a aVar2, boolean z4, p7.k kVar, p7.k kVar2, p7.k kVar3, x5.e eVar, z5.c cVar, EnvProvider envProvider, p7.a aVar3, w wVar, y4.e eVar2) {
        q7.k.e(b0Var, "scope");
        q7.k.e(tVar2, "logger");
        q7.k.e(aVar2, "bootstrapTokenProvider");
        q7.k.e(envProvider, "envProvider");
        this.f7573a = b0Var;
        this.f7574b = c0Var;
        this.f7575c = d0Var;
        this.f7576d = oVar;
        this.f7577e = nVar;
        this.f7578f = oVar2;
        this.f7579g = tVar;
        this.f7580h = nVar2;
        this.f7581i = yVar;
        this.f7582j = aVar;
        this.f7583k = tVar2;
        this.f7584l = aVar2;
        this.f7585m = z4;
        this.f7586n = (i7.i) kVar;
        this.f7587o = (i7.i) kVar2;
        this.f7588p = (i7.i) kVar3;
        this.f7589q = eVar;
        this.f7590r = cVar;
        this.f7591s = envProvider;
        this.f7592t = aVar3;
        this.f7593u = wVar;
        this.f7594v = eVar2;
        this.f7596x = new f1(this, "operator");
        this.f7597y = new f1(this, "node");
        la.j0 j0VarB = la.k0.b(0, 1, 5);
        this.f7598z = j0VarB;
        this.A = new la.e0(j0VarB);
        this.B = la.k0.b(0, 256, 5);
        this.C = la.k0.b(0, 256, 5);
        this.D = s7.a.H(new b0.d0(10));
        this.F = true;
        this.G = true;
        this.L = "reconnect";
        this.M = ConcurrentHashMap.newKeySet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0188, code lost:
    
        if (r0.g(false, r3) == r4) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o4.t1 r27, i7.c r28) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.a(o4.t1, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[PHI: r14
      0x00d2: PHI (r14v3 o4.t1) = (r14v2 o4.t1), (r14v7 o4.t1) binds: [B:44:0x00cf, B:18:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o4.t1 r14, i7.c r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.b(o4.t1, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(o4.t1 r16, o4.f1 r17, java.lang.String r18, long r19, i7.c r21) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.c(o4.t1, o4.f1, java.lang.String, long, i7.c):java.lang.Object");
    }

    public final void d(String str) {
        ia.w1 w1Var = this.J;
        if (w1Var != null) {
            ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        this.J = null;
        if (this.I) {
            this.I = false;
            k5.s.info$default(this.f7583k, "OpenClawGateway", a1.a.j("screenOffConnectOverride cleared (", str, ")"), null, 4, null);
            boolean z4 = this.G;
            boolean z10 = this.F;
            boolean zF = f();
            if (this.E == null || z4 || z10 || zF) {
                return;
            }
            k5.s.info$default(this.f7583k, "OpenClawGateway", "screen still off after override cleared → close WS to stop ping", null, 4, null);
            this.f7596x.f();
            this.f7597y.f();
        }
    }

    public final void e(y yVar, y yVar2, z1 z1Var, v2 v2Var) {
        i0 i0Var = new i0(yVar, yVar2, z1Var, v2Var);
        this.E = i0Var;
        this.f7596x.m(i0Var);
        if (!z1Var.f7726j) {
            this.f7597y.m(i0Var);
        } else {
            ia.d0.s(this.f7573a, null, null, new a5.b(this, i0Var, null, 23), 3);
        }
    }

    public final boolean f() {
        ConcurrentHashMap.KeySetView keySetView = this.M;
        q7.k.d(keySetView, "activeInvokeIds");
        if (!keySetView.isEmpty() || !this.f7596x.f7347d.isEmpty() || !this.f7597y.f7347d.isEmpty()) {
            return true;
        }
        ConcurrentHashMap concurrentHashMap = b2.f7283a;
        return !b2.e().isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(boolean r19, i7.c r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.g(boolean, i7.c):java.lang.Object");
    }

    public final void h() {
        if (this.G || this.I) {
            return;
        }
        this.f7596x.u();
        this.f7597y.u();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r5, java.lang.String r6, long r7, i7.c r9) throws org.json.JSONException {
        /*
            r4 = this;
            boolean r0 = r9 instanceof o4.m1
            if (r0 == 0) goto L14
            r0 = r9
            o4.m1 r0 = (o4.m1) r0
            int r1 = r0.f7451h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f7451h = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            o4.m1 r0 = new o4.m1
            r0.<init>(r4, r9)
            goto L12
        L1a:
            java.lang.Object r0 = r9.f7449f
            h7.a r1 = h7.a.f4212f
            int r2 = r9.f7451h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            w7.e0.N(r0)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            w7.e0.N(r0)
            r9.f7451h = r3
            o4.f1 r4 = r4.f7596x
            java.lang.Object r0 = r4.p(r5, r6, r7, r9)
            if (r0 != r1) goto L3f
            return r1
        L3f:
            o4.n0 r0 = (o4.n0) r0
            boolean r4 = r0.f7465b
            if (r4 == 0) goto L4c
            java.lang.String r4 = r0.f7466c
            if (r4 != 0) goto L4b
            java.lang.String r4 = ""
        L4b:
            return r4
        L4c:
            o4.j0 r4 = r0.f7467d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            if (r4 == 0) goto L55
            java.lang.String r6 = r4.f7405a
            goto L57
        L55:
            java.lang.String r6 = "UNAVAILABLE"
        L57:
            if (r4 == 0) goto L5c
            java.lang.String r4 = r4.f7406b
            goto L5e
        L5c:
            java.lang.String r4 = "request failed"
        L5e:
            java.lang.String r7 = ": "
            java.lang.String r4 = a1.a.x(r6, r7, r4)
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.i(java.lang.String, java.lang.String, long, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(i7.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof o4.o1
            if (r0 == 0) goto L13
            r0 = r7
            o4.o1 r0 = (o4.o1) r0
            int r1 = r0.f7495i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7495i = r1
            goto L18
        L13:
            o4.o1 r0 = new o4.o1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f7493g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7495i
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            o4.t1 r6 = r0.f7492f
            w7.e0.N(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            w7.e0.N(r7)
            long r4 = java.lang.System.currentTimeMillis()
            o4.q1 r7 = new o4.q1
            r2 = 0
            r7.<init>(r6, r4, r2)
            r0.f7492f = r6
            r0.f7495i = r3
            java.lang.Object r7 = ia.d0.f(r7, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            o4.f1 r7 = r6.f7596x
            la.u0 r7 = r7.f7345b
            java.lang.Object r7 = r7.getValue()
            o4.h1 r0 = o4.h1.ONLINE
            c7.r r1 = c7.r.f1986a
            if (r7 != r0) goto L5c
            la.j0 r6 = r6.f7598z
            r6.M(r1)
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.j(i7.c):java.lang.Object");
    }

    public final void k(boolean z4) {
        if (this.F == z4) {
            return;
        }
        this.F = z4;
        ia.w1 w1Var = this.K;
        if (w1Var != null) {
            ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        this.K = ia.d0.s(this.f7573a, null, null, new r1(z4, this, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(long r6, i7.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof o4.s1
            if (r0 == 0) goto L13
            r0 = r8
            o4.s1 r0 = (o4.s1) r0
            int r1 = r0.f7561h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7561h = r1
            goto L18
        L13:
            o4.s1 r0 = new o4.s1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f7559f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7561h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r8)
            goto L42
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            w7.e0.N(r8)
            a6.r r8 = new a6.r
            r2 = 0
            r4 = 7
            r8.<init>(r5, r2, r4)
            r0.f7561h = r3
            java.lang.Object r8 = ia.d0.D(r6, r8, r0)
            if (r8 != r1) goto L42
            return r1
        L42:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L4b
            boolean r5 = r8.booleanValue()
            goto L4c
        L4b:
            r5 = 0
        L4c:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t1.l(long, i7.c):java.lang.Object");
    }

    public final Object m(j1 j1Var) {
        return a.a(new j1.s(0, this, t1.class, "hasPendingActivity", "hasPendingActivity()Z", 0, 1), new e0(this, 0), 120000L, 500L, new a5.a(16, this), j1Var);
    }

    public final void n(boolean z4) {
        if (!z4) {
            this.f7596x.w(false);
            this.f7597y.w(false);
            return;
        }
        synchronized (this) {
            this.L = "push";
        }
        boolean z10 = this.G;
        boolean zF = f();
        if (!z10 && !zF) {
            this.I = true;
            ia.w1 w1Var = this.J;
            g7.d dVar = null;
            if (w1Var != null) {
                ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
            }
            this.J = ia.d0.s(this.f7573a, null, null, new a5.b(this, dVar, 22), 3);
            k5.s.info$default(this.f7583k, "OpenClawGateway", "screenOffConnectOverride armed (CloudWake, grace=180000ms)", null, 4, null);
        }
        o(this.f7596x, "operator");
        o(this.f7597y, "node");
    }

    public final void o(f1 f1Var, String str) {
        if (f1Var.f7345b.getValue() == h1.ONLINE) {
            k5.s.info$default(this.f7583k, "OpenClawGateway", a1.a.j("CloudWake → skip (", str, " ONLINE)"), null, 4, null);
            return;
        }
        f1Var.w(true);
        k5.s.info$default(this.f7583k, "OpenClawGateway", "CloudWake → wakeIfNotOnline " + str + " state=" + f1Var.f7345b.getValue(), null, 4, null);
    }
}
