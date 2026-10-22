package com.android.server.power.stats;

import android.os.BatteryConsumer;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.telephony.CellSignalStrength;
import android.util.Log;
import android.util.LongArrayQueue;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;
import com.android.internal.power.ModemPowerProfile;
import java.util.ArrayList;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes3.dex */
public class MobileRadioPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final int IGNORE = -1;
    private static final double MILLIS_IN_HOUR = 3600000.0d;
    private static final int NUM_SIGNAL_STRENGTH_LEVELS = 0;
    private static final String TAG = "MobRadioPowerCalculator";
    private static final BatteryConsumer.Key[] UNINITIALIZED_KEYS = null;
    private final UsageBasedPowerEstimator mActivePowerEstimator;
    private final UsageBasedPowerEstimator mIdlePowerEstimator;
    private final UsageBasedPowerEstimator[] mIdlePowerEstimators;
    private final PowerProfile mPowerProfile;
    private final UsageBasedPowerEstimator mScanPowerEstimator;
    private final UsageBasedPowerEstimator mSleepPowerEstimator;

    private static class PowerAndDuration {
        public long remainingDurationMs;
        public double remainingPowerMah;
        public long totalAppDurationMs;
        public double totalAppPowerMah;

        /* synthetic */ PowerAndDuration(MobileRadioPowerCalculatorIA r1) {
            this();
        }

        private PowerAndDuration() {
        }
    }

    static {
        NUM_SIGNAL_STRENGTH_LEVELS = CellSignalStrength.getNumSignalStrengthLevels();
        UNINITIALIZED_KEYS = new BatteryConsumer.Key[0];
    }

    public MobileRadioPowerCalculator(PowerProfile profile) {
        this.mIdlePowerEstimators = new UsageBasedPowerEstimator[NUM_SIGNAL_STRENGTH_LEVELS];
        this.mPowerProfile = profile;
        double sleepDrainRateMa = this.mPowerProfile.getAverageBatteryDrainOrDefaultMa(4294967296L, Double.NaN);
        if (Double.isNaN(sleepDrainRateMa) == false) goto L5;
        this.mSleepPowerEstimator = null;
    L6:
        double idleDrainRateMa = this.mPowerProfile.getAverageBatteryDrainOrDefaultMa(4563402752L, Double.NaN);
        if (Double.isNaN(idleDrainRateMa) == false) goto L9;
        this.mIdlePowerEstimator = null;
    L10:
        double powerRadioActiveMa = profile.getAveragePowerOrDefault("radio.active", Double.NaN);
        if (Double.isNaN(powerRadioActiveMa) == false) goto L17;
        double sum = 0.0d + profile.getAveragePower("modem.controller.rx");
        int i = 0;
    L14:
        if (i >= NUM_SIGNAL_STRENGTH_LEVELS) goto L16;
        sum = sum + profile.getAveragePower("modem.controller.tx", i);
        i = i + 1;
        goto L14
    L16:
        int i2 = NUM_SIGNAL_STRENGTH_LEVELS;
        powerRadioActiveMa = sum / ((double) (i2 + 1));
    L17:
        this.mActivePowerEstimator = new UsageBasedPowerEstimator(powerRadioActiveMa);
        if (Double.isNaN(profile.getAveragePowerOrDefault("radio.on", Double.NaN)) == true) goto L24;
        int i3 = 0;
    L21:
        if (i3 >= NUM_SIGNAL_STRENGTH_LEVELS) goto L29;
        this.mIdlePowerEstimators[i3] = new UsageBasedPowerEstimator(profile.getAveragePower("radio.on", i3));
        i3 = i3 + 1;
    L29:
        this.mScanPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePowerOrDefault("radio.scanning", 0.0d));
        return;
    L24:
        double idle = profile.getAveragePower("modem.controller.idle");
        this.mIdlePowerEstimators[0] = new UsageBasedPowerEstimator((25.0d * idle) / 180.0d);
        int i4 = 1;
    L26:
        if (i4 >= NUM_SIGNAL_STRENGTH_LEVELS) goto L29;
        double sleepDrainRateMa2 = sleepDrainRateMa;
        this.mIdlePowerEstimators[i4] = new UsageBasedPowerEstimator(Math.max(1.0d, idle / 256.0d));
        i4 = i4 + 1;
        sleepDrainRateMa = sleepDrainRateMa2;
        goto L26
    L9:
        this.mIdlePowerEstimator = new UsageBasedPowerEstimator(idleDrainRateMa);
        goto L10
    L5:
        this.mSleepPowerEstimator = new UsageBasedPowerEstimator(sleepDrainRateMa);
        goto L6
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        MobileRadioPowerCalculator r0 = this;
        PowerAndDuration total = new PowerAndDuration(null);
        long totalConsumptionUC = batteryStats.getMobileRadioEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(totalConsumptionUC, query);
        if (powerModel != 2) goto L5;
        double totalActivePowerMah = Double.NaN;
        ArrayList<UidBatteryConsumer.Builder> apps = null;
        LongArrayQueue appDurationsMs = null;
    L6:
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        BatteryConsumer.Key[] keys = UNINITIALIZED_KEYS;
        BatteryConsumer.Key[] keys2 = keys;
        int i = uidBatteryConsumerBuilders.size() - 1;
    L7:
        if (i < 0) goto L40;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        int i2 = i;
        BatteryStats.Uid uid = app.getBatteryStatsUid();
        if (keys2 == UNINITIALIZED_KEYS) goto L11;
    L14:
        double totalActivePowerMah2 = totalActivePowerMah;
        long radioActiveDurationMs = r0.calculateDuration(uid, 0);
        if (app.isVirtualUid() == true) goto L17;
        total.totalAppDurationMs += radioActiveDurationMs;
    L17:
        app.setUsageDurationMillis(8, radioActiveDurationMs);
        if (powerModel != 2) goto L38;
        long appConsumptionUC = uid.getMobileRadioEnergyConsumptionUC();
        if (appConsumptionUC == (-1)) goto L39;
        double appConsumptionMah = PowerCalculator.uCtoMah(appConsumptionUC);
        if (app.isVirtualUid() == true) goto L24;
        total.totalAppPowerMah += appConsumptionMah;
    L24:
        app.setConsumedPower(8, appConsumptionMah, powerModel);
        if (query.isProcessStateDataNeeded() == false) goto L39;
        if (keys2 == null) goto L39;
        int r2 = keys2.length;
        int r3 = 0;
    L28:
        if (r3 >= r2) goto L39;
        BatteryConsumer.Key key = keys2[r3];
        int processState = key.processState;
        if (processState == 0) goto L33;
        long consumptionInStateUc = uid.getMobileRadioEnergyConsumptionUC(processState);
        double powerInStateMah = PowerCalculator.uCtoMah(consumptionInStateUc);
        app.setConsumedPower(key, powerInStateMah, powerModel);
    L33:
        r3 = r3 + 1;
        appConsumptionMah = appConsumptionMah;
    L39:
        i = i2 - 1;
        r0 = this;
        totalActivePowerMah = totalActivePowerMah2;
        goto L7
    L38:
        apps.add(app);
        appDurationsMs.addLast(radioActiveDurationMs);
        goto L39
    L11:
        if (query.isProcessStateDataNeeded() == false) goto L13;
        keys2 = app.getKeys(8);
        goto L14
    L13:
        keys2 = null;
        goto L14
    L40:
        double totalActivePowerMah3 = totalActivePowerMah;
        long totalActiveDurationMs = batteryStats.getMobileRadioActiveTime(rawRealtimeUs, 0) / 1000;
        if (totalActiveDurationMs >= total.totalAppDurationMs) goto L44;
        totalActiveDurationMs = total.totalAppDurationMs;
    L44:
        if (powerModel == 2) goto L72;
        int appSize = apps.size();
        long r22 = 1000;
        int i3 = 0;
    L46:
        if (i3 >= appSize) goto L71;
        UidBatteryConsumer.Builder app2 = apps.get(i3);
        long activeDurationMs = appDurationsMs.get(i3);
        ArrayList<UidBatteryConsumer.Builder> apps2 = apps;
        LongArrayQueue appDurationsMs2 = appDurationsMs;
        if (totalActiveDurationMs != 0.0d) goto L50;
        double appConsumptionMah2 = 0.0d;
    L52:
        if (app2.isVirtualUid() == true) goto L54;
        total.totalAppPowerMah += appConsumptionMah2;
    L54:
        app2.setConsumedPower(8, appConsumptionMah2, powerModel);
        if (query.isProcessStateDataNeeded() == false) goto L70;
        if (keys2 == null) goto L70;
        BatteryStats.Uid uid2 = app2.getBatteryStatsUid();
        int r4 = keys2.length;
        int processState2 = 0;
    L58:
        if (processState2 >= r4) goto L70;
        int r27 = r4;
        BatteryConsumer.Key key2 = keys2[processState2];
        int r28 = processState2;
        int processState3 = key2.processState;
        if (processState3 != 0) goto L62;
        double appConsumptionMah3 = appConsumptionMah2;
    L67:
        processState2 = r28 + 1;
        r4 = r27;
        totalActiveDurationMs = totalActiveDurationMs;
        appConsumptionMah2 = appConsumptionMah3;
        goto L58
    L62:
        appConsumptionMah3 = appConsumptionMah2;
        long durationInStateMs = uid2.getMobileRadioActiveTimeInProcessState(processState3) / 1000;
        if (activeDurationMs != 0.0d) goto L65;
        double powerInStateMah2 = 0.0d;
    L66:
        app2.setConsumedPower(key2, powerInStateMah2, powerModel);
        goto L67
    L65:
        double powerInStateMah3 = durationInStateMs;
        powerInStateMah2 = (powerInStateMah3 * appConsumptionMah3) / activeDurationMs;
    L70:
        i3 = i3 + 1;
        apps = apps2;
        appDurationsMs = appDurationsMs2;
        totalActiveDurationMs = totalActiveDurationMs;
        goto L46
    L50:
        double appConsumptionMah4 = activeDurationMs;
        appConsumptionMah2 = (appConsumptionMah4 * totalActivePowerMah3) / totalActiveDurationMs;
        goto L52
    L71:
        long totalActiveDurationMs2 = totalActiveDurationMs;
        double r24 = 0.0d;
    L73:
        total.remainingDurationMs = totalActiveDurationMs2 - total.totalAppDurationMs;
        if (powerModel != 2) goto L80;
        total.remainingPowerMah = PowerCalculator.uCtoMah(totalConsumptionUC) - total.totalAppPowerMah;
        if (total.remainingPowerMah >= r24) goto L99;
        total.remainingPowerMah = r24;
    L99:
        if (total.remainingPowerMah == 0.0d) goto L101;
    L104:
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(8, total.remainingDurationMs + total.totalAppDurationMs).setConsumedPower(8, total.remainingPowerMah + total.totalAppPowerMah, powerModel);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(8, total.totalAppDurationMs).setConsumedPower(8, total.totalAppPowerMah, powerModel);
        return;
    L101:
        if (total.totalAppPowerMah != 0.0d) goto L104;
        return;
    L80:
        if (totalActiveDurationMs2 == 0) goto L82;
        long totalActiveDurationMs3 = totalActiveDurationMs2;
        total.remainingPowerMah = total.remainingPowerMah + ((totalActivePowerMah3 * total.remainingDurationMs) / totalActiveDurationMs3);
    L83:
        BatteryStats.ControllerActivityCounter modemActivity = batteryStats.getModemControllerActivity();
        double inactivePowerMah = Double.NaN;
        if (modemActivity == null) goto L86;
        int r8 = 0;
        long sleepDurationMs = modemActivity.getSleepTimeCounter().getCountLocked(0);
        long idleDurationMs = modemActivity.getIdleTimeCounter().getCountLocked(0);
        MobileRadioPowerCalculator r1 = this;
        inactivePowerMah = r1.calcInactiveStatePowerMah(sleepDurationMs, idleDurationMs);
    L88:
        if (Double.isNaN(inactivePowerMah) == false) goto L96;
        long scanningTimeMs = batteryStats.getPhoneSignalScanningTime(rawRealtimeUs, r8) / r22;
        inactivePowerMah = r1.calcScanTimePowerMah(scanningTimeMs);
        int i4 = 0;
    L90:
        BatteryStats.ControllerActivityCounter modemActivity2 = modemActivity;
        if (i4 >= NUM_SIGNAL_STRENGTH_LEVELS) goto L96;
        inactivePowerMah = inactivePowerMah + r1.calcIdlePowerAtSignalStrengthMah(batteryStats.getPhoneSignalStrengthTime(i4, rawRealtimeUs, 0) / r22, i4);
        i4 = i4 + 1;
        modemActivity = modemActivity2;
        totalActiveDurationMs3 = totalActiveDurationMs3;
    L96:
        if (Double.isNaN(inactivePowerMah) == true) goto L99;
        total.remainingPowerMah += inactivePowerMah;
        goto L99
    L86:
        r8 = 0;
        r1 = this;
        goto L88
    L82:
        totalActiveDurationMs3 = totalActiveDurationMs2;
        goto L83
    L72:
        totalActiveDurationMs2 = totalActiveDurationMs;
        r22 = 1000;
        r24 = 0.0d;
        goto L73
    L5:
        totalActivePowerMah = r0.calculateActiveModemPowerMah(batteryStats, rawRealtimeUs);
        apps = new ArrayList();
        appDurationsMs = new LongArrayQueue();
        goto L6
    }

    private long calculateDuration(BatteryStats.Uid u, int statsType) {
        return u.getMobileRadioActiveTime(statsType) / 1000;
    }

    private double calculateActiveModemPowerMah(BatteryStats bs, long elapsedRealtimeUs) {
        long elapsedRealtimeMs = 1000;
        long elapsedRealtimeMs2 = elapsedRealtimeUs / 1000;
        int txLvlCount = NUM_SIGNAL_STRENGTH_LEVELS;
        double consumptionMah = 0.0d;
        boolean hasConstants = false;
        int rat = 0;
    L4:
        if (rat >= 3) goto L31;
        if (rat != 2) goto L8;
        int freqCount = 5;
    L9:
        int freq = 0;
    L10:
        if (freq >= freqCount) goto L30;
        int rat2 = rat;
        int rat3 = 0;
        double consumptionMah2 = consumptionMah;
        boolean hasConstants2 = hasConstants;
    L13:
        if (rat3 >= txLvlCount) goto L22;
        int freq2 = freq;
        long txDurationMs = bs.getActiveTxRadioDurationMs(rat2, freq2, rat3, elapsedRealtimeMs2);
        if (txDurationMs != (-1)) goto L17;
        int txLvl = rat3;
        long r20 = elapsedRealtimeMs;
        long elapsedRealtimeMs3 = elapsedRealtimeMs2;
        int rat4 = rat2;
        int freq3 = freq2;
    L21:
        rat3 = txLvl + 1;
        rat2 = rat4;
        freq = freq3;
        elapsedRealtimeMs2 = elapsedRealtimeMs3;
        elapsedRealtimeMs = r20;
        goto L13
    L17:
        r20 = elapsedRealtimeMs;
        elapsedRealtimeMs3 = elapsedRealtimeMs2;
        double txConsumptionMah = calcTxStatePowerMah(rat2, freq2, rat3, txDurationMs);
        txLvl = rat3;
        rat4 = rat2;
        freq3 = freq2;
        if (Double.isNaN(txConsumptionMah) == true) goto L21;
        hasConstants2 = true;
        consumptionMah2 = consumptionMah2 + txConsumptionMah;
        goto L21
    L22:
        long r21 = elapsedRealtimeMs;
        long elapsedRealtimeMs4 = elapsedRealtimeMs2;
        int freq4 = freq;
        int rat5 = rat2;
        long rxDurationMs = bs.getActiveRxRadioDurationMs(rat5, freq4, elapsedRealtimeMs4);
        if (rxDurationMs == (-1)) goto L27;
        double rxConsumptionMah = calcRxStatePowerMah(rat5, freq4, rxDurationMs);
        if (Double.isNaN(rxConsumptionMah) == true) goto L27;
        hasConstants = true;
        consumptionMah2 = consumptionMah2 + rxConsumptionMah;
    L29:
        consumptionMah = consumptionMah2;
        rat = rat5;
        freq = freq4 + 1;
        elapsedRealtimeMs2 = elapsedRealtimeMs4;
        elapsedRealtimeMs = r21;
    L27:
        hasConstants = hasConstants2;
        goto L29
    L30:
        long r22 = elapsedRealtimeMs;
        rat = rat + 1;
        elapsedRealtimeMs2 = elapsedRealtimeMs2;
        elapsedRealtimeMs = r22;
        goto L4
    L8:
        freqCount = 1;
        goto L9
    L31:
        long r23 = elapsedRealtimeMs;
        if (hasConstants == true) goto L46;
        long radioActiveDurationMs = bs.getMobileRadioActiveTime(elapsedRealtimeUs, 0) / r23;
        if (radioActiveDurationMs <= 0) goto L36;
        double consumptionMah3 = calcPowerFromRadioActiveDurationMah(radioActiveDurationMs);
        return consumptionMah3;
    L36:
        return 0.0d;
    L46:
        return consumptionMah;
    }

    public double calcRxStatePowerMah(int rat, int freqRange, long rxDurationMs) {
        long rxKey = ModemPowerProfile.getAverageBatteryDrainKey(536870912, rat, freqRange, -1);
        double drainRateMa = this.mPowerProfile.getAverageBatteryDrainOrDefaultMa(rxKey, Double.NaN);
        if (Double.isNaN(drainRateMa) == false) goto L6;
        Log.w(TAG, "Unavailable Power Profile constant for key 0x" + Long.toHexString(rxKey));
        return Double.NaN;
    L6:
        double consumptionMah = (rxDurationMs * drainRateMa) / MILLIS_IN_HOUR;
        return consumptionMah;
    }

    public double calcTxStatePowerMah(int rat, int freqRange, int txLevel, long txDurationMs) {
        long txKey = ModemPowerProfile.getAverageBatteryDrainKey(LZMA2Options.DICT_SIZE_MAX, rat, freqRange, txLevel);
        double drainRateMa = this.mPowerProfile.getAverageBatteryDrainOrDefaultMa(txKey, Double.NaN);
        if (Double.isNaN(drainRateMa) == false) goto L6;
        Log.w(TAG, "Unavailable Power Profile constant for key 0x" + Long.toHexString(txKey));
        return Double.NaN;
    L6:
        double consumptionMah = (txDurationMs * drainRateMa) / MILLIS_IN_HOUR;
        return consumptionMah;
    }

    public double calcInactiveStatePowerMah(long sleepDurationMs, long idleDurationMs) {
        if (this.mSleepPowerEstimator != null) goto L5;
        return Double.NaN;
    L5:
        if (this.mIdlePowerEstimator == null) goto L11;
        double sleepConsumptionMah = this.mSleepPowerEstimator.calculatePower(sleepDurationMs);
        double idleConsumptionMah = this.mIdlePowerEstimator.calculatePower(idleDurationMs);
        return sleepConsumptionMah + idleConsumptionMah;
    L11:
        return Double.NaN;
    }

    public double calcPowerFromRadioActiveDurationMah(long radioActiveDurationMs) {
        return this.mActivePowerEstimator.calculatePower(radioActiveDurationMs);
    }

    public double calcIdlePowerAtSignalStrengthMah(long strengthTimeMs, int strengthLevel) {
        return this.mIdlePowerEstimators[strengthLevel].calculatePower(strengthTimeMs);
    }

    public double calcScanTimePowerMah(long scanningTimeMs) {
        return this.mScanPowerEstimator.calculatePower(scanningTimeMs);
    }
}
