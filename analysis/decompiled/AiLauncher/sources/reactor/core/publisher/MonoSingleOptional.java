package reactor.core.publisher;

import java.util.Optional;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class MonoSingleOptional<T> extends InternalMonoOperator<T, Optional<T>> {

    public static final class SingleOptionalSubscriber<T> extends Operators.MonoInnerProducerBase<Optional<T>> implements InnerConsumer<T> {
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39669s;

        public SingleOptionalSubscriber(CoreSubscriber<? super Optional<T>> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return actual().currentContext();
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnCancel() {
            this.f39669s.cancel();
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnRequest(long j10) {
            this.f39669s.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(Optional.empty());
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
            } else {
                this.done = true;
                actual().onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, actual().currentContext());
            } else {
                this.done = true;
                complete(Optional.of(t10));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39669s, dVar)) {
                this.f39669s = dVar;
                actual().onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f39669s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoSingleOptional(Mono<? extends T> mono) {
        super(mono);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Optional<T>> coreSubscriber) {
        return new SingleOptionalSubscriber(coreSubscriber);
    }
}
