package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class ParallelThen extends Mono<Void> implements Scannable, Fuseable {
    final ParallelFlux<?> source;

    public static final class ThenInner implements InnerConsumer<Object> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<ThenInner, qc.d> f39702S = AtomicReferenceFieldUpdater.newUpdater(ThenInner.class, qc.d.class, "s");
        final ThenMain parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39703s;

        public ThenInner(ThenMain thenMain) {
            this.parent = thenMain;
        }

        public void cancel() {
            Operators.terminate(f39702S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.innerError(th, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            Operators.onDiscard(obj, this.parent.actual.currentContext());
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39702S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39703s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f39703s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class ThenMain implements InnerProducer<Void>, Fuseable, Fuseable.QueueSubscription<Void> {
        static final long CANCELLED_FLAG = Long.MIN_VALUE;
        static final long INNER_COMPLETED_MAX = 2147483647L;
        static final long REQUESTED_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<ThenMain> STATE = AtomicLongFieldUpdater.newUpdater(ThenMain.class, VoiceWakeupReceiver.EXTRA_STATE);
        final CoreSubscriber<? super Void> actual;
        final ParallelFlux<?> source;
        volatile long state;
        final ThenInner[] subscribers;

        public ThenMain(CoreSubscriber<? super Void> coreSubscriber, ParallelFlux<?> parallelFlux) {
            this.actual = coreSubscriber;
            this.source = parallelFlux;
            int iParallelism = parallelFlux.parallelism();
            ThenInner[] thenInnerArr = new ThenInner[iParallelism];
            for (int i10 = 0; i10 < iParallelism; i10++) {
                thenInnerArr[i10] = new ThenInner(this);
            }
            this.subscribers = thenInnerArr;
        }

        public static int innersCompletedCount(long j10) {
            return (int) (j10 & INNER_COMPLETED_MAX);
        }

        public static boolean isCancelled(long j10) {
            return (j10 & CANCELLED_FLAG) == CANCELLED_FLAG;
        }

        public static boolean isRequestedOnce(long j10) {
            return (j10 & REQUESTED_FLAG) == REQUESTED_FLAG;
        }

        public static long markCancelled(ThenMain thenMain) {
            long j10;
            int iParallelism = thenMain.source.parallelism();
            while (true) {
                j10 = thenMain.state;
                if (isCancelled(j10) || innersCompletedCount(j10) == iParallelism) {
                    break;
                }
                ThenMain thenMain2 = thenMain;
                if (STATE.weakCompareAndSet(thenMain2, j10, j10 | CANCELLED_FLAG)) {
                    break;
                }
                thenMain = thenMain2;
            }
            return j10;
        }

        public static long markForceTerminated(ThenMain thenMain) {
            long j10;
            int iParallelism = thenMain.source.parallelism();
            while (true) {
                j10 = thenMain.state;
                if (isCancelled(j10) || innersCompletedCount(j10) == iParallelism) {
                    break;
                }
                ThenMain thenMain2 = thenMain;
                if (STATE.compareAndSet(thenMain2, j10, iParallelism | ((-2147483648L) & j10) | CANCELLED_FLAG)) {
                    break;
                }
                thenMain = thenMain2;
            }
            return j10;
        }

        public static long markInnerCompleted(ThenMain thenMain) {
            long j10;
            int iParallelism = thenMain.source.parallelism();
            while (true) {
                j10 = thenMain.state;
                if (isCancelled(j10) || innersCompletedCount(j10) == iParallelism) {
                    break;
                }
                ThenMain thenMain2 = thenMain;
                if (STATE.compareAndSet(thenMain2, j10, j10 + 1)) {
                    break;
                }
                thenMain = thenMain2;
            }
            return j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Void> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            long jMarkCancelled = markCancelled(this);
            if (isCancelled(jMarkCancelled) || !isRequestedOnce(jMarkCancelled)) {
                return;
            }
            for (ThenInner thenInner : this.subscribers) {
                thenInner.cancel();
            }
        }

        @Override // java.util.Collection
        public void clear() {
        }

        public void innerComplete() {
            long jMarkInnerCompleted = markInnerCompleted(this);
            int iParallelism = this.source.parallelism();
            int iInnersCompletedCount = innersCompletedCount(jMarkInnerCompleted);
            if (isCancelled(jMarkInnerCompleted) || iInnersCompletedCount == iParallelism || iInnersCompletedCount + 1 != iParallelism) {
                return;
            }
            this.actual.onComplete();
        }

        public void innerError(Throwable th, ThenInner thenInner) {
            long jMarkForceTerminated = markForceTerminated(this);
            int iParallelism = this.source.parallelism();
            if (isCancelled(jMarkForceTerminated) || innersCompletedCount(jMarkForceTerminated) == iParallelism) {
                return;
            }
            for (ThenInner thenInner2 : this.subscribers) {
                if (thenInner2 != thenInner) {
                    thenInner2.cancel();
                }
            }
            this.actual.onError(th);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Queue
        public Void poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (STATE.compareAndSet(this, 0L, REQUESTED_FLAG)) {
                this.source.subscribe(this.subscribers);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            return 0;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(innersCompletedCount(this.state) == this.source.parallelism());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled(this.state) && innersCompletedCount(this.state) != this.source.parallelism());
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public ParallelThen(ParallelFlux<?> parallelFlux) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Void> coreSubscriber) {
        coreSubscriber.onSubscribe(new ThenMain(coreSubscriber, this.source));
    }
}
