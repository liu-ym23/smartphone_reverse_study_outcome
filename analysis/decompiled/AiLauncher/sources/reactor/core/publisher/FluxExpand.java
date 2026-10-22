package reactor.core.publisher;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxExpand<T> extends InternalFluxOperator<T, T> {
    final boolean breadthFirst;
    final int capacityHint;
    final Function<? super T, ? extends qc.b<? extends T>> expander;

    public static final class ExpandBreathSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<ExpandBreathSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(ExpandBreathSubscriber.class, "wip");
        volatile boolean active;
        final Function<? super T, ? extends qc.b<? extends T>> expander;
        long produced;
        final Queue<qc.b<? extends T>> queue;
        volatile int wip;

        public ExpandBreathSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
            super(coreSubscriber);
            this.expander = function;
            this.queue = (Queue) Queues.unbounded(i10).get();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            super.cancel();
            drainQueue();
        }

        public void drainQueue() {
            if (WIP.getAndIncrement(this) == 0) {
                do {
                    Queue<qc.b<? extends T>> queue = this.queue;
                    if (isCancelled()) {
                        queue.clear();
                    } else if (!this.active) {
                        if (queue.isEmpty()) {
                            set(Operators.cancelledSubscription());
                            super.cancel();
                            this.actual.onComplete();
                        } else {
                            qc.b<? extends T> bVarPoll = queue.poll();
                            long j10 = this.produced;
                            if (j10 != 0) {
                                this.produced = 0L;
                                produced(j10);
                            }
                            this.active = true;
                            bVarPoll.subscribe(this);
                        }
                    }
                } while (WIP.decrementAndGet(this) != 0);
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.active = false;
            drainQueue();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            set(Operators.cancelledSubscription());
            super.cancel();
            this.actual.onError(th);
            drainQueue();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
            try {
                qc.b<? extends T> bVarApply = this.expander.apply(t10);
                Objects.requireNonNull(bVarApply, "The expander returned a null Publisher");
                this.queue.offer(Operators.toFluxOrMono(bVarApply));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                super.cancel();
                this.actual.onError(th);
                drainQueue();
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            set(dVar);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Queue<qc.b<? extends T>> queue = this.queue;
            return Integer.valueOf(queue != null ? queue.size() : 0);
        }
    }

    public static final class ExpandDepthSubscriber<T> implements InnerConsumer<T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<ExpandDepthSubscriber, qc.d> f39504S = AtomicReferenceFieldUpdater.newUpdater(ExpandDepthSubscriber.class, qc.d.class, "s");
        volatile boolean done;
        ExpandDepthSubscription<T> parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39505s;
        volatile T value;

        public ExpandDepthSubscriber(ExpandDepthSubscription<T> expandDepthSubscription) {
            this.parent = expandDepthSubscription;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual().currentContext();
        }

        public void dispose() {
            Operators.terminate(f39504S, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.f39505s != Operators.cancelledSubscription()) {
                this.parent.innerComplete(this);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.f39505s != Operators.cancelledSubscription()) {
                this.parent.innerError(this, th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.f39505s != Operators.cancelledSubscription()) {
                this.value = t10;
                this.parent.innerNext();
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39504S, this, dVar)) {
                dVar.request(1L);
            }
        }

        public void requestOne() {
            this.f39505s.request(1L);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39505s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent.actual;
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

    public static final class ExpandDepthSubscription<T> implements InnerProducer<T> {
        volatile int active;
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        volatile Object current;
        volatile Throwable error;
        final Function<? super T, ? extends qc.b<? extends T>> expander;
        volatile long requested;
        CorePublisher<? extends T> source;
        Deque<ExpandDepthSubscriber<T>> subscriptionStack;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<ExpandDepthSubscription, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ExpandDepthSubscription.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<ExpandDepthSubscription> ACTIVE = AtomicIntegerFieldUpdater.newUpdater(ExpandDepthSubscription.class, "active");
        static final AtomicLongFieldUpdater<ExpandDepthSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(ExpandDepthSubscription.class, "requested");
        static final AtomicReferenceFieldUpdater<ExpandDepthSubscription, Object> CURRENT = AtomicReferenceFieldUpdater.newUpdater(ExpandDepthSubscription.class, Object.class, "current");
        static final AtomicIntegerFieldUpdater<ExpandDepthSubscription> WIP = AtomicIntegerFieldUpdater.newUpdater(ExpandDepthSubscription.class, "wip");

        public ExpandDepthSubscription(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qc.b<? extends T>> function, int i10) {
            this.actual = coreSubscriber;
            this.expander = function;
            this.subscriptionStack = new ArrayDeque(i10);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Deque<ExpandDepthSubscriber<T>> deque;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            synchronized (this) {
                deque = this.subscriptionStack;
                this.subscriptionStack = null;
            }
            if (deque != null) {
                while (!deque.isEmpty()) {
                    deque.poll().dispose();
                }
            }
            Object andSet = CURRENT.getAndSet(this, this);
            if (andSet == this || andSet == null) {
                return;
            }
            ((ExpandDepthSubscriber) andSet).dispose();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00d0, code lost:
        
            r12.source = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drainQueue() {
            /*
                r12 = this;
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription> r0 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.WIP
                int r0 = r0.getAndIncrement(r12)
                if (r0 == 0) goto La
                goto Lcc
            La:
                reactor.core.CoreSubscriber<? super T> r0 = r12.actual
                long r1 = r12.consumed
                r3 = 1
                r4 = r3
            L10:
                java.lang.Object r5 = r12.current
                boolean r6 = r12.cancelled
                r7 = 0
                if (r6 != 0) goto Ld0
                if (r5 != r12) goto L1b
                goto Ld0
            L1b:
                reactor.core.publisher.FluxExpand$ExpandDepthSubscriber r5 = (reactor.core.publisher.FluxExpand.ExpandDepthSubscriber) r5
                reactor.core.CorePublisher<? extends T> r6 = r12.source
                if (r5 != 0) goto L3a
                if (r6 == 0) goto L3a
                r12.source = r7
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription> r5 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.ACTIVE
                r5.getAndIncrement(r12)
                reactor.core.publisher.FluxExpand$ExpandDepthSubscriber r5 = new reactor.core.publisher.FluxExpand$ExpandDepthSubscriber
                r5.<init>(r12)
                boolean r7 = r12.setCurrent(r5)
                if (r7 == 0) goto Lcc
                r6.subscribe(r5)
                goto Lbd
            L3a:
                if (r5 != 0) goto L3e
                goto Lcc
            L3e:
                boolean r6 = r5.done
                T r8 = r5.value
                r9 = 0
                if (r8 == 0) goto L8e
                long r10 = r12.requested
                int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
                if (r10 == 0) goto L8e
                r5.value = r7
                r0.onNext(r8)
                r10 = 1
                long r1 = r1 + r10
                java.util.function.Function<? super T, ? extends qc.b<? extends T>> r10 = r12.expander     // Catch: java.lang.Throwable -> L62
                java.lang.Object r10 = r10.apply(r8)     // Catch: java.lang.Throwable -> L62
                java.lang.String r11 = "The expander returned a null Publisher"
                java.util.Objects.requireNonNull(r10, r11)     // Catch: java.lang.Throwable -> L62
                qc.b r10 = (qc.b) r10     // Catch: java.lang.Throwable -> L62
                r7 = r10
                goto L72
            L62:
                r6 = move-exception
                reactor.core.Exceptions.throwIfFatal(r6)
                r5.dispose()
                r5.done = r3
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription, java.lang.Throwable> r8 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.ERROR
                reactor.core.Exceptions.addThrowable(r8, r12, r6)
                r6 = r3
                r8 = r7
            L72:
                if (r7 == 0) goto L8e
                boolean r5 = r12.push(r5)
                if (r5 == 0) goto L8e
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription> r5 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.ACTIVE
                r5.getAndIncrement(r12)
                reactor.core.publisher.FluxExpand$ExpandDepthSubscriber r5 = new reactor.core.publisher.FluxExpand$ExpandDepthSubscriber
                r5.<init>(r12)
                boolean r9 = r12.setCurrent(r5)
                if (r9 == 0) goto Lcc
                r7.subscribe(r5)
                r9 = r3
            L8e:
                if (r9 != 0) goto Lbd
                if (r6 == 0) goto Lbd
                if (r8 != 0) goto Lbd
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription> r5 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.ACTIVE
                int r5 = r5.decrementAndGet(r12)
                if (r5 != 0) goto Lac
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription, java.lang.Throwable> r1 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.ERROR
                java.lang.Throwable r12 = reactor.core.Exceptions.terminate(r1, r12)
                if (r12 == 0) goto La8
                r0.onError(r12)
                goto Lcc
            La8:
                r0.onComplete()
                goto Lcc
            Lac:
                reactor.core.publisher.FluxExpand$ExpandDepthSubscriber r5 = r12.pop()
                if (r5 == 0) goto Lcc
                boolean r6 = r12.setCurrent(r5)
                if (r6 == 0) goto Lcc
                r5.requestOne()
                goto L10
            Lbd:
                int r5 = r12.wip
                if (r4 != r5) goto Lcd
                r12.consumed = r1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxExpand$ExpandDepthSubscription> r5 = reactor.core.publisher.FluxExpand.ExpandDepthSubscription.WIP
                int r4 = -r4
                int r4 = r5.addAndGet(r12, r4)
                if (r4 != 0) goto L10
            Lcc:
                return
            Lcd:
                r4 = r5
                goto L10
            Ld0:
                r12.source = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxExpand.ExpandDepthSubscription.drainQueue():void");
        }

        public void innerComplete(ExpandDepthSubscriber expandDepthSubscriber) {
            expandDepthSubscriber.done = true;
            drainQueue();
        }

        public void innerError(ExpandDepthSubscriber expandDepthSubscriber, Throwable th) {
            Exceptions.addThrowable(ERROR, this, th);
            expandDepthSubscriber.done = true;
            drainQueue();
        }

        public void innerNext() {
            drainQueue();
        }

        @Nullable
        public ExpandDepthSubscriber<T> pop() {
            ExpandDepthSubscriber<T> expandDepthSubscriberPollFirst;
            synchronized (this) {
                try {
                    Deque<ExpandDepthSubscriber<T>> deque = this.subscriptionStack;
                    expandDepthSubscriberPollFirst = deque != null ? deque.pollFirst() : null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return expandDepthSubscriberPollFirst;
        }

        public boolean push(ExpandDepthSubscriber<T> expandDepthSubscriber) {
            synchronized (this) {
                try {
                    Deque<ExpandDepthSubscriber<T>> deque = this.subscriptionStack;
                    if (deque == null) {
                        return false;
                    }
                    deque.offerFirst(expandDepthSubscriber);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drainQueue();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.ERROR ? this.error : super.scanUnsafe(attr);
        }

        public boolean setCurrent(ExpandDepthSubscriber<T> expandDepthSubscriber) {
            AtomicReferenceFieldUpdater<ExpandDepthSubscription, Object> atomicReferenceFieldUpdater;
            Object obj;
            do {
                atomicReferenceFieldUpdater = CURRENT;
                obj = atomicReferenceFieldUpdater.get(this);
                if (obj == this) {
                    expandDepthSubscriber.dispose();
                    return false;
                }
            } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, expandDepthSubscriber));
            return true;
        }
    }

    public FluxExpand(Flux<T> flux, Function<? super T, ? extends qc.b<? extends T>> function, boolean z10, int i10) {
        super(flux);
        this.expander = function;
        this.breadthFirst = z10;
        this.capacityHint = i10;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        if (!this.breadthFirst) {
            ExpandDepthSubscription expandDepthSubscription = new ExpandDepthSubscription(coreSubscriber, this.expander, this.capacityHint);
            expandDepthSubscription.source = this.source;
            coreSubscriber.onSubscribe(expandDepthSubscription);
            return null;
        }
        ExpandBreathSubscriber expandBreathSubscriber = new ExpandBreathSubscriber(coreSubscriber, this.expander, this.capacityHint);
        expandBreathSubscriber.queue.offer(this.source);
        coreSubscriber.onSubscribe(expandBreathSubscriber);
        expandBreathSubscriber.drainQueue();
        return null;
    }
}
