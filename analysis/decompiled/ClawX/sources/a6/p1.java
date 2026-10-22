package a6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class p1 implements h1, u1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f206a = AtomicReferenceFieldUpdater.newUpdater(p1.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f207b = AtomicReferenceFieldUpdater.newUpdater(p1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public p1(boolean z) {
        this._state$volatile = z ? i0.f180j : i0.f179i;
    }

    public static q V(f6.i iVar) {
        while (iVar.i()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.i.f2647b;
            f6.i iVarF = iVar.f();
            if (iVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(iVar);
                while (true) {
                    iVar = (f6.i) obj;
                    if (!iVar.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(iVar);
                }
            } else {
                iVar = iVarF;
            }
        }
        while (true) {
            iVar = iVar.h();
            if (!iVar.i()) {
                if (iVar instanceof q) {
                    return (q) iVar;
                }
                if (iVar instanceof q1) {
                    return null;
                }
            }
        }
    }

    public static String c0(Object obj) {
        if (!(obj instanceof o1)) {
            return obj instanceof e1 ? ((e1) obj).a() ? "Active" : "New" : obj instanceof v ? "Cancelled" : "Completed";
        }
        o1 o1Var = (o1) obj;
        return o1Var.e() ? "Cancelling" : o1.f202b.get(o1Var) == 1 ? "Completing" : "Active";
    }

    @Override // a6.h1
    public final s0 A(p5.l lVar) {
        return P(true, new t0(1, lVar));
    }

    public final boolean B(Throwable th) {
        if (R()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        p pVar = (p) f207b.get(this);
        return (pVar == null || pVar == s1.f213a) ? z : pVar.c(th) || z;
    }

    public String D() {
        return "Job was cancelled";
    }

    public boolean E(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return x(th) && J();
    }

    public final void F(e1 e1Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f207b;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        if (pVar != null) {
            pVar.b();
            atomicReferenceFieldUpdater.set(this, s1.f213a);
        }
        w wVar = null;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f222a : null;
        if (e1Var instanceof l1) {
            try {
                ((l1) e1Var).l(th);
                return;
            } catch (Throwable th2) {
                N(new w("Exception in completion handler " + e1Var + " for " + this, th2));
                return;
            }
        }
        q1 q1VarD = e1Var.d();
        if (q1VarD != null) {
            q1VarD.e(new f6.g(1), 1);
            Object obj2 = f6.i.f2646a.get(q1VarD);
            kotlin.jvm.internal.p.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (f6.i iVarH = (f6.i) obj2; !iVarH.equals(q1VarD); iVarH = iVarH.h()) {
                if (iVarH instanceof l1) {
                    try {
                        ((l1) iVarH).l(th);
                    } catch (Throwable th3) {
                        if (wVar != null) {
                            a.a.a(wVar, th3);
                        } else {
                            wVar = new w("Exception in completion handler " + iVarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (wVar != null) {
                N(wVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    public final Throwable G(Object obj) {
        CancellationException cancellationExceptionC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        p1 p1Var = (p1) ((u1) obj);
        Object obj2 = f206a.get(p1Var);
        if (obj2 instanceof o1) {
            cancellationExceptionC = ((o1) obj2).c();
        } else if (obj2 instanceof v) {
            cancellationExceptionC = ((v) obj2).f222a;
        } else {
            if (obj2 instanceof e1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            cancellationExceptionC = null;
        }
        CancellationException cancellationException = cancellationExceptionC instanceof CancellationException ? cancellationExceptionC : null;
        return cancellationException == null ? new i1("Parent job is ".concat(c0(obj2)), cancellationExceptionC, p1Var) : cancellationException;
    }

    public final Object H(o1 o1Var, Object obj) {
        Throwable thI;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f222a : null;
        synchronized (o1Var) {
            o1Var.e();
            ArrayList arrayListF = o1Var.f(th);
            thI = I(o1Var, arrayListF);
            if (thI != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                int size = arrayListF.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj2 = arrayListF.get(i8);
                    i8++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != thI && th2 != thI && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        a.a.a(thI, th2);
                    }
                }
            }
        }
        if (thI != null && thI != th) {
            obj = new v(thI, false);
        }
        if (thI != null && (B(thI) || M(thI))) {
            kotlin.jvm.internal.p.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            v.f221b.compareAndSet((v) obj, 0, 1);
        }
        X(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f206a;
        Object f1Var = obj instanceof e1 ? new f1((e1) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, o1Var, f1Var) && atomicReferenceFieldUpdater.get(this) == o1Var) {
        }
        F(o1Var, obj);
        return obj;
    }

    public final Throwable I(o1 o1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (o1Var.e()) {
                return new i1(D(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i9);
            i9++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof a2) {
            int size2 = arrayList.size();
            while (true) {
                if (i8 >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i8);
                i8++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof a2)) {
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

    public boolean J() {
        return true;
    }

    public boolean K() {
        return this instanceof s;
    }

    public final q1 L(e1 e1Var) {
        q1 q1VarD = e1Var.d();
        if (q1VarD != null) {
            return q1VarD;
        }
        if (e1Var instanceof u0) {
            return new q1();
        }
        if (e1Var instanceof l1) {
            a0((l1) e1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + e1Var).toString());
    }

    public boolean M(Throwable th) {
        return false;
    }

    public final void O(h1 h1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f207b;
        s1 s1Var = s1.f213a;
        if (h1Var == null) {
            atomicReferenceFieldUpdater.set(this, s1Var);
            return;
        }
        h1Var.start();
        p pVarL = h1Var.l(this);
        atomicReferenceFieldUpdater.set(this, pVarL);
        if (Q()) {
            pVarL.b();
            atomicReferenceFieldUpdater.set(this, s1Var);
        }
    }

    public final s0 P(boolean z, l1 l1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        s1 s1Var;
        boolean z2;
        boolean zE;
        l1Var.d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f206a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z8 = obj instanceof u0;
            s1Var = s1.f213a;
            z2 = true;
            if (!z8) {
                if (!(obj instanceof e1)) {
                    z2 = false;
                    break;
                }
                e1 e1Var = (e1) obj;
                q1 q1VarD = e1Var.d();
                if (q1VarD == null) {
                    a0((l1) obj);
                } else {
                    if (l1Var.k()) {
                        o1 o1Var = e1Var instanceof o1 ? (o1) e1Var : null;
                        Throwable thC = o1Var != null ? o1Var.c() : null;
                        if (thC == null) {
                            zE = q1VarD.e(l1Var, 5);
                        } else if (z) {
                            l1Var.l(thC);
                            return s1Var;
                        }
                    } else {
                        zE = q1VarD.e(l1Var, 1);
                    }
                    if (zE) {
                        break;
                    }
                }
            } else {
                u0 u0Var = (u0) obj;
                if (u0Var.f220a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, l1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                Z(u0Var);
            }
        }
        if (z2) {
            return l1Var;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            v vVar = obj2 instanceof v ? (v) obj2 : null;
            l1Var.l(vVar != null ? vVar.f222a : null);
        }
        return s1Var;
    }

    public final boolean Q() {
        return !(f206a.get(this) instanceof e1);
    }

    public boolean R() {
        return this instanceof g;
    }

    public final boolean S(Object obj) {
        Object objD0;
        do {
            objD0 = d0(f206a.get(this), obj);
            if (objD0 == i0.d) {
                return false;
            }
            if (objD0 == i0.f175e) {
                return true;
            }
        } while (objD0 == i0.f176f);
        q(objD0);
        return true;
    }

    public final Object T(Object obj) {
        Object objD0;
        do {
            objD0 = d0(f206a.get(this), obj);
            if (objD0 == i0.d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                v vVar = obj instanceof v ? (v) obj : null;
                throw new IllegalStateException(str, vVar != null ? vVar.f222a : null);
            }
        } while (objD0 == i0.f176f);
        return objD0;
    }

    public String U() {
        return getClass().getSimpleName();
    }

    public final void W(q1 q1Var, Throwable th) {
        q1Var.e(new f6.g(4), 4);
        Object obj = f6.i.f2646a.get(q1Var);
        kotlin.jvm.internal.p.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        w wVar = null;
        for (f6.i iVarH = (f6.i) obj; !iVarH.equals(q1Var); iVarH = iVarH.h()) {
            if ((iVarH instanceof l1) && ((l1) iVarH).k()) {
                try {
                    ((l1) iVarH).l(th);
                } catch (Throwable th2) {
                    if (wVar != null) {
                        a.a.a(wVar, th2);
                    } else {
                        wVar = new w("Exception in completion handler " + iVarH + " for " + this, th2);
                    }
                }
            }
        }
        if (wVar != null) {
            N(wVar);
        }
        B(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [a6.d1] */
    public final void Z(u0 u0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1 q1Var = new q1();
        if (!u0Var.f220a) {
            q1Var = new d1(q1Var);
        }
        do {
            atomicReferenceFieldUpdater = f206a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, u0Var, q1Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == u0Var);
    }

    @Override // a6.h1
    public boolean a() {
        Object obj = f206a.get(this);
        return (obj instanceof e1) && ((e1) obj).a();
    }

    public final void a0(l1 l1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1 q1Var = new q1();
        l1Var.getClass();
        f6.i.f2647b.set(q1Var, l1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6.i.f2646a;
        atomicReferenceFieldUpdater2.set(q1Var, l1Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(l1Var) == l1Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(l1Var, l1Var, q1Var)) {
                    if (atomicReferenceFieldUpdater2.get(l1Var) != l1Var) {
                        break;
                    }
                }
                q1Var.g(l1Var);
                break loop0;
            }
            break;
        }
        f6.i iVarH = l1Var.h();
        do {
            atomicReferenceFieldUpdater = f206a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, l1Var, iVarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == l1Var);
    }

    public final int b0(Object obj) {
        boolean z = obj instanceof u0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f206a;
        if (z) {
            if (((u0) obj).f220a) {
                return 0;
            }
            u0 u0Var = i0.f180j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, u0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof d1)) {
            return 0;
        }
        q1 q1Var = ((d1) obj).f149a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    public final Object d0(Object obj, Object obj2) {
        if (!(obj instanceof e1)) {
            return i0.d;
        }
        if (((obj instanceof u0) || (obj instanceof l1)) && !(obj instanceof q) && !(obj2 instanceof v)) {
            e1 e1Var = (e1) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f206a;
            Object f1Var = obj2 instanceof e1 ? new f1((e1) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, e1Var, f1Var)) {
                if (atomicReferenceFieldUpdater.get(this) != e1Var) {
                    return i0.f176f;
                }
            }
            X(obj2);
            F(e1Var, obj2);
            return obj2;
        }
        e1 e1Var2 = (e1) obj;
        q1 q1VarL = L(e1Var2);
        if (q1VarL == null) {
            return i0.f176f;
        }
        o1 o1Var = e1Var2 instanceof o1 ? (o1) e1Var2 : null;
        if (o1Var == null) {
            o1Var = new o1(q1VarL, null);
        }
        synchronized (o1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o1.f202b;
            if (atomicIntegerFieldUpdater.get(o1Var) == 1) {
                return i0.d;
            }
            atomicIntegerFieldUpdater.set(o1Var, 1);
            if (o1Var != e1Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f206a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, e1Var2, o1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != e1Var2) {
                        return i0.f176f;
                    }
                }
            }
            boolean zE = o1Var.e();
            v vVar = obj2 instanceof v ? (v) obj2 : null;
            if (vVar != null) {
                o1Var.b(vVar.f222a);
            }
            Throwable thC = zE ? null : o1Var.c();
            if (thC != null) {
                W(q1VarL, thC);
            }
            q qVarV = V(q1VarL);
            if (qVarV != null && e0(o1Var, qVarV, obj2)) {
                return i0.f175e;
            }
            q1VarL.e(new f6.g(2), 2);
            q qVarV2 = V(q1VarL);
            return (qVarV2 == null || !e0(o1Var, qVarV2, obj2)) ? H(o1Var, obj2) : i0.f175e;
        }
    }

    @Override // a6.h1
    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new i1(D(), null, this);
        }
        y(cancellationException);
    }

    public final boolean e0(o1 o1Var, q qVar, Object obj) {
        while (i0.o(qVar.f208e, false, new n1(this, o1Var, qVar, obj)) == s1.f213a) {
            qVar = V(qVar);
            if (qVar == null) {
                return false;
            }
        }
        return true;
    }

    public Object g() throws Throwable {
        Object obj = f206a.get(this);
        if (obj instanceof e1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof v) {
            throw ((v) obj).f222a;
        }
        return i0.y(obj);
    }

    @Override // f5.f
    public final f5.g getKey() {
        return c0.f143b;
    }

    @Override // a6.h1
    public final boolean isCancelled() {
        Object obj = f206a.get(this);
        if (obj instanceof v) {
            return true;
        }
        return (obj instanceof o1) && ((o1) obj).e();
    }

    @Override // a6.h1
    public final Object j(h5.c cVar) {
        Object obj;
        b5.a0 a0Var;
        do {
            obj = f206a.get(this);
            boolean z = obj instanceof e1;
            a0Var = b5.a0.f883a;
            if (!z) {
                i0.h(cVar.getContext());
                return a0Var;
            }
        } while (b0(obj) < 0);
        m mVar = new m(1, b8.h.u(cVar));
        mVar.t();
        mVar.w(new i(1, i0.o(this, true, new o(mVar, 1))));
        Object objS = mVar.s();
        g5.a aVar = g5.a.f2984a;
        if (objS != aVar) {
            objS = a0Var;
        }
        return objS == aVar ? objS : a0Var;
    }

    @Override // a6.h1
    public final p l(p1 p1Var) {
        q qVar = new q(p1Var);
        qVar.d = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f206a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof u0) {
                u0 u0Var = (u0) obj;
                if (u0Var.f220a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, qVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                Z(u0Var);
            } else {
                boolean z = obj instanceof e1;
                s1 s1Var = s1.f213a;
                if (!z) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    v vVar = obj2 instanceof v ? (v) obj2 : null;
                    qVar.l(vVar != null ? vVar.f222a : null);
                    return s1Var;
                }
                q1 q1VarD = ((e1) obj).d();
                if (q1VarD == null) {
                    a0((l1) obj);
                } else if (!q1VarD.e(qVar, 7)) {
                    boolean zE = q1VarD.e(qVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof o1) {
                        thC = ((o1) obj3).c();
                    } else {
                        v vVar2 = obj3 instanceof v ? (v) obj3 : null;
                        if (vVar2 != null) {
                            thC = vVar2.f222a;
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

    @Override // a6.h1
    public final s0 n(boolean z, boolean z2, p5.l lVar) {
        return P(z2, z ? new g1(lVar) : new t0(1, lVar));
    }

    @Override // f5.h
    public final f5.f o(f5.g gVar) {
        return b8.h.o(this, gVar);
    }

    public void r(Object obj) {
        q(obj);
    }

    @Override // f5.h
    public final f5.h s(f5.g gVar) {
        return b8.h.y(this, gVar);
    }

    @Override // a6.h1
    public final boolean start() {
        int iB0;
        do {
            iB0 = b0(f206a.get(this));
            if (iB0 == 0) {
                return false;
            }
        } while (iB0 != 1);
        return true;
    }

    @Override // f5.h
    public final f5.h t(f5.h hVar) {
        return b8.h.I(this, hVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(U() + AbstractJsonLexerKt.BEGIN_OBJ + c0(f206a.get(this)) + AbstractJsonLexerKt.END_OBJ);
        sb.append('@');
        sb.append(i0.k(this));
        return sb.toString();
    }

    @Override // a6.h1
    public final CancellationException v() {
        CancellationException cancellationException;
        Object obj = f206a.get(this);
        if (!(obj instanceof o1)) {
            if (obj instanceof e1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof v)) {
                return new i1(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((v) obj).f222a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new i1(D(), th, this) : cancellationException;
        }
        Throwable thC = ((o1) obj).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = D();
        }
        return new i1(strConcat, thC, this);
    }

    public final Object w(f5.c cVar) {
        Object obj;
        do {
            obj = f206a.get(this);
            if (!(obj instanceof e1)) {
                if (obj instanceof v) {
                    throw ((v) obj).f222a;
                }
                return i0.y(obj);
            }
        } while (b0(obj) < 0);
        m1 m1Var = new m1(b8.h.u(cVar), this);
        m1Var.t();
        m1Var.w(new i(1, i0.o(this, true, new t0(2, m1Var))));
        Object objS = m1Var.s();
        g5.a aVar = g5.a.f2984a;
        return objS;
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
    public final boolean x(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.p1.x(java.lang.Object):boolean");
    }

    public void y(CancellationException cancellationException) {
        x(cancellationException);
    }

    @Override // f5.h
    public final Object z(Object obj, p5.p pVar) {
        return pVar.invoke(obj, this);
    }

    public void Y() {
    }

    public void N(w wVar) {
        throw wVar;
    }

    public void X(Object obj) {
    }

    public void q(Object obj) {
    }
}
