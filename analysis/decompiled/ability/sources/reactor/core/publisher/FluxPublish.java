package reactor.core.publisher;

import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxPublish<T> extends ConnectableFlux<T> implements Scannable {
    static final AtomicReferenceFieldUpdater<FluxPublish, PublishSubscriber> CONNECTION = AtomicReferenceFieldUpdater.newUpdater(FluxPublish.class, PublishSubscriber.class, "connection");
    volatile PublishSubscriber<T> connection;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final boolean resetUponSourceTermination;
    final Flux<? extends T> source;

    public static abstract class PubSubInner<T> implements InnerProducer<T> {
        static final AtomicLongFieldUpdater<PubSubInner> REQUESTED = AtomicLongFieldUpdater.newUpdater(PubSubInner.class, "requested");
        final CoreSubscriber<? super T> actual;
        volatile long requested;

        public PubSubInner(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public final void cancel() {
            if (this.requested == Long.MIN_VALUE || REQUESTED.getAndSet(this, Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            removeAndDrainParent();
        }

        public abstract void drainParent();

        public final boolean isCancelled() {
            return this.requested == Long.MIN_VALUE;
        }

        public abstract void removeAndDrainParent();

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public final void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCapCancellable(REQUESTED, this, j5);
                drainParent();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled());
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(isCancelled() ? 0L : this.requested);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class PublishInner<T> extends PubSubInner<T> {
        PublishSubscriber<T> parent;

        public PublishInner(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxPublish.PubSubInner
        public void drainParent() {
            PublishSubscriber<T> publishSubscriber = this.parent;
            if (publishSubscriber != null) {
                publishSubscriber.drainFromInner();
            }
        }

        @Override // reactor.core.publisher.FluxPublish.PubSubInner
        public void removeAndDrainParent() {
            PublishSubscriber<T> publishSubscriber = this.parent;
            if (publishSubscriber != null) {
                publishSubscriber.remove(this);
                publishSubscriber.drainFromInner();
            }
        }

        @Override // reactor.core.publisher.FluxPublish.PubSubInner, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr != Scannable.Attr.TERMINATED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            PublishSubscriber<T> publishSubscriber = this.parent;
            return Boolean.valueOf(publishSubscriber != null && publishSubscriber.isTerminated());
        }
    }

    public static final class PublishSubscriber<T> implements InnerConsumer<T>, Disposable {
        static final long CANCELLED_FLAG = 2305843009213693952L;
        static final long CONNECTED_FLAG = 288230376151711744L;
        static final long FINALIZED_FLAG = Long.MIN_VALUE;
        static final long SUBSCRIPTION_SET_FLAG = 576460752303423488L;
        static final long TERMINATED_FLAG = 4611686018427387904L;
        static final long WORK_IN_PROGRESS_MASK = 4294967295L;
        boolean done;
        volatile Throwable error;
        final FluxPublish<T> parent;
        final int prefetch;
        Queue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5776s;
        int sourceMode;
        volatile long state;
        volatile PubSubInner<T>[] subscribers;
        static final AtomicReferenceFieldUpdater<PublishSubscriber, PubSubInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(PublishSubscriber.class, PubSubInner[].class, "subscribers");
        static final AtomicLongFieldUpdater<PublishSubscriber> STATE = AtomicLongFieldUpdater.newUpdater(PublishSubscriber.class, "state");
        static final PubSubInner[] INIT = new PublishInner[0];
        static final PubSubInner[] CANCELLED = new PublishInner[0];
        static final PubSubInner[] TERMINATED = new PublishInner[0];
        static final AtomicReferenceFieldUpdater<PublishSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(PublishSubscriber.class, Throwable.class, "error");

        public PublishSubscriber(int i, FluxPublish<T> fluxPublish) {
            this.prefetch = i;
            this.parent = fluxPublish;
            SUBSCRIBERS.lazySet(this, INIT);
        }

        public static long addWork(long j5) {
            return (j5 & WORK_IN_PROGRESS_MASK) == WORK_IN_PROGRESS_MASK ? (j5 & (-4294967296L)) | 1 : j5 + 1;
        }

        public static long addWorkIfSubscribed(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (!isSubscriptionSet(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, addWork(j5))) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static void clearAndFinalize(PublishSubscriber<?> publishSubscriber) {
            while (true) {
                long j5 = publishSubscriber.state;
                if (isFinalized(j5)) {
                    publishSubscriber.clear();
                    return;
                }
                if (isSubscriptionSet(j5)) {
                    publishSubscriber.clear();
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, ((-4294967296L) & j5) | Long.MIN_VALUE)) {
                    return;
                } else {
                    publishSubscriber = publishSubscriber2;
                }
            }
        }

        public static boolean hasWorkInProgress(long j5) {
            return (j5 & WORK_IN_PROGRESS_MASK) > 0;
        }

        public static boolean isCancelled(long j5) {
            return (j5 & CANCELLED_FLAG) == CANCELLED_FLAG;
        }

        public static boolean isConnected(long j5) {
            return (j5 & CONNECTED_FLAG) == CONNECTED_FLAG;
        }

        public static boolean isFinalized(long j5) {
            return (j5 & Long.MIN_VALUE) == Long.MIN_VALUE;
        }

        public static boolean isSubscriptionSet(long j5) {
            return (j5 & SUBSCRIPTION_SET_FLAG) == SUBSCRIPTION_SET_FLAG;
        }

        public static boolean isTerminated(long j5) {
            return (j5 & 4611686018427387904L) == 4611686018427387904L;
        }

        public static long markCancelled(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (isCancelled(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, addWork(j5) | CANCELLED_FLAG)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static long markConnected(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (isConnected(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, CONNECTED_FLAG | j5)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static long markSubscriptionSet(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (isCancelled(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, SUBSCRIPTION_SET_FLAG | j5)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static long markSubscriptionSetAndAddWork(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (isCancelled(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, addWork(j5) | SUBSCRIPTION_SET_FLAG)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static long markTerminated(PublishSubscriber<?> publishSubscriber) {
            long j5;
            while (true) {
                j5 = publishSubscriber.state;
                if (isCancelled(j5) || isTerminated(j5)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, addWork(j5) | 4611686018427387904L)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j5;
        }

        public static long markWorkDone(PublishSubscriber<?> publishSubscriber, long j5) {
            while (true) {
                long j6 = publishSubscriber.state;
                if (j5 != j6) {
                    return j6;
                }
                long j10 = j6 & (-4294967296L);
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j6, j10)) {
                    return j10;
                }
                publishSubscriber = publishSubscriber2;
            }
        }

        public boolean add(PublishInner<T> publishInner) {
            PubSubInner<T>[] pubSubInnerArr;
            PubSubInner[] pubSubInnerArr2;
            do {
                pubSubInnerArr = this.subscribers;
                if (pubSubInnerArr == TERMINATED) {
                    return false;
                }
                int length = pubSubInnerArr.length;
                pubSubInnerArr2 = new PubSubInner[length + 1];
                System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr2, 0, length);
                pubSubInnerArr2[length] = publishInner;
            } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
            return true;
        }

        public boolean checkTerminated(boolean z10, boolean z11, @Nullable T t9) {
            long j5 = this.state;
            if (isCancelled(j5)) {
                Operators.onDiscard(t9, currentContext());
                disconnectAction(j5);
                return true;
            }
            int i = 0;
            if (z10) {
                Throwable thTerminate = this.error;
                if (thTerminate != null && thTerminate != Exceptions.TERMINATED) {
                    FluxPublish<T> fluxPublish = this.parent;
                    if (fluxPublish.resetUponSourceTermination) {
                        FluxPublish.CONNECTION.compareAndSet(fluxPublish, this, null);
                        thTerminate = Exceptions.terminate(ERROR, this);
                    }
                    this.queue.clear();
                    PubSubInner<T>[] pubSubInnerArrTerminate = terminate();
                    int length = pubSubInnerArrTerminate.length;
                    while (i < length) {
                        pubSubInnerArrTerminate[i].actual.onError(thTerminate);
                        i++;
                    }
                    return true;
                }
                if (z11) {
                    FluxPublish<T> fluxPublish2 = this.parent;
                    if (fluxPublish2.resetUponSourceTermination) {
                        FluxPublish.CONNECTION.compareAndSet(fluxPublish2, this, null);
                    }
                    PubSubInner<T>[] pubSubInnerArrTerminate2 = terminate();
                    int length2 = pubSubInnerArrTerminate2.length;
                    while (i < length2) {
                        pubSubInnerArrTerminate2[i].actual.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            if (this.sourceMode != 0) {
                this.queue.clear();
                return;
            }
            while (true) {
                T tPoll = this.queue.poll();
                if (tPoll == null) {
                    return;
                } else {
                    Operators.onDiscard(tPoll, currentContext());
                }
            }
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Operators.multiSubscribersContext(this.subscribers);
        }

        public void disconnectAction(long j5) {
            if (isSubscriptionSet(j5)) {
                this.f5776s.cancel();
                clear();
            }
            PubSubInner[] andSet = SUBSCRIBERS.getAndSet(this, CANCELLED);
            if (andSet.length > 0) {
                CancellationException cancellationException = new CancellationException("Disconnected");
                for (PubSubInner pubSubInner : andSet) {
                    pubSubInner.actual.onError(cancellationException);
                }
            }
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (SUBSCRIBERS.get(this) != TERMINATED && FluxPublish.CONNECTION.compareAndSet(this.parent, this, null)) {
                long jMarkCancelled = markCancelled(this);
                if (isTerminated(jMarkCancelled) || isCancelled(jMarkCancelled) || hasWorkInProgress(jMarkCancelled)) {
                    return;
                }
                disconnectAction(jMarkCancelled);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0120 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0124  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void drain(long r25) {
            /*
                Method dump skipped, instructions count: 299
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxPublish.PublishSubscriber.drain(long):void");
        }

        public final void drainFromInner() {
            long jAddWorkIfSubscribed = addWorkIfSubscribed(this);
            if (isSubscriptionSet(jAddWorkIfSubscribed) && !hasWorkInProgress(jAddWorkIfSubscribed)) {
                drain(jAddWorkIfSubscribed + 1);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            long j5 = this.state;
            return isTerminated(j5) || isCancelled(j5);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long jMarkTerminated = markTerminated(this);
            if (isTerminated(jMarkTerminated) || isCancelled(jMarkTerminated) || hasWorkInProgress(jMarkTerminated)) {
                return;
            }
            drain((jMarkTerminated | 4611686018427387904L) + 1);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDroppedMulticast(th, this.subscribers);
                return;
            }
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDroppedMulticast(th, this.subscribers);
                return;
            }
            this.done = true;
            long jMarkTerminated = markTerminated(this);
            if (isTerminated(jMarkTerminated) || isCancelled(jMarkTerminated) || hasWorkInProgress(jMarkTerminated)) {
                return;
            }
            drain((jMarkTerminated | 4611686018427387904L) + 1);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(@Nullable T t9) {
            if (this.done) {
                if (t9 != null) {
                    Operators.onNextDropped(t9, currentContext());
                    return;
                }
                return;
            }
            if (this.sourceMode != 2 && !this.queue.offer(t9)) {
                Throwable thOnOperatorError = Operators.onOperatorError(this.f5776s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, currentContext());
                if (!Exceptions.addThrowable(ERROR, this, thOnOperatorError)) {
                    Operators.onErrorDroppedMulticast(thOnOperatorError, this.subscribers);
                    return;
                }
                this.done = true;
            }
            long jAddWork = addWork((PublishSubscriber<?>) this);
            if (isFinalized(jAddWork)) {
                clear();
            } else {
                if (isTerminated(jAddWork) || isCancelled(jAddWork) || hasWorkInProgress(jAddWork)) {
                    return;
                }
                drain(jAddWork + 1);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5776s, eVar)) {
                this.f5776s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        long jMarkSubscriptionSetAndAddWork = markSubscriptionSetAndAddWork(this);
                        if (isCancelled(jMarkSubscriptionSetAndAddWork)) {
                            eVar.cancel();
                            return;
                        } else {
                            if (hasWorkInProgress(jMarkSubscriptionSetAndAddWork)) {
                                return;
                            }
                            drain(jMarkSubscriptionSetAndAddWork | 576460752303423489L);
                            return;
                        }
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        if (isCancelled(markSubscriptionSet(this))) {
                            eVar.cancel();
                            return;
                        } else {
                            eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                            return;
                        }
                    }
                }
                this.queue = this.parent.queueSupplier.get();
                if (isCancelled(markSubscriptionSet(this))) {
                    eVar.cancel();
                } else {
                    eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                }
            }
        }

        public void remove(PubSubInner<T> pubSubInner) {
            PubSubInner<T>[] pubSubInnerArr;
            PubSubInner[] pubSubInnerArr2;
            do {
                pubSubInnerArr = this.subscribers;
                if (pubSubInnerArr == TERMINATED || pubSubInnerArr == CANCELLED) {
                    return;
                }
                int length = pubSubInnerArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (pubSubInnerArr[i] == pubSubInner) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    pubSubInnerArr2 = CANCELLED;
                } else {
                    PubSubInner[] pubSubInnerArr3 = new PubSubInner[length - 1];
                    System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr3, 0, i);
                    System.arraycopy(pubSubInnerArr, i + 1, pubSubInnerArr3, i, (length - i) - 1);
                    pubSubInnerArr2 = pubSubInnerArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5776s;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.BUFFERED) {
                Queue<T> queue = this.queue;
                return Integer.valueOf(queue != null ? queue.size() : 0);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(isTerminated());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5776s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        public PubSubInner<T>[] terminate() {
            return SUBSCRIBERS.getAndSet(this, TERMINATED);
        }

        public boolean tryConnect() {
            return !isConnected(markConnected(this));
        }

        public static long addWork(PublishSubscriber<?> publishSubscriber) {
            while (true) {
                long j5 = publishSubscriber.state;
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j5, addWork(j5))) {
                    return j5;
                }
                publishSubscriber = publishSubscriber2;
            }
        }

        public boolean isTerminated() {
            return this.subscribers == TERMINATED;
        }
    }

    public FluxPublish(Flux<? extends T> flux, int i, Supplier<? extends Queue<T>> supplier, boolean z10) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "bufferSize > 0 required but it was "));
        }
        Objects.requireNonNull(flux, AgentBusWakeContract.EXTRA_SOURCE);
        this.source = Flux.from(flux);
        this.prefetch = i;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.resetUponSourceTermination = z10;
    }

    @Override // reactor.core.publisher.ConnectableFlux
    public void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.connection;
            if (publishSubscriber != null && !publishSubscriber.isTerminated()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.prefetch, this);
            if (CONNECTION.compareAndSet(this, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean zTryConnect = publishSubscriber.tryConnect();
        consumer.accept(publishSubscriber);
        if (zTryConnect) {
            this.source.subscribe((CoreSubscriber<? super Object>) publishSubscriber);
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
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
        PublishInner<T> publishInner = new PublishInner<>(coreSubscriber);
        coreSubscriber.onSubscribe(publishInner);
        while (!publishInner.isCancelled()) {
            PublishSubscriber<T> publishSubscriber = this.connection;
            if (publishSubscriber == null || (this.resetUponSourceTermination && publishSubscriber.isTerminated())) {
                PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.prefetch, this);
                if (CONNECTION.compareAndSet(this, publishSubscriber, publishSubscriber2)) {
                    publishSubscriber = publishSubscriber2;
                } else {
                    continue;
                }
            }
            if (publishSubscriber.add(publishInner)) {
                if (publishInner.isCancelled()) {
                    publishSubscriber.remove(publishInner);
                } else {
                    publishInner.parent = publishSubscriber;
                }
                publishSubscriber.drainFromInner();
                return;
            }
            if (!this.resetUponSourceTermination) {
                if (publishSubscriber.error != null) {
                    publishInner.actual.onError(publishSubscriber.error);
                    return;
                } else {
                    publishInner.actual.onComplete();
                    return;
                }
            }
        }
    }
}
