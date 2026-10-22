package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
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
        protected qc.d subscription;
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
        final Runnable flushTask = new Runnable() { // from class: reactor.core.publisher.r0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                FluxBufferTimeout.BufferTimeoutSubscriber.a(this.f39792a);
            }
        };

        public BufferTimeoutSubscriber(CoreSubscriber<? super C> coreSubscriber, int i10, long j10, TimeUnit timeUnit, Scheduler.Worker worker, Supplier<C> supplier) {
            this.actual = coreSubscriber;
            this.timespan = j10;
            this.unit = timeUnit;
            this.timer = worker;
            this.batchSize = i10;
            this.bufferSupplier = supplier;
        }

        public static /* synthetic */ void a(BufferTimeoutSubscriber bufferTimeoutSubscriber) throws Throwable {
            int i10;
            if (bufferTimeoutSubscriber.terminated == 0) {
                do {
                    i10 = bufferTimeoutSubscriber.index;
                    if (i10 == 0) {
                        return;
                    }
                } while (!INDEX.compareAndSet(bufferTimeoutSubscriber, i10, 0));
                bufferTimeoutSubscriber.flushCallback(null);
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (TERMINATED.compareAndSet(this, 0, 3)) {
                this.timer.dispose();
                qc.d dVar = this.subscription;
                if (dVar != null) {
                    this.subscription = null;
                    dVar.cancel();
                }
                C c10 = this.values;
                if (c10 != null) {
                    Operators.onDiscardMultiple(c10, this.actual.currentContext());
                    c10.clear();
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

        public void nextCallback(T t10) {
            synchronized (this) {
                try {
                    if (OUTSTANDING.decrementAndGet(this) < 0) {
                        this.actual.onError(Exceptions.failWithOverflow("Unrequested element received"));
                        Context contextCurrentContext = this.actual.currentContext();
                        Operators.onDiscard(t10, contextCurrentContext);
                        Operators.onDiscardMultiple(this.values, contextCurrentContext);
                        return;
                    }
                    C c10 = this.values;
                    if (c10 == null) {
                        C c11 = this.bufferSupplier.get();
                        Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                        c10 = c11;
                        this.values = c10;
                    }
                    c10.add(t10);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (TERMINATED.compareAndSet(this, 0, 1)) {
                this.timer.dispose();
                checkedComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (TERMINATED.compareAndSet(this, 0, 2)) {
                this.timer.dispose();
                Context contextCurrentContext = this.actual.currentContext();
                synchronized (this) {
                    try {
                        C c10 = this.values;
                        if (c10 != null) {
                            Operators.onDiscardMultiple(c10, contextCurrentContext);
                            c10.clear();
                            this.values = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) throws Throwable {
            int i10;
            int i11;
            boolean z10;
            do {
                i10 = this.index;
                i11 = i10 + 1;
                z10 = i11 % this.batchSize == 0;
            } while (!INDEX.compareAndSet(this, i10, z10 ? 0 : i11));
            if (i11 == 1) {
                try {
                    this.timespanRegistration = this.timer.schedule(this.flushTask, this.timespan, this.unit);
                } catch (RejectedExecutionException e10) {
                    Context contextCurrentContext = this.actual.currentContext();
                    onError(Operators.onRejectedExecution(e10, this.subscription, null, t10, contextCurrentContext));
                    Operators.onDiscard(t10, contextCurrentContext);
                    return;
                }
            }
            nextCallback(t10);
            if (z10) {
                if (this.timespanRegistration != null) {
                    this.timespanRegistration.dispose();
                    this.timespanRegistration = null;
                }
                flushCallback(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                doOnSubscribe();
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                if (this.terminated != 0) {
                    return;
                }
                if (this.batchSize == Integer.MAX_VALUE || j10 == Long.MAX_VALUE) {
                    requestMore(Long.MAX_VALUE);
                    return;
                }
                long jMultiplyCap = Operators.multiplyCap(this.requested, this.batchSize);
                if (jMultiplyCap > this.outstanding) {
                    requestMore(jMultiplyCap - this.outstanding);
                }
            }
        }

        public final void requestMore(long j10) {
            qc.d dVar = this.subscription;
            if (dVar != null) {
                Operators.addCap(OUTSTANDING, this, j10);
                dVar.request(j10);
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
        private qc.d subscription;
        private final long timeSpan;
        private final Scheduler.Worker timer;
        private final TimeUnit unit;
        private static final AtomicLongFieldUpdater<BufferTimeoutWithBackpressureSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferTimeoutWithBackpressureSubscriber.class, "requested");
        private static final AtomicLongFieldUpdater<BufferTimeoutWithBackpressureSubscriber> STATE = AtomicLongFieldUpdater.newUpdater(BufferTimeoutWithBackpressureSubscriber.class, VoiceWakeupReceiver.EXTRA_STATE);

        public BufferTimeoutWithBackpressureSubscriber(CoreSubscriber<? super C> coreSubscriber, int i10, long j10, TimeUnit timeUnit, Scheduler.Worker worker, Supplier<C> supplier, @Nullable Logger logger) {
            this.actual = coreSubscriber;
            this.batchSize = i10;
            this.timeSpan = j10;
            this.unit = timeUnit;
            this.timer = worker;
            this.bufferSupplier = supplier;
            this.logger = logger;
            this.stateLogger = logger != null ? new StateLogger(logger) : null;
            int i11 = i10 << 2;
            this.prefetch = i11;
            this.replenishMark = i10 << 1;
            this.queue = (Queue) Queues.get(i11).get();
        }

        private static long bitwiseIncrement(long j10, long j11, long j12, int i10) {
            int i11 = (int) j12;
            return (j10 & (~j11)) | (((((j10 & j11) >> i11) + i10) << i11) & j11);
        }

        private void drain(boolean z10) {
            long j10;
            int i10;
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
                    int i11 = 0;
                    boolean z12 = jDecrementAndGet > 0 && (z11 || isTimedOut(jResetTimeout) || isTerminated(jResetTimeout) || index >= ((long) this.batchSize));
                    Logger logger3 = this.logger;
                    if (logger3 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        j10 = 0;
                        sb2.append("should flush: ");
                        sb2.append(z12);
                        sb2.append(" currentRequest: ");
                        sb2.append(jDecrementAndGet);
                        sb2.append(" index: ");
                        sb2.append(index);
                        sb2.append(" isTerminated: ");
                        sb2.append(isTerminated(jResetTimeout));
                        sb2.append(" isTimedOut: ");
                        sb2.append(isTimedOut(jResetTimeout));
                        trace(logger3, sb2.toString());
                    } else {
                        j10 = 0;
                    }
                    if (z12) {
                        this.currentTimeoutTask.update(null);
                        int i12 = 0;
                        do {
                            int iFlush = flush();
                            Logger logger4 = this.logger;
                            if (logger4 != null) {
                                trace(logger4, "flushed: " + iFlush);
                            }
                            if (iFlush == 0) {
                                break;
                            }
                            i12 += iFlush;
                            if (jDecrementAndGet != Long.MAX_VALUE) {
                                jDecrementAndGet = REQUESTED.decrementAndGet(this);
                            }
                        } while (jDecrementAndGet != j10);
                        i11 = i12;
                        z11 = false;
                    }
                    boolean zIsTerminated = isTerminated(jResetTimeout);
                    if (i11 > 0) {
                        this.outstanding -= i11;
                    }
                    if (!zIsTerminated && jDecrementAndGet > j10 && (i10 = this.outstanding) < this.replenishMark) {
                        requestMore(this.prefetch - i10);
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
                    if (i11 > 0) {
                        final int i13 = -i11;
                        forceUpdate(this, new Function() { // from class: reactor.core.publisher.v0
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.resetTimeout(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.incrementIndex(((Long) obj).longValue(), i13)));
                            }
                        });
                        jResetTimeout = resetTimeout(incrementIndex(jResetTimeout, i13));
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
            long j10;
            long jLongValue;
            BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber2;
            while (true) {
                j10 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                jLongValue = HAS_WORK_IN_PROGRESS_FLAG | function.apply(Long.valueOf(j10)).longValue();
                bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j10, jLongValue)) {
                    break;
                }
                bufferTimeoutWithBackpressureSubscriber = bufferTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
            if (stateLogger == null) {
                return j10;
            }
            stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "faw", j10, jLongValue);
            return j10;
        }

        private static long forceUpdate(BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber, Function<Long, Long> function) {
            long j10;
            long jLongValue;
            BufferTimeoutWithBackpressureSubscriber<?, ?> bufferTimeoutWithBackpressureSubscriber2;
            while (true) {
                j10 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                jLongValue = function.apply(Long.valueOf(j10)).longValue();
                bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j10, jLongValue)) {
                    break;
                }
                bufferTimeoutWithBackpressureSubscriber = bufferTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
            if (stateLogger == null) {
                return jLongValue;
            }
            stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "fup", j10, jLongValue);
            return jLongValue;
        }

        private static long getIndex(long j10) {
            return j10 & INDEX_MASK;
        }

        private static boolean hasWorkInProgress(long j10) {
            return (j10 & HAS_WORK_IN_PROGRESS_FLAG) == HAS_WORK_IN_PROGRESS_FLAG;
        }

        private static long incrementIndex(long j10, int i10) {
            return bitwiseIncrement(j10, INDEX_MASK, 0L, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long incrementRequestIndex(long j10) {
            return bitwiseIncrement(j10, REQUESTED_INDEX_MASK, 32L, 1);
        }

        private static boolean isCancelled(long j10) {
            return (j10 & CANCELLED_FLAG) == CANCELLED_FLAG;
        }

        private static boolean isTerminated(long j10) {
            return (j10 & TERMINATED_FLAG) == TERMINATED_FLAG;
        }

        private static boolean isTimedOut(long j10) {
            return (j10 & TIMEOUT_FLAG) == TIMEOUT_FLAG;
        }

        private void requestMore(int i10) {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "requestMore " + i10);
            }
            this.outstanding += i10;
            qc.d dVar = this.subscription;
            Objects.requireNonNull(dVar);
            dVar.request(i10);
        }

        private static long resetTimeout(long j10) {
            return j10 & (-1152921504606846977L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setCancelled(long j10) {
            return j10 | CANCELLED_FLAG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setTerminated(long j10) {
            return j10 | TERMINATED_FLAG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long setTimedOut(long j10) {
            return j10 | TIMEOUT_FLAG;
        }

        private static long setWorkInProgress(long j10) {
            return j10 | HAS_WORK_IN_PROGRESS_FLAG;
        }

        private static void trace(Logger logger, String str) {
            logger.trace(String.format("[%s][%s]", Long.valueOf(Thread.currentThread().getId()), str));
        }

        private static <T, C extends Collection<? super T>> long tryClearWip(BufferTimeoutWithBackpressureSubscriber<T, C> bufferTimeoutWithBackpressureSubscriber, long j10) {
            while (true) {
                long j11 = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber).state;
                if (j10 != j11) {
                    return j11;
                }
                long j12 = j11 & (-3458764509525573633L);
                BufferTimeoutWithBackpressureSubscriber<T, C> bufferTimeoutWithBackpressureSubscriber2 = bufferTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(bufferTimeoutWithBackpressureSubscriber2, j11, j12)) {
                    StateLogger stateLogger = ((BufferTimeoutWithBackpressureSubscriber) bufferTimeoutWithBackpressureSubscriber2).stateLogger;
                    if (stateLogger == null) {
                        return j12;
                    }
                    stateLogger.log(bufferTimeoutWithBackpressureSubscriber2.toString(), "wcl", j11, j12);
                    return j12;
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
            if (this.done || hasWorkInProgress(forceAddWork(this, new Function() { // from class: reactor.core.publisher.s0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setTimedOut(((Long) obj).longValue()));
                }
            }))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "cancel");
            }
            if (this.done || isCancelled(this.state)) {
                return;
            }
            qc.d dVar = this.subscription;
            if (dVar != null) {
                dVar.cancel();
            }
            if (hasWorkInProgress(forceAddWork(this, new Function() { // from class: reactor.core.publisher.w0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setCancelled(((Long) obj).longValue()));
                }
            }))) {
                return;
            }
            drain(false);
        }

        public int flush() {
            T tPoll = this.queue.poll();
            int i10 = 0;
            if (tPoll == null) {
                return 0;
            }
            C c10 = this.bufferSupplier.get();
            do {
                c10.add(tPoll);
                i10++;
                if (i10 >= this.batchSize) {
                    break;
                }
                tPoll = this.queue.poll();
            } while (tPoll != null);
            this.actual.onNext(c10);
            return i10;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "onComplete");
            }
            if (this.done || hasWorkInProgress(forceAddWork(this, new C5393u0()))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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
            if (hasWorkInProgress(forceAddWork(this, new C5393u0()))) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            long jForceAddWork;
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "onNext " + t10);
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            boolean zOffer = this.queue.offer(t10);
            if (!zOffer) {
                this.error = Operators.onOperatorError(this.subscription, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, this.actual.currentContext());
                Operators.onDiscard(t10, this.actual.currentContext());
            }
            if (zOffer) {
                jForceAddWork = forceAddWork(this, new Function() { // from class: reactor.core.publisher.x0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.incrementIndex(((Long) obj).longValue(), 1));
                    }
                });
                if (getIndex(jForceAddWork) == 0) {
                    try {
                        this.currentTimeoutTask.update(this.timer.schedule(new Runnable() { // from class: reactor.core.publisher.y0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f39820a.bufferTimedOut();
                            }
                        }, this.timeSpan, this.unit));
                    } catch (RejectedExecutionException e10) {
                        this.error = Operators.onRejectedExecution(e10, this.subscription, null, t10, this.actual.currentContext());
                        jForceAddWork = forceAddWork(this, new C5393u0());
                    }
                }
            } else {
                jForceAddWork = forceAddWork(this, new C5393u0());
            }
            if (hasWorkInProgress(jForceAddWork)) {
                return;
            }
            drain(false);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            Logger logger = this.logger;
            if (logger != null) {
                trace(logger, "request " + j10);
            }
            if (Operators.validate(j10)) {
                long jAddCap = Operators.addCap(REQUESTED, this, j10);
                if (jAddCap == Long.MAX_VALUE || hasWorkInProgress(forceAddWork(this, new Function() { // from class: reactor.core.publisher.t0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.incrementRequestIndex(((Long) obj).longValue()));
                    }
                }))) {
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

    public FluxBufferTimeout(Flux<T> flux, int i10, long j10, TimeUnit timeUnit, Scheduler scheduler, Supplier<C> supplier, boolean z10) {
        super(flux);
        if (j10 <= 0) {
            throw new IllegalArgumentException("Timeout period must be strictly positive");
        }
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize must be strictly positive");
        }
        Objects.requireNonNull(scheduler, "Timer");
        this.timer = scheduler;
        this.timespan = j10;
        Objects.requireNonNull(timeUnit, "unit");
        this.unit = timeUnit;
        this.batchSize = i10;
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

    public FluxBufferTimeout(Flux<T> flux, int i10, long j10, TimeUnit timeUnit, Scheduler scheduler, Supplier<C> supplier, boolean z10, Logger logger) {
        super(flux);
        if (j10 <= 0) {
            throw new IllegalArgumentException("Timeout period must be strictly positive");
        }
        if (i10 > 0) {
            Objects.requireNonNull(scheduler, "Timer");
            this.timer = scheduler;
            this.timespan = j10;
            Objects.requireNonNull(timeUnit, "unit");
            this.unit = timeUnit;
            this.batchSize = i10;
            Objects.requireNonNull(supplier, "bufferSupplier");
            this.bufferSupplier = supplier;
            this.fairBackpressure = z10;
            this.logger = logger;
            return;
        }
        throw new IllegalArgumentException("maxSize must be strictly positive");
    }
}
