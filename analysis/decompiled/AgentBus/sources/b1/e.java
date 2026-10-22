package b1;

import i1.x1;
import ia.b0;
import n0.l;
import o4.d0;
import p.y0;
import q7.v;

/* loaded from: classes.dex */
public final class e extends l implements x1 {

    /* renamed from: t, reason: collision with root package name */
    public final d0 f1472t;

    /* renamed from: u, reason: collision with root package name */
    public final i5.f f1473u;

    /* renamed from: v, reason: collision with root package name */
    public e f1474v;

    /* renamed from: w, reason: collision with root package name */
    public final String f1475w = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";

    public e(d0 d0Var, i5.f fVar) {
        this.f1472t = d0Var;
        this.f1473u = fVar;
    }

    @Override // n0.l
    public final void d0() {
        i5.f fVar = this.f1473u;
        fVar.f4653g = this;
        fVar.f4654h = null;
        this.f1474v = null;
        fVar.f4655i = new a8.c(3, this);
        fVar.f4656j = Z();
    }

    @Override // n0.l
    public final void e0() {
        v vVar = new v();
        i1.l.x(this, new f(vVar, 0));
        e eVar = (e) ((x1) vVar.f8820f);
        this.f1474v = eVar;
        i5.f fVar = this.f1473u;
        fVar.f4654h = eVar;
        if (((e) fVar.f4653g) == this) {
            fVar.f4653g = null;
        }
    }

    @Override // i1.x1
    public final Object k() {
        return this.f1475w;
    }

    public final b0 l0() {
        e eVar = this.f6810s ? (e) i1.l.j(this) : null;
        b0 b0VarL0 = eVar != null ? eVar.l0() : null;
        if (b0VarL0 != null && ia.d0.q(b0VarL0)) {
            return b0VarL0;
        }
        b0 b0Var = (b0) this.f1473u.f4656j;
        if (b0Var != null) {
            return b0Var;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(long r12, long r14, i7.c r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof b1.c
            if (r1 == 0) goto L16
            r1 = r0
            b1.c r1 = (b1.c) r1
            int r2 = r1.f1467j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f1467j = r2
        L14:
            r7 = r1
            goto L1c
        L16:
            b1.c r1 = new b1.c
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.f1465h
            h7.a r1 = h7.a.f4212f
            int r2 = r7.f1467j
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 == r3) goto L38
            if (r2 != r8) goto L30
            long r11 = r7.f1463f
            w7.e0.N(r0)
            goto L8a
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            long r12 = r7.f1464g
            long r2 = r7.f1463f
            w7.e0.N(r0)
            r9 = r2
            r2 = r12
            r12 = r9
            goto L58
        L43:
            w7.e0.N(r0)
            r7.f1463f = r12
            r7.f1464g = r14
            r7.f1467j = r3
            o4.d0 r2 = r11.f1472t
            r3 = r12
            r5 = r14
            java.lang.Object r0 = r2.P(r3, r5, r7)
            if (r0 != r1) goto L57
            goto L88
        L57:
            r2 = r14
        L58:
            d2.p r0 = (d2.p) r0
            long r4 = r0.f2801a
            boolean r0 = r11.f6810s
            if (r0 == 0) goto L6e
            r6 = 0
            if (r0 == 0) goto L6c
            if (r0 == 0) goto L6c
            i1.x1 r11 = i1.l.j(r11)
            r6 = r11
            b1.e r6 = (b1.e) r6
        L6c:
            r11 = r6
            goto L71
        L6e:
            b1.e r6 = r11.f1474v
            goto L6c
        L71:
            if (r11 == 0) goto L90
            long r12 = d2.p.e(r12, r4)
            long r2 = d2.p.d(r2, r4)
            r7.f1463f = r4
            r7.f1467j = r8
            r14 = r2
            r16 = r7
            java.lang.Object r0 = r11.m0(r12, r14, r16)
            if (r0 != r1) goto L89
        L88:
            return r1
        L89:
            r11 = r4
        L8a:
            d2.p r0 = (d2.p) r0
            long r0 = r0.f2801a
            r4 = r11
            goto L92
        L90:
            r0 = 0
        L92:
            long r11 = d2.p.e(r4, r0)
            d2.p r13 = new d2.p
            r13.<init>(r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.m0(long, long, i7.c):java.lang.Object");
    }

    public final long n0(long j2, long j4, int i2) {
        y0 y0Var = (y0) this.f1472t.f7326g;
        long jG = y0Var.f8216a.i() ? 0L : y0Var.g(y0Var.c(y0Var.f8216a.n(y0Var.c(y0Var.f(j4)))));
        boolean z4 = this.f6810s;
        e eVar = null;
        if (z4 && z4) {
            eVar = (e) i1.l.j(this);
        }
        e eVar2 = eVar;
        return t0.b.g(jG, eVar2 != null ? eVar2.n0(t0.b.g(j2, jG), t0.b.f(j4, jG), i2) : 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r11 == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        if (r11 != r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(long r9, g7.d r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof b1.d
            if (r0 == 0) goto L13
            r0 = r11
            b1.d r0 = (b1.d) r0
            int r1 = r0.f1471i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1471i = r1
            goto L1a
        L13:
            b1.d r0 = new b1.d
            i7.c r11 = (i7.c) r11
            r0.<init>(r8, r11)
        L1a:
            java.lang.Object r11 = r0.f1469g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f1471i
            r3 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L3e
            if (r2 == r6) goto L38
            if (r2 != r5) goto L30
            long r8 = r0.f1468f
            w7.e0.N(r11)
            goto L74
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            long r9 = r0.f1468f
            w7.e0.N(r11)
            goto L5c
        L3e:
            w7.e0.N(r11)
            boolean r11 = r8.f6810s
            r2 = 0
            if (r11 == 0) goto L4f
            if (r11 == 0) goto L4f
            i1.x1 r8 = i1.l.j(r8)
            r2 = r8
            b1.e r2 = (b1.e) r2
        L4f:
            if (r2 == 0) goto L63
            r0.f1468f = r9
            r0.f1471i = r6
            java.lang.Object r11 = r2.o0(r9, r0)
            if (r11 != r1) goto L5c
            goto L73
        L5c:
            d2.p r11 = (d2.p) r11
            long r6 = r11.f2801a
            r10 = r9
            r8 = r6
            goto L65
        L63:
            r10 = r9
            r8 = r3
        L65:
            d2.p.d(r10, r8)
            r0.f1468f = r8
            r0.f1471i = r5
            d2.p r11 = new d2.p
            r11.<init>(r3)
            if (r11 != r1) goto L74
        L73:
            return r1
        L74:
            d2.p r11 = (d2.p) r11
            long r10 = r11.f2801a
            long r8 = d2.p.e(r8, r10)
            d2.p r10 = new d2.p
            r10.<init>(r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.o0(long, g7.d):java.lang.Object");
    }

    public final long p0(int i2, long j2) {
        boolean z4 = this.f6810s;
        e eVar = null;
        if (z4 && z4) {
            eVar = (e) i1.l.j(this);
        }
        long jP0 = eVar != null ? eVar.p0(i2, j2) : 0L;
        t0.b.f(j2, jP0);
        return t0.b.g(jP0, 0L);
    }
}
