package com.android.server.display;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayControl {
    private static native IBinder nativeCreateVirtualDisplay(String r0, boolean r1, boolean r2, String r3, float r4);

    private static native void nativeDestroyVirtualDisplay(IBinder r0);

    private static native boolean nativeGetHdrOutputConversionSupport();

    private static native int[] nativeGetHdrOutputTypesWithLatency();

    private static native long[] nativeGetPhysicalDisplayIds();

    private static native IBinder nativeGetPhysicalDisplayToken(long r0);

    private static native int[] nativeGetSupportedHdrOutputTypes();

    private static native void nativeOverrideHdrTypes(IBinder r0, int[] r1);

    private static native int nativeSetHdrConversionMode(int r0, int r1, int[] r2, int r3);

    public DisplayControl() {
    }

    public static IBinder createVirtualDisplay(String name, boolean secure) {
        name.getClass();
        return nativeCreateVirtualDisplay(name, secure, true, "", 0.0f);
    }

    public static IBinder createVirtualDisplay(String name, boolean secure, boolean optimizeForPower, String uniqueId, float requestedRefreshRate) {
        name.getClass();
        uniqueId.getClass();
        return nativeCreateVirtualDisplay(name, secure, optimizeForPower, uniqueId, requestedRefreshRate);
    }

    public static void destroyVirtualDisplay(IBinder displayToken) {
        if (displayToken == null) goto L6;
        nativeDestroyVirtualDisplay(displayToken);
        return;
    L6:
        throw new IllegalArgumentException("displayToken must not be null");
    }

    public static void overrideHdrTypes(IBinder displayToken, int[] modes) {
        nativeOverrideHdrTypes(displayToken, modes);
    }

    public static long[] getPhysicalDisplayIds() {
        return nativeGetPhysicalDisplayIds();
    }

    public static IBinder getPhysicalDisplayToken(long physicalDisplayId) {
        return nativeGetPhysicalDisplayToken(physicalDisplayId);
    }

    public static int setHdrConversionMode(int conversionMode, int preferredHdrOutputType, int[] autoHdrTypes) {
        if (autoHdrTypes == null) goto L4;
        int length = autoHdrTypes.length;
    L6:
        return nativeSetHdrConversionMode(conversionMode, preferredHdrOutputType, autoHdrTypes, length);
    L4:
        length = 0;
        goto L6
    }

    public static int[] getSupportedHdrOutputTypes() {
        return nativeGetSupportedHdrOutputTypes();
    }

    public static int[] getHdrOutputTypesWithLatency() {
        return nativeGetHdrOutputTypesWithLatency();
    }

    public static boolean getHdrOutputConversionSupport() {
        return nativeGetHdrOutputConversionSupport();
    }
}
