package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> r1, Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Action r5) {
            super(r1);
            this.onNext = r2;
            this.onError = r3;
            this.onComplete = r4;
            this.onAfterTerminate = r5;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L15;
            this.downstream.onNext(null);
            return;
        L15:
            this.onNext.accept(r2);     // Catch: Throwable -> L12
            this.downstream.onNext((Object) r2);
            return;
        L12:
            th = move-exception;
            fail(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r3) {
            if (this.done == false) goto L11;
            return false;
        L11:
            this.onNext.accept(r3);     // Catch: Throwable -> L8
            return this.downstream.tryOnNext((Object) r3);
        L8:
            th = move-exception;
            fail(th);
            return false;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable r7) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r7);
            return;
        L6:
            boolean r0 = true;
            this.done = true;
            this.onError.accept(r7);     // Catch: Throwable -> L9
        L11:
            if (r0 == false) goto L20;
            this.downstream.onError(r7);
        L20:
            this.onAfterTerminate.run();     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r7, th}));
            r0 = false;
            goto L11
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L15;
            return;
        L15:
            this.onComplete.run();     // Catch: Throwable -> L12
            this.done = true;
            this.downstream.onComplete();
            this.onAfterTerminate.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r3 = this.qs.poll();     // Catch: Throwable -> L22
            if (r3 == null) goto L19;
            this.onNext.accept(r3);     // Catch: Throwable -> L7
            this.onAfterTerminate.run();
        L21:
            return r3;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);     // Catch: Throwable -> L15
            this.onError.accept(th);     // Catch: Throwable -> L12
        L11:
            throw ExceptionHelper.throwIfThrowable(th);     // Catch: Throwable -> L15
        L12:
            th = move-exception;
            throw new CompositeException(new Throwable[]{th, th});     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            this.onAfterTerminate.run();
            throw th;
        L19:
            if (this.sourceMode != 1) goto L21;
            this.onComplete.run();
            this.onAfterTerminate.run();
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.onError.accept(th);     // Catch: Throwable -> L27
            throw ExceptionHelper.throwIfThrowable(th);
        L27:
            th = move-exception;
            throw new CompositeException(new Throwable[]{th, th});
        }
    }

    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachSubscriber(Subscriber<? super T> r1, Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Action r5) {
            super(r1);
            this.onNext = r2;
            this.onError = r3;
            this.onComplete = r4;
            this.onAfterTerminate = r5;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L15;
            this.downstream.onNext(null);
            return;
        L15:
            this.onNext.accept(r2);     // Catch: Throwable -> L12
            this.downstream.onNext((Object) r2);
            return;
        L12:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable r7) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r7);
            return;
        L6:
            boolean r0 = true;
            this.done = true;
            this.onError.accept(r7);     // Catch: Throwable -> L9
        L11:
            if (r0 == false) goto L20;
            this.downstream.onError(r7);
        L20:
            this.onAfterTerminate.run();     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r7, th}));
            r0 = false;
            goto L11
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L15;
            return;
        L15:
            this.onComplete.run();     // Catch: Throwable -> L12
            this.done = true;
            this.downstream.onComplete();
            this.onAfterTerminate.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r3 = this.qs.poll();     // Catch: Throwable -> L22
            if (r3 == null) goto L19;
            this.onNext.accept(r3);     // Catch: Throwable -> L7
            this.onAfterTerminate.run();
        L21:
            return r3;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);     // Catch: Throwable -> L15
            this.onError.accept(th);     // Catch: Throwable -> L12
        L11:
            throw ExceptionHelper.throwIfThrowable(th);     // Catch: Throwable -> L15
        L12:
            th = move-exception;
            throw new CompositeException(new Throwable[]{th, th});     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            this.onAfterTerminate.run();
            throw th;
        L19:
            if (this.sourceMode != 1) goto L21;
            this.onComplete.run();
            this.onAfterTerminate.run();
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.onError.accept(th);     // Catch: Throwable -> L27
            throw ExceptionHelper.throwIfThrowable(th);
        L27:
            th = move-exception;
            throw new CompositeException(new Throwable[]{th, th});
        }
    }

    public FlowableDoOnEach(Flowable<T> r1, Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Action r5) {
        super(r1);
        this.onNext = r2;
        this.onError = r3;
        this.onComplete = r4;
        this.onAfterTerminate = r5;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r9) {
        if ((r9 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new DoOnEachConditionalSubscriber((ConditionalSubscriber) r9, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
        return;
    L5:
        this.source.subscribe(new DoOnEachSubscriber(r9, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
    }
}
