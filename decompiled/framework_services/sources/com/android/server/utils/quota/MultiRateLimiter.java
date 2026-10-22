package com.android.server.utils.quota;

import android.content.Context;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiRateLimiter {
    private static final CountQuotaTracker[] EMPTY_TRACKER_ARRAY = null;
    private static final String TAG = "MultiRateLimiter";
    private final Object mLock;
    private final CountQuotaTracker[] mQuotaTrackers;

    public static class Builder {
        private final Categorizer mCategorizer;
        private final Category mCategory;
        private final Context mContext;
        private final QuotaTracker.Injector mInjector;
        private final List<CountQuotaTracker> mQuotaTrackers;

        Builder(Context context, QuotaTracker.Injector injector) {
            this.mQuotaTrackers = new ArrayList();
            this.mContext = context;
            this.mInjector = injector;
            this.mCategorizer = Categorizer.SINGLE_CATEGORIZER;
            this.mCategory = Category.SINGLE_CATEGORY;
        }

        public Builder(Context context) {
            this(context, null);
        }

        public Builder addRateLimit(int limit, Duration windowSize) {
            if (this.mInjector == null) goto L5;
            CountQuotaTracker countQuotaTracker = new CountQuotaTracker(this.mContext, this.mCategorizer, this.mInjector);
        L6:
            countQuotaTracker.setCountLimit(this.mCategory, limit, windowSize.toMillis());
            this.mQuotaTrackers.add(countQuotaTracker);
            return this;
        L5:
            countQuotaTracker = new CountQuotaTracker(this.mContext, this.mCategorizer);
            goto L6
        }

        public Builder addRateLimit(RateLimit rateLimit) {
            return addRateLimit(rateLimit.mLimit, rateLimit.mWindowSize);
        }

        public Builder addRateLimits(RateLimit[] rateLimits) {
            int r0 = rateLimits.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            RateLimit rateLimit = rateLimits[r1];
            addRateLimit(rateLimit);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public MultiRateLimiter build() {
            return new MultiRateLimiter(this.mQuotaTrackers, null);
        }
    }

    public static class RateLimit {
        public final int mLimit;
        public final Duration mWindowSize;

        private RateLimit(int limit, Duration windowSize) {
            this.mLimit = limit;
            this.mWindowSize = windowSize;
        }

        public static RateLimit create(int limit, Duration windowSize) {
            return new RateLimit(limit, windowSize);
        }
    }

    /* synthetic */ MultiRateLimiter(List r1, MultiRateLimiterIA r2) {
        this(r1);
    }

    static {
        EMPTY_TRACKER_ARRAY = new CountQuotaTracker[0];
    }

    private MultiRateLimiter(List<CountQuotaTracker> quotaTrackers) {
        this.mLock = new Object();
        this.mQuotaTrackers = (CountQuotaTracker[]) quotaTrackers.toArray(EMPTY_TRACKER_ARRAY);
    }

    public void noteEvent(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        noteEventLocked(userId, packageName, tag);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isWithinQuota(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isWithinQuotaLocked(userId, packageName, tag);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void clear(int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearLocked(userId, packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void noteEventLocked(int userId, String packageName, String tag) {
        CountQuotaTracker[] r0 = this.mQuotaTrackers;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        CountQuotaTracker quotaTracker = r0[r2];
        quotaTracker.noteEvent(userId, packageName, tag);
        r2 = r2 + 1;
        goto L3
    }

    private boolean isWithinQuotaLocked(int userId, String packageName, String tag) {
        CountQuotaTracker[] r0 = this.mQuotaTrackers;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        CountQuotaTracker quotaTracker = r0[r3];
        if (quotaTracker.isWithinQuota(userId, packageName, tag) == false) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private void clearLocked(int userId, String packageName) {
        CountQuotaTracker[] r0 = this.mQuotaTrackers;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        CountQuotaTracker quotaTracker = r0[r2];
        quotaTracker.onAppRemovedLocked(userId, packageName);
        r2 = r2 + 1;
        goto L3
    }
}
