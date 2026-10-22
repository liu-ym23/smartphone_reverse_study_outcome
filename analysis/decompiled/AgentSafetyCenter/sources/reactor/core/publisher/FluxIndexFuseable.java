package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxIndex;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxIndexFuseable<T, I> extends InternalFluxOperator<T, I> implements Fuseable {
    private final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class IndexFuseableConditionalSubscriber<I, T> implements InnerOperator<T, I>, Fuseable.ConditionalSubscriber<T>, Fuseable.QueueSubscription<I> {
        final Fuseable.ConditionalSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10633s;
        int sourceMode;

        public IndexFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super I> conditionalSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = conditionalSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10633s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10633s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10633s.isEmpty();
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
            long j10 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j10), t10);
                this.index = j10 + 1;
                this.actual.onNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10633s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10633s, eVar)) {
                this.f10633s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public I poll() {
            T tPoll = this.f10633s.poll();
            if (tPoll == null) {
                return null;
            }
            long j10 = this.index;
            I iApply = this.indexMapper.apply(Long.valueOf(j10), tPoll);
            this.index = j10 + 1;
            return iApply;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10633s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if (this.indexMapper != Flux.TUPLE2_BIFUNCTION && (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10633s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10633s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10633s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return true;
            }
            long j10 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j10), t10);
                this.index = j10 + 1;
                return this.actual.tryOnNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10633s, th, t10, this.actual.currentContext()));
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class IndexFuseableSubscriber<I, T> implements InnerOperator<T, I>, Fuseable.QueueSubscription<I> {
        final CoreSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10634s;
        int sourceMode;

        public IndexFuseableSubscriber(CoreSubscriber<? super I> coreSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = coreSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10634s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10634s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10634s.isEmpty();
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
            long j10 = this.index;
            try {
                I iApply = this.indexMapper.apply(Long.valueOf(j10), t10);
                this.index = j10 + 1;
                this.actual.onNext(iApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10634s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10634s, eVar)) {
                this.f10634s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public I poll() {
            T tPoll = this.f10634s.poll();
            if (tPoll == null) {
                return null;
            }
            long j10 = this.index;
            I iApply = this.indexMapper.apply(Long.valueOf(j10), tPoll);
            this.index = j10 + 1;
            return iApply;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10634s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if (this.indexMapper != Flux.TUPLE2_BIFUNCTION && (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10634s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10634s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10634s.size();
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
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        BiFunction<? super Long, ? super T, ? extends I> biFunction = this.indexMapper;
        return z10 ? new IndexFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, biFunction) : new IndexFuseableSubscriber(coreSubscriber, biFunction);
    }
}
