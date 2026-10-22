package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableTimer extends Flowable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> downstream;
        volatile boolean requested;

        TimerSubscriber(Subscriber<? super Long> r1) {
            this.downstream = r1;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            if (SubscriptionHelper.validate(r1) == false) goto L6;
            this.requested = true;
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (this.requested == false) goto L7;
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        L7:
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void setResource(Disposable r1) {
            DisposableHelper.trySet(this, r1);
        }
    }

    public FlowableTimer(long r1, TimeUnit r3, Scheduler r4) {
        this.delay = r1;
        this.unit = r3;
        this.scheduler = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> r4) {
        TimerSubscriber r0 = new TimerSubscriber(r4);
        r4.onSubscribe(r0);
        r0.setResource(this.scheduler.scheduleDirect(r0, this.delay, this.unit));
    }
}
