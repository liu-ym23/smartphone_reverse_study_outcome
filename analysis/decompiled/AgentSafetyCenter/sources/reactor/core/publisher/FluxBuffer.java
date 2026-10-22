package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxBuffer<T, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final int size;
    final int skip;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferExactSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10587s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10587s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c9 = this.buffer;
            if (c9 != null && !c9.isEmpty()) {
                this.actual.onNext(c9);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            this.actual.onError(th);
            Operators.onDiscardMultiple(this.buffer, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            C c9 = this.buffer;
            if (c9 == null) {
                try {
                    C c10 = this.bufferSupplier.get();
                    Objects.requireNonNull(c10, "The bufferSupplier returned a null buffer");
                    c9 = c10;
                    this.buffer = c9;
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f10587s, th, t10, contextCurrentContext));
                    Operators.onDiscard(t10, contextCurrentContext);
                    return;
                }
            }
            if (!c9.add(t10)) {
                Operators.onDiscard(t10, this.actual.currentContext());
                this.f10587s.request(1L);
            } else if (c9.size() == this.size) {
                this.buffer = null;
                this.actual.onNext(c9);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10587s, eVar)) {
                this.f10587s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.f10587s.request(Operators.multiplyCap(j10, this.size));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10587s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.size) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.size) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            C c9 = this.buffer;
            return Integer.valueOf(c9 != null ? c9.size() : 0);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        qd.e f10588s;
        final int size;
        final int skip;

        public BufferOverlappingSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, int i3, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.size = i;
            this.skip = i3;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.cancelled = true;
            this.f10588s.cancel();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            clear();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.index;
            if (j10 % this.skip == 0) {
                try {
                    C c9 = this.bufferSupplier.get();
                    Objects.requireNonNull(c9, "The bufferSupplier returned a null buffer");
                    offer(c9);
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onOperatorError(this.f10588s, th, t10, contextCurrentContext));
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

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10588s, eVar)) {
                this.f10588s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10) && !DrainUtils.postCompleteRequest(j10, this.actual, this, REQUESTED, this, this)) {
                if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
                    this.f10588s.request(Operators.multiplyCap(this.skip, j10));
                } else {
                    this.f10588s.request(Operators.addCap(this.size, Operators.multiplyCap(this.skip, j10 - 1)));
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10588s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.CAPACITY ? Integer.valueOf(size() * this.size) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(stream().mapToInt(new g0()).sum()) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferSkipSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        static final AtomicIntegerFieldUpdater<BufferSkipSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(BufferSkipSubscriber.class, "wip");
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        final Context ctx;
        boolean done;
        long index;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10589s;
        final int size;
        final int skip;
        volatile int wip;

        public BufferSkipSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, int i3, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.size = i;
            this.skip = i3;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10589s.cancel();
            Operators.onDiscardMultiple(this.buffer, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c9 = this.buffer;
            this.buffer = null;
            if (c9 != null) {
                this.actual.onNext(c9);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            C c9 = this.buffer;
            this.buffer = null;
            this.actual.onError(th);
            Operators.onDiscardMultiple(c9, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            C c9 = this.buffer;
            long j10 = this.index;
            if (j10 % this.skip == 0) {
                try {
                    C c10 = this.bufferSupplier.get();
                    Objects.requireNonNull(c10, "The bufferSupplier returned a null buffer");
                    c9 = c10;
                    this.buffer = c9;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f10589s, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                    return;
                }
            }
            if (c9 != null) {
                c9.add(t10);
                if (c9.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c9);
                }
            } else {
                Operators.onDiscard(t10, this.ctx);
            }
            this.index = j10 + 1;
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10589s, eVar)) {
                this.f10589s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                    this.f10589s.request(Operators.multiplyCap(this.skip, j10));
                    return;
                }
                this.f10589s.request(Operators.addCap(Operators.multiplyCap(j10, this.size), Operators.multiplyCap(this.skip - this.size, j10 - 1)));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10589s;
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
            C c9 = this.buffer;
            return Integer.valueOf(c9 != null ? c9.size() : 0);
        }
    }

    public FluxBuffer(Flux<? extends T> flux, int i, int i3, Supplier<C> supplier) {
        super(flux);
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "size > 0 required but it was "));
            throw null;
        }
        if (i3 <= 0) {
            g5.f.s(k0.a.j(i3, "skip > 0 required but it was "));
            throw null;
        }
        this.size = i;
        this.skip = i3;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        int i = this.size;
        int i3 = this.skip;
        return i == i3 ? new BufferExactSubscriber(coreSubscriber, i, this.bufferSupplier) : i3 > i ? new BufferSkipSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier) : new BufferOverlappingSubscriber(coreSubscriber, this.size, this.skip, this.bufferSupplier);
    }

    public FluxBuffer(Flux<? extends T> flux, int i, Supplier<C> supplier) {
        this(flux, i, i, supplier);
    }
}
