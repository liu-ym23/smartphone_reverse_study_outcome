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

/* loaded from: classes4.dex */
final class FluxPublishOn<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final boolean delayError;
    final int lowTide;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final Scheduler scheduler;

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
        Z9.e f5781s;
        final Scheduler scheduler;
        int sourceMode;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicIntegerFieldUpdater<PublishOnConditionalSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "wip");
        static final AtomicIntegerFieldUpdater<PublishOnConditionalSubscriber> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "discardGuard");
        static final AtomicLongFieldUpdater<PublishOnConditionalSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(PublishOnConditionalSubscriber.class, "requested");

        public PublishOnConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler scheduler, Scheduler.Worker worker, boolean z10, int i, int i6, Supplier<? extends Queue<T>> supplier) {
            this.actual = conditionalSubscriber;
            this.worker = worker;
            this.scheduler = scheduler;
            this.delayError = z10;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i, i6);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5781s.cancel();
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

        public boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, @Nullable T t9) {
            if (this.cancelled) {
                Operators.onDiscard(t9, this.actual.currentContext());
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
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
            Operators.onDiscard(t9, this.actual.currentContext());
            if (this.sourceMode == 2) {
                this.queue.clear();
            } else {
                Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
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

        public void doComplete(Z9.d dVar) {
            dVar.onComplete();
            this.worker.dispose();
        }

        public void doError(Z9.d dVar, Throwable th) {
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule(null, null, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                trySchedule(this, null, null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            if (this.cancelled) {
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            if (!this.queue.offer(t9)) {
                Operators.onDiscard(t9, this.actual.currentContext());
                this.error = Operators.onOperatorError(this.f5781s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.actual.currentContext());
                this.done = true;
            }
            trySchedule(this, null, t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5781s, eVar)) {
                this.f5781s = eVar;
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
                long j5 = this.consumed + 1;
                if (j5 == this.limit) {
                    this.consumed = 0L;
                    this.f5781s.request(j5);
                    return tPoll;
                }
                this.consumed = j5;
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
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
            long j5 = this.produced;
            long j6 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j10 = this.requested;
                while (j5 != j10) {
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
                            j5++;
                        }
                        j6++;
                        if (j6 == this.limit) {
                            this.f5781s.request(j6);
                            j6 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f5781s.cancel();
                        queue.clear();
                        doError(conditionalSubscriber, Operators.onOperatorError(th, this.actual.currentContext()));
                        return;
                    }
                }
                if (j5 == j10 && checkTerminated(this.done, queue.isEmpty(), conditionalSubscriber, null)) {
                    return;
                }
                int i = this.wip;
                if (iAddAndGet == i) {
                    this.produced = j5;
                    this.consumed = j6;
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
                    if (th != null) {
                        doError(this.actual, th);
                        return;
                    } else {
                        doComplete(this.actual);
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
            long j5 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j6 = this.requested;
                while (j5 != j6) {
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
                            j5++;
                        }
                    } catch (Throwable th) {
                        doError(conditionalSubscriber, Operators.onOperatorError(this.f5781s, th, this.actual.currentContext()));
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
                    this.produced = j5;
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
                return this.f5781s;
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

        public void trySchedule(@Nullable Z9.e eVar, @Nullable Throwable th, @Nullable Object obj) {
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
            } catch (RejectedExecutionException e) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else if (this.outputFused) {
                    clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
                if (this.cancelled) {
                    Operators.onErrorDropped(e, this.actual.currentContext());
                } else {
                    Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                    conditionalSubscriber.onError(Operators.onRejectedExecution(e, eVar, th, obj, conditionalSubscriber.currentContext()));
                }
            }
        }
    }

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
        Z9.e f5782s;
        final Scheduler scheduler;
        int sourceMode;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicIntegerFieldUpdater<PublishOnSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(PublishOnSubscriber.class, "wip");
        static final AtomicIntegerFieldUpdater<PublishOnSubscriber> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(PublishOnSubscriber.class, "discardGuard");
        static final AtomicLongFieldUpdater<PublishOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(PublishOnSubscriber.class, "requested");

        public PublishOnSubscriber(CoreSubscriber<? super T> coreSubscriber, Scheduler scheduler, Scheduler.Worker worker, boolean z10, int i, int i6, Supplier<? extends Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.worker = worker;
            this.scheduler = scheduler;
            this.delayError = z10;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i, i6);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5782s.cancel();
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

        public boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, @Nullable T t9) {
            if (this.cancelled) {
                Operators.onDiscard(t9, this.actual.currentContext());
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
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
            Operators.onDiscard(t9, this.actual.currentContext());
            if (this.sourceMode == 2) {
                this.queue.clear();
            } else {
                Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
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

        public void doComplete(Z9.d dVar) {
            dVar.onComplete();
            this.worker.dispose();
        }

        public void doError(Z9.d dVar, Throwable th) {
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule(null, null, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                trySchedule(this, null, null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            if (this.cancelled) {
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            if (!this.queue.offer(t9)) {
                Operators.onDiscard(t9, this.actual.currentContext());
                this.error = Operators.onOperatorError(this.f5782s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.actual.currentContext());
                this.done = true;
            }
            trySchedule(this, null, t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5782s, eVar)) {
                this.f5782s = eVar;
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
                long j5 = this.produced + 1;
                if (j5 == this.limit) {
                    this.produced = 0L;
                    this.f5782s.request(j5);
                    return tPoll;
                }
                this.produced = j5;
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
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
            long j5 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested;
                while (j5 != jAddAndGet) {
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
                        j5++;
                        if (j5 == this.limit) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = REQUESTED.addAndGet(this, -j5);
                            }
                            this.f5782s.request(j5);
                            j5 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f5782s.cancel();
                        if (this.sourceMode == 2) {
                            this.queue.clear();
                        } else {
                            Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                        }
                        doError(coreSubscriber, Operators.onOperatorError(th, this.actual.currentContext()));
                        return;
                    }
                }
                if (j5 == jAddAndGet && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, null)) {
                    return;
                }
                int i = this.wip;
                if (iAddAndGet == i) {
                    this.produced = j5;
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
                    if (th != null) {
                        doError(this.actual, th);
                        return;
                    } else {
                        doComplete(this.actual);
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
            long j5 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j6 = this.requested;
                while (j5 != j6) {
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
                            j5++;
                        }
                    } catch (Throwable th) {
                        doError(coreSubscriber, Operators.onOperatorError(this.f5782s, th, this.actual.currentContext()));
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
                    this.produced = j5;
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
                return this.f5782s;
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

        public void trySchedule(@Nullable Z9.e eVar, @Nullable Throwable th, @Nullable Object obj) {
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
            } catch (RejectedExecutionException e) {
                if (this.sourceMode == 2) {
                    this.queue.clear();
                } else if (this.outputFused) {
                    clear();
                } else {
                    Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                }
                if (this.cancelled) {
                    Operators.onErrorDropped(e, this.actual.currentContext());
                } else {
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onRejectedExecution(e, eVar, th, obj, coreSubscriber.currentContext()));
                }
            }
        }
    }

    public FluxPublishOn(Flux<? extends T> flux, Scheduler scheduler, boolean z10, int i, int i6, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.delayError = z10;
        this.prefetch = i;
        this.lowTide = i6;
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
