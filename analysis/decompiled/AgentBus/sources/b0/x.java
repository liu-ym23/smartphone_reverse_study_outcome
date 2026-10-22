package b0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class x implements t {

    /* renamed from: f, reason: collision with root package name */
    public final u f1393f;

    /* renamed from: g, reason: collision with root package name */
    public final i5.l f1394g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference f1395h = new AtomicReference(null);

    /* renamed from: i, reason: collision with root package name */
    public final Object f1396i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final k.d0 f1397j;

    /* renamed from: k, reason: collision with root package name */
    public final p2 f1398k;

    /* renamed from: l, reason: collision with root package name */
    public final k.a0 f1399l;

    /* renamed from: m, reason: collision with root package name */
    public final k.b0 f1400m;

    /* renamed from: n, reason: collision with root package name */
    public final k.b0 f1401n;

    /* renamed from: o, reason: collision with root package name */
    public final k.a0 f1402o;

    /* renamed from: p, reason: collision with root package name */
    public final c0.a f1403p;

    /* renamed from: q, reason: collision with root package name */
    public final c0.a f1404q;

    /* renamed from: r, reason: collision with root package name */
    public final k.a0 f1405r;

    /* renamed from: s, reason: collision with root package name */
    public k.a0 f1406s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1407t;

    /* renamed from: u, reason: collision with root package name */
    public x f1408u;

    /* renamed from: v, reason: collision with root package name */
    public int f1409v;

    /* renamed from: w, reason: collision with root package name */
    public final b1 f1410w;

    /* renamed from: x, reason: collision with root package name */
    public final i1.a1 f1411x;

    /* renamed from: y, reason: collision with root package name */
    public final p f1412y;

    /* renamed from: z, reason: collision with root package name */
    public int f1413z;

    public x(u uVar, i5.l lVar) {
        this.f1393f = uVar;
        this.f1394g = lVar;
        k.d0 d0Var = new k.d0(new k.b0());
        this.f1397j = d0Var;
        p2 p2Var = new p2();
        if (((Boolean) j2.f1205y.get()).booleanValue()) {
            p2Var.f1316p = new k.t();
        }
        this.f1398k = p2Var;
        this.f1399l = ib.c.r();
        this.f1400m = new k.b0();
        this.f1401n = new k.b0();
        this.f1402o = ib.c.r();
        c0.a aVar = new c0.a();
        this.f1403p = aVar;
        c0.a aVar2 = new c0.a();
        this.f1404q = aVar2;
        this.f1405r = ib.c.r();
        this.f1406s = ib.c.r();
        b1 b1Var = new b1(uVar);
        this.f1410w = b1Var;
        this.f1411x = new i1.a1();
        this.f1412y = new p(lVar, uVar, p2Var, d0Var, aVar, aVar2, b1Var, this);
        j0.d dVar = i.f1184a;
    }

    public final void a() {
        this.f1395h.set(null);
        this.f1403p.f1713a.Q();
        this.f1404q.f1713a.Q();
        k.d0 d0Var = this.f1397j;
        if (d0Var.f5475f.g()) {
            return;
        }
        i1.a1 a1Var = this.f1411x;
        try {
            a1Var.i(d0Var, this.f1412y.y());
            a1Var.e();
        } finally {
            a1Var.b();
        }
    }

    public final void b(Object obj, boolean z4) {
        Object objG = this.f1399l.g(obj);
        if (objG == null) {
            return;
        }
        boolean z10 = objG instanceof k.b0;
        k.b0 b0Var = this.f1400m;
        k.b0 b0Var2 = this.f1401n;
        k.a0 a0Var = this.f1405r;
        if (!z10) {
            z1 z1Var = (z1) objG;
            if (ib.c.K(a0Var, obj, z1Var) || z1Var.c(obj) == t0.f1370f) {
                return;
            }
            if (z1Var.f1447g == null || z4) {
                b0Var.a(z1Var);
                return;
            } else {
                b0Var2.a(z1Var);
                return;
            }
        }
        k.b0 b0Var3 = (k.b0) objG;
        Object[] objArr = b0Var3.f5454b;
        long[] jArr = b0Var3.f5453a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        z1 z1Var2 = (z1) objArr[(i2 << 3) + i11];
                        if (!ib.c.K(a0Var, obj, z1Var2) && z1Var2.c(obj) != t0.f1370f) {
                            if (z1Var2.f1447g == null || z4) {
                                b0Var.a(z1Var2);
                            } else {
                                b0Var2.a(z1Var2);
                            }
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0183 A[EDGE_INSN: B:73:0x0183->B:224:0x0122 BREAK  A[LOOP:13: B:63:0x0151->B:74:0x0185]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.Set r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.c(java.util.Set, boolean):void");
    }

    public final void d() {
        synchronized (this.f1396i) {
            try {
                e(this.f1403p);
                l();
            } catch (Throwable th) {
                try {
                    if (!this.f1397j.f5475f.g()) {
                        i1.a1 a1Var = this.f1411x;
                        try {
                            a1Var.i(this.f1397j, this.f1412y.y());
                            a1Var.e();
                            a1Var.b();
                        } catch (Throwable th2) {
                            a1Var.b();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    a();
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01e1 A[Catch: all -> 0x01e5, TRY_LEAVE, TryCatch #3 {all -> 0x01e5, blocks: (B:118:0x01d9, B:120:0x01e1), top: B:134:0x01d9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(c0.a r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.e(c0.a):void");
    }

    public final void f() {
        synchronized (this.f1396i) {
            try {
                if (this.f1404q.f1713a.T()) {
                    e(this.f1404q);
                }
            } catch (Throwable th) {
                try {
                    if (!this.f1397j.f5475f.g()) {
                        i1.a1 a1Var = this.f1411x;
                        try {
                            a1Var.i(this.f1397j, this.f1412y.y());
                            a1Var.e();
                            a1Var.b();
                        } catch (Throwable th2) {
                            a1Var.b();
                            throw th2;
                        }
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public final void g() {
        i1.a1 a1Var;
        synchronized (this.f1396i) {
            try {
                this.f1412y.f1291u = null;
                if (!this.f1397j.f5475f.g()) {
                    a1Var = this.f1411x;
                    try {
                        a1Var.i(this.f1397j, this.f1412y.y());
                        a1Var.e();
                        a1Var.b();
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    if (!this.f1397j.f5475f.g()) {
                        a1Var = this.f1411x;
                        try {
                            a1Var.i(this.f1397j, this.f1412y.y());
                            a1Var.e();
                            a1Var.b();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.h():void");
    }

    public final void i(j0.d dVar) {
        try {
            synchronized (this.f1396i) {
                k();
                k.a0 a0Var = this.f1406s;
                this.f1406s = ib.c.r();
                try {
                    p pVar = this.f1412y;
                    if (!pVar.f1275e.f1713a.S()) {
                        s.c("Expected applyChanges() to have been called");
                    }
                    pVar.o(a0Var, dVar);
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.f1397j.f5475f.g()) {
                    i1.a1 a1Var = this.f1411x;
                    try {
                        a1Var.i(this.f1397j, this.f1412y.y());
                        a1Var.e();
                        a1Var.b();
                    } catch (Throwable th2) {
                        a1Var.b();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                a();
                throw th3;
            }
        }
    }

    public final void j(j0.d dVar) {
        d2 d2Var;
        boolean zContains;
        l0.b bVarC;
        j2 j2Var = (j2) this.f1393f;
        boolean z4 = this.f1412y.E;
        synchronized (j2Var.f1207b) {
            d2 d2Var2 = (d2) j2Var.f1225t.getValue();
            d2Var = d2.f1124g;
            zContains = d2Var2.compareTo(d2Var) > 0 ? true ^ j2Var.h().contains(this) : true;
        }
        try {
            a5.a aVar = new a5.a(3, this);
            b2 b2Var = new b2(0, this, (Object) null);
            l0.f fVarK = l0.m.k();
            l0.b bVar = fVarK instanceof l0.b ? (l0.b) fVarK : null;
            if (bVar == null || (bVarC = bVar.C(aVar, b2Var)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                l0.f fVarJ = bVarC.j();
                try {
                    i(dVar);
                    synchronized (j2Var.f1207b) {
                        if (((d2) j2Var.f1225t.getValue()).compareTo(d2Var) > 0 && !j2Var.h().contains(this)) {
                            j2Var.f1210e.add(this);
                            j2Var.f1211f = null;
                        }
                    }
                    if (!z4) {
                        l0.m.k().m();
                    }
                    try {
                        synchronized (j2Var.f1207b) {
                            ArrayList arrayList = j2Var.f1215j;
                            if (arrayList.size() > 0) {
                                ((e1) arrayList.get(0)).getClass();
                                throw null;
                            }
                        }
                        try {
                            d();
                            f();
                            if (z4) {
                                return;
                            }
                            l0.m.k().m();
                        } catch (Throwable th) {
                            j2Var.k(th, null);
                        }
                    } catch (Throwable th2) {
                        j2Var.k(th2, this);
                    }
                } finally {
                    l0.f.q(fVarJ);
                }
            } finally {
                j2.c(bVarC);
            }
        } catch (Throwable th3) {
            if (zContains) {
                synchronized (j2Var.f1207b) {
                }
            }
            j2Var.k(th3, this);
        }
    }

    public final void k() {
        Object obj = b.f1104a;
        AtomicReference atomicReference = this.f1395h;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                s.d("pending composition has not been applied");
                throw new a4.u();
            }
            if (andSet instanceof Set) {
                c((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                s.d("corrupt pendingModifications drain: " + atomicReference);
                throw new a4.u();
            }
            for (Set set : (Set[]) andSet) {
                c(set, true);
            }
        }
    }

    public final void l() {
        AtomicReference atomicReference = this.f1395h;
        Object andSet = atomicReference.getAndSet(null);
        if (q7.k.a(andSet, b.f1104a)) {
            return;
        }
        if (andSet instanceof Set) {
            c((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                c(set, false);
            }
            return;
        }
        if (andSet == null) {
            s.d("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new a4.u();
        }
        s.d("corrupt pendingModifications drain: " + atomicReference);
        throw new a4.u();
    }

    public final void m(ArrayList arrayList) {
        k.d0 d0Var = this.f1397j;
        p pVar = this.f1412y;
        if (arrayList.size() > 0) {
            ((e1) ((c7.j) arrayList.get(0)).f1973f).getClass();
            throw null;
        }
        try {
            pVar.getClass();
            try {
                pVar.A(arrayList);
                pVar.i();
            } catch (Throwable th) {
                pVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                if (!d0Var.f5475f.g()) {
                    i1.a1 a1Var = this.f1411x;
                    try {
                        a1Var.i(d0Var, pVar.y());
                        a1Var.e();
                        a1Var.b();
                    } catch (Throwable th3) {
                        a1Var.b();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                a();
                throw th4;
            }
        }
    }

    public final t0 n(z1 z1Var, Object obj) {
        x xVar;
        int i2 = z1Var.f1442b;
        if ((i2 & 2) != 0) {
            z1Var.f1442b = i2 | 4;
        }
        a aVar = z1Var.f1443c;
        if (aVar == null || !aVar.a()) {
            return t0.f1370f;
        }
        if (this.f1398k.i(aVar)) {
            if (z1Var.f1444d == null) {
                return t0.f1370f;
            }
            t0 t0VarP = p(z1Var, aVar, obj);
            if (t0VarP != t0.f1370f) {
                this.f1410w.getClass();
            }
            return t0VarP;
        }
        synchronized (this.f1396i) {
            xVar = this.f1408u;
        }
        if (xVar != null) {
            p pVar = xVar.f1412y;
            if (pVar.E && pVar.W(z1Var, obj)) {
                return t0.f1373i;
            }
        }
        return t0.f1370f;
    }

    public final void o() {
        x xVar;
        synchronized (this.f1396i) {
            try {
                for (Object obj : this.f1398k.f1308h) {
                    z1 z1Var = obj instanceof z1 ? (z1) obj : null;
                    if (z1Var != null && (xVar = z1Var.f1441a) != null) {
                        xVar.n(z1Var, null);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5 A[Catch: all -> 0x003e, EDGE_INSN: B:95:0x00d5->B:64:0x00d5 BREAK  A[LOOP:0: B:46:0x0089->B:60:0x00cd], EDGE_INSN: B:96:0x00d5->B:64:0x00d5 BREAK  A[LOOP:0: B:46:0x0089->B:60:0x00cd], TRY_LEAVE, TryCatch #1 {all -> 0x003e, blocks: (B:4:0x000b, B:6:0x000f, B:8:0x0017, B:10:0x001e, B:14:0x0028, B:16:0x002e, B:24:0x0044, B:26:0x004a, B:31:0x0055, B:35:0x005b, B:36:0x0064, B:38:0x0068, B:39:0x0071, B:41:0x0079, B:43:0x007d, B:46:0x0089, B:48:0x009c, B:50:0x00a8, B:52:0x00b2, B:56:0x00c1, B:60:0x00cd, B:61:0x00d0, B:64:0x00d5, B:13:0x0023), top: B:93:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b0.t0 p(b0.z1 r22, b0.a r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.p(b0.z1, b0.a, java.lang.Object):b0.t0");
    }

    public final void q(Object obj) {
        Object objG = this.f1399l.g(obj);
        if (objG == null) {
            return;
        }
        boolean z4 = objG instanceof k.b0;
        k.a0 a0Var = this.f1405r;
        if (!z4) {
            z1 z1Var = (z1) objG;
            if (z1Var.c(obj) == t0.f1373i) {
                ib.c.g(a0Var, obj, z1Var);
                return;
            }
            return;
        }
        k.b0 b0Var = (k.b0) objG;
        Object[] objArr = b0Var.f5454b;
        long[] jArr = b0Var.f5453a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        z1 z1Var2 = (z1) objArr[(i2 << 3) + i11];
                        if (z1Var2.c(obj) == t0.f1373i) {
                            ib.c.g(a0Var, obj, z1Var2);
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(java.util.Set r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof d0.h
            k.a0 r3 = r0.f1402o
            k.a0 r0 = r0.f1399l
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L5e
            d0.h r1 = (d0.h) r1
            k.b0 r1 = r1.f2763f
            java.lang.Object[] r2 = r1.f5454b
            long[] r1 = r1.f5453a
            int r6 = r1.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L7b
            r7 = r4
        L1c:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L59
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L36:
            if (r12 >= r10) goto L57
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L53
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r2[r13]
            boolean r14 = r0.c(r13)
            if (r14 != 0) goto L52
            boolean r13 = r3.c(r13)
            if (r13 == 0) goto L53
        L52:
            return r5
        L53:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L36
        L57:
            if (r10 != r11) goto L7b
        L59:
            if (r7 == r6) goto L7b
            int r7 = r7 + 1
            goto L1c
        L5e:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L64:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r1.next()
            boolean r6 = r0.c(r2)
            if (r6 != 0) goto L7a
            boolean r2 = r3.c(r2)
            if (r2 == 0) goto L64
        L7a:
            return r5
        L7b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.r(java.util.Set):boolean");
    }

    public final boolean s() {
        boolean zT;
        synchronized (this.f1396i) {
            k();
            try {
                k.a0 a0Var = this.f1406s;
                this.f1406s = ib.c.r();
                try {
                    p pVar = this.f1412y;
                    c0.a aVar = pVar.f1275e;
                    if (!aVar.f1713a.S()) {
                        s.c("Expected applyChanges() to have been called");
                    }
                    if (a0Var.f5450e > 0 || !pVar.f1288r.isEmpty()) {
                        pVar.o(a0Var, null);
                        zT = aVar.f1713a.T();
                    } else {
                        zT = false;
                    }
                    if (!zT) {
                        l();
                    }
                } catch (Throwable th) {
                    this.f1406s = a0Var;
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    if (!this.f1397j.f5475f.g()) {
                        i1.a1 a1Var = this.f1411x;
                        try {
                            a1Var.i(this.f1397j, this.f1412y.y());
                            a1Var.e();
                            a1Var.b();
                        } catch (Throwable th3) {
                            a1Var.b();
                            throw th3;
                        }
                    }
                    throw th2;
                } catch (Throwable th4) {
                    a();
                    throw th4;
                }
            }
        }
        return zT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Set[]] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object[]] */
    public final void t(d0.h hVar) {
        d0.h hVar2;
        while (true) {
            Object obj = this.f1395h.get();
            if (obj == null || obj.equals(b.f1104a)) {
                hVar2 = hVar;
            } else if (obj instanceof Set) {
                hVar2 = new Set[]{obj, hVar};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.f1395h).toString());
                }
                Set[] setArr = (Set[]) obj;
                int length = setArr.length;
                ?? CopyOf = Arrays.copyOf(setArr, length + 1);
                CopyOf[length] = hVar;
                hVar2 = CopyOf;
            }
            AtomicReference atomicReference = this.f1395h;
            while (!atomicReference.compareAndSet(obj, hVar2)) {
                if (atomicReference.get() != obj) {
                    break;
                }
            }
            if (obj == null) {
                synchronized (this.f1396i) {
                    l();
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.u(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.f1396i
            monitor-enter(r0)
            r14.q(r15)     // Catch: java.lang.Throwable -> L4f
            k.a0 r1 = r14.f1402o     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.g(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof k.b0     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            k.b0 r15 = (k.b0) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.f5454b     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.f5453a     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            b0.i0 r10 = (b0.i0) r10     // Catch: java.lang.Throwable -> L4f
            r14.q(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r14 = move-exception
            goto L63
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            b0.i0 r15 = (b0.i0) r15     // Catch: java.lang.Throwable -> L4f
            r14.q(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.x.v(java.lang.Object):void");
    }
}
