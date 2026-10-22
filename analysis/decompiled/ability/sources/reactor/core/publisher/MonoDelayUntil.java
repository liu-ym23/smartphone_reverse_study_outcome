package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoDelayUntil<T> extends Mono<T> implements Scannable, OptimizableOperator<T, T> {

    @Nullable
    final OptimizableOperator<?, T> optimizableOperator;
    Function<? super T, ? extends Z9.c>[] otherGenerators;
    final Mono<T> source;

    public static final class DelayUntilCoordinator<T> implements InnerOperator<T, T> {
        static final int HAS_INNER = 2;
        static final int HAS_REQUEST = 4;
        static final int HAS_SUBSCRIPTION = 1;
        static final int HAS_VALUE = 8;
        static final int TERMINATED = Integer.MIN_VALUE;
        final CoreSubscriber<? super T> actual;
        boolean done;
        volatile Throwable error;
        int index;
        final Function<? super T, ? extends Z9.c>[] otherGenerators;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5846s;
        volatile int state;
        DelayUntilTrigger<?> triggerSubscriber;
        T value;
        static final AtomicReferenceFieldUpdater<DelayUntilCoordinator, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(DelayUntilCoordinator.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<DelayUntilCoordinator> STATE = AtomicIntegerFieldUpdater.newUpdater(DelayUntilCoordinator.class, "state");

        public DelayUntilCoordinator(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends Z9.c>[] functionArr) {
            this.actual = coreSubscriber;
            this.otherGenerators = functionArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            int iMarkTerminated = markTerminated();
            if (MonoDelayUntil.isTerminated(iMarkTerminated)) {
                return;
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
            if (MonoDelayUntil.hasSubscription(iMarkTerminated)) {
                this.f5846s.cancel();
            }
            if (MonoDelayUntil.hasInner(iMarkTerminated)) {
                Operators.onDiscard(this.value, this.actual.currentContext());
                this.triggerSubscriber.cancel();
            }
        }

        public void complete() {
            int i;
            do {
                i = this.state;
                if (MonoDelayUntil.isTerminated(i)) {
                    return;
                }
                if (MonoDelayUntil.hasRequest(i) && STATE.compareAndSet(this, i, Integer.MIN_VALUE)) {
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onNext(this.value);
                    coreSubscriber.onComplete();
                    return;
                }
            } while (!STATE.compareAndSet(this, i, i | 8));
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            DelayUntilTrigger<?> delayUntilTrigger = this.triggerSubscriber;
            return delayUntilTrigger == null ? Stream.empty() : Stream.of(delayUntilTrigger);
        }

        public int markHasRequest() {
            int i;
            do {
                i = this.state;
                if (!MonoDelayUntil.isTerminated(i)) {
                    if (MonoDelayUntil.hasRequest(i)) {
                        break;
                    }
                } else {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i, MonoDelayUntil.hasValue(i) ? Integer.MIN_VALUE : i | 4));
            return i;
        }

        public int markHasSubscription() {
            int i;
            do {
                i = this.state;
                if (MonoDelayUntil.isTerminated(i)) {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i, i | 1));
            return i;
        }

        public int markTerminated() {
            int i;
            do {
                i = this.state;
                if (MonoDelayUntil.isTerminated(i)) {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i, Integer.MIN_VALUE));
            return i;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (!this.done && this.value == null) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            if (this.value == null) {
                this.actual.onError(th);
                return;
            }
            AtomicReferenceFieldUpdater<DelayUntilCoordinator, Throwable> atomicReferenceFieldUpdater = ERROR;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            int iMarkTerminated = markTerminated();
            if (MonoDelayUntil.isTerminated(iMarkTerminated)) {
                return;
            }
            if (MonoDelayUntil.hasInner(iMarkTerminated)) {
                Operators.onDiscard(this.value, this.actual.currentContext());
                this.triggerSubscriber.cancel();
            }
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onDiscard(t9, this.actual.currentContext());
            } else {
                this.value = t9;
                subscribeNextTrigger();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5846s, eVar)) {
                this.f5846s = eVar;
                if (MonoDelayUntil.isTerminated(markHasSubscription())) {
                    eVar.cancel();
                } else {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                int iMarkHasRequest = markHasRequest();
                if (MonoDelayUntil.isTerminated(iMarkHasRequest) || MonoDelayUntil.hasRequest(iMarkHasRequest) || !MonoDelayUntil.hasValue(iMarkHasRequest)) {
                    return;
                }
                this.done = true;
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onNext(this.value);
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            boolean z10 = false;
            if (attr == Scannable.Attr.CANCELLED) {
                if (MonoDelayUntil.isTerminated(this.state) && !this.done) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.PREFETCH) {
                    return Integer.MAX_VALUE;
                }
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (MonoDelayUntil.isTerminated(this.state) && this.done) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }

        public void subscribeNextTrigger() {
            try {
                Z9.c cVarApply = this.otherGenerators[this.index].apply(this.value);
                Objects.requireNonNull(cVarApply, "mapper returned null value");
                DelayUntilTrigger<?> delayUntilTrigger = this.triggerSubscriber;
                if (delayUntilTrigger == null) {
                    delayUntilTrigger = new DelayUntilTrigger<>(this);
                    this.triggerSubscriber = delayUntilTrigger;
                }
                Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) delayUntilTrigger);
            } catch (Throwable th) {
                onError(th);
            }
        }
    }

    public static final class DelayUntilTrigger<T> implements InnerConsumer<T> {
        boolean done;
        Throwable error;
        final DelayUntilCoordinator<?> parent;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5847s;

        public DelayUntilTrigger(DelayUntilCoordinator<?> delayUntilCoordinator) {
            this.parent = delayUntilCoordinator;
        }

        public void cancel() {
            this.f5847s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public int markInnerActive() {
            int i;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            do {
                i = delayUntilCoordinator.state;
                if (MonoDelayUntil.isTerminated(i)) {
                    return Integer.MIN_VALUE;
                }
                if (MonoDelayUntil.hasInner(i)) {
                    break;
                }
            } while (!DelayUntilCoordinator.STATE.compareAndSet(delayUntilCoordinator, i, i | 2));
            return i;
        }

        public int markInnerInactive() {
            int i;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            do {
                i = delayUntilCoordinator.state;
                if (MonoDelayUntil.isTerminated(i)) {
                    return Integer.MIN_VALUE;
                }
                if (!MonoDelayUntil.hasInner(i)) {
                    break;
                }
            } while (!DelayUntilCoordinator.STATE.compareAndSet(delayUntilCoordinator, i, i & (-3)));
            return i;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            int i = delayUntilCoordinator.index + 1;
            delayUntilCoordinator.index = i;
            if (i == delayUntilCoordinator.otherGenerators.length) {
                delayUntilCoordinator.complete();
            } else {
                if (MonoDelayUntil.isTerminated(markInnerInactive())) {
                    return;
                }
                this.done = false;
                this.f5847s = null;
                delayUntilCoordinator.subscribeNextTrigger();
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
                return;
            }
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            this.done = true;
            delayUntilCoordinator.done = true;
            AtomicReferenceFieldUpdater<DelayUntilCoordinator, Throwable> atomicReferenceFieldUpdater = DelayUntilCoordinator.ERROR;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, delayUntilCoordinator, th)) {
                Operators.onErrorDropped(th, delayUntilCoordinator.currentContext());
            } else {
                if (MonoDelayUntil.isTerminated(delayUntilCoordinator.markTerminated())) {
                    return;
                }
                Operators.onDiscard(delayUntilCoordinator.value, delayUntilCoordinator.currentContext());
                delayUntilCoordinator.f5846s.cancel();
                delayUntilCoordinator.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, delayUntilCoordinator));
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            Operators.onDiscard(t9, this.parent.currentContext());
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5847s, eVar)) {
                this.f5847s = eVar;
                if (!MonoDelayUntil.isTerminated(markInnerActive())) {
                    eVar.request(Long.MAX_VALUE);
                    return;
                }
                eVar.cancel();
                DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
                Operators.onDiscard(delayUntilCoordinator.value, delayUntilCoordinator.currentContext());
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(MonoDelayUntil.isTerminated(this.parent.state) && !this.done);
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f5847s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MonoDelayUntil(Mono<T> mono, Function<? super T, ? extends Z9.c> function) {
        Objects.requireNonNull(mono, "monoSource");
        this.source = mono;
        Objects.requireNonNull(function, "triggerGenerator");
        this.otherGenerators = new Function[]{function};
        this.optimizableOperator = mono instanceof OptimizableOperator ? (OptimizableOperator) mono : null;
    }

    public static boolean hasInner(int i) {
        return (i & 2) == 2;
    }

    public static boolean hasRequest(int i) {
        return (i & 4) == 4;
    }

    public static boolean hasSubscription(int i) {
        return (i & 1) == 1;
    }

    public static boolean hasValue(int i) {
        return (i & 8) == 8;
    }

    public static boolean isTerminated(int i) {
        return i == Integer.MIN_VALUE;
    }

    public MonoDelayUntil<T> copyWithNewTriggerGenerator(boolean z10, Function<? super T, ? extends Z9.c> function) {
        Objects.requireNonNull(function, "triggerGenerator");
        Function<? super T, ? extends Z9.c>[] functionArr = this.otherGenerators;
        Function[] functionArr2 = new Function[functionArr.length + 1];
        System.arraycopy(functionArr, 0, functionArr2, 0, functionArr.length);
        functionArr2[functionArr.length] = function;
        return new MonoDelayUntil<>(this.source, functionArr2);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final OptimizableOperator<?, ? extends T> nextOptimizableSource() {
        return this.optimizableOperator;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends T> source() {
        return this.source;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            Operators.toFluxOrMono(this.source).subscribe((CoreSubscriber) subscribeOrReturn(coreSubscriber));
        } catch (Throwable th) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
        }
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) throws Throwable {
        DelayUntilCoordinator delayUntilCoordinator = new DelayUntilCoordinator(coreSubscriber, this.otherGenerators);
        coreSubscriber.onSubscribe(delayUntilCoordinator);
        return delayUntilCoordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MonoDelayUntil(Mono<T> mono, Function<? super T, ? extends Z9.c>[] functionArr) {
        Objects.requireNonNull(mono, "monoSource");
        this.source = mono;
        this.otherGenerators = functionArr;
        if (mono instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) mono;
        } else {
            this.optimizableOperator = null;
        }
    }
}
