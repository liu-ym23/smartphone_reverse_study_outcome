package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoReduce<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final BiFunction<T, T, T> aggregator;

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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ReduceSubscriber<T> implements InnerOperator<T, T>, Fuseable, Fuseable.QueueSubscription<T> {
        static final Object CANCELLED = new Object();
        final CoreSubscriber<? super T> actual;
        T aggregate;
        final BiFunction<T, T, T> aggregator;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10734s;

        public ReduceSubscriber(CoreSubscriber<? super T> coreSubscriber, BiFunction<T, T, T> biFunction) {
            this.actual = coreSubscriber;
            this.aggregator = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            T t10;
            T t11;
            this.f10734s.cancel();
            synchronized (this) {
                t10 = this.aggregate;
                t11 = (T) CANCELLED;
                this.aggregate = t11;
            }
            if (t10 == null || t10 == t11) {
                return;
            }
            Operators.onDiscard(t10, this.actual.currentContext());
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            T t10;
            if (this.done) {
                return;
            }
            this.done = true;
            synchronized (this) {
                t10 = this.aggregate;
                this.aggregate = null;
            }
            if (t10 == CANCELLED) {
                return;
            }
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (t10 == null) {
                coreSubscriber.onComplete();
            } else {
                coreSubscriber.onNext(t10);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            T t10;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                t10 = this.aggregate;
                this.aggregate = null;
            }
            if (t10 == CANCELLED) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            if (t10 != null) {
                Operators.onDiscard(t10, this.actual.currentContext());
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            T t11 = this.aggregate;
            Object obj = CANCELLED;
            if (t11 == obj) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            if (t11 == null) {
                synchronized (this) {
                    try {
                        if (this.aggregate == null) {
                            this.aggregate = t10;
                            return;
                        } else {
                            Operators.onDiscard(t10, this.actual.currentContext());
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
                            Operators.onDiscard(t10, this.actual.currentContext());
                            return;
                        }
                        T tApply = this.aggregator.apply(t11, t10);
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
                    Operators.onDiscard(t10, contextCurrentContext);
                    Operators.onDiscard(t11, contextCurrentContext);
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(this.f10734s, th, t10, coreSubscriber.currentContext()));
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10734s, eVar)) {
                this.f10734s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10734s.request(Long.MAX_VALUE);
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
                return attr == Scannable.Attr.PARENT ? this.f10734s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

        @Override // java.util.Collection
        public void clear() {
        }
    }
}
