package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> onAfterNext;

    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> r1, Consumer<? super T> r2) {
            super(r1);
            this.onAfterNext = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            this.downstream.onNext((Object) r2);
            if (this.sourceMode != 0) goto L11;
            this.onAfterNext.accept(r2);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            fail(th);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r3) {
            boolean r0 = this.downstream.tryOnNext((Object) r3);
            this.onAfterNext.accept(r3);     // Catch: Throwable -> L5
        L7:
            return r0;
        L5:
            th = move-exception;
            fail(th);
            goto L7
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
            this.onAfterNext.accept(r0);
        L5:
            return r0;
        }
    }

    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        DoAfterSubscriber(Subscriber<? super T> r1, Consumer<? super T> r2) {
            super(r1);
            this.onAfterNext = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.downstream.onNext((Object) r2);
            if (this.sourceMode != 0) goto L14;
            this.onAfterNext.accept(r2);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            fail(th);
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
            this.onAfterNext.accept(r0);
        L5:
            return r0;
        }
    }

    public FlowableDoAfterNext(Flowable<T> r1, Consumer<? super T> r2) {
        super(r1);
        this.onAfterNext = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        if ((r3 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) r3, this.onAfterNext));
        return;
    L5:
        this.source.subscribe(new DoAfterSubscriber(r3, this.onAfterNext));
    }
}
