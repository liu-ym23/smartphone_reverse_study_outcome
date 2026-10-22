package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 1015244841293359600L;
    final Subscriber<? super T> downstream;
    final mf.f scheduler;
    Subscription upstream;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowableUnsubscribeOn$UnsubscribeSubscriber f20634a;

        public a(FlowableUnsubscribeOn$UnsubscribeSubscriber r10) {
            this.f20634a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20634a.upstream.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(Subscriber<? super T> r10, mf.f r11) {
        this.downstream = r10;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        new a(this);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (get() == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (get() == true) goto L6;
        this.downstream.onNext(r10);
        return;
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
