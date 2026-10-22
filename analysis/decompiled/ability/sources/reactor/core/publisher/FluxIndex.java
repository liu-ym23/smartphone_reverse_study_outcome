package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxIndex<T, I> extends InternalFluxOperator<T, I> {
    private final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

    public static final class IndexConditionalSubscriber<T, I> implements InnerOperator<T, I>, Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super I> actual;
        boolean done;
        long index;
        final BiFunction<? super Long, ? super T, ? extends I> indexMapper;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5751s;

        public IndexConditionalSubscriber(Fuseable.ConditionalSubscriber<? super I> conditionalSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = conditionalSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5751s.cancel();
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
                onError(Operators.onOperatorError(this.f5751s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5751s, eVar)) {
                this.f5751s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5751s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5751s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
                onError(Operators.onOperatorError(this.f5751s, th, t9, this.actual.currentContext()));
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
        Z9.e f5752s;

        public IndexSubscriber(CoreSubscriber<? super I> coreSubscriber, BiFunction<? super Long, ? super T, ? extends I> biFunction) {
            this.actual = coreSubscriber;
            this.indexMapper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super I> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5752s.cancel();
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
                onError(Operators.onOperatorError(this.f5752s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5752s, eVar)) {
                this.f5752s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5752s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5752s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
        public /* bridge */ /* synthetic */ Object apply(Long l, Object obj) {
            return apply2(l, (Long) obj);
        }

        /* renamed from: apply, reason: avoid collision after fix types in other method */
        public I apply2(Long l, T t9) {
            I iApply = this.indexMapper.apply(l, t9);
            if (iApply != null) {
                return iApply;
            }
            throw new NullPointerException("indexMapper returned a null value at raw index " + l + " for value " + t9);
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
