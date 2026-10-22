package reactor.core.publisher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
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

/* loaded from: classes4.dex */
public abstract class Flux<T> implements CorePublisher<T> {
    static final BiFunction TUPLE2_BIFUNCTION = new C1892h(0);
    static final Supplier LIST_SUPPLIER = new C1886b(2);
    static final Supplier SET_SUPPLIER = new C1886b(3);
    static final BooleanSupplier ALWAYS_BOOLEAN_SUPPLIER = new C1893i();
    static final BiPredicate OBJECT_EQUAL = new C1894j(0);
    static final Function IDENTITY_FUNCTION = Function.identity();

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(Function<Object[], V> function, Z9.c... cVarArr) {
        return combineLatest(function, Queues.XS_BUFFER_SIZE, cVarArr);
    }

    public static <T> Flux<T> concat(Iterable<? extends Z9.c> iterable) {
        return onAssembly(new FluxConcatIterable(iterable));
    }

    public static <T> Flux<T> concatDelayError(Z9.c cVar) {
        return concatDelayError(cVar, Queues.XS_BUFFER_SIZE);
    }

    private final Flux<T> contextWriteSkippingContextPropagation(ContextView contextView) {
        return contextWriteSkippingContextPropagation(new C1897m(contextView, 0));
    }

    public static BooleanSupplier countingBooleanSupplier(final BooleanSupplier booleanSupplier, final long j5) {
        return j5 <= 0 ? booleanSupplier : new BooleanSupplier() { // from class: reactor.core.publisher.Flux.4
            long n;

            @Override // java.util.function.BooleanSupplier
            public boolean getAsBoolean() {
                long j6 = this.n;
                this.n = 1 + j6;
                return j6 < j5 && booleanSupplier.getAsBoolean();
            }
        };
    }

    public static <O> Predicate<O> countingPredicate(final Predicate<O> predicate, final long j5) {
        return j5 == 0 ? predicate : new Predicate<O>() { // from class: reactor.core.publisher.Flux.5
            long n;

            @Override // java.util.function.Predicate
            public boolean test(O o) {
                long j6 = this.n;
                this.n = 1 + j6;
                return j6 < j5 && predicate.test(o);
            }
        };
    }

    public static <T> Flux<T> create(Consumer<? super FluxSink<T>> consumer) {
        return create(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static <T> Flux<T> defer(Supplier<? extends Z9.c> supplier) {
        return onAssembly(new FluxDefer(supplier));
    }

    public static <T> Flux<T> deferContextual(Function<ContextView, ? extends Z9.c> function) {
        return onAssembly(new FluxDeferContextual(function));
    }

    public static <T> Flux<T> doOnSignal(Flux<T> flux, @Nullable Consumer<? super Z9.e> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        return flux instanceof Fuseable ? onAssembly(new FluxPeekFuseable(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3)) : onAssembly(new FluxPeek(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3));
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
    public static <I> Flux<I> first(Z9.c... cVarArr) {
        return firstWithSignal(cVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithSignal(Z9.c... cVarArr) {
        return onAssembly(new FluxFirstWithSignal(cVarArr));
    }

    public static <I> Flux<I> firstWithValue(Iterable<? extends Z9.c> iterable) {
        return onAssembly(new FluxFirstWithValue(iterable));
    }

    public static <T> Flux<T> from(Z9.c cVar) {
        return (!(cVar instanceof Flux) || ContextPropagationSupport.shouldWrapPublisher(cVar)) ? onAssembly(wrap(cVar)) : (Flux) cVar;
    }

    public static <T> Flux<T> fromArray(T[] tArr) {
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : onAssembly(new FluxArray(tArr));
    }

    public static <T> Flux<T> fromIterable(Iterable<? extends T> iterable) {
        return onAssembly(new FluxIterable(iterable));
    }

    public static <T> Flux<T> fromStream(Stream<? extends T> stream) {
        Objects.requireNonNull(stream, "Stream s must be provided");
        return onAssembly(new FluxStream(new C1907x(stream, 0)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$buffer$7(Duration duration, Scheduler scheduler, Long l) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$bufferUntilChanged$8(Function function, BiPredicate biPredicate) {
        return bufferUntil(new FluxBufferPredicate.ChangedPredicate(function, biPredicate), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectList$10(Callable callable) throws Exception {
        List list = (List) listSupplier().get();
        Object objCall = callable.call();
        if (objCall != null) {
            list.add(objCall);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectList$9(Object obj) throws Exception {
        List list = (List) listSupplier().get();
        if (obj != null) {
            list.add(obj);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$collectMap$11() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$collectMap$12(Function function, Function function2, Map map, Object obj) {
        map.put(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$collectMultimap$13() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$collectMultimap$15(Function function, Function function2, Map map, Object obj) {
        ((Collection) map.computeIfAbsent(function.apply(obj), new C1885a(13))).add(function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$combineLatest$0(Function function, Object obj) {
        return function.apply(new Object[]{obj});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$combineLatest$1(Function function, Object obj) {
        return function.apply(new Object[]{obj});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object lambda$combineLatest$2(BiFunction biFunction, Object[] objArr) {
        return biFunction.apply(objArr[0], objArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$contextWrite$17(ContextView contextView, Context context) {
        return context.putAll(contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$contextWriteSkippingContextPropagation$18(ContextView contextView, Context context) {
        return context.putAll(contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$delayElements$19(Duration duration, Scheduler scheduler, Object obj) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$delayUntil$20(Function function, Object obj) {
        return Mono.just(obj).delayUntil(function);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doOnError$21(Predicate predicate, Consumer consumer, Throwable th) {
        if (predicate.test(th)) {
            consumer.accept(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doOnTerminate$22(Runnable runnable, Throwable th) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$fromStream$3(Stream stream) {
        return stream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Logger lambda$log$24(Logger logger, String str) {
        return logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$mapNotNull$25(Function function, Object obj, SynchronousSink synchronousSink) {
        Object objApply = function.apply(obj);
        if (objApply != null) {
            synchronousSink.next(objApply);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$null$14(Object obj) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$null$40(BiFunction biFunction, ContextView contextView, Z9.c cVar) {
        return (Z9.c) biFunction.apply(wrap(cVar), contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$ofType$26(Class cls, Object obj) {
        return cls.isAssignableFrom(obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onBackpressureError$27(Object obj) {
        throw Exceptions.failWithOverflow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$onErrorMap$28(Function function, Throwable th) {
        return Mono.error((Throwable) function.apply(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$onErrorMap$29(Function function, Throwable th) {
        return Mono.error((Throwable) function.apply(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$onErrorResume$30(Predicate predicate, Function function, Throwable th) {
        return predicate.test(th) ? (Z9.c) function.apply(th) : error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$reduce$31(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$repeat$32(BooleanSupplier booleanSupplier, long j5) {
        return repeat(countingBooleanSupplier(booleanSupplier, j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$sampleFirst$33(Duration duration, Object obj) {
        return Mono.delay(duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$scan$34(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$45() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$timeout$35(Mono mono, Object obj) {
        return mono;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$timeout$36(Object obj) {
        return never();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Tuple2 lambda$timestamp$37(Scheduler scheduler, Object obj) {
        return Tuples.of(Long.valueOf(scheduler.now(TimeUnit.MILLISECONDS)), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Queue lambda$toIterable$38(Supplier supplier) {
        return Hooks.wrapQueue((Queue) supplier.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$transformDeferred$39(Function function) {
        return Hooks.DETECT_CONTEXT_LOSS ? new ContextTrackingFunctionWrapper(function).apply((Z9.c) this) : (Z9.c) function.apply(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$transformDeferredContextual$41(BiFunction biFunction, ContextView contextView) {
        return Hooks.DETECT_CONTEXT_LOSS ? new ContextTrackingFunctionWrapper(new C1906w(biFunction, contextView, 0), biFunction.toString()).apply((Z9.c) this) : (Z9.c) biFunction.apply(this, contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$usingWhen$4(Function function, Object obj, Throwable th) {
        return (Z9.c) function.apply(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$window$42(Duration duration, Scheduler scheduler, Long l) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$windowUntilChanged$43(Function function, BiPredicate biPredicate) {
        return windowUntil(new FluxBufferPredicate.ChangedPredicate(function, biPredicate), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$zip$5(Function function, Object obj) {
        return function.apply(new Object[]{obj});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$zip$6(Function function, Object obj) {
        return function.apply(new Object[]{obj});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object lambda$zipWith$44(BiFunction biFunction, Object[] objArr) {
        return biFunction.apply(objArr[0], objArr[1]);
    }

    public static <O> Supplier<List<O>> listSupplier() {
        return LIST_SUPPLIER;
    }

    public static <T> Flux<T> merge(Z9.c cVar) {
        return merge(cVar, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergeComparing(Z9.c... cVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparingDelayError(int i, Comparator<? super T> comparator, Z9.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, true, true, cVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeDelayError(int i, Z9.c... cVarArr) {
        return merge(i, true, cVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <I extends Comparable<? super I>> Flux<I> mergeOrdered(Z9.c... cVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergePriority(Z9.c... cVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriorityDelayError(int i, Comparator<? super T> comparator, Z9.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, true, false, cVarArr));
    }

    public static <T> Flux<T> mergeSequential(Z9.c cVar) {
        return mergeSequential(cVar, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> mergeSequentialDelayError(Z9.c cVar, int i, int i6) {
        return mergeSequential(cVar, true, i, i6);
    }

    public static <T> Flux<T> never() {
        return FluxNever.instance();
    }

    public static <T> Flux<T> onAssembly(Flux<T> flux) {
        Function<Z9.c, Z9.c> function = Hooks.onEachOperatorHook;
        if (function != null) {
            flux = (Flux) function.apply(flux);
        }
        return Hooks.GLOBAL_TRACE ? (Flux) Hooks.addAssemblyInfo(flux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : flux;
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer) {
        return push(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static Flux<Integer> range(int i, int i6) {
        return i6 == 1 ? just(Integer.valueOf(i)) : i6 == 0 ? empty() : onAssembly(new FluxRange(i, i6));
    }

    public static <T> Flux<T> switchOnNext(Z9.c cVar) {
        return onAssembly(new FluxSwitchMapNoPrefetch(from(cVar), identityFunction()));
    }

    public static <A, B> BiFunction<A, B, Tuple2<A, B>> tuple2Function() {
        return TUPLE2_BIFUNCTION;
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends Z9.c> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Flux<T> usingWhen(Z9.c cVar, Function<? super D, ? extends Z9.c> function, Function<? super D, ? extends Z9.c> function2) {
        return usingWhen(cVar, function, function2, new A(0, function2), function2);
    }

    public static <I> Flux<I> wrap(Z9.c cVar) throws Exception {
        boolean zShouldWrapPublisher = ContextPropagationSupport.shouldWrapPublisher(cVar);
        if (cVar instanceof Flux) {
            return !zShouldWrapPublisher ? (Flux) cVar : ContextPropagation.fluxRestoreThreadLocals((Flux) cVar, cVar instanceof Fuseable);
        }
        if (!(cVar instanceof Fuseable.ScalarCallable)) {
            boolean z10 = cVar instanceof Fuseable;
            Flux<I> fluxSourceMonoFuseable = cVar instanceof Mono ? z10 ? new FluxSourceMonoFuseable<>((Mono) cVar) : new FluxSourceMono<>((Mono) cVar) : z10 ? new FluxSourceFuseable<>(cVar) : new FluxSource<>(cVar);
            return zShouldWrapPublisher ? ContextPropagation.fluxRestoreThreadLocals(fluxSourceMonoFuseable, z10) : fluxSourceMonoFuseable;
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) cVar).call();
            return tCall != null ? new FluxJust(tCall) : FluxEmpty.instance();
        } catch (Exception e) {
            return new FluxError(Exceptions.unwrap(e));
        }
    }

    public static <T> Mono<T> wrapToMono(Callable<T> callable) throws Exception {
        if (!(callable instanceof Fuseable.ScalarCallable)) {
            return new MonoCallable(callable);
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) callable).call();
            return tCall == null ? MonoEmpty.instance() : new MonoJust(tCall);
        } catch (Exception e) {
            return new MonoError(Exceptions.unwrap(e));
        }
    }

    public static <T1, T2, O> Flux<O> zip(Z9.c cVar, Z9.c cVar2, BiFunction<? super T1, ? super T2, ? extends O> biFunction) {
        return onAssembly(new FluxZip(cVar, cVar2, biFunction, Queues.xs(), Queues.XS_BUFFER_SIZE));
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
        subscribe((Z9.d) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet();
    }

    @Nullable
    public final T blockLast() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((Z9.d) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet();
    }

    public final Flux<List<T>> buffer() {
        return buffer(Integer.MAX_VALUE);
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration) {
        return (Flux<List<T>>) bufferTimeout(i, duration, listSupplier());
    }

    public final Flux<List<T>> bufferUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), FluxBufferPredicate.Mode.UNTIL));
    }

    public final Flux<List<T>> bufferUntilChanged() {
        return bufferUntilChanged(identityFunction());
    }

    public final <U, V> Flux<List<T>> bufferWhen(Z9.c cVar, Function<? super U, ? extends Z9.c> function) {
        return (Flux<List<T>>) bufferWhen(cVar, function, listSupplier());
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
        return (Flux<E>) map(new c0(cls));
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
            final int i = 1;
            return Mono.onAssembly(new MonoCallable(new Callable() { // from class: reactor.core.publisher.v
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    int i6 = i;
                    Object obj = callable;
                    switch (i6) {
                        case 0:
                            return Flux.lambda$collectList$9(obj);
                        default:
                            return Flux.lambda$collectList$10((Callable) obj);
                    }
                }
            }));
        }
        try {
            final T tCall = ((Fuseable.ScalarCallable) this).call();
            final int i6 = 0;
            return Mono.onAssembly(new MonoCallable(new Callable() { // from class: reactor.core.publisher.v
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    int i62 = i6;
                    Object obj = tCall;
                    switch (i62) {
                        case 0:
                            return Flux.lambda$collectList$9(obj);
                        default:
                            return Flux.lambda$collectList$10((Callable) obj);
                    }
                }
            }));
        } catch (Exception e) {
            return Mono.error(Exceptions.unwrap(e));
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

    public final <V> Flux<V> concatMap(Function<? super T, ? extends Z9.c> function) {
        return onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends Z9.c> function) {
        return concatMapDelayError(function, 0);
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return concatMapIterable(function, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> concatWith(Z9.c cVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceLast(cVar) : concat(this, cVar);
    }

    @SafeVarargs
    public final Flux<T> concatWithValues(T... tArr) {
        return concatWith(fromArray(tArr));
    }

    public final Flux<T> contextCapture() {
        return !ContextPropagationSupport.isContextPropagationAvailable() ? this : ContextPropagationSupport.propagateContextToThreadLocals ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, ContextPropagation.contextCapture())) : onAssembly(new FluxContextWrite(this, ContextPropagation.contextCapture()));
    }

    public final Flux<T> contextWrite(ContextView contextView) {
        return contextWrite(new C1897m(contextView, 1));
    }

    public final Mono<Long> count() {
        return Mono.onAssembly(new MonoCount(this));
    }

    public final Flux<T> defaultIfEmpty(T t9) {
        return onAssembly(new FluxDefaultIfEmpty(this, t9));
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

    public final Flux<T> delayUntil(Function<? super T, ? extends Z9.c> function) {
        return (Flux<T>) concatMap(new r(0, function));
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

    public final Flux<T> doOnSubscribe(Consumer<? super Z9.e> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, consumer, null, null, null, null, null, null);
    }

    public final Flux<T> doOnTerminate(Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        return doOnSignal(this, null, null, new C1902s(runnable, 0), runnable, null, null, null);
    }

    public final Flux<Tuple2<Long, T>> elapsed() {
        return elapsed(Schedulers.parallel());
    }

    public final Mono<T> elementAt(int i) {
        return Mono.onAssembly(new MonoElementAt(this, i));
    }

    public final Flux<T> expand(Function<? super T, ? extends Z9.c> function, int i) {
        return onAssembly(new FluxExpand(this, function, true, i));
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends Z9.c> function, int i) {
        return onAssembly(new FluxExpand(this, function, false, i));
    }

    public final Flux<T> filter(Predicate<? super T> predicate) {
        return this instanceof Fuseable ? onAssembly(new FluxFilterFuseable(this, predicate)) : onAssembly(new FluxFilter(this, predicate));
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends Z9.c> function) {
        return filterWhen(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMap(Function<? super T, ? extends Z9.c> function) {
        return (Flux<R>) flatMap(function, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public final <V> Flux<V> flatMapDelayError(Function<? super T, ? extends Z9.c> function, int i, int i6) {
        return flatMap(function, true, i, i6);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return flatMapIterable(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends Z9.c> function) {
        return flatMapSequential(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapSequentialDelayError(Function<? super T, ? extends Z9.c> function, int i, int i6) {
        return flatMapSequential(function, true, i, i6);
    }

    public int getPrefetch() {
        return -1;
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> groupJoin(Z9.c cVar, Function<? super T, ? extends Z9.c> function, Function<? super TRight, ? extends Z9.c> function2, BiFunction<? super T, ? super Flux<TRight>, ? extends R> biFunction) {
        int i = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxGroupJoin(this, cVar, function, function2, biFunction, Queues.unbounded(i), Queues.unbounded(i)));
    }

    public final <R> Flux<R> handle(BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        return this instanceof Fuseable ? onAssembly(new FluxHandleFuseable(this, biConsumer)) : onAssembly(new FluxHandle(this, biConsumer));
    }

    public final Mono<Boolean> hasElement(T t9) {
        Objects.requireNonNull(t9, "value");
        return any(new e0(t9, 1));
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

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> join(Z9.c cVar, Function<? super T, ? extends Z9.c> function, Function<? super TRight, ? extends Z9.c> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        return onAssembly(new FluxJoin(this, cVar, function, function2, biFunction));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last() throws Exception {
        if (!(this instanceof Callable)) {
            return Mono.onAssembly(new MonoTakeLastOne(this));
        }
        Mono monoWrapToMono = wrapToMono((Callable) this);
        return monoWrapToMono == Mono.empty() ? Mono.onAssembly(new MonoError(new NoSuchElementException("Flux#last() didn't observe any onNext signal from Callable flux"))) : Mono.onAssembly(monoWrapToMono);
    }

    public final Flux<T> limitRate(int i) {
        return onAssembly(publishOn(Schedulers.immediate(), i));
    }

    @Deprecated
    public final Flux<T> limitRequest(long j5) {
        return take(j5, true);
    }

    public final Flux<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public final <V> Flux<V> map(Function<? super T, ? extends V> function) {
        return this instanceof Fuseable ? onAssembly(new FluxMapFuseable(this, function)) : onAssembly(new FluxMap(this, function));
    }

    public final <V> Flux<V> mapNotNull(Function<? super T, ? extends V> function) {
        return (Flux<V>) handle(new D(function, 0));
    }

    public final Flux<Signal<T>> materialize() {
        return onAssembly(new FluxMaterialize(this));
    }

    public final Flux<T> mergeComparingWith(Z9.c cVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(cVar, comparator) : mergeComparing(comparator, this, cVar);
    }

    @Deprecated
    public final Flux<T> mergeOrderedWith(Z9.c cVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(cVar, comparator) : mergeOrdered(comparator, this, cVar);
    }

    public final Flux<T> mergeWith(Z9.c cVar) {
        return this instanceof FluxMerge ? ((FluxMerge) this).mergeAdditionalSource(cVar, new C1903t(0)) : merge(this, cVar);
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
    public final <U> Flux<U> ofType(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz");
        return (Flux<U>) filter(new b0(cls, 2)).cast(cls);
    }

    public final Flux<T> onBackpressureBuffer() {
        return onAssembly(new FluxOnBackpressureBuffer(this, Queues.SMALL_BUFFER_SIZE, true, null));
    }

    public final Flux<T> onBackpressureDrop() {
        return onAssembly(new FluxOnBackpressureDrop(this));
    }

    public final Flux<T> onBackpressureError() {
        return onBackpressureDrop(new N(3));
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

    public final Flux<T> onErrorMap(Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(new r(3, function));
    }

    public final Flux<T> onErrorResume(Function<? super Throwable, ? extends Z9.c> function) {
        return onAssembly(new FluxOnErrorResume(this, function));
    }

    public final Flux<T> onErrorReturn(T t9) {
        Objects.requireNonNull(t9, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, null, t9));
    }

    public final Flux<T> onErrorStop() {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.stop()));
    }

    public final Flux<T> onTerminateDetach() {
        return new FluxDetach(this);
    }

    public final Flux<T> or(Z9.c cVar) {
        FluxFirstWithSignal<T> fluxFirstWithSignalOrAdditionalSource;
        return (!(this instanceof FluxFirstWithSignal) || (fluxFirstWithSignalOrAdditionalSource = ((FluxFirstWithSignal) this).orAdditionalSource(cVar)) == null) ? firstWithSignal(this, cVar) : fluxFirstWithSignalOrAdditionalSource;
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

    public final Flux<T> repeatWhen(Function<Flux<Long>, ? extends Z9.c> function) {
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

    public final Flux<T> sampleFirst(Duration duration) {
        return sampleFirst(new a0(1, duration));
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends Z9.c> function) {
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
        } catch (Exception e) {
            return Mono.error(Exceptions.unwrap(e));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> singleOrEmpty() {
        return this instanceof Callable ? Mono.onAssembly(wrapToMono((Callable) this)) : Mono.onAssembly(new MonoSingle(this, null, true));
    }

    public final Flux<T> skip(long j5) {
        return j5 == 0 ? this : onAssembly(new FluxSkip(this, j5));
    }

    public final Flux<T> skipLast(int i) {
        return i == 0 ? this : onAssembly(new FluxSkipLast(this, i));
    }

    public final Flux<T> skipUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxSkipUntil(this, predicate));
    }

    public final Flux<T> skipUntilOther(Z9.c cVar) {
        return onAssembly(new FluxSkipUntilOther(this, cVar));
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

    public final <E extends Z9.d> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Flux<T> switchIfEmpty(Z9.c cVar) {
        return onAssembly(new FluxSwitchIfEmpty(this, cVar));
    }

    public final <V> Flux<V> switchMap(Function<? super T, Z9.c> function) {
        return onAssembly(new FluxSwitchMapNoPrefetch(this, function));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, Z9.c> biFunction) {
        return switchOnFirst(biFunction, true);
    }

    public final Flux<T> tag(String str, String str2) {
        return FluxName.createOrAppend(this, str, str2);
    }

    public final Flux<T> take(long j5) {
        return take(j5, true);
    }

    public final Flux<T> takeLast(int i) {
        return i == 1 ? onAssembly(new FluxTakeLastOne(this)) : onAssembly(new FluxTakeLast(this, i));
    }

    public final Flux<T> takeUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeUntil(this, predicate));
    }

    public final Flux<T> takeUntilOther(Z9.c cVar) {
        return onAssembly(new FluxTakeUntilOther(this, cVar));
    }

    public final Flux<T> takeWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeWhile(this, predicate));
    }

    public final Flux<T> tap(final Supplier<SignalListener<T>> supplier) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.2
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(Z9.c cVar, ContextView contextView, Void r32) {
                return (SignalListener) supplier.get();
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(Z9.c cVar) {
                return null;
            }
        });
    }

    public final Mono<Void> then() {
        return Mono.onAssembly(new MonoIgnoreElements(this));
    }

    public final Mono<Void> thenEmpty(Z9.c cVar) {
        return then(Mono.fromDirect(cVar));
    }

    public final <V> Flux<V> thenMany(Z9.c cVar) {
        return concat(ignoreElements(), cVar);
    }

    public final Flux<Timed<T>> timed() {
        return timed(Schedulers.parallel());
    }

    public final Flux<T> timeout(Duration duration) {
        return timeout(duration, (Z9.c) null, Schedulers.parallel());
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

    public final <V> Flux<V> transform(Function<? super Flux<T>, ? extends Z9.c> function) {
        if (Hooks.DETECT_CONTEXT_LOSS) {
            function = new ContextTrackingFunctionWrapper(function);
        }
        return onAssembly(from(function.apply(this)));
    }

    public final <V> Flux<V> transformDeferred(Function<? super Flux<T>, ? extends Z9.c> function) {
        return defer(new E(this, function, 0));
    }

    public final <V> Flux<V> transformDeferredContextual(BiFunction<? super Flux<T>, ? super ContextView, ? extends Z9.c> biFunction) {
        return deferContextual(new C1896l(this, biFunction, 0));
    }

    public final Flux<Flux<T>> window(int i) {
        return onAssembly(new FluxWindow(this, i, Queues.get(i)));
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration) {
        return windowTimeout(i, duration, Schedulers.parallel());
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate) {
        return windowUntil(predicate, false);
    }

    public final Flux<Flux<T>> windowUntilChanged() {
        return windowUntilChanged(identityFunction());
    }

    public final <U, V> Flux<Flux<T>> windowWhen(Z9.c cVar, Function<? super U, ? extends Z9.c> function) {
        return onAssembly(new FluxWindowWhen(this, cVar, function, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate) {
        return windowWhile(predicate, Queues.SMALL_BUFFER_SIZE);
    }

    public final <U, R> Flux<R> withLatestFrom(Z9.c cVar, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return onAssembly(new FluxWithLatestFrom(this, cVar, biFunction));
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(Z9.c cVar) {
        return (Flux<Tuple2<T, T2>>) zipWith(cVar, tuple2Function());
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWithIterable(Iterable<? extends T2> iterable) {
        return (Flux<Tuple2<T, T2>>) zipWithIterable(iterable, tuple2Function());
    }

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(Function<Object[], V> function, int i, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length != 1) {
            return onAssembly(new FluxCombineLatest(cVarArr, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i), i));
        }
        Z9.c cVar = cVarArr[0];
        return cVar instanceof Fuseable ? onAssembly(new FluxMapFuseable(from(cVar), new r(4, function))) : onAssembly(new FluxMap(from(cVar), new r(5, function)));
    }

    public static <T> Flux<T> concat(Z9.c cVar) {
        return concat(cVar, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> concatDelayError(Z9.c cVar, int i) {
        return from(cVar).concatMapDelayError(identityFunction(), i);
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
    public static <I> Flux<I> first(Iterable<? extends Z9.c> iterable) {
        return firstWithSignal(iterable);
    }

    public static <I> Flux<I> firstWithSignal(Iterable<? extends Z9.c> iterable) {
        return onAssembly(new FluxFirstWithSignal(iterable));
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithValue(Z9.c cVar, Z9.c... cVarArr) {
        FluxFirstWithValue<T> fluxFirstWithValueFirstValuedAdditionalSources;
        return (!(cVar instanceof FluxFirstWithValue) || (fluxFirstWithValueFirstValuedAdditionalSources = ((FluxFirstWithValue) cVar).firstValuedAdditionalSources(cVarArr)) == null) ? onAssembly(new FluxFirstWithValue(cVar, cVarArr)) : fluxFirstWithValueFirstValuedAdditionalSources;
    }

    public static Flux<Long> interval(Duration duration, Duration duration2) {
        return interval(duration, duration2, Schedulers.parallel());
    }

    public static <T> Flux<T> just(T t9) {
        return onAssembly(new FluxJust(t9));
    }

    public static <T> Flux<T> merge(Z9.c cVar, int i) {
        return merge(cVar, i, Queues.XS_BUFFER_SIZE);
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(Comparator<? super T> comparator, Z9.c... cVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(Comparator<? super T> comparator, Z9.c... cVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(Comparator<? super T> comparator, Z9.c... cVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    public static <T> Flux<T> mergeSequential(Z9.c cVar, int i, int i6) {
        return mergeSequential(cVar, false, i, i6);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequentialDelayError(int i, Z9.c... cVarArr) {
        return mergeSequential(i, true, cVarArr);
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy) {
        return onAssembly(new FluxCreate(consumer, overflowStrategy, FluxCreate.CreateMode.PUSH_ONLY));
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends Z9.c> function, Consumer<? super D> consumer, boolean z10) {
        return onAssembly(new FluxUsing(callable, function, consumer, z10));
    }

    public static <T, D> Flux<T> usingWhen(Z9.c cVar, Function<? super D, ? extends Z9.c> function, Function<? super D, ? extends Z9.c> function2, BiFunction<? super D, ? super Throwable, ? extends Z9.c> biFunction, Function<? super D, ? extends Z9.c> function3) {
        return onAssembly(new FluxUsingWhen(cVar, function, function2, biFunction, function3));
    }

    public final Flux<List<T>> buffer(int i) {
        return (Flux<List<T>>) buffer(i, listSupplier());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Supplier<C> supplier) {
        return bufferTimeout(i, duration, Schedulers.parallel(), supplier);
    }

    public final <V> Flux<List<T>> bufferUntilChanged(Function<? super T, ? extends V> function) {
        return bufferUntilChanged(function, equalPredicate());
    }

    public final <U, V, C extends Collection<? super T>> Flux<C> bufferWhen(Z9.c cVar, Function<? super U, ? extends Z9.c> function, Supplier<C> supplier) {
        return onAssembly(new FluxBufferWhen(this, cVar, function, supplier, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<T> cache(int i) {
        return replay(i).autoConnect();
    }

    public final Flux<T> checkpoint(String str) {
        Objects.requireNonNull(str);
        return checkpoint(str, false);
    }

    public final <R, A> Mono<R> collect(Collector<? super T, A, ? extends R> collector) {
        return Mono.onAssembly(new MonoStreamCollector(this, collector));
    }

    public final <K, V> Mono<Map<K, V>> collectMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMap(function, function2, new C1886b(5));
    }

    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMultimap(function, function2, new C1886b(6));
    }

    public final Mono<List<T>> collectSortedList(@Nullable Comparator<? super T> comparator) {
        return collectList().doOnNext(new C1887c(comparator, 1));
    }

    public final <V> Flux<V> concatMap(Function<? super T, ? extends Z9.c> function, int i) {
        return i == 0 ? onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE)) : onAssembly(new FluxConcatMap(this, function, Queues.get(i), i, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends Z9.c> function, int i) {
        return concatMapDelayError(function, true, i);
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return onAssembly(new FluxFlattenIterable(this, function, i, Queues.get(i)));
    }

    public final Flux<T> contextWrite(Function<Context, Context> function) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, function)) : onAssembly(new FluxContextWrite(this, function));
    }

    public final Flux<T> delayElements(Duration duration, Scheduler scheduler) {
        return delayUntil(new C1899o(2, duration, scheduler));
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

    public final Mono<T> elementAt(int i, T t9) {
        return Mono.onAssembly(new MonoElementAt(this, i, t9));
    }

    public final Flux<T> expand(Function<? super T, ? extends Z9.c> function) {
        return expand(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends Z9.c> function) {
        return expandDeep(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends Z9.c> function, int i) {
        return onAssembly(new FluxFilterWhen(this, function, i));
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends Z9.c> function, int i) {
        return flatMap(function, i, Queues.XS_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return onAssembly(new FluxFlattenIterable(this, function, i, Queues.get(i)));
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends Z9.c> function, int i) {
        return flatMapSequential(function, i, Queues.XS_BUFFER_SIZE);
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function, int i) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction(), i);
    }

    public final <I> Flux<I> index(BiFunction<? super Long, ? super T, ? extends I> biFunction) {
        return this instanceof Fuseable ? onAssembly(new FluxIndexFuseable(this, biFunction)) : onAssembly(new FluxIndex(this, biFunction));
    }

    public final Flux<T> limitRate(int i, int i6) {
        return onAssembly(publishOn(Schedulers.immediate(), true, i, i6));
    }

    public final Flux<T> log(String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final Flux<T> onBackpressureBuffer(int i) {
        return onAssembly(new FluxOnBackpressureBuffer(this, i, false, null));
    }

    public final Flux<T> onBackpressureDrop(Consumer<? super T> consumer) {
        return onAssembly(new FluxOnBackpressureDrop(this, consumer));
    }

    public final Flux<T> onErrorComplete(Class<? extends Throwable> cls) {
        Objects.requireNonNull(cls, "type must not be null");
        return onErrorComplete(new b0(cls, 1));
    }

    public final <E extends Throwable> Flux<T> onErrorMap(Class<E> cls, Function<? super E, ? extends Throwable> function) {
        cls.getClass();
        return onErrorMap(new b0(cls, 1), function);
    }

    public final <E extends Throwable> Flux<T> onErrorResume(Class<E> cls, Function<? super E, ? extends Z9.c> function) {
        Objects.requireNonNull(cls, "type");
        return onErrorResume(new b0(cls, 1), function);
    }

    public final ParallelFlux<T> parallel(int i) {
        return parallel(i, Queues.SMALL_BUFFER_SIZE);
    }

    public final ConnectableFlux<T> publish(int i) {
        return onAssembly((ConnectableFlux) new FluxPublish(this, i, Queues.get(i), true));
    }

    public final Flux<T> publishOn(Scheduler scheduler, int i) {
        return publishOn(scheduler, true, i);
    }

    public final Flux<T> repeat(BooleanSupplier booleanSupplier) {
        return onAssembly(new FluxRepeatPredicate(this, booleanSupplier));
    }

    public final ConnectableFlux<T> replay(int i) {
        if (i != 0) {
            return onAssembly((ConnectableFlux) new FluxReplay(this, i, 0L, null));
        }
        int i6 = Queues.SMALL_BUFFER_SIZE;
        return onAssembly((ConnectableFlux) new FluxPublish(this, i6, Queues.get(i6), false));
    }

    public final Flux<T> retry(long j5) {
        return onAssembly(new FluxRetry(this, j5));
    }

    public final <U> Flux<T> sample(Z9.c cVar) {
        return onAssembly(new FluxSample(this, cVar));
    }

    public final <U> Flux<T> sampleFirst(Function<? super T, ? extends Z9.c> function) {
        return onAssembly(new FluxSampleFirst(this, function));
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends Z9.c> function, int i) {
        return onAssembly(new FluxSampleTimeout(this, function, Queues.get(i)));
    }

    public final <A> Flux<A> scan(A a3, BiFunction<A, ? super T, A> biFunction) {
        Objects.requireNonNull(a3, "seed");
        return scanWith(new B(a3, 0), biFunction);
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
    public final <V> Flux<V> switchMap(Function<? super T, Z9.c> function, int i) {
        return i == 0 ? onAssembly(new FluxSwitchMapNoPrefetch(this, function)) : onAssembly(new FluxSwitchMap(this, function, Queues.unbounded(i), i));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, Z9.c> biFunction, boolean z10) {
        return onAssembly(new FluxSwitchOnFirst(this, biFunction, z10));
    }

    public final Flux<T> take(long j5, boolean z10) {
        return z10 ? onAssembly(new FluxLimitRequest(this, j5)) : this instanceof Fuseable ? onAssembly(new FluxTakeFuseable(this, j5)) : onAssembly(new FluxTake(this, j5));
    }

    public final Flux<T> tap(final Function<ContextView, SignalListener<T>> function) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.3
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(Z9.c cVar, ContextView contextView, Void r32) {
                return (SignalListener) function.apply(contextView);
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(Z9.c cVar) {
                return null;
            }
        });
    }

    public final Flux<Timed<T>> timed(Scheduler scheduler) {
        return onAssembly(new FluxTimed(this, scheduler));
    }

    public final Flux<T> timeout(Duration duration, @Nullable Z9.c cVar) {
        return timeout(duration, cVar, Schedulers.parallel());
    }

    public final Flux<Tuple2<Long, T>> timestamp(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return (Flux<Tuple2<Long, T>>) map(new C1891g(scheduler, 0));
    }

    public final Iterable<T> toIterable(int i) {
        return toIterable(i, null);
    }

    public final Stream<T> toStream(int i) {
        return new BlockingIterable(this, i, Queues.get(i), ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new C1886b(1) : new C1886b(4)).stream();
    }

    public final Flux<Flux<T>> window(int i, int i6) {
        int i10 = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxWindow(this, i, i6, Queues.unbounded(i10), Queues.unbounded(i10)));
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, boolean z10) {
        return windowTimeout(i, duration, Schedulers.parallel(), z10);
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10) {
        return windowUntil(predicate, z10, Queues.SMALL_BUFFER_SIZE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <V> Flux<Flux<T>> windowUntilChanged(Function<? super T, ? super V> function) {
        return windowUntilChanged(function, equalPredicate());
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate, int i) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i), Queues.unbounded(i), i, predicate, FluxBufferPredicate.Mode.WHILE));
    }

    public final <T2, V> Flux<V> zipWith(Z9.c cVar, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        FluxZip fluxZipZipAdditionalSource;
        return (!(this instanceof FluxZip) || (fluxZipZipAdditionalSource = ((FluxZip) this).zipAdditionalSource(cVar, biFunction)) == null) ? zip(this, cVar, biFunction) : fluxZipZipAdditionalSource;
    }

    public final <T2, V> Flux<V> zipWithIterable(Iterable<? extends T2> iterable, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        return onAssembly(new FluxZipIterable(this, iterable, biFunction));
    }

    public static <T> Flux<T> concat(Z9.c cVar, int i) {
        return from(cVar).concatMap(identityFunction(), i);
    }

    public static <T> Flux<T> concatDelayError(Z9.c cVar, boolean z10, int i) {
        return from(cVar).concatMapDelayError(identityFunction(), z10, i);
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

    public static <T> Flux<T> merge(Z9.c cVar, int i, int i6) {
        return onAssembly(new FluxFlatMap(from(cVar), identityFunction(), false, i, Queues.get(i), i6, Queues.get(i6)));
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(int i, Comparator<? super T> comparator, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i, comparator, false, true, cVarArr));
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(int i, Comparator<? super T> comparator, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i, comparator, true, true, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(int i, Comparator<? super T> comparator, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMergeComparing(i, comparator, false, false, cVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(Z9.c... cVarArr) {
        return mergeSequential(Queues.XS_BUFFER_SIZE, false, cVarArr);
    }

    public static <I> Flux<I> mergeSequentialDelayError(Iterable<? extends Z9.c> iterable, int i, int i6) {
        return mergeSequential(iterable, true, i, i6);
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends Z9.c> function) {
        return using((Callable) callable, (Function) function, true);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i, supplier));
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, Scheduler scheduler) {
        return (Flux<List<T>>) bufferTimeout(i, duration, scheduler, listSupplier());
    }

    public final <V> Flux<List<T>> bufferUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        return defer(new C1901q(this, function, biPredicate, 0));
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
    public final <K, V> Mono<Map<K, V>> collectMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<Map<K, V>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        return (Mono<Map<K, V>>) collect(supplier, new C1908y(function, function2, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<Map<K, Collection<V>>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        return (Mono<Map<K, Collection<V>>>) collect(supplier, new C1908y(function, function2, 1));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends Z9.c> function, boolean z10, int i) {
        FluxConcatMap.ErrorMode errorMode = z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.BOUNDARY;
        if (i == 0) {
            return onAssembly(new FluxConcatMapNoPrefetch(this, function, errorMode));
        }
        return onAssembly(new FluxConcatMap(this, function, Queues.get(i), i, errorMode));
    }

    public final <U> Flux<T> delaySubscription(Z9.c cVar) {
        return onAssembly(new FluxDelaySubscription(this, cVar));
    }

    public final <V, C extends Collection<? super V>> Flux<T> distinct(Function<? super T, ? extends V> function, Supplier<C> supplier) {
        return distinct(function, supplier, new C1894j(1), new N(4));
    }

    public final <V> Flux<T> distinctUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        return onAssembly(new FluxDistinctUntilChanged(this, function, biPredicate));
    }

    public final <E extends Throwable> Flux<T> doOnError(Class<E> cls, Consumer<? super E> consumer) {
        Objects.requireNonNull(cls, "type");
        return doOnError(new b0(cls, 1), consumer);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends Z9.c> function, int i, int i6) {
        return flatMap(function, false, i, i6);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends Z9.c> function, int i, int i6) {
        return flatMapSequential(function, false, i, i6);
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final Flux<T> onBackpressureBuffer(int i, Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onOverflow");
        return onAssembly(new FluxOnBackpressureBuffer(this, i, false, consumer));
    }

    public final Flux<T> onErrorMap(Predicate<? super Throwable> predicate, Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(predicate, new r(6, function));
    }

    public final <E extends Throwable> Flux<T> onErrorReturn(Class<E> cls, T t9) {
        Objects.requireNonNull(cls, "type must not be null");
        return onErrorReturn((Predicate<? super Throwable>) new b0(cls, 1), (b0) t9);
    }

    public final ParallelFlux<T> parallel(int i, int i6) {
        return ParallelFlux.from(this, i, i6, Queues.get(i6));
    }

    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i) {
        return publishOn(scheduler, z10, i, i);
    }

    public final Flux<T> repeat(long j5) {
        return j5 == 0 ? this : onAssembly(new FluxRepeat(this, j5));
    }

    public final Flux<T> skip(Duration duration, Scheduler scheduler) {
        return !duration.isZero() ? skipUntilOther(Mono.delay(duration, scheduler)) : this;
    }

    public final Flux<T> startWith(Z9.c cVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceFirst(cVar) : concat(cVar, this);
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
        return Mono.onAssembly(new MonoIgnoreThen(new Z9.c[]{this}, mono));
    }

    public final Flux<T> timeout(Duration duration, Scheduler scheduler) {
        return timeout(duration, (Z9.c) null, scheduler);
    }

    public final Iterable<T> toIterable(int i, @Nullable Supplier<Queue<T>> supplier) {
        Supplier c;
        if (supplier == null) {
            c = Queues.get(i);
        } else {
            c = new C(0, supplier);
        }
        return new BlockingIterable(this, i, c, ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new C1886b(1) : new C1886b(4));
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, Scheduler scheduler) {
        return windowTimeout(i, duration, scheduler, false);
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10, int i) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i), Queues.unbounded(i), i, predicate, z10 ? FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE : FluxBufferPredicate.Mode.UNTIL));
    }

    public final <V> Flux<Flux<T>> windowUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        return defer(new C1901q(this, function, biPredicate, 1));
    }

    @SafeVarargs
    public static <T> Flux<T> concat(Z9.c... cVarArr) {
        return onAssembly(new FluxConcatArray(false, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> concatDelayError(Z9.c... cVarArr) {
        return onAssembly(new FluxConcatArray(true, cVarArr));
    }

    public static <T, S> Flux<T> generate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction, Consumer<? super S> consumer) {
        return onAssembly(new FluxGenerate(callable, biFunction, consumer));
    }

    public static Flux<Long> interval(Duration duration, Duration duration2, Scheduler scheduler) {
        return onAssembly(new FluxInterval(duration.toNanos(), duration2.toNanos(), TimeUnit.NANOSECONDS, scheduler));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i, Z9.c... cVarArr) {
        return mergeSequential(i, false, cVarArr);
    }

    @Deprecated
    public static <T> Flux<T> switchOnNext(Z9.c cVar, int i) {
        if (i == 0) {
            return onAssembly(new FluxSwitchMapNoPrefetch(from(cVar), identityFunction()));
        }
        return onAssembly(new FluxSwitchMap(from(cVar), identityFunction(), Queues.unbounded(i), i));
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends Z9.c> function, boolean z10) {
        return using(callable, function, Exceptions.AUTO_CLOSE, z10);
    }

    public static <T1, T2> Flux<Tuple2<T1, T2>> zip(Z9.c cVar, Z9.c cVar2) {
        return zip(cVar, cVar2, tuple2Function());
    }

    public final Flux<List<T>> buffer(int i, int i6) {
        return (Flux<List<T>>) buffer(i, i6, listSupplier());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Scheduler scheduler, Supplier<C> supplier) {
        return onAssembly(new FluxBufferTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, false));
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

    public final <R> Flux<R> flatMap(@Nullable Function<? super T, ? extends Z9.c> function, @Nullable Function<? super Throwable, ? extends Z9.c> function2, @Nullable Supplier<? extends Z9.c> supplier) {
        FluxMapSignal fluxMapSignal = new FluxMapSignal(this, function, function2, supplier);
        Function functionIdentityFunction = identityFunction();
        int i = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxFlatMap(fluxMapSignal, functionIdentityFunction, false, i, Queues.xs(), i, Queues.xs()));
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends Z9.c> function, boolean z10, int i, int i6) {
        return onAssembly(new FluxMergeSequential(this, function, i, i6, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i) {
        return onAssembly(new FluxGroupBy(this, function, function2, Queues.unbounded(i), Queues.unbounded(i), i));
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
        return onErrorContinue(new b0(cls, 1), biConsumer);
    }

    public final Flux<T> onErrorResume(Predicate<? super Throwable> predicate, Function<? super Throwable, ? extends Z9.c> function) {
        Objects.requireNonNull(predicate, "predicate");
        return onErrorResume(new C1904u(predicate, function, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i, int i6) {
        if (this instanceof Callable) {
            if (this instanceof Fuseable.ScalarCallable) {
                try {
                    return onAssembly(new FluxSubscribeOnValue(((Fuseable.ScalarCallable) this).call(), scheduler));
                } catch (Exception unused) {
                }
            }
            return onAssembly(new FluxSubscribeOnCallable((Callable) this, scheduler));
        }
        return onAssembly(new FluxPublishOn(this, scheduler, z10, i, i6, Queues.get(i)));
    }

    public final Flux<T> repeat(long j5, BooleanSupplier booleanSupplier) {
        if (j5 >= 0) {
            return j5 == 0 ? this : defer(new C1900p(this, booleanSupplier, j5, 0));
        }
        throw new IllegalArgumentException("numRepeat >= 0 required");
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer2, "errorConsumer");
        return subscribe(consumer, consumer2, null);
    }

    public final Flux<T> timeout(Duration duration, @Nullable Z9.c cVar, Scheduler scheduler) {
        Mono<Long> monoOnErrorReturn = Mono.delay(duration, scheduler).onErrorReturn(0L);
        I i = new I(monoOnErrorReturn, 1);
        if (cVar == null) {
            return timeout(monoOnErrorReturn, i, duration.toMillis() + "ms");
        }
        return timeout(monoOnErrorReturn, i, cVar);
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, Scheduler scheduler, boolean z10) {
        return onAssembly(new FluxWindowTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, z10));
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends Z9.c> iterable) {
        return mergeSequential(iterable, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <T1, T2, T3> Flux<Tuple3<T1, T2, T3>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3) {
        return zip(Tuples.fn3(), cVar, cVar2, cVar3);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i, int i6, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i, i6, supplier));
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i, duration, Schedulers.parallel(), listSupplier(), z10);
    }

    public final Flux<T> cache(int i, Duration duration) {
        return cache(i, duration, Schedulers.parallel());
    }

    public final Flux<T> doOnError(Predicate<? super Throwable> predicate, Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(predicate, "predicate");
        return doOnError(new C1909z(predicate, consumer, 0));
    }

    public final Flux<T> onBackpressureBuffer(int i, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i, null, bufferOverflowStrategy));
    }

    public final <E extends Throwable> Flux<T> onErrorContinue(Predicate<E> predicate, BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resumeIf(predicate, biConsumer)));
    }

    public final Flux<T> onErrorReturn(Predicate<? super Throwable> predicate, T t9) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        Objects.requireNonNull(t9, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, predicate, t9));
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends Z9.c> function) {
        return publish(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <A> Mono<A> reduce(A a3, BiFunction<A, ? super T, A> biFunction) {
        return reduceWith(new B(a3, 1), biFunction);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends Z9.c> iterable, int i, int i6) {
        return mergeSequential(iterable, false, i, i6);
    }

    public static <T> ConnectableFlux<T> onAssembly(ConnectableFlux<T> connectableFlux) {
        Function<Z9.c, Z9.c> function = Hooks.onEachOperatorHook;
        if (function != null) {
            connectableFlux = (ConnectableFlux) function.apply(connectableFlux);
        }
        return Hooks.GLOBAL_TRACE ? (ConnectableFlux) Hooks.addAssemblyInfo(connectableFlux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : connectableFlux;
    }

    public static <T1, T2, T3, T4> Flux<Tuple4<T1, T2, T3, T4>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4) {
        return zip(Tuples.fn4(), cVar, cVar2, cVar3, cVar4);
    }

    @Nullable
    public final T blockFirst(Duration duration) {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((Z9.d) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Nullable
    public final T blockLast(Duration duration) {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((Z9.d) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final Flux<List<T>> buffer(Z9.c cVar) {
        return (Flux<List<T>>) buffer(cVar, listSupplier());
    }

    public final Flux<T> cache(int i, Duration duration, Scheduler scheduler) {
        return replay(i, duration, scheduler).autoConnect();
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends Z9.c> function, int i) {
        return onAssembly(new FluxPublishMulticast(this, function, i, Queues.get(i)));
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

    public final Flux<Flux<T>> window(Z9.c cVar) {
        return onAssembly(new FluxWindowBoundary(this, cVar, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final <T2, V> Flux<V> zipWith(Z9.c cVar, int i, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        return zip(new C1895k(biFunction, 0), i, this, cVar);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i, boolean z10, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMergeSequential(new FluxArray(cVarArr), identityFunction(), cVarArr.length, i, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T1, T2, T3, T4, T5> Flux<Tuple5<T1, T2, T3, T4, T5>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5) {
        return zip(Tuples.fn5(), cVar, cVar2, cVar3, cVar4, cVar5);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(Z9.c cVar, Supplier<C> supplier) {
        return onAssembly(new FluxBufferBoundary(this, cVar, supplier));
    }

    public final Flux<T> onBackpressureBuffer(int i, Consumer<? super T> consumer, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(consumer, "onBufferOverflow");
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i, consumer, bufferOverflowStrategy));
    }

    public final ConnectableFlux<T> replay(int i, Duration duration) {
        return replay(i, duration, Schedulers.parallel());
    }

    @Deprecated
    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super Z9.e> consumer3) {
        return (Disposable) subscribeWith(new LambdaSubscriber(consumer, consumer2, runnable, consumer3, null));
    }

    public final Flux<T> take(Duration duration, Scheduler scheduler) {
        if (!duration.isZero()) {
            return takeUntilOther(Mono.delay(duration, scheduler));
        }
        return take(0L, false);
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(Z9.c cVar, int i) {
        return (Flux<Tuple2<T, T2>>) zipWith(cVar, i, tuple2Function());
    }

    public static <T1, T2, T3, T4, T5, T6> Flux<Tuple6<T1, T2, T3, T4, T5, T6>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5, Z9.c cVar6) {
        return zip(Tuples.fn6(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    public final Flux<List<T>> buffer(Duration duration) {
        return buffer(duration, Schedulers.parallel());
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, Scheduler scheduler, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i, duration, scheduler, listSupplier(), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last(T t9) throws Exception {
        if (this instanceof Callable) {
            Callable callable = (Callable) this;
            if (callable instanceof Fuseable.ScalarCallable) {
                try {
                    T tCall = ((Fuseable.ScalarCallable) callable).call();
                    if (tCall == null) {
                        return Mono.just(t9);
                    }
                    return Mono.just(tCall);
                } catch (Exception e) {
                    return Mono.error(Exceptions.unwrap(e));
                }
            }
            Mono.onAssembly(new MonoCallable(callable));
        }
        return Mono.onAssembly(new MonoTakeLastOne(this, t9));
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

    public final <U> Flux<T> timeout(Z9.c cVar) {
        return timeout(cVar, new C1885a(14));
    }

    public static <I> Flux<I> merge(Iterable<? extends Z9.c> iterable) {
        return merge(fromIterable(iterable));
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Flux<Tuple7<T1, T2, T3, T4, T5, T6, T7>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5, Z9.c cVar6, Z9.c cVar7) {
        return zip(Tuples.fn7(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7);
    }

    public final Flux<List<T>> buffer(Duration duration, Duration duration2) {
        return buffer(duration, duration2, Schedulers.parallel());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Supplier<C> supplier, boolean z10) {
        return bufferTimeout(i, duration, Schedulers.parallel(), supplier, z10);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends Z9.c> function, boolean z10, int i, int i6) {
        return onAssembly(new FluxFlatMap(this, function, z10, i, Queues.get(i), i6, Queues.get(i6)));
    }

    public final Flux<T> log(Logger logger, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, "IGNORED", level, z10, new C1898n(logger, 0), signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new FluxLogFuseable(this, signalLogger));
        }
        return onAssembly(new FluxLog(this, signalLogger));
    }

    public final ConnectableFlux<T> replay(int i, Duration duration, Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "timer");
        if (i == 0) {
            int i6 = Queues.SMALL_BUFFER_SIZE;
            return onAssembly((ConnectableFlux) new FluxPublish(this, i6, Queues.get(i6), true));
        }
        return onAssembly((ConnectableFlux) new FluxReplay(this, i, duration.toNanos(), scheduler));
    }

    @Override // reactor.core.CorePublisher, Z9.c
    public final void subscribe(Z9.d dVar) {
        CorePublisher corePublisherOnLastAssembly = Operators.onLastAssembly(this);
        CoreSubscriber<? super T> coreSubscriber = Operators.toCoreSubscriber(dVar);
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

    public final <U, V> Flux<T> timeout(Z9.c cVar, Function<? super T, ? extends Z9.c> function) {
        return timeout(cVar, function, "first signal from a Publisher");
    }

    public final Flux<Flux<T>> window(Duration duration) {
        return window(duration, Schedulers.parallel());
    }

    @SafeVarargs
    public static <I> Flux<I> merge(Z9.c... cVarArr) {
        return merge(Queues.XS_BUFFER_SIZE, cVarArr);
    }

    private <U, V> Flux<T> timeout(Z9.c cVar, Function<? super T, ? extends Z9.c> function, String str) {
        return onAssembly(new FluxTimeout(this, cVar, function, str));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Flux<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> zip(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5, Z9.c cVar6, Z9.c cVar7, Z9.c cVar8) {
        return zip(Tuples.fn8(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8);
    }

    public final Flux<List<T>> buffer(Duration duration, Scheduler scheduler) {
        return buffer(interval(duration, scheduler));
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Scheduler scheduler, Supplier<C> supplier, boolean z10) {
        return onAssembly(new FluxBufferTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, z10));
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i, Consumer<? super T> consumer) {
        return onBackpressureBuffer(duration, i, consumer, Schedulers.parallel());
    }

    public final Flux<Flux<T>> window(Duration duration, Duration duration2) {
        return window(duration, duration2, Schedulers.parallel());
    }

    @SafeVarargs
    public static <I> Flux<I> merge(int i, Z9.c... cVarArr) {
        return merge(i, false, cVarArr);
    }

    public static <O> Flux<O> zip(Iterable<? extends Z9.c> iterable, Function<? super Object[], ? extends O> function) {
        return zip(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public final Flux<List<T>> buffer(Duration duration, Duration duration2, Scheduler scheduler) {
        if (duration.equals(duration2)) {
            return buffer(duration, scheduler);
        }
        return bufferWhen(interval(Duration.ZERO, duration2, scheduler), new C1899o(0, duration, scheduler));
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i, Consumer<? super T> consumer, Scheduler scheduler) {
        Objects.requireNonNull(duration, "ttl");
        Objects.requireNonNull(consumer, "onBufferEviction");
        return onAssembly(new FluxOnBackpressureBufferTimeout(this, duration, scheduler, i, consumer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> single(T t9) throws Exception {
        if (this instanceof Callable) {
            if (this instanceof Fuseable.ScalarCallable) {
                try {
                    T tCall = ((Fuseable.ScalarCallable) this).call();
                    if (tCall == null) {
                        return Mono.just(t9);
                    }
                    return Mono.just(tCall);
                } catch (Exception e) {
                    return Mono.error(Exceptions.unwrap(e));
                }
            }
            return Mono.onAssembly(new MonoSingleCallable((Callable) this, t9));
        }
        return Mono.onAssembly(new MonoSingle(this, t9, false));
    }

    public final <U, V> Flux<T> timeout(Z9.c cVar, Function<? super T, ? extends Z9.c> function, Z9.c cVar2) {
        return onAssembly(new FluxTimeout(this, cVar, function, cVar2));
    }

    public final Flux<Flux<T>> window(Duration duration, Scheduler scheduler) {
        return window(interval(duration, scheduler));
    }

    public static <T1, T2, V> Flux<V> combineLatest(Z9.c cVar, Z9.c cVar2, BiFunction<? super T1, ? super T2, ? extends V> biFunction) {
        return combineLatest(new C1895k(biFunction, 1), cVar, cVar2);
    }

    @SafeVarargs
    public static <I> Flux<I> merge(int i, boolean z10, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMerge(cVarArr, z10, cVarArr.length, Queues.get(cVarArr.length), i, Queues.get(i)));
    }

    public static <O> Flux<O> zip(Iterable<? extends Z9.c> iterable, int i, Function<? super Object[], ? extends O> function) {
        return onAssembly(new FluxZip(iterable, function, Queues.get(i), i));
    }

    public final Flux<Flux<T>> window(Duration duration, Duration duration2, Scheduler scheduler) {
        if (duration2.equals(duration)) {
            return window(duration);
        }
        return windowWhen(interval(Duration.ZERO, duration2, scheduler), new C1899o(1, duration, scheduler));
    }

    public static <T1, T2, T3, V> Flux<V> combineLatest(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3);
    }

    public static <T1, T2, T3, T4, V> Flux<V> combineLatest(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4);
    }

    public static <T> Flux<T> mergeSequential(Z9.c cVar, boolean z10, int i, int i6) {
        return onAssembly(new FluxMergeSequential(from(cVar), identityFunction(), i, i6, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T1, T2, T3, T4, T5, V> Flux<V> combineLatest(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4, cVar5);
    }

    @SafeVarargs
    public static <I, O> Flux<O> zip(Function<? super Object[], ? extends O> function, Z9.c... cVarArr) {
        return zip(function, Queues.XS_BUFFER_SIZE, cVarArr);
    }

    public static <T1, T2, T3, T4, T5, T6, V> Flux<V> combineLatest(Z9.c cVar, Z9.c cVar2, Z9.c cVar3, Z9.c cVar4, Z9.c cVar5, Z9.c cVar6, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    @SafeVarargs
    public static <I, O> Flux<O> zip(Function<? super Object[], ? extends O> function, int i, Z9.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            Z9.c cVar = cVarArr[0];
            if (cVar instanceof Fuseable) {
                return onAssembly(new FluxMapFuseable(from(cVar), new r(1, function)));
            }
            return onAssembly(new FluxMap(from(cVar), new r(2, function)));
        }
        return onAssembly(new FluxZip(cVarArr, function, Queues.get(i), i));
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends Z9.c> iterable, Function<Object[], V> function) {
        return combineLatest(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends Z9.c> iterable, boolean z10, int i, int i6) {
        return onAssembly(new FluxMergeSequential(new FluxIterable(iterable), identityFunction(), i, i6, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends Z9.c> iterable, int i, Function<Object[], V> function) {
        return onAssembly(new FluxCombineLatest(iterable, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i), i));
    }

    public static <TUPLE extends Tuple2, V> Flux<V> zip(Z9.c cVar, final Function<? super TUPLE, ? extends V> function) {
        return onAssembly(new FluxBuffer(from(cVar), Integer.MAX_VALUE, listSupplier()).flatMap(new Function<List<? extends Z9.c>, Z9.c>() { // from class: reactor.core.publisher.Flux.1
            @Override // java.util.function.Function
            public Z9.c apply(List<? extends Z9.c> list) {
                return Flux.zip(Tuples.fnAny(function), (Z9.c[]) list.toArray(new Z9.c[list.size()]));
            }
        }));
    }
}
