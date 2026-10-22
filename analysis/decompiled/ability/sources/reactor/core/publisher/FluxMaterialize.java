package reactor.core.publisher;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BooleanSupplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxMaterialize<T> extends InternalFluxOperator<T, Signal<T>> {

    public static final class MaterializeSubscriber<T> extends AbstractQueue<Signal<T>> implements InnerOperator<T, Signal<T>>, BooleanSupplier {
        static final AtomicLongFieldUpdater<MaterializeSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(MaterializeSubscriber.class, "requested");
        static final Signal empty = new ImmutableSignal(Context.empty(), SignalType.ON_NEXT, null, null, null);
        final CoreSubscriber<? super Signal<T>> actual;
        final Context cachedContext;
        volatile boolean cancelled;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5760s;
        Signal<T> terminalSignal;

        public MaterializeSubscriber(CoreSubscriber<? super Signal<T>> coreSubscriber) {
            this.actual = coreSubscriber;
            this.cachedContext = coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Signal<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5760s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.cachedContext;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Signal<T>> iterator() {
            throw new UnsupportedOperationException();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.terminalSignal != null) {
                return;
            }
            this.terminalSignal = Signal.complete(this.cachedContext);
            long j5 = this.produced;
            if (j5 != 0) {
                Operators.addCap(REQUESTED, this, -j5);
            }
            DrainUtils.postComplete(this.actual, this, REQUESTED, this, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.terminalSignal != null) {
                Operators.onErrorDropped(th, this.cachedContext);
                return;
            }
            this.terminalSignal = Signal.error(th, this.cachedContext);
            long j5 = this.produced;
            if (j5 != 0) {
                Operators.addCap(REQUESTED, this, -j5);
            }
            DrainUtils.postComplete(this.actual, this, REQUESTED, this, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.terminalSignal != null) {
                Operators.onNextDropped(t9, this.cachedContext);
            } else {
                this.produced++;
                this.actual.onNext(Signal.next(t9, this.cachedContext));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5760s, eVar)) {
                this.f5760s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (!Operators.validate(j5) || DrainUtils.postCompleteRequest(j5, this.actual, this, REQUESTED, this, this)) {
                return;
            }
            this.f5760s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5760s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.terminalSignal != null);
            }
            if (attr != Scannable.Attr.ERROR) {
                return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(getAsBoolean()) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Signal<T> signal = this.terminalSignal;
            if (signal != null) {
                return signal.getThrowable();
            }
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Signal<T> signal = this.terminalSignal;
            return (signal == null || signal == empty) ? 0 : 1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "MaterializeSubscriber";
        }

        @Override // java.util.Queue
        public boolean offer(Signal<T> signal) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Queue
        @Nullable
        public Signal<T> peek() {
            Signal<T> signal = empty;
            Signal<T> signal2 = this.terminalSignal;
            if (signal == signal2) {
                return null;
            }
            return signal2;
        }

        @Override // java.util.Queue
        @Nullable
        public Signal<T> poll() {
            Signal<T> signal;
            Signal<T> signal2 = this.terminalSignal;
            if (signal2 == null || signal2 == (signal = empty)) {
                return null;
            }
            this.terminalSignal = signal;
            return signal2;
        }
    }

    public FluxMaterialize(Flux<T> flux) {
        super(flux);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Signal<T>> coreSubscriber) {
        return new MaterializeSubscriber(coreSubscriber);
    }
}
