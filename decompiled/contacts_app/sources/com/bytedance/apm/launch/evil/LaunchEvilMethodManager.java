package com.bytedance.apm.launch.evil;

import android.os.Handler;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.perf.monitor.EvilMethodTracer;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchEvilMethodManager {
    private static final String LAUNCH_EVIL_METHOD_SCENE = "app_launch_evil_method_scene_apm_2";
    private static final long MAX_INTERVAL = 10000;
    private static EvilMethodTracer evilMethodTracer = null;
    private static boolean isOpenDispatch = false;
    private static boolean isStarted = false;

    static {
    }

    public LaunchEvilMethodManager() {
    }

    public static synchronized void startMonitorEvilMethod() {
        monitor-enter(LaunchEvilMethodManager.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isStarted == false) goto L9;
        monitor-exit(LaunchEvilMethodManager.class);
        return;
    L9:
        isStarted = true;     // Catch: Throwable -> L18
        if (isOpenDispatch == true) goto L15;
        isOpenDispatch = true;     // Catch: Throwable -> L18
        EvilMethodTracer.setEvilThresholdMs(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L18
        EvilMethodTracer.setIsEvilMethodTraceEnable(true);     // Catch: Throwable -> L18
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L14;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L18
    L14:
        MainThreadMonitor.getMonitor().init();     // Catch: Throwable -> L18
        MethodCollector.getInstance().onStart();     // Catch: Throwable -> L18
        EvilMethodTracer.isMethodTraced = true;     // Catch: Throwable -> L18
        EvilMethodTracer r2 = new EvilMethodTracer(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L18
        evilMethodTracer = r2;     // Catch: Throwable -> L18
        r2.startTrace();     // Catch: Throwable -> L18
        LooperMonitor.dispatch(true, "launch", null);     // Catch: Throwable -> L18
        new Handler().postDelayed(new AnonymousClass1(), MAX_INTERVAL);     // Catch: Throwable -> L18
    L15:
        FpsTracer.addScene(LAUNCH_EVIL_METHOD_SCENE);     // Catch: Throwable -> L18
        monitor-exit(LaunchEvilMethodManager.class);
    }

    public static synchronized void stopMonitorEvilMethod() {
        monitor-enter(LaunchEvilMethodManager.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isStarted == true) goto L9;
        monitor-exit(LaunchEvilMethodManager.class);
        return;
    L9:
        isStarted = false;     // Catch: Throwable -> L12
        evilMethodTracer.setLimitDepth(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        EvilMethodTracer.setEvilThresholdMs(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        FpsTracer.removeScene(LAUNCH_EVIL_METHOD_SCENE);     // Catch: Throwable -> L12
        monitor-exit(LaunchEvilMethodManager.class);
    }

    public static synchronized void registerEvilMethodConfig() {
        monitor-enter(LaunchEvilMethodManager.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (evilMethodTracer != null) goto L7;
    L9:
        monitor-exit(LaunchEvilMethodManager.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L9;
        evilMethodTracer.registerConfig();     // Catch: Throwable -> L11
        goto L9
    }
}
