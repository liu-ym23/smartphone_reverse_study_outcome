package o1;

import v1.u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 implements o2.c, nb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ i0 f9041c;

    /* renamed from: f, reason: collision with root package name */
    public kc.g f9042f;

    /* renamed from: g, reason: collision with root package name */
    public kc.g f9043g;

    /* renamed from: h, reason: collision with root package name */
    public k f9044h;
    public nb.h i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ i0 f9045j;

    @Override // o2.c
    public final long E(float f5) {
        return this.f9041c.E(f5);
    }

    @Override // o2.c
    public final float J(int i) {
        return this.f9041c.J(i);
    }

    @Override // o2.c
    public final float M(float f5) {
        return f5 / this.f9041c.a();
    }

    @Override // o2.c
    public final float T() {
        return this.f9041c.T();
    }

    @Override // o2.c
    public final float X(float f5) {
        return this.f9041c.a() * f5;
    }

    @Override // o2.c
    public final float a() {
        return this.f9041c.a();
    }

    public final Object b(k kVar, pb.a aVar) {
        kc.g gVar = new kc.g(1, td.h.y(aVar));
        gVar.s();
        this.f9044h = kVar;
        this.f9043g = gVar;
        Object objR = gVar.r();
        ob.a aVar2 = ob.a.f9351c;
        return objR;
    }

    public final u1 c() {
        i0 i0Var = this.f9045j;
        i0Var.getClass();
        return u1.f.u(i0Var).C;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r8, xb.p r10, pb.a r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof o1.f0
            if (r0 == 0) goto L13
            r0 = r11
            o1.f0 r0 = (o1.f0) r0
            int r1 = r0.f9024h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9024h = r1
            goto L18
        L13:
            o1.f0 r0 = new o1.f0
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.f9022f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f9024h
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2b
            kc.z r7 = r0.f9021c
            id.c.I(r11)     // Catch: java.lang.Throwable -> L29
            goto L68
        L29:
            r8 = move-exception
            goto L72
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L32:
            id.c.I(r11)
            r4 = 0
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 > 0) goto L4b
            kc.g r11 = r7.f9043g
            if (r11 == 0) goto L4b
            o1.l r2 = new o1.l
            r2.<init>(r8)
            jb.h r2 = id.c.l(r2)
            r11.resumeWith(r2)
        L4b:
            o1.i0 r11 = r7.f9045j
            kc.t r11 = r11.p0()
            m8.j0 r2 = new m8.j0
            r4 = 0
            r2.<init>(r8, r7, r4)
            r8 = 3
            kc.z r8 = kc.w.u(r11, r4, r4, r2, r8)
            r0.f9021c = r8     // Catch: java.lang.Throwable -> L6e
            r0.f9024h = r3     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r11 = r10.invoke(r7, r0)     // Catch: java.lang.Throwable -> L6e
            if (r11 != r1) goto L67
            return r1
        L67:
            r7 = r8
        L68:
            o1.b r8 = o1.b.f9002f
            r7.e(r8)
            return r11
        L6e:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L72:
            o1.b r9 = o1.b.f9002f
            r7.e(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.h0.d(long, xb.p, pb.a):java.lang.Object");
    }

    @Override // o2.c
    public final int e0(float f5) {
        return this.f9041c.e0(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(long r5, u.b1 r7, pb.a r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof o1.g0
            if (r0 == 0) goto L13
            r0 = r8
            o1.g0 r0 = (o1.g0) r0
            int r1 = r0.f9033g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9033g = r1
            goto L18
        L13:
            o1.g0 r0 = new o1.g0
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f9031c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f9033g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r8)     // Catch: o1.l -> L3b
            return r8
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r8)
            r0.f9033g = r3     // Catch: o1.l -> L3b
            java.lang.Object r4 = r4.d(r5, r7, r0)     // Catch: o1.l -> L3b
            if (r4 != r1) goto L3a
            return r1
        L3a:
            return r4
        L3b:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.h0.g(long, u.b1, pb.a):java.lang.Object");
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.i;
    }

    @Override // o2.c
    public final long j0(long j10) {
        return this.f9041c.j0(j10);
    }

    @Override // o2.c
    public final float m0(long j10) {
        return this.f9041c.m0(j10);
    }

    @Override // o2.c
    public final long n(float f5) {
        return this.f9041c.n(f5);
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        i0 i0Var = this.f9045j;
        synchronized (i0Var.f9055z) {
            i0Var.f9054y.j(this);
        }
        this.f9042f.resumeWith(obj);
    }

    @Override // o2.c
    public final float u(long j10) {
        return this.f9041c.u(j10);
    }
}
