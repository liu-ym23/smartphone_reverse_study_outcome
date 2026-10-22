package com.android.server.display.brightness.clamper;

import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.IndentingPrintWriter;
import android.util.Spline;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.config.SensorData;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessClamperController {
    private static final String TAG = "BrightnessClamperController";
    private final ClamperChangeListener mClamperChangeListenerExternal;
    private final List<DeviceConfigListener> mDeviceConfigListeners;
    private final DeviceConfigParameterProvider mDeviceConfigParameterProvider;
    private final List<DisplayDeviceDataListener> mDisplayDeviceDataListeners;
    private int mDisplayState;
    private final Executor mExecutor;
    private IExtBrightnessClamperController mExt;
    private final Handler mHandler;
    private final LightSensorController mLightSensorController;
    private final LightSensorController.LightSensorListener mLightSensorListener;
    protected final List<BrightnessStateModifier> mModifiers;
    private ModifiersAggregatedState mModifiersAggregatedState;
    private final DeviceConfig.OnPropertiesChangedListener mOnPropertiesChangedListener;
    private volatile boolean mStarted;
    private final List<StatefulModifier> mStatefulModifiers;
    private final List<UserSwitchListener> mUserSwitchListeners;

    /* JADX INFO: renamed from: com.android.server.display.brightness.clamper.BrightnessClamperController$1, reason: invalid class name */
    class AnonymousClass1 implements LightSensorController.LightSensorListener {
        final /* synthetic */ BrightnessClamperController this$0;

        /* JADX INFO: renamed from: $r8$lambda$syL2Q9eql9hG0-EAx6p4vg3nSqY, reason: not valid java name */
        public static /* synthetic */ void m3984$r8$lambda$syL2Q9eql9hG0EAx6p4vg3nSqY(float r0, BrightnessStateModifier r1) {
            lambda$onAmbientLuxChange$0(r0, r1);
        }

        AnonymousClass1(BrightnessClamperController this$0) {
            this.this$0 = this$0;
        }

        private static /* synthetic */ void lambda$onAmbientLuxChange$0(float lux, BrightnessStateModifier mModifier) {
            mModifier.setAmbientLux(lux);
        }

        @Override // com.android.server.display.brightness.clamper.LightSensorController.LightSensorListener
        public void onAmbientLuxChange(final float lux) {
            this.this$0.mModifiers.forEach(new BrightnessClamperController$1$$ExternalSyntheticLambda0(lux));
        }
    }

    public interface ClamperChangeListener {
        void onChanged();
    }

    interface DeviceConfigListener {
        void onDeviceConfigChanged();
    }

    public static class DisplayDeviceData implements BrightnessThermalModifier.ThermalData, BrightnessPowerModifier.PowerData, BrightnessWearBedtimeModeModifier.WearBedtimeModeData {
        final DisplayDeviceConfig mDisplayDeviceConfig;
        final int mDisplayId;
        final IBinder mDisplayToken;
        final int mHeight;
        private final String mPowerThrottlingDataId;
        private final String mThermalThrottlingDataId;
        private final String mUniqueDisplayId;
        final int mWidth;

        public DisplayDeviceData(String uniqueDisplayId, String thermalThrottlingDataId, String powerThrottlingDataId, DisplayDeviceConfig displayDeviceConfig, int width, int height, IBinder displayToken, int displayId) {
            this.mUniqueDisplayId = uniqueDisplayId;
            this.mThermalThrottlingDataId = thermalThrottlingDataId;
            this.mPowerThrottlingDataId = powerThrottlingDataId;
            this.mDisplayDeviceConfig = displayDeviceConfig;
            this.mWidth = width;
            this.mHeight = height;
            this.mDisplayToken = displayToken;
            this.mDisplayId = displayId;
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessThermalModifier.ThermalData, com.android.server.display.brightness.clamper.BrightnessPowerModifier.PowerData
        public String getUniqueDisplayId() {
            return this.mUniqueDisplayId;
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessThermalModifier.ThermalData
        public String getThermalThrottlingDataId() {
            return this.mThermalThrottlingDataId;
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessThermalModifier.ThermalData
        public DisplayDeviceConfig.ThermalBrightnessThrottlingData getThermalBrightnessThrottlingData() {
            if (this.mThermalThrottlingDataId != null) goto L7;
            return null;
        L7:
            return this.mDisplayDeviceConfig.getThermalBrightnessThrottlingDataMapByThrottlingId().get(this.mThermalThrottlingDataId);
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessPowerModifier.PowerData
        public String getPowerThrottlingDataId() {
            return this.mPowerThrottlingDataId;
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessPowerModifier.PowerData
        public DisplayDeviceConfig.PowerThrottlingData getPowerThrottlingData() {
            return this.mDisplayDeviceConfig.getPowerThrottlingDataMapByThrottlingId().get(this.mPowerThrottlingDataId);
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessPowerModifier.PowerData
        public DisplayDeviceConfig.PowerThrottlingConfigData getPowerThrottlingConfigData() {
            return this.mDisplayDeviceConfig.getPowerThrottlingConfigData();
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessWearBedtimeModeModifier.WearBedtimeModeData
        public float getBrightnessWearBedtimeModeCap() {
            return this.mDisplayDeviceConfig.getBrightnessCapForWearBedtimeMode();
        }

        @Override // com.android.server.display.brightness.clamper.BrightnessThermalModifier.ThermalData
        public SensorData getTempSensor() {
            return this.mDisplayDeviceConfig.getTempSensor();
        }

        SensorData getAmbientLightSensor() {
            return this.mDisplayDeviceConfig.getAmbientLightSensor();
        }

        int getDisplayId() {
            return this.mDisplayId;
        }
    }

    interface DisplayDeviceDataListener {
        void onDisplayChanged(DisplayDeviceData r1);
    }

    static class Injector {
        Injector() {
        }

        DeviceConfigParameterProvider getDeviceConfigParameterProvider() {
            return new DeviceConfigParameterProvider(DeviceConfigInterface.REAL);
        }

        List<BrightnessStateModifier> getModifiers(DisplayManagerFlags flags, Context context, Handler handler, ClamperChangeListener listener, DisplayDeviceData data, float currentBrightness) {
            List<BrightnessStateModifier> modifiers = new ArrayList();
            modifiers.add(new BrightnessThermalModifier(handler, listener, data));
            if (flags.isBrightnessWearBedtimeModeClamperEnabled() == false) goto L6;
            modifiers.add(new BrightnessWearBedtimeModeModifier(handler, context, listener, data));
        L6:
            if (flags.isPowerThrottlingClamperEnabled() == false) goto L10;
            DisplayDeviceConfig.PowerThrottlingConfigData configData = data.getPowerThrottlingConfigData();
            if (configData == null) goto L10;
            modifiers.add(new BrightnessPowerModifier(handler, listener, data, currentBrightness));
        L10:
            modifiers.add(new DisplayDimModifier(data.mDisplayId, context));
            modifiers.add(new BrightnessLowPowerModeModifier());
            if (flags.isEvenDimmerEnabled() == false) goto L16;
            if (data.mDisplayDeviceConfig.isEvenDimmerAvailable() == false) goto L16;
            modifiers.add(new BrightnessLowLuxModifier(handler, listener, context, data.mDisplayDeviceConfig));
        L16:
            if (flags.useNewHdrBrightnessModifier() == false) goto L18;
            modifiers.add(new HdrBrightnessModifier(handler, context, listener, data));
        L18:
            return modifiers;
        }

        LightSensorController getLightSensorController(SensorManager sensorManager, Context context, LightSensorController.LightSensorListener listener, Handler handler) {
            return new LightSensorController(sensorManager, context.getResources(), listener, handler);
        }
    }

    public static class ModifiersAggregatedState {
        float mMaxBrightness;
        int mMaxBrightnessReason;
        float mMaxDesiredHdrRatio;
        float mMaxHdrBrightness;
        Spline mSdrHdrRatioSpline;

        public ModifiersAggregatedState() {
            this.mMaxDesiredHdrRatio = 1.0f;
            this.mMaxHdrBrightness = 1.0f;
            this.mSdrHdrRatioSpline = null;
            this.mMaxBrightnessReason = 0;
            this.mMaxBrightness = 1.0f;
        }
    }

    interface StatefulModifier {
        void applyStateChange(ModifiersAggregatedState r1);
    }

    interface UserSwitchListener {
        void onSwitchUser();
    }

    /* JADX INFO: renamed from: $r8$lambda$KW1PfQkggty-OpDV9NTT8OvIsEM, reason: not valid java name */
    public static /* synthetic */ void m3981$r8$lambda$KW1PfQkggtyOpDV9NTT8OvIsEM(ModifiersAggregatedState r0, StatefulModifier r1) {
        lambda$recalculateModifiersState$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$O_Db3R5ZOThySPed3NrXWlnzByY(BrightnessClamperController r0, DeviceConfig.Properties r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$T0jhELYM8iAkhQZTlgzlCemCYMI(BrightnessClamperController r0, Runnable r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$UbHQs2xcCeL-ihfZ8Z3AiRG97qA, reason: not valid java name */
    public static /* synthetic */ void m3982$r8$lambda$UbHQs2xcCeLihfZ8Z3AiRG97qA(IndentingPrintWriter r0, BrightnessStateModifier r1) {
        lambda$dump$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$_99BYE4X6wh_0QCNX7YtZRRi0qQ(BrightnessClamperController r0) {
        r0.recalculateModifiersState();
    }

    public static /* synthetic */ void $r8$lambda$lZbkd5dSsq5LPeOklHPm2wOksTM(BrightnessClamperController r0, BrightnessStateModifier r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wTdg2EEUse8KZfVRspHss_Ie-xA, reason: not valid java name */
    public static /* synthetic */ void m3983$r8$lambda$wTdg2EEUse8KZfVRspHss_IexA(DisplayDeviceData r0, DisplayDeviceDataListener r1) {
        lambda$onDisplayChanged$3(r0, r1);
    }

    public BrightnessClamperController(Handler handler, ClamperChangeListener clamperChangeListener, DisplayDeviceData data, Context context, DisplayManagerFlags flags, SensorManager sensorManager, float currentBrightness) {
        this(new Injector(), handler, clamperChangeListener, data, context, flags, sensorManager, currentBrightness);
    }

    BrightnessClamperController(Injector injector, Handler handler, ClamperChangeListener clamperChangeListener, DisplayDeviceData data, Context context, DisplayManagerFlags flags, SensorManager sensorManager, float currentBrightness) {
        this.mDisplayState = 1;
        this.mDisplayDeviceDataListeners = new ArrayList();
        this.mStatefulModifiers = new ArrayList();
        this.mUserSwitchListeners = new ArrayList();
        this.mDeviceConfigListeners = new ArrayList();
        this.mModifiersAggregatedState = new ModifiersAggregatedState();
        this.mLightSensorListener = new AnonymousClass1(this);
        this.mStarted = false;
        this.mExt = (IExtBrightnessClamperController) ExtImplFactory.getImpl(IExtBrightnessClamperController.class, new Object[]{this});
        this.mDeviceConfigParameterProvider = injector.getDeviceConfigParameterProvider();
        this.mHandler = handler;
        this.mLightSensorController = injector.getLightSensorController(sensorManager, context, this.mLightSensorListener, this.mHandler);
        this.mClamperChangeListenerExternal = clamperChangeListener;
        this.mExecutor = new HandlerExecutor(handler);
        final Runnable modifiersChangeRunnableInternal = new BrightnessClamperController$$ExternalSyntheticLambda7(this);
        ClamperChangeListener clamperChangeListenerInternal = new BrightnessClamperController$$ExternalSyntheticLambda8(this, modifiersChangeRunnableInternal);
        this.mModifiers = injector.getModifiers(flags, context, handler, clamperChangeListenerInternal, data, currentBrightness);
        this.mExt.setModifiers(this.mModifiers);
        this.mModifiers.forEach(new BrightnessClamperController$$ExternalSyntheticLambda9(this));
        this.mOnPropertiesChangedListener = new BrightnessClamperController$$ExternalSyntheticLambda10(this);
        this.mLightSensorController.configure(data.getAmbientLightSensor(), data.getDisplayId());
        start();
    }

    private /* synthetic */ void lambda$new$0(Runnable modifiersChangeRunnableInternal) {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mHandler.hasCallbacks(modifiersChangeRunnableInternal) == true) goto L9;
        this.mHandler.post(modifiersChangeRunnableInternal);
        return;
    }

    private /* synthetic */ void lambda$new$1(BrightnessStateModifier m) {
        if ((m instanceof DisplayDeviceDataListener) == false) goto L6;
        DisplayDeviceDataListener l = (DisplayDeviceDataListener) m;
        this.mDisplayDeviceDataListeners.add(l);
    L6:
        if ((m instanceof StatefulModifier) == false) goto L9;
        StatefulModifier s = (StatefulModifier) m;
        this.mStatefulModifiers.add(s);
    L9:
        if ((m instanceof UserSwitchListener) == false) goto L12;
        UserSwitchListener l2 = (UserSwitchListener) m;
        this.mUserSwitchListeners.add(l2);
    L12:
        if ((m instanceof DeviceConfigListener) == false) goto L15;
        DeviceConfigListener l3 = (DeviceConfigListener) m;
        this.mDeviceConfigListeners.add(l3);
        return;
    }

    private /* synthetic */ void lambda$new$2(DeviceConfig.Properties properties) {
        this.mDeviceConfigListeners.forEach(new BrightnessClamperController$$ExternalSyntheticLambda2());
    }

    public void onDisplayChanged(final DisplayDeviceData data) {
        this.mLightSensorController.configure(data.getAmbientLightSensor(), data.getDisplayId());
        this.mDisplayDeviceDataListeners.forEach(new BrightnessClamperController$$ExternalSyntheticLambda5(data));
        adjustLightSensorSubscription();
    }

    private static /* synthetic */ void lambda$onDisplayChanged$3(DisplayDeviceData data, DisplayDeviceDataListener l) {
        l.onDisplayChanged(data);
    }

    public DisplayBrightnessState clamp(DisplayBrightnessState displayBrightnessState, DisplayManagerInternal.DisplayPowerRequest request, float brightnessValue, boolean slowChange, int displayState) {
        this.mDisplayState = displayState;
        DisplayBrightnessState.Builder builder = DisplayBrightnessState.Builder.from(displayBrightnessState);
        builder.setIsSlowChange(slowChange);
        builder.setBrightness(brightnessValue);
        adjustLightSensorSubscription();
        int i = 0;
    L4:
        if (i >= this.mModifiers.size()) goto L7;
        this.mModifiers.get(i).apply(request, builder);
        i = i + 1;
        goto L4
    L7:
        return builder.build();
    }

    public void onUserSwitch() {
        this.mUserSwitchListeners.forEach(new BrightnessClamperController$$ExternalSyntheticLambda6());
    }

    public void dump(PrintWriter writer) {
        writer.println("BrightnessClamperController:");
        final PrintWriter r0 = new IndentingPrintWriter(writer, "    ");
        this.mLightSensorController.dump(r0);
        this.mModifiers.forEach(new BrightnessClamperController$$ExternalSyntheticLambda0(r0));
    }

    private static /* synthetic */ void lambda$dump$4(IndentingPrintWriter ipw, BrightnessStateModifier modifier) {
        modifier.dump(ipw);
    }

    public void stop() {
        this.mStarted = false;
        this.mDeviceConfigParameterProvider.removeOnPropertiesChangedListener(this.mOnPropertiesChangedListener);
        this.mLightSensorController.stop();
        this.mModifiers.forEach(new BrightnessClamperController$$ExternalSyntheticLambda3());
    }

    public float getMaxBrightness() {
        return this.mModifiersAggregatedState.mMaxBrightness;
    }

    public boolean isThrottled() {
        if (this.mModifiersAggregatedState.mMaxBrightnessReason == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void recalculateModifiersState() {
        final ModifiersAggregatedState newAggregatedState = new ModifiersAggregatedState();
        this.mStatefulModifiers.forEach(new BrightnessClamperController$$ExternalSyntheticLambda1(newAggregatedState));
        if (needToNotifyExternalListener(this.mModifiersAggregatedState, newAggregatedState) == false) goto L5;
        this.mClamperChangeListenerExternal.onChanged();
    L5:
        this.mModifiersAggregatedState = newAggregatedState;
    }

    private static /* synthetic */ void lambda$recalculateModifiersState$5(ModifiersAggregatedState newAggregatedState, StatefulModifier modifier) {
        modifier.applyStateChange(newAggregatedState);
    }

    private boolean needToNotifyExternalListener(ModifiersAggregatedState state1, ModifiersAggregatedState state2) {
        if (BrightnessSynchronizer.floatEquals(state1.mMaxDesiredHdrRatio, state2.mMaxDesiredHdrRatio) == true) goto L5;
    L14:
        return true;
    L5:
        if (BrightnessSynchronizer.floatEquals(state1.mMaxHdrBrightness, state2.mMaxHdrBrightness) == false) goto L14;
        if (state1.mSdrHdrRatioSpline != state2.mSdrHdrRatioSpline) goto L14;
        if (state1.mMaxBrightnessReason != state2.mMaxBrightnessReason) goto L14;
        if (BrightnessSynchronizer.floatEquals(state1.mMaxBrightness, state2.mMaxBrightness) == false) goto L14;
        return false;
    }

    private void start() {
        if (this.mDeviceConfigListeners.isEmpty() == true) goto L5;
        this.mDeviceConfigParameterProvider.addOnPropertiesChangedListener(this.mExecutor, this.mOnPropertiesChangedListener);
    L5:
        adjustLightSensorSubscription();
        this.mStarted = true;
    }

    private void adjustLightSensorSubscription() {
        if (this.mDisplayState == 2) goto L5;
    L7:
        this.mLightSensorController.stop();
        return;
    L5:
        if (this.mModifiers.stream().anyMatch(new BrightnessClamperController$$ExternalSyntheticLambda4()) == false) goto L7;
        this.mLightSensorController.restart();
    }

    public IExtBrightnessClamperController getExt() {
        return this.mExt;
    }
}
