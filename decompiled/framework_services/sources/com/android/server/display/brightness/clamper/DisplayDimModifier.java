package com.android.server.display.brightness.clamper;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManagerInternal;
import android.os.PowerManager;
import android.pico.utils.ExtImplFactory;
import android.util.IndentingPrintWriter;
import com.android.server.display.brightness.BrightnessUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class DisplayDimModifier extends BrightnessModifier {
    private IExtDisplayDimModifier mExt;
    private final float mScreenBrightnessDimConfig;
    private final float mScreenBrightnessMinimumDimAmount;

    DisplayDimModifier(int displayId, Context context) {
        this.mExt = (IExtDisplayDimModifier) ExtImplFactory.getImpl(IExtDisplayDimModifier.class, new Object[]{this});
        PowerManager pm = (PowerManager) context.getSystemService(PowerManager.class);
        pm.getClass();
        Resources resources = context.getResources();
        this.mScreenBrightnessDimConfig = BrightnessUtils.clampAbsoluteBrightness(pm.getBrightnessConstraint(displayId, 3));
        this.mScreenBrightnessMinimumDimAmount = resources.getFloat(R.dimen.edit_text_inset_bottom_material);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    boolean shouldApply(DisplayManagerInternal.DisplayPowerRequest request) {
        return this.mExt.shouldApply(request);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    float getBrightnessAdjusted(float currentBrightness, DisplayManagerInternal.DisplayPowerRequest request) {
        return this.mExt.getBrightnessAdjusted(currentBrightness, request, this.mScreenBrightnessDimConfig, this.mScreenBrightnessMinimumDimAmount);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    int getModifier() {
        return this.mExt.getModifier();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("DisplayDimModifier:");
        pw.println("  mScreenBrightnessDimConfig=" + this.mScreenBrightnessDimConfig);
        pw.println("  mScreenBrightnessMinimumDimAmount=" + this.mScreenBrightnessMinimumDimAmount);
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "    ");
        super.dump(ipw);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public boolean shouldListenToLightSensor() {
        return false;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void setAmbientLux(float lux) {
    }
}
