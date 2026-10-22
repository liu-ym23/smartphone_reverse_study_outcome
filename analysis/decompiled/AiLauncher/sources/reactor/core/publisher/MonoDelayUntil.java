package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
final class MonoDelayUntil<T> extends Mono<T> implements Scannable, OptimizableOperator<T, T> {

    @Nullable
    final OptimizableOperator<?, T> optimizableOperator;
    Function<? super T, ? extends qc.b<?>>[] otherGenerators;
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
        final Function<? super T, ? extends qc.b<?>>[] otherGenerators;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39650s;
        volatile int state;
        DelayUntilTrigger<?> triggerSubscriber;
        T value;
        static final AtomicReferenceFieldUpdater<DelayUntilCoordinator, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(DelayUntilCoordinator.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<DelayUntilCoordinator> STATE = AtomicIntegerFieldUpdater.newUpdater(DelayUntilCoordinator.class, VoiceWakeupReceiver.EXTRA_STATE);

        public DelayUntilCoordinator(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qc.b<?>>[] functionArr) {
            this.actual = coreSubscriber;
            this.otherGenerators = functionArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
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
                this.f39650s.cancel();
            }
            if (MonoDelayUntil.hasInner(iMarkTerminated)) {
                Operators.onDiscard(this.value, this.actual.currentContext());
                this.triggerSubscriber.cancel();
            }
        }

        public void complete() {
            int i10;
            do {
                i10 = this.state;
                if (MonoDelayUntil.isTerminated(i10)) {
                    return;
                }
                if (MonoDelayUntil.hasRequest(i10) && STATE.compareAndSet(this, i10, Integer.MIN_VALUE)) {
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onNext(this.value);
                    coreSubscriber.onComplete();
                    return;
                }
            } while (!STATE.compareAndSet(this, i10, i10 | 8));
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            DelayUntilTrigger<?> delayUntilTrigger = this.triggerSubscriber;
            return delayUntilTrigger == null ? Stream.empty() : Stream.of(delayUntilTrigger);
        }

        public int markHasRequest() {
            int i10;
            do {
                i10 = this.state;
                if (!MonoDelayUntil.isTerminated(i10)) {
                    if (MonoDelayUntil.hasRequest(i10)) {
                        break;
                    }
                } else {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i10, MonoDelayUntil.hasValue(i10) ? Integer.MIN_VALUE : i10 | 4));
            return i10;
        }

        public int markHasSubscription() {
            int i10;
            do {
                i10 = this.state;
                if (MonoDelayUntil.isTerminated(i10)) {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i10, i10 | 1));
            return i10;
        }

        public int markTerminated() {
            int i10;
            do {
                i10 = this.state;
                if (MonoDelayUntil.isTerminated(i10)) {
                    return Integer.MIN_VALUE;
                }
            } while (!STATE.compareAndSet(this, i10, Integer.MIN_VALUE));
            return i10;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (!this.done && this.value == null) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onDiscard(t10, this.actual.currentContext());
            } else {
                this.value = t10;
                subscribeNextTrigger();
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39650s, dVar)) {
                this.f39650s = dVar;
                if (MonoDelayUntil.isTerminated(markHasSubscription())) {
                    dVar.cancel();
                } else {
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
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
                qc.b<?> bVarApply = this.otherGenerators[this.index].apply(this.value);
                Objects.requireNonNull(bVarApply, "mapper returned null value");
                DelayUntilTrigger<?> delayUntilTrigger = this.triggerSubscriber;
                if (delayUntilTrigger == null) {
                    delayUntilTrigger = new DelayUntilTrigger<>(this);
                    this.triggerSubscriber = delayUntilTrigger;
                }
                Operators.toFluxOrMono(bVarApply).subscribe((qc.c) delayUntilTrigger);
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
        qc.d f39651s;

        public DelayUntilTrigger(DelayUntilCoordinator<?> delayUntilCoordinator) {
            this.parent = delayUntilCoordinator;
        }

        public void cancel() {
            this.f39651s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public int markInnerActive() {
            int i10;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            do {
                i10 = delayUntilCoordinator.state;
                if (MonoDelayUntil.isTerminated(i10)) {
                    return Integer.MIN_VALUE;
                }
                if (MonoDelayUntil.hasInner(i10)) {
                    break;
                }
            } while (!DelayUntilCoordinator.STATE.compareAndSet(delayUntilCoordinator, i10, i10 | 2));
            return i10;
        }

        public int markInnerInactive() {
            int i10;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            do {
                i10 = delayUntilCoordinator.state;
                if (MonoDelayUntil.isTerminated(i10)) {
                    return Integer.MIN_VALUE;
                }
                if (!MonoDelayUntil.hasInner(i10)) {
                    break;
                }
            } while (!DelayUntilCoordinator.STATE.compareAndSet(delayUntilCoordinator, i10, i10 & (-3)));
            return i10;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            DelayUntilCoordinator<?> delayUntilCoordinator = this.parent;
            int i10 = delayUntilCoordinator.index + 1;
            delayUntilCoordinator.index = i10;
            if (i10 == delayUntilCoordinator.otherGenerators.length) {
                delayUntilCoordinator.complete();
            } else {
                if (MonoDelayUntil.isTerminated(markInnerInactive())) {
                    return;
                }
                this.done = false;
                this.f39651s = null;
                delayUntilCoordinator.subscribeNextTrigger();
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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
                delayUntilCoordinator.f39650s.cancel();
                delayUntilCoordinator.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, delayUntilCoordinator));
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            Operators.onDiscard(t10, this.parent.currentContext());
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39651s, dVar)) {
                this.f39651s = dVar;
                if (!MonoDelayUntil.isTerminated(markInnerActive())) {
                    dVar.request(Long.MAX_VALUE);
                    return;
                }
                dVar.cancel();
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
                return this.f39651s;
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
    public MonoDelayUntil(Mono<T> mono, Function<? super T, ? extends qc.b<?>> function) {
        Objects.requireNonNull(mono, "monoSource");
        this.source = mono;
        Objects.requireNonNull(function, "triggerGenerator");
        this.otherGenerators = new Function[]{function};
        this.optimizableOperator = mono instanceof OptimizableOperator ? (OptimizableOperator) mono : null;
    }

    public static boolean hasInner(int i10) {
        return (i10 & 2) == 2;
    }

    public static boolean hasRequest(int i10) {
        return (i10 & 4) == 4;
    }

    public static boolean hasSubscription(int i10) {
        return (i10 & 1) == 1;
    }

    public static boolean hasValue(int i10) {
        return (i10 & 8) == 8;
    }

    public static boolean isTerminated(int i10) {
        return i10 == Integer.MIN_VALUE;
    }

    public MonoDelayUntil<T> copyWithNewTriggerGenerator(boolean z10, Function<? super T, ? extends qc.b<?>> function) {
        Objects.requireNonNull(function, "triggerGenerator");
        Function<? super T, ? extends qc.b<?>>[] functionArr = this.otherGenerators;
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
            Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) throws Throwable {
        DelayUntilCoordinator delayUntilCoordinator = new DelayUntilCoordinator(coreSubscriber, this.otherGenerators);
        coreSubscriber.onSubscribe(delayUntilCoordinator);
        return delayUntilCoordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MonoDelayUntil(Mono<T> mono, Function<? super T, ? extends qc.b<?>>[] functionArr) {
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
