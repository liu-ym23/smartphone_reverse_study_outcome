package com.bytedance.crash.jni;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.config.e;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.crash.b;
import com.bytedance.crash.i;
import com.bytedance.crash.n.d;
import com.bytedance.crash.o.w;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NativeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7550a = 100;
    private static volatile boolean isSoLoaded;

    static {
    }

    private static native void doRegister(String r0, String r1);

    private static native void doSetDropDataState(int r0);

    private static native void nAnrDumpNativeInfo(long r0);

    private static native long nAnrDumpNativeInit(String r0);

    private static native void nAnrDumpNativeRelease(long r0);

    private static native void nAnrDumpTrace(String r0);

    private static native void nAnrEnterMonitorLooper();

    private static native void nAnrInitOnMainThread();

    public static native void nAnrNativeProfilerDump(long r0, String r2, long r3);

    public static native void nAnrNativeProfilerExit(long r0);

    public static native void nAnrNativeProfilerFormat(String r0, long[] r1);

    public static native int nAnrNativeProfilerJvmStart(long r0);

    public static native String nAnrNativeProfilerRunTest(String r0);

    public static native long nAnrNativeProfilerStart();

    public static native void nAnrNativeProfilerStop(long r0);

    private static native void nCheckSigHandler();

    private static native void nCoredumpNativeInit(String r0);

    private static native long nCrashDumpNativeInfo(long r0);

    private static native void nDumpLogcat(String r0, int r1);

    private static native void nDumpOsMemory(String r0);

    private static native void nDumperLateInit();

    private static native void nEnablePrioriryParams(boolean r0, boolean r1, int r2);

    private static native int nFlock(String r0);

    private static native int nGetApexVersion();

    private static native String nGetBuildID(String r0);

    private static native int nGetFdCount(String r0);

    private static native String nGetFdLeakReason(String r0);

    private static native int nGetFdLimit();

    private static native int nGetJvmMonitorState();

    private static native String nGetMallocType();

    private static native String nGetNativePthreadKeyLeakLibrary(String r0);

    private static native String[] nGetOOMReason(String r0);

    private static native String nGetStackTrace(boolean r0);

    private static native int nGetThreadCount(String r0);

    private static native long nGetThreadCpuTimeMills(int r0);

    private static native String nGetThreadLeakLibrary(String r0);

    private static native String nGetThreadLeakName(String r0);

    private static native long nGetVmRss(String r0);

    private static native long nGetVmSize(String r0, int r1);

    private static native int nGetVmaCount(String r0);

    private static native boolean nIncreaseFdLimit();

    private static native boolean nIs64BitRuntime();

    private static native String nLoadNativeCrashAbortReason(String r0);

    private static native String nLoadNativeCrashBacktrace(String r0);

    private static native NativeCrashSummary nLoadNativeCrashSummary(String r0);

    private static native int nNativePthreadKeyCount(String r0);

    private static native void nNotifyUploadDone();

    private static native void nParseSmaps(String r0);

    private static native void nPriorityMonitorInit(String r0);

    private static native void nRecoverSignalHandler();

    private static native void nResetNativeInfoLatches();

    private static native void nSet64Bit(boolean r0);

    private static native void nSetAlogFlushAddr(long r0);

    private static native void nSetAnrDumpAsync(boolean r0);

    private static native void nSetAnrResendSigquit(boolean r0);

    private static native void nSetAppVersion(String r0);

    private static native void nSetDumpTraceTryCatch(boolean r0);

    private static native boolean nSignalToProcess(int r0, int r1);

    private static native void nStartDumperThread();

    private static native int nStartNativeCrashMonitor(int r0, String r1, String r2, String r3, String r4, String r5, int r6, long r7, long r9, String r11);

    private static native void nStartProfilerJavaLockMonitor();

    private static native long nStringDumperCreate(String r0, int r1);

    private static native void nStringDumperDumpByteArray(long r0, byte[] r2, int r3);

    private static native void nStringDumperDumpCharArray(long r0, char[] r2, int r3);

    private static native void nStringDumperDumpString(long r0, String r2, int r3);

    private static native void nStringDumperFlushBuffer(long r0);

    private static native void nStringDumperRelease(long r0);

    private static native void nUnFlock(int r0);

    private static native int nativeDumpHprof(int r0, String r1);

    private static native void nativeDumpTags(String r0);

    private static native String[] nativeGetFdListForAPM();

    private static native String[] nativeGetTags();

    private static native void unRegister(String r0);

    public NativeBridge() {
    }

    public static void a() {
        w.a("npth");
    }

    public static boolean b() {
        return isSoLoaded;
    }

    public static void a(Context r13, File r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if (b() == false) goto L8;
        String r3 = r14.getAbsolutePath();
        String r2 = r15.getApplicationInfo().nativeLibraryDir;
        File r16 = e.b();
        if (r16.exists() == true) goto L7;
        r16.mkdirs();
    L7:
        String r4 = new File(r16, b.b()).getAbsolutePath();
        nStartNativeCrashMonitor(Build.VERSION.SDK_INT, r2, r3, r4, d.d(), i.a(r15).getAbsolutePath(), 4020254, i.f(), i.h(), i.i());
        return;
    L8:
        com.bytedance.crash.c.b.b("npth so load fail", new Exception());
    }

    public static void c() {
        if (b() == false) goto L6;
        nStartDumperThread();
        return;
    }

    public static void d() {
        if (b() == false) goto L6;
        nDumperLateInit();
        return;
    }

    public static long a(long r1) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nCrashDumpNativeInfo(r1);
    }

    public static void b(long r1) {
        if (b() == false) goto L6;
        nAnrDumpNativeInfo(r1);
        return;
    }

    public static void c(long r1) {
        if (b() == false) goto L6;
        nAnrDumpNativeRelease(r1);
        return;
    }

    public static long a(String r2) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nAnrDumpNativeInit(r2);
    }

    public static int b(String r1) {
        if (b() == true) goto L5;
        return -1;
    L5:
        return nFlock(r1);
    }

    public static void a(int r1) {
        if (b() == false) goto L6;
        nUnFlock(r1);
        return;
    }

    public static void d(long r1) {
        if (b() == false) goto L6;
        nSetAlogFlushAddr(r1);
        return;
    }

    public static void c(String r1) {
        if (b() == false) goto L6;
        nCoredumpNativeInit(r1);
        return;
    }

    private static void handleCrashFromDumperThread(long r0, int r2) {
        b.b(r0, r2);
    }

    private static void reportAnrEventFromNative(int r0, int r1) {
        com.bytedance.crash.anr.e.a(r0, r1);
    }

    public static void e() {
        if (b() == false) goto L6;
        nNotifyUploadDone();
        return;
    }

    public static NativeCrashSummary d(String r1) {
        if (b() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashSummary(r1);
    }

    public static void a(String r2, int r3, boolean r4) {
        if (b() == false) goto L18;
        if (Build.VERSION.SDK_INT != 23) goto L11;
        String r0 = Build.MANUFACTURER;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (r0.toLowerCase(Locale.getDefault()).contains("oppo") == false) goto L11;
        return;
    L11:
        nDumpLogcat(r2, r3);
        if (r4 == false) goto L19;
        SystemClock.sleep(1000);
        return;
    L19:
        return;
    }

    public static void a(String r1, boolean r2) {
        if (b() == false) goto L8;
        nDumpOsMemory(r1);
        if (r2 == false) goto L9;
        SystemClock.sleep(1000);
        return;
    L9:
        return;
    }

    public static int e(String r1) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nGetThreadCount(r1);
    }

    public static int f(String r1) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nGetFdCount(r1);
    }

    public static long b(String r1, boolean r2) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nGetVmSize(r1, r2 ? 1 : 0);
    }

    public static long g(String r2) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nGetVmRss(r2);
    }

    public static int f() {
        if (b() == false) goto L7;
        return nGetFdLimit();
    L7:
        if (Build.VERSION.SDK_INT <= 27) goto L9;
        return 32768;
    L9:
        return 1024;
    }

    public static String a(File r1) {
        if (b() == false) goto L5;
        String r2 = nGetFdLeakReason(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return SensitiveType.UNKNOWN;
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String b(File r1) {
        if (b() == false) goto L5;
        String r2 = nGetNativePthreadKeyLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return SensitiveType.UNKNOWN;
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String c(File r1) {
        if (b() == false) goto L5;
        String r2 = nGetThreadLeakName(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return SensitiveType.UNKNOWN;
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String d(File r1) {
        if (b() == false) goto L5;
        String r2 = nGetThreadLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return SensitiveType.UNKNOWN;
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String h(String r1) {
        if (b() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashBacktrace(r1);
    }

    public static String i(String r1) {
        if (b() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashAbortReason(r1);
    }

    public static String j(String r1) {
        if (b() == true) goto L5;
        return null;
    L5:
        return nGetBuildID(r1);
    }

    public static boolean g() {
        if (b() == true) goto L5;
        return false;
    L5:
        return nIs64BitRuntime();
    }

    public static void h() {
        if (b() == false) goto L6;
        nAnrInitOnMainThread();
        return;
    }

    public static void i() {
        if (b() == false) goto L6;
        nAnrEnterMonitorLooper();
        return;
    }

    public static void k(String r1) {
        if (b() == false) goto L6;
        nAnrDumpTrace(r1);
        return;
    }

    public static void a(long r1, char[] r3, int r4) {
        if (b() == false) goto L6;
        nStringDumperDumpCharArray(r1, r3, r4);
        return;
    }

    public static void a(long r1, String r3, int r4) {
        if (b() == false) goto L6;
        nStringDumperDumpString(r1, r3, r4);
        return;
    }

    public static long a(String r1, int r2) {
        if (b() == true) goto L5;
        return 0;
    L5:
        return nStringDumperCreate(r1, r2);
    }

    public static void e(long r1) {
        if (b() == false) goto L6;
        nStringDumperRelease(r1);
        return;
    }

    public static void f(long r1) {
        if (b() == false) goto L6;
        nStringDumperFlushBuffer(r1);
        return;
    }

    public static void l(String r1) {
        if (b() == false) goto L6;
        nSetAppVersion(r1);
        return;
    }

    public static void b(int r1) {
        if (b() == true) goto L5;
        return;
    L5:
        doSetDropDataState(r1);
    }

    public static int m(String r1) {
        if (b() == true) goto L7;
        return 0;
    L7:
        return nNativePthreadKeyCount(r1);
    }

    public static int n(String r1) {
        if (b() == true) goto L7;
        return 0;
    L7:
        return nGetVmaCount(r1);
    }

    public static String[] o(String r1) {
        if (b() == true) goto L7;
        return null;
    L7:
        return nGetOOMReason(r1);
    }

    public static int p(String r1) {
        if (b() == true) goto L10;
        return -1;
    L10:
        return nativeDumpHprof(Build.VERSION.SDK_INT, r1);
    L8:
        return -2;
    }

    public static HashMap<String, String> j() {
        String[] r0 = nativeGetTags();
        HashMap<String, String> r1 = new HashMap();
        if (r0 != null) goto L15;
        return r1;
    L15:
        if (r0.length >= 1) goto L8;
        return r1;
    L8:
        int r2 = 0;
    L10:
        if (r2 >= r0.length) goto L13;
        r1.put(r0[r2], r0[r2 + 1]);     // Catch: Throwable -> L14
        r2 = r2 + 2;
    L13:
        return r1;
    }

    public static void q(String r1) {
        if (b() == true) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L9;
        nPriorityMonitorInit(r1);
        return;
    }

    public static void a(boolean r1, boolean r2, int r3) {
        if (b() == false) goto L6;
        nEnablePrioriryParams(r1, r2, r3);
        return;
    }

    public static void r(String r1) {
        if (b() == false) goto L6;
        nParseSmaps(r1);
        return;
    }

    public static boolean a(String r1, String r2) {
        if (b() == true) goto L6;
        return false;
    L6:
        doRegister(r1, r2);
        return true;
    }

    public static boolean s(String r2) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        unRegister(r2);
        return true;
    }

    public static void t(String r1) {
        if (b() == true) goto L8;
        return;
    L8:
        nativeDumpTags(r1);     // Catch: Throwable -> L7
        return;
    }

    public static void k() {
        if (b() == false) goto L6;
        nStartProfilerJavaLockMonitor();
        return;
    }

    public static void a(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSet64Bit(r1);
    }

    public static void b(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrDumpAsync(r1);
    }

    public static void c(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetDumpTraceTryCatch(r1);
    }

    public static void d(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrResendSigquit(r1);
    }

    public static String e(boolean r2) {
        if (b() == true) goto L8;
        return null;
    L8:
        return nGetStackTrace(r2);
    L7:
        return null;
    }

    public static int l() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetJvmMonitorState();
    L11:
        return -1;
    }

    public static int m() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetApexVersion();
    L11:
        return -1;
    }

    public static String n() {
        if (b() == true) goto L9;
        return null;
    L9:
        return nGetMallocType();
    L11:
        return null;
    }
}
