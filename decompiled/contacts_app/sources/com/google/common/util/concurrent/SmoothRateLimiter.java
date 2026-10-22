package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double r1, double r3) {
            return 0;
        }

        SmoothBursty(RateLimiter.SleepingStopwatch r2, double r3) {
            super(r2, null);
            this.maxBurstSeconds = r3;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double r3, double r5) {
            double r6 = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * r3;
            if (r6 != Double.POSITIVE_INFINITY) goto L5;
            this.storedPermits = this.maxPermits;
            return;
        L5:
            double r4 = 0.0d;
            if (r6 == 0.0d) goto L9;
            r4 = (this.storedPermits * this.maxPermits) / r6;
        L9:
            this.storedPermits = r4;
        }
    }

    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double halfPermits;
        private double slope;
        private final long warmupPeriodMicros;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch r2, long r3, TimeUnit r5) {
            super(r2, null);
            this.warmupPeriodMicros = r5.toMicros(r3);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double r5, double r7) {
            double r6 = this.maxPermits;
            this.maxPermits = this.warmupPeriodMicros / r7;
            double r0 = this.maxPermits / 2.0d;
            this.halfPermits = r0;
            this.slope = ((3.0d * r7) - r7) / r0;
            if (r6 != Double.POSITIVE_INFINITY) goto L6;
            this.storedPermits = 0.0d;
            return;
        L6:
            if (r6 != 0.0d) goto L8;
            double r8 = this.maxPermits;
        L9:
            this.storedPermits = r8;
            return;
        L8:
            r8 = (this.storedPermits * this.maxPermits) / r6;
            goto L9
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double r5, double r7) {
            double r6 = r5 - this.halfPermits;
            if (r6 <= 0.0d) goto L5;
            double r0 = Math.min(r6, r7);
            long r8 = (long) (((permitsToTime(r6) + permitsToTime(r6 - r0)) * r0) / 2.0d);
            r7 = r7 - r0;
        L7:
            return (long) (r8 + (this.stableIntervalMicros * r7));
        L5:
            r8 = 0;
            goto L7
        }

        private double permitsToTime(double r5) {
            return this.stableIntervalMicros + (r5 * this.slope);
        }
    }

    abstract void doSetRate(double r1, double r3);

    abstract long storedPermitsToWaitTime(double r1, double r3);

    /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch r1, AnonymousClass1 r2) {
        this(r1);
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch r3) {
        super(r3);
        this.nextFreeTicketMicros = 0;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double r3, long r5) {
        resync(r5);
        double r6 = TimeUnit.SECONDS.toMicros(1) / r3;
        this.stableIntervalMicros = r6;
        doSetRate(r3, r6);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1) / this.stableIntervalMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long r1) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int r9, long r10) {
        resync(r10);
        long r11 = this.nextFreeTicketMicros;
        double r0 = r9;
        double r2 = Math.min(r0, this.storedPermits);
        this.nextFreeTicketMicros += storedPermitsToWaitTime(this.storedPermits, r2) + ((long) ((r0 - r2) * this.stableIntervalMicros));
        this.storedPermits -= r2;
        return r11;
    }

    private void resync(long r9) {
        long r0 = this.nextFreeTicketMicros;
        if (r9 <= r0) goto L6;
        this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((r9 - r0) / this.stableIntervalMicros));
        this.nextFreeTicketMicros = r9;
        return;
    }
}
