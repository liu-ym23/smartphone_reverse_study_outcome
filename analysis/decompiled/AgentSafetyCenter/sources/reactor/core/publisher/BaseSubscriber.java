package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class BaseSubscriber<T> implements CoreSubscriber<T>, qd.e, Disposable {
    static AtomicReferenceFieldUpdater<BaseSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(BaseSubscriber.class, qd.e.class, "subscription");
    volatile qd.e subscription;

    @Override // qd.e
    public final void cancel() {
        if (Operators.terminate(S, this)) {
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

    public void hookOnError(Throwable th) {
        throw Exceptions.errorCallbackNotImplemented(th);
    }

    public void hookOnSubscribe(qd.e eVar) {
        eVar.request(Long.MAX_VALUE);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.subscription == Operators.cancelledSubscription();
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onComplete() {
        if (S.getAndSet(this, Operators.cancelledSubscription()) != Operators.cancelledSubscription()) {
            try {
                hookOnComplete();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onError(Throwable th) {
        Objects.requireNonNull(th, "onError");
        if (S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
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

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onNext(T t10) {
        Objects.requireNonNull(t10, "onNext");
        try {
            hookOnNext(t10);
        } catch (Throwable th) {
            onError(Operators.onOperatorError(this.subscription, th, t10, currentContext()));
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onSubscribe(qd.e eVar) {
        if (Operators.setOnce(S, this, eVar)) {
            try {
                hookOnSubscribe(eVar);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(eVar, th, currentContext()));
            }
        }
    }

    @Override // qd.e
    public final void request(long j10) {
        qd.e eVar;
        if (!Operators.validate(j10) || (eVar = this.subscription) == null) {
            return;
        }
        eVar.request(j10);
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

    public qd.e upstream() {
        return this.subscription;
    }

    public void hookFinally(SignalType signalType) {
    }

    public void hookOnNext(T t10) {
    }

    public void hookOnCancel() {
    }

    public void hookOnComplete() {
    }
}
