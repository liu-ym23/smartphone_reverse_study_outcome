package reactor.core.publisher;

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

/* loaded from: classes4.dex */
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
    final Function<? super T, ? extends Z9.c> mapper;

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
        Z9.e f5801s;

        public SwitchMapInner(SwitchMapMain<T, R> switchMapMain, CoreSubscriber<? super R> coreSubscriber, int i, @Nullable StateLogger stateLogger) {
            this.parent = switchMapMain;
            this.actual = coreSubscriber;
            this.index = i;
            this.logger = stateLogger;
        }

        public void cancelFromParent() {
            this.f5801s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public boolean isCancelledByParent() {
            long j5 = this.parent.state;
            if (this.index == FluxSwitchMapNoPrefetch.index(j5) || this.done) {
                return !this.parent.done && j5 == FluxSwitchMapNoPrefetch.TERMINATED;
            }
            return true;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            SwitchMapMain<T, R> switchMapMain = this.parent;
            int i = this.index;
            long wip = FluxSwitchMapNoPrefetch.setWip(switchMapMain, i);
            if (wip != FluxSwitchMapNoPrefetch.TERMINATED && FluxSwitchMapNoPrefetch.index(wip) == i) {
                long j5 = this.produced;
                if (j5 > 0) {
                    this.produced = 0L;
                    this.requested = 0L;
                    SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j5);
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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
                switchMapMain.f5802s.cancel();
            }
            this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, switchMapMain));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            long j5;
            boolean z10;
            if (this.done) {
                Operators.onNextDropped(r5, this.actual.currentContext());
                return;
            }
            SwitchMapMain<T, R> switchMapMain = this.parent;
            Z9.e eVar = this.f5801s;
            int i = this.index;
            long jAddAndGet = this.requested;
            long wip = FluxSwitchMapNoPrefetch.setWip(switchMapMain, i);
            if (wip == FluxSwitchMapNoPrefetch.TERMINATED) {
                Operators.onDiscard(r5, this.actual.currentContext());
                return;
            }
            if (FluxSwitchMapNoPrefetch.index(wip) != i) {
                Operators.onDiscard(r5, this.actual.currentContext());
                return;
            }
            this.actual.onNext(r5);
            int iHasRequest = FluxSwitchMapNoPrefetch.hasRequest(wip);
            if (jAddAndGet != Long.MAX_VALUE) {
                j5 = this.produced + 1;
                this.produced = j5;
                if (iHasRequest > 1) {
                    long j6 = switchMapMain.requested;
                    long j10 = j6 - jAddAndGet;
                    if (j10 > 0) {
                        this.requested = j6;
                        if (j6 == Long.MAX_VALUE) {
                            this.produced = 0L;
                            eVar.request(Long.MAX_VALUE);
                            jAddAndGet = j6;
                            j5 = 0;
                        } else {
                            eVar.request(j10);
                            jAddAndGet = j6;
                        }
                    }
                }
                z10 = j5 == jAddAndGet;
                if (z10) {
                    this.produced = 0L;
                    jAddAndGet = SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j5);
                    this.requested = jAddAndGet;
                    boolean z11 = jAddAndGet == 0;
                    if (!z11) {
                        eVar.request(jAddAndGet);
                    }
                    z10 = z11;
                    j5 = 0;
                }
            } else {
                j5 = 0;
                z10 = false;
            }
            while (true) {
                long jUnsetWip = FluxSwitchMapNoPrefetch.unsetWip(switchMapMain, i, z10, iHasRequest);
                if (jUnsetWip == FluxSwitchMapNoPrefetch.TERMINATED) {
                    return;
                }
                int iIndex = FluxSwitchMapNoPrefetch.index(jUnsetWip);
                if (i != iIndex) {
                    if (j5 > 0) {
                        this.produced = 0L;
                        this.requested = 0L;
                        SwitchMapMain.REQUESTED.addAndGet(switchMapMain, -j5);
                    }
                    switchMapMain.subscribeInner(this.nextElement, this.nextInner, iIndex);
                    return;
                }
                int iHasRequest2 = FluxSwitchMapNoPrefetch.hasRequest(jUnsetWip);
                if (!z10 || iHasRequest >= iHasRequest2) {
                    return;
                }
                long j11 = switchMapMain.requested;
                long j12 = j11 - jAddAndGet;
                if (j12 > 0) {
                    this.requested = j11;
                    eVar.request(j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j12);
                    iHasRequest = iHasRequest2;
                    jAddAndGet = j11;
                    z10 = false;
                } else {
                    iHasRequest = iHasRequest2;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5801s, eVar)) {
                this.f5801s = eVar;
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
                    long j5 = switchMapMain.requested;
                    this.requested = j5;
                    eVar.request(j5);
                }
            }
        }

        public void request(long j5) {
            this.requested = Operators.addCap(this.requested, j5);
            this.f5801s.request(j5);
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

    public static final class SwitchMapMain<T, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        SwitchMapInner<T, R> inner;

        @Nullable
        final StateLogger logger;
        final Function<? super T, ? extends Z9.c> mapper;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5802s;
        volatile long state;
        volatile Throwable throwable;
        static final AtomicReferenceFieldUpdater<SwitchMapMain, Throwable> THROWABLE = AtomicReferenceFieldUpdater.newUpdater(SwitchMapMain.class, Throwable.class, "throwable");
        static final AtomicLongFieldUpdater<SwitchMapMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "requested");
        static final AtomicLongFieldUpdater<SwitchMapMain> STATE = AtomicLongFieldUpdater.newUpdater(SwitchMapMain.class, "state");

        public SwitchMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function) {
            this(coreSubscriber, function, null);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
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
            this.f5802s.cancel();
            Throwable thTerminate = Exceptions.terminate(THROWABLE, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.inner);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            SwitchMapInner<T, R> switchMapInner = this.inner;
            if (switchMapInner == null) {
                SwitchMapInner<T, R> switchMapInner2 = new SwitchMapInner<>(this, this.actual, 0, this.logger);
                this.inner = switchMapInner2;
                subscribeInner(t9, switchMapInner2, 0);
                return;
            }
            int i = switchMapInner.index + 1;
            SwitchMapInner<T, R> switchMapInner3 = new SwitchMapInner<>(this, this.actual, i, this.logger);
            this.inner = switchMapInner3;
            switchMapInner.nextInner = switchMapInner3;
            switchMapInner.nextElement = t9;
            long jIncrementIndex = FluxSwitchMapNoPrefetch.incrementIndex(this);
            if (jIncrementIndex == FluxSwitchMapNoPrefetch.TERMINATED) {
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            if (FluxSwitchMapNoPrefetch.isInnerSubscribed(jIncrementIndex)) {
                switchMapInner.cancelFromParent();
                if (FluxSwitchMapNoPrefetch.isWip(jIncrementIndex)) {
                    return;
                }
                long j5 = switchMapInner.produced;
                if (j5 > 0) {
                    switchMapInner.produced = 0L;
                    if (this.requested != Long.MAX_VALUE) {
                        switchMapInner.requested = 0L;
                        REQUESTED.addAndGet(this, -j5);
                    }
                }
                subscribeInner(t9, switchMapInner3, i);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5802s, eVar)) {
                this.f5802s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                long jAddRequest = FluxSwitchMapNoPrefetch.addRequest(this, Operators.addCap(REQUESTED, this, j5));
                if (jAddRequest != FluxSwitchMapNoPrefetch.TERMINATED && FluxSwitchMapNoPrefetch.hasRequest(jAddRequest) == 1 && FluxSwitchMapNoPrefetch.isInnerSubscribed(jAddRequest) && !FluxSwitchMapNoPrefetch.hasInnerCompleted(jAddRequest)) {
                    SwitchMapInner<T, R> switchMapInner = this.inner;
                    if (switchMapInner.index == FluxSwitchMapNoPrefetch.index(jAddRequest)) {
                        switchMapInner.request(j5);
                    }
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            long j5 = this.state;
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(!this.done && j5 == FluxSwitchMapNoPrefetch.TERMINATED);
            }
            return attr == Scannable.Attr.PARENT ? this.f5802s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.throwable : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void subscribeInner(T t9, SwitchMapInner<T, R> switchMapInner, int i) {
            Context contextCurrentContext = this.actual.currentContext();
            while (switchMapInner.index != i) {
                Operators.onDiscard(t9, contextCurrentContext);
                t9 = switchMapInner.nextElement;
                switchMapInner = switchMapInner.nextInner;
            }
            try {
                Z9.c cVarApply = this.mapper.apply(t9);
                Objects.requireNonNull(cVarApply, "The mapper returned a null publisher");
                Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) switchMapInner);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5802s, th, t9, contextCurrentContext));
            }
        }

        public SwitchMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, @Nullable StateLogger stateLogger) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.logger = stateLogger;
        }
    }

    public FluxSwitchMapNoPrefetch(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function) {
        super(flux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    public static long addRequest(SwitchMapMain<?, ?> switchMapMain, long j5) {
        while (true) {
            long j6 = switchMapMain.state;
            long j10 = TERMINATED;
            if (j6 == j10) {
                return j10;
            }
            int iHasRequest = hasRequest(j6);
            if (iHasRequest == 0 && j5 > 0) {
                return j6;
            }
            long jState = state(index(j6), isWip(j6), iHasRequest + 1, isInnerSubscribed(j6), hasMainCompleted(j6), hasInnerCompleted(j6));
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j6, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return jState;
                }
                stateLogger.log(switchMapMain2.toString(), "adr", j6, jState);
                return jState;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static boolean hasInnerCompleted(long j5) {
        long j6 = INNER_COMPLETED_MASK;
        return (j5 & j6) == j6;
    }

    public static boolean hasMainCompleted(long j5) {
        long j6 = COMPLETED_MASK;
        return (j5 & j6) == j6;
    }

    public static int hasRequest(long j5) {
        return ((int) (j5 & HAS_REQUEST_MASK)) >> HAS_REQUEST_OFFSET;
    }

    public static long incrementIndex(SwitchMapMain<?, ?> switchMapMain) {
        long j5 = switchMapMain.state;
        long j6 = TERMINATED;
        if (j5 == j6) {
            return j6;
        }
        int iNextIndex = nextIndex(j5);
        while (true) {
            long jState = state(iNextIndex, isWip(j5), hasRequest(j5), false, false, false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            long j10 = j5;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j10, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j10;
                }
                stateLogger.log(switchMapMain2.toString(), "ini", j10, jState);
                return j10;
            }
            j5 = switchMapMain2.state;
            long j11 = TERMINATED;
            if (j5 == j11) {
                return j11;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static int index(long j5) {
        return (int) (j5 >>> INDEX_OFFSET);
    }

    public static boolean isInnerSubscribed(long j5) {
        long j6 = INNER_SUBSCRIBED_MASK;
        return (j5 & j6) == j6;
    }

    public static boolean isWip(long j5) {
        long j6 = INNER_WIP_MASK;
        return (j5 & j6) == j6;
    }

    public static int nextIndex(long j5) {
        return ((int) (j5 >>> INDEX_OFFSET)) + 1;
    }

    public static long setInnerCompleted(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            boolean zIsInnerSubscribed = isInnerSubscribed(j5);
            long jState = state(index(j5), false, hasRequest(j5), zIsInnerSubscribed, hasMainCompleted(j5), zIsInnerSubscribed);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "sic", j5, jState);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setInnerSubscribed(SwitchMapMain<?, ?> switchMapMain, int i) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            if (i != index(j5)) {
                return j5;
            }
            long jState = state(i, false, hasRequest(j5), true, hasMainCompleted(j5), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "sns", j5, jState);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setMainCompleted(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            long j10 = COMPLETED_MASK;
            if ((j5 & j10) == j10) {
                return j5;
            }
            long j11 = j5 | j10;
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, j11)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "smc", j5, j11);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setTerminated(SwitchMapMain<?, ?> switchMapMain) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, TERMINATED)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "std", j5, TERMINATED);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long setWip(SwitchMapMain<?, ?> switchMapMain, int i) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            if (i != index(j5)) {
                return j5;
            }
            long jState = state(i, true, hasRequest(j5), true, hasMainCompleted(j5), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "swp", j5, jState);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    public static long state(int i, boolean z10, int i6, boolean z11, boolean z12, boolean z13) {
        return (z10 ? INNER_WIP_MASK : 0L) | (i << INDEX_OFFSET) | (Math.max(Math.min(i6, MAX_HAS_REQUEST), 0) << HAS_REQUEST_OFFSET) | (z11 ? INNER_SUBSCRIBED_MASK : 0L) | (z12 ? COMPLETED_MASK : 0L) | (z13 ? INNER_COMPLETED_MASK : 0L);
    }

    public static long unsetWip(SwitchMapMain<?, ?> switchMapMain, int i, boolean z10, int i6) {
        while (true) {
            long j5 = switchMapMain.state;
            long j6 = TERMINATED;
            if (j5 == j6) {
                return j6;
            }
            int iIndex = index(j5);
            int iHasRequest = hasRequest(j5);
            boolean z11 = i == iIndex;
            if (z10 && i6 < iHasRequest && z11) {
                return j5;
            }
            long jState = state(iIndex, false, (z10 && i6 == iHasRequest) ? 0 : iHasRequest, isInnerSubscribed(j5), hasMainCompleted(j5), false);
            SwitchMapMain<?, ?> switchMapMain2 = switchMapMain;
            if (SwitchMapMain.STATE.compareAndSet(switchMapMain2, j5, jState)) {
                StateLogger stateLogger = switchMapMain2.logger;
                if (stateLogger == null) {
                    return j5;
                }
                stateLogger.log(switchMapMain2.toString(), "uwp", j5, jState);
                return j5;
            }
            switchMapMain = switchMapMain2;
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
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
}
