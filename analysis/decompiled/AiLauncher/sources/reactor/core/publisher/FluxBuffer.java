package reactor.core.publisher;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxBuffer<T, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final int size;
    final int skip;

    public static final class BufferExactSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39471s;
        final int size;

        public BufferExactSubscriber(CoreSubscriber<? super C> coreSubscriber, int i10, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.size = i10;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39471s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c10 = this.buffer;
            if (c10 != null && !c10.isEmpty()) {
                this.actual.onNext(c10);
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
            this.actual.onError(th);
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            C c10 = this.buffer;
            if (c10 == null) {
                try {
                    C c11 = this.bufferSupplier.get();
                    Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                    c10 = c11;
                    this.buffer = c10;
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f39471s, th, t10, contextCurrentContext));
                    Operators.onDiscard(t10, contextCurrentContext);
                    return;
                }
            }
            if (!c10.add(t10)) {
                Operators.onDiscard(t10, this.actual.currentContext());
                this.f39471s.request(1L);
            } else if (c10.size() == this.size) {
                this.buffer = null;
                this.actual.onNext(c10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39471s, dVar)) {
                this.f39471s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.f39471s.request(Operators.multiplyCap(j10, this.size));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39471s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                C c10 = this.buffer;
                return Integer.valueOf(c10 != null ? c10.size() : 0);
            }
            if (attr != Scannable.Attr.CAPACITY && attr != Scannable.Attr.PREFETCH) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            return Integer.valueOf(this.size);
        }
    }

    public static final class BufferOverlappingSubscriber<T, C extends Collection<? super T>> extends ArrayDeque<C> implements BooleanSupplier, InnerOperator<T, C> {
        static final AtomicIntegerFieldUpdater<BufferOverlappingSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(BufferOverlappingSubscriber.class, "once");
        static final AtomicLongFieldUpdater<BufferOverlappingSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferOverlappingSubscriber.class, "requested");
        final CoreSubscriber<? super C> actual;
        final Supplier<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        long index;
        volatile int once;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39472s;
        final int size;
        final int skip;

        public BufferOverlappingSubscriber(CoreSubscriber<? super C> coreSubscriber, int i10, int i11, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.cancelled = true;
            this.f39472s.cancel();
            clear();
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Context contextCurrentContext = this.actual.currentContext();
            Iterator<C> it = iterator();
            while (it.hasNext()) {
                Operators.onDiscardMultiple(it.next(), contextCurrentContext);
            }
            super.clear();
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j10 = this.produced;
            if (j10 != 0) {
                Operators.produced(REQUESTED, this, j10);
            }
            DrainUtils.postComplete(this.actual, this, REQUESTED, this, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            clear();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.index;
            if (j10 % this.skip == 0) {
                try {
                    C c10 = this.bufferSupplier.get();
                    Objects.requireNonNull(c10, "The bufferSupplier returned a null buffer");
                    offer(c10);
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f39472s, th, t10, contextCurrentContext));
                    Operators.onDiscard(t10, contextCurrentContext);
                    return;
                }
            }
            C cPeek = peek();
            if (cPeek != null && cPeek.size() + 1 == this.size) {
                poll();
                cPeek.add(t10);
                this.actual.onNext(cPeek);
                this.produced++;
            }
            Iterator<C> it = iterator();
            while (it.hasNext()) {
                it.next().add(t10);
            }
            this.index = j10 + 1;
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39472s, dVar)) {
                this.f39472s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10) && !DrainUtils.postCompleteRequest(j10, this.actual, this, REQUESTED, this, this)) {
                if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
                    this.f39472s.request(Operators.multiplyCap(this.skip, j10));
                } else {
                    this.f39472s.request(Operators.addCap(this.size, Operators.multiplyCap(this.skip, j10 - 1)));
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39472s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.CAPACITY) {
                return Integer.valueOf(size() * this.size);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(stream().mapToInt(new C5382q0()).sum());
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class BufferSkipSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        static final AtomicIntegerFieldUpdater<BufferSkipSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(BufferSkipSubscriber.class, "wip");
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        final Context ctx;
        boolean done;
        long index;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39473s;
        final int size;
        final int skip;
        volatile int wip;

        public BufferSkipSubscriber(CoreSubscriber<? super C> coreSubscriber, int i10, int i11, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39473s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c10 = this.buffer;
            this.buffer = null;
            if (c10 != null) {
                this.actual.onNext(c10);
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
            C c10 = this.buffer;
            this.buffer = null;
            this.actual.onError(th);
            Operators.onDiscardMultiple(c10, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            C c10 = this.buffer;
            long j10 = this.index;
            if (j10 % this.skip == 0) {
                try {
                    C c11 = this.bufferSupplier.get();
                    Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                    c10 = c11;
                    this.buffer = c10;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39473s, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                    return;
                }
            }
            if (c10 != null) {
                c10.add(t10);
                if (c10.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c10);
                }
            } else {
                Operators.onDiscard(t10, this.ctx);
            }
            this.index = j10 + 1;
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39473s, dVar)) {
                this.f39473s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                    this.f39473s.request(Operators.multiplyCap(this.skip, j10));
                    return;
                }
                this.f39473s.request(Operators.addCap(Operators.multiplyCap(j10, this.size), Operators.multiplyCap(this.skip - this.size, j10 - 1)));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39473s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CAPACITY) {
                return Integer.valueOf(this.size);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.size) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            C c10 = this.buffer;
            return Integer.valueOf(c10 != null ? c10.size() : 0);
        }
    }

    public FluxBuffer(Flux<? extends T> flux, int i10, Supplier<C> supplier) {
        this(flux, i10, i10, supplier);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        int i10 = this.size;
        int i11 = this.skip;
        return i10 == i11 ? new BufferExactSubscriber(coreSubscriber, i10, this.bufferSupplier) : i11 > i10 ? new BufferSkipSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier) : new BufferOverlappingSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier);
    }

    public FluxBuffer(Flux<? extends T> flux, int i10, int i11, Supplier<C> supplier) {
        super(flux);
        if (i10 <= 0) {
            throw new IllegalArgumentException("size > 0 required but it was " + i10);
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("skip > 0 required but it was " + i11);
        }
        this.size = i10;
        this.skip = i11;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
    }
}
