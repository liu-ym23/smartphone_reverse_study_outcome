package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
    private static final long serialVersionUID = 7326289992464377023L;
    final Subscriber<? super T> downstream;
    final SequentialDisposable serial;

    public FlowableCreate$BaseEmitter(Subscriber<? super T> r10) {
        this.downstream = r10;
        this.serial = new SequentialDisposable();
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public void complete() {
        if (isCancelled() == false) goto L11;
        return;
    L11:
        this.downstream.onComplete();     // Catch: Throwable -> L8
        this.serial.dispose();
        return;
    L8:
        th = move-exception;
        this.serial.dispose();
        throw th;
    }

    public boolean error(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L5:
        if (isCancelled() == false) goto L14;
        return false;
    L14:
        this.downstream.onError(r10);     // Catch: Throwable -> L11
        this.serial.dispose();
        return true;
    L11:
        th = move-exception;
        this.serial.dispose();
        throw th;
    }

    @Override // io.reactivex.FlowableEmitter
    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    @Override // io.reactivex.Emitter
    public void onComplete() {
        complete();
    }

    @Override // io.reactivex.Emitter
    public final void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        qf.a.e(r10);
        return;
    }

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this, r10);
        onRequested();
        return;
    }

    @Override // io.reactivex.FlowableEmitter
    public final long requested() {
        return get();
    }

    @Override // io.reactivex.FlowableEmitter
    public final FlowableEmitter<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    @Override // io.reactivex.FlowableEmitter
    public final void setCancellable(Cancellable r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    @Override // io.reactivex.FlowableEmitter
    public final void setDisposable(Disposable r10) {
        this.serial.update(r10);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
    }

    @Override // io.reactivex.FlowableEmitter
    public boolean tryOnError(Throwable r10) {
        return error(r10);
    }
}
