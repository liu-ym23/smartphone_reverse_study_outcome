package com.android.server.selinux;

import android.os.SystemClock;
import com.android.internal.os.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class RateLimiter {
    private final Clock mClock;
    private Instant mNextPermit;
    private final Duration mWindow;

    RateLimiter(Clock clock, Duration window) {
        this.mNextPermit = Instant.EPOCH;
        this.mClock = clock;
        this.mWindow = window;
    }

    public RateLimiter(Duration window) {
        this(Clock.SYSTEM_CLOCK, window);
    }

    public void acquire() {
        Instant now = Instant.ofEpochMilli(this.mClock.currentTimeMillis());
        if (this.mNextPermit.isAfter(now) == false) goto L5;
        SystemClock.sleep(ChronoUnit.MILLIS.between(now, this.mNextPermit));
        this.mNextPermit = this.mNextPermit.plus(this.mWindow);
        return;
    L5:
        this.mNextPermit = now.plus(this.mWindow);
    }

    public boolean tryAcquire() {
        Instant now = Instant.ofEpochMilli(this.mClock.currentTimeMillis());
        if (this.mNextPermit.isAfter(now) == false) goto L6;
        return false;
    L6:
        this.mNextPermit = now.plus(this.mWindow);
        return true;
    }
}
