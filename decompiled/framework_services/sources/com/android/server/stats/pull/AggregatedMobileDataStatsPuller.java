package com.android.server.stats.pull;

import android.app.ActivityManager;
import android.app.usage.NetworkStatsManager;
import android.net.NetworkStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.StatsEvent;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.selinux.RateLimiter;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class AggregatedMobileDataStatsPuller {
    private static final boolean DEBUG = false;
    private static final String TAG = "AggregatedMobileDataStatsPuller";
    private static final int UID_STATS_MAX_SIZE = 3000;
    private NetworkStats mLastMobileUidStats;
    private final Object mLock;
    private final Handler mMobileDataStatsHandler;
    private final NetworkStatsManager mNetworkStatsManager;
    private final RateLimiter mRateLimiter;
    private final SparseIntArray mUidPreviousState;
    private final Map<UidProcState, MobileDataStats> mUidStats;

    private static class MobileDataStats {
        private long mRxBytes;
        private long mRxPackets;
        private long mTxBytes;
        private long mTxPackets;

        /* synthetic */ MobileDataStats(AggregatedMobileDataStatsPullerIA r1) {
            this();
        }

        private MobileDataStats() {
            this.mRxPackets = 0;
            this.mTxPackets = 0;
            this.mRxBytes = 0;
            this.mTxBytes = 0;
        }

        public long getRxPackets() {
            return this.mRxPackets;
        }

        public long getTxPackets() {
            return this.mTxPackets;
        }

        public long getRxBytes() {
            return this.mRxBytes;
        }

        public long getTxBytes() {
            return this.mTxBytes;
        }

        public void addRxPackets(long rxPackets) {
            this.mRxPackets += rxPackets;
        }

        public void addTxPackets(long txPackets) {
            this.mTxPackets += txPackets;
        }

        public void addRxBytes(long rxBytes) {
            this.mRxBytes += rxBytes;
        }

        public void addTxBytes(long txBytes) {
            this.mTxBytes += txBytes;
        }

        public boolean isEmpty() {
            if (this.mRxPackets == 0) goto L5;
        L11:
            return false;
        L5:
            if (this.mTxPackets != 0) goto L11;
            if (this.mRxBytes != 0) goto L11;
            if (this.mTxBytes != 0) goto L11;
            return true;
        }
    }

    private static class UidProcState {
        private final int mState;
        private final int mUid;

        UidProcState(int uid, int state) {
            this.mUid = uid;
            this.mState = state;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof UidProcState) == false) goto L14;
            UidProcState key = (UidProcState) o;
            if (this.mUid != key.mUid) goto L13;
            if (this.mState != key.mState) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            int result = this.mUid;
            return (result * 31) + this.mState;
        }

        public int getUid() {
            return this.mUid;
        }

        public int getState() {
            return this.mState;
        }
    }

    public static /* synthetic */ void $r8$lambda$TUrXXS0k7WcZnRrfjsngjNomQ8w(AggregatedMobileDataStatsPuller r0, int r1, int r2) {
        r0.lambda$noteUidProcessState$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$t4qGpDfNygeaR2N48fNhkmgoaeo(AggregatedMobileDataStatsPuller r0) {
        r0.lambda$new$0();
    }

    AggregatedMobileDataStatsPuller(NetworkStatsManager networkStatsManager) {
        this.mLock = new Object();
        this.mLastMobileUidStats = new NetworkStats(0, -1);
        this.mRateLimiter = new RateLimiter(Duration.ofSeconds(1));
        this.mUidStats = new ArrayMap();
        this.mUidPreviousState = new SparseIntArray();
        this.mNetworkStatsManager = networkStatsManager;
        HandlerThread mMobileDataStatsHandlerThread = new HandlerThread("MobileDataStatsHandler");
        mMobileDataStatsHandlerThread.start();
        this.mMobileDataStatsHandler = new Handler(mMobileDataStatsHandlerThread.getLooper());
        if (this.mNetworkStatsManager == null) goto L6;
        this.mMobileDataStatsHandler.post(new AggregatedMobileDataStatsPuller$$ExternalSyntheticLambda0(this));
        return;
    }

    private /* synthetic */ void lambda$new$0() {
        updateNetworkStats(this.mNetworkStatsManager);
    }

    public void noteUidProcessState(final int uid, final int state, long unusedElapsedRealtime, long unusedUptime) {
        if (this.mRateLimiter.tryAcquire() == false) goto L5;
        this.mMobileDataStatsHandler.post(new AggregatedMobileDataStatsPuller$$ExternalSyntheticLambda1(this, uid, state));
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidPreviousState.put(uid, state);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteUidProcessState$1(int uid, int state) {
        noteUidProcessStateImpl(uid, state);
    }

    public int pullDataBytesTransfer(List<StatsEvent> data) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = pullDataBytesTransferLocked(data);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private MobileDataStats getUidStatsForPreviousStateLocked(int uid) {
        int previousState = this.mUidPreviousState.get(uid, -1);
        UidProcState statsKey = new UidProcState(uid, previousState);
        if (this.mUidStats.containsKey(statsKey) == true) goto L5;
        AggregatedMobileDataStatsPullerIA r4 = null;
        if (this.mUidStats.size() >= 3000) goto L10;
        MobileDataStats stats = new MobileDataStats(r4);
        this.mUidStats.put(statsKey, stats);
        return stats;
    L10:
        return null;
    L5:
        return this.mUidStats.get(statsKey);
    }

    private void noteUidProcessStateImpl(int uid, int state) {
        if (this.mNetworkStatsManager == null) goto L5;
        updateNetworkStats(this.mNetworkStatsManager);
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidPreviousState.put(uid, state);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        Slog.w(TAG, "noteUidProcessStateLocked() can not get mNetworkStatsManager");
        goto L6
    }

    private void updateNetworkStats(NetworkStatsManager networkStatsManager) {
        NetworkStats latestStats = networkStatsManager.getMobileUidStats();
        if (isEmpty(latestStats) == false) goto L5;
        return;
    L5:
        NetworkStats delta = latestStats.subtract(this.mLastMobileUidStats);
        this.mLastMobileUidStats = latestStats;
        if (isEmpty(delta) == true) goto L9;
        updateNetworkStatsDelta(delta);
        return;
    }

    private void updateNetworkStatsDelta(NetworkStats delta) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator r1 = delta.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L18;
        NetworkStats.Entry entry = (NetworkStats.Entry) r1.next();     // Catch: Throwable -> L12
        if (entry.getRxPackets() != 0) goto L14;
        if (entry.getTxPackets() == 0) goto L6;
    L14:
        MobileDataStats stats = getUidStatsForPreviousStateLocked(entry.getUid());     // Catch: Throwable -> L12
        if (stats == null) goto L6;
        stats.addTxBytes(entry.getTxBytes());     // Catch: Throwable -> L12
        stats.addRxBytes(entry.getRxBytes());     // Catch: Throwable -> L12
        stats.addTxPackets(entry.getTxPackets());     // Catch: Throwable -> L12
        stats.addRxPackets(entry.getRxPackets());     // Catch: Throwable -> L12
        goto L6
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private int pullDataBytesTransferLocked(List<StatsEvent> pulledData) {
        Iterator<Map.Entry<UidProcState, MobileDataStats>> r1 = this.mUidStats.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<UidProcState, MobileDataStats> uidStats = r1.next();
        if (uidStats.getValue().isEmpty() == true) goto L4;
        MobileDataStats stats = uidStats.getValue();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.MOBILE_BYTES_TRANSFER_BY_PROC_STATE, uidStats.getKey().getUid(), ActivityManager.processStateAmToProto(uidStats.getKey().getState()), stats.getRxBytes(), stats.getRxPackets(), stats.getTxBytes(), stats.getTxPackets()));
        goto L4
    L11:
        return 0;
    }

    private static boolean isEmpty(NetworkStats stats) {
        Iterator r0 = stats.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        NetworkStats.Entry entry = (NetworkStats.Entry) r0.next();
        if (entry.getRxPackets() != 0) goto L11;
        if (entry.getTxPackets() == 0) goto L4;
        return false;
    L11:
        return false;
    L13:
        return true;
    }
}
