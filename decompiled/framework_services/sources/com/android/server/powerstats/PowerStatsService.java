package com.android.server.powerstats;

import android.content.Context;
import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerResult;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.StateResidencyResult;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IPowerStatsService;
import android.os.Looper;
import android.os.PowerMonitor;
import android.os.ResultReceiver;
import android.power.PowerStatsInternal;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.os.Clock;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.display.config.SensorData;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsService extends SystemService {
    private static final String DATA_STORAGE_SUBDIR = "powerstats";
    private static final int DATA_STORAGE_VERSION = 0;
    private static final boolean DEBUG = false;
    private static final double INTERVAL_RANDOM_NOISE_GENERATION_ALPHA = 50.0d;
    static final String KEY_POWER_MONITOR_API_ENABLED = "power_monitor_api_enabled";
    private static final long MAX_FINE_POWER_MONITOR_AGE_MILLIS = 250;
    private static final long MAX_POWER_MONITOR_AGE_MILLIS = 20000;
    private static final long MAX_RANDOM_NOISE_UWS = 10000000;
    private static final String METER_CACHE_FILENAME = "meterCache";
    private static final String METER_FILENAME = "log.powerstats.meter.0";
    private static final String MODEL_CACHE_FILENAME = "modelCache";
    private static final String MODEL_FILENAME = "log.powerstats.model.0";
    private static final String RESIDENCY_CACHE_FILENAME = "residencyCache";
    private static final String RESIDENCY_FILENAME = "log.powerstats.residency.0";
    private static final String TAG = null;
    private BatteryTrigger mBatteryTrigger;
    private final Clock mClock;
    private Context mContext;
    private File mDataStoragePath;
    private final DeviceConfigInterface mDeviceConfig;
    private final DeviceConfigListener mDeviceConfigListener;
    private EnergyConsumer[] mEnergyConsumers;
    private Channel[] mEnergyMeters;
    private PowerMonitorState[] mFinePowerMonitorStates;
    private Handler mHandler;
    private final Injector mInjector;
    private IntervalRandomNoiseGenerator mIntervalRandomNoiseGenerator;
    private Looper mLooper;
    private boolean mPowerMonitorApiEnabled;
    private PowerMonitorState[] mPowerMonitorStates;
    private volatile PowerMonitor[] mPowerMonitors;
    private PowerStatsInternal mPowerStatsInternal;
    private PowerStatsLogger mPowerStatsLogger;
    private StatsPullAtomCallbackImpl mPullAtomCallback;
    private final IBinder mService;
    private TimerTrigger mTimerTrigger;

    /* JADX INFO: renamed from: com.android.server.powerstats.PowerStatsService$1, reason: invalid class name */
    class AnonymousClass1 extends IPowerStatsService.Stub {
        final /* synthetic */ PowerStatsService this$0;

        public static /* synthetic */ void $r8$lambda$fMDPgpm7l5sfkeriE4yKZRK8reM(AnonymousClass1 r0, int[] r1, ResultReceiver r2, int r3) {
            r0.lambda$getPowerMonitorReadings$1(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$wTg4t_wXyeO0yCJjTtZ_Tg5MF4s(AnonymousClass1 r0, ResultReceiver r1) {
            r0.lambda$getSupportedPowerMonitors$0(r1);
        }

        AnonymousClass1(PowerStatsService this$0) {
            this.this$0 = this$0;
        }

        public void getSupportedPowerMonitors(final ResultReceiver resultReceiver) {
            resultReceiver.getClass();
            PowerStatsService.m7881$$Nest$mgetHandler(this.this$0).post(new PowerStatsService$1$$ExternalSyntheticLambda0(this, resultReceiver));
        }

        private /* synthetic */ void lambda$getSupportedPowerMonitors$0(ResultReceiver resultReceiver) {
            this.this$0.getSupportedPowerMonitorsImpl(resultReceiver);
        }

        public void getPowerMonitorReadings(final int[] powerMonitorIds, final ResultReceiver resultReceiver) {
            powerMonitorIds.getClass();
            resultReceiver.getClass();
            final int callingUid = Binder.getCallingUid();
            PowerStatsService.m7881$$Nest$mgetHandler(this.this$0).post(new PowerStatsService$1$$ExternalSyntheticLambda1(this, powerMonitorIds, resultReceiver, callingUid));
        }

        private /* synthetic */ void lambda$getPowerMonitorReadings$1(int[] powerMonitorIds, ResultReceiver resultReceiver, int callingUid) {
            this.this$0.getPowerMonitorReadingsImpl(powerMonitorIds, resultReceiver, callingUid);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(PowerStatsService.m7877$$Nest$fgetmContext(this.this$0), PowerStatsService.m7885$$Nest$sfgetTAG(), pw) == true) goto L6;
            return;
        L6:
            if (PowerStatsService.m7879$$Nest$fgetmPowerStatsLogger(this.this$0) != null) goto L9;
            Slog.e(PowerStatsService.m7885$$Nest$sfgetTAG(), "PowerStats HAL is not initialized.  No data available.");
            return;
        L9:
            if (args.length > 0) goto L11;
        L21:
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
            ipw.println("PowerStatsService dumpsys: available PowerEntities");
            PowerEntity[] powerEntity = PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getPowerEntityInfo();
            ipw.increaseIndent();
            ProtoStreamUtils.PowerEntityUtils.dumpsys(powerEntity, ipw);
            ipw.decreaseIndent();
            ipw.println("PowerStatsService dumpsys: available Channels");
            Channel[] channel = PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getEnergyMeterInfo();
            ipw.increaseIndent();
            ProtoStreamUtils.ChannelUtils.dumpsys(channel, ipw);
            ipw.decreaseIndent();
            ipw.println("PowerStatsService dumpsys: available EnergyConsumers");
            EnergyConsumer[] energyConsumer = PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getEnergyConsumerInfo();
            ipw.increaseIndent();
            ProtoStreamUtils.EnergyConsumerUtils.dumpsys(energyConsumer, ipw);
            ipw.decreaseIndent();
            ipw.println("PowerStatsService dumpsys: PowerStatsLogger stats");
            ipw.increaseIndent();
            PowerStatsService.m7879$$Nest$fgetmPowerStatsLogger(this.this$0).dump(ipw);
            ipw.decreaseIndent();
            return;
        L11:
            if ("--proto".equals(args[0]) == false) goto L21;
            if ("model".equals(args[1]) == false) goto L16;
            PowerStatsService.m7879$$Nest$fgetmPowerStatsLogger(this.this$0).writeModelDataToFile(fd);
            return;
        L16:
            if ("meter".equals(args[1]) == false) goto L19;
            PowerStatsService.m7879$$Nest$fgetmPowerStatsLogger(this.this$0).writeMeterDataToFile(fd);
            return;
        L19:
            if ("residency".equals(args[1]) == false) goto L26;
            PowerStatsService.m7879$$Nest$fgetmPowerStatsLogger(this.this$0).writeResidencyDataToFile(fd);
            return;
        }
    }

    private class DeviceConfigListener implements DeviceConfig.OnPropertiesChangedListener {
        public Executor mExecutor;
        final /* synthetic */ PowerStatsService this$0;

        /* synthetic */ DeviceConfigListener(PowerStatsService r1, PowerStatsServiceIA r2) {
            this(r1);
        }

        private DeviceConfigListener(PowerStatsService r2) {
            this.this$0 = r2;
            this.mExecutor = new HandlerExecutor(PowerStatsService.m7881$$Nest$mgetHandler(this.this$0));
        }

        void startListening() {
            PowerStatsService.m7878$$Nest$fgetmDeviceConfig(this.this$0).addOnPropertiesChangedListener("battery_stats", this.mExecutor, this);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            this.this$0.refreshFlags();
        }
    }

    static class Injector {
        private PowerStatsHALWrapper.IPowerStatsHALWrapper mPowerStatsHALWrapper;

        Injector() {
        }

        Clock getClock() {
            return Clock.SYSTEM_CLOCK;
        }

        File createDataStoragePath() {
            return new File(Environment.getDataSystemDeDirectory(0), PowerStatsService.DATA_STORAGE_SUBDIR);
        }

        String createMeterFilename() {
            return PowerStatsService.METER_FILENAME;
        }

        String createModelFilename() {
            return PowerStatsService.MODEL_FILENAME;
        }

        String createResidencyFilename() {
            return PowerStatsService.RESIDENCY_FILENAME;
        }

        String createMeterCacheFilename() {
            return PowerStatsService.METER_CACHE_FILENAME;
        }

        String createModelCacheFilename() {
            return PowerStatsService.MODEL_CACHE_FILENAME;
        }

        String createResidencyCacheFilename() {
            return PowerStatsService.RESIDENCY_CACHE_FILENAME;
        }

        PowerStatsHALWrapper.IPowerStatsHALWrapper createPowerStatsHALWrapperImpl() {
            return PowerStatsHALWrapper.getPowerStatsHalImpl();
        }

        PowerStatsHALWrapper.IPowerStatsHALWrapper getPowerStatsHALWrapperImpl() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mPowerStatsHALWrapper != null) goto L8;
            this.mPowerStatsHALWrapper = PowerStatsHALWrapper.getPowerStatsHalImpl();     // Catch: Throwable -> L6
        L8:
            PowerStatsHALWrapper.IPowerStatsHALWrapper r0 = this.mPowerStatsHALWrapper;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        }

        PowerStatsLogger createPowerStatsLogger(Context context, Looper looper, File dataStoragePath, String meterFilename, String meterCacheFilename, String modelFilename, String modelCacheFilename, String residencyFilename, String residencyCacheFilename, PowerStatsHALWrapper.IPowerStatsHALWrapper powerStatsHALWrapper) {
            return new PowerStatsLogger(context, looper, dataStoragePath, meterFilename, meterCacheFilename, modelFilename, modelCacheFilename, residencyFilename, residencyCacheFilename, powerStatsHALWrapper);
        }

        BatteryTrigger createBatteryTrigger(Context context, PowerStatsLogger powerStatsLogger) {
            return new BatteryTrigger(context, powerStatsLogger, true);
        }

        TimerTrigger createTimerTrigger(Context context, PowerStatsLogger powerStatsLogger) {
            return new TimerTrigger(context, powerStatsLogger, true);
        }

        StatsPullAtomCallbackImpl createStatsPullerImpl(Context context, PowerStatsInternal powerStatsInternal) {
            return new StatsPullAtomCallbackImpl(context, powerStatsInternal);
        }

        DeviceConfigInterface getDeviceConfig() {
            return DeviceConfigInterface.REAL;
        }

        IntervalRandomNoiseGenerator createIntervalRandomNoiseGenerator() {
            return new IntervalRandomNoiseGenerator(PowerStatsService.INTERVAL_RANDOM_NOISE_GENERATION_ALPHA);
        }

        boolean checkFinePowerMonitorsPermission(Context context, int callingUid) {
            if (context.checkPermission("android.permission.ACCESS_FINE_POWER_MONITORS", -1, callingUid) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private final class LocalService extends PowerStatsInternal {
        final /* synthetic */ PowerStatsService this$0;

        public static /* synthetic */ void $r8$lambda$8lMkOnci_Kr8P27pH_iS_4p2VLc(LocalService r0, CompletableFuture r1, int[] r2) {
            r0.lambda$readEnergyMeterAsync$2(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$Jf7j_oHA5ZXXBvvutpd1qM7z0CY(LocalService r0, CompletableFuture r1, int[] r2) {
            r0.lambda$getStateResidencyAsync$1(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$sMX5PwUEnvq6B-BZqycTW8d1yDw, reason: not valid java name */
        public static /* synthetic */ void m7886$r8$lambda$sMX5PwUEnvq6BBZqycTW8d1yDw(LocalService r0, CompletableFuture r1, int[] r2) {
            r0.lambda$getEnergyConsumedAsync$0(r1, r2);
        }

        /* synthetic */ LocalService(PowerStatsService r1, PowerStatsServiceIA r2) {
            this(r1);
        }

        private LocalService(PowerStatsService r1) {
            this.this$0 = r1;
        }

        @Override // android.power.PowerStatsInternal
        public EnergyConsumer[] getEnergyConsumerInfo() {
            return PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getEnergyConsumerInfo();
        }

        @Override // android.power.PowerStatsInternal
        public CompletableFuture<EnergyConsumerResult[]> getEnergyConsumedAsync(final int[] energyConsumerIds) {
            final CompletableFuture<EnergyConsumerResult[]> future = new CompletableFuture();
            PowerStatsService.m7881$$Nest$mgetHandler(this.this$0).post(new PowerStatsService$LocalService$$ExternalSyntheticLambda0(this, future, energyConsumerIds));
            return future;
        }

        private /* synthetic */ void lambda$getEnergyConsumedAsync$0(CompletableFuture future, int[] energyConsumerIds) {
            PowerStatsService.m7880$$Nest$mgetEnergyConsumedAsync(this.this$0, future, energyConsumerIds);
        }

        @Override // android.power.PowerStatsInternal
        public PowerEntity[] getPowerEntityInfo() {
            return PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getPowerEntityInfo();
        }

        @Override // android.power.PowerStatsInternal
        public CompletableFuture<StateResidencyResult[]> getStateResidencyAsync(final int[] powerEntityIds) {
            final CompletableFuture<StateResidencyResult[]> future = new CompletableFuture();
            PowerStatsService.m7881$$Nest$mgetHandler(this.this$0).post(new PowerStatsService$LocalService$$ExternalSyntheticLambda2(this, future, powerEntityIds));
            return future;
        }

        private /* synthetic */ void lambda$getStateResidencyAsync$1(CompletableFuture future, int[] powerEntityIds) {
            PowerStatsService.m7883$$Nest$mgetStateResidencyAsync(this.this$0, future, powerEntityIds);
        }

        @Override // android.power.PowerStatsInternal
        public Channel[] getEnergyMeterInfo() {
            return PowerStatsService.m7882$$Nest$mgetPowerStatsHal(this.this$0).getEnergyMeterInfo();
        }

        @Override // android.power.PowerStatsInternal
        public CompletableFuture<EnergyMeasurement[]> readEnergyMeterAsync(final int[] channelIds) {
            final CompletableFuture<EnergyMeasurement[]> future = new CompletableFuture();
            PowerStatsService.m7881$$Nest$mgetHandler(this.this$0).post(new PowerStatsService$LocalService$$ExternalSyntheticLambda1(this, future, channelIds));
            return future;
        }

        private /* synthetic */ void lambda$readEnergyMeterAsync$2(CompletableFuture future, int[] channelIds) {
            PowerStatsService.m7884$$Nest$mreadEnergyMeterAsync(this.this$0, future, channelIds);
        }
    }

    private static class PowerMonitorState {
        public long energyUws;
        public final int id;
        public final PowerMonitor powerMonitor;
        public long prevEnergyUws;
        public long timestampMs;

        /* synthetic */ PowerMonitorState(PowerMonitor r1, int r2, PowerStatsServiceIA r3) {
            this(r1, r2);
        }

        private PowerMonitorState(PowerMonitor powerMonitor, int id) {
            this.energyUws = -1;
            this.powerMonitor = powerMonitor;
            this.id = id;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7877$$Nest$fgetmContext(PowerStatsService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceConfigInterface m7878$$Nest$fgetmDeviceConfig(PowerStatsService r0) {
        return r0.mDeviceConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerStatsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerStatsLogger m7879$$Nest$fgetmPowerStatsLogger(PowerStatsService r0) {
        return r0.mPowerStatsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetEnergyConsumedAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7880$$Nest$mgetEnergyConsumedAsync(PowerStatsService r0, CompletableFuture r1, int[] r2) {
        r0.getEnergyConsumedAsync(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7881$$Nest$mgetHandler(PowerStatsService r0) {
        return r0.getHandler();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPowerStatsHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerStatsHALWrapper.IPowerStatsHALWrapper m7882$$Nest$mgetPowerStatsHal(PowerStatsService r0) {
        return r0.getPowerStatsHal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStateResidencyAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7883$$Nest$mgetStateResidencyAsync(PowerStatsService r0, CompletableFuture r1, int[] r2) {
        r0.getStateResidencyAsync(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadEnergyMeterAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7884$$Nest$mreadEnergyMeterAsync(PowerStatsService r0, CompletableFuture r1, int[] r2) {
        r0.readEnergyMeterAsync(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7885$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = PowerStatsService.class.getSimpleName();
    }

    IPowerStatsService getIPowerStatsServiceForTest() {
        return this.mService;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        onSystemServicesReady();
        return;
    L6:
        if (phase != 1000) goto L10;
        onBootCompleted();
        return;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (getPowerStatsHal().isInitialized() == false) goto L5;
        publishLocalService(PowerStatsInternal.class, getPowerStatsInternal());
    L5:
        publishBinderService(DATA_STORAGE_SUBDIR, this.mService);
    }

    public PowerStatsInternal getPowerStatsInternal() {
        if (this.mPowerStatsInternal != null) goto L6;
        this.mPowerStatsInternal = new LocalService(this, null);
    L6:
        return this.mPowerStatsInternal;
    }

    private void onSystemServicesReady() {
        this.mPullAtomCallback = this.mInjector.createStatsPullerImpl(this.mContext, this.mPowerStatsInternal);
        this.mDeviceConfigListener.startListening();
        refreshFlags();
    }

    public boolean getDeleteMeterDataOnBoot() {
        return this.mPowerStatsLogger.getDeleteMeterDataOnBoot();
    }

    public boolean getDeleteModelDataOnBoot() {
        return this.mPowerStatsLogger.getDeleteModelDataOnBoot();
    }

    public boolean getDeleteResidencyDataOnBoot() {
        return this.mPowerStatsLogger.getDeleteResidencyDataOnBoot();
    }

    private void onBootCompleted() {
        if (getPowerStatsHal().isInitialized() == false) goto L5;
        this.mDataStoragePath = this.mInjector.createDataStoragePath();
        this.mPowerStatsLogger = this.mInjector.createPowerStatsLogger(this.mContext, getLooper(), this.mDataStoragePath, this.mInjector.createMeterFilename(), this.mInjector.createMeterCacheFilename(), this.mInjector.createModelFilename(), this.mInjector.createModelCacheFilename(), this.mInjector.createResidencyFilename(), this.mInjector.createResidencyCacheFilename(), getPowerStatsHal());
        this.mBatteryTrigger = this.mInjector.createBatteryTrigger(this.mContext, this.mPowerStatsLogger);
        this.mTimerTrigger = this.mInjector.createTimerTrigger(this.mContext, this.mPowerStatsLogger);
        return;
    L5:
        Slog.e(TAG, "Failed to start PowerStatsService loggers");
    }

    private PowerStatsHALWrapper.IPowerStatsHALWrapper getPowerStatsHal() {
        return this.mInjector.getPowerStatsHALWrapperImpl();
    }

    private Looper getLooper() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mLooper != null) goto L10;
        HandlerThread thread = new HandlerThread(TAG);     // Catch: Throwable -> L8
        thread.start();     // Catch: Throwable -> L8
        Looper r1 = thread.getLooper();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r1;
    L10:
        Looper r0 = this.mLooper;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    }

    private Handler getHandler() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandler != null) goto L8;
        this.mHandler = new Handler(getLooper());     // Catch: Throwable -> L6
    L8:
        Handler r0 = this.mHandler;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }

    private EnergyConsumer[] getEnergyConsumerInfo() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnergyConsumers != null) goto L8;
        this.mEnergyConsumers = getPowerStatsHal().getEnergyConsumerInfo();     // Catch: Throwable -> L6
    L8:
        EnergyConsumer[] r0 = this.mEnergyConsumers;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }

    private Channel[] getEnergyMeterInfo() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnergyMeters != null) goto L8;
        this.mEnergyMeters = getPowerStatsHal().getEnergyMeterInfo();     // Catch: Throwable -> L6
    L8:
        Channel[] r0 = this.mEnergyMeters;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }

    public PowerStatsService(Context context) {
        this(context, new Injector());
    }

    public PowerStatsService(Context context, Injector injector) {
        super(context);
        this.mDeviceConfigListener = new DeviceConfigListener(this, null);
        this.mEnergyConsumers = null;
        this.mEnergyMeters = null;
        this.mService = new AnonymousClass1(this);
        this.mPowerMonitorApiEnabled = true;
        this.mContext = context;
        this.mInjector = injector;
        this.mClock = injector.getClock();
        this.mDeviceConfig = injector.getDeviceConfig();
    }

    void refreshFlags() {
        setPowerMonitorApiEnabled(this.mDeviceConfig.getBoolean("battery_stats", KEY_POWER_MONITOR_API_ENABLED, true));
    }

    private void getEnergyConsumedAsync(CompletableFuture<EnergyConsumerResult[]> future, int[] energyConsumerIds) {
        EnergyConsumerResult[] results = getPowerStatsHal().getEnergyConsumed(energyConsumerIds);     // Catch: Exception -> L36
        EnergyConsumer[] energyConsumers = getEnergyConsumerInfo();
        if (energyConsumers != null) goto L7;
    L34:
        future.complete(results);
        return;
    L7:
        if (energyConsumerIds.length != 0) goto L9;
        int expectedLength = energyConsumers.length;
    L10:
        if (results != null) goto L12;
    L13:
        StringBuilder sb = new StringBuilder();
        sb.append("Requested ids:");
        if (energyConsumerIds.length != 0) goto L16;
        sb.append("ALL");
    L16:
        sb.append("[");
        int i = 0;
    L18:
        if (i >= energyConsumerIds.length) goto L23;
        int id = energyConsumerIds[i];
        sb.append(id);
        sb.append("(type:");
        sb.append(energyConsumers[id].type);
        sb.append(",ord:");
        sb.append(energyConsumers[id].ordinal);
        sb.append(",name:");
        sb.append(energyConsumers[id].name);
        sb.append(")");
        if (i == (expectedLength - 1)) goto L22;
        sb.append(", ");
    L22:
        i = i + 1;
        goto L18
    L23:
        sb.append("]");
        sb.append(", Received result ids:");
        if (results != null) goto L26;
        sb.append("null");
    L33:
        Slog.wtf(TAG, "Missing result from getEnergyConsumedAsync call. " + sb);
        goto L34
    L26:
        sb.append("[");
        int resultLength = results.length;
        int i2 = 0;
    L27:
        if (i2 >= resultLength) goto L32;
        int id2 = results[i2].id;
        sb.append(id2);
        sb.append("(type:");
        sb.append(energyConsumers[id2].type);
        sb.append(",ord:");
        sb.append(energyConsumers[id2].ordinal);
        sb.append(",name:");
        sb.append(energyConsumers[id2].name);
        sb.append(")");
        if (i2 == (resultLength - 1)) goto L31;
        sb.append(", ");
    L31:
        i2 = i2 + 1;
        goto L27
    L32:
        sb.append("]");
        goto L33
    L12:
        if (expectedLength == results.length) goto L34;
    L9:
        expectedLength = energyConsumerIds.length;
    L36:
        e = move-exception;
        future.completeExceptionally(e);
    }

    private void getStateResidencyAsync(CompletableFuture<StateResidencyResult[]> future, int[] powerEntityIds) {
        future.complete(getPowerStatsHal().getStateResidency(powerEntityIds));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        future.completeExceptionally(e);
    }

    private void readEnergyMeterAsync(CompletableFuture<EnergyMeasurement[]> future, int[] channelIds) {
        future.complete(getPowerStatsHal().readEnergyMeter(channelIds));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        future.completeExceptionally(e);
    }

    private void setPowerMonitorApiEnabled(boolean powerMonitorApiEnabled) {
        if (powerMonitorApiEnabled == this.mPowerMonitorApiEnabled) goto L6;
        this.mPowerMonitorApiEnabled = powerMonitorApiEnabled;
        this.mPowerMonitors = null;
        this.mPowerMonitorStates = null;
        this.mFinePowerMonitorStates = null;
        return;
    }

    private void ensurePowerMonitors() {
        if (this.mPowerMonitors == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mPowerMonitors == null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.mIntervalRandomNoiseGenerator != null) goto L16;
        this.mIntervalRandomNoiseGenerator = this.mInjector.createIntervalRandomNoiseGenerator();     // Catch: Throwable -> L10
    L16:
        if (this.mPowerMonitorApiEnabled == true) goto L20;
        this.mPowerMonitors = new PowerMonitor[0];     // Catch: Throwable -> L10
        this.mPowerMonitorStates = new PowerMonitorState[0];     // Catch: Throwable -> L10
        this.mFinePowerMonitorStates = new PowerMonitorState[0];     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        List<PowerMonitor> monitors = new ArrayList();     // Catch: Throwable -> L10
        List<PowerMonitorState> states = new ArrayList();     // Catch: Throwable -> L10
        int index = 0;
        Channel[] channels = getEnergyMeterInfo();     // Catch: Throwable -> L10
        PowerStatsServiceIA r5 = null;
        if (channels == null) goto L25;
        int r6 = channels.length;     // Catch: Throwable -> L10
        int r7 = 0;
    L23:
        if (r7 >= r6) goto L25;
        Channel channel = channels[r7];     // Catch: Throwable -> L10
        PowerMonitor monitor = new PowerMonitor(index, 1, getChannelName(channel));     // Catch: Throwable -> L10
        monitors.add(monitor);     // Catch: Throwable -> L10
        states.add(new PowerMonitorState(monitor, channel.id, r5));     // Catch: Throwable -> L10
        r7 = r7 + 1;     // Catch: Throwable -> L10
        index = index + 1;     // Catch: Throwable -> L10
    L25:
        EnergyConsumer[] energyConsumers = getEnergyConsumerInfo();     // Catch: Throwable -> L10
        if (energyConsumers == null) goto L30;
        int r8 = energyConsumers.length;     // Catch: Throwable -> L10
        int r9 = 0;
    L28:
        if (r9 >= r8) goto L30;
        EnergyConsumer consumer = energyConsumers[r9];     // Catch: Throwable -> L10
        PowerMonitor monitor2 = new PowerMonitor(index, 0, getEnergyConsumerName(consumer, energyConsumers));     // Catch: Throwable -> L10
        monitors.add(monitor2);     // Catch: Throwable -> L10
        states.add(new PowerMonitorState(monitor2, consumer.id, r5));     // Catch: Throwable -> L10
        r9 = r9 + 1;     // Catch: Throwable -> L10
        index = index + 1;     // Catch: Throwable -> L10
    L30:
        this.mPowerMonitors = (PowerMonitor[]) monitors.toArray(new PowerMonitor[monitors.size()]);     // Catch: Throwable -> L10
        this.mPowerMonitorStates = (PowerMonitorState[]) states.toArray(new PowerMonitorState[monitors.size()]);     // Catch: Throwable -> L10
        this.mFinePowerMonitorStates = (PowerMonitorState[]) states.toArray(new PowerMonitorState[monitors.size()]);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    private String getChannelName(Channel c) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(c.name);
        sb.append("]:");
        if (c.subsystem == null) goto L6;
        sb.append(c.subsystem);
    L6:
        return sb.toString();
    }

    private String getEnergyConsumerName(EnergyConsumer consumer, EnergyConsumer[] energyConsumers) {
        StringBuilder sb = new StringBuilder();
        switch(consumer.type) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L5;
        };
    L10:
        sb.append("CAMERA");
    L17:
        int r2 = 0;
        if (consumer.ordinal == 0) goto L20;
        boolean hasOrdinal = true;
    L21:
        if (hasOrdinal == true) goto L31;
        int r3 = energyConsumers.length;
    L24:
        if (r2 >= r3) goto L31;
        EnergyConsumer aConsumer = energyConsumers[r2];
        if (aConsumer.type != consumer.type) goto L30;
        if (aConsumer.ordinal == 0) goto L30;
        hasOrdinal = true;
    L30:
        r2 = r2 + 1;
    L31:
        if (hasOrdinal == false) goto L34;
        sb.append('/');
        sb.append(consumer.ordinal);
    L34:
        return sb.toString();
    L20:
        hasOrdinal = false;
        goto L21
    L11:
        sb.append("WIFI");
        goto L17
    L12:
        sb.append("MOBILE_RADIO");
        goto L17
    L13:
        sb.append("GNSS");
        goto L17
    L14:
        sb.append(SensorData.TEMPERATURE_TYPE_DISPLAY);
        goto L17
    L15:
        sb.append("CPU");
        goto L17
    L16:
        sb.append("BLUETOOTH");
        goto L17
    L5:
        if (consumer.name != null) goto L7;
    L9:
        sb.append("CONSUMER_");
        sb.append(consumer.type);
        goto L17
    L7:
        if (consumer.name.isBlank() == true) goto L9;
        sb.append(consumer.name.toUpperCase(Locale.ENGLISH));
        goto L17
    }

    public void getSupportedPowerMonitorsImpl(ResultReceiver resultReceiver) {
        ensurePowerMonitors();
        Bundle result = new Bundle();
        result.putParcelableArray("monitors", this.mPowerMonitors);
        resultReceiver.send(0, result);
    }

    public void getPowerMonitorReadingsImpl(int[] powerMonitorIndices, ResultReceiver resultReceiver, int callingUid) {
        PowerStatsService r0 = this;
        r0.ensurePowerMonitors();
        int r10 = callingUid;
        if (r0.mInjector.checkFinePowerMonitorsPermission(r0.mContext, r10) == false) goto L5;
        int granularity = 1;
    L7:
        if (granularity != 1) goto L9;
        PowerMonitorState[] allPowerMonitorStates = r0.mFinePowerMonitorStates;
        PowerMonitorState[] allPowerMonitorStates2 = allPowerMonitorStates;
        long maxAge = 250;
    L10:
        PowerMonitorState[] powerMonitorStates = new PowerMonitorState[powerMonitorIndices.length];
        int i = 0;
        long earliestTimestamp = Long.MAX_VALUE;
    L12:
        if (i >= powerMonitorIndices.length) goto L27;
        int index = powerMonitorIndices[i];
        if (index < 0) goto L24;
        if (index >= allPowerMonitorStates2.length) goto L24;
        powerMonitorStates[i] = allPowerMonitorStates2[index];
        if (allPowerMonitorStates2[index] == null) goto L23;
        if (allPowerMonitorStates2[index].timestampMs >= earliestTimestamp) goto L23;
        earliestTimestamp = allPowerMonitorStates2[index].timestampMs;
    L23:
        i = i + 1;
    L24:
        resultReceiver.send(1, null);
        return;
    L27:
        if (earliestTimestamp != 0) goto L29;
    L30:
        r0.updateEnergyConsumers(powerMonitorStates);
        r0.updateEnergyMeasurements(powerMonitorStates);
        r0.mIntervalRandomNoiseGenerator.refresh();
    L31:
        long[] energy = new long[powerMonitorStates.length];
        long[] timestamps = new long[powerMonitorStates.length];
        int i2 = 0;
    L33:
        if (i2 >= powerMonitorStates.length) goto L41;
        PowerMonitorState state = powerMonitorStates[i2];
        if (state.energyUws != (-1)) goto L37;
    L39:
        long[] timestamps2 = timestamps;
        int i3 = i2;
        PowerMonitorState state2 = state;
        energy[i3] = state2.energyUws;
    L40:
        timestamps2[i3] = state2.timestampMs;
        i2 = i3 + 1;
        r10 = callingUid;
        timestamps = timestamps2;
        r0 = this;
        goto L33
    L37:
        if (state.prevEnergyUws == (-1)) goto L39;
        timestamps2 = timestamps;
        state2 = state;
        i3 = i2;
        energy[i3] = r0.mIntervalRandomNoiseGenerator.addNoise(Math.max(state.prevEnergyUws, state.energyUws - MAX_RANDOM_NOISE_UWS), state.energyUws, r10);
        goto L40
    L41:
        Bundle result = new Bundle();
        result.putLongArray("energy", energy);
        result.putLongArray("timestamps", timestamps);
        result.putInt("granularity", granularity);
        resultReceiver.send(0, result);
        return;
    L29:
        if ((r0.mClock.elapsedRealtime() - earliestTimestamp) <= maxAge) goto L31;
    L9:
        PowerMonitorState[] allPowerMonitorStates3 = r0.mPowerMonitorStates;
        allPowerMonitorStates2 = allPowerMonitorStates3;
        maxAge = 20000;
        goto L10
    L5:
        granularity = 0;
        goto L7
    }

    private void updateEnergyConsumers(PowerMonitorState[] powerMonitorStates) {
        int[] ids = collectIds(powerMonitorStates, 0);
        if (ids != null) goto L5;
        return;
    L5:
        EnergyConsumerResult[] energyConsumerResults = getPowerStatsHal().getEnergyConsumed(ids);
        if (energyConsumerResults != null) goto L8;
        return;
    L8:
        int r3 = powerMonitorStates.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L20;
        PowerMonitorState powerMonitorState = powerMonitorStates[r4];
        if (powerMonitorState.powerMonitor.getType() != 0) goto L19;
        int r6 = energyConsumerResults.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L19;
        EnergyConsumerResult energyConsumerResult = energyConsumerResults[r7];
        if (energyConsumerResult.id == powerMonitorState.id) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        powerMonitorState.prevEnergyUws = powerMonitorState.energyUws;
        powerMonitorState.energyUws = energyConsumerResult.energyUWs;
        powerMonitorState.timestampMs = energyConsumerResult.timestampMs;
    L19:
        r4 = r4 + 1;
        goto L9
    }

    private void updateEnergyMeasurements(PowerMonitorState[] powerMonitorStates) {
        int[] ids = collectIds(powerMonitorStates, 1);
        if (ids != null) goto L5;
        return;
    L5:
        EnergyMeasurement[] energyMeasurements = getPowerStatsHal().readEnergyMeter(ids);
        if (energyMeasurements != null) goto L8;
        return;
    L8:
        int r3 = powerMonitorStates.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L20;
        PowerMonitorState powerMonitorState = powerMonitorStates[r5];
        if (powerMonitorState.powerMonitor.getType() != 1) goto L19;
        int r7 = energyMeasurements.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L19;
        EnergyMeasurement energyMeasurement = energyMeasurements[r8];
        if (energyMeasurement.id == powerMonitorState.id) goto L17;
        r8 = r8 + 1;
        goto L14
    L17:
        powerMonitorState.prevEnergyUws = powerMonitorState.energyUws;
        powerMonitorState.energyUws = energyMeasurement.energyUWs;
        powerMonitorState.timestampMs = energyMeasurement.timestampMs;
    L19:
        r5 = r5 + 1;
        goto L9
    }

    private int[] collectIds(PowerMonitorState[] powerMonitorStates, int type) {
        int count = 0;
        int r1 = powerMonitorStates.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (powerMonitorStates[r3].powerMonitor.getType() != type) goto L7;
        count = count + 1;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        if (count != 0) goto L11;
        return null;
    L11:
        int[] ids = new int[count];
        int index = 0;
        int r4 = powerMonitorStates.length;
    L12:
        if (r2 >= r4) goto L17;
        PowerMonitorState monitorState = powerMonitorStates[r2];
        if (monitorState.powerMonitor.getType() != type) goto L16;
        ids[index] = monitorState.id;
        index = index + 1;
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        return ids;
    }
}
