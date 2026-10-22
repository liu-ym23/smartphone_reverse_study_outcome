package p;

import b0.f2;

/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public t0 f8216a;

    /* renamed from: b, reason: collision with root package name */
    public o.t0 f8217b;

    /* renamed from: c, reason: collision with root package name */
    public nb.f f8218c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f8219d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8220e;

    /* renamed from: f, reason: collision with root package name */
    public i5.f f8221f;

    /* renamed from: g, reason: collision with root package name */
    public int f8222g = 1;

    /* renamed from: h, reason: collision with root package name */
    public i0 f8223h = androidx.compose.foundation.gestures.a.f727a;

    /* renamed from: i, reason: collision with root package name */
    public final w0 f8224i = new w0(this);

    /* renamed from: j, reason: collision with root package name */
    public final c1.w f8225j = new c1.w(27, this);

    public y0(t0 t0Var, o.t0 t0Var2, nb.f fVar, e0 e0Var, boolean z4, i5.f fVar2) {
        this.f8216a = t0Var;
        this.f8217b = t0Var2;
        this.f8218c = fVar;
        this.f8219d = e0Var;
        this.f8220e = z4;
        this.f8221f = fVar2;
    }

    public static final long a(y0 y0Var, i0 i0Var, long j2, int i2) {
        b1.e eVar = (b1.e) y0Var.f8221f.f4653g;
        b1.e eVar2 = null;
        b1.e eVar3 = (eVar == null || !eVar.f6810s) ? null : (b1.e) i1.l.j(eVar);
        long jP0 = eVar3 != null ? eVar3.p0(i2, j2) : 0L;
        long jF = t0.b.f(j2, jP0);
        long jD = y0Var.d(y0Var.g(i0Var.a(y0Var.f(y0Var.d(t0.b.a(y0Var.f8219d == e0.f8082g ? 1 : 2, jF))))));
        long jF2 = t0.b.f(jF, jD);
        b1.e eVar4 = (b1.e) y0Var.f8221f.f4653g;
        if (eVar4 != null && eVar4.f6810s) {
            eVar2 = (b1.e) i1.l.j(eVar4);
        }
        b1.e eVar5 = eVar2;
        return t0.b.g(t0.b.g(jP0, jD), eVar5 != null ? eVar5.n0(jD, jF2, i2) : 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r11, i7.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof p.u0
            if (r0 == 0) goto L13
            r0 = r13
            p.u0 r0 = (p.u0) r0
            int r1 = r0.f8189i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8189i = r1
            goto L18
        L13:
            p.u0 r0 = new p.u0
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8187g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8189i
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            q7.u r10 = r0.f8186f
            w7.e0.N(r13)
            goto L4f
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L31:
            w7.e0.N(r13)
            q7.u r6 = new q7.u
            r6.<init>()
            r6.f8819f = r11
            i5.s r4 = new i5.s
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.f8186f = r6
            r0.f8189i = r3
            java.lang.Object r10 = r5.e(r3, r4, r0)
            if (r10 != r1) goto L4e
            return r1
        L4e:
            r10 = r6
        L4f:
            long r10 = r10.f8819f
            d2.p r12 = new d2.p
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p.y0.b(long, i7.c):java.lang.Object");
    }

    public final float c(float f10) {
        return this.f8220e ? f10 * (-1) : f10;
    }

    public final long d(long j2) {
        return this.f8220e ? t0.b.h(-1.0f, j2) : j2;
    }

    public final Object e(int i2, p7.n nVar, i7.c cVar) {
        Object objB = this.f8216a.b(i2, new f2(this, nVar, (g7.d) null), cVar);
        return objB == h7.a.f4212f ? objB : c7.r.f1986a;
    }

    public final float f(long j2) {
        return this.f8219d == e0.f8082g ? t0.b.d(j2) : t0.b.e(j2);
    }

    public final long g(float f10) {
        if (f10 == 0.0f) {
            return 0L;
        }
        return this.f8219d == e0.f8082g ? n7.b.b(f10, 0.0f) : n7.b.b(0.0f, f10);
    }
}
