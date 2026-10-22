package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitTraceUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitScheduler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitScheduler {
    private static final String INIT_SCHEDULER_CATEGORY = "init_scheduler";
    public static final InitScheduler INSTANCE = null;
    public static TaskConfig config;
    private static WeakReference<Activity> mainActivityWR;
    private static WeakReference<Activity> splashActivityWR;
    private static ThreadPoolExecutor taskExecutor;

    static {
        INSTANCE = new InitScheduler();
        INIT_SCHEDULER_CATEGORY = "init_scheduler";
    }

    private InitScheduler() {
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r1 = config;
        if (r1 != null) goto L5;
        o.c("config");
    L5:
        return r1;
    }

    public final void setConfig$initscheduler_release(TaskConfig r1) {
        o.d(r1, "<set-?>");
        config = r1;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    public static final void config(TaskConfig r3) {
        o.d(r3, "config");
        config = r3;
        IdleTaskDispatcher.INSTANCE.config(r3.getIdleTaskConfig());
        IdleTaskMonitor.INSTANCE.setApplicationStartTime(r3.getApplicationStartTime());
    }

    public static final void setServiceManagerProxy(IServiceManagerProxy r2) {
        IServiceManagerProxy r3 = (IServiceManagerProxy) ZeusTransformUtils.wrapperContextForParams(r2, IServiceManagerProxy.class, "com.obric.aiagent.plugin");
        o.d(r3, "proxy");
        ServiceManagerProxy.INSTANCE.setProxy$initscheduler_release(r3);
    }

    public static final void setExecutorService(ThreadPoolExecutor r1) {
        o.d(r1, "executor");
        taskExecutor = r1;
    }

    public static final void onPeriodStart(InitPeriod r9) {
        o.d(r9, "period");
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        o.c("config");
    L5:
        r0.isDebug();
        InitTaskDispatcher.INSTANCE.onPeriod(r9, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r2 = InitMonitor.INSTANCE;
        Category r3 = Category.ON_PERIOD_EXCEPTION;
        String r4 = r9.name();
        JSONObject r5 = new JSONObject();
        r5.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        r2.monitorEvent(r3, r4, r5);
        TaskConfig r6 = config;
        if (r6 != null) goto L13;
        o.c("config");
    L13:
        if (r6.getCatchException() == false) goto L17;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "ON_PERIOD_EXCEPTION:" + r9.name());
        return;
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void onPeriodEnd(InitPeriod r8) {
        o.d(r8, "period");
        InitTaskDispatcher.INSTANCE.onPeriod(r8, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r1 = InitMonitor.INSTANCE;
        Category r2 = Category.ON_PERIOD_EXCEPTION;
        String r3 = r8.name();
        JSONObject r4 = new JSONObject();
        r4.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        r1.monitorEvent(r2, r3, r4);
        TaskConfig r5 = config;
        if (r5 != null) goto L10;
        o.c("config");
    L10:
        if (r5.getCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "ON_PERIOD_EXCEPTION:" + r8.name());
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void startDispatchDelayTask() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        o.c("config");
    L5:
        r0.isDebug();
        DelayTaskDispatcher.INSTANCE.start();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "START_DELAY_TASK_DISPATCHER");
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void startDispatchIdleTask() {
        IdleTaskDispatcher.INSTANCE.bootFinish();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L10;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "START_IDLE_TASK_DISPATCHER");
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void onFeedShow() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        o.c("config");
    L5:
        r0.isDebug();
        FeedShowTaskDispatcher.INSTANCE.onFeedShow();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void registerMainActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.d(r4, "mainActivity");
        mainActivityWR = new WeakReference(r4);
        i r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, p.class) == true) goto L5;
        r4 = null;
    L5:
        p r5 = (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        r2 = r5.getLifecycle();
    L8:
        if (r2 == null) goto L12;
        PeriodTaskManager.INSTANCE.registerMain$initscheduler_release(r2);
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("mainActivity must be LifecycleOwner."), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void registerSplashActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.d(r4, "splashActivity");
        splashActivityWR = new WeakReference(r4);
        i r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, p.class) == true) goto L5;
        r4 = null;
    L5:
        p r5 = (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        r2 = r5.getLifecycle();
    L8:
        if (r2 == null) goto L12;
        PeriodTaskManager.INSTANCE.registerSplash$initscheduler_release(r2);
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("splashActivity must be LifecycleOwner."), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.aiagent.plugin");
    }

    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.aiagent.plugin");
    }

    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r1 = config;     // Catch: Exception -> L7
        if (r1 != null) goto L5;
        o.c("config");     // Catch: Exception -> L7
    L5:
        return r1.isDebug();
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L7;
        if (r1 != null) goto L6;
        o.a();
    L6:
        return r1;
    L7:
        TaskConfig r2 = config;
        if (r2 != null) goto L10;
        o.c("config");
    L10:
        ThreadPoolExecutor r3 = r2.getTaskExecutor();
        if (r3 != null) goto L13;
        o.a();
    L13:
        return r3;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r1 = taskExecutor;
        if (r1 == null) goto L13;
        return r1;
    L13:
        TaskConfig r2 = config;     // Catch: Exception -> L10
        if (r2 != null) goto L8;
        o.c("config");     // Catch: Exception -> L10
    L8:
        return r2.getTaskExecutor();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r1 = config;
        if (r1 != null) goto L6;
        o.c("config");
    L6:
        return r1.getMode();
    }

    public final boolean enableCatchException() {
        TaskConfig r1 = config;
        if (r1 != null) goto L6;
        o.c("config");
    L6:
        return r1.getCatchException();
    }

    public static final void afterPrivacyPopupWindow() {
        InitTaskDispatcher.INSTANCE.startPrivacyTask();     // Catch: Exception -> L4
    L8:
        TaskConfig r0 = config;
        if (r0 != null) goto L11;
        o.c("config");
    L11:
        r0.setAgreePrivacyPopupWindow(true);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L14;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "START_DELAY_TASK_DISPATCHER");
        goto L8
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final void initTasks() {
        InitTraceUtil.INSTANCE.beginSection("initTasks");
        InitTaskDispatcher.INSTANCE.init();
        x r0 = x.f38692a;
        InitTraceUtil.INSTANCE.endSection();
    }

    public static final void initPeriodTask() {
        InitTraceUtil.INSTANCE.beginSection("initPeriodTask");
        PeriodTaskManager.INSTANCE.init();
        x r0 = x.f38692a;
        InitTraceUtil.INSTANCE.endSection();
    }
}
