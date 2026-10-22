package reactor.core.publisher;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BooleanSupplier;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
abstract class DrainUtils {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    public static <T, F> void postComplete(CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier) {
        long j10;
        long j11;
        if (queue.isEmpty()) {
            coreSubscriber.onComplete();
            return;
        }
        if (postCompleteDrain(atomicLongFieldUpdater.get(f10), coreSubscriber, queue, atomicLongFieldUpdater, f10, booleanSupplier)) {
            return;
        }
        do {
            j10 = atomicLongFieldUpdater.get(f10);
            if ((j10 & COMPLETED_MASK) != 0) {
                return;
            } else {
                j11 = j10 | COMPLETED_MASK;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(f10, j10, j11));
        if (j10 != 0) {
            postCompleteDrain(j11, coreSubscriber, queue, atomicLongFieldUpdater, f10, booleanSupplier);
        }
    }

    public static <T, F> void postCompleteDelayError(CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier, @Nullable Throwable th) {
        long j10;
        long j11;
        if (queue.isEmpty()) {
            if (th == null) {
                coreSubscriber.onComplete();
                return;
            } else {
                coreSubscriber.onError(th);
                return;
            }
        }
        if (postCompleteDrainDelayError(atomicLongFieldUpdater.get(f10), coreSubscriber, queue, atomicLongFieldUpdater, f10, booleanSupplier, th)) {
            return;
        }
        do {
            j10 = atomicLongFieldUpdater.get(f10);
            if ((j10 & COMPLETED_MASK) != 0) {
                return;
            } else {
                j11 = j10 | COMPLETED_MASK;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(f10, j10, j11));
        if (j10 != 0) {
            postCompleteDrainDelayError(j11, coreSubscriber, queue, atomicLongFieldUpdater, f10, booleanSupplier, th);
        }
    }

    public static <T, F> boolean postCompleteDrain(long j10, qc.c<? super T> cVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier) {
        long j11 = j10 & COMPLETED_MASK;
        while (true) {
            if (j11 != j10) {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(tPoll);
                j11++;
            } else {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j10 = atomicLongFieldUpdater.get(f10);
                if (j10 == j11) {
                    long jAddAndGet = atomicLongFieldUpdater.addAndGet(f10, -(j11 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j11 = jAddAndGet & COMPLETED_MASK;
                    j10 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, F> boolean postCompleteDrainDelayError(long j10, qc.c<? super T> cVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier, @Nullable Throwable th) {
        long j11 = j10 & COMPLETED_MASK;
        while (true) {
            if (j11 != j10) {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    if (th == null) {
                        cVar.onComplete();
                    } else {
                        cVar.onError(th);
                    }
                    return true;
                }
                cVar.onNext(tPoll);
                j11++;
            } else {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                if (queue.isEmpty()) {
                    if (th == null) {
                        cVar.onComplete();
                    } else {
                        cVar.onError(th);
                    }
                    return true;
                }
                j10 = atomicLongFieldUpdater.get(f10);
                if (j10 == j11) {
                    long jAddAndGet = atomicLongFieldUpdater.addAndGet(f10, -(j11 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j11 = jAddAndGet & COMPLETED_MASK;
                    j10 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, F> boolean postCompleteRequest(long j10, qc.c<? super T> cVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier) {
        long j11;
        do {
            j11 = atomicLongFieldUpdater.get(f10);
        } while (!atomicLongFieldUpdater.compareAndSet(f10, j11, (j11 & COMPLETED_MASK) | Operators.addCap(Long.MAX_VALUE & j11, j10)));
        if (j11 != COMPLETED_MASK) {
            return false;
        }
        postCompleteDrain(j10 | COMPLETED_MASK, cVar, queue, atomicLongFieldUpdater, f10, booleanSupplier);
        return true;
    }

    public static <T, F> boolean postCompleteRequestDelayError(long j10, qc.c<? super T> cVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f10, BooleanSupplier booleanSupplier, Throwable th) {
        long j11;
        do {
            j11 = atomicLongFieldUpdater.get(f10);
        } while (!atomicLongFieldUpdater.compareAndSet(f10, j11, (j11 & COMPLETED_MASK) | Operators.addCap(Long.MAX_VALUE & j11, j10)));
        if (j11 != COMPLETED_MASK) {
            return false;
        }
        postCompleteDrainDelayError(j10 | COMPLETED_MASK, cVar, queue, atomicLongFieldUpdater, f10, booleanSupplier, th);
        return true;
    }
}
