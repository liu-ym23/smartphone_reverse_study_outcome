package reactor.core.publisher;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoCollect<T, R> extends MonoFromFluxOperator<T, R> implements Fuseable {
    final BiConsumer<? super R, ? super T> action;
    final Supplier<R> supplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CollectSubscriber<T, R> extends Operators.BaseFluxToMonoOperator<T, R> {
        final BiConsumer<? super R, ? super T> action;
        R container;
        boolean done;

        public CollectSubscriber(CoreSubscriber<? super R> coreSubscriber, BiConsumer<? super R, ? super T> biConsumer, R r10) {
            super(coreSubscriber);
            this.action = biConsumer;
            this.container = r10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public R accumulatedValue() {
            R r10;
            synchronized (this) {
                r10 = this.container;
                this.container = null;
            }
            return r10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            R r10;
            super.cancel();
            synchronized (this) {
                r10 = this.container;
                this.container = null;
            }
            if (r10 != null) {
                discard(r10);
            }
        }

        public void discard(R r10) {
            boolean z10 = r10 instanceof Collection;
            CoreSubscriber<? super O> coreSubscriber = this.actual;
            if (z10) {
                Operators.onDiscardMultiple((Collection<?>) r10, coreSubscriber.currentContext());
            } else {
                Operators.onDiscard(r10, coreSubscriber.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            R r10;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                r10 = this.container;
                this.container = null;
            }
            if (r10 == null) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                discard(r10);
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                synchronized (this) {
                    try {
                        R r10 = this.container;
                        if (r10 != null) {
                            this.action.accept(r10, t10);
                        } else {
                            Operators.onDiscard(t10, this.actual.currentContext());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Context contextCurrentContext = this.actual.currentContext();
                Operators.onDiscard(t10, contextCurrentContext);
                onError(Operators.onOperatorError(this.f10743s, th2, t10, contextCurrentContext));
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public MonoCollect(Flux<? extends T> flux, Supplier<R> supplier, BiConsumer<? super R, ? super T> biConsumer) {
        super(flux);
        Objects.requireNonNull(supplier, "supplier");
        this.supplier = supplier;
        Objects.requireNonNull(biConsumer);
        this.action = biConsumer;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        R r10 = this.supplier.get();
        Objects.requireNonNull(r10, "The supplier returned a null container");
        return new CollectSubscriber(coreSubscriber, this.action, r10);
    }
}
