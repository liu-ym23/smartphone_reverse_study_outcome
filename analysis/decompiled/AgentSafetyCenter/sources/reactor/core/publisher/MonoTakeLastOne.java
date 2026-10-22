package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoTakeLastOne<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final T defaultValue;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            T t10;
            this.f10743s.cancel();
            synchronized (this) {
                t10 = this.value;
                this.value = (T) CANCELLED;
            }
            if (t10 != null) {
                Operators.onDiscard(t10, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
                return;
            }
            boolean z10 = this.mustEmit;
            qd.d dVar = this.actual;
            if (z10) {
                dVar.onError(Operators.onOperatorError(new NoSuchElementException("Flux#last() didn't observe any onNext signal"), this.actual.currentContext()));
            } else {
                dVar.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
            CoreSubscriber<? super O> coreSubscriber = this.actual;
            if (t11 == obj) {
                Operators.onDiscard(t10, coreSubscriber.currentContext());
            } else {
                Operators.onDiscard(t11, coreSubscriber.currentContext());
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

    public MonoTakeLastOne(Flux<? extends T> flux, T t10) {
        super(flux);
        Objects.requireNonNull(t10, "defaultValue");
        this.defaultValue = t10;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new TakeLastOneSubscriber(coreSubscriber, this.defaultValue, true);
    }

    public MonoTakeLastOne(Flux<? extends T> flux) {
        super(flux);
        this.defaultValue = null;
    }
}
