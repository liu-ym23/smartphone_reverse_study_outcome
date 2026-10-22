package reactor.core.publisher;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.Exceptions;
import reactor.core.publisher.FluxOnAssembly;
import reactor.core.publisher.OnNextFailureStrategy;
import reactor.core.scheduler.Schedulers;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public abstract class Hooks {
    private static final String CONTEXT_IN_THREAD_LOCALS_KEY = "CONTEXT_IN_THREAD_LOCALS";
    static final String KEY_ON_DISCARD = "reactor.onDiscard.local";
    static final String KEY_ON_ERROR_DROPPED = "reactor.onErrorDropped.local";
    static final String KEY_ON_NEXT_DROPPED = "reactor.onNextDropped.local";
    static final String KEY_ON_OPERATOR_ERROR = "reactor.onOperatorError.local";
    static final String KEY_ON_REJECTED_EXECUTION = "reactor.onRejectedExecution.local";
    static Function<qc.b, qc.b> onEachOperatorHook;
    static volatile Consumer<? super Throwable> onErrorDroppedHook;
    static volatile Function<qc.b, qc.b> onLastOperatorHook;
    static volatile Consumer<Object> onNextDroppedHook;
    static volatile OnNextFailureStrategy onNextErrorHook;
    static volatile BiFunction<? super Throwable, Object, ? extends Throwable> onOperatorErrorHook;
    private static final LinkedHashMap<String, Function<Queue<?>, Queue<?>>> QUEUE_WRAPPERS = new LinkedHashMap<>(1);
    private static Function<Queue<?>, Queue<?>> QUEUE_WRAPPER = Function.identity();
    static final Logger log = Loggers.getLogger((Class<?>) Hooks.class);
    static boolean GLOBAL_TRACE = initStaticGlobalTrace();
    static boolean DETECT_CONTEXT_LOSS = false;
    private static final LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> onEachOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> onLastOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, BiFunction<? super Throwable, Object, ? extends Throwable>> onOperatorErrorHooks = new LinkedHashMap<>(1);

    public static /* synthetic */ Throwable a(BiFunction biFunction, BiFunction biFunction2, Throwable th, Object obj) {
        return (Throwable) biFunction.apply(biFunction2.apply(th, obj), obj);
    }

    public static <T, P extends qc.b<T>> qc.b<T> addAssemblyInfo(P p10, FluxOnAssembly.AssemblySnapshot assemblySnapshot) {
        return p10 instanceof Callable ? p10 instanceof Mono ? new MonoCallableOnAssembly((Mono) p10, assemblySnapshot) : new FluxCallableOnAssembly((Flux) p10, assemblySnapshot) : p10 instanceof Mono ? new MonoOnAssembly((Mono) p10, assemblySnapshot) : p10 instanceof ParallelFlux ? new ParallelFluxOnAssembly((ParallelFlux) p10, assemblySnapshot) : p10 instanceof ConnectableFlux ? new ConnectableFluxOnAssembly((ConnectableFlux) p10, assemblySnapshot) : new FluxOnAssembly((Flux) p10, assemblySnapshot);
    }

    @Nullable
    @Deprecated
    public static <T, P extends qc.b<T>> qc.b<T> addCallSiteInfo(@Nullable P p10, String str) {
        if (p10 == null) {
            return null;
        }
        return addAssemblyInfo(p10, new FluxOnAssembly.AssemblySnapshot(str));
    }

    public static void addQueueWrapper(String str, Function<Queue<?>, Queue<?>> function) {
        LinkedHashMap<String, Function<Queue<?>, Queue<?>>> linkedHashMap = QUEUE_WRAPPERS;
        synchronized (linkedHashMap) {
            try {
                linkedHashMap.put(str, function);
                Function<Queue<?>, Queue<?>> functionAndThen = null;
                for (Function<Queue<?>, Queue<?>> function2 : linkedHashMap.values()) {
                    functionAndThen = functionAndThen == null ? function2 : functionAndThen.andThen(function2);
                }
                QUEUE_WRAPPER = functionAndThen;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    @Deprecated
    public static <T, P extends qc.b<T>> qc.b<T> addReturnInfo(@Nullable P p10, String str) {
        if (p10 == null) {
            return null;
        }
        return addAssemblyInfo(p10, new FluxOnAssembly.MethodReturnSnapshot(str));
    }

    public static /* synthetic */ void b(Object obj) {
        throw Exceptions.failWithCancel();
    }

    public static <T> Flux<T> convertToFluxBypassingHooks(qc.b<T> bVar) {
        return Flux.wrap(bVar);
    }

    public static <T> Mono<T> convertToMonoBypassingHooks(qc.b<T> bVar, boolean z10) {
        return Mono.wrap(bVar, z10);
    }

    @Nullable
    public static BiFunction<? super Throwable, Object, ? extends Throwable> createOrUpdateOpErrorHook(Collection<BiFunction<? super Throwable, Object, ? extends Throwable>> collection) {
        final BiFunction<? super Throwable, Object, ? extends Throwable> biFunction = null;
        for (final BiFunction<? super Throwable, Object, ? extends Throwable> biFunction2 : collection) {
            biFunction = biFunction != null ? new BiFunction() { // from class: reactor.core.publisher.W0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Hooks.a(biFunction2, biFunction, (Throwable) obj, obj2);
                }
            } : biFunction2;
        }
        return biFunction;
    }

    @Nullable
    public static Function<qc.b, qc.b> createOrUpdateOpHook(Collection<Function<? super qc.b<Object>, ? extends qc.b<Object>>> collection) {
        Function functionAndThen = null;
        for (Function<? super qc.b<Object>, ? extends qc.b<Object>> function : collection) {
            functionAndThen = functionAndThen != null ? functionAndThen.andThen(function) : function;
        }
        return functionAndThen;
    }

    public static void disableAutomaticContextPropagation() {
        if (ContextPropagationSupport.isContextPropagationOnClasspath) {
            removeQueueWrapper(CONTEXT_IN_THREAD_LOCALS_KEY);
            Schedulers.resetOnScheduleHook(CONTEXT_IN_THREAD_LOCALS_KEY);
            ContextPropagationSupport.propagateContextToThreadLocals = false;
        }
    }

    public static void disableContextLossTracking() {
        DETECT_CONTEXT_LOSS = false;
    }

    public static void enableAutomaticContextPropagation() {
        if (ContextPropagationSupport.isContextPropagationOnClasspath) {
            Schedulers.onScheduleHook(CONTEXT_IN_THREAD_LOCALS_KEY, ContextPropagation.scopePassingOnScheduleHook());
            ContextPropagationSupport.propagateContextToThreadLocals = true;
            ContextPropagation.configureContextSnapshotFactory(true);
        }
    }

    public static void enableContextLossTracking() {
        DETECT_CONTEXT_LOSS = true;
    }

    public static final Map<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> getOnEachOperatorHooks() {
        return Collections.unmodifiableMap(onEachOperatorHooks);
    }

    public static final Map<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> getOnLastOperatorHooks() {
        return Collections.unmodifiableMap(onLastOperatorHooks);
    }

    public static final Map<String, BiFunction<? super Throwable, Object, ? extends Throwable>> getOnOperatorErrorHooks() {
        return Collections.unmodifiableMap(onOperatorErrorHooks);
    }

    public static boolean initStaticGlobalTrace() {
        return Boolean.parseBoolean(System.getProperty("reactor.trace.operatorStacktrace", "false"));
    }

    public static void onEachOperator(Function<? super qc.b<Object>, ? extends qc.b<Object>> function) {
        onEachOperator(function.toString(), function);
    }

    public static void onErrorDropped(Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onErrorDroppedHook");
        Logger logger = log;
        logger.debug("Hooking new default : onErrorDropped");
        synchronized (logger) {
            try {
                if (onErrorDroppedHook != null) {
                    onErrorDroppedHook = onErrorDroppedHook.andThen(consumer);
                } else {
                    onErrorDroppedHook = consumer;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void onLastOperator(Function<? super qc.b<Object>, ? extends qc.b<Object>> function) {
        onLastOperator(function.toString(), function);
    }

    public static void onNextDropped(Consumer<Object> consumer) {
        Objects.requireNonNull(consumer, "onNextDroppedHook");
        Logger logger = log;
        logger.debug("Hooking new default : onNextDropped");
        synchronized (logger) {
            try {
                if (onNextDroppedHook != null) {
                    onNextDroppedHook = onNextDroppedHook.andThen(consumer);
                } else {
                    onNextDroppedHook = consumer;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void onNextDroppedFail() {
        Logger logger = log;
        logger.debug("Enabling failure mode for onNextDropped");
        synchronized (logger) {
            onNextDroppedHook = new Consumer() { // from class: reactor.core.publisher.V0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Hooks.b(obj);
                }
            };
        }
    }

    public static void onNextError(BiFunction<? super Throwable, Object, ? extends Throwable> biFunction) {
        Objects.requireNonNull(biFunction, "onNextError");
        Logger logger = log;
        logger.debug("Hooking new default : onNextError");
        if (biFunction instanceof OnNextFailureStrategy) {
            synchronized (logger) {
                onNextErrorHook = (OnNextFailureStrategy) biFunction;
            }
        } else {
            synchronized (logger) {
                onNextErrorHook = new OnNextFailureStrategy.LambdaOnNextErrorStrategy(biFunction);
            }
        }
    }

    public static void onOperatorDebug() {
        log.debug("Enabling stacktrace debugging via onOperatorDebug");
        GLOBAL_TRACE = true;
    }

    public static void onOperatorError(BiFunction<? super Throwable, Object, ? extends Throwable> biFunction) {
        onOperatorError(biFunction.toString(), biFunction);
    }

    public static void removeQueueWrapper(String str) {
        LinkedHashMap<String, Function<Queue<?>, Queue<?>>> linkedHashMap = QUEUE_WRAPPERS;
        synchronized (linkedHashMap) {
            try {
                linkedHashMap.remove(str);
                if (linkedHashMap.isEmpty()) {
                    QUEUE_WRAPPER = Function.identity();
                } else {
                    Function<Queue<?>, Queue<?>> functionAndThen = null;
                    for (Function<Queue<?>, Queue<?>> function : linkedHashMap.values()) {
                        functionAndThen = functionAndThen == null ? function : functionAndThen.andThen(function);
                    }
                    QUEUE_WRAPPER = functionAndThen;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void removeQueueWrappers() {
        LinkedHashMap<String, Function<Queue<?>, Queue<?>>> linkedHashMap = QUEUE_WRAPPERS;
        synchronized (linkedHashMap) {
            linkedHashMap.clear();
            QUEUE_WRAPPER = Function.identity();
        }
    }

    public static void resetOnEachOperator(String str) {
        Objects.requireNonNull(str, "key");
        Logger logger = log;
        logger.debug("Reset onEachOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> linkedHashMap = onEachOperatorHooks;
            linkedHashMap.remove(str);
            onEachOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
    }

    public static void resetOnErrorDropped() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onErrorDropped");
        synchronized (logger) {
            onErrorDroppedHook = null;
        }
    }

    public static void resetOnLastOperator(String str) {
        Objects.requireNonNull(str, "key");
        Logger logger = log;
        logger.debug("Reset onLastOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> linkedHashMap = onLastOperatorHooks;
            linkedHashMap.remove(str);
            onLastOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
    }

    public static void resetOnNextDropped() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onNextDropped");
        synchronized (logger) {
            onNextDroppedHook = null;
        }
    }

    public static void resetOnNextError() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onNextError");
        synchronized (logger) {
            onNextErrorHook = null;
        }
    }

    public static void resetOnOperatorDebug() {
        GLOBAL_TRACE = false;
    }

    public static void resetOnOperatorError(String str) {
        Objects.requireNonNull(str, "key");
        Logger logger = log;
        logger.debug("Reset onOperatorError: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, BiFunction<? super Throwable, Object, ? extends Throwable>> linkedHashMap = onOperatorErrorHooks;
            linkedHashMap.remove(str);
            onOperatorErrorHook = createOrUpdateOpErrorHook(linkedHashMap.values());
        }
    }

    public static <T> Queue<T> wrapQueue(Queue<T> queue) {
        return (Queue) QUEUE_WRAPPER.apply(queue);
    }

    public static void onEachOperator(String str, Function<? super qc.b<Object>, ? extends qc.b<Object>> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onEachOperator");
        Logger logger = log;
        logger.debug("Hooking onEachOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> linkedHashMap = onEachOperatorHooks;
            linkedHashMap.put(str, function);
            onEachOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
    }

    public static void onLastOperator(String str, Function<? super qc.b<Object>, ? extends qc.b<Object>> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onLastOperator");
        Logger logger = log;
        logger.debug("Hooking onLastOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qc.b<Object>, ? extends qc.b<Object>>> linkedHashMap = onLastOperatorHooks;
            linkedHashMap.put(str, function);
            onLastOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
    }

    public static void onOperatorError(String str, BiFunction<? super Throwable, Object, ? extends Throwable> biFunction) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(biFunction, "onOperatorError");
        Logger logger = log;
        logger.debug("Hooking onOperatorError: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, BiFunction<? super Throwable, Object, ? extends Throwable>> linkedHashMap = onOperatorErrorHooks;
            linkedHashMap.put(str, biFunction);
            onOperatorErrorHook = createOrUpdateOpErrorHook(linkedHashMap.values());
        }
    }

    public static void resetOnEachOperator() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onEachOperator");
        synchronized (logger) {
            onEachOperatorHooks.clear();
            onEachOperatorHook = null;
        }
    }

    public static void resetOnLastOperator() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onLastOperator");
        synchronized (logger) {
            onLastOperatorHooks.clear();
            onLastOperatorHook = null;
        }
    }

    public static void resetOnOperatorError() {
        Logger logger = log;
        logger.debug("Reset to factory defaults : onOperatorError");
        synchronized (logger) {
            onOperatorErrorHooks.clear();
            onOperatorErrorHook = null;
        }
    }
}
