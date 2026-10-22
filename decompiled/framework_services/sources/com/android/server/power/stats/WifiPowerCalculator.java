package com.android.server.power.stats;

import android.os.BatteryConsumer;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class WifiPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "WifiPowerCalculator";
    private static final BatteryConsumer.Key[] UNINITIALIZED_KEYS = null;
    private final UsageBasedPowerEstimator mBatchScanPowerEstimator;
    private final boolean mHasWifiPowerController;
    private final UsageBasedPowerEstimator mIdlePowerEstimator;
    private final UsageBasedPowerEstimator mPowerOnPowerEstimator;
    private final UsageBasedPowerEstimator mRxPowerEstimator;
    private final UsageBasedPowerEstimator mScanPowerEstimator;
    private final UsageBasedPowerEstimator mTxPowerEstimator;
    private final double mWifiPowerPerPacket;

    private static class PowerDurationAndTraffic {
        public long durationMs;
        public BatteryConsumer.Key[] keys;
        public double powerMah;
        public double[] powerPerKeyMah;
        public long wifiRxBytes;
        public long wifiRxPackets;
        public long wifiTxBytes;
        public long wifiTxPackets;

        /* synthetic */ PowerDurationAndTraffic(WifiPowerCalculatorIA r1) {
            this();
        }

        private PowerDurationAndTraffic() {
        }
    }

    static {
        UNINITIALIZED_KEYS = new BatteryConsumer.Key[0];
    }

    public WifiPowerCalculator(PowerProfile profile) {
        this.mPowerOnPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.on"));
        this.mScanPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.scan"));
        this.mBatchScanPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.batchedscan"));
        this.mIdlePowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.controller.idle"));
        this.mTxPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.controller.tx"));
        this.mRxPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("wifi.controller.rx"));
        this.mWifiPowerPerPacket = getWifiPowerPerPacket(profile);
        if (this.mIdlePowerEstimator.isSupported() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        this.mHasWifiPowerController = r0;
        return;
    L5:
        if (this.mTxPowerEstimator.isSupported() == false) goto L9;
        if (this.mRxPowerEstimator.isSupported() == false) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 11) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        BatteryConsumer.Key[] keys = UNINITIALIZED_KEYS;
        long totalAppDurationMs = 0;
        PowerDurationAndTraffic powerDurationAndTraffic = new PowerDurationAndTraffic(null);
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
        double totalAppPowerMah = 0.0d;
    L4:
        if (i < 0) goto L29;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        if (keys == UNINITIALIZED_KEYS) goto L8;
    L11:
        long consumptionUC = app.getBatteryStatsUid().getWifiEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC, query);
        calculateApp(powerDurationAndTraffic, app.getBatteryStatsUid(), powerModel, rawRealtimeUs, 0, batteryStats.hasWifiActivityReporting(), consumptionUC);
        if (app.isVirtualUid() == true) goto L15;
        totalAppDurationMs = totalAppDurationMs + powerDurationAndTraffic.durationMs;
        totalAppPowerMah = totalAppPowerMah + powerDurationAndTraffic.powerMah;
    L15:
        app.setUsageDurationMillis(11, powerDurationAndTraffic.durationMs);
        app.setConsumedPower(11, powerDurationAndTraffic.powerMah, powerModel);
        if (query.isProcessStateDataNeeded() == false) goto L28;
        if (keys == null) goto L28;
        int j = 0;
    L20:
        if (j >= keys.length) goto L28;
        BatteryConsumer.Key key = keys[j];
        int processState = key.processState;
        if (processState == 0) goto L25;
        app.setConsumedPower(key, powerDurationAndTraffic.powerPerKeyMah[j], powerModel);
    L25:
        j = j + 1;
        keys = keys;
        totalAppDurationMs = totalAppDurationMs;
    L28:
        i = i - 1;
        keys = keys;
        totalAppDurationMs = totalAppDurationMs;
        goto L4
    L8:
        if (query.isProcessStateDataNeeded() == false) goto L10;
        keys = app.getKeys(11);
        powerDurationAndTraffic.keys = keys;
        powerDurationAndTraffic.powerPerKeyMah = new double[keys.length];
        goto L11
    L10:
        keys = null;
        goto L11
    L29:
        long consumptionUC2 = batteryStats.getWifiEnergyConsumptionUC();
        int powerModel2 = PowerCalculator.getPowerModel(consumptionUC2, query);
        calculateRemaining(powerDurationAndTraffic, powerModel2, batteryStats, rawRealtimeUs, 0, batteryStats.hasWifiActivityReporting(), totalAppDurationMs, totalAppPowerMah, consumptionUC2);
        double totalAppPowerMah2 = totalAppPowerMah;
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(11, powerDurationAndTraffic.durationMs).setConsumedPower(11, powerDurationAndTraffic.powerMah + totalAppPowerMah2, powerModel2);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(11, totalAppPowerMah2, powerModel2);
    }

    private void calculateApp(PowerDurationAndTraffic powerDurationAndTraffic, BatteryStats.Uid u, int powerModel, long rawRealtimeUs, int statsType, boolean hasWifiActivityReporting, long consumptionUC) {
        powerDurationAndTraffic.wifiRxPackets = u.getNetworkActivityPackets(2, statsType);
        powerDurationAndTraffic.wifiTxPackets = u.getNetworkActivityPackets(3, statsType);
        powerDurationAndTraffic.wifiRxBytes = u.getNetworkActivityBytes(2, statsType);
        powerDurationAndTraffic.wifiTxBytes = u.getNetworkActivityBytes(3, statsType);
        if (hasWifiActivityReporting == true) goto L5;
    L30:
        long wifiRunningTime = u.getWifiRunningTime(rawRealtimeUs, statsType) / 1000;
        powerDurationAndTraffic.durationMs = wifiRunningTime;
        if (powerModel != 1) goto L37;
        long wifiScanTimeMs = u.getWifiScanTime(rawRealtimeUs, statsType) / 1000;
        int bin = 0;
        long batchTimeMs = 0;
    L34:
        if (bin >= 5) goto L36;
        batchTimeMs = batchTimeMs + (u.getWifiBatchedScanTime(bin, rawRealtimeUs, statsType) / 1000);
        bin = bin + 1;
        goto L34
    L36:
        powerDurationAndTraffic.powerMah = calcPowerWithoutControllerDataMah(powerDurationAndTraffic.wifiRxPackets, powerDurationAndTraffic.wifiTxPackets, wifiRunningTime, wifiScanTimeMs, batchTimeMs);
    L39:
        if (powerDurationAndTraffic.powerPerKeyMah == null) goto L48;
        Arrays.fill(powerDurationAndTraffic.powerPerKeyMah, 0.0d);
        return;
    L48:
        return;
    L37:
        powerDurationAndTraffic.powerMah = PowerCalculator.uCtoMah(consumptionUC);
        goto L39
    L5:
        if (this.mHasWifiPowerController == false) goto L30;
        BatteryStats.ControllerActivityCounter counter = u.getWifiControllerActivity();
        if (counter == null) goto L26;
        BatteryStats.LongCounter rxTimeCounter = counter.getRxTimeCounter();
        BatteryStats.LongCounter txTimeCounter = counter.getTxTimeCounters()[0];
        BatteryStats.LongCounter idleTimeCounter = counter.getIdleTimeCounter();
        long rxTime = rxTimeCounter.getCountLocked(statsType);
        long txTime = txTimeCounter.getCountLocked(statsType);
        long idleTime = idleTimeCounter.getCountLocked(statsType);
        powerDurationAndTraffic.durationMs = (idleTime + rxTime) + txTime;
        if (powerModel != 1) goto L11;
        powerDurationAndTraffic.powerMah = calcPowerFromControllerDataMah(rxTime, txTime, idleTime);
    L13:
        if (powerDurationAndTraffic.keys == null) goto L47;
        int i = 0;
    L16:
        if (i >= powerDurationAndTraffic.keys.length) goto L47;
        int processState = powerDurationAndTraffic.keys[i].processState;
        if (processState == 0) goto L24;
        if (powerModel != 1) goto L23;
        powerDurationAndTraffic.powerPerKeyMah[i] = calcPowerFromControllerDataMah(rxTimeCounter.getCountForProcessState(processState), txTimeCounter.getCountForProcessState(processState), idleTimeCounter.getCountForProcessState(processState));
        goto L24
    L23:
        powerDurationAndTraffic.powerPerKeyMah[i] = PowerCalculator.uCtoMah(u.getWifiEnergyConsumptionUC(processState));
    L24:
        i = i + 1;
    L47:
        return;
    L11:
        powerDurationAndTraffic.powerMah = PowerCalculator.uCtoMah(consumptionUC);
        goto L13
    L26:
        powerDurationAndTraffic.durationMs = 0;
        powerDurationAndTraffic.powerMah = 0.0d;
        if (powerDurationAndTraffic.powerPerKeyMah == null) goto L47;
        Arrays.fill(powerDurationAndTraffic.powerPerKeyMah, 0.0d);
        goto L47
    }

    private void calculateRemaining(PowerDurationAndTraffic powerDurationAndTraffic, int powerModel, BatteryStats stats, long rawRealtimeUs, int statsType, boolean hasWifiActivityReporting, long totalAppDurationMs, double totalAppPowerMah, long consumptionUC) {
        double totalPowerMah = 0.0d;
        if (powerModel != 2) goto L6;
        totalPowerMah = PowerCalculator.uCtoMah(consumptionUC);
    L6:
        if (hasWifiActivityReporting == true) goto L8;
    L17:
        long totalDurationMs = stats.getGlobalWifiRunningTime(rawRealtimeUs, statsType) / 1000;
        if (powerModel != 1) goto L20;
        totalPowerMah = calcGlobalPowerWithoutControllerDataMah(totalDurationMs);
        long totalDurationMs2 = totalDurationMs;
    L21:
        powerDurationAndTraffic.durationMs = Math.max(0, totalDurationMs2 - totalAppDurationMs);
        powerDurationAndTraffic.powerMah = Math.max(0.0d, totalPowerMah - totalAppPowerMah);
        return;
    L20:
        totalDurationMs2 = totalDurationMs;
        goto L21
    L8:
        if (this.mHasWifiPowerController == false) goto L17;
        BatteryStats.ControllerActivityCounter counter = stats.getWifiControllerActivity();
        long idleTimeMs = counter.getIdleTimeCounter().getCountLocked(statsType);
        long txTimeMs = counter.getTxTimeCounters()[0].getCountLocked(statsType);
        long rxTimeMs = counter.getRxTimeCounter().getCountLocked(statsType);
        totalDurationMs2 = (idleTimeMs + rxTimeMs) + txTimeMs;
        if (powerModel != 1) goto L21;
        double totalPowerMah2 = counter.getPowerCounter().getCountLocked(statsType) / 3600000.0d;
        if (totalPowerMah2 != 0.0d) goto L14;
        totalPowerMah = calcPowerFromControllerDataMah(rxTimeMs, txTimeMs, idleTimeMs);
        goto L21
    L14:
        totalPowerMah = totalPowerMah2;
        goto L21
    }

    public double calcPowerFromControllerDataMah(long rxTimeMs, long txTimeMs, long idleTimeMs) {
        return (this.mRxPowerEstimator.calculatePower(rxTimeMs) + this.mTxPowerEstimator.calculatePower(txTimeMs)) + this.mIdlePowerEstimator.calculatePower(idleTimeMs);
    }

    public double calcPowerWithoutControllerDataMah(long rxPackets, long txPackets, long wifiRunningTimeMs, long wifiScanTimeMs, long wifiBatchScanTimeMs) {
        return ((((rxPackets + txPackets) * this.mWifiPowerPerPacket) + this.mPowerOnPowerEstimator.calculatePower(wifiRunningTimeMs)) + this.mScanPowerEstimator.calculatePower(wifiScanTimeMs)) + this.mBatchScanPowerEstimator.calculatePower(wifiBatchScanTimeMs);
    }

    public double calcGlobalPowerWithoutControllerDataMah(long globalWifiRunningTimeMs) {
        return this.mPowerOnPowerEstimator.calculatePower(globalWifiRunningTimeMs);
    }

    private static double getWifiPowerPerPacket(PowerProfile profile) {
        double averageWifiActivePower = profile.getAveragePower("wifi.active") / 3600.0d;
        return averageWifiActivePower / 61.03515625d;
    }
}
