package com.bytedance.vmsdk.log;

import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.util.Timer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class VLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "VLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static long alogNativePtr = 0;
    private static final int sDefaultLogLevel = 6;
    private static final int sDetectALogDependencyInterval = 500;
    private static final int sMaxTryCounts = 120;
    private static int[] sNativeLevelMap = null;
    private static int sNativeMinLogLevel = 6;
    private static int sTryCounts;

    static {
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    private static native void nativeInitALogNative(long r0, boolean r2);

    private static native void nativeInternalLog(int r0, String r1, String r2);

    private static native void nativeSetNativeMinLogLevel(int r0);

    public VLog() {
    }

    static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    public static void setMinimumLoggingLevel(int r2) {
        initNativeLogLevelMap();     // Catch: ArrayIndexOutOfBoundsException -> L6
        nativeSetNativeMinLogLevel(sNativeLevelMap[r2]);     // Catch: ArrayIndexOutOfBoundsException -> L6
        if (sNativeMinLogLevel == r2) goto L11;
        sNativeMinLogLevel = r2;     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("vmsdk", "Please check index, " + e.getMessage());
        sNativeMinLogLevel = 6;
        nativeSetNativeMinLogLevel(sNativeLevelMap[6]);
    }

    public static void onEnvReady() {
        setMinimumLoggingLevel(4);
    }

    public static void v(String r1, String r2) {
        internalLog(2, r1, r2);
    }

    public static void d(String r1, String r2) {
        internalLog(3, r1, r2);
    }

    public static void i(String r1, String r2) {
        internalLog(4, r1, r2);
    }

    public static void w(String r1, String r2) {
        internalLog(5, r1, r2);
    }

    public static void e(String r1, String r2) {
        internalLog(6, r1, r2);
    }

    public static void internalLog(int r0, String r1, String r2) {
        nativeInternalLog(r0, r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, th.getMessage());
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap != null) goto L6;
        sNativeLevelMap = new int[]{0, 0, -1, 0, 0, 1, 2, 3};
        return;
    }

    private static void loadALogDependency() {
        if (detectALogDependence() == true) goto L6;
        new Timer().schedule(new AnonymousClass1(), 0, 500);
        return;
    }

    private static boolean detectALogDependence() {
        long r0 = a.a();
        if (r0 == 0) goto L6;
        initALog(r0);
        INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "ALog dependency load successfully");
        return true;
    L6:
        int r1 = sTryCounts + 1;
        sTryCounts = r1;
        if (r1 != 120) goto L10;
        INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Get ALog dependency failed");
        return true;
    L10:
        return false;
    }

    public static void initALog(long r2) {
        if (Build.VERSION.SDK_INT <= 24) goto L5;
        boolean r0 = true;
    L6:
        alogNativePtr = r2;
        nativeInitALogNative(r2, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void init() {
        onEnvReady();     // Catch: Throwable -> L6
        long r0 = a.a();     // Catch: Throwable -> L6
        if (r0 == 0) goto L10;
        initALog(r0);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    L6:
        INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "vmsdk alog init fail");
    }

    private static long getALogPtr() {
        return alogNativePtr;
    }

    private static void initALogLazy() {
        loadALogDependency();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_log_VLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
