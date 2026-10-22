package reactor.core.publisher;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxBufferBoundary<T, U, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final qc.b<U> other;

    public static final class BufferBoundaryMain<T, U, C extends Collection<? super T>> implements InnerOperator<T, C> {
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        final Context ctx;
        final BufferBoundaryOther<U> other = new BufferBoundaryOther<>(this);
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39475s;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<BufferBoundaryMain, qc.d> f39474S = AtomicReferenceFieldUpdater.newUpdater(BufferBoundaryMain.class, qc.d.class, "s");
        static final AtomicLongFieldUpdater<BufferBoundaryMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferBoundaryMain.class, "requested");

        public BufferBoundaryMain(CoreSubscriber<? super C> coreSubscriber, C c10, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.buffer = c10;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Operators.terminate(f39474S, this);
            Operators.onDiscardMultiple(this.buffer, this.ctx);
            this.other.cancel();
        }

        public boolean emit(C c10) {
            long j10 = this.requested;
            if (j10 == 0) {
                this.actual.onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(), c10, this.ctx));
                Operators.onDiscardMultiple(c10, this.ctx);
                return false;
            }
            this.actual.onNext(c10);
            if (j10 == Long.MAX_VALUE) {
                return true;
            }
            REQUESTED.decrementAndGet(this);
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            C c10;
            if (Operators.terminate(f39474S, this)) {
                synchronized (this) {
                    c10 = this.buffer;
                    this.buffer = null;
                }
                this.other.cancel();
                if (c10.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c10)) {
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            C c10;
            if (!Operators.terminate(f39474S, this)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c10 = this.buffer;
                this.buffer = null;
            }
            this.other.cancel();
            this.actual.onError(th);
            Operators.onDiscardMultiple(c10, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            synchronized (this) {
                try {
                    C c10 = this.buffer;
                    if (c10 != null) {
                        c10.add(t10);
                    } else {
                        Operators.onNextDropped(t10, this.ctx);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39474S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void otherComplete() {
            C c10;
            qc.d andSet = f39474S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet != Operators.cancelledSubscription()) {
                synchronized (this) {
                    c10 = this.buffer;
                    this.buffer = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
                if (c10 == null || c10.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c10)) {
                    this.actual.onComplete();
                }
            }
        }

        public void otherError(Throwable th) {
            C c10;
            qc.d andSet = f39474S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c10 = this.buffer;
                this.buffer = null;
            }
            if (andSet != null) {
                andSet.cancel();
            }
            this.actual.onError(th);
            Operators.onDiscardMultiple(c10, this.ctx);
        }

        public void otherNext() {
            C c10;
            try {
                C c11 = this.bufferSupplier.get();
                Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                C c12 = c11;
                synchronized (this) {
                    c10 = this.buffer;
                    this.buffer = c12;
                }
                if (c10 == null || c10.isEmpty()) {
                    return;
                }
                emit(c10);
            } catch (Throwable th) {
                otherError(Operators.onOperatorError(this.other, th, this.ctx));
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
            if (attr == Scannable.Attr.PARENT) {
                return this.f39475s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39475s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.CAPACITY) {
                C c10 = this.buffer;
                return Integer.valueOf(c10 != null ? c10.size() : 0);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class BufferBoundaryOther<U> extends Operators.DeferredSubscription implements InnerConsumer<U> {
        final BufferBoundaryMain<?, U, ?> main;

        public BufferBoundaryOther(BufferBoundaryMain<?, U, ?> bufferBoundaryMain) {
            this.main = bufferBoundaryMain;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.main.otherComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(U u10) {
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

    public FluxBufferBoundary(Flux<? extends T> flux, qc.b<U> bVar, Supplier<C> supplier) {
        super(flux);
        Objects.requireNonNull(bVar, "other");
        this.other = Operators.toFluxOrMono(bVar);
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        C c10 = this.bufferSupplier.get();
        Objects.requireNonNull(c10, "The bufferSupplier returned a null buffer");
        BufferBoundaryMain bufferBoundaryMain = new BufferBoundaryMain(this.source instanceof FluxInterval ? coreSubscriber : Operators.serialize(coreSubscriber), c10, this.bufferSupplier);
        coreSubscriber.onSubscribe(bufferBoundaryMain);
        this.other.subscribe(bufferBoundaryMain.other);
        return bufferBoundaryMain;
    }
}
