package com.android.server.power.stats;

import android.bluetooth.BluetoothActivityEnergyInfo;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.UidTraffic;
import android.content.pm.PackageManager;
import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.power.stats.format.BluetoothPowerStatsLayout;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothPowerStatsCollector extends PowerStatsCollector {
    private static final long BLUETOOTH_ACTIVITY_REQUEST_TIMEOUT = 20000;
    private static final String TAG = "BluetoothPowerStatsCollector";
    private BluetoothStatsRetriever mBluetoothStatsRetriever;
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private PowerStatsCollector.ConsumedEnergyRetriever mConsumedEnergyRetriever;
    private long[] mDeviceStats;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private long mLastIdleTime;
    private long mLastRxTime;
    private long mLastTxTime;
    private BluetoothPowerStatsLayout mLayout;
    private final Observer mObserver;
    private PowerStats mPowerStats;
    private final SparseArray<UidStats> mUidStats;

    public interface BluetoothStatsRetriever {

        public interface Callback {
            void onBluetoothScanTime(int r1, long r2);
        }

        boolean requestControllerActivityEnergyInfo(Executor r1, BluetoothAdapter.OnBluetoothActivityEnergyInfoCallback r2);

        void retrieveBluetoothScanTimes(Callback r1);
    }

    public interface Injector {
        BluetoothStatsRetriever getBluetoothStatsRetriever();

        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        Handler getHandler();

        PackageManager getPackageManager();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        PowerStatsUidResolver getUidResolver();
    }

    interface Observer {
        void onBluetoothPowerStatsRetrieved(BluetoothActivityEnergyInfo r1, long r2, long r4);
    }

    private static class UidStats {
        public long lastRxCount;
        public long lastScanTime;
        public long lastTxCount;
        public long rxCount;
        public long scanTime;
        public long txCount;

        /* synthetic */ UidStats(BluetoothPowerStatsCollectorIA r1) {
            this();
        }

        private UidStats() {
        }
    }

    public static /* synthetic */ void $r8$lambda$3824U9J2kTG05xiNsh4SEdMikUA(BluetoothPowerStatsCollector r0, int r1, long r2) {
        r0.lambda$collectBluetoothScanStats$0(r1, r2);
    }

    public BluetoothPowerStatsCollector(Injector injector, Observer observer) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(2)), injector.getUidResolver(), injector.getClock());
        this.mUidStats = new SparseArray();
        this.mInjector = injector;
        this.mObserver = observer;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public void setEnabled(boolean enabled) {
        boolean r0 = false;
        if (enabled == false) goto L11;
        PackageManager packageManager = this.mInjector.getPackageManager();
        if (packageManager != null) goto L7;
    L10:
        super.setEnabled(r0);
        return;
    L7:
        if (packageManager.hasSystemFeature("android.hardware.bluetooth") == false) goto L10;
        r0 = true;
        goto L10
    L11:
        super.setEnabled(false);
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L6;
        return true;
    L6:
        if (isEnabled() == true) goto L9;
        return false;
    L9:
        this.mBluetoothStatsRetriever = this.mInjector.getBluetoothStatsRetriever();
        this.mConsumedEnergyRetriever = this.mInjector.getConsumedEnergyRetriever();
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mConsumedEnergyRetriever, 1);
        this.mLayout = new BluetoothPowerStatsLayout(this.mConsumedEnergyHelper.getEnergyConsumerCount());
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        PowerStats.Descriptor powerStatsDescriptor = new PowerStats.Descriptor(2, this.mLayout.getDeviceStatsArrayLength(), null, 0, this.mLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(powerStatsDescriptor);
        this.mDeviceStats = this.mPowerStats.stats;
        this.mIsInitialized = true;
        return true;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public PowerStats collectStats() {
        if (ensureInitialized() == true) goto L6;
        return null;
    L6:
        Arrays.fill(this.mDeviceStats, 0);
        this.mPowerStats.uidStats.clear();
        BluetoothActivityEnergyInfo activityInfo = collectBluetoothActivityInfo();
        collectBluetoothScanStats();
        this.mConsumedEnergyHelper.collectConsumedEnergy(this.mPowerStats, this.mLayout);
        if (this.mObserver == null) goto L10;
        this.mObserver.onBluetoothPowerStatsRetrieved(activityInfo, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    L10:
        return this.mPowerStats;
    }

    private BluetoothActivityEnergyInfo collectBluetoothActivityInfo() {
        final CompletableFuture<BluetoothActivityEnergyInfo> immediateFuture = new CompletableFuture();
        boolean success = this.mBluetoothStatsRetriever.requestControllerActivityEnergyInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass1(this, immediateFuture));
        if (success == true) goto L34;
        return null;
    L34:
        BluetoothActivityEnergyInfo activityInfo = immediateFuture.get(BLUETOOTH_ACTIVITY_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: Exception -> L7
    L9:
        if (activityInfo != null) goto L11;
        return null;
    L11:
        long rxTime = activityInfo.getControllerRxTimeMillis();
        long rxTimeDelta = Math.max(0, rxTime - this.mLastRxTime);
        this.mLayout.setDeviceRxTime(this.mDeviceStats, rxTimeDelta);
        this.mLastRxTime = rxTime;
        long txTime = activityInfo.getControllerTxTimeMillis();
        long txTimeDelta = Math.max(0, txTime - this.mLastTxTime);
        this.mLayout.setDeviceTxTime(this.mDeviceStats, txTimeDelta);
        this.mLastTxTime = txTime;
        long idleTime = activityInfo.getControllerIdleTimeMillis();
        CompletableFuture<BluetoothActivityEnergyInfo> immediateFuture2 = immediateFuture;
        long idleTimeDelta = Math.max(0, idleTime - this.mLastIdleTime);
        this.mLayout.setDeviceIdleTime(this.mDeviceStats, idleTimeDelta);
        this.mLastIdleTime = idleTime;
        this.mPowerStats.durationMs = (rxTimeDelta + txTimeDelta) + idleTimeDelta;
        List<UidTraffic> uidTraffic = activityInfo.getUidTraffic();
        int i = uidTraffic.size() - 1;
    L12:
        if (i < 0) goto L18;
        UidTraffic ut = uidTraffic.get(i);
        BluetoothActivityEnergyInfo activityInfo2 = activityInfo;
        int uid = this.mUidResolver.mapUid(ut.getUid());
        UidStats counts = this.mUidStats.get(uid);
        if (counts != null) goto L17;
        counts = new UidStats(null);
        this.mUidStats.put(uid, counts);
    L17:
        counts.rxCount += ut.getRxBytes();
        counts.txCount += ut.getTxBytes();
        i = i - 1;
        activityInfo = activityInfo2;
        uidTraffic = uidTraffic;
        goto L12
    L18:
        BluetoothActivityEnergyInfo activityInfo3 = activityInfo;
        int i2 = this.mUidStats.size() - 1;
    L19:
        if (i2 < 0) goto L33;
        UidStats counts2 = this.mUidStats.valueAt(i2);
        CompletableFuture<BluetoothActivityEnergyInfo> immediateFuture3 = immediateFuture2;
        long rxDelta = Math.max(0, counts2.rxCount - counts2.lastRxCount);
        counts2.lastRxCount = counts2.rxCount;
        counts2.rxCount = 0;
        long rxTimeDelta2 = rxTimeDelta;
        long txDelta = Math.max(0, counts2.txCount - counts2.lastTxCount);
        counts2.lastTxCount = counts2.txCount;
        counts2.txCount = 0;
        if (rxDelta == 0) goto L23;
    L26:
        int uid2 = this.mUidStats.keyAt(i2);
        long[] stats = (long[]) this.mPowerStats.uidStats.get(uid2);
        if (stats != null) goto L30;
        stats = new long[this.mLayout.getUidStatsArrayLength()];
        this.mPowerStats.uidStats.put(uid2, stats);
    L30:
        this.mLayout.setUidRxBytes(stats, rxDelta);
        this.mLayout.setUidTxBytes(stats, txDelta);
    L31:
        i2 = i2 - 1;
        immediateFuture2 = immediateFuture3;
        rxTimeDelta = rxTimeDelta2;
        goto L19
    L23:
        if (txDelta != 0) goto L26;
        i2 = i2;
        goto L31
    L33:
        return activityInfo3;
    L7:
        e = move-exception;
        Slog.e(TAG, "Cannot acquire BluetoothActivityEnergyInfo", e);
        activityInfo = null;
        goto L9
    }

    private void collectBluetoothScanStats() {
        this.mBluetoothStatsRetriever.retrieveBluetoothScanTimes(new BluetoothPowerStatsCollector$$ExternalSyntheticLambda0(this));
        long totalScanTime = 0;
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L14;
        UidStats counts = this.mUidStats.valueAt(i);
        if (counts.scanTime == 0) goto L13;
        long delta = Math.max(0, counts.scanTime - counts.lastScanTime);
        counts.lastScanTime = counts.scanTime;
        counts.scanTime = 0;
        if (delta == 0) goto L13;
        int uid = this.mUidStats.keyAt(i);
        long[] stats = (long[]) this.mPowerStats.uidStats.get(uid);
        if (stats != null) goto L12;
        stats = new long[this.mLayout.getUidStatsArrayLength()];
        this.mPowerStats.uidStats.put(uid, stats);
    L12:
        this.mLayout.setUidScanTime(stats, delta);
        totalScanTime = totalScanTime + delta;
    L13:
        i = i - 1;
        goto L3
    L14:
        this.mLayout.setDeviceScanTime(this.mDeviceStats, totalScanTime);
    }

    private /* synthetic */ void lambda$collectBluetoothScanStats$0(int uid, long scanTimeMs) {
        int uid2 = this.mUidResolver.mapUid(uid);
        UidStats uidStats = this.mUidStats.get(uid2);
        if (uidStats != null) goto L5;
        uidStats = new UidStats(null);
        this.mUidStats.put(uid2, uidStats);
    L5:
        uidStats.scanTime += scanTimeMs;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected void onUidRemoved(int uid) {
        super.onUidRemoved(uid);
        this.mUidStats.remove(uid);
    }
}
