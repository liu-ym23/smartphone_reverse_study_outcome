package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxReplay<T> extends ConnectableFlux<T> implements Scannable, Fuseable, OptimizableOperator<T, T> {
    static final AtomicReferenceFieldUpdater<FluxReplay, ReplaySubscriber> CONNECTION = AtomicReferenceFieldUpdater.newUpdater(FluxReplay.class, ReplaySubscriber.class, "connection");
    volatile ReplaySubscriber<T> connection;
    final int history;

    @Nullable
    final OptimizableOperator<?, T> optimizableOperator;
    final Scheduler scheduler;
    final CorePublisher<T> source;
    final long ttl;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ReplayBuffer<T> {
        void add(T t10);

        int capacity();

        void clear(ReplaySubscription<T> replaySubscription);

        @Nullable
        Throwable getError();

        boolean isDone();

        boolean isEmpty(ReplaySubscription<T> replaySubscription);

        boolean isExpired();

        void onComplete();

        void onError(Throwable th);

        @Nullable
        T poll(ReplaySubscription<T> replaySubscription);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();

        int size(ReplaySubscription<T> replaySubscription);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ReplaySubscription<T> extends Fuseable.QueueSubscription<T>, InnerProducer<T> {
        CoreSubscriber<? super T> actual();

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        /* synthetic */ void cancel();

        boolean enter();

        int fusionMode();

        int index();

        void index(int i);

        boolean isCancelled();

        int leave(int i);

        @Nullable
        Object node();

        void node(@Nullable Object obj);

        void produced(long j10);

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        /* synthetic */ void request(long j10);

        void requestMore(int i);

        long requested();

        int tailIndex();

        void tailIndex(int i);
    }

    public FluxReplay(CorePublisher<T> corePublisher, int i, long j10, @Nullable Scheduler scheduler) {
        Objects.requireNonNull(corePublisher, "source");
        this.source = Operators.toFluxOrMono(corePublisher);
        if (corePublisher instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) corePublisher;
        } else {
            this.optimizableOperator = null;
        }
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "History cannot be zero or negative : "));
            throw null;
        }
        this.history = i;
        if (scheduler != null && j10 < 0) {
            g5.f.s(k0.a.m("TTL cannot be negative : ", j10));
            throw null;
        }
        this.ttl = j10;
        this.scheduler = scheduler;
    }

    @Override // reactor.core.publisher.ConnectableFlux
    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriberNewState;
        do {
            replaySubscriberNewState = this.connection;
            if (replaySubscriberNewState != null) {
                break;
            } else {
                replaySubscriberNewState = newState();
            }
        } while (!CONNECTION.compareAndSet(this, null, replaySubscriberNewState));
        boolean zTryConnect = replaySubscriberNewState.tryConnect();
        consumer.accept(replaySubscriberNewState);
        if (zTryConnect) {
            try {
                this.source.subscribe((CoreSubscriber) replaySubscriberNewState);
            } catch (Throwable th) {
                Operators.reportThrowInSubscribe(replaySubscriberNewState, th);
            }
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.history;
    }

    public ReplaySubscriber<T> newState() {
        if (this.scheduler != null) {
            return new ReplaySubscriber<>(new SizeAndTimeBoundReplayBuffer(this.history, this.ttl, this.scheduler), this, this.history);
        }
        if (this.history != Integer.MAX_VALUE) {
            return new ReplaySubscriber<>(new SizeBoundReplayBuffer(this.history), this, this.history);
        }
        int i = Queues.SMALL_BUFFER_SIZE;
        return new ReplaySubscriber<>(new UnboundedReplayBuffer(i), this, i);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final OptimizableOperator<?, ? extends T> nextOptimizableSource() {
        return this.optimizableOperator;
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_ON) {
            return this.scheduler;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends T> source() {
        return this.source;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            CoreSubscriber<? super T> coreSubscriberSubscribeOrReturn = subscribeOrReturn(coreSubscriber);
            if (coreSubscriberSubscribeOrReturn == null) {
                return;
            }
            this.source.subscribe((CoreSubscriber) coreSubscriberSubscribeOrReturn);
        } catch (Throwable th) {
            k0.a.B(coreSubscriber, th, coreSubscriber);
        }
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        ReplaySubscriber<T> replaySubscriber;
        boolean z10;
        while (true) {
            replaySubscriber = this.connection;
            z10 = (this.scheduler == null || replaySubscriber == null || !replaySubscriber.buffer.isExpired()) ? false : true;
            if (replaySubscriber != null && !z10) {
                break;
            }
            ReplaySubscriber<T> replaySubscriberNewState = newState();
            if (CONNECTION.compareAndSet(this, replaySubscriber, replaySubscriberNewState)) {
                replaySubscriber = replaySubscriberNewState;
                break;
            }
        }
        ReplayInner<T> replayInner = new ReplayInner<>(coreSubscriber, replaySubscriber);
        coreSubscriber.onSubscribe(replayInner);
        replaySubscriber.add(replayInner);
        if (replayInner.isCancelled()) {
            replaySubscriber.remove(replayInner);
            return null;
        }
        replaySubscriber.buffer.replay(replayInner);
        if (z10) {
            return replaySubscriber;
        }
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ReplayInner<T> implements ReplaySubscription<T> {
        final CoreSubscriber<? super T> actual;
        int fusionMode;
        int index;
        Object node;
        final ReplaySubscriber<T> parent;
        volatile long requested;
        int tailIndex;
        long totalRequested;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<ReplayInner> WIP = AtomicIntegerFieldUpdater.newUpdater(ReplayInner.class, "wip");
        static final AtomicLongFieldUpdater<ReplayInner> REQUESTED = AtomicLongFieldUpdater.newUpdater(ReplayInner.class, "requested");

        public ReplayInner(CoreSubscriber<? super T> coreSubscriber, ReplaySubscriber<T> replaySubscriber) {
            this.actual = coreSubscriber;
            this.parent = replaySubscriber;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription, reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription, reactor.core.Fuseable.QueueSubscription, qd.e
        public void cancel() {
            if (REQUESTED.getAndSet(this, Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                if (enter()) {
                    this.node = null;
                }
            }
        }

        @Override // java.util.Collection
        public void clear() {
            this.parent.buffer.clear(this);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public boolean enter() {
            return WIP.getAndIncrement(this) == 0;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public int fusionMode() {
            return this.fusionMode;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public int index() {
            return this.index;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public boolean isCancelled() {
            return this.requested == Long.MIN_VALUE;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.parent.buffer.isEmpty(this);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public int leave(int i) {
            return WIP.addAndGet(this, -i);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public void node(@Nullable Object obj) {
            this.node = obj;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.parent.buffer.poll(this);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public void produced(long j10) {
            REQUESTED.addAndGet(this, -j10);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription, reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            if (!Operators.validate(j10) || Operators.addCapCancellable(REQUESTED, this, j10) == Long.MIN_VALUE) {
                return;
            }
            this.totalRequested = Operators.addCap(this.totalRequested, j10);
            this.parent.buffer.replay(this);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.fusionMode = 2;
            return 2;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public void requestMore(int i) {
            this.index = i;
            long jMarkWorkAdded = ReplaySubscriber.markWorkAdded(this.parent);
            if (ReplaySubscriber.isDisposed(jMarkWorkAdded) || ReplaySubscriber.isWorkInProgress(jMarkWorkAdded)) {
                return;
            }
            this.parent.manageRequest(jMarkWorkAdded + 1);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public long requested() {
            return this.requested;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.parent.isTerminated()) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(Math.max(0L, this.requested)) : attr == Scannable.Attr.RUN_ON ? this.parent.parent.scheduler : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.parent.buffer.size(this);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public int tailIndex() {
            return this.tailIndex;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public void index(int i) {
            this.index = i;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        @Nullable
        public Object node() {
            return this.node;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplaySubscription
        public void tailIndex(int i) {
            this.tailIndex = i;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final int batchSize;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        final int indexUpdateLimit;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public UnboundedReplayBuffer(int i) {
            this.batchSize = i;
            this.indexUpdateLimit = Operators.unboundedOrLimit(i);
            Object[] objArr = new Object[i + 1];
            this.tail = objArr;
            this.head = objArr;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void add(T t10) {
            int i = this.tailIndex;
            Object[] objArr = this.tail;
            if (i == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t10;
                this.tailIndex = 1;
                objArr[i] = objArr2;
                this.tail = objArr2;
            } else {
                objArr[i] = t10;
                this.tailIndex = i + 1;
            }
            this.size++;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int capacity() {
            return Reader.READ_DONE;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void clear(ReplaySubscription<T> replaySubscription) {
            replaySubscription.node(null);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public Throwable getError() {
            return this.error;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isEmpty(ReplaySubscription<T> replaySubscription) {
            return replaySubscription.index() == this.size;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isExpired() {
            return false;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onComplete() {
            this.done = true;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public T poll(ReplaySubscription<T> replaySubscription) {
            int iIndex = replaySubscription.index();
            if (iIndex == this.size) {
                return null;
            }
            Object[] objArr = (Object[]) replaySubscription.node();
            if (objArr == null) {
                objArr = this.head;
                replaySubscription.node(objArr);
            }
            int iTailIndex = replaySubscription.tailIndex();
            if (iTailIndex == this.batchSize) {
                objArr = (Object[]) objArr[iTailIndex];
                replaySubscription.node(objArr);
                iTailIndex = 0;
            }
            T t10 = (T) objArr[iTailIndex];
            replaySubscription.tailIndex(iTailIndex + 1);
            int i = iIndex + 1;
            if (i % this.indexUpdateLimit == 0) {
                replaySubscription.requestMore(i);
                return t10;
            }
            replaySubscription.index(i);
            return t10;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.enter()) {
                if (replaySubscription.fusionMode() == 0) {
                    replayNormal(replaySubscription);
                } else {
                    replayFused(replaySubscription);
                }
            }
        }

        public void replayFused(ReplaySubscription<T> replaySubscription) {
            CoreSubscriber<? super T> coreSubscriberActual = replaySubscription.actual();
            int iLeave = 1;
            while (!replaySubscription.isCancelled()) {
                boolean z10 = this.done;
                coreSubscriberActual.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    if (th != null) {
                        coreSubscriberActual.onError(th);
                        return;
                    } else {
                        coreSubscriberActual.onComplete();
                        return;
                    }
                }
                iLeave = replaySubscription.leave(iLeave);
                if (iLeave == 0) {
                    return;
                }
            }
            replaySubscription.node(null);
        }

        public void replayNormal(ReplaySubscription<T> replaySubscription) {
            long j10;
            CoreSubscriber<? super T> coreSubscriberActual = replaySubscription.actual();
            int i = this.batchSize;
            int iLeave = 1;
            do {
                long jRequested = replaySubscription.requested();
                Object[] objArr = (Object[]) replaySubscription.node();
                if (objArr == null) {
                    objArr = this.head;
                }
                int iTailIndex = replaySubscription.tailIndex();
                int iIndex = replaySubscription.index();
                long j11 = 0;
                while (true) {
                    if (j11 == jRequested) {
                        j10 = 0;
                        break;
                    }
                    if (replaySubscription.isCancelled()) {
                        replaySubscription.node(null);
                        return;
                    }
                    j10 = 0;
                    boolean z10 = this.done;
                    boolean z11 = iIndex == this.size;
                    if (z10 && z11) {
                        replaySubscription.node(null);
                        Throwable th = this.error;
                        if (th != null) {
                            coreSubscriberActual.onError(th);
                            return;
                        } else {
                            coreSubscriberActual.onComplete();
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    if (iTailIndex == i) {
                        objArr = (Object[]) objArr[iTailIndex];
                        iTailIndex = 0;
                    }
                    coreSubscriberActual.onNext(objArr[iTailIndex]);
                    j11++;
                    iTailIndex++;
                    iIndex++;
                    if (iIndex % this.indexUpdateLimit == 0) {
                        replaySubscription.requestMore(iIndex);
                    }
                }
                if (j11 == jRequested) {
                    if (replaySubscription.isCancelled()) {
                        replaySubscription.node(null);
                        return;
                    }
                    boolean z12 = this.done;
                    boolean z13 = iIndex == this.size;
                    if (z12 && z13) {
                        replaySubscription.node(null);
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            coreSubscriberActual.onError(th2);
                            return;
                        } else {
                            coreSubscriberActual.onComplete();
                            return;
                        }
                    }
                }
                if (j11 != j10 && jRequested != Long.MAX_VALUE) {
                    replaySubscription.produced(j11);
                }
                replaySubscription.index(iIndex);
                replaySubscription.tailIndex(iTailIndex);
                replaySubscription.node(objArr);
                iLeave = replaySubscription.leave(iLeave);
            } while (iLeave != 0);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size(ReplaySubscription<T> replaySubscription) {
            return this.size - replaySubscription.index();
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size() {
            return this.size;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ReplaySubscriber<T> implements InnerConsumer<T>, Disposable {
        static final long CONNECTED_FLAG = 1152921504606846976L;
        static final long DISPOSED_FLAG = Long.MIN_VALUE;
        static final long SUBSCRIBED_FLAG = 2305843009213693952L;
        static final long WORK_IN_PROGRESS_MAX_VALUE = 1152921504606846975L;
        final ReplayBuffer<T> buffer;
        final int limit;
        int nextPrefetchIndex;
        final FluxReplay<T> parent;
        final long prefetch;
        int produced;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10666s;
        volatile long state;
        volatile ReplaySubscription<T>[] subscribers = EMPTY;
        static final AtomicLongFieldUpdater<ReplaySubscriber> STATE = AtomicLongFieldUpdater.newUpdater(ReplaySubscriber.class, "state");
        static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer, FluxReplay<T> fluxReplay, int i) {
            this.buffer = replayBuffer;
            this.parent = fluxReplay;
            this.prefetch = Operators.unboundedOrPrefetch(i);
            int iUnboundedOrLimit = Operators.unboundedOrLimit(i);
            this.limit = iUnboundedOrLimit;
            this.nextPrefetchIndex = iUnboundedOrLimit;
        }

        public static boolean isConnected(long j10) {
            return (j10 & CONNECTED_FLAG) == CONNECTED_FLAG;
        }

        public static boolean isDisposed(long j10) {
            return (j10 & DISPOSED_FLAG) == DISPOSED_FLAG;
        }

        public static boolean isSubscribed(long j10) {
            return (j10 & SUBSCRIBED_FLAG) == SUBSCRIBED_FLAG;
        }

        public static boolean isWorkInProgress(long j10) {
            return (j10 & WORK_IN_PROGRESS_MAX_VALUE) > 0;
        }

        public static boolean markConnected(ReplaySubscriber<?> replaySubscriber) {
            while (true) {
                long j10 = replaySubscriber.state;
                if (isConnected(j10)) {
                    return false;
                }
                ReplaySubscriber<?> replaySubscriber2 = replaySubscriber;
                if (STATE.compareAndSet(replaySubscriber2, j10, CONNECTED_FLAG | j10)) {
                    return true;
                }
                replaySubscriber = replaySubscriber2;
            }
        }

        public static long markDisposed(ReplaySubscriber<?> replaySubscriber) {
            long j10;
            while (true) {
                j10 = replaySubscriber.state;
                if (isDisposed(j10)) {
                    break;
                }
                ReplaySubscriber<?> replaySubscriber2 = replaySubscriber;
                if (STATE.compareAndSet(replaySubscriber2, j10, DISPOSED_FLAG | j10)) {
                    break;
                }
                replaySubscriber = replaySubscriber2;
            }
            return j10;
        }

        public static long markSubscribed(ReplaySubscriber<?> replaySubscriber) {
            long j10;
            while (true) {
                j10 = replaySubscriber.state;
                if (isDisposed(j10)) {
                    break;
                }
                ReplaySubscriber<?> replaySubscriber2 = replaySubscriber;
                if (STATE.compareAndSet(replaySubscriber2, j10, SUBSCRIBED_FLAG | j10)) {
                    break;
                }
                replaySubscriber = replaySubscriber2;
            }
            return j10;
        }

        public static long markWorkAdded(ReplaySubscriber<?> replaySubscriber) {
            long j10;
            while (true) {
                j10 = replaySubscriber.state;
                if (isDisposed(j10) || (j10 & WORK_IN_PROGRESS_MAX_VALUE) == WORK_IN_PROGRESS_MAX_VALUE) {
                    break;
                }
                ReplaySubscriber<?> replaySubscriber2 = replaySubscriber;
                if (STATE.compareAndSet(replaySubscriber2, j10, 1 + j10)) {
                    break;
                }
                replaySubscriber = replaySubscriber2;
            }
            return j10;
        }

        public static long markWorkDone(ReplaySubscriber<?> replaySubscriber, long j10) {
            while (true) {
                long j11 = replaySubscriber.state;
                if (j10 != j11) {
                    return j11;
                }
                long j12 = j11 & (-1152921504606846976L);
                ReplaySubscriber<?> replaySubscriber2 = replaySubscriber;
                if (STATE.compareAndSet(replaySubscriber2, j11, j12)) {
                    return j12;
                }
                replaySubscriber = replaySubscriber2;
            }
        }

        public boolean add(ReplayInner<T> replayInner) {
            ReplaySubscription<T>[] replaySubscriptionArr = this.subscribers;
            ReplaySubscription<T>[] replaySubscriptionArr2 = TERMINATED;
            if (replaySubscriptionArr == replaySubscriptionArr2) {
                return false;
            }
            synchronized (this) {
                try {
                    ReplaySubscription<T>[] replaySubscriptionArr3 = this.subscribers;
                    if (replaySubscriptionArr3 == replaySubscriptionArr2) {
                        return false;
                    }
                    int length = replaySubscriptionArr3.length;
                    ReplayInner[] replayInnerArr = new ReplayInner[length + 1];
                    System.arraycopy(replaySubscriptionArr3, 0, replayInnerArr, 0, length);
                    replayInnerArr[length] = replayInner;
                    this.subscribers = replayInnerArr;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Operators.multiSubscribersContext(this.subscribers);
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            FluxReplay.CONNECTION.compareAndSet(this.parent, this, null);
            long jMarkDisposed = markDisposed(this);
            if (isDisposed(jMarkDisposed)) {
                return;
            }
            if (isSubscribed(jMarkDisposed)) {
                this.f10666s.cancel();
            }
            CancellationException cancellationException = new CancellationException("Disconnected");
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.onError(cancellationException);
            for (ReplaySubscription<T> replaySubscription : terminate()) {
                replayBuffer.replay(replaySubscription);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        public boolean isTerminated() {
            return this.subscribers == TERMINATED;
        }

        public void manageRequest(long j10) {
            qd.e eVar = this.f10666s;
            do {
                int i = this.nextPrefetchIndex;
                ReplaySubscription<T>[] replaySubscriptionArr = this.subscribers;
                if (replaySubscriptionArr.length > 0) {
                    for (ReplaySubscription<T> replaySubscription : replaySubscriptionArr) {
                        if (replaySubscription.index() < i) {
                            break;
                        }
                    }
                    int i3 = this.limit;
                    this.nextPrefetchIndex = i + i3;
                    eVar.request(i3);
                } else if (this.produced >= i) {
                    int i32 = this.limit;
                    this.nextPrefetchIndex = i + i32;
                    eVar.request(i32);
                }
                j10 = markWorkDone(this, j10);
                if (isDisposed(j10)) {
                    return;
                }
            } while (isWorkInProgress(j10));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone()) {
                return;
            }
            replayBuffer.onComplete();
            for (ReplaySubscription<T> replaySubscription : terminate()) {
                replayBuffer.replay(replaySubscription);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone()) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            replayBuffer.onError(th);
            for (ReplaySubscription<T> replaySubscription : terminate()) {
                replayBuffer.replay(replaySubscription);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone()) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            this.produced++;
            replayBuffer.add(t10);
            ReplaySubscription<T>[] replaySubscriptionArr = this.subscribers;
            if (replaySubscriptionArr.length != 0) {
                for (ReplaySubscription<T> replaySubscription : replaySubscriptionArr) {
                    replayBuffer.replay(replaySubscription);
                }
                return;
            }
            if (this.produced % this.limit == 0) {
                long jMarkWorkAdded = markWorkAdded(this);
                if (isDisposed(jMarkWorkAdded) || isWorkInProgress(jMarkWorkAdded)) {
                    return;
                }
                manageRequest(jMarkWorkAdded + 1);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (this.buffer.isDone()) {
                eVar.cancel();
                return;
            }
            if (Operators.validate(this.f10666s, eVar)) {
                this.f10666s = eVar;
                if (isDisposed(markSubscribed(this))) {
                    eVar.cancel();
                } else {
                    eVar.request(this.prefetch);
                }
            }
        }

        public void remove(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            ReplaySubscription<T>[] replaySubscriptionArr3 = this.subscribers;
            ReplaySubscription<T>[] replaySubscriptionArr4 = TERMINATED;
            if (replaySubscriptionArr3 == replaySubscriptionArr4 || replaySubscriptionArr3 == (replaySubscriptionArr = EMPTY)) {
                return;
            }
            synchronized (this) {
                try {
                    ReplaySubscription<T>[] replaySubscriptionArr5 = this.subscribers;
                    if (replaySubscriptionArr5 != replaySubscriptionArr4 && replaySubscriptionArr5 != replaySubscriptionArr) {
                        int length = replaySubscriptionArr5.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                i = -1;
                                break;
                            } else if (replaySubscriptionArr5[i] != replaySubscription) {
                                i++;
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        if (length == 1) {
                            replaySubscriptionArr2 = EMPTY;
                        } else {
                            ReplayInner[] replayInnerArr = new ReplayInner[length - 1];
                            System.arraycopy(replaySubscriptionArr5, 0, replayInnerArr, 0, i);
                            System.arraycopy(replaySubscriptionArr5, i + 1, replayInnerArr, i, (length - i) - 1);
                            replaySubscriptionArr2 = replayInnerArr;
                        }
                        this.subscribers = replaySubscriptionArr2;
                    }
                } finally {
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10666s;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(Reader.READ_DONE);
            }
            if (attr == Scannable.Attr.CAPACITY) {
                return Integer.valueOf(this.buffer.capacity());
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.buffer.getError();
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.buffer.size());
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(isTerminated());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        public ReplaySubscription<T>[] terminate() {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2 = this.subscribers;
            ReplaySubscription<T>[] replaySubscriptionArr3 = TERMINATED;
            if (replaySubscriptionArr2 == replaySubscriptionArr3) {
                return replaySubscriptionArr2;
            }
            synchronized (this) {
                try {
                    replaySubscriptionArr = this.subscribers;
                    if (replaySubscriptionArr != replaySubscriptionArr3) {
                        this.subscribers = replaySubscriptionArr3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return replaySubscriptionArr;
        }

        public boolean tryConnect() {
            return markConnected(this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return isDisposed(this.state);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        static final long NOT_DONE = Long.MIN_VALUE;
        volatile long done = NOT_DONE;
        Throwable error;
        volatile TimedNode<T> head;
        final int indexUpdateLimit;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            final int index;
            final long time;
            final T value;

            public TimedNode(int i, @Nullable T t10, long j10) {
                this.index = i;
                this.value = t10;
                this.time = j10;
            }

            @Override // java.util.concurrent.atomic.AtomicReference
            public String toString() {
                return "TimedNode{index=" + this.index + ", value=" + this.value + ", time=" + this.time + '}';
            }
        }

        public SizeAndTimeBoundReplayBuffer(int i, long j10, Scheduler scheduler) {
            this.limit = i;
            this.indexUpdateLimit = Operators.unboundedOrLimit(i);
            this.maxAge = j10;
            this.scheduler = scheduler;
            TimedNode<T> timedNode = new TimedNode<>(-1, null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void add(T t10) {
            TimedNode<T> timedNode = this.tail;
            int i = timedNode.index + 1;
            Scheduler scheduler = this.scheduler;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            TimedNode<T> timedNode2 = new TimedNode<>(i, t10, scheduler.now(timeUnit));
            timedNode.set(timedNode2);
            this.tail = timedNode2;
            int i3 = this.size;
            if (i3 == this.limit) {
                this.head = this.head.get();
            } else {
                this.size = i3 + 1;
            }
            long jNow = this.scheduler.now(timeUnit);
            long j10 = this.maxAge;
            long j11 = jNow - j10;
            if (j10 == 0) {
                this.head = timedNode2;
                return;
            }
            TimedNode<T> timedNode3 = this.head;
            int i10 = 0;
            while (true) {
                TimedNode<T> timedNode4 = timedNode3.get();
                if (timedNode4 == null) {
                    return;
                }
                if (timedNode4.time > j11 || timedNode4 == timedNode2) {
                    break;
                }
                i10++;
                timedNode3 = timedNode4;
            }
            if (i10 != 0) {
                this.size -= i10;
                this.head = timedNode3;
            }
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int capacity() {
            return this.limit;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void clear(ReplaySubscription<T> replaySubscription) {
            replaySubscription.node(null);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public Throwable getError() {
            return this.error;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isDone() {
            return this.done != NOT_DONE;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isEmpty(ReplaySubscription<T> replaySubscription) {
            return latestHead(replaySubscription).get() == null;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isExpired() {
            long j10 = this.done;
            return j10 != NOT_DONE && this.scheduler.now(TimeUnit.NANOSECONDS) - this.maxAge > j10;
        }

        public TimedNode<T> latestHead(ReplaySubscription<T> replaySubscription) {
            long jNow = this.scheduler.now(TimeUnit.NANOSECONDS) - this.maxAge;
            TimedNode<T> timedNode = (TimedNode) replaySubscription.node();
            if (timedNode == null) {
                timedNode = this.head;
            }
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null || timedNode2.time > jNow) {
                    break;
                }
                timedNode = timedNode2;
            }
            return timedNode;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onComplete() {
            this.done = this.scheduler.now(TimeUnit.NANOSECONDS);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onError(Throwable th) {
            this.done = this.scheduler.now(TimeUnit.NANOSECONDS);
            this.error = th;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public T poll(ReplaySubscription<T> replaySubscription) {
            TimedNode<T> timedNode;
            TimedNode<T> timedNodeLatestHead = latestHead(replaySubscription);
            long jNow = this.scheduler.now(TimeUnit.NANOSECONDS) - this.maxAge;
            while (true) {
                timedNode = timedNodeLatestHead.get();
                if (timedNode == null) {
                    break;
                }
                if (timedNode.time > jNow) {
                    timedNodeLatestHead = timedNode;
                    break;
                }
                timedNodeLatestHead = timedNode;
            }
            if (timedNode != null) {
                replaySubscription.node(timedNode);
                int i = timedNode.index;
                if ((i + 1) % this.indexUpdateLimit == 0) {
                    replaySubscription.requestMore(i + 1);
                }
                return timedNodeLatestHead.value;
            }
            int i3 = timedNodeLatestHead.index;
            if (i3 == -1 || (i3 + 1) % this.indexUpdateLimit != 0) {
                return null;
            }
            replaySubscription.requestMore(i3 + 1);
            return null;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.enter()) {
                if (replaySubscription.fusionMode() == 0) {
                    replayNormal(replaySubscription);
                } else {
                    replayFused(replaySubscription);
                }
            }
        }

        public void replayFused(ReplaySubscription<T> replaySubscription) {
            CoreSubscriber<? super T> coreSubscriberActual = replaySubscription.actual();
            int iLeave = 1;
            while (!replaySubscription.isCancelled()) {
                boolean z10 = this.done != NOT_DONE;
                coreSubscriberActual.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    if (th != null) {
                        coreSubscriberActual.onError(th);
                        return;
                    } else {
                        coreSubscriberActual.onComplete();
                        return;
                    }
                }
                iLeave = replaySubscription.leave(iLeave);
                if (iLeave == 0) {
                    return;
                }
            }
            replaySubscription.node(null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
        
            if (r12 != r8) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
        
            if (r21.isCancelled() == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a6, code lost:
        
            r21.node(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a9, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        
            if (r20.done == r16) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b7, code lost:
        
            if (r5.get() != null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
        
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ba, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00bc, code lost:
        
            if (r15 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00be, code lost:
        
            r21.node(null);
            r0 = r20.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00c3, code lost:
        
            if (r0 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00c5, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c8, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c9, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00cc, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00cf, code lost:
        
            if (r12 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
        
            if (r8 == Long.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00da, code lost:
        
            r21.produced(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        
            r21.node(r5);
            r4 = r21.leave(r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void replayNormal(reactor.core.publisher.FluxReplay.ReplaySubscription<T> r21) {
            /*
                Method dump skipped, instructions count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxReplay.SizeAndTimeBoundReplayBuffer.replayNormal(reactor.core.publisher.FluxReplay$ReplaySubscription):void");
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size(ReplaySubscription<T> replaySubscription) {
            TimedNode<T> timedNodeLatestHead = latestHead(replaySubscription);
            int i = 0;
            while (true) {
                timedNodeLatestHead = timedNodeLatestHead.get();
                if (timedNodeLatestHead == null || i == Integer.MAX_VALUE) {
                    break;
                }
                i++;
            }
            return i;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size() {
            TimedNode<T> timedNode = this.head;
            int i = 0;
            while (true) {
                timedNode = timedNode.get();
                if (timedNode == null || i == Integer.MAX_VALUE) {
                    break;
                }
                i++;
            }
            return i;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int indexUpdateLimit;
        final int limit;
        int size;
        Node<T> tail;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final int index;
            final T value;

            public Node(int i, @Nullable T t10) {
                this.index = i;
                this.value = t10;
            }

            @Override // java.util.concurrent.atomic.AtomicReference
            public String toString() {
                return "Node(" + this.value + ")";
            }
        }

        public SizeBoundReplayBuffer(int i) {
            if (i < 0) {
                g5.f.s("Limit cannot be negative");
                throw null;
            }
            this.limit = i;
            this.indexUpdateLimit = Operators.unboundedOrLimit(i);
            Node<T> node = new Node<>(-1, null);
            this.tail = node;
            this.head = node;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void add(T t10) {
            Node<T> node = this.tail;
            Node<T> node2 = new Node<>(node.index + 1, t10);
            node.set(node2);
            this.tail = node2;
            int i = this.size;
            if (i == this.limit) {
                this.head = this.head.get();
            } else {
                this.size = i + 1;
            }
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int capacity() {
            return this.limit;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void clear(ReplaySubscription<T> replaySubscription) {
            replaySubscription.node(null);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public Throwable getError() {
            return this.error;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isEmpty(ReplaySubscription<T> replaySubscription) {
            Node<T> node = (Node) replaySubscription.node();
            if (node == null) {
                node = this.head;
                replaySubscription.node(node);
            }
            return node.get() == null;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public boolean isExpired() {
            return false;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onComplete() {
            this.done = true;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        @Nullable
        public T poll(ReplaySubscription<T> replaySubscription) {
            Node<T> node = (Node) replaySubscription.node();
            if (node == null) {
                node = this.head;
                replaySubscription.node(node);
            }
            Node<T> node2 = node.get();
            if (node2 == null) {
                return null;
            }
            replaySubscription.node(node2);
            int i = node2.index;
            if ((i + 1) % this.indexUpdateLimit == 0) {
                replaySubscription.requestMore(i + 1);
            }
            return node2.value;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.enter()) {
                if (replaySubscription.fusionMode() == 0) {
                    replayNormal(replaySubscription);
                } else {
                    replayFused(replaySubscription);
                }
            }
        }

        public void replayFused(ReplaySubscription<T> replaySubscription) {
            CoreSubscriber<? super T> coreSubscriberActual = replaySubscription.actual();
            int iLeave = 1;
            while (!replaySubscription.isCancelled()) {
                boolean z10 = this.done;
                coreSubscriberActual.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    if (th != null) {
                        coreSubscriberActual.onError(th);
                        return;
                    } else {
                        coreSubscriberActual.onComplete();
                        return;
                    }
                }
                iLeave = replaySubscription.leave(iLeave);
                if (iLeave == 0) {
                    return;
                }
            }
            replaySubscription.node(null);
        }

        public void replayNormal(ReplaySubscription<T> replaySubscription) {
            CoreSubscriber<? super T> coreSubscriberActual = replaySubscription.actual();
            int iLeave = 1;
            do {
                long jRequested = replaySubscription.requested();
                Node<T> node = (Node) replaySubscription.node();
                if (node == null) {
                    node = this.head;
                }
                long j10 = 0;
                while (true) {
                    if (j10 == jRequested) {
                        break;
                    }
                    if (replaySubscription.isCancelled()) {
                        replaySubscription.node(null);
                        return;
                    }
                    boolean z10 = this.done;
                    Node<T> node2 = node.get();
                    boolean z11 = node2 == null;
                    if (z10 && z11) {
                        replaySubscription.node(null);
                        Throwable th = this.error;
                        if (th != null) {
                            coreSubscriberActual.onError(th);
                            return;
                        } else {
                            coreSubscriberActual.onComplete();
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    coreSubscriberActual.onNext(node2.value);
                    j10++;
                    int i = node2.index;
                    if ((i + 1) % this.indexUpdateLimit == 0) {
                        replaySubscription.requestMore(i + 1);
                    }
                    node = node2;
                }
                if (j10 == jRequested) {
                    if (replaySubscription.isCancelled()) {
                        replaySubscription.node(null);
                        return;
                    }
                    boolean z12 = this.done;
                    boolean z13 = node.get() == null;
                    if (z12 && z13) {
                        replaySubscription.node(null);
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            coreSubscriberActual.onError(th2);
                            return;
                        } else {
                            coreSubscriberActual.onComplete();
                            return;
                        }
                    }
                }
                if (j10 != 0 && jRequested != Long.MAX_VALUE) {
                    replaySubscription.produced(j10);
                }
                replaySubscription.node(node);
                iLeave = replaySubscription.leave(iLeave);
            } while (iLeave != 0);
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size(ReplaySubscription<T> replaySubscription) {
            Node<T> node = (Node) replaySubscription.node();
            if (node == null) {
                node = this.head;
            }
            int i = 0;
            while (true) {
                node = node.get();
                if (node == null || i == Integer.MAX_VALUE) {
                    break;
                }
                i++;
            }
            return i;
        }

        @Override // reactor.core.publisher.FluxReplay.ReplayBuffer
        public int size() {
            Node<T> node = this.head;
            int i = 0;
            while (true) {
                node = node.get();
                if (node == null || i == Integer.MAX_VALUE) {
                    break;
                }
                i++;
            }
            return i;
        }
    }
}
