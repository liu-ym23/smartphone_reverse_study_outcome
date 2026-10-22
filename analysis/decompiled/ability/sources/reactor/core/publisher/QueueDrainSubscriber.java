package reactor.core.publisher;

import java.util.Queue;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements InnerOperator<T, V> {
    final CoreSubscriber<? super V> actual;
    volatile boolean cancelled;
    volatile boolean done;
    Throwable error;
    final Queue<U> queue;

    public QueueDrainSubscriber(CoreSubscriber<? super V> coreSubscriber, Queue<U> queue) {
        this.actual = coreSubscriber;
        this.queue = queue;
    }

    public static <Q, S> boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, boolean z12, Queue<?> queue, QueueDrainSubscriber<?, Q, S> queueDrainSubscriber) {
        if (queueDrainSubscriber.cancelled()) {
            queue.clear();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            Throwable thError = queueDrainSubscriber.error();
            if (thError != null) {
                dVar.onError(thError);
            } else {
                dVar.onComplete();
            }
            return true;
        }
        Throwable thError2 = queueDrainSubscriber.error();
        if (thError2 != null) {
            queue.clear();
            dVar.onError(thError2);
            return true;
        }
        if (!z11) {
            return false;
        }
        dVar.onComplete();
        return true;
    }

    public static <Q, S> void drainMaxLoop(Queue<Q> queue, Z9.d dVar, boolean z10, Disposable disposable, QueueDrainSubscriber<?, Q, S> queueDrainSubscriber) {
        int iLeave = 1;
        while (true) {
            boolean zDone = queueDrainSubscriber.done();
            Q qPoll = queue.poll();
            boolean z11 = qPoll == null;
            Queue<Q> queue2 = queue;
            Z9.d dVar2 = dVar;
            boolean z12 = z10;
            QueueDrainSubscriber<?, Q, S> queueDrainSubscriber2 = queueDrainSubscriber;
            if (checkTerminated(zDone, z11, dVar2, z12, queue2, queueDrainSubscriber2)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            }
            if (z11) {
                iLeave = queueDrainSubscriber2.leave(-iLeave);
                if (iLeave == 0) {
                    return;
                }
            } else {
                long jRequested = queueDrainSubscriber2.requested();
                if (jRequested == 0) {
                    queue2.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    dVar2.onError(Exceptions.failWithOverflow("Could not emit value due to lack of requests."));
                    return;
                }
                if (queueDrainSubscriber2.accept(dVar2, qPoll) && jRequested != Long.MAX_VALUE) {
                    queueDrainSubscriber2.produced(1L);
                }
            }
            dVar = dVar2;
            z10 = z12;
            queue = queue2;
            queueDrainSubscriber = queueDrainSubscriber2;
        }
    }

    public boolean accept(Z9.d dVar, U u) {
        return false;
    }

    @Override // reactor.core.publisher.InnerProducer
    public CoreSubscriber<? super V> actual() {
        return this.actual;
    }

    public abstract /* synthetic */ void cancel();

    public final boolean cancelled() {
        return this.cancelled;
    }

    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    public final void fastPathEmitMax(U u, boolean z10, Disposable disposable) {
        CoreSubscriber<? super V> coreSubscriber = this.actual;
        Queue<U> queue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j5 = this.requested;
            if (j5 == 0) {
                disposable.dispose();
                coreSubscriber.onError(Exceptions.failWithOverflow("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (accept(coreSubscriber, u) && j5 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            }
        } else {
            queue.offer(u);
            if (!enter()) {
                return;
            }
        }
        drainMaxLoop(queue, coreSubscriber, z10, disposable, this);
    }

    public final void fastPathOrderedEmitMax(U u, boolean z10, Disposable disposable) {
        CoreSubscriber<? super V> coreSubscriber = this.actual;
        Queue<U> queue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j5 = this.requested;
            if (j5 == 0) {
                this.cancelled = true;
                disposable.dispose();
                coreSubscriber.onError(Exceptions.failWithOverflow("Could not emit buffer due to lack of requests"));
                return;
            } else if (queue.isEmpty()) {
                if (accept(coreSubscriber, u) && j5 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                queue.offer(u);
            }
        } else {
            queue.offer(u);
            if (!enter()) {
                return;
            }
        }
        drainMaxLoop(queue, coreSubscriber, z10, disposable, this);
    }

    public final int leave(int i) {
        return this.wip.addAndGet(i);
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    public final long produced(long j5) {
        return QueueDrainSubscriberPad3.REQUESTED.addAndGet(this, -j5);
    }

    public abstract /* synthetic */ void request(long j5);

    public final long requested() {
        return this.requested;
    }

    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.ERROR ? this.error : super.scanUnsafe(attr);
    }

    public final void requested(long j5) {
        if (Operators.validate(j5)) {
            Operators.addCap(QueueDrainSubscriberPad3.REQUESTED, this, j5);
        }
    }
}
