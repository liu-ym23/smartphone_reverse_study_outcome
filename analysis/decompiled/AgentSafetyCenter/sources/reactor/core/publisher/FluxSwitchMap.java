package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSwitchMap<T, R> extends InternalFluxOperator<T, R> {
    static final SwitchMapInner<Object> CANCELLED_INNER = new SwitchMapInner<>(null, 0, Long.MAX_VALUE);
    final Function<? super T, ? extends qd.c> mapper;
    final int prefetch;
    final Supplier<? extends Queue<Object>> queueSupplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SwitchMapInner<R> implements InnerConsumer<R>, qd.e {
        static final AtomicIntegerFieldUpdater<SwitchMapInner> ONCE = AtomicIntegerFieldUpdater.newUpdater(SwitchMapInner.class, "once");
        static final AtomicReferenceFieldUpdater<SwitchMapInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(SwitchMapInner.class, qd.e.class, "s");
        final long index;
        final int limit;
        volatile int once;
        final SwitchMapMain<?, R> parent;
        final int prefetch;
        int produced;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10679s;

        public SwitchMapInner(SwitchMapMain<?, R> switchMapMain, int i, long j10) {
            this.parent = switchMapMain;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
            this.index = j10;
        }

        @Override // qd.e
        public void cancel() {
            qd.e andSet;
            if (this.f10679s == Operators.cancelledSubscription() || (andSet = S.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public void deactivate() {
            if (ONCE.compareAndSet(this, 0, 1)) {
                this.parent.deactivate();
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(R r10) {
            this.parent.innerNext(this, r10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            qd.e eVar2 = this.f10679s;
            if (eVar2 == Operators.cancelledSubscription()) {
                eVar.cancel();
            }
            if (eVar2 != null) {
                eVar.cancel();
                Operators.reportSubscriptionSet();
            } else if (S.compareAndSet(this, null, eVar)) {
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            } else if (this.f10679s != Operators.cancelledSubscription()) {
                eVar.cancel();
                Operators.reportSubscriptionSet();
            }
        }

        @Override // qd.e
        public void request(long j10) {
            long j11 = this.produced + j10;
            if (j11 < this.limit) {
                this.produced = (int) j11;
            } else {
                this.produced = 0;
                this.f10679s.request(j11);
            }
        }

        public void requestOne() {
            int i = this.produced + 1;
            if (i != this.limit) {
                this.produced = i;
            } else {
                this.produced = 0;
                this.f10679s.request(i);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10679s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10679s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SwitchMapMain<T, R> implements InnerOperator<T, R> {
        volatile int active = 1;
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        volatile boolean done;
        volatile Throwable error;
        volatile long index;
        volatile SwitchMapInner<R> inner;
        final Function<? super T, ? extends qd.c> mapper;
        volatile int once;
        final int prefetch;
        final Queue<Object> queue;
        final BiPredicate<Object, Object> queueBiAtomic;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10680s;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<SwitchMapMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(SwitchMapMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<SwitchMapMain> ONCE = AtomicIntegerFieldUpdater.newUpdater(SwitchMapMain.class, "once");
        static final AtomicLongFieldUpdater<SwitchMapMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "requested");
        static final AtomicIntegerFieldUpdater<SwitchMapMain> WIP = AtomicIntegerFieldUpdater.newUpdater(SwitchMapMain.class, "wip");
        static final AtomicReferenceFieldUpdater<SwitchMapMain, SwitchMapInner> INNER = AtomicReferenceFieldUpdater.newUpdater(SwitchMapMain.class, SwitchMapInner.class, "inner");
        static final AtomicLongFieldUpdater<SwitchMapMain> INDEX = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "index");
        static final AtomicIntegerFieldUpdater<SwitchMapMain> ACTIVE = AtomicIntegerFieldUpdater.newUpdater(SwitchMapMain.class, "active");

        public SwitchMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, Queue<Object> queue, int i) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.queue = queue;
            this.prefetch = i;
            if (queue instanceof BiPredicate) {
                this.queueBiAtomic = (BiPredicate) queue;
            } else {
                this.queueBiAtomic = null;
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (WIP.getAndIncrement(this) == 0) {
                cancelAndCleanup(this.queue);
            }
        }

        public void cancelAndCleanup(Queue<?> queue) {
            this.f10680s.cancel();
            cancelInner();
            queue.clear();
        }

        public void cancelInner() {
            AtomicReferenceFieldUpdater<SwitchMapMain, SwitchMapInner> atomicReferenceFieldUpdater = INNER;
            SwitchMapInner<Object> switchMapInner = FluxSwitchMap.CANCELLED_INNER;
            SwitchMapInner<Object> andSet = atomicReferenceFieldUpdater.getAndSet(this, switchMapInner);
            if (andSet == null || andSet == switchMapInner) {
                return;
            }
            andSet.cancel();
            andSet.deactivate();
        }

        public boolean checkTerminated(boolean z10, boolean z11, qd.d dVar, Queue<?> queue) {
            if (this.cancelled) {
                cancelAndCleanup(queue);
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null && thTerminate != Exceptions.TERMINATED) {
                cancelAndCleanup(queue);
                dVar.onError(thTerminate);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        public void deactivate() {
            ACTIVE.decrementAndGet(this);
        }

        public void drain() {
            Object objPoll;
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            Queue<?> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (true) {
                    if (j10 == j11) {
                        break;
                    }
                    boolean z10 = this.active == 0;
                    SwitchMapInner switchMapInner = (SwitchMapInner) queue.poll();
                    boolean z11 = switchMapInner == null;
                    if (checkTerminated(z10, z11, coreSubscriber, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    do {
                        objPoll = queue.poll();
                    } while (objPoll == null);
                    if (this.index == switchMapInner.index) {
                        coreSubscriber.onNext(objPoll);
                        switchMapInner.requestOne();
                        j11++;
                    }
                }
                if (j10 == j11) {
                    if (checkTerminated(this.active == 0, queue.isEmpty(), coreSubscriber, queue)) {
                        return;
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void innerComplete(SwitchMapInner<R> switchMapInner) {
            switchMapInner.deactivate();
            drain();
        }

        public void innerError(SwitchMapInner<R> switchMapInner, Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.f10680s.cancel();
            if (ONCE.compareAndSet(this, 0, 1)) {
                deactivate();
            }
            switchMapInner.deactivate();
            drain();
        }

        public void innerNext(SwitchMapInner<R> switchMapInner, R r10) {
            BiPredicate<Object, Object> biPredicate = this.queueBiAtomic;
            if (biPredicate != null) {
                biPredicate.test(switchMapInner, r10);
            } else {
                this.queue.offer(switchMapInner);
                this.queue.offer(r10);
            }
            drain();
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.inner);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            if (ONCE.compareAndSet(this, 0, 1)) {
                deactivate();
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            if (ONCE.compareAndSet(this, 0, 1)) {
                deactivate();
            }
            cancelInner();
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long jIncrementAndGet = INDEX.incrementAndGet(this);
            SwitchMapInner<R> switchMapInner = this.inner;
            if (switchMapInner != null) {
                switchMapInner.deactivate();
                switchMapInner.cancel();
            }
            try {
                qd.c cVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(cVarApply, "The mapper returned a null publisher");
                qd.c cVar = cVarApply;
                SwitchMapInner switchMapInner2 = new SwitchMapInner(this, this.prefetch, jIncrementAndGet);
                if (INNER.compareAndSet(this, switchMapInner, switchMapInner2)) {
                    ACTIVE.getAndIncrement(this);
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) switchMapInner2);
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10680s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10680s, eVar)) {
                this.f10680s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
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
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.PARENT ? this.f10680s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSwitchMap(Flux<? extends T> flux, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<Object>> supplier, int i) {
        super(flux);
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, false)) {
            return null;
        }
        return new SwitchMapMain(coreSubscriber, this.mapper, this.queueSupplier.get(), this.prefetch);
    }
}
