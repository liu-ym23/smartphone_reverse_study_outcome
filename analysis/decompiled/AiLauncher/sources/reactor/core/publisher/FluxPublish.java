package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public final void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCapCancellable(REQUESTED, this, j10);
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
        qc.d f39546s;
        int sourceMode;
        volatile long state;
        volatile PubSubInner<T>[] subscribers;
        static final AtomicReferenceFieldUpdater<PublishSubscriber, PubSubInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(PublishSubscriber.class, PubSubInner[].class, "subscribers");
        static final AtomicLongFieldUpdater<PublishSubscriber> STATE = AtomicLongFieldUpdater.newUpdater(PublishSubscriber.class, VoiceWakeupReceiver.EXTRA_STATE);
        static final PubSubInner[] INIT = new PublishInner[0];
        static final PubSubInner[] CANCELLED = new PublishInner[0];
        static final PubSubInner[] TERMINATED = new PublishInner[0];
        static final AtomicReferenceFieldUpdater<PublishSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(PublishSubscriber.class, Throwable.class, "error");

        public PublishSubscriber(int i10, FluxPublish<T> fluxPublish) {
            this.prefetch = i10;
            this.parent = fluxPublish;
            SUBSCRIBERS.lazySet(this, INIT);
        }

        public static long addWork(long j10) {
            return (j10 & WORK_IN_PROGRESS_MASK) == WORK_IN_PROGRESS_MASK ? (j10 & (-4294967296L)) | 1 : j10 + 1;
        }

        public static long addWorkIfSubscribed(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (!isSubscriptionSet(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, addWork(j10))) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static void clearAndFinalize(PublishSubscriber<?> publishSubscriber) {
            while (true) {
                long j10 = publishSubscriber.state;
                if (isFinalized(j10)) {
                    publishSubscriber.clear();
                    return;
                }
                if (isSubscriptionSet(j10)) {
                    publishSubscriber.clear();
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, ((-4294967296L) & j10) | FINALIZED_FLAG)) {
                    return;
                } else {
                    publishSubscriber = publishSubscriber2;
                }
            }
        }

        public static boolean hasWorkInProgress(long j10) {
            return (j10 & WORK_IN_PROGRESS_MASK) > 0;
        }

        public static boolean isCancelled(long j10) {
            return (j10 & CANCELLED_FLAG) == CANCELLED_FLAG;
        }

        public static boolean isConnected(long j10) {
            return (j10 & CONNECTED_FLAG) == CONNECTED_FLAG;
        }

        public static boolean isFinalized(long j10) {
            return (j10 & FINALIZED_FLAG) == FINALIZED_FLAG;
        }

        public static boolean isSubscriptionSet(long j10) {
            return (j10 & SUBSCRIPTION_SET_FLAG) == SUBSCRIPTION_SET_FLAG;
        }

        public static boolean isTerminated(long j10) {
            return (j10 & TERMINATED_FLAG) == TERMINATED_FLAG;
        }

        public static long markCancelled(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (isCancelled(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, addWork(j10) | CANCELLED_FLAG)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static long markConnected(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (isConnected(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, CONNECTED_FLAG | j10)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static long markSubscriptionSet(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (isCancelled(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, SUBSCRIPTION_SET_FLAG | j10)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static long markSubscriptionSetAndAddWork(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (isCancelled(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, addWork(j10) | SUBSCRIPTION_SET_FLAG)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static long markTerminated(PublishSubscriber<?> publishSubscriber) {
            long j10;
            while (true) {
                j10 = publishSubscriber.state;
                if (isCancelled(j10) || isTerminated(j10)) {
                    break;
                }
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, addWork(j10) | TERMINATED_FLAG)) {
                    break;
                }
                publishSubscriber = publishSubscriber2;
            }
            return j10;
        }

        public static long markWorkDone(PublishSubscriber<?> publishSubscriber, long j10) {
            while (true) {
                long j11 = publishSubscriber.state;
                if (j10 != j11) {
                    return j11;
                }
                long j12 = j11 & (-4294967296L);
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j11, j12)) {
                    return j12;
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

        public boolean checkTerminated(boolean z10, boolean z11, @Nullable T t10) {
            long j10 = this.state;
            if (isCancelled(j10)) {
                Operators.onDiscard(t10, currentContext());
                disconnectAction(j10);
                return true;
            }
            int i10 = 0;
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
                    while (i10 < length) {
                        pubSubInnerArrTerminate[i10].actual.onError(thTerminate);
                        i10++;
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
                    while (i10 < length2) {
                        pubSubInnerArrTerminate2[i10].actual.onComplete();
                        i10++;
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

        public void disconnectAction(long j10) {
            if (isSubscriptionSet(j10)) {
                this.f39546s.cancel();
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
            long j10 = this.state;
            return isTerminated(j10) || isCancelled(j10);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long jMarkTerminated = markTerminated(this);
            if (isTerminated(jMarkTerminated) || isCancelled(jMarkTerminated) || hasWorkInProgress(jMarkTerminated)) {
                return;
            }
            drain((jMarkTerminated | TERMINATED_FLAG) + 1);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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
            drain((jMarkTerminated | TERMINATED_FLAG) + 1);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(@Nullable T t10) {
            if (this.done) {
                if (t10 != null) {
                    Operators.onNextDropped(t10, currentContext());
                    return;
                }
                return;
            }
            if (this.sourceMode != 2 && !this.queue.offer(t10)) {
                Throwable thOnOperatorError = Operators.onOperatorError(this.f39546s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, currentContext());
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

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39546s, dVar)) {
                this.f39546s = dVar;
                if (dVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) dVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        long jMarkSubscriptionSetAndAddWork = markSubscriptionSetAndAddWork(this);
                        if (isCancelled(jMarkSubscriptionSetAndAddWork)) {
                            dVar.cancel();
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
                            dVar.cancel();
                            return;
                        } else {
                            dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                            return;
                        }
                    }
                }
                this.queue = this.parent.queueSupplier.get();
                if (isCancelled(markSubscriptionSet(this))) {
                    dVar.cancel();
                } else {
                    dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
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
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (pubSubInnerArr[i10] == pubSubInner) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    pubSubInnerArr2 = CANCELLED;
                } else {
                    PubSubInner[] pubSubInnerArr3 = new PubSubInner[length - 1];
                    System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr3, 0, i10);
                    System.arraycopy(pubSubInnerArr, i10 + 1, pubSubInnerArr3, i10, (length - i10) - 1);
                    pubSubInnerArr2 = pubSubInnerArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39546s;
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
                return Boolean.valueOf(this.f39546s == Operators.cancelledSubscription());
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
                long j10 = publishSubscriber.state;
                PublishSubscriber<?> publishSubscriber2 = publishSubscriber;
                if (STATE.compareAndSet(publishSubscriber2, j10, addWork(j10))) {
                    return j10;
                }
                publishSubscriber = publishSubscriber2;
            }
        }

        public boolean isTerminated() {
            return this.subscribers == TERMINATED;
        }
    }

    public FluxPublish(Flux<? extends T> flux, int i10, Supplier<? extends Queue<T>> supplier, boolean z10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("bufferSize > 0 required but it was " + i10);
        }
        Objects.requireNonNull(flux, "source");
        this.source = Flux.from(flux);
        this.prefetch = i10;
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
