package com.apm.lite.nativecrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.c;
import com.apm.lite.j.b;
import com.apm.lite.k.h;
import com.apm.lite.k.n;
import com.apm.lite.k.p;
import com.apm.lite.k.t;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import g1.d;
import g1.e;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import r1.l;
import r1.m;
import s1.f;

/* JADX INFO: loaded from: classes39.dex */
public class NativeImpl {
    private static boolean sResendSigQuit = true;
    private static volatile boolean soLoaded;
    private static volatile boolean soLoadedSuccess;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeImpl.access$000();     // Catch: Throwable -> L4
            return;
        }
    }

    public NativeImpl() {
    }

    public static /* synthetic */ void access$000() {
        startAnrMonitor();
    }

    public static void closeFile(int r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doCloseFile(r100);     // Catch: Throwable -> L7
        return;
    }

    public static int createCallbackThread() {
        if (soLoadedSuccess == true) goto L7;
        return -1;
    L7:
        return doCreateCallbackThread();
    }

    private static native boolean doCheckNativeCrash();

    private static native void doCloseFile(int r100);

    private static native int doCreateCallbackThread();

    private static native void doDump(String r100);

    public static void doDumpAllThread(String r100) {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doDump(r100);
    }

    private static native void doDumpFds(String r100);

    private static native void doDumpHprof(String r100);

    private static native void doDumpLogcat(String r100, String r101, String r102);

    private static native void doDumpMaps(String r100);

    private static native void doDumpMemInfo(String r100);

    private static native void doDumpThreads(String r100);

    private static native long doGetAppCpuTime();

    private static native long doGetChildCpuTime();

    private static native String doGetCrashHeader(String r100);

    private static native long doGetDeviceCpuTime();

    private static native int doGetFDCount();

    private static native String[] doGetFdDump(int r100, int r101, int[] r102, String[] r103);

    private static native long doGetFreeMemory();

    private static native long doGetThreadCpuTime(int r100);

    private static native int doGetThreadsCount();

    private static native long doGetTotalMemory();

    private static native long doGetVMSize();

    private static native void doInitThreadDump();

    public static int doLock(String r100) {
        if (soLoadedSuccess == true) goto L5;
    L9:
        return -1;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return doLock(r100, -1);
    }

    private static native int doLock(String r100, int r101);

    private static native int doOpenFile(String r100);

    private static native void doRebuildTombstone(String r100, String r101, String r102);

    private static native void doSetAlogConfigPath(String r100);

    private static native void doSetAlogFlushAddr(long r100);

    private static native void doSetAlogLogDirAddr(long r100);

    private static native void doSetResendSigQuit(int r100);

    private static native void doSetUploadEnd();

    private static native void doSignalMainThread();

    private static native int doStart(int r100, String r101, String r102, String r103, int r104);

    private static native void doStartAnrMonitor(int r100);

    private static native void doWriteFile(int r100, String r101, int r102);

    public static void dumpFds(String r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doDumpFds(r100);     // Catch: Throwable -> L7
        return;
    }

    public static void dumpHprof(String r100) {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doDumpHprof(r100);
    }

    public static void dumpLogcat(String r100, String r101, String r102) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doDumpLogcat(r100, r101, r102);     // Catch: Throwable -> L7
        return;
    }

    public static void dumpMaps(String r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doDumpMaps(r100);     // Catch: Throwable -> L7
        return;
    }

    public static void dumpMemInfo(String r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doDumpMemInfo(r100);     // Catch: Throwable -> L7
        return;
    }

    public static void dumpThreads(String r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doDumpThreads(r100);     // Catch: Throwable -> L7
        return;
    }

    public static boolean duringNativeCrash() {
        if (soLoadedSuccess == true) goto L8;
        return false;
    L8:
        return doCheckNativeCrash();
    L7:
        return false;
    }

    public static long getAppCpuTime() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetAppCpuTime();
    }

    public static long getChildCpuTime() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetChildCpuTime();
    }

    public static long getDeviceCpuTime() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetDeviceCpuTime();
    }

    public static int getFDCount() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetFDCount();
    }

    public static String[] getFd(int r100, int[] r110, String[] r111) {
        if (soLoadedSuccess == false) goto L22;
        if (r110 == null) goto L27;
        if (r111 == null) goto L28;
        String[] r101 = new String[100];
        int[] r102 = new int[100];
        int r103 = 0;
    L9:
        if (r103 >= r110.length) goto L21;
        if ((r110.length - r103) <= 100) goto L13;
        int r104 = 100;
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L17;
        r102[r105] = r110[r105 + r103];
        r105 = r105 + 1;
        goto L15
    L17:
        doGetFdDump(r100, r104, r102, r101);
        int r106 = 0;
    L18:
        if (r106 >= r104) goto L20;
        r111[r106 + r103] = r101[r106];
        r106 = r106 + 1;
        goto L18
    L20:
        r103 = r103 + 100;
        goto L9
    L13:
        r104 = r110.length - r103;
        goto L14
    L21:
        return r111;
    L28:
        return null;
    L27:
        return null;
    L22:
        return null;
    }

    public static long getFreeMemory() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetFreeMemory();
    }

    public static String getNativeCrashHeader(String r100) {
        if (soLoadedSuccess == true) goto L7;
        return null;
    L7:
        return doGetCrashHeader(r100);
    }

    public static long getThreadCpuTime(int r100) {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetThreadCpuTime(r100);
    }

    public static int getThreadsCount() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetThreadsCount();
    }

    public static long getTotalMemory() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetTotalMemory();
    }

    public static long getVMSize() {
        if (soLoadedSuccess == true) goto L7;
        return 0;
    L7:
        return doGetVMSize();
    }

    public static void initPThreadDump() {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doInitThreadDump();
    }

    private static native boolean is64Bit();

    public static boolean is64BitRuntime() {
        if (soLoadedSuccess == true) goto L8;
        return false;
    L8:
        return is64Bit();
    L7:
        return false;
    }

    public static boolean isResendSigQuit() {
        return sResendSigQuit;
    }

    public static int openFile(String r100) {
        if (soLoadedSuccess == true) goto L8;
        return -1;
    L8:
        return doOpenFile(r100);
    L7:
        return -1;
    }

    public static void registerSignalMainThread() {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doSignalMainThread();
    }

    private static void reportEventForAnrMonitor() {
        d.f479564c = null;     // Catch: Throwable -> L5
        e.b();     // Catch: Throwable -> L5
        return;
    }

    public static void setAlogFlushAddr(long r100) {
    }

    public static void setAlogFlushV2Addr(long r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doSetAlogFlushAddr(r100);     // Catch: Throwable -> L7
        return;
    }

    public static void setAlogLogDirAddr(long r100) {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doSetAlogLogDirAddr(r100);     // Catch: Throwable -> L7
        return;
    }

    public static void setResendSigQuit(boolean r100) {
        sResendSigQuit = r100;
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doSetResendSigQuit(r100 ? 1 : 0);
    }

    public static void setUploadEnd() {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        doSetUploadEnd();
    }

    private static void startAnrMonitor() {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        doStartAnrMonitor(Build.VERSION.SDK_INT);     // Catch: Throwable -> L7
        return;
    }

    public static int unLock(int r100) {
        if (soLoadedSuccess == false) goto L8;
        if (r100 < 0) goto L8;
        return doLock("", r100);
    L8:
        return -1;
    }

    public static void writeFile(int r100, String r101) {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        doWriteFile(r100, r101, r101.length());     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public static boolean loadLibrary() {
        if (soLoaded == true) goto L5;
        boolean r100 = true;
        soLoaded = true;
        if (soLoadedSuccess == true) goto L13;
        t.a();     // Catch: Throwable -> L10
    L11:
        soLoadedSuccess = r100;
    L10:
        r100 = false;
    L13:
        return soLoadedSuccess;
    L5:
        return soLoadedSuccess;
    }

    public static void setAlogLogFilePathToNative() {
        if (soLoadedSuccess == true) goto L8;
        return;
    L8:
        String r100 = com.apm.lite.e.f();     // Catch: Throwable -> L7
        PolarisFileWrapper r101 = new PolarisFileWrapper(n.g(com.apm.lite.e.f29909a), "apmlite/alogCrash");     // Catch: Throwable -> L7
        r101.mkdirs();     // Catch: Throwable -> L7
        doSetAlogConfigPath(r101.getPath() + "/native_" + r100 + ".atmp");     // Catch: Throwable -> L7
        return;
    }

    public static void startThreadForAnrMonitor() {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(), "NPTH-AnrMonitor"));
    }

    private static void handleNativeCrash(String r110) {
        long r100 = System.currentTimeMillis();
        p.a("[onNativeCrash] enter");
        b r101 = b.a();     // Catch: Throwable -> L28
        r101.getClass();     // Catch: Throwable -> L28
        if (r101.f29928e == true) goto L10;
        if (com.apm.lite.k.a.h(com.apm.lite.e.f29909a) == false) goto L10;
        m.a().a(r101.f29930g);     // Catch: Throwable -> L43
    L10:
        PolarisFileWrapper r102 = new PolarisFileWrapper(n.c(), com.apm.lite.e.f());     // Catch: Throwable -> L28
        PolarisFileWrapper r111 = new PolarisFileWrapper(r102, "callback.json");     // Catch: Throwable -> L28
        f r112 = f.b();     // Catch: Throwable -> L28
        CrashType r113 = CrashType.NATIVE;     // Catch: Throwable -> L28
        q1.b.a r114 = new q1.b.a(r102, r110, r111, r100);     // Catch: Throwable -> L28
        k1.a r115 = null;
        if (r113 != null) goto L13;
        r112.getClass();     // Catch: Throwable -> L28
    L16:
        JSONObject r103 = r115.f501330a;     // Catch: Throwable -> L28
        if (r103 == null) goto L25;
        if (r103.length() == 0) goto L25;
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L28
        long r105 = r104 - r100;
        r103.put("java_end", r104);     // Catch: Throwable -> L44
        r115.l("crash_cost", String.valueOf(r105));     // Catch: Throwable -> L44
        r115.c("crash_cost", String.valueOf(r105 / 1000));     // Catch: Throwable -> L44
    L23:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r111.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);     // Catch: Throwable -> L28
        h.g(r116, r103);     // Catch: Throwable -> L28
        r116.renameTo(r111);     // Catch: Throwable -> L28
    L25:
        if (((CopyOnWriteArrayList) l.f535571e.f535550c).isEmpty() == true) goto L55;
        PolarisFileWrapper r117 = new PolarisFileWrapper(n.c(), com.apm.lite.e.f());     // Catch: Throwable -> L34
        q1.e r106 = new q1.e(r117);     // Catch: Throwable -> L34
    L32:
        r106.a(r117);     // Catch: Throwable -> L34
        q1.b.a(r106.b());     // Catch: Throwable -> L34
        return;
    L55:
        return;
    L13:
        s1.d r107 = r112.a(r113);     // Catch: Throwable -> L28
        if (r107 == null) goto L16;
        r115 = r107.c(null, r114, true);     // Catch: Throwable -> L28
    L34:
        q1.b.a("");
        return;
    L28:
        c.a();     // Catch: Throwable -> L36
        if (((CopyOnWriteArrayList) l.f535571e.f535550c).isEmpty() == true) goto L56;
        r117 = new PolarisFileWrapper(n.c(), com.apm.lite.e.f());     // Catch: Throwable -> L34
        r106 = new q1.e(r117);     // Catch: Throwable -> L34
        goto L32
    L56:
        return;
    L36:
        th = move-exception;
    L41:
        q1.b.a("");
    L42:
        throw th;
    L38:
        if (((CopyOnWriteArrayList) l.f535571e.f535550c).isEmpty() == true) goto L42;
        PolarisFileWrapper r108 = new PolarisFileWrapper(n.c(), com.apm.lite.e.f());     // Catch: Throwable -> L41
        q1.e r109 = new q1.e(r108);     // Catch: Throwable -> L41
        r109.a(r108);     // Catch: Throwable -> L41
        q1.b.a(r109.b());     // Catch: Throwable -> L41
        goto L42
    }

    public static void rebuildTombstone(File r100) {
        if (soLoadedSuccess == true) goto L5;
        return;
    L5:
        String r101 = new PolarisFileWrapper(r100, "header.bin").getAbsolutePath();
        String r102 = new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, r100.getName()), "maps.txt").getAbsolutePath();
        doRebuildTombstone(r101, n.e(r100).getAbsolutePath(), r102);
    }

    public static boolean startMonitorNativeCrash(Context r100) {
        boolean r101 = loadLibrary();
        if (r101 == false) goto L9;
        String r102 = n.g(r100) + "/apmlite";
        new PolarisFileWrapper(r102).mkdirs();
        if (new PolarisFileWrapper(r100.getApplicationInfo().nativeLibraryDir, "libapmliteb.so").exists() == false) goto L7;
        String r103 = r100.getApplicationInfo().nativeLibraryDir;
    L8:
        doStart(Build.VERSION.SDK_INT, r103, r102, com.apm.lite.e.f(), 0);
        goto L9
    L7:
        r103 = com.apm.lite.e.f29909a.getFilesDir() + "/apmlite/selflib/";
        m.a().a(new m1.b());
    L9:
        return r101;
    }
}
