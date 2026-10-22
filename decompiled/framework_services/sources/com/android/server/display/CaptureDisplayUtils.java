package com.android.server.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.SystemProperties;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureDisplayUtils {
    public static final int ADAPTER_TYPE_VIRTUAL = 1;
    public static final int ADAPTER_TYPE_WIFI = 0;
    public static final int CAPTURE_TYPE_CAPTURE = 1;
    public static final int CAPTURE_TYPE_CASTING = 3;
    public static final int CAPTURE_TYPE_DOUBLE_EYE_NON_DISTORTION = 5;
    public static final int CAPTURE_TYPE_INVALIDATE = -1;
    public static final int CAPTURE_TYPE_MRC = 4;
    public static final int CAPTURE_TYPE_RECORDING = 2;
    public static final int CAST_BUSINESS_MODE_DOUBLE = 1;
    public static final int CAST_BUSINESS_MODE_SINGLE = 0;
    public static final int CAST_MODE_DOUBLE = 0;
    public static final int CAST_MODE_SINGLE = 1;
    public static final String DISPLAY_NAME_CASTING = "ScreenCastThread-display";
    public static final String DISPLAY_NAME_MRC = "MrcDisplay";
    public static final String DISPLAY_NAME_NATIVESHELL = "ns_";
    public static final String DISPLAY_NAME_PICO_TV = "picotv";
    public static final String DISPLAY_NAME_RTC = "RTCScreenCapture";
    public static final String DISPLAY_NAME_SCRCPY = "scrcpy";
    public static final String DISPLAY_NAME_SCREENCAPTURE = "PvrScreenRecord";
    public static final String PROP_BUSINESS_CAST_MODE = "persist.pvr.cast.binocular";
    public static final String PROP_CAST_MODE = "persist.pxr.wfd.enable";
    public static final String TAG = "CaptureDisplayUtils";

    private static final class CaptureDisplayToken extends Binder {
        /* synthetic */ CaptureDisplayToken(CaptureDisplayUtilsIA r1) {
            this();
        }

        private CaptureDisplayToken() {
        }
    }

    public CaptureDisplayUtils() {
    }

    public static int getCaptureType(String name, int flags, int adapterType) {
        byte r1 = -1;
        if (isCaptureDisplay(name, flags, adapterType) == true) goto L7;
        Slog.d(TAG, "not a capture display: " + name);
        return -1;
    L7:
        switch(name.hashCode()) {
            case 173176073: goto L19;
            case 1682139850: goto L16;
            case 1937932196: goto L13;
            case 2091675769: goto L10;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        return 2;
    L23:
        return 4;
    L25:
        return 3;
    L26:
        return 2;
    L10:
        if (name.equals(DISPLAY_NAME_RTC) == false) goto L21;
        r1 = 2;
        goto L21
    L13:
        if (name.equals(DISPLAY_NAME_MRC) == false) goto L21;
        r1 = 3;
        goto L21
    L16:
        if (name.equals(DISPLAY_NAME_CASTING) == false) goto L21;
        r1 = 1;
        goto L21
    L19:
        if (name.equals(DISPLAY_NAME_SCREENCAPTURE) == false) goto L21;
        r1 = 0;
        goto L21
    }

    public static IBinder generateCaptureDisplayToken() {
        return new CaptureDisplayToken(null);
    }

    private static boolean isCaptureDisplay(String name, int flags, int adapterType) {
        boolean r1 = false;
        if (isNewCaptureEnable() == true) goto L6;
        return false;
    L6:
        if (name.contains(DISPLAY_NAME_PICO_TV) == false) goto L8;
    L40:
        return false;
    L8:
        if (name.equals(DISPLAY_NAME_SCRCPY) == true) goto L40;
        if (name.toLowerCase().startsWith(DISPLAY_NAME_NATIVESHELL) == true) goto L40;
        if (getBussinessCastMode() != 1) goto L19;
        if ((flags & 16) != 16) goto L19;
        Slog.i(TAG, "enterprise with dual cast: " + name);
        return false;
    L19:
        if (getCastModeStatus() != 0) goto L25;
        if (isCastingDisplay(name) == true) goto L25;
        Slog.i(TAG, "double mode and not a casting display...");
        return false;
    L25:
        if (name.contains(DISPLAY_NAME_MRC) == false) goto L28;
        return true;
    L28:
        switch(adapterType) {
            case 0: goto L35;
            case 1: goto L31;
            default: goto L29;
        };
    L29:
        boolean ret = false;
    L38:
        Slog.i(TAG, "has presentation? " + ret + " name: " + name);
        return ret;
    L31:
        if ((flags & 2) != 2) goto L33;
        r1 = true;
    L33:
        ret = r1;
        goto L38
    L35:
        if ((flags & 64) != 64) goto L37;
        r1 = true;
    L37:
        ret = r1;
        goto L38
    }

    private static boolean isCastingDisplay(String name) {
        if (DISPLAY_NAME_CASTING.equals(name) == false) goto L5;
    L10:
        return true;
    L5:
        if (DISPLAY_NAME_RTC.equals(name) == true) goto L10;
        if (DISPLAY_NAME_MRC.equals(name) == true) goto L10;
        return false;
    }

    private static int getCastModeStatus() {
        return SystemProperties.getInt(PROP_CAST_MODE, 1);
    }

    private static int getBussinessCastMode() {
        return SystemProperties.getInt(PROP_BUSINESS_CAST_MODE, 0);
    }

    private static boolean isNewCaptureEnable() {
        return CaptureSurfaceAgent.isNewCaptureEnable();
    }
}
