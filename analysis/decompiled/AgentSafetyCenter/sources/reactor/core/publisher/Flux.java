package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class Flux<T> implements CorePublisher<T> {
    static final BiFunction TUPLE2_BIFUNCTION = new i(0);
    static final Supplier LIST_SUPPLIER = new b(2);
    static final Supplier SET_SUPPLIER = new b(3);
    static final BooleanSupplier ALWAYS_BOOLEAN_SUPPLIER = new j();
    static final BiPredicate OBJECT_EQUAL = new k(0);
    static final Function IDENTITY_FUNCTION = Function.identity();

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(Function<Object[], V> function, int i, qd.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length != 1) {
            return onAssembly(new FluxCombineLatest(cVarArr, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i), i));
        }
        qd.c cVar = cVarArr[0];
        if (cVar instanceof Fuseable) {
            Flux fluxFrom = from(cVar);
            s sVar = new s(4);
            sVar.f10854b = function;
            VarHandle.storeStoreFence();
            return onAssembly(new FluxMapFuseable(fluxFrom, sVar));
        }
        Flux fluxFrom2 = from(cVar);
        s sVar2 = new s(5);
        sVar2.f10854b = function;
        VarHandle.storeStoreFence();
        return onAssembly(new FluxMap(fluxFrom2, sVar2));
    }

    public static <T> Flux<T> concat(qd.c cVar, int i) {
        return from(cVar).concatMap(identityFunction(), i);
    }

    public static <T> Flux<T> concatDelayError(qd.c cVar, int i) {
        return from(cVar).concatMapDelayError(identityFunction(), i);
    }

    private final Flux<T> contextWriteSkippingContextPropagation(ContextView contextView) {
        n nVar = new n(0);
        nVar.f10827b = contextView;
        VarHandle.storeStoreFence();
        return contextWriteSkippingContextPropagation(nVar);
    }

    public static BooleanSupplier countingBooleanSupplier(final BooleanSupplier booleanSupplier, final long j10) {
        return j10 <= 0 ? booleanSupplier : new BooleanSupplier() { // from class: reactor.core.publisher.Flux.4

            /* renamed from: n, reason: collision with root package name */
            long f10585n;

            @Override // java.util.function.BooleanSupplier
            public boolean getAsBoolean() {
                long j11 = this.f10585n;
                this.f10585n = 1 + j11;
                return j11 < j10 && booleanSupplier.getAsBoolean();
            }
        };
    }

    public static <O> Predicate<O> countingPredicate(final Predicate<O> predicate, final long j10) {
        return j10 == 0 ? predicate : new Predicate<O>() { // from class: reactor.core.publisher.Flux.5

            /* renamed from: n, reason: collision with root package name */
            long f10586n;

            @Override // java.util.function.Predicate
            public boolean test(O o10) {
                long j11 = this.f10586n;
                this.f10586n = 1 + j11;
                return j11 < j10 && predicate.test(o10);
            }
        };
    }

    public static <T> Flux<T> create(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy) {
        return onAssembly(new FluxCreate(consumer, overflowStrategy, FluxCreate.CreateMode.PUSH_PULL));
    }

    public static <T> Flux<T> defer(Supplier<? extends qd.c> supplier) {
        return onAssembly(new FluxDefer(supplier));
    }

    public static <T> Flux<T> deferContextual(Function<ContextView, ? extends qd.c> function) {
        return onAssembly(new FluxDeferContextual(function));
    }

    public static <T> Flux<T> doOnSignal(Flux<T> flux, @Nullable Consumer<? super qd.e> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        return flux instanceof Fuseable ? onAssembly(new FluxPeekFuseable(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3)) : onAssembly(new FluxPeek(flux, consumer, consumer2, consumer3, runnable, runnable2, longConsumer, runnable3));
    }

    public static <T> Flux<T> empty() {
        return FluxEmpty.instance();
    }

    public static <U, V> BiPredicate<U, V> equalPredicate() {
        return OBJECT_EQUAL;
    }

    public static <O> Flux<O> error(Throwable th, boolean z10) {
        return z10 ? onAssembly(new FluxErrorOnRequest(th)) : onAssembly(new FluxError(th));
    }

    @SafeVarargs
    @Deprecated
    public static <I> Flux<I> first(qd.c... cVarArr) {
        return firstWithSignal(cVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithSignal(qd.c... cVarArr) {
        return onAssembly(new FluxFirstWithSignal(cVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> firstWithValue(qd.c cVar, qd.c... cVarArr) {
        FluxFirstWithValue<T> fluxFirstWithValueFirstValuedAdditionalSources;
        return (!(cVar instanceof FluxFirstWithValue) || (fluxFirstWithValueFirstValuedAdditionalSources = ((FluxFirstWithValue) cVar).firstValuedAdditionalSources(cVarArr)) == null) ? onAssembly(new FluxFirstWithValue(cVar, cVarArr)) : fluxFirstWithValueFirstValuedAdditionalSources;
    }

    public static <T> Flux<T> from(qd.c cVar) {
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
        y yVar = new y(0);
        yVar.f10881f = stream;
        VarHandle.storeStoreFence();
        return onAssembly(new FluxStream(yVar));
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

    public static Flux<Long> interval(Duration duration, Duration duration2, Scheduler scheduler) {
        return onAssembly(new FluxInterval(duration.toNanos(), duration2.toNanos(), TimeUnit.NANOSECONDS, scheduler));
    }

    public static <T> Flux<T> just(T t10) {
        return onAssembly(new FluxJust(t10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$buffer$7(Duration duration, Scheduler scheduler, Long l2) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$bufferUntilChanged$8(Function function, BiPredicate biPredicate) {
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
    public static /* synthetic */ List lambda$collectList$9(Object obj) {
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
        ((Collection) map.computeIfAbsent(function.apply(obj), new a(13))).add(function2.apply(obj));
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
    public static /* synthetic */ qd.c lambda$delayElements$19(Duration duration, Scheduler scheduler, Object obj) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$delayUntil$20(Function function, Object obj) {
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
    public static /* synthetic */ qd.c lambda$null$40(BiFunction biFunction, ContextView contextView, qd.c cVar) {
        return (qd.c) biFunction.apply(wrap(cVar), contextView);
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
    public static /* synthetic */ qd.c lambda$onErrorMap$28(Function function, Throwable th) {
        return Mono.error((Throwable) function.apply(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$onErrorMap$29(Function function, Throwable th) {
        return Mono.error((Throwable) function.apply(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$onErrorResume$30(Predicate predicate, Function function, Throwable th) {
        return predicate.test(th) ? (qd.c) function.apply(th) : error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$repeat$32(BooleanSupplier booleanSupplier, long j10) {
        return repeat(countingBooleanSupplier(booleanSupplier, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$sampleFirst$33(Duration duration, Object obj) {
        return Mono.delay(duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$45() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$timeout$36(Object obj) {
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
    public /* synthetic */ qd.c lambda$transformDeferred$39(Function function) {
        return Hooks.DETECT_CONTEXT_LOSS ? new ContextTrackingFunctionWrapper(function).apply((qd.c) this) : (qd.c) function.apply(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$transformDeferredContextual$41(BiFunction biFunction, ContextView contextView) {
        if (!Hooks.DETECT_CONTEXT_LOSS) {
            return (qd.c) biFunction.apply(this, contextView);
        }
        x xVar = new x(0);
        xVar.f10875b = biFunction;
        xVar.f10876c = contextView;
        VarHandle.storeStoreFence();
        return new ContextTrackingFunctionWrapper(xVar, biFunction.toString()).apply((qd.c) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$usingWhen$4(Function function, Object obj, Throwable th) {
        return (qd.c) function.apply(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$window$42(Duration duration, Scheduler scheduler, Long l2) {
        return Mono.delay(duration, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$windowUntilChanged$43(Function function, BiPredicate biPredicate) {
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

    @SafeVarargs
    public static <I> Flux<I> merge(int i, boolean z10, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMerge(cVarArr, z10, cVarArr.length, Queues.get(cVarArr.length), i, Queues.get(i)));
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(int i, Comparator<? super T> comparator, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, false, true, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparingDelayError(int i, Comparator<? super T> comparator, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, true, true, cVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeDelayError(int i, qd.c... cVarArr) {
        return merge(i, true, cVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(int i, Comparator<? super T> comparator, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, true, true, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(int i, Comparator<? super T> comparator, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, false, false, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriorityDelayError(int i, Comparator<? super T> comparator, qd.c... cVarArr) {
        return cVarArr.length == 0 ? empty() : cVarArr.length == 1 ? from(cVarArr[0]) : onAssembly(new FluxMergeComparing(i, comparator, true, false, cVarArr));
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i, boolean z10, qd.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        if (cVarArr.length == 1) {
            return from(cVarArr[0]);
        }
        return onAssembly(new FluxMergeSequential(new FluxArray(cVarArr), identityFunction(), cVarArr.length, i, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public static <T> Flux<T> mergeSequentialDelayError(qd.c cVar, int i, int i3) {
        return mergeSequential(cVar, true, i, i3);
    }

    public static <T> Flux<T> never() {
        return FluxNever.instance();
    }

    public static <T> Flux<T> onAssembly(Flux<T> flux) {
        Function<qd.c, qd.c> function = Hooks.onEachOperatorHook;
        if (function != null) {
            flux = (Flux) function.apply(flux);
        }
        return Hooks.GLOBAL_TRACE ? (Flux) Hooks.addAssemblyInfo(flux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : flux;
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy) {
        return onAssembly(new FluxCreate(consumer, overflowStrategy, FluxCreate.CreateMode.PUSH_ONLY));
    }

    public static Flux<Integer> range(int i, int i3) {
        return i3 == 1 ? just(Integer.valueOf(i)) : i3 == 0 ? empty() : onAssembly(new FluxRange(i, i3));
    }

    @Deprecated
    public static <T> Flux<T> switchOnNext(qd.c cVar, int i) {
        return i == 0 ? onAssembly(new FluxSwitchMapNoPrefetch(from(cVar), identityFunction())) : onAssembly(new FluxSwitchMap(from(cVar), identityFunction(), Queues.unbounded(i), i));
    }

    public static <A, B> BiFunction<A, B, Tuple2<A, B>> tuple2Function() {
        return TUPLE2_BIFUNCTION;
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qd.c> function, Consumer<? super D> consumer, boolean z10) {
        return onAssembly(new FluxUsing(callable, function, consumer, z10));
    }

    public static <T, D> Flux<T> usingWhen(qd.c cVar, Function<? super D, ? extends qd.c> function, Function<? super D, ? extends qd.c> function2) {
        b0 b0Var = new b0(0);
        b0Var.f10763f = function2;
        VarHandle.storeStoreFence();
        return usingWhen(cVar, function, function2, b0Var, function2);
    }

    public static <I> Flux<I> wrap(qd.c cVar) throws Exception {
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

    @SafeVarargs
    public static <I, O> Flux<O> zip(Function<? super Object[], ? extends O> function, int i, qd.c... cVarArr) {
        if (cVarArr.length == 0) {
            return empty();
        }
        int i3 = 1;
        if (cVarArr.length != 1) {
            return onAssembly(new FluxZip(cVarArr, function, Queues.get(i), i));
        }
        qd.c cVar = cVarArr[0];
        if (cVar instanceof Fuseable) {
            Flux fluxFrom = from(cVar);
            s sVar = new s(i3);
            sVar.f10854b = function;
            VarHandle.storeStoreFence();
            return onAssembly(new FluxMapFuseable(fluxFrom, sVar));
        }
        Flux fluxFrom2 = from(cVar);
        s sVar2 = new s(2);
        sVar2.f10854b = function;
        VarHandle.storeStoreFence();
        return onAssembly(new FluxMap(fluxFrom2, sVar2));
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
    public final T blockFirst(Duration duration) {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qd.d) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Nullable
    public final T blockLast(Duration duration) {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qd.d) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final Flux<List<T>> buffer(Duration duration, Duration duration2, Scheduler scheduler) {
        if (duration.equals(duration2)) {
            return buffer(duration, scheduler);
        }
        Flux<Long> fluxInterval = interval(Duration.ZERO, duration2, scheduler);
        p pVar = new p(0);
        pVar.f10835b = duration;
        pVar.f10836c = scheduler;
        VarHandle.storeStoreFence();
        return bufferWhen(fluxInterval, pVar);
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Scheduler scheduler, Supplier<C> supplier) {
        return onAssembly(new FluxBufferTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, false));
    }

    public final Flux<List<T>> bufferUntil(Predicate<? super T> predicate, boolean z10) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), z10 ? FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE : FluxBufferPredicate.Mode.UNTIL));
    }

    public final <V> Flux<List<T>> bufferUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        r rVar = new r(0);
        rVar.f10847f = this;
        rVar.f10848g = function;
        rVar.f10849h = biPredicate;
        VarHandle.storeStoreFence();
        return defer(rVar);
    }

    public final <U, V, C extends Collection<? super T>> Flux<C> bufferWhen(qd.c cVar, Function<? super U, ? extends qd.c> function, Supplier<C> supplier) {
        return onAssembly(new FluxBufferWhen(this, cVar, function, supplier, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<List<T>> bufferWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), FluxBufferPredicate.Mode.WHILE));
    }

    public final Flux<T> cache(int i) {
        return replay(i).autoConnect();
    }

    public final Flux<T> cancelOn(Scheduler scheduler) {
        return onAssembly(new FluxCancelOn(this, scheduler));
    }

    public final <E> Flux<E> cast(Class<E> cls) {
        Objects.requireNonNull(cls, "clazz");
        b1 b1Var = new b1(1);
        b1Var.f10765b = cls;
        VarHandle.storeStoreFence();
        return (Flux<E>) map(b1Var);
    }

    public final Flux<T> checkpoint(@Nullable String str, boolean z10) {
        return new FluxOnAssembly(this, !z10 ? new FluxOnAssembly.CheckpointLightSnapshot(str) : new FluxOnAssembly.CheckpointHeavySnapshot(str, Traces.callSiteSupplierFactory.get()));
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
            w wVar = new w(1);
            wVar.f10872f = (Callable) this;
            VarHandle.storeStoreFence();
            return Mono.onAssembly(new MonoCallable(wVar));
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) this).call();
            w wVar2 = new w(0);
            wVar2.f10872f = tCall;
            VarHandle.storeStoreFence();
            return Mono.onAssembly(new MonoCallable(wVar2));
        } catch (Exception e10) {
            return Mono.error(Exceptions.unwrap(e10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Mono<Map<K, V>> collectMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<Map<K, V>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        z zVar = new z(0);
        zVar.f10884f = function;
        zVar.f10885g = function2;
        VarHandle.storeStoreFence();
        return (Mono<Map<K, V>>) collect(supplier, zVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<Map<K, Collection<V>>> supplier) {
        Objects.requireNonNull(function, "Key extractor is null");
        Objects.requireNonNull(function2, "Value extractor is null");
        Objects.requireNonNull(supplier, "Map supplier is null");
        z zVar = new z(1);
        zVar.f10884f = function;
        zVar.f10885g = function2;
        VarHandle.storeStoreFence();
        return (Mono<Map<K, Collection<V>>>) collect(supplier, zVar);
    }

    public final Mono<List<T>> collectSortedList(@Nullable Comparator<? super T> comparator) throws Exception {
        Mono<List<T>> monoCollectList = collectList();
        c cVar = new c(1);
        cVar.f10767f = comparator;
        VarHandle.storeStoreFence();
        return monoCollectList.doOnNext(cVar);
    }

    public final <V> Flux<V> concatMap(Function<? super T, ? extends qd.c> function, int i) {
        return i == 0 ? onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE)) : onAssembly(new FluxConcatMap(this, function, Queues.get(i), i, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qd.c> function, boolean z10, int i) {
        FluxConcatMap.ErrorMode errorMode = z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.BOUNDARY;
        return i == 0 ? onAssembly(new FluxConcatMapNoPrefetch(this, function, errorMode)) : onAssembly(new FluxConcatMap(this, function, Queues.get(i), i, errorMode));
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return onAssembly(new FluxFlattenIterable(this, function, i, Queues.get(i)));
    }

    public final Flux<T> concatWith(qd.c cVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceLast(cVar) : concat(this, cVar);
    }

    @SafeVarargs
    public final Flux<T> concatWithValues(T... tArr) {
        return concatWith(fromArray(tArr));
    }

    public final Flux<T> contextCapture() {
        return !ContextPropagationSupport.isContextPropagationAvailable() ? this : ContextPropagationSupport.propagateContextToThreadLocals ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, ContextPropagation.contextCapture())) : onAssembly(new FluxContextWrite(this, ContextPropagation.contextCapture()));
    }

    public final Flux<T> contextWrite(Function<Context, Context> function) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? onAssembly(new FluxContextWriteRestoringThreadLocals(this, function)) : onAssembly(new FluxContextWrite(this, function));
    }

    public final Mono<Long> count() {
        return Mono.onAssembly(new MonoCount(this));
    }

    public final Flux<T> defaultIfEmpty(T t10) {
        return onAssembly(new FluxDefaultIfEmpty(this, t10));
    }

    public final Flux<T> delayElements(Duration duration, Scheduler scheduler) {
        p pVar = new p(2);
        pVar.f10835b = duration;
        pVar.f10836c = scheduler;
        VarHandle.storeStoreFence();
        return delayUntil(pVar);
    }

    public final Flux<T> delaySequence(Duration duration, Scheduler scheduler) {
        return onAssembly(new FluxDelaySequence(this, duration, scheduler));
    }

    public final <U> Flux<T> delaySubscription(qd.c cVar) {
        return onAssembly(new FluxDelaySubscription(this, cVar));
    }

    public final Flux<T> delayUntil(Function<? super T, ? extends qd.c> function) {
        s sVar = new s(0);
        sVar.f10854b = function;
        VarHandle.storeStoreFence();
        return concatMap(sVar);
    }

    public final <X> Flux<X> dematerialize() {
        return onAssembly(new FluxDematerialize(this));
    }

    public final <V, C> Flux<T> distinct(Function<? super T, ? extends V> function, Supplier<C> supplier, BiPredicate<C, V> biPredicate, Consumer<C> consumer) {
        return this instanceof Fuseable ? onAssembly(new FluxDistinctFuseable(this, function, supplier, biPredicate, consumer)) : onAssembly(new FluxDistinct(this, function, supplier, biPredicate, consumer));
    }

    public final <V> Flux<T> distinctUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        return onAssembly(new FluxDistinctUntilChanged(this, function, biPredicate));
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

    public final Flux<T> doOnError(Predicate<? super Throwable> predicate, Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(predicate, "predicate");
        a0 a0Var = new a0(0);
        a0Var.f10757f = predicate;
        a0Var.f10758g = consumer;
        VarHandle.storeStoreFence();
        return doOnError(a0Var);
    }

    public final Flux<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext");
        return doOnSignal(this, null, consumer, null, null, null, null, null);
    }

    public final Flux<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "consumer");
        return doOnSignal(this, null, null, null, null, null, longConsumer, null);
    }

    public final Flux<T> doOnSubscribe(Consumer<? super qd.e> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, consumer, null, null, null, null, null, null);
    }

    public final Flux<T> doOnTerminate(Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        t tVar = new t(0);
        tVar.f10859f = runnable;
        VarHandle.storeStoreFence();
        return doOnSignal(this, null, null, tVar, runnable, null, null, null);
    }

    public final Flux<Tuple2<Long, T>> elapsed(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return onAssembly(new FluxElapsed(this, scheduler));
    }

    public final Mono<T> elementAt(int i) {
        return Mono.onAssembly(new MonoElementAt(this, i));
    }

    public final Flux<T> expand(Function<? super T, ? extends qd.c> function, int i) {
        return onAssembly(new FluxExpand(this, function, true, i));
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qd.c> function, int i) {
        return onAssembly(new FluxExpand(this, function, false, i));
    }

    public final Flux<T> filter(Predicate<? super T> predicate) {
        return this instanceof Fuseable ? onAssembly(new FluxFilterFuseable(this, predicate)) : onAssembly(new FluxFilter(this, predicate));
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends qd.c> function, int i) {
        return onAssembly(new FluxFilterWhen(this, function, i));
    }

    public final <R> Flux<R> flatMap(@Nullable Function<? super T, ? extends qd.c> function, @Nullable Function<? super Throwable, ? extends qd.c> function2, @Nullable Supplier<? extends qd.c> supplier) {
        FluxMapSignal fluxMapSignal = new FluxMapSignal(this, function, function2, supplier);
        Function functionIdentityFunction = identityFunction();
        int i = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxFlatMap(fluxMapSignal, functionIdentityFunction, false, i, Queues.xs(), i, Queues.xs()));
    }

    public final <V> Flux<V> flatMapDelayError(Function<? super T, ? extends qd.c> function, int i, int i3) {
        return flatMap(function, true, i, i3);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return onAssembly(new FluxFlattenIterable(this, function, i, Queues.get(i)));
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qd.c> function, boolean z10, int i, int i3) {
        return onAssembly(new FluxMergeSequential(this, function, i, i3, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <R> Flux<R> flatMapSequentialDelayError(Function<? super T, ? extends qd.c> function, int i, int i3) {
        return flatMapSequential(function, true, i, i3);
    }

    public int getPrefetch() {
        return -1;
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i) {
        return onAssembly(new FluxGroupBy(this, function, function2, Queues.unbounded(i), Queues.unbounded(i), i));
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> groupJoin(qd.c cVar, Function<? super T, ? extends qd.c> function, Function<? super TRight, ? extends qd.c> function2, BiFunction<? super T, ? super Flux<TRight>, ? extends R> biFunction) {
        int i = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxGroupJoin(this, cVar, function, function2, biFunction, Queues.unbounded(i), Queues.unbounded(i)));
    }

    public final <R> Flux<R> handle(BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        return this instanceof Fuseable ? onAssembly(new FluxHandleFuseable(this, biConsumer)) : onAssembly(new FluxHandle(this, biConsumer));
    }

    public final Mono<Boolean> hasElement(T t10) {
        Objects.requireNonNull(t10, "value");
        d1 d1Var = new d1(1);
        d1Var.f10778f = t10;
        VarHandle.storeStoreFence();
        return any(d1Var);
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

    public final <I> Flux<I> index(BiFunction<? super Long, ? super T, ? extends I> biFunction) {
        return this instanceof Fuseable ? onAssembly(new FluxIndexFuseable(this, biFunction)) : onAssembly(new FluxIndex(this, biFunction));
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flux<R> join(qd.c cVar, Function<? super T, ? extends qd.c> function, Function<? super TRight, ? extends qd.c> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        return onAssembly(new FluxJoin(this, cVar, function, function2, biFunction));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last(T t10) throws Exception {
        if (this instanceof Callable) {
            Callable callable = (Callable) this;
            if (callable instanceof Fuseable.ScalarCallable) {
                try {
                    T tCall = ((Fuseable.ScalarCallable) callable).call();
                    return tCall == null ? Mono.just(t10) : Mono.just(tCall);
                } catch (Exception e10) {
                    return Mono.error(Exceptions.unwrap(e10));
                }
            }
            Mono.onAssembly(new MonoCallable(callable));
        }
        return Mono.onAssembly(new MonoTakeLastOne(this, t10));
    }

    public final Flux<T> limitRate(int i, int i3) {
        return onAssembly(publishOn(Schedulers.immediate(), true, i, i3));
    }

    @Deprecated
    public final Flux<T> limitRequest(long j10) {
        return take(j10, true);
    }

    public final Flux<T> log(Logger logger, Level level, boolean z10, SignalType... signalTypeArr) {
        o oVar = new o(0);
        oVar.f10829b = logger;
        VarHandle.storeStoreFence();
        SignalLogger signalLogger = new SignalLogger(this, "IGNORED", level, z10, oVar, signalTypeArr);
        return this instanceof Fuseable ? onAssembly(new FluxLogFuseable(this, signalLogger)) : onAssembly(new FluxLog(this, signalLogger));
    }

    public final <V> Flux<V> map(Function<? super T, ? extends V> function) {
        return this instanceof Fuseable ? onAssembly(new FluxMapFuseable(this, function)) : onAssembly(new FluxMap(this, function));
    }

    public final <V> Flux<V> mapNotNull(Function<? super T, ? extends V> function) {
        e0 e0Var = new e0(0);
        e0Var.f10780f = function;
        VarHandle.storeStoreFence();
        return (Flux<V>) handle(e0Var);
    }

    public final Flux<Signal<T>> materialize() {
        return onAssembly(new FluxMaterialize(this));
    }

    public final Flux<T> mergeComparingWith(qd.c cVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(cVar, comparator) : mergeComparing(comparator, this, cVar);
    }

    @Deprecated
    public final Flux<T> mergeOrderedWith(qd.c cVar, Comparator<? super T> comparator) {
        return this instanceof FluxMergeComparing ? ((FluxMergeComparing) this).mergeAdditionalSource(cVar, comparator) : mergeOrdered(comparator, this, cVar);
    }

    public final Flux<T> mergeWith(qd.c cVar) {
        return this instanceof FluxMerge ? ((FluxMerge) this).mergeAdditionalSource(cVar, new u(0)) : merge(this, cVar);
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

    public final <U> Flux<U> ofType(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz");
        h hVar = new h(1);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return filter(hVar).cast(cls);
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i, Consumer<? super T> consumer, Scheduler scheduler) {
        Objects.requireNonNull(duration, "ttl");
        Objects.requireNonNull(consumer, "onBufferEviction");
        return onAssembly(new FluxOnBackpressureBufferTimeout(this, duration, scheduler, i, consumer));
    }

    public final Flux<T> onBackpressureDrop() {
        return onAssembly(new FluxOnBackpressureDrop(this));
    }

    public final Flux<T> onBackpressureError() {
        return onBackpressureDrop(new o0(3));
    }

    public final Flux<T> onBackpressureLatest() {
        return onAssembly(new FluxOnBackpressureLatest(this));
    }

    public final Flux<T> onErrorComplete(Class<? extends Throwable> cls) {
        Objects.requireNonNull(cls, "type must not be null");
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return onErrorComplete(hVar);
    }

    public final <E extends Throwable> Flux<T> onErrorContinue(Class<E> cls, BiConsumer<Throwable, Object> biConsumer) {
        cls.getClass();
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return onErrorContinue(hVar, biConsumer);
    }

    public final <E extends Throwable> Flux<T> onErrorMap(Class<E> cls, Function<? super E, ? extends Throwable> function) {
        cls.getClass();
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return onErrorMap(hVar, function);
    }

    public final Flux<T> onErrorResume(Predicate<? super Throwable> predicate, Function<? super Throwable, ? extends qd.c> function) {
        Objects.requireNonNull(predicate, "predicate");
        v vVar = new v(0);
        vVar.f10867b = predicate;
        vVar.f10868c = function;
        VarHandle.storeStoreFence();
        return onErrorResume(vVar);
    }

    public final <E extends Throwable> Flux<T> onErrorReturn(Class<E> cls, T t10) {
        Objects.requireNonNull(cls, "type must not be null");
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return onErrorReturn((Predicate<? super Throwable>) hVar, (h) t10);
    }

    public final Flux<T> onErrorStop() {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.stop()));
    }

    public final Flux<T> onTerminateDetach() {
        return new FluxDetach(this);
    }

    public final Flux<T> or(qd.c cVar) {
        FluxFirstWithSignal<T> fluxFirstWithSignalOrAdditionalSource;
        return (!(this instanceof FluxFirstWithSignal) || (fluxFirstWithSignalOrAdditionalSource = ((FluxFirstWithSignal) this).orAdditionalSource(cVar)) == null) ? firstWithSignal(this, cVar) : fluxFirstWithSignalOrAdditionalSource;
    }

    public final ParallelFlux<T> parallel(int i, int i3) {
        return ParallelFlux.from(this, i, i3, Queues.get(i3));
    }

    public final ConnectableFlux<T> publish(int i) {
        return onAssembly((ConnectableFlux) new FluxPublish(this, i, Queues.get(i), true));
    }

    @Deprecated
    public final Mono<T> publishNext() {
        return shareNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i, int i3) {
        if (!(this instanceof Callable)) {
            return onAssembly(new FluxPublishOn(this, scheduler, z10, i, i3, Queues.get(i)));
        }
        if (this instanceof Fuseable.ScalarCallable) {
            try {
                return onAssembly(new FluxSubscribeOnValue(((Fuseable.ScalarCallable) this).call(), scheduler));
            } catch (Exception unused) {
            }
        }
        return onAssembly(new FluxSubscribeOnCallable((Callable) this, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> reduce(BiFunction<T, T, T> biFunction) {
        return this instanceof Callable ? Mono.onAssembly(wrapToMono((Callable) this)) : Mono.onAssembly(new MonoReduce(this, biFunction));
    }

    public final <A> Mono<A> reduceWith(Supplier<A> supplier, BiFunction<A, ? super T, A> biFunction) {
        return Mono.onAssembly(new MonoReduceSeed(this, supplier, biFunction));
    }

    public final Flux<T> repeat(long j10, BooleanSupplier booleanSupplier) {
        if (j10 < 0) {
            g5.f.s("numRepeat >= 0 required");
            return null;
        }
        if (j10 == 0) {
            return this;
        }
        q qVar = new q(0);
        qVar.f10842h = this;
        qVar.f10840f = booleanSupplier;
        qVar.f10841g = j10;
        VarHandle.storeStoreFence();
        return defer(qVar);
    }

    public final Flux<T> repeatWhen(Function<Flux<Long>, ? extends qd.c> function) {
        return onAssembly(new FluxRepeatWhen(this, function));
    }

    public final ConnectableFlux<T> replay(int i, Duration duration, Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "timer");
        if (i != 0) {
            return onAssembly((ConnectableFlux) new FluxReplay(this, i, duration.toNanos(), scheduler));
        }
        int i3 = Queues.SMALL_BUFFER_SIZE;
        return onAssembly((ConnectableFlux) new FluxPublish(this, i3, Queues.get(i3), true));
    }

    public final Flux<T> retry() {
        return retry(Long.MAX_VALUE);
    }

    public final Flux<T> retryWhen(Retry retry) {
        return onAssembly(new FluxRetryWhen(this, retry));
    }

    public final <U> Flux<T> sample(qd.c cVar) {
        return onAssembly(new FluxSample(this, cVar));
    }

    public final Flux<T> sampleFirst(Duration duration) {
        a1 a1Var = new a1(1);
        a1Var.f10760b = duration;
        VarHandle.storeStoreFence();
        return sampleFirst(a1Var);
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends qd.c> function, int i) {
        return onAssembly(new FluxSampleTimeout(this, function, Queues.get(i)));
    }

    public final <A> Flux<A> scan(A a10, BiFunction<A, ? super T, A> biFunction) {
        Objects.requireNonNull(a10, "seed");
        c0 c0Var = new c0(0);
        c0Var.f10769f = a10;
        VarHandle.storeStoreFence();
        return scanWith(c0Var, biFunction);
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

    public final Flux<T> skipLast(int i) {
        return i == 0 ? this : onAssembly(new FluxSkipLast(this, i));
    }

    public final Flux<T> skipUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxSkipUntil(this, predicate));
    }

    public final Flux<T> skipUntilOther(qd.c cVar) {
        return onAssembly(new FluxSkipUntilOther(this, cVar));
    }

    public final Flux<T> skipWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxSkipWhile(this, predicate));
    }

    public final Flux<T> sort() {
        return (Flux<T>) collectSortedList().flatMapIterable(identityFunction());
    }

    public final Flux<T> startWith(qd.c cVar) {
        return this instanceof FluxConcatArray ? ((FluxConcatArray) this).concatAdditionalSourceFirst(cVar) : concat(cVar, this);
    }

    @Override // reactor.core.CorePublisher, qd.c
    public final void subscribe(qd.d dVar) {
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

    @Override // reactor.core.CorePublisher
    public abstract void subscribe(CoreSubscriber<? super T> coreSubscriber);

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

    public final <E extends qd.d> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final Flux<T> switchIfEmpty(qd.c cVar) {
        return onAssembly(new FluxSwitchIfEmpty(this, cVar));
    }

    @Deprecated
    public final <V> Flux<V> switchMap(Function<? super T, qd.c> function, int i) {
        return i == 0 ? onAssembly(new FluxSwitchMapNoPrefetch(this, function)) : onAssembly(new FluxSwitchMap(this, function, Queues.unbounded(i), i));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, qd.c> biFunction, boolean z10) {
        return onAssembly(new FluxSwitchOnFirst(this, biFunction, z10));
    }

    public final Flux<T> tag(String str, String str2) {
        return FluxName.createOrAppend(this, str, str2);
    }

    public final Flux<T> take(long j10, boolean z10) {
        return z10 ? onAssembly(new FluxLimitRequest(this, j10)) : this instanceof Fuseable ? onAssembly(new FluxTakeFuseable(this, j10)) : onAssembly(new FluxTake(this, j10));
    }

    public final Flux<T> takeLast(int i) {
        return i == 1 ? onAssembly(new FluxTakeLastOne(this)) : onAssembly(new FluxTakeLast(this, i));
    }

    public final Flux<T> takeUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeUntil(this, predicate));
    }

    public final Flux<T> takeUntilOther(qd.c cVar) {
        return onAssembly(new FluxTakeUntilOther(this, cVar));
    }

    public final Flux<T> takeWhile(Predicate<? super T> predicate) {
        return onAssembly(new FluxTakeWhile(this, predicate));
    }

    public final Flux<T> tap(SignalListenerFactory<T, ?> signalListenerFactory) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? onAssembly(new FluxTapRestoringThreadLocals(this, signalListenerFactory)) : this instanceof Fuseable ? onAssembly(new FluxTapFuseable(this, signalListenerFactory)) : onAssembly(new FluxTap(this, signalListenerFactory));
    }

    public final <V> Mono<V> then(Mono<V> mono) {
        return Mono.onAssembly(new MonoIgnoreThen(new qd.c[]{this}, mono));
    }

    public final Mono<Void> thenEmpty(qd.c cVar) {
        return then(Mono.fromDirect(cVar));
    }

    public final <V> Flux<V> thenMany(qd.c cVar) {
        return concat(ignoreElements(), cVar);
    }

    public final Flux<Timed<T>> timed(Scheduler scheduler) {
        return onAssembly(new FluxTimed(this, scheduler));
    }

    public final Flux<T> timeout(Duration duration, @Nullable qd.c cVar, Scheduler scheduler) {
        Mono<Long> monoOnErrorReturn = Mono.delay(duration, scheduler).onErrorReturn(0L);
        j0 j0Var = new j0(1);
        j0Var.f10807b = monoOnErrorReturn;
        VarHandle.storeStoreFence();
        if (cVar != null) {
            return timeout(monoOnErrorReturn, j0Var, cVar);
        }
        return timeout(monoOnErrorReturn, j0Var, duration.toMillis() + "ms");
    }

    public final Flux<Tuple2<Long, T>> timestamp(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        g gVar = new g(0);
        gVar.f10793b = scheduler;
        VarHandle.storeStoreFence();
        return (Flux<Tuple2<Long, T>>) map(gVar);
    }

    public final Iterable<T> toIterable(int i, @Nullable Supplier<Queue<T>> supplier) {
        Supplier supplier2;
        if (supplier == null) {
            supplier2 = Queues.get(i);
        } else {
            d0 d0Var = new d0(0);
            d0Var.f10776f = supplier;
            VarHandle.storeStoreFence();
            supplier2 = d0Var;
        }
        return new BlockingIterable(this, i, supplier2, ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new b(1) : new b(4));
    }

    public final Stream<T> toStream(int i) {
        return new BlockingIterable(this, i, Queues.get(i), ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? new b(1) : new b(4)).stream();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final <V> Flux<V> transform(Function<? super Flux<T>, ? extends qd.c> function) {
        if (Hooks.DETECT_CONTEXT_LOSS) {
            function = new ContextTrackingFunctionWrapper(function);
        }
        return onAssembly(from(function.apply(this)));
    }

    public final <V> Flux<V> transformDeferred(Function<? super Flux<T>, ? extends qd.c> function) {
        f0 f0Var = new f0(0);
        f0Var.f10788g = this;
        f0Var.f10787f = function;
        VarHandle.storeStoreFence();
        return defer(f0Var);
    }

    public final <V> Flux<V> transformDeferredContextual(BiFunction<? super Flux<T>, ? super ContextView, ? extends qd.c> biFunction) {
        m mVar = new m(0);
        mVar.f10823c = this;
        mVar.f10822b = biFunction;
        VarHandle.storeStoreFence();
        return deferContextual(mVar);
    }

    public final Flux<Flux<T>> window(Duration duration, Duration duration2, Scheduler scheduler) {
        if (duration2.equals(duration)) {
            return window(duration);
        }
        Flux<Long> fluxInterval = interval(Duration.ZERO, duration2, scheduler);
        p pVar = new p(1);
        pVar.f10835b = duration;
        pVar.f10836c = scheduler;
        VarHandle.storeStoreFence();
        return windowWhen(fluxInterval, pVar);
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, Scheduler scheduler, boolean z10) {
        return onAssembly(new FluxWindowTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, z10));
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10, int i) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i), Queues.unbounded(i), i, predicate, z10 ? FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE : FluxBufferPredicate.Mode.UNTIL));
    }

    public final <V> Flux<Flux<T>> windowUntilChanged(Function<? super T, ? extends V> function, BiPredicate<? super V, ? super V> biPredicate) {
        r rVar = new r(1);
        rVar.f10847f = this;
        rVar.f10848g = function;
        rVar.f10849h = biPredicate;
        VarHandle.storeStoreFence();
        return defer(rVar);
    }

    public final <U, V> Flux<Flux<T>> windowWhen(qd.c cVar, Function<? super U, ? extends qd.c> function) {
        return onAssembly(new FluxWindowWhen(this, cVar, function, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate, int i) {
        return onAssembly(new FluxWindowPredicate(this, Queues.unbounded(i), Queues.unbounded(i), i, predicate, FluxBufferPredicate.Mode.WHILE));
    }

    public final <U, R> Flux<R> withLatestFrom(qd.c cVar, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return onAssembly(new FluxWithLatestFrom(this, cVar, biFunction));
    }

    public final <T2, V> Flux<V> zipWith(qd.c cVar, int i, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        l lVar = new l(0);
        lVar.f10815b = biFunction;
        VarHandle.storeStoreFence();
        return zip(lVar, i, this, cVar);
    }

    public final <T2, V> Flux<V> zipWithIterable(Iterable<? extends T2> iterable, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        return onAssembly(new FluxZipIterable(this, iterable, biFunction));
    }

    @Deprecated
    public static <I> Flux<I> first(Iterable<? extends qd.c> iterable) {
        return firstWithSignal(iterable);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequentialDelayError(int i, qd.c... cVarArr) {
        return mergeSequential(i, true, cVarArr);
    }

    public static <I> Flux<I> mergeSequentialDelayError(Iterable<? extends qd.c> iterable, int i, int i3) {
        return mergeSequential(iterable, true, i, i3);
    }

    public final Flux<T> cache() {
        return cache(Reader.READ_DONE);
    }

    public final ParallelFlux<T> parallel(int i) {
        return parallel(i, Queues.SMALL_BUFFER_SIZE);
    }

    public static <I> Flux<I> firstWithSignal(Iterable<? extends qd.c> iterable) {
        return onAssembly(new FluxFirstWithSignal(iterable));
    }

    @SafeVarargs
    public static <T> Flux<T> just(T... tArr) {
        return fromArray(tArr);
    }

    public static <T, D> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qd.c> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public final Flux<T> cache(Duration duration) {
        return cache(duration, Schedulers.parallel());
    }

    public final <R, A> Mono<R> collect(Collector<? super T, A, ? extends R> collector) {
        return Mono.onAssembly(new MonoStreamCollector(this, collector));
    }

    public final Flux<T> delaySequence(Duration duration) {
        return delaySequence(duration, Schedulers.parallel());
    }

    public final Flux<T> delaySubscription(Duration duration, Scheduler scheduler) {
        return delaySubscription(Mono.delay(duration, scheduler));
    }

    public final <V> Flux<T> distinctUntilChanged(Function<? super T, ? extends V> function) {
        return distinctUntilChanged(function, equalPredicate());
    }

    public final Flux<T> filterWhen(Function<? super T, ? extends qd.c> function) {
        return filterWhen(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> onBackpressureDrop(Consumer<? super T> consumer) {
        return onAssembly(new FluxOnBackpressureDrop(this, consumer));
    }

    public final ParallelFlux<T> parallel() {
        return parallel(Schedulers.DEFAULT_POOL_SIZE);
    }

    public final Flux<T> retry(long j10) {
        return onAssembly(new FluxRetry(this, j10));
    }

    public final Flux<T> sample(Duration duration) {
        return sample(interval(duration));
    }

    public final <V> Flux<V> switchOnFirst(BiFunction<Signal<? extends T>, Flux<T>, qd.c> biFunction) {
        return switchOnFirst(biFunction, true);
    }

    public final Flux<Timed<T>> timed() {
        return timed(Schedulers.parallel());
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWithIterable(Iterable<? extends T2> iterable) {
        return (Flux<Tuple2<T, T2>>) zipWithIterable(iterable, tuple2Function());
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qd.c> function) {
        return using((Callable) callable, (Function) function, true);
    }

    public final Flux<T> cache(Duration duration, Scheduler scheduler) {
        return cache(Reader.READ_DONE, duration, scheduler);
    }

    public final Flux<T> delaySubscription(Duration duration) {
        return delaySubscription(duration, Schedulers.parallel());
    }

    public final Flux<T> distinctUntilChanged() {
        return distinctUntilChanged(identityFunction());
    }

    public final Mono<T> elementAt(int i, T t10) {
        return Mono.onAssembly(new MonoElementAt(this, i, t10));
    }

    public final Flux<T> expand(Function<? super T, ? extends qd.c> function) {
        return expand(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qd.c> function) {
        return expandDeep(function, Queues.SMALL_BUFFER_SIZE);
    }

    public static <T> Flux<T> create(Consumer<? super FluxSink<T>> consumer) {
        return create(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static <T> Flux<T> push(Consumer<? super FluxSink<T>> consumer) {
        return push(consumer, FluxSink.OverflowStrategy.BUFFER);
    }

    public static <T, D extends AutoCloseable> Flux<T> using(Callable<? extends D> callable, Function<? super D, ? extends qd.c> function, boolean z10) {
        return using(callable, function, Exceptions.AUTO_CLOSE, z10);
    }

    public final Flux<T> cache(int i, Duration duration) {
        return cache(i, duration, Schedulers.parallel());
    }

    public static <T> Flux<T> concat(qd.c cVar) {
        return concat(cVar, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> concatDelayError(qd.c cVar) {
        return concatDelayError(cVar, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> cache(int i, Duration duration, Scheduler scheduler) {
        return replay(i, duration, scheduler).autoConnect();
    }

    public final Flux<T> sort(Comparator<? super T> comparator) {
        return (Flux<T>) collectSortedList(comparator).flatMapIterable(identityFunction());
    }

    public static <T> Flux<T> concat(Iterable<? extends qd.c> iterable) {
        return onAssembly(new FluxConcatIterable(iterable));
    }

    public static <T> Flux<T> concatDelayError(qd.c cVar, boolean z10, int i) {
        return from(cVar).concatMapDelayError(identityFunction(), z10, i);
    }

    public final <R> Flux<R> concatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return concatMapIterable(function, Queues.XS_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return flatMapIterable(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> limitRate(int i) {
        return onAssembly(publishOn(Schedulers.immediate(), i));
    }

    public final <U> Flux<T> sampleTimeout(Function<? super T, ? extends qd.c> function) {
        return sampleTimeout(function, Queues.XS_BUFFER_SIZE);
    }

    @SafeVarargs
    public static <T> Flux<T> concat(qd.c... cVarArr) {
        return onAssembly(new FluxConcatArray(false, cVarArr));
    }

    @SafeVarargs
    public static <T> Flux<T> concatDelayError(qd.c... cVarArr) {
        return onAssembly(new FluxConcatArray(true, cVarArr));
    }

    public static <T, S> Flux<T> generate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction) {
        return onAssembly(new FluxGenerate(callable, biFunction));
    }

    public final Flux<Tuple2<Long, T>> elapsed() {
        return elapsed(Schedulers.parallel());
    }

    public final ConnectableFlux<T> publish() {
        return publish(Queues.SMALL_BUFFER_SIZE);
    }

    private final Flux<T> contextWriteSkippingContextPropagation(Function<Context, Context> function) {
        return onAssembly(new FluxContextWrite(this, function));
    }

    public static <T, S> Flux<T> generate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction, Consumer<? super S> consumer) {
        return onAssembly(new FluxGenerate(callable, biFunction, consumer));
    }

    public static <T, D> Flux<T> usingWhen(qd.c cVar, Function<? super D, ? extends qd.c> function, Function<? super D, ? extends qd.c> function2, BiFunction<? super D, ? super Throwable, ? extends qd.c> biFunction, Function<? super D, ? extends qd.c> function3) {
        return onAssembly(new FluxUsingWhen(cVar, function, function2, biFunction, function3));
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends qd.c> function) {
        return publish(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <U> Flux<T> sampleFirst(Function<? super T, ? extends qd.c> function) {
        return onAssembly(new FluxSampleFirst(this, function));
    }

    public final Mono<Void> then() {
        return Mono.onAssembly(new MonoIgnoreElements(this));
    }

    public final <R> Flux<R> publish(Function<? super Flux<T>, ? extends qd.c> function, int i) {
        return onAssembly(new FluxPublishMulticast(this, function, i, Queues.get(i)));
    }

    public final Flux<T> skip(Duration duration) {
        return skip(duration, Schedulers.parallel());
    }

    public final Flux<T> delayElements(Duration duration) {
        return delayElements(duration, Schedulers.parallel());
    }

    public final Flux<T> skip(Duration duration, Scheduler scheduler) {
        return !duration.isZero() ? skipUntilOther(Mono.delay(duration, scheduler)) : this;
    }

    public final Flux<T> onErrorContinue(BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resume(biConsumer)));
    }

    public final Flux<T> onErrorMap(Function<? super Throwable, ? extends Throwable> function) {
        s sVar = new s(3);
        sVar.f10854b = function;
        VarHandle.storeStoreFence();
        return onErrorResume(sVar);
    }

    public final <V> Flux<List<T>> bufferUntilChanged(Function<? super T, ? extends V> function) {
        return bufferUntilChanged(function, equalPredicate());
    }

    public final <U, V> Flux<List<T>> bufferWhen(qd.c cVar, Function<? super U, ? extends qd.c> function) {
        return (Flux<List<T>>) bufferWhen(cVar, function, listSupplier());
    }

    public final Mono<List<T>> collectSortedList() {
        return collectSortedList(null);
    }

    public final Flux<T> onErrorMap(Predicate<? super Throwable> predicate, Function<? super Throwable, ? extends Throwable> function) {
        s sVar = new s(6);
        sVar.f10854b = function;
        VarHandle.storeStoreFence();
        return onErrorResume(predicate, sVar);
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, boolean z10) {
        return windowTimeout(i, duration, Schedulers.parallel(), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <V> Flux<Flux<T>> windowUntilChanged(Function<? super T, ? super V> function) {
        return windowUntilChanged(function, equalPredicate());
    }

    public static Flux<Long> interval(Duration duration, Duration duration2) {
        return interval(duration, duration2, Schedulers.parallel());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Supplier<C> supplier) {
        return bufferTimeout(i, duration, Schedulers.parallel(), supplier);
    }

    public final Flux<List<T>> bufferUntil(Predicate<? super T> predicate) {
        return onAssembly(new FluxBufferPredicate(this, predicate, listSupplier(), FluxBufferPredicate.Mode.UNTIL));
    }

    public final Flux<List<T>> bufferUntilChanged() {
        return bufferUntilChanged(identityFunction());
    }

    public final Flux<T> onErrorComplete() {
        return onAssembly(new FluxOnErrorReturn(this, null, null));
    }

    public final Flux<T> onErrorReturn(T t10) {
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, null, t10));
    }

    public final Flux<T> scan(BiFunction<T, T, T> biFunction) {
        return onAssembly(new FluxScan(this, biFunction));
    }

    public final Flux<Tuple2<Long, T>> timestamp() {
        return timestamp(Schedulers.parallel());
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration, Scheduler scheduler) {
        return windowTimeout(i, duration, scheduler, false);
    }

    public final Flux<Flux<T>> windowUntilChanged() {
        return windowUntilChanged(identityFunction());
    }

    public static <T> Flux<T> error(Supplier<? extends Throwable> supplier) {
        return onAssembly(new FluxErrorSupplied(supplier));
    }

    public static Flux<Long> interval(Duration duration, Scheduler scheduler) {
        return interval(duration, duration, scheduler);
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, Scheduler scheduler) {
        return (Flux<List<T>>) bufferTimeout(i, duration, scheduler, listSupplier());
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function, int i) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction(), i);
    }

    public final Flux<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        return onAssembly(new FluxOnErrorReturn(this, predicate, null));
    }

    public final <E extends Throwable> Flux<T> onErrorContinue(Predicate<E> predicate, BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resumeIf(predicate, biConsumer)));
    }

    public final Flux<Flux<T>> windowTimeout(int i, Duration duration) {
        return windowTimeout(i, duration, Schedulers.parallel());
    }

    public static <T> Flux<T> error(Throwable th) {
        return error(th, false);
    }

    public static Flux<Long> interval(Duration duration) {
        return interval(duration, Schedulers.parallel());
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration) {
        return (Flux<List<T>>) bufferTimeout(i, duration, listSupplier());
    }

    public final <E extends Throwable> Flux<T> doOnError(Class<E> cls, Consumer<? super E> consumer) {
        Objects.requireNonNull(cls, "type");
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return doOnError(hVar, consumer);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qd.c> function, int i) {
        return flatMapSequential(function, i, Queues.XS_BUFFER_SIZE);
    }

    public final <K, V> Flux<GroupedFlux<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, Queues.SMALL_BUFFER_SIZE);
    }

    public final <E extends Throwable> Flux<T> onErrorResume(Class<E> cls, Function<? super E, ? extends qd.c> function) {
        Objects.requireNonNull(cls, "type");
        h hVar = new h(0);
        hVar.f10797f = cls;
        VarHandle.storeStoreFence();
        return onErrorResume(hVar, function);
    }

    public final Flux<T> onErrorReturn(Predicate<? super Throwable> predicate, T t10) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new FluxOnErrorReturn(this, predicate, t10));
    }

    public final Flux<Flux<T>> windowWhile(Predicate<T> predicate) {
        return windowWhile(predicate, Queues.SMALL_BUFFER_SIZE);
    }

    public static <I> Flux<I> firstWithValue(Iterable<? extends qd.c> iterable) {
        return onAssembly(new FluxFirstWithValue(iterable));
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i, duration, Schedulers.parallel(), listSupplier(), z10);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qd.c> function, int i, int i3) {
        return flatMapSequential(function, false, i, i3);
    }

    public final <K> Flux<GroupedFlux<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Flux<GroupedFlux<K, T>>) groupBy(function, identityFunction());
    }

    public final Flux<Tuple2<Long, T>> index() {
        return (Flux<Tuple2<Long, T>>) index(tuple2Function());
    }

    public final <T2, V> Flux<V> zipWith(qd.c cVar, BiFunction<? super T, ? super T2, ? extends V> biFunction) {
        FluxZip fluxZipZipAdditionalSource;
        return (!(this instanceof FluxZip) || (fluxZipZipAdditionalSource = ((FluxZip) this).zipAdditionalSource(cVar, biFunction)) == null) ? zip(this, cVar, biFunction) : fluxZipZipAdditionalSource;
    }

    public final Flux<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError");
        return doOnSignal(this, null, null, consumer, null, null, null, null);
    }

    public final <R> Flux<R> flatMapSequential(Function<? super T, ? extends qd.c> function) {
        return flatMapSequential(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> onBackpressureBuffer(int i) {
        return onAssembly(new FluxOnBackpressureBuffer(this, i, false, null));
    }

    public final Flux<T> onErrorResume(Function<? super Throwable, ? extends qd.c> function) {
        return onAssembly(new FluxOnErrorResume(this, function));
    }

    public final <A> Mono<A> reduce(A a10, BiFunction<A, ? super T, A> biFunction) {
        c0 c0Var = new c0(1);
        c0Var.f10769f = a10;
        VarHandle.storeStoreFence();
        return reduceWith(c0Var, biFunction);
    }

    @SafeVarargs
    public final Flux<T> startWith(T... tArr) {
        return startWith(just((Object[]) tArr));
    }

    public static <T> Flux<T> fromStream(Supplier<Stream<? extends T>> supplier) {
        return onAssembly(new FluxStream(supplier));
    }

    public final Flux<T> contextWrite(ContextView contextView) {
        n nVar = new n(1);
        nVar.f10827b = contextView;
        VarHandle.storeStoreFence();
        return contextWrite(nVar);
    }

    public final Flux<T> onBackpressureBuffer(int i, Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onOverflow");
        return onAssembly(new FluxOnBackpressureBuffer(this, i, false, consumer));
    }

    public final Flux<T> startWith(Iterable<? extends T> iterable) {
        return startWith(fromIterable(iterable));
    }

    public final <V> Flux<V> switchMap(Function<? super T, qd.c> function) {
        return onAssembly(new FluxSwitchMapNoPrefetch(this, function));
    }

    public final Flux<List<T>> bufferTimeout(int i, Duration duration, Scheduler scheduler, boolean z10) {
        return (Flux<List<T>>) bufferTimeout(i, duration, scheduler, listSupplier(), z10);
    }

    public final Flux<T> checkpoint(String str) {
        Objects.requireNonNull(str);
        return checkpoint(str, false);
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Supplier<C> supplier, boolean z10) {
        return bufferTimeout(i, duration, Schedulers.parallel(), supplier, z10);
    }

    public final Flux<T> checkpoint() {
        return checkpoint(null, true);
    }

    public final Flux<T> onBackpressureBuffer(int i, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i, null, bufferOverflowStrategy));
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(qd.c cVar) {
        return (Flux<Tuple2<T, T2>>) zipWith(cVar, tuple2Function());
    }

    public final <C extends Collection<? super T>> Flux<C> bufferTimeout(int i, Duration duration, Scheduler scheduler, Supplier<C> supplier, boolean z10) {
        return onAssembly(new FluxBufferTimeout(this, i, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler, supplier, z10));
    }

    public final <T2> Flux<Tuple2<T, T2>> zipWith(qd.c cVar, int i) {
        return (Flux<Tuple2<T, T2>>) zipWith(cVar, i, tuple2Function());
    }

    public final Flux<T> onBackpressureBuffer(int i, Consumer<? super T> consumer, BufferOverflowStrategy bufferOverflowStrategy) {
        Objects.requireNonNull(consumer, "onBufferOverflow");
        Objects.requireNonNull(bufferOverflowStrategy, "bufferOverflowStrategy");
        return onAssembly(new FluxOnBackpressureBufferStrategy(this, i, consumer, bufferOverflowStrategy));
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate, boolean z10) {
        return windowUntil(predicate, z10, Queues.SMALL_BUFFER_SIZE);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qd.c> function, int i) {
        return flatMap(function, i, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<Flux<T>> windowUntil(Predicate<T> predicate) {
        return windowUntil(predicate, false);
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qd.c> function, int i, int i3) {
        return flatMap(function, false, i, i3);
    }

    public final <K, V> Mono<Map<K, V>> collectMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMap(function, function2, new b(5));
    }

    public final <K, V> Mono<Map<K, Collection<V>>> collectMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return collectMultimap(function, function2, new b(6));
    }

    public final <V> Flux<V> concatMap(Function<? super T, ? extends qd.c> function) {
        return onAssembly(new FluxConcatMapNoPrefetch(this, function, FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final <R> Flux<R> flatMap(Function<? super T, ? extends qd.c> function) {
        return (Flux<R>) flatMap(function, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> onBackpressureBuffer(Duration duration, int i, Consumer<? super T> consumer) {
        return onBackpressureBuffer(duration, i, consumer, Schedulers.parallel());
    }

    public final Stream<T> toStream() {
        return toStream(Queues.SMALL_BUFFER_SIZE);
    }

    @Nullable
    public final T blockFirst() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qd.d) blockingFirstSubscriber);
        return blockingFirstSubscriber.blockingGet();
    }

    @Nullable
    public final T blockLast() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qd.d) blockingLastSubscriber);
        return blockingLastSubscriber.blockingGet();
    }

    public final <K> Mono<Map<K, T>> collectMap(Function<? super T, ? extends K> function) {
        return (Mono<Map<K, T>>) collectMap(function, identityFunction());
    }

    public final <K> Mono<Map<K, Collection<T>>> collectMultimap(Function<? super T, ? extends K> function) {
        return (Mono<Map<K, Collection<T>>>) collectMultimap(function, identityFunction());
    }

    public final <V> Flux<T> distinct(Function<? super T, ? extends V> function) {
        return distinct(function, hashSetSupplier());
    }

    public final <V> Flux<V> flatMap(Function<? super T, ? extends qd.c> function, boolean z10, int i, int i3) {
        return onAssembly(new FluxFlatMap(this, function, z10, i, Queues.get(i), i3, Queues.get(i3)));
    }

    public final Flux<T> onBackpressureBuffer() {
        return onAssembly(new FluxOnBackpressureBuffer(this, Queues.SMALL_BUFFER_SIZE, true, null));
    }

    @SafeVarargs
    public static <T> Flux<T> mergeComparing(Comparator<? super T> comparator, qd.c... cVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <T> Flux<T> mergeOrdered(Comparator<? super T> comparator, qd.c... cVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    @SafeVarargs
    public static <T> Flux<T> mergePriority(Comparator<? super T> comparator, qd.c... cVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, comparator, cVarArr);
    }

    public static <T> ConnectableFlux<T> onAssembly(ConnectableFlux<T> connectableFlux) {
        Function<qd.c, qd.c> function = Hooks.onEachOperatorHook;
        if (function != null) {
            connectableFlux = (ConnectableFlux) function.apply(connectableFlux);
        }
        return Hooks.GLOBAL_TRACE ? (ConnectableFlux) Hooks.addAssemblyInfo(connectableFlux, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : connectableFlux;
    }

    public final Flux<List<T>> buffer(int i) {
        return (Flux<List<T>>) buffer(i, listSupplier());
    }

    public final <V, C extends Collection<? super V>> Flux<T> distinct(Function<? super T, ? extends V> function, Supplier<C> supplier) {
        return distinct(function, supplier, new k(1), new o0(4));
    }

    public final Flux<Flux<T>> window(int i, int i3) {
        int i10 = Queues.XS_BUFFER_SIZE;
        return onAssembly(new FluxWindow(this, i, i3, Queues.unbounded(i10), Queues.unbounded(i10)));
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergeComparing(qd.c... cVarArr) {
        return mergeComparing(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    @SafeVarargs
    @Deprecated
    public static <I extends Comparable<? super I>> Flux<I> mergeOrdered(qd.c... cVarArr) {
        return mergeOrdered(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    @SafeVarargs
    public static <I extends Comparable<? super I>> Flux<I> mergePriority(qd.c... cVarArr) {
        return mergePriority(Queues.SMALL_BUFFER_SIZE, Comparator.naturalOrder(), cVarArr);
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i, supplier));
    }

    public final Flux<T> distinct() {
        return distinct(identityFunction());
    }

    public final Flux<T> repeat(BooleanSupplier booleanSupplier) {
        return onAssembly(new FluxRepeatPredicate(this, booleanSupplier));
    }

    public final Flux<T> take(long j10) {
        return take(j10, true);
    }

    public final Flux<List<T>> buffer(int i, int i3) {
        return (Flux<List<T>>) buffer(i, i3, listSupplier());
    }

    public final Flux<T> repeat(long j10) {
        return j10 == 0 ? this : onAssembly(new FluxRepeat(this, j10));
    }

    public final Flux<T> take(Duration duration) {
        return take(duration, Schedulers.parallel());
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(int i, int i3, Supplier<C> supplier) {
        return onAssembly(new FluxBuffer(this, i, i3, supplier));
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qd.c> function, int i) {
        return concatMapDelayError(function, true, i);
    }

    public final Flux<T> repeat() {
        return repeat(ALWAYS_BOOLEAN_SUPPLIER);
    }

    public final Flux<T> take(Duration duration, Scheduler scheduler) {
        if (!duration.isZero()) {
            return takeUntilOther(Mono.delay(duration, scheduler));
        }
        return take(0L, false);
    }

    public final Flux<List<T>> buffer(qd.c cVar) {
        return (Flux<List<T>>) buffer(cVar, listSupplier());
    }

    public final <V> Flux<V> concatMapDelayError(Function<? super T, ? extends qd.c> function) {
        return concatMapDelayError(function, 0);
    }

    public final Flux<Flux<T>> window(qd.c cVar) {
        return onAssembly(new FluxWindowBoundary(this, cVar, Queues.unbounded(Queues.XS_BUFFER_SIZE)));
    }

    public final <C extends Collection<? super T>> Flux<C> buffer(qd.c cVar, Supplier<C> supplier) {
        return onAssembly(new FluxBufferBoundary(this, cVar, supplier));
    }

    public final Flux<T> tap(final Function<ContextView, SignalListener<T>> function) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.3
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(qd.c cVar, ContextView contextView, Void r32) {
                return (SignalListener) function.apply(contextView);
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(qd.c cVar) {
                return null;
            }
        });
    }

    public final Flux<List<T>> buffer(Duration duration) {
        return buffer(duration, Schedulers.parallel());
    }

    public final ConnectableFlux<T> replay(int i) {
        if (i == 0) {
            int i3 = Queues.SMALL_BUFFER_SIZE;
            return onAssembly((ConnectableFlux) new FluxPublish(this, i3, Queues.get(i3), false));
        }
        return onAssembly((ConnectableFlux) new FluxReplay(this, i, 0L, null));
    }

    public final Flux<T> tap(final Supplier<SignalListener<T>> supplier) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Flux.2
            @Override // reactor.core.observability.SignalListenerFactory
            public SignalListener<T> createListener(qd.c cVar, ContextView contextView, Void r32) {
                return (SignalListener) supplier.get();
            }

            @Override // reactor.core.observability.SignalListenerFactory
            public Void initializePublisherState(qd.c cVar) {
                return null;
            }
        });
    }

    public static <T> Flux<T> switchOnNext(qd.c cVar) {
        return onAssembly(new FluxSwitchMapNoPrefetch(from(cVar), identityFunction()));
    }

    public final Flux<List<T>> buffer(Duration duration, Duration duration2) {
        return buffer(duration, duration2, Schedulers.parallel());
    }

    public final Flux<Flux<T>> window(Duration duration) {
        return window(duration, Schedulers.parallel());
    }

    public static <T> Flux<T> merge(qd.c cVar, int i) {
        return merge(cVar, i, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<List<T>> buffer(Duration duration, Scheduler scheduler) {
        return buffer(interval(duration, scheduler));
    }

    public final Flux<Flux<T>> window(Duration duration, Duration duration2) {
        return window(duration, duration2, Schedulers.parallel());
    }

    public static <T> Flux<T> merge(qd.c cVar, int i, int i3) {
        return onAssembly(new FluxFlatMap(from(cVar), identityFunction(), false, i, Queues.get(i), i3, Queues.get(i3)));
    }

    public final Flux<List<T>> buffer() {
        return buffer(Reader.READ_DONE);
    }

    public final Iterable<T> toIterable(int i) {
        return toIterable(i, null);
    }

    public final Flux<Flux<T>> window(Duration duration, Scheduler scheduler) {
        return window(interval(duration, scheduler));
    }

    public final ConnectableFlux<T> replay(Duration duration) {
        return replay(Reader.READ_DONE, duration);
    }

    public final Iterable<T> toIterable() {
        return toIterable(Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<Flux<T>> window(int i) {
        return onAssembly(new FluxWindow(this, i, Queues.get(i)));
    }

    public final Flux<T> log(String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final ConnectableFlux<T> replay(int i, Duration duration) {
        return replay(i, duration, Schedulers.parallel());
    }

    public final Flux<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final ConnectableFlux<T> replay(Duration duration, Scheduler scheduler) {
        return replay(Reader.READ_DONE, duration, scheduler);
    }

    public final Flux<T> subscribeOn(Scheduler scheduler) {
        return subscribeOn(scheduler, true);
    }

    public final Flux<T> log(@Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, str, level, z10, signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new FluxLogFuseable(this, signalLogger));
        }
        return onAssembly(new FluxLog(this, signalLogger));
    }

    public final ConnectableFlux<T> replay() {
        return replay(Reader.READ_DONE);
    }

    public static <I> Flux<I> merge(Iterable<? extends qd.c> iterable) {
        return merge(fromIterable(iterable));
    }

    public static <T> Flux<T> mergeSequential(qd.c cVar, int i, int i3) {
        return mergeSequential(cVar, false, i, i3);
    }

    @SafeVarargs
    public static <I> Flux<I> merge(qd.c... cVarArr) {
        return merge(Queues.XS_BUFFER_SIZE, cVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(qd.c... cVarArr) {
        return mergeSequential(Queues.XS_BUFFER_SIZE, false, cVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> merge(int i, qd.c... cVarArr) {
        return merge(i, false, cVarArr);
    }

    @SafeVarargs
    public static <I> Flux<I> mergeSequential(int i, qd.c... cVarArr) {
        return mergeSequential(i, false, cVarArr);
    }

    public final Flux<T> log(Logger logger) {
        return log(logger, Level.INFO, false, new SignalType[0]);
    }

    public static <T> Flux<T> merge(qd.c cVar) {
        return merge(cVar, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qd.c> iterable) {
        return mergeSequential(iterable, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public final Flux<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qd.c> iterable, int i, int i3) {
        return mergeSequential(iterable, false, i, i3);
    }

    public static <T> Flux<T> mergeSequential(qd.c cVar) {
        return mergeSequential(cVar, false, Queues.SMALL_BUFFER_SIZE, Queues.XS_BUFFER_SIZE);
    }

    public static <T> Flux<T> mergeSequential(qd.c cVar, boolean z10, int i, int i3) {
        return onAssembly(new FluxMergeSequential(from(cVar), identityFunction(), i, i3, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final Flux<T> publishOn(Scheduler scheduler, int i) {
        return publishOn(scheduler, true, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> last() throws Exception {
        if (this instanceof Callable) {
            Mono monoWrapToMono = wrapToMono((Callable) this);
            if (monoWrapToMono == Mono.empty()) {
                return Mono.onAssembly(new MonoError(new NoSuchElementException("Flux#last() didn't observe any onNext signal from Callable flux")));
            }
            return Mono.onAssembly(monoWrapToMono);
        }
        return Mono.onAssembly(new MonoTakeLastOne(this));
    }

    public final Flux<T> publishOn(Scheduler scheduler, boolean z10, int i) {
        return publishOn(scheduler, z10, i, i);
    }

    public final Flux<T> publishOn(Scheduler scheduler) {
        return publishOn(scheduler, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> timeout(Duration duration, @Nullable qd.c cVar) {
        return timeout(duration, cVar, Schedulers.parallel());
    }

    public static <I> Flux<I> mergeSequential(Iterable<? extends qd.c> iterable, boolean z10, int i, int i3) {
        return onAssembly(new FluxMergeSequential(new FluxIterable(iterable), identityFunction(), i, i3, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.IMMEDIATE));
    }

    public final Flux<T> timeout(Duration duration, Scheduler scheduler) {
        return timeout(duration, (qd.c) null, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$fromStream$3(Stream stream) {
        return stream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$reduce$31(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$scan$34(Object obj) {
        return obj;
    }

    public final Flux<T> timeout(Duration duration) {
        return timeout(duration, (qd.c) null, Schedulers.parallel());
    }

    public final <U> Flux<T> timeout(qd.c cVar) {
        return timeout(cVar, new a(14));
    }

    public final <U, V> Flux<T> timeout(qd.c cVar, Function<? super T, ? extends qd.c> function) {
        return timeout(cVar, function, "first signal from a Publisher");
    }

    private <U, V> Flux<T> timeout(qd.c cVar, Function<? super T, ? extends qd.c> function, String str) {
        return onAssembly(new FluxTimeout(this, cVar, function, str));
    }

    public final <U, V> Flux<T> timeout(qd.c cVar, Function<? super T, ? extends qd.c> function, qd.c cVar2) {
        return onAssembly(new FluxTimeout(this, cVar, function, cVar2));
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

    public final Disposable subscribe() {
        return subscribe(null, null, null);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return subscribe(consumer, null, null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer2, "errorConsumer");
        return subscribe(consumer, consumer2, null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable) {
        return subscribe(consumer, consumer2, runnable, (Context) null);
    }

    @Deprecated
    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qd.e> consumer3) {
        return (Disposable) subscribeWith(new LambdaSubscriber(consumer, consumer2, runnable, consumer3, null));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Context context) {
        return (Disposable) subscribeWith(new LambdaSubscriber(consumer, consumer2, runnable, null, context));
    }

    public static <T1, T2> Flux<Tuple2<T1, T2>> zip(qd.c cVar, qd.c cVar2) {
        return zip(cVar, cVar2, tuple2Function());
    }

    @SafeVarargs
    public static <T, V> Flux<V> combineLatest(Function<Object[], V> function, qd.c... cVarArr) {
        return combineLatest(function, Queues.XS_BUFFER_SIZE, cVarArr);
    }

    public static <T1, T2, T3> Flux<Tuple3<T1, T2, T3>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3) {
        return zip(Tuples.fn3(), cVar, cVar2, cVar3);
    }

    public static <T1, T2, V> Flux<V> combineLatest(qd.c cVar, qd.c cVar2, BiFunction<? super T1, ? super T2, ? extends V> biFunction) {
        l lVar = new l(1);
        lVar.f10815b = biFunction;
        VarHandle.storeStoreFence();
        return combineLatest(lVar, cVar, cVar2);
    }

    public static <T1, T2, T3, T4> Flux<Tuple4<T1, T2, T3, T4>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4) {
        return zip(Tuples.fn4(), cVar, cVar2, cVar3, cVar4);
    }

    public static <T1, T2, T3, V> Flux<V> combineLatest(qd.c cVar, qd.c cVar2, qd.c cVar3, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3);
    }

    public static <T1, T2, T3, T4, T5> Flux<Tuple5<T1, T2, T3, T4, T5>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5) {
        return zip(Tuples.fn5(), cVar, cVar2, cVar3, cVar4, cVar5);
    }

    public static <T1, T2, T3, T4, V> Flux<V> combineLatest(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4);
    }

    public static <T1, T2, T3, T4, T5, T6> Flux<Tuple6<T1, T2, T3, T4, T5, T6>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5, qd.c cVar6) {
        return zip(Tuples.fn6(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    public static <T1, T2, T3, T4, T5, V> Flux<V> combineLatest(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4, cVar5);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Flux<Tuple7<T1, T2, T3, T4, T5, T6, T7>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5, qd.c cVar6, qd.c cVar7) {
        return zip(Tuples.fn7(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7);
    }

    public static <T1, T2, T3, T4, T5, T6, V> Flux<V> combineLatest(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5, qd.c cVar6, Function<Object[], V> function) {
        return combineLatest(function, cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Flux<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> zip(qd.c cVar, qd.c cVar2, qd.c cVar3, qd.c cVar4, qd.c cVar5, qd.c cVar6, qd.c cVar7, qd.c cVar8) {
        return zip(Tuples.fn8(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8);
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends qd.c> iterable, Function<Object[], V> function) {
        return combineLatest(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public static <O> Flux<O> zip(Iterable<? extends qd.c> iterable, Function<? super Object[], ? extends O> function) {
        return zip(iterable, Queues.XS_BUFFER_SIZE, function);
    }

    public static <T, V> Flux<V> combineLatest(Iterable<? extends qd.c> iterable, int i, Function<Object[], V> function) {
        return onAssembly(new FluxCombineLatest(iterable, function, (Supplier<? extends Queue<FluxCombineLatest.SourceAndArray>>) Queues.get(i), i));
    }

    public static <O> Flux<O> zip(Iterable<? extends qd.c> iterable, int i, Function<? super Object[], ? extends O> function) {
        return onAssembly(new FluxZip(iterable, function, Queues.get(i), i));
    }

    @SafeVarargs
    public static <I, O> Flux<O> zip(Function<? super Object[], ? extends O> function, qd.c... cVarArr) {
        return zip(function, Queues.XS_BUFFER_SIZE, cVarArr);
    }

    public static <T1, T2, O> Flux<O> zip(qd.c cVar, qd.c cVar2, BiFunction<? super T1, ? super T2, ? extends O> biFunction) {
        return onAssembly(new FluxZip(cVar, cVar2, biFunction, Queues.xs(), Queues.XS_BUFFER_SIZE));
    }

    public static <TUPLE extends Tuple2, V> Flux<V> zip(qd.c cVar, final Function<? super TUPLE, ? extends V> function) {
        return onAssembly(new FluxBuffer(from(cVar), Reader.READ_DONE, listSupplier()).flatMap(new Function<List<? extends qd.c>, qd.c>() { // from class: reactor.core.publisher.Flux.1
            @Override // java.util.function.Function
            public qd.c apply(List<? extends qd.c> list) {
                return Flux.zip(Tuples.fnAny(function), (qd.c[]) list.toArray(new qd.c[list.size()]));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Logger lambda$log$24(Logger logger, String str) {
        return logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$timeout$35(Mono mono, Object obj) {
        return mono;
    }
}
