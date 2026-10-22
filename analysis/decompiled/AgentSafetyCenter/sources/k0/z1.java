package k0;

import android.util.Log;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z1 extends v {

    /* renamed from: x, reason: collision with root package name */
    public static final nc.t0 f7153x = nc.k0.a(q0.b.i);

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicReference f7154y = new AtomicReference(Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    public g f7155a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7156b;

    /* renamed from: c, reason: collision with root package name */
    public kc.x0 f7157c;

    /* renamed from: d, reason: collision with root package name */
    public Throwable f7158d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f7159e;

    /* renamed from: f, reason: collision with root package name */
    public Object f7160f;

    /* renamed from: g, reason: collision with root package name */
    public p.g0 f7161g;

    /* renamed from: h, reason: collision with root package name */
    public m0.e f7162h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f7163j;

    /* renamed from: k, reason: collision with root package name */
    public p.f0 f7164k;

    /* renamed from: l, reason: collision with root package name */
    public p5.c f7165l;

    /* renamed from: m, reason: collision with root package name */
    public p.f0 f7166m;

    /* renamed from: n, reason: collision with root package name */
    public p.f0 f7167n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f7168o;

    /* renamed from: p, reason: collision with root package name */
    public LinkedHashSet f7169p;

    /* renamed from: q, reason: collision with root package name */
    public kc.g f7170q;

    /* renamed from: r, reason: collision with root package name */
    public a1.g f7171r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7172s;

    /* renamed from: t, reason: collision with root package name */
    public nc.t0 f7173t;

    /* renamed from: u, reason: collision with root package name */
    public kc.z0 f7174u;

    /* renamed from: v, reason: collision with root package name */
    public nb.g f7175v;

    /* renamed from: w, reason: collision with root package name */
    public y0 f7176w;

    public static void r(u0.b bVar) {
        try {
            if (bVar.w() instanceof u0.g) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            bVar.c();
        }
    }

    public static final void x(ArrayList arrayList, z1 z1Var, y yVar) {
        arrayList.clear();
        synchronized (z1Var.f7156b) {
            Iterator it = z1Var.f7163j.iterator();
            if (it.hasNext()) {
                ((b1) it.next()).getClass();
                throw null;
            }
        }
    }

    public final void A(Throwable th, y yVar) throws Throwable {
        if (!((Boolean) f7154y.get()).booleanValue() || (th instanceof l)) {
            synchronized (this.f7156b) {
                a1.g gVar = this.f7171r;
                if (gVar != null) {
                    throw ((Throwable) gVar.f19f);
                }
                this.f7171r = new a1.g(th, 17);
            }
            throw th;
        }
        synchronized (this.f7156b) {
            try {
                Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", th);
                this.i.clear();
                this.f7162h.g();
                this.f7161g = new p.g0();
                this.f7163j.clear();
                this.f7164k.a();
                this.f7166m.a();
                this.f7171r = new a1.g(th, 17);
                if (yVar != null) {
                    C(yVar);
                }
                t();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean B() {
        synchronized (this.f7156b) {
            boolean z10 = true;
            if (this.f7161g.g()) {
                if (this.f7162h.f8160g == 0 && !u() && !this.f7164k.j()) {
                    z10 = false;
                }
                return z10;
            }
            List listW = w();
            m0.h hVarK = com.stepos.statsrpk.h.K(this.f7161g);
            this.f7161g = new p.g0();
            try {
                int size = listW.size();
                for (int i = 0; i < size; i++) {
                    ((y) listW.get(i)).x(hVarK);
                    if (((w1) this.f7173t.getValue()).compareTo(w1.f7101f) <= 0) {
                        break;
                    }
                }
                synchronized (this.f7156b) {
                    if (t() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    if (this.f7162h.f8160g == 0 && !u() && !this.f7164k.j()) {
                        z10 = false;
                    }
                }
                return z10;
            } catch (Throwable th) {
                synchronized (this.f7156b) {
                    p.g0 g0Var = this.f7161g;
                    g0Var.getClass();
                    Iterator<E> it = hVarK.iterator();
                    while (it.hasNext()) {
                        g0Var.i(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public final void C(y yVar) {
        ArrayList arrayList = this.f7168o;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f7168o = arrayList;
        }
        if (!arrayList.contains(yVar)) {
            arrayList.add(yVar);
        }
        if (this.f7159e.remove(yVar)) {
            this.f7160f = null;
        }
    }

    @Override // k0.v
    public final void a(y yVar, xb.p pVar) throws Throwable {
        boolean z10;
        u0.b bVarC;
        boolean z11 = yVar.f7134x.F;
        synchronized (this.f7156b) {
            if (((w1) this.f7173t.getValue()).compareTo(w1.f7101f) > 0) {
                boolean zContains = w().contains(yVar);
                z10 = !zContains;
                if (!zContains) {
                    this.f7159e.add(yVar);
                    this.f7160f = null;
                }
            } else {
                z10 = true;
            }
        }
        try {
            a9.e eVar = new a9.e(8);
            eVar.f257f = yVar;
            VarHandle.storeStoreFence();
            aa.g gVar = new aa.g(5);
            gVar.f319f = yVar;
            gVar.f320g = null;
            VarHandle.storeStoreFence();
            u0.f fVarK = u0.m.k();
            u0.b bVar = fVarK instanceof u0.b ? (u0.b) fVarK : null;
            if (bVar == null || (bVarC = bVar.C(eVar, gVar)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                u0.f fVarJ = bVarC.j();
                try {
                    yVar.j(pVar);
                    if (!z11) {
                        u0.m.k().m();
                    }
                    try {
                        synchronized (this.f7156b) {
                            ArrayList arrayList = this.f7163j;
                            if (arrayList.size() > 0) {
                                ((b1) arrayList.get(0)).getClass();
                                throw null;
                            }
                        }
                        try {
                            yVar.d();
                            yVar.f();
                            if (z11) {
                                return;
                            }
                            u0.m.k().m();
                        } catch (Throwable th) {
                            A(th, null);
                        }
                    } catch (Throwable th2) {
                        A(th2, yVar);
                    }
                } finally {
                    u0.f.q(fVarJ);
                }
            } finally {
                r(bVarC);
            }
        } catch (Throwable th3) {
            A(th3, yVar);
            if (z10) {
                synchronized (this.f7156b) {
                    if (this.f7159e.remove(yVar)) {
                        this.f7160f = null;
                    }
                }
            }
        }
    }

    @Override // k0.v
    public final boolean c() {
        return ((Boolean) f7154y.get()).booleanValue();
    }

    @Override // k0.v
    public final boolean d() {
        return false;
    }

    @Override // k0.v
    public final boolean e() {
        return false;
    }

    @Override // k0.v
    public final long f() {
        return 1000;
    }

    @Override // k0.v
    public final u g() {
        return null;
    }

    @Override // k0.v
    public final nb.g i() {
        return this.f7175v;
    }

    @Override // k0.v
    public final void j(y yVar) {
        kc.f fVarT;
        synchronized (this.f7156b) {
            if (this.f7162h.h(yVar)) {
                fVarT = null;
            } else {
                this.f7162h.b(yVar);
                fVarT = t();
            }
        }
        if (fVarT != null) {
            ((kc.g) fVarT).resumeWith(jb.v.f6774a);
        }
    }

    @Override // k0.v
    public final a1 k(b1 b1Var) {
        a1 a1Var;
        synchronized (this.f7156b) {
            a1Var = (a1) this.f7166m.k(b1Var);
        }
        return a1Var;
    }

    @Override // k0.v
    public final void n(y yVar) {
        synchronized (this.f7156b) {
            try {
                LinkedHashSet linkedHashSet = this.f7169p;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.f7169p = linkedHashSet;
                }
                linkedHashSet.add(yVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k0.v
    public final void q(y yVar) {
        synchronized (this.f7156b) {
            if (this.f7159e.remove(yVar)) {
                this.f7160f = null;
            }
            this.f7162h.j(yVar);
            this.i.remove(yVar);
        }
    }

    public final void s() {
        synchronized (this.f7156b) {
            if (((w1) this.f7173t.getValue()).compareTo(w1.i) >= 0) {
                nc.t0 t0Var = this.f7173t;
                w1 w1Var = w1.f7101f;
                t0Var.getClass();
                t0Var.g(null, w1Var);
            }
        }
        this.f7174u.e(null);
    }

    public final kc.f t() {
        w1 w1Var;
        ArrayList arrayList = this.f7163j;
        ArrayList arrayList2 = this.i;
        m0.e eVar = this.f7162h;
        nc.t0 t0Var = this.f7173t;
        if (((w1) t0Var.getValue()).compareTo(w1.f7101f) > 0) {
            if (this.f7171r != null) {
                w1Var = w1.f7102g;
            } else if (this.f7157c == null) {
                this.f7161g = new p.g0();
                eVar.g();
                w1Var = u() ? w1.f7103h : w1.f7102g;
            } else {
                w1Var = (eVar.f8160g == 0 && !this.f7161g.h() && arrayList2.isEmpty() && arrayList.isEmpty() && !u() && !this.f7164k.j()) ? w1.i : w1.f7104j;
            }
            t0Var.g(null, w1Var);
            if (w1Var != w1.f7104j) {
                return null;
            }
            kc.g gVar = this.f7170q;
            this.f7170q = null;
            return gVar;
        }
        for (y yVar : w()) {
        }
        this.f7159e.clear();
        this.f7160f = kb.s.f7404c;
        this.f7161g = new p.g0();
        eVar.g();
        arrayList2.clear();
        arrayList.clear();
        this.f7168o = null;
        kc.g gVar2 = this.f7170q;
        if (gVar2 != null) {
            gVar2.f(null);
        }
        this.f7170q = null;
        this.f7171r = null;
        return null;
    }

    public final boolean u() {
        return !this.f7172s && (this.f7155a.f6913h.get() & 134217727) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f7156b
            monitor-enter(r0)
            p.g0 r1 = r2.f7161g     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r1.h()     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            m0.e r1 = r2.f7162h     // Catch: java.lang.Throwable -> L1b
            int r1 = r1.f8160g     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L12
            goto L1d
        L12:
            boolean r2 = r2.u()     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L19
            goto L1d
        L19:
            r2 = 0
            goto L1e
        L1b:
            r2 = move-exception
            goto L20
        L1d:
            r2 = 1
        L1e:
            monitor-exit(r0)
            return r2
        L20:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.z1.v():boolean");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    public final List w() {
        ?? r02 = this.f7160f;
        if (r02 != 0) {
            return r02;
        }
        ArrayList arrayList = this.f7159e;
        List arrayList2 = arrayList.isEmpty() ? kb.s.f7404c : new ArrayList(arrayList);
        this.f7160f = arrayList2;
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0147, code lost:
    
        r3 = r11.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014c, code lost:
    
        if (r4 >= r3) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0156, code lost:
    
        if (((jb.g) r11.get(r4)).f6760f == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0158, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015b, code lost:
    
        r3 = new java.util.ArrayList(r11.size());
        r4 = r11.size();
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0169, code lost:
    
        if (r10 >= r4) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x016b, code lost:
    
        r12 = (jb.g) r11.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
    
        if (r12.f6760f != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        r12 = (k0.b1) r12.f6759c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017c, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x017f, code lost:
    
        r4 = r18.f7156b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0181, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0182, code lost:
    
        kb.q.p0(r3, r18.f7163j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0187, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0188, code lost:
    
        r3 = new java.util.ArrayList(r11.size());
        r4 = r11.size();
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0196, code lost:
    
        if (r10 >= r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0198, code lost:
    
        r12 = r11.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a1, code lost:
    
        if (((jb.g) r12).f6760f == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a3, code lost:
    
        r3.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a6, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a9, code lost:
    
        r11 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List y(java.util.List r19, p.g0 r20) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.z1.y(java.util.List, p.g0):java.util.List");
    }

    public final y z(y yVar, p.g0 g0Var) {
        u0.b bVarC;
        if (yVar.f7134x.F || yVar.f7135y == 3) {
            return null;
        }
        LinkedHashSet linkedHashSet = this.f7169p;
        if (linkedHashSet == null || !linkedHashSet.contains(yVar)) {
            a9.e eVar = new a9.e(8);
            eVar.f257f = yVar;
            VarHandle.storeStoreFence();
            aa.g gVar = new aa.g(5);
            gVar.f319f = yVar;
            gVar.f320g = g0Var;
            VarHandle.storeStoreFence();
            u0.f fVarK = u0.m.k();
            u0.b bVar = fVarK instanceof u0.b ? (u0.b) fVarK : null;
            if (bVar == null || (bVarC = bVar.C(eVar, gVar)) == null) {
                od.f.e("Cannot create a mutable snapshot of an read-only snapshot");
            } else {
                try {
                    u0.f fVarJ = bVarC.j();
                    if (g0Var != null) {
                        try {
                            if (g0Var.h()) {
                                e9.j jVar = new e9.j(4);
                                jVar.f3666f = g0Var;
                                jVar.f3667g = yVar;
                                VarHandle.storeStoreFence();
                                s sVar = yVar.f7134x;
                                if (sVar.F) {
                                    t.c("Preparing a composition while composing is not supported");
                                }
                                sVar.F = true;
                                try {
                                    jVar.invoke();
                                    sVar.F = false;
                                } catch (Throwable th) {
                                    sVar.F = false;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            u0.f.q(fVarJ);
                            throw th2;
                        }
                    }
                    boolean zW = yVar.w();
                    u0.f.q(fVarJ);
                    if (zW) {
                        return yVar;
                    }
                } finally {
                    r(bVarC);
                }
            }
        }
        return null;
    }

    @Override // k0.v
    public final void l(Set set) {
    }
}
