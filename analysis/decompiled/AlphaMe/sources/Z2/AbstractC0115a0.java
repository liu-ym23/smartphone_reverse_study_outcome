package Z2;

import f1.AbstractC0557a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.Nullable;

/* renamed from: Z2.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0115a0 extends AbstractC0117b0 implements L {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2204e = AtomicReferenceFieldUpdater.newUpdater(AbstractC0115a0.class, Object.class, "_queue");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2205f = AtomicReferenceFieldUpdater.newUpdater(AbstractC0115a0.class, Object.class, "_delayed");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2206g = AtomicIntegerFieldUpdater.newUpdater(AbstractC0115a0.class, "_isCompleted");

    @Volatile
    @Nullable
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted = 0;

    @Volatile
    @Nullable
    private volatile Object _queue;

    @Override // Z2.V
    public void D() {
        Y yB;
        ThreadLocal threadLocal = G0.f2166a;
        G0.f2166a.set(null);
        f2206g.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2204e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            X.r rVar = I.f2172e;
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, rVar)) {
                    break;
                }
            } else if (obj instanceof d3.p) {
                ((d3.p) obj).b();
                break;
            } else {
                if (obj == rVar) {
                    break;
                }
                d3.p pVar = new d3.p(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                pVar.a((Runnable) obj);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                    break;
                }
            }
        }
        while (w() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            Z z4 = (Z) f2205f.get(this);
            if (z4 == null) {
                return;
            }
            synchronized (z4) {
                yB = d3.C.f12437b.get(z4) > 0 ? z4.b(0) : null;
            }
            if (yB == null) {
                return;
            } else {
                N(jNanoTime, yB);
            }
        }
    }

    public void O(Runnable runnable) {
        if (!P(runnable)) {
            J.f2181h.O(runnable);
            return;
        }
        Thread threadI = I();
        if (Thread.currentThread() != threadI) {
            LockSupport.unpark(threadI);
        }
    }

    public final boolean P(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2204e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f2206g.get(this) != 0) {
                return false;
            }
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof d3.p) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                d3.p pVar = (d3.p) obj;
                int iA = pVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar.c());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == I.f2172e) {
                    return false;
                }
                d3.p pVar2 = new d3.p(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                pVar2.a((Runnable) obj);
                pVar2.a(runnable);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar2)) {
                    return true;
                }
            }
        }
    }

    public final boolean Q() {
        ArrayDeque arrayDeque = this.f2196c;
        if (!(arrayDeque != null ? arrayDeque.isEmpty() : true)) {
            return false;
        }
        Z z4 = (Z) f2205f.get(this);
        if (z4 != null && d3.C.f12437b.get(z4) != 0) {
            return false;
        }
        Object obj = f2204e.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof d3.p) {
            long j4 = d3.p.f12471f.get((d3.p) obj);
            if (((int) (1073741823 & j4)) == ((int) ((j4 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == I.f2172e) {
            return true;
        }
        return false;
    }

    public final void R(long j4, Y y4) {
        int iC;
        Thread threadI;
        boolean z4 = f2206g.get(this) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2205f;
        if (z4) {
            iC = 1;
        } else {
            Z z5 = (Z) atomicReferenceFieldUpdater.get(this);
            if (z5 == null) {
                Z z6 = new Z();
                z6.f2202c = j4;
                atomicReferenceFieldUpdater.compareAndSet(this, null, z6);
                Object obj = atomicReferenceFieldUpdater.get(this);
                Intrinsics.checkNotNull(obj);
                z5 = (Z) obj;
            }
            iC = y4.c(j4, z5, this);
        }
        if (iC != 0) {
            if (iC == 1) {
                N(j4, y4);
                return;
            } else {
                if (iC != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            }
        }
        Z z7 = (Z) atomicReferenceFieldUpdater.get(this);
        if (z7 != null) {
            synchronized (z7) {
                Y[] yArr = z7.f12438a;
                y = yArr != null ? yArr[0] : null;
            }
        }
        if (y != y4 || Thread.currentThread() == (threadI = I())) {
            return;
        }
        LockSupport.unpark(threadI);
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        O(runnable);
    }

    public T invokeOnTimeout(long j4, Runnable runnable, CoroutineContext coroutineContext) {
        return AbstractC0557a.E(j4, runnable, coroutineContext);
    }

    @Override // Z2.L
    public final void scheduleResumeAfterDelay(long j4, InterfaceC0126g interfaceC0126g) {
        long j5 = j4 > 0 ? j4 >= 9223372036854L ? LongCompanionObject.MAX_VALUE : 1000000 * j4 : 0L;
        if (j5 < DurationKt.MAX_MILLIS) {
            long jNanoTime = System.nanoTime();
            C0128h c0128h = (C0128h) interfaceC0126g;
            W w4 = new W(this, j5 + jNanoTime, c0128h);
            R(jNanoTime, w4);
            c0128h.o(new C0122e(1, w4));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    @Override // Z2.V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w() {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.AbstractC0115a0.w():long");
    }
}
