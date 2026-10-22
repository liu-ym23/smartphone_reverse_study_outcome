package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSwitchMapNoPrefetch<T, R> extends InternalFluxOperator<T, R> {
    static long COMPLETED_MASK = 8;
    static long HAS_REQUEST_MASK = 4294967280L;
    static int HAS_REQUEST_OFFSET = 4;
    static int INDEX_OFFSET = 32;
    static long INNER_COMPLETED_MASK = 4;
    static long INNER_SUBSCRIBED_MASK = 2;
    static long INNER_WIP_MASK = 1;
    static int MAX_HAS_REQUEST = 268435455;
    static long TERMINATED = -1;
    final Function<? super T, ? extends qd.c> mapper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SwitchMapInner<T, R> implements InnerConsumer<R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final int index;

        @Nullable
        final StateLogger logger;
        T nextElement;
        SwitchMapInner<T, R> nextInner;
        final SwitchMapMain<T, R> parent;
        long produced;
        long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10681s;

        public SwitchMapInner(SwitchMapMain<T, R> switchMapMain, CoreSubscriber<? super R> coreSubscriber, int i, @Nullable StateLogger stateLogger) {
            this.parent = switchMapMain;
            this.actual = coreSubscriber;
            this.index = i;
            this.logger = stateLogger;
        }

        public void cancelFromParent() {
            this.f10681s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public boolean isCancelledByParent() {
            long j10 = this.parent.state;
            if (this.index == FluxSwitchMapNoPrefetch.index(j10) || this.done) {
                return !this.parent.done && j10 == FluxSwitchMapNoPrefetch.TERMINATED;
            }
            return true;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            SwitchMapMain<T, R> switchMapMain = this.parent;
            int i = this.index;
            long wip = FluxSwitchMapNoPrefetch.setWip(switchMapMain, i);
            if (wip != FluxSwitchMapNoPrefetch.TERMINATED && FluxSwitchMapNoPrefetch.index(wip) == i) {
                long j10 = this.produced;
                if (j10 > 0) {
                    this.produced = 0L;
                    this.requested = 0L;
                    SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j10);
                }
                if (FluxSwitchMapNoPrefetch.hasMainCompleted(wip)) {
                    this.actual.onComplete();
                    return;
                }
                long innerCompleted = FluxSwitchMapNoPrefetch.setInnerCompleted(switchMapMain);
                if (innerCompleted == FluxSwitchMapNoPrefetch.TERMINATED) {
                    return;
                }
                int iIndex = FluxSwitchMapNoPrefetch.index(innerCompleted);
                if (i != iIndex) {
                    switchMapMain.subscribeInner(this.nextElement, this.nextInner, iIndex);
                } else if (FluxSwitchMapNoPrefetch.hasMainCompleted(innerCompleted)) {
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            SwitchMapMain<T, R> switchMapMain = this.parent;
            AtomicReferenceFieldUpdater<SwitchMapMain, Throwable> atomicReferenceFieldUpdater = SwitchMapMain.THROWABLE;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, switchMapMain, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            long terminated = FluxSwitchMapNoPrefetch.setTerminated(switchMapMain);
            if (terminated == FluxSwitchMapNoPrefetch.TERMINATED) {
                return;
            }
            if (!FluxSwitchMapNoPrefetch.hasMainCompleted(terminated)) {
                switchMapMain.f10682s.cancel();
            }
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, switchMapMain));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(R r10) {
            long j10;
            boolean z10;
            if (this.done) {
                Operators.onNextDropped(r10, this.actual.currentContext());
                return;
            }
            SwitchMapMain<T, R> switchMapMain = this.parent;
            qd.e eVar = this.f10681s;
            int i = this.index;
            long jAddAndGet = this.requested;
            long wip = FluxSwitchMapNoPrefetch.setWip(switchMapMain, i);
            if (wip == FluxSwitchMapNoPrefetch.TERMINATED) {
                Operators.onDiscard(r10, this.actual.currentContext());
                return;
            }
            int iIndex = FluxSwitchMapNoPrefetch.index(wip);
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            if (iIndex != i) {
                Operators.onDiscard(r10, coreSubscriber.currentContext());
                return;
            }
            coreSubscriber.onNext(r10);
            int iHasRequest = FluxSwitchMapNoPrefetch.hasRequest(wip);
            if (jAddAndGet != Long.MAX_VALUE) {
                j10 = this.produced + 1;
                this.produced = j10;
                if (iHasRequest > 1) {
                    long j11 = switchMapMain.requested;
                    long j12 = j11 - jAddAndGet;
                    if (j12 > 0) {
                        this.requested = j11;
                        if (j11 == Long.MAX_VALUE) {
                            this.produced = 0L;
                            eVar.request(Long.MAX_VALUE);
                            jAddAndGet = j11;
                            j10 = 0;
                        } else {
                            eVar.request(j12);
                            jAddAndGet = j11;
                        }
                    }
                }
                z10 = j10 == jAddAndGet;
                if (z10) {
                    this.produced = 0L;
                    jAddAndGet = SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j10);
                    this.requested = jAddAndGet;
                    boolean z11 = jAddAndGet == 0;
                    if (!z11) {
                        eVar.request(jAddAndGet);
                    }
                    z10 = z11;
                    j10 = 0;
                }
            } else {
                j10 = 0;
                z10 = false;
            }
            while (true) {
                long jUnsetWip = FluxSwitchMapNoPrefetch.unsetWip(switchMapMain, i, z10, iHasRequest);
                if (jUnsetWip == FluxSwitchMapNoPrefetch.TERMINATED) {
                    return;
                }
                int iIndex2 = FluxSwitchMapNoPrefetch.index(jUnsetWip);
                if (i != iIndex2) {
                    if (j10 > 0) {
                        this.produced = 0L;
                        this.requested = 0L;
                        SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j10);
                    }
                    switchMapMain.subscribeInner(this.nextElement, this.nextInner, iIndex2);
                    return;
                }
                int iHasRequest2 = FluxSwitchMapNoPrefetch.hasRequest(jUnsetWip);
                if (!z10 || iHasRequest >= iHasRequest2) {
                    return;
                }
                long j13 = switchMapMain.requested;
                long j14 = j13 - jAddAndGet;
                if (j14 > 0) {
                    this.requested = j13;
                    eVar.request(j13 == Long.MAX_VALUE ? Long.MAX_VALUE : j14);
                    iHasRequest = iHasRequest2;
                    jAddAndGet = j13;
                    z10 = false;
                } else {
                    iHasRequest = iHasRequest2;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10681s, eVar)) {
                this.f10681s = eVar;
                int i = this.index;
                SwitchMapMain<T, R> switchMapMain = this.parent;
                long innerSubscribed = FluxSwitchMapNoPrefetch.setInnerSubscribed(switchMapMain, i);
                if (innerSubscribed == FluxSwitchMapNoPrefetch.TERMINATED) {
                    eVar.cancel();
                    return;
                }
                int iIndex = FluxSwitchMapNoPrefetch.index(innerSubscribed);
                if (i != iIndex) {
                    eVar.cancel();
                    switchMapMain.subscribeInner(this.nextElement, this.nextInner, iIndex);
                } else if (FluxSwitchMapNoPrefetch.hasRequest(innerSubscribed) > 0) {
                    long j10 = switchMapMain.requested;
                    this.requested = j10;
                    eVar.request(j10);
                }
            }
        }

        public void request(long j10) {
            this.requested = Operators.addCap(this.requested, j10);
            this.f10681s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelledByParent());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.actual;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        public String toString() {
            return new StringJoiner(", ", SwitchMapInner.class.getSimpleName().concat("["), "]").add("index=" + this.index).toString();
        }
    }

    public FluxSwitchMapNoPrefetch(Flux<? extends T> flux, Function<? super T, ? extends qd.c> function) {
        super(flux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    public static long addRequest(SwitchMapMain<?, ?> switchMapMain, long j10) {
        while (true) {
            long j11 = switchMapMain.state;
            long j12 = TERMINATED;
            if (j11 == j12) {
                return j12;
            }
            int iHasRequest = hasRequest(j11);
            if (iHasRequest == 0 && j10 > 0) {
                return j11;
            }
            long jState = state(index(j11), isWip(j11), iHasRequest + 1, isInnerSubscribed(j11), hasMainCompleted(j11), hasInnerCompleted(j11));
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j11, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return jState;
                }
                stateLogger.log(switchMapMain2.toString(), "adr", j11, jState);
                return jState;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static boolean hasInnerCompleted(long j10) {
        long j11 = INNER_COMPLETED_MASK;
        return (j10 & j11) == j11;
    }

    public static boolean hasMainCompleted(long j10) {
        long j11 = COMPLETED_MASK;
        return (j10 & j11) == j11;
    }

    public static int hasRequest(long j10) {
        return ((int) (j10 & HAS_REQUEST_MASK)) >> HAS_REQUEST_OFFSET;
    }

    public static long incrementIndex(SwitchMapMain<?, ?> switchMapMain) {
        long j10 = switchMapMain.state;
        long j11 = TERMINATED;
        if (j10 == j11) {
            return j11;
        }
        int iNextIndex = nextIndex(j10);
        while (true) {
            long jState = state(iNextIndex, isWip(j10), hasRequest(j10), false, false, false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            long j12 = j10;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j12, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j12;
                }
                stateLogger.log(switchMapMain2.toString(), "ini", j12, jState);
                return j12;
            }
            j10 = switchMapMain2.state;
            long j13 = TERMINATED;
            if (j10 == j13) {
                return j13;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static int index(long j10) {
        return (int) (j10 >>> INDEX_OFFSET);
    }

    public static boolean isInnerSubscribed(long j10) {
        long j11 = INNER_SUBSCRIBED_MASK;
        return (j10 & j11) == j11;
    }

    public static boolean isWip(long j10) {
        long j11 = INNER_WIP_MASK;
        return (j10 & j11) == j11;
    }

    public static int nextIndex(long j10) {
        return ((int) (j10 >>> INDEX_OFFSET)) + 1;
    }

    public static long setInnerCompleted(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            boolean zIsInnerSubscribed = isInnerSubscribed(j10);
            long jState = state(index(j10), false, hasRequest(j10), zIsInnerSubscribed, hasMainCompleted(j10), zIsInnerSubscribed);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "sic", j10, jState);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setInnerSubscribed(SwitchMapMain<?, ?> switchMapMain, int i) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            if (i != index(j10)) {
                return j10;
            }
            long jState = state(i, false, hasRequest(j10), true, hasMainCompleted(j10), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "sns", j10, jState);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setMainCompleted(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            long j12 = COMPLETED_MASK;
            if ((j10 & j12) == j12) {
                return j10;
            }
            long j13 = j10 | j12;
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, j13)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "smc", j10, j13);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setTerminated(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, TERMINATED)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "std", j10, TERMINATED);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setWip(SwitchMapMain<?, ?> switchMapMain, int i) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            if (i != index(j10)) {
                return j10;
            }
            long jState = state(i, true, hasRequest(j10), true, hasMainCompleted(j10), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "swp", j10, jState);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long state(int i, boolean z10, int i3, boolean z11, boolean z12, boolean z13) {
        return (z10 ? INNER_WIP_MASK : 0L) | (i << INDEX_OFFSET) | (Math.max(Math.min(i3, MAX_HAS_REQUEST), 0) << HAS_REQUEST_OFFSET) | (z11 ? INNER_SUBSCRIBED_MASK : 0L) | (z12 ? COMPLETED_MASK : 0L) | (z13 ? INNER_COMPLETED_MASK : 0L);
    }

    public static long unsetWip(SwitchMapMain<?, ?> switchMapMain, int i, boolean z10, int i3) {
        while (true) {
            long j10 = switchMapMain.state;
            long j11 = TERMINATED;
            if (j10 == j11) {
                return j11;
            }
            int iIndex = index(j10);
            int iHasRequest = hasRequest(j10);
            boolean z11 = i == iIndex;
            if (z10 && i3 < iHasRequest && z11) {
                return j10;
            }
            long jState = state(iIndex, false, (z10 && i3 == iHasRequest) ? 0 : iHasRequest, isInnerSubscribed(j10), hasMainCompleted(j10), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "uwp", j10, jState);
                return j10;
            }
            switchMapMain = switchMapMain2;
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, false)) {
            return null;
        }
        return new SwitchMapMain(coreSubscriber, this.mapper);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SwitchMapMain<T, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        SwitchMapInner<T, R> inner;

        @Nullable
        final StateLogger logger;
        final Function<? super T, ? extends qd.c> mapper;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10682s;
        volatile long state;
        volatile Throwable throwable;
        static final AtomicReferenceFieldUpdater<SwitchMapMain, Throwable> THROWABLE = AtomicReferenceFieldUpdater.newUpdater(SwitchMapMain.class, Throwable.class, "throwable");
        static final AtomicLongFieldUpdater<SwitchMapMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "requested");
        static final AtomicLongFieldUpdater<SwitchMapMain> STATE = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "state");

        public SwitchMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, @Nullable StateLogger stateLogger) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.logger = stateLogger;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            long terminated = FluxSwitchMapNoPrefetch.setTerminated(this);
            if (terminated == FluxSwitchMapNoPrefetch.TERMINATED) {
                return;
            }
            SwitchMapInner<T, R> switchMapInner = this.inner;
            if (switchMapInner != null && FluxSwitchMapNoPrefetch.isInnerSubscribed(terminated) && !FluxSwitchMapNoPrefetch.hasInnerCompleted(terminated) && switchMapInner.index == FluxSwitchMapNoPrefetch.index(terminated)) {
                switchMapInner.cancelFromParent();
            }
            if (FluxSwitchMapNoPrefetch.hasMainCompleted(terminated)) {
                return;
            }
            this.f10682s.cancel();
            Throwable thTerminate = Exceptions.terminate(THROWABLE, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.inner);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long mainCompleted = FluxSwitchMapNoPrefetch.setMainCompleted(this);
            if (mainCompleted == FluxSwitchMapNoPrefetch.TERMINATED) {
                return;
            }
            if (this.inner == null || FluxSwitchMapNoPrefetch.hasInnerCompleted(mainCompleted)) {
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            AtomicReferenceFieldUpdater<SwitchMapMain, Throwable> atomicReferenceFieldUpdater = THROWABLE;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            long terminated = FluxSwitchMapNoPrefetch.setTerminated(this);
            if (terminated == FluxSwitchMapNoPrefetch.TERMINATED) {
                return;
            }
            SwitchMapInner<T, R> switchMapInner = this.inner;
            if (switchMapInner != null && FluxSwitchMapNoPrefetch.isInnerSubscribed(terminated)) {
                switchMapInner.cancelFromParent();
            }
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            SwitchMapInner<T, R> switchMapInner = this.inner;
            if (switchMapInner == null) {
                SwitchMapInner<T, R> switchMapInner2 = new SwitchMapInner<>(this, this.actual, 0, this.logger);
                this.inner = switchMapInner2;
                subscribeInner(t10, switchMapInner2, 0);
                return;
            }
            int i = switchMapInner.index + 1;
            SwitchMapInner<T, R> switchMapInner3 = new SwitchMapInner<>(this, this.actual, i, this.logger);
            this.inner = switchMapInner3;
            switchMapInner.nextInner = switchMapInner3;
            switchMapInner.nextElement = t10;
            long jIncrementIndex = FluxSwitchMapNoPrefetch.incrementIndex(this);
            if (jIncrementIndex == FluxSwitchMapNoPrefetch.TERMINATED) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            if (FluxSwitchMapNoPrefetch.isInnerSubscribed(jIncrementIndex)) {
                switchMapInner.cancelFromParent();
                if (FluxSwitchMapNoPrefetch.isWip(jIncrementIndex)) {
                    return;
                }
                long j10 = switchMapInner.produced;
                if (j10 > 0) {
                    switchMapInner.produced = 0L;
                    if (this.requested != Long.MAX_VALUE) {
                        switchMapInner.requested = 0L;
                        REQUESTED.addAndGet(this, -j10);
                    }
                }
                subscribeInner(t10, switchMapInner3, i);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10682s, eVar)) {
                this.f10682s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                long jAddRequest = FluxSwitchMapNoPrefetch.addRequest(this, Operators.addCap(REQUESTED, this, j10));
                if (jAddRequest != FluxSwitchMapNoPrefetch.TERMINATED && FluxSwitchMapNoPrefetch.hasRequest(jAddRequest) == 1 && FluxSwitchMapNoPrefetch.isInnerSubscribed(jAddRequest) && !FluxSwitchMapNoPrefetch.hasInnerCompleted(jAddRequest)) {
                    SwitchMapInner<T, R> switchMapInner = this.inner;
                    if (switchMapInner.index == FluxSwitchMapNoPrefetch.index(jAddRequest)) {
                        switchMapInner.request(j10);
                    }
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            long j10 = this.state;
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(!this.done && j10 == FluxSwitchMapNoPrefetch.TERMINATED);
            }
            return attr == Scannable.Attr.PARENT ? this.f10682s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.throwable : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void subscribeInner(T t10, SwitchMapInner<T, R> switchMapInner, int i) {
            Context contextCurrentContext = this.actual.currentContext();
            while (switchMapInner.index != i) {
                Operators.onDiscard(t10, contextCurrentContext);
                t10 = switchMapInner.nextElement;
                switchMapInner = switchMapInner.nextInner;
            }
            try {
                qd.c cVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(cVarApply, "The mapper returned a null publisher");
                Operators.toFluxOrMono(cVarApply).subscribe((qd.d) switchMapInner);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10682s, th, t10, contextCurrentContext));
            }
        }

        public SwitchMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function) {
            this(coreSubscriber, function, null);
        }
    }
}
