package d5;

import ia.f1;
import la.e0;
import la.f0;
import la.j0;
import la.k0;
import la.s0;
import la.u0;

/* loaded from: classes.dex */
public final class d0 implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2863a;

    /* renamed from: b, reason: collision with root package name */
    public final m f2864b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2865c;

    /* renamed from: d, reason: collision with root package name */
    public final c6.l f2866d;

    /* renamed from: e, reason: collision with root package name */
    public final c5.c f2867e;

    /* renamed from: f, reason: collision with root package name */
    public final s9.d f2868f;

    /* renamed from: g, reason: collision with root package name */
    public final k5.t f2869g;

    /* renamed from: h, reason: collision with root package name */
    public final k5.q f2870h;

    /* renamed from: i, reason: collision with root package name */
    public final na.d f2871i;

    /* renamed from: j, reason: collision with root package name */
    public final u0 f2872j;

    /* renamed from: k, reason: collision with root package name */
    public final j0 f2873k;

    /* renamed from: l, reason: collision with root package name */
    public final f0 f2874l;

    /* renamed from: m, reason: collision with root package name */
    public final e0 f2875m;

    public d0(String str, m mVar, String str2, c6.l lVar, c5.c cVar, s9.d dVar, k5.a aVar, k5.t tVar, k5.q qVar) {
        q7.k.e(str, "id");
        q7.k.e(mVar, "role");
        q7.k.e(cVar, "codec");
        q7.k.e(dVar, "validator");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        q7.k.e(qVar, "internalBus");
        this.f2863a = str;
        this.f2864b = mVar;
        this.f2865c = str2;
        this.f2866d = lVar;
        this.f2867e = cVar;
        this.f2868f = dVar;
        this.f2869g = tVar;
        this.f2870h = qVar;
        na.d dVarB = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5616a));
        this.f2871i = dVarB;
        u0 u0VarC = k0.c(q.f2898a);
        this.f2872j = u0VarC;
        j0 j0VarB = k0.b(0, 256, 5);
        this.f2873k = j0VarB;
        this.f2874l = new f0(u0VarC);
        this.f2875m = new e0(j0VarB);
        g7.d dVar2 = null;
        ia.d0.s(dVarB, null, null, new b0(this, dVar2, 0), 3);
        ia.d0.s(dVarB, null, null, new b0(this, dVar2, 1), 3);
    }

    public static k5.j j(r rVar) {
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
        return this.f2875m;
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
            boolean r0 = r6 instanceof d5.c0
            if (r0 == 0) goto L13
            r0 = r6
            d5.c0 r0 = (d5.c0) r0
            int r1 = r0.f2862i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2862i = r1
            goto L18
        L13:
            d5.c0 r0 = new d5.c0
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f2860g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f2862i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            d5.d0 r5 = r0.f2859f
            w7.e0.N(r6)     // Catch: java.lang.Throwable -> L2a
            goto L47
        L2a:
            r6 = move-exception
            goto L44
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            w7.e0.N(r6)
            c6.l r6 = r5.f2866d     // Catch: java.lang.Throwable -> L2a
            r0.f2859f = r5     // Catch: java.lang.Throwable -> L2a
            r0.f2862i = r4     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r6 = c6.k.close$default(r6, r3, r0, r4, r3)     // Catch: java.lang.Throwable -> L2a
            if (r6 != r1) goto L47
            return r1
        L44:
            w7.e0.n(r6)
        L47:
            d5.o r6 = d5.o.f2895a
            r5.k(r6)
            na.d r5 = r5.f2871i
            ia.d0.e(r5, r3)
            c7.r r5 = c7.r.f1986a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.d0.b(i7.c):java.lang.Object");
    }

    @Override // d5.e
    public final t c() {
        return null;
    }

    @Override // d5.e
    public final boolean d() {
        return d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return this.f2865c;
    }

    @Override // d5.e
    public final m f() {
        return this.f2864b;
    }

    @Override // d5.e
    public final String g() {
        return null;
    }

    @Override // d5.e
    public final String getId() {
        return this.f2863a;
    }

    @Override // d5.e
    public final s0 h() {
        return this.f2874l;
    }

    @Override // d5.e
    public final Object i(c5.b bVar, i7.c cVar) {
        u0 u0Var = this.f2872j;
        if (u0Var.getValue() instanceof q) {
            Object objB = this.f2866d.b(((c5.d) this.f2867e).b(bVar), cVar);
            return objB == h7.a.f4212f ? objB : c7.r.f1986a;
        }
        throw new f(this.f2863a + " not ONLINE (state=" + q7.w.f8821a.b(u0Var.getValue().getClass()).t() + ")");
    }

    public final void k(r rVar) {
        u0 u0Var = this.f2872j;
        r rVar2 = (r) u0Var.getValue();
        if (rVar2.getClass() == rVar.getClass()) {
            return;
        }
        u0Var.getClass();
        u0Var.g(null, rVar);
        ((a7.d) this.f2870h).C(new k5.i(this.f2863a, j(rVar2), j(rVar)));
    }
}
