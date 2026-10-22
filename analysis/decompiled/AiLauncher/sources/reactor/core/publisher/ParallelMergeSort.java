package reactor.core.publisher;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class ParallelMergeSort<T> extends Flux<T> implements Scannable {
    final Comparator<? super T> comparator;
    final ParallelFlux<List<T>> source;

    public static final class MergeSortInner<T> implements InnerConsumer<List<T>> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<MergeSortInner, qc.d> f39699S = AtomicReferenceFieldUpdater.newUpdater(MergeSortInner.class, qc.d.class, "s");
        final int index;
        final MergeSortMain<T> parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39700s;

        public MergeSortInner(MergeSortMain<T> mergeSortMain, int i10) {
            this.parent = mergeSortMain;
            this.index = i10;
        }

        public void cancel() {
            Operators.terminate(f39699S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39699S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39700s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f39700s;
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    public static final class MergeSortMain<T> implements InnerProducer<T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        volatile Throwable error;
        final int[] indexes;
        final List<T>[] lists;
        volatile int remaining;
        volatile long requested;
        final MergeSortInner<T>[] subscribers;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<MergeSortMain> WIP = AtomicIntegerFieldUpdater.newUpdater(MergeSortMain.class, "wip");
        static final AtomicLongFieldUpdater<MergeSortMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(MergeSortMain.class, "requested");
        static final AtomicIntegerFieldUpdater<MergeSortMain> REMAINING = AtomicIntegerFieldUpdater.newUpdater(MergeSortMain.class, "remaining");
        static final AtomicReferenceFieldUpdater<MergeSortMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeSortMain.class, Throwable.class, "error");

        public MergeSortMain(CoreSubscriber<? super T> coreSubscriber, int i10, Comparator<? super T> comparator) {
            this.comparator = comparator;
            this.actual = coreSubscriber;
            MergeSortInner<T>[] mergeSortInnerArr = new MergeSortInner[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                mergeSortInnerArr[i11] = new MergeSortInner<>(this, i11);
            }
            this.subscribers = mergeSortInnerArr;
            this.lists = new List[i10];
            this.indexes = new int[i10];
            REMAINING.lazySet(this, i10);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (WIP.getAndIncrement(this) == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        public void cancelAll() {
            for (MergeSortInner<T> mergeSortInner : this.subscribers) {
                mergeSortInner.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
        
            if (r11 != r7) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
        
            if (r19.cancelled == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        
            java.util.Arrays.fill(r2, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
        
            r5 = r19.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
        
            if (r5 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
        
            cancelAll();
            java.util.Arrays.fill(r2, (java.lang.Object) null);
            r1.onError(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
        
            if (r14 >= r4) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
        
            if (r3[r14] == r2[r14].size()) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        
            r14 = r14 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
        
            java.util.Arrays.fill(r2, (java.lang.Object) null);
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ae, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
        
            if (r11 == 0) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        
            if (r7 == Long.MAX_VALUE) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00bc, code lost:
        
            reactor.core.publisher.ParallelMergeSort.MergeSortMain.REQUESTED.addAndGet(r19, -r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
        
            r5 = r19.wip;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
        
            if (r5 != r6) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c6, code lost:
        
            r5 = reactor.core.publisher.ParallelMergeSort.MergeSortMain.WIP.addAndGet(r19, -r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
        
            if (r5 != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 211
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ParallelMergeSort.MergeSortMain.drain():void");
        }

        public void innerError(Throwable th) {
            if (ERROR.compareAndSet(this, null, th)) {
                cancelAll();
                drain();
            } else if (this.error != th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        public void innerNext(List<T> list, int i10) {
            this.lists[i10] = list;
            if (REMAINING.decrementAndGet(this) == 0) {
                drain();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                if (this.remaining == 0) {
                    drain();
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.subscribers.length - this.remaining) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public ParallelMergeSort(ParallelFlux<List<T>> parallelFlux, Comparator<? super T> comparator) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.comparator = comparator;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
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
        MergeSortMain mergeSortMain = new MergeSortMain(coreSubscriber, this.source.parallelism(), this.comparator);
        coreSubscriber.onSubscribe(mergeSortMain);
        this.source.subscribe(mergeSortMain.subscribers);
    }
}
