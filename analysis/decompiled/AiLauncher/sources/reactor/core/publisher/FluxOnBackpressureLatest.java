package reactor.core.publisher;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxOnBackpressureLatest<T> extends InternalFluxOperator<T, T> {

    public static final class LatestSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final Context ctx;
        volatile boolean done;
        Throwable error;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39540s;
        volatile T value;
        volatile int wip;
        static final AtomicLongFieldUpdater<LatestSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(LatestSubscriber.class, "requested");
        static final AtomicIntegerFieldUpdater<LatestSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(LatestSubscriber.class, "wip");
        static final AtomicReferenceFieldUpdater<LatestSubscriber, Object> VALUE = AtomicReferenceFieldUpdater.newUpdater(LatestSubscriber.class, Object.class, UxipConstants.f30680s);

        public LatestSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Object andSet;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f39540s.cancel();
            if (WIP.getAndIncrement(this) != 0 || (andSet = VALUE.getAndSet(this, null)) == null) {
                return;
            }
            Operators.onDiscard(andSet, this.ctx);
        }

        public boolean checkTerminated(boolean z10, boolean z11, qc.c<? super T> cVar) {
            if (this.cancelled) {
                Object andSet = VALUE.getAndSet(this, null);
                if (andSet != null) {
                    Operators.onDiscard(andSet, this.ctx);
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (th == null) {
                if (!z11) {
                    return false;
                }
                cVar.onComplete();
                return true;
            }
            Object andSet2 = VALUE.getAndSet(this, null);
            if (andSet2 != null) {
                Operators.onDiscard(andSet2, this.ctx);
            }
            cVar.onError(th);
            return true;
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            int iAddAndGet = 1;
            do {
                if (checkTerminated(this.done, this.value == null, coreSubscriber)) {
                    return;
                }
                long j10 = this.requested;
                long j11 = 0;
                while (j10 != j11) {
                    boolean z10 = this.done;
                    Object andSet = VALUE.getAndSet(this, null);
                    boolean z11 = andSet == null;
                    if (checkTerminated(z10, z11, coreSubscriber)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    coreSubscriber.onNext(andSet);
                    j11++;
                }
                if (j10 == j11) {
                    if (checkTerminated(this.done, this.value == null, coreSubscriber)) {
                        return;
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    Operators.produced(REQUESTED, this, j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            Object andSet = VALUE.getAndSet(this, t10);
            if (andSet != null) {
                Operators.onDiscard(andSet, this.ctx);
            }
            drain();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39540s, dVar)) {
                this.f39540s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
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
                return this.f39540s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.value != null ? 1 : 0);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnBackpressureLatest(Flux<? extends T> flux) {
        super(flux);
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new LatestSubscriber(coreSubscriber);
    }
}
