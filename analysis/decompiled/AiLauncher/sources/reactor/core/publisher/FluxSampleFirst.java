package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxSampleFirst<T, U> extends InternalFluxOperator<T, T> {
    final Function<? super T, ? extends qc.b<U>> throttler;

    public static final class SampleFirstMain<T, U> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile Throwable error;
        volatile boolean gate;
        volatile qc.d other;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39559s;
        final Function<? super T, ? extends qc.b<U>> throttler;
        volatile int wip;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<SampleFirstMain, qc.d> f39558S = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, qc.d.class, "s");
        static final AtomicReferenceFieldUpdater<SampleFirstMain, qc.d> OTHER = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, qc.d.class, "other");
        static final AtomicLongFieldUpdater<SampleFirstMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SampleFirstMain.class, "requested");
        static final AtomicIntegerFieldUpdater<SampleFirstMain> WIP = AtomicIntegerFieldUpdater.newUpdater(SampleFirstMain.class, "wip");
        static final AtomicReferenceFieldUpdater<SampleFirstMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, Throwable.class, "error");

        public SampleFirstMain(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qc.b<U>> function) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.throttler = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Operators.terminate(f39558S, this);
            Operators.terminate(OTHER, this);
        }

        public void error(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
            } else if (WIP.getAndIncrement(this) == 0) {
                handleTermination();
            }
        }

        public void handleTermination() {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate == null || thTerminate == Exceptions.TERMINATED) {
                this.actual.onComplete();
            } else {
                this.actual.onError(thTerminate);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            Operators.terminate(OTHER, this);
            if (WIP.getAndIncrement(this) == 0) {
                handleTermination();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            Operators.terminate(OTHER, this);
            error(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.gate) {
                Operators.onDiscard(t10, this.ctx);
                return;
            }
            this.gate = true;
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<SampleFirstMain> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    this.actual.onNext(t10);
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        handleTermination();
                        return;
                    }
                    try {
                        qc.b<U> bVarApply = this.throttler.apply(t10);
                        Objects.requireNonNull(bVarApply, "The throttler returned a null publisher");
                        qc.b<U> bVar = bVarApply;
                        SampleFirstOther sampleFirstOther = new SampleFirstOther(this);
                        if (Operators.replace(OTHER, this, sampleFirstOther)) {
                            Operators.toFluxOrMono(bVar).subscribe((qc.c) sampleFirstOther);
                        }
                    } catch (Throwable th) {
                        Operators.terminate(f39558S, this);
                        error(Operators.onOperatorError(null, th, t10, this.ctx));
                    }
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39558S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void otherError(Throwable th) {
            Operators.terminate(f39558S, this);
            error(th);
        }

        public void otherNext() {
            this.gate = false;
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
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39559s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.f39559s : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class SampleFirstOther<U> extends Operators.DeferredSubscription implements InnerConsumer<U> {
        final SampleFirstMain<?, U> main;

        public SampleFirstOther(SampleFirstMain<?, U> sampleFirstMain) {
            this.main = sampleFirstMain;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.main.otherNext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(U u10) {
            cancel();
            this.main.otherNext();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (set(dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSampleFirst(Flux<? extends T> flux, Function<? super T, ? extends qc.b<U>> function) {
        super(flux);
        Objects.requireNonNull(function, "throttler");
        this.throttler = function;
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
        SampleFirstMain sampleFirstMain = new SampleFirstMain(coreSubscriber, this.throttler);
        coreSubscriber.onSubscribe(sampleFirstMain);
        return sampleFirstMain;
    }
}
