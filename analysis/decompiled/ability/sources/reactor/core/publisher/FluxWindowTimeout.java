package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxWindowTimeout<T> extends InternalFluxOperator<T, Flux<T>> {
    final boolean fairBackpressure;
    final int maxSize;
    final Scheduler timer;
    final long timespan;
    final TimeUnit unit;

    public static final class InnerWindow<T> extends Flux<T> implements InnerProducer<T>, Runnable {
        static final long CANCELLED_STATE = 1152921504606846976L;
        static final long FINALIZED_STATE = Long.MIN_VALUE;
        static final long HAS_SUBSCRIBER_SET_STATE = 72057594037927936L;
        static final long HAS_SUBSCRIBER_STATE = 144115188075855872L;
        static final long HAS_VALUES_STATE = 288230376151711744L;
        static final long PARENT_CANCELLED_STATE = 2305843009213693952L;
        static final long RECEIVED_MASK = 36028797002186752L;
        static final long RECEIVED_SHIFT_BITS = 24;
        static final long TERMINATED_STATE = 4611686018427387904L;
        static final long TIMEOUT_STATE = 576460752303423488L;
        static final long UNSENT_STATE = 36028797018963968L;
        static final long WORK_IN_PROGRESS_MAX = 16777215;
        CoreSubscriber<? super T> actual;
        final long createTime;
        Throwable error;
        final int index;

        @Nullable
        final StateLogger logger;
        final int max;
        final WindowTimeoutWithBackpressureSubscriber<T> parent;
        final Queue<T> queue;
        volatile long requested;
        volatile long state;
        volatile Disposable timer;
        static final Disposable DISPOSED = Disposables.disposed();
        static final AtomicLongFieldUpdater<InnerWindow> REQUESTED = AtomicLongFieldUpdater.newUpdater(InnerWindow.class, "requested");
        static final AtomicLongFieldUpdater<InnerWindow> STATE = AtomicLongFieldUpdater.newUpdater(InnerWindow.class, "state");
        static final AtomicReferenceFieldUpdater<InnerWindow, Disposable> TIMER = AtomicReferenceFieldUpdater.newUpdater(InnerWindow.class, Disposable.class, "timer");
        int received = 0;
        int produced = 0;

        public InnerWindow(int i, WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber, int i6, boolean z10, @Nullable StateLogger stateLogger) {
            this.max = i;
            this.parent = windowTimeoutWithBackpressureSubscriber;
            this.queue = (Queue) Queues.get(i).get();
            this.index = i6;
            this.logger = stateLogger;
            if (z10) {
                STATE.lazySet(this, UNSENT_STATE);
                if (stateLogger != null) {
                    stateLogger.log(toString(), "mct", 0L, UNSENT_STATE);
                }
            } else if (stateLogger != null) {
                stateLogger.log(toString(), "mct", 0, 0);
            }
            this.createTime = windowTimeoutWithBackpressureSubscriber.now();
        }

        public static boolean hasSubscribedOnce(long j5) {
            return (j5 & HAS_SUBSCRIBER_STATE) == HAS_SUBSCRIBER_STATE;
        }

        public static boolean hasSubscriberSet(long j5) {
            return (j5 & HAS_SUBSCRIBER_SET_STATE) == HAS_SUBSCRIBER_SET_STATE;
        }

        public static boolean hasValues(long j5) {
            return (j5 & HAS_VALUES_STATE) == HAS_VALUES_STATE;
        }

        public static boolean hasWorkInProgress(long j5) {
            return (j5 & WORK_IN_PROGRESS_MAX) > 0;
        }

        public static long incrementReceived(long j5) {
            return ((j5 >> RECEIVED_SHIFT_BITS) + 1) << RECEIVED_SHIFT_BITS;
        }

        public static long incrementWork(long j5) {
            if (j5 == WORK_IN_PROGRESS_MAX) {
                return 1L;
            }
            return j5 + 1;
        }

        public static boolean isCancelled(long j5) {
            return (j5 & CANCELLED_STATE) == CANCELLED_STATE;
        }

        public static boolean isCancelledByParent(long j5) {
            return (j5 & PARENT_CANCELLED_STATE) == PARENT_CANCELLED_STATE;
        }

        public static boolean isFinalized(long j5) {
            return (j5 & Long.MIN_VALUE) == Long.MIN_VALUE;
        }

        public static boolean isSent(long j5) {
            return (j5 & UNSENT_STATE) == 0;
        }

        public static boolean isTerminated(long j5) {
            return (j5 & 4611686018427387904L) == 4611686018427387904L;
        }

        public static boolean isTimeout(long j5) {
            return (j5 & TIMEOUT_STATE) == TIMEOUT_STATE;
        }

        public static <T> long markCancelled(InnerWindow<T> innerWindow) {
            long j5;
            while (true) {
                j5 = innerWindow.state;
                if (isCancelled(j5) || isFinalized(j5)) {
                    break;
                }
                long jIncrementWork = incrementWork(WORK_IN_PROGRESS_MAX & j5) | ((-16777216) & j5) | 1224979098644774912L;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, jIncrementWork)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow2.toString(), "mcd", j5, jIncrementWork);
                        return j5;
                    }
                } else {
                    innerWindow = innerWindow2;
                }
            }
            return j5;
        }

        public static <T> long markHasRequest(InnerWindow<T> innerWindow) {
            long j5;
            while (true) {
                j5 = innerWindow.state;
                if (isCancelled(j5) || isFinalized(j5)) {
                    break;
                }
                long jIncrementWork = (hasValues(j5) ? incrementWork(WORK_IN_PROGRESS_MAX & j5) : 0L) | ((-16777216) & j5) | HAS_SUBSCRIBER_SET_STATE;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, jIncrementWork)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow2.toString(), "mhr", j5, jIncrementWork);
                        return j5;
                    }
                } else {
                    innerWindow = innerWindow2;
                }
            }
            return j5;
        }

        public static <T> long markHasValues(InnerWindow<T> innerWindow) {
            long j5;
            long jIncrementReceived;
            long jIncrementWork;
            while (true) {
                j5 = innerWindow.state;
                if (isFinalized(j5)) {
                    StateLogger stateLogger = innerWindow.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow.toString(), "fhv", j5, j5);
                        return j5;
                    }
                } else {
                    if (hasSubscriberSet(j5)) {
                        jIncrementReceived = incrementReceived(RECEIVED_MASK & j5) | HAS_VALUES_STATE | ((-36028797018963968L) & j5);
                        jIncrementWork = incrementWork(j5 & WORK_IN_PROGRESS_MAX);
                    } else {
                        jIncrementReceived = incrementReceived(RECEIVED_MASK & j5) | HAS_VALUES_STATE | ((-36028797018963968L) & j5);
                        jIncrementWork = hasWorkInProgress(j5) ? incrementWork(j5 & WORK_IN_PROGRESS_MAX) : 0L;
                    }
                    long j6 = jIncrementWork | jIncrementReceived;
                    InnerWindow<T> innerWindow2 = innerWindow;
                    boolean zCompareAndSet = STATE.compareAndSet(innerWindow2, j5, j6);
                    j5 = j5;
                    if (zCompareAndSet) {
                        StateLogger stateLogger2 = innerWindow2.logger;
                        if (stateLogger2 != null) {
                            stateLogger2.log(innerWindow2.toString(), "mhv", j5, j6);
                        }
                    } else {
                        innerWindow = innerWindow2;
                    }
                }
            }
            return j5;
        }

        public static <T> long markHasValuesAndTerminated(InnerWindow<T> innerWindow) {
            long j5;
            long jIncrementReceived;
            long jIncrementWork;
            while (true) {
                j5 = innerWindow.state;
                if (isFinalized(j5)) {
                    StateLogger stateLogger = innerWindow.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow.toString(), "fht", j5, j5);
                        return j5;
                    }
                } else {
                    long j6 = (-36028797018963968L) & j5;
                    if (hasSubscriberSet(j5)) {
                        jIncrementReceived = j6 | 4899916394579099648L | incrementReceived(RECEIVED_MASK & j5);
                        jIncrementWork = incrementWork(WORK_IN_PROGRESS_MAX & j5);
                    } else {
                        jIncrementReceived = j6 | 4899916394579099648L | incrementReceived(RECEIVED_MASK & j5);
                        jIncrementWork = hasWorkInProgress(j5) ? incrementWork(WORK_IN_PROGRESS_MAX & j5) : 0L;
                    }
                    long j10 = jIncrementReceived | jIncrementWork;
                    InnerWindow<T> innerWindow2 = innerWindow;
                    boolean zCompareAndSet = STATE.compareAndSet(innerWindow2, j5, j10);
                    j5 = j5;
                    if (zCompareAndSet) {
                        StateLogger stateLogger2 = innerWindow2.logger;
                        if (stateLogger2 != null) {
                            stateLogger2.log(innerWindow2.toString(), "hvt", j5, j10);
                        }
                    } else {
                        innerWindow = innerWindow2;
                    }
                }
            }
            return j5;
        }

        public static <T> long markSent(InnerWindow<T> innerWindow) {
            while (true) {
                long j5 = innerWindow.state;
                if (isCancelled(j5)) {
                    return j5;
                }
                long j6 = UNSENT_STATE ^ j5;
                if (isTimeout(j5) || isTerminated(j5)) {
                    jIncrementWork = (hasSubscriberSet(j5) ? hasValues(j5) ? incrementWork(WORK_IN_PROGRESS_MAX & j5) : Long.MIN_VALUE : 0L) | 4611686018427387904L;
                }
                long j10 = j6 | jIncrementWork;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, j10)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger == null) {
                        return j5;
                    }
                    stateLogger.log(innerWindow2.toString(), "mst", j5, j10);
                    return j5;
                }
                innerWindow = innerWindow2;
            }
        }

        public static <T> long markSubscribedOnce(InnerWindow<T> innerWindow) {
            while (true) {
                long j5 = innerWindow.state;
                if (hasSubscribedOnce(j5)) {
                    return j5;
                }
                long j6 = j5 | HAS_SUBSCRIBER_STATE;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, j6)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger == null) {
                        return j5;
                    }
                    stateLogger.log(innerWindow2.toString(), "mso", j5, j6);
                    return j5;
                }
                innerWindow = innerWindow2;
            }
        }

        public static <T> long markSubscriberSet(InnerWindow<T> innerWindow) {
            long j5;
            while (true) {
                j5 = innerWindow.state;
                if (isFinalized(j5) || hasWorkInProgress(j5)) {
                    break;
                }
                long j6 = ((!isTerminated(j5) || hasValues(j5)) ? 0L : Long.MIN_VALUE) | HAS_SUBSCRIBER_SET_STATE | j5;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, j6)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow2.toString(), "mss", j5, j6);
                        return j5;
                    }
                } else {
                    innerWindow = innerWindow2;
                }
            }
            return j5;
        }

        public static <T> long markTerminated(InnerWindow<T> innerWindow) {
            long j5;
            while (true) {
                j5 = innerWindow.state;
                if (isFinalized(j5) || isTerminated(j5)) {
                    break;
                }
                long jIncrementWork = (hasSubscriberSet(j5) ? hasValues(j5) ? incrementWork(WORK_IN_PROGRESS_MAX & j5) : Long.MIN_VALUE : 0L) | ((-16777216) & j5) | 4611686018427387904L;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, jIncrementWork)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger != null) {
                        stateLogger.log(innerWindow2.toString(), "mtd", j5, jIncrementWork);
                        return j5;
                    }
                } else {
                    innerWindow = innerWindow2;
                }
            }
            return j5;
        }

        public static <T> long markTimeout(InnerWindow<T> innerWindow) {
            while (true) {
                long j5 = innerWindow.state;
                if (isTerminated(j5)) {
                    return j5;
                }
                long j6 = j5 | TIMEOUT_STATE;
                InnerWindow<T> innerWindow2 = innerWindow;
                if (STATE.compareAndSet(innerWindow2, j5, j6)) {
                    StateLogger stateLogger = innerWindow2.logger;
                    if (stateLogger == null) {
                        return j5;
                    }
                    stateLogger.log(innerWindow2.toString(), "mtt", j5, j6);
                    return j5;
                }
                innerWindow = innerWindow2;
            }
        }

        public static <T> long markWorkDone(InnerWindow<T> innerWindow, long j5, boolean z10) {
            long j6 = innerWindow.state;
            if (j5 != j6) {
                return j6;
            }
            long j10 = ((z10 ? 0L : HAS_VALUES_STATE) ^ j6) & (-16777216);
            if (!STATE.compareAndSet(innerWindow, j6, j10)) {
                return innerWindow.state;
            }
            StateLogger stateLogger = innerWindow.logger;
            if (stateLogger == null) {
                return j10;
            }
            stateLogger.log(innerWindow.toString(), "mwd", j6, j10);
            return j10;
        }

        public static long received(long j5) {
            return (j5 & RECEIVED_MASK) >> RECEIVED_SHIFT_BITS;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            long jMarkCancelled = markCancelled(this);
            if (isCancelled(jMarkCancelled) || isFinalized(jMarkCancelled) || hasWorkInProgress(jMarkCancelled)) {
                return;
            }
            clearAndFinalize();
        }

        public boolean checkTerminated(int i, CoreSubscriber<? super T> coreSubscriber, @Nullable T t9) {
            long j5 = this.state;
            if (isCancelled(j5)) {
                if (t9 != null) {
                    Operators.onDiscard(t9, coreSubscriber.currentContext());
                }
                clearAndFinalize();
                return true;
            }
            if (t9 != null || received(j5) > i || !isTerminated(j5) || !markFinalized(j5)) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
            return true;
        }

        public void clearAndFinalize() {
            while (true) {
                long j5 = this.state;
                this.clearQueue();
                if (isFinalized(j5)) {
                    return;
                }
                InnerWindow<T> innerWindow = this;
                if (STATE.compareAndSet(innerWindow, j5, (hasValues(j5) ? HAS_VALUES_STATE : 0L) ^ ((Long.MIN_VALUE | j5) & (-16777216)))) {
                    return;
                } else {
                    this = innerWindow;
                }
            }
        }

        public void clearQueue() {
            Queue<T> queue = this.queue;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            Context contextCurrentContext = coreSubscriber != null ? coreSubscriber.currentContext() : this.parent.currentContext();
            while (true) {
                T tPoll = queue.poll();
                if (tPoll == null) {
                    return;
                } else {
                    Operators.onDiscard(tPoll, contextCurrentContext);
                }
            }
        }

        public void drain(long j5) {
            Queue<T> queue = this.queue;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            do {
                long j6 = this.requested;
                int i = 0;
                boolean z10 = false;
                while (true) {
                    if (i >= j6) {
                        break;
                    }
                    T tPoll = queue.poll();
                    boolean z11 = tPoll == null;
                    if (checkTerminated(this.produced + i, coreSubscriber, tPoll)) {
                        return;
                    }
                    if (z11) {
                        z10 = z11;
                        break;
                    } else {
                        coreSubscriber.onNext(tPoll);
                        i++;
                        z10 = z11;
                    }
                }
                int i6 = this.produced + i;
                this.produced = i6;
                if (checkTerminated(i6, coreSubscriber, null)) {
                    return;
                }
                if (i != 0 && j6 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -i);
                }
                j5 = markWorkDone(this, j5, !z10);
                if (isCancelled(j5)) {
                    clearAndFinalize();
                    return;
                }
            } while (hasWorkInProgress(j5));
        }

        public boolean markFinalized(long j5) {
            return STATE.compareAndSet(this, j5, ((Long.MIN_VALUE | j5) & (-16777216)) ^ (hasValues(j5) ? HAS_VALUES_STATE : 0L));
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Operators.addCap(REQUESTED, this, j5);
            long jMarkHasRequest = markHasRequest(this);
            if (hasWorkInProgress(jMarkHasRequest) || isCancelled(jMarkHasRequest) || isFinalized(jMarkHasRequest) || !hasValues(jMarkHasRequest)) {
                return;
            }
            drain((jMarkHasRequest | HAS_SUBSCRIBER_SET_STATE) + 1);
        }

        @Override // java.lang.Runnable
        public void run() {
            long jMarkTimeout = markTimeout(this);
            if (isTerminated(jMarkTimeout) || isCancelledByParent(jMarkTimeout)) {
                return;
            }
            this.parent.tryCreateNextWindow(this.index);
        }

        public void scheduleTimeout() {
            Disposable disposableSchedule = this.parent.schedule(this, this.createTime);
            if (TIMER.compareAndSet(this, null, disposableSchedule)) {
                return;
            }
            disposableSchedule.dispose();
        }

        public long sendCancel() {
            long j5;
            Disposable andSet;
            while (true) {
                j5 = this.state;
                if (isCancelledByParent(j5)) {
                    break;
                }
                long jIncrementWork = (hasSubscriberSet(j5) ? hasValues(j5) ? incrementWork(WORK_IN_PROGRESS_MAX & j5) : Long.MIN_VALUE : 0L) | ((-16777216) & j5) | 6917529027641081856L;
                InnerWindow<T> innerWindow = this;
                if (!STATE.compareAndSet(innerWindow, j5, jIncrementWork)) {
                    this = innerWindow;
                } else if (!isFinalized(j5)) {
                    if (!isTimeout(j5) && (andSet = TIMER.getAndSet(innerWindow, DISPOSED)) != null) {
                        andSet.dispose();
                    }
                    if (hasSubscriberSet(j5) && !hasWorkInProgress(j5)) {
                        if (isCancelled(j5)) {
                            innerWindow.clearAndFinalize();
                            return j5;
                        }
                        if (hasValues(j5)) {
                            innerWindow.drain(jIncrementWork);
                            return j5;
                        }
                        innerWindow.actual.onComplete();
                    }
                }
            }
            return j5;
        }

        public long sendComplete() {
            Disposable andSet;
            long jMarkTerminated = markTerminated(this);
            if (!isFinalized(jMarkTerminated) && !isTerminated(jMarkTerminated)) {
                if (!isTimeout(jMarkTerminated) && (andSet = TIMER.getAndSet(this, DISPOSED)) != null) {
                    andSet.dispose();
                }
                if (hasSubscriberSet(jMarkTerminated) && !hasWorkInProgress(jMarkTerminated)) {
                    if (isCancelled(jMarkTerminated)) {
                        clearAndFinalize();
                        return jMarkTerminated;
                    }
                    if (hasValues(jMarkTerminated)) {
                        drain((4611686018427387904L | jMarkTerminated) + 1);
                        return jMarkTerminated;
                    }
                    this.actual.onComplete();
                }
            }
            return jMarkTerminated;
        }

        public long sendError(Throwable th) {
            Disposable andSet;
            this.error = th;
            long jMarkTerminated = markTerminated(this);
            if (!isFinalized(jMarkTerminated) && !isTerminated(jMarkTerminated)) {
                if (!isTimeout(jMarkTerminated) && (andSet = TIMER.getAndSet(this, DISPOSED)) != null) {
                    andSet.dispose();
                }
                if (hasSubscriberSet(jMarkTerminated) && !hasWorkInProgress(jMarkTerminated)) {
                    if (isCancelled(jMarkTerminated)) {
                        clearAndFinalize();
                        return jMarkTerminated;
                    }
                    if (hasValues(jMarkTerminated)) {
                        drain((4611686018427387904L | jMarkTerminated) + 1);
                        return jMarkTerminated;
                    }
                    this.actual.onError(th);
                }
            }
            return jMarkTerminated;
        }

        public boolean sendNext(T t9) {
            long jMarkHasValues;
            long j5;
            int i = this.received + 1;
            if (i > this.max) {
                return false;
            }
            this.received = i;
            this.queue.offer(t9);
            if (i == this.max) {
                jMarkHasValues = markHasValuesAndTerminated(this);
                j5 = (4899916394579099648L | jMarkHasValues) + 1;
                if (!isTimeout(jMarkHasValues)) {
                    Disposable andSet = TIMER.getAndSet(this, DISPOSED);
                    if (andSet != null) {
                        andSet.dispose();
                    }
                    if (!isCancelledByParent(jMarkHasValues)) {
                        this.parent.tryCreateNextWindow(this.index);
                    }
                }
            } else {
                jMarkHasValues = markHasValues(this);
                j5 = (HAS_VALUES_STATE | jMarkHasValues) + 1;
            }
            if (isFinalized(jMarkHasValues)) {
                if (isCancelledByParent(jMarkHasValues)) {
                    clearQueue();
                    return true;
                }
                if (isCancelled(jMarkHasValues)) {
                    clearQueue();
                    this.parent.f5827s.request(1L);
                    return true;
                }
                if (this.queue.poll() == t9) {
                    return false;
                }
                this.parent.f5827s.request(1L);
                return true;
            }
            if (isTimeout(jMarkHasValues) && isTerminated(jMarkHasValues)) {
                this.parent.f5827s.request(1L);
            }
            if (!hasSubscriberSet(jMarkHasValues) || hasWorkInProgress(jMarkHasValues)) {
                return true;
            }
            if (isCancelled(jMarkHasValues)) {
                clearAndFinalize();
                return true;
            }
            drain(j5);
            return true;
        }

        public long sendSent() {
            long jMarkSent = markSent(this);
            if (!isFinalized(jMarkSent) && ((isTerminated(jMarkSent) || isTimeout(jMarkSent)) && hasSubscriberSet(jMarkSent) && !hasWorkInProgress(jMarkSent))) {
                if (isCancelled(jMarkSent)) {
                    clearAndFinalize();
                    return jMarkSent;
                }
                if (hasValues(jMarkSent)) {
                    drain(((UNSENT_STATE ^ jMarkSent) | 4611686018427387904L) + 1);
                    return jMarkSent;
                }
                this.actual.onComplete();
            }
            return jMarkSent;
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            if (hasSubscribedOnce(markSubscribedOnce(this))) {
                Operators.error(coreSubscriber, new IllegalStateException("Only one subscriber allowed"));
                return;
            }
            this.actual = coreSubscriber;
            coreSubscriber.onSubscribe(this);
            long jMarkSubscriberSet = markSubscriberSet(this);
            if (isFinalized(jMarkSubscriberSet) || hasWorkInProgress(jMarkSubscriberSet) || hasValues(jMarkSubscriberSet) || !isTerminated(jMarkSubscriberSet)) {
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.publisher.Flux
        public String toString() {
            return super.toString() + " " + this.index;
        }
    }

    public static final class WindowTimeoutSubscriber<T> implements InnerOperator<T, Flux<T>> {
        final CoreSubscriber<? super Flux<T>> actual;
        volatile boolean cancelled;
        int count;
        volatile boolean done;
        Throwable error;
        final int maxSize;
        long producerIndex;
        final Queue<Object> queue = (Queue) Queues.unboundedMultiproducer().get();
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5826s;
        final Scheduler scheduler;
        volatile boolean terminated;
        volatile Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Sinks.Many<T> window;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicLongFieldUpdater<WindowTimeoutSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(WindowTimeoutSubscriber.class, "requested");
        static final AtomicIntegerFieldUpdater<WindowTimeoutSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(WindowTimeoutSubscriber.class, "wip");
        static final AtomicReferenceFieldUpdater<WindowTimeoutSubscriber, Disposable> TIMER = AtomicReferenceFieldUpdater.newUpdater(WindowTimeoutSubscriber.class, Disposable.class, "timer");

        public static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowTimeoutSubscriber<?> parent;

            public ConsumerIndexHolder(long j5, WindowTimeoutSubscriber<?> windowTimeoutSubscriber) {
                this.index = j5;
                this.parent = windowTimeoutSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowTimeoutSubscriber<?> windowTimeoutSubscriber = this.parent;
                if (windowTimeoutSubscriber.cancelled) {
                    windowTimeoutSubscriber.terminated = true;
                    windowTimeoutSubscriber.timer.dispose();
                    windowTimeoutSubscriber.worker.dispose();
                } else {
                    windowTimeoutSubscriber.queue.offer(this);
                }
                if (windowTimeoutSubscriber.enter()) {
                    windowTimeoutSubscriber.drainLoop();
                }
            }
        }

        public WindowTimeoutSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, int i, long j5, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.timespan = j5;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.maxSize = i;
            this.worker = scheduler.createWorker();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.cancelled = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            Queue<Object> queue = this.queue;
            CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
            Sinks.Many<T> manyOnBackpressureBuffer = this.window;
            int iAddAndGet = 1;
            while (!this.terminated) {
                boolean z10 = this.done;
                Object objPoll = queue.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof ConsumerIndexHolder;
                if (z10 && (z11 || z12)) {
                    this.window = null;
                    queue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        manyOnBackpressureBuffer.emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
                    } else {
                        manyOnBackpressureBuffer.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                    }
                    this.timer.dispose();
                    this.worker.dispose();
                    return;
                }
                if (z11) {
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (z12) {
                    manyOnBackpressureBuffer.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                    this.count = 0;
                    manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer();
                    this.window = manyOnBackpressureBuffer;
                    long j5 = this.requested;
                    if (j5 == 0) {
                        this.window = null;
                        this.queue.clear();
                        coreSubscriber.onError(Operators.onOperatorError(this.f5826s, Exceptions.failWithOverflow(), this.actual.currentContext()));
                        this.timer.dispose();
                        this.worker.dispose();
                        return;
                    }
                    coreSubscriber.onNext(manyOnBackpressureBuffer.asFlux());
                    if (j5 != Long.MAX_VALUE) {
                        REQUESTED.decrementAndGet(this);
                    }
                } else {
                    Sinks.EmitFailureHandler emitFailureHandler = Sinks.EmitFailureHandler.FAIL_FAST;
                    manyOnBackpressureBuffer.emitNext(objPoll, emitFailureHandler);
                    int i = this.count + 1;
                    if (i >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        manyOnBackpressureBuffer.emitComplete(emitFailureHandler);
                        long j6 = this.requested;
                        if (j6 == 0) {
                            this.window = null;
                            coreSubscriber.onError(Operators.onOperatorError(this.f5826s, Exceptions.failWithOverflow(), objPoll, this.actual.currentContext()));
                            this.timer.dispose();
                            this.worker.dispose();
                            return;
                        }
                        manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer();
                        this.window = manyOnBackpressureBuffer;
                        this.actual.onNext(manyOnBackpressureBuffer.asFlux());
                        if (j6 != Long.MAX_VALUE) {
                            REQUESTED.decrementAndGet(this);
                        }
                        Disposable disposable = this.timer;
                        disposable.dispose();
                        Disposable disposableNewPeriod = newPeriod();
                        if (!TIMER.compareAndSet(this, disposable, disposableNewPeriod)) {
                            disposableNewPeriod.dispose();
                        }
                    } else {
                        this.count = i;
                    }
                }
            }
            this.f5826s.cancel();
            queue.clear();
            this.timer.dispose();
            this.worker.dispose();
        }

        public boolean enter() {
            return WIP.getAndIncrement(this) == 0;
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            Sinks.Many<T> many = this.window;
            return many == null ? Stream.empty() : Stream.of(Scannable.from(many));
        }

        public Disposable newPeriod() {
            try {
                Scheduler.Worker worker = this.worker;
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                long j5 = this.timespan;
                return worker.schedulePeriodically(consumerIndexHolder, j5, j5, this.unit);
            } catch (Exception e) {
                CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e, this.f5826s, null, null, coreSubscriber.currentContext()));
                return Disposables.disposed();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            this.timer.dispose();
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            this.timer.dispose();
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.terminated) {
                return;
            }
            AtomicIntegerFieldUpdater<WindowTimeoutSubscriber> atomicIntegerFieldUpdater = WIP;
            if (atomicIntegerFieldUpdater.get(this) == 0 && atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                Sinks.Many<T> many = this.window;
                Sinks.EmitFailureHandler emitFailureHandler = Sinks.EmitFailureHandler.FAIL_FAST;
                many.emitNext(t9, emitFailureHandler);
                int i = this.count + 1;
                if (i >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0;
                    many.emitComplete(emitFailureHandler);
                    long j5 = this.requested;
                    if (j5 == 0) {
                        this.window = null;
                        this.actual.onError(Operators.onOperatorError(this.f5826s, Exceptions.failWithOverflow(), t9, this.actual.currentContext()));
                        this.timer.dispose();
                        this.worker.dispose();
                        return;
                    }
                    Sinks.Many<T> manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer();
                    this.window = manyOnBackpressureBuffer;
                    this.actual.onNext(manyOnBackpressureBuffer.asFlux());
                    if (j5 != Long.MAX_VALUE) {
                        REQUESTED.decrementAndGet(this);
                    }
                    Disposable disposable = this.timer;
                    disposable.dispose();
                    Disposable disposableNewPeriod = newPeriod();
                    if (!TIMER.compareAndSet(this, disposable, disposableNewPeriod)) {
                        disposableNewPeriod.dispose();
                    }
                } else {
                    this.count = i;
                }
                if (atomicIntegerFieldUpdater.decrementAndGet(this) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t9);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5826s, eVar)) {
                this.f5826s = eVar;
                CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
                coreSubscriber.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                Sinks.Many<T> manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer();
                this.window = manyOnBackpressureBuffer;
                long j5 = this.requested;
                if (j5 == 0) {
                    coreSubscriber.onError(Operators.onOperatorError(eVar, Exceptions.failWithOverflow(), this.actual.currentContext()));
                    return;
                }
                coreSubscriber.onNext(manyOnBackpressureBuffer.asFlux());
                if (j5 != Long.MAX_VALUE) {
                    REQUESTED.decrementAndGet(this);
                }
                if (OperatorDisposables.replace(TIMER, this, newPeriod())) {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5826s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.CAPACITY ? Integer.valueOf(this.maxSize) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public static final class WindowTimeoutWithBackpressureSubscriber<T> implements InnerOperator<T, Flux<T>> {
        static final long ACTIVE_WINDOW_INDEX_MASK = 1099510579200L;
        static final int ACTIVE_WINDOW_INDEX_SHIFT = 20;
        static final long CANCELLED_FLAG = Long.MIN_VALUE;
        static final long HAS_UNSENT_WINDOW = 2305843009213693952L;
        static final long HAS_WORK_IN_PROGRESS = 1152921504606846976L;
        static final long NEXT_WINDOW_INDEX_MASK = 1048575;
        static final long REQUEST_INDEX_MASK = 1152920405095219200L;
        static final int REQUEST_INDEX_SHIFT = 40;
        static final long TERMINATED_FLAG = 4611686018427387904L;
        final CoreSubscriber<? super Flux<T>> actual;
        boolean done;
        Throwable error;
        final int limit;

        @Nullable
        final StateLogger logger;
        final int maxSize;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5827s;
        final Scheduler scheduler;
        volatile long state;
        final long timespan;
        final TimeUnit unit;
        InnerWindow<T> window;
        final Scheduler.Worker worker;
        static final AtomicLongFieldUpdater<WindowTimeoutWithBackpressureSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(WindowTimeoutWithBackpressureSubscriber.class, "requested");
        static final AtomicLongFieldUpdater<WindowTimeoutWithBackpressureSubscriber> STATE = AtomicLongFieldUpdater.newUpdater(WindowTimeoutWithBackpressureSubscriber.class, "state");

        public WindowTimeoutWithBackpressureSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, int i, long j5, TimeUnit timeUnit, Scheduler scheduler, @Nullable StateLogger stateLogger) {
            this.actual = coreSubscriber;
            this.timespan = j5;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.maxSize = i;
            this.limit = Operators.unboundedOrLimit(i);
            this.worker = scheduler.createWorker();
            this.logger = stateLogger;
            STATE.lazySet(this, 1L);
        }

        public static int activeWindowIndex(long j5) {
            return (int) ((j5 & ACTIVE_WINDOW_INDEX_MASK) >> 20);
        }

        public static <T> long commitSent(WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber, long j5) {
            long j6;
            long j10;
            WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2;
            while (true) {
                j6 = windowTimeoutWithBackpressureSubscriber.state;
                j10 = (j5 == j6 ? HAS_WORK_IN_PROGRESS : 0L) ^ ((-2305843009213693953L) & j6);
                windowTimeoutWithBackpressureSubscriber2 = windowTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j6, j10)) {
                    break;
                }
                windowTimeoutWithBackpressureSubscriber = windowTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = windowTimeoutWithBackpressureSubscriber2.logger;
            if (stateLogger == null) {
                return j6;
            }
            stateLogger.log(windowTimeoutWithBackpressureSubscriber2.toString(), "cts", j6, j10);
            return j6;
        }

        public static <T> long commitWork(WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber, long j5, boolean z10) {
            long j6;
            long jIncrementActiveWindowIndex;
            WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2;
            while (true) {
                j6 = windowTimeoutWithBackpressureSubscriber.state;
                jIncrementActiveWindowIndex = (((-2305844108724273153L) & j6) ^ (j5 == j6 ? HAS_WORK_IN_PROGRESS : 0L)) | incrementActiveWindowIndex(j6) | (z10 ? HAS_UNSENT_WINDOW : 0L);
                windowTimeoutWithBackpressureSubscriber2 = windowTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j6, jIncrementActiveWindowIndex)) {
                    break;
                }
                windowTimeoutWithBackpressureSubscriber = windowTimeoutWithBackpressureSubscriber2;
            }
            StateLogger stateLogger = windowTimeoutWithBackpressureSubscriber2.logger;
            if (stateLogger == null) {
                return j6;
            }
            stateLogger.log(windowTimeoutWithBackpressureSubscriber2.toString(), "ctw", j6, jIncrementActiveWindowIndex);
            return j6;
        }

        public static boolean hasUnsentWindow(long j5) {
            return (j5 & HAS_UNSENT_WINDOW) == HAS_UNSENT_WINDOW;
        }

        public static boolean hasWorkInProgress(long j5) {
            return (j5 & HAS_WORK_IN_PROGRESS) == HAS_WORK_IN_PROGRESS;
        }

        public static long incrementActiveWindowIndex(long j5) {
            return ((((j5 & ACTIVE_WINDOW_INDEX_MASK) >> 20) + 1) << 20) & ACTIVE_WINDOW_INDEX_MASK;
        }

        public static long incrementNextWindowIndex(long j5) {
            return ((j5 & NEXT_WINDOW_INDEX_MASK) + 1) & NEXT_WINDOW_INDEX_MASK;
        }

        public static long incrementRequestIndex(long j5) {
            return ((((j5 & REQUEST_INDEX_MASK) >> 40) + 1) << 40) & REQUEST_INDEX_MASK;
        }

        public static boolean isCancelled(long j5) {
            return (j5 & Long.MIN_VALUE) == Long.MIN_VALUE;
        }

        public static boolean isTerminated(long j5) {
            return (j5 & 4611686018427387904L) == 4611686018427387904L;
        }

        public static <T> long markCancelled(WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber) {
            long j5;
            while (true) {
                j5 = windowTimeoutWithBackpressureSubscriber.state;
                if ((!hasWorkInProgress(j5) && isTerminated(j5) && !hasUnsentWindow(j5)) || isCancelled(j5)) {
                    break;
                }
                WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2 = windowTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j5, j5 | Long.MIN_VALUE)) {
                    break;
                }
                windowTimeoutWithBackpressureSubscriber = windowTimeoutWithBackpressureSubscriber2;
            }
            return j5;
        }

        public static <T> long markTerminated(WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber) {
            long j5;
            while (true) {
                j5 = windowTimeoutWithBackpressureSubscriber.state;
                if (isTerminated(j5) || isCancelled(j5)) {
                    break;
                }
                long j6 = j5 | 4611686018427387904L;
                WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2 = windowTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j5, j6)) {
                    StateLogger stateLogger = windowTimeoutWithBackpressureSubscriber2.logger;
                    if (stateLogger != null) {
                        stateLogger.log(windowTimeoutWithBackpressureSubscriber2.toString(), "mtd", j5, j6);
                        return j5;
                    }
                } else {
                    windowTimeoutWithBackpressureSubscriber = windowTimeoutWithBackpressureSubscriber2;
                }
            }
            return j5;
        }

        public static <T> long markWorkDone(WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber, long j5) {
            while (true) {
                long j6 = windowTimeoutWithBackpressureSubscriber.state;
                if (j5 != j6) {
                    StateLogger stateLogger = windowTimeoutWithBackpressureSubscriber.logger;
                    if (stateLogger != null) {
                        stateLogger.log(windowTimeoutWithBackpressureSubscriber.toString(), "fwd", j6, j6);
                    }
                    return j6;
                }
                long j10 = j6 ^ HAS_WORK_IN_PROGRESS;
                WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2 = windowTimeoutWithBackpressureSubscriber;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j6, j10)) {
                    StateLogger stateLogger2 = windowTimeoutWithBackpressureSubscriber2.logger;
                    if (stateLogger2 != null) {
                        stateLogger2.log(windowTimeoutWithBackpressureSubscriber2.toString(), "mwd", j6, j10);
                    }
                    return j10;
                }
                windowTimeoutWithBackpressureSubscriber = windowTimeoutWithBackpressureSubscriber2;
            }
        }

        public static int nextWindowIndex(long j5) {
            return (int) (j5 & NEXT_WINDOW_INDEX_MASK);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            long jMarkCancelled = markCancelled(this);
            if ((hasWorkInProgress(jMarkCancelled) || !isTerminated(jMarkCancelled) || hasUnsentWindow(jMarkCancelled)) && !isCancelled(jMarkCancelled)) {
                this.f5827s.cancel();
                InnerWindow<T> innerWindow = this.window;
                if (innerWindow == null || InnerWindow.isSent(innerWindow.sendCancel()) || hasWorkInProgress(jMarkCancelled)) {
                    return;
                }
                innerWindow.cancel();
            }
        }

        public void drain(long j5, long j6) {
            long jCommitWork;
            long jIncrementActiveWindowIndex;
            long jIncrementActiveWindowIndex2;
            long j10;
            long j11 = j5;
            long jMarkWorkDone = j6;
            while (true) {
                long j12 = this.requested;
                StateLogger stateLogger = this.logger;
                if (stateLogger != null) {
                    stateLogger.log(toString(), androidx.compose.foundation.b.p(j12, "dr"), j11, jMarkWorkDone);
                }
                boolean zHasUnsentWindow = hasUnsentWindow(j11);
                int iActiveWindowIndex = activeWindowIndex(jMarkWorkDone);
                int iNextWindowIndex = nextWindowIndex(jMarkWorkDone);
                long j13 = HAS_WORK_IN_PROGRESS;
                if (iActiveWindowIndex != iNextWindowIndex || zHasUnsentWindow) {
                    long j14 = HAS_UNSENT_WINDOW;
                    if (j12 > 0) {
                        if (zHasUnsentWindow) {
                            InnerWindow<T> innerWindow = this.window;
                            this.actual.onNext(innerWindow);
                            if (j12 != Long.MAX_VALUE) {
                                long jDecrementAndGet = REQUESTED.decrementAndGet(this);
                                StateLogger stateLogger2 = this.logger;
                                if (stateLogger2 != null) {
                                    stateLogger2.log(toString(), "dec", jDecrementAndGet, jDecrementAndGet);
                                }
                                j12 = jDecrementAndGet;
                            }
                            long jSendSent = innerWindow.sendSent();
                            if (isTerminated(jMarkWorkDone)) {
                                Throwable th = this.error;
                                if (th != null) {
                                    if (!isTerminated(jSendSent)) {
                                        innerWindow.sendError(th);
                                    }
                                    this.actual.onError(th);
                                    return;
                                } else {
                                    if (!isTerminated(jSendSent)) {
                                        innerWindow.sendComplete();
                                    }
                                    this.actual.onComplete();
                                    return;
                                }
                            }
                            if (iNextWindowIndex <= iActiveWindowIndex || !(InnerWindow.isTimeout(jSendSent) || InnerWindow.isTerminated(jSendSent))) {
                                long jCommitSent = commitSent(this, jMarkWorkDone);
                                long j15 = jCommitSent & (-2305843009213693953L);
                                if (jMarkWorkDone != jCommitSent) {
                                    j13 = 0;
                                }
                                jIncrementActiveWindowIndex2 = j15 ^ j13;
                                if (isCancelled(jIncrementActiveWindowIndex2)) {
                                    return;
                                }
                                if (isTerminated(jIncrementActiveWindowIndex2)) {
                                    Throwable th2 = this.error;
                                    if (th2 != null) {
                                        this.actual.onError(th2);
                                        return;
                                    } else {
                                        this.actual.onComplete();
                                        return;
                                    }
                                }
                                if (!hasWorkInProgress(jIncrementActiveWindowIndex2)) {
                                    return;
                                } else {
                                    j10 = j15;
                                }
                            } else {
                                boolean z10 = j12 == 0;
                                InnerWindow<T> innerWindow2 = new InnerWindow<>(this.maxSize, this, iNextWindowIndex, z10, this.logger);
                                this.window = innerWindow2;
                                if (!z10) {
                                    this.actual.onNext(innerWindow2);
                                    if (j12 != Long.MAX_VALUE) {
                                        REQUESTED.decrementAndGet(this);
                                    }
                                }
                                long jCommitWork2 = commitWork(this, jMarkWorkDone, z10);
                                long j16 = jCommitWork2 & (-2305844108724273153L);
                                if (jMarkWorkDone != jCommitWork2) {
                                    j13 = 0;
                                }
                                jIncrementActiveWindowIndex2 = (j16 ^ j13) | incrementActiveWindowIndex(jCommitWork2) | (z10 ? 2305843009213693952L : 0L);
                                long j17 = jCommitWork2 & (-2305843009213693953L);
                                if (!z10) {
                                    j14 = 0;
                                }
                                j10 = j17 | j14;
                                if (isCancelled(jIncrementActiveWindowIndex2)) {
                                    innerWindow2.sendCancel();
                                    if (z10) {
                                        innerWindow2.cancel();
                                        return;
                                    }
                                    return;
                                }
                                if (isTerminated(jIncrementActiveWindowIndex2) && !z10) {
                                    Throwable th3 = this.error;
                                    if (th3 != null) {
                                        innerWindow2.sendError(th3);
                                        this.actual.onError(th3);
                                        return;
                                    } else {
                                        innerWindow2.sendComplete();
                                        this.actual.onComplete();
                                        return;
                                    }
                                }
                                try {
                                    innerWindow2.scheduleTimeout();
                                    long jReceived = InnerWindow.received(jSendSent);
                                    if (jReceived > 0) {
                                        this.f5827s.request(jReceived);
                                    }
                                    if (!hasWorkInProgress(jIncrementActiveWindowIndex2)) {
                                        return;
                                    }
                                } catch (Exception e) {
                                    if (!hasWorkInProgress(jIncrementActiveWindowIndex2)) {
                                        onError(Operators.onOperatorError(this.f5827s, e, this.actual.currentContext()));
                                        return;
                                    } else {
                                        CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
                                        coreSubscriber.onError(Operators.onOperatorError(this.f5827s, e, coreSubscriber.currentContext()));
                                        return;
                                    }
                                }
                            }
                            jMarkWorkDone = jIncrementActiveWindowIndex2;
                            j11 = j10;
                        } else {
                            InnerWindow<T> innerWindow3 = new InnerWindow<>(this.maxSize, this, iNextWindowIndex, false, this.logger);
                            InnerWindow<T> innerWindow4 = this.window;
                            this.window = innerWindow3;
                            this.actual.onNext(innerWindow3);
                            if (j12 != Long.MAX_VALUE) {
                                REQUESTED.decrementAndGet(this);
                            }
                            jCommitWork = commitWork(this, jMarkWorkDone, false);
                            long j18 = jCommitWork & (-2305844108724273153L);
                            if (jMarkWorkDone != jCommitWork) {
                                j13 = 0;
                            }
                            jIncrementActiveWindowIndex = (j18 ^ j13) | incrementActiveWindowIndex(jCommitWork);
                            if (isCancelled(jIncrementActiveWindowIndex)) {
                                innerWindow4.sendCancel();
                                innerWindow3.sendCancel();
                                return;
                            }
                            if (isTerminated(jIncrementActiveWindowIndex)) {
                                Throwable th4 = this.error;
                                if (th4 != null) {
                                    innerWindow4.sendError(th4);
                                    innerWindow3.sendError(th4);
                                    this.actual.onError(th4);
                                    return;
                                } else {
                                    innerWindow4.sendComplete();
                                    innerWindow3.sendComplete();
                                    this.actual.onComplete();
                                    return;
                                }
                            }
                            try {
                                innerWindow3.scheduleTimeout();
                                long jReceived2 = innerWindow4 == null ? this.maxSize : InnerWindow.received(innerWindow4.sendComplete());
                                if (jReceived2 > 0) {
                                    this.f5827s.request(jReceived2);
                                }
                                if (!hasWorkInProgress(jIncrementActiveWindowIndex)) {
                                    return;
                                }
                            } catch (Exception e6) {
                                if (!hasWorkInProgress(jIncrementActiveWindowIndex)) {
                                    onError(Operators.onOperatorError(this.f5827s, e6, this.actual.currentContext()));
                                    return;
                                } else {
                                    CoreSubscriber<? super Flux<T>> coreSubscriber2 = this.actual;
                                    coreSubscriber2.onError(Operators.onOperatorError(this.f5827s, e6, coreSubscriber2.currentContext()));
                                    return;
                                }
                            }
                        }
                    } else if (j12 != 0 || zHasUnsentWindow) {
                        long jMarkWorkDone2 = markWorkDone(this, jMarkWorkDone);
                        jCommitWork = jMarkWorkDone2 | HAS_WORK_IN_PROGRESS;
                        if (isCancelled(jMarkWorkDone2)) {
                            InnerWindow<T> innerWindow5 = this.window;
                            if (InnerWindow.isSent(innerWindow5.sendCancel())) {
                                return;
                            }
                            innerWindow5.cancel();
                            return;
                        }
                        if (isTerminated(jMarkWorkDone2) && !hasUnsentWindow(jMarkWorkDone2)) {
                            Throwable th5 = this.error;
                            if (th5 != null) {
                                this.actual.onError(th5);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        }
                        if (!hasWorkInProgress(jMarkWorkDone2)) {
                            return;
                        }
                        jMarkWorkDone = jMarkWorkDone2;
                        j11 = jCommitWork;
                    } else {
                        InnerWindow<T> innerWindow6 = new InnerWindow<>(this.maxSize, this, iNextWindowIndex, true, this.logger);
                        InnerWindow<T> innerWindow7 = this.window;
                        this.window = innerWindow6;
                        long jCommitWork3 = commitWork(this, jMarkWorkDone, true);
                        long j19 = jCommitWork3 & (-2305844108724273153L);
                        if (jMarkWorkDone != jCommitWork3) {
                            j13 = 0;
                        }
                        jIncrementActiveWindowIndex = (j19 ^ j13) | incrementActiveWindowIndex(jCommitWork3) | HAS_UNSENT_WINDOW;
                        jCommitWork = jCommitWork3 | HAS_UNSENT_WINDOW;
                        if (isCancelled(jIncrementActiveWindowIndex)) {
                            innerWindow7.sendCancel();
                            innerWindow6.sendCancel();
                            innerWindow6.cancel();
                            return;
                        }
                        try {
                            innerWindow6.scheduleTimeout();
                            long jReceived3 = InnerWindow.received(innerWindow7.sendComplete());
                            if (jReceived3 > 0) {
                                this.f5827s.request(jReceived3);
                            }
                            if (!hasWorkInProgress(jIncrementActiveWindowIndex)) {
                                return;
                            }
                        } catch (Exception e9) {
                            if (!hasWorkInProgress(jIncrementActiveWindowIndex)) {
                                onError(Operators.onOperatorError(this.f5827s, e9, this.actual.currentContext()));
                                return;
                            } else {
                                CoreSubscriber<? super Flux<T>> coreSubscriber3 = this.actual;
                                coreSubscriber3.onError(Operators.onOperatorError(this.f5827s, e9, coreSubscriber3.currentContext()));
                                return;
                            }
                        }
                    }
                    jMarkWorkDone = jIncrementActiveWindowIndex;
                    j11 = jCommitWork;
                } else {
                    jMarkWorkDone = markWorkDone(this, jMarkWorkDone);
                    j11 = HAS_WORK_IN_PROGRESS | jMarkWorkDone;
                    if (isCancelled(jMarkWorkDone)) {
                        return;
                    }
                    if (isTerminated(jMarkWorkDone)) {
                        Throwable th6 = this.error;
                        if (th6 != null) {
                            this.actual.onError(th6);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    if (!hasWorkInProgress(jMarkWorkDone)) {
                        return;
                    }
                }
            }
        }

        public long now() {
            return this.scheduler.now(TimeUnit.NANOSECONDS);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long jMarkTerminated = markTerminated(this);
            if (isCancelled(jMarkTerminated) || isTerminated(jMarkTerminated)) {
                return;
            }
            InnerWindow<T> innerWindow = this.window;
            if (innerWindow != null) {
                innerWindow.sendComplete();
                if (hasUnsentWindow(jMarkTerminated)) {
                    return;
                }
            }
            if (hasWorkInProgress(jMarkTerminated)) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            long jMarkTerminated = markTerminated(this);
            if (isCancelled(jMarkTerminated) || isTerminated(jMarkTerminated)) {
                return;
            }
            InnerWindow<T> innerWindow = this.window;
            if (innerWindow != null) {
                innerWindow.sendError(Exceptions.wrapSource(th));
                if (hasUnsentWindow(jMarkTerminated)) {
                    return;
                }
            }
            if (hasWorkInProgress(jMarkTerminated)) {
                return;
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            while (!isCancelled(this.state)) {
                if (this.window.sendNext(t9)) {
                    return;
                }
            }
            Operators.onDiscard(t9, this.actual.currentContext());
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5827s, eVar)) {
                this.f5827s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.addCap(REQUESTED, this, j5) == Long.MAX_VALUE) {
                return;
            }
            while (true) {
                long j6 = this.state;
                if (isCancelled(j6)) {
                    return;
                }
                if (hasWorkInProgress(j6)) {
                    long jIncrementRequestIndex = ((-1152920405095219201L) & j6) | incrementRequestIndex(j6);
                    WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber = this;
                    if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber, j6, jIncrementRequestIndex)) {
                        StateLogger stateLogger = windowTimeoutWithBackpressureSubscriber.logger;
                        if (stateLogger != null) {
                            stateLogger.log(windowTimeoutWithBackpressureSubscriber.toString(), "mre", j6, jIncrementRequestIndex);
                            return;
                        }
                        return;
                    }
                    this = windowTimeoutWithBackpressureSubscriber;
                } else {
                    WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber2 = this;
                    if (!hasUnsentWindow(j6) && (isTerminated(j6) || activeWindowIndex(j6) == nextWindowIndex(j6))) {
                        return;
                    }
                    long j10 = HAS_WORK_IN_PROGRESS | ((-2305843009213693953L) & j6);
                    if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber2, j6, j10)) {
                        StateLogger stateLogger2 = windowTimeoutWithBackpressureSubscriber2.logger;
                        if (stateLogger2 != null) {
                            stateLogger2.log(windowTimeoutWithBackpressureSubscriber2.toString(), "mre", j6, j10);
                            j6 = j6;
                            j10 = j10;
                        }
                        windowTimeoutWithBackpressureSubscriber2.drain(j6, j10);
                        return;
                    }
                    this = windowTimeoutWithBackpressureSubscriber2;
                }
            }
        }

        public Disposable schedule(Runnable runnable, long j5) {
            if (this.unit.toNanos(this.timespan) - (this.scheduler.now(TimeUnit.NANOSECONDS) - j5) > 0) {
                return this.worker.schedule(runnable, this.timespan, this.unit);
            }
            runnable.run();
            return InnerWindow.DISPOSED;
        }

        public void tryCreateNextWindow(int i) {
            while (true) {
                long j5 = this.state;
                if (isCancelled(j5) || nextWindowIndex(j5) != i) {
                    return;
                }
                boolean zHasWorkInProgress = hasWorkInProgress(j5);
                if (!zHasWorkInProgress && isTerminated(j5) && !hasUnsentWindow(j5)) {
                    return;
                }
                long jIncrementNextWindowIndex = HAS_WORK_IN_PROGRESS | ((-1048576) & j5) | incrementNextWindowIndex(j5);
                WindowTimeoutWithBackpressureSubscriber<T> windowTimeoutWithBackpressureSubscriber = this;
                if (STATE.compareAndSet(windowTimeoutWithBackpressureSubscriber, j5, jIncrementNextWindowIndex)) {
                    if (zHasWorkInProgress) {
                        return;
                    }
                    windowTimeoutWithBackpressureSubscriber.drain(j5, jIncrementNextWindowIndex);
                    return;
                }
                this = windowTimeoutWithBackpressureSubscriber;
            }
        }
    }

    public FluxWindowTimeout(Flux<T> flux, int i, long j5, TimeUnit timeUnit, Scheduler scheduler, boolean z10) {
        super(Flux.from(flux));
        if (j5 <= 0) {
            throw new IllegalArgumentException("Timeout period must be strictly positive");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize must be strictly positive");
        }
        this.fairBackpressure = z10;
        Objects.requireNonNull(scheduler, "Timer");
        this.timer = scheduler;
        this.timespan = j5;
        Objects.requireNonNull(timeUnit, "unit");
        this.unit = timeUnit;
        this.maxSize = i;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.timer : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Flux<T>> coreSubscriber) {
        return this.fairBackpressure ? new WindowTimeoutWithBackpressureSubscriber(coreSubscriber, this.maxSize, this.timespan, this.unit, this.timer, null) : new WindowTimeoutSubscriber(coreSubscriber, this.maxSize, this.timespan, this.unit, this.timer);
    }
}
