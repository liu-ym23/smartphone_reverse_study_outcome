package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxMapFuseable<T, R> extends InternalFluxOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends R> mapper;

    public static final class MapFuseableConditionalSubscriber<T, R> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, R>, Fuseable.QueueSubscription<R> {
        final Fuseable.ConditionalSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f39527s;
        int sourceMode;

        public MapFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.actual = conditionalSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39527s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f39527s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f39527s.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    this.actual.onNext(rApply);
                    return;
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39527s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39527s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39527s, dVar)) {
                this.f39527s = (Fuseable.QueueSubscription) dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            RuntimeException runtimeExceptionOnNextPollError;
            do {
                T tPoll = this.f39527s.poll();
                if (tPoll == null) {
                    return null;
                }
                try {
                    R rApply = this.mapper.apply(tPoll);
                    Objects.requireNonNull(rApply);
                    return rApply;
                } finally {
                }
            } while (runtimeExceptionOnNextPollError == null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39527s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f39527s.requestFusion(i10);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39527s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f39527s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return true;
            }
            try {
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    return this.actual.tryOnNext(rApply);
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39527s);
                if (thOnNextError == null) {
                    return false;
                }
                onError(thOnNextError);
                return true;
            }
        }
    }

    public static final class MapFuseableSubscriber<T, R> implements InnerOperator<T, R>, Fuseable.QueueSubscription<R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f39528s;
        int sourceMode;

        public MapFuseableSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends R> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39528s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f39528s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f39528s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    this.actual.onNext(rApply);
                    return;
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39528s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39528s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39528s, dVar)) {
                this.f39528s = (Fuseable.QueueSubscription) dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            RuntimeException runtimeExceptionOnNextPollError;
            do {
                T tPoll = this.f39528s.poll();
                if (tPoll == null) {
                    return null;
                }
                try {
                    R rApply = this.mapper.apply(tPoll);
                    Objects.requireNonNull(rApply);
                    return rApply;
                } finally {
                }
            } while (runtimeExceptionOnNextPollError == null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39528s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f39528s.requestFusion(i10);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39528s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f39528s.size();
        }
    }

    public FluxMapFuseable(Flux<? extends T> flux, Function<? super T, ? extends R> function) {
        super(flux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new MapFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.mapper) : new MapFuseableSubscriber(coreSubscriber, this.mapper);
    }
}
