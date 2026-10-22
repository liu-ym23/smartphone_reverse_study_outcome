package reactor.core.publisher;

import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class ParallelMergeSequential<T> extends Flux<T> implements Scannable {
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;
    final ParallelFlux<? extends T> source;

    public static final class MergeSequentialInner<T> implements InnerConsumer<T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<MergeSequentialInner, Z9.e> f5882S = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialInner.class, Z9.e.class, "s");
        volatile boolean done;
        final int limit;
        final MergeSequentialMain<T> parent;
        final int prefetch;
        long produced;
        volatile Queue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5883s;

        public MergeSequentialInner(MergeSequentialMain<T> mergeSequentialMain, int i) {
            this.parent = mergeSequentialMain;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
        }

        public void cancel() {
            Operators.terminate(f5882S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        public Queue<T> getQueue(Supplier<Queue<T>> supplier) {
            Queue<T> queue = this.queue;
            if (queue != null) {
                return queue;
            }
            Queue<T> queue2 = supplier.get();
            this.queue = queue2;
            return queue2;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.parent.onNext(this, t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5882S, this, eVar)) {
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public void requestOne() {
            long j5 = this.produced + 1;
            if (j5 != this.limit) {
                this.produced = j5;
            } else {
                this.produced = 0L;
                this.f5883s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5883s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f5883s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class MergeSequentialMain<T> implements InnerProducer<T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        volatile int done;
        volatile Throwable error;
        final Supplier<Queue<T>> queueSupplier;
        volatile long requested;
        final MergeSequentialInner<T>[] subscribers;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MergeSequentialMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<MergeSequentialMain> WIP = AtomicIntegerFieldUpdater.newUpdater(MergeSequentialMain.class, "wip");
        static final AtomicLongFieldUpdater<MergeSequentialMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(MergeSequentialMain.class, "requested");
        static final AtomicIntegerFieldUpdater<MergeSequentialMain> DONE = AtomicIntegerFieldUpdater.newUpdater(MergeSequentialMain.class, HighlightCallback.KEY_DONE);

        public MergeSequentialMain(CoreSubscriber<? super T> coreSubscriber, int i, int i6, Supplier<Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.queueSupplier = supplier;
            MergeSequentialInner<T>[] mergeSequentialInnerArr = new MergeSequentialInner[i];
            for (int i10 = 0; i10 < i; i10++) {
                mergeSequentialInnerArr[i10] = new MergeSequentialInner<>(this, i6);
            }
            this.subscribers = mergeSequentialInnerArr;
            DONE.lazySet(this, i);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (WIP.getAndIncrement(this) == 0) {
                cleanup();
            }
        }

        public void cancelAll() {
            for (MergeSequentialInner<T> mergeSequentialInner : this.subscribers) {
                mergeSequentialInner.cancel();
            }
        }

        public void cleanup() {
            for (MergeSequentialInner<T> mergeSequentialInner : this.subscribers) {
                mergeSequentialInner.queue = null;
            }
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        
            r16 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
        
            if (r12 == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
        
            if (r15 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (r15 == false) goto L89;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drainLoop() {
            /*
                r18 = this;
                r0 = r18
                reactor.core.publisher.ParallelMergeSequential$MergeSequentialInner<T>[] r1 = r0.subscribers
                int r2 = r1.length
                reactor.core.CoreSubscriber<? super T> r3 = r0.actual
                r5 = 1
            L8:
                long r6 = r0.requested
                r10 = 0
            Lc:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                r13 = 0
                if (r12 == 0) goto L5c
                boolean r12 = r0.cancelled
                if (r12 == 0) goto L19
                r0.cleanup()
                return
            L19:
                java.lang.Throwable r12 = r0.error
                if (r12 == 0) goto L24
                r0.cleanup()
                r3.onError(r12)
                return
            L24:
                int r12 = r0.done
                if (r12 != 0) goto L2a
                r12 = 1
                goto L2b
            L2a:
                r12 = r13
            L2b:
                r14 = r13
                r15 = 1
            L2d:
                if (r14 >= r2) goto L4f
                r4 = r1[r14]
                r16 = 0
                java.util.Queue<T> r8 = r4.queue
                if (r8 == 0) goto L4c
                java.lang.Object r8 = r8.poll()
                if (r8 == 0) goto L4c
                r3.onNext(r8)
                r4.requestOne()
                r8 = 1
                long r10 = r10 + r8
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L4b
                goto L5e
            L4b:
                r15 = r13
            L4c:
                int r14 = r14 + 1
                goto L2d
            L4f:
                r16 = 0
                if (r12 == 0) goto L59
                if (r15 == 0) goto L59
                r3.onComplete()
                return
            L59:
                if (r15 == 0) goto Lc
                goto L5e
            L5c:
                r16 = 0
            L5e:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L98
                boolean r4 = r0.cancelled
                if (r4 == 0) goto L6a
                r0.cleanup()
                return
            L6a:
                java.lang.Throwable r4 = r0.error
                if (r4 == 0) goto L75
                r0.cleanup()
                r3.onError(r4)
                return
            L75:
                int r4 = r0.done
                if (r4 != 0) goto L7b
                r4 = 1
                goto L7c
            L7b:
                r4 = r13
            L7c:
                r8 = r13
            L7d:
                if (r8 >= r2) goto L8f
                r9 = r1[r8]
                java.util.Queue<T> r9 = r9.queue
                if (r9 == 0) goto L8c
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L8c
                goto L90
            L8c:
                int r8 = r8 + 1
                goto L7d
            L8f:
                r13 = 1
            L90:
                if (r4 == 0) goto L98
                if (r13 == 0) goto L98
                r3.onComplete()
                return
            L98:
                int r4 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
                if (r4 == 0) goto Lab
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto Lab
                java.util.concurrent.atomic.AtomicLongFieldUpdater<reactor.core.publisher.ParallelMergeSequential$MergeSequentialMain> r4 = reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.REQUESTED
                long r6 = -r10
                r4.addAndGet(r0, r6)
            Lab:
                int r4 = r0.wip
                if (r4 != r5) goto Lb9
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.ParallelMergeSequential$MergeSequentialMain> r4 = reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.WIP
                int r5 = -r5
                int r4 = r4.addAndGet(r0, r5)
                if (r4 != 0) goto Lb9
                return
            Lb9:
                r5 = r4
                goto L8
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.drainLoop():void");
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        public void onComplete() {
            if (DONE.decrementAndGet(this) < 0) {
                return;
            }
            drain();
        }

        public void onError(Throwable th) {
            if (ERROR.compareAndSet(this, null, th)) {
                cancelAll();
                drain();
            } else if (this.error != th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onNext(reactor.core.publisher.ParallelMergeSequential.MergeSequentialInner<T> r7, T r8) {
            /*
                r6 = this;
                int r0 = r6.wip
                java.lang.String r1 = "Queue is full: Reactive Streams source doesn't respect backpressure"
                if (r0 != 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.ParallelMergeSequential$MergeSequentialMain> r0 = reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.WIP
                r2 = 0
                r3 = 1
                boolean r2 = r0.compareAndSet(r6, r2, r3)
                if (r2 == 0) goto L56
                long r2 = r6.requested
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 == 0) goto L31
                reactor.core.CoreSubscriber<? super T> r1 = r6.actual
                r1.onNext(r8)
                long r1 = r6.requested
                r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r8 == 0) goto L2d
                java.util.concurrent.atomic.AtomicLongFieldUpdater<reactor.core.publisher.ParallelMergeSequential$MergeSequentialMain> r8 = reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.REQUESTED
                r8.decrementAndGet(r6)
            L2d:
                r7.requestOne()
                goto L4f
            L31:
                java.util.function.Supplier<java.util.Queue<T>> r2 = r6.queueSupplier
                java.util.Queue r7 = r7.getQueue(r2)
                boolean r7 = r7.offer(r8)
                if (r7 != 0) goto L4f
                java.lang.IllegalStateException r7 = reactor.core.Exceptions.failWithOverflow(r1)
                reactor.core.CoreSubscriber<? super T> r0 = r6.actual
                reactor.util.context.Context r0 = r0.currentContext()
                java.lang.Throwable r7 = reactor.core.publisher.Operators.onOperatorError(r6, r7, r8, r0)
                r6.onError(r7)
                return
            L4f:
                int r7 = r0.decrementAndGet(r6)
                if (r7 != 0) goto L7d
                goto L7c
            L56:
                java.util.function.Supplier<java.util.Queue<T>> r0 = r6.queueSupplier
                java.util.Queue r7 = r7.getQueue(r0)
                boolean r7 = r7.offer(r8)
                if (r7 != 0) goto L74
                java.lang.IllegalStateException r7 = reactor.core.Exceptions.failWithOverflow(r1)
                reactor.core.CoreSubscriber<? super T> r0 = r6.actual
                reactor.util.context.Context r0 = r0.currentContext()
                java.lang.Throwable r7 = reactor.core.publisher.Operators.onOperatorError(r6, r7, r8, r0)
                r6.onError(r7)
                return
            L74:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.ParallelMergeSequential$MergeSequentialMain> r7 = reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.WIP
                int r7 = r7.getAndIncrement(r6)
                if (r7 == 0) goto L7d
            L7c:
                return
            L7d:
                r6.drainLoop()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ParallelMergeSequential.MergeSequentialMain.onNext(reactor.core.publisher.ParallelMergeSequential$MergeSequentialInner, java.lang.Object):void");
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done == 0);
            }
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public ParallelMergeSequential(ParallelFlux<? extends T> parallelFlux, int i, Supplier<Queue<T>> supplier) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.prefetch = i;
        this.queueSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
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
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        MergeSequentialMain mergeSequentialMain = new MergeSequentialMain(coreSubscriber, this.source.parallelism(), this.prefetch, this.queueSupplier);
        coreSubscriber.onSubscribe(mergeSequentialMain);
        this.source.subscribe(mergeSequentialMain.subscribers);
    }
}
