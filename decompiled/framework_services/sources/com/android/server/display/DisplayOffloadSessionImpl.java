package com.android.server.display;

import android.hardware.display.DisplayManagerInternal;
import android.os.Trace;
import android.util.Slog;
import com.android.server.display.utils.DebugUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayOffloadSessionImpl implements DisplayManagerInternal.DisplayOffloadSession {
    private static final boolean DEBUG = false;
    private static final String TAG = "DisplayOffloadSessionImpl";
    private final DisplayManagerInternal.DisplayOffloader mDisplayOffloader;
    private final DisplayPowerController mDisplayPowerController;
    private boolean mIsActive;

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public DisplayOffloadSessionImpl(DisplayManagerInternal.DisplayOffloader displayOffloader, DisplayPowerController displayPowerController) {
        this.mDisplayOffloader = displayOffloader;
        this.mDisplayPowerController = displayPowerController;
    }

    public void setDozeStateOverride(int displayState) {
        this.mDisplayPowerController.overrideDozeScreenState(displayState, 3);
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean allowAutoBrightnessInDoze() {
        if (this.mDisplayOffloader != null) goto L7;
        return false;
    L7:
        return this.mDisplayOffloader.allowAutoBrightnessInDoze();
    }

    public void updateBrightness(float brightness) {
        if (this.mIsActive == false) goto L6;
        this.mDisplayPowerController.setBrightnessFromOffload(brightness);
        return;
    }

    public boolean blockScreenOn(Runnable unblocker) {
        if (this.mDisplayOffloader != null) goto L6;
        return false;
    L6:
        this.mDisplayOffloader.onBlockingScreenOn(unblocker);
        return true;
    }

    public void cancelBlockScreenOn() {
        if (this.mDisplayOffloader != null) goto L5;
        return;
    L5:
        this.mDisplayOffloader.cancelBlockScreenOn();
    }

    public float[] getAutoBrightnessLevels(int mode) {
        if (mode < 0) goto L8;
        if (mode > 2) goto L8;
        return this.mDisplayPowerController.getAutoBrightnessLevels(mode);
    L8:
        throw new IllegalArgumentException("Unknown auto-brightness mode: " + mode);
    }

    public float[] getAutoBrightnessLuxLevels(int mode) {
        if (mode < 0) goto L8;
        if (mode > 2) goto L8;
        return this.mDisplayPowerController.getAutoBrightnessLuxLevels(mode);
    L8:
        throw new IllegalArgumentException("Unknown auto-brightness mode: " + mode);
    }

    public boolean startOffload() {
        if (this.mDisplayOffloader != null) goto L5;
        return false;
    L5:
        if (this.mIsActive == true) goto L22;
        Trace.traceBegin(131072, "DisplayOffloader#startOffload");
        this.mIsActive = this.mDisplayOffloader.startOffload();     // Catch: Throwable -> L11
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "startOffload = " + this.mIsActive);     // Catch: Throwable -> L11
    L13:
        boolean r0 = this.mIsActive;     // Catch: Throwable -> L11
        Trace.traceEnd(131072);
        return r0;
    L11:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    L22:
        return false;
    }

    public void stopOffload() {
        if (this.mDisplayOffloader != null) goto L5;
        return;
    L5:
        if (this.mIsActive == false) goto L21;
        Trace.traceBegin(131072, "DisplayOffloader#stopOffload");
        this.mDisplayOffloader.stopOffload();     // Catch: Throwable -> L12
        this.mIsActive = false;     // Catch: Throwable -> L12
        if (DEBUG == false) goto L14;
        Slog.i(TAG, "stopOffload");     // Catch: Throwable -> L12
    L14:
        Trace.traceEnd(131072);
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    }

    public float getBrightness() {
        return this.mDisplayPowerController.getScreenBrightnessSetting();
    }

    public float getDozeBrightness() {
        return this.mDisplayPowerController.getDozeBrightnessForOffload();
    }
}
