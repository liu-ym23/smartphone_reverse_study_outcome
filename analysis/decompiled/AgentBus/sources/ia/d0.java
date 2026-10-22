package ia;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.x f4935a = new f8.x("RESUME_TOKEN", 3);

    /* renamed from: b, reason: collision with root package name */
    public static final f8.x f4936b = new f8.x("REMOVED_TASK", 3);

    /* renamed from: c, reason: collision with root package name */
    public static final f8.x f4937c = new f8.x("CLOSED_EMPTY", 3);

    /* renamed from: d, reason: collision with root package name */
    public static final f8.x f4938d = new f8.x("COMPLETING_ALREADY", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final f8.x f4939e = new f8.x("COMPLETING_WAITING_CHILDREN", 3);

    /* renamed from: f, reason: collision with root package name */
    public static final f8.x f4940f = new f8.x("COMPLETING_RETRY", 3);

    /* renamed from: g, reason: collision with root package name */
    public static final f8.x f4941g = new f8.x("TOO_LATE_TO_CANCEL", 3);

    /* renamed from: h, reason: collision with root package name */
    public static final f8.x f4942h = new f8.x("SEALED", 3);

    /* renamed from: i, reason: collision with root package name */
    public static final r0 f4943i = new r0(false);

    /* renamed from: j, reason: collision with root package name */
    public static final r0 f4944j = new r0(true);

    public static final e2 A(g7.d dVar, g7.l lVar, Object obj) {
        e2 e2Var = null;
        if ((dVar instanceof i7.d) && lVar.o(f2.f4957f) != null) {
            i7.d callerFrame = (i7.d) dVar;
            while (true) {
                if ((callerFrame instanceof l0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof e2) {
                    e2Var = (e2) callerFrame;
                    break;
                }
            }
            if (e2Var != null) {
                e2Var.r0(lVar, obj);
            }
        }
        return e2Var;
    }

    public static final Object B(g7.l lVar, p7.n nVar, g7.d dVar) throws Throwable {
        Object objZ;
        g7.l context = dVar.getContext();
        g7.l lVarQ = !((Boolean) lVar.r(Boolean.FALSE, new g7.b(2))).booleanValue() ? context.Q(lVar) : i(context, lVar, false);
        h(lVarQ);
        if (lVarQ == context) {
            na.r rVar = new na.r(dVar, lVarQ);
            objZ = nb.i.K(rVar, true, rVar, nVar);
        } else {
            g7.f fVar = g7.f.f3865f;
            if (q7.k.a(lVarQ.o(fVar), context.o(fVar))) {
                e2 e2Var = new e2(dVar, lVarQ);
                g7.l lVar2 = e2Var.f4915h;
                Object objN = na.b.n(lVar2, null);
                try {
                    Object objK = nb.i.K(e2Var, true, e2Var, nVar);
                    na.b.g(lVar2, objN);
                    objZ = objK;
                } catch (Throwable th) {
                    na.b.g(lVar2, objN);
                    throw th;
                }
            } else {
                l0 l0Var = new l0(dVar, lVarQ);
                try {
                    na.b.h(ib.k.C(ib.k.r(l0Var, l0Var, nVar)), c7.r.f1986a);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = l0.f4969j;
                    while (true) {
                        int i2 = atomicIntegerFieldUpdater.get(l0Var);
                        if (i2 != 0) {
                            if (i2 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            objZ = z(o1.f4991f.get(l0Var));
                            if (objZ instanceof v) {
                                throw ((v) objZ).f5011a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(l0Var, 0, 1)) {
                            objZ = h7.a.f4212f;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (th instanceof k0) {
                        th = ((k0) th).f4965f;
                    }
                    l0Var.resumeWith(w7.e0.n(th));
                    throw th;
                }
            }
        }
        h7.a aVar = h7.a.f4212f;
        return objZ;
    }

    public static final Object C(long j2, p7.n nVar, i7.c cVar) {
        if (j2 <= 0) {
            throw new a2("Timed out immediately", null);
        }
        Object objX = x(new b2(j2, cVar), nVar);
        h7.a aVar = h7.a.f4212f;
        return objX;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object D(long r6, p7.n r8, i7.c r9) {
        /*
            boolean r0 = r9 instanceof ia.c2
            if (r0 == 0) goto L13
            r0 = r9
            ia.c2 r0 = (ia.c2) r0
            int r1 = r0.f4933h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4933h = r1
            goto L18
        L13:
            ia.c2 r0 = new ia.c2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f4932g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f4933h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            q7.v r6 = r0.f4931f
            w7.e0.N(r9)     // Catch: ia.a2 -> L29
            return r9
        L29:
            r7 = move-exception
            goto L57
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            w7.e0.N(r9)
            r4 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L3d
            goto L5d
        L3d:
            q7.v r9 = new q7.v
            r9.<init>()
            r0.f4931f = r9     // Catch: ia.a2 -> L55
            r0.f4933h = r3     // Catch: ia.a2 -> L55
            ia.b2 r2 = new ia.b2     // Catch: ia.a2 -> L55
            r2.<init>(r6, r0)     // Catch: ia.a2 -> L55
            r9.f8820f = r2     // Catch: ia.a2 -> L55
            java.lang.Object r6 = x(r2, r8)     // Catch: ia.a2 -> L55
            if (r6 != r1) goto L54
            return r1
        L54:
            return r6
        L55:
            r7 = move-exception
            r6 = r9
        L57:
            ia.g1 r8 = r7.f4918f
            java.lang.Object r6 = r6.f8820f
            if (r8 != r6) goto L5f
        L5d:
            r6 = 0
            return r6
        L5f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.d0.D(long, p7.n, i7.c):java.lang.Object");
    }

    public static s a() {
        s sVar = new s(true);
        sVar.T(null);
        return sVar;
    }

    public static final na.d b(g7.l lVar) {
        if (lVar.o(z.f5027g) == null) {
            lVar = lVar.Q(new i1(null));
        }
        return new na.d(lVar);
    }

    public static x1 c() {
        return new x1(null);
    }

    public static h0 d(b0 b0Var, g7.l lVar, p7.n nVar, int i2) {
        if ((i2 & 1) != 0) {
            lVar = g7.m.f3866f;
        }
        c0 c0Var = c0.f4926f;
        g7.l lVarT = t(b0Var, lVar);
        c0 c0Var2 = c0.f4926f;
        h0 h0Var = new h0(lVarT, true);
        h0Var.n0(c0Var, h0Var, nVar);
        return h0Var;
    }

    public static final void e(b0 b0Var, CancellationException cancellationException) {
        g1 g1Var = (g1) b0Var.k().o(z.f5027g);
        if (g1Var != null) {
            g1Var.d(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + b0Var).toString());
        }
    }

    public static final Object f(p7.n nVar, g7.d dVar) throws Throwable {
        na.r rVar = new na.r(dVar, dVar.getContext());
        Object objK = nb.i.K(rVar, true, rVar, nVar);
        h7.a aVar = h7.a.f4212f;
        return objK;
    }

    public static final Object g(long j2, g7.d dVar) {
        if (j2 > 0) {
            m mVar = new m(1, ib.k.C(dVar));
            mVar.s();
            if (j2 < Long.MAX_VALUE) {
                j(mVar.f4975j).k(j2, mVar);
            }
            Object objR = mVar.r();
            if (objR == h7.a.f4212f) {
                return objR;
            }
        }
        return c7.r.f1986a;
    }

    public static final void h(g7.l lVar) {
        g1 g1Var = (g1) lVar.o(z.f5027g);
        if (g1Var != null && !g1Var.b()) {
            throw g1Var.E();
        }
    }

    public static final g7.l i(g7.l lVar, g7.l lVar2, boolean z4) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) lVar.r(bool, new g7.b(2))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) lVar2.r(bool, new g7.b(2))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return lVar.Q(lVar2);
        }
        g7.b bVar = new g7.b(3);
        g7.m mVar = g7.m.f3866f;
        g7.l lVar3 = (g7.l) lVar.r(mVar, bVar);
        Object objR = lVar2;
        if (zBooleanValue2) {
            objR = lVar2.r(mVar, new g7.b(4));
        }
        return lVar3.Q((g7.l) objR);
    }

    public static final j0 j(g7.l lVar) {
        g7.j jVarO = lVar.o(g7.f.f3865f);
        j0 j0Var = jVarO instanceof j0 ? (j0) jVarO : null;
        return j0Var == null ? f0.f4956a : j0Var;
    }

    public static final String k(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final g1 l(g7.l lVar) {
        g1 g1Var = (g1) lVar.o(z.f5027g);
        if (g1Var != null) {
            return g1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + lVar).toString());
    }

    public static final m m(g7.d dVar) {
        m mVar;
        m mVar2;
        if (!(dVar instanceof na.g)) {
            return new m(1, dVar);
        }
        na.g gVar = (na.g) dVar;
        f8.x xVar = na.b.f6889c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.g.f6899m;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(gVar);
            mVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(gVar, xVar);
                mVar2 = null;
                break;
            }
            if (obj instanceof m) {
                while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, xVar)) {
                    if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                        break;
                    }
                }
                mVar2 = (m) obj;
                break loop0;
            }
            if (obj != xVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (mVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = m.f4972l;
            Object obj2 = atomicReferenceFieldUpdater2.get(mVar2);
            if (!(obj2 instanceof u) || ((u) obj2).f5006d == null) {
                m.f4971k.set(mVar2, 536870911);
                atomicReferenceFieldUpdater2.set(mVar2, b.f4919a);
                mVar = mVar2;
            } else {
                mVar2.o();
            }
            if (mVar != null) {
                return mVar;
            }
        }
        return new m(2, dVar);
    }

    public static final void n(g7.l lVar, Throwable th) {
        if (th instanceof k0) {
            th = ((k0) th).f4965f;
        }
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) lVar.o(z.f5026f);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.e(lVar, th);
            } else {
                na.b.d(lVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ib.k.e(runtimeException, th);
                th = runtimeException;
            }
            na.b.d(lVar, th);
        }
    }

    public static final p0 o(g1 g1Var, boolean z4, k1 k1Var) {
        if (g1Var instanceof o1) {
            return ((o1) g1Var).U(z4, k1Var);
        }
        return g1Var.i(k1Var.k(), z4, new j1(1, k1Var, k1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0));
    }

    public static final boolean p(g7.l lVar) {
        g1 g1Var = (g1) lVar.o(z.f5027g);
        if (g1Var != null) {
            return g1Var.b();
        }
        return true;
    }

    public static final boolean q(b0 b0Var) {
        g1 g1Var = (g1) b0Var.k().o(z.f5027g);
        if (g1Var != null) {
            return g1Var.b();
        }
        return true;
    }

    public static final w1 r(b0 b0Var, g7.l lVar, c0 c0Var, p7.n nVar) {
        g7.l lVarT = t(b0Var, lVar);
        c0Var.getClass();
        w1 p1Var = c0Var == c0.f4927g ? new p1(lVarT, nVar) : new w1(lVarT, true);
        p1Var.n0(c0Var, p1Var, nVar);
        return p1Var;
    }

    public static /* synthetic */ w1 s(b0 b0Var, g7.l lVar, c0 c0Var, p7.n nVar, int i2) {
        if ((i2 & 1) != 0) {
            lVar = g7.m.f3866f;
        }
        if ((i2 & 2) != 0) {
            c0Var = c0.f4926f;
        }
        return r(b0Var, lVar, c0Var, nVar);
    }

    public static final g7.l t(b0 b0Var, g7.l lVar) {
        g7.l lVarI = i(b0Var.k(), lVar, true);
        pa.e eVar = n0.f4982a;
        return (lVarI == eVar || lVarI.o(g7.f.f3865f) != null) ? lVarI : lVarI.Q(eVar);
    }

    public static final Object u(Object obj) {
        return obj instanceof v ? w7.e0.n(((v) obj).f5011a) : obj;
    }

    public static final void v(m mVar, g7.d dVar, boolean z4) {
        Object obj = m.f4972l.get(mVar);
        Throwable thE = mVar.e(obj);
        Object objN = thE != null ? w7.e0.n(thE) : mVar.g(obj);
        if (!z4) {
            dVar.resumeWith(objN);
            return;
        }
        q7.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        na.g gVar = (na.g) dVar;
        i7.c cVar = gVar.f6901j;
        Object obj2 = gVar.f6903l;
        g7.l context = cVar.getContext();
        Object objN2 = na.b.n(context, obj2);
        e2 e2VarA = objN2 != na.b.f6890d ? A(cVar, context, objN2) : null;
        try {
            cVar.resumeWith(objN);
            if (e2VarA == null || e2VarA.p0()) {
                na.b.g(context, objN2);
            }
        } catch (Throwable th) {
            if (e2VarA == null || e2VarA.p0()) {
                na.b.g(context, objN2);
            }
            throw th;
        }
    }

    public static final Object w(g7.l lVar, p7.n nVar) throws Throwable {
        x0 x0VarA;
        g7.l lVarI;
        long jY;
        Thread threadCurrentThread = Thread.currentThread();
        g7.k kVar = g7.f.f3865f;
        g7.g gVar = (g7.g) lVar.o(kVar);
        g7.m mVar = g7.m.f3866f;
        if (gVar == null) {
            x0VarA = z1.a();
            lVarI = i(mVar, lVar.Q(x0VarA), true);
            pa.e eVar = n0.f4982a;
            if (lVarI != eVar && lVarI.o(kVar) == null) {
                lVarI = lVarI.Q(eVar);
            }
        } else {
            if (gVar instanceof x0) {
            }
            x0VarA = (x0) z1.f5029a.get();
            lVarI = i(mVar, lVar, true);
            pa.e eVar2 = n0.f4982a;
            if (lVarI != eVar2 && lVarI.o(kVar) == null) {
                lVarI = lVarI.Q(eVar2);
            }
        }
        f fVar = new f(lVarI, threadCurrentThread, x0VarA);
        fVar.n0(c0.f4926f, fVar, nVar);
        x0 x0Var = fVar.f4955j;
        if (x0Var != null) {
            int i2 = x0.f5022k;
            x0Var.X(false);
        }
        while (true) {
            if (x0Var != null) {
                try {
                    jY = x0Var.Y();
                } catch (Throwable th) {
                    if (x0Var != null) {
                        int i10 = x0.f5022k;
                        x0Var.U(false);
                    }
                    throw th;
                }
            } else {
                jY = Long.MAX_VALUE;
            }
            if (fVar.V()) {
                break;
            }
            LockSupport.parkNanos(fVar, jY);
            if (Thread.interrupted()) {
                fVar.B(new InterruptedException());
            }
        }
        if (x0Var != null) {
            int i11 = x0.f5022k;
            x0Var.U(false);
        }
        Object objZ = z(o1.f4991f.get(fVar));
        v vVar = objZ instanceof v ? (v) objZ : null;
        if (vVar == null) {
            return objZ;
        }
        throw vVar.f5011a;
    }

    public static final Object x(b2 b2Var, p7.n nVar) {
        o(b2Var, true, new q0(0, j(b2Var.f6925i.getContext()).C(b2Var.f4921j, b2Var, b2Var.f4915h)));
        return nb.i.K(b2Var, false, b2Var, nVar);
    }

    public static final String y(g7.d dVar) {
        Object objN;
        if (dVar instanceof na.g) {
            return ((na.g) dVar).toString();
        }
        try {
            objN = dVar + '@' + k(dVar);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (c7.m.a(objN) != null) {
            objN = dVar.getClass().getName() + '@' + k(dVar);
        }
        return (String) objN;
    }

    public static final Object z(Object obj) {
        c1 c1Var;
        d1 d1Var = obj instanceof d1 ? (d1) obj : null;
        return (d1Var == null || (c1Var = d1Var.f4945a) == null) ? obj : c1Var;
    }
}
