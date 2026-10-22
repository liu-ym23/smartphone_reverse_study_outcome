package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class FluxFilterWhen<T> extends InternalFluxOperator<T, T> {
    final Function<? super T, ? extends qd.c> asyncPredicate;
    final int bufferSize;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FilterWhenInner implements InnerConsumer<Boolean> {
        static final AtomicReferenceFieldUpdater<FilterWhenInner, qd.e> SUB = AtomicReferenceFieldUpdater.newUpdater(FilterWhenInner.class, qd.e.class, "sub");
        final boolean cancelOnNext;
        boolean done;
        final FluxFilterWhenSubscriber<?> parent;
        volatile qd.e sub;

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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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
                return Integer.valueOf(Reader.READ_DONE);
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.done ? 0L : 1L);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FluxFilterWhenSubscriber<T> implements InnerOperator<T, T> {
        static final int STATE_FRESH = 0;
        static final int STATE_RESULT = 2;
        static final int STATE_RUNNING = 1;
        final CoreSubscriber<? super T> actual;
        final Function<? super T, ? extends qd.c> asyncPredicate;
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
        qd.e upstream;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<FluxFilterWhenSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, Throwable.class, "error");
        static final AtomicLongFieldUpdater<FluxFilterWhenSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, "requested");
        static final AtomicIntegerFieldUpdater<FluxFilterWhenSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, "wip");
        static final AtomicReferenceFieldUpdater<FluxFilterWhenSubscriber, FilterWhenInner> CURRENT = AtomicReferenceFieldUpdater.newUpdater(FluxFilterWhenSubscriber.class, FilterWhenInner.class, "current");
        static final FilterWhenInner INNER_CANCELLED = new FilterWhenInner(null, false);

        public FluxFilterWhenSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qd.c> function, int i) {
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            ERROR.set(this, th);
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            long j10 = this.producerIndex;
            this.toFilter.lazySet((this.toFilter.length() - 1) & ((int) j10), t10);
            this.producerIndex = j10 + 1;
            drain();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.actual.onSubscribe(this);
                eVar.request(this.bufferSize);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
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
            long j10 = this.producerIndex - this.consumerIndex;
            if (j10 <= 2147483647L) {
                return Integer.valueOf((int) j10);
            }
            return Integer.MIN_VALUE;
        }
    }

    public FluxFilterWhen(Flux<T> flux, Function<? super T, ? extends qd.c> function, int i) {
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
