package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 5904473792286235046L;
    final Consumer<? super D> disposer;
    final Subscriber<? super T> downstream;
    final boolean eager;
    final D resource;
    Subscription upstream;

    public FlowableUsing$UsingSubscriber(Subscriber<? super T> r10, D r11, Consumer<? super D> r12, boolean r13) {
        this.downstream = r10;
        this.resource = r11;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        disposeAfter();
        this.upstream.cancel();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.eager == true) goto L5;
        this.downstream.onComplete();
        this.upstream.cancel();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L14;
    L11:
        this.upstream.cancel();
        this.downstream.onComplete();
        return;
    L14:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.eager == true) goto L5;
        this.downstream.onError(r10);
        this.upstream.cancel();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L17;
    L10:
        th = null;
    L11:
        this.upstream.cancel();
        if (th == null) goto L14;
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L14:
        this.downstream.onError(r10);
        return;
    L17:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = th;
        io.reactivex.exceptions.a.a(th);
        goto L11
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
