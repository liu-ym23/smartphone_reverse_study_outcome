package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;

/* loaded from: classes5.dex */
public abstract class BaseSubscriber<T> implements CoreSubscriber<T>, qc.d, Disposable {

    /* renamed from: S, reason: collision with root package name */
    static AtomicReferenceFieldUpdater<BaseSubscriber, qc.d> f39451S = AtomicReferenceFieldUpdater.newUpdater(BaseSubscriber.class, qc.d.class, "subscription");
    volatile qc.d subscription;

    @Override // qc.d
    public final void cancel() {
        if (Operators.terminate(f39451S, this)) {
            try {
                hookOnCancel();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        cancel();
    }

    public void hookFinally(SignalType signalType) {
    }

    public void hookOnCancel() {
    }

    public void hookOnComplete() {
    }

    public void hookOnError(Throwable th) {
        throw Exceptions.errorCallbackNotImplemented(th);
    }

    public void hookOnNext(T t10) {
    }

    public void hookOnSubscribe(qc.d dVar) {
        dVar.request(Long.MAX_VALUE);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.subscription == Operators.cancelledSubscription();
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onComplete() {
        if (f39451S.getAndSet(this, Operators.cancelledSubscription()) != Operators.cancelledSubscription()) {
            try {
                hookOnComplete();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onError(Throwable th) {
        Objects.requireNonNull(th, "onError");
        if (f39451S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
            Operators.onErrorDropped(th, currentContext());
            return;
        }
        try {
            hookOnError(th);
        } catch (Throwable th2) {
            try {
                Operators.onErrorDropped(Exceptions.addSuppressed(th2, th), currentContext());
            } finally {
                safeHookFinally(SignalType.ON_ERROR);
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onNext(T t10) {
        Objects.requireNonNull(t10, "onNext");
        try {
            hookOnNext(t10);
        } catch (Throwable th) {
            onError(Operators.onOperatorError(this.subscription, th, t10, currentContext()));
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onSubscribe(qc.d dVar) {
        if (Operators.setOnce(f39451S, this, dVar)) {
            try {
                hookOnSubscribe(dVar);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(dVar, th, currentContext()));
            }
        }
    }

    @Override // qc.d
    public final void request(long j10) {
        qc.d dVar;
        if (!Operators.validate(j10) || (dVar = this.subscription) == null) {
            return;
        }
        dVar.request(j10);
    }

    public final void requestUnbounded() {
        request(Long.MAX_VALUE);
    }

    public void safeHookFinally(SignalType signalType) {
        try {
            hookFinally(signalType);
        } catch (Throwable th) {
            Operators.onErrorDropped(th, currentContext());
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public qc.d upstream() {
        return this.subscription;
    }
}
