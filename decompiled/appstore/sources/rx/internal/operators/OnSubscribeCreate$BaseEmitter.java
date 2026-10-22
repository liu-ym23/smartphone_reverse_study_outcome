package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Emitter;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class OnSubscribeCreate$BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
    private static final long serialVersionUID = 7326289992464377023L;
    final Subscriber actual;
    final rx.subscriptions.d serial;

    public OnSubscribeCreate$BaseEmitter(Subscriber r10) {
        this.actual = r10;
        this.serial = new rx.subscriptions.d();
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.serial.isUnsubscribed();
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.actual.isUnsubscribed() == false) goto L11;
        return;
    L11:
        this.actual.onCompleted();     // Catch: Throwable -> L8
        this.serial.unsubscribe();
        return;
    L8:
        th = move-exception;
        this.serial.unsubscribe();
        throw th;
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        if (this.actual.isUnsubscribed() == false) goto L11;
        return;
    L11:
        this.actual.onError(r10);     // Catch: Throwable -> L8
        this.serial.unsubscribe();
        return;
    L8:
        th = move-exception;
        this.serial.unsubscribe();
        throw th;
    }

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // rx.Producer
    public final void request(long r10) {
        if (a.d(r10) == false) goto L6;
        a.b(this, r10);
        onRequested();
        return;
    }

    @Override // rx.Emitter
    public final long requested() {
        return get();
    }

    @Override // rx.Emitter
    public final void setCancellation(Cancellable r10) {
        setSubscription(new CancellableSubscription(r10));
    }

    @Override // rx.Emitter
    public final void setSubscription(Subscription r10) {
        this.serial.a(r10);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
