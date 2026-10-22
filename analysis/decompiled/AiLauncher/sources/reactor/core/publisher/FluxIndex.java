package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxIndex<T, I> extends InternalFluxOperator<T, I> {
    private final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

    public static final class IndexConditionalSubscriber<T, I> implements InnerOperator<T, I>, Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39521s;

        public IndexConditionalSubscriber(Fuseable.ConditionalSubscriber<? super I> conditionalSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = conditionalSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39521s.cancel();
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
                onError(Operators.onOperatorError(this.f39521s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39521s, dVar)) {
                this.f39521s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39521s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39521s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
                onError(Operators.onOperatorError(this.f39521s, th, t10, this.actual.currentContext()));
                return true;
            }
        }
    }

    public static final class IndexSubscriber<T, I> implements InnerOperator<T, I> {
        final CoreSubscriber<? super I> actual;
        boolean done;
        long index = 0;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39522s;

        public IndexSubscriber(CoreSubscriber<? super I> coreSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = coreSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39522s.cancel();
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
                onError(Operators.onOperatorError(this.f39522s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39522s, dVar)) {
                this.f39522s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39522s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39522s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static class NullSafeIndexMapper<T, I> implements BiFunction<Long, T, I> {
        private final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        private NullSafeIndexMapper(BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.indexMapper = biFunction;
        }

        public static <T, I> BiFunction<? super Long, ? super T, ? extends I> create(BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            return biFunction == Flux.TUPLE2_BIFUNCTION ? biFunction : new NullSafeIndexMapper(biFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Long l10, Object obj) {
            return apply2(l10, (Long) obj);
        }

        /* renamed from: apply, reason: avoid collision after fix types in other method */
        public I apply2(Long l10, T t10) {
            I iApply = this.indexMapper.apply(l10, t10);
            if (iApply != null) {
                return iApply;
            }
            throw new NullPointerException("indexMapper returned a null value at raw index " + l10 + " for value " + t10);
        }
    }

    public FluxIndex(Flux<T> flux, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
        super(flux);
        Objects.requireNonNull(biFunction, "indexMapper must be non null");
        this.indexMapper = NullSafeIndexMapper.create(biFunction);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new IndexConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.indexMapper) : new IndexSubscriber(coreSubscriber, this.indexMapper);
    }
}
