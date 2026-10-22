package d3;

import Z2.InterfaceC0126g;
import Z2.K;
import Z2.L;
import Z2.T;
import androidx.appcompat.widget.RunnableC0209k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;

/* loaded from: classes2.dex */
public final class j extends Z2.A implements L {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12459f = AtomicIntegerFieldUpdater.newUpdater(j.class, "runningWorkers");

    /* renamed from: a, reason: collision with root package name */
    public final Z2.A f12460a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12461b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ L f12462c;

    /* renamed from: d, reason: collision with root package name */
    public final n f12463d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f12464e;

    @Volatile
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public j(f3.k kVar, int i4) {
        this.f12460a = kVar;
        this.f12461b = i4;
        L l4 = kVar instanceof L ? (L) kVar : null;
        this.f12462c = l4 == null ? K.f2184a : l4;
        this.f12463d = new n();
        this.f12464e = new Object();
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableE;
        this.f12463d.a(runnable);
        if (f12459f.get(this) >= this.f12461b || !l() || (runnableE = e()) == null) {
            return;
        }
        this.f12460a.dispatch(this, new RunnableC0209k(18, this, runnableE));
    }

    @Override // Z2.A
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableE;
        this.f12463d.a(runnable);
        if (f12459f.get(this) >= this.f12461b || !l() || (runnableE = e()) == null) {
            return;
        }
        this.f12460a.dispatchYield(this, new RunnableC0209k(18, this, runnableE));
    }

    public final Runnable e() {
        while (true) {
            Runnable runnable = (Runnable) this.f12463d.c();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f12464e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12459f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f12463d.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // Z2.L
    public final T invokeOnTimeout(long j4, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f12462c.invokeOnTimeout(j4, runnable, coroutineContext);
    }

    public final boolean l() {
        synchronized (this.f12464e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12459f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f12461b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // Z2.L
    public final void scheduleResumeAfterDelay(long j4, InterfaceC0126g interfaceC0126g) {
        this.f12462c.scheduleResumeAfterDelay(j4, interfaceC0126g);
    }
}
