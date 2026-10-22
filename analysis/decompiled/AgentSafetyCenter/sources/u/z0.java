package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public u0 f13624a;

    /* renamed from: b, reason: collision with root package name */
    public t.b1 f13625b;

    /* renamed from: c, reason: collision with root package name */
    public k f13626c;

    /* renamed from: d, reason: collision with root package name */
    public f0 f13627d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13628e;

    /* renamed from: f, reason: collision with root package name */
    public n1.d f13629f;

    /* renamed from: g, reason: collision with root package name */
    public int f13630g;

    /* renamed from: h, reason: collision with root package name */
    public j0 f13631h;
    public y0 i;

    /* renamed from: j, reason: collision with root package name */
    public a2.m f13632j;

    public static final long a(z0 z0Var, j0 j0Var, long j10, int i) {
        n1.g gVar = z0Var.f13629f.f8626a;
        n1.g gVar2 = null;
        n1.g gVar3 = (gVar == null || !gVar.f15126r) ? null : (n1.g) u1.f.j(gVar);
        long jF = gVar3 != null ? gVar3.F(i, j10) : 0L;
        long jG = c1.b.g(j10, jF);
        long jD = z0Var.d(z0Var.g(j0Var.a(z0Var.f(z0Var.d(c1.b.b(z0Var.f13627d == f0.f13454f ? 1 : 2, jG))))));
        long jG2 = c1.b.g(jG, jD);
        n1.g gVar4 = z0Var.f13629f.f8626a;
        if (gVar4 != null && gVar4.f15126r) {
            gVar2 = (n1.g) u1.f.j(gVar4);
        }
        n1.g gVar5 = gVar2;
        return c1.b.h(c1.b.h(jF, jD), gVar5 != null ? gVar5.d0(i, jD, jG2) : 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r11, pb.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof u.v0
            if (r0 == 0) goto L13
            r0 = r13
            u.v0 r0 = (u.v0) r0
            int r1 = r0.f13598h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13598h = r1
            goto L18
        L13:
            u.v0 r0 = new u.v0
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f13596f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13598h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            yb.t r10 = r0.f13595c
            id.c.I(r13)
            goto L50
        L29:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L30:
            id.c.I(r13)
            yb.t r6 = new yb.t
            r6.<init>()
            r6.f16097c = r11
            u.x0 r4 = new u.x0
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.f13595c = r6
            r0.f13598h = r3
            t.u0 r10 = t.u0.f13068c
            java.lang.Object r10 = r5.e(r10, r4, r0)
            if (r10 != r1) goto L4f
            return r1
        L4f:
            r10 = r6
        L50:
            long r10 = r10.f16097c
            o2.p r10 = o2.p.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: u.z0.b(long, pb.c):java.lang.Object");
    }

    public final float c(float f5) {
        return this.f13628e ? f5 * (-1) : f5;
    }

    public final long d(long j10) {
        return this.f13628e ? c1.b.i(-1.0f, j10) : j10;
    }

    public final Object e(t.u0 u0Var, xb.p pVar, pb.c cVar) {
        Object objC = this.f13624a.c(u0Var, new androidx.lifecycle.l0(this, pVar, (nb.c) null), cVar);
        return objC == ob.a.f9351c ? objC : jb.v.f6774a;
    }

    public final float f(long j10) {
        return this.f13627d == f0.f13454f ? c1.b.e(j10) : c1.b.f(j10);
    }

    public final long g(float f5) {
        if (f5 == 0.0f) {
            return 0L;
        }
        return this.f13627d == f0.f13454f ? id.k.d(f5, 0.0f) : id.k.d(0.0f, f5);
    }
}
