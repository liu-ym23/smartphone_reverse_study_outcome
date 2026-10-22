package a6;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.emoji2.text.r f172a = new androidx.emoji2.text.r("RESUME_TOKEN", 1);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.r f173b = new androidx.emoji2.text.r("REMOVED_TASK", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.r f174c = new androidx.emoji2.text.r("CLOSED_EMPTY", 1);
    public static final androidx.emoji2.text.r d = new androidx.emoji2.text.r("COMPLETING_ALREADY", 1);

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.r f175e = new androidx.emoji2.text.r("COMPLETING_WAITING_CHILDREN", 1);

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.r f176f = new androidx.emoji2.text.r("COMPLETING_RETRY", 1);

    /* renamed from: g, reason: collision with root package name */
    public static final androidx.emoji2.text.r f177g = new androidx.emoji2.text.r("TOO_LATE_TO_CANCEL", 1);

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.emoji2.text.r f178h = new androidx.emoji2.text.r("SEALED", 1);

    /* renamed from: i, reason: collision with root package name */
    public static final u0 f179i = new u0(false);

    /* renamed from: j, reason: collision with root package name */
    public static final u0 f180j = new u0(true);

    public static final Object A(f5.h hVar, p5.p pVar, f5.c cVar) {
        Object objY;
        f5.h context = cVar.getContext();
        f5.h hVarT = !((Boolean) hVar.z(Boolean.FALSE, new y(0))).booleanValue() ? context.t(hVar) : i(context, hVar, false);
        h(hVarT);
        if (hVarT == context) {
            f6.p pVar2 = new f6.p(cVar, hVarT);
            objY = b8.h.M(pVar2, true, pVar2, pVar);
        } else {
            f5.d dVar = f5.d.f2625a;
            if (kotlin.jvm.internal.p.a(hVarT.o(dVar), context.o(dVar))) {
                e2 e2Var = new e2(cVar, hVarT);
                f5.h hVar2 = e2Var.f128c;
                Object objN = f6.a.n(hVar2, null);
                try {
                    Object objM = b8.h.M(e2Var, true, e2Var, pVar);
                    f6.a.g(hVar2, objN);
                    objY = objM;
                } catch (Throwable th) {
                    f6.a.g(hVar2, objN);
                    throw th;
                }
            } else {
                p0 p0Var = new p0(cVar, hVarT);
                try {
                    f6.a.h(b8.h.u(b8.h.k(p0Var, p0Var, pVar)), b5.a0.f883a);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = p0.f205e;
                    while (true) {
                        int i8 = atomicIntegerFieldUpdater.get(p0Var);
                        if (i8 != 0) {
                            if (i8 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            objY = y(p1.f206a.get(p0Var));
                            if (objY instanceof v) {
                                throw ((v) objY).f222a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(p0Var, 0, 1)) {
                            objY = g5.a.f2984a;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    a.a.D(p0Var, th2);
                    throw null;
                }
            }
        }
        g5.a aVar = g5.a.f2984a;
        return objY;
    }

    public static final Object B(long j4, p5.p pVar, h5.c cVar) {
        if (j4 <= 0) {
            throw new a2("Timed out immediately", null);
        }
        Object objW = w(new b2(j4, cVar), pVar);
        g5.a aVar = g5.a.f2984a;
        return objW;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object C(long r6, p5.p r8, h5.c r9) {
        /*
            boolean r0 = r9 instanceof a6.c2
            if (r0 == 0) goto L13
            r0 = r9
            a6.c2 r0 = (a6.c2) r0
            int r1 = r0.f147c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f147c = r1
            goto L18
        L13:
            a6.c2 r0 = new a6.c2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f146b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f147c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.y r6 = r0.f145a
            a.a.c0(r9)     // Catch: a6.a2 -> L29
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
            a.a.c0(r9)
            r4 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L3d
            goto L5d
        L3d:
            kotlin.jvm.internal.y r9 = new kotlin.jvm.internal.y
            r9.<init>()
            r0.f145a = r9     // Catch: a6.a2 -> L55
            r0.f147c = r3     // Catch: a6.a2 -> L55
            a6.b2 r2 = new a6.b2     // Catch: a6.a2 -> L55
            r2.<init>(r6, r0)     // Catch: a6.a2 -> L55
            r9.f3686a = r2     // Catch: a6.a2 -> L55
            java.lang.Object r6 = w(r2, r8)     // Catch: a6.a2 -> L55
            if (r6 != r1) goto L54
            return r1
        L54:
            return r6
        L55:
            r7 = move-exception
            r6 = r9
        L57:
            a6.h1 r8 = r7.f134a
            java.lang.Object r6 = r6.f3686a
            if (r8 != r6) goto L5f
        L5d:
            r6 = 0
            return r6
        L5f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.i0.C(long, p5.p, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object D(h5.c r7) {
        /*
            f5.h r0 = r7.getContext()
            h(r0)
            f5.c r7 = b8.h.u(r7)
            boolean r1 = r7 instanceof f6.e
            if (r1 == 0) goto L12
            f6.e r7 = (f6.e) r7
            goto L13
        L12:
            r7 = 0
        L13:
            b5.a0 r1 = b5.a0.f883a
            if (r7 != 0) goto L1a
        L17:
            r7 = r1
            goto L88
        L1a:
            a6.b0 r2 = r7.d
            boolean r3 = f6.a.j(r2, r0)
            r4 = 1
            if (r3 == 0) goto L2b
            r7.f2639f = r1
            r7.f209c = r4
            r2.E(r0, r7)
            goto L86
        L2b:
            a6.h2 r3 = new a6.h2
            a6.c0 r5 = a6.h2.f168c
            r3.<init>(r5)
            f5.h r0 = r0.t(r3)
            r7.f2639f = r1
            r7.f209c = r4
            r2.E(r0, r7)
            boolean r0 = r3.f169b
            if (r0 == 0) goto L86
            a6.a1 r0 = a6.z1.a()
            c5.j r2 = r0.f133e
            if (r2 == 0) goto L4e
            boolean r2 = r2.isEmpty()
            goto L4f
        L4e:
            r2 = r4
        L4f:
            if (r2 == 0) goto L52
            goto L17
        L52:
            long r2 = r0.f132c
            r5 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L5f
            r2 = r4
            goto L60
        L5f:
            r2 = 0
        L60:
            if (r2 == 0) goto L6c
            r7.f2639f = r1
            r7.f209c = r4
            r0.I(r7)
            g5.a r7 = g5.a.f2984a
            goto L88
        L6c:
            r0.K(r4)
            r7.run()     // Catch: java.lang.Throwable -> L7c
        L72:
            boolean r2 = r0.M()     // Catch: java.lang.Throwable -> L7c
            if (r2 != 0) goto L72
        L78:
            r0.H(r4)
            goto L17
        L7c:
            r2 = move-exception
            r7.g(r2)     // Catch: java.lang.Throwable -> L81
            goto L78
        L81:
            r7 = move-exception
            r0.H(r4)
            throw r7
        L86:
            g5.a r7 = g5.a.f2984a
        L88:
            g5.a r0 = g5.a.f2984a
            if (r7 != r0) goto L8d
            return r7
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.i0.D(h5.c):java.lang.Object");
    }

    public static s a() {
        s sVar = new s(true);
        sVar.O(null);
        return sVar;
    }

    public static final l4.a b(f5.h hVar) {
        if (hVar.o(c0.f143b) == null) {
            hVar = hVar.t(new j1(null));
        }
        return new l4.a(hVar);
    }

    public static x1 c() {
        return new x1(null);
    }

    public static m0 d(f0 f0Var, f5.h hVar, p5.p pVar, int i8) {
        if ((i8 & 1) != 0) {
            hVar = f5.i.f2626a;
        }
        g0 g0Var = g0.f162a;
        f5.h hVarR = r(f0Var, hVar);
        g0 g0Var2 = g0.f162a;
        m0 m0Var = new m0(hVarR, true);
        m0Var.h0(g0Var, m0Var, pVar);
        return m0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object e(ArrayList arrayList, h5.i iVar) {
        if (arrayList.isEmpty()) {
            return c5.s.f1092a;
        }
        l0[] l0VarArr = (l0[]) arrayList.toArray(new l0[0]);
        e eVar = new e(l0VarArr);
        m mVar = new m(1, b8.h.u(iVar));
        mVar.t();
        int length = l0VarArr.length;
        c[] cVarArr = new c[length];
        for (int i8 = 0; i8 < length; i8++) {
            r rVar = l0VarArr[i8];
            ((p1) rVar).start();
            c cVar = new c(eVar, mVar);
            cVar.f140f = o(rVar, true, cVar);
            cVarArr[i8] = cVar;
        }
        d dVar = new d(cVarArr);
        for (int i9 = 0; i9 < length; i9++) {
            c cVar2 = cVarArr[i9];
            cVar2.getClass();
            c.f138h.set(cVar2, dVar);
        }
        if (m.f190g.get(mVar) instanceof t1) {
            mVar.w(dVar);
        } else {
            dVar.b();
        }
        Object objS = mVar.s();
        g5.a aVar = g5.a.f2984a;
        return objS;
    }

    public static final void f(f0 f0Var, CancellationException cancellationException) {
        h1 h1Var = (h1) f0Var.b().o(c0.f143b);
        if (h1Var != null) {
            h1Var.e(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + f0Var).toString());
        }
    }

    public static final Object g(long j4, h5.c cVar) {
        if (j4 > 0) {
            m mVar = new m(1, b8.h.u(cVar));
            mVar.t();
            if (j4 < Util.VLI_MAX) {
                j(mVar.f192e).u(j4, mVar);
            }
            Object objS = mVar.s();
            if (objS == g5.a.f2984a) {
                return objS;
            }
        }
        return b5.a0.f883a;
    }

    public static final void h(f5.h hVar) {
        h1 h1Var = (h1) hVar.o(c0.f143b);
        if (h1Var != null && !h1Var.a()) {
            throw h1Var.v();
        }
    }

    public static final f5.h i(f5.h hVar, f5.h hVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.z(bool, new y(0))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.z(bool, new y(0))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.t(hVar2);
        }
        y yVar = new y(1);
        f5.i iVar = f5.i.f2626a;
        f5.h hVar3 = (f5.h) hVar.z(iVar, yVar);
        Object objZ = hVar2;
        if (zBooleanValue2) {
            objZ = hVar2.z(iVar, new y(2));
        }
        return hVar3.t((f5.h) objZ);
    }

    public static final n0 j(f5.h hVar) {
        f5.f fVarO = hVar.o(f5.d.f2625a);
        n0 n0Var = fVarO instanceof n0 ? (n0) fVarO : null;
        return n0Var == null ? k0.f185a : n0Var;
    }

    public static final String k(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final h1 l(f5.h hVar) {
        h1 h1Var = (h1) hVar.o(c0.f143b);
        if (h1Var != null) {
            return h1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + hVar).toString());
    }

    public static final m m(f5.c cVar) {
        m mVar;
        m mVar2;
        if (!(cVar instanceof f6.e)) {
            return new m(1, cVar);
        }
        f6.e eVar = (f6.e) cVar;
        androidx.emoji2.text.r rVar = f6.a.f2629c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.e.f2637h;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(eVar);
            mVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(eVar, rVar);
                mVar2 = null;
                break;
            }
            if (obj instanceof m) {
                while (!atomicReferenceFieldUpdater.compareAndSet(eVar, obj, rVar)) {
                    if (atomicReferenceFieldUpdater.get(eVar) != obj) {
                        break;
                    }
                }
                mVar2 = (m) obj;
                break loop0;
            }
            if (obj != rVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (mVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = m.f190g;
            Object obj2 = atomicReferenceFieldUpdater2.get(mVar2);
            if (!(obj2 instanceof u) || ((u) obj2).d == null) {
                m.f189f.set(mVar2, 536870911);
                atomicReferenceFieldUpdater2.set(mVar2, b.f135a);
                mVar = mVar2;
            } else {
                mVar2.o();
            }
            if (mVar != null) {
                return mVar;
            }
        }
        return new m(2, cVar);
    }

    public static final void n(f5.h hVar, Throwable th) {
        if (th instanceof o0) {
            th = ((o0) th).f201a;
        }
        try {
            if (((d0) hVar.o(c0.f142a)) != null) {
                return;
            }
            f6.a.d(hVar, th);
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a.a.a(runtimeException, th);
                th = runtimeException;
            }
            f6.a.d(hVar, th);
        }
    }

    public static final s0 o(h1 h1Var, boolean z, l1 l1Var) {
        if (h1Var instanceof p1) {
            return ((p1) h1Var).P(z, l1Var);
        }
        return h1Var.n(l1Var.k(), z, new k1(1, l1Var, l1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(java.util.List r4, f5.c r5) {
        /*
            boolean r0 = r5 instanceof a6.f
            if (r0 == 0) goto L13
            r0 = r5
            a6.f r0 = (a6.f) r0
            int r1 = r0.f158c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f158c = r1
            goto L18
        L13:
            a6.f r0 = new a6.f
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f157b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f158c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.util.Iterator r4 = r0.f156a
            a.a.c0(r5)
            goto L38
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r5)
            java.util.Iterator r4 = r4.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            a6.h1 r5 = (a6.h1) r5
            r0.f156a = r4
            r0.f158c = r3
            java.lang.Object r5 = r5.j(r0)
            if (r5 != r1) goto L38
            return r1
        L4f:
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.i0.p(java.util.List, f5.c):java.lang.Object");
    }

    public static v1 q(f0 f0Var, f5.h hVar, p5.p pVar, int i8) {
        if ((i8 & 1) != 0) {
            hVar = f5.i.f2626a;
        }
        g0 g0Var = g0.f162a;
        f5.h hVarR = r(f0Var, hVar);
        g0 g0Var2 = g0.f162a;
        v1 v1Var = new v1(hVarR, true);
        v1Var.h0(g0Var, v1Var, pVar);
        return v1Var;
    }

    public static final f5.h r(f0 f0Var, f5.h hVar) {
        f5.h hVarI = i(f0Var.b(), hVar, true);
        h6.e eVar = r0.f210a;
        return (hVarI == eVar || hVarI.o(f5.d.f2625a) != null) ? hVarI : hVarI.t(eVar);
    }

    public static final Object s(Object obj) {
        return obj instanceof v ? a.a.o(((v) obj).f222a) : obj;
    }

    public static final void t(m mVar, f5.c cVar, boolean z) {
        Object obj = m.f190g.get(mVar);
        Throwable thE = mVar.e(obj);
        Object objO = thE != null ? a.a.o(thE) : mVar.f(obj);
        if (!z) {
            cVar.resumeWith(objO);
            return;
        }
        kotlin.jvm.internal.p.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        f6.e eVar = (f6.e) cVar;
        h5.c cVar2 = eVar.f2638e;
        Object obj2 = eVar.f2640g;
        f5.h context = cVar2.getContext();
        Object objN = f6.a.n(context, obj2);
        e2 e2VarZ = objN != f6.a.d ? z(cVar2, context, objN) : null;
        try {
            cVar2.resumeWith(objO);
            if (e2VarZ == null || e2VarZ.j0()) {
                f6.a.g(context, objN);
            }
        } catch (Throwable th) {
            if (e2VarZ == null || e2VarZ.j0()) {
                f6.a.g(context, objN);
            }
            throw th;
        }
    }

    public static final Object u(f5.h hVar, p5.p pVar) throws Throwable {
        a1 a1VarA;
        f5.h hVarI;
        long jL;
        Thread threadCurrentThread = Thread.currentThread();
        f5.g gVar = f5.d.f2625a;
        f5.e eVar = (f5.e) hVar.o(gVar);
        f5.i iVar = f5.i.f2626a;
        if (eVar == null) {
            a1VarA = z1.a();
            hVarI = i(iVar, hVar.t(a1VarA), true);
            h6.e eVar2 = r0.f210a;
            if (hVarI != eVar2 && hVarI.o(gVar) == null) {
                hVarI = hVarI.t(eVar2);
            }
        } else {
            if (eVar instanceof a1) {
            }
            a1VarA = (a1) z1.f233a.get();
            hVarI = i(iVar, hVar, true);
            h6.e eVar3 = r0.f210a;
            if (hVarI != eVar3 && hVarI.o(gVar) == null) {
                hVarI = hVarI.t(eVar3);
            }
        }
        g gVar2 = new g(hVarI, threadCurrentThread, a1VarA);
        gVar2.h0(g0.f162a, gVar2, pVar);
        a1 a1Var = gVar2.f161e;
        if (a1Var != null) {
            int i8 = a1.f131f;
            a1Var.K(false);
        }
        while (true) {
            if (a1Var != null) {
                try {
                    jL = a1Var.L();
                } catch (Throwable th) {
                    if (a1Var != null) {
                        int i9 = a1.f131f;
                        a1Var.H(false);
                    }
                    throw th;
                }
            } else {
                jL = Util.VLI_MAX;
            }
            if (gVar2.Q()) {
                break;
            }
            LockSupport.parkNanos(gVar2, jL);
            if (Thread.interrupted()) {
                gVar2.x(new InterruptedException());
            }
        }
        if (a1Var != null) {
            int i10 = a1.f131f;
            a1Var.H(false);
        }
        Object objY = y(p1.f206a.get(gVar2));
        v vVar = objY instanceof v ? (v) objY : null;
        if (vVar == null) {
            return objY;
        }
        throw vVar.f222a;
    }

    public static final Object w(b2 b2Var, p5.p pVar) {
        o(b2Var, true, new t0(0, j(b2Var.d.getContext()).b(b2Var.f137e, b2Var, b2Var.f128c)));
        return b8.h.M(b2Var, false, b2Var, pVar);
    }

    public static final String x(f5.c cVar) {
        Object objO;
        if (cVar instanceof f6.e) {
            return ((f6.e) cVar).toString();
        }
        try {
            objO = cVar + '@' + k(cVar);
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        if (b5.i.a(objO) != null) {
            objO = cVar.getClass().getName() + '@' + k(cVar);
        }
        return (String) objO;
    }

    public static final Object y(Object obj) {
        e1 e1Var;
        f1 f1Var = obj instanceof f1 ? (f1) obj : null;
        return (f1Var == null || (e1Var = f1Var.f159a) == null) ? obj : e1Var;
    }

    public static final e2 z(f5.c cVar, f5.h hVar, Object obj) {
        e2 e2Var = null;
        if ((cVar instanceof h5.d) && hVar.o(f2.f160a) != null) {
            h5.d callerFrame = (h5.d) cVar;
            while (true) {
                if ((callerFrame instanceof p0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof e2) {
                    e2Var = (e2) callerFrame;
                    break;
                }
            }
            if (e2Var != null) {
                e2Var.l0(hVar, obj);
            }
        }
        return e2Var;
    }
}
