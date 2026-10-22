package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    final Function<? super T, K> keySelector;

    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> r1, Function<? super T, K> r2, BiPredicate<? super K, ? super K> r3) {
            super(r1);
            this.keySelector = r2;
            this.comparer = r3;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.request(1);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r6) {
            if (this.done == false) goto L6;
            return false;
        L6:
            if (this.sourceMode == 0) goto L21;
            return this.downstream.tryOnNext((Object) r6);
        L21:
            K r2 = this.keySelector.apply(r6);     // Catch: Throwable -> L18
            if (this.hasValue == false) goto L15;
            boolean r3 = this.comparer.test(this.last, r2);     // Catch: Throwable -> L18
            this.last = r2;     // Catch: Throwable -> L18
            if (r3 == false) goto L16;
            return false;
        L16:
            this.downstream.onNext((Object) r6);
            return true;
        L15:
            this.hasValue = true;     // Catch: Throwable -> L18
            this.last = r2;     // Catch: Throwable -> L18
        L18:
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
        L2:
            T r0 = this.qs.poll();
            if (r0 == null) goto L4;
            K r1 = this.keySelector.apply(r0);
            if (this.hasValue == false) goto L8;
            if (this.comparer.test(this.last, r1) == false) goto L12;
            this.last = r1;
            if (this.sourceMode == 1) goto L2;
            this.upstream.request(1);
            goto L2
        L12:
            this.last = r1;
            return r0;
        L8:
            this.hasValue = true;
            this.last = r1;
            return r0;
        L4:
            return null;
        }
    }

    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        DistinctUntilChangedSubscriber(Subscriber<? super T> r1, Function<? super T, K> r2, BiPredicate<? super K, ? super K> r3) {
            super(r1);
            this.keySelector = r2;
            this.comparer = r3;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.request(1);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r6) {
            if (this.done == false) goto L6;
            return false;
        L6:
            if (this.sourceMode == 0) goto L20;
            this.downstream.onNext((Object) r6);
            return true;
        L20:
            K r0 = this.keySelector.apply(r6);     // Catch: Throwable -> L17
            if (this.hasValue == false) goto L14;
            boolean r3 = this.comparer.test(this.last, r0);     // Catch: Throwable -> L17
            this.last = r0;     // Catch: Throwable -> L17
            if (r3 == false) goto L15;
            return false;
        L15:
            this.downstream.onNext((Object) r6);
            return true;
        L14:
            this.hasValue = true;     // Catch: Throwable -> L17
            this.last = r0;     // Catch: Throwable -> L17
        L17:
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
        L2:
            T r0 = this.qs.poll();
            if (r0 == null) goto L4;
            K r1 = this.keySelector.apply(r0);
            if (this.hasValue == false) goto L8;
            if (this.comparer.test(this.last, r1) == false) goto L12;
            this.last = r1;
            if (this.sourceMode == 1) goto L2;
            this.upstream.request(1);
            goto L2
        L12:
            this.last = r1;
            return r0;
        L8:
            this.hasValue = true;
            this.last = r1;
            return r0;
        L4:
            return null;
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> r1, Function<? super T, K> r2, BiPredicate<? super K, ? super K> r3) {
        super(r1);
        this.keySelector = r2;
        this.comparer = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r4) {
        if ((r4 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) r4, this.keySelector, this.comparer));
        return;
    L5:
        this.source.subscribe(new DistinctUntilChangedSubscriber(r4, this.keySelector, this.comparer));
    }
}
