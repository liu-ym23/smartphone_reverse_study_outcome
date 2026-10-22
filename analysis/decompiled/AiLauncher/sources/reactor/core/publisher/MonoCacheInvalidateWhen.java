package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
final class MonoCacheInvalidateWhen<T> extends InternalMonoOperator<T, T> {
    private static final Logger LOGGER = Loggers.getLogger((Class<?>) MonoCacheInvalidateWhen.class);
    static final AtomicReferenceFieldUpdater<MonoCacheInvalidateWhen, MonoCacheInvalidateIf.State> STATE = AtomicReferenceFieldUpdater.newUpdater(MonoCacheInvalidateWhen.class, MonoCacheInvalidateIf.State.class, VoiceWakeupReceiver.EXTRA_STATE);

    @Nullable
    final Consumer<? super T> invalidateHandler;
    final Function<? super T, Mono<Void>> invalidationTriggerGenerator;
    volatile MonoCacheInvalidateIf.State<T> state;

    public static final class CacheMonoSubscriber<T> extends Operators.MonoSubscriber<T, T> {
        CoordinatorSubscriber<T> coordinator;

        public CacheMonoSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
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

    public static final class CoordinatorSubscriber<T> implements InnerConsumer<T>, MonoCacheInvalidateIf.State<T> {
        final MonoCacheInvalidateWhen<T> main;
        volatile CacheMonoSubscriber<T>[] subscribers = COORDINATOR_INIT;
        qc.d subscription;
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

        @Override // reactor.core.publisher.MonoCacheInvalidateIf.State
        public void clear() {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.main.state == this) {
                cacheLoadFailure(this, new NoSuchElementException("cacheInvalidateWhen expects a value, source completed empty"));
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.main.state != this) {
                Operators.onErrorDroppedMulticast(th, this.subscribers);
            } else {
                cacheLoadFailure(this, th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.main.state != this) {
                Operators.onNextDroppedMulticast(t10, this.subscribers);
            } else {
                cacheLoad(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                dVar.request(Long.MAX_VALUE);
            }
        }

        public final void remove(CacheMonoSubscriber<T> cacheMonoSubscriber) {
            while (true) {
                CacheMonoSubscriber<T>[] cacheMonoSubscriberArr = this.subscribers;
                if (cacheMonoSubscriberArr == COORDINATOR_DONE || cacheMonoSubscriberArr == COORDINATOR_INIT) {
                    return;
                }
                int length = cacheMonoSubscriberArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (cacheMonoSubscriberArr[i10] == cacheMonoSubscriber) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length != 1) {
                    CacheMonoSubscriber[] cacheMonoSubscriberArr2 = new CacheMonoSubscriber[length - 1];
                    System.arraycopy(cacheMonoSubscriberArr, 0, cacheMonoSubscriberArr2, 0, i10);
                    System.arraycopy(cacheMonoSubscriberArr, i10 + 1, cacheMonoSubscriberArr2, i10, (length - i10) - 1);
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
    }

    public static final class TriggerSubscriber implements InnerConsumer<Void> {
        final MonoCacheInvalidateWhen<?> main;

        public TriggerSubscriber(MonoCacheInvalidateWhen<?> monoCacheInvalidateWhen) {
            this.main = monoCacheInvalidateWhen;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Context.empty();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.main.invalidate();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            MonoCacheInvalidateWhen.LOGGER.debug("Invalidation triggered by onError(" + th + ")");
            this.main.invalidate();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Void r12) {
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            dVar.request(1L);
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
    }

    public MonoCacheInvalidateWhen(Mono<T> mono, Function<? super T, Mono<Void>> function, @Nullable Consumer<? super T> consumer) {
        super(mono);
        Objects.requireNonNull(function, "invalidationTriggerGenerator");
        this.invalidationTriggerGenerator = function;
        this.invalidateHandler = consumer;
        this.state = (MonoCacheInvalidateIf.State<T>) MonoCacheInvalidateIf.EMPTY_STATE;
    }

    public static /* synthetic */ String R(Object obj, boolean z10) {
        if (!z10) {
            return "Failed to apply invalidate handler";
        }
        return "Failed to apply invalidate handler on value " + obj;
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

    public void safeInvalidateHandler(@Nullable final T t10) {
        Consumer<? super T> consumer;
        if (t10 == null || (consumer = this.invalidateHandler) == null) {
            return;
        }
        try {
            consumer.accept(t10);
        } catch (Throwable th) {
            LOGGER.warnOrDebug(new Logger.ChoiceOfMessageSupplier() { // from class: reactor.core.publisher.N1
                @Override // reactor.util.Logger.ChoiceOfMessageSupplier
                public final String get(boolean z10) {
                    return MonoCacheInvalidateWhen.R(t10, z10);
                }
            }, th);
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
}
