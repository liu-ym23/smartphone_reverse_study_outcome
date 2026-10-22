package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetLibraryLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18551b = "CronetLibraryLoader";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HandlerThread f18552c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f18553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f18554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConditionVariable f18555f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f18556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f18557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f18558i;

    public interface Natives {
        void cronetInitOnInitThread();

        String getCronetVersion();
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b();
        }
    }

    static {
        f18550a = new Object();
        f18552c = new HandlerThread("CronetInit");
        f18553d = false;
        f18555f = new ConditionVariable();
    }

    public static void a(Context r10, CronetEngineBuilderImpl r11) {
        Object r12 = f18550a;
        monitor-enter(r12);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f18554e == true) goto L13;
        com.ttnet.org.chromium.base.e.e(r10);     // Catch: Throwable -> L9
        HandlerThread r13 = f18552c;     // Catch: Throwable -> L9
        if (r13.isAlive() == true) goto L11;
        r13.start();     // Catch: Throwable -> L9
    L11:
        e(new a());     // Catch: Throwable -> L9
    L13:
        if (f18553d == true) goto L19;
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        c(r11);     // Catch: Throwable -> L9
        f18558i = SystemClock.uptimeMillis() - r14;     // Catch: Throwable -> L9
        String r15 = ImplVersion.a();     // Catch: Throwable -> L9
        if (r15.equals(b.b().getCronetVersion()) == false) goto L18;
        com.ttnet.org.chromium.base.j.d(f18551b, "Cronet version: %s, arch: %s", new Object[]{r15, System.getProperty("os.arch")});     // Catch: Throwable -> L9
        f18553d = true;     // Catch: Throwable -> L9
        f18555f.open();     // Catch: Throwable -> L9
        goto L19
    L18:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r15, b.b().getCronetVersion()}));     // Catch: Throwable -> L9
    L19:
        monitor-exit(r12);     // Catch: Throwable -> L9
    }

    public static void b() {
        if (f18554e == false) goto L5;
        return;
    L5:
        f18556g = System.currentTimeMillis();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.n();
        f18555f.block();
        b.b().cronetInitOnInitThread();
        f18554e = true;
        f18557h = System.currentTimeMillis();
    }

    public static void c(CronetEngineBuilderImpl r10) {
        String r11 = r10.U();
        if (TextUtils.isEmpty(r11) == true) goto L11;
        File r12 = new File(r11);
        if (r12.exists() == false) goto L11;
        if (r12.isDirectory() == true) goto L11;
        com.ttnet.org.chromium.base.j.d(f18551b, "cronet so load: %s", new Object[]{r11});
        System.load(r11);
        return;
    L11:
        if (r10.i0() == null) goto L13;
        r10.i0().loadLibrary("sscronet");
        return;
    L13:
        System.loadLibrary("sscronet");
    }

    public static boolean d() {
        if (f18552c.getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(Runnable r10) {
        if (d() == false) goto L5;
        r10.run();
        return;
    L5:
        new Handler(f18552c.getLooper()).post(r10);
    }

    @CalledByNative
    private static void ensureInitializedFromNative() {
        Object r10 = f18550a;
        monitor-enter(r10);
        f18553d = true;     // Catch: Throwable -> L9
        f18555f.open();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        a(com.ttnet.org.chromium.base.e.d(), null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static String getDefaultUserAgent() {
        return u.b(com.ttnet.org.chromium.base.e.d());
    }

    @CalledByNative
    private static void setNetworkThreadPriorityOnNetworkThread(int r10) {
        Process.setThreadPriority(r10);
    }
}
