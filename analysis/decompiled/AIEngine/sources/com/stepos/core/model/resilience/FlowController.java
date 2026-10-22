package com.stepos.core.model.resilience;

import android.util.Log;
import com.stepos.core.ota.d;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.e;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FlowController {
    public static final long BACKOFF_MS = 100;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FlowController";
    private volatile int effectiveMax;
    private volatile boolean exclusiveActive;
    private final int maxConcurrent;
    private int pendingMax;
    private final AtomicLong rejectedCount;
    private final Semaphore semaphore;
    private final AtomicLong totalAcquires;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AcquireResult {
        private final boolean acquired;
        private final long retryAfterMs;

        public AcquireResult(boolean z, long j10) {
            this.acquired = z;
            this.retryAfterMs = j10;
        }

        public static /* synthetic */ AcquireResult copy$default(AcquireResult acquireResult, boolean z, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z = acquireResult.acquired;
            }
            if ((i10 & 2) != 0) {
                j10 = acquireResult.retryAfterMs;
            }
            return acquireResult.copy(z, j10);
        }

        public final boolean component1() {
            return this.acquired;
        }

        public final long component2() {
            return this.retryAfterMs;
        }

        public final AcquireResult copy(boolean z, long j10) {
            return new AcquireResult(z, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AcquireResult)) {
                return false;
            }
            AcquireResult acquireResult = (AcquireResult) obj;
            return this.acquired == acquireResult.acquired && this.retryAfterMs == acquireResult.retryAfterMs;
        }

        public final boolean getAcquired() {
            return this.acquired;
        }

        public final long getRetryAfterMs() {
            return this.retryAfterMs;
        }

        public int hashCode() {
            return Long.hashCode(this.retryAfterMs) + (Boolean.hashCode(this.acquired) * 31);
        }

        public String toString() {
            return "AcquireResult(acquired=" + this.acquired + ", retryAfterMs=" + this.retryAfterMs + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public FlowController() {
        this(0, 1, null);
    }

    private final void applyMaxConcurrent(int i10) {
        if (i10 <= 0 || i10 == this.effectiveMax) {
            return;
        }
        int i11 = i10 - this.effectiveMax;
        this.effectiveMax = i10;
        if (i11 > 0) {
            this.semaphore.release(i11);
        } else {
            int i12 = -i11;
            for (int i13 = 0; i13 < i12; i13++) {
                this.semaphore.tryAcquire();
            }
        }
        Log.d(TAG, "updateMaxConcurrent: effectiveMax=" + this.effectiveMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void releaseGate(int i10) {
        if (i10 > 0) {
            try {
                this.semaphore.release(i10);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.exclusiveActive = false;
        int i11 = this.pendingMax;
        if (i11 > 0) {
            this.pendingMax = -1;
            applyMaxConcurrent(i11);
        }
    }

    public final AutoCloseable acquireAllOrNull(long j10) {
        synchronized (this) {
            if (this.exclusiveActive) {
                return null;
            }
            this.exclusiveActive = true;
            n nVar = n.f10413a;
            int i10 = this.effectiveMax;
            long nanos = TimeUnit.MILLISECONDS.toNanos(j10) + System.nanoTime();
            final int i11 = 0;
            while (i11 < i10) {
                long millis = TimeUnit.NANOSECONDS.toMillis(nanos - System.nanoTime());
                if (millis <= 0 || !this.semaphore.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
                    releaseGate(i11);
                    return null;
                }
                i11++;
            }
            return new AutoCloseable() { // from class: com.stepos.core.model.resilience.FlowController$acquireAllOrNull$$inlined$AutoCloseable$1
                @Override // java.lang.AutoCloseable
                public final void close() {
                    this.this$0.releaseGate(i11);
                }
            };
        }
    }

    public final int availablePermits() {
        return this.semaphore.availablePermits();
    }

    public final int currentConcurrent() {
        return this.effectiveMax - this.semaphore.availablePermits();
    }

    public final FlowStatistics getStatistics() {
        return new FlowStatistics(this.effectiveMax, currentConcurrent(), availablePermits(), queueLength(), this.totalAcquires.get(), this.rejectedCount.get());
    }

    public final boolean isIdle() {
        return currentConcurrent() == 0;
    }

    public final int queueLength() {
        return this.semaphore.getQueueLength();
    }

    public final void release() {
        this.semaphore.release();
    }

    public final void resetStatistics() {
        this.totalAcquires.set(0L);
        this.rejectedCount.set(0L);
    }

    public final AcquireResult tryAcquire() {
        this.totalAcquires.incrementAndGet();
        Log.w(TAG, "[DIAG] tryAcquire: availablePermits=" + this.semaphore.availablePermits() + ", effectiveMax=" + this.effectiveMax);
        if (!this.semaphore.tryAcquire()) {
            this.rejectedCount.incrementAndGet();
            Log.w(TAG, d.e(this.effectiveMax, "Flow control rejected: effectiveMax=", this.semaphore.getQueueLength(), ", queueLength=", ", retryAfterMs=100"));
            return new AcquireResult(false, 100L);
        }
        Log.w(TAG, "[DIAG] tryAcquire: ACQUIRED, remaining=" + this.semaphore.availablePermits());
        return new AcquireResult(true, 0L);
    }

    public final boolean tryAcquireNow() {
        return tryAcquire().getAcquired();
    }

    public final synchronized void updateMaxConcurrent(int i10) {
        if (i10 > 0) {
            if (i10 != this.effectiveMax) {
                if (this.exclusiveActive) {
                    this.pendingMax = i10;
                } else {
                    applyMaxConcurrent(i10);
                }
            }
        }
    }

    public FlowController(int i10) {
        this.maxConcurrent = i10;
        this.semaphore = new Semaphore(i10);
        this.effectiveMax = i10;
        this.pendingMax = -1;
        this.totalAcquires = new AtomicLong(0L);
        this.rejectedCount = new AtomicLong(0L);
    }

    public /* synthetic */ FlowController(int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? 8 : i10);
    }
}
