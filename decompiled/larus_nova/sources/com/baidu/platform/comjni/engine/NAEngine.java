package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NAEngine extends NativeComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LongLinkClient f33437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33438b;

    private native long nativeCreate();

    private static native void nativeEnableMonitor(boolean r100);

    private static native boolean nativeGetFlaxLength(Bundle r100);

    private static native String nativeGetIP(String r100);

    private static native void nativeInitCVLogFilePath(String r100);

    private static native int nativeInitClass(Object r100, int r101);

    private static native boolean nativeInitEngine(Object r100, String r101);

    private static native void nativeInitMonitor(String r100);

    private static native void nativeMonitorAddLog(int r100, String r101, String r102);

    private static native void nativeMonitorSetLogPriority(int r100);

    private static native void nativeMonitorSetOutPutType(int r100);

    private native int nativeRelease(long r100);

    private static native void nativeSetHttpsEnable(boolean r100);

    private static native void nativeSetMonitorLogFilter(String[] r100);

    private static native void nativeSetNewDomainEnable(boolean r100);

    private static native void nativeSetProxyInfo(String r100, int r101);

    private static native void nativeStartRunningRequest();

    private static native boolean nativeStartSocketProc();

    private static native boolean nativeStartSocketProcByCache(String r100);

    private static native void nativeSyncAppRuntime(String r100);

    private static native void nativeUninitCVLogFilePath();

    private static native boolean nativeUninitEngine();

    public static void a() {
        nativeInitClass(new Bundle(), 0);
        f33438b = true;
    }

    public static boolean c() {
        LongLinkClient r100 = f33437a;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.unRegister(null);     // Catch: Throwable -> L7
        f33437a.release();     // Catch: Throwable -> L7
        f33437a = null;     // Catch: Throwable -> L7
    L5:
        return nativeUninitEngine();
    L7:
        return false;
    }

    public static boolean initLongLinkClient() {
        if (f33437a != null) goto L8;
        f33437a = LongLinkClient.create();     // Catch: ComInitException -> L6
    L8:
        if (f33437a == null) goto L10;
        return true;
    L10:
        return false;
    }

    public static void restartLongLink() {
        LongLinkClient r100 = f33437a;
        if (r100 == null) goto L9;
        r100.start();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public static void stopLongLink() {
        LongLinkClient r100 = f33437a;
        if (r100 == null) goto L9;
        r100.stop();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public NAEngine() {
        create();
    }

    public static boolean b() {
        return nativeStartSocketProc();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public static void startRunningRequest() {
        nativeStartRunningRequest();
    }

    public static void a(boolean r100) {
        nativeEnableMonitor(r100);
        nativeMonitorSetLogPriority(1);
    }

    public static void b(int r100) {
        nativeMonitorSetOutPutType(r100);
    }

    public static String getIP(String r100) {
        return nativeGetIP(r100);
    }

    public static void a(int r100) {
        nativeMonitorSetLogPriority(r100);
    }

    public static void a(String r100) {
        nativeInitMonitor(r100);
    }

    public static void a(String[] r100) {
        nativeSetMonitorLogFilter(r100);
    }

    public static boolean a(Context r100, String r101) {
        if (f33438b == true) goto L9;
        a();
    L9:
        return nativeInitEngine(r100, r101);
    L7:
        return false;
    }

    public static void a(int r100, String r101, String r102) {
        nativeMonitorAddLog(r100, r101, r102);
    }
}
