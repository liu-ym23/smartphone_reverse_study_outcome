package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.MonoCacheInvalidateIf;
import reactor.core.publisher.Operators;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoCacheInvalidateWhen<T> extends InternalMonoOperator<T, T> {
    private static final Logger LOGGER = Loggers.getLogger((Class<?>) MonoCacheInvalidateWhen.class);
    static final AtomicReferenceFieldUpdater<MonoCacheInvalidateWhen, MonoCacheInvalidateIf.State> STATE = AtomicReferenceFieldUpdater.newUpdater(MonoCacheInvalidateWhen.class, MonoCacheInvalidateIf.State.class, "state");

    @Nullable
    final Consumer<? super T> invalidateHandler;
    final Function<? super T, Mono<Void>> invalidationTriggerGenerator;
    volatile MonoCacheInvalidateIf.State<T> state;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CacheMonoSubscriber<T> extends Operators.MonoSubscriber<T, T> {
        CoordinatorSubscriber<T> coordinator;

        public CacheMonoSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            super.cancel();
            CoordinatorSubscriber<T> coordinatorSubscriber = this.coordinator;
            if (coordinatorSubscriber != null) {
                coordinatorSubscriber.remove(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.coordinator.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoCacheInvalidateWhen(Mono<T> mono, Function<? super T, Mono<Void>> function, @Nullable Consumer<? super T> consumer) {
        super(mono);
        Objects.requireNonNull(function, "invalidationTriggerGenerator");
        this.invalidationTriggerGenerator = function;
        this.invalidateHandler = consumer;
        this.state = (MonoCacheInvalidateIf.State<T>) MonoCacheInvalidateIf.EMPTY_STATE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$safeInvalidateHandler$0(Object obj, boolean z10) {
        return z10 ? k0.a.l(obj, "Failed to apply invalidate handler on value ") : "Failed to apply invalidate handler";
    }

    public boolean compareAndInvalidate(MonoCacheInvalidateIf.State<T> state) {
        if (!STATE.compareAndSet(this, state, MonoCacheInvalidateIf.EMPTY_STATE)) {
            return false;
        }
        if (!(state instanceof MonoCacheInvalidateIf.ValueState)) {
            return true;
        }
        LOGGER.trace("invalidated {}", state.get());
        safeInvalidateHandler(state.get());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void invalidate() {
        MonoCacheInvalidateIf.State andSet = STATE.getAndSet(this, MonoCacheInvalidateIf.EMPTY_STATE);
        if (andSet instanceof MonoCacheInvalidateIf.ValueState) {
            LOGGER.trace("invalidated {}", andSet.get());
            safeInvalidateHandler(andSet.get());
        }
    }

    public void safeInvalidateHandler(@Nullable T t10) {
        Consumer<? super T> consumer;
        if (t10 == null || (consumer = this.invalidateHandler) == null) {
            return;
        }
        try {
            consumer.accept(t10);
        } catch (Throwable th) {
            Logger logger = LOGGER;
            y0 y0Var = new y0();
            y0Var.f10882a = t10;
            VarHandle.storeStoreFence();
            logger.warnOrDebug(y0Var, th);
        }
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        CoordinatorSubscriber<T> coordinatorSubscriber;
        boolean z10;
        CacheMonoSubscriber<T> cacheMonoSubscriber = new CacheMonoSubscriber<>(coreSubscriber);
        coreSubscriber.onSubscribe(cacheMonoSubscriber);
        while (true) {
            MonoCacheInvalidateIf.State<T> state = this.state;
            MonoCacheInvalidateIf.State<?> state2 = MonoCacheInvalidateIf.EMPTY_STATE;
            if (state != state2 && !(state instanceof CoordinatorSubscriber)) {
                cacheMonoSubscriber.complete(state.get());
                return null;
            }
            if (state == state2) {
                coordinatorSubscriber = new CoordinatorSubscriber<>(this);
                if (STATE.compareAndSet(this, state2, coordinatorSubscriber)) {
                    z10 = true;
                } else {
                    continue;
                }
            } else {
                coordinatorSubscriber = (CoordinatorSubscriber) state;
                z10 = false;
            }
            if (coordinatorSubscriber.add(cacheMonoSubscriber)) {
                if (cacheMonoSubscriber.isCancelled()) {
                    coordinatorSubscriber.remove(cacheMonoSubscriber);
                } else {
                    cacheMonoSubscriber.coordinator = coordinatorSubscriber;
                }
                if (z10) {
                    this.source.subscribe((CoreSubscriber) coordinatorSubscriber);
                }
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TriggerSubscriber implements InnerConsumer<Void> {
        final MonoCacheInvalidateWhen<?> main;

        public TriggerSubscriber(MonoCacheInvalidateWhen<?> monoCacheInvalidateWhen) {
            this.main = monoCacheInvalidateWhen;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Context.empty();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.main.invalidate();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            MonoCacheInvalidateWhen.LOGGER.debug("Invalidation triggered by onError(" + th + ")");
            this.main.invalidate();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            eVar.request(1L);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.main;
            }
            boolean z10 = true;
            if (attr != Scannable.Attr.TERMINATED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PREFETCH ? 1 : null;
            }
            if (this.main.state != MonoCacheInvalidateIf.EMPTY_STATE && !(this.main.state instanceof CoordinatorSubscriber)) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Void r12) {
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CoordinatorSubscriber<T> implements InnerConsumer<T>, MonoCacheInvalidateIf.State<T> {
        final MonoCacheInvalidateWhen<T> main;
        volatile CacheMonoSubscriber<T>[] subscribers = COORDINATOR_INIT;
        qd.e subscription;
        static final AtomicReferenceFieldUpdater<CoordinatorSubscriber, CacheMonoSubscriber[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(CoordinatorSubscriber.class, CacheMonoSubscriber[].class, "subscribers");
        private static final CacheMonoSubscriber[] COORDINATOR_DONE = new CacheMonoSubscriber[0];
        private static final CacheMonoSubscriber[] COORDINATOR_INIT = new CacheMonoSubscriber[0];

        public CoordinatorSubscriber(MonoCacheInvalidateWhen<T> monoCacheInvalidateWhen) {
            this.main = monoCacheInvalidateWhen;
        }

        public final boolean add(CacheMonoSubscriber<T> cacheMonoSubscriber) {
            CacheMonoSubscriber<T>[] cacheMonoSubscriberArr;
            CacheMonoSubscriber[] cacheMonoSubscriberArr2;
            do {
                cacheMonoSubscriberArr = this.subscribers;
                if (cacheMonoSubscriberArr == COORDINATOR_DONE) {
                    return false;
                }
                int length = cacheMonoSubscriberArr.length;
                cacheMonoSubscriberArr2 = new CacheMonoSubscriber[length + 1];
                System.arraycopy(cacheMonoSubscriberArr, 0, cacheMonoSubscriberArr2, 0, length);
                cacheMonoSubscriberArr2[length] = cacheMonoSubscriber;
            } while (!SUBSCRIBERS.compareAndSet(this, cacheMonoSubscriberArr, cacheMonoSubscriberArr2));
            return true;
        }

        public void cacheLoad(T t10) {
            MonoCacheInvalidateIf.ValueState valueState = new MonoCacheInvalidateIf.ValueState(t10);
            if (MonoCacheInvalidateWhen.STATE.compareAndSet(this.main, this, valueState)) {
                try {
                    Mono<Void> monoApply = this.main.invalidationTriggerGenerator.apply(t10);
                    Objects.requireNonNull(monoApply, "invalidationTriggerGenerator produced a null trigger");
                    Mono<Void> mono = monoApply;
                    for (CacheMonoSubscriber cacheMonoSubscriber : SUBSCRIBERS.getAndSet(this, COORDINATOR_DONE)) {
                        cacheMonoSubscriber.complete(t10);
                    }
                    mono.subscribe((CoreSubscriber<? super Void>) new TriggerSubscriber(this.main));
                } catch (Throwable th) {
                    if (cacheLoadFailure(valueState, th)) {
                        this.main.safeInvalidateHandler(t10);
                    }
                }
            }
        }

        public boolean cacheLoadFailure(MonoCacheInvalidateIf.State<T> state, Throwable th) {
            if (!MonoCacheInvalidateWhen.STATE.compareAndSet(this.main, state, MonoCacheInvalidateIf.EMPTY_STATE)) {
                return false;
            }
            for (CacheMonoSubscriber cacheMonoSubscriber : SUBSCRIBERS.getAndSet(this, COORDINATOR_DONE)) {
                cacheMonoSubscriber.onError(th);
            }
            return true;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Operators.multiSubscribersContext(this.subscribers);
        }

        @Override // reactor.core.publisher.MonoCacheInvalidateIf.State
        @Nullable
        public T get() {
            throw new UnsupportedOperationException("coordinator State#get shouldn't be used");
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.main.state == this) {
                cacheLoadFailure(this, new NoSuchElementException("cacheInvalidateWhen expects a value, source completed empty"));
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.main.state != this) {
                Operators.onErrorDroppedMulticast(th, this.subscribers);
            } else {
                cacheLoadFailure(this, th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.main.state != this) {
                Operators.onNextDroppedMulticast(t10, this.subscribers);
            } else {
                cacheLoad(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.subscription, eVar)) {
                this.subscription = eVar;
                eVar.request(Long.MAX_VALUE);
            }
        }

        public final void remove(CacheMonoSubscriber<T> cacheMonoSubscriber) {
            while (true) {
                CacheMonoSubscriber<T>[] cacheMonoSubscriberArr = this.subscribers;
                if (cacheMonoSubscriberArr == COORDINATOR_DONE || cacheMonoSubscriberArr == COORDINATOR_INIT) {
                    return;
                }
                int length = cacheMonoSubscriberArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cacheMonoSubscriberArr[i] == cacheMonoSubscriber) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length != 1) {
                    CacheMonoSubscriber[] cacheMonoSubscriberArr2 = new CacheMonoSubscriber[length - 1];
                    System.arraycopy(cacheMonoSubscriberArr, 0, cacheMonoSubscriberArr2, 0, i);
                    System.arraycopy(cacheMonoSubscriberArr, i + 1, cacheMonoSubscriberArr2, i, (length - i) - 1);
                    if (SUBSCRIBERS.compareAndSet(this, cacheMonoSubscriberArr, cacheMonoSubscriberArr2)) {
                        return;
                    }
                } else if (SUBSCRIBERS.compareAndSet(this, cacheMonoSubscriberArr, COORDINATOR_DONE)) {
                    if (this.main.compareAndInvalidate(this)) {
                        this.subscription.cancel();
                        return;
                    }
                    return;
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        @Override // reactor.core.publisher.MonoCacheInvalidateIf.State
        public void clear() {
        }
    }
}
