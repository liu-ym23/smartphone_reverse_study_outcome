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

/* loaded from: classes4.dex */
public abstract class Hooks {
    private static final String CONTEXT_IN_THREAD_LOCALS_KEY = "CONTEXT_IN_THREAD_LOCALS";
    static final String KEY_ON_DISCARD = "reactor.onDiscard.local";
    static final String KEY_ON_ERROR_DROPPED = "reactor.onErrorDropped.local";
    static final String KEY_ON_NEXT_DROPPED = "reactor.onNextDropped.local";
    static final String KEY_ON_OPERATOR_ERROR = "reactor.onOperatorError.local";
    static final String KEY_ON_REJECTED_EXECUTION = "reactor.onRejectedExecution.local";
    static Function<Z9.c, Z9.c> onEachOperatorHook;
    static volatile Consumer<? super Throwable> onErrorDroppedHook;
    static volatile Function<Z9.c, Z9.c> onLastOperatorHook;
    static volatile Consumer<Object> onNextDroppedHook;
    static volatile OnNextFailureStrategy onNextErrorHook;
    static volatile BiFunction<? super Throwable, Object, ? extends Throwable> onOperatorErrorHook;
    private static final LinkedHashMap<String, Function<Queue<?>, Queue<?>>> QUEUE_WRAPPERS = new LinkedHashMap<>(1);
    private static Function<Queue<?>, Queue<?>> QUEUE_WRAPPER = Function.identity();
    static final Logger log = Loggers.getLogger((Class<?>) Hooks.class);
    static boolean GLOBAL_TRACE = initStaticGlobalTrace();
    static boolean DETECT_CONTEXT_LOSS = false;
    private static final LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> onEachOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> onLastOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, BiFunction<? super Throwable, Object, ? extends Throwable>> onOperatorErrorHooks = new LinkedHashMap<>(1);

    public static <T, P extends Z9.c> Z9.c addAssemblyInfo(P p, FluxOnAssembly.AssemblySnapshot assemblySnapshot) {
        return p instanceof Callable ? p instanceof Mono ? new MonoCallableOnAssembly((Mono) p, assemblySnapshot) : new FluxCallableOnAssembly((Flux) p, assemblySnapshot) : p instanceof Mono ? new MonoOnAssembly((Mono) p, assemblySnapshot) : p instanceof ParallelFlux ? new ParallelFluxOnAssembly((ParallelFlux) p, assemblySnapshot) : p instanceof ConnectableFlux ? new ConnectableFluxOnAssembly((ConnectableFlux) p, assemblySnapshot) : new FluxOnAssembly((Flux) p, assemblySnapshot);
    }

    @Nullable
    @Deprecated
    public static <T, P extends Z9.c> Z9.c addCallSiteInfo(@Nullable P p, String str) {
        if (p == null) {
            return null;
        }
        return addAssemblyInfo(p, new FluxOnAssembly.AssemblySnapshot(str));
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
    public static <T, P extends Z9.c> Z9.c addReturnInfo(@Nullable P p, String str) {
        if (p == null) {
            return null;
        }
        return addAssemblyInfo(p, new FluxOnAssembly.MethodReturnSnapshot(str));
    }

    public static <T> Flux<T> convertToFluxBypassingHooks(Z9.c cVar) {
        return Flux.wrap(cVar);
    }

    public static <T> Mono<T> convertToMonoBypassingHooks(Z9.c cVar, boolean z10) {
        return Mono.wrap(cVar, z10);
    }

    @Nullable
    public static BiFunction<? super Throwable, Object, ? extends Throwable> createOrUpdateOpErrorHook(Collection<BiFunction<? super Throwable, Object, ? extends Throwable>> collection) {
        BiFunction<? super Throwable, Object, ? extends Throwable> c1890f = null;
        for (BiFunction<? super Throwable, Object, ? extends Throwable> biFunction : collection) {
            c1890f = c1890f != null ? new C1890f(1, biFunction, c1890f) : biFunction;
        }
        return c1890f;
    }

    @Nullable
    public static Function<Z9.c, Z9.c> createOrUpdateOpHook(Collection<Function<? super Z9.c, ? extends Z9.c>> collection) {
        Function functionAndThen = null;
        for (Function<? super Z9.c, ? extends Z9.c> function : collection) {
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

    public static final Map<String, Function<? super Z9.c, ? extends Z9.c>> getOnEachOperatorHooks() {
        return Collections.unmodifiableMap(onEachOperatorHooks);
    }

    public static final Map<String, Function<? super Z9.c, ? extends Z9.c>> getOnLastOperatorHooks() {
        return Collections.unmodifiableMap(onLastOperatorHooks);
    }

    public static final Map<String, BiFunction<? super Throwable, Object, ? extends Throwable>> getOnOperatorErrorHooks() {
        return Collections.unmodifiableMap(onOperatorErrorHooks);
    }

    public static boolean initStaticGlobalTrace() {
        return Boolean.parseBoolean(System.getProperty("reactor.trace.operatorStacktrace", "false"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$createOrUpdateOpErrorHook$1(BiFunction biFunction, BiFunction biFunction2, Throwable th, Object obj) {
        return (Throwable) biFunction.apply(biFunction2.apply(th, obj), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onNextDroppedFail$0(Object obj) {
        throw Exceptions.failWithCancel();
    }

    public static void onEachOperator(Function<? super Z9.c, ? extends Z9.c> function) {
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

    public static void onLastOperator(Function<? super Z9.c, ? extends Z9.c> function) {
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
            onNextDroppedHook = new N(5);
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
            LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> linkedHashMap = onEachOperatorHooks;
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
            LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> linkedHashMap = onLastOperatorHooks;
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

    public static void onEachOperator(String str, Function<? super Z9.c, ? extends Z9.c> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onEachOperator");
        Logger logger = log;
        logger.debug("Hooking onEachOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> linkedHashMap = onEachOperatorHooks;
            linkedHashMap.put(str, function);
            onEachOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
    }

    public static void onLastOperator(String str, Function<? super Z9.c, ? extends Z9.c> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onLastOperator");
        Logger logger = log;
        logger.debug("Hooking onLastOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super Z9.c, ? extends Z9.c>> linkedHashMap = onLastOperatorHooks;
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
