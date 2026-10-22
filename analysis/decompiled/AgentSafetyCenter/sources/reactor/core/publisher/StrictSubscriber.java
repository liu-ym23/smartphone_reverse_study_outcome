package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class StrictSubscriber<T> implements Scannable, CoreSubscriber<T>, qd.e {
    final qd.d actual;
    volatile boolean done;
    volatile Throwable error;
    volatile long requested;

    /* renamed from: s, reason: collision with root package name */
    volatile qd.e f10754s;
    volatile int wip;
    static final AtomicReferenceFieldUpdater<StrictSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, qd.e.class, "s");
    static final AtomicLongFieldUpdater<StrictSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(StrictSubscriber.class, "requested");
    static final AtomicIntegerFieldUpdater<StrictSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(StrictSubscriber.class, "wip");
    static final AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(StrictSubscriber.class, Throwable.class, "error");

    public StrictSubscriber(qd.d dVar) {
        this.actual = dVar;
    }

    @Override // qd.e
    public void cancel() {
        if (this.done) {
            return;
        }
        Operators.terminate(S, this);
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return Context.empty();
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onComplete() {
        this.done = true;
        if (WIP.getAndIncrement(this) == 0) {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            qd.d dVar = this.actual;
            if (thTerminate != null) {
                dVar.onError(thTerminate);
            } else {
                dVar.onComplete();
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onError(Throwable th) {
        this.done = true;
        AtomicReferenceFieldUpdater<StrictSubscriber, Throwable> atomicReferenceFieldUpdater = ERROR;
        if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
            Operators.onErrorDropped(th, Context.empty());
        } else if (WIP.getAndIncrement(this) == 0) {
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onNext(T t10) {
        AtomicIntegerFieldUpdater<StrictSubscriber> atomicIntegerFieldUpdater = WIP;
        if (atomicIntegerFieldUpdater.get(this) == 0 && atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.actual.onNext(t10);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                Throwable thTerminate = Exceptions.terminate(ERROR, this);
                qd.d dVar = this.actual;
                if (thTerminate != null) {
                    dVar.onError(thTerminate);
                } else {
                    dVar.onComplete();
                }
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onSubscribe(qd.e eVar) {
        if (!Operators.validate(this.f10754s, eVar)) {
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
            return;
        }
        this.actual.onSubscribe(this);
        if (Operators.setOnce(S, this, eVar)) {
            long andSet = REQUESTED.getAndSet(this, 0L);
            if (andSet != 0) {
                eVar.request(andSet);
            }
        }
    }

    @Override // qd.e
    public void request(long j10) {
        if (j10 <= 0) {
            cancel();
            onError(new IllegalArgumentException(k0.a.m("§3.9 violated: positive request amount required but it was ", j10)));
            return;
        }
        qd.e eVar = this.f10754s;
        if (eVar != null) {
            eVar.request(j10);
            return;
        }
        AtomicLongFieldUpdater<StrictSubscriber> atomicLongFieldUpdater = REQUESTED;
        Operators.addCap(atomicLongFieldUpdater, this, j10);
        qd.e eVar2 = this.f10754s;
        if (eVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
            return;
        }
        eVar2.request(j10);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.f10754s;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.f10754s == Operators.cancelledSubscription());
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
