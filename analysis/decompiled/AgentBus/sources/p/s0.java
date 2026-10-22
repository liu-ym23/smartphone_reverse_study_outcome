package p;

import android.view.KeyEvent;
import i1.p1;
import i1.s1;
import ia.j1;

/* loaded from: classes.dex */
public final class s0 extends i1.k implements i1.f1, s0.l, a1.d, s1, p1, i1.i {
    public q.b A;
    public boolean B;
    public c1.x C;
    public o.t0 D;
    public final i5.f E;
    public final j0 F;
    public final nb.f G;
    public final y0 H;
    public final o4.d0 I;
    public final i J;
    public a K;
    public u L;
    public p0 M;

    /* renamed from: v, reason: collision with root package name */
    public e0 f8177v;

    /* renamed from: w, reason: collision with root package name */
    public e f8178w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8179x;

    /* renamed from: y, reason: collision with root package name */
    public q.i f8180y;

    /* renamed from: z, reason: collision with root package name */
    public ka.g f8181z;

    public s0(o.t0 t0Var, e0 e0Var, t0 t0Var2, q.i iVar, boolean z4) {
        e eVar = e.f8079i;
        this.f8177v = e0Var;
        this.f8178w = eVar;
        this.f8179x = true;
        this.f8180y = iVar;
        this.D = t0Var;
        i5.f fVar = new i5.f(4);
        this.E = fVar;
        j0 j0Var = new j0();
        l0(j0Var);
        this.F = j0Var;
        nb.f fVar2 = new nb.f(new a7.d(22, new a7.d(androidx.compose.foundation.gestures.a.f729c)));
        this.G = fVar2;
        y0 y0Var = new y0(t0Var2, this.D, fVar2, e0Var, z4, fVar);
        this.H = y0Var;
        o4.d0 d0Var = new o4.d0(2, y0Var);
        this.I = d0Var;
        i iVar2 = new i(e0Var, y0Var, z4);
        l0(iVar2);
        this.J = iVar2;
        l0(new b1.e(d0Var, fVar));
        l0(new s0.q(new j1(1, s0.s.f9203a, s0.s.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0, 3), 3));
        s.d dVar = new s.d();
        dVar.f9159t = iVar2;
        l0(dVar);
        c1.w wVar = new c1.w(26, this);
        o.e0 e0Var2 = new o.e0();
        e0Var2.f7042t = wVar;
        l0(e0Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o0(p.s0 r5, i7.c r6) {
        /*
            boolean r0 = r6 instanceof p.w
            if (r0 == 0) goto L13
            r0 = r6
            p.w r0 = (p.w) r0
            int r1 = r0.f8199i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8199i = r1
            goto L18
        L13:
            p.w r0 = new p.w
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8197g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8199i
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            p.s0 r5 = r0.f8196f
            w7.e0.N(r6)
            goto L4c
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            w7.e0.N(r6)
            q.b r6 = r5.A
            if (r6 == 0) goto L4f
            q.i r2 = r5.f8180y
            if (r2 == 0) goto L4c
            q.a r4 = new q.a
            r4.<init>(r6)
            r0.f8196f = r5
            r0.f8199i = r3
            java.lang.Object r6 = r2.a(r4, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r6 = 0
            r5.A = r6
        L4f:
            r0 = 0
            r5.s0(r0)
            c7.r r5 = c7.r.f1986a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.s0.o0(p.s0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p0(p.s0 r6, p.o r7, i7.c r8) {
        /*
            boolean r0 = r8 instanceof p.x
            if (r0 == 0) goto L13
            r0 = r8
            p.x r0 = (p.x) r0
            int r1 = r0.f8206k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8206k = r1
            goto L18
        L13:
            p.x r0 = new p.x
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f8204i
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8206k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            q.b r6 = r0.f8203h
            p.o r7 = r0.f8202g
            p.s0 r0 = r0.f8201f
            w7.e0.N(r8)
            goto L77
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            p.o r7 = r0.f8202g
            p.s0 r6 = r0.f8201f
            w7.e0.N(r8)
            goto L5d
        L40:
            w7.e0.N(r8)
            q.b r8 = r6.A
            if (r8 == 0) goto L5d
            q.i r2 = r6.f8180y
            if (r2 == 0) goto L5d
            q.a r5 = new q.a
            r5.<init>(r8)
            r0.f8201f = r6
            r0.f8202g = r7
            r0.f8206k = r4
            java.lang.Object r8 = r2.a(r5, r0)
            if (r8 != r1) goto L5d
            goto L74
        L5d:
            q.b r8 = new q.b
            r8.<init>()
            q.i r2 = r6.f8180y
            if (r2 == 0) goto L79
            r0.f8201f = r6
            r0.f8202g = r7
            r0.f8203h = r8
            r0.f8206k = r3
            java.lang.Object r0 = r2.a(r8, r0)
            if (r0 != r1) goto L75
        L74:
            return r1
        L75:
            r0 = r6
            r6 = r8
        L77:
            r8 = r6
            r6 = r0
        L79:
            r6.A = r8
            long r6 = r7.f8143a
            c7.r r6 = c7.r.f1986a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p.s0.p0(p.s0, p.o, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q0(p.s0 r5, p.p r6, i7.c r7) {
        /*
            boolean r0 = r7 instanceof p.y
            if (r0 == 0) goto L13
            r0 = r7
            p.y r0 = (p.y) r0
            int r1 = r0.f8215j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8215j = r1
            goto L18
        L13:
            p.y r0 = new p.y
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8213h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8215j
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            p.p r6 = r0.f8212g
            p.s0 r5 = r0.f8211f
            w7.e0.N(r7)
            goto L50
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            w7.e0.N(r7)
            q.b r7 = r5.A
            if (r7 == 0) goto L53
            q.i r2 = r5.f8180y
            if (r2 == 0) goto L50
            q.c r4 = new q.c
            r4.<init>(r7)
            r0.f8211f = r5
            r0.f8212g = r6
            r0.f8215j = r3
            java.lang.Object r7 = r2.a(r4, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = 0
            r5.A = r7
        L53:
            long r6 = r6.f8148a
            r5.s0(r6)
            c7.r r5 = c7.r.f1986a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.s0.q0(p.s0, p.p, i7.c):java.lang.Object");
    }

    @Override // a1.d
    public final boolean B(KeyEvent keyEvent) {
        long jB;
        if (!this.f8179x) {
            return false;
        }
        if ((!a1.b.a(ib.c.a(keyEvent.getKeyCode()), a1.b.f151n) && !a1.b.a(ib.c.a(keyEvent.getKeyCode()), a1.b.f150m)) || a.a.Q(keyEvent) != 2 || keyEvent.isCtrlPressed()) {
            return false;
        }
        e0 e0Var = this.H.f8219d;
        e0 e0Var2 = e0.f8081f;
        i iVar = this.J;
        if (e0Var == e0Var2) {
            int i2 = (int) (iVar.A & 4294967295L);
            jB = n7.b.b(0.0f, a1.b.a(ib.c.a(keyEvent.getKeyCode()), a1.b.f150m) ? i2 : -i2);
        } else {
            int i10 = (int) (iVar.A >> 32);
            jB = n7.b.b(a1.b.a(ib.c.a(keyEvent.getKeyCode()), a1.b.f150m) ? i10 : -i10, 0.0f);
        }
        ia.d0.s(Z(), null, null, new p0(this, jB, null, 1), 3);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, java.util.List] */
    @Override // i1.p1
    public final void C(c1.f fVar, c1.g gVar, long j2) {
        g7.d dVar;
        long j4;
        ?? r02 = fVar.f1795a;
        int size = r02.size();
        int i2 = 0;
        int i10 = 0;
        while (true) {
            dVar = null;
            if (i10 >= size) {
                break;
            }
            if (((Boolean) this.f8178w.invoke((c1.l) r02.get(i10))).booleanValue()) {
                if (this.f8179x && this.C == null) {
                    v vVar = new v(this, dVar, i2);
                    c1.f fVar2 = c1.t.f1840a;
                    c1.x xVar = new c1.x(null, null, c1.u.f1841a);
                    xVar.f1852v = vVar;
                    l0(xVar);
                    this.C = xVar;
                }
                c1.x xVar2 = this.C;
                if (xVar2 != null) {
                    xVar2.C(fVar, gVar, j2);
                }
            } else {
                i10++;
            }
        }
        if (gVar == c1.g.f1798g && fVar.f1796b == 6) {
            ?? r11 = fVar.f1795a;
            int size2 = r11.size();
            for (int i11 = 0; i11 < size2; i11++) {
                if (((c1.l) r11.get(i11)).b()) {
                    return;
                }
            }
            q7.k.b(this.K);
            d2.c cVar = i1.l.u(this).A;
            t0.b bVar = new t0.b(0L);
            int size3 = r11.size();
            int i12 = 0;
            while (true) {
                j4 = bVar.f9654a;
                if (i12 >= size3) {
                    break;
                }
                bVar = new t0.b(t0.b.g(j4, ((c1.l) r11.get(i12)).f1813j));
                i12++;
            }
            ia.d0.s(Z(), null, null, new p0(this, t0.b.h(-cVar.o(64), j4), dVar, 2), 3);
            int size4 = r11.size();
            while (i2 < size4) {
                ((c1.l) r11.get(i2)).a();
                i2++;
            }
        }
    }

    @Override // i1.p1
    public final void M() {
        c1.x xVar = this.C;
        if (xVar != null) {
            xVar.M();
        }
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // n0.l
    public final void d0() {
        i1.l.r(this, new t(this, 2));
        this.K = a.f8051a;
    }

    @Override // n0.l
    public final void e0() {
        this.B = false;
        r0();
    }

    @Override // a1.d
    public final boolean i(KeyEvent keyEvent) {
        return false;
    }

    public final void r0() {
        q.b bVar = this.A;
        if (bVar != null) {
            q.i iVar = this.f8180y;
            if (iVar != null) {
                iVar.b(new q.a(bVar));
            }
            this.A = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [p7.a, q7.m] */
    public final void s0(long j2) {
        ia.b0 b0Var = (ia.b0) ((q7.m) this.E.f4655i).c();
        if (b0Var == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        ia.d0.s(b0Var, null, null, new p0(this, j2, null, 0), 3);
    }

    @Override // i1.s1
    public final void u(p1.i iVar) {
        if (this.f8179x && (this.L == null || this.M == null)) {
            this.L = new u(this, 1);
            this.M = new p0(this, null);
        }
        u uVar = this.L;
        if (uVar != null) {
            w7.t[] tVarArr = p1.u.f8372a;
            iVar.i(p1.h.f8281d, new p1.a(null, uVar));
        }
        p0 p0Var = this.M;
        if (p0Var != null) {
            w7.t[] tVarArr2 = p1.u.f8372a;
            iVar.i(p1.h.f8282e, p0Var);
        }
    }

    @Override // i1.f1
    public final void v() {
        i1.l.r(this, new t(this, 2));
    }

    @Override // s0.l
    public final void x(s0.i iVar) {
        iVar.b(false);
    }
}
