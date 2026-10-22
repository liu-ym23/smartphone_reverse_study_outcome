package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoMaterialize<T> extends InternalMonoOperator<T, Signal<T>> {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MaterializeSubscriber<T> implements InnerOperator<T, Signal<T>> {
        final CoreSubscriber<? super Signal<T>> actual;
        boolean alreadyReceivedSignalFromSource;
        volatile boolean requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10728s;

        @Nullable
        volatile Signal<T> signalToReplayUponFirstRequest;

        public MaterializeSubscriber(CoreSubscriber<? super Signal<T>> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Signal<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10728s.cancel();
        }

        public boolean drain() {
            Signal<T> signal = this.signalToReplayUponFirstRequest;
            if (signal == null || !this.requested) {
                return false;
            }
            this.actual.onNext(signal);
            this.actual.onComplete();
            this.signalToReplayUponFirstRequest = null;
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.alreadyReceivedSignalFromSource) {
                return;
            }
            this.alreadyReceivedSignalFromSource = true;
            this.signalToReplayUponFirstRequest = Signal.complete(currentContext());
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.alreadyReceivedSignalFromSource) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.alreadyReceivedSignalFromSource = true;
            this.signalToReplayUponFirstRequest = Signal.error(th, currentContext());
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.alreadyReceivedSignalFromSource || !this.requested) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            this.alreadyReceivedSignalFromSource = true;
            this.actual.onNext(Signal.next(t10, currentContext()));
            this.actual.onComplete();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10728s, eVar)) {
                this.f10728s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (this.requested || !Operators.validate(j10)) {
                return;
            }
            this.requested = true;
            if (drain()) {
                return;
            }
            this.f10728s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10728s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoMaterialize(Mono<T> mono) {
        super(mono);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Signal<T>> coreSubscriber) {
        return new MaterializeSubscriber(coreSubscriber);
    }
}
