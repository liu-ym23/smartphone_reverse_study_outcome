package com.android.server.wm;

import android.R;
import android.content.Context;
import android.os.SystemProperties;
import android.window.DesktopExperienceFlags;
import android.window.DesktopModeFlags;

/* JADX INFO: loaded from: classes3.dex */
public final class DesktopModeHelper {
    private static final boolean ENFORCE_DEVICE_RESTRICTIONS = false;

    public DesktopModeHelper() {
    }

    static {
        ENFORCE_DEVICE_RESTRICTIONS = SystemProperties.getBoolean("persist.wm.debug.desktop_mode_enforce_device_restrictions", true);
    }

    private static boolean isDesktopModeEnabled() {
        return DesktopModeFlags.ENABLE_DESKTOP_WINDOWING_MODE.isTrue();
    }

    static boolean shouldEnforceDeviceRestrictions() {
        return ENFORCE_DEVICE_RESTRICTIONS;
    }

    private static boolean isDesktopModeSupported(Context context) {
        return context.getResources().getBoolean(R.bool.config_jobSchedulerRestrictBackgroundUser);
    }

    static boolean isDesktopModeDevOptionsSupported(Context context) {
        return context.getResources().getBoolean(R.bool.config_is_powerbutton_fps);
    }

    private static boolean canInternalDisplayHostDesktops(Context context) {
        return context.getResources().getBoolean(R.bool.config_carDockEnablesAccelerometer);
    }

    private static boolean isDesktopModeEnabledByDevOption(Context context) {
        if (DesktopModeFlags.isDesktopModeForcedEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (isDesktopModeDevOptionsSupported(context) == false) goto L7;
    L8:
        return true;
    L7:
        if (isDeviceEligibleForDesktopMode(context) == false) goto L9;
        goto L8
    }

    public static boolean isDeviceEligibleForDesktopMode(Context context) {
        if (shouldEnforceDeviceRestrictions() == true) goto L6;
        return true;
    L6:
        if (DesktopExperienceFlags.ENABLE_PROJECTED_DISPLAY_DESKTOP_MODE.isTrue() == false) goto L9;
        boolean desktopModeSupported = isDesktopModeSupported(context);
    L15:
        if (desktopModeSupported == true) goto L20;
        if (0 == 0) goto L19;
        return true;
    L19:
        return false;
    L20:
        return true;
    L9:
        if (isDesktopModeSupported(context) == true) goto L11;
    L13:
        desktopModeSupported = false;
        goto L15
    L11:
        if (canInternalDisplayHostDesktops(context) == false) goto L13;
        desktopModeSupported = true;
        goto L15
    }

    static boolean canEnterDesktopMode(Context context) {
        if (isDeviceEligibleForDesktopMode(context) == false) goto L7;
        if (DesktopModeFlags.ENABLE_DESKTOP_WINDOWING_MODE.isTrue() == false) goto L7;
    L8:
        return true;
    L7:
        if (isDesktopModeEnabledByDevOption(context) == true) goto L8;
        return false;
    }

    public static boolean isDeviceEligibleForDesktopExperienceWallpaper(Context context) {
        return false;
    }
}
