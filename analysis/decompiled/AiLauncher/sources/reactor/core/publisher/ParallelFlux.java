package reactor.core.publisher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.FluxConcatMap;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.FluxOnAssembly;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
public abstract class ParallelFlux<T> implements CorePublisher<T> {
    public static /* synthetic */ List a(Comparator comparator, List list) {
        list.sort(comparator);
        return list;
    }

    public static /* synthetic */ List b(int i10) {
        return new ArrayList(i10);
    }

    public static <T> ParallelFlux<T> doOnSignal(ParallelFlux<T> parallelFlux, @Nullable Consumer<? super T> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable Consumer<? super qc.d> consumer4, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        return onAssembly(new ParallelPeek(parallelFlux, consumer, consumer2, consumer3, runnable, runnable2, consumer4, longConsumer, runnable3));
    }

    public static <T> ParallelFlux<T> from(ParallelFlux<T> parallelFlux) {
        return ContextPropagationSupport.shouldWrapPublisher(parallelFlux) ? new ParallelFluxRestoringThreadLocals(parallelFlux) : parallelFlux;
    }

    public static /* synthetic */ List g(Comparator comparator, List list) {
        list.sort(comparator);
        return list;
    }

    public static /* synthetic */ List h(List list, Object obj) {
        list.add(obj);
        return list;
    }

    public static /* synthetic */ List j(int i10) {
        return new ArrayList(i10);
    }

    public static /* synthetic */ List k(List list, Object obj) {
        list.add(obj);
        return list;
    }

    public static <T> ParallelFlux<T> onAssembly(ParallelFlux<T> parallelFlux) {
        Function<qc.b, qc.b> function = Hooks.onEachOperatorHook;
        if (function != null) {
            parallelFlux = (ParallelFlux) function.apply(parallelFlux);
        }
        return Hooks.GLOBAL_TRACE ? (ParallelFlux) Hooks.addAssemblyInfo(parallelFlux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : parallelFlux;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0037, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.util.List<T> sortedMerger(java.util.List<T> r5, java.util.List<T> r6, java.util.Comparator<? super T> r7) {
        /*
            int r0 = r5.size()
            int r1 = r6.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L11
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            return r5
        L11:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
            boolean r0 = r5.hasNext()
            r2 = 0
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r5.next()
            goto L2b
        L2a:
            r0 = r2
        L2b:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r6.next()
            goto L37
        L36:
            r3 = r2
        L37:
            if (r0 == 0) goto L5f
            if (r3 == 0) goto L5f
            int r4 = r7.compare(r0, r3)
            if (r4 >= 0) goto L51
            r1.add(r0)
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L4f
            java.lang.Object r0 = r5.next()
            goto L37
        L4f:
            r0 = r2
            goto L37
        L51:
            r1.add(r3)
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r6.next()
            goto L37
        L5f:
            if (r0 == 0) goto L72
            r1.add(r0)
        L64:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L85
            java.lang.Object r6 = r5.next()
            r1.add(r6)
            goto L64
        L72:
            if (r3 == 0) goto L85
            r1.add(r3)
        L77:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto L85
            java.lang.Object r5 = r6.next()
            r1.add(r5)
            goto L77
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ParallelFlux.sortedMerger(java.util.List, java.util.List, java.util.Comparator):java.util.List");
    }

    public final <U> U as(Function<? super ParallelFlux<T>, U> function) {
        return function.apply(this);
    }

    public final ParallelFlux<T> checkpoint() {
        return new ParallelFluxOnAssembly(this, new FluxOnAssembly.CheckpointHeavySnapshot(null, Traces.callSiteSupplierFactory.get()));
    }

    public final <C> ParallelFlux<C> collect(Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        return onAssembly(new ParallelCollect(this, supplier, biConsumer));
    }

    public final Mono<List<T>> collectSortedList(Comparator<? super T> comparator) {
        return collectSortedList(comparator, 16);
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qc.b<? extends R>> function) {
        return concatMap(function, 2, FluxConcatMap.ErrorMode.IMMEDIATE);
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qc.b<? extends R>> function) {
        return concatMap(function, 2, FluxConcatMap.ErrorMode.END);
    }

    public final ParallelFlux<T> doAfterTerminate(Runnable runnable) {
        Objects.requireNonNull(runnable, "afterTerminate");
        return doOnSignal(this, null, null, null, null, runnable, null, null, null);
    }

    public final ParallelFlux<T> doOnCancel(Runnable runnable) {
        Objects.requireNonNull(runnable, "onCancel");
        return doOnSignal(this, null, null, null, null, null, null, null, runnable);
    }

    public final ParallelFlux<T> doOnComplete(Runnable runnable) {
        Objects.requireNonNull(runnable, "onComplete");
        return doOnSignal(this, null, null, null, runnable, null, null, null, null);
    }

    public final ParallelFlux<T> doOnEach(final Consumer<? super Signal<T>> consumer) {
        Objects.requireNonNull(consumer, "signalConsumer");
        return onAssembly(new ParallelDoOnEach(this, new BiConsumer() { // from class: reactor.core.publisher.k2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                consumer.accept(Signal.next(obj2, (Context) obj));
            }
        }, new BiConsumer() { // from class: reactor.core.publisher.n2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                consumer.accept(Signal.error((Throwable) obj2, (Context) obj));
            }
        }, new Consumer() { // from class: reactor.core.publisher.o2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                consumer.accept(Signal.complete((Context) obj));
            }
        }));
    }

    public final ParallelFlux<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError");
        return doOnSignal(this, null, null, consumer, null, null, null, null, null);
    }

    public final ParallelFlux<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext");
        return doOnSignal(this, consumer, null, null, null, null, null, null, null);
    }

    public final ParallelFlux<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "onRequest");
        return doOnSignal(this, null, null, null, null, null, null, longConsumer, null);
    }

    public final ParallelFlux<T> doOnSubscribe(Consumer<? super qc.d> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, null, null, null, null, null, consumer, null, null);
    }

    public final ParallelFlux<T> doOnTerminate(final Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        return doOnSignal(this, null, null, new Consumer() { // from class: reactor.core.publisher.p2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                runnable.run();
            }
        }, runnable, null, null, null, null);
    }

    public final ParallelFlux<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return onAssembly(new ParallelFilter(this, predicate));
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qc.b<? extends R>> function) {
        return flatMap(function, false, Integer.MAX_VALUE, Queues.SMALL_BUFFER_SIZE);
    }

    public int getPrefetch() {
        return -1;
    }

    public final Flux<GroupedFlux<Integer, T>> groups() {
        return Flux.onAssembly(new ParallelGroup(this));
    }

    public final ParallelFlux<T> hide() {
        return new ParallelFluxHide(this);
    }

    public final ParallelFlux<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public final <U> ParallelFlux<U> map(Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function, "mapper");
        return onAssembly(new ParallelMap(this, function));
    }

    public final ParallelFlux<T> name(String str) {
        return ParallelFluxName.createOrAppend(this, str);
    }

    public final Flux<T> ordered(Comparator<? super T> comparator) {
        return ordered(comparator, Queues.SMALL_BUFFER_SIZE);
    }

    public abstract int parallelism();

    public final Mono<T> reduce(BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer");
        return Mono.onAssembly(new ParallelMergeReduce(this, biFunction));
    }

    public final ParallelFlux<T> runOn(Scheduler scheduler) {
        return runOn(scheduler, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> sequential() {
        return sequential(Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> sorted(Comparator<? super T> comparator) {
        return sorted(comparator, 16);
    }

    public final Disposable subscribe() {
        return subscribe(null, null, null);
    }

    public abstract void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr);

    public final ParallelFlux<T> tag(String str, String str2) {
        return ParallelFluxName.createOrAppend(this, str, str2);
    }

    public final Mono<Void> then() {
        return Mono.onAssembly(new ParallelThen(this));
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U> ParallelFlux<U> transform(Function<? super ParallelFlux<T>, ParallelFlux<U>> function) {
        return onAssembly((ParallelFlux) as(function));
    }

    public final <U> ParallelFlux<U> transformGroups(final Function<? super GroupedFlux<Integer, T>, ? extends qc.b<? extends U>> function) {
        if (getPrefetch() > -1) {
            Flux<GroupedFlux<Integer, T>> fluxGroups = groups();
            function.getClass();
            return from(fluxGroups.flatMap(new Function() { // from class: reactor.core.publisher.q2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (qc.b) function.apply((GroupedFlux) obj);
                }
            }), parallelism(), getPrefetch(), Queues.small());
        }
        Flux<GroupedFlux<Integer, T>> fluxGroups2 = groups();
        function.getClass();
        return from(fluxGroups2.flatMap(new Function() { // from class: reactor.core.publisher.q2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (qc.b) function.apply((GroupedFlux) obj);
            }
        }), parallelism());
    }

    public final boolean validate(qc.c<?>[] cVarArr) {
        int iParallelism = parallelism();
        if (cVarArr.length == iParallelism) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + iParallelism + ", subscribers = " + cVarArr.length);
        int length = cVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Operators.error(cVarArr[i10], illegalArgumentException);
        }
        return false;
    }

    public final Mono<List<T>> collectSortedList(final Comparator<? super T> comparator, int i10) {
        final int iParallelism = (i10 / parallelism()) + 1;
        return reduce(new Supplier() { // from class: reactor.core.publisher.r2
            @Override // java.util.function.Supplier
            public final Object get() {
                return ParallelFlux.b(iParallelism);
            }
        }, new BiFunction() { // from class: reactor.core.publisher.s2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ParallelFlux.k((List) obj, obj2);
            }
        }).map(new Function() { // from class: reactor.core.publisher.t2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ParallelFlux.g(comparator, (List) obj);
            }
        }).reduce(new BiFunction() { // from class: reactor.core.publisher.u2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ParallelFlux.sortedMerger((List) obj, (List) obj2, comparator);
            }
        });
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qc.b<? extends R>> function, int i10) {
        return concatMap(function, i10, FluxConcatMap.ErrorMode.IMMEDIATE);
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qc.b<? extends R>> function, boolean z10, int i10) {
        return concatMap(function, i10, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.BOUNDARY);
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qc.b<? extends R>> function, boolean z10) {
        return flatMap(function, z10, Integer.MAX_VALUE, Queues.SMALL_BUFFER_SIZE);
    }

    public final ParallelFlux<T> log(@Nullable String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final Flux<T> ordered(Comparator<? super T> comparator, int i10) {
        return new ParallelMergeOrdered(this, i10, comparator);
    }

    public final ParallelFlux<T> runOn(Scheduler scheduler, int i10) {
        Objects.requireNonNull(scheduler, "scheduler");
        return onAssembly(new ParallelRunOn(this, scheduler, i10, Queues.get(i10)));
    }

    public final Flux<T> sequential(int i10) {
        return Flux.onAssembly(new ParallelMergeSequential(this, i10, Queues.get(i10)));
    }

    public final Flux<T> sorted(final Comparator<? super T> comparator, int i10) {
        final int iParallelism = (i10 / parallelism()) + 1;
        return Flux.onAssembly(new ParallelMergeSort(reduce(new Supplier() { // from class: reactor.core.publisher.v2
            @Override // java.util.function.Supplier
            public final Object get() {
                return ParallelFlux.j(iParallelism);
            }
        }, new BiFunction() { // from class: reactor.core.publisher.l2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ParallelFlux.h((List) obj, obj2);
            }
        }).map(new Function() { // from class: reactor.core.publisher.m2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ParallelFlux.a(comparator, (List) obj);
            }
        }), comparator));
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, null, null);
    }

    public static <T> ParallelFlux<T> from(qc.b<? extends T> bVar) {
        return from(bVar, Schedulers.DEFAULT_POOL_SIZE, Queues.SMALL_BUFFER_SIZE, Queues.small());
    }

    public final ParallelFlux<T> checkpoint(String str) {
        return new ParallelFluxOnAssembly(this, new FluxOnAssembly.CheckpointLightSnapshot(str));
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qc.b<? extends R>> function, int i10, FluxConcatMap.ErrorMode errorMode) {
        return onAssembly(new ParallelConcatMap(this, function, Queues.get(i10), i10, errorMode));
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qc.b<? extends R>> function, int i10) {
        return concatMap(function, i10, FluxConcatMap.ErrorMode.END);
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qc.b<? extends R>> function, boolean z10, int i10) {
        return flatMap(function, z10, i10, Queues.SMALL_BUFFER_SIZE);
    }

    public final ParallelFlux<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final <R> ParallelFlux<R> reduce(Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "initialSupplier");
        Objects.requireNonNull(biFunction, "reducer");
        return onAssembly(new ParallelReduceSeed(this, supplier, biFunction));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, null);
    }

    public final ParallelFlux<T> checkpoint(String str, boolean z10) {
        FluxOnAssembly.AssemblySnapshot checkpointHeavySnapshot;
        if (!z10) {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointLightSnapshot(str);
        } else {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointHeavySnapshot(str, Traces.callSiteSupplierFactory.get());
        }
        return new ParallelFluxOnAssembly(this, checkpointHeavySnapshot);
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qc.b<? extends R>> function, boolean z10, int i10, int i11) {
        return onAssembly(new ParallelFlatMap(this, function, z10, i10, Queues.get(i10), i11, Queues.get(i11)));
    }

    public final ParallelFlux<T> log(@Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        return onAssembly(new ParallelLog(this, new SignalLogger(this, str, level, z10, signalTypeArr)));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable) {
        return subscribe(consumer, consumer2, runnable, null, null);
    }

    @Override // reactor.core.CorePublisher
    public final void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        sequential().subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(Operators.toCoreSubscriber(coreSubscriber))));
    }

    public static <T> ParallelFlux<T> from(qc.b<? extends T> bVar, int i10) {
        return from(bVar, i10, Queues.SMALL_BUFFER_SIZE, Queues.small());
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3) {
        return subscribe(consumer, consumer2, runnable, consumer3, null);
    }

    public static <T> ParallelFlux<T> from(qc.b<? extends T> bVar, int i10, int i11, Supplier<Queue<T>> supplier) {
        Objects.requireNonNull(supplier, "queueSupplier");
        Objects.requireNonNull(bVar, "source");
        return onAssembly(new ParallelSource(bVar, i10, i11, supplier));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Context context) {
        return subscribe(consumer, consumer2, runnable, null, context);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3, @Nullable Context context) {
        CorePublisher corePublisherOnLastAssembly = Operators.onLastAssembly(this);
        if (corePublisherOnLastAssembly instanceof ParallelFlux) {
            int iParallelism = parallelism();
            LambdaSubscriber[] lambdaSubscriberArr = new LambdaSubscriber[iParallelism];
            for (int i10 = 0; i10 < iParallelism; i10++) {
                lambdaSubscriberArr[i10] = new LambdaSubscriber(consumer, consumer2, runnable, consumer3, context);
            }
            ((ParallelFlux) corePublisherOnLastAssembly).subscribe(lambdaSubscriberArr);
            return Disposables.composite(lambdaSubscriberArr);
        }
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, runnable, consumer3, context);
        corePublisherOnLastAssembly.subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(lambdaSubscriber)));
        return lambdaSubscriber;
    }

    @SafeVarargs
    public static <T> ParallelFlux<T> from(qc.b<T>... bVarArr) {
        return onAssembly(new ParallelArraySource(bVarArr));
    }

    @Override // reactor.core.CorePublisher, qc.b
    public final void subscribe(qc.c<? super T> cVar) {
        Operators.onLastAssembly(sequential()).subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(Operators.toCoreSubscriber(cVar))));
    }
}
