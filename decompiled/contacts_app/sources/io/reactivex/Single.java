package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDematerialize;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleDoOnTerminate;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleMaterialize;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Single<T> implements SingleSource<T> {
    protected abstract void subscribeActual(SingleObserver<? super T> r1);

    public Single() {
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "sources is null");
        return RxJavaPlugins.onAssembly(new SingleAmb(null, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> ambArray(SingleSource<? extends T>... r2) {
        if (r2.length != 0) goto L7;
        return error(SingleInternalHelper.emptyThrower());
    L7:
        if (r2.length != 1) goto L11;
        return wrap(r2[0]);
    L11:
        return RxJavaPlugins.onAssembly(new SingleAmb(r2, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> r0) {
        return concat(Flowable.fromIterable(r0));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> r4) {
        ObjectHelper.requireNonNull(r4, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(r4, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> r1) {
        return concat(r1, 2);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> r3, int r4) {
        ObjectHelper.requireNonNull(r3, "sources is null");
        ObjectHelper.verifyPositive(r4, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(r3, SingleInternalHelper.toFlowable(), r4, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> r2, SingleSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return concat(Flowable.fromArray(new SingleSource[]{r2, r3}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return concat(Flowable.fromArray(new SingleSource[]{r2, r3, r4}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4, SingleSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return concat(Flowable.fromArray(new SingleSource[]{r2, r3, r4, r5}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArray(SingleSource<? extends T>... r4) {
        return RxJavaPlugins.onAssembly(new FlowableConcatMap(Flowable.fromArray(r4), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(SingleSource<? extends T>... r1) {
        return Flowable.fromArray(r1).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Publisher<? extends SingleSource<? extends T>> r1) {
        return Flowable.fromPublisher(r1).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Iterable<? extends SingleSource<? extends T>> r1) {
        return Flowable.fromIterable(r1).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> create(SingleOnSubscribe<T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        return RxJavaPlugins.onAssembly(new SingleCreate(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> r1) {
        ObjectHelper.requireNonNull(r1, "singleSupplier is null");
        return RxJavaPlugins.onAssembly(new SingleDefer(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> error(Callable<? extends Throwable> r1) {
        ObjectHelper.requireNonNull(r1, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new SingleError(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> error(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "exception is null");
        return error(Functions.justCallable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromCallable(Callable<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "callable is null");
        return RxJavaPlugins.onAssembly(new SingleFromCallable(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> r0) {
        return toSingle(Flowable.fromFuture(r0));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> r0, long r1, TimeUnit r3) {
        return toSingle(Flowable.fromFuture(r0, r1, r3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> r0, long r1, TimeUnit r3, Scheduler r4) {
        return toSingle(Flowable.fromFuture(r0, r1, r3, r4));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> r0, Scheduler r1) {
        return toSingle(Flowable.fromFuture(r0, r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Single<T> fromPublisher(Publisher<? extends T> r1) {
        ObjectHelper.requireNonNull(r1, "publisher is null");
        return RxJavaPlugins.onAssembly(new SingleFromPublisher(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromObservable(ObservableSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "observableSource is null");
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(r2, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> just(T r1) {
        ObjectHelper.requireNonNull(r1, "item is null");
        return RxJavaPlugins.onAssembly(new SingleJust(r1));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> r0) {
        return merge(Flowable.fromIterable(r0));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> r7) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(r7, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "source is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMap(r2, Functions.identity()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> r2, SingleSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return merge(Flowable.fromArray(new SingleSource[]{r2, r3}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return merge(Flowable.fromArray(new SingleSource[]{r2, r3, r4}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4, SingleSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return merge(Flowable.fromArray(new SingleSource[]{r2, r3, r4, r5}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> r0) {
        return mergeDelayError(Flowable.fromIterable(r0));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> r7) {
        ObjectHelper.requireNonNull(r7, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(r7, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> r2, SingleSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return mergeDelayError(Flowable.fromArray(new SingleSource[]{r2, r3}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return mergeDelayError(Flowable.fromArray(new SingleSource[]{r2, r3, r4}));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> r2, SingleSource<? extends T> r3, SingleSource<? extends T> r4, SingleSource<? extends T> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return mergeDelayError(Flowable.fromArray(new SingleSource[]{r2, r3, r4, r5}));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> never() {
        return RxJavaPlugins.onAssembly(SingleNever.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Single<Long> timer(long r1, TimeUnit r3) {
        return timer(r1, r3, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Single<Long> timer(long r1, TimeUnit r3, Scheduler r4) {
        ObjectHelper.requireNonNull(r3, "unit is null");
        ObjectHelper.requireNonNull(r4, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleTimer(r1, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> equals(SingleSource<? extends T> r1, SingleSource<? extends T> r2) {
        ObjectHelper.requireNonNull(r1, "first is null");
        ObjectHelper.requireNonNull(r2, "second is null");
        return RxJavaPlugins.onAssembly(new SingleEquals(r1, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> unsafeCreate(SingleSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "onSubscribe is null");
        if ((r1 instanceof Single) == true) goto L7;
        return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(r1));
    L7:
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> Single<T> using(Callable<U> r1, Function<? super U, ? extends SingleSource<? extends T>> r2, Consumer<? super U> r3) {
        return using(r1, r2, r3, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> Single<T> using(Callable<U> r1, Function<? super U, ? extends SingleSource<? extends T>> r2, Consumer<? super U> r3, boolean r4) {
        ObjectHelper.requireNonNull(r1, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r2, "singleFunction is null");
        ObjectHelper.requireNonNull(r3, "disposer is null");
        return RxJavaPlugins.onAssembly(new SingleUsing(r1, r2, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> wrap(SingleSource<T> r1) {
        ObjectHelper.requireNonNull(r1, "source is null");
        if ((r1 instanceof Single) == false) goto L7;
        return RxJavaPlugins.onAssembly((Single) r1);
    L7:
        return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "zipper is null");
        ObjectHelper.requireNonNull(r1, "sources is null");
        return RxJavaPlugins.onAssembly(new SingleZipIterable(r1, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, BiFunction<? super T1, ? super T2, ? extends R> r4) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        return zipArray(Functions.toFunction(r4), new SingleSource[]{r2, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, Function3<? super T1, ? super T2, ? super T3, ? extends R> r5) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        return zipArray(Functions.toFunction(r5), new SingleSource[]{r2, r3, r4});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> r6) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        return zipArray(Functions.toFunction(r6), new SingleSource[]{r2, r3, r4, r5});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, SingleSource<? extends T5> r6, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> r7) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        return zipArray(Functions.toFunction(r7), new SingleSource[]{r2, r3, r4, r5, r6});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, SingleSource<? extends T5> r6, SingleSource<? extends T6> r7, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> r8) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        return zipArray(Functions.toFunction(r8), new SingleSource[]{r2, r3, r4, r5, r6, r7});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, SingleSource<? extends T5> r6, SingleSource<? extends T6> r7, SingleSource<? extends T7> r8, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> r9) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        return zipArray(Functions.toFunction(r9), new SingleSource[]{r2, r3, r4, r5, r6, r7, r8});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, SingleSource<? extends T5> r6, SingleSource<? extends T6> r7, SingleSource<? extends T7> r8, SingleSource<? extends T8> r9, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> r10) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        return zipArray(Functions.toFunction(r10), new SingleSource[]{r2, r3, r4, r5, r6, r7, r8, r9});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> r2, SingleSource<? extends T2> r3, SingleSource<? extends T3> r4, SingleSource<? extends T4> r5, SingleSource<? extends T5> r6, SingleSource<? extends T6> r7, SingleSource<? extends T7> r8, SingleSource<? extends T8> r9, SingleSource<? extends T9> r10, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> r11) {
        ObjectHelper.requireNonNull(r2, "source1 is null");
        ObjectHelper.requireNonNull(r3, "source2 is null");
        ObjectHelper.requireNonNull(r4, "source3 is null");
        ObjectHelper.requireNonNull(r5, "source4 is null");
        ObjectHelper.requireNonNull(r6, "source5 is null");
        ObjectHelper.requireNonNull(r7, "source6 is null");
        ObjectHelper.requireNonNull(r8, "source7 is null");
        ObjectHelper.requireNonNull(r9, "source8 is null");
        ObjectHelper.requireNonNull(r10, "source9 is null");
        return zipArray(Functions.toFunction(r11), new SingleSource[]{r2, r3, r4, r5, r6, r7, r8, r9, r10});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> r1, SingleSource<? extends T>... r2) {
        ObjectHelper.requireNonNull(r1, "zipper is null");
        ObjectHelper.requireNonNull(r2, "sources is null");
        if (r2.length != 0) goto L7;
        return error(new NoSuchElementException());
    L7:
        return RxJavaPlugins.onAssembly(new SingleZipArray(r2, r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> ambWith(SingleSource<? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "other is null");
        return ambArray(new SingleSource[]{this, r3});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R as(SingleConverter<T, ? extends R> r2) {
        return (R) ((SingleConverter) ObjectHelper.requireNonNull(r2, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> hide() {
        return RxJavaPlugins.onAssembly(new SingleHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> r2) {
        return wrap(((SingleTransformer) ObjectHelper.requireNonNull(r2, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> cache() {
        return RxJavaPlugins.onAssembly(new SingleCache(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> cast(Class<? extends U> r2) {
        ObjectHelper.requireNonNull(r2, "clazz is null");
        return (Single<U>) map(Functions.castFunction(r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> concatWith(SingleSource<? extends T> r1) {
        return concat(this, r1);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> delay(long r7, TimeUnit r9) {
        return delay(r7, r9, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> delay(long r7, TimeUnit r9, boolean r10) {
        return delay(r7, r9, Schedulers.computation(), r10);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> delay(long r7, TimeUnit r9, Scheduler r10) {
        return delay(r7, r9, r10, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> delay(long r9, TimeUnit r11, Scheduler r12, boolean r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleDelay(this, r9, r11, r12, r13));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> delaySubscription(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(SingleSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(ObservableSource<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithObservable(this, r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(Publisher<U> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithPublisher(this, r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> delaySubscription(long r2, TimeUnit r4) {
        return delaySubscription(r2, r4, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> delaySubscription(long r1, TimeUnit r3, Scheduler r4) {
        return delaySubscription(Observable.timer(r1, r3, r4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Maybe<R> dematerialize(Function<? super T, Notification<R>> r2) {
        ObjectHelper.requireNonNull(r2, "selector is null");
        return RxJavaPlugins.onAssembly(new SingleDematerialize(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doAfterSuccess(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onAfterSuccess is null");
        return RxJavaPlugins.onAssembly(new SingleDoAfterSuccess(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doAfterTerminate(Action r2) {
        ObjectHelper.requireNonNull(r2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new SingleDoAfterTerminate(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doFinally(Action r2) {
        ObjectHelper.requireNonNull(r2, "onFinally is null");
        return RxJavaPlugins.onAssembly(new SingleDoFinally(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnSubscribe(Consumer<? super Disposable> r2) {
        ObjectHelper.requireNonNull(r2, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnSubscribe(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnTerminate(Action r2) {
        ObjectHelper.requireNonNull(r2, "onTerminate is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnTerminate(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnSuccess(Consumer<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "onSuccess is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnSuccess(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "onEvent is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnEvent(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnError(Consumer<? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "onError is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnError(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnDispose(Action r2) {
        ObjectHelper.requireNonNull(r2, "onDispose is null");
        return RxJavaPlugins.onAssembly(new SingleDoOnDispose(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> filter(Predicate<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeFilterSingle(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMap(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapMaybe(this, r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapPublisher(this, r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapIterableFlowable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapIterableObservable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapObservable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleFlatMapCompletable(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingGet() {
        BlockingMultiObserver r0 = new BlockingMultiObserver();
        subscribe(r0);
        return (T) r0.blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> r2) {
        ObjectHelper.requireNonNull(r2, "lift is null");
        return RxJavaPlugins.onAssembly(new SingleLift(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> map(Function<? super T, ? extends R> r2) {
        ObjectHelper.requireNonNull(r2, "mapper is null");
        return RxJavaPlugins.onAssembly(new SingleMap(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new SingleMaterialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object r2) {
        return contains(r2, ObjectHelper.equalsPredicate());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object r2, BiPredicate<Object, Object> r3) {
        ObjectHelper.requireNonNull(r2, "value is null");
        ObjectHelper.requireNonNull(r3, "comparer is null");
        return RxJavaPlugins.onAssembly(new SingleContains(this, r2, r3));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> mergeWith(SingleSource<? extends T> r1) {
        return merge(this, r1);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> observeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleObserveOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> r3) {
        ObjectHelper.requireNonNull(r3, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, r3, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorReturnItem(T r3) {
        ObjectHelper.requireNonNull(r3, "value is null");
        return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, null, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorResumeNext(Single<? extends T> r2) {
        ObjectHelper.requireNonNull(r2, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.justFunction(r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> r2) {
        ObjectHelper.requireNonNull(r2, "resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.onAssembly(new SingleResumeNext(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new SingleDetach(this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat() {
        return toFlowable().repeat();
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat(long r1) {
        return toFlowable().repeat(r1);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> r1) {
        return toFlowable().repeatWhen(r1);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatUntil(BooleanSupplier r1) {
        return toFlowable().repeatUntil(r1);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry() {
        return toSingle(toFlowable().retry());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(long r1) {
        return toSingle(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> r1) {
        return toSingle(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(long r1, Predicate<? super Throwable> r3) {
        return toSingle(toFlowable().retry(r1, r3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(Predicate<? super Throwable> r1) {
        return toSingle(toFlowable().retry(r1));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> r1) {
        return toSingle(toFlowable().retryWhen(r1));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> r2) {
        ObjectHelper.requireNonNull(r2, "onCallback is null");
        BiConsumerSingleObserver r0 = new BiConsumerSingleObserver(r2);
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2) {
        return subscribe(r2, Functions.ON_ERROR_MISSING);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> r2, Consumer<? super Throwable> r3) {
        ObjectHelper.requireNonNull(r2, "onSuccess is null");
        ObjectHelper.requireNonNull(r3, "onError is null");
        ConsumerSingleObserver r0 = new ConsumerSingleObserver(r2, r3);
        subscribe(r0);
        return r0;
    }

    @Override // io.reactivex.SingleSource
    @SchedulerSupport("none")
    public final void subscribe(SingleObserver<? super T> r2) {
        ObjectHelper.requireNonNull(r2, "observer is null");
        SingleObserver<? super T> r3 = RxJavaPlugins.onSubscribe(this, r2);
        ObjectHelper.requireNonNull(r3, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        subscribeActual(r3);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        NullPointerException r4 = new NullPointerException("subscribeActual failed");
        r4.initCause(th);
        throw r4;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends SingleObserver<? super T>> E subscribeWith(E r1) {
        subscribe(r1);
        return r1;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> subscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleSubscribeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> takeUntil(CompletableSource r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return takeUntil(new CompletableToFlowable(r2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <E> Single<T> takeUntil(Publisher<E> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return RxJavaPlugins.onAssembly(new SingleTakeUntil(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E> Single<T> takeUntil(SingleSource<? extends E> r2) {
        ObjectHelper.requireNonNull(r2, "other is null");
        return takeUntil(new SingleToFlowable(r2));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> timeout(long r7, TimeUnit r9) {
        return timeout0(r7, r9, Schedulers.computation(), null);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> timeout(long r7, TimeUnit r9, Scheduler r10) {
        return timeout0(r7, r9, r10, null);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> timeout(long r2, TimeUnit r4, Scheduler r5, SingleSource<? extends T> r6) {
        ObjectHelper.requireNonNull(r6, "other is null");
        return timeout0(r2, r4, r5, r6);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> timeout(long r8, TimeUnit r10, SingleSource<? extends T> r11) {
        ObjectHelper.requireNonNull(r11, "other is null");
        return timeout0(r8, r10, Schedulers.computation(), r11);
    }

    private Single<T> timeout0(long r9, TimeUnit r11, Scheduler r12, SingleSource<? extends T> r13) {
        ObjectHelper.requireNonNull(r11, "unit is null");
        ObjectHelper.requireNonNull(r12, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleTimeout(this, r9, r11, r12, r13));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super Single<T>, R> r2) {
        return (R) ((Function) ObjectHelper.requireNonNull(r2, "convert is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Deprecated
    public final Completable toCompletable() {
        return RxJavaPlugins.onAssembly(new CompletableFromSingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly(new CompletableFromSingle(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> toFlowable() {
        if ((this instanceof FuseToFlowable) == false) goto L7;
        return ((FuseToFlowable) this).fuseToFlowable();
    L7:
        return RxJavaPlugins.onAssembly(new SingleToFlowable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSingleObserver());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> toMaybe() {
        if ((this instanceof FuseToMaybe) == false) goto L7;
        return ((FuseToMaybe) this).fuseToMaybe();
    L7:
        return RxJavaPlugins.onAssembly(new MaybeFromSingle(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> toObservable() {
        if ((this instanceof FuseToObservable) == false) goto L7;
        return ((FuseToObservable) this).fuseToObservable();
    L7:
        return RxJavaPlugins.onAssembly(new SingleToObservable(this));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single<T> unsubscribeOn(Scheduler r2) {
        ObjectHelper.requireNonNull(r2, "scheduler is null");
        return RxJavaPlugins.onAssembly(new SingleUnsubscribeOn(this, r2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Single<R> zipWith(SingleSource<U> r1, BiFunction<? super T, ? super U, ? extends R> r2) {
        return zip(this, r1, r2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> r0 = new TestObserver();
        subscribe(r0);
        return r0;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean r2) {
        TestObserver<T> r0 = new TestObserver();
        if (r2 == false) goto L5;
        r0.cancel();
    L5:
        subscribe(r0);
        return r0;
    }

    private static <T> Single<T> toSingle(Flowable<T> r2) {
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(r2, null));
    }
}
