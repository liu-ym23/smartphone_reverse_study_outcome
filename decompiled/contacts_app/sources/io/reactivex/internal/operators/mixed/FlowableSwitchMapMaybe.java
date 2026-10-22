package io.reactivex.internal.operators.mixed;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final Flowable<T> source;

    static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        long emitted;
        final AtomicThrowable errors;
        final AtomicReference<SwitchMapMaybeObserver<R>> inner;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final AtomicLong requested;
        Subscription upstream;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeSubscriber<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r1) {
                this.item = r1;
                this.parent.drain();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r2) {
                this.parent.innerError(this, r2);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        static {
            INNER_DISPOSED = new SwitchMapMaybeObserver(null);
        }

        SwitchMapMaybeSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.inner = new AtomicReference();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r4) {
            SwitchMapMaybeObserver<R> r0 = this.inner.get();
            if (r0 == null) goto L17;
            r0.dispose();
        L17:
            MaybeSource r5 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L14
            SwitchMapMaybeObserver r1 = new SwitchMapMaybeObserver(this);
        L7:
            SwitchMapMaybeObserver<R> r2 = this.inner.get();
            if (r2 == INNER_DISPOSED) goto L22;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.inner, r2, r1) == false) goto L7;
            r5.subscribe(r1);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            disposeInner();
        L7:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        void disposeInner() {
            AtomicReference<SwitchMapMaybeObserver<R>> r1 = this.inner;
            SwitchMapMaybeObserver<Object> r0 = INNER_DISPOSED;
            SwitchMapMaybeObserver<R> r2 = r1.getAndSet((SwitchMapMaybeObserver<R>) r0);
            if (r2 == null) goto L7;
            if (r2 == r0) goto L8;
            r2.dispose();
            return;
        L8:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            BackpressureHelper.add(this.requested, r2);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
        }

        void innerError(SwitchMapMaybeObserver<R> r3, Throwable r4) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.inner, r3, null) == true) goto L5;
        L11:
            RxJavaPlugins.onError(r4);
            return;
        L5:
            if (this.errors.addThrowable(r4) == false) goto L11;
            if (this.delayErrors == true) goto L9;
            this.upstream.cancel();
            disposeInner();
        L9:
            drain();
        }

        void innerComplete(SwitchMapMaybeObserver<R> r3) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.inner, r3, null) == false) goto L6;
            drain();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r0 = this.downstream;
            AtomicThrowable r1 = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> r2 = this.inner;
            AtomicLong r3 = this.requested;
            long r4 = this.emitted;
            int r7 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r1.get() != null) goto L12;
        L15:
            boolean r8 = this.done;
            SwitchMapMaybeObserver<R> r9 = r2.get();
            if (r9 != null) goto L18;
            boolean r10 = true;
        L19:
            if (r8 == false) goto L26;
            if (r10 == false) goto L26;
            Throwable r12 = r1.terminate();
            if (r12 == null) goto L24;
            r0.onError(r12);
            return;
        L24:
            r0.onComplete();
            return;
        L26:
            if (r10 == true) goto L33;
            if (r9.item == null) goto L33;
            if (r4 == r3.get()) goto L33;
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r2, r9, null);
            r0.onNext(r9.item);
            r4 = r4 + 1;
        L33:
            this.emitted = r4;
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L7;
            return;
        L18:
            r10 = false;
            goto L19
        L12:
            if (this.delayErrors == true) goto L15;
            r0.onError(r1.terminate());
            return;
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
        this.source = r1;
        this.mapper = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r4) {
        this.source.subscribe(new SwitchMapMaybeSubscriber(r4, this.mapper, this.delayErrors));
    }
}
