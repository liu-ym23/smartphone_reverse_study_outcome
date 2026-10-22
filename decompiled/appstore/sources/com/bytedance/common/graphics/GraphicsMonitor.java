package com.bytedance.common.graphics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class GraphicsMonitor {
    private static final long COLLECT_WINDOWS = 100;
    private static final String MTK = "mt";
    private static final long POLL_INTERVAL = 15000;
    private static ScheduledFuture<?> gpuFuture = null;
    private static double gpuLoadDataOnce = -1.0d;
    private static ScheduledExecutorService gpuScheduleService = null;
    private static boolean isInit = false;
    private static boolean isInitGraphicsLoad = false;
    private static volatile boolean isPause = false;
    private static ActivityLifecycleService lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    public static class a implements IActivityLifecycleObserver {
        public a() {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityCreated(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityPause(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityStarted(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onBackground(Activity r10) {
            GraphicsMonitor.access$002(true);
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onFront(Activity r10) {
            GraphicsMonitor.access$002(false);
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GraphicsMonitor.access$000() == true) goto L5;
            GraphicsMonitor.access$100();     // Catch: Throwable -> L8
            Thread.sleep(GraphicsMonitor.access$200());     // Catch: Throwable -> L8
            GraphicsMonitor.access$300();     // Catch: Throwable -> L8
            GraphicsMonitor.access$402(GraphicsMonitor.access$500());     // Catch: Throwable -> L8
        L6:
            Log.i("atrace_gpu", "bytegpu: " + GraphicsMonitor.access$400());     // Catch: Throwable -> L8
            return;
        L5:
            GraphicsMonitor.access$402(-1.0d);     // Catch: Throwable -> L8
        }
    }

    static {
    }

    public GraphicsMonitor() {
    }

    public static /* synthetic */ boolean access$000() {
        return isPause;
    }

    public static /* synthetic */ boolean access$002(boolean r10) {
        isPause = r10;
        return r10;
    }

    public static /* synthetic */ void access$100() {
        openStatistical();
    }

    public static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    public static /* synthetic */ void access$300() {
        closeStatistical();
    }

    public static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    public static /* synthetic */ double access$402(double r10) {
        gpuLoadDataOnce = r10;
        return r10;
    }

    public static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    @Keep
    private static native void closeStatistical();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r10 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native double getStatisticOnceData();

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L13
        sCollectInterval = 15000;     // Catch: Throwable -> L13
        sCollectWindow = 100;     // Catch: Throwable -> L13
        ActivityLifecycleService r10 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);     // Catch: Throwable -> L13
        lifecycleService = r10;     // Catch: Throwable -> L13
        r10.register(new a());     // Catch: Throwable -> L13
        if (lifecycleService.isForeground() == false) goto L15;
        isPause = false;     // Catch: Throwable -> L13
    L15:
        monitor-exit(GraphicsMonitor.class);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        PerfMonitorManager.v(r3.a.b());     // Catch: Throwable -> L5
        startHook();     // Catch: Throwable -> L5
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L5
        return;
    L5:
        isInitGraphicsLoad = false;
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r10;
    L7:
        r10 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native void openStatistical();

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L13;
        initGraphicsLoad();     // Catch: Throwable -> L11
    L13:
        ScheduledExecutorService r10 = gpuScheduleService;     // Catch: Throwable -> L11
        if (r10 != null) goto L17;
        monitor-exit(GraphicsMonitor.class);
        return;
    L17:
        int r11 = startTime + 1;     // Catch: Throwable -> L11
        startTime = r11;     // Catch: Throwable -> L11
        if (r11 <= 1) goto L21;
        monitor-exit(GraphicsMonitor.class);
        return;
    L21:
        b r12 = new b();     // Catch: Throwable -> L11
        long r13 = sCollectInterval;     // Catch: Throwable -> L11
        gpuFuture = r10.scheduleWithFixedDelay(r12, r13, r13, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        monitor-exit(GraphicsMonitor.class);
    }

    @Keep
    private static native boolean startHook();

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L21:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L21;
        int r10 = startTime - 1;     // Catch: Throwable -> L16
        startTime = r10;     // Catch: Throwable -> L16
        if (r10 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r11 = gpuFuture;     // Catch: Throwable -> L16
        if (r11 == null) goto L18;
        r11.cancel(true);     // Catch: Throwable -> L16
    L18:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L16
        monitor-exit(GraphicsMonitor.class);
    }
}
