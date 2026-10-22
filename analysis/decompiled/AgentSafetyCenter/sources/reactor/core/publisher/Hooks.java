package reactor.core.publisher;

import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class Hooks {
    private static final String CONTEXT_IN_THREAD_LOCALS_KEY = "CONTEXT_IN_THREAD_LOCALS";
    static final String KEY_ON_DISCARD = "reactor.onDiscard.local";
    static final String KEY_ON_ERROR_DROPPED = "reactor.onErrorDropped.local";
    static final String KEY_ON_NEXT_DROPPED = "reactor.onNextDropped.local";
    static final String KEY_ON_OPERATOR_ERROR = "reactor.onOperatorError.local";
    static final String KEY_ON_REJECTED_EXECUTION = "reactor.onRejectedExecution.local";
    static Function<qd.c, qd.c> onEachOperatorHook;
    static volatile Consumer<? super Throwable> onErrorDroppedHook;
    static volatile Function<qd.c, qd.c> onLastOperatorHook;
    static volatile Consumer<Object> onNextDroppedHook;
    static volatile OnNextFailureStrategy onNextErrorHook;
    static volatile BiFunction<? super Throwable, Object, ? extends Throwable> onOperatorErrorHook;
    private static final LinkedHashMap<String, Function<Queue<?>, Queue<?>>> QUEUE_WRAPPERS = new LinkedHashMap<>(1);
    private static Function<Queue<?>, Queue<?>> QUEUE_WRAPPER = Function.identity();
    static final Logger log = Loggers.getLogger((Class<?>) Hooks.class);
    static boolean GLOBAL_TRACE = initStaticGlobalTrace();
    static boolean DETECT_CONTEXT_LOSS = false;
    private static final LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> onEachOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> onLastOperatorHooks = new LinkedHashMap<>(1);
    private static final LinkedHashMap<String, BiFunction<? super Throwable, Object, ? extends Throwable>> onOperatorErrorHooks = new LinkedHashMap<>(1);

    public static <T, P extends qd.c> qd.c addAssemblyInfo(P p3, FluxOnAssembly.AssemblySnapshot assemblySnapshot) {
        return p3 instanceof Callable ? p3 instanceof Mono ? new MonoCallableOnAssembly((Mono) p3, assemblySnapshot) : new FluxCallableOnAssembly((Flux) p3, assemblySnapshot) : p3 instanceof Mono ? new MonoOnAssembly((Mono) p3, assemblySnapshot) : p3 instanceof ParallelFlux ? new ParallelFluxOnAssembly((ParallelFlux) p3, assemblySnapshot) : p3 instanceof ConnectableFlux ? new ConnectableFluxOnAssembly((ConnectableFlux) p3, assemblySnapshot) : new FluxOnAssembly((Flux) p3, assemblySnapshot);
    }

    @Nullable
    @Deprecated
    public static <T, P extends qd.c> qd.c addCallSiteInfo(@Nullable P p3, String str) {
        if (p3 == null) {
            return null;
        }
        return addAssemblyInfo(p3, new FluxOnAssembly.AssemblySnapshot(str));
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
    public static <T, P extends qd.c> qd.c addReturnInfo(@Nullable P p3, String str) {
        if (p3 == null) {
            return null;
        }
        return addAssemblyInfo(p3, new FluxOnAssembly.MethodReturnSnapshot(str));
    }

    public static <T> Flux<T> convertToFluxBypassingHooks(qd.c cVar) {
        return Flux.wrap(cVar);
    }

    public static <T> Mono<T> convertToMonoBypassingHooks(qd.c cVar, boolean z10) {
        return Mono.wrap(cVar, z10);
    }

    @Nullable
    public static BiFunction<? super Throwable, Object, ? extends Throwable> createOrUpdateOpErrorHook(Collection<BiFunction<? super Throwable, Object, ? extends Throwable>> collection) {
        BiFunction<? super Throwable, Object, ? extends Throwable> biFunction = null;
        for (BiFunction<? super Throwable, Object, ? extends Throwable> biFunction2 : collection) {
            if (biFunction != null) {
                f fVar = new f(1);
                fVar.f10784f = biFunction2;
                fVar.f10785g = biFunction;
                VarHandle.storeStoreFence();
                biFunction = fVar;
            } else {
                biFunction = biFunction2;
            }
        }
        return biFunction;
    }

    @Nullable
    public static Function<qd.c, qd.c> createOrUpdateOpHook(Collection<Function<? super qd.c, ? extends qd.c>> collection) {
        Function functionAndThen = null;
        for (Function<? super qd.c, ? extends qd.c> function : collection) {
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

    public static final Map<String, Function<? super qd.c, ? extends qd.c>> getOnEachOperatorHooks() {
        return Collections.unmodifiableMap(onEachOperatorHooks);
    }

    public static final Map<String, Function<? super qd.c, ? extends qd.c>> getOnLastOperatorHooks() {
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

    public static void onEachOperator(String str, Function<? super qd.c, ? extends qd.c> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onEachOperator");
        Logger logger = log;
        logger.debug("Hooking onEachOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> linkedHashMap = onEachOperatorHooks;
            linkedHashMap.put(str, function);
            onEachOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
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

    public static void onLastOperator(String str, Function<? super qd.c, ? extends qd.c> function) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(function, "onLastOperator");
        Logger logger = log;
        logger.debug("Hooking onLastOperator: {}", str);
        synchronized (logger) {
            LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> linkedHashMap = onLastOperatorHooks;
            linkedHashMap.put(str, function);
            onLastOperatorHook = createOrUpdateOpHook(linkedHashMap.values());
        }
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
            onNextDroppedHook = new o0(5);
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
            LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> linkedHashMap = onEachOperatorHooks;
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
            LinkedHashMap<String, Function<? super qd.c, ? extends qd.c>> linkedHashMap = onLastOperatorHooks;
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

    public static void onEachOperator(Function<? super qd.c, ? extends qd.c> function) {
        onEachOperator(function.toString(), function);
    }

    public static void onLastOperator(Function<? super qd.c, ? extends qd.c> function) {
        onLastOperator(function.toString(), function);
    }

    public static void onOperatorError(BiFunction<? super Throwable, Object, ? extends Throwable> biFunction) {
        onOperatorError(biFunction.toString(), biFunction);
    }
}
