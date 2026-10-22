package kotlinx.coroutines;

import C7.r;
import D7.t;
import H7.f;
import H7.h;
import S7.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;
import m9.AbstractC1683A;
import m9.C1694L;
import m9.C1695M;
import m9.C1705X;
import m9.C1707Z;
import m9.C1713f;
import m9.C1715h;
import m9.C1718k;
import m9.C1720m;
import m9.C1722o;
import m9.C1724q;
import m9.C1727t;
import m9.InterfaceC1693K;
import m9.InterfaceC1706Y;
import m9.InterfaceC1721n;
import m9.a0;
import m9.b0;
import m9.c0;
import m9.e0;
import m9.f0;
import m9.g0;
import m9.h0;
import m9.l0;
import m9.n0;
import m9.p0;
import s9.g;
import u1.d;
import z2.l;

/* loaded from: classes4.dex */
public class c implements c0, p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5183a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public c(boolean z10) {
        this._state$volatile = z10 ? AbstractC1683A.f5312j : AbstractC1683A.i;
    }

    public static C1722o X(kotlinx.coroutines.internal.a aVar) {
        while (aVar.g()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.internal.a.b;
            kotlinx.coroutines.internal.a aVarD = aVar.d();
            if (aVarD == null) {
                Object obj = atomicReferenceFieldUpdater.get(aVar);
                while (true) {
                    aVar = (kotlinx.coroutines.internal.a) obj;
                    if (!aVar.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(aVar);
                }
            } else {
                aVar = aVarD;
            }
        }
        while (true) {
            aVar = aVar.f();
            if (!aVar.g()) {
                if (aVar instanceof C1722o) {
                    return (C1722o) aVar;
                }
                if (aVar instanceof l0) {
                    return null;
                }
            }
        }
    }

    public static String d0(Object obj) {
        if (!(obj instanceof h0)) {
            return obj instanceof InterfaceC1706Y ? ((InterfaceC1706Y) obj).isActive() ? "Active" : "New" : obj instanceof C1727t ? "Cancelled" : "Completed";
        }
        h0 h0Var = (h0) obj;
        return h0Var.d() ? "Cancelling" : h0.b.get(h0Var) != 0 ? "Completing" : "Active";
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[PHI: r0
      0x0041: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v10 java.lang.Object) binds: [B:3:0x0008, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.c.A(java.lang.Object):boolean");
    }

    public void B(CancellationException cancellationException) {
        A(cancellationException);
    }

    public final boolean C(Throwable th) {
        if (T()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        InterfaceC1721n interfaceC1721n = (InterfaceC1721n) b.get(this);
        return (interfaceC1721n == null || interfaceC1721n == n0.f5331a) ? z10 : interfaceC1721n.a(th) || z10;
    }

    public String D() {
        return "Job was cancelled";
    }

    public boolean E(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return A(th) && L();
    }

    public final void F(InterfaceC1706Y interfaceC1706Y, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        InterfaceC1721n interfaceC1721n = (InterfaceC1721n) atomicReferenceFieldUpdater.get(this);
        if (interfaceC1721n != null) {
            interfaceC1721n.dispose();
            atomicReferenceFieldUpdater.set(this, n0.f5331a);
        }
        CompletionHandlerException completionHandlerException = null;
        C1727t c1727t = obj instanceof C1727t ? (C1727t) obj : null;
        Throwable th = c1727t != null ? c1727t.f5333a : null;
        if (interfaceC1706Y instanceof e0) {
            try {
                ((e0) interfaceC1706Y).j(th);
                return;
            } catch (Throwable th2) {
                Q(new CompletionHandlerException("Exception in completion handler " + interfaceC1706Y + " for " + this, th2));
                return;
            }
        }
        l0 l0VarB = interfaceC1706Y.b();
        if (l0VarB != null) {
            l0VarB.c(new g(1), 1);
            Object obj2 = kotlinx.coroutines.internal.a.f5251a.get(l0VarB);
            k.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (kotlinx.coroutines.internal.a aVarF = (kotlinx.coroutines.internal.a) obj2; !aVarF.equals(l0VarB); aVarF = aVarF.f()) {
                if (aVarF instanceof e0) {
                    try {
                        ((e0) aVarF).j(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            S0.b.e0(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + aVarF + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                Q(completionHandlerException);
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
        c cVar = (c) ((p0) obj);
        Object obj2 = f5183a.get(cVar);
        if (obj2 instanceof h0) {
            cancellationExceptionC = ((h0) obj2).c();
        } else if (obj2 instanceof C1727t) {
            cancellationExceptionC = ((C1727t) obj2).f5333a;
        } else {
            if (obj2 instanceof InterfaceC1706Y) {
                throw new IllegalStateException(androidx.compose.foundation.b.r(obj2, "Cannot be cancelling child in this state: "));
            }
            cancellationExceptionC = null;
        }
        CancellationException cancellationException = cancellationExceptionC instanceof CancellationException ? cancellationExceptionC : null;
        return cancellationException == null ? new JobCancellationException("Parent job is ".concat(d0(obj2)), cancellationExceptionC, cVar) : cancellationException;
    }

    public final Object H(h0 h0Var, Object obj) {
        Throwable thK;
        C1727t c1727t = obj instanceof C1727t ? (C1727t) obj : null;
        Throwable th = c1727t != null ? c1727t.f5333a : null;
        synchronized (h0Var) {
            h0Var.d();
            ArrayList<Throwable> arrayListE = h0Var.e(th);
            thK = K(h0Var, arrayListE);
            if (thK != null && arrayListE.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListE.size()));
                for (Throwable th2 : arrayListE) {
                    if (th2 != thK && th2 != thK && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        S0.b.e0(thK, th2);
                    }
                }
            }
        }
        if (thK != null && thK != th) {
            obj = new C1727t(thK, false);
        }
        if (thK != null && (C(thK) || P(thK))) {
            k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C1727t.b.compareAndSet((C1727t) obj, 0, 1);
        }
        Z(obj);
        f5183a.compareAndSet(this, h0Var, obj instanceof InterfaceC1706Y ? new C1707Z((InterfaceC1706Y) obj) : obj);
        F(h0Var, obj);
        return obj;
    }

    public final t I() {
        return new t(new JobSupport$children$1(null, this));
    }

    public final Object J() throws Throwable {
        Object obj = f5183a.get(this);
        if (obj instanceof InterfaceC1706Y) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof C1727t) {
            throw ((C1727t) obj).f5333a;
        }
        return AbstractC1683A.u(obj);
    }

    public final Throwable K(h0 h0Var, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (h0Var.d()) {
                return new JobCancellationException(D(), null, this);
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
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
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

    public boolean L() {
        return true;
    }

    public final d M() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.f5179a;
        k.d(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        p.e(3, jobSupport$onAwaitInternal$1);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.f5180a;
        k.d(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        p.e(3, jobSupport$onAwaitInternal$2);
        return new d(this, jobSupport$onAwaitInternal$1, jobSupport$onAwaitInternal$2, null, 21);
    }

    public boolean N() {
        return this instanceof C1724q;
    }

    public final l0 O(InterfaceC1706Y interfaceC1706Y) {
        l0 l0VarB = interfaceC1706Y.b();
        if (l0VarB != null) {
            return l0VarB;
        }
        if (interfaceC1706Y instanceof C1695M) {
            return new l0();
        }
        if (interfaceC1706Y instanceof e0) {
            b0((e0) interfaceC1706Y);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC1706Y).toString());
    }

    public boolean P(Throwable th) {
        return false;
    }

    public void Q(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }

    public final void R(c0 c0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        n0 n0Var = n0.f5331a;
        if (c0Var == null) {
            atomicReferenceFieldUpdater.set(this, n0Var);
            return;
        }
        c0Var.start();
        InterfaceC1721n interfaceC1721nK = c0Var.k(this);
        atomicReferenceFieldUpdater.set(this, interfaceC1721nK);
        if (r()) {
            interfaceC1721nK.dispose();
            atomicReferenceFieldUpdater.set(this, n0Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [m9.X] */
    public final InterfaceC1693K S(boolean z10, e0 e0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        n0 n0Var;
        boolean z11;
        boolean zC;
        e0Var.d = this;
        while (true) {
            atomicReferenceFieldUpdater = f5183a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z12 = obj instanceof C1695M;
            n0Var = n0.f5331a;
            z11 = true;
            if (!z12) {
                if (!(obj instanceof InterfaceC1706Y)) {
                    z11 = false;
                    break;
                }
                InterfaceC1706Y interfaceC1706Y = (InterfaceC1706Y) obj;
                l0 l0VarB = interfaceC1706Y.b();
                if (l0VarB == null) {
                    k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    b0((e0) obj);
                } else {
                    if (e0Var.i()) {
                        h0 h0Var = interfaceC1706Y instanceof h0 ? (h0) interfaceC1706Y : null;
                        Throwable thC = h0Var != null ? h0Var.c() : null;
                        if (thC == null) {
                            zC = l0VarB.c(e0Var, 5);
                        } else if (z10) {
                            e0Var.j(thC);
                            return n0Var;
                        }
                    } else {
                        zC = l0VarB.c(e0Var, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                C1695M c1695m = (C1695M) obj;
                if (!c1695m.f5317a) {
                    l0 l0Var = new l0();
                    if (!c1695m.f5317a) {
                        l0Var = new C1705X(l0Var);
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, c1695m, l0Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, e0Var)) {
                    break;
                }
            }
        }
        if (z11) {
            return e0Var;
        }
        if (z10) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            C1727t c1727t = obj2 instanceof C1727t ? (C1727t) obj2 : null;
            e0Var.j(c1727t != null ? c1727t.f5333a : null);
        }
        return n0Var;
    }

    public boolean T() {
        return this instanceof C1713f;
    }

    public final boolean U(Object obj) {
        Object objE0;
        do {
            objE0 = e0(f5183a.get(this), obj);
            if (objE0 == AbstractC1683A.d) {
                return false;
            }
            if (objE0 == AbstractC1683A.e) {
                return true;
            }
        } while (objE0 == AbstractC1683A.f);
        x(objE0);
        return true;
    }

    public final Object V(Object obj) {
        Object objE0;
        do {
            objE0 = e0(f5183a.get(this), obj);
            if (objE0 == AbstractC1683A.d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C1727t c1727t = obj instanceof C1727t ? (C1727t) obj : null;
                throw new IllegalStateException(str, c1727t != null ? c1727t.f5333a : null);
            }
        } while (objE0 == AbstractC1683A.f);
        return objE0;
    }

    public String W() {
        return getClass().getSimpleName();
    }

    public final void Y(l0 l0Var, Throwable th) {
        l0Var.c(new g(4), 4);
        Object obj = kotlinx.coroutines.internal.a.f5251a.get(l0Var);
        k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.a aVarF = (kotlinx.coroutines.internal.a) obj; !aVarF.equals(l0Var); aVarF = aVarF.f()) {
            if ((aVarF instanceof e0) && ((e0) aVarF).i()) {
                try {
                    ((e0) aVarF).j(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        S0.b.e0(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + aVarF + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Q(completionHandlerException);
        }
        C(th);
    }

    public void Z(Object obj) {
    }

    public void a0() {
    }

    public final void b0(e0 e0Var) {
        l0 l0Var = new l0();
        e0Var.getClass();
        kotlinx.coroutines.internal.a.b.set(l0Var, e0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.internal.a.f5251a;
        atomicReferenceFieldUpdater.set(l0Var, e0Var);
        while (true) {
            if (atomicReferenceFieldUpdater.get(e0Var) != e0Var) {
                break;
            } else if (atomicReferenceFieldUpdater.compareAndSet(e0Var, e0Var, l0Var)) {
                l0Var.e(e0Var);
                break;
            }
        }
        f5183a.compareAndSet(this, e0Var, e0Var.f());
    }

    public Object c() {
        return J();
    }

    public final int c0(Object obj) {
        boolean z10 = obj instanceof C1695M;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5183a;
        if (z10) {
            if (((C1695M) obj).f5317a) {
                return 0;
            }
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, AbstractC1683A.f5312j)) {
                return -1;
            }
            a0();
            return 1;
        }
        if (!(obj instanceof C1705X)) {
            return 0;
        }
        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, ((C1705X) obj).f5322a)) {
            return -1;
        }
        a0();
        return 1;
    }

    @Override // m9.c0
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(D(), null, this);
        }
        B(cancellationException);
    }

    public final Object e0(Object obj, Object obj2) {
        if (!(obj instanceof InterfaceC1706Y)) {
            return AbstractC1683A.d;
        }
        if (((obj instanceof C1695M) || (obj instanceof e0)) && !(obj instanceof C1722o) && !(obj2 instanceof C1727t)) {
            InterfaceC1706Y interfaceC1706Y = (InterfaceC1706Y) obj;
            if (!f5183a.compareAndSet(this, interfaceC1706Y, obj2 instanceof InterfaceC1706Y ? new C1707Z((InterfaceC1706Y) obj2) : obj2)) {
                return AbstractC1683A.f;
            }
            Z(obj2);
            F(interfaceC1706Y, obj2);
            return obj2;
        }
        InterfaceC1706Y interfaceC1706Y2 = (InterfaceC1706Y) obj;
        l0 l0VarO = O(interfaceC1706Y2);
        if (l0VarO == null) {
            return AbstractC1683A.f;
        }
        h0 h0Var = interfaceC1706Y2 instanceof h0 ? (h0) interfaceC1706Y2 : null;
        if (h0Var == null) {
            h0Var = new h0(l0VarO, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (h0Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h0.b;
            if (atomicIntegerFieldUpdater.get(h0Var) != 0) {
                return AbstractC1683A.d;
            }
            atomicIntegerFieldUpdater.set(h0Var, 1);
            if (h0Var != interfaceC1706Y2 && !f5183a.compareAndSet(this, interfaceC1706Y2, h0Var)) {
                return AbstractC1683A.f;
            }
            boolean zD = h0Var.d();
            C1727t c1727t = obj2 instanceof C1727t ? (C1727t) obj2 : null;
            if (c1727t != null) {
                h0Var.a(c1727t.f5333a);
            }
            Throwable thC = zD ? null : h0Var.c();
            ref$ObjectRef.f4920a = thC;
            if (thC != null) {
                Y(l0VarO, thC);
            }
            C1722o c1722oX = X(l0VarO);
            if (c1722oX != null && f0(h0Var, c1722oX, obj2)) {
                return AbstractC1683A.e;
            }
            l0VarO.c(new g(2), 2);
            C1722o c1722oX2 = X(l0VarO);
            return (c1722oX2 == null || !f0(h0Var, c1722oX2, obj2)) ? H(h0Var, obj2) : AbstractC1683A.e;
        }
    }

    public final boolean f0(h0 h0Var, C1722o c1722o, Object obj) {
        while (a.j(c1722o.e, false, new g0(this, h0Var, c1722o, obj)) == n0.f5331a) {
            c1722o = X(c1722o);
            if (c1722o == null) {
                return false;
            }
        }
        return true;
    }

    @Override // H7.h
    public final Object fold(Object obj, n nVar) {
        return nVar.invoke(obj, this);
    }

    @Override // m9.c0
    public final Object g(ContinuationImpl continuationImpl) {
        Object obj;
        r rVar;
        do {
            obj = f5183a.get(this);
            boolean z10 = obj instanceof InterfaceC1706Y;
            rVar = r.f317a;
            if (!z10) {
                a.g(continuationImpl.getContext());
                return rVar;
            }
        } while (c0(obj) < 0);
        C1718k c1718k = new C1718k(1, U7.a.I(continuationImpl));
        c1718k.y();
        c1718k.A(new C1715h(a.j(this, true, new C1720m(c1718k, 1)), 2));
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (objX != coroutineSingletons) {
            objX = rVar;
        }
        return objX == coroutineSingletons ? objX : rVar;
    }

    @Override // H7.h
    public final f get(H7.g gVar) {
        return l.x(this, gVar);
    }

    @Override // H7.f
    public final H7.g getKey() {
        return b0.f5325a;
    }

    @Override // m9.c0
    public final CancellationException i() {
        CancellationException cancellationException;
        Object obj = f5183a.get(this);
        if (!(obj instanceof h0)) {
            if (obj instanceof InterfaceC1706Y) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof C1727t)) {
                return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C1727t) obj).f5333a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new JobCancellationException(D(), th, this) : cancellationException;
        }
        Throwable thC = ((h0) obj).c();
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
        return new JobCancellationException(strConcat, thC, this);
    }

    @Override // m9.c0
    public boolean isActive() {
        Object obj = f5183a.get(this);
        return (obj instanceof InterfaceC1706Y) && ((InterfaceC1706Y) obj).isActive();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [m9.X] */
    @Override // m9.c0
    public final InterfaceC1721n k(c cVar) {
        C1722o c1722o = new C1722o(cVar);
        c1722o.d = this;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5183a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C1695M) {
                C1695M c1695m = (C1695M) obj;
                if (!c1695m.f5317a) {
                    l0 l0Var = new l0();
                    if (!c1695m.f5317a) {
                        l0Var = new C1705X(l0Var);
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, c1695m, l0Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c1722o)) {
                    break;
                }
            } else {
                boolean z10 = obj instanceof InterfaceC1706Y;
                n0 n0Var = n0.f5331a;
                if (!z10) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    C1727t c1727t = obj2 instanceof C1727t ? (C1727t) obj2 : null;
                    c1722o.j(c1727t != null ? c1727t.f5333a : null);
                    return n0Var;
                }
                l0 l0VarB = ((InterfaceC1706Y) obj).b();
                if (l0VarB == null) {
                    k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    b0((e0) obj);
                } else if (!l0VarB.c(c1722o, 7)) {
                    boolean zC = l0VarB.c(c1722o, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof h0) {
                        thC = ((h0) obj3).c();
                    } else {
                        C1727t c1727t2 = obj3 instanceof C1727t ? (C1727t) obj3 : null;
                        if (c1727t2 != null) {
                            thC = c1727t2.f5333a;
                        }
                    }
                    c1722o.j(thC);
                    if (zC) {
                        break;
                    }
                    return n0Var;
                }
            }
        }
        return c1722o;
    }

    @Override // H7.h
    public final h minusKey(H7.g gVar) {
        return l.C(this, gVar);
    }

    @Override // m9.c0
    public final InterfaceC1693K n(boolean z10, boolean z11, S7.k kVar) {
        return S(z11, z10 ? new a0(kVar) : new C1694L(kVar, 1));
    }

    @Override // H7.h
    public final h plus(h hVar) {
        return l.H(this, hVar);
    }

    @Override // m9.c0
    public final boolean r() {
        return !(f5183a.get(this) instanceof InterfaceC1706Y);
    }

    @Override // m9.c0
    public final boolean start() {
        int iC0;
        do {
            iC0 = c0(f5183a.get(this));
            if (iC0 == 0) {
                return false;
            }
        } while (iC0 != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(W() + '{' + d0(f5183a.get(this)) + '}');
        sb.append('@');
        sb.append(AbstractC1683A.i(this));
        return sb.toString();
    }

    @Override // m9.c0
    public final InterfaceC1693K w(S7.k kVar) {
        return S(true, new C1694L(kVar, 1));
    }

    public void x(Object obj) {
    }

    public void y(Object obj) {
        x(obj);
    }

    public final Object z(H7.c cVar) {
        Object obj;
        do {
            obj = f5183a.get(this);
            if (!(obj instanceof InterfaceC1706Y)) {
                if (obj instanceof C1727t) {
                    throw ((C1727t) obj).f5333a;
                }
                return AbstractC1683A.u(obj);
            }
        } while (c0(obj) < 0);
        f0 f0Var = new f0(U7.a.I(cVar), this);
        f0Var.y();
        int i = 2;
        f0Var.A(new C1715h(a.j(this, true, new C1694L(f0Var, i)), i));
        Object objX = f0Var.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }
}
