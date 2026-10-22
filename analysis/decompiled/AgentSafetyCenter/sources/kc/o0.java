package kc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o0 extends j0 implements a0 {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7466j = AtomicReferenceFieldUpdater.newUpdater(o0.class, Object.class, "_queue$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7467k = AtomicReferenceFieldUpdater.newUpdater(o0.class, Object.class, "_delayed$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7468l = AtomicIntegerFieldUpdater.newUpdater(o0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // kc.a0
    public final void F(long j10, g gVar) {
        long j11 = j10 > 0 ? j10 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j10 : 0L;
        if (j11 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            k0 k0Var = new k0(this, j11 + jNanoTime, gVar);
            b0(jNanoTime, k0Var);
            w.h(gVar, k0Var);
        }
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        V(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // kc.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long T() {
        /*
            r10 = this;
            pc.t r0 = kc.w.f7491c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kc.o0.f7466j
            boolean r2 = r10.U()
            r3 = 0
            if (r2 == 0) goto Le
            goto Laa
        Le:
            r10.W()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L40
        L1a:
            boolean r6 = r2 instanceof pc.m
            if (r6 == 0) goto L34
            r6 = r2
            pc.m r6 = (pc.m) r6
            java.lang.Object r7 = r6.d()
            pc.t r8 = pc.m.f9973g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L40
        L2c:
            pc.m r5 = r6.c()
            r1.compareAndSet(r10, r2, r5)
            goto L11
        L34:
            if (r2 != r0) goto L37
            goto L18
        L37:
            boolean r6 = r1.compareAndSet(r10, r2, r5)
            if (r6 == 0) goto L11
            r7 = r2
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L40:
            if (r7 == 0) goto L46
            r7.run()
            return r3
        L46:
            kb.j r2 = r10.f7446h
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != 0) goto L51
        L4f:
            r8 = r6
            goto L59
        L51:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L58
            goto L4f
        L58:
            r8 = r3
        L59:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L5e
            goto Laa
        L5e:
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L86
            boolean r2 = r1 instanceof pc.m
            if (r2 == 0) goto L83
            pc.m r1 = (pc.m) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pc.m.f9972f
            long r0 = r0.get(r1)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r0
            int r2 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r0 = r0 & r8
            r8 = 30
            long r0 = r0 >> r8
            int r0 = (int) r0
            if (r2 != r0) goto L82
            goto L86
        L82:
            return r3
        L83:
            if (r1 != r0) goto Laa
            goto Lae
        L86:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.o0.f7467k
            java.lang.Object r10 = r0.get(r10)
            kc.n0 r10 = (kc.n0) r10
            if (r10 == 0) goto Lae
            monitor-enter(r10)
            kc.m0[] r0 = r10.f9992a     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L9b
            r1 = 0
            r5 = r0[r1]     // Catch: java.lang.Throwable -> L99
            goto L9b
        L99:
            r0 = move-exception
            goto Lac
        L9b:
            monitor-exit(r10)
            if (r5 != 0) goto L9f
            goto Lae
        L9f:
            long r0 = r5.f7456c
            long r5 = java.lang.System.nanoTime()
            long r0 = r0 - r5
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 >= 0) goto Lab
        Laa:
            return r3
        Lab:
            return r0
        Lac:
            monitor-exit(r10)
            throw r0
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.o0.T():long");
    }

    public void V(Runnable runnable) {
        W();
        if (!X(runnable)) {
            x.f7499m.V(runnable);
            return;
        }
        Thread threadY = Y();
        if (Thread.currentThread() != threadY) {
            LockSupport.unpark(threadY);
        }
    }

    public final void W() {
        m0 m0VarB;
        n0 n0Var = (n0) f7467k.get(this);
        if (n0Var == null || pc.x.f9991b.get(n0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (n0Var) {
                try {
                    m0[] m0VarArr = n0Var.f9992a;
                    m0 m0Var = m0VarArr != null ? m0VarArr[0] : null;
                    if (m0Var != null) {
                        m0VarB = ((jNanoTime - m0Var.f7456c) > 0L ? 1 : ((jNanoTime - m0Var.f7456c) == 0L ? 0 : -1)) >= 0 ? X(m0Var) : false ? n0Var.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (m0VarB != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.o0.f7466j
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = kc.o0.f7468l
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L1b
            r1 = 0
            boolean r0 = r0.compareAndSet(r6, r1, r7)
            if (r0 == 0) goto L0
            goto L51
        L1b:
            boolean r4 = r1 instanceof pc.m
            if (r4 == 0) goto L36
            r4 = r1
            pc.m r4 = (pc.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L51
            if (r5 == r2) goto L2e
            r0 = 2
            if (r5 == r0) goto L3a
            goto L0
        L2e:
            pc.m r2 = r4.c()
            r0.compareAndSet(r6, r1, r2)
            goto L0
        L36:
            pc.t r4 = kc.w.f7491c
            if (r1 != r4) goto L3b
        L3a:
            return r3
        L3b:
            pc.m r3 = new pc.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
            boolean r0 = r0.compareAndSet(r6, r1, r3)
            if (r0 == 0) goto L0
        L51:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.o0.X(java.lang.Runnable):boolean");
    }

    public abstract Thread Y();

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Z() {
        /*
            r7 = this;
            kb.j r0 = r7.f7446h
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.o0.f7467k
            java.lang.Object r0 = r0.get(r7)
            kc.n0 r0 = (kc.n0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = pc.x.f9991b
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kc.o0.f7466j
            java.lang.Object r7 = r0.get(r7)
            if (r7 != 0) goto L30
            goto L53
        L30:
            boolean r0 = r7 instanceof pc.m
            if (r0 == 0) goto L4f
            pc.m r7 = (pc.m) r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pc.m.f9972f
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
            pc.t r0 = kc.w.f7491c
            if (r7 != r0) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.o0.Z():boolean");
    }

    public void a0(long j10, m0 m0Var) {
        x.f7499m.b0(j10, m0Var);
    }

    public final void b0(long j10, m0 m0Var) {
        int iB;
        Thread threadY;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7467k;
        if (f7468l.get(this) != 0) {
            iB = 1;
        } else {
            n0 n0Var = (n0) atomicReferenceFieldUpdater.get(this);
            if (n0Var == null) {
                n0 n0Var2 = new n0();
                n0Var2.f7462c = j10;
                atomicReferenceFieldUpdater.compareAndSet(this, null, n0Var2);
                Object obj = atomicReferenceFieldUpdater.get(this);
                obj.getClass();
                n0Var = (n0) obj;
            }
            iB = m0Var.b(j10, n0Var, this);
        }
        if (iB != 0) {
            if (iB == 1) {
                a0(j10, m0Var);
                return;
            } else {
                if (iB == 2) {
                    return;
                }
                od.f.e("unexpected result");
                return;
            }
        }
        n0 n0Var3 = (n0) atomicReferenceFieldUpdater.get(this);
        if (n0Var3 != null) {
            synchronized (n0Var3) {
                m0[] m0VarArr = n0Var3.f9992a;
                m0Var = m0VarArr != null ? m0VarArr[0] : null;
            }
        }
        if (m0Var != m0Var || Thread.currentThread() == (threadY = Y())) {
            return;
        }
        LockSupport.unpark(threadY);
    }

    @Override // kc.a0
    public g0 n(long j10, o1 o1Var, nb.g gVar) {
        return y.f7501a.n(j10, o1Var, gVar);
    }

    @Override // kc.j0
    public void shutdown() {
        m0 m0VarB;
        l1.f7450a.set(null);
        f7468l.set(this, 1);
        pc.t tVar = w.f7491c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7466j;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, tVar)) {
                    break;
                }
            } else if (obj instanceof pc.m) {
                ((pc.m) obj).b();
                break;
            } else {
                if (obj == tVar) {
                    break;
                }
                pc.m mVar = new pc.m(8, true);
                mVar.a((Runnable) obj);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                    break;
                }
            }
        }
        while (T() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            n0 n0Var = (n0) f7467k.get(this);
            if (n0Var == null) {
                return;
            }
            synchronized (n0Var) {
                m0VarB = pc.x.f9991b.get(n0Var) > 0 ? n0Var.b(0) : null;
            }
            if (m0VarB == null) {
                return;
            } else {
                a0(jNanoTime, m0VarB);
            }
        }
    }
}
