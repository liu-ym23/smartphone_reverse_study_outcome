package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxScanSeed<T, R> extends InternalFluxOperator<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Supplier<R> initialSupplier;

    public static final class ScanSeedCoordinator<T, R> extends Operators.MultiSubscriptionSubscriber<R, R> {
        static final AtomicIntegerFieldUpdater<ScanSeedCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(ScanSeedCoordinator.class, "wip");
        final BiFunction<R, ? super T, R> accumulator;
        final Supplier<R> initialSupplier;
        long produced;
        private ScanSeedSubscriber<T, R> seedSubscriber;
        final Flux<? extends T> source;
        volatile int wip;

        public ScanSeedCoordinator(CoreSubscriber<? super R> coreSubscriber, Flux<? extends T> flux, BiFunction<R, ? super T, R> biFunction, Supplier<R> supplier) {
            super(coreSubscriber);
            this.source = flux;
            this.accumulator = biFunction;
            this.initialSupplier = supplier;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (WIP.getAndIncrement(this) == 0) {
                while (!isCancelled()) {
                    ScanSeedSubscriber<T, R> scanSeedSubscriber = this.seedSubscriber;
                    if (scanSeedSubscriber != null && this.subscription == scanSeedSubscriber) {
                        this.actual.onComplete();
                        return;
                    }
                    long j5 = this.produced;
                    if (j5 != 0) {
                        this.produced = 0L;
                        produced(j5);
                    }
                    ScanSeedSubscriber<T, R> scanSeedSubscriber2 = this.seedSubscriber;
                    if (scanSeedSubscriber2 == null) {
                        try {
                            R r5 = this.initialSupplier.get();
                            Objects.requireNonNull(r5, "The initial value supplied is null");
                            onSubscribe(Operators.scalarSubscription(this, r5));
                            this.seedSubscriber = new ScanSeedSubscriber<>(this, this.accumulator, r5);
                        } catch (Throwable th) {
                            onError(Operators.onOperatorError(th, this.actual.currentContext()));
                            return;
                        }
                    } else {
                        this.source.subscribe((CoreSubscriber<? super Object>) scanSeedSubscriber2);
                    }
                    if (isCancelled() || WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            this.produced++;
            this.actual.onNext(r5);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class ScanSeedSubscriber<T, R> implements InnerOperator<T, R> {
        final BiFunction<R, ? super T, R> accumulator;
        final CoreSubscriber<? super R> actual;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5791s;
        R value;

        public ScanSeedSubscriber(CoreSubscriber<? super R> coreSubscriber, BiFunction<R, ? super T, R> biFunction, R r5) {
            this.actual = coreSubscriber;
            this.accumulator = biFunction;
            this.value = r5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5791s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.value = null;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            this.value = null;
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            try {
                R rApply = this.accumulator.apply(this.value, t9);
                Objects.requireNonNull(rApply, "The accumulator returned a null value");
                this.actual.onNext(rApply);
                this.value = rApply;
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5791s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5791s, eVar)) {
                this.f5791s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5791s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5791s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxScanSeed(Flux<? extends T> flux, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flux);
        Objects.requireNonNull(biFunction, "accumulator");
        this.accumulator = biFunction;
        Objects.requireNonNull(supplier, "initialSupplier");
        this.initialSupplier = supplier;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        ScanSeedCoordinator scanSeedCoordinator = new ScanSeedCoordinator(coreSubscriber, this.source, this.accumulator, this.initialSupplier);
        coreSubscriber.onSubscribe(scanSeedCoordinator);
        if (scanSeedCoordinator.isCancelled()) {
            return null;
        }
        scanSeedCoordinator.onComplete();
        return null;
    }
}
