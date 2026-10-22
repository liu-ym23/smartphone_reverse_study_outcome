package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoTakeLastOne<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final T defaultValue;

    public static final class TakeLastOneSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {
        static final Object CANCELLED = new Object();
        boolean done;
        final boolean mustEmit;
        T value;

        public TakeLastOneSubscriber(CoreSubscriber<? super T> coreSubscriber, @Nullable T t10, boolean z10) {
            super(coreSubscriber);
            this.value = t10;
            this.mustEmit = z10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            T t10;
            synchronized (this) {
                t10 = this.value;
                this.value = null;
            }
            if (t10 == CANCELLED) {
                return null;
            }
            return t10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            T t10;
            this.f39687s.cancel();
            synchronized (this) {
                t10 = this.value;
                this.value = (T) CANCELLED;
            }
            if (t10 != null) {
                Operators.onDiscard(t10, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t10 = this.value;
            if (t10 == CANCELLED) {
                return;
            }
            if (t10 != null) {
                completePossiblyEmpty();
            } else if (this.mustEmit) {
                this.actual.onError(Operators.onOperatorError(new NoSuchElementException("Flux#last() didn't observe any onNext signal"), this.actual.currentContext()));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            T t10;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                t10 = this.value;
                this.value = null;
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            T t11;
            T t12 = this.value;
            Object obj = CANCELLED;
            if (t12 == obj) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            synchronized (this) {
                try {
                    t11 = this.value;
                    if (t11 != obj) {
                        this.value = t10;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (t11 == obj) {
                Operators.onDiscard(t10, this.actual.currentContext());
            } else {
                Operators.onDiscard(t11, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.CANCELLED) {
                    return Boolean.valueOf(this.value == CANCELLED);
                }
                return super.scanUnsafe(attr);
            }
            if (this.done && this.value == null) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public MonoTakeLastOne(Flux<? extends T> flux) {
        super(flux);
        this.defaultValue = null;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new TakeLastOneSubscriber(coreSubscriber, this.defaultValue, true);
    }

    public MonoTakeLastOne(Flux<? extends T> flux, T t10) {
        super(flux);
        Objects.requireNonNull(t10, "defaultValue");
        this.defaultValue = t10;
    }
}
