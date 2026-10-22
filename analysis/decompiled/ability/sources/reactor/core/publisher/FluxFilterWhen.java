package reactor.core.publisher;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
class FluxFilterWhen<T> extends InternalFluxOperator<T, T> {
    final Function<? super T, ? extends Z9.c> asyncPredicate;
    final int bufferSize;

    public static final class FilterWhenInner implements InnerConsumer<Boolean> {
        static final AtomicReferenceFieldUpdater<FilterWhenInner, Z9.e> SUB = AtomicReferenceFieldUpdater.newUpdater(FilterWhenInner.class, Z9.e.class, "sub");
        final boolean cancelOnNext;
        boolean done;
        final FluxFilterWhenSubscriber<?> parent;
        volatile Z9.e sub;

        public FilterWhenInner(FluxFilterWhenSubscriber<?> fluxFilterWhenSubscriber, boolean z10) {
            this.parent = fluxFilterWhenSubscriber;
            this.cancelOnNext = z10;
        }

        public void cancel() {
            Operators.terminate(SUB, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(SUB, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.sub;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.sub == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.done ? 0L : 1L);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Boolean bool) {
            if (this.done) {
                return;
            }
            if (this.cancelOnNext) {
                this.sub.cancel();
            }
            this.done = true;
            this.parent.innerResult(bool);
        }
    }

    public static final class FluxFilterWhenSubscriber<T> implements InnerOperator<T, T> {
        static final int STATE_FRESH = 0;
        static final int STATE_RESULT = 2;
        static final int STATE_RUNNING = 1;
        final CoreSubscriber<? super T> actual;
        final Function<? super T, ? extends Z9.c> asyncPredicate;
        final int bufferSize;
        volatile boolean cancelled;
        int consumed;
        long consumerIndex;
        final Context ctx;
        volatile FilterWhenInner current;
        volatile boolean done;
        long emitted;
        volatile Throwable error;
        Boolean innerResult;
        long producerIndex;
        volatile long requested;
        volatile int state;
        final AtomicReferenceArray<T> toFilter;
        Z9.e upstream;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<FluxFilterWhenSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, Throwable.class, "error");
        static final AtomicLongFieldUpdater<FluxFilterWhenSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, "requested");
        static final AtomicIntegerFieldUpdater<FluxFilterWhenSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, "wip");
        static final AtomicReferenceFieldUpdater<FluxFilterWhenSubscriber, FilterWhenInner> CURRENT = AtomicReferenceFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, FilterWhenInner.class, "current");
        static final FilterWhenInner INNER_CANCELLED = new FilterWhenInner(null, false);

        public FluxFilterWhenSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends Z9.c> function, int i) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.toFilter = new AtomicReferenceArray<>(Queues.ceilingNextPowerOfTwo(i));
            this.asyncPredicate = function;
            this.bufferSize = i;
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
            this.upstream.cancel();
            cancelInner();
            if (WIP.getAndIncrement(this) == 0) {
                clear();
            }
        }

        public void cancelInner() {
            FilterWhenInner andSet;
            AtomicReferenceFieldUpdater<FluxFilterWhenSubscriber, FilterWhenInner> atomicReferenceFieldUpdater = CURRENT;
            FilterWhenInner filterWhenInner = atomicReferenceFieldUpdater.get(this);
            FilterWhenInner filterWhenInner2 = INNER_CANCELLED;
            if (filterWhenInner == filterWhenInner2 || (andSet = atomicReferenceFieldUpdater.getAndSet(this, filterWhenInner2)) == null || andSet == filterWhenInner2) {
                return;
            }
            andSet.cancel();
        }

        public void clear() {
            int length = this.toFilter.length();
            for (int i = 0; i < length; i++) {
                Operators.onDiscard(this.toFilter.getAndSet(i, null), this.ctx);
            }
            this.innerResult = null;
        }

        public void clearCurrent() {
            FilterWhenInner filterWhenInner = this.current;
            if (filterWhenInner != INNER_CANCELLED) {
                CURRENT.compareAndSet(this, filterWhenInner, null);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 395
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxFilterWhen.FluxFilterWhenSubscriber.drain():void");
        }

        public void innerComplete() {
            this.state = 2;
            clearCurrent();
            drain();
        }

        public void innerError(Throwable th) {
            Exceptions.addThrowable(ERROR, this, th);
            this.state = 2;
            clearCurrent();
            drain();
        }

        public void innerResult(Boolean bool) {
            this.innerResult = bool;
            this.state = 2;
            clearCurrent();
            drain();
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            FilterWhenInner filterWhenInner = this.current;
            return filterWhenInner == null ? Stream.empty() : Stream.of(filterWhenInner);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            ERROR.set(this, th);
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            long j5 = this.producerIndex;
            this.toFilter.lazySet((this.toFilter.length() - 1) & ((int) j5), t9);
            this.producerIndex = j5 + 1;
            drain();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.actual.onSubscribe(this);
                eVar.request(this.bufferSize);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.upstream;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.CAPACITY) {
                return Integer.valueOf(this.toFilter.length());
            }
            if (attr == Scannable.Attr.LARGE_BUFFERED) {
                return Long.valueOf(this.producerIndex - this.consumerIndex);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.bufferSize) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            long j5 = this.producerIndex - this.consumerIndex;
            if (j5 <= SieveCacheKt.NodeLinkMask) {
                return Integer.valueOf((int) j5);
            }
            return Integer.MIN_VALUE;
        }
    }

    public FluxFilterWhen(Flux<T> flux, Function<? super T, ? extends Z9.c> function, int i) {
        super(flux);
        this.asyncPredicate = function;
        this.bufferSize = i;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxFilterWhenSubscriber(coreSubscriber, this.asyncPredicate, this.bufferSize);
    }
}
