package ia;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public abstract class w0 extends x0 implements j0 {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5018l = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_queue$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5019m = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_delayed$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5020n = AtomicIntegerFieldUpdater.newUpdater(w0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    public p0 C(long j2, Runnable runnable, g7.l lVar) {
        return i0.invokeOnTimeout(this, j2, runnable, lVar);
    }

    @Override // ia.x
    public final void R(g7.l lVar, Runnable runnable) {
        b0(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // ia.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long Y() {
        /*
            r10 = this;
            f8.x r0 = ia.d0.f4937c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = ia.w0.f5018l
            boolean r2 = r10.Z()
            r3 = 0
            if (r2 == 0) goto Le
            goto Lb4
        Le:
            r10.c0()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r2 instanceof na.n
            if (r6 == 0) goto L3e
            r6 = r2
            na.n r6 = (na.n) r6
            java.lang.Object r7 = r6.d()
            f8.x r8 = na.n.f6918g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            na.n r6 = r6.c()
        L30:
            boolean r5 = r1.compareAndSet(r10, r2, r6)
            if (r5 == 0) goto L37
            goto L11
        L37:
            java.lang.Object r5 = r1.get(r10)
            if (r5 == r2) goto L30
            goto L11
        L3e:
            if (r2 != r0) goto L41
            goto L18
        L41:
            boolean r6 = r1.compareAndSet(r10, r2, r5)
            if (r6 == 0) goto Lb9
            r7 = r2
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L4a:
            if (r7 == 0) goto L50
            r7.run()
            return r3
        L50:
            d7.m r2 = r10.f5025j
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != 0) goto L5b
        L59:
            r8 = r6
            goto L63
        L5b:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L62
            goto L59
        L62:
            r8 = r3
        L63:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L68
            goto Lb4
        L68:
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L90
            boolean r2 = r1 instanceof na.n
            if (r2 == 0) goto L8d
            na.n r1 = (na.n) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = na.n.f6917f
            long r0 = r0.get(r1)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r0
            int r2 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r0 = r0 & r8
            r8 = 30
            long r0 = r0 >> r8
            int r0 = (int) r0
            if (r2 != r0) goto L8c
            goto L90
        L8c:
            return r3
        L8d:
            if (r1 != r0) goto Lb4
            goto Lb8
        L90:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ia.w0.f5019m
            java.lang.Object r10 = r0.get(r10)
            ia.v0 r10 = (ia.v0) r10
            if (r10 == 0) goto Lb8
            monitor-enter(r10)
            ia.u0[] r0 = r10.f6931a     // Catch: java.lang.Throwable -> La3
            if (r0 == 0) goto La5
            r1 = 0
            r5 = r0[r1]     // Catch: java.lang.Throwable -> La3
            goto La5
        La3:
            r0 = move-exception
            goto Lb6
        La5:
            monitor-exit(r10)
            if (r5 != 0) goto La9
            goto Lb8
        La9:
            long r0 = r5.f5008f
            long r5 = java.lang.System.nanoTime()
            long r0 = r0 - r5
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 >= 0) goto Lb5
        Lb4:
            return r3
        Lb5:
            return r0
        Lb6:
            monitor-exit(r10)
            throw r0
        Lb8:
            return r6
        Lb9:
            java.lang.Object r6 = r1.get(r10)
            if (r6 == r2) goto L41
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.w0.Y():long");
    }

    public void b0(Runnable runnable) {
        c0();
        if (!d0(runnable)) {
            e0.f4949o.b0(runnable);
            return;
        }
        Thread threadW = W();
        if (Thread.currentThread() != threadW) {
            LockSupport.unpark(threadW);
        }
    }

    public final void c0() {
        u0 u0VarB;
        v0 v0Var = (v0) f5019m.get(this);
        if (v0Var == null || na.v.f6930b.get(v0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (v0Var) {
                try {
                    u0[] u0VarArr = v0Var.f6931a;
                    u0 u0Var = u0VarArr != null ? u0VarArr[0] : null;
                    if (u0Var != null) {
                        u0VarB = ((jNanoTime - u0Var.f5008f) > 0L ? 1 : ((jNanoTime - u0Var.f5008f) == 0L ? 0 : -1)) >= 0 ? d0(u0Var) : false ? v0Var.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (u0VarB != null);
    }

    public final boolean d0(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5018l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f5020n.get(this) != 1) {
                if (obj != null) {
                    if (!(obj instanceof na.n)) {
                        if (obj != d0.f4937c) {
                            na.n nVar = new na.n(8, true);
                            nVar.a((Runnable) obj);
                            nVar.a(runnable);
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        return false;
                    }
                    na.n nVar2 = (na.n) obj;
                    int iA = nVar2.a(runnable);
                    if (iA == 0) {
                        break;
                    }
                    if (iA == 1) {
                        na.n nVarC = nVar2.c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (iA == 2) {
                        return false;
                    }
                } else {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                        if (atomicReferenceFieldUpdater.get(this) != null) {
                            break;
                        }
                    }
                    break loop0;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0() {
        /*
            r7 = this;
            d7.m r0 = r7.f5025j
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ia.w0.f5019m
            java.lang.Object r0 = r0.get(r7)
            ia.v0 r0 = (ia.v0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = na.v.f6930b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ia.w0.f5018l
            java.lang.Object r7 = r0.get(r7)
            if (r7 != 0) goto L30
            goto L53
        L30:
            boolean r0 = r7 instanceof na.n
            if (r0 == 0) goto L4f
            na.n r7 = (na.n) r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = na.n.f6917f
            long r3 = r0.get(r7)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r7 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r0 = 30
            long r3 = r3 >> r0
            int r0 = (int) r3
            if (r7 != r0) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            f8.x r0 = ia.d0.f4937c
            if (r7 != r0) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.w0.e0():boolean");
    }

    public final void f0(long j2, u0 u0Var) {
        int iB;
        Thread threadW;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5019m;
        if (f5020n.get(this) == 1) {
            iB = 1;
        } else {
            v0 v0Var = (v0) atomicReferenceFieldUpdater.get(this);
            if (v0Var == null) {
                v0 v0Var2 = new v0();
                v0Var2.f5012c = j2;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, v0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                q7.k.b(obj);
                v0Var = (v0) obj;
            }
            iB = u0Var.b(j2, v0Var, this);
        }
        if (iB != 0) {
            if (iB == 1) {
                a0(j2, u0Var);
                return;
            } else {
                if (iB != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        v0 v0Var3 = (v0) atomicReferenceFieldUpdater.get(this);
        if (v0Var3 != null) {
            synchronized (v0Var3) {
                u0[] u0VarArr = v0Var3.f6931a;
                u0Var = u0VarArr != null ? u0VarArr[0] : null;
            }
        }
        if (u0Var != u0Var || Thread.currentThread() == (threadW = W())) {
            return;
        }
        LockSupport.unpark(threadW);
    }

    @Override // ia.j0
    public final void k(long j2, m mVar) {
        long j4 = j2 > 0 ? j2 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j2 : 0L;
        if (j4 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            s0 s0Var = new s0(this, j4 + jNanoTime, mVar);
            f0(jNanoTime, s0Var);
            mVar.v(new h(2, s0Var));
        }
    }

    @Override // ia.x0
    public void shutdown() {
        u0 u0VarB;
        z1.f5029a.set(null);
        f5020n.set(this, 1);
        f8.x xVar = d0.f4937c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5018l;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof na.n)) {
                    if (obj != xVar) {
                        na.n nVar = new na.n(8, true);
                        nVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((na.n) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, xVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (Y() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            v0 v0Var = (v0) f5019m.get(this);
            if (v0Var == null) {
                return;
            }
            synchronized (v0Var) {
                u0VarB = na.v.f6930b.get(v0Var) > 0 ? v0Var.b(0) : null;
            }
            if (u0VarB == null) {
                return;
            } else {
                a0(jNanoTime, u0VarB);
            }
        }
    }
}
