package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxDistinctUntilChanged<T, K> extends InternalFluxOperator<T, T> {
    final BiPredicate<? super K, ? super K> keyComparator;
    final Function<? super T, K> keyExtractor;

    public static final class DistinctUntilChangedConditionalSubscriber<T, K> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final BiPredicate<? super K, ? super K> keyComparator;
        final Function<? super T, K> keyExtractor;

        @Nullable
        K lastKey;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5728s;

        public DistinctUntilChangedConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            this.actual = conditionalSubscriber;
            this.ctx = conditionalSubscriber.currentContext();
            this.keyExtractor = function;
            this.keyComparator = biPredicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5728s.cancel();
            this.lastKey = null;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.lastKey = null;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            this.lastKey = null;
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (tryOnNext(t9)) {
                return;
            }
            this.f5728s.request(1L);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5728s, eVar)) {
                this.f5728s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5728s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5728s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.ctx);
                return true;
            }
            try {
                K kApply = this.keyExtractor.apply(t9);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                K k = this.lastKey;
                if (k == null) {
                    this.lastKey = kApply;
                    return this.actual.tryOnNext(t9);
                }
                try {
                    if (this.keyComparator.test(k, kApply)) {
                        Operators.onDiscard(t9, this.ctx);
                        return false;
                    }
                    this.lastKey = kApply;
                    return this.actual.tryOnNext(t9);
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5728s, th, t9, this.ctx));
                    Operators.onDiscard(t9, this.ctx);
                    return true;
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f5728s, th2, t9, this.ctx));
                Operators.onDiscard(t9, this.ctx);
                return true;
            }
        }
    }

    public static final class DistinctUntilChangedSubscriber<T, K> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final BiPredicate<? super K, ? super K> keyComparator;
        final Function<? super T, K> keyExtractor;

        @Nullable
        K lastKey;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5729s;

        public DistinctUntilChangedSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.keyExtractor = function;
            this.keyComparator = biPredicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5729s.cancel();
            this.lastKey = null;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.lastKey = null;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            this.lastKey = null;
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (tryOnNext(t9)) {
                return;
            }
            this.f5729s.request(1L);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5729s, eVar)) {
                this.f5729s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5729s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5729s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.ctx);
                return true;
            }
            try {
                K kApply = this.keyExtractor.apply(t9);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                K k = this.lastKey;
                if (k == null) {
                    this.lastKey = kApply;
                    this.actual.onNext(t9);
                    return true;
                }
                try {
                    if (this.keyComparator.test(k, kApply)) {
                        Operators.onDiscard(t9, this.ctx);
                        return false;
                    }
                    this.lastKey = kApply;
                    this.actual.onNext(t9);
                    return true;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5729s, th, t9, this.ctx));
                    Operators.onDiscard(t9, this.ctx);
                    return true;
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f5729s, th2, t9, this.ctx));
                Operators.onDiscard(t9, this.ctx);
                return true;
            }
        }
    }

    public FluxDistinctUntilChanged(Flux<? extends T> flux, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flux);
        Objects.requireNonNull(function, "keyExtractor");
        this.keyExtractor = function;
        Objects.requireNonNull(biPredicate, "keyComparator");
        this.keyComparator = biPredicate;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new DistinctUntilChangedConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.keyExtractor, this.keyComparator) : new DistinctUntilChangedSubscriber(coreSubscriber, this.keyExtractor, this.keyComparator);
    }
}
