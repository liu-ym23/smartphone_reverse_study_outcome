package reactor.core.publisher;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BooleanSupplier;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
abstract class DrainUtils {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    public static <T, F> void postComplete(CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier) {
        long j5;
        long j6;
        if (queue.isEmpty()) {
            coreSubscriber.onComplete();
            return;
        }
        if (postCompleteDrain(atomicLongFieldUpdater.get(f), coreSubscriber, queue, atomicLongFieldUpdater, f, booleanSupplier)) {
            return;
        }
        do {
            j5 = atomicLongFieldUpdater.get(f);
            if ((j5 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j6 = j5 | Long.MIN_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(f, j5, j6));
        if (j5 != 0) {
            postCompleteDrain(j6, coreSubscriber, queue, atomicLongFieldUpdater, f, booleanSupplier);
        }
    }

    public static <T, F> void postCompleteDelayError(CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier, @Nullable Throwable th) {
        long j5;
        long j6;
        if (queue.isEmpty()) {
            if (th == null) {
                coreSubscriber.onComplete();
                return;
            } else {
                coreSubscriber.onError(th);
                return;
            }
        }
        if (postCompleteDrainDelayError(atomicLongFieldUpdater.get(f), coreSubscriber, queue, atomicLongFieldUpdater, f, booleanSupplier, th)) {
            return;
        }
        do {
            j5 = atomicLongFieldUpdater.get(f);
            if ((j5 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j6 = j5 | Long.MIN_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(f, j5, j6));
        if (j5 != 0) {
            postCompleteDrainDelayError(j6, coreSubscriber, queue, atomicLongFieldUpdater, f, booleanSupplier, th);
        }
    }

    public static <T, F> boolean postCompleteDrain(long j5, Z9.d dVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier) {
        long j6 = j5 & Long.MIN_VALUE;
        while (true) {
            if (j6 != j5) {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    dVar.onComplete();
                    return true;
                }
                dVar.onNext(tPoll);
                j6++;
            } else {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                if (queue.isEmpty()) {
                    dVar.onComplete();
                    return true;
                }
                j5 = atomicLongFieldUpdater.get(f);
                if (j5 == j6) {
                    long jAddAndGet = atomicLongFieldUpdater.addAndGet(f, -(j6 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j6 = jAddAndGet & Long.MIN_VALUE;
                    j5 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, F> boolean postCompleteDrainDelayError(long j5, Z9.d dVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier, @Nullable Throwable th) {
        long j6 = j5 & Long.MIN_VALUE;
        while (true) {
            if (j6 != j5) {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    if (th == null) {
                        dVar.onComplete();
                    } else {
                        dVar.onError(th);
                    }
                    return true;
                }
                dVar.onNext(tPoll);
                j6++;
            } else {
                if (booleanSupplier.getAsBoolean()) {
                    return true;
                }
                if (queue.isEmpty()) {
                    if (th == null) {
                        dVar.onComplete();
                    } else {
                        dVar.onError(th);
                    }
                    return true;
                }
                j5 = atomicLongFieldUpdater.get(f);
                if (j5 == j6) {
                    long jAddAndGet = atomicLongFieldUpdater.addAndGet(f, -(j6 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j6 = jAddAndGet & Long.MIN_VALUE;
                    j5 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, F> boolean postCompleteRequest(long j5, Z9.d dVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier) {
        long j6;
        do {
            j6 = atomicLongFieldUpdater.get(f);
        } while (!atomicLongFieldUpdater.compareAndSet(f, j6, (j6 & Long.MIN_VALUE) | Operators.addCap(Long.MAX_VALUE & j6, j5)));
        if (j6 != Long.MIN_VALUE) {
            return false;
        }
        postCompleteDrain(j5 | Long.MIN_VALUE, dVar, queue, atomicLongFieldUpdater, f, booleanSupplier);
        return true;
    }

    public static <T, F> boolean postCompleteRequestDelayError(long j5, Z9.d dVar, Queue<T> queue, AtomicLongFieldUpdater<F> atomicLongFieldUpdater, F f, BooleanSupplier booleanSupplier, Throwable th) {
        long j6;
        do {
            j6 = atomicLongFieldUpdater.get(f);
        } while (!atomicLongFieldUpdater.compareAndSet(f, j6, (j6 & Long.MIN_VALUE) | Operators.addCap(Long.MAX_VALUE & j6, j5)));
        if (j6 != Long.MIN_VALUE) {
            return false;
        }
        postCompleteDrainDelayError(j5 | Long.MIN_VALUE, dVar, queue, atomicLongFieldUpdater, f, booleanSupplier, th);
        return true;
    }
}
