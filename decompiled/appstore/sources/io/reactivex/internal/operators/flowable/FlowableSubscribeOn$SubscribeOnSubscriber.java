package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final Subscriber<? super T> downstream;
    final boolean nonScheduledRequests;
    final AtomicLong requested;
    Publisher<T> source;
    final AtomicReference<Subscription> upstream;
    final mf.f.a worker;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscription f20632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f20633b;

        public a(Subscription r10, long r11) {
            this.f20632a = r10;
            this.f20633b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20632a.request(this.f20633b);
        }
    }

    public FlowableSubscribeOn$SubscribeOnSubscriber(Subscriber<? super T> r10, mf.f.a r11, Publisher<T> r12, boolean r13) {
        this.downstream = r10;
        this.source = r12;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.nonScheduledRequests = !r13;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L8;
        long r11 = this.requested.getAndSet(0);
        if (r11 == 0) goto L9;
        requestUpstream(r11, r10);
        return;
    L9:
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L13;
        Subscription r11 = this.upstream.get();
        if (r11 == null) goto L7;
        requestUpstream(r10, r11);
        return;
    L7:
        io.reactivex.internal.util.a.a(this.requested, r10);
        Subscription r12 = this.upstream.get();
        if (r12 == null) goto L15;
        long r13 = this.requested.getAndSet(0);
        if (r13 == 0) goto L16;
        requestUpstream(r13, r12);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void requestUpstream(long r10, Subscription r11) {
        if (this.nonScheduledRequests == false) goto L5;
    L9:
        r11.request(r10);
        return;
    L5:
        if (Thread.currentThread() == get()) goto L9;
        new a(r11, r10);
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        Publisher<T> r10 = this.source;
        this.source = null;
        r10.subscribe(this);
    }
}
