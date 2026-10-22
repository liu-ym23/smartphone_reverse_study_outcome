package ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class o1 implements g1, u1 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4991f = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4992g = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public o1(boolean z4) {
        this._state$volatile = z4 ? d0.f4944j : d0.f4943i;
    }

    public static q a0(na.k kVar) {
        while (kVar.i()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.k.f6912g;
            na.k kVarF = kVar.f();
            if (kVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (na.k) obj;
                    if (!kVar.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = kVarF;
            }
        }
        while (true) {
            kVar = kVar.h();
            if (!kVar.i()) {
                if (kVar instanceof q) {
                    return (q) kVar;
                }
                if (kVar instanceof q1) {
                    return null;
                }
            }
        }
    }

    public static String h0(Object obj) {
        if (!(obj instanceof n1)) {
            return obj instanceof c1 ? ((c1) obj).b() ? "Active" : "New" : obj instanceof v ? "Cancelled" : "Completed";
        }
        n1 n1Var = (n1) obj;
        return n1Var.e() ? "Cancelling" : n1.f4984g.get(n1Var) == 1 ? "Completing" : "Active";
    }

    public static CancellationException i0(o1 o1Var, Throwable th) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new h1(o1Var.F(), th, o1Var) : cancellationException;
    }

    public final Object A(g7.d dVar) throws Throwable {
        Object obj;
        do {
            obj = f4991f.get(this);
            if (!(obj instanceof c1)) {
                if (obj instanceof v) {
                    throw ((v) obj).f5011a;
                }
                return d0.z(obj);
            }
        } while (g0(obj) < 0);
        l1 l1Var = new l1(ib.k.C(dVar), this);
        l1Var.s();
        int i2 = 2;
        l1Var.v(new h(i2, d0.o(this, true, new q0(i2, l1Var))));
        Object objR = l1Var.r();
        h7.a aVar = h7.a.f4212f;
        return objR;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r0
      0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v11 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.o1.B(java.lang.Object):boolean");
    }

    public void C(CancellationException cancellationException) {
        B(cancellationException);
    }

    public final boolean D(Throwable th) {
        if (W()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        p pVar = (p) f4992g.get(this);
        return (pVar == null || pVar == s1.f5001f) ? z4 : pVar.c(th) || z4;
    }

    @Override // ia.g1
    public final CancellationException E() {
        Object obj = f4991f.get(this);
        if (!(obj instanceof n1)) {
            if (!(obj instanceof c1)) {
                return obj instanceof v ? i0(this, ((v) obj).f5011a) : new h1(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        Throwable thC = ((n1) obj).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = F();
        }
        return new h1(strConcat, thC, this);
    }

    public String F() {
        return "Job was cancelled";
    }

    public boolean G(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return B(th) && N();
    }

    public final void I(c1 c1Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4992g;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        if (pVar != null) {
            pVar.a();
            atomicReferenceFieldUpdater.set(this, s1.f5001f);
        }
        a4.u uVar = null;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f5011a : null;
        if (c1Var instanceof k1) {
            try {
                ((k1) c1Var).l(th);
                return;
            } catch (Throwable th2) {
                S(new a4.u("Exception in completion handler " + c1Var + " for " + this, th2));
                return;
            }
        }
        q1 q1VarD = c1Var.d();
        if (q1VarD != null) {
            q1VarD.e(new na.i(1), 1);
            Object obj2 = na.k.f6911f.get(q1VarD);
            q7.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (na.k kVarH = (na.k) obj2; !kVarH.equals(q1VarD); kVarH = kVarH.h()) {
                if (kVarH instanceof k1) {
                    try {
                        ((k1) kVarH).l(th);
                    } catch (Throwable th3) {
                        if (uVar != null) {
                            ib.k.e(uVar, th3);
                        } else {
                            uVar = new a4.u("Exception in completion handler " + kVarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (uVar != null) {
                S(uVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    public final Throwable J(Object obj) {
        CancellationException cancellationExceptionC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        o1 o1Var = (o1) ((u1) obj);
        Object obj2 = f4991f.get(o1Var);
        if (obj2 instanceof n1) {
            cancellationExceptionC = ((n1) obj2).c();
        } else if (obj2 instanceof v) {
            cancellationExceptionC = ((v) obj2).f5011a;
        } else {
            if (obj2 instanceof c1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            cancellationExceptionC = null;
        }
        CancellationException cancellationException = cancellationExceptionC instanceof CancellationException ? cancellationExceptionC : null;
        return cancellationException == null ? new h1("Parent job is ".concat(h0(obj2)), cancellationExceptionC, o1Var) : cancellationException;
    }

    public final Object L(n1 n1Var, Object obj) {
        Throwable thM;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f5011a : null;
        synchronized (n1Var) {
            n1Var.e();
            ArrayList<Throwable> arrayListF = n1Var.f(th);
            thM = M(n1Var, arrayListF);
            if (thM != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                for (Throwable th2 : arrayListF) {
                    if (th2 != thM && th2 != thM && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ib.k.e(thM, th2);
                    }
                }
            }
        }
        if (thM != null && thM != th) {
            obj = new v(thM, false);
        }
        if (thM != null && (D(thM) || R(thM))) {
            q7.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            v.f5010b.compareAndSet((v) obj, 0, 1);
        }
        c0(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4991f;
        Object d1Var = obj instanceof c1 ? new d1((c1) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, n1Var, d1Var) && atomicReferenceFieldUpdater.get(this) == n1Var) {
        }
        I(n1Var, obj);
        return obj;
    }

    public final Throwable M(n1 n1Var, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (n1Var.e()) {
                return new h1(F(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof a2) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof a2)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean N() {
        return true;
    }

    public boolean O() {
        return this instanceof s;
    }

    public final q1 P(c1 c1Var) {
        q1 q1VarD = c1Var.d();
        if (q1VarD != null) {
            return q1VarD;
        }
        if (c1Var instanceof r0) {
            return new q1();
        }
        if (c1Var instanceof k1) {
            f0((k1) c1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + c1Var).toString());
    }

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return f1.plus(this, lVar);
    }

    public boolean R(Throwable th) {
        return false;
    }

    public void S(a4.u uVar) {
        throw uVar;
    }

    public final void T(g1 g1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4992g;
        s1 s1Var = s1.f5001f;
        if (g1Var == null) {
            atomicReferenceFieldUpdater.set(this, s1Var);
            return;
        }
        g1Var.start();
        p pVarQ = g1Var.q(this);
        atomicReferenceFieldUpdater.set(this, pVarQ);
        if (V()) {
            pVarQ.a();
            atomicReferenceFieldUpdater.set(this, s1Var);
        }
    }

    public final p0 U(boolean z4, k1 k1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        s1 s1Var;
        boolean z10;
        boolean zE;
        k1Var.f4966i = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f4991f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z11 = obj instanceof r0;
            s1Var = s1.f5001f;
            z10 = true;
            if (!z11) {
                if (!(obj instanceof c1)) {
                    z10 = false;
                    break;
                }
                c1 c1Var = (c1) obj;
                q1 q1VarD = c1Var.d();
                if (q1VarD == null) {
                    f0((k1) obj);
                } else {
                    if (k1Var.k()) {
                        n1 n1Var = c1Var instanceof n1 ? (n1) c1Var : null;
                        Throwable thC = n1Var != null ? n1Var.c() : null;
                        if (thC == null) {
                            zE = q1VarD.e(k1Var, 5);
                        } else if (z4) {
                            k1Var.l(thC);
                            return s1Var;
                        }
                    } else {
                        zE = q1VarD.e(k1Var, 1);
                    }
                    if (zE) {
                        break;
                    }
                }
            } else {
                r0 r0Var = (r0) obj;
                if (r0Var.f4997f) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, k1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                e0(r0Var);
            }
        }
        if (z10) {
            return k1Var;
        }
        if (z4) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            v vVar = obj2 instanceof v ? (v) obj2 : null;
            k1Var.l(vVar != null ? vVar.f5011a : null);
        }
        return s1Var;
    }

    public final boolean V() {
        return !(f4991f.get(this) instanceof c1);
    }

    public boolean W() {
        return this instanceof f;
    }

    public final boolean X(Object obj) {
        Object objJ0;
        do {
            objJ0 = j0(f4991f.get(this), obj);
            if (objJ0 == d0.f4938d) {
                return false;
            }
            if (objJ0 == d0.f4939e) {
                return true;
            }
        } while (objJ0 == d0.f4940f);
        w(objJ0);
        return true;
    }

    public final Object Y(Object obj) {
        Object objJ0;
        do {
            objJ0 = j0(f4991f.get(this), obj);
            if (objJ0 == d0.f4938d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                v vVar = obj instanceof v ? (v) obj : null;
                throw new IllegalStateException(str, vVar != null ? vVar.f5011a : null);
            }
        } while (objJ0 == d0.f4940f);
        return objJ0;
    }

    public String Z() {
        return getClass().getSimpleName();
    }

    @Override // ia.g1
    public /* synthetic */ boolean a(Throwable th) {
        C(th != null ? i0(this, th) : new h1(F(), null, this));
        return true;
    }

    @Override // ia.g1
    public boolean b() {
        Object obj = f4991f.get(this);
        return (obj instanceof c1) && ((c1) obj).b();
    }

    public final void b0(q1 q1Var, Throwable th) {
        q1Var.e(new na.i(4), 4);
        Object obj = na.k.f6911f.get(q1Var);
        q7.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        a4.u uVar = null;
        for (na.k kVarH = (na.k) obj; !kVarH.equals(q1Var); kVarH = kVarH.h()) {
            if ((kVarH instanceof k1) && ((k1) kVarH).k()) {
                try {
                    ((k1) kVarH).l(th);
                } catch (Throwable th2) {
                    if (uVar != null) {
                        ib.k.e(uVar, th2);
                    } else {
                        uVar = new a4.u("Exception in completion handler " + kVarH + " for " + this, th2);
                    }
                }
            }
        }
        if (uVar != null) {
            S(uVar);
        }
        D(th);
    }

    public void c0(Object obj) {
    }

    @Override // ia.g1
    public void d(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new h1(F(), null, this);
        }
        C(cancellationException);
    }

    public void d0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [ia.b1] */
    public final void e0(r0 r0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1 q1Var = new q1();
        if (!r0Var.f4997f) {
            q1Var = new b1(q1Var);
        }
        do {
            atomicReferenceFieldUpdater = f4991f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, r0Var, q1Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == r0Var);
    }

    public final void f0(k1 k1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1 q1Var = new q1();
        k1Var.getClass();
        na.k.f6912g.set(q1Var, k1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = na.k.f6911f;
        atomicReferenceFieldUpdater2.set(q1Var, k1Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(k1Var) == k1Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(k1Var, k1Var, q1Var)) {
                    if (atomicReferenceFieldUpdater2.get(k1Var) != k1Var) {
                        break;
                    }
                }
                q1Var.g(k1Var);
                break loop0;
            }
            break;
        }
        na.k kVarH = k1Var.h();
        do {
            atomicReferenceFieldUpdater = f4991f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, k1Var, kVarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == k1Var);
    }

    public Object g() throws Throwable {
        Object obj = f4991f.get(this);
        if (obj instanceof c1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof v) {
            throw ((v) obj).f5011a;
        }
        return d0.z(obj);
    }

    public final int g0(Object obj) {
        boolean z4 = obj instanceof r0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4991f;
        if (z4) {
            if (((r0) obj).f4997f) {
                return 0;
            }
            r0 r0Var = d0.f4944j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, r0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            d0();
            return 1;
        }
        if (!(obj instanceof b1)) {
            return 0;
        }
        q1 q1Var = ((b1) obj).f4920f;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        d0();
        return 1;
    }

    @Override // g7.j
    public final g7.k getKey() {
        return z.f5027g;
    }

    @Override // ia.g1
    public final p0 i(boolean z4, boolean z10, p7.k kVar) {
        return U(z10, z4 ? new e1(kVar) : new q0(1, kVar));
    }

    public final Object j0(Object obj, Object obj2) {
        if (!(obj instanceof c1)) {
            return d0.f4938d;
        }
        if (((obj instanceof r0) || (obj instanceof k1)) && !(obj instanceof q) && !(obj2 instanceof v)) {
            c1 c1Var = (c1) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4991f;
            Object d1Var = obj2 instanceof c1 ? new d1((c1) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c1Var, d1Var)) {
                if (atomicReferenceFieldUpdater.get(this) != c1Var) {
                    return d0.f4940f;
                }
            }
            c0(obj2);
            I(c1Var, obj2);
            return obj2;
        }
        c1 c1Var2 = (c1) obj;
        q1 q1VarP = P(c1Var2);
        if (q1VarP == null) {
            return d0.f4940f;
        }
        n1 n1Var = c1Var2 instanceof n1 ? (n1) c1Var2 : null;
        if (n1Var == null) {
            n1Var = new n1(q1VarP, null);
        }
        synchronized (n1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n1.f4984g;
            if (atomicIntegerFieldUpdater.get(n1Var) == 1) {
                return d0.f4938d;
            }
            atomicIntegerFieldUpdater.set(n1Var, 1);
            if (n1Var != c1Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4991f;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, c1Var2, n1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != c1Var2) {
                        return d0.f4940f;
                    }
                }
            }
            boolean zE = n1Var.e();
            v vVar = obj2 instanceof v ? (v) obj2 : null;
            if (vVar != null) {
                n1Var.a(vVar.f5011a);
            }
            Throwable thC = zE ? null : n1Var.c();
            if (thC != null) {
                b0(q1VarP, thC);
            }
            q qVarA0 = a0(q1VarP);
            if (qVarA0 != null && k0(n1Var, qVarA0, obj2)) {
                return d0.f4939e;
            }
            q1VarP.e(new na.i(2), 2);
            q qVarA02 = a0(q1VarP);
            return (qVarA02 == null || !k0(n1Var, qVarA02, obj2)) ? L(n1Var, obj2) : d0.f4939e;
        }
    }

    public final boolean k0(n1 n1Var, q qVar, Object obj) {
        while (d0.o(qVar.f4994j, false, new m1(this, n1Var, qVar, obj)) == s1.f5001f) {
            qVar = a0(qVar);
            if (qVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // g7.l
    public final g7.j o(g7.k kVar) {
        return f1.get(this, kVar);
    }

    @Override // ia.g1
    public final p q(o1 o1Var) {
        q qVar = new q(o1Var);
        qVar.f4966i = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4991f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof r0) {
                r0 r0Var = (r0) obj;
                if (r0Var.f4997f) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, qVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                e0(r0Var);
            } else {
                boolean z4 = obj instanceof c1;
                s1 s1Var = s1.f5001f;
                if (!z4) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    v vVar = obj2 instanceof v ? (v) obj2 : null;
                    qVar.l(vVar != null ? vVar.f5011a : null);
                    return s1Var;
                }
                q1 q1VarD = ((c1) obj).d();
                if (q1VarD == null) {
                    f0((k1) obj);
                } else if (!q1VarD.e(qVar, 7)) {
                    boolean zE = q1VarD.e(qVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof n1) {
                        thC = ((n1) obj3).c();
                    } else {
                        v vVar2 = obj3 instanceof v ? (v) obj3 : null;
                        if (vVar2 != null) {
                            thC = vVar2.f5011a;
                        }
                    }
                    qVar.l(thC);
                    if (zE) {
                        break loop0;
                    }
                    return s1Var;
                }
            }
        }
        return qVar;
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return f1.fold(this, obj, nVar);
    }

    @Override // ia.g1
    public final Object s(i7.c cVar) {
        Object obj;
        c7.r rVar;
        do {
            obj = f4991f.get(this);
            boolean z4 = obj instanceof c1;
            rVar = c7.r.f1986a;
            if (!z4) {
                d0.h(cVar.getContext());
                return rVar;
            }
        } while (g0(obj) < 0);
        m mVar = new m(1, ib.k.C(cVar));
        mVar.s();
        mVar.v(new h(2, d0.o(this, true, new o(mVar, 1))));
        Object objR = mVar.r();
        h7.a aVar = h7.a.f4212f;
        if (objR != aVar) {
            objR = rVar;
        }
        return objR == aVar ? objR : rVar;
    }

    @Override // ia.g1
    public final boolean start() {
        int iG0;
        do {
            iG0 = g0(f4991f.get(this));
            if (iG0 == 0) {
                return false;
            }
        } while (iG0 != 1);
        return true;
    }

    @Override // ia.g1
    public final p0 t(p7.k kVar) {
        return U(true, new q0(1, kVar));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Z() + '{' + h0(f4991f.get(this)) + '}');
        sb2.append('@');
        sb2.append(d0.k(this));
        return sb2.toString();
    }

    public void w(Object obj) {
    }

    public void y(Object obj) {
        w(obj);
    }

    @Override // g7.l
    public final g7.l z(g7.k kVar) {
        return f1.minusKey(this, kVar);
    }
}
