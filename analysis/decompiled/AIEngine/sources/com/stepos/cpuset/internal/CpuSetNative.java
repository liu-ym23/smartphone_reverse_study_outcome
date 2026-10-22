package com.stepos.cpuset.internal;

import a0.a;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuSetNative {
    public static final CpuSetNative INSTANCE = new CpuSetNative();
    private static final String TAG = "CpuSetNative";
    private static volatile boolean isLibraryLoaded;

    static {
        try {
            System.loadLibrary(CpuSetNativeKt.LIBRARY_NAME_CPU_SET);
            isLibraryLoaded = true;
            Log.i(TAG, "Native library cpuset loaded successfully");
        } catch (UnsatisfiedLinkError e10) {
            isLibraryLoaded = false;
            a.A("Failed to load native library cpuset: ", e10.getMessage(), TAG);
        }
    }

    private CpuSetNative() {
    }

    private static final native int[] nativeGetAffinity(int i10);

    private static final native int nativeGetCpuCount();

    private static final native int nativeGetCurrentCpu(int i10);

    private static final native int nativeGetOnlineCpuCount();

    public final int[] getAffinity(int i10) {
        if (!isLibraryLoaded) {
            Log.w(TAG, "Native library not loaded, cannot get affinity");
            return null;
        }
        try {
            return nativeGetAffinity(i10);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to get affinity for thread " + i10, e10);
            return null;
        }
    }

    public final int getCpuCount() {
        if (!isLibraryLoaded) {
            Log.w(TAG, "Native library not loaded, cannot get CPU count");
            return 0;
        }
        try {
            return nativeGetCpuCount();
        } catch (Exception e10) {
            Log.e(TAG, "Failed to get CPU count", e10);
            return 0;
        }
    }

    public final int getCurrentCpu(int i10) {
        if (!isLibraryLoaded) {
            Log.w(TAG, "Native library not loaded, cannot get current CPU");
            return -1;
        }
        try {
            return nativeGetCurrentCpu(i10);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to get current CPU for thread " + i10, e10);
            return -1;
        }
    }

    public final int getOnlineCpuCount() {
        if (!isLibraryLoaded) {
            Log.w(TAG, "Native library not loaded, cannot get online CPU count");
            return 0;
        }
        try {
            return nativeGetOnlineCpuCount();
        } catch (Exception e10) {
            Log.e(TAG, "Failed to get online CPU count", e10);
            return 0;
        }
    }

    public final boolean isNativeLibraryLoaded() {
        return isLibraryLoaded;
    }
}
