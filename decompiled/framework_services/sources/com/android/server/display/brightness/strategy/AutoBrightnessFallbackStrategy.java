package com.android.server.display.brightness.strategy;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.IndentingPrintWriter;
import com.android.server.display.BrightnessMappingStrategy;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.DisplayPowerController$$ExternalSyntheticLambda2;
import com.android.server.display.ScreenOffBrightnessSensorController;
import com.android.server.display.brightness.BrightnessReason;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import com.android.server.display.utils.SensorUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoBrightnessFallbackStrategy implements DisplayBrightnessStrategy {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Injector mInjector;
    private boolean mIsDisplayEnabled;
    private int mLeadDisplayId;
    Sensor mScreenOffBrightnessSensor;
    private ScreenOffBrightnessSensorController mScreenOffBrightnessSensorController;

    interface Injector {
        Sensor getScreenOffBrightnessSensor(SensorManager r1, DisplayDeviceConfig r2);

        ScreenOffBrightnessSensorController getScreenOffBrightnessSensorController(SensorManager r1, Sensor r2, Handler r3, ScreenOffBrightnessSensorController.Clock r4, int[] r5, BrightnessMappingStrategy r6);
    }

    static class RealInjector implements Injector {
        RealInjector() {
        }

        @Override // com.android.server.display.brightness.strategy.AutoBrightnessFallbackStrategy.Injector
        public Sensor getScreenOffBrightnessSensor(SensorManager sensorManager, DisplayDeviceConfig displayDeviceConfig) {
            return SensorUtils.findSensor(sensorManager, displayDeviceConfig.getScreenOffBrightnessSensor(), 0);
        }

        @Override // com.android.server.display.brightness.strategy.AutoBrightnessFallbackStrategy.Injector
        public ScreenOffBrightnessSensorController getScreenOffBrightnessSensorController(SensorManager sensorManager, Sensor lightSensor, Handler handler, ScreenOffBrightnessSensorController.Clock clock, int[] sensorValueToLux, BrightnessMappingStrategy brightnessMapper) {
            return new ScreenOffBrightnessSensorController(sensorManager, lightSensor, handler, clock, sensorValueToLux, brightnessMapper);
        }
    }

    static {
    }

    public AutoBrightnessFallbackStrategy(Injector injector) {
        if (injector != null) goto L5;
        Injector r0 = new RealInjector();
    L6:
        this.mInjector = r0;
        return;
    L5:
        r0 = injector;
        goto L6
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        float brightness = this.mScreenOffBrightnessSensorController.getAutomaticScreenBrightness();
        BrightnessReason brightnessReason = new BrightnessReason();
        brightnessReason.setReason(9);
        DisplayBrightnessState.Builder r2 = new DisplayBrightnessState.Builder().setBrightness(brightness).setBrightnessReason(brightnessReason).setDisplayBrightnessStrategyName(getName());
        if (brightness == strategyExecutionRequest.getCurrentScreenBrightness()) goto L5;
        boolean r3 = true;
    L7:
        return r2.setShouldUpdateScreenBrightnessSetting(r3).build();
    L5:
        r3 = false;
        goto L7
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "AutoBrightnessFallbackStrategy";
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 9;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("AutoBrightnessFallbackStrategy:");
        writer.println("  mLeadDisplayId=" + this.mLeadDisplayId);
        writer.println("  mIsDisplayEnabled=" + this.mIsDisplayEnabled);
        writer.println("");
        if (this.mScreenOffBrightnessSensorController == null) goto L6;
        this.mScreenOffBrightnessSensorController.dump(new IndentingPrintWriter(writer, " "));
        return;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
        if (this.mScreenOffBrightnessSensorController == null) goto L19;
        int policy = strategySelectionNotifyRequest.getDisplayPowerRequest().policy;
        ScreenOffBrightnessSensorController r1 = this.mScreenOffBrightnessSensorController;
        if (strategySelectionNotifyRequest.isAutoBrightnessEnabled() == true) goto L7;
    L16:
        boolean r2 = false;
    L17:
        r1.setLightSensorEnabled(r2);
        return;
    L7:
        if (this.mIsDisplayEnabled == false) goto L16;
        r2 = true;
        if (policy == 0) goto L14;
        if (policy != 1) goto L16;
        if (strategySelectionNotifyRequest.isAllowAutoBrightnessWhileDozingConfig() == true) goto L16;
    L14:
        if (this.mLeadDisplayId != (-1)) goto L16;
    }

    public ScreenOffBrightnessSensorController getScreenOffBrightnessSensorController() {
        return this.mScreenOffBrightnessSensorController;
    }

    public void setupAutoBrightnessFallbackSensor(SensorManager sensorManager, DisplayDeviceConfig displayDeviceConfig, Handler handler, BrightnessMappingStrategy brightnessMappingStrategy, boolean isDisplayEnabled, int leadDisplayId) {
        this.mIsDisplayEnabled = isDisplayEnabled;
        this.mLeadDisplayId = leadDisplayId;
        if (this.mScreenOffBrightnessSensorController == null) goto L5;
        this.mScreenOffBrightnessSensorController.stop();
        this.mScreenOffBrightnessSensorController = null;
    L5:
        loadScreenOffBrightnessSensor(sensorManager, displayDeviceConfig);
        int[] sensorValueToLux = displayDeviceConfig.getScreenOffBrightnessSensorValueToLux();
        if (this.mScreenOffBrightnessSensor == null) goto L10;
        if (sensorValueToLux == null) goto L10;
        this.mScreenOffBrightnessSensorController = this.mInjector.getScreenOffBrightnessSensorController(sensorManager, this.mScreenOffBrightnessSensor, handler, new DisplayPowerController$$ExternalSyntheticLambda2(), sensorValueToLux, brightnessMappingStrategy);
        return;
    }

    public void stop() {
        if (this.mScreenOffBrightnessSensorController == null) goto L6;
        this.mScreenOffBrightnessSensorController.stop();
        return;
    }

    public boolean isValid() {
        if (this.mScreenOffBrightnessSensorController != null) goto L5;
    L7:
        return false;
    L5:
        if (BrightnessUtils.isValidBrightnessValue(this.mScreenOffBrightnessSensorController.getAutomaticScreenBrightness()) == false) goto L7;
        return true;
    }

    private void loadScreenOffBrightnessSensor(SensorManager sensorManager, DisplayDeviceConfig displayDeviceConfig) {
        this.mScreenOffBrightnessSensor = this.mInjector.getScreenOffBrightnessSensor(sensorManager, displayDeviceConfig);
    }
}
