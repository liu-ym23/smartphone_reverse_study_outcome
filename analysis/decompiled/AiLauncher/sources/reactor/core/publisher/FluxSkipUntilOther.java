package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxSkipUntilOther<T, U> extends InternalFluxOperator<T, T> {
    final qc.b<U> other;

    public static final class SkipUntilMainSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicReferenceFieldUpdater<SkipUntilMainSubscriber, qc.d> MAIN = AtomicReferenceFieldUpdater.newUpdater(SkipUntilMainSubscriber.class, qc.d.class, "main");
        static final AtomicReferenceFieldUpdater<SkipUntilMainSubscriber, qc.d> OTHER = AtomicReferenceFieldUpdater.newUpdater(SkipUntilMainSubscriber.class, qc.d.class, "other");
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile boolean gate;
        volatile qc.d main;
        volatile qc.d other;

        public SkipUntilMainSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = Operators.serialize(coreSubscriber);
            this.ctx = coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Operators.terminate(MAIN, this);
            Operators.terminate(OTHER, this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            Operators.terminate(OTHER, this);
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.gate) {
                this.actual.onNext(t10);
            } else {
                Operators.onDiscard(t10, this.ctx);
                this.main.request(1L);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (MAIN.compareAndSet(this, null, dVar)) {
                this.actual.onSubscribe(this);
                return;
            }
            dVar.cancel();
            if (this.main != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
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

        public void setOther(qc.d dVar) {
            if (OTHER.compareAndSet(this, null, dVar)) {
                return;
            }
            dVar.cancel();
            if (this.other != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }
    }

    public static final class SkipUntilOtherSubscriber<U> implements InnerConsumer<U> {
        final SkipUntilMainSubscriber<?> main;

        public SkipUntilOtherSubscriber(SkipUntilMainSubscriber<?> skipUntilMainSubscriber) {
            this.main = skipUntilMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            if (skipUntilMainSubscriber.gate) {
                return;
            }
            skipUntilMainSubscriber.gate = true;
            skipUntilMainSubscriber.other = Operators.cancelledSubscription();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            if (skipUntilMainSubscriber.gate) {
                Operators.onErrorDropped(th, this.main.currentContext());
            } else {
                skipUntilMainSubscriber.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(U u10) {
            if (this.main.gate) {
                return;
            }
            SkipUntilMainSubscriber<?> skipUntilMainSubscriber = this.main;
            skipUntilMainSubscriber.other.cancel();
            skipUntilMainSubscriber.gate = true;
            skipUntilMainSubscriber.other = Operators.cancelledSubscription();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            this.main.setOther(dVar);
            dVar.request(Long.MAX_VALUE);
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

    public FluxSkipUntilOther(Flux<? extends T> flux, qc.b<U> bVar) {
        super(flux);
        Objects.requireNonNull(bVar, "other");
        this.other = Operators.toFluxOrMono(bVar);
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
