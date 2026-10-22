package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Temperature;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfigInterface;
import android.util.Slog;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.config.SensorData;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.display.utils.DeviceConfigParsingUtils;
import com.android.server.display.utils.SensorUtils;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class BrightnessThermalModifier implements BrightnessStateModifier, BrightnessClamperController.DisplayDeviceDataListener, BrightnessClamperController.StatefulModifier, BrightnessClamperController.DeviceConfigListener {
    private static final String TAG = "BrightnessThermalClamper";
    private boolean mApplied;
    private float mBrightnessCap;
    protected final BrightnessClamperController.ClamperChangeListener mChangeListener;
    private final DeviceConfigParameterProvider mConfigParameterProvider;
    private String mDataId;
    private final BiFunction<String, String, DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel> mDataPointMapper;
    private final Function<List<DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel>, DisplayDeviceConfig.ThermalBrightnessThrottlingData> mDataSetMapper;
    private IExtBrightnessThermalModifier mExt;
    protected final Handler mHandler;
    private final ThermalStatusObserver mThermalStatusObserver;
    private DisplayDeviceConfig.ThermalBrightnessThrottlingData mThermalThrottlingDataActive;
    private DisplayDeviceConfig.ThermalBrightnessThrottlingData mThermalThrottlingDataFromDeviceConfig;
    private Map<String, Map<String, DisplayDeviceConfig.ThermalBrightnessThrottlingData>> mThermalThrottlingDataOverride;
    private int mThrottlingStatus;
    private String mUniqueDisplayId;

    static class Injector {
        Injector() {
        }

        IThermalService getThermalService() {
            return IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        }

        DeviceConfigParameterProvider getDeviceConfigParameterProvider() {
            return new DeviceConfigParameterProvider(DeviceConfigInterface.REAL);
        }
    }

    interface ThermalData {
        SensorData getTempSensor();

        DisplayDeviceConfig.ThermalBrightnessThrottlingData getThermalBrightnessThrottlingData();

        String getThermalThrottlingDataId();

        String getUniqueDisplayId();
    }

    private final class ThermalStatusObserver extends IThermalEventListener.Stub {
        private final Handler mHandler;
        private final Injector mInjector;
        private SensorData mObserverTempSensor;
        private boolean mStarted;
        private IThermalService mThermalService;
        final /* synthetic */ BrightnessThermalModifier this$0;

        public static /* synthetic */ void $r8$lambda$sRzgdLFMU9Ur97h22PwwbhASE9o(ThermalStatusObserver r0, int r1) {
            r0.lambda$notifyThrottling$0(r1);
        }

        ThermalStatusObserver(BrightnessThermalModifier r1, Injector injector, Handler handler) {
            this.this$0 = r1;
            this.mInjector = injector;
            this.mHandler = handler;
            this.mStarted = false;
        }

        void registerSensor(SensorData tempSensor) {
            if (this.mStarted == true) goto L5;
        L13:
            this.mObserverTempSensor = tempSensor;
            registerThermalListener();
            return;
        L5:
            if (this.mObserverTempSensor == null) goto L13;
            String curType = this.mObserverTempSensor.type;
            this.mObserverTempSensor = tempSensor;
            if (Objects.equals(curType, tempSensor.type) == false) goto L11;
            Slog.d(BrightnessThermalModifier.TAG, "Thermal status observer already started");
            return;
        L11:
            stopObserving();
            registerThermalListener();
        }

        void registerThermalListener() {
            this.mThermalService = this.mInjector.getThermalService();
            if (this.mThermalService != null) goto L6;
            Slog.e(BrightnessThermalModifier.TAG, "Could not observe thermal status. Service not available");
            return;
        L6:
            int temperatureType = SensorUtils.getSensorTemperatureType(this.mObserverTempSensor);
            this.mThermalService.registerThermalEventListenerWithType(this, temperatureType);     // Catch: RemoteException -> L9
            this.mStarted = true;     // Catch: RemoteException -> L9
            return;
        L9:
            e = move-exception;
            Slog.e(BrightnessThermalModifier.TAG, "Failed to register thermal status listener", e);
        }

        public void notifyThrottling(Temperature temp) {
            Slog.d(BrightnessThermalModifier.TAG, "New thermal throttling status = " + temp.getStatus());
            if (this.mObserverTempSensor.name != null) goto L5;
        L8:
            final int status = temp.getStatus();
            this.mHandler.post(new BrightnessThermalModifier$ThermalStatusObserver$$ExternalSyntheticLambda0(this, status));
            return;
        L5:
            if (this.mObserverTempSensor.name.equals(temp.getName()) == true) goto L8;
            Slog.i(BrightnessThermalModifier.TAG, "Skipping thermal throttling notification as monitored sensor: " + this.mObserverTempSensor.name + " != notified sensor: " + temp.getName());
        }

        private /* synthetic */ void lambda$notifyThrottling$0(int status) {
            BrightnessThermalModifier.m3993$$Nest$mthermalStatusChanged(this.this$0, status);
        }

        void stopObserving() {
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
            Slog.e(BrightnessThermalModifier.TAG, "Failed to unregister thermal status listener", e);
            goto L9
        }

        void dump(PrintWriter writer) {
            writer.println("  ThermalStatusObserver:");
            writer.println("    mStarted: " + this.mStarted);
            writer.println("    mObserverTempSensor: " + this.mObserverTempSensor);
            if (this.mThermalService == null) goto L5;
            writer.println("    ThermalService available");
            return;
        L5:
            writer.println("    ThermalService not available");
        }
    }

    public static /* synthetic */ void $r8$lambda$3ZG5HSTRQ2t7KNJMOwKgXy204sI(BrightnessThermalModifier r0, BrightnessClamperController.DisplayDeviceData r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XR3z-g3_7ZUkt1ztDHPdAtpOdQ8, reason: not valid java name */
    public static /* synthetic */ void m3992$r8$lambda$XR3zg3_7ZUkt1ztDHPdAtpOdQ8(BrightnessThermalModifier r0) {
        r0.lambda$onDeviceConfigChanged$3();
    }

    public static /* synthetic */ void $r8$lambda$eW0xlnIU08x6wWuR_DZG0tFTYac(BrightnessThermalModifier r0, BrightnessClamperController.DisplayDeviceData r1) {
        r0.lambda$onDisplayChanged$2(r1);
    }

    public static /* synthetic */ DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel $r8$lambda$jdbc_JzcgGEXRPTp_54StI8jthQ(String r0, String r1) {
        return lambda$new$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mthermalStatusChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3993$$Nest$mthermalStatusChanged(BrightnessThermalModifier r0, int r1) {
        r0.thermalStatusChanged(r1);
    }

    private static /* synthetic */ DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel lambda$new$0(String key, String value) {
        int status = DeviceConfigParsingUtils.parseThermalStatus(key);     // Catch: IllegalArgumentException -> L4
        float brightnessPoint = DeviceConfigParsingUtils.parseBrightness(value);     // Catch: IllegalArgumentException -> L4
        return new DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel(status, brightnessPoint);
    L5:
        return null;
    }

    BrightnessThermalModifier(Handler handler, BrightnessClamperController.ClamperChangeListener listener, BrightnessClamperController.DisplayDeviceData data) {
        this(new Injector(), handler, listener, data);
    }

    BrightnessThermalModifier(Injector injector, Handler handler, BrightnessClamperController.ClamperChangeListener listener, final BrightnessClamperController.DisplayDeviceData data) {
        this.mThermalThrottlingDataOverride = Map.of();
        this.mThermalThrottlingDataFromDeviceConfig = null;
        this.mThermalThrottlingDataActive = null;
        this.mUniqueDisplayId = null;
        this.mDataId = null;
        this.mThrottlingStatus = 0;
        this.mBrightnessCap = 1.0f;
        this.mApplied = false;
        this.mDataPointMapper = new BrightnessThermalModifier$$ExternalSyntheticLambda1();
        this.mDataSetMapper = new BrightnessThermalModifier$$ExternalSyntheticLambda2();
        this.mExt = (IExtBrightnessThermalModifier) ExtImplFactory.getImpl(IExtBrightnessThermalModifier.class, new Object[]{this});
        this.mHandler = handler;
        this.mChangeListener = listener;
        this.mConfigParameterProvider = injector.getDeviceConfigParameterProvider();
        this.mThermalStatusObserver = new ThermalStatusObserver(this, injector, handler);
        this.mHandler.post(new BrightnessThermalModifier$$ExternalSyntheticLambda3(this, data));
    }

    private /* synthetic */ void lambda$new$1(BrightnessClamperController.DisplayDeviceData data) {
        setDisplayData(data);
        loadOverrideData();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        this.mExt.apply(request, stateBuilder);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
        this.mThermalStatusObserver.stopObserving();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter writer) {
        writer.println("BrightnessThermalClamper:");
        writer.println("  mThrottlingStatus: " + this.mThrottlingStatus);
        writer.println("  mUniqueDisplayId: " + this.mUniqueDisplayId);
        writer.println("  mDataId: " + this.mDataId);
        writer.println("  mDataOverride: " + this.mThermalThrottlingDataOverride);
        writer.println("  mDataFromDeviceConfig: " + this.mThermalThrottlingDataFromDeviceConfig);
        writer.println("  mDataActive: " + this.mThermalThrottlingDataActive);
        writer.println("  mBrightnessCap:" + this.mBrightnessCap);
        writer.println("  mApplied:" + this.mApplied);
        this.mThermalStatusObserver.dump(writer);
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
        this.mHandler.post(new BrightnessThermalModifier$$ExternalSyntheticLambda0(this, data));
    }

    private /* synthetic */ void lambda$onDisplayChanged$2(BrightnessClamperController.DisplayDeviceData data) {
        setDisplayData(data);
        recalculateActiveData();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.StatefulModifier
    public void applyStateChange(BrightnessClamperController.ModifiersAggregatedState aggregatedState) {
        if (aggregatedState.mMaxBrightness <= this.mBrightnessCap) goto L6;
        aggregatedState.mMaxBrightness = this.mBrightnessCap;
        aggregatedState.mMaxBrightnessReason = 1;
        return;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.DeviceConfigListener
    public void onDeviceConfigChanged() {
        this.mHandler.post(new BrightnessThermalModifier$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$onDeviceConfigChanged$3() {
        loadOverrideData();
        recalculateActiveData();
    }

    private void recalculateActiveData() {
        if (this.mUniqueDisplayId != null) goto L5;
        return;
    L5:
        if (this.mDataId == null) goto L10;
        this.mThermalThrottlingDataActive = this.mThermalThrottlingDataOverride.getOrDefault(this.mUniqueDisplayId, Map.of()).getOrDefault(this.mDataId, this.mThermalThrottlingDataFromDeviceConfig);
        recalculateBrightnessCap();
        return;
    }

    private void loadOverrideData() {
        String throttlingDataOverride = this.mConfigParameterProvider.getBrightnessThrottlingData();
        this.mThermalThrottlingDataOverride = DeviceConfigParsingUtils.parseDeviceConfigMap(throttlingDataOverride, this.mDataPointMapper, this.mDataSetMapper);
    }

    private void setDisplayData(ThermalData data) {
        this.mUniqueDisplayId = data.getUniqueDisplayId();
        this.mDataId = data.getThermalThrottlingDataId();
        this.mThermalThrottlingDataFromDeviceConfig = data.getThermalBrightnessThrottlingData();
        if (this.mThermalThrottlingDataFromDeviceConfig == null) goto L5;
    L7:
        this.mThermalStatusObserver.registerSensor(data.getTempSensor());
        return;
    L5:
        if ("default".equals(this.mDataId) == true) goto L7;
        Slog.wtf(TAG, "Thermal throttling data is missing for thermalThrottlingDataId=" + this.mDataId);
        goto L7
    }

    private void recalculateBrightnessCap() {
        float brightnessCap = 1.0f;
        if (this.mThermalThrottlingDataActive == null) goto L11;
        Iterator<DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel> r1 = this.mThermalThrottlingDataActive.throttlingLevels.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        DisplayDeviceConfig.ThermalBrightnessThrottlingData.ThrottlingLevel level = r1.next();
        if (level.thermalStatus > this.mThrottlingStatus) goto L11;
        brightnessCap = level.brightness;
    L11:
        if (brightnessCap == this.mBrightnessCap) goto L16;
        this.mBrightnessCap = brightnessCap;
        this.mChangeListener.onChanged();
        return;
    }

    private void thermalStatusChanged(int status) {
        if (this.mThrottlingStatus == status) goto L6;
        this.mThrottlingStatus = status;
        recalculateBrightnessCap();
        return;
    }

    public IExtBrightnessThermalModifier getExt() {
        return this.mExt;
    }
}
