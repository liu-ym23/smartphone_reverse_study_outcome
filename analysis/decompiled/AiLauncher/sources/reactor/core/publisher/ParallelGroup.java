package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelGroup<T> extends Flux<GroupedFlux<Integer, T>> implements Scannable, Fuseable {
    final ParallelFlux<? extends T> source;

    public static final class ParallelInnerGroup<T> extends GroupedFlux<Integer, T> implements InnerOperator<T, T> {
        CoreSubscriber<? super T> actual;
        final int key;
        volatile int once;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39694s;
        static final AtomicIntegerFieldUpdater<ParallelInnerGroup> ONCE = AtomicIntegerFieldUpdater.newUpdater(ParallelInnerGroup.class, "once");

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<ParallelInnerGroup, qc.d> f39693S = AtomicReferenceFieldUpdater.newUpdater(ParallelInnerGroup.class, qc.d.class, "s");
        static final AtomicLongFieldUpdater<ParallelInnerGroup> REQUESTED = AtomicLongFieldUpdater.newUpdater(ParallelInnerGroup.class, "requested");

        public ParallelInnerGroup(int i10) {
            this.key = i10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Operators.terminate(f39693S, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39693S, this, dVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    dVar.request(andSet);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                qc.d dVar = this.f39694s;
                if (dVar != null) {
                    dVar.request(j10);
                    return;
                }
                AtomicLongFieldUpdater<ParallelInnerGroup> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qc.d dVar2 = this.f39694s;
                if (dVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
                    return;
                }
                dVar2.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39694s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39694s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            if (!ONCE.compareAndSet(this, 0, 1)) {
                Operators.error(coreSubscriber, new IllegalStateException("This ParallelGroup can be subscribed to at most once."));
            } else {
                this.actual = coreSubscriber;
                coreSubscriber.onSubscribe(this);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // reactor.core.publisher.GroupedFlux
        public Integer key() {
            return Integer.valueOf(this.key);
        }
    }

    public ParallelGroup(ParallelFlux<? extends T> parallelFlux) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super GroupedFlux<Integer, T>> coreSubscriber) {
        int iParallelism = this.source.parallelism();
        ParallelInnerGroup[] parallelInnerGroupArr = new ParallelInnerGroup[iParallelism];
        for (int i10 = 0; i10 < iParallelism; i10++) {
            parallelInnerGroupArr[i10] = new ParallelInnerGroup(i10);
        }
        FluxArray.subscribe(coreSubscriber, parallelInnerGroupArr);
        this.source.subscribe(parallelInnerGroupArr);
    }
}
