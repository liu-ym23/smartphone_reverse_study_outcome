package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelThen extends Mono<Void> implements Scannable, Fuseable {
    final ParallelFlux<?> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ThenInner implements InnerConsumer<Object> {
        static final AtomicReferenceFieldUpdater<ThenInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(ThenInner.class, qd.e.class, "s");
        final ThenMain parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10750s;

        public ThenInner(ThenMain thenMain) {
            this.parent = thenMain;
        }

        public void cancel() {
            Operators.terminate(S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.parent.innerError(th, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            Operators.onDiscard(obj, this.parent.actual.currentContext());
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10750s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10750s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(Reader.READ_DONE);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ThenMain implements InnerProducer<Void>, Fuseable, Fuseable.QueueSubscription<Void> {
        static final long CANCELLED_FLAG = Long.MIN_VALUE;
        static final long INNER_COMPLETED_MAX = 2147483647L;
        static final long REQUESTED_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<ThenMain> STATE = AtomicLongFieldUpdater.newUpdater(ThenMain.class, "state");
        final CoreSubscriber<? super Void> actual;
        final ParallelFlux<?> source;
        volatile long state;
        final ThenInner[] subscribers;

        public ThenMain(CoreSubscriber<? super Void> coreSubscriber, ParallelFlux<?> parallelFlux) {
            this.actual = coreSubscriber;
            this.source = parallelFlux;
            int iParallelism = parallelFlux.parallelism();
            ThenInner[] thenInnerArr = new ThenInner[iParallelism];
            for (int i = 0; i < iParallelism; i++) {
                thenInnerArr[i] = new ThenInner(this);
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

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            long jMarkCancelled = markCancelled(this);
            if (isCancelled(jMarkCancelled) || !isRequestedOnce(jMarkCancelled)) {
                return;
            }
            for (ThenInner thenInner : this.subscribers) {
                thenInner.cancel();
            }
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

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (STATE.compareAndSet(this, 0L, REQUESTED_FLAG)) {
                this.source.subscribe(this.subscribers);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
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

        @Override // java.util.Queue
        public Void poll() {
            return null;
        }

        @Override // java.util.Collection
        public void clear() {
        }
    }
}
