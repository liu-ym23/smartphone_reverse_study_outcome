package reactor.core.publisher;

import java.util.ArrayDeque;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxSkipLast<T> extends InternalFluxOperator<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final int f39566n;

    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;

        /* renamed from: n, reason: collision with root package name */
        final int f39567n;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39568s;

        public SkipLastSubscriber(CoreSubscriber<? super T> coreSubscriber, int i10) {
            this.actual = coreSubscriber;
            this.f39567n = i10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39568s.cancel();
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (size() == this.f39567n) {
                this.actual.onNext(pollFirst());
            }
            offerLast(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39568s, dVar)) {
                this.f39568s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.f39567n);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39568s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39568s : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.f39567n) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSkipLast(Flux<? extends T> flux, int i10) {
        super(flux);
        if (i10 >= 0) {
            this.f39566n = i10;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i10);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new SkipLastSubscriber(coreSubscriber, this.f39566n);
    }
}
