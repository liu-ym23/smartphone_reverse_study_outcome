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

/* loaded from: classes4.dex */
final class FluxMergeComparing<T> extends Flux<T> implements SourceProducer<T> {
    final boolean delayError;
    final int prefetch;
    final Z9.c[] sources;
    final Comparator<? super T> valueComparator;
    final boolean waitForAllSources;

    public static final class MergeOrderedInnerSubscriber<T> implements InnerOperator<T, T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<MergeOrderedInnerSubscriber, Z9.e> f5761S = AtomicReferenceFieldUpdater.newUpdater(MergeOrderedInnerSubscriber.class, Z9.e.class, "s");
        int consumed;
        volatile boolean done;
        final int limit;
        final MergeOrderedMainProducer<T> parent;
        final int prefetch;
        final Queue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5762s;

        public MergeOrderedInnerSubscriber(MergeOrderedMainProducer<T> mergeOrderedMainProducer, int i) {
            this.parent = mergeOrderedMainProducer;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.queue = (Queue) Queues.get(i).get();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.parent.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Z9.e andSet = f5761S.getAndSet(this, this);
            if (andSet == null || andSet == this) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.parent.onInnerError(this, th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.parent.done || this.done) {
                Operators.onNextDropped(t9, actual().currentContext());
            } else {
                this.queue.offer(t9);
                this.parent.drain();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5761S, this, eVar)) {
                eVar.request(this.prefetch);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            int i = this.consumed + 1;
            if (i != this.limit) {
                this.consumed = i;
                return;
            }
            this.consumed = 0;
            Z9.e eVar = this.f5762s;
            if (eVar != this) {
                eVar.request(i);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.parent : attr == Scannable.Attr.PARENT ? this.f5762s : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

        public MergeOrderedMainProducer(CoreSubscriber<? super T> coreSubscriber, Comparator<? super T> comparator, int i, int i6, boolean z10, boolean z11) {
            this.actual = coreSubscriber;
            this.comparator = comparator;
            this.delayError = z10;
            this.waitForAllSources = z11;
            this.subscribers = new MergeOrderedInnerSubscriber[i6];
            for (int i10 = 0; i10 < i6; i10++) {
                this.subscribers[i10] = new MergeOrderedInnerSubscriber<>(this, i);
            }
            this.values = new Object[i6];
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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
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

        public boolean checkTerminated(boolean z10, Z9.d dVar) {
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
                    dVar.onComplete();
                } else {
                    dVar.onError(Exceptions.terminate(ERROR, this));
                }
            } else {
                Throwable th2 = this.error;
                if (th2 == null || th2 == Exceptions.TERMINATED) {
                    dVar.onComplete();
                } else {
                    Throwable thTerminate = Exceptions.terminate(ERROR, this);
                    cancel();
                    discardData();
                    dVar.onError(thTerminate);
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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Operators.addCap(REQUESTED, this, j5);
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

        public void subscribe(Z9.c[] cVarArr) {
            if (cVarArr.length != this.subscribers.length) {
                throw new IllegalArgumentException(androidx.appfunctions.metadata.a.o(new StringBuilder("must subscribe with "), " sources", this.subscribers.length));
            }
            for (int i = 0; i < cVarArr.length; i++) {
                Objects.requireNonNull(cVarArr[i], "subscribed with a null source: sources[" + i + "]");
                cVarArr[i].subscribe(this.subscribers[i]);
            }
        }
    }

    @SafeVarargs
    public FluxMergeComparing(int i, Comparator<? super T> comparator, boolean z10, boolean z11, Z9.c... cVarArr) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(cVarArr, "sources must be non-null");
        this.sources = cVarArr;
        for (int i6 = 0; i6 < cVarArr.length; i6++) {
            if (cVarArr[i6] == null) {
                throw new NullPointerException(androidx.appfunctions.metadata.a.i(i6, "sources[", "] is null"));
            }
        }
        Operators.toFluxOrMono(this.sources);
        this.prefetch = i;
        this.valueComparator = comparator;
        this.delayError = z10;
        this.waitForAllSources = z11;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    public FluxMergeComparing<T> mergeAdditionalSource(Z9.c cVar, Comparator<? super T> comparator) {
        Z9.c[] cVarArr = this.sources;
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        if (this.valueComparator.equals(comparator)) {
            return new FluxMergeComparing<>(this.prefetch, this.valueComparator, this.delayError, this.waitForAllSources, cVarArr2);
        }
        return new FluxMergeComparing<>(this.prefetch, this.valueComparator.thenComparing((Comparator<? super Object>) comparator), this.delayError, this.waitForAllSources, cVarArr2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr != Scannable.Attr.PARENT) {
            return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
        Z9.c[] cVarArr = this.sources;
        if (cVarArr.length > 0) {
            return cVarArr[0];
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
