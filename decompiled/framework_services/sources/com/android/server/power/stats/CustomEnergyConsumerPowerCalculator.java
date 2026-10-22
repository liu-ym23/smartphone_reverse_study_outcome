package com.android.server.power.stats;

import android.os.AggregateBatteryConsumer;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class CustomEnergyConsumerPowerCalculator extends PowerCalculator {
    private static final String TAG = "CustomEnergyCsmrPowerCalc";

    public CustomEnergyConsumerPowerCalculator(PowerProfile powerProfile) {
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        double[] totalAppPowerMah = null;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L5;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        totalAppPowerMah = calculateApp(app, app.getBatteryStatsUid(), totalAppPowerMah);
        i = i - 1;
        goto L3
    L5:
        double[] customEnergyConsumerPowerMah = uCtoMah(batteryStats.getCustomEnergyConsumerBatteryConsumptionUC());
        if (customEnergyConsumerPowerMah == null) goto L11;
        AggregateBatteryConsumer.Builder deviceBatteryConsumerBuilder = builder.getAggregateBatteryConsumerBuilder(0);
        int i2 = 0;
    L9:
        if (i2 >= customEnergyConsumerPowerMah.length) goto L11;
        deviceBatteryConsumerBuilder.setConsumedPower(i2 + 1000, customEnergyConsumerPowerMah[i2]);
        i2 = i2 + 1;
    L11:
        if (totalAppPowerMah == null) goto L16;
        AggregateBatteryConsumer.Builder appsBatteryConsumerBuilder = builder.getAggregateBatteryConsumerBuilder(1);
        int i3 = 0;
    L14:
        if (i3 >= totalAppPowerMah.length) goto L20;
        appsBatteryConsumerBuilder.setConsumedPower(i3 + 1000, totalAppPowerMah[i3]);
        i3 = i3 + 1;
        goto L14
    L20:
        return;
    }

    private double[] calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, double[] totalPowerMah) {
        double[] newTotalPowerMah = null;
        double[] customEnergyConsumerPowerMah = uCtoMah(u.getCustomEnergyConsumerBatteryConsumptionUC());
        if (customEnergyConsumerPowerMah == null) goto L17;
        if (totalPowerMah != null) goto L7;
        newTotalPowerMah = new double[customEnergyConsumerPowerMah.length];
    L10:
        int i = 0;
    L12:
        if (i >= customEnergyConsumerPowerMah.length) goto L17;
        app.setConsumedPower(i + 1000, customEnergyConsumerPowerMah[i]);
        if (app.isVirtualUid() == true) goto L16;
        newTotalPowerMah[i] = newTotalPowerMah[i] + customEnergyConsumerPowerMah[i];
    L16:
        i = i + 1;
        goto L12
    L7:
        if (totalPowerMah.length == customEnergyConsumerPowerMah.length) goto L9;
        Slog.wtf(TAG, "Number of custom energy components is not the same for all apps: " + totalPowerMah.length + ", " + customEnergyConsumerPowerMah.length);
        newTotalPowerMah = Arrays.copyOf(totalPowerMah, customEnergyConsumerPowerMah.length);
        goto L10
    L9:
        newTotalPowerMah = totalPowerMah;
    L17:
        return newTotalPowerMah;
    }

    private double[] uCtoMah(long[] chargeUC) {
        if (chargeUC != null) goto L5;
        return null;
    L5:
        double[] mah = new double[chargeUC.length];
        int i = 0;
    L7:
        if (i >= chargeUC.length) goto L10;
        mah[i] = PowerCalculator.uCtoMah(chargeUC[i]);
        i = i + 1;
        goto L7
    L10:
        return mah;
    }
}
