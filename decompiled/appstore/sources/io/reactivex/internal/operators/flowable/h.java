package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements FlowableSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subscriber f20641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubscriptionArbiter f20642b;

    public h(Subscriber r10, SubscriptionArbiter r11) {
        this.f20641a = r10;
        this.f20642b = r11;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f20641a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.f20641a.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        this.f20641a.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        this.f20642b.setSubscription(r10);
    }
}
