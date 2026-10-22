package com.bytedance.crash.resource;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.r;

/* JADX INFO: loaded from: classes.dex */
public class NativeResourceMonitor {
    private static native void nDumpNativeInfoThreads(String r0);

    private static native int nFakeOpen(String r0);

    private static native int nFdTrackDoCommand(int r0);

    private static native int nFdTrackDumpNative(int r0, String r1);

    private static native int nFdTrackGetFdCount(int r0);

    private static native int nNativeBridgeInit(int r0, int r1, String r2, String r3, String r4, String r5);

    private static native int nNativeDoCommnad(int r0);

    private static native long nNativeGetHeapLeakSize();

    private static native long nNativeGetHeapSize();

    private static native void nNativeNeedDumpMemInfo(int r0);

    private static native void nNativeSetDumpThreshold(long r0);

    private static native void nNativeSetMinSizeByte(long r0);

    private static native int nVmMonitorDoCommand(int r0, int r1);

    private static native void nVmMonitorDumpMaps(String r0);

    private static native int nVmMonitorDumpNative(int r0, int r1, String r2);

    private static native int nXasanInit(int r0, String r1, String r2);

    public NativeResourceMonitor() {
    }

    public static boolean a() {
        return NativeBridge.b();
    }

    public static int a(int r1, int r2, String r3, String r4, String r5, String r6) {
        if (a() == true) goto L7;
        r.c("NativeBridgeInit fail", "monitorType:" + r2 + " soName:" + r3);
        return -1;
    L7:
        return nNativeBridgeInit(r1, r2, r3, r4, r5, r6);
    }

    public static int a(int r1) {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nNativeDoCommnad(r1);
    }

    public static long b() {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapSize();
    }

    public static long c() {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapLeakSize();
    }

    public static void b(int r1) {
        if (a() == true) goto L5;
        return;
    L5:
        nNativeNeedDumpMemInfo(r1);
    }

    public static int a(int r1, int r2) {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDoCommand(r1, r2);
    }

    public static void a(String r1) {
        if (a() == true) goto L5;
        return;
    L5:
        nVmMonitorDumpMaps(r1);
    }

    public static int c(int r1) {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDoCommand(r1);
    }

    public static int d(int r1) {
        if (a() == true) goto L7;
        return -1;
    L7:
        return nFdTrackGetFdCount(r1);
    }

    public static int a(int r1, String r2, String r3) {
        if (a() == true) goto L7;
        r.c("NPTH", "xasan load so failed");
        return -1;
    L7:
        return nXasanInit(r1, r2, r3);
    }

    public static void b(String r1) {
        if (a() == false) goto L6;
        nDumpNativeInfoThreads(r1);
        return;
    }
}
