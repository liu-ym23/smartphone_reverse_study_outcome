package com.android.server.display.brightness.clamper;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.util.Slog;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessLowLuxModifier extends BrightnessModifier implements BrightnessClamperController.UserSwitchListener {
    private static final boolean DEBUG = false;
    private static final float MIN_NITS_DEFAULT = 0.2f;
    private static final String TAG = "BrightnessLowLuxModifier";
    private float mAmbientLux;
    private float mBrightnessLowerBound;
    private final BrightnessClamperController.ClamperChangeListener mChangeListener;
    private final ContentResolver mContentResolver;
    private final DisplayDeviceConfig mDisplayDeviceConfig;
    private final Handler mHandler;
    private boolean mIsActive;
    private float mMinNitsAllowed;
    private int mReason;

    public static /* synthetic */ void $r8$lambda$mrxB_EUddprBtF8zJnmcOsbhhrA(BrightnessLowLuxModifier r0) {
        r0.lambda$new$0();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    BrightnessLowLuxModifier(Handler handler, BrightnessClamperController.ClamperChangeListener listener, Context context, DisplayDeviceConfig displayDeviceConfig) {
        this.mChangeListener = listener;
        this.mHandler = handler;
        this.mContentResolver = context.getContentResolver();
        this.mDisplayDeviceConfig = displayDeviceConfig;
        this.mHandler.post(new BrightnessLowLuxModifier$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$new$0() {
        start();
    }

    public void recalculateLowerBound() {
        if (this.mAmbientLux == (-1.0f)) goto L5;
        boolean isActive = true;
    L6:
        float minNitsAllowed = -1.0f;
        if (isActive == false) goto L9;
        float luxBasedNitsLowerBound = this.mDisplayDeviceConfig.getMinNitsFromLux(this.mAmbientLux);
        minNitsAllowed = Math.max(0.2f, luxBasedNitsLowerBound);
        float minBrightnessAllowed = getBrightnessFromNits(minNitsAllowed);
        int reason = 16;
    L11:
        if (this.mBrightnessLowerBound == minBrightnessAllowed) goto L13;
    L16:
        this.mIsActive = isActive;
        this.mReason = reason;
        if (DEBUG == false) goto L19;
        Slog.i(TAG, "isActive: " + isActive + ", minBrightnessAllowed: " + minBrightnessAllowed + ", mAmbientLux: " + this.mAmbientLux + ", mReason: " + this.mReason + ", minNitsAllowed: " + minNitsAllowed);
    L19:
        this.mMinNitsAllowed = minNitsAllowed;
        this.mBrightnessLowerBound = minBrightnessAllowed;
        this.mChangeListener.onChanged();
        return;
    L13:
        if (this.mReason != reason) goto L16;
        if (this.mIsActive != isActive) goto L16;
        return;
    L9:
        minBrightnessAllowed = this.mDisplayDeviceConfig.getEvenDimmerTransitionPoint();
        reason = 0;
        goto L11
    L5:
        isActive = false;
        goto L6
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void setAmbientLux(float lux) {
        this.mAmbientLux = lux;
        recalculateLowerBound();
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public int getBrightnessReason() {
        return this.mReason;
    }

    public float getBrightnessLowerBound() {
        return this.mBrightnessLowerBound;
    }

    void start() {
        recalculateLowerBound();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    boolean shouldApply(DisplayManagerInternal.DisplayPowerRequest request) {
        return this.mIsActive;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    float getBrightnessAdjusted(float currentBrightness, DisplayManagerInternal.DisplayPowerRequest request) {
        return Math.max(this.mBrightnessLowerBound, currentBrightness);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    int getModifier() {
        return this.mReason;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        stateBuilder.setMinBrightness(this.mBrightnessLowerBound);
        float boundedBrightness = Math.max(this.mBrightnessLowerBound, stateBuilder.getBrightness());
        stateBuilder.setBrightness(boundedBrightness);
        if (BrightnessSynchronizer.floatEquals(stateBuilder.getBrightness(), this.mBrightnessLowerBound) == false) goto L6;
        stateBuilder.getBrightnessReason().addModifier(this.mReason);
        return;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public boolean shouldListenToLightSensor() {
        return true;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.UserSwitchListener
    public void onSwitchUser() {
        recalculateLowerBound();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("BrightnessLowLuxModifier:");
        pw.println("  mIsActive=" + this.mIsActive);
        pw.println("  mBrightnessLowerBound=" + this.mBrightnessLowerBound);
        pw.println("  mReason=" + this.mReason);
        pw.println("  mAmbientLux=" + this.mAmbientLux);
        pw.println("  mMinNitsAllowed=" + this.mMinNitsAllowed);
    }

    private float getBrightnessFromNits(float nits) {
        return this.mDisplayDeviceConfig.getBrightnessFromBacklight(this.mDisplayDeviceConfig.getBacklightFromNits(nits));
    }
}
