package com.android.server.power.stats;

import android.content.pm.PackageManager;
import android.net.NetworkStats;
import android.os.BatteryConsumer;
import android.os.BatteryStats;
import android.os.Handler;
import android.os.PersistableBundle;
import android.telephony.ModemActivityInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.power.stats.format.MobileRadioPowerStatsLayout;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class MobileRadioPowerStatsCollector extends PowerStatsCollector {
    protected static final long MOBILE_RADIO_POWER_STATE_UPDATE_FREQ_MS = 600000;
    private static final long MODEM_ACTIVITY_REQUEST_TIMEOUT = 20000;
    static final int[] NETWORK_TYPES = null;
    private static final String TAG = "MobileRadioPowerStatsCollector";
    private LongSupplier mCallDurationSupplier;
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private long[] mDeviceStats;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private long mLastCallDuration;
    private ModemActivityInfo mLastModemActivityInfo;
    private NetworkStats mLastNetworkStats;
    private long mLastScanDuration;
    private long mLastUpdateTimestampMillis;
    private MobileRadioPowerStatsLayout mLayout;
    private volatile Supplier<NetworkStats> mNetworkStatsSupplier;
    private final Observer mObserver;
    private PowerStats mPowerStats;
    private LongSupplier mScanDurationSupplier;
    private volatile TelephonyManager mTelephonyManager;

    public interface Injector {
        LongSupplier getCallDurationSupplier();

        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        Handler getHandler();

        Supplier<NetworkStats> getMobileNetworkStatsSupplier();

        PackageManager getPackageManager();

        LongSupplier getPhoneSignalScanDurationSupplier();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        TelephonyManager getTelephonyManager();

        PowerStatsUidResolver getUidResolver();

        NetworkStats networkStatsDelta(NetworkStats r1, NetworkStats r2);
    }

    interface Observer {
        void onMobileRadioPowerStatsRetrieved(ModemActivityInfo r1, NetworkStats r2, long r3, long r5);
    }

    static {
        NETWORK_TYPES = new int[]{0, 1, 2, 3, 4, 5, 6};
    }

    public MobileRadioPowerStatsCollector(Injector injector, Observer observer) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(8)), injector.getUidResolver(), injector.getClock());
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
        if (packageManager.hasSystemFeature("android.hardware.telephony") == false) goto L10;
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
        this.mTelephonyManager = this.mInjector.getTelephonyManager();
        this.mNetworkStatsSupplier = this.mInjector.getMobileNetworkStatsSupplier();
        this.mCallDurationSupplier = this.mInjector.getCallDurationSupplier();
        this.mScanDurationSupplier = this.mInjector.getPhoneSignalScanDurationSupplier();
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), 5);
        this.mLayout = new MobileRadioPowerStatsLayout(this.mConsumedEnergyHelper.getEnergyConsumerCount());
        SparseArray<String> stateLabels = new SparseArray();
        int rat = 0;
    L11:
        if (rat >= 3) goto L32;
        if (rat != 2) goto L15;
        int freqCount = 5;
    L16:
        int freq = 0;
    L17:
        if (freq >= freqCount) goto L31;
        int stateKey = MobileRadioPowerStatsLayout.makeStateKey(rat, freq);
        StringBuilder sb = new StringBuilder();
        if (rat == 0) goto L21;
        sb.append(BatteryStats.RADIO_ACCESS_TECHNOLOGY_NAMES[rat]);
    L21:
        if (freq == 0) goto L27;
        if (sb.isEmpty() == true) goto L25;
        sb.append(" ");
    L25:
        sb.append(ServiceState.frequencyRangeToString(freq));
    L27:
        if (sb.isEmpty() == true) goto L29;
        String r8 = sb.toString();
    L30:
        stateLabels.put(stateKey, r8);
        freq = freq + 1;
        goto L17
    L29:
        r8 = "other";
        goto L30
    L31:
        rat = rat + 1;
        goto L11
    L15:
        freqCount = 1;
        goto L16
    L32:
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        PowerStats.Descriptor powerStatsDescriptor = new PowerStats.Descriptor(8, this.mLayout.getDeviceStatsArrayLength(), stateLabels, this.mLayout.getStateStatsArrayLength(), this.mLayout.getUidStatsArrayLength(), extras);
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
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        ModemActivityInfo modemActivityDelta = collectModemActivityInfo();
        NetworkStats networkStatsDeltas = collectNetworkStats();
        this.mConsumedEnergyHelper.collectConsumedEnergy(this.mPowerStats, this.mLayout);
        if (this.mPowerStats.durationMs != 0) goto L10;
        setTimestamp(this.mClock.elapsedRealtime());
    L10:
        if (this.mObserver == null) goto L13;
        this.mObserver.onMobileRadioPowerStatsRetrieved(modemActivityDelta, networkStatsDeltas, this.mClock.elapsedRealtime(), this.mClock.uptimeMillis());
    L13:
        return this.mPowerStats;
    }

    private ModemActivityInfo collectModemActivityInfo() {
        if (this.mTelephonyManager != null) goto L5;
        return null;
    L5:
        final CompletableFuture<ModemActivityInfo> immediateFuture = new CompletableFuture();
        this.mTelephonyManager.requestModemActivityInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass1(this, immediateFuture));
        ModemActivityInfo activityInfo = immediateFuture.get(MODEM_ACTIVITY_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
    L10:
        if (activityInfo != null) goto L13;
        return null;
    L13:
        if (this.mLastModemActivityInfo != null) goto L15;
        ModemActivityInfo deltaInfo = activityInfo.getDelta(activityInfo);
    L16:
        this.mLastModemActivityInfo = activityInfo;
        setTimestamp(deltaInfo.getTimestampMillis());
        this.mLayout.setDeviceSleepTime(this.mDeviceStats, deltaInfo.getSleepTimeMillis());
        this.mLayout.setDeviceIdleTime(this.mDeviceStats, deltaInfo.getIdleTimeMillis());
        long callDuration = this.mCallDurationSupplier.getAsLong();
        if (callDuration < this.mLastCallDuration) goto L19;
        this.mLayout.setDeviceCallTime(this.mDeviceStats, callDuration - this.mLastCallDuration);
    L19:
        this.mLastCallDuration = callDuration;
        long scanDuration = this.mScanDurationSupplier.getAsLong();
        if (scanDuration < this.mLastScanDuration) goto L22;
        this.mLayout.setDeviceScanTime(this.mDeviceStats, scanDuration - this.mLastScanDuration);
    L22:
        this.mLastScanDuration = scanDuration;
        SparseArray<long[]> stateStats = this.mPowerStats.stateStats;
        stateStats.clear();
        if (deltaInfo.getSpecificInfoLength() != 0) goto L25;
        this.mLayout.addRxTxTimesForRat(stateStats, 0, 0, deltaInfo.getReceiveTimeMillis(), deltaInfo.getTransmitTimeMillis());
    L37:
        return deltaInfo;
    L25:
        int rat = 0;
    L27:
        if (rat >= NETWORK_TYPES.length) goto L37;
        if (rat != 6) goto L35;
        int freq = 0;
    L32:
        if (freq >= 5) goto L36;
        this.mLayout.addRxTxTimesForRat(stateStats, rat, freq, deltaInfo.getReceiveTimeMillis(rat, freq), deltaInfo.getTransmitTimeMillis(rat, freq));
        freq = freq + 1;
    L36:
        rat = rat + 1;
        goto L27
    L35:
        this.mLayout.addRxTxTimesForRat(stateStats, rat, 0, deltaInfo.getReceiveTimeMillis(rat), deltaInfo.getTransmitTimeMillis(rat));
        goto L36
    L15:
        deltaInfo = this.mLastModemActivityInfo.getDelta(activityInfo);
    L9:
        Slog.e(TAG, "Cannot acquire ModemActivityInfo");
        activityInfo = null;
        goto L10
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

    private void setTimestamp(long timestamp) {
        PowerStats r0 = this.mPowerStats;
        r0.durationMs = Math.max(timestamp - this.mLastUpdateTimestampMillis, 0);
        this.mLastUpdateTimestampMillis = timestamp;
    }
}
