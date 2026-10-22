package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class RateLimiter {

    @MonotonicNonNullDecl
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    public static abstract class SleepingStopwatch {
        public SleepingStopwatch() {
        }

        public static SleepingStopwatch createFromSystemTimer() {
            return new AnonymousClass1();
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long r10);
    }

    public RateLimiter(SleepingStopwatch r10) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(r10);
    }

    private boolean canAcquire(long r10, long r11) {
        if ((queryEarliestAvailable(r10) - r11) > r10) goto L5;
        return true;
    L5:
        return false;
    }

    private static void checkPermits(int r10) {
        if (r10 <= 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "Requested permits (%s) must be positive", r10);
        return;
    L4:
        r11 = false;
        goto L5
    }

    public static RateLimiter create(double r10) {
        return create(r10, SleepingStopwatch.createFromSystemTimer());
    }

    private Object mutex() {
        Object r10 = this.mutexDoNotUseDirectly;
        if (r10 != null) goto L14;
        monitor-enter(this);
        r10 = this.mutexDoNotUseDirectly;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        r10 = new Object();     // Catch: Throwable -> L8
        this.mutexDoNotUseDirectly = r10;     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L14:
        return r10;
    }

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double r10, long r11);

    public final double getRate() {
        Object r10 = mutex();
        monitor-enter(r10);
        double r11 = doGetRate();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract long queryEarliestAvailable(long r10);

    public final long reserve(int r10) {
        checkPermits(r10);
        Object r11 = mutex();
        monitor-enter(r11);
        long r12 = reserveAndGetWaitLength(r10, this.stopwatch.readMicros());     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final long reserveAndGetWaitLength(int r10, long r11) {
        return Math.max(reserveEarliestAvailable(r10, r11) - r11, 0);
    }

    public abstract long reserveEarliestAvailable(int r10, long r11);

    public final void setRate(double r10) {
        if (r10 > 0.0d) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Preconditions.checkArgument(r11, "rate must be positive");
        Object r12 = mutex();
        monitor-enter(r12);
        doSetRate(r10, this.stopwatch.readMicros());     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (Double.isNaN(r10) == true) goto L7;
        r11 = true;
        goto L8
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    public boolean tryAcquire(long r10, TimeUnit r11) {
        return tryAcquire(1, r10, r11);
    }

    @VisibleForTesting
    public static RateLimiter create(double r10, SleepingStopwatch r11) {
        SmoothRateLimiter.SmoothBursty r12 = new SmoothRateLimiter.SmoothBursty(r11, 1.0d);
        r12.setRate(r10);
        return r12;
    }

    @CanIgnoreReturnValue
    public double acquire(int r10) {
        long r11 = reserve(r10);
        this.stopwatch.sleepMicrosUninterruptibly(r11);
        return (r11 * 1.0d) / TimeUnit.SECONDS.toMicros(1);
    }

    public boolean tryAcquire(int r10) {
        return tryAcquire(r10, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public static RateLimiter create(double r10, long r12, TimeUnit r14) {
        if (r12 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "warmupPeriod must not be negative: %s", r12);
        return create(r10, r12, r14, 3.0d, SleepingStopwatch.createFromSystemTimer());
    L5:
        r11 = false;
        goto L6
    }

    public boolean tryAcquire(int r10, long r11, TimeUnit r12) {
        long r13 = Math.max(r12.toMicros(r11), 0);
        checkPermits(r10);
        Object r14 = mutex();
        monitor-enter(r14);
        long r15 = this.stopwatch.readMicros();     // Catch: Throwable -> L9
        if (canAcquire(r15, r13) == true) goto L11;
        monitor-exit(r14);     // Catch: Throwable -> L9
        return false;
    L11:
        long r16 = reserveAndGetWaitLength(r10, r15);     // Catch: Throwable -> L9
        monitor-exit(r14);     // Catch: Throwable -> L9
        this.stopwatch.sleepMicrosUninterruptibly(r16);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public static RateLimiter create(double r10, long r11, TimeUnit r12, double r13, SleepingStopwatch r15) {
        SmoothRateLimiter.SmoothWarmingUp r14 = new SmoothRateLimiter.SmoothWarmingUp(r15, r11, r12, r13);
        r14.setRate(r10);
        return r14;
    }
}
