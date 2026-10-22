package b0;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class j2 extends u {

    /* renamed from: x, reason: collision with root package name */
    public static final la.u0 f1204x = la.k0.c(h0.b.f4061i);

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicReference f1205y = new AtomicReference(Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    public final f f1206a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1207b;

    /* renamed from: c, reason: collision with root package name */
    public ia.g1 f1208c;

    /* renamed from: d, reason: collision with root package name */
    public Throwable f1209d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1210e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1211f;

    /* renamed from: g, reason: collision with root package name */
    public k.b0 f1212g;

    /* renamed from: h, reason: collision with root package name */
    public final d0.e f1213h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1214i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f1215j;

    /* renamed from: k, reason: collision with root package name */
    public final k.a0 f1216k;

    /* renamed from: l, reason: collision with root package name */
    public final q6.b f1217l;

    /* renamed from: m, reason: collision with root package name */
    public final k.a0 f1218m;

    /* renamed from: n, reason: collision with root package name */
    public final k.a0 f1219n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f1220o;

    /* renamed from: p, reason: collision with root package name */
    public LinkedHashSet f1221p;

    /* renamed from: q, reason: collision with root package name */
    public ia.m f1222q;

    /* renamed from: r, reason: collision with root package name */
    public a7.d f1223r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1224s;

    /* renamed from: t, reason: collision with root package name */
    public final la.u0 f1225t;

    /* renamed from: u, reason: collision with root package name */
    public final ia.i1 f1226u;

    /* renamed from: v, reason: collision with root package name */
    public final g7.l f1227v;

    /* renamed from: w, reason: collision with root package name */
    public final b1 f1228w;

    public j2(g7.l lVar) {
        f fVar = new f(new a2(0, this));
        this.f1206a = fVar;
        this.f1207b = new Object();
        this.f1210e = new ArrayList();
        this.f1212g = new k.b0();
        this.f1213h = new d0.e(new x[16]);
        this.f1214i = new ArrayList();
        this.f1215j = new ArrayList();
        this.f1216k = new k.a0();
        this.f1217l = new q6.b(3);
        this.f1218m = new k.a0();
        this.f1219n = new k.a0();
        this.f1225t = la.k0.c(d2.f1125h);
        new AtomicReference(j0.i.f5085b);
        ia.i1 i1Var = new ia.i1((ia.g1) lVar.o(ia.z.f5027g));
        i1Var.t(new a5.a(4, this));
        this.f1226u = i1Var;
        this.f1227v = lVar.Q(fVar).Q(i1Var);
        this.f1228w = new b1(9);
    }

    public static final x a(j2 j2Var, x xVar, k.b0 b0Var) {
        LinkedHashSet linkedHashSet;
        l0.b bVarC;
        if (!xVar.f1412y.E && xVar.f1413z != 3 && ((linkedHashSet = j2Var.f1221p) == null || !linkedHashSet.contains(xVar))) {
            a5.a aVar = new a5.a(3, xVar);
            b2 b2Var = new b2(0, xVar, b0Var);
            l0.f fVarK = l0.m.k();
            l0.b bVar = fVarK instanceof l0.b ? (l0.b) fVarK : null;
            if (bVar == null || (bVarC = bVar.C(aVar, b2Var)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                l0.f fVarJ = bVarC.j();
                if (b0Var != null) {
                    try {
                        if (b0Var.h()) {
                            c2 c2Var = new c2(0, b0Var, xVar);
                            p pVar = xVar.f1412y;
                            if (pVar.E) {
                                s.c("Preparing a composition while composing is not supported");
                            }
                            pVar.E = true;
                            try {
                                c2Var.c();
                                pVar.E = false;
                            } catch (Throwable th) {
                                pVar.E = false;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        l0.f.q(fVarJ);
                        throw th2;
                    }
                }
                boolean zS = xVar.s();
                l0.f.q(fVarJ);
                if (zS) {
                    return xVar;
                }
            } finally {
                c(bVarC);
            }
        }
        return null;
    }

    public static final boolean b(j2 j2Var) {
        synchronized (j2Var.f1207b) {
            boolean z4 = true;
            if (j2Var.f1212g.g()) {
                if (j2Var.f1213h.f2751h == 0 && !j2Var.f() && j2Var.f1216k.f5450e == 0) {
                    z4 = false;
                }
                return z4;
            }
            List listH = j2Var.h();
            d0.h hVar = new d0.h(j2Var.f1212g);
            j2Var.f1212g = new k.b0();
            try {
                int size = listH.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((x) listH.get(i2)).t(hVar);
                    if (((d2) j2Var.f1225t.getValue()).compareTo(d2.f1124g) <= 0) {
                        break;
                    }
                }
                synchronized (j2Var.f1207b) {
                    if (j2Var.e() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    if (j2Var.f1213h.f2751h == 0 && !j2Var.f() && j2Var.f1216k.f5450e == 0) {
                        z4 = false;
                    }
                }
                return z4;
            } catch (Throwable th) {
                synchronized (j2Var.f1207b) {
                    k.b0 b0Var = j2Var.f1212g;
                    b0Var.getClass();
                    Iterator<E> it = hVar.iterator();
                    while (it.hasNext()) {
                        b0Var.i(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public static void c(l0.b bVar) {
        try {
            if (bVar.w() instanceof l0.g) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            bVar.c();
        }
    }

    public static final void i(ArrayList arrayList, j2 j2Var, x xVar) {
        arrayList.clear();
        synchronized (j2Var.f1207b) {
            Iterator it = j2Var.f1215j.iterator();
            if (it.hasNext()) {
                ((e1) it.next()).getClass();
                throw null;
            }
        }
    }

    public final void d() {
        synchronized (this.f1207b) {
            if (((d2) this.f1225t.getValue()).compareTo(d2.f1127j) >= 0) {
                la.u0 u0Var = this.f1225t;
                d2 d2Var = d2.f1124g;
                u0Var.getClass();
                u0Var.g(null, d2Var);
            }
        }
        ia.f1.cancel$default((ia.g1) this.f1226u, (CancellationException) null, 1, (Object) null);
    }

    public final ia.k e() {
        d2 d2Var;
        la.u0 u0Var = this.f1225t;
        int iCompareTo = ((d2) u0Var.getValue()).compareTo(d2.f1124g);
        ArrayList arrayList = this.f1215j;
        ArrayList arrayList2 = this.f1214i;
        d0.e eVar = this.f1213h;
        if (iCompareTo > 0) {
            if (this.f1223r != null) {
                d2Var = d2.f1125h;
            } else if (this.f1208c == null) {
                this.f1212g = new k.b0();
                eVar.g();
                d2Var = f() ? d2.f1126i : d2.f1125h;
            } else {
                d2Var = (eVar.f2751h == 0 && !this.f1212g.h() && arrayList2.isEmpty() && arrayList.isEmpty() && !f() && this.f1216k.f5450e == 0) ? d2.f1127j : d2.f1128k;
            }
            u0Var.getClass();
            u0Var.g(null, d2Var);
            if (d2Var != d2.f1128k) {
                return null;
            }
            ia.m mVar = this.f1222q;
            this.f1222q = null;
            return mVar;
        }
        for (x xVar : h()) {
        }
        this.f1210e.clear();
        this.f1211f = d7.z.f2978f;
        this.f1212g = new k.b0();
        eVar.g();
        arrayList2.clear();
        arrayList.clear();
        this.f1220o = null;
        ia.m mVar2 = this.f1222q;
        if (mVar2 != null) {
            ia.j.cancel$default(mVar2, null, 1, null);
        }
        this.f1222q = null;
        this.f1223r = null;
        return null;
    }

    public final boolean f() {
        return !this.f1224s && (this.f1206a.f1142i.get() & 134217727) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f1207b
            monitor-enter(r0)
            k.b0 r1 = r2.f1212g     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r1.h()     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            d0.e r1 = r2.f1213h     // Catch: java.lang.Throwable -> L1b
            int r1 = r1.f2751h     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L12
            goto L1d
        L12:
            boolean r2 = r2.f()     // Catch: java.lang.Throwable -> L1b
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
        throw new UnsupportedOperationException("Method not decompiled: b0.j2.g():boolean");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    public final List h() {
        ?? r02 = this.f1211f;
        if (r02 != 0) {
            return r02;
        }
        ArrayList arrayList = this.f1210e;
        List arrayList2 = arrayList.isEmpty() ? d7.z.f2978f : new ArrayList(arrayList);
        this.f1211f = arrayList2;
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x013c, code lost:
    
        r3 = r10.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0141, code lost:
    
        if (r4 >= r3) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014b, code lost:
    
        if (((c7.j) r10.get(r4)).f1974g == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0150, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
    
        if (r8 >= r4) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        r11 = (c7.j) r10.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0168, code lost:
    
        if (r11.f1974g != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016a, code lost:
    
        r11 = (b0.e1) r11.f1973f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0171, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0174, code lost:
    
        r4 = r17.f1207b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0176, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0177, code lost:
    
        d7.x.D0(r17.f1215j, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017c, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017d, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018b, code lost:
    
        if (r8 >= r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018d, code lost:
    
        r11 = r10.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0196, code lost:
    
        if (((c7.j) r11).f1974g == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0198, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019b, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019e, code lost:
    
        r10 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List j(java.util.List r18, k.b0 r19) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.j2.j(java.util.List, k.b0):java.util.List");
    }

    public final void k(Throwable th, x xVar) {
        if (!((Boolean) f1205y.get()).booleanValue() || (th instanceof j)) {
            synchronized (this.f1207b) {
                a7.d dVar = this.f1223r;
                if (dVar != null) {
                    throw ((Throwable) dVar.f411g);
                }
                this.f1223r = new a7.d(2, th);
            }
            throw th;
        }
        synchronized (this.f1207b) {
            try {
                Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", th);
                this.f1214i.clear();
                this.f1213h.g();
                this.f1212g = new k.b0();
                this.f1215j.clear();
                this.f1216k.a();
                this.f1218m.a();
                this.f1223r = new a7.d(2, th);
                if (xVar != null) {
                    l(xVar);
                }
                e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(x xVar) {
        ArrayList arrayList = this.f1220o;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f1220o = arrayList;
        }
        if (!arrayList.contains(xVar)) {
            arrayList.add(xVar);
        }
        if (this.f1210e.remove(xVar)) {
            this.f1211f = null;
        }
    }
}
