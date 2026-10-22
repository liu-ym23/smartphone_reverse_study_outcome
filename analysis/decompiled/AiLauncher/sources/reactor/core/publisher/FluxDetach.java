package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxDetach<T> extends InternalFluxOperator<T, T> {

    public static final class DetachSubscriber<T> implements InnerOperator<T, T> {
        CoreSubscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39495s;

        public DetachSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            qc.d dVar = this.f39495s;
            if (dVar != null) {
                this.actual = null;
                this.f39495s = null;
                dVar.cancel();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            return coreSubscriber == null ? Context.empty() : coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (coreSubscriber != null) {
                this.actual = null;
                this.f39495s = null;
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (coreSubscriber != null) {
                this.actual = null;
                this.f39495s = null;
                coreSubscriber.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (coreSubscriber != null) {
                coreSubscriber.onNext(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39495s, dVar)) {
                this.f39495s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            qc.d dVar = this.f39495s;
            if (dVar != null) {
                dVar.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39495s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.actual == null);
            }
            if (attr != Scannable.Attr.CANCELLED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (this.actual == null && this.f39495s == null) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public FluxDetach(Flux<? extends T> flux) {
        super(flux);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DetachSubscriber(coreSubscriber);
    }
}
