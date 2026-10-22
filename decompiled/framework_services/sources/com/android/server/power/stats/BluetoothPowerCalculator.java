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
public class BluetoothPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "BluetoothPowerCalc";
    private static final BatteryConsumer.Key[] UNINITIALIZED_KEYS = null;
    private final boolean mHasBluetoothPowerController;
    private final double mIdleMa;
    private final double mRxMa;
    private final double mTxMa;

    private static class PowerAndDuration {
        public long durationMs;
        public BatteryConsumer.Key[] keys;
        public double powerMah;
        public double[] powerPerKeyMah;
        public long totalDurationMs;
        public double totalPowerMah;

        /* synthetic */ PowerAndDuration(BluetoothPowerCalculatorIA r1) {
            this();
        }

        private PowerAndDuration() {
        }
    }

    static {
        UNINITIALIZED_KEYS = new BatteryConsumer.Key[0];
    }

    public BluetoothPowerCalculator(PowerProfile profile) {
        this.mIdleMa = profile.getAveragePower("bluetooth.controller.idle");
        this.mRxMa = profile.getAveragePower("bluetooth.controller.rx");
        this.mTxMa = profile.getAveragePower("bluetooth.controller.tx");
        if (this.mIdleMa != 0.0d) goto L5;
    L9:
        boolean r0 = false;
    L10:
        this.mHasBluetoothPowerController = r0;
        return;
    L5:
        if (this.mRxMa == 0.0d) goto L9;
        if (this.mTxMa == 0.0d) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        if (batteryStats.hasBluetoothActivityReporting() == true) goto L5;
        return;
    L5:
        BatteryConsumer.Key[] keys = UNINITIALIZED_KEYS;
        PowerAndDuration powerAndDuration = new PowerAndDuration(null);
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L7:
        if (i < 0) goto L15;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        if (keys != UNINITIALIZED_KEYS) goto L14;
        if (query.isProcessStateDataNeeded() == false) goto L13;
        keys = app.getKeys(2);
        powerAndDuration.keys = keys;
        powerAndDuration.powerPerKeyMah = new double[keys.length];
        goto L14
    L13:
        keys = null;
    L14:
        calculateApp(app, powerAndDuration, query);
        i = i - 1;
        goto L7
    L15:
        long consumedEnergyUC = batteryStats.getBluetoothEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumedEnergyUC, query);
        BatteryStats.ControllerActivityCounter activityCounter = batteryStats.getBluetoothControllerActivity();
        calculatePowerAndDuration(null, powerModel, consumedEnergyUC, activityCounter, query.shouldForceUsePowerProfileModel(), powerAndDuration);
        Math.max(0, powerAndDuration.durationMs - powerAndDuration.totalDurationMs);
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(2, powerAndDuration.durationMs).setConsumedPower(2, Math.max(powerAndDuration.powerMah, powerAndDuration.totalPowerMah), powerModel);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(2, powerAndDuration.totalDurationMs).setConsumedPower(2, powerAndDuration.totalPowerMah, powerModel);
    }

    private void calculateApp(UidBatteryConsumer.Builder app, PowerAndDuration powerAndDuration, BatteryUsageStatsQuery query) {
        long consumedEnergyUC = app.getBatteryStatsUid().getBluetoothEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumedEnergyUC, query);
        BatteryStats.ControllerActivityCounter activityCounter = app.getBatteryStatsUid().getBluetoothControllerActivity();
        calculatePowerAndDuration(app.getBatteryStatsUid(), powerModel, consumedEnergyUC, activityCounter, query.shouldForceUsePowerProfileModel(), powerAndDuration);
        app.setUsageDurationMillis(2, powerAndDuration.durationMs).setConsumedPower(2, powerAndDuration.powerMah, powerModel);
        if (app.isVirtualUid() == true) goto L6;
        powerAndDuration.totalDurationMs += powerAndDuration.durationMs;
        powerAndDuration.totalPowerMah += powerAndDuration.powerMah;
    L6:
        if (query.isProcessStateDataNeeded() == true) goto L8;
        return;
    L8:
        if (powerAndDuration.keys == null) goto L21;
        int j = 0;
    L11:
        if (j >= powerAndDuration.keys.length) goto L22;
        BatteryConsumer.Key key = powerAndDuration.keys[j];
        int processState = key.processState;
        if (processState == 0) goto L16;
        app.setConsumedPower(key, powerAndDuration.powerPerKeyMah[j], powerModel);
    L16:
        j = j + 1;
        goto L11
    L22:
        return;
    }

    private void calculatePowerAndDuration(BatteryStats.Uid uid, int powerModel, long consumedEnergyUC, BatteryStats.ControllerActivityCounter counter, boolean ignoreReportedPower, PowerAndDuration powerAndDuration) {
        if (counter != null) goto L8;
        powerAndDuration.durationMs = 0;
        powerAndDuration.powerMah = 0.0d;
        if (powerAndDuration.powerPerKeyMah == null) goto L55;
        Arrays.fill(powerAndDuration.powerPerKeyMah, 0.0d);
        return;
    L55:
        return;
    L8:
        BatteryStats.LongCounter idleTimeCounter = counter.getIdleTimeCounter();
        BatteryStats.LongCounter rxTimeCounter = counter.getRxTimeCounter();
        BatteryStats.LongCounter txTimeCounter = counter.getTxTimeCounters()[0];
        long idleTimeMs = idleTimeCounter.getCountLocked(0);
        long rxTimeMs = rxTimeCounter.getCountLocked(0);
        long txTimeMs = txTimeCounter.getCountLocked(0);
        powerAndDuration.durationMs = (idleTimeMs + rxTimeMs) + txTimeMs;
        if (powerModel != 2) goto L23;
        powerAndDuration.powerMah = PowerCalculator.uCtoMah(consumedEnergyUC);
        if (uid != null) goto L13;
        return;
    L13:
        if (powerAndDuration.keys == null) goto L58;
        int i = 0;
    L16:
        if (i >= powerAndDuration.keys.length) goto L61;
        BatteryConsumer.Key key = powerAndDuration.keys[i];
        int processState = key.processState;
        if (processState == 0) goto L21;
        powerAndDuration.powerPerKeyMah[i] = PowerCalculator.uCtoMah(uid.getBluetoothEnergyConsumptionUC(processState));
    L21:
        i = i + 1;
        goto L16
    L61:
        return;
    L58:
        return;
    L23:
        if (ignoreReportedPower == true) goto L33;
        double powerMah = counter.getPowerCounter().getCountLocked(0) / 3600000.0d;
        if (powerMah == 0.0d) goto L33;
        powerAndDuration.powerMah = powerMah;
        if (powerAndDuration.powerPerKeyMah == null) goto L30;
        Arrays.fill(powerAndDuration.powerPerKeyMah, 0.0d);
        return;
    L30:
        return;
    L33:
        if (this.mHasBluetoothPowerController == false) goto L45;
        powerAndDuration.powerMah = calculatePowerMah(rxTimeMs, txTimeMs, idleTimeMs);
        if (powerAndDuration.keys == null) goto L59;
        int i2 = 0;
    L38:
        if (i2 >= powerAndDuration.keys.length) goto L62;
        BatteryConsumer.Key key2 = powerAndDuration.keys[i2];
        int processState2 = key2.processState;
        if (processState2 == 0) goto L43;
        powerAndDuration.powerPerKeyMah[i2] = calculatePowerMah(rxTimeCounter.getCountForProcessState(processState2), txTimeCounter.getCountForProcessState(processState2), idleTimeCounter.getCountForProcessState(processState2));
    L43:
        i2 = i2 + 1;
        goto L38
    L62:
        return;
    L59:
        return;
    L45:
        powerAndDuration.powerMah = 0.0d;
        if (powerAndDuration.powerPerKeyMah == null) goto L60;
        Arrays.fill(powerAndDuration.powerPerKeyMah, 0.0d);
        return;
    }

    public double calculatePowerMah(long rxTimeMs, long txTimeMs, long idleTimeMs) {
        return (((idleTimeMs * this.mIdleMa) + (rxTimeMs * this.mRxMa)) + (txTimeMs * this.mTxMa)) / 3600000.0d;
    }
}
