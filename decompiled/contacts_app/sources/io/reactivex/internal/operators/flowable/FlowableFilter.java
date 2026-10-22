package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> filter;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> r1, Predicate<? super T> r2) {
            super(r1);
            this.filter = r2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.request(1);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r4) {
            if (this.done == false) goto L6;
            return false;
        L6:
            if (this.sourceMode == 0) goto L19;
            return this.downstream.tryOnNext(null);
        L19:
            if (this.filter.test(r4) == true) goto L13;
            return false;
        L13:
            if (this.downstream.tryOnNext((Object) r4) == true) goto L15;
            return false;
        L15:
            return true;
        L16:
            th = move-exception;
            fail(th);
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> r0 = this.qs;
            Predicate<? super T> r1 = this.filter;
        L3:
            T r2 = r0.poll();
            if (r2 == null) goto L5;
            if (r1.test(r2) == true) goto L9;
            if (this.sourceMode != 2) goto L3;
            r0.request(1);
            goto L3
        L9:
            return r2;
        L5:
            return null;
        }
    }

    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> filter;

        FilterSubscriber(Subscriber<? super T> r1, Predicate<? super T> r2) {
            super(r1);
            this.filter = r2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.request(1);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r3) {
            if (this.done == false) goto L7;
            return false;
        L7:
            if (this.sourceMode == 0) goto L17;
            this.downstream.onNext(null);
            return true;
        L17:
            boolean r0 = this.filter.test(r3);     // Catch: Throwable -> L14
            if (r0 == false) goto L13;
            this.downstream.onNext((Object) r3);
        L13:
            return r0;
        L14:
            th = move-exception;
            fail(th);
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> r0 = this.qs;
            Predicate<? super T> r1 = this.filter;
        L3:
            T r2 = r0.poll();
            if (r2 == null) goto L5;
            if (r1.test(r2) == true) goto L9;
            if (this.sourceMode != 2) goto L3;
            r0.request(1);
            goto L3
        L9:
            return r2;
        L5:
            return null;
        }
    }

    public FlowableFilter(Flowable<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        if ((r3 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) r3, this.predicate));
        return;
    L5:
        this.source.subscribe(new FilterSubscriber(r3, this.predicate));
    }
}
