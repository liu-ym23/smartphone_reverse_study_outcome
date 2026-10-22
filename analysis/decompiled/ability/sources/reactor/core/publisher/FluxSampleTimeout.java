package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxSampleTimeout<T, U> extends InternalFluxOperator<T, T> {
    final Supplier<Queue<Object>> queueSupplier;
    final Function<? super T, ? extends Z9.c> throttler;

    public static final class SampleTimeoutMain<T, U> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final Context ctx;
        volatile boolean done;
        volatile Throwable error;
        volatile long index;
        volatile Z9.e other;
        final Queue<SampleTimeoutOther<T, U>> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5789s;
        final Function<? super T, ? extends Z9.c> throttler;
        volatile int wip;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<SampleTimeoutMain, Z9.e> f5788S = AtomicReferenceFieldUpdater.newUpdater(SampleTimeoutMain.class, Z9.e.class, "s");
        static final AtomicReferenceFieldUpdater<SampleTimeoutMain, Z9.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(SampleTimeoutMain.class, Z9.e.class, "other");
        static final AtomicLongFieldUpdater<SampleTimeoutMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SampleTimeoutMain.class, "requested");
        static final AtomicIntegerFieldUpdater<SampleTimeoutMain> WIP = AtomicIntegerFieldUpdater.newUpdater(SampleTimeoutMain.class, "wip");
        static final AtomicReferenceFieldUpdater<SampleTimeoutMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(SampleTimeoutMain.class, Throwable.class, "error");
        static final AtomicLongFieldUpdater<SampleTimeoutMain> INDEX = AtomicLongFieldUpdater.newUpdater(SampleTimeoutMain.class, "index");

        public SampleTimeoutMain(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends Z9.c> function, Queue<SampleTimeoutOther<T, U>> queue) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.throttler = function;
            this.queue = queue;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            Operators.terminate(f5788S, this);
            Operators.terminate(OTHER, this);
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, new C1885a(10));
        }

        public boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, Queue<SampleTimeoutOther<T, U>> queue) {
            if (this.cancelled) {
                Operators.onDiscardQueueWithClear(queue, this.ctx, new C1885a(10));
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate == null || thTerminate == Exceptions.TERMINATED) {
                if (!z11) {
                    return false;
                }
                dVar.onComplete();
                return true;
            }
            cancel();
            Operators.onDiscardQueueWithClear(queue, this.ctx, new C1885a(10));
            dVar.onError(thTerminate);
            return true;
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            Queue<SampleTimeoutOther<T, U>> queue = this.queue;
            int iAddAndGet = 1;
            while (true) {
                boolean z10 = this.done;
                SampleTimeoutOther<T, U> sampleTimeoutOtherPoll = queue.poll();
                boolean z11 = sampleTimeoutOtherPoll == null;
                if (checkTerminated(z10, z11, coreSubscriber, queue)) {
                    return;
                }
                if (z11) {
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (sampleTimeoutOtherPoll.index == this.index) {
                    long j5 = this.requested;
                    if (j5 == 0) {
                        cancel();
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new C1885a(10));
                        IllegalStateException illegalStateExceptionFailWithOverflow = Exceptions.failWithOverflow("Could not emit value due to lack of requests");
                        AtomicReferenceFieldUpdater<SampleTimeoutMain, Throwable> atomicReferenceFieldUpdater = ERROR;
                        Exceptions.addThrowable(atomicReferenceFieldUpdater, this, illegalStateExceptionFailWithOverflow);
                        coreSubscriber.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
                        return;
                    }
                    coreSubscriber.onNext(sampleTimeoutOtherPoll.value);
                    if (j5 != Long.MAX_VALUE) {
                        REQUESTED.decrementAndGet(this);
                    }
                } else {
                    continue;
                }
            }
        }

        public void error(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            Z9.e eVar = this.other;
            if (eVar instanceof SampleTimeoutOther) {
                SampleTimeoutOther sampleTimeoutOther = (SampleTimeoutOther) eVar;
                sampleTimeoutOther.cancel();
                sampleTimeoutOther.onComplete();
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Operators.terminate(OTHER, this);
            error(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            long jIncrementAndGet = INDEX.incrementAndGet(this);
            AtomicReferenceFieldUpdater<SampleTimeoutMain, Z9.e> atomicReferenceFieldUpdater = OTHER;
            if (Operators.set(atomicReferenceFieldUpdater, this, Operators.emptySubscription())) {
                try {
                    Z9.c cVarApply = this.throttler.apply(t9);
                    Objects.requireNonNull(cVarApply, "throttler returned a null publisher");
                    Z9.c cVar = cVarApply;
                    SampleTimeoutOther sampleTimeoutOther = new SampleTimeoutOther(this, t9, jIncrementAndGet);
                    if (Operators.replace(atomicReferenceFieldUpdater, this, sampleTimeoutOther)) {
                        Operators.toFluxOrMono(cVar).subscribe((Z9.d) sampleTimeoutOther);
                    }
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5789s, th, t9, this.ctx));
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5788S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void otherError(long j5, Throwable th) {
            if (j5 != this.index) {
                Operators.onErrorDropped(th, this.ctx);
            } else {
                Operators.terminate(f5788S, this);
                error(th);
            }
        }

        public void otherNext(SampleTimeoutOther<T, U> sampleTimeoutOther) {
            this.queue.offer(sampleTimeoutOther);
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.PARENT ? this.f5789s : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class SampleTimeoutOther<T, U> extends Operators.DeferredSubscription implements InnerConsumer<U> {
        static final AtomicIntegerFieldUpdater<SampleTimeoutOther> ONCE = AtomicIntegerFieldUpdater.newUpdater(SampleTimeoutOther.class, "once");
        final long index;
        final SampleTimeoutMain<T, U> main;
        volatile int once;
        final T value;

        public SampleTimeoutOther(SampleTimeoutMain<T, U> sampleTimeoutMain, T t9, long j5) {
            this.main = sampleTimeoutMain;
            this.value = t9;
            this.index = j5;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (ONCE.compareAndSet(this, 0, 1)) {
                this.main.otherNext(this);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (ONCE.compareAndSet(this, 0, 1)) {
                this.main.otherError(this.index, th);
            } else {
                Operators.onErrorDropped(th, this.main.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(U u) {
            if (ONCE.compareAndSet(this, 0, 1)) {
                cancel();
                this.main.otherNext(this);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (set(eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.once == 1);
            }
            return attr == Scannable.Attr.ACTUAL ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public final Stream<T> toStream() {
            return Stream.of(this.value);
        }
    }

    public FluxSampleTimeout(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function, Supplier<Queue<Object>> supplier) {
        super(flux);
        Objects.requireNonNull(function, "throttler");
        this.throttler = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
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
        SampleTimeoutMain sampleTimeoutMain = new SampleTimeoutMain(coreSubscriber, this.throttler, this.queueSupplier.get());
        coreSubscriber.onSubscribe(sampleTimeoutMain);
        return sampleTimeoutMain;
    }
}
