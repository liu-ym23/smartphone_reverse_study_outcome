package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    final ParallelFlowable<T> source;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelMapTry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = null;

        static {
            int[] r0 = new int[ParallelFailureHandling.values().length];
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = r0;
            r0[ParallelFailureHandling.RETRY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> r1, Function<? super T, ? extends R> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.errorHandler = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r10) {
            if (this.done == false) goto L5;
            return false;
        L5:
            long r2 = 0;
        L26:
            return this.downstream.tryOnNext(ObjectHelper.requireNonNull(this.mapper.apply(r10), "The mapper returned a null value"));
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L21
            int r6 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item")).ordinal()];
            if (r6 == 1) goto L26;
            if (r6 != 2) goto L16;
        L20:
            return false;
        L16:
            if (r6 == 3) goto L19;
            cancel();
            onError(th);
            return false;
        L19:
            cancel();
            onComplete();
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }
    }

    static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        ParallelMapTrySubscriber(Subscriber<? super R> r1, Function<? super T, ? extends R> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.errorHandler = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r10) {
            if (this.done == false) goto L5;
            return false;
        L5:
            long r2 = 0;
        L27:
            this.downstream.onNext(ObjectHelper.requireNonNull(this.mapper.apply(r10), "The mapper returned a null value"));
            return true;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2 = r2 + 1;     // Catch: Throwable -> L22
            int r6 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(r2), th), "The errorHandler returned a null item")).ordinal()];
            if (r6 == 1) goto L27;
            if (r6 != 2) goto L17;
        L21:
            return false;
        L17:
            if (r6 == 3) goto L20;
            cancel();
            onError(th);
            return false;
        L20:
            cancel();
            onComplete();
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(new CompositeException(new Throwable[]{th, th}));
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public ParallelMapTry(ParallelFlowable<T> r1, Function<? super T, ? extends R> r2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> r3) {
        this.source = r1;
        this.mapper = r2;
        this.errorHandler = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] r8) {
        if (validate(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Subscriber<? super R> r3 = r8[r2];
        if ((r3 instanceof ConditionalSubscriber) == false) goto L10;
        r1[r2] = new ParallelMapTryConditionalSubscriber((ConditionalSubscriber) r3, this.mapper, this.errorHandler);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r1[r2] = new ParallelMapTrySubscriber(r3, this.mapper, this.errorHandler);
        goto L11
    L12:
        this.source.subscribe(r1);
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }
}
