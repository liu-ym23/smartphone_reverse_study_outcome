package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTakeUntilOther<T, U> extends InternalFluxOperator<T, T> {
    final qd.c other;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TakeUntilMainSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicReferenceFieldUpdater<TakeUntilMainSubscriber, qd.e> MAIN = AtomicReferenceFieldUpdater.newUpdater(TakeUntilMainSubscriber.class, qd.e.class, "main");
        static final AtomicReferenceFieldUpdater<TakeUntilMainSubscriber, qd.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(TakeUntilMainSubscriber.class, qd.e.class, "other");
        final CoreSubscriber<? super T> actual;
        volatile qd.e main;
        volatile qd.e other;

        public TakeUntilMainSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = Operators.serialize(coreSubscriber);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            qd.e andSet;
            if (this.main != Operators.cancelledSubscription() && (andSet = MAIN.getAndSet(this, Operators.cancelledSubscription())) != null && andSet != Operators.cancelledSubscription()) {
                andSet.cancel();
            }
            cancelOther();
        }

        public void cancelMainAndComplete() {
            if (this.main != Operators.cancelledSubscription()) {
                qd.e andSet = MAIN.getAndSet(this, Operators.cancelledSubscription());
                if (andSet != null && andSet != Operators.cancelledSubscription()) {
                    andSet.cancel();
                }
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                if (andSet == null) {
                    Operators.complete(coreSubscriber);
                } else {
                    coreSubscriber.onComplete();
                }
            }
        }

        public void cancelOther() {
            qd.e andSet;
            if (this.other == Operators.cancelledSubscription() || (andSet = OTHER.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                Operators.complete(this.actual);
            } else {
                cancelOther();
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                Operators.error(this.actual, th);
            } else {
                cancelOther();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (MAIN.compareAndSet(this, null, eVar)) {
                this.actual.onSubscribe(this);
                return;
            }
            eVar.cancel();
            if (this.main != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.main.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.main;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setOther(qd.e eVar) {
            if (OTHER.compareAndSet(this, null, eVar)) {
                return;
            }
            eVar.cancel();
            if (this.other != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TakeUntilOtherSubscriber<U> implements InnerConsumer<U> {
        final TakeUntilMainSubscriber<?> main;
        boolean once;

        public TakeUntilOtherSubscriber(TakeUntilMainSubscriber<?> takeUntilMainSubscriber) {
            this.main = takeUntilMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.cancelMainAndComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(U u10) {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.cancelOther();
            this.main.cancelMainAndComplete();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            this.main.setOther(eVar);
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main.other == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.main.other;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.main;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxTakeUntilOther(Flux<? extends T> flux, qd.c cVar) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(coreSubscriber);
        this.other.subscribe(new TakeUntilOtherSubscriber(takeUntilMainSubscriber));
        return takeUntilMainSubscriber;
    }
}
