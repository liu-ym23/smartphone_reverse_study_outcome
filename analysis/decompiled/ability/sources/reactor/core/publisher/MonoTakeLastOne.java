package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoTakeLastOne<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final T defaultValue;

    public static final class TakeLastOneSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {
        static final Object CANCELLED = new Object();
        boolean done;
        final boolean mustEmit;
        T value;

        public TakeLastOneSubscriber(CoreSubscriber<? super T> coreSubscriber, @Nullable T t9, boolean z10) {
            super(coreSubscriber);
            this.value = t9;
            this.mustEmit = z10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            T t9;
            synchronized (this) {
                t9 = this.value;
                this.value = null;
            }
            if (t9 == CANCELLED) {
                return null;
            }
            return t9;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            T t9;
            this.f5875s.cancel();
            synchronized (this) {
                t9 = this.value;
                this.value = (T) CANCELLED;
            }
            if (t9 != null) {
                Operators.onDiscard(t9, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t9 = this.value;
            if (t9 == CANCELLED) {
                return;
            }
            if (t9 != null) {
                completePossiblyEmpty();
            } else if (this.mustEmit) {
                this.actual.onError(Operators.onOperatorError(new NoSuchElementException("Flux#last() didn't observe any onNext signal"), this.actual.currentContext()));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            T t9;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                t9 = this.value;
                this.value = null;
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            T t10;
            T t11 = this.value;
            Object obj = CANCELLED;
            if (t11 == obj) {
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            synchronized (this) {
                try {
                    t10 = this.value;
                    if (t10 != obj) {
                        this.value = t9;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (t10 == obj) {
                Operators.onDiscard(t9, this.actual.currentContext());
            } else {
                Operators.onDiscard(t10, this.actual.currentContext());
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

    public MonoTakeLastOne(Flux<? extends T> flux, T t9) {
        super(flux);
        Objects.requireNonNull(t9, "defaultValue");
        this.defaultValue = t9;
    }
}
