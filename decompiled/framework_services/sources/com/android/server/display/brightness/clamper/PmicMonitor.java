package com.android.server.display.brightness.clamper;

import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.os.IThermalService;
import android.os.RemoteException;
import android.os.Temperature;
import android.power.PowerStatsInternal;
import android.util.IntArray;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class PmicMonitor {
    private static final String TAG = "PmicMonitor";
    private float[] mAvgPowerCircularList;
    private Temperature mCurrentTemperature;
    private long mCurrentTimestampMillis;
    private float mCurrentTotalAvgPower;
    private final ScheduledExecutorService mExecutor;
    private float mLastEnergyConsumed;
    private ScheduledFuture<?> mPmicMonitorFuture;
    BrightnessPowerModifier.PowerChangeListener mPowerChangeListener;
    private int mPowerListEnd;
    private int mPowerListStart;
    private final long mPowerMonitorPeriodConfigMillis;
    private final PowerStatsInternal mPowerStatsInternal;
    final IThermalService mThermalService;

    public static /* synthetic */ void $r8$lambda$cEEyBdj4M7vH142zh4xqaprVEkY(PmicMonitor r0) {
        r0.capturePeriodicDisplayPower();
    }

    PmicMonitor(BrightnessPowerModifier.PowerChangeListener listener, IThermalService thermalService, int pollingMaxTimeMillis, int pollingMinTimeMillis) {
        this.mLastEnergyConsumed = 0.0f;
        this.mCurrentTotalAvgPower = 0.0f;
        this.mCurrentTimestampMillis = 0;
        this.mPowerListStart = 0;
        this.mPowerListEnd = 0;
        this.mPowerChangeListener = listener;
        this.mThermalService = thermalService;
        this.mPowerStatsInternal = (PowerStatsInternal) LocalServices.getService(PowerStatsInternal.class);
        this.mAvgPowerCircularList = new float[pollingMaxTimeMillis / pollingMinTimeMillis];
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mPowerMonitorPeriodConfigMillis = pollingMinTimeMillis;
    }

    private Temperature getDisplayTemperature() {
        Temperature[] temperatures = this.mThermalService.getCurrentTemperaturesWithType(3);     // Catch: RemoteException -> L6
        if (temperatures.length <= 1) goto L9;
        Slog.w(TAG, "Multiple skin temperatures not allowed!");     // Catch: RemoteException -> L6
    L9:
        if (temperatures.length <= 0) goto L18;
        Temperature retTemperature = temperatures[0];     // Catch: RemoteException -> L6
        return retTemperature;
    L18:
        return null;
    L6:
        e = move-exception;
        Slog.w(TAG, "getDisplayTemperature failed" + e);
        return null;
    }

    private void capturePeriodicDisplayPower() {
        EnergyConsumer[] energyConsumers = this.mPowerStatsInternal.getEnergyConsumerInfo();
        if (energyConsumers != null) goto L5;
        return;
    L5:
        if (energyConsumers.length == 0) goto L53;
        IntArray energyConsumerIds = new IntArray();
        int i = 0;
    L9:
        if (i >= energyConsumers.length) goto L14;
        if (energyConsumers[i].type != 3) goto L13;
        energyConsumerIds.add(energyConsumers[i].id);
    L13:
        i = i + 1;
        goto L9
    L14:
        int i2 = energyConsumerIds.size();
        if (i2 != 0) goto L18;
        Slog.w(TAG, "DISPLAY energyConsumerIds size is null");
        return;
    L18:
        CompletableFuture<EnergyConsumerResult[]> futureECRs = this.mPowerStatsInternal.getEnergyConsumedAsync(energyConsumerIds.toArray());
        if (futureECRs != null) goto L47;
        Slog.w(TAG, "Energy consumers results are null");
        return;
    L47:
        EnergyConsumerResult[] displayResults = futureECRs.get();     // Catch: ExecutionException -> L24 InterruptedException -> L26
    L30:
        if (displayResults != null) goto L32;
    L44:
        Slog.w(TAG, "displayResults are null");
        return;
    L32:
        if (displayResults.length == 0) goto L44;
        float energyConsumed = displayResults[0].energyUWs - this.mLastEnergyConsumed;
        float timeIntervalSeconds = (displayResults[0].timestampMs - this.mCurrentTimestampMillis) / 1000.0f;
        float currentPower = (energyConsumed / timeIntervalSeconds) / 1000.0f;
        Temperature displayTemperature = getDisplayTemperature();
        boolean isBufferFull = false;
        this.mAvgPowerCircularList[this.mPowerListEnd] = currentPower;
        this.mCurrentTotalAvgPower += currentPower;
        this.mPowerListEnd = (this.mPowerListEnd + 1) % this.mAvgPowerCircularList.length;
        if (this.mPowerListStart != this.mPowerListEnd) goto L37;
        isBufferFull = true;
    L37:
        this.mCurrentTemperature = displayTemperature;
        this.mLastEnergyConsumed = displayResults[0].energyUWs;
        this.mCurrentTimestampMillis = displayResults[0].timestampMs;
        if (this.mCurrentTemperature == null) goto L41;
        if (isBufferFull == false) goto L41;
        this.mPowerChangeListener.onChanged(this.mCurrentTotalAvgPower / this.mAvgPowerCircularList.length, this.mCurrentTemperature.getStatus());
    L41:
        if (isBufferFull == false) goto L52;
        this.mCurrentTotalAvgPower -= this.mAvgPowerCircularList[this.mPowerListStart];
        this.mPowerListStart = (this.mPowerListStart + 1) % this.mAvgPowerCircularList.length;
        return;
    L52:
        return;
    L26:
        e = move-exception;
        Slog.w(TAG, "timeout or interrupt reading getEnergyConsumedAsync failed", e);
        displayResults = null;
    L24:
        e = move-exception;
        Slog.wtf(TAG, "exception reading getEnergyConsumedAsync: ", e);
        displayResults = null;
        goto L30
    }

    public void start() {
        if (this.mPowerStatsInternal != null) goto L7;
        Slog.w(TAG, "Power stats service not found for monitoring.");
        return;
    L7:
        if (this.mThermalService != null) goto L11;
        Slog.w(TAG, "Thermal service not found.");
        return;
    L11:
        if (this.mPmicMonitorFuture != null) goto L13;
        this.mPmicMonitorFuture = this.mExecutor.scheduleAtFixedRate(new PmicMonitor$$ExternalSyntheticLambda0(this), this.mPowerMonitorPeriodConfigMillis, this.mPowerMonitorPeriodConfigMillis, TimeUnit.MILLISECONDS);
        return;
    L13:
        Slog.e(TAG, "PMIC already scheduled, stop() called before start.");
    }

    public void stop() {
        if (this.mPmicMonitorFuture == null) goto L6;
        this.mPmicMonitorFuture.cancel(true);
        this.mPmicMonitorFuture = null;
        return;
    }

    public void updateConfiguration() {
        if (this.mPmicMonitorFuture == null) goto L6;
        this.mPmicMonitorFuture.cancel(true);
        this.mPmicMonitorFuture = null;
        return;
    }

    public boolean isStopped() {
        if (this.mPmicMonitorFuture != null) goto L5;
        return true;
    L5:
        return false;
    }

    public void shutdown() {
        this.mExecutor.shutdownNow();
    }
}
