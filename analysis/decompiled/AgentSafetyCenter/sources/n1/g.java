package n1;

import kc.t;
import kc.w;
import u1.a2;
import w0.l;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends l implements a2, a {

    /* renamed from: s, reason: collision with root package name */
    public a f8638s;

    /* renamed from: t, reason: collision with root package name */
    public d f8639t;

    /* renamed from: u, reason: collision with root package name */
    public g f8640u;

    /* renamed from: v, reason: collision with root package name */
    public final String f8641v;

    public g(a aVar, d dVar) {
        this.f8638s = aVar;
        this.f8639t = dVar == null ? new d() : dVar;
        this.f8641v = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final t B0() {
        g gVar = this.f15126r ? (g) u1.f.j(this) : null;
        t tVarB0 = gVar != null ? gVar.B0() : null;
        if (tVarB0 != null && w.r(tVarB0)) {
            return tVarB0;
        }
        t tVar = this.f8639t.f8629d;
        if (tVar != null) {
            return tVar;
        }
        od.f.e("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        return null;
    }

    @Override // n1.a
    public final long F(int i, long j10) {
        boolean z10 = this.f15126r;
        g gVar = null;
        if (z10 && z10) {
            gVar = (g) u1.f.j(this);
        }
        long jF = gVar != null ? gVar.F(i, j10) : 0L;
        return c1.b.h(jF, this.f8638s.F(i, c1.b.g(j10, jF)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // n1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S(long r11, long r13, nb.c r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof n1.e
            if (r0 == 0) goto L14
            r0 = r15
            n1.e r0 = (n1.e) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.i = r1
        L12:
            r6 = r0
            goto L1c
        L14:
            n1.e r0 = new n1.e
            pb.c r15 = (pb.c) r15
            r0.<init>(r10, r15)
            goto L12
        L1c:
            java.lang.Object r15 = r6.f8632g
            ob.a r0 = ob.a.f9351c
            int r1 = r6.i
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L37
            if (r1 != r7) goto L30
            long r10 = r6.f8630c
            id.c.I(r15)
            goto L82
        L30:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L37:
            long r13 = r6.f8631f
            long r11 = r6.f8630c
            id.c.I(r15)
            goto L55
        L3f:
            id.c.I(r15)
            n1.a r1 = r10.f8638s
            r6.f8630c = r11
            r6.f8631f = r13
            r6.i = r2
            r2 = r11
            r4 = r13
            java.lang.Object r15 = r1.S(r2, r4, r6)
            if (r15 != r0) goto L53
            goto L80
        L53:
            r11 = r2
            r13 = r4
        L55:
            o2.p r15 = (o2.p) r15
            long r8 = r15.f9131a
            boolean r15 = r10.f15126r
            if (r15 == 0) goto L6a
            r1 = 0
            if (r15 == 0) goto L6c
            if (r15 == 0) goto L6c
            u1.a2 r10 = u1.f.j(r10)
            r1 = r10
            n1.g r1 = (n1.g) r1
            goto L6c
        L6a:
            n1.g r1 = r10.f8640u
        L6c:
            if (r1 == 0) goto L88
            long r2 = o2.p.f(r11, r8)
            long r4 = o2.p.e(r13, r8)
            r6.f8630c = r8
            r6.i = r7
            java.lang.Object r15 = r1.S(r2, r4, r6)
            if (r15 != r0) goto L81
        L80:
            return r0
        L81:
            r10 = r8
        L82:
            o2.p r15 = (o2.p) r15
            long r12 = r15.f9131a
            r8 = r10
            goto L8a
        L88:
            r12 = 0
        L8a:
            long r10 = o2.p.f(r8, r12)
            o2.p r10 = o2.p.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.g.S(long, long, nb.c):java.lang.Object");
    }

    @Override // n1.a
    public final long d0(int i, long j10, long j11) {
        long jD0 = this.f8638s.d0(i, j10, j11);
        boolean z10 = this.f15126r;
        g gVar = null;
        if (z10 && z10) {
            gVar = (g) u1.f.j(this);
        }
        g gVar2 = gVar;
        return c1.b.h(jD0, gVar2 != null ? gVar2.d0(i, c1.b.h(j10, jD0), c1.b.g(j11, jD0)) : 0L);
    }

    @Override // u1.a2
    public final Object k() {
        return this.f8641v;
    }

    @Override // w0.l
    public final void t0() {
        d dVar = this.f8639t;
        dVar.f8626a = this;
        dVar.f8627b = null;
        this.f8640u = null;
        dVar.f8628c = new ad.l(this, 16);
        dVar.f8629d = p0();
    }

    @Override // w0.l
    public final void u0() {
        u uVar = new u();
        u1.f.x(this, new h(uVar, 0));
        g gVar = (g) ((a2) uVar.f16098c);
        this.f8640u = gVar;
        d dVar = this.f8639t;
        dVar.f8627b = gVar;
        if (dVar.f8626a == this) {
            dVar.f8626a = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r9 == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // n1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(long r7, nb.c r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof n1.f
            if (r0 == 0) goto L13
            r0 = r9
            n1.f r0 = (n1.f) r0
            int r1 = r0.f8637h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8637h = r1
            goto L1a
        L13:
            n1.f r0 = new n1.f
            pb.c r9 = (pb.c) r9
            r0.<init>(r6, r9)
        L1a:
            java.lang.Object r9 = r0.f8635f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8637h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2e
            long r6 = r0.f8634c
            id.c.I(r9)
            goto L72
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L35:
            long r7 = r0.f8634c
            id.c.I(r9)
            goto L59
        L3b:
            id.c.I(r9)
            boolean r9 = r6.f15126r
            r2 = 0
            if (r9 == 0) goto L4c
            if (r9 == 0) goto L4c
            u1.a2 r9 = u1.f.j(r6)
            r2 = r9
            n1.g r2 = (n1.g) r2
        L4c:
            if (r2 == 0) goto L5e
            r0.f8634c = r7
            r0.f8637h = r4
            java.lang.Object r9 = r2.v(r7, r0)
            if (r9 != r1) goto L59
            goto L70
        L59:
            o2.p r9 = (o2.p) r9
            long r4 = r9.f9131a
            goto L60
        L5e:
            r4 = 0
        L60:
            n1.a r6 = r6.f8638s
            long r7 = o2.p.e(r7, r4)
            r0.f8634c = r4
            r0.f8637h = r3
            java.lang.Object r9 = r6.v(r7, r0)
            if (r9 != r1) goto L71
        L70:
            return r1
        L71:
            r6 = r4
        L72:
            o2.p r9 = (o2.p) r9
            long r8 = r9.f9131a
            long r6 = o2.p.f(r6, r8)
            o2.p r6 = o2.p.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.g.v(long, nb.c):java.lang.Object");
    }
}
