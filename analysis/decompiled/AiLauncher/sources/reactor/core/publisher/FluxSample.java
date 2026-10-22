package reactor.core.publisher;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxSample<T, U> extends InternalFluxOperator<T, T> {
    final qc.b<U> other;

    public static final class SampleMainSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile qc.d main;
        volatile qc.d other;
        volatile long requested;
        volatile T value;
        static final AtomicReferenceFieldUpdater<SampleMainSubscriber, Object> VALUE = AtomicReferenceFieldUpdater.newUpdater(SampleMainSubscriber.class, Object.class, UxipConstants.f30680s);
        static final AtomicReferenceFieldUpdater<SampleMainSubscriber, qc.d> MAIN = AtomicReferenceFieldUpdater.newUpdater(SampleMainSubscriber.class, qc.d.class, "main");
        static final AtomicReferenceFieldUpdater<SampleMainSubscriber, qc.d> OTHER = AtomicReferenceFieldUpdater.newUpdater(SampleMainSubscriber.class, qc.d.class, "other");
        static final AtomicLongFieldUpdater<SampleMainSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(SampleMainSubscriber.class, "requested");

        public SampleMainSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            cancelMain();
            cancelOther();
        }

        public void cancelMain() {
            qc.d andSet;
            if (this.main == Operators.cancelledSubscription() || (andSet = MAIN.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        public void cancelOther() {
            qc.d andSet;
            if (this.other == Operators.cancelledSubscription() || (andSet = OTHER.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        public void decrement() {
            REQUESTED.decrementAndGet(this);
        }

        @Nullable
        public T getAndNullValue() {
            return (T) VALUE.getAndSet(this, null);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            cancelOther();
            if (this.value != null) {
                this.actual.onNext(this.value);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            cancelOther();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            Object andSet = VALUE.getAndSet(this, t10);
            if (andSet != null) {
                Operators.onDiscard(andSet, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (MAIN.compareAndSet(this, null, dVar)) {
                dVar.request(Long.MAX_VALUE);
                return;
            }
            dVar.cancel();
            if (this.main != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.main;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.value != null ? 1 : 0);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setOther(qc.d dVar) {
            if (OTHER.compareAndSet(this, null, dVar)) {
                dVar.request(Long.MAX_VALUE);
                return;
            }
            dVar.cancel();
            if (this.other != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }
    }

    public static final class SampleOther<T, U> implements InnerConsumer<U> {
        final SampleMainSubscriber<T> main;

        public SampleOther(SampleMainSubscriber<T> sampleMainSubscriber) {
            this.main = sampleMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            SampleMainSubscriber<T> sampleMainSubscriber = this.main;
            sampleMainSubscriber.cancelMain();
            sampleMainSubscriber.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            SampleMainSubscriber<T> sampleMainSubscriber = this.main;
            sampleMainSubscriber.cancelMain();
            sampleMainSubscriber.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(U u10) {
            SampleMainSubscriber<T> sampleMainSubscriber = this.main;
            T andNullValue = sampleMainSubscriber.getAndNullValue();
            if (andNullValue != null) {
                if (sampleMainSubscriber.requested == 0) {
                    sampleMainSubscriber.cancel();
                    sampleMainSubscriber.actual.onError(Exceptions.failWithOverflow("Can't signal value due to lack of requests"));
                    Operators.onDiscard(andNullValue, sampleMainSubscriber.ctx);
                } else {
                    sampleMainSubscriber.actual.onNext(andNullValue);
                    if (sampleMainSubscriber.requested != Long.MAX_VALUE) {
                        sampleMainSubscriber.decrement();
                    }
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            this.main.setOther(dVar);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.main.other;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.main;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main.other == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxSample(Flux<? extends T> flux, qc.b<U> bVar) {
        super(flux);
        Objects.requireNonNull(bVar, "other");
        this.other = Operators.toFluxOrMono(bVar);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        SampleMainSubscriber sampleMainSubscriber = new SampleMainSubscriber(Operators.serialize(coreSubscriber));
        coreSubscriber.onSubscribe(sampleMainSubscriber);
        this.other.subscribe(new SampleOther(sampleMainSubscriber));
        return sampleMainSubscriber;
    }
}
