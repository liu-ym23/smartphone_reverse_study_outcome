package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeConcatArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current;
        final SequentialDisposable disposables;
        final Subscriber<? super T> downstream;
        int index;
        long produced;
        final AtomicLong requested;
        final MaybeSource<? extends T>[] sources;

        ConcatMaybeObserver(Subscriber<? super T> r1, MaybeSource<? extends T>[] r2) {
            this.downstream = r1;
            this.sources = r2;
            this.requested = new AtomicLong();
            this.disposables = new SequentialDisposable();
            this.current = new AtomicReference(NotificationLite.COMPLETE);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            this.disposables.replace(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            this.current.lazySet(r2);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<Object> r0 = this.current;
            Subscriber<? super T> r1 = this.downstream;
            SequentialDisposable r2 = this.disposables;
        L7:
            if (r2.isDisposed() == true) goto L8;
            Object r3 = r0.get();
            if (r3 == null) goto L28;
            boolean r6 = true;
            if (r3 == NotificationLite.COMPLETE) goto L18;
            long r7 = this.produced;
            if (r7 == this.requested.get()) goto L17;
            this.produced = r7 + 1;
            r0.lazySet(null);
            r1.onNext(r3);
        L19:
            if (r6 == false) goto L28;
            if (r2.isDisposed() == true) goto L28;
            int r4 = this.index;
            MaybeSource<? extends T>[] r5 = this.sources;
            if (r4 == r5.length) goto L24;
            this.index = r4 + 1;
            r5[r4].subscribe(this);
            goto L28
        L24:
            r1.onComplete();
            return;
        L17:
            r6 = false;
            goto L19
        L18:
            r0.lazySet(null);
        L28:
            if (decrementAndGet() != 0) goto L7;
            return;
        L8:
            r0.lazySet(null);
        }
    }

    public MaybeConcatArray(MaybeSource<? extends T>[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r2) {
        ConcatMaybeObserver r0 = new ConcatMaybeObserver(r2, this.sources);
        r2.onSubscribe(r0);
        r0.drain();
    }
}
