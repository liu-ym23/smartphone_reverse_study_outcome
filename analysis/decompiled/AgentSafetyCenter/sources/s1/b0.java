package s1;

import android.os.Handler;
import android.view.ViewGroup;
import java.lang.invoke.VarHandle;
import java.util.List;
import u1.l1;
import v1.h2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements k0.k {

    /* renamed from: c, reason: collision with root package name */
    public u1.g0 f11203c;

    /* renamed from: f, reason: collision with root package name */
    public k0.v f11204f;

    /* renamed from: g, reason: collision with root package name */
    public a1 f11205g;

    /* renamed from: h, reason: collision with root package name */
    public int f11206h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public p.f0 f11207j;

    /* renamed from: k, reason: collision with root package name */
    public p.f0 f11208k;

    /* renamed from: l, reason: collision with root package name */
    public w f11209l;

    /* renamed from: m, reason: collision with root package name */
    public t f11210m;

    /* renamed from: n, reason: collision with root package name */
    public p.f0 f11211n;

    /* renamed from: o, reason: collision with root package name */
    public p.r0 f11212o;

    /* renamed from: p, reason: collision with root package name */
    public p.f0 f11213p;

    /* renamed from: q, reason: collision with root package name */
    public m0.e f11214q;

    /* renamed from: r, reason: collision with root package name */
    public int f11215r;

    /* renamed from: s, reason: collision with root package name */
    public int f11216s;

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    @Override // k0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r17 = this;
            r0 = r17
            u1.g0 r1 = r0.f11203c
            r2 = 1
            r1.f13803t = r2
            p.f0 r2 = r0.f11207j
            java.lang.Object[] r3 = r2.f9554c
            long[] r4 = r2.f9552a
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L52
            r7 = r6
        L14:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4d
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L2e:
            if (r12 >= r10) goto L4b
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L47
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            s1.u r13 = (s1.u) r13
            k0.y r13 = r13.f11301c
            if (r13 == 0) goto L47
            r13.l()
        L47:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L2e
        L4b:
            if (r10 != r11) goto L52
        L4d:
            if (r7 == r5) goto L52
            int r7 = r7 + 1
            goto L14
        L52:
            r1.P()
            r1.f13803t = r6
            r2.a()
            p.f0 r1 = r0.f11208k
            r1.a()
            r0.f11216s = r6
            r0.f11215r = r6
            p.f0 r1 = r0.f11211n
            r1.a()
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.b0.a():void");
    }

    @Override // k0.k
    public final void b() {
        e(true);
    }

    public final void c(int i) {
        boolean z10;
        boolean z11 = false;
        this.f11215r = 0;
        List listN = this.f11203c.n();
        m0.b bVar = (m0.b) listN;
        int i3 = (bVar.f8152c.f8160g - this.f11216s) - 1;
        if (i <= i3) {
            this.f11212o.clear();
            if (i <= i3) {
                int i10 = i;
                while (true) {
                    Object objG = this.f11207j.g((u1.g0) bVar.get(i10));
                    objG.getClass();
                    ((p.c0) this.f11212o.f9622f).a(((u) objG).f11299a);
                    if (i10 == i3) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.f11205g.c(this.f11212o);
            u0.f fVarD = u0.r.d();
            xb.l lVarE = fVarD != null ? fVarD.e() : null;
            u0.f fVarG = u0.r.g(fVarD);
            z10 = false;
            while (i3 >= i) {
                try {
                    u1.g0 g0Var = (u1.g0) ((m0.b) listN).get(i3);
                    Object objG2 = this.f11207j.g(g0Var);
                    objG2.getClass();
                    u uVar = (u) objG2;
                    Object obj = uVar.f11299a;
                    if (((p.c0) this.f11212o.f9622f).c(obj)) {
                        this.f11215r++;
                        if (((Boolean) uVar.f11304f.getValue()).booleanValue()) {
                            u1.k0 k0Var = g0Var.I;
                            u1.x0 x0Var = k0Var.f13857p;
                            u1.e0 e0Var = u1.e0.f13767g;
                            x0Var.f13962p = e0Var;
                            u1.t0 t0Var = k0Var.f13858q;
                            if (t0Var != null) {
                                t0Var.f13925n = e0Var;
                            }
                            g(uVar, false);
                            if (uVar.f11305g) {
                                z10 = true;
                            }
                        }
                    } else {
                        u1.g0 g0Var2 = this.f11203c;
                        g0Var2.f13803t = true;
                        this.f11207j.k(g0Var);
                        k0.y yVar = uVar.f11301c;
                        if (yVar != null) {
                            yVar.l();
                        }
                        this.f11203c.Q(i3, 1);
                        g0Var2.f13803t = false;
                    }
                    this.f11208k.k(obj);
                    i3--;
                } catch (Throwable th) {
                    u0.r.j(fVarD, fVarG, lVarE);
                    throw th;
                }
            }
            u0.r.j(fVarD, fVarG, lVarE);
        } else {
            z10 = false;
        }
        if (z10) {
            synchronized (u0.m.f13676c) {
                p.g0 g0Var3 = u0.m.f13682j.f13641h;
                if (g0Var3 != null) {
                    if (g0Var3.h()) {
                        z11 = true;
                    }
                }
            }
            if (z11) {
                u0.m.a();
            }
        }
        d();
    }

    public final void d() {
        p.f0 f0Var = this.f11211n;
        int i = ((m0.b) this.f11203c.n()).f8152c.f8160g;
        p.f0 f0Var2 = this.f11207j;
        if (f0Var2.f9556e != i) {
            r1.a.a("Inconsistency between the count of nodes tracked by the state (" + f0Var2.f9556e + ") and the children count on the SubcomposeLayout (" + i + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if ((i - this.f11215r) - this.f11216s < 0) {
            StringBuilder sbT = k0.a.t(i, "Incorrect state. Total children ", ". Reusable children ");
            sbT.append(this.f11215r);
            sbT.append(". Precomposed children ");
            sbT.append(this.f11216s);
            r1.a.a(sbT.toString());
        }
        if (f0Var.f9556e == this.f11216s) {
            return;
        }
        r1.a.a("Incorrect state. Precomposed children " + this.f11216s + ". Map size " + f0Var.f9556e);
    }

    public final void e(boolean z10) {
        this.f11216s = 0;
        this.f11211n.a();
        List listN = this.f11203c.n();
        int i = ((m0.b) listN).f8152c.f8160g;
        if (this.f11215r != i) {
            this.f11215r = i;
            u0.f fVarD = u0.r.d();
            xb.l lVarE = fVarD != null ? fVarD.e() : null;
            u0.f fVarG = u0.r.g(fVarD);
            for (int i3 = 0; i3 < i; i3++) {
                try {
                    u1.g0 g0Var = (u1.g0) ((m0.b) listN).get(i3);
                    u uVar = (u) this.f11207j.g(g0Var);
                    if (uVar != null && ((Boolean) uVar.f11304f.getValue()).booleanValue()) {
                        u1.k0 k0Var = g0Var.I;
                        u1.x0 x0Var = k0Var.f13857p;
                        u1.e0 e0Var = u1.e0.f13767g;
                        x0Var.f13962p = e0Var;
                        u1.t0 t0Var = k0Var.f13858q;
                        if (t0Var != null) {
                            t0Var.f13925n = e0Var;
                        }
                        g(uVar, z10);
                        uVar.f11299a = v0.f11317a;
                    }
                } catch (Throwable th) {
                    u0.r.j(fVarD, fVarG, lVarE);
                    throw th;
                }
            }
            u0.r.j(fVarD, fVarG, lVarE);
            this.f11208k.a();
        }
        d();
    }

    public final w0 f(Object obj, xb.p pVar) {
        u1.g0 g0Var = this.f11203c;
        if (g0Var.G()) {
            d();
            if (!this.f11208k.c(obj)) {
                this.f11213p.k(obj);
                p.f0 f0Var = this.f11211n;
                Object objG = f0Var.g(obj);
                if (objG == null) {
                    objG = i(obj);
                    if (objG != null) {
                        int i = ((m0.b) g0Var.n()).f8152c.i(objG);
                        int i3 = ((m0.b) g0Var.n()).f8152c.f8160g;
                        g0Var.f13803t = true;
                        g0Var.K(i, i3, 1);
                        g0Var.f13803t = false;
                        this.f11216s++;
                    } else {
                        int i10 = ((m0.b) g0Var.n()).f8152c.f8160g;
                        u1.g0 g0Var2 = new u1.g0(2);
                        g0Var.f13803t = true;
                        g0Var.z(i10, g0Var2);
                        g0Var.f13803t = false;
                        this.f11216s++;
                        objG = g0Var2;
                    }
                    f0Var.m(obj, objG);
                }
                h((u1.g0) objG, obj, pVar);
            }
        }
        if (!g0Var.G()) {
            return new z();
        }
        a0 a0Var = new a0();
        a0Var.f11200b = this;
        a0Var.f11201c = obj;
        int[] iArr = p.l.f9589a;
        a0Var.f11199a = new p.v();
        VarHandle.storeStoreFence();
        return a0Var;
    }

    public final void g(u uVar, boolean z10) {
        k0.y yVar;
        if (z10 || !uVar.f11305g) {
            uVar.f11304f = k0.z.v(Boolean.FALSE);
        } else {
            uVar.f11304f.setValue(Boolean.FALSE);
        }
        uVar.getClass();
        if (z10) {
            k0.y yVar2 = uVar.f11301c;
            if (yVar2 != null) {
                yVar2.k();
                return;
            }
            return;
        }
        l1 outOfFrameExecutor = ((v1.t) u1.j0.a(this.f11203c)).getOutOfFrameExecutor();
        if (outOfFrameExecutor == null) {
            if (uVar.f11305g || (yVar = uVar.f11301c) == null) {
                return;
            }
            yVar.k();
            return;
        }
        ad.l lVar = new ad.l(uVar, 20);
        Handler handler = ((v1.t) outOfFrameExecutor).getHandler();
        if (handler == null) {
            g5.f.s("schedule is called when outOfFrameExecutor is not available (view is detached)");
            return;
        }
        a4.t tVar = new a4.t(24);
        tVar.f200f = lVar;
        VarHandle.storeStoreFence();
        handler.postAtFrontOfQueue(tVar);
    }

    public final void h(u1.g0 g0Var, Object obj, xb.p pVar) {
        boolean z10;
        p.f0 f0Var = this.f11207j;
        Object objG = f0Var.g(g0Var);
        Object obj2 = objG;
        if (objG == null) {
            s0.c cVar = h.f11252a;
            u uVar = new u();
            uVar.f11299a = obj;
            uVar.f11300b = cVar;
            uVar.f11301c = null;
            uVar.f11304f = k0.z.v(Boolean.TRUE);
            f0Var.m(g0Var, uVar);
            obj2 = uVar;
        }
        u uVar2 = (u) obj2;
        boolean z11 = uVar2.f11300b != pVar;
        k0.y yVar = uVar2.f11301c;
        if (yVar != null) {
            synchronized (yVar.f7119h) {
                z10 = yVar.f7128r.f9556e > 0;
            }
        } else {
            z10 = true;
        }
        if (z11 || z10 || uVar2.f11302d) {
            uVar2.f11300b = pVar;
            u0.f fVarD = u0.r.d();
            xb.l lVarE = fVarD != null ? fVarD.e() : null;
            u0.f fVarG = u0.r.g(fVarD);
            try {
                u1.g0 g0Var2 = this.f11203c;
                g0Var2.f13803t = true;
                k0.y yVar2 = uVar2.f11301c;
                k0.v vVar = this.f11204f;
                if (vVar == null) {
                    r1.a.c("parent composition reference not set");
                    throw new androidx.fragment.app.d();
                }
                if (yVar2 == null) {
                    ViewGroup.LayoutParams layoutParams = h2.f14473a;
                    yVar2 = new k0.y(vVar, new p5.m(g0Var));
                } else {
                    if (yVar2.f7135y == 3) {
                        ViewGroup.LayoutParams layoutParams2 = h2.f14473a;
                        yVar2 = new k0.y(vVar, new p5.m(g0Var));
                    }
                }
                uVar2.f11301c = yVar2;
                xb.p cVar2 = uVar2.f11300b;
                if (((v1.t) u1.j0.a(this.f11203c)).getOutOfFrameExecutor() != null) {
                    uVar2.f11305g = false;
                } else {
                    uVar2.f11305g = true;
                    cVar2 = new s0.c(1524156494, true, new h0.k(4, uVar2, cVar2));
                }
                if (uVar2.f11303e) {
                    yVar2.i();
                    yVar2.p();
                    k0.s sVar = yVar2.f7134x;
                    sVar.f7057z = 100;
                    sVar.f7056y = true;
                    yVar2.f7116c.a(yVar2, cVar2);
                    sVar.u();
                } else {
                    yVar2.A(cVar2);
                }
                uVar2.f11303e = false;
                g0Var2.f13803t = false;
                u0.r.j(fVarD, fVarG, lVarE);
                uVar2.f11302d = false;
            } catch (Throwable th) {
                u0.r.j(fVarD, fVarG, lVarE);
                throw th;
            }
        }
    }

    public final u1.g0 i(Object obj) {
        int i;
        u1.g0 g0Var = this.f11203c;
        p.f0 f0Var = this.f11207j;
        if (this.f11215r == 0) {
            return null;
        }
        m0.b bVar = (m0.b) g0Var.n();
        int i3 = bVar.f8152c.f8160g - this.f11216s;
        int i10 = i3 - this.f11215r;
        int i11 = i3 - 1;
        int i12 = i11;
        while (true) {
            if (i12 < i10) {
                i = -1;
                break;
            }
            Object objG = f0Var.g((u1.g0) bVar.get(i12));
            objG.getClass();
            if (((u) objG).f11299a.equals(obj)) {
                i = i12;
                break;
            }
            i12--;
        }
        if (i == -1) {
            while (i11 >= i10) {
                Object objG2 = f0Var.g((u1.g0) bVar.get(i11));
                objG2.getClass();
                u uVar = (u) objG2;
                Object obj2 = uVar.f11299a;
                if (obj2 == v0.f11317a || this.f11205g.b(obj, obj2)) {
                    uVar.f11299a = obj;
                    i12 = i11;
                    i = i12;
                    break;
                }
                i11--;
            }
            i12 = i11;
        }
        if (i == -1) {
            return null;
        }
        if (i12 != i10) {
            g0Var.f13803t = true;
            g0Var.K(i12, i10, 1);
            g0Var.f13803t = false;
        }
        this.f11215r--;
        u1.g0 g0Var2 = (u1.g0) bVar.get(i10);
        Object objG3 = f0Var.g(g0Var2);
        objG3.getClass();
        u uVar2 = (u) objG3;
        uVar2.f11304f = k0.z.v(Boolean.TRUE);
        uVar2.f11303e = true;
        uVar2.f11302d = true;
        return g0Var2;
    }
}
