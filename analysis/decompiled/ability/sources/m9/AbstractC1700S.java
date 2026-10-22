package m9;

import androidx.compose.animation.core.AnimationKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* renamed from: m9.S, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1700S extends AbstractC1701T implements InterfaceC1688F {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(AbstractC1700S.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1700S.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(AbstractC1700S.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // m9.AbstractC1701T
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long I() {
        /*
            r10 = this;
            a5.d r0 = m9.AbstractC1683A.c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = m9.AbstractC1700S.e
            boolean r2 = r10.J()
            r3 = 0
            if (r2 == 0) goto Le
            goto Laa
        Le:
            r10.M()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L40
        L1a:
            boolean r6 = r2 instanceof s9.j
            if (r6 == 0) goto L34
            r6 = r2
            s9.j r6 = (s9.j) r6
            java.lang.Object r7 = r6.d()
            a5.d r8 = s9.j.g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L40
        L2c:
            s9.j r5 = r6.c()
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
            D7.p r2 = r10.c
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
            boolean r2 = r1 instanceof s9.j
            if (r2 == 0) goto L83
            s9.j r1 = (s9.j) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = s9.j.f
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.AbstractC1700S.f
            java.lang.Object r10 = r0.get(r10)
            m9.Q r10 = (m9.C1699Q) r10
            if (r10 == 0) goto Lae
            monitor-enter(r10)
            m9.P[] r0 = r10.f6010a     // Catch: java.lang.Throwable -> L99
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
            long r0 = r5.f5318a
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
        throw new UnsupportedOperationException("Method not decompiled: m9.AbstractC1700S.I():long");
    }

    public void L(Runnable runnable) {
        M();
        if (!N(runnable)) {
            RunnableC1684B.h.L(runnable);
            return;
        }
        Thread threadG = G();
        if (Thread.currentThread() != threadG) {
            LockSupport.unpark(threadG);
        }
    }

    public final void M() {
        AbstractRunnableC1698P abstractRunnableC1698PB;
        C1699Q c1699q = (C1699Q) f.get(this);
        if (c1699q == null || s9.u.b.get(c1699q) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (c1699q) {
                try {
                    AbstractRunnableC1698P[] abstractRunnableC1698PArr = c1699q.f6010a;
                    AbstractRunnableC1698P abstractRunnableC1698P = abstractRunnableC1698PArr != null ? abstractRunnableC1698PArr[0] : null;
                    if (abstractRunnableC1698P != null) {
                        abstractRunnableC1698PB = ((jNanoTime - abstractRunnableC1698P.f5318a) > 0L ? 1 : ((jNanoTime - abstractRunnableC1698P.f5318a) == 0L ? 0 : -1)) >= 0 ? N(abstractRunnableC1698P) : false ? c1699q.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (abstractRunnableC1698PB != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean N(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.AbstractC1700S.e
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = m9.AbstractC1700S.g
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
            boolean r4 = r1 instanceof s9.j
            if (r4 == 0) goto L36
            r4 = r1
            s9.j r4 = (s9.j) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L51
            if (r5 == r2) goto L2e
            r0 = 2
            if (r5 == r0) goto L3a
            goto L0
        L2e:
            s9.j r2 = r4.c()
            r0.compareAndSet(r6, r1, r2)
            goto L0
        L36:
            a5.d r4 = m9.AbstractC1683A.c
            if (r1 != r4) goto L3b
        L3a:
            return r3
        L3b:
            s9.j r3 = new s9.j
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
        throw new UnsupportedOperationException("Method not decompiled: m9.AbstractC1700S.N(java.lang.Runnable):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean O() {
        /*
            r7 = this;
            D7.p r0 = r7.c
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.AbstractC1700S.f
            java.lang.Object r0 = r0.get(r7)
            m9.Q r0 = (m9.C1699Q) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = s9.u.b
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.AbstractC1700S.e
            java.lang.Object r7 = r0.get(r7)
            if (r7 != 0) goto L30
            goto L53
        L30:
            boolean r0 = r7 instanceof s9.j
            if (r0 == 0) goto L4f
            s9.j r7 = (s9.j) r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = s9.j.f
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
            a5.d r0 = m9.AbstractC1683A.c
            if (r7 != r0) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.AbstractC1700S.O():boolean");
    }

    public final void P(long j5, AbstractRunnableC1698P abstractRunnableC1698P) {
        int iC;
        Thread threadG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        if (g.get(this) != 0) {
            iC = 1;
        } else {
            C1699Q c1699q = (C1699Q) atomicReferenceFieldUpdater.get(this);
            if (c1699q == null) {
                C1699Q c1699q2 = new C1699Q();
                c1699q2.c = j5;
                atomicReferenceFieldUpdater.compareAndSet(this, null, c1699q2);
                Object obj = atomicReferenceFieldUpdater.get(this);
                kotlin.jvm.internal.k.c(obj);
                c1699q = (C1699Q) obj;
            }
            iC = abstractRunnableC1698P.c(j5, c1699q, this);
        }
        if (iC != 0) {
            if (iC == 1) {
                K(j5, abstractRunnableC1698P);
                return;
            } else {
                if (iC != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        C1699Q c1699q3 = (C1699Q) atomicReferenceFieldUpdater.get(this);
        if (c1699q3 != null) {
            synchronized (c1699q3) {
                AbstractRunnableC1698P[] abstractRunnableC1698PArr = c1699q3.f6010a;
                abstractRunnableC1698P = abstractRunnableC1698PArr != null ? abstractRunnableC1698PArr[0] : null;
            }
        }
        if (abstractRunnableC1698P != abstractRunnableC1698P || Thread.currentThread() == (threadG = G())) {
            return;
        }
        LockSupport.unpark(threadG);
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        L(runnable);
    }

    public InterfaceC1693K l(long j5, Runnable runnable, H7.h hVar) {
        return AbstractC1685C.f5313a.l(j5, runnable, hVar);
    }

    @Override // m9.InterfaceC1688F
    public final void s(long j5, C1718k c1718k) {
        long j6 = j5 > 0 ? j5 >= 9223372036854L ? Long.MAX_VALUE : AnimationKt.MillisToNanos * j5 : 0L;
        if (j6 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            C1696N c1696n = new C1696N(this, j6 + jNanoTime, c1718k);
            P(jNanoTime, c1696n);
            c1718k.A(new C1715h(c1696n, 2));
        }
    }

    @Override // m9.AbstractC1701T
    public void shutdown() {
        AbstractRunnableC1698P abstractRunnableC1698PB;
        t0.f5334a.set(null);
        g.set(this, 1);
        a5.d dVar = AbstractC1683A.c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, dVar)) {
                    break;
                }
            } else if (obj instanceof s9.j) {
                ((s9.j) obj).b();
                break;
            } else {
                if (obj == dVar) {
                    break;
                }
                s9.j jVar = new s9.j(8, true);
                jVar.a((Runnable) obj);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, jVar)) {
                    break;
                }
            }
        }
        while (I() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            C1699Q c1699q = (C1699Q) f.get(this);
            if (c1699q == null) {
                return;
            }
            synchronized (c1699q) {
                abstractRunnableC1698PB = s9.u.b.get(c1699q) > 0 ? c1699q.b(0) : null;
            }
            if (abstractRunnableC1698PB == null) {
                return;
            } else {
                K(jNanoTime, abstractRunnableC1698PB);
            }
        }
    }
}
