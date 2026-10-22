package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Temperature;
import android.provider.DeviceConfigInterface;
import android.util.Slog;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.display.utils.DeviceConfigParsingUtils;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class BrightnessPowerModifier implements BrightnessStateModifier, BrightnessClamperController.DisplayDeviceDataListener, BrightnessClamperController.StatefulModifier, BrightnessClamperController.DeviceConfigListener {
    private static final String TAG = "BrightnessPowerClamper";
    private boolean mApplied;
    private float mBrightnessCap;
    protected final BrightnessClamperController.ClamperChangeListener mChangeListener;
    private final DeviceConfigParameterProvider mConfigParameterProvider;
    private float mCurrentAvgPowerConsumed;
    private float mCurrentBrightness;
    private int mCurrentThermalLevel;
    private boolean mCurrentThermalLevelChanged;
    private float mCustomAnimationRateDeviceConfig;
    private float mCustomAnimationRateSec;
    private String mDataId;
    private final BiFunction<String, String, DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel> mDataPointMapper;
    private final Function<List<DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel>, DisplayDeviceConfig.PowerThrottlingData> mDataSetMapper;
    protected final Handler mHandler;
    private final PmicMonitor mPmicMonitor;
    private DisplayDeviceConfig.PowerThrottlingConfigData mPowerThrottlingConfigData;
    private DisplayDeviceConfig.PowerThrottlingData mPowerThrottlingDataActive;
    private DisplayDeviceConfig.PowerThrottlingData mPowerThrottlingDataFromDDC;
    private Map<String, Map<String, DisplayDeviceConfig.PowerThrottlingData>> mPowerThrottlingDataOverride;
    private final ThermalLevelListener mThermalLevelListener;
    private String mUniqueDisplayId;

    static class Injector {
        Injector() {
        }

        PmicMonitor getPmicMonitor(PowerChangeListener powerChangeListener, IThermalService thermalService, int pollingMaxTimeMillis, int pollingMinTimeMillis) {
            return new PmicMonitor(powerChangeListener, thermalService, pollingMaxTimeMillis, pollingMinTimeMillis);
        }

        DeviceConfigParameterProvider getDeviceConfigParameterProvider() {
            return new DeviceConfigParameterProvider(DeviceConfigInterface.REAL);
        }
    }

    @FunctionalInterface
    public interface PowerChangeListener {
        void onChanged(float r1, int r2);
    }

    public interface PowerData {
        DisplayDeviceConfig.PowerThrottlingConfigData getPowerThrottlingConfigData();

        DisplayDeviceConfig.PowerThrottlingData getPowerThrottlingData();

        String getPowerThrottlingDataId();

        String getUniqueDisplayId();
    }

    private final class ThermalLevelListener extends IThermalEventListener.Stub {
        private final Handler mHandler;
        private boolean mStarted;
        private IThermalService mThermalService;
        final /* synthetic */ BrightnessPowerModifier this$0;

        /* JADX INFO: renamed from: $r8$lambda$20aF-SPGVM6H1027Ons6vT4GPus, reason: not valid java name */
        public static /* synthetic */ void m3991$r8$lambda$20aFSPGVM6H1027Ons6vT4GPus(BrightnessPowerModifier r0) {
            BrightnessPowerModifier.m3989$$Nest$mactivatePmicMonitor(r0);
        }

        public static /* synthetic */ void $r8$lambda$ubnOdYg7n4fcHPzKnKW852Cva3Y(ThermalLevelListener r0, int r1) {
            r0.lambda$notifyThrottling$0(r1);
        }

        ThermalLevelListener(BrightnessPowerModifier r1, Handler handler) {
            this.this$0 = r1;
            this.mHandler = handler;
            this.mStarted = false;
            this.mThermalService = IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        }

        IThermalService getThermalService() {
            return this.mThermalService;
        }

        void start() {
            if (this.mStarted == false) goto L6;
            return;
        L6:
            if (this.mThermalService != null) goto L13;
            return;
        L13:
            this.mThermalService.registerThermalEventListenerWithType(this, 3);     // Catch: RemoteException -> L10
            this.mStarted = true;     // Catch: RemoteException -> L10
            return;
        L10:
            e = move-exception;
            Slog.e(BrightnessPowerModifier.TAG, "Failed to register thermal status listener", e);
        }

        public void notifyThrottling(Temperature temp) {
            final int status = temp.getStatus();
            if (status < 1) goto L6;
            Slog.d(BrightnessPowerModifier.TAG, "Activating pmic monitor due to thermal state:" + status);
            Handler r1 = this.mHandler;
            final BrightnessPowerModifier r2 = this.this$0;
            r1.post(new BrightnessPowerModifier$ThermalLevelListener$$ExternalSyntheticLambda0(r2));
            return;
        L6:
            if (BrightnessPowerModifier.m3988$$Nest$fgetmPmicMonitor(this.this$0).isStopped() == true) goto L10;
            this.mHandler.post(new BrightnessPowerModifier$ThermalLevelListener$$ExternalSyntheticLambda1(this, status));
            return;
        }

        private /* synthetic */ void lambda$notifyThrottling$0(int status) {
            BrightnessPowerModifier.m3990$$Nest$mdeactivatePmicMonitor(this.this$0, status);
        }

        void stop() {
            if (this.mStarted == true) goto L11;
            return;
        L11:
            this.mThermalService.unregisterThermalEventListener(this);     // Catch: RemoteException -> L7
            this.mStarted = false;     // Catch: RemoteException -> L7
        L9:
            this.mThermalService = null;
            return;
        L7:
            e = move-exception;
            Slog.e(BrightnessPowerModifier.TAG, "Failed to unregister thermal status listener", e);
            goto L9
        }

        void dump(PrintWriter writer) {
            writer.println("  ThermalLevelObserver:");
            writer.println("    mStarted: " + this.mStarted);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3qJfZiNExghXhIpE-_DN4Ds7e-Q, reason: not valid java name */
    public static /* synthetic */ void m3985$r8$lambda$3qJfZiNExghXhIpE_DN4Ds7eQ(BrightnessPowerModifier r0, PowerData r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5LoNAxwgtcr-skeyF7JY58bnPrw, reason: not valid java name */
    public static /* synthetic */ void m3986$r8$lambda$5LoNAxwgtcrskeyF7JY58bnPrw(BrightnessPowerModifier r0, int r1, float r2) {
        r0.lambda$recalculatePowerQuotaChange$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_AAgBRrrOtfefLzj8CVwCZZrEUw(BrightnessPowerModifier r0, BrightnessClamperController.DisplayDeviceData r1) {
        r0.lambda$onDisplayChanged$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$eVUF0eCk5S6mSL1T-GhaCp5fFYg, reason: not valid java name */
    public static /* synthetic */ void m3987$r8$lambda$eVUF0eCk5S6mSL1TGhaCp5fFYg(BrightnessPowerModifier r0) {
        r0.lambda$onDeviceConfigChanged$3();
    }

    public static /* synthetic */ void $r8$lambda$gSxzfeLlhiZZGgaI9xdvxU5NJEI(BrightnessPowerModifier r0, float r1, int r2) {
        r0.recalculatePowerQuotaChange(r1, r2);
    }

    public static /* synthetic */ DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel $r8$lambda$vaRpUl_duR6a_KEwqYhW64Mf9AA(String r0, String r1) {
        return lambda$new$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPmicMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ PmicMonitor m3988$$Nest$fgetmPmicMonitor(BrightnessPowerModifier r0) {
        return r0.mPmicMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$mactivatePmicMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3989$$Nest$mactivatePmicMonitor(BrightnessPowerModifier r0) {
        r0.activatePmicMonitor();
    }

    /* JADX INFO: renamed from: -$$Nest$mdeactivatePmicMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3990$$Nest$mdeactivatePmicMonitor(BrightnessPowerModifier r0, int r1) {
        r0.deactivatePmicMonitor(r1);
    }

    private static /* synthetic */ DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel lambda$new$0(String key, String value) {
        int status = DeviceConfigParsingUtils.parseThermalStatus(key);     // Catch: IllegalArgumentException -> L4
        float powerQuota = Float.parseFloat(value);     // Catch: IllegalArgumentException -> L4
        return new DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel(status, powerQuota);
    L5:
        return null;
    }

    BrightnessPowerModifier(Handler handler, BrightnessClamperController.ClamperChangeListener listener, PowerData powerData, float currentBrightness) {
        this(new Injector(), handler, listener, powerData, currentBrightness);
    }

    BrightnessPowerModifier(Injector injector, Handler handler, BrightnessClamperController.ClamperChangeListener listener, final PowerData powerData, float currentBrightness) {
        this.mPowerThrottlingDataOverride = Map.of();
        this.mPowerThrottlingDataFromDDC = null;
        this.mPowerThrottlingDataActive = null;
        this.mCurrentThermalLevel = 0;
        this.mCurrentThermalLevelChanged = false;
        this.mCurrentAvgPowerConsumed = 0.0f;
        this.mUniqueDisplayId = null;
        this.mDataId = null;
        this.mCurrentBrightness = -1.0f;
        this.mCustomAnimationRateSec = -1.0f;
        this.mCustomAnimationRateDeviceConfig = -1.0f;
        this.mDataPointMapper = new BrightnessPowerModifier$$ExternalSyntheticLambda3();
        this.mDataSetMapper = new BrightnessPowerModifier$$ExternalSyntheticLambda4();
        this.mBrightnessCap = 1.0f;
        this.mApplied = false;
        this.mHandler = handler;
        this.mChangeListener = listener;
        this.mCurrentBrightness = currentBrightness;
        this.mPowerThrottlingConfigData = powerData.getPowerThrottlingConfigData();
        if (this.mPowerThrottlingConfigData == null) goto L5;
        this.mCustomAnimationRateDeviceConfig = this.mPowerThrottlingConfigData.customAnimationRate;
    L5:
        this.mThermalLevelListener = new ThermalLevelListener(this, handler);
        this.mPmicMonitor = injector.getPmicMonitor(new BrightnessPowerModifier$$ExternalSyntheticLambda5(this), this.mThermalLevelListener.getThermalService(), this.mPowerThrottlingConfigData.pollingWindowMaxMillis, this.mPowerThrottlingConfigData.pollingWindowMinMillis);
        this.mConfigParameterProvider = injector.getDeviceConfigParameterProvider();
        this.mHandler.post(new BrightnessPowerModifier$$ExternalSyntheticLambda6(this, powerData));
    }

    private /* synthetic */ void lambda$new$1(PowerData powerData) {
        setDisplayData(powerData);
        loadOverrideData();
        start();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        if (stateBuilder.getMaxBrightness() <= this.mBrightnessCap) goto L8;
        stateBuilder.setMaxBrightness(this.mBrightnessCap);
        stateBuilder.setBrightness(Math.min(stateBuilder.getBrightness(), this.mBrightnessCap));
        stateBuilder.setBrightnessMaxReason(2);
        stateBuilder.getBrightnessReason().addModifier(8);
        if (this.mApplied == true) goto L7;
        stateBuilder.setCustomAnimationRate(this.mCustomAnimationRateSec);
        this.mCustomAnimationRateSec = -1.0f;
    L7:
        this.mApplied = true;
    L9:
        this.mCurrentBrightness = stateBuilder.getBrightness();
        return;
    L8:
        this.mApplied = false;
        goto L9
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
        this.mPmicMonitor.shutdown();
        this.mThermalLevelListener.stop();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("BrightnessPowerClamper:");
        pw.println("  mCurrentAvgPowerConsumed=" + this.mCurrentAvgPowerConsumed);
        pw.println("  mUniqueDisplayId=" + this.mUniqueDisplayId);
        pw.println("  mCurrentThermalLevel=" + this.mCurrentThermalLevel);
        pw.println("  mCurrentThermalLevelChanged=" + this.mCurrentThermalLevelChanged);
        StringBuilder r0 = new StringBuilder();
        r0.append("  mPowerThrottlingDataFromDDC=");
        if (this.mPowerThrottlingDataFromDDC != null) goto L5;
        String r1 = "null";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("  mBrightnessCap: " + this.mBrightnessCap);
        pw.println("  mApplied: " + this.mApplied);
        this.mThermalLevelListener.dump(pw);
        return;
    L5:
        r1 = this.mPowerThrottlingDataFromDDC.toString();
        goto L6
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public boolean shouldListenToLightSensor() {
        return false;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void setAmbientLux(float lux) {
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.DisplayDeviceDataListener
    public void onDisplayChanged(final BrightnessClamperController.DisplayDeviceData data) {
        this.mHandler.post(new BrightnessPowerModifier$$ExternalSyntheticLambda1(this, data));
    }

    private /* synthetic */ void lambda$onDisplayChanged$2(BrightnessClamperController.DisplayDeviceData data) {
        setDisplayData(data);
        recalculateActiveData();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.StatefulModifier
    public void applyStateChange(BrightnessClamperController.ModifiersAggregatedState aggregatedState) {
        if (aggregatedState.mMaxBrightness <= this.mBrightnessCap) goto L6;
        aggregatedState.mMaxBrightness = this.mBrightnessCap;
        aggregatedState.mMaxBrightnessReason = 2;
        return;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.DeviceConfigListener
    public void onDeviceConfigChanged() {
        this.mHandler.post(new BrightnessPowerModifier$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$onDeviceConfigChanged$3() {
        loadOverrideData();
        recalculateActiveData();
    }

    private void recalculateActiveData() {
        if (this.mUniqueDisplayId != null) goto L5;
        return;
    L5:
        if (this.mDataId == null) goto L13;
        this.mPowerThrottlingDataActive = this.mPowerThrottlingDataOverride.getOrDefault(this.mUniqueDisplayId, Map.of()).getOrDefault(this.mDataId, this.mPowerThrottlingDataFromDDC);
        if (this.mPowerThrottlingDataActive != null) goto L12;
        this.mPmicMonitor.stop();
        return;
    L12:
        return;
    }

    private void loadOverrideData() {
        String throttlingDataOverride = this.mConfigParameterProvider.getPowerThrottlingData();
        this.mPowerThrottlingDataOverride = DeviceConfigParsingUtils.parseDeviceConfigMap(throttlingDataOverride, this.mDataPointMapper, this.mDataSetMapper);
    }

    private void setDisplayData(PowerData data) {
        this.mUniqueDisplayId = data.getUniqueDisplayId();
        this.mDataId = data.getPowerThrottlingDataId();
        this.mPowerThrottlingDataFromDDC = data.getPowerThrottlingData();
        if (this.mPowerThrottlingDataFromDDC == null) goto L5;
    L7:
        this.mPowerThrottlingConfigData = data.getPowerThrottlingConfigData();
        return;
    L5:
        if ("default".equals(this.mDataId) == true) goto L7;
        Slog.wtf(TAG, "Power throttling data is missing for powerThrottlingDataId=" + this.mDataId);
        goto L7
    }

    private void recalculateBrightnessCap() {
        float targetBrightnessCap = 1.0f;
        float powerQuota = getPowerQuotaForThermalStatus(this.mCurrentThermalLevel);
        if (this.mPowerThrottlingDataActive != null) goto L6;
        return;
    L6:
        if (powerQuota <= 0.0f) goto L22;
        if (BrightnessUtils.isValidBrightnessValue(this.mCurrentBrightness) == false) goto L13;
        if (this.mCurrentAvgPowerConsumed <= powerQuota) goto L13;
        targetBrightnessCap = (powerQuota / this.mCurrentAvgPowerConsumed) * this.mCurrentBrightness;
    L13:
        if (this.mCurrentThermalLevelChanged == true) goto L15;
        targetBrightnessCap = 1.0f;
        goto L22
    L15:
        if (this.mCurrentThermalLevel != 0) goto L17;
        targetBrightnessCap = 1.0f;
        this.mPmicMonitor.stop();
        goto L22
    L17:
        targetBrightnessCap = 1.0f;
        if (this.mPmicMonitor.isStopped() == false) goto L22;
        this.mPmicMonitor.start();
    L22:
        if (this.mPowerThrottlingConfigData == null) goto L25;
        targetBrightnessCap = Math.max(targetBrightnessCap, this.mPowerThrottlingConfigData.brightnessLowestCapAllowed);
    L25:
        if (this.mBrightnessCap == targetBrightnessCap) goto L27;
        Slog.i(TAG, "Power clamper changing current brightness cap mBrightnessCap: " + this.mBrightnessCap + " to target brightness cap:" + targetBrightnessCap + " for current screen brightness: " + this.mCurrentBrightness + "\nPower clamper changed state: thermalStatus:" + this.mCurrentThermalLevel + " mCurrentThermalLevelChanged:" + this.mCurrentThermalLevelChanged + " mCurrentAvgPowerConsumed:" + this.mCurrentAvgPowerConsumed + " mCustomAnimationRateSec:" + this.mCustomAnimationRateDeviceConfig);
        this.mBrightnessCap = targetBrightnessCap;
        this.mCustomAnimationRateSec = this.mCustomAnimationRateDeviceConfig;
        this.mChangeListener.onChanged();
        return;
    L27:
        this.mCustomAnimationRateSec = -1.0f;
    }

    private float getPowerQuotaForThermalStatus(int thermalStatus) {
        float powerQuota = 0.0f;
        if (this.mPowerThrottlingDataActive == null) goto L10;
        Iterator<DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel> r1 = this.mPowerThrottlingDataActive.throttlingLevels.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        DisplayDeviceConfig.PowerThrottlingData.ThrottlingLevel level = r1.next();
        if (level.thermalStatus > thermalStatus) goto L10;
        powerQuota = level.powerQuotaMilliWatts;
    L10:
        return powerQuota;
    }

    private void recalculatePowerQuotaChange(final float avgPowerConsumed, final int thermalStatus) {
        this.mHandler.post(new BrightnessPowerModifier$$ExternalSyntheticLambda0(this, thermalStatus, avgPowerConsumed));
    }

    private /* synthetic */ void lambda$recalculatePowerQuotaChange$4(int thermalStatus, float avgPowerConsumed) {
        if (this.mCurrentThermalLevel == thermalStatus) goto L5;
        boolean r0 = true;
    L6:
        this.mCurrentThermalLevelChanged = r0;
        this.mCurrentThermalLevel = thermalStatus;
        this.mCurrentAvgPowerConsumed = avgPowerConsumed;
        recalculateBrightnessCap();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void start() {
        if (this.mPowerThrottlingConfigData != null) goto L6;
        return;
    L6:
        if (this.mPowerThrottlingConfigData.pollingWindowMaxMillis > this.mPowerThrottlingConfigData.pollingWindowMinMillis) goto L10;
        Slog.e(TAG, "Brightness power max polling window:" + this.mPowerThrottlingConfigData.pollingWindowMaxMillis + " msec, should be greater than brightness min polling window:" + this.mPowerThrottlingConfigData.pollingWindowMinMillis + " msec.");
        return;
    L10:
        if ((this.mPowerThrottlingConfigData.pollingWindowMaxMillis % this.mPowerThrottlingConfigData.pollingWindowMinMillis) == 0) goto L13;
        Slog.e(TAG, "Brightness power max polling window:" + this.mPowerThrottlingConfigData.pollingWindowMaxMillis + " msec, is not divisible by brightness min polling window:" + this.mPowerThrottlingConfigData.pollingWindowMinMillis + " msec.");
        return;
    L13:
        this.mCustomAnimationRateDeviceConfig = this.mPowerThrottlingConfigData.customAnimationRate;
        this.mThermalLevelListener.start();
    }

    private void activatePmicMonitor() {
        if (this.mPmicMonitor.isStopped() == true) goto L5;
        return;
    L5:
        this.mPmicMonitor.start();
    }

    private void deactivatePmicMonitor(int status) {
        if (status == 0) goto L5;
        return;
    L5:
        if (this.mPmicMonitor.isStopped() == false) goto L7;
        return;
    L7:
        this.mPmicMonitor.stop();
    }
}
