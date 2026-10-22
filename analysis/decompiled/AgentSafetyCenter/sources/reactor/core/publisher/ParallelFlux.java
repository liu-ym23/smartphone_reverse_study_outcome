package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class ParallelFlux<T> implements CorePublisher<T> {
    public static <T> ParallelFlux<T> doOnSignal(ParallelFlux<T> parallelFlux, @Nullable Consumer<? super T> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable Consumer<? super qd.e> consumer4, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        return onAssembly(new ParallelPeek(parallelFlux, consumer, consumer2, consumer3, runnable, runnable2, consumer4, longConsumer, runnable3));
    }

    public static <T> ParallelFlux<T> from(qd.c cVar, int i, int i3, Supplier<Queue<T>> supplier) {
        Objects.requireNonNull(supplier, "queueSupplier");
        Objects.requireNonNull(cVar, "source");
        return onAssembly(new ParallelSource(cVar, i, i3, supplier));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectSortedList$0(int i) {
        return new ArrayList(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectSortedList$1(List list, Object obj) {
        list.add(obj);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectSortedList$2(Comparator comparator, List list) {
        list.sort(comparator);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$collectSortedList$3(Comparator comparator, List list, List list2) {
        return sortedMerger(list, list2, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doOnEach$4(Consumer consumer, Context context, Object obj) {
        consumer.accept(Signal.next(obj, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doOnEach$5(Consumer consumer, Context context, Throwable th) {
        consumer.accept(Signal.error(th, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doOnEach$6(Consumer consumer, Context context) {
        consumer.accept(Signal.complete(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$sorted$10(Comparator comparator, List list) {
        list.sort(comparator);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$sorted$8(int i) {
        return new ArrayList(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$sorted$9(List list, Object obj) {
        list.add(obj);
        return list;
    }

    public static <T> ParallelFlux<T> onAssembly(ParallelFlux<T> parallelFlux) {
        Function<qd.c, qd.c> function = Hooks.onEachOperatorHook;
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
            int r1 = r1 + r0
            if (r1 != 0) goto L11
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            return r5
        L11:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
            boolean r1 = r5.hasNext()
            r2 = 0
            if (r1 == 0) goto L2a
            java.lang.Object r1 = r5.next()
            goto L2b
        L2a:
            r1 = r2
        L2b:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r6.next()
            goto L37
        L36:
            r3 = r2
        L37:
            if (r1 == 0) goto L5f
            if (r3 == 0) goto L5f
            int r4 = r7.compare(r1, r3)
            if (r4 >= 0) goto L51
            r0.add(r1)
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r5.next()
            goto L37
        L4f:
            r1 = r2
            goto L37
        L51:
            r0.add(r3)
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r6.next()
            goto L37
        L5f:
            if (r1 == 0) goto L72
            r0.add(r1)
        L64:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L85
            java.lang.Object r6 = r5.next()
            r0.add(r6)
            goto L64
        L72:
            if (r3 == 0) goto L85
            r0.add(r3)
        L77:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto L85
            java.lang.Object r5 = r6.next()
            r0.add(r5)
            goto L77
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ParallelFlux.sortedMerger(java.util.List, java.util.List, java.util.Comparator):java.util.List");
    }

    public final <U> U as(Function<? super ParallelFlux<T>, U> function) {
        return function.apply(this);
    }

    public final ParallelFlux<T> checkpoint(String str, boolean z10) {
        return new ParallelFluxOnAssembly(this, !z10 ? new FluxOnAssembly.CheckpointLightSnapshot(str) : new FluxOnAssembly.CheckpointHeavySnapshot(str, Traces.callSiteSupplierFactory.get()));
    }

    public final <C> ParallelFlux<C> collect(Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        return onAssembly(new ParallelCollect(this, supplier, biConsumer));
    }

    public final Mono<List<T>> collectSortedList(Comparator<? super T> comparator, int i) {
        int iParallelism = i / parallelism();
        int i3 = 1;
        i1 i1Var = new i1(0);
        i1Var.f10805f = iParallelism + 1;
        VarHandle.storeStoreFence();
        ParallelFlux<R> parallelFluxReduce = reduce(i1Var, new i(2));
        h1 h1Var = new h1(i3);
        h1Var.f10801b = comparator;
        VarHandle.storeStoreFence();
        ParallelFlux map = parallelFluxReduce.map(h1Var);
        p0 p0Var = new p0(i3);
        p0Var.f10838f = comparator;
        VarHandle.storeStoreFence();
        return map.reduce(p0Var);
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qd.c> function, int i, FluxConcatMap.ErrorMode errorMode) {
        return onAssembly(new ParallelConcatMap(this, function, Queues.get(i), i, errorMode));
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qd.c> function, boolean z10, int i) {
        return concatMap(function, i, z10 ? FluxConcatMap.ErrorMode.END : FluxConcatMap.ErrorMode.BOUNDARY);
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

    public final ParallelFlux<T> doOnEach(Consumer<? super Signal<T>> consumer) {
        Objects.requireNonNull(consumer, "signalConsumer");
        g1 g1Var = new g1(0);
        g1Var.f10795f = consumer;
        VarHandle.storeStoreFence();
        g1 g1Var2 = new g1(1);
        g1Var2.f10795f = consumer;
        VarHandle.storeStoreFence();
        c1 c1Var = new c1(4);
        c1Var.f10771f = consumer;
        VarHandle.storeStoreFence();
        return onAssembly(new ParallelDoOnEach(this, g1Var, g1Var2, c1Var));
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

    public final ParallelFlux<T> doOnSubscribe(Consumer<? super qd.e> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe");
        return doOnSignal(this, null, null, null, null, null, consumer, null, null);
    }

    public final ParallelFlux<T> doOnTerminate(Runnable runnable) {
        Objects.requireNonNull(runnable, "onTerminate");
        t tVar = new t(3);
        tVar.f10859f = runnable;
        VarHandle.storeStoreFence();
        return doOnSignal(this, null, null, tVar, runnable, null, null, null, null);
    }

    public final ParallelFlux<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return onAssembly(new ParallelFilter(this, predicate));
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qd.c> function, boolean z10, int i, int i3) {
        return onAssembly(new ParallelFlatMap(this, function, z10, i, Queues.get(i), i3, Queues.get(i3)));
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

    public final ParallelFlux<T> log(@Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        return onAssembly(new ParallelLog(this, new SignalLogger(this, str, level, z10, signalTypeArr)));
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

    public final <R> ParallelFlux<R> reduce(Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "initialSupplier");
        Objects.requireNonNull(biFunction, "reducer");
        return onAssembly(new ParallelReduceSeed(this, supplier, biFunction));
    }

    public final ParallelFlux<T> runOn(Scheduler scheduler, int i) {
        Objects.requireNonNull(scheduler, "scheduler");
        return onAssembly(new ParallelRunOn(this, scheduler, i, Queues.get(i)));
    }

    public final Flux<T> sequential(int i) {
        return Flux.onAssembly(new ParallelMergeSequential(this, i, Queues.get(i)));
    }

    public final Flux<T> sorted(Comparator<? super T> comparator, int i) {
        int iParallelism = i / parallelism();
        int i3 = 1;
        i1 i1Var = new i1(i3);
        i1Var.f10805f = iParallelism + 1;
        VarHandle.storeStoreFence();
        ParallelFlux<R> parallelFluxReduce = reduce(i1Var, new i(i3));
        h1 h1Var = new h1(0);
        h1Var.f10801b = comparator;
        VarHandle.storeStoreFence();
        return Flux.onAssembly(new ParallelMergeSort(parallelFluxReduce.map(h1Var), comparator));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qd.e> consumer3, @Nullable Context context) {
        CorePublisher corePublisherOnLastAssembly = Operators.onLastAssembly(this);
        if (!(corePublisherOnLastAssembly instanceof ParallelFlux)) {
            LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, runnable, consumer3, context);
            corePublisherOnLastAssembly.subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(lambdaSubscriber)));
            return lambdaSubscriber;
        }
        int iParallelism = parallelism();
        LambdaSubscriber[] lambdaSubscriberArr = new LambdaSubscriber[iParallelism];
        for (int i = 0; i < iParallelism; i++) {
            lambdaSubscriberArr[i] = new LambdaSubscriber(consumer, consumer2, runnable, consumer3, context);
        }
        ((ParallelFlux) corePublisherOnLastAssembly).subscribe(lambdaSubscriberArr);
        return Disposables.composite(lambdaSubscriberArr);
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

    public final <U> ParallelFlux<U> transformGroups(Function<? super GroupedFlux<Integer, T>, ? extends qd.c> function) {
        int i = 11;
        if (getPrefetch() > -1) {
            Flux<GroupedFlux<Integer, T>> fluxGroups = groups();
            function.getClass();
            s sVar = new s(i);
            sVar.f10854b = function;
            VarHandle.storeStoreFence();
            return from(fluxGroups.flatMap(sVar), parallelism(), getPrefetch(), Queues.small());
        }
        Flux<GroupedFlux<Integer, T>> fluxGroups2 = groups();
        function.getClass();
        s sVar2 = new s(i);
        sVar2.f10854b = function;
        VarHandle.storeStoreFence();
        return from(fluxGroups2.flatMap(sVar2), parallelism());
    }

    public final boolean validate(qd.d[] dVarArr) {
        int iParallelism = parallelism();
        if (dVarArr.length == iParallelism) {
            return true;
        }
        StringBuilder sbT = k0.a.t(iParallelism, "parallelism = ", ", subscribers = ");
        sbT.append(dVarArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sbT.toString());
        for (qd.d dVar : dVarArr) {
            Operators.error(dVar, illegalArgumentException);
        }
        return false;
    }

    public final Flux<T> ordered(Comparator<? super T> comparator, int i) {
        return new ParallelMergeOrdered(this, i, comparator);
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qd.c> function) {
        return concatMap(function, 2, FluxConcatMap.ErrorMode.END);
    }

    public final <R> ParallelFlux<R> concatMapDelayError(Function<? super T, ? extends qd.c> function, int i) {
        return concatMap(function, i, FluxConcatMap.ErrorMode.END);
    }

    public final Flux<T> sequential() {
        return sequential(Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qd.c> function, int i) {
        return concatMap(function, i, FluxConcatMap.ErrorMode.IMMEDIATE);
    }

    public final <R> ParallelFlux<R> concatMap(Function<? super T, ? extends qd.c> function) {
        return concatMap(function, 2, FluxConcatMap.ErrorMode.IMMEDIATE);
    }

    public final ParallelFlux<T> runOn(Scheduler scheduler) {
        return runOn(scheduler, Queues.SMALL_BUFFER_SIZE);
    }

    public static <T> ParallelFlux<T> from(qd.c cVar) {
        return from(cVar, Schedulers.DEFAULT_POOL_SIZE, Queues.SMALL_BUFFER_SIZE, Queues.small());
    }

    public final ParallelFlux<T> log(@Nullable String str) {
        return log(str, Level.INFO, new SignalType[0]);
    }

    public final Mono<T> reduce(BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer");
        return Mono.onAssembly(new ParallelMergeReduce(this, biFunction));
    }

    public final ParallelFlux<T> log(@Nullable String str, Level level, SignalType... signalTypeArr) {
        return log(str, level, false, signalTypeArr);
    }

    public final ParallelFlux<T> log() {
        return log(null, Level.INFO, new SignalType[0]);
    }

    public static <T> ParallelFlux<T> from(qd.c cVar, int i) {
        return from(cVar, i, Queues.SMALL_BUFFER_SIZE, Queues.small());
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qd.c> function, boolean z10) {
        return flatMap(function, z10, Reader.READ_DONE, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qd.c> function, boolean z10, int i) {
        return flatMap(function, z10, i, Queues.SMALL_BUFFER_SIZE);
    }

    public final <R> ParallelFlux<R> flatMap(Function<? super T, ? extends qd.c> function) {
        return flatMap(function, false, Reader.READ_DONE, Queues.SMALL_BUFFER_SIZE);
    }

    public static <T> ParallelFlux<T> from(ParallelFlux<T> parallelFlux) {
        return ContextPropagationSupport.shouldWrapPublisher(parallelFlux) ? new ParallelFluxRestoringThreadLocals(parallelFlux) : parallelFlux;
    }

    public final ParallelFlux<T> checkpoint(String str) {
        return new ParallelFluxOnAssembly(this, new FluxOnAssembly.CheckpointLightSnapshot(str));
    }

    @SafeVarargs
    public static <T> ParallelFlux<T> from(qd.c... cVarArr) {
        return onAssembly(new ParallelArraySource(cVarArr));
    }

    public final ParallelFlux<T> checkpoint() {
        return new ParallelFluxOnAssembly(this, new FluxOnAssembly.CheckpointHeavySnapshot(null, Traces.callSiteSupplierFactory.get()));
    }

    public final Flux<T> sorted(Comparator<? super T> comparator) {
        return sorted(comparator, 16);
    }

    public final Mono<List<T>> collectSortedList(Comparator<? super T> comparator) {
        return collectSortedList(comparator, 16);
    }

    public final Disposable subscribe() {
        return subscribe(null, null, null);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, null, null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable) {
        return subscribe(consumer, consumer2, runnable, null, null);
    }

    @Override // reactor.core.CorePublisher
    public final void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        sequential().subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(Operators.toCoreSubscriber(coreSubscriber))));
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qd.e> consumer3) {
        return subscribe(consumer, consumer2, runnable, consumer3, null);
    }

    public final Disposable subscribe(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Context context) {
        return subscribe(consumer, consumer2, runnable, null, context);
    }

    @Override // reactor.core.CorePublisher, qd.c
    public final void subscribe(qd.d dVar) {
        Operators.onLastAssembly(sequential()).subscribe((CoreSubscriber) Operators.toCoreSubscriber(new FluxHide.SuppressFuseableSubscriber(Operators.toCoreSubscriber(dVar))));
    }
}
