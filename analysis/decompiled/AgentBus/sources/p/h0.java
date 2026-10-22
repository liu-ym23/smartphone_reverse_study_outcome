package p;

/* loaded from: classes.dex */
public final class h0 implements d2.c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d2.c f8113f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8114g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8115h;

    /* renamed from: i, reason: collision with root package name */
    public final ra.d f8116i = new ra.d();

    public h0(d2.c cVar) {
        this.f8113f = cVar;
    }

    @Override // d2.c
    public final long F(long j2) {
        return this.f8113f.F(j2);
    }

    @Override // d2.c
    public final float J(long j2) {
        return this.f8113f.J(j2);
    }

    @Override // d2.c
    public final long R(float f10) {
        return this.f8113f.R(f10);
    }

    @Override // d2.c
    public final float X(float f10) {
        return this.f8113f.X(f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(i7.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof p.f0
            if (r0 == 0) goto L13
            r0 = r5
            p.f0 r0 = (p.f0) r0
            int r1 = r0.f8095i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8095i = r1
            goto L18
        L13:
            p.f0 r0 = new p.f0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8093g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8095i
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            p.h0 r4 = r0.f8092f
            w7.e0.N(r5)
            goto L42
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            w7.e0.N(r5)
            r0.f8092f = r4
            r0.f8095i = r3
            ra.d r5 = r4.f8116i
            r2 = 0
            java.lang.Object r5 = ra.a.lock$default(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L42
            return r1
        L42:
            r5 = 0
            r4.f8114g = r5
            r4.f8115h = r5
            c7.r r4 = c7.r.f1986a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p.h0.a(i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(i7.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof p.g0
            if (r0 == 0) goto L13
            r0 = r6
            p.g0 r0 = (p.g0) r0
            int r1 = r0.f8104i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8104i = r1
            goto L18
        L13:
            p.g0 r0 = new p.g0
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8102g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8104i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            p.h0 r5 = r0.f8101f
            w7.e0.N(r6)
            goto L4a
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            w7.e0.N(r6)
            boolean r6 = r5.f8114g
            if (r6 != 0) goto L4f
            boolean r6 = r5.f8115h
            if (r6 != 0) goto L4f
            r0.f8101f = r5
            r0.f8104i = r4
            ra.d r6 = r5.f8116i
            java.lang.Object r6 = ra.a.lock$default(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            ra.d r6 = r5.f8116i
            ra.a.unlock$default(r6, r3, r4, r3)
        L4f:
            boolean r5 = r5.f8114g
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.h0.b(i7.c):java.lang.Object");
    }

    @Override // d2.c
    public final float c() {
        return this.f8113f.c();
    }

    @Override // d2.c
    public final float j() {
        return this.f8113f.j();
    }

    @Override // d2.c
    public final long n(float f10) {
        return this.f8113f.n(f10);
    }

    @Override // d2.c
    public final float o(float f10) {
        return this.f8113f.o(f10);
    }

    @Override // d2.c
    public final float t(long j2) {
        return this.f8113f.t(j2);
    }

    @Override // d2.c
    public final int y(float f10) {
        return this.f8113f.y(f10);
    }
}
