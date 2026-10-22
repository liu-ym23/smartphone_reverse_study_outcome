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

/* loaded from: classes4.dex */
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
        Z9.e f5701s;
        final int size;

        public BufferExactSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.size = i;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5701s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c = this.buffer;
            if (c != null && !c.isEmpty()) {
                this.actual.onNext(c);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            this.actual.onError(th);
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            C c = this.buffer;
            if (c == null) {
                try {
                    C c2 = this.bufferSupplier.get();
                    Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                    c = c2;
                    this.buffer = c;
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f5701s, th, t9, contextCurrentContext));
                    Operators.onDiscard(t9, contextCurrentContext);
                    return;
                }
            }
            if (!c.add(t9)) {
                Operators.onDiscard(t9, this.actual.currentContext());
                this.f5701s.request(1L);
            } else if (c.size() == this.size) {
                this.buffer = null;
                this.actual.onNext(c);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5701s, eVar)) {
                this.f5701s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                this.f5701s.request(Operators.multiplyCap(j5, this.size));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5701s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                C c = this.buffer;
                return Integer.valueOf(c != null ? c.size() : 0);
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
        Z9.e f5702s;
        final int size;
        final int skip;

        public BufferOverlappingSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, int i6, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.size = i;
            this.skip = i6;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.cancelled = true;
            this.f5702s.cancel();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j5 = this.produced;
            if (j5 != 0) {
                Operators.produced(REQUESTED, this, j5);
            }
            DrainUtils.postComplete(this.actual, this, REQUESTED, this, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            clear();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.index;
            if (j5 % this.skip == 0) {
                try {
                    C c = this.bufferSupplier.get();
                    Objects.requireNonNull(c, "The bufferSupplier returned a null buffer");
                    offer(c);
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f5702s, th, t9, contextCurrentContext));
                    Operators.onDiscard(t9, contextCurrentContext);
                    return;
                }
            }
            C cPeek = peek();
            if (cPeek != null && cPeek.size() + 1 == this.size) {
                poll();
                cPeek.add(t9);
                this.actual.onNext(cPeek);
                this.produced++;
            }
            Iterator<C> it = iterator();
            while (it.hasNext()) {
                it.next().add(t9);
            }
            this.index = j5 + 1;
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5702s, eVar)) {
                this.f5702s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5) && !DrainUtils.postCompleteRequest(j5, this.actual, this, REQUESTED, this, this)) {
                if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
                    this.f5702s.request(Operators.multiplyCap(this.skip, j5));
                } else {
                    this.f5702s.request(Operators.addCap(this.size, Operators.multiplyCap(this.skip, j5 - 1)));
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5702s;
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
                return Integer.valueOf(stream().mapToInt(new F()).sum());
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
        Z9.e f5703s;
        final int size;
        final int skip;
        volatile int wip;

        public BufferSkipSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, int i6, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.size = i;
            this.skip = i6;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5703s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            if (c != null) {
                this.actual.onNext(c);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            this.actual.onError(th);
            Operators.onDiscardMultiple(c, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.ctx);
                return;
            }
            C c = this.buffer;
            long j5 = this.index;
            if (j5 % this.skip == 0) {
                try {
                    C c2 = this.bufferSupplier.get();
                    Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                    c = c2;
                    this.buffer = c;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5703s, th, t9, this.ctx));
                    Operators.onDiscard(t9, this.ctx);
                    return;
                }
            }
            if (c != null) {
                c.add(t9);
                if (c.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c);
                }
            } else {
                Operators.onDiscard(t9, this.ctx);
            }
            this.index = j5 + 1;
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5703s, eVar)) {
                this.f5703s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                    this.f5703s.request(Operators.multiplyCap(this.skip, j5));
                    return;
                }
                this.f5703s.request(Operators.addCap(Operators.multiplyCap(j5, this.size), Operators.multiplyCap(this.skip - this.size, j5 - 1)));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5703s;
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
            C c = this.buffer;
            return Integer.valueOf(c != null ? c.size() : 0);
        }
    }

    public FluxBuffer(Flux<? extends T> flux, int i, Supplier<C> supplier) {
        this(flux, i, i, supplier);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        int i = this.size;
        int i6 = this.skip;
        return i == i6 ? new BufferExactSubscriber(coreSubscriber, i, this.bufferSupplier) : i6 > i ? new BufferSkipSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier) : new BufferOverlappingSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier);
    }

    public FluxBuffer(Flux<? extends T> flux, int i, int i6, Supplier<C> supplier) {
        super(flux);
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "size > 0 required but it was "));
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "skip > 0 required but it was "));
        }
        this.size = i;
        this.skip = i6;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
    }
}
