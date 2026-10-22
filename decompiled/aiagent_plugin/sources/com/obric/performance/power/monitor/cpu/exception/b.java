package com.obric.performance.power.monitor.cpu.exception;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: CPUExceptionDiagnosisConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f36979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f36980b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f36981c = null;

    public static final List<String> a() {
        return f36979a;
    }

    static {
        f36979a = p.b(new String[]{"java", "javax", "sun", "android", "kotlin", "org", "com.android", "dalvik", "de", "$", MonitorConstants.IO, "okio", "butterknife", "libcore", "androidx", "Y.ACallable", "Y.ARunnable", "J.N", "com.google"});
        f36980b = p.b(new String[]{"HeapTaskDaemon", "FinalizerDaemon", "FinalizerWatchdogDaemon", "ReferenceQueueDaemon", "Profile Saver", "Signal Catcher", "cpu-exception-diagnosis"});
        f36981c = p.b(new String[]{"Jit thread", "Binder:", "HwBinder:", "hwui"});
    }

    public static final List<String> b() {
        return f36980b;
    }

    public static final List<String> c() {
        return f36981c;
    }
}
