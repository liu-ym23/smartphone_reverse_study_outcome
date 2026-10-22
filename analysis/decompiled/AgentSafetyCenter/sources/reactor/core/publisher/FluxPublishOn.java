package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxPublishOn<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final boolean delayError;
    final int lowTide;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PublishOnConditionalSubscriber<T> implements Fuseable.QueueSubscription<T>, Runnable, InnerOperator<T, T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        final boolean delayError;
        volatile int discardGuard;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10660s;
        final Scheduler scheduler;
        int sourceMode;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicIntegerFieldUpdater<PublishOnConditionalSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "wip");
        static final AtomicIntegerFieldUpdater<PublishOnConditionalSubscriber> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "discardGuard");
        static final AtomicLongFieldUpdater<PublishOnConditionalSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "requested");

        public PublishOnConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler scheduler, Scheduler.Worker worker, boolean z10, int i, int i3, Supplier<? extends Queue<T>> supplier) {
            this.actual = conditionalSubscriber;
            this.worker = worker;
            this.scheduler = scheduler;
            this.delayError = z10;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i, i3);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f10660s.cancel();
            this.worker.dispose();
            if (WIP.getAndIncrement(this) == 0) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else {
                    if (this.outputFused) {
                        return;
                    }
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qd.d dVar, @Nullable T t10) {
            if (this.cancelled) {
                Operators.onDiscard(t10, this.actual.currentContext());
                int i = this.sourceMode;
                Queue<T> queue = this.queue;
                if (i == 2) {
                    queue.clear();
                } else {
                    Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    doError(dVar, th);
                } else {
                    doComplete(dVar);
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 == null) {
                if (!z11) {
                    return false;
                }
                doComplete(dVar);
                return true;
            }
            Operators.onDiscard(t10, this.actual.currentContext());
            int i3 = this.sourceMode;
            Queue<T> queue2 = this.queue;
            if (i3 == 2) {
                queue2.clear();
            } else {
                Operators.onDiscardQueueWithClear(queue2, this.actual.currentContext(), null);
            }
            doError(dVar, th2);
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            if (DISCARD_GUARD.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                int i = this.discardGuard;
                if (iAddAndGet == i) {
                    iAddAndGet = DISCARD_GUARD.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        public void doComplete(qd.d dVar) {
            dVar.onComplete();
            this.worker.dispose();
        }

        public void doError(qd.d dVar, Throwable th) {
            try {
                dVar.onError(th);
            } finally {
                this.worker.dispose();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule(null, null, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                trySchedule(this, null, null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            if (this.cancelled) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            if (!this.queue.offer(t10)) {
                Operators.onDiscard(t10, this.actual.currentContext());
                this.error = Operators.onOperatorError(this.f10660s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, this.actual.currentContext());
                this.done = true;
            }
            trySchedule(this, null, t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10660s, eVar)) {
                this.f10660s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j10 = this.consumed + 1;
                if (j10 == this.limit) {
                    this.consumed = 0L;
                    this.f10660s.request(j10);
                    return tPoll;
                }
                this.consumed = j10;
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                trySchedule(this, null, null);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        public void runAsync() {
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            Queue<T> queue = this.queue;
            long j10 = this.produced;
            long j11 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j12 = this.requested;
                while (j10 != j12) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = queue.poll();
                        boolean z11 = tPoll == null;
                        if (checkTerminated(z10, z11, conditionalSubscriber, tPoll)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(tPoll)) {
                            j10++;
                        }
                        j11++;
                        if (j11 == this.limit) {
                            this.f10660s.request(j11);
                            j11 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f10660s.cancel();
                        queue.clear();
                        doError(conditionalSubscriber, Operators.onOperatorError(th, this.actual.currentContext()));
                        return;
                    }
                }
                if (j10 == j12 && checkTerminated(this.done, queue.isEmpty(), conditionalSubscriber, null)) {
                    return;
                }
                int i = this.wip;
                if (iAddAndGet == i) {
                    this.produced = j10;
                    this.consumed = j11;
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        public void runBackfused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.actual.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                    if (th != null) {
                        doError(conditionalSubscriber, th);
                        return;
                    } else {
                        doComplete(conditionalSubscriber);
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            clear();
        }

        public void runSync() {
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            Queue<T> queue = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested;
                while (j10 != j11) {
                    try {
                        T tPoll = queue.poll();
                        if (this.cancelled) {
                            Operators.onDiscard(tPoll, this.actual.currentContext());
                            Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                            return;
                        } else if (tPoll == null) {
                            doComplete(conditionalSubscriber);
                            return;
                        } else if (conditionalSubscriber.tryOnNext(tPoll)) {
                            j10++;
                        }
                    } catch (Throwable th) {
                        doError(conditionalSubscriber, Operators.onOperatorError(this.f10660s, th, this.actual.currentContext()));
                        return;
                    }
                }
                if (this.cancelled) {
                    Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                    return;
                }
                if (queue.isEmpty()) {
                    doComplete(conditionalSubscriber);
                    return;
                }
                int i = this.wip;
                if (iAddAndGet == i) {
                    this.produced = j10;
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10660s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
            }
            Queue<T> queue = this.queue;
            return Integer.valueOf(queue != null ? queue.size() : 0);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        public void trySchedule(@Nullable qd.e eVar, @Nullable Throwable th, @Nullable Object obj) {
            if (WIP.getAndIncrement(this) != 0) {
                if (this.cancelled) {
                    if (this.sourceMode == 2) {
                        this.queue.clear();
                        return;
                    } else {
                        Operators.onDiscard(obj, this.actual.currentContext());
                        return;
                    }
                }
                return;
            }
            try {
                this.worker.schedule(this);
            } catch (RejectedExecutionException e10) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else if (this.outputFused) {
                    clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
                boolean z10 = this.cancelled;
                Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                if (z10) {
                    Operators.onErrorDropped(e10, conditionalSubscriber.currentContext());
                } else {
                    conditionalSubscriber.onError(Operators.onRejectedExecution(e10, eVar, th, obj, conditionalSubscriber.currentContext()));
                }
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PublishOnSubscriber<T> implements Fuseable.QueueSubscription<T>, Runnable, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile int discardGuard;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10661s;
        final Scheduler scheduler;
        int sourceMode;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicIntegerFieldUpdater<PublishOnSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(PublishOnSubscriber.class, "wip");
        static final AtomicIntegerFieldUpdater<PublishOnSubscriber> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(PublishOnSubscriber.class, "discardGuard");
        static final AtomicLongFieldUpdater<PublishOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(PublishOnSubscriber.class, "requested");

        public PublishOnSubscriber(CoreSubscriber<? super T> coreSubscriber, Scheduler scheduler, Scheduler.Worker worker, boolean z10, int i, int i3, Supplier<? extends Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.worker = worker;
            this.scheduler = scheduler;
            this.delayError = z10;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i, i3);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f10661s.cancel();
            this.worker.dispose();
            if (WIP.getAndIncrement(this) == 0) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else {
                    if (this.outputFused) {
                        return;
                    }
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qd.d dVar, @Nullable T t10) {
            if (this.cancelled) {
                Operators.onDiscard(t10, this.actual.currentContext());
                int i = this.sourceMode;
                Queue<T> queue = this.queue;
                if (i == 2) {
                    queue.clear();
                } else {
                    Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    doError(dVar, th);
                } else {
                    doComplete(dVar);
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 == null) {
                if (!z11) {
                    return false;
                }
                doComplete(dVar);
                return true;
            }
            Operators.onDiscard(t10, this.actual.currentContext());
            int i3 = this.sourceMode;
            Queue<T> queue2 = this.queue;
            if (i3 == 2) {
                queue2.clear();
            } else {
                Operators.onDiscardQueueWithClear(queue2, this.actual.currentContext(), null);
            }
            doError(dVar, th2);
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            if (DISCARD_GUARD.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                int i = this.discardGuard;
                if (iAddAndGet == i) {
                    iAddAndGet = DISCARD_GUARD.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        public void doComplete(qd.d dVar) {
            dVar.onComplete();
            this.worker.dispose();
        }

        public void doError(qd.d dVar, Throwable th) {
            try {
                dVar.onError(th);
            } finally {
                this.worker.dispose();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule(null, null, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                trySchedule(this, null, null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            if (this.cancelled) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            if (!this.queue.offer(t10)) {
                Operators.onDiscard(t10, this.actual.currentContext());
                this.error = Operators.onOperatorError(this.f10661s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, this.actual.currentContext());
                this.done = true;
            }
            trySchedule(this, null, t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10661s, eVar)) {
                this.f10661s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j10 = this.produced + 1;
                if (j10 == this.limit) {
                    this.produced = 0L;
                    this.f10661s.request(j10);
                    return tPoll;
                }
                this.produced = j10;
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                trySchedule(this, null, null);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        public void runAsync() {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            Queue<T> queue = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested;
                while (j10 != jAddAndGet) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = queue.poll();
                        boolean z11 = tPoll == null;
                        if (checkTerminated(z10, z11, coreSubscriber, tPoll)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        coreSubscriber.onNext(tPoll);
                        j10++;
                        if (j10 == this.limit) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = REQUESTED.addAndGet(this, -j10);
                            }
                            this.f10661s.request(j10);
                            j10 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f10661s.cancel();
                        int i = this.sourceMode;
                        Queue<T> queue2 = this.queue;
                        if (i == 2) {
                            queue2.clear();
                        } else {
                            Operators.onDiscardQueueWithClear(queue2, this.actual.currentContext(), null);
                        }
                        doError(coreSubscriber, Operators.onOperatorError(th, this.actual.currentContext()));
                        return;
                    }
                }
                if (j10 == jAddAndGet && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, null)) {
                    return;
                }
                int i3 = this.wip;
                if (iAddAndGet == i3) {
                    this.produced = j10;
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i3;
                }
            }
        }

        public void runBackfused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.actual.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    if (th != null) {
                        doError(coreSubscriber, th);
                        return;
                    } else {
                        doComplete(coreSubscriber);
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            clear();
        }

        public void runSync() {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            Queue<T> queue = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested;
                while (j10 != j11) {
                    try {
                        T tPoll = queue.poll();
                        if (this.cancelled) {
                            Operators.onDiscard(tPoll, this.actual.currentContext());
                            Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                            return;
                        } else if (tPoll == null) {
                            doComplete(coreSubscriber);
                            return;
                        } else {
                            coreSubscriber.onNext(tPoll);
                            j10++;
                        }
                    } catch (Throwable th) {
                        doError(coreSubscriber, Operators.onOperatorError(this.f10661s, th, this.actual.currentContext()));
                        return;
                    }
                }
                if (this.cancelled) {
                    Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                    return;
                }
                if (queue.isEmpty()) {
                    doComplete(coreSubscriber);
                    return;
                }
                int i = this.wip;
                if (iAddAndGet == i) {
                    this.produced = j10;
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10661s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
            }
            Queue<T> queue = this.queue;
            return Integer.valueOf(queue != null ? queue.size() : 0);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        public void trySchedule(@Nullable qd.e eVar, @Nullable Throwable th, @Nullable Object obj) {
            if (WIP.getAndIncrement(this) != 0) {
                if (this.cancelled) {
                    if (this.sourceMode == 2) {
                        this.queue.clear();
                        return;
                    } else {
                        Operators.onDiscard(obj, this.actual.currentContext());
                        return;
                    }
                }
                return;
            }
            try {
                this.worker.schedule(this);
            } catch (RejectedExecutionException e10) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else if (this.outputFused) {
                    clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
                boolean z10 = this.cancelled;
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                if (z10) {
                    Operators.onErrorDropped(e10, coreSubscriber.currentContext());
                } else {
                    coreSubscriber.onError(Operators.onRejectedExecution(e10, eVar, th, obj, coreSubscriber.currentContext()));
                }
            }
        }
    }

    public FluxPublishOn(Flux<? extends T> flux, Scheduler scheduler, boolean z10, int i, int i3, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.delayError = z10;
        this.prefetch = i;
        this.lowTide = i3;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        Objects.requireNonNull(workerCreateWorker, "The scheduler returned a null worker");
        Scheduler.Worker worker = workerCreateWorker;
        if (!(coreSubscriber instanceof Fuseable.ConditionalSubscriber)) {
            return new PublishOnSubscriber(coreSubscriber, this.scheduler, worker, this.delayError, this.prefetch, this.lowTide, this.queueSupplier);
        }
        this.source.subscribe((CoreSubscriber) new PublishOnConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.scheduler, worker, this.delayError, this.prefetch, this.lowTide, this.queueSupplier));
        return null;
    }
}
