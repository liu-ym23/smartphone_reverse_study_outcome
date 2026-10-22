package com.android.server.selinux;

import com.android.internal.os.Clock;
import java.time.Duration;
import java.time.Instant;

/* JADX INFO: loaded from: classes3.dex */
public class QuotaLimiter {
    private final Clock mClock;
    private long mCurrentWindow;
    private int mMaxPermits;
    private int mPermitsGranted;
    private final Duration mWindowSize;

    QuotaLimiter(Clock clock, Duration windowSize, int maxPermits) {
        this.mClock = clock;
        this.mWindowSize = windowSize;
        this.mMaxPermits = maxPermits;
    }

    public QuotaLimiter(Duration windowSize, int maxPermits) {
        this(Clock.SYSTEM_CLOCK, windowSize, maxPermits);
    }

    public QuotaLimiter(int maxPermitsPerDay) {
        this(Clock.SYSTEM_CLOCK, Duration.ofDays(1), maxPermitsPerDay);
    }

    boolean acquire() {
        long nowWindow = Duration.between(Instant.EPOCH, Instant.ofEpochMilli(this.mClock.currentTimeMillis())).dividedBy(this.mWindowSize);
        if (nowWindow <= this.mCurrentWindow) goto L6;
        this.mCurrentWindow = nowWindow;
        this.mPermitsGranted = 0;
    L6:
        if (this.mPermitsGranted >= this.mMaxPermits) goto L9;
        this.mPermitsGranted++;
        return true;
    L9:
        return false;
    }

    public void setMaxPermits(int maxPermits) {
        this.mMaxPermits = maxPermits;
    }
}
