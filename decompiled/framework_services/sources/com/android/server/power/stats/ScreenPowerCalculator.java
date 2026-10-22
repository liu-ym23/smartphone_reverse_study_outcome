package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    public static final long MIN_ACTIVE_TIME_FOR_SMEARING = 600000;
    private static final String TAG = "ScreenPowerCalculator";
    private final UsageBasedPowerEstimator[] mScreenFullPowerEstimators;
    private final UsageBasedPowerEstimator[] mScreenOnPowerEstimators;

    private static class PowerAndDuration {
        public long durationMs;
        public double powerMah;

        /* synthetic */ PowerAndDuration(ScreenPowerCalculatorIA r1) {
            this();
        }

        private PowerAndDuration() {
        }
    }

    public ScreenPowerCalculator(PowerProfile powerProfile) {
        int numDisplays = powerProfile.getNumDisplays();
        this.mScreenOnPowerEstimators = new UsageBasedPowerEstimator[numDisplays];
        this.mScreenFullPowerEstimators = new UsageBasedPowerEstimator[numDisplays];
        int display = 0;
    L3:
        if (display >= numDisplays) goto L6;
        this.mScreenOnPowerEstimators[display] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForOrdinal("screen.on.display", display));
        this.mScreenFullPowerEstimators[display] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForOrdinal("screen.full.display", display));
        display = display + 1;
        goto L3
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        ScreenPowerCalculatorIA r10 = null;
        PowerAndDuration totalPowerAndDuration = new PowerAndDuration(r10);
        long consumptionUC = batteryStats.getScreenOnEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC, query);
        ScreenPowerCalculator r0 = this;
        long r4 = rawRealtimeUs;
        r0.calculateTotalDurationAndPower(totalPowerAndDuration, powerModel, batteryStats, r4, 0, consumptionUC);
        double totalAppPower = 0.0d;
        long totalAppDuration = 0;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        switch(powerModel) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        r0.smearScreenBatteryDrain(uidBatteryConsumerBuilders, totalPowerAndDuration, r4);
        totalAppPower = totalPowerAndDuration.powerMah;
        totalAppDuration = totalPowerAndDuration.durationMs;
    L12:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(0, Math.max(totalPowerAndDuration.powerMah, totalAppPower), powerModel).setUsageDurationMillis(0, totalPowerAndDuration.durationMs);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(0, totalAppPower, powerModel).setUsageDurationMillis(0, totalAppDuration);
        return;
    L5:
        PowerAndDuration appPowerAndDuration = new PowerAndDuration(r10);
        int i = uidBatteryConsumerBuilders.size() - 1;
    L6:
        if (i < 0) goto L12;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders2 = uidBatteryConsumerBuilders;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        long consumptionUC2 = consumptionUC;
        r0.calculateAppUsingEnergyConsumption(appPowerAndDuration, app.getBatteryStatsUid(), r4);
        app.setUsageDurationMillis(0, appPowerAndDuration.durationMs).setConsumedPower(0, appPowerAndDuration.powerMah, powerModel);
        if (app.isVirtualUid() == true) goto L10;
        totalAppPower = totalAppPower + appPowerAndDuration.powerMah;
        totalAppDuration = totalAppDuration + appPowerAndDuration.durationMs;
    L10:
        i = i - 1;
        r0 = this;
        r4 = rawRealtimeUs;
        uidBatteryConsumerBuilders = uidBatteryConsumerBuilders2;
        consumptionUC = consumptionUC2;
        goto L6
    }

    private void calculateTotalDurationAndPower(PowerAndDuration totalPowerAndDuration, int powerModel, BatteryStats batteryStats, long rawRealtimeUs, int statsType, long consumptionUC) {
        totalPowerAndDuration.durationMs = calculateDuration(batteryStats, rawRealtimeUs, statsType);
        switch(powerModel) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        totalPowerAndDuration.powerMah = calculateTotalPowerFromBrightness(batteryStats, rawRealtimeUs);
        return;
    L5:
        totalPowerAndDuration.powerMah = PowerCalculator.uCtoMah(consumptionUC);
    }

    private void calculateAppUsingEnergyConsumption(PowerAndDuration appPowerAndDuration, BatteryStats.Uid u, long rawRealtimeUs) {
        appPowerAndDuration.durationMs = getProcessForegroundTimeMs(u, rawRealtimeUs);
        long chargeUC = u.getScreenOnEnergyConsumptionUC();
        if (chargeUC >= 0) goto L6;
        Slog.wtf(TAG, "Screen energy not supported, so calculateApp shouldn't de called");
        appPowerAndDuration.powerMah = 0.0d;
        return;
    L6:
        appPowerAndDuration.powerMah = PowerCalculator.uCtoMah(chargeUC);
    }

    private long calculateDuration(BatteryStats batteryStats, long rawRealtimeUs, int statsType) {
        return batteryStats.getScreenOnTime(rawRealtimeUs, statsType) / 1000;
    }

    private double calculateTotalPowerFromBrightness(BatteryStats batteryStats, long rawRealtimeUs) {
        int numDisplays = this.mScreenOnPowerEstimators.length;
        double power = 0.0d;
        int display = 0;
    L3:
        if (display >= numDisplays) goto L10;
        long r10 = 1000;
        long displayTime = batteryStats.getDisplayScreenOnTime(display, rawRealtimeUs) / 1000;
        power = power + this.mScreenOnPowerEstimators[display].calculatePower(displayTime);
        int bin = 0;
    L6:
        if (bin >= 5) goto L8;
        long brightnessTime = batteryStats.getDisplayScreenBrightnessTime(display, bin, rawRealtimeUs) / r10;
        double binPowerMah = (this.mScreenFullPowerEstimators[display].calculatePower(brightnessTime) * ((double) (bin + 0.5f))) / 5.0d;
        power = power + binPowerMah;
        bin = bin + 1;
        r10 = 1000;
        goto L6
    L8:
        display = display + 1;
        goto L3
    L10:
        return power;
    }

    private void smearScreenBatteryDrain(SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders, PowerAndDuration totalPowerAndDuration, long rawRealtimeUs) {
        long totalActivityTimeMs = 0;
        SparseLongArray activityTimeArray = new SparseLongArray();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L9;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        BatteryStats.Uid uid = app.getBatteryStatsUid();
        long timeMs = getProcessForegroundTimeMs(uid, rawRealtimeUs);
        activityTimeArray.put(uid.getUid(), timeMs);
        if (app.isVirtualUid() == true) goto L7;
        totalActivityTimeMs = totalActivityTimeMs + timeMs;
    L7:
        i = i - 1;
        goto L3
    L9:
        if (totalActivityTimeMs < 600000) goto L15;
        double totalScreenPowerMah = totalPowerAndDuration.powerMah;
        int i2 = uidBatteryConsumerBuilders.size() - 1;
    L11:
        if (i2 < 0) goto L20;
        UidBatteryConsumer.Builder app2 = uidBatteryConsumerBuilders.valueAt(i2);
        long durationMs = activityTimeArray.get(app2.getUid(), 0);
        double totalScreenPowerMah2 = totalScreenPowerMah;
        double powerMah = (totalScreenPowerMah2 * durationMs) / totalActivityTimeMs;
        app2.setUsageDurationMillis(0, durationMs).setConsumedPower(0, powerMah, 1);
        i2 = i2 - 1;
        activityTimeArray = activityTimeArray;
        totalScreenPowerMah = totalScreenPowerMah2;
        goto L11
    L20:
        return;
    }

    public long getProcessForegroundTimeMs(BatteryStats.Uid uid, long rawRealTimeUs) {
        int[] foregroundTypes = {0};
        long timeUs = 0;
        int r4 = foregroundTypes.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L6;
        int type = foregroundTypes[r5];
        long localTime = uid.getProcessStateTime(type, rawRealTimeUs, 0);
        timeUs = timeUs + localTime;
        r5 = r5 + 1;
        goto L3
    L6:
        return Math.min(timeUs, getForegroundActivityTotalTimeUs(uid, rawRealTimeUs)) / 1000;
    }

    public long getForegroundActivityTotalTimeUs(BatteryStats.Uid uid, long rawRealtimeUs) {
        BatteryStats.Timer timer = uid.getForegroundActivityTimer();
        if (timer != null) goto L7;
        return 0;
    L7:
        return timer.getTotalTimeLocked(rawRealtimeUs, 0);
    }
}
