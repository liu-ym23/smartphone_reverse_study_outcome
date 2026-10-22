package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;

/* loaded from: classes4.dex */
public abstract class BaseSubscriber<T> implements CoreSubscriber<T>, Z9.e, Disposable {

    /* renamed from: S, reason: collision with root package name */
    static AtomicReferenceFieldUpdater<BaseSubscriber, Z9.e> f5691S = AtomicReferenceFieldUpdater.newUpdater(BaseSubscriber.class, Z9.e.class, "subscription");
    volatile Z9.e subscription;

    @Override // Z9.e
    public final void cancel() {
        if (Operators.terminate(f5691S, this)) {
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

    public void hookOnNext(T t9) {
    }

    public void hookOnSubscribe(Z9.e eVar) {
        eVar.request(Long.MAX_VALUE);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.subscription == Operators.cancelledSubscription();
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public final void onComplete() {
        if (f5691S.getAndSet(this, Operators.cancelledSubscription()) != Operators.cancelledSubscription()) {
            try {
                hookOnComplete();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public final void onError(Throwable th) {
        Objects.requireNonNull(th, "onError");
        if (f5691S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
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

    @Override // reactor.core.CoreSubscriber, Z9.d
    public final void onNext(T t9) {
        Objects.requireNonNull(t9, "onNext");
        try {
            hookOnNext(t9);
        } catch (Throwable th) {
            onError(Operators.onOperatorError(this.subscription, th, t9, currentContext()));
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public final void onSubscribe(Z9.e eVar) {
        if (Operators.setOnce(f5691S, this, eVar)) {
            try {
                hookOnSubscribe(eVar);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(eVar, th, currentContext()));
            }
        }
    }

    @Override // Z9.e
    public final void request(long j5) {
        Z9.e eVar;
        if (!Operators.validate(j5) || (eVar = this.subscription) == null) {
            return;
        }
        eVar.request(j5);
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

    public Z9.e upstream() {
        return this.subscription;
    }
}
