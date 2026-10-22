package com.apm.insight.nativecrash;

import N9.j;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.apm.insight.g;
import h2.d;
import java.io.File;
import r2.b;
import z2.l;
import z2.r;

/* loaded from: classes2.dex */
public class NativeImpl {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f2193a = false;
    public static volatile boolean b = false;
    public static boolean c = true;

    public static void A() {
        if (f2193a) {
            try {
                doStartAnrMonitor(Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(String str) {
        if (f2193a) {
            return doGetCrashHeader(str);
        }
        return null;
    }

    public static void b(int i) {
        if (!f2193a || i < 0) {
            return;
        }
        try {
            doLock("", i);
        } catch (Throwable unused) {
        }
    }

    public static void c(int i, String str) {
        if (!f2193a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            doWriteFile(i, str, str.length());
        } catch (Throwable unused) {
        }
    }

    public static void d(File file) {
        if (f2193a) {
            doRebuildTombstone(new File(file, "header.bin").getAbsolutePath(), new File(file, "tombstone.txt").getAbsolutePath(), new File(j.g(g.f2160a, file.getName()), "maps.txt").getAbsolutePath());
        }
    }

    @Keep
    private static native boolean doCheckNativeCrash();

    @Keep
    private static native void doCloseFile(int i);

    @Keep
    private static native int doCreateCallbackThread();

    @Keep
    private static native void doDump(String str);

    @Keep
    private static native void doDumpFds(String str);

    @Keep
    private static native void doDumpHprof(String str);

    @Keep
    private static native void doDumpLogcat(String str, String str2, String str3);

    @Keep
    private static native void doDumpMaps(String str);

    @Keep
    private static native void doDumpMemInfo(String str);

    @Keep
    private static native void doDumpThreads(String str);

    @Keep
    private static native long doGetAppCpuTime();

    @Keep
    private static native long doGetChildCpuTime();

    @Keep
    private static native String doGetCrashHeader(String str);

    @Keep
    private static native long doGetDeviceCpuTime();

    @Keep
    private static native int doGetFDCount();

    @Keep
    private static native String[] doGetFdDump(int i, int i6, int[] iArr, String[] strArr);

    @Keep
    private static native long doGetFreeMemory();

    @Keep
    private static native long doGetThreadCpuTime(int i);

    @Keep
    private static native int doGetThreadsCount();

    @Keep
    private static native long doGetTotalMemory();

    @Keep
    private static native long doGetVMSize();

    @Keep
    private static native void doInitThreadDump();

    @Keep
    private static native int doLock(String str, int i);

    @Keep
    private static native int doOpenFile(String str);

    @Keep
    private static native void doRebuildTombstone(String str, String str2, String str3);

    @Keep
    private static native void doSetAlogConfigPath(String str);

    @Keep
    private static native void doSetAlogFlushAddr(long j5);

    @Keep
    private static native void doSetAlogLogDirAddr(long j5);

    @Keep
    private static native void doSetResendSigQuit(int i);

    @Keep
    private static native void doSetUploadEnd();

    @Keep
    private static native void doSignalMainThread();

    @Keep
    private static native int doStart(int i, String str, String str2, String str3, int i6);

    @Keep
    private static native void doStartAnrMonitor(int i);

    @Keep
    private static native void doWriteFile(int i, String str, int i6);

    public static void e(String str, String str2, String str3) {
        if (f2193a) {
            try {
                doDumpLogcat(str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(boolean z10) {
        c = z10;
        if (f2193a) {
            doSetResendSigQuit(z10 ? 1 : 0);
        }
    }

    public static boolean g(Context context) {
        boolean z10;
        String str;
        if (b) {
            z10 = f2193a;
        } else {
            boolean z11 = true;
            b = true;
            if (!f2193a) {
                try {
                    System.loadLibrary("apminsighta");
                } catch (Throwable unused) {
                    z11 = false;
                }
                f2193a = z11;
            }
            z10 = f2193a;
        }
        if (z10) {
            String str2 = j.C(context) + "/apminsight";
            new File(str2).mkdirs();
            if (new File(context.getApplicationInfo().nativeLibraryDir, "libapminsightb.so").exists()) {
                str = context.getApplicationInfo().nativeLibraryDir;
            } else {
                str = g.f2160a.getFilesDir() + "/apminsight/selflib/";
                r rVarI = l.i();
                b bVar = new b();
                bVar.b = false;
                rVarI.a(bVar);
            }
            doStart(Build.VERSION.SDK_INT, str, str2, g.g(), g.o);
        }
        return z10;
    }

    public static int h() {
        if (f2193a) {
            return doCreateCallbackThread();
        }
        return -1;
    }

    @Keep
    private static void handleNativeCrash(String str) {
        NativeCrashCollector.onNativeCrash(str);
    }

    public static void i(int i) {
        if (f2193a) {
            try {
                doCloseFile(i);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    private static native boolean is64Bit();

    public static void j(long j5) {
        if (f2193a) {
            try {
                doSetAlogFlushAddr(j5);
            } catch (Throwable unused) {
            }
        }
    }

    public static void k(String str) {
        if (f2193a) {
            doDumpHprof(str);
        }
    }

    public static int l(String str) {
        if (f2193a && !TextUtils.isEmpty(str)) {
            try {
                return doLock(str, -1);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static long m(int i) {
        if (f2193a) {
            return doGetThreadCpuTime(i);
        }
        return 0L;
    }

    public static void n() {
        if (f2193a) {
            try {
                String strG = g.g();
                File file = new File(j.C(g.f2160a), "apminsight/alogCrash");
                file.mkdirs();
                doSetAlogConfigPath(file.getPath() + "/native_" + strG + ".atmp");
            } catch (Throwable unused) {
            }
        }
    }

    public static void o(long j5) {
        if (f2193a) {
            try {
                doSetAlogLogDirAddr(j5);
            } catch (Throwable unused) {
            }
        }
    }

    public static void p(String str) {
        if (f2193a) {
            try {
                doDumpMemInfo(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean q() {
        if (!f2193a) {
            return false;
        }
        try {
            return doCheckNativeCrash();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void r(String str) {
        if (f2193a) {
            try {
                doDumpFds(str);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    private static void reportEventForAnrMonitor() {
        try {
            System.currentTimeMillis();
            Context context = g.f2160a;
            d.C();
        } catch (Throwable unused) {
        }
    }

    public static boolean s() {
        if (!f2193a) {
            return false;
        }
        try {
            return is64Bit();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void t(String str) {
        if (f2193a) {
            try {
                doDumpMaps(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void u(String str) {
        if (f2193a) {
            try {
                doDumpThreads(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static int v(String str) {
        if (!f2193a) {
            return -1;
        }
        try {
            return doOpenFile(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void w() {
        if (f2193a) {
            doSignalMainThread();
        }
    }

    public static void x() {
        if (f2193a) {
            doSetUploadEnd();
        }
    }

    public static void y(String str) {
        if (f2193a) {
            doDump(str);
        }
    }

    public static void z() {
        if (f2193a) {
            doInitThreadDump();
        }
    }
}
