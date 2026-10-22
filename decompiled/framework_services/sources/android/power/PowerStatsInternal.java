package android.power;

import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.StateResidencyResult;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class PowerStatsInternal {
    public abstract CompletableFuture<EnergyConsumerResult[]> getEnergyConsumedAsync(int[] r1);

    public abstract EnergyConsumer[] getEnergyConsumerInfo();

    public abstract Channel[] getEnergyMeterInfo();

    public abstract PowerEntity[] getPowerEntityInfo();

    public abstract CompletableFuture<StateResidencyResult[]> getStateResidencyAsync(int[] r1);

    public abstract CompletableFuture<EnergyMeasurement[]> readEnergyMeterAsync(int[] r1);

    public PowerStatsInternal() {
    }
}
