package reactor.core.publisher;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Collector;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.core.publisher.FluxBufferPredicate;
import reactor.core.publisher.FluxCombineLatest;
import reactor.core.publisher.FluxConcatMap;
import reactor.core.publisher.FluxCreate;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.FluxOnAssembly;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.Logger;
import reactor.util.Metrics;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuple4;
import reactor.util.function.Tuple5;
import reactor.util.function.Tuple6;
import reactor.util.function.Tuple7;
import reactor.util.function.Tuple8;
import reactor.util.function.Tuples;
import reactor.util.retry.Retry;

/* loaded from: classes5.dex */
public abstract class Flux<T> implements CorePublisher<T> {
    static final BiFunction TUPLE2_BIFUNCTION = new C5369m();
    static final Supplier LIST_SUPPLIER = new Supplier() { // from class: reactor.core.publisher.n
        @Override // java.util.function.Supplier
        public final Object get() {
            return new ArrayList();
        }
    };
    static final Supplier SET_SUPPLIER = new Supplier() { // from class: reactor.core.publisher.o
        @Override // java.util.function.Supplier
        public final Object get() {
            return new HashSet();
        }
    };
    static final BooleanSupplier ALWAYS_BOOLEAN_SUPPLIER = new BooleanSupplier() { // from class: reactor.core.publisher.p
        @Override // java.util.function.BooleanSupplier
        public final boolean getAsBoolean() {
            return Flux.v();
        }
    };
    static final BiPredicate OBJECT_EQUAL = new C5381q();
    static final Function IDENTITY_FUNCTION = Function.identity();

    public static /* synthetic */ qc.b I(Predicate predicate, Function function, Throwable th) {
        return predicate.test(th) ? (qc.b) function.apply(th) : error(th);
    }

    public static /* synthetic */ List K(Callable callable) throws Exception {
        List list = (List) listSupplier().get();
        Object objCall = callable.call();
        if (objCall != null) {
            list.add(objCall);
        }
        return list;
    }

    public static /* synthetic */ Logger N(Logger logger, String str) {
        return logger;
    }

    public static /* synthetic */ Map O() {
        return new HashMap();
    }

    public static /* synthetic */ qc.b P(Flux flux, final BiFunction biFunction, final ContextView contextView) {
        flux.getClass();
        return Hooks.DETECT_CONTEXT_LOSS ? new ContextTrackingFunctionWrapper(new Function() { // from class: reactor.core.publisher.S
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.Q(biFunction, contextView, (qc.b) obj);
            }
        }, biFunction.toString()).apply((qc.b) flux) : (qc.b) biFunction.apply(flux, contextView);
    }

    public static /* synthetic */ qc.b Q(BiFunction biFunction, ContextView contextView, qc.b bVar) {
        return (qc.b) biFunction.apply(wrap(bVar), contextView);
    }

    public static /* synthetic */ Stream S(Stream stream) {
        return stream;
    }

    public static /* synthetic */ Collection T(Object obj) {
        return new ArrayList();
    }

    public static /* synthetic */ qc.b V(Flux flux, BooleanSupplier booleanSupplier, long j10) {
        flux.getClass();
        return flux.repeat(countingBooleanSupplier(booleanSupplier, j10));
    }

    public static /* synthetic */ qc.b W(Function function, Object obj, Throwable th) {
        return (qc.b) function.apply(obj);
    }

    public static /* synthetic */ Object X(Object obj) {
        return obj;
    }

    public static /* synthetic */ void Z(Predicate predicate, Consumer consumer, Throwable th) {
        if (predicate.test(th)) {
            consumer.accept(th);
        }
    }

    public static /* synthetic */ qc.b c0(Flux flux, Function function) {
        flux.getClass();
        return Hooks.DETECT_CONTEXT_LOSS ? new ContextTrackingFunctionWrapper(function).apply((qc.b) flux) : (qc.b) function.apply(flux);
    }

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(Function<Object[], V> function, qc.b<? extends T>... bVarArr) {
        return combineLatest(function, Queues.XS_BUFFER_SIZE, bVarArr);
    }

    public static <T> Flux<T> concat(Iterable<? extends qc.b<? extends T>> iterable) {
        return onAssembly(new FluxConcatIterable(iterable));
    }

    public static <T> Flux<T> concatDelayError(qc.b<? extends qc.b<? extends T>> bVar) {
        return concatDelayError(bVar, Queues.XS_BUFFER_SIZE);
    }

    private final Flux<T> contextWriteSkippingContextPropagation(final ContextView contextView) {
        return contextWriteSkippingContextPropagation(new Function() { // from class: reactor.core.publisher.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Context) obj).putAll(contextView);
            }
        });
    }

    public static BooleanSupplier countingBooleanSupplier(final BooleanSupplier booleanSupplier, final long j10) {
        return j10 <= 0 ? booleanSupplier : new BooleanSupplier() { // from class: reactor.core.publisher.Flux.4

            /* renamed from: n, reason: collision with root package name */
            long f39469n;

            @Override // java.util.function.BooleanSupplier
            public boolean getAsBoolean() {
                long j11 = this.f39469n;
                this.f39469n = 1 + j11;
                return j11 < j10 && booleanSupplier.getAsBoolean();
            }
        };
    }

    public static <O> Predicate<O> countingPredicate(final Predicate<O> predicate, final long j10) {
        return j10 == 0 ? predicate : new Predicate<O>() { // from class: reactor.core.publisher.Flux.5

            /* renamed from: n, reason: collision with root package name */
            long f39470n;

            @Override // java.util.function.Predicate
            public boolean test(O o10) {
                long j11 = this.f39470n;
                this.f39470n = 1 + j11;
                return j11 < j10 && predicate.test(o10);
            }
        };
    }

    public static <T> Flux<T> create(Consumer<? super FluxSink<T>> consumer) {
        return create(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static <T> Flux<T> defer(Supplier<? extends qc.b<T>> supplier) {
        return onAssembly(new FluxDefer(supplier));
    }

    public static <T> Flux<T> deferContextual(Function<ContextView, ? extends qc.b<T>> function) {
        return onAssembly(new FluxDeferContextual(function));
    }

    public static <T> Flux<T> doOnSignal(Flux<T> flux, @Nullable Consumer<? super qc.d> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        return flux instanceof Fuseable ? onAssembly(new FluxPeekFuseable(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3)) : onAssembly(new FluxPeek(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3));
    }

    public static /* synthetic */ List e0(Object obj) {
        List list = (List) listSupplier().get();
        if (obj != null) {
            list.add(obj);
        }
        return list;
    }

    public static <T> Flux<T> empty() {
        return FluxEmpty.instance();
    }

    public static <U, V> BiPredicate<U, V> equalPredicate() {
        return OBJECT_EQUAL;
    }

    public static <T> Flux<T> error(Throwable th) {
        return error(th, false);
    }

    @SafeVarargs
    @Deprecated
    public static <I> Flux<I> first(qc.b<? extends I>... bVarArr) {
        return firstWithSignal(bVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithSignal(qc.b<? extends I>... bVarArr) {
        return onAssembly(new FluxFirstWithSignal(bVarArr));
    }

    public static <I> Flux<I> firstWithValue(Iterable<? extends qc.b<? extends I>> iterable) {
        return onAssembly(new FluxFirstWithValue(iterable));
    }

    public static <T> Flux<T> from(qc.b<? extends T> bVar) {
        return (!(bVar instanceof Flux) || ContextPropagationSupport.shouldWrapPublisher(bVar)) ? onAssembly(wrap(bVar)) : (Flux) bVar;
    }

    public static <T> Flux<T> fromArray(T[] tArr) {
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : onAssembly(new FluxArray(tArr));
    }

    public static <T> Flux<T> fromIterable(Iterable<? extends T> iterable) {
        return onAssembly(new FluxIterable(iterable));
    }

    public static <T> Flux<T> fromStream(final Stream<? extends T> stream) {
        Objects.requireNonNull(stream, "Stream s must be provided");
        return onAssembly(new FluxStream(new Supplier() { // from class: reactor.core.publisher.W
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.S(stream);
            }
        }));
    }

    public static /* synthetic */ qc.b g0(Flux flux, Function function, BiPredicate biPredicate) {
        flux.getClass();
        return flux.windowUntil(new FluxBufferPredicate.ChangedPredicate(function, biPredicate), true);
    }

    public static <T> Flux<T> generate(Consumer<SynchronousSink<T>> consumer) {
        Objects.requireNonNull(consumer, "generator");
        return onAssembly(new FluxGenerate(consumer));
    }

    public static <O> Supplier<Set<O>> hashSetSupplier() {
        return SET_SUPPLIER;
    }

    public static <T> Function<T, T> identityFunction() {
        return IDENTITY_FUNCTION;
    }

    public static Flux<Long> interval(Duration duration) {
        return interval(duration, Schedulers.parallel());
    }

    @SafeVarargs
    public static <T> Flux<T> just(T... tArr) {
        return fromArray(tArr);
    }

    public static /* synthetic */ qc.b l(Mono mono, Object obj) {
        return mono;
    }

    public static <O> Supplier<List<O>> listSupplier() {
        return LIST_SUPPLIER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(Function function, Object obj, SynchronousSink synchronousSink) {
        Object objApply = function.apply(obj);
        if (objApply != null) {
            synchronousSink.next(objApply);
        }
    }

    public static <T> Flux<T> merge(qc.b<? extends qc.b<? extends T>> bVar) {
        return merge(bVar, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergeComparing(qc.b<? extends I>... bVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), bVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparingDelayError(int i10, Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        return bVarArr.length == 0 ? empty() : bVarArr.length == 1 ? from(bVarArr[0]) : onAssembly(new FluxMergeComparing(i10, comparator, true, true, bVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeDelayError(int i10, qc.b<? extends I>... bVarArr) {
        return merge(i10, true, (qc.b[]) bVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <I extends Comparable<? super I>> Flux<I> mergeOrdered(qc.b<? extends I>... bVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), bVarArr);
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergePriority(qc.b<? extends I>... bVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), bVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriorityDelayError(int i10, Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        return bVarArr.length == 0 ? empty() : bVarArr.length == 1 ? from(bVarArr[0]) : onAssembly(new FluxMergeComparing(i10, comparator, true, false, bVarArr));
    }

    public static <T> Flux<T> mergeSequential(qc.b<? extends qc.b<? extends T>> bVar) {
        return mergeSequential((qc.b) bVar, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> mergeSequentialDelayError(qc.b<? extends qc.b<? extends T>> bVar, int i10, int i11) {
        return mergeSequential((qc.b) bVar, true, i10, i11);
    }

    public static <T> Flux<T> never() {
        return FluxNever.instance();
    }

    public static <T> Flux<T> onAssembly(Flux<T> flux) {
        Function<qc.b, qc.b> function = Hooks.onEachOperatorHook;
        if (function != null) {
            flux = (Flux) function.apply(flux);
        }
        return Hooks.GLOBAL_TRACE ? (Flux) Hooks.addAssemblyInfo(flux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : flux;
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer) {
        return push(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static Flux<Integer> range(int i10, int i11) {
        return i11 == 1 ? just(Integer.valueOf(i10)) : i11 == 0 ? empty() : onAssembly(new FluxRange(i10, i11));
    }

    public static <T> Flux<T> switchOnNext(qc.b<? extends qc.b<? extends T>> bVar) {
        return onAssembly(new FluxSwitchMapNoPrefetch(from(bVar), identityFunction()));
    }

    public static /* synthetic */ void t(Object obj) {
        throw Exceptions.failWithOverflow();
    }

    public static <A, B> BiFunction<A, B, Tuple2<A, B>> tuple2Function() {
        return TUPLE2_BIFUNCTION;
    }

    public static /* synthetic */ Object u(Object obj) {
        return obj;
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qc.b<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Flux<T> usingWhen(qc.b<D> bVar, Function<? super D, ? extends qc.b<? extends T>> function, final Function<? super D, ? extends qc.b<?>> function2) {
        return usingWhen(bVar, function, function2, new BiFunction() { // from class: reactor.core.publisher.Z
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Flux.W(function2, obj, (Throwable) obj2);
            }
        }, function2);
    }

    public static /* synthetic */ boolean v() {
        return true;
    }

    public static <I> Flux<I> wrap(qc.b<? extends I> bVar) throws Exception {
        boolean zShouldWrapPublisher = ContextPropagationSupport.shouldWrapPublisher(bVar);
        if (bVar instanceof Flux) {
            return !zShouldWrapPublisher ? (Flux) bVar : ContextPropagation.fluxRestoreThreadLocals((Flux) bVar, bVar instanceof Fuseable);
        }
        if (!(bVar instanceof Fuseable.ScalarCallable)) {
            boolean z10 = bVar instanceof Fuseable;
            Flux<I> fluxSourceMonoFuseable = bVar instanceof Mono ? z10 ? new FluxSourceMonoFuseable<>((Mono) bVar) : new FluxSourceMono<>((Mono) bVar) : z10 ? new FluxSourceFuseable<>(bVar) : new FluxSource<>(bVar);
            return zShouldWrapPublisher ? ContextPropagation.fluxRestoreThreadLocals(fluxSourceMonoFuseable, z10) : fluxSourceMonoFuseable;
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) bVar).call();
            return tCall != null ? new FluxJust(tCall) : FluxEmpty.instance();
        } catch (Exception e10) {
            return new FluxError(Exceptions.unwrap(e10));
        }
    }

    public static <T> Mono<T> wrapToMono(Callable<T> callable) throws Exception {
        if (!(callable instanceof Fuseable.ScalarCallable)) {
            return new MonoCallable(callable);
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) callable).call();
            return tCall == null ? MonoEmpty.instance() : new MonoJust(tCall);
        } catch (Exception e10) {
            return new MonoError(Exceptions.unwrap(e10));
        }
    }

    public static /* synthetic */ Map y() {
        return new HashMap();
    }

    public static /* synthetic */ qc.b z(Flux flux, Function function, BiPredicate biPredicate) {
        flux.getClass();
        return flux.bufferUntil(new FluxBufferPredicate.ChangedPredicate(function, biPredicate), true);
    }

    public static <T1, T2, O> Flux<O> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, BiFunction<? super T1, ? super T2, ? extends O> biFunction) {
        return onAssembly(new FluxZip(bVar, bVar2, biFunction, Queues.xs(), Queues.XS_BUFFER_SIZE));
    }

    public final Mono<Boolean> all(Predicate<? super T> predicate) {
        return Mono.onAssembly(new MonoAll(this, predicate));
    }

    public final Mono<Boolean> any(Predicate<? super T> predicate) {
        return Mono.onAssembly(new MonoAny(this, predicate));
    }

    public final <P> P as(Function<? super Flux<T>, P> function) {
        return function.apply(this);
    }

    @Nullable
    public final T blockFirst() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet();
    }

    @Nullable
    public final T blockLast() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet();
    }

    public final Flux<List<T>> buffer() {
        return buffer(Integer.MAX_VALUE);
    }

    public final Flux<List<T>> bufferTimeout(int i10, Duration duration) {
        return (Flux<List<T>>) bufferTimeout(i10, duration, listSupplier());
    }

    public final Flux<List<T>> bufferUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), FluxBufferPredicate.Mode.UNTIL));
    }

    public final Flux<List<T>> bufferUntilChanged() {
        return bufferUntilChanged(identityFunction());
    }

    public final <U, V> Flux<List<T>> bufferWhen(qc.b<U> bVar, Function<? super U, ? extends qc.b<V>> function) {
        return (Flux<List<T>>) bufferWhen(bVar, function, listSupplier());
    }

    public final Flux<List<T>> bufferWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), FluxBufferPredicate.Mode.WHILE));
    }

    public final Flux<T> cache() {
        return cache(Integer.MAX_VALUE);
    }

    public final Flux<T> cancelOn(Scheduler scheduler) {
        return onAssembly(new FluxCancelOn(this, scheduler));
    }

    public final <E> Flux<E> cast(Class<E> cls) {
        Objects.requireNonNull(cls, "clazz");
        return (Flux<E>) map(new C5401x(cls));
    }

    public final Flux<T> checkpoint() {
        return checkpoint(null, true);
    }

    public final <E> Mono<E> collect(Supplier<E> supplier, BiConsumer<E, ? super T> biConsumer) {
        return Mono.onAssembly(new MonoCollect(this, supplier, biConsumer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<List<T>> collectList() throws Exception {
        if (!(this instanceof Callable)) {
            return Mono.onAssembly(new MonoCollectList(this));
        }
        if (!(this instanceof Fuseable.ScalarCallable)) {
            final Callable callable = (Callable) this;
            return Mono.onAssembly(new MonoCallable(new Callable() { // from class: reactor.core.publisher.M
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Flux.K(callable);
                }
            }));
        }
        try {
            final T tCall = ((Fuseable.ScalarCallable) this).call();
            return Mono.onAssembly(new MonoCallable(new Callable() { // from class: reactor.core.publisher.L
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Flux.e0(tCall);
                }
            }));
        } catch (Exception e10) {
            return Mono.error(Exceptions.unwrap(e10));
        }
    }

    public final <K> Mono<Map<K, T>> collectMap(Function<? super T, ? extends K> function) {
        return (Mono<Map<K, T>>) collectMap(function, identityFunction());
    }

    public final <K> Mono<Map<K, Collection<T>>> collectMultimap(Function<? super T, ? extends K> function) {
        return (Mono<Map<K, Collection<T>>>) collectMultimap(function, identityFunction());
    }

    public final Mono<List<T>> collectSortedList() {
        return collectSortedList(null);
    }

    public final <V> Flux<V> concatMap(Function<? super T, ? extends qc.b<? extends V>> function) {
        return onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qc.b<? extends V>> function) {
        return concatMapDelayError(function, 0);
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return concatMapIterable(function, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> concatWith(qc.b<? extends T> bVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceLast(bVar) : concat(this, bVar);
    }

    @SafeVarargs
    public final Flux<T> concatWithValues(T... tArr) {
        return concatWith(fromArray(tArr));
    }

    public final Flux<T> contextCapture() {
        return !ContextPropagationSupport.isContextPropagationAvailable() ? this : ContextPropagationSupport.propagateContextToThreadLocals ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, ContextPropagation.contextCapture())) : onAssembly(new FluxContextWrite(this, ContextPropagation.contextCapture()));
    }

    public final Flux<T> contextWrite(final ContextView contextView) {
        return contextWrite(new Function() { // from class: reactor.core.publisher.B
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Context) obj).putAll(contextView);
            }
        });
    }

    public final Mono<Long> count() {
        return Mono.onAssembly(new MonoCount(this));
    }

    public final Flux<T> defaultIfEmpty(T t10) {
        return onAssembly(new FluxDefaultIfEmpty(this, t10));
    }

    public final Flux<T> delayElements(Duration duration) {
        return delayElements(duration, Schedulers.parallel());
    }

    public final Flux<T> delaySequence(Duration duration) {
        return delaySequence(duration, Schedulers.parallel());
    }

    public final Flux<T> delaySubscription(Duration duration) {
        return delaySubscription(duration, Schedulers.parallel());
    }

    public final Flux<T> delayUntil(final Function<? super T, ? extends qc.b<?>> function) {
        return (Flux<T>) concatMap(new Function() { // from class: reactor.core.publisher.A
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.just(obj).delayUntil(function);
            }
        });
    }

    public final <X> Flux<X> dematerialize() {
        return onAssembly(new FluxDematerialize(this));
    }

    public final Flux<T> distinct() {
        return distinct(identityFunction());
    }

    public final Flux<T> distinctUntilChanged() {
        return distinctUntilChanged(identityFunction());
    }

    public final Flux<T> doAfterTerminate(Runnable runnable) {
        Objects.requireNonNull(runnable, "afterTerminate");
        return doOnSignal(this, null, null, null, null, runnable, null, null);
    }

    public final Flux<T> doFinally(Consumer<SignalType> consumer) {
        Objects.requireNonNull(consumer, "onFinally");
        return onAssembly(new FluxDoFinally(this, consumer));
    }

    public final Flux<T> doFirst(Runnable runnable) {
        Objects.requireNonNull(runnable, "onFirst");
        return this instanceof Fuseable ? onAssembly(new FluxDoFirstFuseable(this, runnable)) : onAssembly(new FluxDoFirst(this, runnable));
    }

    public final Flux<T> doOnCancel(Runnable runnable) {
        Objects.requireNonNull(runnable, "onCancel");
        return doOnSignal(this, null, null, null, null, null, null, runnable);
    }

    public final Flux<T> doOnComplete(Runnable runnable) {
        Objects.requireNonNull(runnable, "onComplete");
        return doOnSignal(this, null, null, null, runnable, null, null, null);
    }

    public final <R> Flux<T> doOnDiscard(Class<R> cls, Consumer<? super R> consumer) {
        return contextWriteSkippingContextPropagation(Operators.discardLocalAdapter(cls, consumer));
    }

    public final Flux<T> doOnEach(Consumer<? super Signal<T>> consumer) {
        return this instanceof Fuseable ? onAssembly(new FluxDoOnEachFuseable(this, consumer)) : onAssembly(new FluxDoOnEach(this, consumer));
    }

    public final Flux<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError");
        return doOnSignal(this, null, null, consumer, null, null, null, null);
    }

    public final Flux<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext");
        return doOnSignal(this, null, consumer, null, null, null, null, null);
    }

    public final Flux<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "consumer");
        return doOnSignal(this, null, null, null, null, null, longConsumer, null);
    }

    public final Flux<T> doOnSubscribe(Consumer<? super qc.d> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, consumer, null, null, null, null, null, null);
    }

    public final Flux<T> doOnTerminate(final Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        return doOnSignal(this, null, null, new Consumer() { // from class: reactor.core.publisher.C
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                runnable.run();
            }
        }, runnable, null, null, null);
    }

    public final Flux<Tuple2<Long, T>> elapsed() {
        return elapsed(Schedulers.parallel());
    }

    public final Mono<T> elementAt(int i10) {
        return Mono.onAssembly(new MonoElementAt(this, i10));
    }

    public final Flux<T> expand(Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
        return onAssembly(new FluxExpand(this, function, true, i10));
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
        return onAssembly(new FluxExpand(this, function, false, i10));
    }

    public final Flux<T> filter(Predicate<? super T> predicate) {
        return this instanceof Fuseable ? onAssembly(new FluxFilterFuseable(this, predicate)) : onAssembly(new FluxFilter(this, predicate));
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends qc.b<Boolean>> function) {
        return filterWhen(function, Queues.SMALL_BUFFER_SIZE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Flux<R> flatMap(Function<? super T, ? extends qc.b<? extends R>> function) {
        return (Flux<R>) flatMap(function, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public final <V> Flux<V> flatMapDelayError(Function<? super T, ? extends qc.b<? extends V>> function, int i10, int i11) {
        return flatMap(function, true, i10, i11);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return flatMapIterable(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qc.b<? extends R>> function) {
        return flatMapSequential(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapSequentialDelayError(Function<? super T, ? extends qc.b<? extends R>> function, int i10, int i11) {
        return flatMapSequential(function, true, i10, i11);
    }

    public int getPrefetch() {
        return -1;
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> groupJoin(qc.b<? extends TRight> bVar, Function<? super T, ? extends qc.b<TLeftEnd>> function, Function<? super TRight, ? extends qc.b<TRightEnd>> function2, BiFunction<? super T, ? super Flux<TRight>, ? extends R> biFunction) {
        int i10 = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxGroupJoin(this, bVar, function, function2, biFunction, Queues.unbounded(i10), Queues.unbounded(i10)));
    }

    public final <R> Flux<R> handle(BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        return this instanceof Fuseable ? onAssembly(new FluxHandleFuseable(this, biConsumer)) : onAssembly(new FluxHandle(this, biConsumer));
    }

    public final Mono<Boolean> hasElement(final T t10) {
        Objects.requireNonNull(t10, UxipConstants.f30680s);
        return any(new Predicate() { // from class: reactor.core.publisher.a0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.equals(t10, obj);
            }
        });
    }

    public final Mono<Boolean> hasElements() {
        return Mono.onAssembly(new MonoHasElements(this));
    }

    public Flux<T> hide() {
        return new FluxHide(this);
    }

    public final Mono<T> ignoreElements() {
        return Mono.onAssembly(new MonoIgnoreElements(this));
    }

    public final Flux<Tuple2<Long, T>> index() {
        return (Flux<Tuple2<Long, T>>) index(tuple2Function());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> join(qc.b<? extends TRight> bVar, Function<? super T, ? extends qc.b<TLeftEnd>> function, Function<? super TRight, ? extends qc.b<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        return onAssembly(new FluxJoin(this, bVar, function, function2, biFunction));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last() throws Exception {
        if (!(this instanceof Callable)) {
            return Mono.onAssembly(new MonoTakeLastOne(this));
        }
        Mono monoWrapToMono = wrapToMono((Callable) this);
        return monoWrapToMono == Mono.empty() ? Mono.onAssembly(new MonoError(new NoSuchElementException("Flux#last() didn't observe any onNext signal from Callable flux"))) : Mono.onAssembly(monoWrapToMono);
    }

    public final Flux<T> limitRate(int i10) {
        return onAssembly(publishOn(Schedulers.immediate(), i10));
    }

    @Deprecated
    public final Flux<T> limitRequest(long j10) {
        return take(j10, true);
    }

    public final Flux<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public final <V> Flux<V> map(Function<? super T, ? extends V> function) {
        return this instanceof Fuseable ? onAssembly(new FluxMapFuseable(this, function)) : onAssembly(new FluxMap(this, function));
    }

    public final <V> Flux<V> mapNotNull(final Function<? super T, ? extends V> function) {
        return (Flux<V>) handle(new BiConsumer() { // from class: reactor.core.publisher.g0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Flux.m(function, obj, (SynchronousSink) obj2);
            }
        });
    }

    public final Flux<Signal<T>> materialize() {
        return onAssembly(new FluxMaterialize(this));
    }

    public final Flux<T> mergeComparingWith(qc.b<? extends T> bVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(bVar, comparator) : mergeComparing(comparator, this, bVar);
    }

    @Deprecated
    public final Flux<T> mergeOrderedWith(qc.b<? extends T> bVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(bVar, comparator) : mergeOrdered(comparator, this, bVar);
    }

    public final Flux<T> mergeWith(qc.b<? extends T> bVar) {
        return this instanceof FluxMerge ? ((FluxMerge) this).mergeAdditionalSource(bVar, new IntFunction() { // from class: reactor.core.publisher.G
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return Queues.get(i10);
            }
        }) : merge(this, bVar);
    }

    @Deprecated
    public final Flux<T> metrics() {
        return !Metrics.isInstrumentationAvailable() ? this : this instanceof Fuseable ? onAssembly(new FluxMetricsFuseable(this)) : onAssembly(new FluxMetrics(this));
    }

    public final Flux<T> name(String str) {
        return FluxName.createOrAppend(this, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> next() {
        return this instanceof Callable ? Mono.onAssembly(wrapToMono((Callable) this)) : Mono.onAssembly(new MonoNext(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U> Flux<U> ofType(final Class<U> cls) {
        Objects.requireNonNull(cls, "clazz");
        return (Flux<U>) filter(new Predicate() { // from class: reactor.core.publisher.s
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isAssignableFrom(obj.getClass());
            }
        }).cast(cls);
    }

    public final Flux<T> onBackpressureBuffer() {
        return onAssembly(new FluxOnBackpressureBuffer(this, Queues.SMALL_BUFFER_SIZE, true, null));
    }

    public final Flux<T> onBackpressureDrop() {
        return onAssembly(new FluxOnBackpressureDrop(this));
    }

    public final Flux<T> onBackpressureError() {
        return onBackpressureDrop(new Consumer() { // from class: reactor.core.publisher.H
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Flux.t(obj);
            }
        });
    }

    public final Flux<T> onBackpressureLatest() {
        return onAssembly(new FluxOnBackpressureLatest(this));
    }

    public final Flux<T> onErrorComplete() {
        return onAssembly(new FluxOnErrorReturn(this, null, null));
    }

    public final Flux<T> onErrorContinue(BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resume(biConsumer)));
    }

    public final Flux<T> onErrorMap(final Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(new Function() { // from class: reactor.core.publisher.P
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error((Throwable) function.apply((Throwable) obj));
            }
        });
    }

    public final Flux<T> onErrorResume(Function<? super Throwable, ? extends qc.b<? extends T>> function) {
        return onAssembly(new FluxOnErrorResume(this, function));
    }

    public final Flux<T> onErrorReturn(T t10) {
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, null, t10));
    }

    public final Flux<T> onErrorStop() {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.stop()));
    }

    public final Flux<T> onTerminateDetach() {
        return new FluxDetach(this);
    }

    public final Flux<T> or(qc.b<? extends T> bVar) {
        FluxFirstWithSignal<T> fluxFirstWithSignalOrAdditionalSource;
        return (!(this instanceof FluxFirstWithSignal) || (fluxFirstWithSignalOrAdditionalSource = ((FluxFirstWithSignal) this).orAdditionalSource(bVar)) == null) ? firstWithSignal(this, bVar) : fluxFirstWithSignalOrAdditionalSource;
    }

    public final ParallelFlux<T> parallel() {
        return parallel(Schedulers.DEFAULT_POOL_SIZE);
    }

    public final ConnectableFlux<T> publish() {
        return publish(Queues.SMALL_BUFFER_SIZE);
    }

    @Deprecated
    public final Mono<T> publishNext() {
        return shareNext();
    }

    public final Flux<T> publishOn(Scheduler scheduler) {
        return publishOn(scheduler, Queues.SMALL_BUFFER_SIZE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> reduce(BiFunction<T, T, T> biFunction) {
        return this instanceof Callable ? Mono.onAssembly(wrapToMono((Callable) this)) : Mono.onAssembly(new MonoReduce(this, biFunction));
    }

    public final <A> Mono<A> reduceWith(Supplier<A> supplier, BiFunction<A, ? super T, A> biFunction) {
        return Mono.onAssembly(new MonoReduceSeed(this, supplier, biFunction));
    }

    public final Flux<T> repeat() {
        return repeat(ALWAYS_BOOLEAN_SUPPLIER);
    }

    public final Flux<T> repeatWhen(Function<Flux<Long>, ? extends qc.b<?>> function) {
        return onAssembly(new FluxRepeatWhen(this, function));
    }

    public final ConnectableFlux<T> replay() {
        return replay(Integer.MAX_VALUE);
    }

    public final Flux<T> retry() {
        return retry(Long.MAX_VALUE);
    }

    public final Flux<T> retryWhen(Retry retry) {
        return onAssembly(new FluxRetryWhen(this, retry));
    }

    public final Flux<T> sample(Duration duration) {
        return sample(interval(duration));
    }

    public final Flux<T> sampleFirst(final Duration duration) {
        return sampleFirst(new Function() { // from class: reactor.core.publisher.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.delay(duration);
            }
        });
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends qc.b<U>> function) {
        return sampleTimeout(function, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> scan(BiFunction<T, T, T> biFunction) {
        return onAssembly(new FluxScan(this, biFunction));
    }

    public final <A> Flux<A> scanWith(Supplier<A> supplier, BiFunction<A, ? super T, A> biFunction) {
        return onAssembly(new FluxScanSeed(this, supplier, biFunction));
    }

    public final Flux<T> share() {
        return onAssembly(new FluxRefCount(new FluxPublish(this, Queues.SMALL_BUFFER_SIZE, Queues.small(), true), 1));
    }

    public final Mono<T> shareNext() {
        return Mono.onAssembly(new NextProcessor(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> single() throws Exception {
        if (!(this instanceof Callable)) {
            return Mono.onAssembly(new MonoSingle(this));
        }
        if (!(this instanceof Fuseable.ScalarCallable)) {
            return Mono.onAssembly(new MonoSingleCallable((Callable) this));
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) this).call();
            return tCall == null ? Mono.error(new NoSuchElementException("Source was a (constant) empty")) : Mono.just(tCall);
        } catch (Exception e10) {
            return Mono.error(Exceptions.unwrap(e10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> singleOrEmpty() {
        return this instanceof Callable ? Mono.onAssembly(wrapToMono((Callable) this)) : Mono.onAssembly(new MonoSingle(this, null, true));
    }

    public final Flux<T> skip(long j10) {
        return j10 == 0 ? this : onAssembly(new FluxSkip(this, j10));
    }

    public final Flux<T> skipLast(int i10) {
        return i10 == 0 ? this : onAssembly(new FluxSkipLast(this, i10));
    }

    public final Flux<T> skipUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxSkipUntil(this, predicate));
    }

    public final Flux<T> skipUntilOther(qc.b<?> bVar) {
        return onAssembly(new FluxSkipUntilOther(this, bVar));
    }

    public final Flux<T> skipWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxSkipWhile(this, predicate));
    }

    public final Flux<T> sort() {
        return (Flux<T>) collectSortedList().flatMapIterable(identityFunction());
    }

    public final Flux<T> startWith(Iterable<? extends T> iterable) {
        return startWith(fromIterable(iterable));
    }

    public final Disposable subscribe() {
        return subscribe(null, null, null);
    }

    @Override // reactor.core.CorePublisher
    public abstract void subscribe(CoreSubscriber<? super T> coreSubscriber);

    public final Flux<T> subscribeOn(Scheduler scheduler) {
        return subscribeOn(scheduler, true);
    }

    public final <E extends qc.c<? super T>> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final Flux<T> switchIfEmpty(qc.b<? extends T> bVar) {
        return onAssembly(new FluxSwitchIfEmpty(this, bVar));
    }

    public final <V> Flux<V> switchMap(Function<? super T, qc.b<? extends V>> function) {
        return onAssembly(new FluxSwitchMapNoPrefetch(this, function));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends V>> biFunction) {
        return switchOnFirst(biFunction, true);
    }

    public final Flux<T> tag(String str, String str2) {
        return FluxName.createOrAppend(this, str, str2);
    }

    public final Flux<T> take(long j10) {
        return take(j10, true);
    }

    public final Flux<T> takeLast(int i10) {
        return i10 == 1 ? onAssembly(new FluxTakeLastOne(this)) : onAssembly(new FluxTakeLast(this, i10));
    }

    public final Flux<T> takeUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeUntil(this, predicate));
    }

    public final Flux<T> takeUntilOther(qc.b<?> bVar) {
        return onAssembly(new FluxTakeUntilOther(this, bVar));
    }

    public final Flux<T> takeWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeWhile(this, predicate));
    }

    public final Flux<T> tap(final Supplier<SignalListener<T>> supplier) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.2
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(qc.b<? extends T> bVar, ContextView contextView, Void r32) {
                return (SignalListener) supplier.get();
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(qc.b<? extends T> bVar) {
                return null;
            }
        });
    }

    public final Mono<Void> then() {
        return Mono.onAssembly(new MonoIgnoreElements(this));
    }

    public final Mono<Void> thenEmpty(qc.b<Void> bVar) {
        return then(Mono.fromDirect(bVar));
    }

    public final <V> Flux<V> thenMany(qc.b<V> bVar) {
        return concat(ignoreElements(), bVar);
    }

    public final Flux<Timed<T>> timed() {
        return timed(Schedulers.parallel());
    }

    public final Flux<T> timeout(Duration duration) {
        return timeout(duration, (qc.b) null, Schedulers.parallel());
    }

    public final Flux<Tuple2<Long, T>> timestamp() {
        return timestamp(Schedulers.parallel());
    }

    public final Iterable<T> toIterable() {
        return toIterable(Queues.SMALL_BUFFER_SIZE);
    }

    public final Stream<T> toStream() {
        return toStream(Queues.SMALL_BUFFER_SIZE);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final <V> Flux<V> transform(Function<? super Flux<T>, ? extends qc.b<V>> function) {
        if (Hooks.DETECT_CONTEXT_LOSS) {
            function = new ContextTrackingFunctionWrapper(function);
        }
        return onAssembly(from(function.apply(this)));
    }

    public final <V> Flux<V> transformDeferred(final Function<? super Flux<T>, ? extends qc.b<V>> function) {
        return defer(new Supplier() { // from class: reactor.core.publisher.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.c0(this.f39784a, function);
            }
        });
    }

    public final <V> Flux<V> transformDeferredContextual(final BiFunction<? super Flux<T>, ? super ContextView, ? extends qc.b<V>> biFunction) {
        return deferContextual(new Function() { // from class: reactor.core.publisher.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.P(this.f39797a, biFunction, (ContextView) obj);
            }
        });
    }

    public final Flux<Flux<T>> window(int i10) {
        return onAssembly(new FluxWindow(this, i10, Queues.get(i10)));
    }

    public final Flux<Flux<T>> windowTimeout(int i10, Duration duration) {
        return windowTimeout(i10, duration, Schedulers.parallel());
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate) {
        return windowUntil(predicate, false);
    }

    public final Flux<Flux<T>> windowUntilChanged() {
        return windowUntilChanged(identityFunction());
    }

    public final <U, V> Flux<Flux<T>> windowWhen(qc.b<U> bVar, Function<? super U, ? extends qc.b<V>> function) {
        return onAssembly(new FluxWindowWhen(this, bVar, function, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate) {
        return windowWhile(predicate, Queues.SMALL_BUFFER_SIZE);
    }

    public final <U, R> Flux<R> withLatestFrom(qc.b<? extends U> bVar, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return onAssembly(new FluxWithLatestFrom(this, bVar, biFunction));
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(qc.b<? extends T2> bVar) {
        return (Flux<Tuple2<T, T2>>) zipWith(bVar, tuple2Function());
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWithIterable(Iterable<? extends T2> iterable) {
        return (Flux<Tuple2<T, T2>>) zipWithIterable(iterable, tuple2Function());
    }

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(final Function<Object[], V> function, int i10, qc.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length != 1) {
            return onAssembly(new FluxCombineLatest(bVarArr, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i10), i10));
        }
        qc.b<? extends T> bVar = bVarArr[0];
        return bVar instanceof Fuseable ? onAssembly(new FluxMapFuseable(from(bVar), new Function() { // from class: reactor.core.publisher.U
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return function.apply(new Object[]{obj});
            }
        })) : onAssembly(new FluxMap(from(bVar), new Function() { // from class: reactor.core.publisher.V
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return function.apply(new Object[]{obj});
            }
        }));
    }

    public static <T> Flux<T> concat(qc.b<? extends qc.b<? extends T>> bVar) {
        return concat(bVar, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> concatDelayError(qc.b<? extends qc.b<? extends T>> bVar, int i10) {
        return from(bVar).concatMapDelayError(identityFunction(), i10);
    }

    private final Flux<T> contextWriteSkippingContextPropagation(Function<Context, Context> function) {
        return onAssembly(new FluxContextWrite(this, function));
    }

    public static <T> Flux<T> create(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy) {
        return onAssembly(new FluxCreate(consumer, overflowStrategy, FluxCreate.CreateMode.PUSH_PULL));
    }

    public static <T> Flux<T> error(Supplier<? extends Throwable> supplier) {
        return onAssembly(new FluxErrorSupplied(supplier));
    }

    @Deprecated
    public static <I> Flux<I> first(Iterable<? extends qc.b<? extends I>> iterable) {
        return firstWithSignal(iterable);
    }

    public static <I> Flux<I> firstWithSignal(Iterable<? extends qc.b<? extends I>> iterable) {
        return onAssembly(new FluxFirstWithSignal(iterable));
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithValue(qc.b<? extends I> bVar, qc.b<? extends I>... bVarArr) {
        FluxFirstWithValue<T> fluxFirstWithValueFirstValuedAdditionalSources;
        return (!(bVar instanceof FluxFirstWithValue) || (fluxFirstWithValueFirstValuedAdditionalSources = ((FluxFirstWithValue) bVar).firstValuedAdditionalSources(bVarArr)) == null) ? onAssembly(new FluxFirstWithValue(bVar, bVarArr)) : fluxFirstWithValueFirstValuedAdditionalSources;
    }

    public static Flux<Long> interval(Duration duration, Duration duration2) {
        return interval(duration, duration2, Schedulers.parallel());
    }

    public static <T> Flux<T> just(T t10) {
        return onAssembly(new FluxJust(t10));
    }

    public static <T> Flux<T> merge(qc.b<? extends qc.b<? extends T>> bVar, int i10) {
        return merge(bVar, i10, Queues.XS_BUFFER_SIZE);
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, comparator, bVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, comparator, bVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, comparator, bVarArr);
    }

    public static <T> Flux<T> mergeSequential(qc.b<? extends qc.b<? extends T>> bVar, int i10, int i11) {
        return mergeSequential((qc.b) bVar, false, i10, i11);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequentialDelayError(int i10, qc.b<? extends I>... bVarArr) {
        return mergeSequential(i10, true, (qc.b[]) bVarArr);
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy) {
        return onAssembly(new FluxCreate(consumer, overflowStrategy, FluxCreate.CreateMode.PUSH_ONLY));
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qc.b<? extends T>> function, Consumer<? super D> consumer, boolean z10) {
        return onAssembly(new FluxUsing(callable, function, consumer, z10));
    }

    public static <T, D> Flux<T> usingWhen(qc.b<D> bVar, Function<? super D, ? extends qc.b<? extends T>> function, Function<? super D, ? extends qc.b<?>> function2, BiFunction<? super D, ? super Throwable, ? extends qc.b<?>> biFunction, Function<? super D, ? extends qc.b<?>> function3) {
        return onAssembly(new FluxUsingWhen(bVar, function, function2, biFunction, function3));
    }

    public final Flux<List<T>> buffer(int i10) {
        return (Flux<List<T>>) buffer(i10, listSupplier());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i10, Duration duration, Supplier<C> supplier) {
        return bufferTimeout(i10, duration, Schedulers.parallel(), supplier);
    }

    public final <V> Flux<List<T>> bufferUntilChanged(Function<? super T, ? extends V> function) {
        return bufferUntilChanged(function, equalPredicate());
    }

    public final <U, V, C extends Collection<? super T>> Flux<C> bufferWhen(qc.b<U> bVar, Function<? super U, ? extends qc.b<V>> function, Supplier<C> supplier) {
        return onAssembly(new FluxBufferWhen(this, bVar, function, supplier, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<T> cache(int i10) {
        return replay(i10).autoConnect();
    }

    public final Flux<T> checkpoint(String str) {
        Objects.requireNonNull(str);
        return checkpoint(str, false);
    }

    public final <R, A> Mono<R> collect(Collector<? super T, A, ? extends R> collector) {
        return Mono.onAssembly(new MonoStreamCollector(this, collector));
    }

    public final <K, V> Mono<Map<K, V>> collectMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMap(function, function2, new Supplier() { // from class: reactor.core.publisher.m0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.y();
            }
        });
    }

    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMultimap(function, function2, new Supplier() { // from class: reactor.core.publisher.p0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.O();
            }
        });
    }

    public final Mono<List<T>> collectSortedList(@Nullable final Comparator<? super T> comparator) {
        return collectList().doOnNext(new Consumer() { // from class: reactor.core.publisher.D
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((List) obj).sort(comparator);
            }
        });
    }

    public final <V> Flux<V> concatMap(Function<? super T, ? extends qc.b<? extends V>> function, int i10) {
        return i10 == 0 ? onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE)) : onAssembly(new FluxConcatMap(this, function, Queues.get(i10), i10, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qc.b<? extends V>> function, int i10) {
        return concatMapDelayError(function, true, i10);
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i10) {
        return onAssembly(new FluxFlattenIterable(this, function, i10, Queues.get(i10)));
    }

    public final Flux<T> contextWrite(Function<Context, Context> function) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, function)) : onAssembly(new FluxContextWrite(this, function));
    }

    public final Flux<T> delayElements(final Duration duration, final Scheduler scheduler) {
        return delayUntil(new Function() { // from class: reactor.core.publisher.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.delay(duration, scheduler);
            }
        });
    }

    public final Flux<T> delaySequence(Duration duration, Scheduler scheduler) {
        return onAssembly(new FluxDelaySequence(this, duration, scheduler));
    }

    public final Flux<T> delaySubscription(Duration duration, Scheduler scheduler) {
        return delaySubscription(Mono.delay(duration, scheduler));
    }

    public final <V> Flux<T> distinct(Function<? super T, ? extends V> function) {
        return distinct(function, hashSetSupplier());
    }

    public final <V> Flux<T> distinctUntilChanged(Function<? super T, ? extends V> function) {
        return distinctUntilChanged(function, equalPredicate());
    }

    public final Flux<Tuple2<Long, T>> elapsed(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return onAssembly(new FluxElapsed(this, scheduler));
    }

    public final Mono<T> elementAt(int i10, T t10) {
        return Mono.onAssembly(new MonoElementAt(this, i10, t10));
    }

    public final Flux<T> expand(Function<? super T, ? extends qc.b<? extends T>> function) {
        return expand(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qc.b<? extends T>> function) {
        return expandDeep(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends qc.b<Boolean>> function, int i10) {
        return onAssembly(new FluxFilterWhen(this, function, i10));
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qc.b<? extends V>> function, int i10) {
        return flatMap(function, i10, Queues.XS_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i10) {
        return onAssembly(new FluxFlattenIterable(this, function, i10, Queues.get(i10)));
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qc.b<? extends R>> function, int i10) {
        return flatMapSequential(function, i10, Queues.XS_BUFFER_SIZE);
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function, int i10) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction(), i10);
    }

    public final <I> Flux<I> index(BiFunction<? super Long, ? super T, ? extends I> biFunction) {
        return this instanceof Fuseable ? onAssembly(new FluxIndexFuseable(this, biFunction)) : onAssembly(new FluxIndex(this, biFunction));
    }

    public final Flux<T> limitRate(int i10, int i11) {
        return onAssembly(publishOn(Schedulers.immediate(), true, i10, i11));
    }

    public final Flux<T> log(String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final Flux<T> onBackpressureBuffer(int i10) {
        return onAssembly(new FluxOnBackpressureBuffer(this, i10, false, null));
    }

    public final Flux<T> onBackpressureDrop(Consumer<? super T> consumer) {
        return onAssembly(new FluxOnBackpressureDrop(this, consumer));
    }

    public final Flux<T> onErrorComplete(Class<? extends Throwable> cls) {
        Objects.requireNonNull(cls, "type must not be null");
        return onErrorComplete(new C5365l(cls));
    }

    public final <E extends Throwable> Flux<T> onErrorMap(Class<E> cls, Function<? super E, ? extends Throwable> function) {
        cls.getClass();
        return onErrorMap(new C5365l(cls), function);
    }

    public final <E extends Throwable> Flux<T> onErrorResume(Class<E> cls, Function<? super E, ? extends qc.b<? extends T>> function) {
        Objects.requireNonNull(cls, "type");
        return onErrorResume(new C5365l(cls), function);
    }

    public final ParallelFlux<T> parallel(int i10) {
        return parallel(i10, Queues.SMALL_BUFFER_SIZE);
    }

    public final ConnectableFlux<T> publish(int i10) {
        return onAssembly((ConnectableFlux) new FluxPublish(this, i10, Queues.get(i10), true));
    }

    public final Flux<T> publishOn(Scheduler scheduler, int i10) {
        return publishOn(scheduler, true, i10);
    }

    public final Flux<T> repeat(BooleanSupplier booleanSupplier) {
        return onAssembly(new FluxRepeatPredicate(this, booleanSupplier));
    }

    public final ConnectableFlux<T> replay(int i10) {
        if (i10 != 0) {
            return onAssembly((ConnectableFlux) new FluxReplay(this, i10, 0L, null));
        }
        int i11 = Queues.SMALL_BUFFER_SIZE;
        return onAssembly((ConnectableFlux) new FluxPublish(this, i11, Queues.get(i11), false));
    }

    public final Flux<T> retry(long j10) {
        return onAssembly(new FluxRetry(this, j10));
    }

    public final <U> Flux<T> sample(qc.b<U> bVar) {
        return onAssembly(new FluxSample(this, bVar));
    }

    public final <U> Flux<T> sampleFirst(Function<? super T, ? extends qc.b<U>> function) {
        return onAssembly(new FluxSampleFirst(this, function));
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends qc.b<U>> function, int i10) {
        return onAssembly(new FluxSampleTimeout(this, function, Queues.get(i10)));
    }

    public final <A> Flux<A> scan(final A a10, BiFunction<A, ? super T, A> biFunction) {
        Objects.requireNonNull(a10, "seed");
        return scanWith(new Supplier() { // from class: reactor.core.publisher.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.u(a10);
            }
        }, biFunction);
    }

    public final Flux<T> skip(Duration duration) {
        return skip(duration, Schedulers.parallel());
    }

    public final Flux<T> sort(Comparator<? super T> comparator) {
        return (Flux<T>) collectSortedList(comparator).flatMapIterable(identityFunction());
    }

    @SafeVarargs
    public final Flux<T> startWith(T... tArr) {
        return startWith(just((Object[]) tArr));
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return subscribe(consumer, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flux<T> subscribeOn(Scheduler scheduler, boolean z10) {
        if (!(this instanceof Callable)) {
            return onAssembly(new FluxSubscribeOn(this, scheduler, z10));
        }
        if (this instanceof Fuseable.ScalarCallable) {
            try {
                return onAssembly(new FluxSubscribeOnValue(((Fuseable.ScalarCallable) this).call(), scheduler));
            } catch (Exception unused) {
            }
        }
        return onAssembly(new FluxSubscribeOnCallable((Callable) this, scheduler));
    }

    @Deprecated
    public final <V> Flux<V> switchMap(Function<? super T, qc.b<? extends V>> function, int i10) {
        return i10 == 0 ? onAssembly(new FluxSwitchMapNoPrefetch(this, function)) : onAssembly(new FluxSwitchMap(this, function, Queues.unbounded(i10), i10));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends V>> biFunction, boolean z10) {
        return onAssembly(new FluxSwitchOnFirst(this, biFunction, z10));
    }

    public final Flux<T> take(long j10, boolean z10) {
        return z10 ? onAssembly(new FluxLimitRequest(this, j10)) : this instanceof Fuseable ? onAssembly(new FluxTakeFuseable(this, j10)) : onAssembly(new FluxTake(this, j10));
    }

    public final Flux<T> tap(final Function<ContextView, SignalListener<T>> function) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.3
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(qc.b<? extends T> bVar, ContextView contextView, Void r32) {
                return (SignalListener) function.apply(contextView);
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(qc.b<? extends T> bVar) {
                return null;
            }
        });
    }

    public final Flux<Timed<T>> timed(Scheduler scheduler) {
        return onAssembly(new FluxTimed(this, scheduler));
    }

    public final Flux<T> timeout(Duration duration, @Nullable qc.b<? extends T> bVar) {
        return timeout(duration, bVar, Schedulers.parallel());
    }

    public final Flux<Tuple2<Long, T>> timestamp(final Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return (Flux<Tuple2<Long, T>>) map(new Function() { // from class: reactor.core.publisher.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.of(Long.valueOf(scheduler.now(TimeUnit.MILLISECONDS)), obj);
            }
        });
    }

    public final Iterable<T> toIterable(int i10) {
        return toIterable(i10, null);
    }

    public final Stream<T> toStream(int i10) {
        return new BlockingIterable(this, i10, Queues.get(i10), ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new E() : new F()).stream();
    }

    public final Flux<Flux<T>> window(int i10, int i11) {
        int i12 = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxWindow(this, i10, i11, Queues.unbounded(i12), Queues.unbounded(i12)));
    }

    public final Flux<Flux<T>> windowTimeout(int i10, Duration duration, boolean z10) {
        return windowTimeout(i10, duration, Schedulers.parallel(), z10);
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10) {
        return windowUntil(predicate, z10, Queues.SMALL_BUFFER_SIZE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <V> Flux<Flux<T>> windowUntilChanged(Function<? super T, ? super V> function) {
        return windowUntilChanged(function, equalPredicate());
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate, int i10) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i10), Queues.unbounded(i10), i10, predicate, FluxBufferPredicate.Mode.WHILE));
    }

    public final <T2, V> Flux<V> zipWith(qc.b<? extends T2> bVar, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        FluxZip fluxZipZipAdditionalSource;
        return (!(this instanceof FluxZip) || (fluxZipZipAdditionalSource = ((FluxZip) this).zipAdditionalSource(bVar, biFunction)) == null) ? zip(this, bVar, biFunction) : fluxZipZipAdditionalSource;
    }

    public final <T2, V> Flux<V> zipWithIterable(Iterable<? extends T2> iterable, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        return onAssembly(new FluxZipIterable(this, iterable, biFunction));
    }

    public static <T> Flux<T> concat(qc.b<? extends qc.b<? extends T>> bVar, int i10) {
        return from(bVar).concatMap(identityFunction(), i10);
    }

    public static <T> Flux<T> concatDelayError(qc.b<? extends qc.b<? extends T>> bVar, boolean z10, int i10) {
        return from(bVar).concatMapDelayError(identityFunction(), z10, i10);
    }

    public static <O> Flux<O> error(Throwable th, boolean z10) {
        if (z10) {
            return onAssembly(new FluxErrorOnRequest(th));
        }
        return onAssembly(new FluxError(th));
    }

    public static <T> Flux<T> fromStream(Supplier<Stream<? extends T>> supplier) {
        return onAssembly(new FluxStream(supplier));
    }

    public static <T, S> Flux<T> generate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction) {
        return onAssembly(new FluxGenerate(callable, biFunction));
    }

    public static Flux<Long> interval(Duration duration, Scheduler scheduler) {
        return interval(duration, duration, scheduler);
    }

    public static <T> Flux<T> merge(qc.b<? extends qc.b<? extends T>> bVar, int i10, int i11) {
        return onAssembly(new FluxFlatMap(from(bVar), identityFunction(), false, i10, Queues.get(i10), i11, Queues.get(i11)));
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(int i10, Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return from(bVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i10, comparator, false, true, bVarArr));
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(int i10, Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return from(bVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i10, comparator, true, true, bVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(int i10, Comparator<? super T> comparator, qc.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return from(bVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i10, comparator, false, false, bVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(qc.b<? extends I>... bVarArr) {
        return mergeSequential(Queues.XS_BUFFER_SIZE, false, (qc.b[]) bVarArr);
    }

    public static <I> Flux<I> mergeSequentialDelayError(Iterable<? extends qc.b<? extends I>> iterable, int i10, int i11) {
        return mergeSequential((Iterable) iterable, true, i10, i11);
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qc.b<? extends T>> function) {
        return using((Callable) callable, (Function) function, true);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i10, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i10, supplier));
    }

    public final Flux<List<T>> bufferTimeout(int i10, Duration duration, Scheduler scheduler) {
        return (Flux<List<T>>) bufferTimeout(i10, duration, scheduler, listSupplier());
    }

    public final <V> Flux<List<T>> bufferUntilChanged(final Function<? super T, ? extends V> function, final BiPredicate<? super V, ? super V> biPredicate) {
        return defer(new Supplier() { // from class: reactor.core.publisher.z
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.z(this.f39823a, function, biPredicate);
            }
        });
    }

    public final Flux<T> cache(Duration duration) {
        return cache(duration, Schedulers.parallel());
    }

    public final Flux<T> checkpoint(@Nullable String str, boolean z10) {
        FluxOnAssembly.AssemblySnapshot checkpointHeavySnapshot;
        if (!z10) {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointLightSnapshot(str);
        } else {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointHeavySnapshot(str, Traces.callSiteSupplierFactory.get());
        }
        return new FluxOnAssembly(this, checkpointHeavySnapshot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Mono<Map<K, V>> collectMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2, Supplier<Map<K, V>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        return (Mono<Map<K, V>>) collect(supplier, new BiConsumer() { // from class: reactor.core.publisher.X
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Map) obj).put(function.apply(obj2), function2.apply(obj2));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2, Supplier<Map<K, Collection<V>>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        return (Mono<Map<K, Collection<V>>>) collect(supplier, new BiConsumer() { // from class: reactor.core.publisher.b0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collection) ((Map) obj).computeIfAbsent(function.apply(obj2), new Function() { // from class: reactor.core.publisher.h0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return Flux.T(obj3);
                    }
                })).add(function2.apply(obj2));
            }
        });
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qc.b<? extends V>> function, boolean z10, int i10) {
        FluxConcatMap.ErrorMode errorMode = z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.BOUNDARY;
        if (i10 == 0) {
            return onAssembly(new FluxConcatMapNoPrefetch(this, function, errorMode));
        }
        return onAssembly(new FluxConcatMap(this, function, Queues.get(i10), i10, errorMode));
    }

    public final <U> Flux<T> delaySubscription(qc.b<U> bVar) {
        return onAssembly(new FluxDelaySubscription(this, bVar));
    }

    public final <V, C extends Collection<? super V>> Flux<T> distinct(Function<? super T, ? extends V> function, Supplier<C> supplier) {
        return distinct(function, supplier, new BiPredicate() { // from class: reactor.core.publisher.Q
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return ((Collection) obj).add(obj2);
            }
        }, new Consumer() { // from class: reactor.core.publisher.T
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Collection) obj).clear();
            }
        });
    }

    public final <V> Flux<T> distinctUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        return onAssembly(new FluxDistinctUntilChanged(this, function, biPredicate));
    }

    public final <E extends Throwable> Flux<T> doOnError(Class<E> cls, Consumer<? super E> consumer) {
        Objects.requireNonNull(cls, "type");
        return doOnError(new C5365l(cls), consumer);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qc.b<? extends V>> function, int i10, int i11) {
        return flatMap(function, false, i10, i11);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qc.b<? extends R>> function, int i10, int i11) {
        return flatMapSequential(function, false, i10, i11);
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final Flux<T> onBackpressureBuffer(int i10, Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onOverflow");
        return onAssembly(new FluxOnBackpressureBuffer(this, i10, false, consumer));
    }

    public final Flux<T> onErrorMap(Predicate<? super Throwable> predicate, final Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(predicate, new Function() { // from class: reactor.core.publisher.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error((Throwable) function.apply((Throwable) obj));
            }
        });
    }

    public final <E extends Throwable> Flux<T> onErrorReturn(Class<E> cls, T t10) {
        Objects.requireNonNull(cls, "type must not be null");
        return onErrorReturn((Predicate<? super Throwable>) new C5365l(cls), (C5365l) t10);
    }

    public final ParallelFlux<T> parallel(int i10, int i11) {
        return ParallelFlux.from(this, i10, i11, Queues.get(i11));
    }

    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i10) {
        return publishOn(scheduler, z10, i10, i10);
    }

    public final Flux<T> repeat(long j10) {
        return j10 == 0 ? this : onAssembly(new FluxRepeat(this, j10));
    }

    public final Flux<T> skip(Duration duration, Scheduler scheduler) {
        return !duration.isZero() ? skipUntilOther(Mono.delay(duration, scheduler)) : this;
    }

    public final Flux<T> startWith(qc.b<? extends T> bVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceFirst(bVar) : concat(bVar, this);
    }

    public final Flux<T> tap(SignalListenerFactory<T, ?> signalListenerFactory) {
        if (ContextPropagationSupport.shouldPropagateContextToThreadLocals()) {
            return onAssembly(new FluxTapRestoringThreadLocals(this, signalListenerFactory));
        }
        if (this instanceof Fuseable) {
            return onAssembly(new FluxTapFuseable(this, signalListenerFactory));
        }
        return onAssembly(new FluxTap(this, signalListenerFactory));
    }

    public final <V> Mono<V> then(Mono<V> mono) {
        return Mono.onAssembly(new MonoIgnoreThen(new qc.b[]{this}, mono));
    }

    public final Flux<T> timeout(Duration duration, Scheduler scheduler) {
        return timeout(duration, (qc.b) null, scheduler);
    }

    public final Iterable<T> toIterable(int i10, @Nullable final Supplier<Queue<T>> supplier) {
        Supplier supplier2;
        if (supplier == null) {
            supplier2 = Queues.get(i10);
        } else {
            supplier2 = new Supplier() { // from class: reactor.core.publisher.f0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Hooks.wrapQueue((Queue) supplier.get());
                }
            };
        }
        return new BlockingIterable(this, i10, supplier2, ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new E() : new F());
    }

    public final Flux<Flux<T>> windowTimeout(int i10, Duration duration, Scheduler scheduler) {
        return windowTimeout(i10, duration, scheduler, false);
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10, int i10) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i10), Queues.unbounded(i10), i10, predicate, z10 ? FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE : FluxBufferPredicate.Mode.UNTIL));
    }

    public final <V> Flux<Flux<T>> windowUntilChanged(final Function<? super T, ? extends V> function, final BiPredicate<? super V, ? super V> biPredicate) {
        return defer(new Supplier() { // from class: reactor.core.publisher.i0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.g0(this.f39759a, function, biPredicate);
            }
        });
    }

    @SafeVarargs
    public static <T> Flux<T> concat(qc.b<? extends T>... bVarArr) {
        return onAssembly(new FluxConcatArray(false, bVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> concatDelayError(qc.b<? extends T>... bVarArr) {
        return onAssembly(new FluxConcatArray(true, bVarArr));
    }

    public static <T, S> Flux<T> generate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction, Consumer<? super S> consumer) {
        return onAssembly(new FluxGenerate(callable, biFunction, consumer));
    }

    public static Flux<Long> interval(Duration duration, Duration duration2, Scheduler scheduler) {
        return onAssembly(new FluxInterval(duration.toNanos(), duration2.toNanos(), TimeUnit.NANOSECONDS, scheduler));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i10, qc.b<? extends I>... bVarArr) {
        return mergeSequential(i10, false, (qc.b[]) bVarArr);
    }

    @Deprecated
    public static <T> Flux<T> switchOnNext(qc.b<? extends qc.b<? extends T>> bVar, int i10) {
        if (i10 == 0) {
            return onAssembly(new FluxSwitchMapNoPrefetch(from(bVar), identityFunction()));
        }
        return onAssembly(new FluxSwitchMap(from(bVar), identityFunction(), Queues.unbounded(i10), i10));
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qc.b<? extends T>> function, boolean z10) {
        return using(callable, function, Exceptions.AUTO_CLOSE, z10);
    }

    public static <T1, T2> Flux<Tuple2<T1, T2>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2) {
        return zip(bVar, bVar2, tuple2Function());
    }

    public final Flux<List<T>> buffer(int i10, int i11) {
        return (Flux<List<T>>) buffer(i10, i11, listSupplier());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i10, Duration duration, Scheduler scheduler, Supplier<C> supplier) {
        return onAssembly(new FluxBufferTimeout(this, i10, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, false));
    }

    public final Flux<List<T>> bufferUntil(Predicate<? super T> predicate, boolean z10) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), z10 ? FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE : FluxBufferPredicate.Mode.UNTIL));
    }

    public final Flux<T> cache(Duration duration, Scheduler scheduler) {
        return cache(Integer.MAX_VALUE, duration, scheduler);
    }

    public final <V, C> Flux<T> distinct(Function<? super T, ? extends V> function, Supplier<C> supplier, BiPredicate<C, V> biPredicate, Consumer<C> consumer) {
        if (this instanceof Fuseable) {
            return onAssembly(new FluxDistinctFuseable(this, function, supplier, biPredicate, consumer));
        }
        return onAssembly(new FluxDistinct(this, function, supplier, biPredicate, consumer));
    }

    public final <R> Flux<R> flatMap(@Nullable Function<? super T, ? extends qc.b<? extends R>> function, @Nullable Function<? super Throwable, ? extends qc.b<? extends R>> function2, @Nullable Supplier<? extends qc.b<? extends R>> supplier) {
        FluxMapSignal fluxMapSignal = new FluxMapSignal(this, function, function2, supplier);
        Function functionIdentityFunction = identityFunction();
        int i10 = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxFlatMap(fluxMapSignal, functionIdentityFunction, false, i10, Queues.xs(), i10, Queues.xs()));
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qc.b<? extends R>> function, boolean z10, int i10, int i11) {
        return onAssembly(new FluxMergeSequential(this, function, i10, i11, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i10) {
        return onAssembly(new FluxGroupBy(this, function, function2, Queues.unbounded(i10), Queues.unbounded(i10), i10));
    }

    public final Flux<T> log(@Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, str, level, z10, signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new FluxLogFuseable(this, signalLogger));
        }
        return onAssembly(new FluxLog(this, signalLogger));
    }

    public final Flux<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        return onAssembly(new FluxOnErrorReturn(this, predicate, null));
    }

    public final <E extends Throwable> Flux<T> onErrorContinue(Class<E> cls, BiConsumer<Throwable, Object> biConsumer) {
        cls.getClass();
        return onErrorContinue(new C5365l(cls), biConsumer);
    }

    public final Flux<T> onErrorResume(final Predicate<? super Throwable> predicate, final Function<? super Throwable, ? extends qc.b<? extends T>> function) {
        Objects.requireNonNull(predicate, "predicate");
        return onErrorResume(new Function() { // from class: reactor.core.publisher.K
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.I(predicate, function, (Throwable) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i10, int i11) {
        if (this instanceof Callable) {
            if (this instanceof Fuseable.ScalarCallable) {
                try {
                    return onAssembly(new FluxSubscribeOnValue(((Fuseable.ScalarCallable) this).call(), scheduler));
                } catch (Exception unused) {
                }
            }
            return onAssembly(new FluxSubscribeOnCallable((Callable) this, scheduler));
        }
        return onAssembly(new FluxPublishOn(this, scheduler, z10, i10, i11, Queues.get(i10)));
    }

    public final Flux<T> repeat(final long j10, final BooleanSupplier booleanSupplier) {
        if (j10 >= 0) {
            return j10 == 0 ? this : defer(new Supplier() { // from class: reactor.core.publisher.y
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Flux.V(this.f39817a, booleanSupplier, j10);
                }
            });
        }
        throw new IllegalArgumentException("numRepeat >= 0 required");
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer2, "errorConsumer");
        return subscribe(consumer, consumer2, null);
    }

    public final Flux<T> timeout(Duration duration, @Nullable qc.b<? extends T> bVar, Scheduler scheduler) {
        final Mono<Long> monoOnErrorReturn = Mono.delay(duration, scheduler).onErrorReturn(0L);
        Function<? super T, ? extends qc.b<V>> function = new Function() { // from class: reactor.core.publisher.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.l(monoOnErrorReturn, obj);
            }
        };
        if (bVar == null) {
            return timeout(monoOnErrorReturn, function, duration.toMillis() + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
        return timeout(monoOnErrorReturn, function, bVar);
    }

    public final Flux<Flux<T>> windowTimeout(int i10, Duration duration, Scheduler scheduler, boolean z10) {
        return onAssembly(new FluxWindowTimeout(this, i10, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, z10));
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qc.b<? extends I>> iterable) {
        return mergeSequential((Iterable) iterable, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <T1, T2, T3> Flux<Tuple3<T1, T2, T3>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3) {
        return zip(Tuples.fn3(), bVar, bVar2, bVar3);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i10, int i11, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i10, i11, supplier));
    }

    public final Flux<List<T>> bufferTimeout(int i10, Duration duration, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i10, duration, Schedulers.parallel(), listSupplier(), z10);
    }

    public final Flux<T> cache(int i10, Duration duration) {
        return cache(i10, duration, Schedulers.parallel());
    }

    public final Flux<T> doOnError(final Predicate<? super Throwable> predicate, final Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(predicate, "predicate");
        return doOnError(new Consumer() { // from class: reactor.core.publisher.Y
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Flux.Z(predicate, consumer, (Throwable) obj);
            }
        });
    }

    public final Flux<T> onBackpressureBuffer(int i10, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i10, null, bufferOverflowStrategy));
    }

    public final <E extends Throwable> Flux<T> onErrorContinue(Predicate<E> predicate, BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resumeIf(predicate, biConsumer)));
    }

    public final Flux<T> onErrorReturn(Predicate<? super Throwable> predicate, T t10) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, predicate, t10));
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends qc.b<? extends R>> function) {
        return publish(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <A> Mono<A> reduce(final A a10, BiFunction<A, ? super T, A> biFunction) {
        return reduceWith(new Supplier() { // from class: reactor.core.publisher.e0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Flux.X(a10);
            }
        }, biFunction);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qc.b<? extends I>> iterable, int i10, int i11) {
        return mergeSequential((Iterable) iterable, false, i10, i11);
    }

    public static <T> ConnectableFlux<T> onAssembly(ConnectableFlux<T> connectableFlux) {
        Function<qc.b, qc.b> function = Hooks.onEachOperatorHook;
        if (function != null) {
            connectableFlux = (ConnectableFlux) function.apply(connectableFlux);
        }
        return Hooks.GLOBAL_TRACE ? (ConnectableFlux) Hooks.addAssemblyInfo(connectableFlux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : connectableFlux;
    }

    public static <T1, T2, T3, T4> Flux<Tuple4<T1, T2, T3, T4>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4) {
        return zip(Tuples.fn4(), bVar, bVar2, bVar3, bVar4);
    }

    @Nullable
    public final T blockFirst(Duration duration) {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Nullable
    public final T blockLast(Duration duration) {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final Flux<List<T>> buffer(qc.b<?> bVar) {
        return (Flux<List<T>>) buffer(bVar, listSupplier());
    }

    public final Flux<T> cache(int i10, Duration duration, Scheduler scheduler) {
        return replay(i10, duration, scheduler).autoConnect();
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends qc.b<? extends R>> function, int i10) {
        return onAssembly(new FluxPublishMulticast(this, function, i10, Queues.get(i10)));
    }

    public final ConnectableFlux<T> replay(Duration duration) {
        return replay(Integer.MAX_VALUE, duration);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable) {
        return subscribe(consumer, consumer2, runnable, (Context) null);
    }

    public final Flux<T> take(Duration duration) {
        return take(duration, Schedulers.parallel());
    }

    public final Flux<Flux<T>> window(qc.b<?> bVar) {
        return onAssembly(new FluxWindowBoundary(this, bVar, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final <T2, V> Flux<V> zipWith(qc.b<? extends T2> bVar, int i10, final BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        return zip(new Function() { // from class: reactor.core.publisher.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object[] objArr = (Object[]) obj;
                return biFunction.apply(objArr[0], objArr[1]);
            }
        }, i10, this, bVar);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i10, boolean z10, qc.b<? extends I>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return from(bVarArr[0]);
        }
        return onAssembly(new FluxMergeSequential(new FluxArray(bVarArr), identityFunction(), bVarArr.length, i10, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T1, T2, T3, T4, T5> Flux<Tuple5<T1, T2, T3, T4, T5>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5) {
        return zip(Tuples.fn5(), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(qc.b<?> bVar, Supplier<C> supplier) {
        return onAssembly(new FluxBufferBoundary(this, bVar, supplier));
    }

    public final Flux<T> onBackpressureBuffer(int i10, Consumer<? super T> consumer, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(consumer, "onBufferOverflow");
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i10, consumer, bufferOverflowStrategy));
    }

    public final ConnectableFlux<T> replay(int i10, Duration duration) {
        return replay(i10, duration, Schedulers.parallel());
    }

    @Deprecated
    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3) {
        return (Disposable) subscribeWith(new LambdaSubscriber(consumer, consumer2, runnable, consumer3, null));
    }

    public final Flux<T> take(Duration duration, Scheduler scheduler) {
        if (!duration.isZero()) {
            return takeUntilOther(Mono.delay(duration, scheduler));
        }
        return take(0L, false);
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(qc.b<? extends T2> bVar, int i10) {
        return (Flux<Tuple2<T, T2>>) zipWith(bVar, i10, tuple2Function());
    }

    public static <T1, T2, T3, T4, T5, T6> Flux<Tuple6<T1, T2, T3, T4, T5, T6>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5, qc.b<? extends T6> bVar6) {
        return zip(Tuples.fn6(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    public final Flux<List<T>> buffer(Duration duration) {
        return buffer(duration, Schedulers.parallel());
    }

    public final Flux<List<T>> bufferTimeout(int i10, Duration duration, Scheduler scheduler, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i10, duration, scheduler, listSupplier(), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last(T t10) throws Exception {
        if (this instanceof Callable) {
            Callable callable = (Callable) this;
            if (callable instanceof Fuseable.ScalarCallable) {
                try {
                    T tCall = ((Fuseable.ScalarCallable) callable).call();
                    if (tCall == null) {
                        return Mono.just(t10);
                    }
                    return Mono.just(tCall);
                } catch (Exception e10) {
                    return Mono.error(Exceptions.unwrap(e10));
                }
            }
            Mono.onAssembly(new MonoCallable(callable));
        }
        return Mono.onAssembly(new MonoTakeLastOne(this, t10));
    }

    public final Flux<T> log(Logger logger) {
        return log(logger, Level.INFO, false, new SignalType[0]);
    }

    public final ConnectableFlux<T> replay(Duration duration, Scheduler scheduler) {
        return replay(Integer.MAX_VALUE, duration, scheduler);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Context context) {
        return (Disposable) subscribeWith(new LambdaSubscriber(consumer, consumer2, runnable, null, context));
    }

    public final <U> Flux<T> timeout(qc.b<U> bVar) {
        return timeout(bVar, new Function() { // from class: reactor.core.publisher.j0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.never();
            }
        });
    }

    public static <I> Flux<I> merge(Iterable<? extends qc.b<? extends I>> iterable) {
        return merge(fromIterable(iterable));
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Flux<Tuple7<T1, T2, T3, T4, T5, T6, T7>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5, qc.b<? extends T6> bVar6, qc.b<? extends T7> bVar7) {
        return zip(Tuples.fn7(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    public final Flux<List<T>> buffer(Duration duration, Duration duration2) {
        return buffer(duration, duration2, Schedulers.parallel());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i10, Duration duration, Supplier<C> supplier, boolean z10) {
        return bufferTimeout(i10, duration, Schedulers.parallel(), supplier, z10);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qc.b<? extends V>> function, boolean z10, int i10, int i11) {
        return onAssembly(new FluxFlatMap(this, function, z10, i10, Queues.get(i10), i11, Queues.get(i11)));
    }

    public final Flux<T> log(final Logger logger, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, "IGNORED", level, z10, new Function() { // from class: reactor.core.publisher.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.N(logger, (String) obj);
            }
        }, signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new FluxLogFuseable(this, signalLogger));
        }
        return onAssembly(new FluxLog(this, signalLogger));
    }

    public final ConnectableFlux<T> replay(int i10, Duration duration, Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "timer");
        if (i10 == 0) {
            int i11 = Queues.SMALL_BUFFER_SIZE;
            return onAssembly((ConnectableFlux) new FluxPublish(this, i11, Queues.get(i11), true));
        }
        return onAssembly((ConnectableFlux) new FluxReplay(this, i10, duration.toNanos(), scheduler));
    }

    @Override // reactor.core.CorePublisher, qc.b
    public final void subscribe(qc.c<? super T> cVar) {
        CorePublisher corePublisherOnLastAssembly = Operators.onLastAssembly(this);
        CoreSubscriber<? super T> coreSubscriber = Operators.toCoreSubscriber(cVar);
        if ((coreSubscriber instanceof Fuseable.QueueSubscription) && this != corePublisherOnLastAssembly && (this instanceof Fuseable) && !(corePublisherOnLastAssembly instanceof Fuseable)) {
            coreSubscriber = new FluxHide.SuppressFuseableSubscriber(coreSubscriber);
        }
        try {
            if (corePublisherOnLastAssembly instanceof OptimizableOperator) {
                OptimizableOperator optimizableOperator = (OptimizableOperator) corePublisherOnLastAssembly;
                while (true) {
                    coreSubscriber = optimizableOperator.subscribeOrReturn(coreSubscriber);
                    if (coreSubscriber == null) {
                        return;
                    }
                    OptimizableOperator optimizableOperatorNextOptimizableSource = optimizableOperator.nextOptimizableSource();
                    if (optimizableOperatorNextOptimizableSource == null) {
                        corePublisherOnLastAssembly = optimizableOperator.source();
                        break;
                    }
                    optimizableOperator = optimizableOperatorNextOptimizableSource;
                }
            }
            coreSubscriber = Operators.restoreContextOnSubscriberIfPublisherNonInternal(corePublisherOnLastAssembly, coreSubscriber);
            corePublisherOnLastAssembly.subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            Operators.reportThrowInSubscribe(coreSubscriber, th);
        }
    }

    public final <U, V> Flux<T> timeout(qc.b<U> bVar, Function<? super T, ? extends qc.b<V>> function) {
        return timeout(bVar, function, "first signal from a Publisher");
    }

    public final Flux<Flux<T>> window(Duration duration) {
        return window(duration, Schedulers.parallel());
    }

    @SafeVarargs
    public static <I> Flux<I> merge(qc.b<? extends I>... bVarArr) {
        return merge(Queues.XS_BUFFER_SIZE, bVarArr);
    }

    private <U, V> Flux<T> timeout(qc.b<U> bVar, Function<? super T, ? extends qc.b<V>> function, String str) {
        return onAssembly(new FluxTimeout(this, bVar, function, str));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Flux<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> zip(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5, qc.b<? extends T6> bVar6, qc.b<? extends T7> bVar7, qc.b<? extends T8> bVar8) {
        return zip(Tuples.fn8(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    public final Flux<List<T>> buffer(Duration duration, Scheduler scheduler) {
        return buffer(interval(duration, scheduler));
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i10, Duration duration, Scheduler scheduler, Supplier<C> supplier, boolean z10) {
        return onAssembly(new FluxBufferTimeout(this, i10, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, z10));
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i10, Consumer<? super T> consumer) {
        return onBackpressureBuffer(duration, i10, consumer, Schedulers.parallel());
    }

    public final Flux<Flux<T>> window(Duration duration, Duration duration2) {
        return window(duration, duration2, Schedulers.parallel());
    }

    @SafeVarargs
    public static <I> Flux<I> merge(int i10, qc.b<? extends I>... bVarArr) {
        return merge(i10, false, (qc.b[]) bVarArr);
    }

    public static <O> Flux<O> zip(Iterable<? extends qc.b<?>> iterable, Function<? super Object[], ? extends O> function) {
        return zip(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public final Flux<List<T>> buffer(final Duration duration, Duration duration2, final Scheduler scheduler) {
        if (duration.equals(duration2)) {
            return buffer(duration, scheduler);
        }
        return bufferWhen(interval(Duration.ZERO, duration2, scheduler), new Function() { // from class: reactor.core.publisher.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.delay(duration, scheduler);
            }
        });
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i10, Consumer<? super T> consumer, Scheduler scheduler) {
        Objects.requireNonNull(duration, "ttl");
        Objects.requireNonNull(consumer, "onBufferEviction");
        return onAssembly(new FluxOnBackpressureBufferTimeout(this, duration, scheduler, i10, consumer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> single(T t10) throws Exception {
        if (this instanceof Callable) {
            if (this instanceof Fuseable.ScalarCallable) {
                try {
                    T tCall = ((Fuseable.ScalarCallable) this).call();
                    if (tCall == null) {
                        return Mono.just(t10);
                    }
                    return Mono.just(tCall);
                } catch (Exception e10) {
                    return Mono.error(Exceptions.unwrap(e10));
                }
            }
            return Mono.onAssembly(new MonoSingleCallable((Callable) this, t10));
        }
        return Mono.onAssembly(new MonoSingle(this, t10, false));
    }

    public final <U, V> Flux<T> timeout(qc.b<U> bVar, Function<? super T, ? extends qc.b<V>> function, qc.b<? extends T> bVar2) {
        return onAssembly(new FluxTimeout(this, bVar, function, bVar2));
    }

    public final Flux<Flux<T>> window(Duration duration, Scheduler scheduler) {
        return window(interval(duration, scheduler));
    }

    public static <T1, T2, V> Flux<V> combineLatest(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, final BiFunction<? super T1, ? super T2, ? extends V> biFunction) {
        return combineLatest(new Function() { // from class: reactor.core.publisher.J
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object[] objArr = (Object[]) obj;
                return biFunction.apply(objArr[0], objArr[1]);
            }
        }, bVar, bVar2);
    }

    @SafeVarargs
    public static <I> Flux<I> merge(int i10, boolean z10, qc.b<? extends I>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return from(bVarArr[0]);
        }
        return onAssembly(new FluxMerge(bVarArr, z10, bVarArr.length, Queues.get(bVarArr.length), i10, Queues.get(i10)));
    }

    public static <O> Flux<O> zip(Iterable<? extends qc.b<?>> iterable, int i10, Function<? super Object[], ? extends O> function) {
        return onAssembly(new FluxZip(iterable, function, Queues.get(i10), i10));
    }

    public final Flux<Flux<T>> window(final Duration duration, Duration duration2, final Scheduler scheduler) {
        if (duration2.equals(duration)) {
            return window(duration);
        }
        return windowWhen(interval(Duration.ZERO, duration2, scheduler), new Function() { // from class: reactor.core.publisher.I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.delay(duration, scheduler);
            }
        });
    }

    public static <T1, T2, T3, V> Flux<V> combineLatest(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, Function<Object[], V> function) {
        return combineLatest(function, bVar, bVar2, bVar3);
    }

    public static <T1, T2, T3, T4, V> Flux<V> combineLatest(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, Function<Object[], V> function) {
        return combineLatest(function, bVar, bVar2, bVar3, bVar4);
    }

    public static <T> Flux<T> mergeSequential(qc.b<? extends qc.b<? extends T>> bVar, boolean z10, int i10, int i11) {
        return onAssembly(new FluxMergeSequential(from(bVar), identityFunction(), i10, i11, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T1, T2, T3, T4, T5, V> Flux<V> combineLatest(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5, Function<Object[], V> function) {
        return combineLatest(function, bVar, bVar2, bVar3, bVar4, bVar5);
    }

    @SafeVarargs
    public static <I, O> Flux<O> zip(Function<? super Object[], ? extends O> function, qc.b<? extends I>... bVarArr) {
        return zip(function, Queues.XS_BUFFER_SIZE, bVarArr);
    }

    public static <T1, T2, T3, T4, T5, T6, V> Flux<V> combineLatest(qc.b<? extends T1> bVar, qc.b<? extends T2> bVar2, qc.b<? extends T3> bVar3, qc.b<? extends T4> bVar4, qc.b<? extends T5> bVar5, qc.b<? extends T6> bVar6, Function<Object[], V> function) {
        return combineLatest(function, bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    @SafeVarargs
    public static <I, O> Flux<O> zip(final Function<? super Object[], ? extends O> function, int i10, qc.b<? extends I>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            qc.b<? extends I> bVar = bVarArr[0];
            if (bVar instanceof Fuseable) {
                return onAssembly(new FluxMapFuseable(from(bVar), new Function() { // from class: reactor.core.publisher.N
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return function.apply(new Object[]{obj});
                    }
                }));
            }
            return onAssembly(new FluxMap(from(bVar), new Function() { // from class: reactor.core.publisher.O
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return function.apply(new Object[]{obj});
                }
            }));
        }
        return onAssembly(new FluxZip(bVarArr, function, Queues.get(i10), i10));
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends qc.b<? extends T>> iterable, Function<Object[], V> function) {
        return combineLatest(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qc.b<? extends I>> iterable, boolean z10, int i10, int i11) {
        return onAssembly(new FluxMergeSequential(new FluxIterable(iterable), identityFunction(), i10, i11, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends qc.b<? extends T>> iterable, int i10, Function<Object[], V> function) {
        return onAssembly(new FluxCombineLatest(iterable, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i10), i10));
    }

    public static <TUPLE extends Tuple2, V> Flux<V> zip(qc.b<? extends qc.b<?>> bVar, final Function<? super TUPLE, ? extends V> function) {
        return onAssembly(new FluxBuffer(from(bVar), Integer.MAX_VALUE, listSupplier()).flatMap(new Function<List<? extends qc.b<?>>, qc.b<V>>() { // from class: reactor.core.publisher.Flux.1
            @Override // java.util.function.Function
            public qc.b<V> apply(List<? extends qc.b<?>> list) {
                return Flux.zip(Tuples.fnAny(function), (qc.b[]) list.toArray(new qc.b[list.size()]));
            }
        }));
    }
}
