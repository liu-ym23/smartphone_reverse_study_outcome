package com.android.server.power.stats;

import android.content.pm.PackageManager;
import android.net.NetworkStats;
import android.net.wifi.WifiManager;
import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.connectivity.WifiActivityEnergyInfo;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.power.stats.format.WifiPowerStatsLayout;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class WifiPowerStatsCollector extends PowerStatsCollector {
    private static final String TAG = "WifiPowerStatsCollector";
    private static final long WIFI_ACTIVITY_REQUEST_TIMEOUT = 20000;
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private long[] mDeviceStats;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private NetworkStats mLastNetworkStats;
    private final SparseArray<WifiScanTimes> mLastScanTimes;
    private long mLastWifiActiveDuration;
    private WifiActivityEnergyInfo mLastWifiActivityInfo;
    private WifiPowerStatsLayout mLayout;
    private volatile Supplier<NetworkStats> mNetworkStatsSupplier;
    private final Observer mObserver;
    private boolean mPowerReportingSupported;
    private PowerStats mPowerStats;
    private final WifiScanTimes mScanTimes;
    private volatile WifiManager mWifiManager;
    private volatile WifiStatsRetriever mWifiStatsRetriever;

    public interface Injector {
        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        Handler getHandler();

        PackageManager getPackageManager();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        PowerStatsUidResolver getUidResolver();

        WifiManager getWifiManager();

        Supplier<NetworkStats> getWifiNetworkStatsSupplier();

        WifiStatsRetriever getWifiStatsRetriever();

        NetworkStats networkStatsDelta(NetworkStats r1, NetworkStats r2);
    }

    interface Observer {
        void onWifiPowerStatsRetrieved(WifiActivityEnergyInfo r1, NetworkStats r2, long r3, long r5);
    }

    private static class WifiScanTimes {
        public long basicScanTimeMs;
        public long batchedScanTimeMs;

        /* synthetic */ WifiScanTimes(WifiPowerStatsCollectorIA r1) {
            this();
        }

        private WifiScanTimes() {
        }
    }

    public interface WifiStatsRetriever {

        public interface Callback {
            void onWifiScanTime(int r1, long r2, long r4);
        }

        long getWifiActiveDuration();

        void retrieveWifiScanTimes(Callback r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wa61-wcxIfhXx-hiP5ddUIUF1Vk, reason: not valid java name */
    public static /* synthetic */ void m7851$r8$lambda$wa61wcxIfhXxhiP5ddUIUF1Vk(WifiPowerStatsCollector r0, int r1, long r2, long r4) {
        r0.lambda$collectWifiScanTime$0(r1, r2, r4);
    }

    public WifiPowerStatsCollector(Injector injector, Observer observer) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(11)), injector.getUidResolver(), injector.getClock());
        this.mScanTimes = new WifiScanTimes(null);
        this.mLastScanTimes = new SparseArray();
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
        if (packageManager.hasSystemFeature("android.hardware.wifi") == false) goto L10;
        r0 = true;
        goto L10
    L11:
        super.setEnabled(false);
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (isEnabled() == true) goto L8;
        return false;
    L8:
        this.mWifiManager = this.mInjector.getWifiManager();
        this.mNetworkStatsSupplier = this.mInjector.getWifiNetworkStatsSupplier();
        this.mWifiStatsRetriever = this.mInjector.getWifiStatsRetriever();
        if (this.mWifiManager != null) goto L11;
    L14:
        this.mPowerReportingSupported = r2;
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), 6);
        this.mLayout = new WifiPowerStatsLayout(this.mConsumedEnergyHelper.getEnergyConsumerCount(), this.mPowerReportingSupported);
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        PowerStats.Descriptor powerStatsDescriptor = new PowerStats.Descriptor(11, this.mLayout.getDeviceStatsArrayLength(), null, 0, this.mLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(powerStatsDescriptor);
        this.mDeviceStats = this.mPowerStats.stats;
        this.mIsInitialized = true;
        return true;
    L11:
        if (this.mWifiManager.isEnhancedPowerReportingSupported() == false) goto L14;
        r2 = true;
        goto L14
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public PowerStats collectStats() {
        if (ensureInitialized() == true) goto L6;
        return null;
    L6:
        Arrays.fill(this.mDeviceStats, 0);
        this.mPowerStats.uidStats.clear();
        if (this.mPowerReportingSupported == false) goto L9;
        WifiActivityEnergyInfo activityInfo = collectWifiActivityInfo();
        WifiActivityEnergyInfo activityInfo2 = activityInfo;
    L10:
        NetworkStats networkStatsDeltas = collectNetworkStats();
        collectWifiScanTime();
        this.mConsumedEnergyHelper.collectConsumedEnergy(this.mPowerStats, this.mLayout);
        if (this.mObserver == null) goto L14;
        this.mObserver.onWifiPowerStatsRetrieved(activityInfo2, networkStatsDeltas, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    L14:
        return this.mPowerStats;
    L9:
        collectWifiActivityStats();
        activityInfo2 = null;
        goto L10
    }

    private WifiActivityEnergyInfo collectWifiActivityInfo() {
        final CompletableFuture<WifiActivityEnergyInfo> immediateFuture = new CompletableFuture();
        this.mWifiManager.getWifiActivityEnergyInfoAsync(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new WifiPowerStatsCollector$$ExternalSyntheticLambda0(immediateFuture));
        WifiActivityEnergyInfo activityInfo = immediateFuture.get(WIFI_ACTIVITY_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: Exception -> L5
    L7:
        if (activityInfo != null) goto L10;
        return null;
    L10:
        long rxDuration = 0;
        long txDuration = 0;
        long scanDuration = 0;
        long idleDuration = 0;
        if (this.mLastWifiActivityInfo == null) goto L13;
        rxDuration = activityInfo.getControllerRxDurationMillis() - this.mLastWifiActivityInfo.getControllerRxDurationMillis();
        txDuration = activityInfo.getControllerTxDurationMillis() - this.mLastWifiActivityInfo.getControllerTxDurationMillis();
        scanDuration = activityInfo.getControllerScanDurationMillis() - this.mLastWifiActivityInfo.getControllerScanDurationMillis();
        idleDuration = activityInfo.getControllerIdleDurationMillis() - this.mLastWifiActivityInfo.getControllerIdleDurationMillis();
    L13:
        this.mLayout.setDeviceRxTime(this.mDeviceStats, rxDuration);
        this.mLayout.setDeviceTxTime(this.mDeviceStats, txDuration);
        this.mLayout.setDeviceScanTime(this.mDeviceStats, scanDuration);
        this.mLayout.setDeviceIdleTime(this.mDeviceStats, idleDuration);
        this.mPowerStats.durationMs = ((rxDuration + txDuration) + scanDuration) + idleDuration;
        this.mLastWifiActivityInfo = activityInfo;
        return new WifiActivityEnergyInfo(activityInfo.getTimeSinceBootMillis(), activityInfo.getStackState(), txDuration, rxDuration, scanDuration, idleDuration);
    L5:
        e = move-exception;
        Slog.e(TAG, "Cannot acquire WifiActivityEnergyInfo", e);
        activityInfo = null;
        goto L7
    }

    private void collectWifiActivityStats() {
        long duration = this.mWifiStatsRetriever.getWifiActiveDuration();
        this.mLayout.setDeviceActiveTime(this.mDeviceStats, Math.max(0, duration - this.mLastWifiActiveDuration));
        this.mLastWifiActiveDuration = duration;
        this.mPowerStats.durationMs = duration;
    }

    private NetworkStats collectNetworkStats() {
        NetworkStats networkStats = this.mNetworkStatsSupplier.get();
        if (networkStats != null) goto L6;
        return null;
    L6:
        NetworkStats delta = this.mInjector.networkStatsDelta(networkStats, this.mLastNetworkStats);
        this.mLastNetworkStats = networkStats;
        Iterator r3 = delta.iterator();
    L8:
        if (r3.hasNext() == false) goto L24;
        NetworkStats.Entry uidDelta = (NetworkStats.Entry) r3.next();
        long rxBytes = uidDelta.getRxBytes();
        long txBytes = uidDelta.getTxBytes();
        long rxPackets = uidDelta.getRxPackets();
        long txPackets = uidDelta.getTxPackets();
        if (rxBytes != 0) goto L18;
        if (txBytes != 0) goto L18;
        if (rxPackets != 0) goto L18;
        if (txPackets == 0) goto L8;
    L18:
        int uid = this.mUidResolver.mapUid(uidDelta.getUid());
        long[] stats = (long[]) this.mPowerStats.uidStats.get(uid);
        if (stats != null) goto L21;
        long[] stats2 = new long[this.mLayout.getUidStatsArrayLength()];
        this.mPowerStats.uidStats.put(uid, stats2);
        this.mLayout.setUidRxBytes(stats2, rxBytes);
        this.mLayout.setUidTxBytes(stats2, txBytes);
        this.mLayout.setUidRxPackets(stats2, rxPackets);
        this.mLayout.setUidTxPackets(stats2, txPackets);
    L22:
        r3 = r3;
        networkStats = networkStats;
        delta = delta;
        goto L8
    L21:
        this.mLayout.setUidRxBytes(stats, this.mLayout.getUidRxBytes(stats) + rxBytes);
        this.mLayout.setUidTxBytes(stats, this.mLayout.getUidTxBytes(stats) + txBytes);
        this.mLayout.setUidRxPackets(stats, this.mLayout.getUidRxPackets(stats) + rxPackets);
        this.mLayout.setUidTxPackets(stats, this.mLayout.getUidTxPackets(stats) + txPackets);
        goto L22
    L24:
        return delta;
    }

    private void collectWifiScanTime() {
        this.mScanTimes.basicScanTimeMs = 0;
        this.mScanTimes.batchedScanTimeMs = 0;
        this.mWifiStatsRetriever.retrieveWifiScanTimes(new WifiPowerStatsCollector$$ExternalSyntheticLambda1(this));
        this.mLayout.setDeviceBasicScanTime(this.mDeviceStats, this.mScanTimes.basicScanTimeMs);
        this.mLayout.setDeviceBatchedScanTime(this.mDeviceStats, this.mScanTimes.batchedScanTimeMs);
    }

    private /* synthetic */ void lambda$collectWifiScanTime$0(int uid, long scanTimeMs, long batchScanTimeMs) {
        WifiScanTimes lastScanTimes = this.mLastScanTimes.get(uid);
        if (lastScanTimes != null) goto L5;
        lastScanTimes = new WifiScanTimes(null);
        this.mLastScanTimes.put(uid, lastScanTimes);
    L5:
        long scanTimeDelta = Math.max(0, scanTimeMs - lastScanTimes.basicScanTimeMs);
        long batchScanTimeDelta = Math.max(0, batchScanTimeMs - lastScanTimes.batchedScanTimeMs);
        if (scanTimeDelta == 0) goto L8;
    L9:
        this.mScanTimes.basicScanTimeMs += scanTimeDelta;
        this.mScanTimes.batchedScanTimeMs += batchScanTimeDelta;
        int uid2 = this.mUidResolver.mapUid(uid);
        long[] stats = (long[]) this.mPowerStats.uidStats.get(uid2);
        if (stats != null) goto L12;
        long[] stats2 = new long[this.mLayout.getUidStatsArrayLength()];
        this.mPowerStats.uidStats.put(uid2, stats2);
        this.mLayout.setUidScanTime(stats2, scanTimeDelta);
        this.mLayout.setUidBatchScanTime(stats2, batchScanTimeDelta);
    L13:
        lastScanTimes.basicScanTimeMs = scanTimeMs;
        lastScanTimes.batchedScanTimeMs = batchScanTimeMs;
        return;
    L12:
        this.mLayout.setUidScanTime(stats, this.mLayout.getUidScanTime(stats) + scanTimeDelta);
        this.mLayout.setUidBatchScanTime(stats, this.mLayout.getUidBatchedScanTime(stats) + batchScanTimeDelta);
        goto L13
    L8:
        if (batchScanTimeDelta == 0) goto L13;
        goto L9
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected void onUidRemoved(int uid) {
        super.onUidRemoved(uid);
        this.mLastScanTimes.remove(uid);
    }
}
