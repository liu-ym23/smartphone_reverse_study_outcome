package com.autonavi.base.ae.gmap;

import android.os.SystemClock;
import com.amap.api.mapcore.util.z8;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes39.dex */
final class MapNetworkMetrics {
    private static final int SNAPSHOT_COMPLETIONS = 20;
    private static final long SNAPSHOT_INTERVAL_MS = 5000;
    static final String TAG = "MapNetworkMetrics";
    private int callbackErrors;
    private int completed;
    private volatile boolean enabled;
    private int evicted;
    private final List<Long> evictedAges;
    private int failed;
    private int failedCanceled;
    private int failedDestroyed;
    private int failedNetwork;
    private int failedOther;
    private int failedReplaced;
    private int failedStopped;
    private int poolRejected;
    private int rejected;
    private int submitted;
    private int succeeded;
    private final List<Long> successNetworkTimes;
    private final List<Long> successQueueTimes;
    private final List<Long> successTotalTimes;
    private long windowStartMs;

    public static final class PoolState {
        final int active;
        final int core;
        final int largest;
        final int max;
        final int queue;

        public static PoolState from(z8 r100) {
            if (r100 == null) goto L4;
            Executor r101 = r100.c();
            if ((r101 instanceof ThreadPoolExecutor) == false) goto L8;
            ThreadPoolExecutor r102 = (ThreadPoolExecutor) r101;
            return new PoolState(r102.getActiveCount(), r102.getQueue().size(), r102.getLargestPoolSize(), r102.getCorePoolSize(), r102.getMaximumPoolSize());
        L8:
            return new PoolState(-1, -1, -1, r100.b(), r100.d());
        L4:
            return new PoolState(-1, -1, -1, -1, -1);
        }

        public PoolState(int r100, int r101, int r102, int r103, int r104) {
            this.active = r100;
            this.queue = r101;
            this.largest = r102;
            this.core = r103;
            this.max = r104;
        }
    }

    public void onSubmitted() {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        this.submitted++;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public MapNetworkMetrics() {
        this.successQueueTimes = new ArrayList();
        this.successNetworkTimes = new ArrayList();
        this.successTotalTimes = new ArrayList();
        this.evictedAges = new ArrayList();
    }

    private void resetWindowLocked() {
        this.windowStartMs = SystemClock.elapsedRealtime();
        this.submitted = 0;
        this.rejected = 0;
        this.poolRejected = 0;
        this.completed = 0;
        this.succeeded = 0;
        this.failed = 0;
        this.evicted = 0;
        this.callbackErrors = 0;
        this.failedReplaced = 0;
        this.failedStopped = 0;
        this.failedCanceled = 0;
        this.failedNetwork = 0;
        this.failedDestroyed = 0;
        this.failedOther = 0;
        this.successQueueTimes.clear();
        this.successNetworkTimes.clear();
        this.successTotalTimes.clear();
        this.evictedAges.clear();
    }

    private static long nonNegative(long r100) {
        return Math.max(0, r100);
    }

    private void recordFailureSourceLocked(String r100) {
        if ("replaced by newer queued request".equals(r100) == false) goto L6;
        this.failedReplaced++;
        return;
    L6:
        if ("network stopped".equals(r100) == false) goto L9;
        this.failedStopped++;
        return;
    L9:
        if ("network cancelled".equals(r100) == false) goto L12;
        this.failedCanceled++;
        return;
    L12:
        if (SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(r100) == false) goto L14;
        this.failedNetwork++;
        return;
    L14:
        if (r100 != null) goto L16;
    L18:
        this.failedOther++;
        return;
    L16:
        if (r100.contains("destroyed") == false) goto L18;
        this.failedDestroyed++;
    }

    public void onEvicted(long r100) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        this.evicted++;     // Catch: Throwable -> L13
        this.evictedAges.add(Long.valueOf(nonNegative(System.currentTimeMillis() - r100)));     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    private static long percentile(List<Long> r100, int r101) {
        if (r100.isEmpty() == false) goto L6;
        return -1;
    L6:
        ArrayList r102 = new ArrayList(r100);
        Collections.sort(r102);
        return ((Long) ListProtector.get(r102, Math.max(0, Math.min(((int) Math.ceil((((double) r101) / 100.0d) * ((double) r102.size()))) - 1, r102.size() - 1)))).longValue();
    }

    public void forceSnapshot(z8 r100, int r101) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        maybeLogLocked(r100, r101, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public void onPoolRejected(z8 r100, int r101) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        this.poolRejected++;     // Catch: Throwable -> L13
        maybeLogLocked(r100, r101, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public void onRejected(z8 r100, int r101) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        this.rejected++;     // Catch: Throwable -> L13
        maybeLogLocked(r100, r101, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    private void maybeLogLocked(z8 r100, int r101, boolean r102) {
        long r103 = SystemClock.elapsedRealtime();
        if (r102 == true) goto L10;
        if (this.completed >= 20) goto L10;
        if ((r103 - this.windowStartMs) >= 5000) goto L10;
        return;
    L10:
        if (this.submitted == 0) goto L12;
    L18:
        PoolState r104 = PoolState.from(r100);
        Math.max(1, r103 - this.windowStartMs);
        percentile(this.evictedAges, 50);
        percentile(this.evictedAges, 95);
        percentile(this.successQueueTimes, 50);
        percentile(this.successQueueTimes, 95);
        percentile(this.successNetworkTimes, 50);
        percentile(this.successNetworkTimes, 95);
        percentile(this.successTotalTimes, 50);
        percentile(this.successTotalTimes, 95);
        int r105 = r104.active;
        resetWindowLocked();
        return;
    L12:
        if (this.completed != 0) goto L18;
        if (this.rejected != 0) goto L18;
        if (this.poolRejected != 0) goto L18;
    }

    public void setEnabled(boolean r100, z8 r101, int r102) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.enabled != r100) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        this.enabled = r100;     // Catch: Throwable -> L12
        resetWindowLocked();     // Catch: Throwable -> L12
        if (r100 == false) goto L10;
        int r103 = PoolState.from(r101).core;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public void onTerminal(boolean r100, String r101, boolean r102, long r103, long r110, long r111, z8 r112, int r113) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L7:
        if (this.enabled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L10:
        this.completed++;     // Catch: Throwable -> L30
        if (r102 == true) goto L13;
        this.callbackErrors++;     // Catch: Throwable -> L30
    L13:
        long r104 = 0;
        if (r111 > 0) goto L17;
        r111 = System.currentTimeMillis();     // Catch: Throwable -> L30
    L17:
        if (r100 == false) goto L26;
        this.succeeded++;     // Catch: Throwable -> L30
        List<Long> r105 = this.successQueueTimes;     // Catch: Throwable -> L30
        if (r110 <= 0) goto L21;
        long r106 = nonNegative(r110 - r103);     // Catch: Throwable -> L30
    L22:
        r105.add(Long.valueOf(r106));     // Catch: Throwable -> L30
        List<Long> r107 = this.successNetworkTimes;     // Catch: Throwable -> L30
        if (r110 <= 0) goto L25;
        r104 = nonNegative(r111 - r110);     // Catch: Throwable -> L30
    L25:
        r107.add(Long.valueOf(r104));     // Catch: Throwable -> L30
        this.successTotalTimes.add(Long.valueOf(nonNegative(r111 - r103)));     // Catch: Throwable -> L30
    L27:
        maybeLogLocked(r112, r113, false);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L21:
        r106 = nonNegative(r111 - r103);     // Catch: Throwable -> L30
        goto L22
    L26:
        this.failed++;     // Catch: Throwable -> L30
        recordFailureSourceLocked(r101);     // Catch: Throwable -> L30
        goto L27
    }
}
