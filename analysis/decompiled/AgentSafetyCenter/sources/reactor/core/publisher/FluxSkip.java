package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSkip<T> extends InternalFluxOperator<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final long f10671n;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SkipSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10672s;

        public SkipSubscriber(CoreSubscriber<? super T> coreSubscriber, long j10) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.remaining = j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10672s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            long j10 = this.remaining;
            if (j10 == 0) {
                this.actual.onNext(t10);
            } else {
                Operators.onDiscard(t10, this.ctx);
                this.remaining = j10 - 1;
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10672s, eVar)) {
                this.f10672s = eVar;
                long j10 = this.remaining;
                this.actual.onSubscribe(this);
                eVar.request(j10);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10672s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10672s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSkip(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.f10671n = j10;
        } else {
            g5.f.s(k0.a.m("n >= 0 required but it was ", j10));
            throw null;
        }
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new SkipSubscriber(coreSubscriber, this.f10671n);
    }
}
