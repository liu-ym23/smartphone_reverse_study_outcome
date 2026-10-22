package com.android.server.powerstats;

import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.IPowerStats;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.StateResidencyResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final class PowerStatsHALWrapper {
    private static final boolean DEBUG = false;
    private static final String TAG = null;

    public interface IPowerStatsHALWrapper {
        EnergyConsumerResult[] getEnergyConsumed(int[] r1);

        EnergyConsumer[] getEnergyConsumerInfo();

        Channel[] getEnergyMeterInfo();

        PowerEntity[] getPowerEntityInfo();

        StateResidencyResult[] getStateResidency(int[] r1);

        boolean isInitialized();

        EnergyMeasurement[] readEnergyMeter(int[] r1);
    }

    public static final class PowerStatsHAL10WrapperImpl implements IPowerStatsHALWrapper {
        private boolean mIsInitialized;

        private static native Channel[] nativeGetEnergyMeterInfo();

        private static native PowerEntity[] nativeGetPowerEntityInfo();

        private static native StateResidencyResult[] nativeGetStateResidency(int[] r0);

        private static native boolean nativeInit();

        private static native EnergyMeasurement[] nativeReadEnergyMeters(int[] r0);

        public PowerStatsHAL10WrapperImpl() {
            if (nativeInit() == false) goto L5;
            this.mIsInitialized = true;
            return;
        L5:
            this.mIsInitialized = false;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public PowerEntity[] getPowerEntityInfo() {
            return nativeGetPowerEntityInfo();
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public StateResidencyResult[] getStateResidency(int[] powerEntityIds) {
            return nativeGetStateResidency(powerEntityIds);
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyConsumer[] getEnergyConsumerInfo() {
            return new EnergyConsumer[0];
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyConsumerResult[] getEnergyConsumed(int[] energyConsumerIds) {
            return new EnergyConsumerResult[0];
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public Channel[] getEnergyMeterInfo() {
            return nativeGetEnergyMeterInfo();
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyMeasurement[] readEnergyMeter(int[] channelIds) {
            return nativeReadEnergyMeters(channelIds);
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public boolean isInitialized() {
            return this.mIsInitialized;
        }
    }

    public static final class PowerStatsHAL20WrapperImpl implements IPowerStatsHALWrapper {
        private static Supplier<IPowerStats> sVintfPowerStats;

        public PowerStatsHAL20WrapperImpl() {
            Supplier<IPowerStats> service = new VintfHalCache(null);
            sVintfPowerStats = null;
            if (service.get() != null) goto L5;
            sVintfPowerStats = null;
            return;
        L5:
            sVintfPowerStats = service;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public PowerEntity[] getPowerEntityInfo() {
            if (sVintfPowerStats == null) goto L11;
            PowerEntity[] powerEntityHAL = sVintfPowerStats.get().getPowerEntityInfo();     // Catch: RemoteException -> L6
            return powerEntityHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get power entity info: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public StateResidencyResult[] getStateResidency(int[] powerEntityIds) {
            if (sVintfPowerStats == null) goto L11;
            StateResidencyResult[] stateResidencyResultHAL = sVintfPowerStats.get().getStateResidency(powerEntityIds);     // Catch: RemoteException -> L6
            return stateResidencyResultHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get state residency: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyConsumer[] getEnergyConsumerInfo() {
            if (sVintfPowerStats == null) goto L11;
            EnergyConsumer[] energyConsumerHAL = sVintfPowerStats.get().getEnergyConsumerInfo();     // Catch: RemoteException -> L6
            return energyConsumerHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get energy consumer info: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyConsumerResult[] getEnergyConsumed(int[] energyConsumerIds) {
            if (sVintfPowerStats == null) goto L11;
            EnergyConsumerResult[] energyConsumedHAL = sVintfPowerStats.get().getEnergyConsumed(energyConsumerIds);     // Catch: RemoteException -> L6
            return energyConsumedHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get energy consumer results: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public Channel[] getEnergyMeterInfo() {
            if (sVintfPowerStats == null) goto L11;
            Channel[] energyMeterInfoHAL = sVintfPowerStats.get().getEnergyMeterInfo();     // Catch: RemoteException -> L6
            return energyMeterInfoHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get energy meter info: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public EnergyMeasurement[] readEnergyMeter(int[] channelIds) {
            if (sVintfPowerStats == null) goto L11;
            EnergyMeasurement[] energyMeasurementHAL = sVintfPowerStats.get().readEnergyMeter(channelIds);     // Catch: RemoteException -> L6
            return energyMeasurementHAL;
        L6:
            e = move-exception;
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Failed to get energy measurements: ", e);
            return null;
        L11:
            return null;
        }

        @Override // com.android.server.powerstats.PowerStatsHALWrapper.IPowerStatsHALWrapper
        public boolean isInitialized() {
            if (sVintfPowerStats == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class VintfHalCache implements Supplier<IPowerStats>, IBinder.DeathRecipient {
        private IPowerStats mInstance;

        /* synthetic */ VintfHalCache(PowerStatsHALWrapperIA r1) {
            this();
        }

        private VintfHalCache() {
            this.mInstance = null;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ IPowerStats get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.function.Supplier
        public synchronized IPowerStats get() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mInstance != null) goto L15;
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService("android.hardware.power.stats.IPowerStats/default"));     // Catch: Throwable -> L11
            if (binder == null) goto L15;
            this.mInstance = IPowerStats.Stub.asInterface(binder);     // Catch: Throwable -> L11
            binder.linkToDeath(this, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        L14:
            Slog.e(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "Unable to register DeathRecipient for " + this.mInstance);     // Catch: Throwable -> L11
        L15:
            IPowerStats r0 = this.mInstance;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r0;
        }

        @Override // android.os.IBinder.DeathRecipient
        public synchronized void binderDied() {
            monitor-enter(this);
            Slog.w(PowerStatsHALWrapper.m7875$$Nest$sfgetTAG(), "PowerStats HAL died");     // Catch: Throwable -> L6
            this.mInstance = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7875$$Nest$sfgetTAG() {
        return TAG;
    }

    public PowerStatsHALWrapper() {
    }

    static {
        TAG = PowerStatsHALWrapper.class.getSimpleName();
    }

    public static IPowerStatsHALWrapper getPowerStatsHalImpl() {
        PowerStatsHAL20WrapperImpl powerStatsHAL20WrapperImpl = new PowerStatsHAL20WrapperImpl();
        if (powerStatsHAL20WrapperImpl.isInitialized() == false) goto L6;
        return powerStatsHAL20WrapperImpl;
    L6:
        return new PowerStatsHAL10WrapperImpl();
    }
}
