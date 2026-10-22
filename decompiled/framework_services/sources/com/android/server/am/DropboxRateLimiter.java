package com.android.server.am;

import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.modules.expresslog.Counter;

/* JADX INFO: loaded from: classes.dex */
public class DropboxRateLimiter {
    private static final String FLAG_NAMESPACE = "dropbox";
    private static final int RATE_LIMIT_ALLOWED_ENTRIES_DEFAULT = 10;
    private static final long RATE_LIMIT_BUFFER_DURATION_DEFAULT = 600000;
    private static final long RATE_LIMIT_BUFFER_EXPIRY_FACTOR_DEFAULT = 3;
    private static final int STRICT_RATE_LIMIT_ALLOWED_ENTRIES_DEFAULT = 5;
    private static final long STRICT_RATE_LIMIT_BUFFER_DURATION_DEFAULT = 1200000;
    private static final String TAG = "DropboxRateLimiter";
    private final Clock mClock;
    private final ArrayMap<String, ErrorRecord> mErrorClusterRecords;
    private long mLastMapCleanUp;
    private int mRateLimitAllowedEntries;
    private long mRateLimitBufferDuration;
    private long mRateLimitBufferExpiryFactor;
    private long mStrictRateLimitBufferDuration;
    private int mStrictRatelimitAllowedEntries;

    public interface Clock {
        long uptimeMillis();
    }

    private static class DefaultClock implements Clock {
        /* synthetic */ DefaultClock(DropboxRateLimiterIA r1) {
            this();
        }

        private DefaultClock() {
        }

        @Override // com.android.server.am.DropboxRateLimiter.Clock
        public long uptimeMillis() {
            return SystemClock.uptimeMillis();
        }
    }

    private class ErrorRecord {
        int mCount;
        long mStartTime;
        int mSuccessiveRateLimitCycles;
        final /* synthetic */ DropboxRateLimiter this$0;

        ErrorRecord(DropboxRateLimiter r1, long startTime, int count) {
            this.this$0 = r1;
            this.mStartTime = startTime;
            this.mCount = count;
            this.mSuccessiveRateLimitCycles = 0;
        }

        public void setStartTime(long startTime) {
            this.mStartTime = startTime;
        }

        public void setCount(int count) {
            this.mCount = count;
        }

        public void incrementCount() {
            this.mCount++;
        }

        public void setSuccessiveRateLimitCycles(int successiveRateLimitCycles) {
            this.mSuccessiveRateLimitCycles = successiveRateLimitCycles;
        }

        public void incrementSuccessiveRateLimitCycles() {
            this.mSuccessiveRateLimitCycles++;
        }

        public long getStartTime() {
            return this.mStartTime;
        }

        public int getCount() {
            return this.mCount;
        }

        public int getSuccessiveRateLimitCycles() {
            return this.mSuccessiveRateLimitCycles;
        }

        public boolean isRepeated() {
            if (this.mSuccessiveRateLimitCycles < 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getAllowedEntries() {
            if (isRepeated() == false) goto L6;
            return DropboxRateLimiter.m1513$$Nest$fgetmStrictRatelimitAllowedEntries(this.this$0);
        L6:
            return DropboxRateLimiter.m1509$$Nest$fgetmRateLimitAllowedEntries(this.this$0);
        }

        public long getBufferDuration() {
            if (isRepeated() == false) goto L6;
            return DropboxRateLimiter.m1512$$Nest$fgetmStrictRateLimitBufferDuration(this.this$0);
        L6:
            return DropboxRateLimiter.m1510$$Nest$fgetmRateLimitBufferDuration(this.this$0);
        }

        public boolean hasExpired(long currentTime) {
            long bufferExpiry = DropboxRateLimiter.m1511$$Nest$fgetmRateLimitBufferExpiryFactor(this.this$0) * getBufferDuration();
            if ((currentTime - this.mStartTime) <= bufferExpiry) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class RateLimitResult {
        final int mDroppedCountSinceRateLimitActivated;
        final boolean mShouldRateLimit;

        public RateLimitResult(DropboxRateLimiter this$0, boolean shouldRateLimit, int droppedCountSinceRateLimitActivated) {
            this.mShouldRateLimit = shouldRateLimit;
            this.mDroppedCountSinceRateLimitActivated = droppedCountSinceRateLimitActivated;
        }

        public boolean shouldRateLimit() {
            return this.mShouldRateLimit;
        }

        public int droppedCountSinceRateLimitActivated() {
            return this.mDroppedCountSinceRateLimitActivated;
        }

        public String createHeader() {
            return "Dropped-Count: " + this.mDroppedCountSinceRateLimitActivated + "\n";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRateLimitAllowedEntries, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1509$$Nest$fgetmRateLimitAllowedEntries(DropboxRateLimiter r0) {
        return r0.mRateLimitAllowedEntries;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRateLimitBufferDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1510$$Nest$fgetmRateLimitBufferDuration(DropboxRateLimiter r2) {
        return r2.mRateLimitBufferDuration;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRateLimitBufferExpiryFactor, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1511$$Nest$fgetmRateLimitBufferExpiryFactor(DropboxRateLimiter r2) {
        return r2.mRateLimitBufferExpiryFactor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrictRateLimitBufferDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1512$$Nest$fgetmStrictRateLimitBufferDuration(DropboxRateLimiter r2) {
        return r2.mStrictRateLimitBufferDuration;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrictRatelimitAllowedEntries, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1513$$Nest$fgetmStrictRatelimitAllowedEntries(DropboxRateLimiter r0) {
        return r0.mStrictRatelimitAllowedEntries;
    }

    public DropboxRateLimiter() {
        this(new DefaultClock(null));
    }

    public DropboxRateLimiter(Clock clock) {
        this.mErrorClusterRecords = new ArrayMap();
        this.mLastMapCleanUp = 0;
        this.mClock = clock;
        this.mRateLimitBufferDuration = 600000;
        this.mRateLimitBufferExpiryFactor = 3;
        this.mRateLimitAllowedEntries = 10;
        this.mStrictRatelimitAllowedEntries = 5;
        this.mStrictRateLimitBufferDuration = STRICT_RATE_LIMIT_BUFFER_DURATION_DEFAULT;
    }

    public void init() {
        this.mRateLimitBufferDuration = DeviceConfig.getLong(FLAG_NAMESPACE, "DropboxRateLimiter__rate_limit_buffer_duration", 600000);
        this.mRateLimitBufferExpiryFactor = DeviceConfig.getLong(FLAG_NAMESPACE, "DropboxRateLimiter__rate_limit_buffer_expiry_factor", 3);
        this.mRateLimitAllowedEntries = DeviceConfig.getInt(FLAG_NAMESPACE, "DropboxRateLimiter__rate_limit_allowed_entries", 10);
        this.mStrictRatelimitAllowedEntries = DeviceConfig.getInt(FLAG_NAMESPACE, "DropboxRateLimiter__strict_rate_limit_allowed_entries", 5);
        this.mStrictRateLimitBufferDuration = DeviceConfig.getLong(FLAG_NAMESPACE, "DropboxRateLimiter__strict_rate_limit_buffer_duration", STRICT_RATE_LIMIT_BUFFER_DURATION_DEFAULT);
    }

    public RateLimitResult shouldRateLimit(String eventType, String processName) {
        long now = this.mClock.uptimeMillis();
        ArrayMap<String, ErrorRecord> r2 = this.mErrorClusterRecords;
        monitor-enter(r2);
        maybeRemoveExpiredRecords(now);     // Catch: Throwable -> L9
        ErrorRecord errRecord = this.mErrorClusterRecords.get(errorKey(eventType, processName));     // Catch: Throwable -> L9
        if (errRecord != null) goto L11;
        ErrorRecord errRecord2 = new ErrorRecord(this, now, 1);     // Catch: Throwable -> L9
        this.mErrorClusterRecords.put(errorKey(eventType, processName), errRecord2);     // Catch: Throwable -> L9
        RateLimitResult r3 = new RateLimitResult(this, false, 0);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r3;
    L11:
        long timeSinceFirstError = now - errRecord.getStartTime();     // Catch: Throwable -> L9
        if (timeSinceFirstError <= errRecord.getBufferDuration()) goto L22;
        int errCount = recentlyDroppedCount(errRecord);     // Catch: Throwable -> L9
        errRecord.setStartTime(now);     // Catch: Throwable -> L9
        errRecord.setCount(1);     // Catch: Throwable -> L9
        if (errCount > 0) goto L16;
    L18:
        errRecord.setSuccessiveRateLimitCycles(0);     // Catch: Throwable -> L9
    L19:
        RateLimitResult r4 = new RateLimitResult(this, false, errCount);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r4;
    L16:
        if (timeSinceFirstError >= (errRecord.getBufferDuration() * 2)) goto L18;
        errRecord.incrementSuccessiveRateLimitCycles();     // Catch: Throwable -> L9
        goto L19
    L22:
        errRecord.incrementCount();     // Catch: Throwable -> L9
        if (errRecord.getCount() <= errRecord.getAllowedEntries()) goto L28;
        RateLimitResult r5 = new RateLimitResult(this, true, recentlyDroppedCount(errRecord));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r5;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return new RateLimitResult(this, false, 0);
    L9:
        th = move-exception;
        throw th;
    }

    private int recentlyDroppedCount(ErrorRecord errRecord) {
        if (errRecord != null) goto L4;
        return 0;
    L4:
        if (errRecord.getCount() >= errRecord.getAllowedEntries()) goto L7;
        return 0;
    L7:
        return errRecord.getCount() - errRecord.getAllowedEntries();
    }

    private void maybeRemoveExpiredRecords(long currentTime) {
        if ((currentTime - this.mLastMapCleanUp) > (this.mRateLimitBufferExpiryFactor * this.mRateLimitBufferDuration)) goto L5;
        return;
    L5:
        int i = this.mErrorClusterRecords.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (this.mErrorClusterRecords.valueAt(i).hasExpired(currentTime) == false) goto L10;
        Counter.logIncrement("stability_errors.value_dropbox_buffer_expired_count", this.mErrorClusterRecords.valueAt(i).getCount());
        this.mErrorClusterRecords.removeAt(i);
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mLastMapCleanUp = currentTime;
    }

    public void reset() {
        ArrayMap<String, ErrorRecord> r0 = this.mErrorClusterRecords;
        monitor-enter(r0);
        this.mErrorClusterRecords.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mLastMapCleanUp = 0;
        Slog.i(TAG, "Rate limiter reset.");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    String errorKey(String eventType, String processName) {
        return eventType + processName;
    }
}
