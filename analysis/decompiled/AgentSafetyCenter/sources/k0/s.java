package k0;

import android.os.Trace;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {
    public int A;
    public int B;
    public boolean C;
    public q D;
    public ArrayList E;
    public boolean F;
    public e2 G;
    public f2 H;
    public i2 I;
    public boolean J;
    public s0.g K;
    public l0.a L;
    public l0.b M;
    public b N;
    public l0.c O;
    public od.f P;
    public v0.b Q;
    public nb.g R;
    public boolean S;
    public long T;
    public x U;

    /* renamed from: a, reason: collision with root package name */
    public p5.m f7033a;

    /* renamed from: b, reason: collision with root package name */
    public v f7034b;

    /* renamed from: c, reason: collision with root package name */
    public f2 f7035c;

    /* renamed from: d, reason: collision with root package name */
    public p.i0 f7036d;

    /* renamed from: e, reason: collision with root package name */
    public l0.a f7037e;

    /* renamed from: f, reason: collision with root package name */
    public l0.a f7038f;

    /* renamed from: g, reason: collision with root package name */
    public a2.i f7039g;

    /* renamed from: h, reason: collision with root package name */
    public y f7040h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public p1 f7041j;

    /* renamed from: k, reason: collision with root package name */
    public int f7042k;

    /* renamed from: l, reason: collision with root package name */
    public int f7043l;

    /* renamed from: m, reason: collision with root package name */
    public int f7044m;

    /* renamed from: n, reason: collision with root package name */
    public r0 f7045n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f7046o;

    /* renamed from: p, reason: collision with root package name */
    public p.s f7047p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7048q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7049r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f7050s;

    /* renamed from: t, reason: collision with root package name */
    public r0 f7051t;

    /* renamed from: u, reason: collision with root package name */
    public s0.g f7052u;

    /* renamed from: v, reason: collision with root package name */
    public p.u f7053v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7054w;

    /* renamed from: x, reason: collision with root package name */
    public r0 f7055x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7056y;

    /* renamed from: z, reason: collision with root package name */
    public int f7057z;

    public static final int O(s sVar, int i, boolean z10, int i3) {
        e2 e2Var = sVar.G;
        if (e2Var.j(i)) {
            int i10 = e2Var.i(i);
            Object objP = e2Var.p(e2Var.f6883b, i);
            if (i10 == 206 && yb.k.a(objP, t.f7066e)) {
                Object objH = e2Var.h(i, 0);
                o oVar = objH instanceof o ? (o) objH : null;
                if (oVar != null) {
                    for (s sVar2 : oVar.f6988c.f7001e) {
                        f2 f2Var = sVar2.f7035c;
                        if (f2Var.f6901f > 0 && (f2Var.f6900c[1] & 67108864) != 0) {
                            y yVar = sVar2.f7040h;
                            synchronized (yVar.f7119h) {
                                yVar.o();
                                p.f0 f0Var = yVar.f7128r;
                                yVar.f7128r = h5.t.t();
                                try {
                                    yVar.f7134x.e0(f0Var);
                                } finally {
                                }
                            }
                            l0.a aVar = new l0.a();
                            sVar2.L = aVar;
                            e2 e2VarC = sVar2.f7035c.c();
                            try {
                                sVar2.G = e2VarC;
                                l0.b bVar = sVar2.M;
                                l0.a aVar2 = bVar.f7659b;
                                try {
                                    bVar.f7659b = aVar;
                                    sVar2.N(0);
                                    l0.b bVar2 = sVar2.M;
                                    bVar2.b();
                                    if (bVar2.f7660c) {
                                        bVar2.f7659b.f7656c.T(l0.b0.f7669c);
                                        if (bVar2.f7660c) {
                                            bVar2.d(false);
                                            bVar2.d(false);
                                            bVar2.f7659b.f7656c.T(l0.m.f7695c);
                                            bVar2.f7660c = false;
                                        }
                                    }
                                } finally {
                                }
                            } finally {
                                e2VarC.c();
                            }
                        }
                        sVar.f7034b.n(sVar2.f7040h);
                    }
                }
                return e2Var.o(i);
            }
            if (!e2Var.l(i)) {
                return e2Var.o(i);
            }
        } else if (e2Var.d(i)) {
            int iA = h2.a(e2Var.f6883b, i) + i;
            int iO = 0;
            for (int iA2 = i + 1; iA2 < iA; iA2 += h2.a(e2Var.f6883b, iA2)) {
                boolean zL = e2Var.l(iA2);
                if (zL) {
                    sVar.M.c();
                    l0.b bVar3 = sVar.M;
                    Object objN = e2Var.n(iA2);
                    bVar3.c();
                    bVar3.f7665h.add(objN);
                }
                iO += O(sVar, iA2, zL || z10, zL ? 0 : i3 + iO);
                if (zL) {
                    sVar.M.c();
                    sVar.M.a();
                }
            }
            if (!e2Var.l(i)) {
                return iO;
            }
        } else if (!e2Var.l(i)) {
            return e2Var.o(i);
        }
        return 1;
    }

    public final v0.b A() {
        if (this.C) {
            return this.Q;
        }
        return null;
    }

    public final boolean B() {
        v1 v1VarY;
        return (this.S || this.f7056y || this.f7054w || (v1VarY = y()) == null || (v1VarY.f7089b & 8) != 0) ? false : true;
    }

    public final void C(ArrayList arrayList) {
        l0.b bVar = this.M;
        l0.a aVar = this.f7038f;
        l0.a aVar2 = bVar.f7659b;
        try {
            bVar.f7659b = aVar;
            aVar.f7656c.T(l0.z.f7712c);
            if (arrayList.size() <= 0) {
                bVar.f7659b.f7656c.T(l0.n.f7696c);
                bVar.f7663f = 0;
            } else {
                jb.g gVar = (jb.g) arrayList.get(0);
                b1 b1Var = (b1) gVar.f6759c;
                b1Var.getClass();
                throw null;
            }
        } finally {
            bVar.f7659b = aVar2;
        }
    }

    public final void D(s0.g gVar, Object obj) {
        T(null, 126665345, 0, null);
        E();
        j0(obj);
        long j10 = this.T;
        try {
            this.T = 126665345;
            if (this.S) {
                i2.y(this.I);
            }
            boolean z10 = (this.S || yb.k.a(this.G.f(), gVar)) ? false : true;
            if (z10) {
                K(gVar);
            }
            T(t.f7064c, 202, 0, gVar);
            this.K = null;
            boolean z11 = this.f7054w;
            this.f7054w = z10;
            r rVar = new r();
            rVar.f7028c = obj;
            VarHandle.storeStoreFence();
            s0.h.c(this, new s0.c(316014703, true, rVar));
            this.f7054w = z11;
        } finally {
        }
    }

    public final Object E() {
        boolean z10 = this.S;
        y0 y0Var = m.f6974a;
        if (!z10) {
            Object objM = this.G.m();
            if (!this.f7056y || (objM instanceof o)) {
                return objM;
            }
        } else if (this.f7049r) {
            t.c("A call to createNode(), emitNode() or useNode() expected");
            return y0Var;
        }
        return y0Var;
    }

    public final List F() {
        v vVar = this.f7034b;
        u uVarG = vVar.g();
        y yVar = uVarG != null ? (y) uVarG : null;
        if (yVar != null) {
            f2 f2Var = yVar.f7120j;
            e2 e2VarC = f2Var.c();
            try {
                Integer numJ = t2.a.j(e2VarC, vVar, 0, e2VarC.f6884c);
                if (numJ != null) {
                    try {
                        return t2.a.q(f2Var.c(), numJ.intValue(), 0);
                    } finally {
                    }
                }
            } finally {
            }
        }
        return kb.s.f7404c;
    }

    public final int G(int i) {
        int iQ = this.G.q(i) + 1;
        int i3 = 0;
        while (iQ < i) {
            if (!this.G.k(iQ)) {
                i3++;
            }
            iQ += h2.a(this.G.f6883b, iQ);
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0005, B:6:0x0012, B:8:0x0020, B:12:0x0029, B:11:0x0026, B:15:0x0030, B:18:0x0038, B:21:0x0040, B:23:0x0048, B:25:0x004e, B:26:0x0052, B:27:0x0053, B:29:0x0059, B:22:0x0044), top: B:34:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(k0.y r9, k0.y r10, java.lang.Integer r11, java.util.List r12, xb.a r13) {
        /*
            r8 = this;
            boolean r0 = r8.F
            int r1 = r8.f7042k
            r2 = 1
            r8.F = r2     // Catch: java.lang.Throwable -> L24
            r2 = 0
            r8.f7042k = r2     // Catch: java.lang.Throwable -> L24
            int r3 = r12.size()     // Catch: java.lang.Throwable -> L24
            r4 = r2
        Lf:
            r5 = 0
            if (r4 >= r3) goto L2c
            java.lang.Object r6 = r12.get(r4)     // Catch: java.lang.Throwable -> L24
            jb.g r6 = (jb.g) r6     // Catch: java.lang.Throwable -> L24
            java.lang.Object r7 = r6.f6759c     // Catch: java.lang.Throwable -> L24
            k0.v1 r7 = (k0.v1) r7     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r6.f6760f     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L26
            r8.d0(r7, r6)     // Catch: java.lang.Throwable -> L24
            goto L29
        L24:
            r9 = move-exception
            goto L62
        L26:
            r8.d0(r7, r5)     // Catch: java.lang.Throwable -> L24
        L29:
            int r4 = r4 + 1
            goto Lf
        L2c:
            if (r9 == 0) goto L59
            if (r11 == 0) goto L35
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L24
            goto L36
        L35:
            r11 = -1
        L36:
            if (r10 == 0) goto L53
            boolean r12 = r10.equals(r9)     // Catch: java.lang.Throwable -> L24
            if (r12 != 0) goto L53
            if (r11 < 0) goto L53
            r9.f7130t = r10     // Catch: java.lang.Throwable -> L24
            r9.f7131u = r11     // Catch: java.lang.Throwable -> L24
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L4d
            r9.f7130t = r5     // Catch: java.lang.Throwable -> L24
            r9.f7131u = r2     // Catch: java.lang.Throwable -> L24
            goto L57
        L4d:
            r10 = move-exception
            r9.f7130t = r5     // Catch: java.lang.Throwable -> L24
            r9.f7131u = r2     // Catch: java.lang.Throwable -> L24
            throw r10     // Catch: java.lang.Throwable -> L24
        L53:
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L24
        L57:
            if (r10 != 0) goto L5d
        L59:
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L24
        L5d:
            r8.F = r0
            r8.f7042k = r1
            return r10
        L62:
            r8.F = r0
            r8.f7042k = r1
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.H(k0.y, k0.y, java.lang.Integer, java.util.List, xb.a):java.lang.Object");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I() {
        /*
            Method dump skipped, instructions count: 897
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.I():void");
    }

    public final void J() {
        int i;
        N(this.G.f6888g);
        l0.b bVar = this.M;
        bVar.d(false);
        r0 r0Var = bVar.f7661d;
        s sVar = bVar.f7658a;
        e2 e2Var = sVar.G;
        if (e2Var.f6884c > 0 && r0Var.a(-2) != (i = e2Var.i)) {
            if (!bVar.f7660c && bVar.f7662e) {
                bVar.d(false);
                bVar.f7659b.f7656c.T(l0.q.f7699c);
                bVar.f7660c = true;
            }
            if (i > 0) {
                b bVarA = e2Var.a(i);
                r0Var.c(i);
                bVar.d(false);
                l0.k0 k0Var = bVar.f7659b.f7656c;
                k0Var.T(l0.p.f7698c);
                id.k.R(k0Var, 0, bVarA);
                bVar.f7660c = true;
            }
        }
        bVar.f7659b.f7656c.T(l0.x.f7710c);
        int i3 = bVar.f7663f;
        e2 e2Var2 = sVar.G;
        bVar.f7663f = h2.a(e2Var2.f6883b, e2Var2.f6888g) + i3;
    }

    public final void K(s0.g gVar) {
        p.u uVar = this.f7053v;
        if (uVar == null) {
            uVar = new p.u();
            this.f7053v = uVar;
        }
        uVar.h(this.G.f6888g, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(int r7, int r8, int r9) {
        /*
            r6 = this;
            k0.e2 r0 = r6.G
            if (r7 != r8) goto L5
            goto L1a
        L5:
            if (r7 == r9) goto L6b
            if (r8 != r9) goto Lb
            goto L6b
        Lb:
            int r1 = r0.q(r7)
            if (r1 != r8) goto L14
            r9 = r8
            goto L6b
        L14:
            int r1 = r0.q(r8)
            if (r1 != r7) goto L1c
        L1a:
            r9 = r7
            goto L6b
        L1c:
            int r1 = r0.q(r7)
            int r2 = r0.q(r8)
            if (r1 != r2) goto L2b
            int r9 = r0.q(r7)
            goto L6b
        L2b:
            r1 = 0
            r2 = r7
            r3 = r1
        L2e:
            if (r2 <= 0) goto L39
            if (r2 == r9) goto L39
            int r2 = r0.q(r2)
            int r3 = r3 + 1
            goto L2e
        L39:
            r2 = r8
            r4 = r1
        L3b:
            if (r2 <= 0) goto L46
            if (r2 == r9) goto L46
            int r2 = r0.q(r2)
            int r4 = r4 + 1
            goto L3b
        L46:
            int r9 = r3 - r4
            r5 = r7
            r2 = r1
        L4a:
            if (r2 >= r9) goto L53
            int r5 = r0.q(r5)
            int r2 = r2 + 1
            goto L4a
        L53:
            int r4 = r4 - r3
            r9 = r8
        L55:
            if (r1 >= r4) goto L5e
            int r9 = r0.q(r9)
            int r1 = r1 + 1
            goto L55
        L5e:
            r1 = r9
            r9 = r5
        L60:
            if (r9 == r1) goto L6b
            int r9 = r0.q(r9)
            int r1 = r0.q(r1)
            goto L60
        L6b:
            if (r7 <= 0) goto L7f
            if (r7 == r9) goto L7f
            boolean r1 = r0.l(r7)
            if (r1 == 0) goto L7a
            l0.b r1 = r6.M
            r1.a()
        L7a:
            int r7 = r0.q(r7)
            goto L6b
        L7f:
            r6.p(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.L(int, int, int):void");
    }

    public final Object M() {
        boolean z10 = this.S;
        y0 y0Var = m.f6974a;
        if (!z10) {
            Object objM = this.G.m();
            if (!this.f7056y || (objM instanceof o)) {
                return objM instanceof b2 ? ((b2) objM).f6867a : objM;
            }
        } else if (this.f7049r) {
            t.c("A call to createNode(), emitNode() or useNode() expected");
            return y0Var;
        }
        return y0Var;
    }

    public final void N(int i) {
        l0.b bVar = this.M;
        boolean zL = this.G.l(i);
        if (zL) {
            bVar.c();
            Object objN = this.G.n(i);
            bVar.c();
            bVar.f7665h.add(objN);
        }
        O(this, i, zL, 0);
        bVar.c();
        if (zL) {
            bVar.a();
        }
    }

    public final boolean P(int i, boolean z10) {
        if ((i & 1) == 0 && (this.S || this.f7056y)) {
            if (this.P != null) {
                y();
                return true;
            }
        } else if (!z10 && B()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.Q():void");
    }

    public final void R() {
        e2 e2Var = this.G;
        int i = e2Var.i;
        this.f7043l = i >= 0 ? e2Var.f6883b[(i * 5) + 1] & 67108863 : 0;
        e2Var.t();
    }

    public final void S() {
        if (this.f7043l != 0) {
            t.c("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (this.S) {
            return;
        }
        v1 v1VarY = y();
        if (v1VarY != null) {
            int i = v1VarY.f7089b;
            if ((i & 128) == 0) {
                v1VarY.f7089b = i | 16;
            }
        }
        if (this.f7050s.isEmpty()) {
            R();
        } else {
            I();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(java.lang.Object r27, int r28, int r29, java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.T(java.lang.Object, int, int, java.lang.Object):void");
    }

    public final void U() {
        T(null, -127, 0, null);
    }

    public final void V(int i, e1 e1Var) {
        T(e1Var, i, 0, null);
    }

    public final void W(Object obj, boolean z10) {
        if (z10) {
            e2 e2Var = this.G;
            if (e2Var.f6891k <= 0) {
                if ((e2Var.f6883b[(e2Var.f6888g * 5) + 1] & 1073741824) == 0) {
                    q1.a("Expected a node group");
                }
                e2Var.u();
                return;
            }
            return;
        }
        if (obj != null && this.G.f() != obj) {
            l0.b bVar = this.M;
            bVar.getClass();
            bVar.d(false);
            l0.k0 k0Var = bVar.f7659b.f7656c;
            k0Var.T(l0.e0.f7676c);
            id.k.R(k0Var, 0, obj);
        }
        this.G.u();
    }

    public final void X(int i) {
        int i3;
        int i10;
        if (this.f7041j != null) {
            T(null, i, 0, null);
            return;
        }
        if (this.f7049r) {
            t.c("A call to createNode(), emitNode() or useNode() expected");
        }
        this.T = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ i, 3) ^ this.f7044m;
        this.f7044m++;
        e2 e2Var = this.G;
        boolean z10 = this.S;
        y0 y0Var = m.f6974a;
        if (z10) {
            e2Var.f6891k++;
            this.I.P(i, y0Var, false, y0Var);
            w(false, null);
            return;
        }
        if (e2Var.g() == i && ((i10 = e2Var.f6888g) >= e2Var.f6889h || (e2Var.f6883b[(i10 * 5) + 1] & 536870912) == 0)) {
            e2Var.u();
            w(false, null);
            return;
        }
        if (e2Var.f6891k <= 0 && (i3 = e2Var.f6888g) != e2Var.f6889h) {
            int i11 = this.f7042k;
            J();
            this.M.e(i11, e2Var.s());
            t.a(this.f7050s, i3, e2Var.f6888g);
        }
        e2Var.f6891k++;
        this.S = true;
        this.K = null;
        if (this.I.f6959w) {
            i2 i2VarD = this.H.d();
            this.I = i2VarD;
            i2VarD.L();
            this.J = false;
            this.K = null;
        }
        i2 i2Var = this.I;
        i2Var.d();
        int i12 = i2Var.f6956t;
        i2Var.P(i, y0Var, false, y0Var);
        this.N = i2Var.b(i12);
        w(false, null);
    }

    public final void Y(int i) {
        T(null, i, 0, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k0.s Z(int r7) {
        /*
            r6 = this;
            a2.i r0 = r6.f7039g
            r6.X(r7)
            java.util.ArrayList r7 = r6.E
            k0.y r1 = r6.f7040h
            boolean r2 = r6.S
            if (r2 == 0) goto L26
            k0.v1 r2 = new k0.v1
            r2.<init>(r1)
            r7.add(r2)
            r6.j0(r2)
            int r7 = r6.B
            r2.f7092e = r7
            int r7 = r2.f7089b
            r7 = r7 & (-17)
            r2.f7089b = r7
            r0.x()
            return r6
        L26:
            java.util.ArrayList r2 = r6.f7050s
            k0.e2 r3 = r6.G
            int r3 = r3.i
            int r3 = k0.t.e(r3, r2)
            if (r3 < 0) goto L39
            java.lang.Object r2 = r2.remove(r3)
            k0.s0 r2 = (k0.s0) r2
            goto L3a
        L39:
            r2 = 0
        L3a:
            k0.e2 r3 = r6.G
            java.lang.Object r3 = r3.m()
            k0.y0 r4 = k0.m.f6974a
            boolean r4 = yb.k.a(r3, r4)
            if (r4 == 0) goto L51
            k0.v1 r3 = new k0.v1
            r3.<init>(r1)
            r6.j0(r3)
            goto L56
        L51:
            r3.getClass()
            k0.v1 r3 = (k0.v1) r3
        L56:
            r1 = 0
            r4 = 1
            if (r2 != 0) goto L6e
            int r2 = r3.f7089b
            r5 = r2 & 64
            if (r5 == 0) goto L62
            r5 = r4
            goto L63
        L62:
            r5 = r1
        L63:
            if (r5 == 0) goto L69
            r2 = r2 & (-65)
            r3.f7089b = r2
        L69:
            if (r5 == 0) goto L6c
            goto L6e
        L6c:
            r2 = r1
            goto L6f
        L6e:
            r2 = r4
        L6f:
            int r5 = r3.f7089b
            if (r2 == 0) goto L76
            r2 = r5 | 8
            goto L78
        L76:
            r2 = r5 & (-9)
        L78:
            r3.f7089b = r2
            r7.add(r3)
            int r7 = r6.B
            r3.f7092e = r7
            int r7 = r3.f7089b
            r7 = r7 & (-17)
            r3.f7089b = r7
            r0.x()
            int r7 = r3.f7089b
            r0 = r7 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto Lb4
            r7 = r7 & (-257(0xfffffffffffffeff, float:NaN))
            r7 = r7 | 512(0x200, float:7.17E-43)
            r3.f7089b = r7
            l0.b r7 = r6.M
            l0.a r7 = r7.f7659b
            l0.k0 r7 = r7.f7656c
            l0.c0 r0 = l0.c0.f7672c
            r7.T(r0)
            id.k.R(r7, r1, r3)
            boolean r7 = r6.f7056y
            if (r7 != 0) goto Lb4
            int r7 = r3.f7089b
            r0 = r7 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto Lb4
            r6.f7056y = r4
            r7 = r7 | 1024(0x400, float:1.435E-42)
            r3.f7089b = r7
        Lb4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.Z(int):k0.s");
    }

    public final void a() {
        i();
        this.i.clear();
        this.f7045n.f7030b = 0;
        this.f7051t.f7030b = 0;
        this.f7055x.f7030b = 0;
        this.f7053v = null;
        l0.c cVar = this.O;
        cVar.f7671d.P();
        cVar.f7670c.P();
        this.T = 0;
        this.A = 0;
        this.f7049r = false;
        this.S = false;
        this.f7056y = false;
        this.F = false;
        this.f7057z = -1;
        e2 e2Var = this.G;
        if (!e2Var.f6887f) {
            e2Var.c();
        }
        if (this.I.f6959w) {
            return;
        }
        x();
    }

    public final void a0(Object obj) {
        if (!this.S && this.G.g() == 207 && !yb.k.a(this.G.f(), obj) && this.f7057z < 0) {
            this.f7057z = this.G.f6888g;
            this.f7056y = true;
        }
        T(null, 207, 0, obj);
    }

    public final void b(Object obj, xb.p pVar) {
        if (this.S) {
            l0.k0 k0Var = this.O.f7670c;
            k0Var.T(l0.f0.f7678c);
            id.k.R(k0Var, 0, obj);
            pVar.getClass();
            yb.x.c(2, pVar);
            id.k.R(k0Var, 1, pVar);
            return;
        }
        l0.b bVar = this.M;
        bVar.b();
        l0.k0 k0Var2 = bVar.f7659b.f7656c;
        k0Var2.T(l0.f0.f7678c);
        pVar.getClass();
        yb.x.c(2, pVar);
        id.k.S(k0Var2, 0, obj, 1, pVar);
    }

    public final void b0() {
        T(null, 125, 2, null);
        this.f7049r = true;
    }

    public final boolean c(float f5) {
        Object objE = E();
        if ((objE instanceof Float) && f5 == ((Number) objE).floatValue()) {
            return false;
        }
        j0(Float.valueOf(f5));
        return true;
    }

    public final void c0() {
        this.f7044m = 0;
        this.G = this.f7035c.c();
        T(null, 100, 0, null);
        v vVar = this.f7034b;
        vVar.o();
        s0.g gVarH = vVar.h();
        this.f7055x.c(this.f7054w ? 1 : 0);
        this.f7054w = f(gVarH);
        this.K = null;
        if (!this.f7048q) {
            this.f7048q = vVar.d();
        }
        if (!this.C) {
            this.C = vVar.e();
        }
        if (this.C) {
            s2 s2Var = v0.c.f14319a;
            s2Var.getClass();
            gVarH = gVarH.b(s2Var, new t2(A()));
        }
        this.f7052u = gVarH;
        Set set = (Set) z.x(gVarH, v0.e.f14321a);
        if (set != null) {
            x xVar = this.U;
            if (xVar == null) {
                y yVar = this.f7040h;
                xVar = new x();
                xVar.f7106a = yVar;
                VarHandle.storeStoreFence();
                this.U = xVar;
            }
            set.add(xVar);
            vVar.l(set);
        }
        T(null, Long.hashCode(vVar.f()), 0, null);
    }

    public final boolean d(int i) {
        Object objE = E();
        if ((objE instanceof Integer) && i == ((Number) objE).intValue()) {
            return false;
        }
        j0(Integer.valueOf(i));
        return true;
    }

    public final boolean d0(v1 v1Var, Object obj) {
        b bVar = v1Var.f7090c;
        if (bVar == null) {
            return false;
        }
        int iA = this.G.f6882a.a(bVar);
        if (!this.F || iA < this.G.f6888g) {
            return false;
        }
        ArrayList arrayList = this.f7050s;
        int iE = t.e(iA, arrayList);
        if (iE < 0) {
            int i = -(iE + 1);
            if (!(obj instanceof i0)) {
                obj = null;
            }
            arrayList.add(i, new s0(v1Var, iA, obj));
            return true;
        }
        s0 s0Var = (s0) arrayList.get(iE);
        if (!(obj instanceof i0)) {
            s0Var.f7060c = null;
            return true;
        }
        Object obj2 = s0Var.f7060c;
        if (obj2 == null) {
            s0Var.f7060c = obj;
            return true;
        }
        if (obj2 instanceof p.g0) {
            ((p.g0) obj2).a(obj);
            return true;
        }
        int i3 = p.o0.f9601a;
        p.g0 g0Var = new p.g0(2);
        g0Var.i(obj2);
        g0Var.i(obj);
        s0Var.f7060c = g0Var;
        return true;
    }

    public final boolean e(long j10) {
        Object objE = E();
        if ((objE instanceof Long) && j10 == ((Number) objE).longValue()) {
            return false;
        }
        j0(Long.valueOf(j10));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(p.f0 r15) {
        /*
            r14 = this;
            java.util.ArrayList r14 = r14.f7050s
            int r0 = ac.a.x(r14)
        L6:
            r1 = -1
            if (r1 >= r0) goto L2a
            java.lang.Object r1 = r14.get(r0)
            k0.s0 r1 = (k0.s0) r1
            k0.v1 r2 = r1.f7058a
            k0.b r2 = r2.f7090c
            if (r2 == 0) goto L24
            boolean r3 = r2.a()
            if (r3 == 0) goto L24
            int r3 = r1.f7059b
            int r2 = r2.f6864a
            if (r3 == r2) goto L27
            r1.f7059b = r2
            goto L27
        L24:
            r14.remove(r0)
        L27:
            int r0 = r0 + (-1)
            goto L6
        L2a:
            java.lang.Object[] r0 = r15.f9553b
            java.lang.Object[] r1 = r15.f9554c
            long[] r15 = r15.f9552a
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L86
            r3 = 0
            r4 = r3
        L37:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L81
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L51:
            if (r9 >= r7) goto L7f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L7b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r10 = r1[r10]
            r11.getClass()
            k0.v1 r11 = (k0.v1) r11
            k0.b r12 = r11.f7090c
            if (r12 == 0) goto L7b
            int r12 = r12.f6864a
            k0.y0 r13 = k0.y0.i
            if (r10 != r13) goto L73
            r10 = 0
        L73:
            k0.s0 r13 = new k0.s0
            r13.<init>(r11, r12, r10)
            r14.add(r13)
        L7b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L51
        L7f:
            if (r7 != r8) goto L86
        L81:
            if (r4 == r2) goto L86
            int r4 = r4 + 1
            goto L37
        L86:
            e2.d r15 = k0.t.f7067f
            kb.p.o0(r15, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.e0(p.f0):void");
    }

    public final boolean f(Object obj) {
        if (yb.k.a(E(), obj)) {
            return false;
        }
        j0(obj);
        return true;
    }

    public final void f0(int i, int i3) {
        if (k0(i) != i3) {
            if (i < 0) {
                p.s sVar = this.f7047p;
                if (sVar == null) {
                    sVar = new p.s();
                    this.f7047p = sVar;
                }
                sVar.f(i, i3);
                return;
            }
            int[] iArr = this.f7046o;
            if (iArr == null) {
                int i10 = this.G.f6884c;
                int[] iArr2 = new int[i10];
                Arrays.fill(iArr2, 0, i10, -1);
                this.f7046o = iArr2;
                iArr = iArr2;
            }
            iArr[i] = i3;
        }
    }

    public final boolean g(boolean z10) {
        Object objE = E();
        if ((objE instanceof Boolean) && z10 == ((Boolean) objE).booleanValue()) {
            return false;
        }
        j0(Boolean.valueOf(z10));
        return true;
    }

    public final void g0(int i, int i3) {
        ArrayList arrayList = this.i;
        int iK0 = k0(i);
        if (iK0 != i3) {
            int i10 = i3 - iK0;
            int size = arrayList.size() - 1;
            while (i != -1) {
                int iK02 = k0(i) + i10;
                f0(i, iK02);
                int i11 = size;
                while (true) {
                    if (-1 < i11) {
                        p1 p1Var = (p1) arrayList.get(i11);
                        if (p1Var != null && p1Var.a(i, iK02)) {
                            size = i11 - 1;
                            break;
                        }
                        i11--;
                    } else {
                        break;
                    }
                }
                e2 e2Var = this.G;
                if (i < 0) {
                    i = e2Var.i;
                } else if (e2Var.l(i)) {
                    return;
                } else {
                    i = this.G.q(i);
                }
            }
        }
    }

    public final boolean h(Object obj) {
        if (E() == obj) {
            return false;
        }
        j0(obj);
        return true;
    }

    public final s0.g h0(s0.g gVar, s0.g gVar2) {
        gVar.getClass();
        s0.f fVar = new s0.f(gVar);
        fVar.putAll(gVar2);
        s0.g gVarA = fVar.a();
        V(204, t.f7065d);
        E();
        j0(gVarA);
        E();
        j0(gVar2);
        q(false);
        return gVarA;
    }

    public final void i() {
        this.f7041j = null;
        this.f7042k = 0;
        this.f7043l = 0;
        this.T = 0L;
        this.f7049r = false;
        l0.b bVar = this.M;
        bVar.f7660c = false;
        bVar.f7661d.f7030b = 0;
        bVar.f7663f = 0;
        bVar.f7662e = true;
        bVar.f7664g = 0;
        bVar.f7665h.clear();
        bVar.i = -1;
        bVar.f7666j = -1;
        bVar.f7667k = -1;
        bVar.f7668l = 0;
        this.E.clear();
        this.f7046o = null;
        this.f7047p = null;
    }

    public final void i0(Object obj) {
        int i;
        e2 e2Var;
        int i3;
        i2 i2Var;
        if (obj instanceof a2) {
            a2 a2Var = (a2) obj;
            b bVarA = null;
            if (this.S) {
                i2 i2Var2 = this.I;
                int i10 = i2Var2.f6956t;
                if (i10 > i2Var2.f6958v + 1) {
                    int i11 = i10 - 1;
                    int iD = i2Var2.D(i2Var2.f6939b, i11);
                    while (true) {
                        i3 = i11;
                        i11 = iD;
                        i2Var = this.I;
                        if (i11 == i2Var.f6958v || i11 < 0) {
                            break;
                        } else {
                            iD = i2Var.D(i2Var.f6939b, i11);
                        }
                    }
                    bVarA = i2Var.b(i3);
                }
            } else {
                e2 e2Var2 = this.G;
                int i12 = e2Var2.f6888g;
                if (i12 > e2Var2.i + 1) {
                    int i13 = i12 - 1;
                    int iQ = e2Var2.q(i13);
                    while (true) {
                        i = i13;
                        i13 = iQ;
                        e2Var = this.G;
                        if (i13 == e2Var.i || i13 < 0) {
                            break;
                        } else {
                            iQ = e2Var.q(i13);
                        }
                    }
                    bVarA = e2Var.a(i);
                }
            }
            b2 b2Var = new b2(a2Var, bVarA);
            if (this.S) {
                l0.k0 k0Var = this.M.f7659b.f7656c;
                k0Var.T(l0.w.f7709c);
                id.k.R(k0Var, 0, b2Var);
            }
            this.f7036d.add(obj);
            obj = b2Var;
        }
        j0(obj);
    }

    public final Object j(s1 s1Var) {
        return z.x(l(), s1Var);
    }

    public final void j0(Object obj) {
        l0.b bVar = this.M;
        if (this.S) {
            i2 i2Var = this.I;
            if (i2Var.f6950n <= 0 || i2Var.i == i2Var.f6947k) {
                i2Var.E(obj);
                return;
            }
            p.u uVar = i2Var.f6955s;
            if (uVar == null) {
                uVar = new p.u();
            }
            i2Var.f6955s = uVar;
            int i = i2Var.f6958v;
            Object objB = uVar.b(i);
            if (objB == null) {
                objB = new p.a0();
                uVar.h(i, objB);
            }
            ((p.a0) objB).a(obj);
            return;
        }
        e2 e2Var = this.G;
        if (!e2Var.f6894n) {
            b bVarA = e2Var.a(e2Var.i);
            l0.k0 k0Var = bVar.f7659b.f7656c;
            k0Var.T(l0.e.f7675c);
            id.k.S(k0Var, 0, bVarA, 1, obj);
            return;
        }
        int iC = (e2Var.f6892l - h2.c(e2Var.f6883b, e2Var.i)) - 1;
        if (bVar.f7658a.G.i - bVar.f7663f >= 0) {
            bVar.d(true);
            l0.k0 k0Var2 = bVar.f7659b.f7656c;
            k0Var2.T(l0.r.f7703g);
            id.k.R(k0Var2, 0, obj);
            k0Var2.f7690e[k0Var2.f7691f - k0Var2.f7688c[k0Var2.f7689d - 1].f7684a] = iC;
            return;
        }
        e2 e2Var2 = this.G;
        b bVarA2 = e2Var2.a(e2Var2.i);
        l0.k0 k0Var3 = bVar.f7659b.f7656c;
        k0Var3.T(l0.r.f7702f);
        id.k.S(k0Var3, 0, obj, 1, bVarA2);
        k0Var3.f7690e[k0Var3.f7691f - k0Var3.f7688c[k0Var3.f7689d - 1].f7684a] = iC;
    }

    public final void k(xb.a aVar) {
        if (!this.f7049r) {
            t.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f7049r = false;
        if (!this.S) {
            t.c("createNode() can only be called when inserting");
        }
        r0 r0Var = this.f7045n;
        int i = r0Var.f7029a[r0Var.f7030b - 1];
        i2 i2Var = this.I;
        b bVarB = i2Var.b(i2Var.f6958v);
        this.f7043l++;
        l0.c cVar = this.O;
        l0.k0 k0Var = cVar.f7670c;
        k0Var.T(l0.r.f7700d);
        id.k.R(k0Var, 0, aVar);
        k0Var.f7690e[k0Var.f7691f - k0Var.f7688c[k0Var.f7689d - 1].f7684a] = i;
        id.k.R(k0Var, 1, bVarB);
        l0.k0 k0Var2 = cVar.f7671d;
        k0Var2.T(l0.r.f7701e);
        k0Var2.f7690e[k0Var2.f7691f - k0Var2.f7688c[k0Var2.f7689d - 1].f7684a] = i;
        id.k.R(k0Var2, 0, bVarB);
    }

    public final int k0(int i) {
        int i3;
        if (i >= 0) {
            int[] iArr = this.f7046o;
            return (iArr == null || (i3 = iArr[i]) < 0) ? this.G.o(i) : i3;
        }
        p.s sVar = this.f7047p;
        if (sVar == null || sVar.c(i) < 0) {
            return 0;
        }
        int iC = sVar.c(i);
        if (iC >= 0) {
            return sVar.f9625c[iC];
        }
        g5.f.m(a.j(i, "Cannot find value for key "));
        return 0;
    }

    public final s0.g l() {
        s0.g gVar;
        s0.g gVar2 = this.K;
        if (gVar2 != null) {
            return gVar2;
        }
        int iQ = this.G.i;
        boolean z10 = this.S;
        e1 e1Var = t.f7064c;
        if (z10 && this.J) {
            int iD = this.I.f6958v;
            while (iD > 0) {
                i2 i2Var = this.I;
                if (i2Var.f6939b[i2Var.r(iD) * 5] == 202 && yb.k.a(this.I.s(iD), e1Var)) {
                    Object objQ = this.I.q(iD);
                    objQ.getClass();
                    s0.g gVar3 = (s0.g) objQ;
                    this.K = gVar3;
                    return gVar3;
                }
                i2 i2Var2 = this.I;
                iD = i2Var2.D(i2Var2.f6939b, iD);
            }
        }
        if (this.G.f6884c > 0) {
            while (iQ > 0) {
                if (this.G.i(iQ) == 202) {
                    e2 e2Var = this.G;
                    if (yb.k.a(e2Var.p(e2Var.f6883b, iQ), e1Var)) {
                        p.u uVar = this.f7053v;
                        if (uVar == null || (gVar = (s0.g) uVar.b(iQ)) == null) {
                            e2 e2Var2 = this.G;
                            Object objB = e2Var2.b(e2Var2.f6883b, iQ);
                            objB.getClass();
                            gVar = (s0.g) objB;
                        }
                        this.K = gVar;
                        return gVar;
                    }
                }
                iQ = this.G.q(iQ);
            }
        }
        s0.g gVar4 = this.f7052u;
        this.K = gVar4;
        return gVar4;
    }

    public final void l0() {
        l0.b bVar = this.M;
        if (!this.f7049r) {
            t.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f7049r = false;
        if (this.S) {
            t.c("useNode() called while inserting");
        }
        e2 e2Var = this.G;
        Object objN = e2Var.n(e2Var.i);
        bVar.c();
        bVar.f7665h.add(objN);
        if (this.f7056y && (objN instanceof k)) {
            bVar.b();
            bVar.f7659b.f7656c.T(l0.h0.f7682c);
        }
    }

    public final List m() {
        boolean z10 = this.C;
        List list = kb.s.f7404c;
        if (!z10) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        i2 i2Var = this.I;
        arrayList.addAll(t2.a.c(i2Var, null, i2Var.f6956t, null));
        e2 e2Var = this.G;
        if (!e2Var.f6887f && e2Var.f6884c != 0) {
            v0.h hVar = new v0.h(e2Var);
            int iQ = e2Var.i;
            Object objValueOf = Integer.valueOf(e2Var.f6892l - h2.c(e2Var.f6883b, iQ));
            while (iQ >= 0) {
                hVar.d(e2Var.f6882a.f(iQ), objValueOf);
                objValueOf = e2Var.a(iQ);
                iQ = e2Var.q(iQ);
            }
            list = (ArrayList) hVar.f13336a;
        }
        arrayList.addAll(list);
        arrayList.addAll(F());
        return arrayList;
    }

    public final void n(boolean z10) {
        if (this.f7043l != 0) {
            t.c("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (this.S) {
            return;
        }
        if (!z10) {
            R();
            return;
        }
        e2 e2Var = this.G;
        int i = e2Var.f6888g;
        int i3 = e2Var.f6889h;
        l0.b bVar = this.M;
        bVar.getClass();
        bVar.d(false);
        bVar.f7659b.f7656c.T(l0.i.f7683c);
        t.a(this.f7050s, i, i3);
        this.G.t();
    }

    public final void o(p.f0 f0Var, xb.p pVar) {
        ArrayList arrayList = this.f7050s;
        if (this.F) {
            t.c("Reentrant composition is not supported");
        }
        this.f7039g.x();
        Trace.beginSection("Compose:recompose");
        try {
            this.B = Long.hashCode(u0.m.k().g());
            this.f7053v = null;
            e0(f0Var);
            this.f7042k = 0;
            this.F = true;
            try {
                c0();
                Object objE = E();
                if (objE != pVar && pVar != null) {
                    j0(pVar);
                }
                q qVar = this.D;
                m0.e eVarP = z.p();
                try {
                    eVarP.b(qVar);
                    e1 e1Var = t.f7062a;
                    if (pVar != null) {
                        V(200, e1Var);
                        s0.h.c(this, pVar);
                        q(false);
                    } else if (!this.f7054w || objE == null || objE.equals(m.f6974a)) {
                        Q();
                    } else {
                        V(200, e1Var);
                        yb.x.c(2, objE);
                        s0.h.c(this, (xb.p) objE);
                        q(false);
                    }
                    eVarP.k(eVarP.f8160g - 1);
                    v();
                    this.F = false;
                    arrayList.clear();
                    if (!this.I.f6959w) {
                        t.c("Check failed");
                    }
                    x();
                } catch (Throwable th) {
                    eVarP.k(eVarP.f8160g - 1);
                    throw th;
                }
            } finally {
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void p(int i, int i3) {
        if (i <= 0 || i == i3) {
            return;
        }
        p(this.G.q(i), i3);
        if (this.G.l(i)) {
            l0.b bVar = this.M;
            Object objN = this.G.n(i);
            bVar.c();
            bVar.f7665h.add(objN);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04e8  */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(boolean r43) {
        /*
            Method dump skipped, instructions count: 1566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.q(boolean):void");
    }

    public final void r() {
        q(false);
        v1 v1VarY = y();
        if (v1VarY != null) {
            int i = v1VarY.f7089b;
            if ((i & 1) != 0) {
                v1VarY.f7089b = i | 2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[EDGE_INSN: B:58:0x008e->B:28:0x008e BREAK  A[LOOP:0: B:15:0x0040->B:27:0x008a], EDGE_INSN: B:59:0x008e->B:28:0x008e BREAK  A[LOOP:0: B:15:0x0040->B:27:0x008a]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k0.v1 s() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.s.s():k0.v1");
    }

    public final void t() {
        if (this.f7056y && this.G.i == this.f7057z) {
            this.f7057z = -1;
            this.f7056y = false;
        }
        q(false);
    }

    public final void u() {
        if (this.F || this.f7057z != 100) {
            q1.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.f7057z = -1;
        this.f7056y = false;
    }

    public final void v() {
        q(false);
        this.f7034b.b();
        q(false);
        l0.b bVar = this.M;
        if (bVar.f7660c) {
            bVar.d(false);
            bVar.d(false);
            bVar.f7659b.f7656c.T(l0.m.f7695c);
            bVar.f7660c = false;
        }
        bVar.b();
        if (bVar.f7661d.f7030b != 0) {
            t.c("Missed recording an endGroup()");
        }
        if (!this.i.isEmpty()) {
            t.c("Start/end imbalance");
        }
        i();
        this.G.c();
        this.f7054w = this.f7055x.b() != 0;
    }

    public final void w(boolean z10, p1 p1Var) {
        this.i.add(this.f7041j);
        this.f7041j = p1Var;
        r0 r0Var = this.f7045n;
        r0Var.c(this.f7043l);
        r0Var.c(this.f7044m);
        r0Var.c(this.f7042k);
        if (z10) {
            this.f7042k = 0;
        }
        this.f7043l = 0;
        this.f7044m = 0;
    }

    public final void x() {
        f2 f2Var = new f2();
        if (this.C) {
            f2Var.b();
        }
        if (this.f7034b.c()) {
            f2Var.f6909o = new p.u();
        }
        this.H = f2Var;
        i2 i2VarD = f2Var.d();
        i2VarD.e(true);
        this.I = i2VarD;
    }

    public final v1 y() {
        ArrayList arrayList = this.E;
        if (this.A != 0 || arrayList.isEmpty()) {
            return null;
        }
        return (v1) arrayList.get(arrayList.size() - 1);
    }

    public final boolean z() {
        if (!B() || this.f7054w) {
            return true;
        }
        v1 v1VarY = y();
        return (v1VarY == null || (v1VarY.f7089b & 4) == 0) ? false : true;
    }
}
