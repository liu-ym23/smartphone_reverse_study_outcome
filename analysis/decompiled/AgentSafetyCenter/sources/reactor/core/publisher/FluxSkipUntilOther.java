package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSkipUntilOther<T, U> extends InternalFluxOperator<T, T> {
    final qd.c other;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SkipUntilMainSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicReferenceFieldUpdater<SkipUntilMainSubscriber, qd.e> MAIN = AtomicReferenceFieldUpdater.newUpdater(SkipUntilMainSubscriber.class, qd.e.class, "main");
        static final AtomicReferenceFieldUpdater<SkipUntilMainSubscriber, qd.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(SkipUntilMainSubscriber.class, qd.e.class, "other");
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile boolean gate;
        volatile qd.e main;
        volatile qd.e other;

        public SkipUntilMainSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = Operators.serialize(coreSubscriber);
            this.ctx = coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            Operators.terminate(MAIN, this);
            Operators.terminate(OTHER, this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            Operators.terminate(OTHER, this);
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                Operators.error(this.actual, th);
            } else if (this.main == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.gate) {
                this.actual.onNext(t10);
            } else {
                Operators.onDiscard(t10, this.ctx);
                this.main.request(1L);
            }
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
    public static final class SkipUntilOtherSubscriber<U> implements InnerConsumer<U> {
        final SkipUntilMainSubscriber<?> main;

        public SkipUntilOtherSubscriber(SkipUntilMainSubscriber<?> skipUntilMainSubscriber) {
            this.main = skipUntilMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            if (skipUntilMainSubscriber.gate) {
                return;
            }
            skipUntilMainSubscriber.gate = true;
            skipUntilMainSubscriber.other = Operators.cancelledSubscription();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            if (skipUntilMainSubscriber.gate) {
                Operators.onErrorDropped(th, this.main.currentContext());
            } else {
                skipUntilMainSubscriber.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(U u10) {
            if (this.main.gate) {
                return;
            }
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            skipUntilMainSubscriber.other.cancel();
            skipUntilMainSubscriber.gate = true;
            skipUntilMainSubscriber.other = Operators.cancelledSubscription();
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

    public FluxSkipUntilOther(Flux<? extends T> flux, qd.c cVar) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(coreSubscriber);
        this.other.subscribe(new SkipUntilOtherSubscriber(skipUntilMainSubscriber));
        return skipUntilMainSubscriber;
    }
}
