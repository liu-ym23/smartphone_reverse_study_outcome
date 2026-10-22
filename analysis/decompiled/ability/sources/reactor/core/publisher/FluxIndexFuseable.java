package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxIndex;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxIndexFuseable<T, I> extends InternalFluxOperator<T, I> implements Fuseable {
    private final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

    public static final class IndexFuseableConditionalSubscriber<I, T> implements InnerOperator<T, I>, Fuseable.ConditionalSubscriber<T>, Fuseable.QueueSubscription<I> {
        final Fuseable.ConditionalSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5753s;
        int sourceMode;

        public IndexFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super I> conditionalSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = conditionalSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5753s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f5753s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f5753s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j5), t9);
                this.index = j5 + 1;
                this.actual.onNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5753s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5753s, eVar)) {
                this.f5753s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public I poll() {
            T tPoll = this.f5753s.poll();
            if (tPoll == null) {
                return null;
            }
            long j5 = this.index;
            I iApply = this.indexMapper.apply(Long.valueOf(j5), tPoll);
            this.index = j5 + 1;
            return iApply;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5753s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if (this.indexMapper != Flux.TUPLE2_BIFUNCTION && (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f5753s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5753s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5753s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return true;
            }
            long j5 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j5), t9);
                this.index = j5 + 1;
                return this.actual.tryOnNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5753s, th, t9, this.actual.currentContext()));
                return true;
            }
        }
    }

    public static final class IndexFuseableSubscriber<I, T> implements InnerOperator<T, I>, Fuseable.QueueSubscription<I> {
        final CoreSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5754s;
        int sourceMode;

        public IndexFuseableSubscriber(CoreSubscriber<? super I> coreSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = coreSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5754s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f5754s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f5754s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j5), t9);
                this.index = j5 + 1;
                this.actual.onNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5754s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5754s, eVar)) {
                this.f5754s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public I poll() {
            T tPoll = this.f5754s.poll();
            if (tPoll == null) {
                return null;
            }
            long j5 = this.index;
            I iApply = this.indexMapper.apply(Long.valueOf(j5), tPoll);
            this.index = j5 + 1;
            return iApply;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5754s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if (this.indexMapper != Flux.TUPLE2_BIFUNCTION && (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f5754s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5754s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5754s.size();
        }
    }

    public FluxIndexFuseable(Flux<T> flux, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
        super(flux);
        Objects.requireNonNull(biFunction, "indexMapper must be non null");
        this.indexMapper = FluxIndex.NullSafeIndexMapper.create(biFunction);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new IndexFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.indexMapper) : new IndexFuseableSubscriber(coreSubscriber, this.indexMapper);
    }
}
