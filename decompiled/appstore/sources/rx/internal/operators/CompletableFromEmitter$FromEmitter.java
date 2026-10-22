package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.CompletableEmitter;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements CompletableEmitter, Subscription {
    private static final long serialVersionUID = 5539301318568668881L;
    final CompletableSubscriber actual;
    final SequentialSubscription resource;

    public CompletableFromEmitter$FromEmitter(CompletableSubscriber r10) {
        this.actual = r10;
        this.resource = new SequentialSubscription();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // rx.CompletableEmitter
    public void onCompleted() {
        if (compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        this.actual.onCompleted();     // Catch: Throwable -> L6
        this.resource.unsubscribe();
        return;
    L6:
        th = move-exception;
        this.resource.unsubscribe();
        throw th;
    }

    @Override // rx.CompletableEmitter
    public void onError(Throwable r10) {
        if (compareAndSet(false, true) == true) goto L11;
        og.c.j(r10);
        return;
    L11:
        this.actual.onError(r10);     // Catch: Throwable -> L6
        this.resource.unsubscribe();
        return;
    L6:
        th = move-exception;
        this.resource.unsubscribe();
        throw th;
    }

    @Override // rx.CompletableEmitter
    public void setCancellation(Cancellable r10) {
        setSubscription(new CancellableSubscription(r10));
    }

    @Override // rx.CompletableEmitter
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
