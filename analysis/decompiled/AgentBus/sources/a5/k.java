package a5;

import c7.r;
import d5.m;
import d5.o;
import d5.q;
import k5.t;
import la.e0;
import la.f0;
import la.j0;
import la.k0;
import la.s0;
import la.u0;

/* loaded from: classes.dex */
public final class k implements d5.e {

    /* renamed from: a, reason: collision with root package name */
    public final t f263a;

    /* renamed from: b, reason: collision with root package name */
    public final b f264b;

    /* renamed from: c, reason: collision with root package name */
    public final m f265c;

    /* renamed from: d, reason: collision with root package name */
    public final u0 f266d;

    /* renamed from: e, reason: collision with root package name */
    public final f0 f267e;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f268f;

    public k(t tVar, b bVar) {
        q7.k.e(tVar, "logger");
        this.f263a = tVar;
        this.f264b = bVar;
        this.f265c = m.NODE;
        u0 u0VarC = k0.c(q.f2898a);
        this.f266d = u0VarC;
        j0 j0VarB = k0.b(0, 1, 5);
        this.f267e = new f0(u0VarC);
        this.f268f = new e0(j0VarB);
    }

    @Override // d5.e
    public final la.j a() {
        return this.f268f;
    }

    @Override // d5.e
    public final Object b(i7.c cVar) {
        u0 u0Var = this.f266d;
        u0Var.getClass();
        u0Var.g(null, o.f2895a);
        return r.f1986a;
    }

    @Override // d5.e
    public final d5.t c() {
        return d5.d.getDeployment(this);
    }

    @Override // d5.e
    public final boolean d() {
        return d5.d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return d5.d.getClientId(this);
    }

    @Override // d5.e
    public final m f() {
        return this.f265c;
    }

    @Override // d5.e
    public final String g() {
        return d5.d.getVendor(this);
    }

    @Override // d5.e
    public final String getId() {
        return "push-virtual";
    }

    @Override // d5.e
    public final s0 h() {
        return this.f267e;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(c5.b r6, i7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof a5.j
            if (r0 == 0) goto L13
            r0 = r7
            a5.j r0 = (a5.j) r0
            int r1 = r0.f262i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f262i = r1
            goto L18
        L13:
            a5.j r0 = new a5.j
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f260g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f262i
            c7.r r3 = c7.r.f1986a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            a5.k r5 = r0.f259f
            w7.e0.N(r7)     // Catch: java.lang.Throwable -> L2b
            goto L45
        L2b:
            r6 = move-exception
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            w7.e0.N(r7)
            a5.b r7 = r5.f264b     // Catch: java.lang.Throwable -> L2b
            r0.f259f = r5     // Catch: java.lang.Throwable -> L2b
            r0.f262i = r4     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r6 = r7.invoke(r6, r0)     // Catch: java.lang.Throwable -> L2b
            if (r6 != r1) goto L45
            return r1
        L45:
            r6 = r3
            goto L4b
        L47:
            c7.l r6 = w7.e0.n(r6)
        L4b:
            java.lang.Throwable r6 = c7.m.a(r6)
            if (r6 == 0) goto L64
            k5.t r5 = r5.f263a
            java.lang.String r7 = r6.getMessage()
            java.lang.String r0 = "onPushInvokeResult failed: "
            java.lang.String r7 = a1.a.w(r0, r7)
            k5.g r5 = (k5.g) r5
            java.lang.String r0 = "PushVirtualConn"
            r5.c(r0, r7, r6)
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.k.i(c5.b, i7.c):java.lang.Object");
    }
}
