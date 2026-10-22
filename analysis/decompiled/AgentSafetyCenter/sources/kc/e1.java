package kc;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e1 implements x0 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7431c = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_state$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7432f = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public e1(boolean z10) {
        this._state$volatile = z10 ? w.f7497j : w.i;
    }

    public static k R(pc.j jVar) {
        while (jVar.i()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pc.j.f9967f;
            pc.j jVarF = jVar.f();
            if (jVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (pc.j) obj;
                    if (!jVar.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = jVarF;
            }
        }
        while (true) {
            jVar = jVar.h();
            if (!jVar.i()) {
                if (jVar instanceof k) {
                    return (k) jVar;
                }
                if (jVar instanceof g1) {
                    return null;
                }
            }
        }
    }

    public static String X(Object obj) {
        if (!(obj instanceof d1)) {
            return obj instanceof t0 ? ((t0) obj).d() ? "Active" : "New" : obj instanceof n ? "Cancelled" : "Completed";
        }
        d1 d1Var = (d1) obj;
        return d1Var.c() ? "Cancelling" : d1.f7424f.get(d1Var) != 0 ? "Completing" : "Active";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kc.x0
    public final j A(e1 e1Var) {
        k kVar = new k();
        kVar.i = e1Var;
        VarHandle.storeStoreFence();
        kVar.f7415h = this;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7431c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof i0) {
                i0 i0Var = (i0) obj;
                boolean z10 = i0Var.f7442c;
                if (!z10) {
                    g1 g1Var = new g1();
                    if (!z10) {
                        s0 s0Var = new s0();
                        s0Var.f7479c = g1Var;
                        VarHandle.storeStoreFence();
                        g1Var = s0Var;
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, i0Var, g1Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, kVar)) {
                    break;
                }
            } else {
                boolean z11 = obj instanceof t0;
                i1 i1Var = i1.f7443c;
                if (!z11) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    n nVar = obj2 instanceof n ? (n) obj2 : null;
                    kVar.l(nVar != null ? nVar.f7461a : null);
                    return i1Var;
                }
                g1 g1VarE = ((t0) obj).e();
                if (g1VarE == null) {
                    V((a1) obj);
                } else if (!g1VarE.b(kVar, 7)) {
                    boolean zB = g1VarE.b(kVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof d1) {
                        thB = ((d1) obj3).b();
                    } else {
                        n nVar2 = obj3 instanceof n ? (n) obj3 : null;
                        if (nVar2 != null) {
                            thB = nVar2.f7461a;
                        }
                    }
                    kVar.l(thB);
                    if (zB) {
                        break;
                    }
                    return i1Var;
                }
            }
        }
        return kVar;
    }

    public final Object B(d1 d1Var, Object obj) {
        Throwable thD;
        Object obj2;
        n nVar = obj instanceof n ? (n) obj : null;
        Throwable th = nVar != null ? nVar.f7461a : null;
        synchronized (d1Var) {
            d1Var.c();
            ArrayList arrayListF = d1Var.f(th);
            thD = D(d1Var, arrayListF);
            if (thD != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                int size = arrayListF.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = arrayListF.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj3;
                    if (th2 != thD && th2 != thD && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        com.stepos.statsrpk.h.b(thD, th2);
                    }
                }
            }
        }
        if (thD != null && thD != th) {
            obj = new n(thD, false);
        }
        if (thD != null && (v(thD) || I(thD))) {
            obj.getClass();
            n.f7460b.compareAndSet((n) obj, 0, 1);
        }
        T(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7431c;
        if (obj instanceof t0) {
            u0 u0Var = new u0();
            u0Var.f7485a = (t0) obj;
            VarHandle.storeStoreFence();
            obj2 = u0Var;
        } else {
            obj2 = obj;
        }
        atomicReferenceFieldUpdater.compareAndSet(this, d1Var, obj2);
        y(d1Var, obj);
        return obj;
    }

    public final Throwable D(d1 d1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (d1Var.c()) {
                return new y0(w(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof n1) {
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof n1)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean E() {
        return true;
    }

    public boolean F() {
        return this instanceof l;
    }

    public final g1 G(t0 t0Var) {
        g1 g1VarE = t0Var.e();
        if (g1VarE != null) {
            return g1VarE;
        }
        if (t0Var instanceof i0) {
            return new g1();
        }
        if (t0Var instanceof a1) {
            V((a1) t0Var);
            return null;
        }
        g5.f.n(t0Var, "State should have list: ");
        return null;
    }

    @Override // kc.x0
    public final g0 H(boolean z10, boolean z11, androidx.room.d dVar) {
        return L(z11, z10 ? new v0(dVar) : new h0(dVar));
    }

    public boolean I(Throwable th) {
        return false;
    }

    public final void K(x0 x0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7432f;
        i1 i1Var = i1.f7443c;
        if (x0Var == null) {
            atomicReferenceFieldUpdater.set(this, i1Var);
            return;
        }
        x0Var.start();
        j jVarA = x0Var.A(this);
        atomicReferenceFieldUpdater.set(this, jVarA);
        if (M()) {
            jVarA.dispose();
            atomicReferenceFieldUpdater.set(this, i1Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g0 L(boolean z10, a1 a1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        i1 i1Var;
        boolean z11;
        boolean zB;
        a1Var.f7415h = this;
        while (true) {
            atomicReferenceFieldUpdater = f7431c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z12 = obj instanceof i0;
            i1Var = i1.f7443c;
            z11 = true;
            if (!z12) {
                if (!(obj instanceof t0)) {
                    z11 = false;
                    break;
                }
                t0 t0Var = (t0) obj;
                g1 g1VarE = t0Var.e();
                if (g1VarE == null) {
                    V((a1) obj);
                } else {
                    if (a1Var.k()) {
                        d1 d1Var = t0Var instanceof d1 ? (d1) t0Var : null;
                        Throwable thB = d1Var != null ? d1Var.b() : null;
                        if (thB == null) {
                            zB = g1VarE.b(a1Var, 5);
                        } else if (z10) {
                            a1Var.l(thB);
                            return i1Var;
                        }
                    } else {
                        zB = g1VarE.b(a1Var, 1);
                    }
                    if (zB) {
                        break;
                    }
                }
            } else {
                i0 i0Var = (i0) obj;
                boolean z13 = i0Var.f7442c;
                if (!z13) {
                    g1 g1Var = new g1();
                    if (!z13) {
                        s0 s0Var = new s0();
                        s0Var.f7479c = g1Var;
                        VarHandle.storeStoreFence();
                        g1Var = s0Var;
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, i0Var, g1Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, a1Var)) {
                    break;
                }
            }
        }
        if (z11) {
            return a1Var;
        }
        if (z10) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            n nVar = obj2 instanceof n ? (n) obj2 : null;
            a1Var.l(nVar != null ? nVar.f7461a : null);
        }
        return i1Var;
    }

    public final boolean M() {
        return !(f7431c.get(this) instanceof t0);
    }

    public boolean N() {
        return this instanceof c;
    }

    public final boolean O(Object obj) {
        Object objY;
        do {
            objY = Y(f7431c.get(this), obj);
            if (objY == w.f7492d) {
                return false;
            }
            if (objY == w.f7493e) {
                return true;
            }
        } while (objY == w.f7494f);
        p(objY);
        return true;
    }

    public final Object P(Object obj) {
        Object objY;
        do {
            objY = Y(f7431c.get(this), obj);
            if (objY == w.f7492d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                n nVar = obj instanceof n ? (n) obj : null;
                throw new IllegalStateException(str, nVar != null ? nVar.f7461a : null);
            }
        } while (objY == w.f7494f);
        return objY;
    }

    public String Q() {
        return getClass().getSimpleName();
    }

    public final void S(g1 g1Var, Throwable th) {
        g1Var.c(4);
        Object obj = pc.j.f9966c.get(g1Var);
        obj.getClass();
        androidx.fragment.app.d dVar = null;
        for (pc.j jVarH = (pc.j) obj; !jVarH.equals(g1Var); jVarH = jVarH.h()) {
            if ((jVarH instanceof a1) && ((a1) jVarH).k()) {
                try {
                    ((a1) jVarH).l(th);
                } catch (Throwable th2) {
                    if (dVar != null) {
                        com.stepos.statsrpk.h.b(dVar, th2);
                    } else {
                        dVar = new androidx.fragment.app.d("Exception in completion handler " + jVarH + " for " + this, th2);
                    }
                }
            }
        }
        if (dVar != null) {
            J(dVar);
        }
        v(th);
    }

    public final void V(a1 a1Var) {
        g1 g1Var = new g1();
        a1Var.getClass();
        pc.j.f9967f.set(g1Var, a1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pc.j.f9966c;
        atomicReferenceFieldUpdater.set(g1Var, a1Var);
        while (true) {
            if (atomicReferenceFieldUpdater.get(a1Var) != a1Var) {
                break;
            } else if (atomicReferenceFieldUpdater.compareAndSet(a1Var, a1Var, g1Var)) {
                g1Var.g(a1Var);
                break;
            }
        }
        f7431c.compareAndSet(this, a1Var, a1Var.h());
    }

    public final int W(Object obj) {
        boolean z10 = obj instanceof i0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7431c;
        if (z10) {
            if (((i0) obj).f7442c) {
                return 0;
            }
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, w.f7497j)) {
                return -1;
            }
            U();
            return 1;
        }
        if (!(obj instanceof s0)) {
            return 0;
        }
        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, ((s0) obj).f7479c)) {
            return -1;
        }
        U();
        return 1;
    }

    public final Object Y(Object obj, Object obj2) {
        Object obj3;
        if (!(obj instanceof t0)) {
            return w.f7492d;
        }
        if (((obj instanceof i0) || (obj instanceof a1)) && !(obj instanceof k) && !(obj2 instanceof n)) {
            t0 t0Var = (t0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7431c;
            if (obj2 instanceof t0) {
                u0 u0Var = new u0();
                u0Var.f7485a = (t0) obj2;
                VarHandle.storeStoreFence();
                obj3 = u0Var;
            } else {
                obj3 = obj2;
            }
            if (!atomicReferenceFieldUpdater.compareAndSet(this, t0Var, obj3)) {
                return w.f7494f;
            }
            T(obj2);
            y(t0Var, obj2);
            return obj2;
        }
        t0 t0Var2 = (t0) obj;
        g1 g1VarG = G(t0Var2);
        if (g1VarG == null) {
            return w.f7494f;
        }
        d1 d1Var = t0Var2 instanceof d1 ? (d1) t0Var2 : null;
        if (d1Var == null) {
            d1Var = new d1(g1VarG, null);
        }
        synchronized (d1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d1.f7424f;
            if (atomicIntegerFieldUpdater.get(d1Var) != 0) {
                return w.f7492d;
            }
            atomicIntegerFieldUpdater.set(d1Var, 1);
            if (d1Var != t0Var2 && !f7431c.compareAndSet(this, t0Var2, d1Var)) {
                return w.f7494f;
            }
            boolean zC = d1Var.c();
            n nVar = obj2 instanceof n ? (n) obj2 : null;
            if (nVar != null) {
                d1Var.a(nVar.f7461a);
            }
            Throwable thB = zC ? null : d1Var.b();
            if (thB != null) {
                S(g1VarG, thB);
            }
            k kVarR = R(g1VarG);
            if (kVarR != null && Z(d1Var, kVarR, obj2)) {
                return w.f7493e;
            }
            g1VarG.c(2);
            k kVarR2 = R(g1VarG);
            return (kVarR2 == null || !Z(d1Var, kVarR2, obj2)) ? B(d1Var, obj2) : w.f7493e;
        }
    }

    public final boolean Z(d1 d1Var, k kVar, Object obj) {
        do {
            e1 e1Var = kVar.i;
            c1 c1Var = new c1();
            c1Var.i = this;
            c1Var.f7420j = d1Var;
            c1Var.f7421k = kVar;
            c1Var.f7422l = obj;
            VarHandle.storeStoreFence();
            if (w.q(e1Var, false, c1Var) != i1.f7443c) {
                return true;
            }
            kVar = R(kVar);
        } while (kVar != null);
        return false;
    }

    @Override // kc.x0
    public boolean d() {
        Object obj = f7431c.get(this);
        return (obj instanceof t0) && ((t0) obj).d();
    }

    @Override // kc.x0
    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new y0(w(), null, this);
        }
        u(cancellationException);
    }

    @Override // nb.g
    public final Object fold(Object obj, xb.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // kc.x0
    public final g0 g(xb.l lVar) {
        return L(true, new h0(lVar));
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        return ac.a.t(this, fVar);
    }

    @Override // nb.e
    public final nb.f getKey() {
        return w0.f7498c;
    }

    @Override // kc.x0
    public final Object i(pb.c cVar) {
        Object obj;
        jb.v vVar;
        do {
            obj = f7431c.get(this);
            boolean z10 = obj instanceof t0;
            vVar = jb.v.f6774a;
            if (!z10) {
                w.i(cVar.getContext());
                return vVar;
            }
        } while (W(obj) < 0);
        g gVar = new g(1, td.h.y(cVar));
        gVar.s();
        i iVar = new i(1);
        iVar.f7441j = gVar;
        VarHandle.storeStoreFence();
        w.h(gVar, w.q(this, true, iVar));
        Object objR = gVar.r();
        ob.a aVar = ob.a.f9351c;
        if (objR != aVar) {
            objR = vVar;
        }
        return objR == aVar ? objR : vVar;
    }

    @Override // kc.x0
    public final boolean isCancelled() {
        Object obj = f7431c.get(this);
        if (obj instanceof n) {
            return true;
        }
        return (obj instanceof d1) && ((d1) obj).c();
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // kc.x0
    public final CancellationException o() {
        CancellationException cancellationException;
        Object obj = f7431c.get(this);
        if (obj instanceof d1) {
            Throwable thB = ((d1) obj).b();
            if (thB == null) {
                g5.f.n(this, "Job is still new or active: ");
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thB instanceof CancellationException ? (CancellationException) thB : null;
            return cancellationException == null ? new y0(strConcat, thB, this) : cancellationException;
        }
        if (obj instanceof t0) {
            g5.f.n(this, "Job is still new or active: ");
            return null;
        }
        if (!(obj instanceof n)) {
            return new y0(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((n) obj).f7461a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new y0(w(), th, this) : cancellationException;
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }

    public void q(Object obj) {
        p(obj);
    }

    public final Object s(pb.c cVar) throws Throwable {
        Object obj;
        do {
            obj = f7431c.get(this);
            if (!(obj instanceof t0)) {
                if (obj instanceof n) {
                    throw ((n) obj).f7461a;
                }
                return w.C(obj);
            }
        } while (W(obj) < 0);
        b1 b1Var = new b1(1, td.h.y(cVar));
        b1Var.f7417m = this;
        VarHandle.storeStoreFence();
        b1Var.s();
        h0 h0Var = new h0(2);
        h0Var.f7439j = b1Var;
        VarHandle.storeStoreFence();
        w.h(b1Var, w.q(this, true, h0Var));
        Object objR = b1Var.r();
        ob.a aVar = ob.a.f9351c;
        return objR;
    }

    @Override // kc.x0
    public final boolean start() {
        int iW;
        do {
            iW = W(f7431c.get(this));
            if (iW == 0) {
                return false;
            }
        } while (iW != 1);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r0
      0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v10 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.e1.t(java.lang.Object):boolean");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Q() + '{' + X(f7431c.get(this)) + '}');
        sb2.append('@');
        sb2.append(w.m(this));
        return sb2.toString();
    }

    public void u(CancellationException cancellationException) {
        t(cancellationException);
    }

    public final boolean v(Throwable th) {
        if (N()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        j jVar = (j) f7432f.get(this);
        return (jVar == null || jVar == i1.f7443c) ? z10 : jVar.a(th) || z10;
    }

    public String w() {
        return "Job was cancelled";
    }

    public boolean x(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return t(th) && E();
    }

    public final void y(t0 t0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7432f;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        if (jVar != null) {
            jVar.dispose();
            atomicReferenceFieldUpdater.set(this, i1.f7443c);
        }
        androidx.fragment.app.d dVar = null;
        n nVar = obj instanceof n ? (n) obj : null;
        Throwable th = nVar != null ? nVar.f7461a : null;
        if (t0Var instanceof a1) {
            try {
                ((a1) t0Var).l(th);
                return;
            } catch (Throwable th2) {
                J(new androidx.fragment.app.d("Exception in completion handler " + t0Var + " for " + this, th2));
                return;
            }
        }
        g1 g1VarE = t0Var.e();
        if (g1VarE != null) {
            g1VarE.c(1);
            Object obj2 = pc.j.f9966c.get(g1VarE);
            obj2.getClass();
            for (pc.j jVarH = (pc.j) obj2; !jVarH.equals(g1VarE); jVarH = jVarH.h()) {
                if (jVarH instanceof a1) {
                    try {
                        ((a1) jVarH).l(th);
                    } catch (Throwable th3) {
                        if (dVar != null) {
                            com.stepos.statsrpk.h.b(dVar, th3);
                        } else {
                            dVar = new androidx.fragment.app.d("Exception in completion handler " + jVarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (dVar != null) {
                J(dVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    public final Throwable z(Object obj) {
        CancellationException cancellationExceptionB;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        e1 e1Var = (e1) obj;
        Object obj2 = f7431c.get(e1Var);
        if (obj2 instanceof d1) {
            cancellationExceptionB = ((d1) obj2).b();
        } else if (obj2 instanceof n) {
            cancellationExceptionB = ((n) obj2).f7461a;
        } else {
            if (obj2 instanceof t0) {
                g5.f.n(obj2, "Cannot be cancelling child in this state: ");
                return null;
            }
            cancellationExceptionB = null;
        }
        CancellationException cancellationException = cancellationExceptionB instanceof CancellationException ? cancellationExceptionB : null;
        return cancellationException == null ? new y0("Parent job is ".concat(X(obj2)), cancellationExceptionB, e1Var) : cancellationException;
    }

    public void U() {
    }

    public void J(androidx.fragment.app.d dVar) {
        throw dVar;
    }

    public void T(Object obj) {
    }

    public void p(Object obj) {
    }
}
