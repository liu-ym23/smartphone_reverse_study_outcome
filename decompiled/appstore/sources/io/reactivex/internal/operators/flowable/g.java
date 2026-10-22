package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements FlowableSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber f20640a;

    public g(FlowableSamplePublisher$SamplePublisherSubscriber r10) {
        this.f20640a = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f20640a.complete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.f20640a.error(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        this.f20640a.run();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        this.f20640a.setOther(r10);
    }
}
