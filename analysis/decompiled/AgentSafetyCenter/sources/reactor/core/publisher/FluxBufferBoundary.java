package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxBufferBoundary<T, U, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final qd.c other;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferBoundaryMain<T, U, C extends Collection<? super T>> implements InnerOperator<T, C> {
        final CoreSubscriber<? super C> actual;
        C buffer;
        final Supplier<C> bufferSupplier;
        final Context ctx;
        final BufferBoundaryOther<U> other = new BufferBoundaryOther<>(this);
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10590s;
        static final AtomicReferenceFieldUpdater<BufferBoundaryMain, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(BufferBoundaryMain.class, qd.e.class, "s");
        static final AtomicLongFieldUpdater<BufferBoundaryMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferBoundaryMain.class, "requested");

        public BufferBoundaryMain(CoreSubscriber<? super C> coreSubscriber, C c9, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.buffer = c9;
            this.bufferSupplier = supplier;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            Operators.terminate(S, this);
            Operators.onDiscardMultiple(this.buffer, this.ctx);
            this.other.cancel();
        }

        public boolean emit(C c9) {
            long j10 = this.requested;
            CoreSubscriber<? super C> coreSubscriber = this.actual;
            if (j10 == 0) {
                coreSubscriber.onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(), c9, this.ctx));
                Operators.onDiscardMultiple(c9, this.ctx);
                return false;
            }
            coreSubscriber.onNext(c9);
            if (j10 == Long.MAX_VALUE) {
                return true;
            }
            REQUESTED.decrementAndGet(this);
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            C c9;
            if (Operators.terminate(S, this)) {
                synchronized (this) {
                    c9 = this.buffer;
                    this.buffer = null;
                }
                this.other.cancel();
                if (c9.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c9)) {
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            C c9;
            if (!Operators.terminate(S, this)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c9 = this.buffer;
                this.buffer = null;
            }
            this.other.cancel();
            this.actual.onError(th);
            Operators.onDiscardMultiple(c9, this.ctx);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            synchronized (this) {
                try {
                    C c9 = this.buffer;
                    if (c9 != null) {
                        c9.add(t10);
                    } else {
                        Operators.onNextDropped(t10, this.ctx);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void otherComplete() {
            C c9;
            qd.e andSet = S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet != Operators.cancelledSubscription()) {
                synchronized (this) {
                    c9 = this.buffer;
                    this.buffer = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
                if (c9 == null || c9.isEmpty()) {
                    this.actual.onComplete();
                } else if (emit(c9)) {
                    this.actual.onComplete();
                }
            }
        }

        public void otherError(Throwable th) {
            C c9;
            qd.e andSet = S.getAndSet(this, Operators.cancelledSubscription());
            if (andSet == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            synchronized (this) {
                c9 = this.buffer;
                this.buffer = null;
            }
            if (andSet != null) {
                andSet.cancel();
            }
            this.actual.onError(th);
            Operators.onDiscardMultiple(c9, this.ctx);
        }

        public void otherNext() {
            C c9;
            try {
                C c10 = this.bufferSupplier.get();
                Objects.requireNonNull(c10, "The bufferSupplier returned a null buffer");
                C c11 = c10;
                synchronized (this) {
                    c9 = this.buffer;
                    this.buffer = c11;
                }
                if (c9 == null || c9.isEmpty()) {
                    return;
                }
                emit(c9);
            } catch (Throwable th) {
                otherError(Operators.onOperatorError(this.other, th, this.ctx));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10590s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10590s == Operators.cancelledSubscription());
            }
            if (attr != Scannable.Attr.CAPACITY) {
                return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            C c9 = this.buffer;
            return Integer.valueOf(c9 != null ? c9.size() : 0);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferBoundaryOther<U> extends Operators.DeferredSubscription implements InnerConsumer<U> {
        final BufferBoundaryMain<?, U, ?> main;

        public BufferBoundaryOther(BufferBoundaryMain<?, U, ?> bufferBoundaryMain) {
            this.main = bufferBoundaryMain;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.main.otherComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(U u10) {
            this.main.otherNext();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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

    public FluxBufferBoundary(Flux<? extends T> flux, qd.c cVar, Supplier<C> supplier) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        C c9 = this.bufferSupplier.get();
        Objects.requireNonNull(c9, "The bufferSupplier returned a null buffer");
        BufferBoundaryMain bufferBoundaryMain = new BufferBoundaryMain(this.source instanceof FluxInterval ? coreSubscriber : Operators.serialize(coreSubscriber), c9, this.bufferSupplier);
        coreSubscriber.onSubscribe(bufferBoundaryMain);
        this.other.subscribe(bufferBoundaryMain.other);
        return bufferBoundaryMain;
    }
}
