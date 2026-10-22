package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z0 extends a1 implements n0 {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f230g = AtomicReferenceFieldUpdater.newUpdater(z0.class, Object.class, "_queue$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f231h = AtomicReferenceFieldUpdater.newUpdater(z0.class, Object.class, "_delayed$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f232j = AtomicIntegerFieldUpdater.newUpdater(z0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // a6.b0
    public final void C(f5.h hVar, Runnable runnable) {
        O(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // a6.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long L() {
        /*
            r10 = this;
            androidx.emoji2.text.r r0 = a6.i0.f174c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = a6.z0.f230g
            boolean r2 = r10.M()
            r3 = 0
            if (r2 == 0) goto Le
            goto Lb4
        Le:
            r10.P()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r2 instanceof f6.l
            if (r6 == 0) goto L3e
            r6 = r2
            f6.l r6 = (f6.l) r6
            java.lang.Object r7 = r6.d()
            androidx.emoji2.text.r r8 = f6.l.f2653g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            f6.l r6 = r6.c()
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
            c5.j r2 = r10.f133e
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
            boolean r2 = r1 instanceof f6.l
            if (r2 == 0) goto L8d
            f6.l r1 = (f6.l) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f6.l.f2652f
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.z0.f231h
            java.lang.Object r10 = r0.get(r10)
            a6.y0 r10 = (a6.y0) r10
            if (r10 == 0) goto Lb8
            monitor-enter(r10)
            a6.x0[] r0 = r10.f2663a     // Catch: java.lang.Throwable -> La3
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
            long r0 = r5.f225a
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
        throw new UnsupportedOperationException("Method not decompiled: a6.z0.L():long");
    }

    public void O(Runnable runnable) {
        P();
        if (!Q(runnable)) {
            j0.f182k.O(runnable);
            return;
        }
        Thread threadJ = J();
        if (Thread.currentThread() != threadJ) {
            LockSupport.unpark(threadJ);
        }
    }

    public final void P() {
        x0 x0VarB;
        y0 y0Var = (y0) f231h.get(this);
        if (y0Var == null || f6.t.f2662b.get(y0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (y0Var) {
                try {
                    x0[] x0VarArr = y0Var.f2663a;
                    x0 x0Var = x0VarArr != null ? x0VarArr[0] : null;
                    if (x0Var != null) {
                        x0VarB = ((jNanoTime - x0Var.f225a) > 0L ? 1 : ((jNanoTime - x0Var.f225a) == 0L ? 0 : -1)) >= 0 ? Q(x0Var) : false ? y0Var.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (x0VarB != null);
    }

    public final boolean Q(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f230g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f232j.get(this) != 1) {
                if (obj != null) {
                    if (!(obj instanceof f6.l)) {
                        if (obj != i0.f174c) {
                            f6.l lVar = new f6.l(8, true);
                            lVar.a((Runnable) obj);
                            lVar.a(runnable);
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lVar)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        return false;
                    }
                    f6.l lVar2 = (f6.l) obj;
                    int iA = lVar2.a(runnable);
                    if (iA == 0) {
                        break;
                    }
                    if (iA == 1) {
                        f6.l lVarC = lVar2.c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
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
    public final boolean R() {
        /*
            r7 = this;
            c5.j r0 = r7.f133e
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.z0.f231h
            java.lang.Object r0 = r0.get(r7)
            a6.y0 r0 = (a6.y0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = f6.t.f2662b
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.z0.f230g
            java.lang.Object r7 = r0.get(r7)
            if (r7 != 0) goto L30
            goto L53
        L30:
            boolean r0 = r7 instanceof f6.l
            if (r0 == 0) goto L4f
            f6.l r7 = (f6.l) r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f6.l.f2652f
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
            androidx.emoji2.text.r r0 = a6.i0.f174c
            if (r7 != r0) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.z0.R():boolean");
    }

    public final void S(long j4, x0 x0Var) {
        int iA;
        Thread threadJ;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f231h;
        if (f232j.get(this) == 1) {
            iA = 1;
        } else {
            y0 y0Var = (y0) atomicReferenceFieldUpdater.get(this);
            if (y0Var == null) {
                y0 y0Var2 = new y0();
                y0Var2.f228c = j4;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, y0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                kotlin.jvm.internal.p.b(obj);
                y0Var = (y0) obj;
            }
            iA = x0Var.a(j4, y0Var, this);
        }
        if (iA != 0) {
            if (iA == 1) {
                N(j4, x0Var);
                return;
            } else {
                if (iA != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        y0 y0Var3 = (y0) atomicReferenceFieldUpdater.get(this);
        if (y0Var3 != null) {
            synchronized (y0Var3) {
                x0[] x0VarArr = y0Var3.f2663a;
                x0Var = x0VarArr != null ? x0VarArr[0] : null;
            }
        }
        if (x0Var != x0Var || Thread.currentThread() == (threadJ = J())) {
            return;
        }
        LockSupport.unpark(threadJ);
    }

    public s0 b(long j4, b2 b2Var, f5.h hVar) {
        return k0.f185a.b(j4, b2Var, hVar);
    }

    @Override // a6.a1
    public void shutdown() {
        x0 x0VarB;
        z1.f233a.set(null);
        f232j.set(this, 1);
        androidx.emoji2.text.r rVar = i0.f174c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f230g;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof f6.l)) {
                    if (obj != rVar) {
                        f6.l lVar = new f6.l(8, true);
                        lVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((f6.l) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, rVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (L() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            y0 y0Var = (y0) f231h.get(this);
            if (y0Var == null) {
                return;
            }
            synchronized (y0Var) {
                x0VarB = f6.t.f2662b.get(y0Var) > 0 ? y0Var.b(0) : null;
            }
            if (x0VarB == null) {
                return;
            } else {
                N(jNanoTime, x0VarB);
            }
        }
    }

    @Override // a6.n0
    public final void u(long j4, m mVar) {
        long j8 = j4 > 0 ? j4 >= 9223372036854L ? Util.VLI_MAX : 1000000 * j4 : 0L;
        if (j8 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            v0 v0Var = new v0(this, j8 + jNanoTime, mVar);
            S(jNanoTime, v0Var);
            mVar.w(new i(1, v0Var));
        }
    }
}
