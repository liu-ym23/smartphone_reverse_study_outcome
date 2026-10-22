package reactor.core.publisher;

import com.autonavi.aps.amapapi.config.Const;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
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
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.FluxOnAssembly;
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
public abstract class Mono<T> implements CorePublisher<T> {
    static final BiPredicate EQUALS_BIPREDICATE = new C5381q();

    public static /* synthetic */ qc.b F(int i10, Function function, Flux flux) {
        return i10 == Integer.MAX_VALUE ? (qc.b) function.apply(flux.index().map(new Function() { // from class: reactor.core.publisher.q1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Long) ((Tuple2) obj).getT1();
            }
        })) : (qc.b) function.apply(flux.index().map(new Function() { // from class: reactor.core.publisher.q1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Long) ((Tuple2) obj).getT1();
            }
        }).take(i10, false).concatWith(Flux.error((Supplier<? extends Throwable>) new Supplier() { // from class: reactor.core.publisher.r1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.e();
            }
        })));
    }

    public static /* synthetic */ Mono M(Mono mono, final BiFunction biFunction, final ContextView contextView) {
        mono.getClass();
        return Hooks.DETECT_CONTEXT_LOSS ? wrap(new ContextTrackingFunctionWrapper(new Function() { // from class: reactor.core.publisher.J1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.u(biFunction, contextView, (qc.b) obj);
            }
        }, biFunction.toString()).apply((qc.b) mono), true) : from((qc.b) biFunction.apply(mono, contextView));
    }

    public static /* synthetic */ Logger O(Logger logger, String str) {
        return logger;
    }

    private final Mono<T> contextWriteSkippingContextPropagation(final ContextView contextView) {
        return contextWriteSkippingContextPropagation(new Function() { // from class: reactor.core.publisher.u1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Context) obj).putAll(contextView);
            }
        });
    }

    public static <T> Mono<T> create(Consumer<MonoSink<T>> consumer) {
        return onAssembly(new MonoCreate(consumer));
    }

    public static <T> Mono<T> defer(Supplier<? extends Mono<? extends T>> supplier) {
        return onAssembly(new MonoDefer(supplier));
    }

    public static <T> Mono<T> deferContextual(Function<ContextView, ? extends Mono<? extends T>> function) {
        return onAssembly(new MonoDeferContextual(function));
    }

    public static Mono<Long> delay(Duration duration) {
        return delay(duration, Schedulers.parallel());
    }

    public static <T> Mono<T> doOnSignal(Mono<T> mono, @Nullable Consumer<? super qc.d> consumer, @Nullable Consumer<? super T> consumer2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable) {
        return mono instanceof Fuseable ? onAssembly(new MonoPeekFuseable(mono, consumer, consumer2, longConsumer, runnable)) : onAssembly(new MonoPeek(mono, consumer, consumer2, longConsumer, runnable));
    }

    public static <T> Mono<T> doOnTerminalSignal(Mono<T> mono, @Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable BiConsumer<? super T, Throwable> biConsumer) {
        return onAssembly(new MonoPeekTerminal(mono, consumer, consumer2, biConsumer));
    }

    public static /* synthetic */ Throwable e() {
        return new IllegalStateException("Exceeded maximum number of repeats");
    }

    public static <T> Mono<T> empty() {
        return MonoEmpty.instance();
    }

    public static <T> BiPredicate<? super T, ? super T> equalsBiPredicate() {
        return EQUALS_BIPREDICATE;
    }

    public static <T> Mono<T> error(Throwable th) {
        return onAssembly(new MonoError(th));
    }

    public static /* synthetic */ Mono f(Mono mono, Function function) {
        mono.getClass();
        return Hooks.DETECT_CONTEXT_LOSS ? from(new ContextTrackingFunctionWrapper(function).apply((qc.b) mono)) : from((qc.b) function.apply(mono));
    }

    @SafeVarargs
    @Deprecated
    public static <T> Mono<T> first(Mono<? extends T>... monoArr) {
        return firstWithSignal(monoArr);
    }

    @SafeVarargs
    public static <T> Mono<T> firstWithSignal(Mono<? extends T>... monoArr) {
        return onAssembly(new MonoFirstWithSignal(monoArr));
    }

    public static <T> Mono<T> firstWithValue(Iterable<? extends Mono<? extends T>> iterable) {
        return onAssembly(new MonoFirstWithValue(iterable));
    }

    public static <T> Mono<T> from(qc.b<? extends T> bVar) {
        boolean zShouldWrapPublisher = ContextPropagationSupport.shouldWrapPublisher(bVar);
        if ((bVar instanceof Mono) && !zShouldWrapPublisher) {
            return (Mono) bVar;
        }
        if (!(bVar instanceof FluxSourceMono) && !(bVar instanceof FluxSourceMonoFuseable)) {
            return onAssembly(wrap(bVar, true));
        }
        Mono<T> mono = (Mono<T>) ((FluxFromMonoOperator) bVar).source;
        return !ContextPropagationSupport.shouldWrapPublisher(mono) ? mono : wrap(mono, false);
    }

    public static <T> Mono<T> fromCallable(Callable<? extends T> callable) {
        return onAssembly(new MonoCallable(callable));
    }

    public static <T> Mono<T> fromCompletionStage(CompletionStage<? extends T> completionStage) {
        return onAssembly(new MonoCompletionStage(completionStage, false));
    }

    public static <I> Mono<I> fromDirect(qc.b<? extends I> bVar) {
        boolean zShouldWrapPublisher = ContextPropagationSupport.shouldWrapPublisher(bVar);
        if ((bVar instanceof Mono) && !zShouldWrapPublisher) {
            return (Mono) bVar;
        }
        if (!(bVar instanceof FluxSourceMono) && !(bVar instanceof FluxSourceMonoFuseable)) {
            return onAssembly(wrap(bVar, false));
        }
        Mono<? extends I> mono = ((FluxFromMonoOperator) bVar).source;
        return !ContextPropagationSupport.shouldWrapPublisher(mono) ? mono : wrap(mono, false);
    }

    public static <T> Mono<T> fromFuture(CompletableFuture<? extends T> completableFuture) {
        return fromFuture((CompletableFuture) completableFuture, false);
    }

    public static <T> Mono<T> fromRunnable(Runnable runnable) {
        return onAssembly(new MonoRunnable(runnable));
    }

    public static <T> Mono<T> fromSupplier(Supplier<? extends T> supplier) {
        return onAssembly(new MonoSupplier(supplier));
    }

    public static <T> Mono<T> ignoreElements(qc.b<T> bVar) {
        return onAssembly(new MonoIgnorePublisher(bVar));
    }

    public static <T> Mono<T> just(T t10) {
        return onAssembly(new MonoJust(t10));
    }

    public static <T> Mono<T> justOrEmpty(@Nullable Optional<? extends T> optional) {
        return (optional == null || !optional.isPresent()) ? empty() : just(optional.get());
    }

    public static /* synthetic */ Mono k(Predicate predicate, Function function, Throwable th) {
        return predicate.test(th) ? (Mono) function.apply(th) : error(th);
    }

    public static /* synthetic */ Mono l(Mono mono, final int i10, final Function function) {
        mono.getClass();
        return mono.repeatWhen(new Function() { // from class: reactor.core.publisher.F1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.F(i10, function, (Flux) obj);
            }
        }).next();
    }

    public static <T> Mono<T> never() {
        return MonoNever.instance();
    }

    public static <T> Mono<T> onAssembly(Mono<T> mono) {
        Function<qc.b, qc.b> function = Hooks.onEachOperatorHook;
        if (function != null) {
            mono = (Mono) function.apply(mono);
        }
        return Hooks.GLOBAL_TRACE ? (Mono) Hooks.addAssemblyInfo(mono, new FluxOnAssembly.AssemblySnapshot(null, Traces.callSiteSupplierFactory.get())) : mono;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p(Function function, Object obj, SynchronousSink synchronousSink) {
        Object objApply = function.apply(obj);
        if (objApply != null) {
            synchronousSink.next(objApply);
        }
    }

    public static /* synthetic */ qc.b q(Function function, Object obj, Throwable th) {
        return (qc.b) function.apply(obj);
    }

    public static /* synthetic */ void s(Predicate predicate, Consumer consumer, Throwable th) {
        if (predicate.test(th)) {
            consumer.accept(th);
        }
    }

    public static <T> Mono<Boolean> sequenceEqual(qc.b<? extends T> bVar, qc.b<? extends T> bVar2) {
        return sequenceEqual(bVar, bVar2, equalsBiPredicate(), Queues.SMALL_BUFFER_SIZE);
    }

    public static /* synthetic */ qc.b u(BiFunction biFunction, ContextView contextView, qc.b bVar) {
        return (qc.b) biFunction.apply(wrap(bVar, false), contextView);
    }

    public static <T, D> Mono<T> using(Callable<? extends D> callable, Function<? super D, ? extends Mono<? extends T>> function, Consumer<? super D> consumer, boolean z10) {
        return onAssembly(new MonoUsing(callable, function, consumer, z10));
    }

    public static <T, D> Mono<T> usingWhen(qc.b<D> bVar, Function<? super D, ? extends Mono<? extends T>> function, final Function<? super D, ? extends qc.b<?>> function2) {
        return usingWhen(bVar, function, function2, new BiFunction() { // from class: reactor.core.publisher.f1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Mono.q(function2, obj, (Throwable) obj2);
            }
        }, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w(Class cls, Consumer consumer, Throwable th) {
        if (cls.isInstance(th)) {
            consumer.accept(cls.cast(th));
        }
    }

    public static Mono<Void> when(qc.b<?>... bVarArr) {
        return bVarArr.length == 0 ? empty() : bVarArr.length == 1 ? empty(bVarArr[0]) : onAssembly(new MonoWhen(false, bVarArr));
    }

    public static Mono<Void> whenDelayError(Iterable<? extends qc.b<?>> iterable) {
        return onAssembly(new MonoWhen(true, iterable));
    }

    public static <T> Mono<T> wrap(qc.b<T> bVar, boolean z10) {
        boolean zShouldWrapPublisher = ContextPropagationSupport.shouldWrapPublisher(bVar);
        if (bVar instanceof Mono) {
            return !zShouldWrapPublisher ? (Mono) bVar : ContextPropagation.monoRestoreThreadLocals((Mono) bVar);
        }
        if ((bVar instanceof FluxSourceMono) || (bVar instanceof FluxSourceMonoFuseable)) {
            Mono<T> mono = (Mono<T>) ((FluxFromMonoOperator) bVar).source;
            return !ContextPropagationSupport.shouldWrapPublisher(mono) ? mono : ContextPropagation.monoRestoreThreadLocals(mono);
        }
        boolean z11 = bVar instanceof Flux;
        if (z11 && (bVar instanceof Callable)) {
            return Flux.wrapToMono((Callable) bVar);
        }
        Mono<T> monoNext = z10 ? z11 ? new MonoNext<>((Flux) bVar) : new MonoFromPublisher<>(bVar) : (z11 && (bVar instanceof Fuseable)) ? new MonoSourceFluxFuseable<>((Flux) bVar) : z11 ? new MonoSourceFlux<>((Flux) bVar) : bVar instanceof Fuseable ? new MonoSourceFuseable<>(bVar) : new MonoSource<>(bVar);
        return zShouldWrapPublisher ? ContextPropagation.monoRestoreThreadLocals(monoNext) : monoNext;
    }

    public static /* synthetic */ qc.b y(Mono mono, BooleanSupplier booleanSupplier, long j10) {
        mono.getClass();
        return mono.repeat(Flux.countingBooleanSupplier(booleanSupplier, j10));
    }

    public static <T1, T2> Mono<Tuple2<T1, T2>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2) {
        return zip(mono, mono2, Flux.tuple2Function());
    }

    public static <T1, T2> Mono<Tuple2<T1, T2>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2}));
    }

    public final Mono<Void> and(qc.b<?> bVar) {
        Mono<Void> monoWhenAdditionalSource;
        return (!(this instanceof MonoWhen) || (monoWhenAdditionalSource = ((MonoWhen) this).whenAdditionalSource(bVar)) == null) ? when((qc.b<?>[]) new qc.b[]{this, bVar}) : monoWhenAdditionalSource;
    }

    public final <P> P as(Function<? super Mono<T>, P> function) {
        return function.apply(this);
    }

    @Nullable
    public T block() {
        BlockingMonoSubscriber blockingMonoSubscriber = new BlockingMonoSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingMonoSubscriber);
        return blockingMonoSubscriber.blockingGet();
    }

    public Optional<T> blockOptional() {
        BlockingOptionalMonoSubscriber blockingOptionalMonoSubscriber = new BlockingOptionalMonoSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingOptionalMonoSubscriber);
        return blockingOptionalMonoSubscriber.blockingGet();
    }

    public final Mono<T> cache() {
        return onAssembly(new MonoCacheTime(this));
    }

    public final Mono<T> cacheInvalidateIf(Predicate<? super T> predicate) {
        return onAssembly(new MonoCacheInvalidateIf(this, predicate));
    }

    public final Mono<T> cacheInvalidateWhen(Function<? super T, Mono<Void>> function) {
        return onAssembly(new MonoCacheInvalidateWhen(this, function, null));
    }

    public final Mono<T> cancelOn(Scheduler scheduler) {
        return onAssembly(new MonoCancelOn(this, scheduler));
    }

    public final <E> Mono<E> cast(Class<E> cls) {
        Objects.requireNonNull(cls, "clazz");
        return (Mono<E>) map(new C5401x(cls));
    }

    public final Mono<T> checkpoint() {
        return checkpoint(null, true);
    }

    public final Flux<T> concatWith(qc.b<? extends T> bVar) {
        return Flux.concat(this, bVar);
    }

    public final Mono<T> contextCapture() {
        return !ContextPropagationSupport.isContextPropagationAvailable() ? this : ContextPropagationSupport.propagateContextToThreadLocals ? onAssembly(new MonoContextWriteRestoringThreadLocals(this, ContextPropagation.contextCapture())) : onAssembly(new MonoContextWrite(this, ContextPropagation.contextCapture()));
    }

    public final Mono<T> contextWrite(final ContextView contextView) {
        return contextWrite(new Function() { // from class: reactor.core.publisher.E1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Context) obj).putAll(contextView);
            }
        });
    }

    public final Mono<T> defaultIfEmpty(T t10) {
        if (!(this instanceof Fuseable.ScalarCallable)) {
            return onAssembly(new MonoDefaultIfEmpty(this, t10));
        }
        try {
            return block() == null ? just(t10) : this;
        } catch (Throwable unused) {
            return this;
        }
    }

    public final Mono<T> delayElement(Duration duration) {
        return delayElement(duration, Schedulers.parallel());
    }

    public final Mono<T> delaySubscription(Duration duration) {
        return delaySubscription(duration, Schedulers.parallel());
    }

    public final Mono<T> delayUntil(Function<? super T, ? extends qc.b<?>> function) {
        Objects.requireNonNull(function, "triggerProvider required");
        return this instanceof MonoDelayUntil ? ((MonoDelayUntil) this).copyWithNewTriggerGenerator(false, function) : onAssembly(new MonoDelayUntil(this, function));
    }

    public final <X> Mono<X> dematerialize() {
        return onAssembly(new MonoDematerialize(this));
    }

    public final Mono<T> doAfterTerminate(final Runnable runnable) {
        Objects.requireNonNull(runnable, "afterTerminate");
        return onAssembly(new MonoPeekTerminal(this, null, null, new BiConsumer() { // from class: reactor.core.publisher.o1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                runnable.run();
            }
        }));
    }

    public final Mono<T> doFinally(Consumer<SignalType> consumer) {
        Objects.requireNonNull(consumer, "onFinally");
        return onAssembly(new MonoDoFinally(this, consumer));
    }

    public final Mono<T> doFirst(Runnable runnable) {
        Objects.requireNonNull(runnable, "onFirst");
        return this instanceof Fuseable ? onAssembly(new MonoDoFirstFuseable(this, runnable)) : onAssembly(new MonoDoFirst(this, runnable));
    }

    public final Mono<T> doOnCancel(Runnable runnable) {
        Objects.requireNonNull(runnable, "onCancel");
        return doOnSignal(this, null, null, null, runnable);
    }

    public final <R> Mono<T> doOnDiscard(Class<R> cls, Consumer<? super R> consumer) {
        return contextWriteSkippingContextPropagation(Operators.discardLocalAdapter(cls, consumer));
    }

    public final Mono<T> doOnEach(Consumer<? super Signal<T>> consumer) {
        Objects.requireNonNull(consumer, "signalConsumer");
        return this instanceof Fuseable ? onAssembly(new MonoDoOnEachFuseable(this, consumer)) : onAssembly(new MonoDoOnEach(this, consumer));
    }

    public final Mono<T> doOnError(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError");
        return doOnTerminalSignal(this, null, consumer, null);
    }

    public final Mono<T> doOnNext(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext");
        return doOnSignal(this, null, consumer, null, null);
    }

    public final Mono<T> doOnRequest(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "consumer");
        return doOnSignal(this, null, null, longConsumer, null);
    }

    public final Mono<T> doOnSubscribe(Consumer<? super qc.d> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, consumer, null, null, null);
    }

    public final Mono<T> doOnSuccess(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onSuccess");
        return doOnTerminalSignal(this, consumer, null, null);
    }

    public final Mono<T> doOnTerminate(final Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        return doOnTerminalSignal(this, new Consumer() { // from class: reactor.core.publisher.K1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                runnable.run();
            }
        }, new Consumer() { // from class: reactor.core.publisher.L1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                runnable.run();
            }
        }, null);
    }

    public final Mono<Tuple2<Long, T>> elapsed() {
        return elapsed(Schedulers.parallel());
    }

    public final Flux<T> expand(Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
        return Flux.onAssembly(new MonoExpand(this, function, true, i10));
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
        return Flux.onAssembly(new MonoExpand(this, function, false, i10));
    }

    public final Mono<T> filter(Predicate<? super T> predicate) {
        return this instanceof Fuseable ? onAssembly(new MonoFilterFuseable(this, predicate)) : onAssembly(new MonoFilter(this, predicate));
    }

    public final Mono<T> filterWhen(Function<? super T, ? extends qc.b<Boolean>> function) {
        return onAssembly(new MonoFilterWhen(this, function));
    }

    public final <R> Mono<R> flatMap(Function<? super T, ? extends Mono<? extends R>> function) {
        return onAssembly(new MonoFlatMap(this, function));
    }

    public final <R> Flux<R> flatMapIterable(Function<? super T, ? extends Iterable<? extends R>> function) {
        return Flux.onAssembly(new MonoFlattenIterable(this, function, Integer.MAX_VALUE, Queues.one()));
    }

    public final <R> Flux<R> flatMapMany(Function<? super T, ? extends qc.b<? extends R>> function) {
        return Flux.onAssembly(new MonoFlatMapMany(this, function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flux<T> flux() {
        return (!(this instanceof Callable) || (this instanceof Fuseable.ScalarCallable)) ? Flux.from(this) : Flux.onAssembly(new FluxCallable((Callable) this));
    }

    public final <R> Mono<R> handle(BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        return this instanceof Fuseable ? onAssembly(new MonoHandleFuseable(this, biConsumer)) : onAssembly(new MonoHandle(this, biConsumer));
    }

    public final Mono<Boolean> hasElement() {
        return onAssembly(new MonoHasElement(this));
    }

    public final Mono<T> hide() {
        return onAssembly(new MonoHide(this));
    }

    public final Mono<T> ignoreElement() {
        return onAssembly(new MonoIgnoreElement(this));
    }

    public final Mono<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public final <R> Mono<R> map(Function<? super T, ? extends R> function) {
        return this instanceof Fuseable ? onAssembly(new MonoMapFuseable(this, function)) : onAssembly(new MonoMap(this, function));
    }

    public final <R> Mono<R> mapNotNull(final Function<? super T, ? extends R> function) {
        return handle(new BiConsumer() { // from class: reactor.core.publisher.B1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Mono.p(function, obj, (SynchronousSink) obj2);
            }
        });
    }

    public final Mono<Signal<T>> materialize() {
        return onAssembly(new MonoMaterialize(this));
    }

    public final Flux<T> mergeWith(qc.b<? extends T> bVar) {
        return Flux.merge(this, bVar);
    }

    @Deprecated
    public final Mono<T> metrics() {
        return !Metrics.isInstrumentationAvailable() ? this : this instanceof Fuseable ? onAssembly(new MonoMetricsFuseable(this)) : onAssembly(new MonoMetrics(this));
    }

    public final Mono<T> name(String str) {
        return MonoName.createOrAppend(this, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U> Mono<U> ofType(final Class<U> cls) {
        Objects.requireNonNull(cls, "clazz");
        return (Mono<U>) filter(new Predicate() { // from class: reactor.core.publisher.j1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isAssignableFrom(obj.getClass());
            }
        }).cast(cls);
    }

    public final Mono<T> onErrorComplete() {
        return onAssembly(new MonoOnErrorReturn(this, null, null));
    }

    public final Mono<T> onErrorContinue(BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resume(biConsumer)));
    }

    public final Mono<T> onErrorMap(Predicate<? super Throwable> predicate, final Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(predicate, new Function() { // from class: reactor.core.publisher.z1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error((Throwable) function.apply((Throwable) obj));
            }
        });
    }

    public final Mono<T> onErrorResume(Function<? super Throwable, ? extends Mono<? extends T>> function) {
        return onAssembly(new MonoOnErrorResume(this, function));
    }

    public final Mono<T> onErrorReturn(T t10) {
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new MonoOnErrorReturn(this, null, t10));
    }

    public final Mono<T> onErrorStop() {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.stop()));
    }

    public final Mono<T> onTerminateDetach() {
        return new MonoDetach(this);
    }

    public final Mono<T> or(Mono<? extends T> mono) {
        Mono<T> monoOrAdditionalSource;
        return (!(this instanceof MonoFirstWithSignal) || (monoOrAdditionalSource = ((MonoFirstWithSignal) this).orAdditionalSource(mono)) == null) ? firstWithSignal(this, mono) : monoOrAdditionalSource;
    }

    public final <R> Mono<R> publish(Function<? super Mono<T>, ? extends Mono<? extends R>> function) {
        return onAssembly(new MonoPublishMulticast(this, function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> publishOn(Scheduler scheduler) {
        if (!(this instanceof Callable)) {
            return onAssembly(new MonoPublishOn(this, scheduler));
        }
        if (this instanceof Fuseable.ScalarCallable) {
            try {
                return onAssembly(new MonoSubscribeOnValue(block(), scheduler));
            } catch (Throwable unused) {
            }
        }
        return onAssembly(new MonoSubscribeOnCallable((Callable) this, scheduler));
    }

    public final Flux<T> repeat() {
        return repeat(Flux.ALWAYS_BOOLEAN_SUPPLIER);
    }

    public final Flux<T> repeatWhen(Function<Flux<Long>, ? extends qc.b<?>> function) {
        return Flux.onAssembly(new MonoRepeatWhen(this, function));
    }

    public final Mono<T> repeatWhenEmpty(Function<Flux<Long>, ? extends qc.b<?>> function) {
        return repeatWhenEmpty(Integer.MAX_VALUE, function);
    }

    public final Mono<T> retry() {
        return retry(Long.MAX_VALUE);
    }

    public final Mono<T> retryWhen(Retry retry) {
        return onAssembly(new MonoRetryWhen(this, retry));
    }

    public final Mono<T> share() {
        return this instanceof Fuseable.ScalarCallable ? this : ((this instanceof NextProcessor) && ((NextProcessor) this).isRefCounted) ? this : new NextProcessor(this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> single() throws Exception {
        if (!(this instanceof Callable)) {
            return onAssembly(new MonoSingleMono(this));
        }
        if (!(this instanceof Fuseable.ScalarCallable)) {
            return onAssembly(new MonoSingleCallable((Callable) this));
        }
        try {
            T tCall = ((Fuseable.ScalarCallable) this).call();
            return tCall == null ? error(new NoSuchElementException("Source was a (constant) empty")) : just(tCall);
        } catch (Exception e10) {
            return error(Exceptions.unwrap(e10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<Optional<T>> singleOptional() {
        if (!(this instanceof Callable)) {
            return onAssembly(new MonoSingleOptional(this));
        }
        if (!(this instanceof Fuseable.ScalarCallable)) {
            return onAssembly(new MonoSingleOptionalCallable((Callable) this));
        }
        try {
            return just(Optional.ofNullable(((Fuseable.ScalarCallable) this).call()));
        } catch (Exception e10) {
            return error(Exceptions.unwrap(e10));
        }
    }

    public final Disposable subscribe() {
        if (this instanceof NextProcessor) {
            NextProcessor nextProcessor = (NextProcessor) this;
            if (nextProcessor.source != null && !nextProcessor.isRefCounted) {
                nextProcessor.subscribe((CoreSubscriber) new LambdaMonoSubscriber(null, null, null, null, null));
                nextProcessor.connect();
                return nextProcessor;
            }
        }
        return (Disposable) subscribeWith(new LambdaMonoSubscriber(null, null, null, null, null));
    }

    @Override // reactor.core.CorePublisher
    public abstract void subscribe(CoreSubscriber<? super T> coreSubscriber);

    /* JADX WARN: Multi-variable type inference failed */
    public final Mono<T> subscribeOn(Scheduler scheduler) {
        if (!(this instanceof Callable)) {
            return onAssembly(new MonoSubscribeOn(this, scheduler));
        }
        if (this instanceof Fuseable.ScalarCallable) {
            try {
                return onAssembly(new MonoSubscribeOnValue(block(), scheduler));
            } catch (Throwable unused) {
            }
        }
        return onAssembly(new MonoSubscribeOnCallable((Callable) this, scheduler));
    }

    public final <E extends qc.c<? super T>> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final Mono<T> switchIfEmpty(Mono<? extends T> mono) {
        return onAssembly(new MonoSwitchIfEmpty(this, mono));
    }

    public final Mono<T> tag(String str, String str2) {
        return MonoName.createOrAppend(this, str, str2);
    }

    public final Mono<T> take(Duration duration) {
        return take(duration, Schedulers.parallel());
    }

    public final Mono<T> takeUntilOther(qc.b<?> bVar) {
        return onAssembly(new MonoTakeUntilOther(this, bVar));
    }

    public final Mono<T> tap(final Supplier<SignalListener<T>> supplier) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Mono.1
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
        return empty(this);
    }

    public final Mono<Void> thenEmpty(qc.b<Void> bVar) {
        return then(fromDirect(bVar));
    }

    public final <V> Flux<V> thenMany(qc.b<V> bVar) {
        return Flux.onAssembly(Flux.concat(ignoreElement(), bVar));
    }

    public final <V> Mono<V> thenReturn(V v10) {
        return then(just(v10));
    }

    public final Mono<Timed<T>> timed() {
        return timed(Schedulers.parallel());
    }

    public final Mono<T> timeout(Duration duration) {
        return timeout(duration, Schedulers.parallel());
    }

    public final Mono<Tuple2<Long, T>> timestamp() {
        return timestamp(Schedulers.parallel());
    }

    public final CompletableFuture<T> toFuture() {
        return (CompletableFuture) subscribeWith(new MonoToCompletableFuture(false));
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final <V> Mono<V> transform(Function<? super Mono<T>, ? extends qc.b<V>> function) {
        if (Hooks.DETECT_CONTEXT_LOSS) {
            function = new ContextTrackingFunctionWrapper(function);
        }
        return onAssembly(from(function.apply(this)));
    }

    public final <V> Mono<V> transformDeferred(final Function<? super Mono<T>, ? extends qc.b<V>> function) {
        return defer(new Supplier() { // from class: reactor.core.publisher.h1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.f(this.f39755a, function);
            }
        });
    }

    public final <V> Mono<V> transformDeferredContextual(final BiFunction<? super Mono<T>, ? super ContextView, ? extends qc.b<V>> biFunction) {
        return deferContextual(new Function() { // from class: reactor.core.publisher.n1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.M(this.f39781a, biFunction, (ContextView) obj);
            }
        });
    }

    public final <T2> Mono<Tuple2<T, T2>> zipWhen(Function<T, Mono<? extends T2>> function) {
        return (Mono<Tuple2<T, T2>>) zipWhen(function, new C5369m());
    }

    public final <T2> Mono<Tuple2<T, T2>> zipWith(Mono<? extends T2> mono) {
        return (Mono<Tuple2<T, T2>>) zipWith(mono, Flux.tuple2Function());
    }

    private final Mono<T> contextWriteSkippingContextPropagation(Function<Context, Context> function) {
        return onAssembly(new MonoContextWrite(this, function));
    }

    public static Mono<Long> delay(Duration duration, Scheduler scheduler) {
        return onAssembly(new MonoDelay(duration.toNanos(), TimeUnit.NANOSECONDS, scheduler));
    }

    public static <T> Mono<Void> empty(qc.b<T> bVar) {
        return ignoreElements(bVar);
    }

    public static <T> Mono<T> error(Supplier<? extends Throwable> supplier) {
        return onAssembly(new MonoErrorSupplied(supplier));
    }

    @Deprecated
    public static <T> Mono<T> first(Iterable<? extends Mono<? extends T>> iterable) {
        return firstWithSignal(iterable);
    }

    public static <T> Mono<T> firstWithSignal(Iterable<? extends Mono<? extends T>> iterable) {
        return onAssembly(new MonoFirstWithSignal(iterable));
    }

    @SafeVarargs
    public static <T> Mono<T> firstWithValue(Mono<? extends T> mono, Mono<? extends T>... monoArr) {
        MonoFirstWithValue<T> monoFirstWithValueFirstValuedAdditionalSources;
        return (!(mono instanceof MonoFirstWithValue) || (monoFirstWithValueFirstValuedAdditionalSources = ((MonoFirstWithValue) mono).firstValuedAdditionalSources(monoArr)) == null) ? onAssembly(new MonoFirstWithValue(mono, monoArr)) : monoFirstWithValueFirstValuedAdditionalSources;
    }

    public static <T> Mono<T> fromCompletionStage(final Supplier<? extends CompletionStage<? extends T>> supplier) {
        return defer(new Supplier() { // from class: reactor.core.publisher.p1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.onAssembly(new MonoCompletionStage((CompletionStage) supplier.get(), false));
            }
        });
    }

    public static <T> Mono<T> fromFuture(CompletableFuture<? extends T> completableFuture, boolean z10) {
        return onAssembly(new MonoCompletionStage(completableFuture, z10));
    }

    public static <T> Mono<T> justOrEmpty(@Nullable T t10) {
        return t10 != null ? just(t10) : empty();
    }

    public static <T> Mono<Boolean> sequenceEqual(qc.b<? extends T> bVar, qc.b<? extends T> bVar2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(bVar, bVar2, biPredicate, Queues.SMALL_BUFFER_SIZE);
    }

    public static <T, D> Mono<T> using(Callable<? extends D> callable, Function<? super D, ? extends Mono<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Mono<T> usingWhen(qc.b<D> bVar, Function<? super D, ? extends Mono<? extends T>> function, Function<? super D, ? extends qc.b<?>> function2, BiFunction<? super D, ? super Throwable, ? extends qc.b<?>> biFunction, Function<? super D, ? extends qc.b<?>> function3) {
        return onAssembly(new MonoUsingWhen(bVar, function, function2, biFunction, function3));
    }

    public static Mono<Void> whenDelayError(qc.b<?>... bVarArr) {
        return bVarArr.length == 0 ? empty() : bVarArr.length == 1 ? empty(bVarArr[0]) : onAssembly(new MonoWhen(true, bVarArr));
    }

    public static <T1, T2, O> Mono<O> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, BiFunction<? super T1, ? super T2, ? extends O> biFunction) {
        return onAssembly(new MonoZip(false, mono, mono2, biFunction));
    }

    public static <T1, T2, T3> Mono<Tuple3<T1, T2, T3>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3}));
    }

    public final Mono<T> cache(Duration duration) {
        return cache(duration, Schedulers.parallel());
    }

    public final Mono<T> cacheInvalidateWhen(Function<? super T, Mono<Void>> function, Consumer<? super T> consumer) {
        return onAssembly(new MonoCacheInvalidateWhen(this, function, consumer));
    }

    public final Mono<T> checkpoint(String str) {
        Objects.requireNonNull(str);
        return checkpoint(str, false);
    }

    public final Mono<T> contextWrite(Function<Context, Context> function) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? onAssembly(new MonoContextWriteRestoringThreadLocals(this, function)) : onAssembly(new MonoContextWrite(this, function));
    }

    public final Mono<T> delayElement(Duration duration, Scheduler scheduler) {
        return onAssembly(new MonoDelayElement(this, duration.toNanos(), TimeUnit.NANOSECONDS, scheduler));
    }

    public final Mono<T> delaySubscription(Duration duration, Scheduler scheduler) {
        return delaySubscription(delay(duration, scheduler));
    }

    public final Mono<Tuple2<Long, T>> elapsed(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return onAssembly(new MonoElapsed(this, scheduler));
    }

    public final Flux<T> expand(Function<? super T, ? extends qc.b<? extends T>> function) {
        return expand(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final Flux<T> expandDeep(Function<? super T, ? extends qc.b<? extends T>> function) {
        return expandDeep(function, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> Flux<R> flatMapMany(Function<? super T, ? extends qc.b<? extends R>> function, Function<? super Throwable, ? extends qc.b<? extends R>> function2, Supplier<? extends qc.b<? extends R>> supplier) {
        return flux().flatMap(function, function2, supplier);
    }

    public final Mono<T> log(@Nullable String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final Mono<T> onErrorComplete(Class<? extends Throwable> cls) {
        Objects.requireNonNull(cls, "type must not be null");
        return onErrorComplete(new C5365l(cls));
    }

    public final Mono<T> onErrorMap(final Function<? super Throwable, ? extends Throwable> function) {
        return onErrorResume(new Function() { // from class: reactor.core.publisher.t1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error((Throwable) function.apply((Throwable) obj));
            }
        });
    }

    public final <E extends Throwable> Mono<T> onErrorResume(Class<E> cls, Function<? super E, ? extends Mono<? extends T>> function) {
        Objects.requireNonNull(cls, "type");
        return onErrorResume(new C5365l(cls), function);
    }

    public final Flux<T> repeat(BooleanSupplier booleanSupplier) {
        return Flux.onAssembly(new MonoRepeatPredicate(this, booleanSupplier));
    }

    public final Mono<T> repeatWhenEmpty(final int i10, final Function<Flux<Long>, ? extends qc.b<?>> function) {
        return defer(new Supplier() { // from class: reactor.core.publisher.M1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.l(this.f39644a, i10, function);
            }
        });
    }

    public final Mono<T> retry(long j10) {
        return onAssembly(new MonoRetry(this, j10));
    }

    public final Mono<T> take(Duration duration, Scheduler scheduler) {
        return takeUntilOther(delay(duration, scheduler));
    }

    public final Mono<T> tap(final Function<ContextView, SignalListener<T>> function) {
        return tap(new SignalListenerFactory<T, Void>() { // from class: reactor.core.publisher.Mono.2
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

    public final <V> Mono<V> then(Mono<V> mono) {
        return this instanceof MonoIgnoreThen ? ((MonoIgnoreThen) this).shift(mono) : onAssembly(new MonoIgnoreThen(new qc.b[]{this}, mono));
    }

    public final Mono<Timed<T>> timed(Scheduler scheduler) {
        return onAssembly(new MonoTimed(this, scheduler));
    }

    public final Mono<T> timeout(Duration duration, Mono<? extends T> mono) {
        return timeout(duration, mono, Schedulers.parallel());
    }

    public final Mono<Tuple2<Long, T>> timestamp(final Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler");
        return (Mono<Tuple2<Long, T>>) map(new Function() { // from class: reactor.core.publisher.i1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.of(Long.valueOf(scheduler.now(TimeUnit.MILLISECONDS)), obj);
            }
        });
    }

    public final <T2, O> Mono<O> zipWhen(final Function<T, Mono<? extends T2>> function, final BiFunction<T, T2, O> biFunction) {
        Objects.requireNonNull(function, "rightGenerator function is mandatory to get the right-hand side Mono");
        Objects.requireNonNull(biFunction, "combinator function is mandatory to combine results from both Monos");
        return (Mono<O>) flatMap(new Function() { // from class: reactor.core.publisher.Z0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Mono) function.apply(obj)).map(new Function() { // from class: reactor.core.publisher.s1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return biFunction.apply(obj, obj2);
                    }
                });
            }
        });
    }

    public final <T2, O> Mono<O> zipWith(Mono<? extends T2> mono, BiFunction<? super T, ? super T2, ? extends O> biFunction) {
        Mono<O> monoZipAdditionalSource;
        return (!(this instanceof MonoZip) || (monoZipAdditionalSource = ((MonoZip) this).zipAdditionalSource(mono, biFunction)) == null) ? zip(this, mono, biFunction) : monoZipAdditionalSource;
    }

    public static <T> Mono<T> fromFuture(Supplier<? extends CompletableFuture<? extends T>> supplier) {
        return fromFuture((Supplier) supplier, false);
    }

    public static <T> Mono<Boolean> sequenceEqual(qc.b<? extends T> bVar, qc.b<? extends T> bVar2, BiPredicate<? super T, ? super T> biPredicate, int i10) {
        return onAssembly(new MonoSequenceEqual(bVar, bVar2, biPredicate, i10));
    }

    public static <T, D extends AutoCloseable> Mono<T> using(Callable<? extends D> callable, Function<? super D, ? extends Mono<? extends T>> function) {
        return using((Callable) callable, (Function) function, true);
    }

    public static <T1, T2, T3> Mono<Tuple3<T1, T2, T3>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.Y0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3}));
    }

    public static <T1, T2, T3, T4> Mono<Tuple4<T1, T2, T3, T4>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.k1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4}));
    }

    public final Mono<T> cache(Duration duration, Scheduler scheduler) {
        return onAssembly(new MonoCacheTime(this, duration, scheduler));
    }

    public final Mono<T> checkpoint(@Nullable String str, boolean z10) {
        FluxOnAssembly.AssemblySnapshot checkpointHeavySnapshot;
        if (!z10) {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointLightSnapshot(str);
        } else {
            checkpointHeavySnapshot = new FluxOnAssembly.CheckpointHeavySnapshot(str, Traces.callSiteSupplierFactory.get());
        }
        return new MonoOnAssembly(this, checkpointHeavySnapshot);
    }

    public final <U> Mono<T> delaySubscription(qc.b<U> bVar) {
        return onAssembly(new MonoDelaySubscription(this, bVar));
    }

    public final <E extends Throwable> Mono<T> doOnError(final Class<E> cls, final Consumer<? super E> consumer) {
        Objects.requireNonNull(cls, "type");
        Objects.requireNonNull(consumer, "onError");
        return doOnTerminalSignal(this, null, new Consumer() { // from class: reactor.core.publisher.l1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Mono.w(cls, consumer, (Throwable) obj);
            }
        }, null);
    }

    public final Mono<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final <E extends Throwable> Mono<T> onErrorMap(Class<E> cls, Function<? super E, ? extends Throwable> function) {
        cls.getClass();
        return onErrorMap(new C5365l(cls), function);
    }

    public final <E extends Throwable> Mono<T> onErrorReturn(Class<E> cls, T t10) {
        Objects.requireNonNull(cls, "type must not be null");
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onErrorReturn((Predicate<? super Throwable>) new C5365l(cls), (C5365l) t10);
    }

    public final Flux<T> repeat(long j10) {
        if (j10 == 0) {
            return flux();
        }
        return Flux.onAssembly(new MonoRepeat(this, j10));
    }

    public final Mono<T> tap(SignalListenerFactory<T, ?> signalListenerFactory) {
        if (ContextPropagationSupport.shouldPropagateContextToThreadLocals()) {
            return onAssembly(new MonoTapRestoringThreadLocals(this, signalListenerFactory));
        }
        if (this instanceof Fuseable) {
            return onAssembly(new MonoTapFuseable(this, signalListenerFactory));
        }
        return onAssembly(new MonoTap(this, signalListenerFactory));
    }

    public final Mono<T> timeout(Duration duration, Scheduler scheduler) {
        return timeout(duration, null, scheduler);
    }

    public static <T> Mono<T> fromFuture(final Supplier<? extends CompletableFuture<? extends T>> supplier, final boolean z10) {
        return defer(new Supplier() { // from class: reactor.core.publisher.A1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.onAssembly(new MonoCompletionStage((CompletionStage) supplier.get(), z10));
            }
        });
    }

    public static <T, D extends AutoCloseable> Mono<T> using(Callable<? extends D> callable, Function<? super D, ? extends Mono<? extends T>> function, boolean z10) {
        return using(callable, function, Exceptions.AUTO_CLOSE, z10);
    }

    public static <T1, T2, T3, T4> Mono<Tuple4<T1, T2, T3, T4>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.X0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4}));
    }

    public static <T1, T2, T3, T4, T5> Mono<Tuple5<T1, T2, T3, T4, T5>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.G1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5}));
    }

    public final Mono<T> cache(Function<? super T, Duration> function, Function<Throwable, Duration> function2, Supplier<Duration> supplier) {
        return cache(function, function2, supplier, Schedulers.parallel());
    }

    public final Mono<T> log(@Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, str, level, z10, signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new MonoLogFuseable(this, signalLogger));
        }
        return onAssembly(new MonoLog(this, signalLogger));
    }

    public final Mono<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        return onAssembly(new MonoOnErrorReturn(this, predicate, null));
    }

    public final <E extends Throwable> Mono<T> onErrorContinue(Class<E> cls, BiConsumer<Throwable, Object> biConsumer) {
        cls.getClass();
        return onErrorContinue(new C5365l(cls), biConsumer);
    }

    public final Mono<T> onErrorResume(final Predicate<? super Throwable> predicate, final Function<? super Throwable, ? extends Mono<? extends T>> function) {
        Objects.requireNonNull(predicate, "predicate");
        return onErrorResume(new Function() { // from class: reactor.core.publisher.x1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.k(predicate, function, (Throwable) obj);
            }
        });
    }

    public final Mono<T> timeout(Duration duration, @Nullable Mono<? extends T> mono, Scheduler scheduler) {
        Mono<Long> monoOnErrorReturn = delay(duration, scheduler).onErrorReturn(0L);
        if (mono == null) {
            return onAssembly(new MonoTimeout(this, monoOnErrorReturn, duration.toMillis() + Const.SP_KEY_GSM_UPLOAD_MXSIZE));
        }
        return onAssembly(new MonoTimeout(this, monoOnErrorReturn, mono));
    }

    public static <T1, T2, T3, T4, T5> Mono<Tuple5<T1, T2, T3, T4, T5>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.d1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5}));
    }

    public static <T1, T2, T3, T4, T5, T6> Mono<Tuple6<T1, T2, T3, T4, T5, T6>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.C1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6}));
    }

    public final Mono<T> cache(Function<? super T, Duration> function, Function<Throwable, Duration> function2, Supplier<Duration> supplier, Scheduler scheduler) {
        return onAssembly(new MonoCacheTime(this, function, function2, supplier, scheduler));
    }

    public final <E extends Throwable> Mono<T> onErrorContinue(Predicate<E> predicate, BiConsumer<Throwable, Object> biConsumer) {
        return contextWriteSkippingContextPropagation(Context.of(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, OnNextFailureStrategy.resumeIf(predicate, biConsumer)));
    }

    public final Flux<T> repeat(final long j10, final BooleanSupplier booleanSupplier) {
        if (j10 < 0) {
            throw new IllegalArgumentException("numRepeat >= 0 required");
        }
        if (j10 == 0) {
            return flux();
        }
        return Flux.defer(new Supplier() { // from class: reactor.core.publisher.w1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.y(this.f39810a, booleanSupplier, j10);
            }
        });
    }

    public static Mono<Void> when(Iterable<? extends qc.b<?>> iterable) {
        return onAssembly(new MonoWhen(false, iterable));
    }

    public static <T1, T2, T3, T4, T5, T6> Mono<Tuple6<T1, T2, T3, T4, T5, T6>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.y1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6}));
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Mono<Tuple7<T1, T2, T3, T4, T5, T6, T7>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6, Mono<? extends T7> mono7) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.I1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6, mono7}));
    }

    @Nullable
    public T block(Duration duration) {
        BlockingMonoSubscriber blockingMonoSubscriber = new BlockingMonoSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingMonoSubscriber);
        return blockingMonoSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public Optional<T> blockOptional(Duration duration) {
        BlockingOptionalMonoSubscriber blockingOptionalMonoSubscriber = new BlockingOptionalMonoSubscriber(ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? ContextPropagation.contextCaptureToEmpty() : Context.empty());
        subscribe((qc.c) blockingOptionalMonoSubscriber);
        return blockingOptionalMonoSubscriber.blockingGet(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final Mono<T> doOnError(final Predicate<? super Throwable> predicate, final Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(consumer, "onError");
        return doOnTerminalSignal(this, null, new Consumer() { // from class: reactor.core.publisher.H1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Mono.s(predicate, consumer, (Throwable) obj);
            }
        }, null);
    }

    public final Mono<T> onErrorReturn(Predicate<? super Throwable> predicate, T t10) {
        Objects.requireNonNull(predicate, "predicate must not be null");
        Objects.requireNonNull(t10, "fallbackValue must not be null");
        return onAssembly(new MonoOnErrorReturn(this, predicate, t10));
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Mono<Tuple7<T1, T2, T3, T4, T5, T6, T7>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6, Mono<? extends T7> mono7) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.c1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6, mono7}));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Mono<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> zipDelayError(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6, Mono<? extends T7> mono7, Mono<? extends T8> mono8) {
        return onAssembly(new MonoZip(true, new Function() { // from class: reactor.core.publisher.g1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6, mono7, mono8}));
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return subscribe(consumer, null, null);
    }

    public final <U> Mono<T> timeout(qc.b<U> bVar) {
        return onAssembly(new MonoTimeout(this, bVar, "first signal from a Publisher"));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Mono<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> zip(Mono<? extends T1> mono, Mono<? extends T2> mono2, Mono<? extends T3> mono3, Mono<? extends T4> mono4, Mono<? extends T5> mono5, Mono<? extends T6> mono6, Mono<? extends T7> mono7, Mono<? extends T8> mono8) {
        return onAssembly(new MonoZip(false, new Function() { // from class: reactor.core.publisher.b1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tuples.fromArray((Object[]) obj);
            }
        }, (Mono<?>[]) new Mono[]{mono, mono2, mono3, mono4, mono5, mono6, mono7, mono8}));
    }

    public static <R> Mono<R> zipDelayError(Iterable<? extends Mono<?>> iterable, Function<? super Object[], ? extends R> function) {
        return onAssembly(new MonoZip(true, (Function) function, iterable));
    }

    public final Mono<T> log(Logger logger) {
        return log(logger, Level.INFO, false, new SignalType[0]);
    }

    public final <U> Mono<T> timeout(qc.b<U> bVar, Mono<? extends T> mono) {
        return onAssembly(new MonoTimeout(this, bVar, mono));
    }

    public static <R> Mono<R> zip(Iterable<? extends Mono<?>> iterable, Function<? super Object[], ? extends R> function) {
        return onAssembly(new MonoZip(false, (Function) function, iterable));
    }

    public static <R> Mono<R> zipDelayError(final Function<? super Object[], ? extends R> function, Mono<?>... monoArr) {
        if (monoArr.length == 0) {
            return empty();
        }
        if (monoArr.length == 1) {
            return monoArr[0].map(new Function() { // from class: reactor.core.publisher.m1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return function.apply(new Object[]{obj});
                }
            });
        }
        return onAssembly(new MonoZip(true, (Function) function, monoArr));
    }

    public final Mono<T> log(final Logger logger, Level level, boolean z10, SignalType... signalTypeArr) {
        SignalLogger signalLogger = new SignalLogger(this, "IGNORED", level, z10, new Function() { // from class: reactor.core.publisher.D1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.O(logger, (String) obj);
            }
        }, signalTypeArr);
        if (this instanceof Fuseable) {
            return onAssembly(new MonoLogFuseable(this, signalLogger));
        }
        return onAssembly(new MonoLog(this, signalLogger));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer2, "errorConsumer");
        return subscribe(consumer, consumer2, null);
    }

    public static <R> Mono<R> zip(final Function<? super Object[], ? extends R> function, Mono<?>... monoArr) {
        if (monoArr.length == 0) {
            return empty();
        }
        if (monoArr.length == 1) {
            return monoArr[0].map(new Function() { // from class: reactor.core.publisher.v1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return function.apply(new Object[]{obj});
                }
            });
        }
        return onAssembly(new MonoZip(false, (Function) function, monoArr));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable) {
        return subscribe(consumer, consumer2, runnable, (Context) null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3) {
        return (Disposable) subscribeWith(new LambdaMonoSubscriber(consumer, consumer2, runnable, consumer3, null));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Context context) {
        return (Disposable) subscribeWith(new LambdaMonoSubscriber(consumer, consumer2, runnable, null, context));
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
}
