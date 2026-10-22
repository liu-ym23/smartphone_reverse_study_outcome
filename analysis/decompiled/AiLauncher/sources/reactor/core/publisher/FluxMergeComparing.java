package reactor.core.publisher;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxMergeComparing<T> extends Flux<T> implements SourceProducer<T> {
    final boolean delayError;
    final int prefetch;
    final qc.b<? extends T>[] sources;
    final Comparator<? super T> valueComparator;
    final boolean waitForAllSources;

    public static final class MergeOrderedInnerSubscriber<T> implements InnerOperator<T, T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<MergeOrderedInnerSubscriber, qc.d> f39531S = AtomicReferenceFieldUpdater.newUpdater(MergeOrderedInnerSubscriber.class, qc.d.class, "s");
        int consumed;
        volatile boolean done;
        final int limit;
        final MergeOrderedMainProducer<T> parent;
        final int prefetch;
        final Queue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39532s;

        public MergeOrderedInnerSubscriber(MergeOrderedMainProducer<T> mergeOrderedMainProducer, int i10) {
            this.parent = mergeOrderedMainProducer;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
            this.queue = (Queue) Queues.get(i10).get();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.parent.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            qc.d andSet = f39531S.getAndSet(this, this);
            if (andSet == null || andSet == this) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.onInnerError(this, th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.parent.done || this.done) {
                Operators.onNextDropped(t10, actual().currentContext());
            } else {
                this.queue.offer(t10);
                this.parent.drain();
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39531S, this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            int i10 = this.consumed + 1;
            if (i10 != this.limit) {
                this.consumed = i10;
                return;
            }
            this.consumed = 0;
            qc.d dVar = this.f39532s;
            if (dVar != this) {
                dVar.request(i10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.parent : attr == Scannable.Attr.PARENT ? this.f39532s : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class MergeOrderedMainProducer<T> implements InnerProducer<T> {
        final CoreSubscriber<? super T> actual;
        volatile int cancelled;
        final Comparator<? super T> comparator;
        final boolean delayError;
        boolean done;
        volatile long emitted;
        volatile Throwable error;
        volatile long requested;
        final MergeOrderedInnerSubscriber<T>[] subscribers;
        final Object[] values;
        final boolean waitForAllSources;
        volatile int wip;
        static final Object DONE = new Object();
        static final AtomicReferenceFieldUpdater<MergeOrderedMainProducer, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeOrderedMainProducer.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<MergeOrderedMainProducer> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(MergeOrderedMainProducer.class, "cancelled");
        static final AtomicLongFieldUpdater<MergeOrderedMainProducer> REQUESTED = AtomicLongFieldUpdater.newUpdater(MergeOrderedMainProducer.class, "requested");
        static final AtomicLongFieldUpdater<MergeOrderedMainProducer> EMITTED = AtomicLongFieldUpdater.newUpdater(MergeOrderedMainProducer.class, "emitted");
        static final AtomicIntegerFieldUpdater<MergeOrderedMainProducer> WIP = AtomicIntegerFieldUpdater.newUpdater(MergeOrderedMainProducer.class, "wip");

        public MergeOrderedMainProducer(CoreSubscriber<? super T> coreSubscriber, Comparator<? super T> comparator, int i10, int i11, boolean z10, boolean z11) {
            this.actual = coreSubscriber;
            this.comparator = comparator;
            this.delayError = z10;
            this.waitForAllSources = z11;
            this.subscribers = new MergeOrderedInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.subscribers[i12] = new MergeOrderedInnerSubscriber<>(this, i10);
            }
            this.values = new Object[i11];
        }

        private void discardData() {
            Context contextCurrentContext = actual().currentContext();
            for (Object obj : this.values) {
                if (obj != DONE) {
                    Operators.onDiscard(obj, contextCurrentContext);
                }
            }
            Arrays.fill(this.values, (Object) null);
            for (MergeOrderedInnerSubscriber<T> mergeOrderedInnerSubscriber : this.subscribers) {
                Operators.onDiscardQueueWithClear(mergeOrderedInnerSubscriber.queue, contextCurrentContext, null);
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                for (MergeOrderedInnerSubscriber<T> mergeOrderedInnerSubscriber : this.subscribers) {
                    mergeOrderedInnerSubscriber.cancel();
                }
                if (WIP.getAndIncrement(this) == 0) {
                    discardData();
                }
            }
        }

        public boolean checkTerminated(boolean z10, qc.c<?> cVar) {
            if (this.cancelled != 0) {
                discardData();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                Throwable th = this.error;
                if (th == null || th == Exceptions.TERMINATED) {
                    cVar.onComplete();
                } else {
                    cVar.onError(Exceptions.terminate(ERROR, this));
                }
            } else {
                Throwable th2 = this.error;
                if (th2 == null || th2 == Exceptions.TERMINATED) {
                    cVar.onComplete();
                } else {
                    Throwable thTerminate = Exceptions.terminate(ERROR, this);
                    cancel();
                    discardData();
                    cVar.onError(thTerminate);
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00c5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 224
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxMergeComparing.MergeOrderedMainProducer.drain():void");
        }

        public void onInnerError(MergeOrderedInnerSubscriber<T> mergeOrderedInnerSubscriber, Throwable th) {
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, actual().currentContext(), this);
            if (thOnNextInnerError == null) {
                mergeOrderedInnerSubscriber.done = true;
                drain();
            } else if (!Exceptions.addThrowable(ERROR, this, thOnNextInnerError)) {
                mergeOrderedInnerSubscriber.done = true;
                Operators.onErrorDropped(thOnNextInnerError, this.actual.currentContext());
            } else {
                if (!this.delayError) {
                    this.done = true;
                }
                mergeOrderedInnerSubscriber.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            Operators.addCap(REQUESTED, this, j10);
            drain();
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ACTUAL) {
                return this.actual;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled > 0);
            }
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested - this.emitted) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void subscribe(qc.b<? extends T>[] bVarArr) {
            if (bVarArr.length != this.subscribers.length) {
                throw new IllegalArgumentException("must subscribe with " + this.subscribers.length + " sources");
            }
            for (int i10 = 0; i10 < bVarArr.length; i10++) {
                Objects.requireNonNull(bVarArr[i10], "subscribed with a null source: sources[" + i10 + "]");
                bVarArr[i10].subscribe(this.subscribers[i10]);
            }
        }
    }

    @SafeVarargs
    public FluxMergeComparing(int i10, Comparator<? super T> comparator, boolean z10, boolean z11, qc.b<? extends T>... bVarArr) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
        }
        Objects.requireNonNull(bVarArr, "sources must be non-null");
        this.sources = bVarArr;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            if (bVarArr[i11] == null) {
                throw new NullPointerException("sources[" + i11 + "] is null");
            }
        }
        Operators.toFluxOrMono(this.sources);
        this.prefetch = i10;
        this.valueComparator = comparator;
        this.delayError = z10;
        this.waitForAllSources = z11;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    public FluxMergeComparing<T> mergeAdditionalSource(qc.b<? extends T> bVar, Comparator<? super T> comparator) {
        qc.b<? extends T>[] bVarArr = this.sources;
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = bVar;
        if (this.valueComparator.equals(comparator)) {
            return new FluxMergeComparing<>(this.prefetch, this.valueComparator, this.delayError, this.waitForAllSources, bVarArr2);
        }
        return new FluxMergeComparing<>(this.prefetch, this.valueComparator.thenComparing((Comparator<? super Object>) comparator), this.delayError, this.waitForAllSources, bVarArr2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr != Scannable.Attr.PARENT) {
            return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
        qc.b<? extends T>[] bVarArr = this.sources;
        if (bVarArr.length > 0) {
            return bVarArr[0];
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        MergeOrderedMainProducer mergeOrderedMainProducer = new MergeOrderedMainProducer(coreSubscriber, this.valueComparator, this.prefetch, this.sources.length, this.delayError, this.waitForAllSources);
        coreSubscriber.onSubscribe(mergeOrderedMainProducer);
        mergeOrderedMainProducer.subscribe(this.sources);
    }
}
