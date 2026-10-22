package reactor.core.publisher;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxWindow<T> extends InternalFluxOperator<T, Flux<T>> {
    final Supplier<? extends Queue<Sinks.Many<T>>> overflowQueueSupplier;
    final Supplier<? extends Queue<T>> processorQueueSupplier;
    final int size;
    final int skip;

    public static final class WindowExactSubscriber<T> implements Disposable, InnerOperator<T, Flux<T>> {
        static final AtomicIntegerFieldUpdater<WindowExactSubscriber> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(WindowExactSubscriber.class, "cancelled");
        static final AtomicIntegerFieldUpdater<WindowExactSubscriber> WINDOW_COUNT = AtomicIntegerFieldUpdater.newUpdater(WindowExactSubscriber.class, "windowCount");
        final CoreSubscriber<? super Flux<T>> actual;
        volatile int cancelled;
        boolean done;
        int index;
        final Supplier<? extends Queue<T>> processorQueueSupplier;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39602s;
        final int size;
        Sinks.Many<T> window;
        volatile int windowCount;

        public WindowExactSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, int i10, Supplier<? extends Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.size = i10;
            this.processorQueueSupplier = supplier;
            WINDOW_COUNT.lazySet(this, 1);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                dispose();
            }
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.f39602s.cancel();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.window));
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.cancelled == 1 || this.done;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Sinks.Many<T> many = this.window;
            if (many != null) {
                this.window = null;
                many.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Sinks.Many<T> many = this.window;
            if (many != null) {
                this.window = null;
                many.emitError(Exceptions.wrapSource(th), Sinks.EmitFailureHandler.FAIL_FAST);
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            int i10 = this.index;
            Sinks.Many<T> manyOnBackpressureBuffer = this.window;
            if (this.cancelled == 0 && i10 == 0) {
                WINDOW_COUNT.getAndIncrement(this);
                manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer(this.processorQueueSupplier.get(), this);
                this.window = manyOnBackpressureBuffer;
                this.actual.onNext(manyOnBackpressureBuffer.asFlux());
            }
            int i11 = i10 + 1;
            Sinks.EmitFailureHandler emitFailureHandler = Sinks.EmitFailureHandler.FAIL_FAST;
            manyOnBackpressureBuffer.emitNext(t10, emitFailureHandler);
            if (i11 != this.size) {
                this.index = i11;
                return;
            }
            this.index = 0;
            this.window = null;
            manyOnBackpressureBuffer.emitComplete(emitFailureHandler);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39602s, dVar)) {
                this.f39602s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.f39602s.request(Operators.multiplyCap(this.size, j10));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39602s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            return attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.size) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class WindowOverlapSubscriber<T> extends ArrayDeque<Sinks.Many<T>> implements Disposable, InnerOperator<T, Flux<T>> {
        final CoreSubscriber<? super Flux<T>> actual;
        volatile int cancelled;
        volatile boolean done;
        Throwable error;
        volatile int firstRequest;
        int index;
        final Supplier<? extends Queue<T>> processorQueueSupplier;
        int produced;
        final Queue<Sinks.Many<T>> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39603s;
        final int size;
        final int skip;
        volatile int windowCount;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<WindowOverlapSubscriber> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(WindowOverlapSubscriber.class, "cancelled");
        static final AtomicIntegerFieldUpdater<WindowOverlapSubscriber> WINDOW_COUNT = AtomicIntegerFieldUpdater.newUpdater(WindowOverlapSubscriber.class, "windowCount");
        static final AtomicIntegerFieldUpdater<WindowOverlapSubscriber> FIRST_REQUEST = AtomicIntegerFieldUpdater.newUpdater(WindowOverlapSubscriber.class, "firstRequest");
        static final AtomicLongFieldUpdater<WindowOverlapSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(WindowOverlapSubscriber.class, "requested");
        static final AtomicIntegerFieldUpdater<WindowOverlapSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(WindowOverlapSubscriber.class, "wip");

        public WindowOverlapSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, int i10, int i11, Supplier<? extends Queue<T>> supplier, Queue<Sinks.Many<T>> queue) {
            this.actual = coreSubscriber;
            this.size = i10;
            this.skip = i11;
            this.processorQueueSupplier = supplier;
            WINDOW_COUNT.lazySet(this, 1);
            this.queue = queue;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                dispose();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qc.c<?> cVar, Queue<?> queue) {
            if (this.cancelled == 1) {
                queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                queue.clear();
                cVar.onError(th);
                return true;
            }
            if (!z11) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.f39603s.cancel();
            }
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
            Queue<Sinks.Many<T>> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (j11 != j10) {
                    boolean z10 = this.done;
                    Sinks.Many<T> manyPoll = queue.poll();
                    boolean z11 = manyPoll == null;
                    if (checkTerminated(z10, z11, coreSubscriber, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    coreSubscriber.onNext(manyPoll.asFlux());
                    j11++;
                }
                if (j11 == j10 && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, queue)) {
                    return;
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(toArray()).map(new reactor.core.j());
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.cancelled == 1 || this.done;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Iterator<Sinks.Many<T>> it = iterator();
            while (it.hasNext()) {
                it.next().emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
            }
            clear();
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Iterator<Sinks.Many<T>> it = iterator();
            while (it.hasNext()) {
                it.next().emitError(Exceptions.wrapSource(th), Sinks.EmitFailureHandler.FAIL_FAST);
            }
            clear();
            this.error = th;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            int i10 = this.index;
            if (i10 == 0 && this.cancelled == 0) {
                WINDOW_COUNT.getAndIncrement(this);
                Sinks.Many<T> manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer(this.processorQueueSupplier.get(), this);
                offer(manyOnBackpressureBuffer);
                this.queue.offer(manyOnBackpressureBuffer);
                drain();
            }
            int i11 = i10 + 1;
            Iterator<Sinks.Many<T>> it = iterator();
            while (it.hasNext()) {
                it.next().emitNext(t10, Sinks.EmitFailureHandler.FAIL_FAST);
            }
            int i12 = this.produced + 1;
            if (i12 == this.size) {
                this.produced = i12 - this.skip;
                Sinks.Many<T> manyPoll = poll();
                if (manyPoll != null) {
                    manyPoll.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                }
            } else {
                this.produced = i12;
            }
            if (i11 == this.skip) {
                this.index = 0;
            } else {
                this.index = i11;
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39603s, dVar)) {
                this.f39603s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                if (this.firstRequest == 0 && FIRST_REQUEST.compareAndSet(this, 0, 1)) {
                    this.f39603s.request(Operators.addCap(this.size, Operators.multiplyCap(this.skip, j10 - 1)));
                } else {
                    this.f39603s.request(Operators.multiplyCap(this.skip, j10));
                }
                drain();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39603s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            if (attr == Scannable.Attr.CAPACITY) {
                return Integer.valueOf(this.size);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.LARGE_BUFFERED) {
                return Long.valueOf(this.queue.size() + size());
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            long size = this.queue.size() + size();
            if (size < 2147483647L) {
                return Integer.valueOf((int) size);
            }
            return Integer.MIN_VALUE;
        }
    }

    public static final class WindowSkipSubscriber<T> implements Disposable, InnerOperator<T, Flux<T>> {
        final CoreSubscriber<? super Flux<T>> actual;
        volatile int cancelled;
        final Context ctx;
        boolean done;
        volatile int firstRequest;
        int index;
        final Supplier<? extends Queue<T>> processorQueueSupplier;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39604s;
        final int size;
        final int skip;
        Sinks.Many<T> window;
        volatile int windowCount;
        static final AtomicIntegerFieldUpdater<WindowSkipSubscriber> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(WindowSkipSubscriber.class, "cancelled");
        static final AtomicIntegerFieldUpdater<WindowSkipSubscriber> WINDOW_COUNT = AtomicIntegerFieldUpdater.newUpdater(WindowSkipSubscriber.class, "windowCount");
        static final AtomicIntegerFieldUpdater<WindowSkipSubscriber> FIRST_REQUEST = AtomicIntegerFieldUpdater.newUpdater(WindowSkipSubscriber.class, "firstRequest");

        public WindowSkipSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, int i10, int i11, Supplier<? extends Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.size = i10;
            this.skip = i11;
            this.processorQueueSupplier = supplier;
            WINDOW_COUNT.lazySet(this, 1);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                dispose();
            }
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.f39604s.cancel();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.window));
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.cancelled == 1 || this.done;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Sinks.Many<T> many = this.window;
            if (many != null) {
                this.window = null;
                many.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            Sinks.Many<T> many = this.window;
            if (many != null) {
                this.window = null;
                many.emitError(Exceptions.wrapSource(th), Sinks.EmitFailureHandler.FAIL_FAST);
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            int i10 = this.index;
            Sinks.Many<T> manyOnBackpressureBuffer = this.window;
            if (i10 == 0) {
                WINDOW_COUNT.getAndIncrement(this);
                manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer(this.processorQueueSupplier.get(), this);
                this.window = manyOnBackpressureBuffer;
                this.actual.onNext(manyOnBackpressureBuffer.asFlux());
            }
            int i11 = i10 + 1;
            if (manyOnBackpressureBuffer != null) {
                manyOnBackpressureBuffer.emitNext(t10, Sinks.EmitFailureHandler.FAIL_FAST);
            } else {
                Operators.onDiscard(t10, this.ctx);
            }
            if (i11 == this.size) {
                this.window = null;
                if (manyOnBackpressureBuffer != null) {
                    manyOnBackpressureBuffer.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                }
            }
            if (i11 == this.skip) {
                this.index = 0;
            } else {
                this.index = i11;
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39604s, dVar)) {
                this.f39604s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                if (this.firstRequest == 0 && FIRST_REQUEST.compareAndSet(this, 0, 1)) {
                    this.f39604s.request(Operators.addCap(Operators.multiplyCap(this.size, j10), Operators.multiplyCap(this.skip - this.size, j10 - 1)));
                } else {
                    this.f39604s.request(Operators.multiplyCap(this.skip, j10));
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39604s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            return attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.size) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxWindow(Flux<? extends T> flux, int i10, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        if (i10 <= 0) {
            throw new IllegalArgumentException("size > 0 required but it was " + i10);
        }
        this.size = i10;
        this.skip = i10;
        Objects.requireNonNull(supplier, "processorQueueSupplier");
        this.processorQueueSupplier = supplier;
        this.overflowQueueSupplier = null;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Flux<T>> coreSubscriber) {
        int i10 = this.skip;
        int i11 = this.size;
        return i10 == i11 ? new WindowExactSubscriber(coreSubscriber, this.size, this.processorQueueSupplier) : i10 > i11 ? new WindowSkipSubscriber(coreSubscriber, this.size, this.skip, this.processorQueueSupplier) : new WindowOverlapSubscriber(coreSubscriber, this.size, this.skip, this.processorQueueSupplier, this.overflowQueueSupplier.get());
    }

    public FluxWindow(Flux<? extends T> flux, int i10, int i11, Supplier<? extends Queue<T>> supplier, Supplier<? extends Queue<Sinks.Many<T>>> supplier2) {
        super(flux);
        if (i10 <= 0) {
            throw new IllegalArgumentException("size > 0 required but it was " + i10);
        }
        if (i11 > 0) {
            this.size = i10;
            this.skip = i11;
            Objects.requireNonNull(supplier, "processorQueueSupplier");
            this.processorQueueSupplier = supplier;
            Objects.requireNonNull(supplier2, "overflowQueueSupplier");
            this.overflowQueueSupplier = supplier2;
            return;
        }
        throw new IllegalArgumentException("skip > 0 required but it was " + i11);
    }
}
