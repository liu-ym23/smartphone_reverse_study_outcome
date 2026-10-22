package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxDematerialize<T> extends InternalFluxOperator<Signal<T>, T> {

    public static final class DematerializeSubscriber<T> implements InnerOperator<Signal<T>, T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean completeAfterOnNext;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5724s;

        public DematerializeSubscriber(CoreSubscriber<? super T> coreSubscriber, boolean z10) {
            this.actual = coreSubscriber;
            this.completeAfterOnNext = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5724s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5724s, eVar)) {
                this.f5724s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                this.f5724s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5724s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Signal<T> signal) {
            if (this.done) {
                Operators.onNextDropped(signal, this.actual.currentContext());
                return;
            }
            if (signal.isOnComplete()) {
                this.f5724s.cancel();
                onComplete();
            } else if (signal.isOnError()) {
                this.f5724s.cancel();
                onError(signal.getThrowable());
            } else if (signal.isOnNext()) {
                this.actual.onNext(signal.get());
                if (this.completeAfterOnNext) {
                    onComplete();
                }
            }
        }
    }

    public FluxDematerialize(Flux<Signal<T>> flux) {
        super(flux);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super Signal<T>> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DematerializeSubscriber(coreSubscriber, false);
    }
}
