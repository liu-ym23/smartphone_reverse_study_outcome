package s4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import x4.C1300L;

/* renamed from: s4.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1063b0 extends AbstractC1065c0 implements Q {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20333f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1063b0.class, Object.class, "_queue$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20334g = AtomicReferenceFieldUpdater.newUpdater(AbstractC1063b0.class, Object.class, "_delayed$volatile");

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20335h = AtomicIntegerFieldUpdater.newUpdater(AbstractC1063b0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* renamed from: s4.b0$a */
    private final class a extends b {

        /* renamed from: c, reason: collision with root package name */
        private final InterfaceC1080k<V3.v> f20336c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j5, InterfaceC1080k<? super V3.v> interfaceC1080k) {
            super(j5);
            this.f20336c = interfaceC1080k;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20336c.d(AbstractC1063b0.this, V3.v.f5542a);
        }

        @Override // s4.AbstractC1063b0.b
        public String toString() {
            return super.toString() + this.f20336c;
        }
    }

    /* renamed from: s4.b0$b */
    public static abstract class b implements Runnable, Comparable<b>, X, x4.M {
        private volatile Object _heap;

        /* renamed from: a, reason: collision with root package name */
        public long f20338a;

        /* renamed from: b, reason: collision with root package name */
        private int f20339b = -1;

        public b(long j5) {
            this.f20338a = j5;
        }

        @Override // x4.M
        public C1300L<?> d() {
            Object obj = this._heap;
            if (obj instanceof C1300L) {
                return (C1300L) obj;
            }
            return null;
        }

        @Override // s4.X
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == C1069e0.f20344a) {
                        return;
                    }
                    c cVar = obj instanceof c ? (c) obj : null;
                    if (cVar != null) {
                        cVar.h(this);
                    }
                    this._heap = C1069e0.f20344a;
                    V3.v vVar = V3.v.f5542a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // x4.M
        public void e(C1300L<?> c1300l) {
            if (this._heap == C1069e0.f20344a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = c1300l;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j5 = this.f20338a - bVar.f20338a;
            if (j5 > 0) {
                return 1;
            }
            return j5 < 0 ? -1 : 0;
        }

        @Override // x4.M
        public int getIndex() {
            return this.f20339b;
        }

        public final int h(long j5, c cVar, AbstractC1063b0 abstractC1063b0) {
            synchronized (this) {
                if (this._heap == C1069e0.f20344a) {
                    return 2;
                }
                synchronized (cVar) {
                    try {
                        b bVarB = cVar.b();
                        if (abstractC1063b0.L0()) {
                            return 1;
                        }
                        if (bVarB == null) {
                            cVar.f20340c = j5;
                        } else {
                            long j6 = bVarB.f20338a;
                            if (j6 - j5 < 0) {
                                j5 = j6;
                            }
                            if (j5 - cVar.f20340c > 0) {
                                cVar.f20340c = j5;
                            }
                        }
                        long j7 = this.f20338a;
                        long j8 = cVar.f20340c;
                        if (j7 - j8 < 0) {
                            this.f20338a = j8;
                        }
                        cVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean i(long j5) {
            return j5 - this.f20338a >= 0;
        }

        @Override // x4.M
        public void setIndex(int i5) {
            this.f20339b = i5;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f20338a + ']';
        }
    }

    /* renamed from: s4.b0$c */
    public static final class c extends C1300L<b> {

        /* renamed from: c, reason: collision with root package name */
        public long f20340c;

        public c(long j5) {
            this.f20340c = j5;
        }
    }

    private final void E0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20333f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (f20333f.compareAndSet(this, null, C1069e0.f20345b)) {
                    return;
                }
            } else if (obj instanceof x4.s) {
                ((x4.s) obj).d();
                return;
            } else {
                if (obj == C1069e0.f20345b) {
                    return;
                }
                x4.s sVar = new x4.s(8, true);
                j4.k.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (f20333f.compareAndSet(this, obj, sVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable F0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20333f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof x4.s) {
                j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                x4.s sVar = (x4.s) obj;
                Object objM = sVar.m();
                if (objM != x4.s.f23881h) {
                    return (Runnable) objM;
                }
                f20333f.compareAndSet(this, obj, sVar.l());
            } else {
                if (obj == C1069e0.f20345b) {
                    return null;
                }
                if (f20333f.compareAndSet(this, obj, null)) {
                    j4.k.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean H0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20333f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (L0()) {
                return false;
            }
            if (obj == null) {
                if (f20333f.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof x4.s) {
                j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                x4.s sVar = (x4.s) obj;
                int iA = sVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    f20333f.compareAndSet(this, obj, sVar.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == C1069e0.f20345b) {
                    return false;
                }
                x4.s sVar2 = new x4.s(8, true);
                j4.k.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar2.a((Runnable) obj);
                sVar2.a(runnable);
                if (f20333f.compareAndSet(this, obj, sVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0() {
        return f20335h.get(this) != 0;
    }

    private final void N0() {
        b bVarJ;
        C1064c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f20334g.get(this);
            if (cVar == null || (bVarJ = cVar.j()) == null) {
                return;
            } else {
                B0(jNanoTime, bVarJ);
            }
        }
    }

    private final int Q0(long j5, b bVar) {
        if (L0()) {
            return 1;
        }
        c cVar = (c) f20334g.get(this);
        if (cVar == null) {
            f20334g.compareAndSet(this, null, new c(j5));
            Object obj = f20334g.get(this);
            j4.k.d(obj);
            cVar = (c) obj;
        }
        return bVar.h(j5, cVar, this);
    }

    private final void R0(boolean z5) {
        f20335h.set(this, z5 ? 1 : 0);
    }

    private final boolean S0(b bVar) {
        c cVar = (c) f20334g.get(this);
        return (cVar != null ? cVar.f() : null) == bVar;
    }

    public void G0(Runnable runnable) {
        if (H0(runnable)) {
            C0();
        } else {
            N.f20317i.G0(runnable);
        }
    }

    protected boolean M0() {
        if (!s0()) {
            return false;
        }
        c cVar = (c) f20334g.get(this);
        if (cVar != null && !cVar.e()) {
            return false;
        }
        Object obj = f20333f.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof x4.s ? ((x4.s) obj).j() : obj == C1069e0.f20345b;
    }

    protected final void O0() {
        f20333f.set(this, null);
        f20334g.set(this, null);
    }

    public final void P0(long j5, b bVar) {
        int iQ0 = Q0(j5, bVar);
        if (iQ0 == 0) {
            if (S0(bVar)) {
                C0();
            }
        } else if (iQ0 == 1) {
            B0(j5, bVar);
        } else if (iQ0 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    @Override // s4.AbstractC1056E
    public final void Y(Z3.i iVar, Runnable runnable) {
        G0(runnable);
    }

    @Override // s4.AbstractC1061a0
    protected long m0() {
        b bVarF;
        if (super.m0() == 0) {
            return 0L;
        }
        Object obj = f20333f.get(this);
        if (obj != null) {
            if (!(obj instanceof x4.s)) {
                return obj == C1069e0.f20345b ? Long.MAX_VALUE : 0L;
            }
            if (!((x4.s) obj).j()) {
                return 0L;
            }
        }
        c cVar = (c) f20334g.get(this);
        if (cVar == null || (bVarF = cVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j5 = bVarF.f20338a;
        C1064c.a();
        return kotlin.ranges.l.c(j5 - System.nanoTime(), 0L);
    }

    @Override // s4.Q
    public void r(long j5, InterfaceC1080k<? super V3.v> interfaceC1080k) {
        long jC = C1069e0.c(j5);
        if (jC < 4611686018427387903L) {
            C1064c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, interfaceC1080k);
            P0(jNanoTime, aVar);
            C1086n.a(interfaceC1080k, aVar);
        }
    }

    @Override // s4.AbstractC1061a0
    public void shutdown() {
        H0.f20303a.c();
        R0(true);
        E0();
        while (u0() <= 0) {
        }
        N0();
    }

    @Override // s4.AbstractC1061a0
    public long u0() {
        b bVarI;
        if (w0()) {
            return 0L;
        }
        c cVar = (c) f20334g.get(this);
        if (cVar != null && !cVar.e()) {
            C1064c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (cVar) {
                    try {
                        b bVarB = cVar.b();
                        if (bVarB != null) {
                            b bVar = bVarB;
                            bVarI = bVar.i(jNanoTime) ? H0(bVar) : false ? cVar.i(0) : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (bVarI != null);
        }
        Runnable runnableF0 = F0();
        if (runnableF0 == null) {
            return m0();
        }
        runnableF0.run();
        return 0L;
    }
}
