package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class MonoSingle<T> extends MonoFromFluxOperator<T, T> {
    final boolean completeOnEmpty;
    final T defaultValue;

    public static final class SingleSubscriber<T> extends Operators.MonoInnerProducerBase<T> implements InnerConsumer<T> {
        final boolean completeOnEmpty;
        int count;

        @Nullable
        final T defaultValue;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39668s;

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
            this.f39668s.cancel();
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnRequest(long j10) {
            this.f39668s.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            int i10 = this.count;
            if (i10 != 0) {
                if (i10 == 1) {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
                return;
            }
            this.done = true;
            discardTheValue();
            actual().onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (isCancelled()) {
                discard(t10);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, actual().currentContext());
                return;
            }
            int i10 = this.count + 1;
            this.count = i10;
            if (i10 <= 1) {
                setValue(t10);
                return;
            }
            discard(t10);
            cancel();
            onError(new IndexOutOfBoundsException("Source emitted more than one item"));
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39668s, dVar)) {
                this.f39668s = dVar;
                actual().onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f39668s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoSingle(Flux<? extends T> flux) {
        super(flux);
        this.defaultValue = null;
        this.completeOnEmpty = false;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new SingleSubscriber(coreSubscriber, this.defaultValue, this.completeOnEmpty);
    }

    public MonoSingle(Flux<? extends T> flux, @Nullable T t10, boolean z10) {
        super(flux);
        if (!z10) {
            Objects.requireNonNull(t10, "defaultValue");
        }
        this.defaultValue = t10;
        this.completeOnEmpty = z10;
    }
}
