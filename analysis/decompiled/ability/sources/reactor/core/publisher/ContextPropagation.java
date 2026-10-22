package reactor.core.publisher;

import io.micrometer.context.ContextAccessor;
import io.micrometer.context.ContextRegistry;
import io.micrometer.context.ContextSnapshot;
import io.micrometer.context.ContextSnapshotFactory;
import io.micrometer.context.ThreadLocalAccessor;
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

/* loaded from: classes4.dex */
final class ContextPropagation {
    static final Function<Context, Context> NO_OP;
    static final Function<Context, Context> WITH_GLOBAL_REGISTRY_NO_PREDICATE;
    static ContextSnapshotFactory globalContextSnapshotFactory;

    public static final class ContextCaptureNoPredicate implements Function<Context, Context> {
        @Override // java.util.function.Function
        public Context apply(Context context) {
            return (Context) ContextPropagation.captureThreadLocals().updateContext(context);
        }
    }

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
            if (contextSnapshot.equals(ContextPropagation.captureThreadLocals())) {
                if (this.hasPrevious && Thread.currentThread().equals(this.lastReader)) {
                    return;
                }
                this.cleanOnNull = false;
                this.lastReader = Thread.currentThread();
                return;
            }
            if (!this.hasPrevious || !Thread.currentThread().equals(this.lastReader)) {
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
        public boolean offer(T t9) {
            return this.envelopeQueue.offer(new Envelope<>(t9, ContextPropagation.captureThreadLocals()));
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
        public final void doAfterComplete() throws Throwable {
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
        public final void doAfterError(Throwable th) throws Throwable {
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
        public final void doFinally(SignalType signalType) throws Throwable {
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
        public final void doFirst() throws Throwable {
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
        public final void doOnCancel() throws Throwable {
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
        public final void doOnComplete() throws Throwable {
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
        public final void doOnError(Throwable th) throws Throwable {
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
        public final void doOnFusion(int i) throws Throwable {
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
        public final void doOnMalformedOnComplete() throws Throwable {
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
        public final void doOnMalformedOnError(Throwable th) throws Throwable {
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
        public final void doOnMalformedOnNext(T t9) throws Throwable {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnMalformedOnNext(t9);
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
        public final void doOnNext(T t9) throws Throwable {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnNext(t9);
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
        public final void doOnRequest(long j5) throws Throwable {
            ContextSnapshot.Scope scopeRestoreThreadLocals = restoreThreadLocals();
            try {
                this.original.doOnRequest(j5);
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
        public final void doOnSubscription() throws Throwable {
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

    public static class Envelope<T> {
        final T body;
        final ContextSnapshot contextSnapshot;

        public Envelope(T t9, ContextSnapshot contextSnapshot) {
            this.body = t9;
            this.contextSnapshot = contextSnapshot;
        }
    }

    public static class ReactorScopeImpl implements ContextSnapshot.Scope {
        private final ContextRegistry contextRegistry;
        private final Map<Object, Object> previousValues;

        private ReactorScopeImpl(Map<Object, Object> map, ContextRegistry contextRegistry) {
            this.previousValues = map;
            this.contextRegistry = contextRegistry;
        }

        public static ContextSnapshot.Scope from(@Nullable Map<Object, Object> map, ContextRegistry contextRegistry) {
            return map != null ? new ReactorScopeImpl(map, contextRegistry) : new C1889e();
        }

        private static /* synthetic */ void lambda$from$0() {
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
    }

    public static class ReactorScopeImpl100 implements ContextSnapshot.Scope {
        private final ContextRegistry contextRegistry;
        private final Map<Object, Object> previousValues;

        private ReactorScopeImpl100(Map<Object, Object> map, ContextRegistry contextRegistry) {
            this.previousValues = map;
            this.contextRegistry = contextRegistry;
        }

        public static ContextSnapshot.Scope from(@Nullable Map<Object, Object> map, ContextRegistry contextRegistry) {
            return map != null ? new ReactorScopeImpl100(map, contextRegistry) : new C1889e();
        }

        private static /* synthetic */ void lambda$from$0() {
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
    }

    static {
        Function<Context, Context> c1885a = new C1885a(1);
        NO_OP = c1885a;
        if (ContextPropagationSupport.isContextPropagationAvailable()) {
            c1885a = new ContextCaptureNoPredicate();
        }
        WITH_GLOBAL_REGISTRY_NO_PREDICATE = c1885a;
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

    public static <T, R> BiConsumer<T, SynchronousSink<R>> contextRestoreForHandle(final BiConsumer<T, SynchronousSink<R>> biConsumer, Supplier<Context> supplier) {
        if (ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators()) {
            final Context context = supplier.get();
            if (!context.isEmpty()) {
                if (ContextPropagationSupport.isContextPropagation103OnClasspath) {
                    final int i = 0;
                    return new BiConsumer() { // from class: reactor.core.publisher.d
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj, Object obj2) {
                            switch (i) {
                                case 0:
                                    ContextPropagation.lambda$contextRestoreForHandle$2(context, biConsumer, obj, (SynchronousSink) obj2);
                                    break;
                                default:
                                    ContextPropagation.lambda$contextRestoreForHandle$3(context, biConsumer, obj, (SynchronousSink) obj2);
                                    break;
                            }
                        }
                    };
                }
                final int i6 = 1;
                return new BiConsumer() { // from class: reactor.core.publisher.d
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        switch (i6) {
                            case 0:
                                ContextPropagation.lambda$contextRestoreForHandle$2(context, biConsumer, obj, (SynchronousSink) obj2);
                                break;
                            default:
                                ContextPropagation.lambda$contextRestoreForHandle$3(context, biConsumer, obj, (SynchronousSink) obj2);
                                break;
                        }
                    }
                };
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$static$0(Context context) {
        return context;
    }

    public static <T> Mono<T> monoRestoreThreadLocals(Mono<? extends T> mono) {
        return new MonoContextWriteRestoringThreadLocals(mono, Function.identity());
    }

    public static Function<Runnable, Runnable> scopePassingOnScheduleHook() {
        return new C1885a(2);
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
}
