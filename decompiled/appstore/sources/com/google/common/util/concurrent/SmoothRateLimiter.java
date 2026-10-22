package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch r10, double r11) {
            super(r10, null);
            this.maxBurstSeconds = r11;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double r10, double r11) {
            double r12 = this.maxPermits;
            double r13 = this.maxBurstSeconds * r10;
            this.maxPermits = r13;
            if (r12 != Double.POSITIVE_INFINITY) goto L5;
            this.storedPermits = r13;
            return;
        L5:
            double r14 = 0.0d;
            if (r12 == 0.0d) goto L9;
            r14 = (this.storedPermits * r13) / r12;
        L9:
            this.storedPermits = r14;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double r10, double r11) {
            return 0;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch r10, long r11, TimeUnit r12, double r13) {
            super(r10, null);
            this.warmupPeriodMicros = r12.toMicros(r11);
            this.coldFactor = r13;
        }

        private double permitsToTime(double r10) {
            return this.stableIntervalMicros + (r10 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double r10, double r11) {
            double r12 = this.maxPermits;
            double r13 = this.coldFactor * r11;
            long r14 = this.warmupPeriodMicros;
            double r15 = (r14 * 0.5d) / r11;
            this.thresholdPermits = r15;
            double r16 = ((r14 * 2.0d) / (r11 + r13)) + r15;
            this.maxPermits = r16;
            this.slope = (r13 - r11) / (r16 - r15);
            if (r12 != Double.POSITIVE_INFINITY) goto L6;
            this.storedPermits = 0.0d;
            return;
        L6:
            if (r12 == 0.0d) goto L9;
            r16 = (this.storedPermits * r16) / r12;
        L9:
            this.storedPermits = r16;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double r10, double r11) {
            double r12 = r10 - this.thresholdPermits;
            if (r12 <= 0.0d) goto L5;
            double r13 = Math.min(r12, r11);
            long r14 = (long) (((permitsToTime(r12) + permitsToTime(r12 - r13)) * r13) / 2.0d);
            r11 = r11 - r13;
        L7:
            return r14 + ((long) (this.stableIntervalMicros * r11));
        L5:
            r14 = 0;
            goto L7
        }
    }

    public /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch r10, AnonymousClass1 r11) {
        this(r10);
    }

    public abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1) / this.stableIntervalMicros;
    }

    public abstract void doSetRate(double r10, double r11);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double r10, long r11) {
        resync(r11);
        double r12 = TimeUnit.SECONDS.toMicros(1) / r10;
        this.stableIntervalMicros = r12;
        doSetRate(r10, r12);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long r10) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int r10, long r11) {
        resync(r11);
        long r12 = this.nextFreeTicketMicros;
        double r13 = r10;
        double r14 = Math.min(r13, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, r14) + ((long) ((r13 - r14) * this.stableIntervalMicros)));
        this.storedPermits -= r14;
        return r12;
    }

    public void resync(long r10) {
        long r11 = this.nextFreeTicketMicros;
        if (r10 <= r11) goto L6;
        this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((r10 - r11) / coolDownIntervalMicros()));
        this.nextFreeTicketMicros = r10;
        return;
    }

    public abstract long storedPermitsToWaitTime(double r10, double r11);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch r10) {
        super(r10);
        this.nextFreeTicketMicros = 0;
    }
}
