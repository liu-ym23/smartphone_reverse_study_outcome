package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSingle<T> extends MonoFromFluxOperator<T, T> {
    final boolean completeOnEmpty;
    final T defaultValue;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SingleSubscriber<T> extends Operators.MonoInnerProducerBase<T> implements InnerConsumer<T> {
        final boolean completeOnEmpty;
        int count;

        @Nullable
        final T defaultValue;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10737s;

        public SingleSubscriber(CoreSubscriber<? super T> coreSubscriber, @Nullable T t10, boolean z10) {
            super(coreSubscriber);
            this.defaultValue = t10;
            this.completeOnEmpty = z10;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return actual().currentContext();
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnCancel() {
            this.f10737s.cancel();
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnRequest(long j10) {
            this.f10737s.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            int i = this.count;
            if (i != 0) {
                if (i == 1) {
                    complete();
                }
            } else {
                if (this.completeOnEmpty) {
                    actual().onComplete();
                    return;
                }
                T t10 = this.defaultValue;
                if (t10 != null) {
                    complete(t10);
                } else {
                    actual().onError(Operators.onOperatorError(this, new NoSuchElementException("Source was empty"), actual().currentContext()));
                }
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
                return;
            }
            this.done = true;
            discardTheValue();
            actual().onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (isCancelled()) {
                discard(t10);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, actual().currentContext());
                return;
            }
            int i = this.count + 1;
            this.count = i;
            if (i <= 1) {
                setValue(t10);
                return;
            }
            discard(t10);
            cancel();
            onError(new IndexOutOfBoundsException("Source emitted more than one item"));
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10737s, eVar)) {
                this.f10737s = eVar;
                actual().onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f10737s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoSingle(Flux<? extends T> flux, @Nullable T t10, boolean z10) {
        super(flux);
        if (!z10) {
            Objects.requireNonNull(t10, "defaultValue");
        }
        this.defaultValue = t10;
        this.completeOnEmpty = z10;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new SingleSubscriber(coreSubscriber, this.defaultValue, this.completeOnEmpty);
    }

    public MonoSingle(Flux<? extends T> flux) {
        super(flux);
        this.defaultValue = null;
        this.completeOnEmpty = false;
    }
}
