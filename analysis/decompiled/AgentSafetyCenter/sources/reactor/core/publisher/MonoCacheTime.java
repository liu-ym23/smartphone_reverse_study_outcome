package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class MonoCacheTime<T> extends InternalMonoOperator<T, T> implements Runnable {
    final Scheduler clock;
    volatile Signal<T> state;
    final Function<? super Signal<T>, Duration> ttlGenerator;
    private static final Duration DURATION_INFINITE = Duration.ofMillis(Long.MAX_VALUE);
    private static final Logger LOGGER = Loggers.getLogger((Class<?>) MonoCacheTime.class);
    static final AtomicReferenceFieldUpdater<MonoCacheTime, Signal> STATE = AtomicReferenceFieldUpdater.newUpdater(MonoCacheTime.class, Signal.class, "state");
    static final Signal<?> EMPTY = new ImmutableSignal(Context.empty(), SignalType.ON_NEXT, null, null, null);

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
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CoordinatorSubscriber<T> implements InnerConsumer<T>, Signal<T> {
        final MonoCacheTime<T> main;
        volatile Operators.MonoSubscriber<T, T>[] subscribers = EMPTY;
        volatile qd.e subscription;
        static final AtomicReferenceFieldUpdater<CoordinatorSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(CoordinatorSubscriber.class, qd.e.class, "subscription");
        static final AtomicReferenceFieldUpdater<CoordinatorSubscriber, Operators.MonoSubscriber[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(CoordinatorSubscriber.class, Operators.MonoSubscriber[].class, "subscribers");
        private static final Operators.MonoSubscriber[] TERMINATED = new Operators.MonoSubscriber[0];
        private static final Operators.MonoSubscriber[] EMPTY = new Operators.MonoSubscriber[0];

        public CoordinatorSubscriber(MonoCacheTime<T> monoCacheTime) {
            this.main = monoCacheTime;
        }

        private void signalCached(Signal<T> signal) {
            Signal<T> signalError;
            Duration durationApply;
            if (MonoCacheTime.STATE.compareAndSet(this.main, this, signal)) {
                try {
                    durationApply = this.main.ttlGenerator.apply(signal);
                    signalError = signal;
                } catch (Throwable th) {
                    signalError = Signal.error(th);
                    MonoCacheTime.STATE.set(this.main, signalError);
                    if (signal.isOnError()) {
                        Exceptions.addSuppressed(th, signal.getThrowable());
                    }
                    durationApply = null;
                }
                if (durationApply == null) {
                    if (signal.isOnNext()) {
                        Operators.onNextDropped(signal.get(), currentContext());
                    }
                    this.main.run();
                } else if (durationApply.isZero()) {
                    this.main.run();
                } else if (!durationApply.equals(MonoCacheTime.DURATION_INFINITE)) {
                    MonoCacheTime<T> monoCacheTime = this.main;
                    monoCacheTime.clock.schedule(monoCacheTime, durationApply.toNanos(), TimeUnit.NANOSECONDS);
                }
                signal = signalError;
            }
            for (Operators.MonoSubscriber monoSubscriber : SUBSCRIBERS.getAndSet(this, TERMINATED)) {
                if (signal.isOnNext()) {
                    monoSubscriber.complete(signal.get());
                } else if (signal.isOnError()) {
                    monoSubscriber.onError(signal.getThrowable());
                } else {
                    monoSubscriber.onComplete();
                }
            }
        }

        public final boolean add(Operators.MonoSubscriber<T, T> monoSubscriber) {
            Operators.MonoSubscriber<T, T>[] monoSubscriberArr;
            Operators.MonoSubscriber[] monoSubscriberArr2;
            do {
                monoSubscriberArr = this.subscribers;
                if (monoSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = monoSubscriberArr.length;
                monoSubscriberArr2 = new Operators.MonoSubscriber[length + 1];
                System.arraycopy(monoSubscriberArr, 0, monoSubscriberArr2, 0, length);
                monoSubscriberArr2[length] = monoSubscriber;
            } while (!SUBSCRIBERS.compareAndSet(this, monoSubscriberArr, monoSubscriberArr2));
            return true;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Operators.multiSubscribersContext(this.subscribers);
        }

        @Override // reactor.core.publisher.Signal, java.util.function.Supplier
        public T get() {
            throw new UnsupportedOperationException("illegal signal use");
        }

        @Override // reactor.core.publisher.Signal
        public ContextView getContextView() {
            throw new UnsupportedOperationException("illegal signal use: getContextView");
        }

        @Override // reactor.core.publisher.Signal
        public qd.e getSubscription() {
            throw new UnsupportedOperationException("illegal signal use");
        }

        @Override // reactor.core.publisher.Signal
        public Throwable getThrowable() {
            throw new UnsupportedOperationException("illegal signal use");
        }

        @Override // reactor.core.publisher.Signal
        public SignalType getType() {
            throw new UnsupportedOperationException("illegal signal use");
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            signalCached(Signal.complete());
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.main.state != this) {
                Operators.onErrorDroppedMulticast(th, this.subscribers);
            } else {
                signalCached(Signal.error(th));
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.main.state != this) {
                Operators.onNextDroppedMulticast(t10, this.subscribers);
            } else {
                signalCached(Signal.next(t10));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.subscription, eVar)) {
                this.subscription = eVar;
                eVar.request(Long.MAX_VALUE);
            }
        }

        public final void remove(Operators.MonoSubscriber<T, T> monoSubscriber) {
            Operators.MonoSubscriber<T, T>[] monoSubscriberArr;
            Operators.MonoSubscriber[] monoSubscriberArr2;
            do {
                monoSubscriberArr = this.subscribers;
                if (monoSubscriberArr == TERMINATED || monoSubscriberArr == EMPTY) {
                    return;
                }
                int length = monoSubscriberArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (monoSubscriberArr[i] == monoSubscriber) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    monoSubscriberArr2 = EMPTY;
                } else {
                    Operators.MonoSubscriber[] monoSubscriberArr3 = new Operators.MonoSubscriber[length - 1];
                    System.arraycopy(monoSubscriberArr, 0, monoSubscriberArr3, 0, i);
                    System.arraycopy(monoSubscriberArr, i + 1, monoSubscriberArr3, i, (length - i) - 1);
                    monoSubscriberArr2 = monoSubscriberArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, monoSubscriberArr, monoSubscriberArr2));
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

    public MonoCacheTime(Mono<? extends T> mono, Function<? super T, Duration> function, Function<Throwable, Duration> function2, Supplier<Duration> supplier, Scheduler scheduler) {
        super(mono);
        Objects.requireNonNull(function, "valueTtlGenerator must not be null");
        Objects.requireNonNull(function2, "errorTtlGenerator must not be null");
        Objects.requireNonNull(supplier, "emptyTtlGenerator must not be null");
        Objects.requireNonNull(scheduler, "clock must not be null");
        z0 z0Var = new z0();
        z0Var.f10886a = function;
        z0Var.f10887b = function2;
        z0Var.f10888c = supplier;
        VarHandle.storeStoreFence();
        this.ttlGenerator = z0Var;
        this.clock = scheduler;
        this.state = (Signal<T>) EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Duration lambda$new$1(Signal signal) {
        return DURATION_INFINITE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Duration lambda$new$2(Function function, Function function2, Supplier supplier, Signal signal) {
        return signal.isOnNext() ? (Duration) function.apply(signal.get()) : signal.isOnError() ? (Duration) function2.apply(signal.getThrowable()) : (Duration) supplier.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        LOGGER.debug("expired {}", this.state);
        this.state = (Signal<T>) EMPTY;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        CoordinatorSubscriber<T> coordinatorSubscriber;
        boolean z10;
        CacheMonoSubscriber cacheMonoSubscriber = new CacheMonoSubscriber(coreSubscriber);
        coreSubscriber.onSubscribe(cacheMonoSubscriber);
        while (true) {
            Signal<T> signal = this.state;
            Signal<?> signal2 = EMPTY;
            if (signal != signal2 && !(signal instanceof CoordinatorSubscriber)) {
                if (signal.isOnNext()) {
                    cacheMonoSubscriber.complete(signal.get());
                    return null;
                }
                if (signal.isOnComplete()) {
                    cacheMonoSubscriber.onComplete();
                    return null;
                }
                cacheMonoSubscriber.onError(signal.getThrowable());
                return null;
            }
            if (signal == signal2) {
                coordinatorSubscriber = new CoordinatorSubscriber<>(this);
                if (STATE.compareAndSet(this, signal2, coordinatorSubscriber)) {
                    z10 = true;
                } else {
                    continue;
                }
            } else {
                coordinatorSubscriber = (CoordinatorSubscriber) signal;
                z10 = false;
            }
            if (coordinatorSubscriber.add(cacheMonoSubscriber)) {
                if (cacheMonoSubscriber.isCancelled()) {
                    coordinatorSubscriber.remove(cacheMonoSubscriber);
                } else {
                    cacheMonoSubscriber.coordinator = coordinatorSubscriber;
                }
                if (!z10) {
                    return null;
                }
                this.source.subscribe((CoreSubscriber) coordinatorSubscriber);
                return null;
            }
        }
    }

    public MonoCacheTime(Mono<? extends T> mono) {
        this(mono, new a(11), Schedulers.immediate());
    }

    public MonoCacheTime(Mono<? extends T> mono, Function<? super Signal<T>, Duration> function, Scheduler scheduler) {
        super(mono);
        this.ttlGenerator = function;
        this.clock = scheduler;
        this.state = (Signal<T>) EMPTY;
    }

    public MonoCacheTime(Mono<? extends T> mono, Duration duration, Scheduler scheduler) {
        super(mono);
        Objects.requireNonNull(duration, "ttl must not be null");
        Objects.requireNonNull(scheduler, "clock must not be null");
        a1 a1Var = new a1(0);
        a1Var.f10760b = duration;
        VarHandle.storeStoreFence();
        this.ttlGenerator = a1Var;
        this.clock = scheduler;
        this.state = (Signal<T>) EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Duration lambda$new$0(Duration duration, Signal signal) {
        return duration;
    }
}
