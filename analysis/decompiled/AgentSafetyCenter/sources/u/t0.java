package u;

import android.view.KeyEvent;
import u1.s1;
import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends u1.m implements u1.i1, b1.m, m1.c, v1, s1, u1.k {
    public boolean A;
    public o1.i0 B;
    public t.b1 C;
    public k D;
    public n1.d E;
    public k0 F;
    public k G;
    public z0 H;
    public l3.d I;
    public i J;
    public a K;
    public w L;
    public r0 M;

    /* renamed from: u, reason: collision with root package name */
    public f0 f13586u;

    /* renamed from: v, reason: collision with root package name */
    public e f13587v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13588w;

    /* renamed from: x, reason: collision with root package name */
    public v.k f13589x;

    /* renamed from: y, reason: collision with root package name */
    public mc.e f13590y;

    /* renamed from: z, reason: collision with root package name */
    public v.b f13591z;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object E0(u.t0 r9, pb.c r10) {
        /*
            boolean r0 = r10 instanceof u.x
            if (r0 == 0) goto L13
            r0 = r10
            u.x r0 = (u.x) r0
            int r1 = r0.f13606h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13606h = r1
            goto L18
        L13:
            u.x r0 = new u.x
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f13604f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13606h
            r7 = 0
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L2a
            u.t0 r9 = r0.f13603c
            id.c.I(r10)
            goto L4c
        L2a:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            r9 = 0
            return r9
        L31:
            id.c.I(r10)
            v.b r10 = r9.f13591z
            if (r10 == 0) goto L4e
            v.k r2 = r9.f13589x
            if (r2 == 0) goto L4c
            v.a r4 = new v.a
            r4.<init>(r10)
            r0.f13603c = r9
            r0.f13606h = r3
            java.lang.Object r10 = r2.a(r4, r0)
            if (r10 != r1) goto L4c
            return r1
        L4c:
            r9.f13591z = r7
        L4e:
            r4 = r9
            n1.d r9 = r4.E
            kc.t r9 = r9.c()
            u.r0 r3 = new u.r0
            r8 = 0
            r5 = 0
            r3.<init>(r4, r5, r7, r8)
            r10 = 3
            kc.w.u(r9, r7, r7, r3, r10)
            jb.v r9 = jb.v.f6774a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u.t0.E0(u.t0, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object F0(u.t0 r6, u.o r7, pb.c r8) {
        /*
            boolean r0 = r8 instanceof u.y
            if (r0 == 0) goto L13
            r0 = r8
            u.y r0 = (u.y) r0
            int r1 = r0.f13618j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13618j = r1
            goto L18
        L13:
            u.y r0 = new u.y
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f13617h
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13618j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L30
            v.b r6 = r0.f13616g
            u.o r7 = r0.f13615f
            u.t0 r0 = r0.f13614c
            id.c.I(r8)
            goto L76
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L37:
            u.o r7 = r0.f13615f
            u.t0 r6 = r0.f13614c
            id.c.I(r8)
            goto L5c
        L3f:
            id.c.I(r8)
            v.b r8 = r6.f13591z
            if (r8 == 0) goto L5c
            v.k r2 = r6.f13589x
            if (r2 == 0) goto L5c
            v.a r5 = new v.a
            r5.<init>(r8)
            r0.f13614c = r6
            r0.f13615f = r7
            r0.f13618j = r4
            java.lang.Object r8 = r2.a(r5, r0)
            if (r8 != r1) goto L5c
            goto L73
        L5c:
            v.b r8 = new v.b
            r8.<init>()
            v.k r2 = r6.f13589x
            if (r2 == 0) goto L78
            r0.f13614c = r6
            r0.f13615f = r7
            r0.f13616g = r8
            r0.f13618j = r3
            java.lang.Object r0 = r2.a(r8, r0)
            if (r0 != r1) goto L74
        L73:
            return r1
        L74:
            r0 = r6
            r6 = r8
        L76:
            r8 = r6
            r6 = r0
        L78:
            r6.f13591z = r8
            long r6 = r7.f13535a
            jb.v r6 = jb.v.f6774a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u.t0.F0(u.t0, u.o, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object G0(u.t0 r9, u.p r10, pb.c r11) {
        /*
            boolean r0 = r11 instanceof u.z
            if (r0 == 0) goto L13
            r0 = r11
            u.z r0 = (u.z) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            u.z r0 = new u.z
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f13622g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r7 = 0
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2c
            u.p r10 = r0.f13621f
            u.t0 r9 = r0.f13620c
            id.c.I(r11)
            goto L55
        L2c:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            r9 = 0
            return r9
        L33:
            id.c.I(r11)
            v.b r11 = r9.f13591z
            if (r11 == 0) goto L57
            v.k r2 = r9.f13589x
            if (r2 == 0) goto L55
            v.c r4 = new v.c
            r4.<init>()
            r4.f14302a = r11
            java.lang.invoke.VarHandle.storeStoreFence()
            r0.f13620c = r9
            r0.f13621f = r10
            r0.i = r3
            java.lang.Object r11 = r2.a(r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r9.f13591z = r7
        L57:
            r4 = r9
            long r5 = r10.f13546a
            n1.d r9 = r4.E
            kc.t r9 = r9.c()
            u.r0 r3 = new u.r0
            r8 = 0
            r3.<init>(r4, r5, r7, r8)
            r10 = 3
            kc.w.u(r9, r7, r7, r3, r10)
            jb.v r9 = jb.v.f6774a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u.t0.G0(u.t0, u.p, pb.c):java.lang.Object");
    }

    @Override // u1.s1
    public final void A() {
        o1.i0 i0Var = this.B;
        if (i0Var != null) {
            i0Var.A();
        }
    }

    public final void H0() {
        v.b bVar = this.f13591z;
        if (bVar != null) {
            v.k kVar = this.f13589x;
            if (kVar != null) {
                kVar.b(new v.a(bVar));
            }
            this.f13591z = null;
        }
    }

    @Override // b1.m
    public final void U(b1.j jVar) {
        jVar.c(false);
    }

    @Override // u1.i1
    public final void c0() {
        u1.f.r(this, new v(this, 2));
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        if (this.f13588w && (this.L == null || this.M == null)) {
            this.L = new w(this, 1);
            this.M = new r0(this, null);
        }
        w wVar = this.L;
        if (wVar != null) {
            fc.c[] cVarArr = a2.w.f144a;
            kVar.d(a2.j.f53d, new a2.a(null, wVar));
        }
        r0 r0Var = this.M;
        if (r0Var != null) {
            fc.c[] cVarArr2 = a2.w.f144a;
            kVar.d(a2.j.f54e, r0Var);
        }
    }

    @Override // m1.c
    public final boolean h(KeyEvent keyEvent) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, java.util.List] */
    @Override // u1.s1
    public final void q(o1.j jVar, o1.k kVar, long j10) {
        nb.c cVar;
        long j11;
        ?? r02 = jVar.f9056a;
        int size = r02.size();
        int i = 0;
        while (true) {
            cVar = null;
            if (i >= size) {
                break;
            }
            if (((Boolean) this.f13587v.invoke((o1.s) r02.get(i))).booleanValue()) {
                if (this.f13588w && this.B == null) {
                    t5.e eVar = new t5.e(this, cVar, 1);
                    o1.j jVar2 = o1.d0.f9016a;
                    o1.i0 i0Var = new o1.i0(null, null, o1.e0.f9019c);
                    i0Var.f9050u = eVar;
                    B0(i0Var);
                    this.B = i0Var;
                }
                o1.i0 i0Var2 = this.B;
                if (i0Var2 != null) {
                    i0Var2.q(jVar, kVar, j10);
                }
            } else {
                i++;
            }
        }
        if (kVar == o1.k.f9060f && jVar.f9058c == 6) {
            ?? r11 = jVar.f9056a;
            int size2 = r11.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (((o1.s) r11.get(i3)).b()) {
                    return;
                }
            }
            this.K.getClass();
            o2.c cVar2 = u1.f.u(this).A;
            c1.b bVarA = c1.b.a(0L);
            int size3 = r11.size();
            int i10 = 0;
            while (true) {
                j11 = bVarA.f2165a;
                if (i10 >= size3) {
                    break;
                }
                bVarA = c1.b.a(c1.b.h(j11, ((o1.s) r11.get(i10)).f9079j));
                i10++;
            }
            kc.w.u(p0(), null, null, new r0(this, c1.b.i(-cVar2.X(64), j11), cVar, 2), 3);
            int size4 = r11.size();
            for (int i11 = 0; i11 < size4; i11++) {
                ((o1.s) r11.get(i11)).a();
            }
        }
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // w0.l
    public final void t0() {
        u1.f.r(this, new v(this, 2));
        this.K = a.f13416a;
    }

    @Override // w0.l
    public final void u0() {
        this.A = false;
        H0();
    }

    @Override // m1.c
    public final boolean y(KeyEvent keyEvent) {
        long jD;
        if (!this.f13588w || ((!m1.a.a(id.k.b(keyEvent.getKeyCode()), m1.a.f8183n) && !m1.a.a(id.k.b(keyEvent.getKeyCode()), m1.a.f8182m)) || id.c.t(keyEvent) != 2 || keyEvent.isCtrlPressed())) {
            return false;
        }
        boolean z10 = this.H.f13627d == f0.f13453c;
        i iVar = this.J;
        if (z10) {
            int i = (int) (iVar.f13486z & 4294967295L);
            jD = id.k.d(0.0f, m1.a.a(id.k.b(keyEvent.getKeyCode()), m1.a.f8182m) ? i : -i);
        } else {
            int i3 = (int) (iVar.f13486z >> 32);
            jD = id.k.d(m1.a.a(id.k.b(keyEvent.getKeyCode()), m1.a.f8182m) ? i3 : -i3, 0.0f);
        }
        kc.w.u(p0(), null, null, new r0(this, jD, null, 1), 3);
        return true;
    }
}
