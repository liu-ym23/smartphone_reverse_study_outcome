package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoReduce<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final BiFunction<T, T, T> aggregator;

    public static final class ReduceSubscriber<T> implements InnerOperator<T, T>, Fuseable, Fuseable.QueueSubscription<T> {
        static final Object CANCELLED = new Object();
        final CoreSubscriber<? super T> actual;
        T aggregate;
        final BiFunction<T, T, T> aggregator;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5860s;

        public ReduceSubscriber(CoreSubscriber<? super T> coreSubscriber, BiFunction<T, T, T> biFunction) {
            this.actual = coreSubscriber;
            this.aggregator = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            T t9;
            T t10;
            this.f5860s.cancel();
            synchronized (this) {
                t9 = this.aggregate;
                t10 = (T) CANCELLED;
                this.aggregate = t10;
            }
            if (t9 == null || t9 == t10) {
                return;
            }
            Operators.onDiscard(t9, this.actual.currentContext());
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            T t9;
            if (this.done) {
                return;
            }
            this.done = true;
            synchronized (this) {
                t9 = this.aggregate;
                this.aggregate = null;
            }
            if (t9 == CANCELLED) {
                return;
            }
            if (t9 == null) {
                this.actual.onComplete();
            } else {
                this.actual.onNext(t9);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            T t9;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                t9 = this.aggregate;
                this.aggregate = null;
            }
            if (t9 == CANCELLED) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            if (t9 != null) {
                Operators.onDiscard(t9, this.actual.currentContext());
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            T t10 = this.aggregate;
            Object obj = CANCELLED;
            if (t10 == obj) {
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            if (t10 == null) {
                synchronized (this) {
                    try {
                        if (this.aggregate == null) {
                            this.aggregate = t9;
                            return;
                        } else {
                            Operators.onDiscard(t9, this.actual.currentContext());
                            return;
                        }
                    } finally {
                    }
                }
            }
            try {
                synchronized (this) {
                    try {
                        if (this.aggregate == obj) {
                            Operators.onDiscard(t9, this.actual.currentContext());
                            return;
                        }
                        T tApply = this.aggregator.apply(t10, t9);
                        Objects.requireNonNull(tApply, "The aggregator returned a null value");
                        this.aggregate = tApply;
                    } finally {
                    }
                }
            } catch (Throwable th) {
                this.done = true;
                Context contextCurrentContext = this.actual.currentContext();
                synchronized (this) {
                    this.aggregate = null;
                    Operators.onDiscard(t9, contextCurrentContext);
                    Operators.onDiscard(t10, contextCurrentContext);
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(this.f5860s, th, t9, coreSubscriber.currentContext()));
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5860s, eVar)) {
                this.f5860s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5860s.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            boolean z10 = false;
            if (attr != Scannable.Attr.CANCELLED) {
                if (attr == Scannable.Attr.PREFETCH) {
                    return 0;
                }
                return attr == Scannable.Attr.PARENT ? this.f5860s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (!this.done && this.aggregate == CANCELLED) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public MonoReduce(Flux<? extends T> flux, BiFunction<T, T, T> biFunction) {
        super(flux);
        Objects.requireNonNull(biFunction, "aggregator");
        this.aggregator = biFunction;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ReduceSubscriber(coreSubscriber, this.aggregator);
    }
}
