package d5;

import ia.f1;
import ia.w1;
import java.util.concurrent.atomic.AtomicReference;
import la.e0;
import la.f0;
import la.j0;
import la.k0;
import la.s0;
import la.u0;

/* loaded from: classes.dex */
public final class z implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2927a;

    /* renamed from: b, reason: collision with root package name */
    public final m f2928b;

    /* renamed from: c, reason: collision with root package name */
    public final t f2929c;

    /* renamed from: d, reason: collision with root package name */
    public final a3.b f2930d;

    /* renamed from: e, reason: collision with root package name */
    public final c5.c f2931e;

    /* renamed from: f, reason: collision with root package name */
    public final s9.d f2932f;

    /* renamed from: g, reason: collision with root package name */
    public final c f2933g;

    /* renamed from: h, reason: collision with root package name */
    public final s f2934h;

    /* renamed from: i, reason: collision with root package name */
    public final k5.t f2935i;

    /* renamed from: j, reason: collision with root package name */
    public final k5.q f2936j;

    /* renamed from: k, reason: collision with root package name */
    public final na.d f2937k;

    /* renamed from: l, reason: collision with root package name */
    public final u0 f2938l;

    /* renamed from: m, reason: collision with root package name */
    public final j0 f2939m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference f2940n;

    /* renamed from: o, reason: collision with root package name */
    public w1 f2941o;

    /* renamed from: p, reason: collision with root package name */
    public final f0 f2942p;

    /* renamed from: q, reason: collision with root package name */
    public final e0 f2943q;

    public z(String str, m mVar, t tVar, a3.b bVar, c5.c cVar, s9.d dVar, c cVar2, s sVar, k5.a aVar, k5.t tVar2, k5.q qVar) {
        q7.k.e(mVar, "role");
        q7.k.e(cVar, "codec");
        q7.k.e(dVar, "validator");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar2, "logger");
        q7.k.e(qVar, "internalBus");
        this.f2927a = str;
        this.f2928b = mVar;
        this.f2929c = tVar;
        this.f2930d = bVar;
        this.f2931e = cVar;
        this.f2932f = dVar;
        this.f2933g = cVar2;
        this.f2934h = sVar;
        this.f2935i = tVar2;
        this.f2936j = qVar;
        this.f2937k = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5616a));
        u0 u0VarC = k0.c(n.f2894c);
        this.f2938l = u0VarC;
        j0 j0VarB = k0.b(0, 256, 5);
        this.f2939m = j0VarB;
        this.f2940n = new AtomicReference(null);
        this.f2942p = new f0(u0VarC);
        this.f2943q = new e0(j0VarB);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010c -> B:13:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x018f -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(d5.z r17, i7.c r18) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.z.j(d5.z, i7.c):java.lang.Object");
    }

    public static k5.j l(r rVar) {
        if (rVar.equals(q.f2898a)) {
            return k5.j.ONLINE;
        }
        if (!(rVar instanceof p) && rVar.equals(o.f2895a)) {
            return k5.j.DOWN;
        }
        return k5.j.OFFLINE;
    }

    @Override // d5.e
    public final la.j a() {
        return this.f2943q;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(i7.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof d5.v
            if (r0 == 0) goto L13
            r0 = r6
            d5.v r0 = (d5.v) r0
            int r1 = r0.f2912i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2912i = r1
            goto L18
        L13:
            d5.v r0 = new d5.v
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f2910g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f2912i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            d5.z r5 = r0.f2909f
            w7.e0.N(r6)     // Catch: java.lang.Throwable -> L2a
            goto L56
        L2a:
            r6 = move-exception
            goto L53
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            w7.e0.N(r6)
            ia.w1 r6 = r5.f2941o
            if (r6 == 0) goto L3e
            ia.f1.cancel$default(r6, r4, r3, r4)
        L3e:
            java.util.concurrent.atomic.AtomicReference r6 = r5.f2940n     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2a
            c6.l r6 = (c6.l) r6     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L56
            r0.f2909f = r5     // Catch: java.lang.Throwable -> L2a
            r0.f2912i = r3     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r6 = c6.k.close$default(r6, r4, r0, r3, r4)     // Catch: java.lang.Throwable -> L2a
            if (r6 != r1) goto L56
            return r1
        L53:
            w7.e0.n(r6)
        L56:
            d5.o r6 = d5.o.f2895a
            r5.m(r6)
            na.d r5 = r5.f2937k
            ia.d0.e(r5, r4)
            c7.r r5 = c7.r.f1986a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.z.b(i7.c):java.lang.Object");
    }

    @Override // d5.e
    public final t c() {
        return this.f2929c;
    }

    @Override // d5.e
    public final boolean d() {
        return d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return d.getClientId(this);
    }

    @Override // d5.e
    public final m f() {
        return this.f2928b;
    }

    @Override // d5.e
    public final String g() {
        return "stepclaw";
    }

    @Override // d5.e
    public final String getId() {
        return this.f2927a;
    }

    @Override // d5.e
    public final s0 h() {
        return this.f2942p;
    }

    @Override // d5.e
    public final Object i(c5.b bVar, i7.c cVar) {
        c6.l lVar = (c6.l) this.f2940n.get();
        u0 u0Var = this.f2938l;
        String str = this.f2927a;
        if (lVar != null) {
            if (!(u0Var.getValue() instanceof q)) {
                throw new f(str.concat(" not ONLINE"));
            }
            Object objB = lVar.b(((c5.d) this.f2931e).b(bVar), cVar);
            return objB == h7.a.f4212f ? objB : c7.r.f1986a;
        }
        throw new f(str + " not ONLINE (state=" + q7.w.f8821a.b(u0Var.getValue().getClass()).t() + ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(c6.l r13, i7.c r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof d5.w
            if (r0 == 0) goto L13
            r0 = r14
            d5.w r0 = (d5.w) r0
            int r1 = r0.f2917j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2917j = r1
            goto L18
        L13:
            d5.w r0 = new d5.w
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f2915h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f2917j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            ia.w1 r12 = r0.f2914g
            d5.z r13 = r0.f2913f
            w7.e0.N(r14)
            goto L59
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            w7.e0.N(r14)
            a5.b r14 = new a5.b
            r2 = 6
            r14.<init>(r13, r12, r4, r2)
            r2 = 3
            na.d r5 = r12.f2937k
            ia.w1 r14 = ia.d0.s(r5, r4, r4, r14, r2)
            la.e0 r13 = r13.d()
            r0.f2913f = r12
            r0.f2914g = r14
            r0.f2917j = r3
            java.lang.Object r13 = la.k0.j(r13, r0)
            if (r13 != r1) goto L55
            return r1
        L55:
            r11 = r13
            r13 = r12
            r12 = r14
            r14 = r11
        L59:
            c6.a r14 = (c6.a) r14
            ia.f1.cancel$default(r12, r4, r3, r4)
            java.util.concurrent.atomic.AtomicReference r12 = r13.f2940n
            r12.set(r4)
            k5.t r5 = r13.f2935i
            java.lang.String r12 = r13.f2927a
            java.lang.String r0 = r14.f1903b
            java.lang.String r1 = " channel closed: "
            java.lang.String r7 = a1.a.x(r12, r1, r0)
            r9 = 4
            r10 = 0
            java.lang.String r6 = "MgdClientConn"
            r8 = 0
            k5.s.info$default(r5, r6, r7, r8, r9, r10)
            d5.p r12 = new d5.p
            java.lang.String r0 = r14.f1903b
            if (r0 != 0) goto L7f
            java.lang.String r0 = "channel closed"
        L7f:
            java.lang.Throwable r14 = r14.f1904c
            r12.<init>(r0, r14)
            r13.m(r12)
            c7.r r12 = c7.r.f1986a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.z.k(c6.l, i7.c):java.lang.Object");
    }

    public final void m(r rVar) {
        u0 u0Var = this.f2938l;
        r rVar2 = (r) u0Var.getValue();
        if (rVar2.getClass() == rVar.getClass()) {
            return;
        }
        u0Var.getClass();
        u0Var.g(null, rVar);
        ((a7.d) this.f2936j).C(new k5.i(this.f2927a, l(rVar2), l(rVar)));
    }
}
