package kc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final pc.t f7489a = new pc.t("RESUME_TOKEN");

    /* renamed from: b, reason: collision with root package name */
    public static final pc.t f7490b = new pc.t("REMOVED_TASK");

    /* renamed from: c, reason: collision with root package name */
    public static final pc.t f7491c = new pc.t("CLOSED_EMPTY");

    /* renamed from: d, reason: collision with root package name */
    public static final pc.t f7492d = new pc.t("COMPLETING_ALREADY");

    /* renamed from: e, reason: collision with root package name */
    public static final pc.t f7493e = new pc.t("COMPLETING_WAITING_CHILDREN");

    /* renamed from: f, reason: collision with root package name */
    public static final pc.t f7494f = new pc.t("COMPLETING_RETRY");

    /* renamed from: g, reason: collision with root package name */
    public static final pc.t f7495g = new pc.t("TOO_LATE_TO_CANCEL");

    /* renamed from: h, reason: collision with root package name */
    public static final pc.t f7496h = new pc.t("SEALED");
    public static final i0 i = new i0(false);

    /* renamed from: j, reason: collision with root package name */
    public static final i0 f7497j = new i0(true);

    public static final Object A(o1 o1Var, xb.p pVar) throws Throwable {
        Object nVar;
        Object objP;
        g0 g0VarN = l(o1Var.f9980h.getContext()).n(o1Var.i, o1Var, o1Var.f7414g);
        h0 h0Var = new h0(0);
        h0Var.f7439j = g0VarN;
        VarHandle.storeStoreFence();
        q(o1Var, true, h0Var);
        try {
            if (pVar instanceof pb.a) {
                yb.x.c(2, pVar);
                nVar = pVar.invoke(o1Var, o1Var);
            } else {
                nVar = td.h.Q(pVar, o1Var, o1Var);
            }
        } catch (Throwable th) {
            nVar = new n(th, false);
        }
        ob.a aVar = ob.a.f9351c;
        if (nVar == aVar || (objP = o1Var.P(nVar)) == f7493e) {
            return aVar;
        }
        if (objP instanceof n) {
            Throwable th2 = ((n) objP).f7461a;
            if (!(th2 instanceof n1) || ((n1) th2).f7463c != o1Var) {
                throw th2;
            }
            if (nVar instanceof n) {
                throw ((n) nVar).f7461a;
            }
        } else {
            nVar = C(objP);
        }
        return nVar;
    }

    public static final String B(nb.c cVar) {
        Object objL;
        if (cVar instanceof pc.f) {
            return ((pc.f) cVar).toString();
        }
        try {
            objL = cVar + '@' + m(cVar);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (jb.i.b(objL) != null) {
            objL = cVar.getClass().getName() + '@' + m(cVar);
        }
        return (String) objL;
    }

    public static final Object C(Object obj) {
        t0 t0Var;
        u0 u0Var = obj instanceof u0 ? (u0) obj : null;
        return (u0Var == null || (t0Var = u0Var.f7485a) == null) ? obj : t0Var;
    }

    public static final r1 D(nb.c cVar, nb.g gVar, Object obj) {
        r1 r1Var = null;
        if ((cVar instanceof pb.d) && gVar.get(s1.f7480c) != null) {
            pb.d callerFrame = (pb.d) cVar;
            while (true) {
                if ((callerFrame instanceof b0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof r1) {
                    r1Var = (r1) callerFrame;
                    break;
                }
            }
            if (r1Var != null) {
                r1Var.e0(gVar, obj);
            }
        }
        return r1Var;
    }

    public static final Object E(nb.g gVar, xb.p pVar, nb.c cVar) throws Throwable {
        Object objC;
        nb.g context = cVar.getContext();
        nb.g gVarPlus = !((Boolean) gVar.fold(Boolean.FALSE, new k8.d(2))).booleanValue() ? context.plus(gVar) : j(context, gVar, false);
        i(gVarPlus);
        if (gVarPlus == context) {
            pc.q qVar = new pc.q(cVar, gVarPlus);
            objC = ac.a.Y(qVar, qVar, pVar);
        } else {
            nb.d dVar = nb.d.f8810c;
            if (yb.k.a(gVarPlus.get(dVar), context.get(dVar))) {
                s1 s1Var = s1.f7480c;
                r1 r1Var = new r1(cVar, gVarPlus.get(s1Var) == null ? gVarPlus.plus(s1Var) : gVarPlus);
                r1Var.i = new ThreadLocal();
                if (!(cVar.getContext().get(dVar) instanceof p)) {
                    Object objL = pc.a.l(gVarPlus, null);
                    pc.a.g(gVarPlus, objL);
                    r1Var.e0(gVarPlus, objL);
                }
                VarHandle.storeStoreFence();
                nb.g gVar2 = r1Var.f7414g;
                Object objL2 = pc.a.l(gVar2, null);
                try {
                    Object objY = ac.a.Y(r1Var, r1Var, pVar);
                    pc.a.g(gVar2, objL2);
                    objC = objY;
                } catch (Throwable th) {
                    pc.a.g(gVar2, objL2);
                    throw th;
                }
            } else {
                b0 b0Var = new b0(cVar, gVarPlus);
                try {
                    pc.a.h(jb.v.f6774a, td.h.y(td.h.m(b0Var, b0Var, pVar)));
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b0.i;
                    while (true) {
                        int i3 = atomicIntegerFieldUpdater.get(b0Var);
                        if (i3 != 0) {
                            if (i3 != 2) {
                                od.f.e("Already suspended");
                                return null;
                            }
                            objC = C(e1.f7431c.get(b0Var));
                            if (objC instanceof n) {
                                throw ((n) objC).f7461a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(b0Var, 0, 1)) {
                            objC = ob.a.f9351c;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    b0Var.resumeWith(id.c.l(th2));
                    throw th2;
                }
            }
        }
        ob.a aVar = ob.a.f9351c;
        return objC;
    }

    public static final Object F(long j10, androidx.lifecycle.l0 l0Var, o4.d dVar) throws Throwable {
        long jConvert;
        long jA = j10;
        int i3 = ic.a.f5939g;
        boolean z10 = jA > 0;
        if (z10) {
            ic.c cVar = ic.c.f5941f;
            long jF0 = ac.a.f0(999999L, cVar);
            if (ic.a.b(jA)) {
                if (ic.a.b(jF0) && (jF0 ^ jA) < 0) {
                    g5.f.s("Summing infinite durations of different signs yields an undefined result.");
                    return null;
                }
            } else if (ic.a.b(jF0)) {
                jA = jF0;
            } else {
                int i10 = ((int) jA) & 1;
                if (i10 == (((int) jF0) & 1)) {
                    long j11 = (jA >> 1) + (jF0 >> 1);
                    if (i10 == 0) {
                        if (-4611686018426999999L > j11 || j11 >= 4611686018427000000L) {
                            jA = ac.a.r(j11 / 1000000);
                        } else {
                            jA = j11 << 1;
                            int i11 = ic.b.f5940a;
                        }
                    } else if (-4611686018426L > j11 || j11 >= 4611686018427L) {
                        jA = ac.a.r(p5.f.r(j11, -4611686018427387903L, 4611686018427387903L));
                    } else {
                        jA = (j11 * 1000000) << 1;
                        int i12 = ic.b.f5940a;
                    }
                } else {
                    jA = i10 == 1 ? ic.a.a(jA >> 1, jF0 >> 1) : ic.a.a(jF0 >> 1, jA >> 1);
                }
            }
            int i13 = ((int) jA) & 1;
            if (i13 != 1 || ic.a.b(jA)) {
                ic.c cVar2 = ic.c.f5942g;
                if (jA == ic.a.f5937c) {
                    jConvert = Long.MAX_VALUE;
                } else if (jA == ic.a.f5938f) {
                    jConvert = Long.MIN_VALUE;
                } else {
                    long j12 = jA >> 1;
                    if (i13 != 0) {
                        cVar = cVar2;
                    }
                    jConvert = TimeUnit.MILLISECONDS.convert(j12, cVar.f5944c);
                }
            } else {
                jConvert = jA >> 1;
            }
        } else {
            if (z10) {
                g5.f.a();
                return null;
            }
            jConvert = 0;
        }
        if (jConvert <= 0) {
            throw new n1("Timed out immediately", null);
        }
        o1 o1Var = new o1(dVar, dVar.getContext());
        o1Var.i = jConvert;
        Object objA = A(o1Var, l0Var);
        ob.a aVar = ob.a.f9351c;
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object G(long r7, xb.p r9, pb.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kc.p1
            if (r0 == 0) goto L13
            r0 = r10
            kc.p1 r0 = (kc.p1) r0
            int r1 = r0.f7472g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7472g = r1
            goto L18
        L13:
            kc.p1 r0 = new kc.p1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f7471f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f7472g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2c
            yb.u r7 = r0.f7470c
            id.c.I(r10)     // Catch: kc.n1 -> L2a
            return r10
        L2a:
            r8 = move-exception
            goto L64
        L2c:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            return r3
        L32:
            id.c.I(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L3c
            goto L6a
        L3c:
            yb.u r10 = new yb.u
            r10.<init>()
            r0.f7470c = r10     // Catch: kc.n1 -> L5d
            r0.f7472g = r4     // Catch: kc.n1 -> L5d
            kc.o1 r2 = new kc.o1     // Catch: kc.n1 -> L5d
            nb.g r4 = r0.getContext()     // Catch: kc.n1 -> L62
            r2.<init>(r0, r4)     // Catch: kc.n1 -> L62
            r2.i = r7     // Catch: kc.n1 -> L62
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: kc.n1 -> L62
            r10.f16098c = r2     // Catch: kc.n1 -> L5d
            java.lang.Object r7 = A(r2, r9)     // Catch: kc.n1 -> L5d
            if (r7 != r1) goto L5c
            return r1
        L5c:
            return r7
        L5d:
            r8 = move-exception
        L5e:
            r7 = r10
            goto L64
        L60:
            r8 = r7
            goto L5e
        L62:
            r7 = move-exception
            goto L60
        L64:
            kc.x0 r9 = r8.f7463c
            java.lang.Object r7 = r7.f16098c
            if (r9 != r7) goto L6b
        L6a:
            return r3
        L6b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.w.G(long, xb.p, pb.c):java.lang.Object");
    }

    public static final pc.c a(nb.g gVar) {
        if (gVar.get(w0.f7498c) == null) {
            gVar = gVar.plus(b());
        }
        return new pc.c(gVar);
    }

    public static z0 b() {
        return new z0(null);
    }

    public static k1 c() {
        return new k1(null);
    }

    public static final void d(t tVar, CancellationException cancellationException) {
        x0 x0Var = (x0) tVar.n().get(w0.f7498c);
        if (x0Var != null) {
            x0Var.e(cancellationException);
        } else {
            g5.f.n(tVar, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final void e(nb.g gVar, CancellationException cancellationException) {
        x0 x0Var = (x0) gVar.get(w0.f7498c);
        if (x0Var != null) {
            x0Var.e(cancellationException);
        }
    }

    public static final Object f(xb.p pVar, nb.c cVar) {
        pc.q qVar = new pc.q(cVar, cVar.getContext());
        Object objY = ac.a.Y(qVar, qVar, pVar);
        ob.a aVar = ob.a.f9351c;
        return objY;
    }

    public static final Object g(long j10, pb.c cVar) {
        if (j10 > 0) {
            g gVar = new g(1, td.h.y(cVar));
            gVar.s();
            if (j10 < Long.MAX_VALUE) {
                l(gVar.i).F(j10, gVar);
            }
            Object objR = gVar.r();
            if (objR == ob.a.f9351c) {
                return objR;
            }
        }
        return jb.v.f6774a;
    }

    public static final void h(g gVar, g0 g0Var) {
        e eVar = new e(2);
        eVar.f7429b = g0Var;
        VarHandle.storeStoreFence();
        gVar.v(eVar);
    }

    public static final void i(nb.g gVar) {
        x0 x0Var = (x0) gVar.get(w0.f7498c);
        if (x0Var != null && !x0Var.d()) {
            throw x0Var.o();
        }
    }

    public static final nb.g j(nb.g gVar, nb.g gVar2, boolean z10) {
        Boolean bool = Boolean.FALSE;
        int i3 = 2;
        boolean zBooleanValue = ((Boolean) gVar.fold(bool, new k8.d(i3))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) gVar2.fold(bool, new k8.d(i3))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return gVar.plus(gVar2);
        }
        k8.d dVar = new k8.d(3);
        VarHandle.storeStoreFence();
        nb.h hVar = nb.h.f8811c;
        nb.g gVar3 = (nb.g) gVar.fold(hVar, dVar);
        Object objFold = gVar2;
        if (zBooleanValue2) {
            objFold = gVar2.fold(hVar, new k8.d(4));
        }
        return gVar3.plus((nb.g) objFold);
    }

    public static final p k(Executor executor) {
        q0 q0Var = new q0();
        q0Var.f7474f = executor;
        if (!(executor instanceof ScheduledThreadPoolExecutor)) {
            VarHandle.storeStoreFence();
            return q0Var;
        }
        ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        VarHandle.storeStoreFence();
        return q0Var;
    }

    public static final a0 l(nb.g gVar) {
        nb.e eVar = gVar.get(nb.d.f8810c);
        a0 a0Var = eVar instanceof a0 ? (a0) eVar : null;
        return a0Var == null ? y.f7501a : a0Var;
    }

    public static final String m(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final x0 n(nb.g gVar) {
        x0 x0Var = (x0) gVar.get(w0.f7498c);
        if (x0Var != null) {
            return x0Var;
        }
        g5.f.n(gVar, "Current context doesn't contain Job in it: ");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r0 = kc.g.f7435k;
        r1 = r0.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if ((r1 instanceof kc.m) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (((kc.m) r1).f7454d == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r3.o();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        kc.g.f7434j.set(r3, 536870911);
        r0.set(r3, kc.b.f7416a);
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r4 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        return new kc.g(2, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kc.g o(nb.c r6) {
        /*
            boolean r0 = r6 instanceof pc.f
            if (r0 != 0) goto Lb
            kc.g r0 = new kc.g
            r1 = 1
            r0.<init>(r1, r6)
            return r0
        Lb:
            r0 = r6
            pc.f r0 = (pc.f) r0
            pc.t r1 = pc.a.f9945c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = pc.f.f9955l
        L12:
            java.lang.Object r3 = r2.get(r0)
            r4 = 0
            if (r3 != 0) goto L1e
            r2.set(r0, r1)
            r3 = r4
            goto L2a
        L1e:
            boolean r5 = r3 instanceof kc.g
            if (r5 == 0) goto L59
            boolean r5 = r2.compareAndSet(r0, r3, r1)
            if (r5 == 0) goto L12
            kc.g r3 = (kc.g) r3
        L2a:
            if (r3 == 0) goto L52
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.g.f7435k
            java.lang.Object r1 = r0.get(r3)
            boolean r2 = r1 instanceof kc.m
            if (r2 == 0) goto L40
            kc.m r1 = (kc.m) r1
            java.lang.Object r1 = r1.f7454d
            if (r1 == 0) goto L40
            r3.o()
            goto L4e
        L40:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = kc.g.f7434j
            r2 = 536870911(0x1fffffff, float:1.0842021E-19)
            r1.set(r3, r2)
            kc.b r1 = kc.b.f7416a
            r0.set(r3, r1)
            r4 = r3
        L4e:
            if (r4 != 0) goto L51
            goto L52
        L51:
            return r4
        L52:
            kc.g r0 = new kc.g
            r1 = 2
            r0.<init>(r1, r6)
            return r0
        L59:
            if (r3 == r1) goto L12
            boolean r4 = r3 instanceof java.lang.Throwable
            if (r4 == 0) goto L60
            goto L12
        L60:
            java.lang.String r6 = "Inconsistent state "
            g5.f.n(r3, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.w.o(nb.c):kc.g");
    }

    public static final void p(nb.g gVar, Throwable th) {
        try {
            r rVar = (r) gVar.get(q.f7473c);
            if (rVar != null) {
                rVar.handleException(gVar, th);
            } else {
                pc.a.d(gVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                com.stepos.statsrpk.h.b(runtimeException, th);
                th = runtimeException;
            }
            pc.a.d(gVar, th);
        }
    }

    public static final g0 q(x0 x0Var, boolean z10, a1 a1Var) {
        if (x0Var instanceof e1) {
            return ((e1) x0Var).L(z10, a1Var);
        }
        return x0Var.H(a1Var.k(), z10, new androidx.room.d(1, a1Var, a1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0, 9));
    }

    public static final boolean r(t tVar) {
        x0 x0Var = (x0) tVar.n().get(w0.f7498c);
        if (x0Var != null) {
            return x0Var.d();
        }
        return true;
    }

    public static final boolean s(nb.g gVar) {
        x0 x0Var = (x0) gVar.get(w0.f7498c);
        if (x0Var != null) {
            return x0Var.d();
        }
        return true;
    }

    public static final z t(t tVar, nb.g gVar, u uVar, xb.p pVar) {
        z zVar;
        nb.g gVarV = v(tVar, gVar);
        uVar.getClass();
        int i3 = 1;
        boolean z10 = true;
        boolean z11 = true;
        if (uVar == u.f7482f) {
            f1 f1Var = new f1(gVarV, false, i3);
            f1Var.i = td.h.m(f1Var, f1Var, pVar);
            VarHandle.storeStoreFence();
            zVar = f1Var;
        } else {
            zVar = new z(gVarV, z11 ? 1 : 0, z10 ? 1 : 0);
        }
        zVar.c0(uVar, zVar, pVar);
        return zVar;
    }

    public static /* synthetic */ z u(t tVar, nb.g gVar, u uVar, xb.p pVar, int i3) {
        if ((i3 & 1) != 0) {
            gVar = nb.h.f8811c;
        }
        if ((i3 & 2) != 0) {
            uVar = u.f7481c;
        }
        return t(tVar, gVar, uVar, pVar);
    }

    public static final nb.g v(t tVar, nb.g gVar) {
        nb.g gVarJ = j(tVar.n(), gVar, true);
        rc.e eVar = e0.f7430a;
        return (gVarJ == eVar || gVarJ.get(nb.d.f8810c) != null) ? gVarJ : gVarJ.plus(eVar);
    }

    public static final Object w(Object obj) {
        return obj instanceof n ? id.c.l(((n) obj).f7461a) : obj;
    }

    public static final void x(g gVar, nb.c cVar, boolean z10) {
        Object obj = g.f7435k.get(gVar);
        Throwable thD = gVar.d(obj);
        Object objL = thD != null ? id.c.l(thD) : gVar.e(obj);
        if (!z10) {
            cVar.resumeWith(objL);
            return;
        }
        cVar.getClass();
        pc.f fVar = (pc.f) cVar;
        pb.c cVar2 = fVar.i;
        Object obj2 = fVar.f9958k;
        nb.g context = cVar2.getContext();
        Object objL2 = pc.a.l(context, obj2);
        r1 r1VarD = objL2 != pc.a.f9946d ? D(cVar2, context, objL2) : null;
        try {
            cVar2.resumeWith(objL);
            if (r1VarD == null || r1VarD.d0()) {
                pc.a.g(context, objL2);
            }
        } catch (Throwable th) {
            if (r1VarD == null || r1VarD.d0()) {
                pc.a.g(context, objL2);
            }
            throw th;
        }
    }

    public static final Object y(nb.g gVar, xb.p pVar) throws Throwable {
        j0 j0VarA;
        nb.g gVarJ;
        Thread threadCurrentThread = Thread.currentThread();
        nb.f fVar = nb.d.f8810c;
        p pVar2 = (p) gVar.get(fVar);
        nb.h hVar = nb.h.f8811c;
        if (pVar2 == null) {
            j0VarA = l1.a();
            gVarJ = j(hVar, gVar.plus(j0VarA), true);
            rc.e eVar = e0.f7430a;
            if (gVarJ != eVar && gVarJ.get(fVar) == null) {
                gVarJ = gVarJ.plus(eVar);
            }
        } else {
            if (pVar2 instanceof j0) {
            }
            j0VarA = (j0) l1.f7450a.get();
            gVarJ = j(hVar, gVar, true);
            rc.e eVar2 = e0.f7430a;
            if (gVarJ != eVar2 && gVarJ.get(fVar) == null) {
                gVarJ = gVarJ.plus(eVar2);
            }
        }
        c cVar = new c(gVarJ, true);
        cVar.f7418h = threadCurrentThread;
        VarHandle.storeStoreFence();
        cVar.c0(u.f7481c, cVar, pVar);
        if (j0VarA != null) {
            int i3 = j0.i;
            j0VarA.S(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jT = j0VarA != null ? j0VarA.T() : Long.MAX_VALUE;
                if (cVar.M()) {
                    if (j0VarA != null) {
                        int i10 = j0.i;
                        j0VarA.Q(false);
                    }
                    Object objC = C(e1.f7431c.get(cVar));
                    n nVar = objC instanceof n ? (n) objC : null;
                    if (nVar == null) {
                        return objC;
                    }
                    throw nVar.f7461a;
                }
                LockSupport.parkNanos(cVar, jT);
            } catch (Throwable th) {
                if (j0VarA != null) {
                    int i11 = j0.i;
                    j0VarA.Q(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.t(interruptedException);
        throw interruptedException;
    }
}
