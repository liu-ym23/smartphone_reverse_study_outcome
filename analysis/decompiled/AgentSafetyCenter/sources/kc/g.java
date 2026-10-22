package kc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class g extends c0 implements f, pb.d, t1 {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7434j = AtomicIntegerFieldUpdater.newUpdater(g.class, "_decisionAndIndex$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7435k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_state$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7436l = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: h, reason: collision with root package name */
    public final nb.c f7437h;
    public final nb.g i;

    public g(int i, nb.c cVar) {
        super(i);
        this.f7437h = cVar;
        this.i = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f7416a;
    }

    public static Object C(j1 j1Var, Object obj, int i, xb.q qVar) {
        if (obj instanceof n) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (qVar != null || (j1Var instanceof e)) {
            return new m(obj, j1Var instanceof e ? (e) j1Var : null, qVar, (Throwable) null, 16);
        }
        return obj;
    }

    public static void x(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(Object obj, int i, xb.q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        do {
            atomicReferenceFieldUpdater = f7435k;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof j1)) {
                if (obj2 instanceof h) {
                    h hVar = (h) obj2;
                    if (h.f7438c.compareAndSet(hVar, 0, 1)) {
                        if (qVar != null) {
                            j(qVar, hVar.f7461a, obj);
                            return;
                        }
                        return;
                    }
                }
                g5.f.n(obj, "Already resumed, but proposed with update ");
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, C((j1) obj2, obj, i, qVar)));
        if (!w()) {
            o();
        }
        p(i);
    }

    public final void B(p pVar) {
        nb.c cVar = this.f7437h;
        pc.f fVar = cVar instanceof pc.f ? (pc.f) cVar : null;
        A(jb.v.f6774a, (fVar != null ? fVar.f9956h : null) == pVar ? 4 : this.f7419g, null);
    }

    @Override // kc.t1
    public final void a(pc.r rVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f7434j;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                od.f.e("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i));
        v(rVar);
    }

    @Override // kc.c0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7435k;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof j1) {
                od.f.e("Not completed");
                return;
            }
            if (obj instanceof n) {
                return;
            }
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (mVar.f7455e != null) {
                    od.f.e("Must be called at most once");
                    return;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, m.a(mVar, null, cancellationException, 15))) {
                    e eVar = mVar.f7452b;
                    if (eVar != null) {
                        i(eVar, cancellationException);
                    }
                    xb.q qVar = mVar.f7453c;
                    if (qVar != null) {
                        j(qVar, cancellationException, mVar.f7451a);
                        return;
                    }
                    return;
                }
                cancellationException2 = cancellationException;
            } else {
                cancellationException2 = cancellationException;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, new m(obj, (e) null, (xb.q) null, cancellationException2, 14))) {
                    return;
                }
            }
            cancellationException = cancellationException2;
        }
    }

    @Override // kc.c0
    public final nb.c c() {
        return this.f7437h;
    }

    @Override // kc.c0
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // kc.c0
    public final Object e(Object obj) {
        return obj instanceof m ? ((m) obj).f7451a : obj;
    }

    @Override // kc.f
    public final boolean f(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = f7435k;
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof j1)) {
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, new h(this, th, (obj instanceof e) || (obj instanceof pc.r))));
        j1 j1Var = (j1) obj;
        if (j1Var instanceof e) {
            i((e) obj, th);
        } else if (j1Var instanceof pc.r) {
            n((pc.r) obj, th);
        }
        if (!w()) {
            o();
        }
        p(this.f7419g);
        return true;
    }

    @Override // pb.d
    public final pb.d getCallerFrame() {
        nb.c cVar = this.f7437h;
        if (cVar instanceof pb.d) {
            return (pb.d) cVar;
        }
        return null;
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.i;
    }

    @Override // kc.c0
    public final Object h() {
        return f7435k.get(this);
    }

    public final void i(e eVar, Throwable th) {
        try {
            switch (eVar.f7428a) {
                case 0:
                    ((ScheduledFuture) eVar.f7429b).cancel(false);
                    break;
                case 1:
                    ((xb.l) eVar.f7429b).invoke(th);
                    break;
                default:
                    ((g0) eVar.f7429b).dispose();
                    break;
            }
        } catch (Throwable th2) {
            w.p(this.i, new androidx.fragment.app.d("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(xb.q qVar, Throwable th, Object obj) {
        nb.g gVar = this.i;
        try {
            qVar.invoke(th, obj, gVar);
        } catch (Throwable th2) {
            w.p(gVar, new androidx.fragment.app.d("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kc.f
    public final pc.t k(Object obj, xb.q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        pc.t tVar = w.f7489a;
        do {
            atomicReferenceFieldUpdater = f7435k;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof j1)) {
                return null;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, C((j1) obj2, obj, this.f7419g, qVar)));
        if (!w()) {
            o();
        }
        return tVar;
    }

    @Override // kc.f
    public final void l(Object obj, xb.q qVar) {
        A(obj, this.f7419g, qVar);
    }

    @Override // kc.f
    public final void m(Object obj) {
        p(this.f7419g);
    }

    public final void n(pc.r rVar, Throwable th) {
        nb.g gVar = this.i;
        int i = f7434j.get(this) & 536870911;
        if (i == 536870911) {
            od.f.e("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            rVar.g(i, gVar);
        } catch (Throwable th2) {
            w.p(gVar, new androidx.fragment.app.d("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7436l;
        g0 g0Var = (g0) atomicReferenceFieldUpdater.get(this);
        if (g0Var == null) {
            return;
        }
        g0Var.dispose();
        atomicReferenceFieldUpdater.set(this, i1.f7443c);
    }

    public final void p(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f7434j;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i10 = i3 >> 29;
            if (i10 != 0) {
                if (i10 != 1) {
                    od.f.e("Already resumed");
                    return;
                }
                boolean z10 = i == 4;
                nb.c cVar = this.f7437h;
                if (!z10 && (cVar instanceof pc.f)) {
                    boolean z11 = i == 1 || i == 2;
                    int i11 = this.f7419g;
                    if (z11 == (i11 == 1 || i11 == 2)) {
                        pc.f fVar = (pc.f) cVar;
                        p pVar = fVar.f9956h;
                        nb.g context = fVar.i.getContext();
                        if (pVar.O(context)) {
                            pVar.M(context, this);
                            return;
                        }
                        j0 j0VarA = l1.a();
                        if (j0VarA.f7444f >= 4294967296L) {
                            j0VarA.R(this);
                            return;
                        }
                        j0VarA.S(true);
                        try {
                            w.x(this, cVar, true);
                            do {
                            } while (j0VarA.U());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                w.x(this, cVar, z10);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable q(e1 e1Var) {
        return e1Var.o();
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        x0 x0Var;
        boolean zW = w();
        do {
            atomicIntegerFieldUpdater = f7434j;
            i = atomicIntegerFieldUpdater.get(this);
            int i3 = i >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    od.f.e("Already suspended");
                    return null;
                }
                if (zW) {
                    z();
                }
                Object obj = f7435k.get(this);
                if (obj instanceof n) {
                    throw ((n) obj).f7461a;
                }
                int i10 = this.f7419g;
                if ((i10 != 1 && i10 != 2) || (x0Var = (x0) this.i.get(w0.f7498c)) == null || x0Var.d()) {
                    return e(obj);
                }
                CancellationException cancellationExceptionO = x0Var.o();
                b(cancellationExceptionO);
                throw cancellationExceptionO;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((g0) f7436l.get(this)) == null) {
            t();
        }
        if (zW) {
            z();
        }
        return ob.a.f9351c;
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        Throwable thB = jb.i.b(obj);
        if (thB != null) {
            obj = new n(thB, false);
        }
        A(obj, this.f7419g, null);
    }

    public final void s() {
        g0 g0VarT = t();
        if (g0VarT == null || (f7435k.get(this) instanceof j1)) {
            return;
        }
        g0VarT.dispose();
        f7436l.set(this, i1.f7443c);
    }

    public final g0 t() {
        x0 x0Var = (x0) this.i.get(w0.f7498c);
        if (x0Var == null) {
            return null;
        }
        i iVar = new i(0);
        iVar.f7441j = this;
        VarHandle.storeStoreFence();
        g0 g0VarQ = w.q(x0Var, true, iVar);
        f7436l.compareAndSet(this, null, g0VarQ);
        return g0VarQ;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y());
        sb2.append('(');
        sb2.append(w.B(this.f7437h));
        sb2.append("){");
        Object obj = f7435k.get(this);
        sb2.append(obj instanceof j1 ? "Active" : obj instanceof h ? "Cancelled" : "Completed");
        sb2.append("}@");
        sb2.append(w.m(this));
        return sb2.toString();
    }

    public final void u(xb.l lVar) {
        e eVar = new e(1);
        eVar.f7429b = lVar;
        VarHandle.storeStoreFence();
        v(eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        x(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(kc.j1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.g.f7435k
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof kc.b
            if (r1 == 0) goto L12
            boolean r0 = r0.compareAndSet(r7, r2, r8)
            if (r0 == 0) goto L0
            goto L92
        L12:
            boolean r1 = r2 instanceof kc.e
            r3 = 0
            if (r1 != 0) goto L93
            boolean r1 = r2 instanceof pc.r
            if (r1 != 0) goto L93
            boolean r1 = r2 instanceof kc.n
            if (r1 == 0) goto L49
            r0 = r2
            kc.n r0 = (kc.n) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = kc.n.f7460b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L45
            boolean r1 = r2 instanceof kc.h
            if (r1 == 0) goto L92
            java.lang.Throwable r0 = r0.f7461a
            boolean r1 = r8 instanceof kc.e
            if (r1 == 0) goto L3c
            kc.e r8 = (kc.e) r8
            r7.i(r8, r0)
            return
        L3c:
            r8.getClass()
            pc.r r8 = (pc.r) r8
            r7.n(r8, r0)
            return
        L45:
            x(r8, r2)
            throw r3
        L49:
            boolean r1 = r2 instanceof kc.m
            if (r1 == 0) goto L78
            r1 = r2
            kc.m r1 = (kc.m) r1
            kc.e r4 = r1.f7452b
            if (r4 != 0) goto L74
            boolean r4 = r8 instanceof pc.r
            if (r4 == 0) goto L59
            return
        L59:
            r8.getClass()
            r4 = r8
            kc.e r4 = (kc.e) r4
            java.lang.Throwable r5 = r1.f7455e
            if (r5 == 0) goto L67
            r7.i(r4, r5)
            return
        L67:
            r5 = 29
            kc.m r1 = kc.m.a(r1, r4, r3, r5)
            boolean r0 = r0.compareAndSet(r7, r2, r1)
            if (r0 == 0) goto L0
            goto L92
        L74:
            x(r8, r2)
            throw r3
        L78:
            boolean r1 = r8 instanceof pc.r
            if (r1 == 0) goto L7d
            return
        L7d:
            r8.getClass()
            r3 = r8
            kc.e r3 = (kc.e) r3
            kc.m r1 = new kc.m
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            boolean r0 = r0.compareAndSet(r7, r2, r1)
            if (r0 == 0) goto L0
        L92:
            return
        L93:
            x(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.g.v(kc.j1):void");
    }

    public final boolean w() {
        if (this.f7419g == 2) {
            return pc.f.f9955l.get((pc.f) this.f7437h) != null;
        }
        return false;
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        nb.c cVar = this.f7437h;
        Throwable th = null;
        pc.f fVar = cVar instanceof pc.f ? (pc.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pc.f.f9955l;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                pc.t tVar = pc.a.f9945c;
                if (obj == tVar) {
                    if (atomicReferenceFieldUpdater.compareAndSet(fVar, tVar, this)) {
                        break;
                    }
                } else if (!(obj instanceof Throwable)) {
                    g5.f.n(obj, "Inconsistent state ");
                    return;
                } else {
                    if (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        g5.f.s("Failed requirement.");
                        return;
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            o();
            f(th);
        }
    }
}
