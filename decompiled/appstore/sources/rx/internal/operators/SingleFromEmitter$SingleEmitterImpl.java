package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.SingleEmitter;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX INFO: loaded from: classes4.dex */
final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
    private static final long serialVersionUID = 8082834163465882809L;
    final jg.b actual;
    final SequentialSubscription resource;

    public SingleFromEmitter$SingleEmitterImpl(jg.b r10) {
        this.actual = r10;
        this.resource = new SequentialSubscription();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // rx.SingleEmitter
    public void onError(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException();
    L5:
        if (compareAndSet(false, true) == true) goto L13;
        og.c.j(r10);
        return;
    L13:
        this.actual.b(r10);     // Catch: Throwable -> L8
        this.resource.unsubscribe();
        return;
    L8:
        th = move-exception;
        this.resource.unsubscribe();
        throw th;
    }

    @Override // rx.SingleEmitter
    public void onSuccess(T r10) {
        if (compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        this.actual.c(r10);     // Catch: Throwable -> L6
        this.resource.unsubscribe();
        return;
    L6:
        th = move-exception;
        this.resource.unsubscribe();
        throw th;
    }

    @Override // rx.SingleEmitter
    public void setCancellation(Cancellable r10) {
        setSubscription(new CancellableSubscription(r10));
    }

    @Override // rx.SingleEmitter
    public void setSubscription(Subscription r10) {
        this.resource.update(r10);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (compareAndSet(false, true) == false) goto L6;
        this.resource.unsubscribe();
        return;
    }
}
