package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4066607327284737757L;
    long count;
    final T defaultValue;
    boolean done;
    final boolean errorOnFewer;
    final long index;
    Subscription upstream;

    public FlowableElementAt$ElementAtSubscriber(Subscriber<? super T> r10, long r11, T r12, boolean r13) {
        super(r10);
        this.index = r11;
        this.defaultValue = r12;
        this.errorOnFewer = r13;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L12;
        this.done = true;
        T r10 = this.defaultValue;
        if (r10 == null) goto L7;
        complete(r10);
        return;
    L7:
        if (this.errorOnFewer == false) goto L9;
        this.downstream.onError(new NoSuchElementException());
        return;
    L9:
        this.downstream.onComplete();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.count;
        if (r11 != this.index) goto L9;
        this.done = true;
        this.upstream.cancel();
        complete(r10);
        return;
    L9:
        this.count = r11 + 1;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
