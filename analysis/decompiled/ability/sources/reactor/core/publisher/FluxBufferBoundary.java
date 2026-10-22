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

/* loaded from: classes4.dex */
final class FluxBufferBoundary<T, U, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final Z9.c other;

    public static final class BufferBoundaryMain<T, U, C extends Collection<? super T>> implements InnerOperator<T, C> {
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        final Context ctx;
        final BufferBoundaryOther<U> other = new BufferBoundaryOther<>(this);
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5705s;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<BufferBoundaryMain, Z9.e> f5704S = AtomicReferenceFieldUpdater.newUpdater(BufferBoundaryMain.class, Z9.e.class, "s");
        static final AtomicLongFieldUpdater<BufferBoundaryMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferBoundaryMain.class, "requested");

        public BufferBoundaryMain(CoreSubscriber<? super C> coreSubscriber, C c, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.buffer = c;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Operators.terminate(f5704S, this);
            Operators.onDiscardMultiple(this.buffer, this.ctx);
            this.other.cancel();
        }

        public boolean emit(C c) {
            long j5 = this.requested;
            if (j5 == 0) {
                this.actual.onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(), c, this.ctx));
                Operators.onDiscardMultiple(c, this.ctx);
                return false;
            }
            this.actual.onNext(c);
            if (j5 == Long.MAX_VALUE) {
                return true;
            }
            REQUESTED.decrementAndGet(this);
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            C c;
            if (Operators.terminate(f5704S, this)) {
                synchronized (this) {
                    c = this.buffer;
                    this.buffer = null;
                }
                this.other.cancel();
                if (c.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c)) {
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            C c;
            if (!Operators.terminate(f5704S, this)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c = this.buffer;
                this.buffer = null;
            }
            this.other.cancel();
            this.actual.onError(th);
            Operators.onDiscardMultiple(c, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            synchronized (this) {
                try {
                    C c = this.buffer;
                    if (c != null) {
                        c.add(t9);
                    } else {
                        Operators.onNextDropped(t9, this.ctx);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5704S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void otherComplete() {
            C c;
            Z9.e andSet = f5704S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet != Operators.cancelledSubscription()) {
                synchronized (this) {
                    c = this.buffer;
                    this.buffer = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
                if (c == null || c.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c)) {
                    this.actual.onComplete();
                }
            }
        }

        public void otherError(Throwable th) {
            C c;
            Z9.e andSet = f5704S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c = this.buffer;
                this.buffer = null;
            }
            if (andSet != null) {
                andSet.cancel();
            }
            this.actual.onError(th);
            Operators.onDiscardMultiple(c, this.ctx);
        }

        public void otherNext() {
            C c;
            try {
                C c2 = this.bufferSupplier.get();
                Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                C c5 = c2;
                synchronized (this) {
                    c = this.buffer;
                    this.buffer = c5;
                }
                if (c == null || c.isEmpty()) {
                    return;
                }
                emit(c);
            } catch (Throwable th) {
                otherError(Operators.onOperatorError(this.other, th, this.ctx));
            }
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
            if (attr == Scannable.Attr.PARENT) {
                return this.f5705s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5705s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.CAPACITY) {
                C c = this.buffer;
                return Integer.valueOf(c != null ? c.size() : 0);
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.main.otherComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(U u) {
            this.main.otherNext();
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
            return attr == Scannable.Attr.ACTUAL ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxBufferBoundary(Flux<? extends T> flux, Z9.c cVar, Supplier<C> supplier) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
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
        C c = this.bufferSupplier.get();
        Objects.requireNonNull(c, "The bufferSupplier returned a null buffer");
        BufferBoundaryMain bufferBoundaryMain = new BufferBoundaryMain(this.source instanceof FluxInterval ? coreSubscriber : Operators.serialize(coreSubscriber), c, this.bufferSupplier);
        coreSubscriber.onSubscribe(bufferBoundaryMain);
        this.other.subscribe(bufferBoundaryMain.other);
        return bufferBoundaryMain;
    }
}
