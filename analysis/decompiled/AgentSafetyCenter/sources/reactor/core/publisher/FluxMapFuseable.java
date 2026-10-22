package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxMapFuseable<T, R> extends InternalFluxOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends R> mapper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MapFuseableConditionalSubscriber<T, R> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, R>, Fuseable.QueueSubscription<R> {
        final Fuseable.ConditionalSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10637s;
        int sourceMode;

        public MapFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.actual = conditionalSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10637s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10637s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10637s.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
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
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10637s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f10637s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10637s, eVar)) {
                this.f10637s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            RuntimeException runtimeExceptionOnNextPollError;
            do {
                T tPoll = this.f10637s.poll();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10637s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10637s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10637s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10637s.size();
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
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10637s);
                if (thOnNextError == null) {
                    return false;
                }
                onError(thOnNextError);
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MapFuseableSubscriber<T, R> implements InnerOperator<T, R>, Fuseable.QueueSubscription<R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10638s;
        int sourceMode;

        public MapFuseableSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends R> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10638s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10638s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10638s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10638s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f10638s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10638s, eVar)) {
                this.f10638s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            RuntimeException runtimeExceptionOnNextPollError;
            do {
                T tPoll = this.f10638s.poll();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10638s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10638s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10638s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10638s.size();
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
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        Function<? super T, ? extends R> function = this.mapper;
        return z10 ? new MapFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, function) : new MapFuseableSubscriber(coreSubscriber, function);
    }
}
