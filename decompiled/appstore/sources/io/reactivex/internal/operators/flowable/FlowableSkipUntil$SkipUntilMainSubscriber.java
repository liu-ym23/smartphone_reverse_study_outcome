package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
    private static final long serialVersionUID = -6270983465606289181L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean gate;
    final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -5592042965931999169L;
        final /* synthetic */ FlowableSkipUntil$SkipUntilMainSubscriber this$0;

        public OtherSubscriber(FlowableSkipUntil$SkipUntilMainSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.this$0.gate = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            SubscriptionHelper.cancel(this.this$0.upstream);
            FlowableSkipUntil$SkipUntilMainSubscriber r11 = this.this$0;
            io.reactivex.internal.util.d.d(r11.downstream, r10, r11, r11.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r10) {
            this.this$0.gate = true;
            get().cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    public FlowableSkipUntil$SkipUntilMainSubscriber(Subscriber<? super T> r10) {
        this.downstream = r10;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new OtherSubscriber(this);
        this.error = new AtomicThrowable();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.internal.util.d.b(this.downstream, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.internal.util.d.d(this.downstream, r10, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (tryOnNext(r10) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
    public boolean tryOnNext(T r10) {
        if (this.gate == false) goto L6;
        io.reactivex.internal.util.d.f(this.downstream, r10, this, this.error);
        return true;
    L6:
        return false;
    }
}
