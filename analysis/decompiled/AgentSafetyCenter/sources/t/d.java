package t;

import android.view.KeyEvent;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import u1.a2;
import u1.s1;
import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d extends u1.m implements s1, m1.c, b1.d, v1, a2 {
    public static final y0 L = new y0();
    public final a0 A = new a0();
    public final c0 B;
    public o1.i0 C;
    public u1.l D;
    public v.m E;
    public v.h F;
    public final LinkedHashMap G;
    public long H;
    public v.k I;
    public boolean J;
    public final y0 K;

    /* renamed from: u, reason: collision with root package name */
    public v.k f12950u;

    /* renamed from: v, reason: collision with root package name */
    public t0 f12951v;

    /* renamed from: w, reason: collision with root package name */
    public String f12952w;

    /* renamed from: x, reason: collision with root package name */
    public a2.g f12953x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12954y;

    /* renamed from: z, reason: collision with root package name */
    public xb.a f12955z;

    public d(v.k kVar, t0 t0Var, boolean z10, String str, a2.g gVar, xb.a aVar) {
        this.f12950u = kVar;
        this.f12951v = t0Var;
        this.f12952w = str;
        this.f12953x = gVar;
        this.f12954y = z10;
        this.f12955z = aVar;
        c0 c0Var = new c0();
        b0 b0Var = new b0();
        b0Var.f12942s = kVar;
        c0Var.B0(b0Var);
        c0Var.f12947v = b0Var;
        d0 d0Var = new d0();
        c0Var.B0(d0Var);
        c0Var.f12948w = d0Var;
        e0 e0Var = new e0();
        c0Var.B0(e0Var);
        c0Var.f12949x = e0Var;
        c0Var.B0(new b1.q(new androidx.room.d(1, b1.s.f1853a, b1.s.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0, 0, 1), 3));
        VarHandle.storeStoreFence();
        this.B = c0Var;
        this.G = new LinkedHashMap();
        this.H = 0L;
        v.k kVar2 = this.f12950u;
        this.I = kVar2;
        this.J = kVar2 == null && this.f12951v != null;
        this.K = L;
    }

    @Override // u1.s1
    public final void A() {
        v.h hVar;
        v.k kVar = this.f12950u;
        if (kVar != null && (hVar = this.F) != null) {
            kVar.b(new v.i(hVar));
        }
        this.F = null;
        o1.i0 i0Var = this.C;
        if (i0Var != null) {
            i0Var.A();
        }
    }

    public abstract Object F0(o1.w wVar, androidx.lifecycle.h0 h0Var);

    public final void G0() {
        v.k kVar = this.f12950u;
        LinkedHashMap linkedHashMap = this.G;
        if (kVar != null) {
            v.m mVar = this.E;
            if (mVar != null) {
                kVar.b(new v.l(mVar));
            }
            v.h hVar = this.F;
            if (hVar != null) {
                kVar.b(new v.i(hVar));
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                kVar.b(new v.l((v.m) it.next()));
            }
        }
        this.E = null;
        this.F = null;
        linkedHashMap.clear();
    }

    public final void H0() {
        t0 t0Var;
        if (this.D == null && (t0Var = this.f12951v) != null) {
            if (this.f12950u == null) {
                this.f12950u = t0.a.a();
            }
            this.B.E0(this.f12950u);
            v.k kVar = this.f12950u;
            kVar.getClass();
            u1.l lVarA = t0Var.a(kVar);
            B0(lVarA);
            this.D = lVarA;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0(v.k r4, t.t0 r5, boolean r6, java.lang.String r7, a2.g r8, xb.a r9) {
        /*
            r3 = this;
            v.k r0 = r3.I
            boolean r0 = yb.k.a(r0, r4)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L13
            r3.G0()
            r3.I = r4
            r3.f12950u = r4
            r4 = r1
            goto L14
        L13:
            r4 = r2
        L14:
            t.t0 r0 = r3.f12951v
            boolean r0 = yb.k.a(r0, r5)
            if (r0 != 0) goto L1f
            r3.f12951v = r5
            r4 = r1
        L1f:
            boolean r5 = r3.f12954y
            t.c0 r0 = r3.B
            if (r5 == r6) goto L3e
            t.a0 r5 = r3.A
            if (r6 == 0) goto L30
            r3.B0(r5)
            r3.B0(r0)
            goto L39
        L30:
            r3.C0(r5)
            r3.C0(r0)
            r3.G0()
        L39:
            u1.f.n(r3)
            r3.f12954y = r6
        L3e:
            java.lang.String r5 = r3.f12952w
            boolean r5 = yb.k.a(r5, r7)
            if (r5 != 0) goto L4b
            r3.f12952w = r7
            u1.f.n(r3)
        L4b:
            a2.g r5 = r3.f12953x
            boolean r5 = yb.k.a(r5, r8)
            if (r5 != 0) goto L58
            r3.f12953x = r8
            u1.f.n(r3)
        L58:
            r3.f12955z = r9
            boolean r5 = r3.J
            v.k r6 = r3.I
            if (r6 != 0) goto L66
            t.t0 r7 = r3.f12951v
            if (r7 == 0) goto L66
            r7 = r1
            goto L67
        L66:
            r7 = r2
        L67:
            if (r5 == r7) goto L79
            if (r6 != 0) goto L70
            t.t0 r5 = r3.f12951v
            if (r5 == 0) goto L70
            r2 = r1
        L70:
            r3.J = r2
            if (r2 != 0) goto L79
            u1.l r5 = r3.D
            if (r5 != 0) goto L79
            goto L7a
        L79:
            r1 = r4
        L7a:
            if (r1 == 0) goto L8f
            u1.l r4 = r3.D
            if (r4 != 0) goto L84
            boolean r5 = r3.J
            if (r5 != 0) goto L8f
        L84:
            if (r4 == 0) goto L89
            r3.C0(r4)
        L89:
            r4 = 0
            r3.D = r4
            r3.H0()
        L8f:
            v.k r3 = r3.f12950u
            r0.E0(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t.d.I0(v.k, t.t0, boolean, java.lang.String, a2.g, xb.a):void");
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        a2.g gVar = this.f12953x;
        if (gVar != null) {
            a2.w.a(kVar, gVar.f45a);
        }
        String str = this.f12952w;
        ad.l lVar = new ad.l(this, 22);
        fc.c[] cVarArr = a2.w.f144a;
        kVar.d(a2.j.f51b, new a2.a(str, lVar));
        if (this.f12954y) {
            this.B.f0(kVar);
        } else {
            kVar.d(a2.u.i, jb.v.f6774a);
        }
        E0(kVar);
    }

    @Override // m1.c
    public final boolean h(KeyEvent keyEvent) {
        return false;
    }

    @Override // u1.a2
    public final Object k() {
        return this.K;
    }

    @Override // u1.v1
    public final boolean o0() {
        return true;
    }

    @Override // u1.s1
    public final void q(o1.j jVar, o1.k kVar, long j10) {
        long j11 = ((j10 >> 33) << 32) | (((j10 << 32) >> 33) & 4294967295L);
        this.H = id.k.d((int) (j11 >> 32), (int) (j11 & 4294967295L));
        H0();
        nb.c cVar = null;
        if (this.f12954y && kVar == o1.k.f9060f) {
            int i = jVar.f9058c;
            if (i == 4) {
                kc.w.u(p0(), null, null, new c(this, cVar, 0), 3);
            } else if (i == 5) {
                kc.w.u(p0(), null, null, new c(this, cVar, 1), 3);
            }
        }
        if (this.C == null) {
            androidx.lifecycle.h0 h0Var = new androidx.lifecycle.h0(this, cVar, 28);
            o1.j jVar2 = o1.d0.f9016a;
            o1.i0 i0Var = new o1.i0(null, null, o1.e0.f9019c);
            i0Var.f9050u = h0Var;
            B0(i0Var);
            this.C = i0Var;
        }
        o1.i0 i0Var2 = this.C;
        if (i0Var2 != null) {
            i0Var2.q(jVar, kVar, j10);
        }
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // w0.l
    public final void t0() {
        if (!this.J) {
            H0();
        }
        if (this.f12954y) {
            B0(this.A);
            B0(this.B);
        }
    }

    @Override // w0.l
    public final void u0() {
        G0();
        if (this.I == null) {
            this.f12950u = null;
        }
        u1.l lVar = this.D;
        if (lVar != null) {
            C0(lVar);
        }
        this.D = null;
    }

    @Override // b1.d
    public final void w(b1.p pVar) {
        if (pVar.a()) {
            H0();
        }
        if (this.f12954y) {
            this.B.w(pVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    @Override // m1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y(android.view.KeyEvent r13) {
        /*
            r12 = this;
            r12.H0()
            boolean r0 = r12.f12954y
            r1 = 3
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 66
            r4 = 23
            r5 = 32
            r6 = 0
            r7 = 1
            r8 = 0
            java.util.LinkedHashMap r9 = r12.G
            if (r0 == 0) goto L74
            int r0 = t.s.f13062b
            int r0 = id.c.t(r13)
            r10 = 2
            if (r0 != r10) goto L74
            int r0 = r13.getKeyCode()
            long r10 = id.k.b(r0)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L2f
            if (r0 == r3) goto L2f
            if (r0 == r2) goto L2f
            goto L74
        L2f:
            int r0 = r13.getKeyCode()
            long r2 = id.k.b(r0)
            m1.a r0 = new m1.a
            r0.<init>()
            r0.f8186a = r2
            java.lang.invoke.VarHandle.storeStoreFence()
            boolean r0 = r9.containsKey(r0)
            if (r0 != 0) goto Lc1
            v.m r0 = new v.m
            long r2 = r12.H
            r0.<init>(r2)
            int r13 = r13.getKeyCode()
            long r2 = id.k.b(r13)
            m1.a r13 = new m1.a
            r13.<init>()
            r13.f8186a = r2
            java.lang.invoke.VarHandle.storeStoreFence()
            r9.put(r13, r0)
            v.k r13 = r12.f12950u
            if (r13 == 0) goto L73
            kc.t r13 = r12.p0()
            t.b r2 = new t.b
            r2.<init>(r12, r0, r8, r6)
            kc.w.u(r13, r8, r8, r2, r1)
        L73:
            return r7
        L74:
            boolean r0 = r12.f12954y
            if (r0 == 0) goto Lc1
            int r0 = t.s.f13062b
            int r0 = id.c.t(r13)
            if (r0 != r7) goto Lc1
            int r0 = r13.getKeyCode()
            long r10 = id.k.b(r0)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L91
            if (r0 == r3) goto L91
            if (r0 == r2) goto L91
            return r6
        L91:
            int r13 = r13.getKeyCode()
            long r2 = id.k.b(r13)
            m1.a r13 = new m1.a
            r13.<init>()
            r13.f8186a = r2
            java.lang.invoke.VarHandle.storeStoreFence()
            java.lang.Object r13 = r9.remove(r13)
            v.m r13 = (v.m) r13
            if (r13 == 0) goto Lbb
            v.k r0 = r12.f12950u
            if (r0 == 0) goto Lbb
            kc.t r0 = r12.p0()
            t.b r2 = new t.b
            r2.<init>(r12, r13, r8, r7)
            kc.w.u(r0, r8, r8, r2, r1)
        Lbb:
            xb.a r12 = r12.f12955z
            r12.invoke()
            return r7
        Lc1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t.d.y(android.view.KeyEvent):boolean");
    }

    public void E0(a2.k kVar) {
    }
}
