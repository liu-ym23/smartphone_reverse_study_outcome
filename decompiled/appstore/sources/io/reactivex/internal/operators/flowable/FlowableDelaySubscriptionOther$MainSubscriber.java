package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableDelaySubscriptionOther$MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 2259811067697317255L;
    final Subscriber<? super T> downstream;
    final Publisher<? extends T> main;
    final FlowableDelaySubscriptionOther$MainSubscriber<T>.OtherSubscriber other;
    final AtomicReference<Subscription> upstream;

    public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -3892798459447644106L;
        final /* synthetic */ FlowableDelaySubscriptionOther$MainSubscriber this$0;

        public OtherSubscriber(FlowableDelaySubscriptionOther$MainSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            this.this$0.next();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            this.this$0.downstream.onError(r10);
            return;
        L5:
            qf.a.e(r10);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r10) {
            Subscription r11 = get();
            SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
            if (r11 == r12) goto L6;
            lazySet(r12);
            r11.cancel();
            this.this$0.next();
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            if (SubscriptionHelper.setOnce(this, r10) == false) goto L6;
            r10.request(Long.MAX_VALUE);
            return;
        }
    }

    public FlowableDelaySubscriptionOther$MainSubscriber(Subscriber<? super T> r10, Publisher<? extends T> r11) {
        this.downstream = r10;
        this.main = r11;
        this.other = new OtherSubscriber(this);
        this.upstream = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void next() {
        this.main.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        SubscriptionHelper.deferredRequest(this.upstream, this, r10);
        return;
    }
}
