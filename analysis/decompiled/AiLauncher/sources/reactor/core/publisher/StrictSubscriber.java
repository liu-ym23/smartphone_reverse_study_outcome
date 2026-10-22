package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class StrictSubscriber<T> implements Scannable, CoreSubscriber<T>, qc.d {
    final qc.c<? super T> actual;
    volatile boolean done;
    volatile Throwable error;
    volatile long requested;

    /* renamed from: s, reason: collision with root package name */
    volatile qc.d f39713s;
    volatile int wip;

    /* renamed from: S, reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<StrictSubscriber, qc.d> f39712S = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, qc.d.class, "s");
    static final AtomicLongFieldUpdater<StrictSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(StrictSubscriber.class, "requested");
    static final AtomicIntegerFieldUpdater<StrictSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(StrictSubscriber.class, "wip");
    static final AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, Throwable.class, "error");

    public StrictSubscriber(qc.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // qc.d
    public void cancel() {
        if (this.done) {
            return;
        }
        Operators.terminate(f39712S, this);
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return Context.empty();
    }

    @Override // reactor.core.CoreSubscriber, qc.c
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

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onError(Throwable th) {
        this.done = true;
        AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> atomicReferenceFieldUpdater = ERROR;
        if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
            Operators.onErrorDropped(th, Context.empty());
        } else if (WIP.getAndIncrement(this) == 0) {
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onNext(T t10) {
        AtomicIntegerFieldUpdater<StrictSubscriber> atomicIntegerFieldUpdater = WIP;
        if (atomicIntegerFieldUpdater.get(this) == 0 && atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.actual.onNext(t10);
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

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onSubscribe(qc.d dVar) {
        if (!Operators.validate(this.f39713s, dVar)) {
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
            return;
        }
        this.actual.onSubscribe(this);
        if (Operators.setOnce(f39712S, this, dVar)) {
            long andSet = REQUESTED.getAndSet(this, 0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
        }
    }

    @Override // qc.d
    public void request(long j10) {
        if (j10 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
            return;
        }
        qc.d dVar = this.f39713s;
        if (dVar != null) {
            dVar.request(j10);
            return;
        }
        AtomicLongFieldUpdater<StrictSubscriber> atomicLongFieldUpdater = REQUESTED;
        Operators.addCap(atomicLongFieldUpdater, this, j10);
        qc.d dVar2 = this.f39713s;
        if (dVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
            return;
        }
        dVar2.request(j10);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.f39713s;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.f39713s == Operators.cancelledSubscription());
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
