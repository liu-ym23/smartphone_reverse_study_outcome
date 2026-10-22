package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class ParallelGroup<T> extends Flux<GroupedFlux<Integer, T>> implements Scannable, Fuseable {
    final ParallelFlux<? extends T> source;

    public static final class ParallelInnerGroup<T> extends GroupedFlux<Integer, T> implements InnerOperator<T, T> {
        CoreSubscriber<? super T> actual;
        final int key;
        volatile int once;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5879s;
        static final AtomicIntegerFieldUpdater<ParallelInnerGroup> ONCE = AtomicIntegerFieldUpdater.newUpdater(ParallelInnerGroup.class, "once");

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<ParallelInnerGroup, Z9.e> f5878S = AtomicReferenceFieldUpdater.newUpdater(ParallelInnerGroup.class, Z9.e.class, "s");
        static final AtomicLongFieldUpdater<ParallelInnerGroup> REQUESTED = AtomicLongFieldUpdater.newUpdater(ParallelInnerGroup.class, "requested");

        public ParallelInnerGroup(int i) {
            this.key = i;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Operators.terminate(f5878S, this);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5878S, this, eVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    eVar.request(andSet);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Z9.e eVar = this.f5879s;
                if (eVar != null) {
                    eVar.request(j5);
                    return;
                }
                AtomicLongFieldUpdater<ParallelInnerGroup> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j5);
                Z9.e eVar2 = this.f5879s;
                if (eVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
                    return;
                }
                eVar2.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5879s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5879s == Operators.cancelledSubscription());
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
        for (int i = 0; i < iParallelism; i++) {
            parallelInnerGroupArr[i] = new ParallelInnerGroup(i);
        }
        FluxArray.subscribe(coreSubscriber, parallelInnerGroupArr);
        this.source.subscribe(parallelInnerGroupArr);
    }
}
