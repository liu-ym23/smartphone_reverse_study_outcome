package reactor.core.publisher;

import io.micrometer.context.ContextAccessor;
import io.micrometer.context.ContextRegistry;
import io.micrometer.context.ContextSnapshot;
import io.micrometer.context.ContextSnapshotFactory;
import io.micrometer.context.ThreadLocalAccessor;
import java.lang.invoke.VarHandle;
import java.util.AbstractQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.observability.SignalListener;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ContextPropagation {
    static final Function<Context, Context> NO_OP;
    static final Function<Context, Context> WITH_GLOBAL_REGISTRY_NO_PREDICATE;
    static ContextSnapshotFactory globalContextSnapshotFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ContextCaptureNoPredicate implements Function<Context, Context> {
        @Override // java.util.function.Function
        public Context apply(Context context) {
            return (Context) ContextPropagation.captureThreadLocals().updateContext(context);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ContextQueue<T> extends AbstractQueue<T> {
        static final String NOT_SUPPORTED_MESSAGE = "ContextQueue wrapper is intended for use with instances returned by Queues class. Iterator based methods are usually unsupported.";
        boolean cleanOnNull;
        final Queue<Envelope<T>> envelopeQueue;
        boolean hasPrevious = false;
        Thread lastReader;
        ContextSnapshot.Scope scope;

        /* JADX WARN: Multi-variable type inference failed */
        public ContextQueue(Queue<?> queue) {
            this.envelopeQueue = queue;
        }

        private void restoreTheContext(Envelope<T> envelope) {
            ContextSnapshot contextSnapshot = envelope.contextSnapshot;
            boolean zEquals = contextSnapshot.equals(ContextPropagation.captureThreadLocals());
            boolean z10 = this.hasPrevious;
            if (zEquals) {
                if (z10 && Thread.currentThread().equals(this.lastReader)) {
                    return;
                }
                this.cleanOnNull = false;
                this.lastReader = Thread.currentThread();
                return;
            }
            if (!z10 || !Thread.currentThread().equals(this.lastReader)) {
                this.cleanOnNull = true;
                this.lastReader = Thread.currentThread();
            }
            this.scope = contextSnapshot.setThreadLocals();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Queue
        public boolean offer(T t10) {
            return this.envelopeQueue.offer(new Envelope<>(t10, ContextPropagation.captureThreadLocals()));
        }

        @Override // java.util.Queue
        @Nullable
        public T peek() {
            Envelope<T> envelopePeek = this.envelopeQueue.peek();
            if (envelopePeek == null) {
                return null;
            }
            return envelopePeek.body;
        }

        @Override // java.util.Queue
        public T poll() {
            ContextSnapshot.Scope scope;
            Envelope<T> envelopePoll = this.envelopeQueue.poll();
            if (envelopePoll != null) {
                restoreTheContext(envelopePoll);
                this.hasPrevious = true;
                return envelopePoll.body;
            }
            if (this.cleanOnNull && (scope = this.scope) != null) {
                scope.close();
            }
            this.cleanOnNull = true;
            this.lastReader = Thread.currentThread();
            this.hasPrevious = false;
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.envelopeQueue.size();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ContextRestore103SignalListener<T> extends ContextRestoreSignalListener<T> {
        final ContextSnapshotFactory contextSnapshotFactory;

        public ContextRestore103SignalListener(SignalListener<T> signalListener, ContextView contextView, ContextSnapshotFactory contextSnapshotFactory) {
            super(signalListener, contextView);
            this.contextSnapshotFactory = contextSnapshotFactory;
        }

        @Override // reactor.core.publisher.ContextPropagation.ContextRestoreSignalListener
        public ContextSnapshot.Scope restoreThreadLocals() {
            return this.contextSnapshotFactory.setThreadLocalsFrom(this.context, new String[0]);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ContextRestoreSignalListener<T> implements SignalListener<T> {
        final ContextView context;
        final SignalListener<T> original;

        public ContextRestoreSignalListener(SignalListener<T> signalListener, ContextView contextView) {
            this.original = signalListener;
            this.context = contextView;
        }

        @Override // reactor.core.observability.SignalListener
        public final Context addToContext(Context context) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                Context contextAddToContext = this.original.addToContext(context);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
                return contextAddToContext;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doAfterComplete() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doAfterComplete();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doAfterError(Throwable th) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doAfterError(th);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doFinally(SignalType signalType) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doFinally(signalType);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doFirst() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doFirst();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnCancel() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnCancel();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnComplete() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnComplete();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnError(Throwable th) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnError(th);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnFusion(int i) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnFusion(i);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnMalformedOnComplete() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnMalformedOnComplete();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnMalformedOnError(Throwable th) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnMalformedOnError(th);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnMalformedOnNext(T t10) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnMalformedOnNext(t10);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnNext(T t10) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnNext(t10);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnRequest(long j10) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnRequest(j10);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void doOnSubscription() {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnSubscription();
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // reactor.core.observability.SignalListener
        public final void handleListenerError(Throwable th) {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.handleListenerError(th);
                if (scopeRestoreThreadLocals != null) {
                    scopeRestoreThreadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (scopeRestoreThreadLocals != null) {
                        try {
                            scopeRestoreThreadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        public ContextSnapshot.Scope restoreThreadLocals() {
            return ContextSnapshot.setAllThreadLocalsFrom(this.context);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Envelope<T> {
        final T body;
        final ContextSnapshot contextSnapshot;

        public Envelope(T t10, ContextSnapshot contextSnapshot) {
            this.body = t10;
            this.contextSnapshot = contextSnapshot;
        }
    }

    static {
        Function<Context, Context> aVar = new a(1);
        NO_OP = aVar;
        if (ContextPropagationSupport.isContextPropagationAvailable()) {
            aVar = new ContextCaptureNoPredicate();
        }
        WITH_GLOBAL_REGISTRY_NO_PREDICATE = aVar;
        if (ContextPropagationSupport.isContextPropagation103Available()) {
            globalContextSnapshotFactory = ContextSnapshotFactory.builder().clearMissing(false).build();
        }
    }

    public static ContextSnapshot captureThreadLocals() {
        return ContextPropagationSupport.isContextPropagation103OnClasspath ? globalContextSnapshotFactory.captureAll(new Object[0]) : ContextSnapshot.captureAll(new Object[0]);
    }

    public static void configureContextSnapshotFactory(boolean z10) {
        if (ContextPropagationSupport.isContextPropagation103OnClasspath) {
            globalContextSnapshotFactory = ContextSnapshotFactory.builder().clearMissing(z10).build();
        }
    }

    public static Function<Context, Context> contextCapture() {
        return WITH_GLOBAL_REGISTRY_NO_PREDICATE;
    }

    public static Context contextCaptureToEmpty() {
        return contextCapture().apply(Context.empty());
    }

    public static <T, R> BiConsumer<T, SynchronousSink<R>> contextRestoreForHandle(BiConsumer<T, SynchronousSink<R>> biConsumer, Supplier<Context> supplier) {
        if (ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators()) {
            Context context = supplier.get();
            if (!context.isEmpty()) {
                if (ContextPropagationSupport.isContextPropagation103OnClasspath) {
                    d dVar = new d(0);
                    dVar.f10773f = context;
                    dVar.f10774g = biConsumer;
                    VarHandle.storeStoreFence();
                    return dVar;
                }
                d dVar2 = new d(1);
                dVar2.f10773f = context;
                dVar2.f10774g = biConsumer;
                VarHandle.storeStoreFence();
                return dVar2;
            }
        }
        return biConsumer;
    }

    public static <T> SignalListener<T> contextRestoreForTap(SignalListener<T> signalListener, Supplier<Context> supplier) {
        if (ContextPropagationSupport.isContextPropagationAvailable()) {
            Context context = supplier.get();
            if (!context.isEmpty()) {
                return ContextPropagationSupport.isContextPropagation103OnClasspath ? new ContextRestore103SignalListener(signalListener, context, globalContextSnapshotFactory) : new ContextRestoreSignalListener(signalListener, context);
            }
        }
        return signalListener;
    }

    public static <T> Flux<T> fluxRestoreThreadLocals(Flux<? extends T> flux, boolean z10) {
        return z10 ? new FluxContextWriteRestoringThreadLocalsFuseable(flux, Function.identity()) : new FluxContextWriteRestoringThreadLocals(flux, Function.identity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contextRestoreForHandle$2(Context context, BiConsumer biConsumer, Object obj, SynchronousSink synchronousSink) {
        ContextSnapshot.Scope threadLocalsFrom = globalContextSnapshotFactory.setThreadLocalsFrom(context, new String[0]);
        try {
            biConsumer.accept(obj, synchronousSink);
            if (threadLocalsFrom != null) {
                threadLocalsFrom.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (threadLocalsFrom != null) {
                    try {
                        threadLocalsFrom.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contextRestoreForHandle$3(Context context, BiConsumer biConsumer, Object obj, SynchronousSink synchronousSink) {
        ContextSnapshot.Scope allThreadLocalsFrom = ContextSnapshot.setAllThreadLocalsFrom(context);
        try {
            biConsumer.accept(obj, synchronousSink);
            if (allThreadLocalsFrom != null) {
                allThreadLocalsFrom.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (allThreadLocalsFrom != null) {
                    try {
                        allThreadLocalsFrom.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Runnable lambda$scopePassingOnScheduleHook$1(Runnable runnable) {
        return captureThreadLocals().wrap(runnable);
    }

    public static <T> Mono<T> monoRestoreThreadLocals(Mono<? extends T> mono) {
        return new MonoContextWriteRestoringThreadLocals(mono, Function.identity());
    }

    public static Function<Runnable, Runnable> scopePassingOnScheduleHook() {
        return new a(2);
    }

    private static <V> Map<Object, Object> setThreadLocal(Object obj, @Nullable V v10, ThreadLocalAccessor<?> threadLocalAccessor, @Nullable Map<Object, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(obj, threadLocalAccessor.getValue());
        if (v10 != null) {
            threadLocalAccessor.setValue(v10);
            return map;
        }
        threadLocalAccessor.reset();
        return map;
    }

    public static <C> ContextSnapshot.Scope setThreadLocals(Object obj) {
        if (ContextPropagationSupport.isContextPropagation103OnClasspath) {
            return globalContextSnapshotFactory.setThreadLocalsFrom(obj, new String[0]);
        }
        ContextRegistry contextRegistry = ContextRegistry.getInstance();
        ContextAccessor contextAccessorForRead = contextRegistry.getContextAccessorForRead(obj);
        Map<Object, Object> threadLocal = null;
        for (ThreadLocalAccessor threadLocalAccessor : contextRegistry.getThreadLocalAccessors()) {
            Object objKey = threadLocalAccessor.key();
            threadLocal = setThreadLocal(objKey, contextAccessorForRead.readValue(obj, objKey), threadLocalAccessor, threadLocal);
        }
        return ContextPropagationSupport.isContextPropagation101Available() ? ReactorScopeImpl.from(threadLocal, contextRegistry) : ReactorScopeImpl100.from(threadLocal, contextRegistry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$static$0(Context context) {
        return context;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ReactorScopeImpl implements ContextSnapshot.Scope {
        private final ContextRegistry contextRegistry;
        private final Map<Object, Object> previousValues;

        private ReactorScopeImpl(Map<Object, Object> map, ContextRegistry contextRegistry) {
            this.previousValues = map;
            this.contextRegistry = contextRegistry;
        }

        public static ContextSnapshot.Scope from(@Nullable Map<Object, Object> map, ContextRegistry contextRegistry) {
            return map != null ? new ReactorScopeImpl(map, contextRegistry) : new e();
        }

        private <V> void resetThreadLocalValue(ThreadLocalAccessor<?> threadLocalAccessor, @Nullable V v10) {
            if (v10 != null) {
                threadLocalAccessor.restore(v10);
            } else {
                threadLocalAccessor.reset();
            }
        }

        public void close() {
            for (ThreadLocalAccessor<?> threadLocalAccessor : this.contextRegistry.getThreadLocalAccessors()) {
                if (this.previousValues.containsKey(threadLocalAccessor.key())) {
                    resetThreadLocalValue(threadLocalAccessor, this.previousValues.get(threadLocalAccessor.key()));
                }
            }
        }

        private static /* synthetic */ void lambda$from$0() {
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ReactorScopeImpl100 implements ContextSnapshot.Scope {
        private final ContextRegistry contextRegistry;
        private final Map<Object, Object> previousValues;

        private ReactorScopeImpl100(Map<Object, Object> map, ContextRegistry contextRegistry) {
            this.previousValues = map;
            this.contextRegistry = contextRegistry;
        }

        public static ContextSnapshot.Scope from(@Nullable Map<Object, Object> map, ContextRegistry contextRegistry) {
            return map != null ? new ReactorScopeImpl100(map, contextRegistry) : new e();
        }

        private <V> void resetThreadLocalValue(ThreadLocalAccessor<?> threadLocalAccessor, @Nullable V v10) {
            if (v10 != null) {
                threadLocalAccessor.setValue(v10);
            } else {
                threadLocalAccessor.reset();
            }
        }

        public void close() {
            for (ThreadLocalAccessor<?> threadLocalAccessor : this.contextRegistry.getThreadLocalAccessors()) {
                if (this.previousValues.containsKey(threadLocalAccessor.key())) {
                    resetThreadLocalValue(threadLocalAccessor, this.previousValues.get(threadLocalAccessor.key()));
                }
            }
        }

        private static /* synthetic */ void lambda$from$0() {
        }
    }
}
