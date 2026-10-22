package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class StrictSubscriber<T> implements Scannable, CoreSubscriber<T>, Z9.e {
    final Z9.d actual;
    volatile boolean done;
    volatile Throwable error;
    volatile long requested;

    /* renamed from: s, reason: collision with root package name */
    volatile Z9.e f5895s;
    volatile int wip;

    /* renamed from: S, reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<StrictSubscriber, Z9.e> f5894S = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, Z9.e.class, "s");
    static final AtomicLongFieldUpdater<StrictSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(StrictSubscriber.class, "requested");
    static final AtomicIntegerFieldUpdater<StrictSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(StrictSubscriber.class, "wip");
    static final AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, Throwable.class, "error");

    public StrictSubscriber(Z9.d dVar) {
        this.actual = dVar;
    }

    @Override // Z9.e
    public void cancel() {
        if (this.done) {
            return;
        }
        Operators.terminate(f5894S, this);
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return Context.empty();
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onComplete() {
        this.done = true;
        if (WIP.getAndIncrement(this) == 0) {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null) {
                this.actual.onError(thTerminate);
            } else {
                this.actual.onComplete();
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onError(Throwable th) {
        this.done = true;
        AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> atomicReferenceFieldUpdater = ERROR;
        if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
            Operators.onErrorDropped(th, Context.empty());
        } else if (WIP.getAndIncrement(this) == 0) {
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onNext(T t9) {
        AtomicIntegerFieldUpdater<StrictSubscriber> atomicIntegerFieldUpdater = WIP;
        if (atomicIntegerFieldUpdater.get(this) == 0 && atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.actual.onNext(t9);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                Throwable thTerminate = Exceptions.terminate(ERROR, this);
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onSubscribe(Z9.e eVar) {
        if (!Operators.validate(this.f5895s, eVar)) {
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
            return;
        }
        this.actual.onSubscribe(this);
        if (Operators.setOnce(f5894S, this, eVar)) {
            long andSet = REQUESTED.getAndSet(this, 0L);
            if (andSet != 0) {
                eVar.request(andSet);
            }
        }
    }

    @Override // Z9.e
    public void request(long j5) {
        if (j5 <= 0) {
            cancel();
            onError(new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "§3.9 violated: positive request amount required but it was ")));
            return;
        }
        Z9.e eVar = this.f5895s;
        if (eVar != null) {
            eVar.request(j5);
            return;
        }
        AtomicLongFieldUpdater<StrictSubscriber> atomicLongFieldUpdater = REQUESTED;
        Operators.addCap(atomicLongFieldUpdater, this, j5);
        Z9.e eVar2 = this.f5895s;
        if (eVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
            return;
        }
        eVar2.request(j5);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.f5895s;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.f5895s == Operators.cancelledSubscription());
        }
        if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
            return Long.valueOf(this.requested);
        }
        if (attr == Scannable.Attr.ACTUAL) {
            return this.actual;
        }
        return null;
    }
}
