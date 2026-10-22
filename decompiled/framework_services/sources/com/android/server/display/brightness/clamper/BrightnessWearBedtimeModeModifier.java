package com.android.server.display.brightness.clamper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.provider.Settings;
import com.android.server.display.DisplayBrightnessState;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessWearBedtimeModeModifier implements BrightnessStateModifier, BrightnessClamperController.DisplayDeviceDataListener, BrightnessClamperController.StatefulModifier {
    public static final int BEDTIME_MODE_OFF = 0;
    public static final int BEDTIME_MODE_ON = 1;
    private boolean mApplied;
    private float mBrightnessCap;
    protected final BrightnessClamperController.ClamperChangeListener mChangeListener;
    private final Context mContext;
    protected final Handler mHandler;
    private boolean mIsActive;
    private final ContentObserver mSettingsObserver;

    static class Injector {
        Injector() {
        }

        void registerBedtimeModeObserver(ContentResolver cr, ContentObserver observer) {
            cr.registerContentObserver(Settings.Global.getUriFor("bedtime_mode"), false, observer, -1);
        }
    }

    interface WearBedtimeModeData {
        float getBrightnessWearBedtimeModeCap();
    }

    public static /* synthetic */ void $r8$lambda$CvVTaiZ0sYWDHzBUCScOgH5ikzU(BrightnessWearBedtimeModeModifier r0, BrightnessClamperController.DisplayDeviceData r1) {
        r0.lambda$onDisplayChanged$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3994$$Nest$fgetmContext(BrightnessWearBedtimeModeModifier r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3995$$Nest$fputmIsActive(BrightnessWearBedtimeModeModifier r0, boolean r1) {
        r0.mIsActive = r1;
    }

    BrightnessWearBedtimeModeModifier(Handler handler, Context context, BrightnessClamperController.ClamperChangeListener listener, WearBedtimeModeData data) {
        this(new Injector(), handler, context, listener, data);
    }

    BrightnessWearBedtimeModeModifier(Injector injector, Handler handler, Context context, BrightnessClamperController.ClamperChangeListener listener, WearBedtimeModeData data) {
        this.mIsActive = false;
        this.mApplied = false;
        this.mHandler = handler;
        this.mChangeListener = listener;
        this.mContext = context;
        this.mBrightnessCap = data.getBrightnessWearBedtimeModeCap();
        final Handler r1 = this.mHandler;
        this.mSettingsObserver = new AnonymousClass1(this, r1);
        injector.registerBedtimeModeObserver(context.getContentResolver(), this.mSettingsObserver);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        if (this.mIsActive == true) goto L5;
    L10:
        this.mApplied = false;
        return;
    L5:
        if (stateBuilder.getMaxBrightness() <= this.mBrightnessCap) goto L10;
        stateBuilder.setMaxBrightness(this.mBrightnessCap);
        stateBuilder.setBrightness(Math.min(stateBuilder.getBrightness(), this.mBrightnessCap));
        stateBuilder.setBrightnessMaxReason(3);
        stateBuilder.getBrightnessReason().addModifier(8);
        if (this.mApplied == true) goto L9;
        stateBuilder.setIsSlowChange(false);
    L9:
        this.mApplied = true;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter writer) {
        writer.println("BrightnessWearBedtimeModeModifier:");
        writer.println("  mBrightnessCap: " + this.mBrightnessCap);
        writer.println("  mIsActive: " + this.mIsActive);
        writer.println("  mApplied: " + this.mApplied);
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
        this.mHandler.post(new BrightnessWearBedtimeModeModifier$$ExternalSyntheticLambda0(this, data));
    }

    private /* synthetic */ void lambda$onDisplayChanged$0(BrightnessClamperController.DisplayDeviceData data) {
        this.mBrightnessCap = data.getBrightnessWearBedtimeModeCap();
        this.mChangeListener.onChanged();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.StatefulModifier
    public void applyStateChange(BrightnessClamperController.ModifiersAggregatedState aggregatedState) {
        if (this.mIsActive == true) goto L5;
        return;
    L5:
        if (aggregatedState.mMaxBrightness <= this.mBrightnessCap) goto L9;
        aggregatedState.mMaxBrightness = this.mBrightnessCap;
        aggregatedState.mMaxBrightnessReason = 3;
        return;
    }
}
