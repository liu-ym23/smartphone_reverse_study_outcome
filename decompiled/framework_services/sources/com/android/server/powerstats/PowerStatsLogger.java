package com.android.server.powerstats;

import android.content.Context;
import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.StateResidencyResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class PowerStatsLogger extends Handler {
    private static final boolean DEBUG = false;
    protected static final int MSG_LOG_TO_DATA_STORAGE_BATTERY_DROP = 0;
    protected static final int MSG_LOG_TO_DATA_STORAGE_HIGH_FREQUENCY = 2;
    protected static final int MSG_LOG_TO_DATA_STORAGE_LOW_FREQUENCY = 1;
    private static final String TAG = null;
    private File mDataStoragePath;
    private boolean mDeleteMeterDataOnBoot;
    private boolean mDeleteModelDataOnBoot;
    private boolean mDeleteResidencyDataOnBoot;
    private final PowerStatsHALWrapper.IPowerStatsHALWrapper mPowerStatsHALWrapper;
    private final PowerStatsDataStorage mPowerStatsMeterStorage;
    private final PowerStatsDataStorage mPowerStatsModelStorage;
    private final PowerStatsDataStorage mPowerStatsResidencyStorage;
    private final long mStartWallTime;

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7876$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = PowerStatsLogger.class.getSimpleName();
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        EnergyMeasurement[] energyMeasurements = this.mPowerStatsHALWrapper.readEnergyMeter(new int[0]);
        ProtoStreamUtils.EnergyMeasurementUtils.adjustTimeSinceBootToEpoch(energyMeasurements, this.mStartWallTime);
        this.mPowerStatsMeterStorage.write(ProtoStreamUtils.EnergyMeasurementUtils.getProtoBytes(energyMeasurements));
        EnergyConsumerResult[] ecrNoAttribution = this.mPowerStatsHALWrapper.getEnergyConsumed(new int[0]);
        ProtoStreamUtils.EnergyConsumerResultUtils.adjustTimeSinceBootToEpoch(ecrNoAttribution, this.mStartWallTime);
        this.mPowerStatsModelStorage.write(ProtoStreamUtils.EnergyConsumerResultUtils.getProtoBytes(ecrNoAttribution, false));
        return;
    L6:
        EnergyConsumerResult[] ecrAttribution = this.mPowerStatsHALWrapper.getEnergyConsumed(new int[0]);
        ProtoStreamUtils.EnergyConsumerResultUtils.adjustTimeSinceBootToEpoch(ecrAttribution, this.mStartWallTime);
        this.mPowerStatsModelStorage.write(ProtoStreamUtils.EnergyConsumerResultUtils.getProtoBytes(ecrAttribution, true));
        return;
    L7:
        StateResidencyResult[] stateResidencyResults = this.mPowerStatsHALWrapper.getStateResidency(new int[0]);
        ProtoStreamUtils.StateResidencyResultUtils.adjustTimeSinceBootToEpoch(stateResidencyResults, this.mStartWallTime);
        this.mPowerStatsResidencyStorage.write(ProtoStreamUtils.StateResidencyResultUtils.getProtoBytes(stateResidencyResults));
        return;
    }

    public void writeMeterDataToFile(FileDescriptor fd) {
        final ProtoOutputStream pos = new ProtoOutputStream(fd);
        Channel[] channel = this.mPowerStatsHALWrapper.getEnergyMeterInfo();     // Catch: IOException -> L5
        ProtoStreamUtils.ChannelUtils.packProtoMessage(channel, pos);     // Catch: IOException -> L5
        this.mPowerStatsMeterStorage.read(new AnonymousClass1(this, pos));     // Catch: IOException -> L5
    L7:
        pos.flush();
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to write energy meter info to incident report.", e);
        goto L7
    }

    public void writeModelDataToFile(FileDescriptor fd) {
        final ProtoOutputStream pos = new ProtoOutputStream(fd);
        EnergyConsumer[] energyConsumer = this.mPowerStatsHALWrapper.getEnergyConsumerInfo();     // Catch: IOException -> L5
        ProtoStreamUtils.EnergyConsumerUtils.packProtoMessage(energyConsumer, pos);     // Catch: IOException -> L5
        this.mPowerStatsModelStorage.read(new AnonymousClass2(this, pos));     // Catch: IOException -> L5
    L7:
        pos.flush();
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to write energy model info to incident report.", e);
        goto L7
    }

    public void writeResidencyDataToFile(FileDescriptor fd) {
        final ProtoOutputStream pos = new ProtoOutputStream(fd);
        PowerEntity[] powerEntity = this.mPowerStatsHALWrapper.getPowerEntityInfo();     // Catch: IOException -> L5
        ProtoStreamUtils.PowerEntityUtils.packProtoMessage(powerEntity, pos);     // Catch: IOException -> L5
        this.mPowerStatsResidencyStorage.read(new AnonymousClass3(this, pos));     // Catch: IOException -> L5
    L7:
        pos.flush();
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to write residency data to incident report.", e);
        goto L7
    }

    private boolean dataChanged(String cachedFilename, byte[] dataCurrent) {
        if (this.mDataStoragePath.exists() == false) goto L5;
    L6:
        File cachedFile = new File(this.mDataStoragePath, cachedFilename);
        if (cachedFile.exists() == false) goto L14;
        byte[] dataCached = new byte[(int) cachedFile.length()];
        FileInputStream fis = new FileInputStream(cachedFile.getPath());     // Catch: IOException -> L11
        fis.read(dataCached);     // Catch: IOException -> L11
    L13:
        boolean dataChanged = !Arrays.equals(dataCached, dataCurrent);
        return dataChanged;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to read cached data from file", e);
        goto L13
    L14:
        return true;
    L5:
        if (this.mDataStoragePath.mkdirs() == true) goto L6;
        return false;
    }

    private void updateCacheFile(String cacheFilename, byte[] data) {
        AtomicFile atomicCachedFile = null;
        FileOutputStream fos = null;
        atomicCachedFile = new AtomicFile(new File(this.mDataStoragePath, cacheFilename));     // Catch: IOException -> L5
        fos = atomicCachedFile.startWrite();     // Catch: IOException -> L5
        fos.write(data);     // Catch: IOException -> L5
        atomicCachedFile.finishWrite(fos);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to write current data to cached file", e);
        if (fos == null) goto L12;
        atomicCachedFile.failWrite(fos);
        return;
    }

    public boolean getDeleteMeterDataOnBoot() {
        return this.mDeleteMeterDataOnBoot;
    }

    public boolean getDeleteModelDataOnBoot() {
        return this.mDeleteModelDataOnBoot;
    }

    public boolean getDeleteResidencyDataOnBoot() {
        return this.mDeleteResidencyDataOnBoot;
    }

    public long getStartWallTime() {
        return this.mStartWallTime;
    }

    public PowerStatsLogger(Context context, Looper looper, File dataStoragePath, String meterFilename, String meterCacheFilename, String modelFilename, String modelCacheFilename, String residencyFilename, String residencyCacheFilename, PowerStatsHALWrapper.IPowerStatsHALWrapper powerStatsHALWrapper) {
        super(looper);
        this.mStartWallTime = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.mPowerStatsHALWrapper = powerStatsHALWrapper;
        this.mDataStoragePath = dataStoragePath;
        this.mPowerStatsMeterStorage = new PowerStatsDataStorage(context, this.mDataStoragePath, meterFilename);
        this.mPowerStatsModelStorage = new PowerStatsDataStorage(context, this.mDataStoragePath, modelFilename);
        this.mPowerStatsResidencyStorage = new PowerStatsDataStorage(context, this.mDataStoragePath, residencyFilename);
        Channel[] channels = this.mPowerStatsHALWrapper.getEnergyMeterInfo();
        byte[] channelBytes = ProtoStreamUtils.ChannelUtils.getProtoBytes(channels);
        this.mDeleteMeterDataOnBoot = dataChanged(meterCacheFilename, channelBytes);
        if (this.mDeleteMeterDataOnBoot == false) goto L5;
        this.mPowerStatsMeterStorage.deleteLogs();
        updateCacheFile(meterCacheFilename, channelBytes);
    L5:
        EnergyConsumer[] energyConsumers = this.mPowerStatsHALWrapper.getEnergyConsumerInfo();
        byte[] energyConsumerBytes = ProtoStreamUtils.EnergyConsumerUtils.getProtoBytes(energyConsumers);
        this.mDeleteModelDataOnBoot = dataChanged(modelCacheFilename, energyConsumerBytes);
        if (this.mDeleteModelDataOnBoot == false) goto L8;
        this.mPowerStatsModelStorage.deleteLogs();
        updateCacheFile(modelCacheFilename, energyConsumerBytes);
    L8:
        PowerEntity[] powerEntities = this.mPowerStatsHALWrapper.getPowerEntityInfo();
        byte[] powerEntityBytes = ProtoStreamUtils.PowerEntityUtils.getProtoBytes(powerEntities);
        this.mDeleteResidencyDataOnBoot = dataChanged(residencyCacheFilename, powerEntityBytes);
        if (this.mDeleteResidencyDataOnBoot == false) goto L12;
        this.mPowerStatsResidencyStorage.deleteLogs();
        updateCacheFile(residencyCacheFilename, powerEntityBytes);
        return;
    }

    public void dump(IndentingPrintWriter ipw) {
        ipw.println("PowerStats Meter Data:");
        ipw.increaseIndent();
        this.mPowerStatsMeterStorage.dump(ipw);
        ipw.decreaseIndent();
        ipw.println("PowerStats Model Data:");
        ipw.increaseIndent();
        this.mPowerStatsModelStorage.dump(ipw);
        ipw.decreaseIndent();
        ipw.println("PowerStats State Residency Data:");
        ipw.increaseIndent();
        this.mPowerStatsResidencyStorage.dump(ipw);
        ipw.decreaseIndent();
    }
}
