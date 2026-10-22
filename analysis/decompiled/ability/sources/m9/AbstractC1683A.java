package m9;

import ca.AbstractC0897f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineStart;
import s9.AbstractC1921a;
import s9.C1923c;
import s9.C1925e;

/* renamed from: m9.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1683A {

    /* renamed from: a, reason: collision with root package name */
    public static final a5.d f5311a;
    public static final a5.d b;
    public static final a5.d c;
    public static final a5.d d;
    public static final a5.d e;
    public static final a5.d f;
    public static final a5.d g;
    public static final a5.d h;
    public static final C1695M i = new C1695M(false);

    /* renamed from: j, reason: collision with root package name */
    public static final C1695M f5312j = new C1695M(true);

    static {
        int i6 = 6;
        f5311a = new a5.d("RESUME_TOKEN", i6);
        b = new a5.d("REMOVED_TASK", i6);
        c = new a5.d("CLOSED_EMPTY", i6);
        d = new a5.d("COMPLETING_ALREADY", i6);
        e = new a5.d("COMPLETING_WAITING_CHILDREN", i6);
        f = new a5.d("COMPLETING_RETRY", i6);
        g = new a5.d("TOO_LATE_TO_CANCEL", i6);
        h = new a5.d("SEALED", i6);
    }

    public static C1724q a() {
        return new C1724q();
    }

    public static final C1923c b(H7.h hVar) {
        if (hVar.get(b0.f5325a) == null) {
            hVar = hVar.plus(kotlinx.coroutines.a.a());
        }
        return new C1923c(hVar);
    }

    public static r0 c() {
        return new r0(null);
    }

    public static C1687E d(InterfaceC1733z interfaceC1733z, H7.h hVar, S7.n nVar, int i6) {
        CoroutineStart coroutineStart = CoroutineStart.d;
        if ((i6 & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        if ((i6 & 2) != 0) {
            coroutineStart = CoroutineStart.f5175a;
        }
        H7.h hVarO = o(interfaceC1733z, hVar);
        C1687E j0Var = coroutineStart == CoroutineStart.b ? new j0(hVarO, nVar) : new C1687E(hVarO, true);
        j0Var.i0(coroutineStart, j0Var, nVar);
        return j0Var;
    }

    public static final void e(InterfaceC1733z interfaceC1733z, CancellationException cancellationException) {
        c0 c0Var = (c0) interfaceC1733z.getCoroutineContext().get(b0.f5325a);
        if (c0Var != null) {
            c0Var.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + interfaceC1733z).toString());
        }
    }

    public static final Object f(S7.n nVar, H7.c cVar) {
        s9.o oVar = new s9.o(cVar.getContext(), cVar);
        Object objM = AbstractC0897f.M(oVar, oVar, nVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objM;
    }

    public static final H7.h g(H7.h hVar, H7.h hVar2, boolean z10) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.fold(bool, new com.stepos.core.a(10))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.fold(bool, new com.stepos.core.a(10))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.plus(hVar2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = hVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f4908a;
        H7.h hVar3 = (H7.h) hVar.fold(emptyCoroutineContext, new com.stepos.core.a(11));
        if (zBooleanValue2) {
            ref$ObjectRef.f4920a = ((H7.h) ref$ObjectRef.f4920a).fold(emptyCoroutineContext, new com.stepos.core.a(12));
        }
        return hVar3.plus((H7.h) ref$ObjectRef.f4920a);
    }

    public static final AbstractC1729v h(Executor executor) {
        AbstractC1729v abstractC1729v;
        ExecutorC1690H executorC1690H = executor instanceof ExecutorC1690H ? (ExecutorC1690H) executor : null;
        return (executorC1690H == null || (abstractC1729v = executorC1690H.f5314a) == null) ? new C1703V(executor) : abstractC1729v;
    }

    public static final String i(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r0 = m9.C1718k.g;
        r1 = r0.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if ((r1 instanceof m9.C1726s) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (((m9.C1726s) r1).d == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r3.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        m9.C1718k.f.set(r3, 536870911);
        r0.set(r3, m9.C1709b.f5324a);
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r4 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        return new m9.C1718k(2, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final m9.C1718k j(H7.c r6) {
        /*
            boolean r0 = r6 instanceof s9.C1925e
            if (r0 != 0) goto Lb
            m9.k r0 = new m9.k
            r1 = 1
            r0.<init>(r1, r6)
            return r0
        Lb:
            r0 = r6
            s9.e r0 = (s9.C1925e) r0
            a5.d r1 = s9.AbstractC1921a.c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = s9.C1925e.h
        L12:
            java.lang.Object r3 = r2.get(r0)
            r4 = 0
            if (r3 != 0) goto L1e
            r2.set(r0, r1)
            r3 = r4
            goto L2a
        L1e:
            boolean r5 = r3 instanceof m9.C1718k
            if (r5 == 0) goto L59
            boolean r5 = r2.compareAndSet(r0, r3, r1)
            if (r5 == 0) goto L12
            m9.k r3 = (m9.C1718k) r3
        L2a:
            if (r3 == 0) goto L52
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.C1718k.g
            java.lang.Object r1 = r0.get(r3)
            boolean r2 = r1 instanceof m9.C1726s
            if (r2 == 0) goto L40
            m9.s r1 = (m9.C1726s) r1
            java.lang.Object r1 = r1.d
            if (r1 == 0) goto L40
            r3.t()
            goto L4e
        L40:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = m9.C1718k.f
            r2 = 536870911(0x1fffffff, float:1.0842021E-19)
            r1.set(r3, r2)
            m9.b r1 = m9.C1709b.f5324a
            r0.set(r3, r1)
            r4 = r3
        L4e:
            if (r4 != 0) goto L51
            goto L52
        L51:
            return r4
        L52:
            m9.k r0 = new m9.k
            r1 = 2
            r0.<init>(r1, r6)
            return r0
        L59:
            if (r3 == r1) goto L12
            boolean r4 = r3 instanceof java.lang.Throwable
            if (r4 == 0) goto L60
            goto L12
        L60:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Inconsistent state "
            java.lang.String r0 = androidx.compose.foundation.b.r(r3, r0)
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.AbstractC1683A.j(H7.c):m9.k");
    }

    public static final void k(H7.h hVar, Throwable th) {
        try {
            InterfaceC1731x interfaceC1731x = (InterfaceC1731x) hVar.get(C1730w.f5337a);
            if (interfaceC1731x != null) {
                interfaceC1731x.handleException(hVar, th);
            } else {
                AbstractC1921a.d(hVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                S0.b.e0(runtimeException, th);
                th = runtimeException;
            }
            AbstractC1921a.d(hVar, th);
        }
    }

    public static final boolean l(InterfaceC1733z interfaceC1733z) {
        c0 c0Var = (c0) interfaceC1733z.getCoroutineContext().get(b0.f5325a);
        if (c0Var != null) {
            return c0Var.isActive();
        }
        return true;
    }

    public static final q0 m(InterfaceC1733z interfaceC1733z, H7.h hVar, CoroutineStart coroutineStart, S7.n nVar) {
        H7.h hVarO = o(interfaceC1733z, hVar);
        coroutineStart.getClass();
        q0 k0Var = coroutineStart == CoroutineStart.b ? new k0(hVarO, nVar) : new q0(hVarO, true);
        k0Var.i0(coroutineStart, k0Var, nVar);
        return k0Var;
    }

    public static /* synthetic */ q0 n(InterfaceC1733z interfaceC1733z, H7.h hVar, S7.n nVar, int i6) {
        CoroutineStart coroutineStart = CoroutineStart.d;
        if ((i6 & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        if ((i6 & 2) != 0) {
            coroutineStart = CoroutineStart.f5175a;
        }
        return m(interfaceC1733z, hVar, coroutineStart, nVar);
    }

    public static final H7.h o(InterfaceC1733z interfaceC1733z, H7.h hVar) {
        H7.h hVarG = g(interfaceC1733z.getCoroutineContext(), hVar, true);
        u9.d dVar = AbstractC1691I.f5315a;
        return (hVarG == dVar || hVarG.get(H7.d.f758a) != null) ? hVarG : hVarG.plus(dVar);
    }

    public static final Object p(Object obj) {
        return obj instanceof C1727t ? kotlin.b.a(((C1727t) obj).f5333a) : obj;
    }

    public static final void q(C1718k c1718k, H7.c cVar, boolean z10) {
        Object obj = C1718k.g.get(c1718k);
        Throwable thM = c1718k.m(obj);
        Object objA = thM != null ? kotlin.b.a(thM) : c1718k.n(obj);
        if (!z10) {
            cVar.resumeWith(objA);
            return;
        }
        kotlin.jvm.internal.k.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C1925e c1925e = (C1925e) cVar;
        H7.c cVar2 = c1925e.e;
        Object obj2 = c1925e.g;
        H7.h context = cVar2.getContext();
        Object objL = AbstractC1921a.l(context, obj2);
        w0 w0VarV = objL != AbstractC1921a.d ? v(cVar2, context, objL) : null;
        try {
            cVar2.resumeWith(objA);
            if (w0VarV == null || w0VarV.j0()) {
                AbstractC1921a.g(context, objL);
            }
        } catch (Throwable th) {
            if (w0VarV == null || w0VarV.j0()) {
                AbstractC1921a.g(context, objL);
            }
            throw th;
        }
    }

    public static final Object r(H7.h hVar, S7.n nVar) throws Throwable {
        AbstractC1701T abstractC1701TA;
        H7.h hVarG;
        Thread threadCurrentThread = Thread.currentThread();
        H7.g gVar = H7.d.f758a;
        H7.e eVar = (H7.e) hVar.get(gVar);
        if (eVar == null) {
            abstractC1701TA = t0.a();
            hVarG = g(EmptyCoroutineContext.f4908a, hVar.plus(abstractC1701TA), true);
            u9.d dVar = AbstractC1691I.f5315a;
            if (hVarG != dVar && hVarG.get(gVar) == null) {
                hVarG = hVarG.plus(dVar);
            }
        } else {
            if (eVar instanceof AbstractC1701T) {
            }
            abstractC1701TA = (AbstractC1701T) t0.f5334a.get();
            hVarG = g(EmptyCoroutineContext.f4908a, hVar, true);
            u9.d dVar2 = AbstractC1691I.f5315a;
            if (hVarG != dVar2 && hVarG.get(gVar) == null) {
                hVarG = hVarG.plus(dVar2);
            }
        }
        C1713f c1713f = new C1713f(hVarG, threadCurrentThread, abstractC1701TA);
        c1713f.i0(CoroutineStart.f5175a, c1713f, nVar);
        AbstractC1701T abstractC1701T = c1713f.e;
        if (abstractC1701T != null) {
            int i6 = AbstractC1701T.d;
            abstractC1701T.H(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jI = abstractC1701T != null ? abstractC1701T.I() : Long.MAX_VALUE;
                if (c1713f.r()) {
                    if (abstractC1701T != null) {
                        int i10 = AbstractC1701T.d;
                        abstractC1701T.E(false);
                    }
                    Object objU = u(kotlinx.coroutines.c.f5183a.get(c1713f));
                    C1727t c1727t = objU instanceof C1727t ? (C1727t) objU : null;
                    if (c1727t == null) {
                        return objU;
                    }
                    throw c1727t.f5333a;
                }
                LockSupport.parkNanos(c1713f, jI);
            } catch (Throwable th) {
                if (abstractC1701T != null) {
                    int i11 = AbstractC1701T.d;
                    abstractC1701T.E(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c1713f.A(interruptedException);
        throw interruptedException;
    }

    public static final String t(H7.c cVar) {
        Object objA;
        if (cVar instanceof C1925e) {
            return ((C1925e) cVar).toString();
        }
        try {
            objA = cVar + '@' + i(cVar);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (Result.a(objA) != null) {
            objA = cVar.getClass().getName() + '@' + i(cVar);
        }
        return (String) objA;
    }

    public static final Object u(Object obj) {
        InterfaceC1706Y interfaceC1706Y;
        C1707Z c1707z = obj instanceof C1707Z ? (C1707Z) obj : null;
        return (c1707z == null || (interfaceC1706Y = c1707z.f5323a) == null) ? obj : interfaceC1706Y;
    }

    public static final w0 v(H7.c cVar, H7.h hVar, Object obj) {
        w0 w0Var = null;
        if ((cVar instanceof J7.b) && hVar.get(x0.f5338a) != null) {
            J7.b callerFrame = (J7.b) cVar;
            while (true) {
                if ((callerFrame instanceof kotlinx.coroutines.b) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof w0) {
                    w0Var = (w0) callerFrame;
                    break;
                }
            }
            if (w0Var != null) {
                w0Var.k0(hVar, obj);
            }
        }
        return w0Var;
    }

    public static final Object w(H7.h hVar, S7.n nVar, H7.c cVar) throws Throwable {
        Object objU;
        H7.h context = cVar.getContext();
        H7.h hVarPlus = !((Boolean) hVar.fold(Boolean.FALSE, new com.stepos.core.a(10))).booleanValue() ? context.plus(hVar) : g(context, hVar, false);
        kotlinx.coroutines.a.g(hVarPlus);
        if (hVarPlus == context) {
            s9.o oVar = new s9.o(hVarPlus, cVar);
            objU = AbstractC0897f.M(oVar, oVar, nVar);
        } else {
            H7.d dVar = H7.d.f758a;
            if (kotlin.jvm.internal.k.b(hVarPlus.get(dVar), context.get(dVar))) {
                w0 w0Var = new w0(hVarPlus, cVar);
                H7.h hVar2 = w0Var.c;
                Object objL = AbstractC1921a.l(hVar2, null);
                try {
                    Object objM = AbstractC0897f.M(w0Var, w0Var, nVar);
                    AbstractC1921a.g(hVar2, objL);
                    objU = objM;
                } catch (Throwable th) {
                    AbstractC1921a.g(hVar2, objL);
                    throw th;
                }
            } else {
                kotlinx.coroutines.b bVar = new kotlinx.coroutines.b(hVarPlus, cVar);
                try {
                    AbstractC1921a.h(U7.a.I(U7.a.u(bVar, bVar, nVar)), C7.r.f317a);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = kotlinx.coroutines.b.e;
                    while (true) {
                        int i6 = atomicIntegerFieldUpdater.get(bVar);
                        if (i6 != 0) {
                            if (i6 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            objU = u(kotlinx.coroutines.c.f5183a.get(bVar));
                            if (objU instanceof C1727t) {
                                throw ((C1727t) objU).f5333a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(bVar, 0, 1)) {
                            objU = CoroutineSingletons.f4909a;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    bVar.resumeWith(kotlin.b.a(th2));
                    throw th2;
                }
            }
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objU;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object x(kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            H7.h r0 = r7.getContext()
            kotlinx.coroutines.a.g(r0)
            H7.c r7 = U7.a.I(r7)
            boolean r1 = r7 instanceof s9.C1925e
            if (r1 == 0) goto L12
            s9.e r7 = (s9.C1925e) r7
            goto L13
        L12:
            r7 = 0
        L13:
            C7.r r1 = C7.r.f317a
            if (r7 != 0) goto L1a
        L17:
            r7 = r1
            goto L88
        L1a:
            m9.v r2 = r7.d
            boolean r3 = r2.isDispatchNeeded(r0)
            r4 = 1
            if (r3 == 0) goto L2b
            r7.f = r1
            r7.c = r4
            r2.dispatchYield(r0, r7)
            goto L86
        L2b:
            m9.z0 r3 = new m9.z0
            m9.b0 r5 = m9.z0.b
            r3.<init>(r5)
            H7.h r0 = r0.plus(r3)
            r7.f = r1
            r7.c = r4
            r2.dispatchYield(r0, r7)
            boolean r0 = r3.f5340a
            if (r0 == 0) goto L86
            m9.T r0 = m9.t0.a()
            D7.p r2 = r0.c
            if (r2 == 0) goto L4e
            boolean r2 = r2.isEmpty()
            goto L4f
        L4e:
            r2 = r4
        L4f:
            if (r2 == 0) goto L52
            goto L17
        L52:
            long r2 = r0.f5319a
            r5 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L5f
            r2 = r4
            goto L60
        L5f:
            r2 = 0
        L60:
            if (r2 == 0) goto L6c
            r7.f = r1
            r7.c = r4
            r0.F(r7)
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            goto L88
        L6c:
            r0.H(r4)
            r7.run()     // Catch: java.lang.Throwable -> L7c
        L72:
            boolean r2 = r0.J()     // Catch: java.lang.Throwable -> L7c
            if (r2 != 0) goto L72
        L78:
            r0.E(r4)
            goto L17
        L7c:
            r2 = move-exception
            r7.o(r2)     // Catch: java.lang.Throwable -> L81
            goto L78
        L81:
            r7 = move-exception
            r0.E(r4)
            throw r7
        L86:
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
        L88:
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r7 != r0) goto L8d
            return r7
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.AbstractC1683A.x(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
