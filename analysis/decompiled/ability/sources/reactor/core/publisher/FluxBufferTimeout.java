package reactor.core.publisher;

import java.util.Collection;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.FluxBufferTimeout;
import reactor.core.scheduler.Scheduler;
import reactor.util.Logger;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxBufferTimeout<T, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final int batchSize;
    final Supplier<C> bufferSupplier;
    final boolean fairBackpressure;
    final Logger logger;
    final Scheduler timer;
    final long timespan;
    final TimeUnit unit;

    public static final class BufferTimeoutSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        static final int NOT_TERMINATED = 0;
        static final int TERMINATED_WITH_CANCEL = 3;
        static final int TERMINATED_WITH_ERROR = 2;
        static final int TERMINATED_WITH_SUCCESS = 1;
        final CoreSubscriber<? super C> actual;
        final int batchSize;
        final Supplier<C> bufferSupplier;
        volatile long outstanding;
        volatile long requested;
        protected Z9.e subscription;
        final Scheduler.Worker timer;
        final long timespan;
        volatile Disposable timespanRegistration;
        final TimeUnit unit;
        volatile C values;
        static final AtomicIntegerFieldUpdater<BufferTimeoutSubscriber> TERMINATED = AtomicIntegerFieldUpdater.newUpdater(BufferTimeoutSubscriber.class, "terminated");
        static final AtomicLongFieldUpdater<BufferTimeoutSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferTimeoutSubscriber.class, "requested");
        static final AtomicLongFieldUpdater<BufferTimeoutSubscriber> OUTSTANDING = AtomicLongFieldUpdater.newUpdater(BufferTimeoutSubscriber.class, "outstanding");
        static final AtomicIntegerFieldUpdater<BufferTimeoutSubscriber> INDEX = AtomicIntegerFieldUpdater.newUpdater(BufferTimeoutSubscriber.class, "index");
        volatile int terminated = 0;
        volatile int index = 0;
        final Runnable flushTask = new G(this, 0);

        public BufferTimeoutSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, long j5, TimeUnit timeUnit, Scheduler.Worker worker, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.timespan = j5;
            this.unit = timeUnit;
            this.timer = worker;
            this.batchSize = i;
            this.bufferSupplier = supplier;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() throws Throwable {
            int i;
            if (this.terminated == 0) {
                do {
                    i = this.index;
                    if (i == 0) {
                        return;
                    }
                } while (!INDEX.compareAndSet(this, i, 0));
                flushCallback(null);
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (TERMINATED.compareAndSet(this, 0, 3)) {
                this.timer.dispose();
                Z9.e eVar = this.subscription;
                if (eVar != null) {
                    this.subscription = null;
                    eVar.cancel();
                }
                C c = this.values;
                if (c != null) {
                    Operators.onDiscardMultiple(c, this.actual.currentContext());
                    c.clear();
                }
            }
        }

        public void checkedComplete() {
            try {
                flushCallback(null);
            } finally {
                this.actual.onComplete();
            }
        }

        public void doOnSubscribe() {
            this.values = this.bufferSupplier.get();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x0072
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void flushCallback(@reactor.util.annotation.Nullable T r12) throws java.lang.Throwable {
            /*
                r11 = this;
                monitor-enter(r11)
                C extends java.util.Collection<? super T> r12 = r11.values     // Catch: java.lang.Throwable -> L6d
                if (r12 == 0) goto L1b
                boolean r0 = r12.isEmpty()     // Catch: java.lang.Throwable -> L17
                if (r0 != 0) goto L1b
                java.util.function.Supplier<C extends java.util.Collection<? super T>> r0 = r11.bufferSupplier     // Catch: java.lang.Throwable -> L17
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L17
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L17
                r11.values = r0     // Catch: java.lang.Throwable -> L17
                r0 = 1
                goto L1c
            L17:
                r0 = move-exception
                r12 = r0
                r6 = r11
                goto L70
            L1b:
                r0 = 0
            L1c:
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L6d
                if (r0 == 0) goto L6c
                long r0 = r11.requested
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L54
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 == 0) goto L4d
                r7 = r0
            L31:
                r0 = 1
                long r9 = r7 - r0
                java.util.concurrent.atomic.AtomicLongFieldUpdater<reactor.core.publisher.FluxBufferTimeout$BufferTimeoutSubscriber> r5 = reactor.core.publisher.FluxBufferTimeout.BufferTimeoutSubscriber.REQUESTED
                r6 = r11
                boolean r11 = r5.compareAndSet(r6, r7, r9)
                if (r11 == 0) goto L44
                reactor.core.CoreSubscriber<? super C extends java.util.Collection<? super T>> r11 = r6.actual
                r11.onNext(r12)
                return
            L44:
                long r7 = r6.requested
                int r11 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r11 > 0) goto L4b
                goto L55
            L4b:
                r11 = r6
                goto L31
            L4d:
                r6 = r11
                reactor.core.CoreSubscriber<? super C extends java.util.Collection<? super T>> r11 = r6.actual
                r11.onNext(r12)
                return
            L54:
                r6 = r11
            L55:
                r6.cancel()
                reactor.core.CoreSubscriber<? super C extends java.util.Collection<? super T>> r11 = r6.actual
                java.lang.String r0 = "Could not emit buffer due to lack of requests"
                java.lang.IllegalStateException r0 = reactor.core.Exceptions.failWithOverflow(r0)
                r11.onError(r0)
                reactor.core.CoreSubscriber<? super C extends java.util.Collection<? super T>> r11 = r6.actual
                reactor.util.context.Context r11 = r11.currentContext()
                reactor.core.publisher.Operators.onDiscardMultiple(r12, r11)
            L6c:
                return
            L6d:
                r0 = move-exception
                r6 = r11
            L6f:
                r12 = r0
            L70:
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L72
                throw r12
            L72:
                r0 = move-exception
                goto L6f
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxBufferTimeout.BufferTimeoutSubscriber.flushCallback(java.lang.Object):void");
        }

        public final boolean isCompleted() {
            return this.terminated == 1;
        }

        public final boolean isFailed() {
            return this.terminated == 2;
        }

        public void nextCallback(T t9) {
            synchronized (this) {
                try {
                    if (OUTSTANDING.decrementAndGet(this) < 0) {
                        this.actual.onError(Exceptions.failWithOverflow("Unrequested element received"));
                        Context contextCurrentContext = this.actual.currentContext();
                        Operators.onDiscard(t9, contextCurrentContext);
                        Operators.onDiscardMultiple(this.values, contextCurrentContext);
                        return;
                    }
                    C c = this.values;
                    if (c == null) {
                        C c2 = this.bufferSupplier.get();
                        Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                        c = c2;
                        this.values = c;
                    }
                    c.add(t9);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (TERMINATED.compareAndSet(this, 0, 1)) {
                this.timer.dispose();
                checkedComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (TERMINATED.compareAndSet(this, 0, 2)) {
                this.timer.dispose();
                Context contextCurrentContext = this.actual.currentContext();
                synchronized (this) {
                    try {
                        C c = this.values;
                        if (c != null) {
                            Operators.onDiscardMultiple(c, contextCurrentContext);
                            c.clear();
                            this.values = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) throws Throwable {
            int i;
            int i6;
            boolean z10;
            do {
                i = this.index;
                i6 = i + 1;
                z10 = i6 % this.batchSize == 0;
            } while (!INDEX.compareAndSet(this, i, z10 ? 0 : i6));
            if (i6 == 1) {
                try {
                    this.timespanRegistration = this.timer.schedule(this.flushTask, this.timespan, this.unit);
                } catch (RejectedExecutionException e) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onRejectedExecution(e, this.subscription, null, t9, contextCurrentContext));
                    Operators.onDiscard(t9, contextCurrentContext);
                    return;
                }
            }
            nextCallback(t9);
            if (z10) {
                if (this.timespanRegistration != null) {
                    this.timespanRegistration.dispose();
                    this.timespanRegistration = null;
                }
                flushCallback(t9);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.subscription, eVar)) {
                this.subscription = eVar;
                doOnSubscribe();
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                if (this.terminated != 0) {
                    return;
                }
                if (this.batchSize == Integer.MAX_VALUE || j5 == Long.MAX_VALUE) {
                    requestMore(Long.MAX_VALUE);
                    return;
                }
                long jMultiplyCap = Operators.multiplyCap(this.requested, this.batchSize);
                if (jMultiplyCap > this.outstanding) {
                    requestMore(jMultiplyCap - this.outstanding);
                }
            }
        }

        public final void requestMore(long j5) {
            Z9.e eVar = this.subscription;
            if (eVar != null) {
                Operators.addCap(OUTSTANDING, this, j5);
                eVar.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.terminated == 3);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.terminated == 2 || this.terminated == 1);
            }
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.batchSize) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.batchSize - this.index) : attr == Scannable.Attr.RUN_ON ? this.timer : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public static final class BufferTimeoutWithBackpressureSubscriber<T, C extends Collection<? super T>> implements InnerOperator<T, C> {
        static final long CANCELLED_FLAG = Long.MIN_VALUE;
        static final long HAS_WORK_IN_PROGRESS_FLAG = 2305843009213693952L;
        static final long INDEX_MASK = 4294967295L;
        private static final int INDEX_SHIFT = 0;
        static final long REQUESTED_INDEX_MASK = 1152921500311879680L;
        private static final int REQUESTED_INDEX_SHIFT = 32;
        static final long TERMINATED_FLAG = 4611686018427387904L;
        static final long TIMEOUT_FLAG = 1152921504606846976L;
        private final CoreSubscriber<? super C> actual;
        private final int batchSize;
        private final Supplier<C> bufferSupplier;
        private final Disposable.Swap currentTimeoutTask = Disposables.swap();
        private boolean done;

        @Nullable
        private Throwable error;

        @Nullable
        private final Logger logger;
        private int outstanding;
        private final int prefetch;
        private final Queue<T> queue;
        private final int replenishMark;
        volatile long requested;
        private volatile long state;

        @Nullable
        private final StateLogger stateLogger;

        @Nullable
        private Z9.e subscription;
        private final long timeSpan;
        private final Scheduler.Worker timer;
        private final TimeUnit unit;
        private static final AtomicLongFieldUpdater<BufferTimeoutWithBackpressureSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferTimeoutWithBackpressureSubscriber.class, "requested");
        private static final AtomicLongFieldUpdater<BufferTimeoutWithBackpressureSubscriber> STATE = AtomicLongFieldUpdater.newUpdater(BufferTimeoutWithBackpressureSubscriber.class, "state");

        public BufferTimeoutWithBackpressureSubscriber(CoreSubscriber<? super C> coreSubscriber, int i, long j5, TimeUnit timeUnit, Scheduler.Worker worker, Supplier<C> supplier, @Nullable Logger logger) {
            this.actual = coreSubscriber;
            this.batchSize = i;
            this.timeSpan = j5;
            this.unit = timeUnit;
            this.timer = worker;
            this.bufferSupplier = supplier;
            this.logger = logger;
            this.stateLogger = logger != null ? new StateLogger(logger) : null;
            int i6 = i << 2;
            this.prefetch = i6;
            this.replenishMark = i << 1;
            this.queue = (Queue) Queues.get(i6).get();
        }

        private static long bitwiseIncrement(long j5, long j6, long j10, int i) {
            int i6 = (int) j10;
            return (j5 & (~j6)) | (((((j5 & j6) >> i6) + i) << i6) & j6);
        }

        private void drain(boolean z10) {
            long j5;
            int i;
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "drain start");
            }
            boolean z11 = z10;
            while (true) {
                long jResetTimeout = this.state;
                if (this.done || isCancelled(jResetTimeout)) {
                    Logger logger2 = this.logger;
                    if (logger2 != null) {
                        trace(logger2, "Discarding entire queue of " + this.queue.size());
                    }
                    Operators.onDiscardQueueWithClear(this.queue, currentContext(), null);
                    if (!hasWorkInProgress(tryClearWip(this, jResetTimeout))) {
                        return;
                    }
                } else {
                    long index = getIndex(jResetTimeout);
                    long jDecrementAndGet = this.requested;
                    int i6 = 0;
                    boolean z12 = jDecrementAndGet > 0 && (z11 || isTimedOut(jResetTimeout) || isTerminated(jResetTimeout) || index >= ((long) this.batchSize));
                    Logger logger3 = this.logger;
                    if (logger3 != null) {
                        j5 = 0;
                        StringBuilder sb = new StringBuilder("should flush: ");
                        sb.append(z12);
                        sb.append(" currentRequest: ");
                        sb.append(jDecrementAndGet);
                        androidx.compose.foundation.b.y(index, " index: ", " isTerminated: ", sb);
                        sb.append(isTerminated(jResetTimeout));
                        sb.append(" isTimedOut: ");
                        sb.append(isTimedOut(jResetTimeout));
                        trace(logger3, sb.toString());
                    } else {
                        j5 = 0;
                    }
                    if (z12) {
                        this.currentTimeoutTask.update(null);
                        int i10 = 0;
                        do {
                            int iFlush = flush();
                            Logger logger4 = this.logger;
                            if (logger4 != null) {
                                trace(logger4, B7.a.h(iFlush, "flushed: "));
                            }
                            if (iFlush == 0) {
                                break;
                            }
                            i10 += iFlush;
                            if (jDecrementAndGet != Long.MAX_VALUE) {
                                jDecrementAndGet = REQUESTED.decrementAndGet(this);
                            }
                        } while (jDecrementAndGet != j5);
                        i6 = i10;
                        z11 = false;
                    }
                    boolean zIsTerminated = isTerminated(jResetTimeout);
                    if (i6 > 0) {
                        this.outstanding -= i6;
                    }
                    if (!zIsTerminated && jDecrementAndGet > j5 && (i = this.outstanding) < this.replenishMark) {
                        requestMore(this.prefetch - i);
                    }
                    if (zIsTerminated && this.queue.isEmpty()) {
                        this.done = true;
                        Logger logger5 = this.logger;
                        if (logger5 != null) {
                            trace(logger5, "terminated! error: " + this.error + " queue size: " + this.queue.size());
                        }
                        if (this.error != null) {
                            Operators.onDiscardQueueWithClear(this.queue, currentContext(), null);
                            this.actual.onError(this.error);
                        } else if (this.queue.isEmpty()) {
                            this.actual.onComplete();
                        }
                    }
                    if (i6 > 0) {
                        final int i11 = -i6;
                        forceUpdate(this, new Function() { // from class: reactor.core.publisher.H
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.lambda$drain$1(i11, (Long) obj);
                            }
                        });
                        jResetTimeout = resetTimeout(incrementIndex(jResetTimeout, i11));
                    }
                    if (!hasWorkInProgress(tryClearWip(this, jResetTimeout))) {
                        Logger logger6 = this.logger;
                        if (logger6 != null) {
                            trace(logger6, "drain done");
                            return;
                        }
                        return;
                    }
                    Logger logger7 = this.logger;
                    if (logger7 != null) {
                        trace(logger7, "drain repeat");
                    }
                }
            }
        }

        private static long forceAddWork(BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber, Function<Long, Long> function) {
            long j5;
            long jLongValue;
            BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber2;
            while (true) {
                j5 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                jLongValue = HAS_WORK_IN_PROGRESS_FLAG | function.apply(Long.valueOf(j5)).longValue();
                bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j5, jLongValue)) {
                    break;
                }
                bufferTimeoutWithBackpressureSubscriber = bufferTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
            if (stateLogger == null) {
                return j5;
            }
            stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "faw", j5, jLongValue);
            return j5;
        }

        private static long forceUpdate(BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber, Function<Long, Long> function) {
            long j5;
            long jLongValue;
            BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber2;
            while (true) {
                j5 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                jLongValue = function.apply(Long.valueOf(j5)).longValue();
                bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j5, jLongValue)) {
                    break;
                }
                bufferTimeoutWithBackpressureSubscriber = bufferTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
            if (stateLogger == null) {
                return jLongValue;
            }
            stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "fup", j5, jLongValue);
            return jLongValue;
        }

        private static long getIndex(long j5) {
            return j5 & INDEX_MASK;
        }

        private static boolean hasWorkInProgress(long j5) {
            return (j5 & HAS_WORK_IN_PROGRESS_FLAG) == HAS_WORK_IN_PROGRESS_FLAG;
        }

        private static long incrementIndex(long j5, int i) {
            return bitwiseIncrement(j5, INDEX_MASK, 0L, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long incrementRequestIndex(long j5) {
            return bitwiseIncrement(j5, REQUESTED_INDEX_MASK, 32L, 1);
        }

        private static boolean isCancelled(long j5) {
            return (j5 & Long.MIN_VALUE) == Long.MIN_VALUE;
        }

        private static boolean isTerminated(long j5) {
            return (j5 & 4611686018427387904L) == 4611686018427387904L;
        }

        private static boolean isTimedOut(long j5) {
            return (j5 & TIMEOUT_FLAG) == TIMEOUT_FLAG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$drain$1(int i, Long l) {
            return Long.valueOf(resetTimeout(incrementIndex(l.longValue(), i)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$onNext$0(Long l) {
            return Long.valueOf(incrementIndex(l.longValue(), 1));
        }

        private void requestMore(int i) {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, B7.a.h(i, "requestMore "));
            }
            this.outstanding += i;
            Z9.e eVar = this.subscription;
            Objects.requireNonNull(eVar);
            eVar.request(i);
        }

        private static long resetTimeout(long j5) {
            return j5 & (-1152921504606846977L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setCancelled(long j5) {
            return j5 | Long.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setTerminated(long j5) {
            return j5 | 4611686018427387904L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setTimedOut(long j5) {
            return j5 | TIMEOUT_FLAG;
        }

        private static long setWorkInProgress(long j5) {
            return j5 | HAS_WORK_IN_PROGRESS_FLAG;
        }

        private static void trace(Logger logger, String str) {
            logger.trace("[" + Thread.currentThread().getId() + "][" + str + "]");
        }

        private static <T, C extends Collection<? super T>> long tryClearWip(BufferTimeoutWithBackpressureSubscriber<T, C> bufferTimeoutWithBackpressureSubscriber, long j5) {
            while (true) {
                long j6 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                if (j5 != j6) {
                    return j6;
                }
                long j10 = j6 & (-3458764509525573633L);
                BufferTimeoutWithBackpressureSubscriber<T, C> bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j6, j10)) {
                    StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
                    if (stateLogger == null) {
                        return j10;
                    }
                    stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "wcl", j6, j10);
                    return j10;
                }
                bufferTimeoutWithBackpressureSubscriber = bufferTimeoutWithBackpressureSubscriber2;
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        public void bufferTimedOut() {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "timedOut");
            }
            if (this.done || hasWorkInProgress(forceAddWork(this, new C1885a(3)))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "cancel");
            }
            if (this.done || isCancelled(this.state)) {
                return;
            }
            Z9.e eVar = this.subscription;
            if (eVar != null) {
                eVar.cancel();
            }
            if (hasWorkInProgress(forceAddWork(this, new C1885a(6)))) {
                return;
            }
            drain(false);
        }

        public int flush() {
            T tPoll = this.queue.poll();
            int i = 0;
            if (tPoll == null) {
                return 0;
            }
            C c = this.bufferSupplier.get();
            do {
                c.add(tPoll);
                i++;
                if (i >= this.batchSize) {
                    break;
                }
                tPoll = this.queue.poll();
            } while (tPoll != null);
            this.actual.onNext(c);
            return i;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "onComplete");
            }
            if (this.done || hasWorkInProgress(forceAddWork(this, new C1885a(5)))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "onError " + th);
            }
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            if (hasWorkInProgress(forceAddWork(this, new C1885a(5)))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            long jForceAddWork;
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, androidx.appfunctions.metadata.a.j(t9, "onNext "));
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            boolean zOffer = this.queue.offer(t9);
            if (!zOffer) {
                this.error = Operators.onOperatorError(this.subscription, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.actual.currentContext());
                Operators.onDiscard(t9, this.actual.currentContext());
            }
            if (zOffer) {
                jForceAddWork = forceAddWork(this, new C1885a(7));
                if (getIndex(jForceAddWork) == 0) {
                    try {
                        this.currentTimeoutTask.update(this.timer.schedule(new G(this, 1), this.timeSpan, this.unit));
                    } catch (RejectedExecutionException e) {
                        this.error = Operators.onRejectedExecution(e, this.subscription, null, t9, this.actual.currentContext());
                        jForceAddWork = forceAddWork(this, new C1885a(5));
                    }
                }
            } else {
                jForceAddWork = forceAddWork(this, new C1885a(5));
            }
            if (hasWorkInProgress(jForceAddWork)) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.subscription, eVar)) {
                this.subscription = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, androidx.compose.foundation.b.p(j5, "request "));
            }
            if (Operators.validate(j5)) {
                long jAddCap = Operators.addCap(REQUESTED, this, j5);
                if (jAddCap == Long.MAX_VALUE || hasWorkInProgress(forceAddWork(this, new C1885a(4)))) {
                    return;
                }
                drain(jAddCap == 0);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.subscription : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled(this.state)) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isTerminated(this.state)) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.RUN_ON ? this.timer : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public FluxBufferTimeout(Flux<T> flux, int i, long j5, TimeUnit timeUnit, Scheduler scheduler, Supplier<C> supplier, boolean z10) {
        super(flux);
        if (j5 <= 0) {
            throw new IllegalArgumentException("Timeout period must be strictly positive");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize must be strictly positive");
        }
        Objects.requireNonNull(scheduler, "Timer");
        this.timer = scheduler;
        this.timespan = j5;
        Objects.requireNonNull(timeUnit, "unit");
        this.unit = timeUnit;
        this.batchSize = i;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
        this.fairBackpressure = z10;
        this.logger = null;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.timer : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        return this.fairBackpressure ? new BufferTimeoutWithBackpressureSubscriber(coreSubscriber, this.batchSize, this.timespan, this.unit, this.timer.createWorker(), this.bufferSupplier, null) : new BufferTimeoutSubscriber(Operators.serialize(coreSubscriber), this.batchSize, this.timespan, this.unit, this.timer.createWorker(), this.bufferSupplier);
    }

    public FluxBufferTimeout(Flux<T> flux, int i, long j5, TimeUnit timeUnit, Scheduler scheduler, Supplier<C> supplier, boolean z10, Logger logger) {
        super(flux);
        if (j5 <= 0) {
            throw new IllegalArgumentException("Timeout period must be strictly positive");
        }
        if (i > 0) {
            Objects.requireNonNull(scheduler, "Timer");
            this.timer = scheduler;
            this.timespan = j5;
            Objects.requireNonNull(timeUnit, "unit");
            this.unit = timeUnit;
            this.batchSize = i;
            Objects.requireNonNull(supplier, "bufferSupplier");
            this.bufferSupplier = supplier;
            this.fairBackpressure = z10;
            this.logger = logger;
            return;
        }
        throw new IllegalArgumentException("maxSize must be strictly positive");
    }
}
