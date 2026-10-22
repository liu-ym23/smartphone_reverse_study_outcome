package reactor.core.publisher;

import java.util.ArrayDeque;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSkipLast<T> extends InternalFluxOperator<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final int f10673n;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;

        /* renamed from: n, reason: collision with root package name */
        final int f10674n;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10675s;

        public SkipLastSubscriber(CoreSubscriber<? super T> coreSubscriber, int i) {
            this.actual = coreSubscriber;
            this.f10674n = i;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10675s.cancel();
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.actual.onError(th);
            Operators.onDiscardQueueWithClear(this, this.actual.currentContext(), null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (size() == this.f10674n) {
                this.actual.onNext(pollFirst());
            }
            offerLast(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10675s, eVar)) {
                this.f10675s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(this.f10674n);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10675s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10675s : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.f10674n) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSkipLast(Flux<? extends T> flux, int i) {
        super(flux);
        if (i >= 0) {
            this.f10673n = i;
        } else {
            g5.f.s(k0.a.j(i, "n >= 0 required but it was "));
            throw null;
        }
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new SkipLastSubscriber(coreSubscriber, this.f10673n);
    }
}
