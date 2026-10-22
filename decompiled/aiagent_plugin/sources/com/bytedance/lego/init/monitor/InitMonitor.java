package com.bytedance.lego.init.monitor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.InitTaskDispatcher;
import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.y;
import d.m.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitMonitor {
    static final /* synthetic */ h[] $$delegatedProperties = null;
    private static final String ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
    public static final String ASYNC = "Async:";
    private static final String INIT_SCHEDULER = "init-scheduler";
    public static final InitMonitor INSTANCE = null;
    public static final String MAIN = "Main:";
    private static final String MONITOR_INIT = "init_task_monitor";
    private static final String MONITOR_INIT_EXCEPTION = "init_task_exception_monitor";
    public static final String TASKDISPATCHER_INIT = "InitTaskDispatcher.init";
    public static final String TASK_END_SUFFIX = "##TASKEND";
    public static final String TASK_START_SUFFIX = "##TASKSTART";
    public static final String WAIT_ASYNC_TASK_INIT = "wait_async_task_init";
    private static volatile boolean alreadyFeedShown;
    private static volatile boolean alreadyUpload;
    private static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = null;
    private static final f launchTraceService$delegate = null;
    private static long onAttachBaseTime;
    private static final List<String> timeoutTaskList = null;

    private final ILaunchTrace getLaunchTraceService() {
        f r2 = launchTraceService$delegate;
        h r0 = $$delegatedProperties[0];
        return (ILaunchTrace) ZeusTransformUtils.preCheckCast(r2.b(), ILaunchTrace.class, "com.obric.aiagent.plugin");
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;")), h.class, "com.obric.aiagent.plugin")};
        INSTANCE = new InitMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        timeoutTaskList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        launchTraceService$delegate = g.a((a) ZeusTransformUtils.preCheckCast(InitMonitor$launchTraceService$2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
        ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
        INIT_SCHEDULER = "init-scheduler";
    }

    private InitMonitor() {
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r0) {
        r0.sendStartUpTimeAsyncInternal();
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        FeedShowTaskMonitor.INSTANCE.onAttachBase();
        ILaunchTrace r2 = getLaunchTraceService();
        if (r2 == null) goto L6;
        r2.startTrace();
        return;
    }

    public final void monitorCosTime(InitTaskInfo r2, long r3, boolean r5) {
        o.d(r2, "taskInfo");
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(PeriodTaskInfo r2, long r3, boolean r5) {
        o.d(r2, "taskInfo");
        addDuration(getPeriodTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(String r2, long r3, boolean r5) {
        o.d(r2, "name");
        addDuration(getMonitorTag(r2, r5), r3);
    }

    public final void monitorTaskStart(InitTaskInfo r5, boolean r6) {
        o.d(r5, "taskInfo");
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(r5.moduleName, r5.taskId);
        return;
    }

    public final void monitorTaskEnd(InitTaskInfo r5, boolean r6) {
        o.d(r5, "taskInfo");
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(r5.moduleName, r5.taskId);
        return;
    }

    public final void monitorStart(String r5, boolean r6) {
        o.d(r5, "name");
        addDuration(getMonitorStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorEnd(String r5, boolean r6) {
        o.d(r5, "name");
        addDuration(getMonitorEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitor(String r5) {
        o.d(r5, "name");
        addDuration(r5, System.currentTimeMillis() - onAttachBaseTime);
    }

    private final synchronized void addDuration(String r3, long r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r3, Long.valueOf(r4)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final String getTaskTag(InitTaskInfo r1, boolean r2) {
        if (r2 == false) goto L6;
        return "Main:Task-" + r1.taskId;
    L6:
        return "Async:Task-" + r1.taskId;
    }

    private final String getPeriodTaskTag(PeriodTaskInfo r1, boolean r2) {
        if (r2 == false) goto L6;
        return MAIN + r1.getTaskId();
    L6:
        return ASYNC + r1.getTaskId();
    }

    private final String getMonitorTag(String r1, boolean r2) {
        if (r2 == false) goto L6;
        return MAIN + r1;
    L6:
        return ASYNC + r1;
    }

    private final String getTaskStartTag(InitTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        return MAIN + r2.taskId + TASK_START_SUFFIX;
    L7:
        return ASYNC + r2.taskId + TASK_START_SUFFIX;
    }

    private final String getTaskEndTag(InitTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        return MAIN + r2.taskId + TASK_END_SUFFIX;
    L7:
        return ASYNC + r2.taskId + TASK_END_SUFFIX;
    }

    private final String getMonitorStartTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        return MAIN + r2 + TASK_START_SUFFIX;
    L7:
        return ASYNC + r2 + TASK_START_SUFFIX;
    }

    private final String getMonitorEndTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        return MAIN + r2 + TASK_END_SUFFIX;
    L7:
        return ASYNC + r2 + TASK_END_SUFFIX;
    }

    public final void onFeedFirstShown(boolean r10) {
        long r1 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L25
        boolean r3 = false;
        if (r1 > 30000) goto L6;
        r3 = monitorTaskTimeout();     // Catch: Exception -> L25
    L6:
        if (r10 == true) goto L12;
        ILaunchTrace r11 = getLaunchTraceService();     // Catch: Exception -> L25
        if (r11 == null) goto L10;
        r11.cancelTrace();     // Catch: Exception -> L25
    L10:
        cosTimeList.clear();     // Catch: Exception -> L25
        return;
    L12:
        ILaunchTrace r12 = getLaunchTraceService();     // Catch: Exception -> L25
        if (r12 == null) goto L21;
        Activity r6 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InitScheduler.getMainActivity$initscheduler_release(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
        if (r6 == null) goto L19;
        Class<?> r7 = r6.getClass();     // Catch: Exception -> L25
        if (r7 == null) goto L19;
        String r8 = r7.getName();     // Catch: Exception -> L25
    L20:
        r12.endTrace(2, r8, 20000);     // Catch: Exception -> L25
    L19:
        r8 = null;
    L21:
        addDuration(ALL_FEED_FIRST_SHOWN, r1);     // Catch: Exception -> L25
        InitLogger.d$default(InitLogger.INSTANCE, null, "onFeedFirstShown: cos " + r1 + " ms.", 1, null);     // Catch: Exception -> L25
        if (r3 == true) goto L29;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L25
        return;
    L29:
        return;
    L25:
        e = move-exception;
        ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r2 = Category.OTHER_EXCEPTION;
        String r4 = e.getClass().getName();
        o.b(r4, "e.javaClass.name");
        JSONObject r5 = new JSONObject();
        JSONObject r9 = new JSONObject();
        r9.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        r5.put("exception_detail", r9);
        monitorEvent(r2, r4, r5);
    }

    public final void monitorEvent(Category r4, String r5, JSONObject r6) {
        o.d(r4, "category");
        o.d(r5, "type");
        o.d(r6, "extraLog");
        IApmAgent r3 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        JSONObject r0 = new JSONObject();
        r0.put(r4.getValue(), r5);     // Catch: Exception -> L7
    L9:
        r6.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r6.put("isUIThread", o.a(Looper.getMainLooper(), Looper.myLooper()));
        r3.monitorEvent(MONITOR_INIT, r0, new JSONObject(), r6);
        InitLogger.d$default(InitLogger.INSTANCE, null, r4.name() + ' ' + r5 + ' ' + r6.toString(), 1, null);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void onTaskTimeout(String r3) {
        o.d(r3, DBDefinition.TASK_ID);
        timeoutTaskList.add(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        InitLogger r4 = InitLogger.INSTANCE;
        String r2 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        o.b(r2, "Log.getStackTraceString(e)");
        InitLogger.e$default(r4, null, r2, 1, null);
    }

    private final boolean monitorTaskTimeout() {
        List<String> r4 = timeoutTaskList;     // Catch: Exception -> L12
        if (r4.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L12
    L8:
        if (r5.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        INSTANCE.monitorEvent(Category.TASK_TIMEOUT_EXCEPTION_REAL, InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout() + ':' + r6, new JSONObject());     // Catch: Exception -> L12
        InitLogger.d$default(InitLogger.INSTANCE, null, "TaskTimeout: " + r6 + ", " + InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout(), 1, null);     // Catch: Exception -> L12
        goto L8
    L10:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        InitLogger r7 = InitLogger.INSTANCE;
        String r10 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        o.b(r10, "Log.getStackTraceString(e)");
        InitLogger.e$default(r7, null, r10, 1, null);
        return false;
    }

    public final void ensureNotReachHere(Throwable r4, String r5) {
        o.d(r4, "t");
        o.d(r5, "msg");
        IEnsure r3 = (IEnsure) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IEnsure.class), IEnsure.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.ensureNotReachHere(r4, r5);
    L5:
        IApmAgent r6 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("EnsureNotReachHere", r5);
        JSONObject r7 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("detail", Log.getStackTraceString(r4));
        r6.monitorEvent(MONITOR_INIT_EXCEPTION, r0, r7, r1);
        return;
    }

    public final void monitorLog(LogType r3, JSONObject r4) {
        o.d(r3, "logType");
        o.d(r4, "logExtr");
        IApmAgent r2 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.monitorLog(r3.name(), r4);
        InitLogger.d$default(InitLogger.INSTANCE, null, r3.name() + " " + r4.toString(), 1, null);
        return;
    }

    public final void ensureNotReachHere(Throwable r3) {
        o.d(r3, "t");
        IEnsure r2 = (IEnsure) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IEnsure.class), IEnsure.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.ensureNotReachHere(r3);
        return;
    }

    private final void sendStartUpTimeAsync(long r4) {
        new Handler(Looper.getMainLooper()).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Runnable.class, "com.obric.aiagent.plugin"), r4);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11 Exception -> L13
        r0.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L11 Exception -> L13
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(cosTimeList, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r1.hasNext() == false) goto L7;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11 Exception -> L13
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11 Exception -> L13
        Object r4 = r2.second;     // Catch: Throwable -> L11 Exception -> L13
        o.b(r4, "it.second");     // Catch: Throwable -> L11 Exception -> L13
        r0.put(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L7:
        InitLogger r5 = InitLogger.INSTANCE;     // Catch: Throwable -> L11 Exception -> L13
        String r6 = r0.toString();     // Catch: Throwable -> L11 Exception -> L13
        o.b(r6, "metric.toString()");     // Catch: Throwable -> L11 Exception -> L13
        r5.d("sendStartUpTimeImmediately", r6);     // Catch: Throwable -> L11 Exception -> L13
        IApmAgent r7 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11 Exception -> L13
        if (r7 == null) goto L15;
        r7.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        InitLogger r8 = InitLogger.INSTANCE;     // Catch: Throwable -> L11
        String r9 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        o.b(r9, "Log.getStackTraceString(e)");     // Catch: Throwable -> L11
        InitLogger.d$default(r8, null, r9, 1, null);     // Catch: Throwable -> L11
        Category r10 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L11
        String r11 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L11
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L11
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L11
        r13.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L11
        r12.put("exception_detail", r13);     // Catch: Throwable -> L11
        monitorEvent(r10, r11, r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private final synchronized void sendStartUpTimeAsyncInternal() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (alreadyUpload == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        alreadyUpload = true;     // Catch: Throwable -> L23
        IApmAgent r1 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        alreadyFeedShown = true;     // Catch: Throwable -> L23
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L23
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(cosTimeList, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L16 Throwable -> L23
    L13:
        if (r2.hasNext() == false) goto L18;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 Throwable -> L23
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 Throwable -> L23
        Object r5 = r3.second;     // Catch: Exception -> L16 Throwable -> L23
        o.b(r5, "it.second");     // Catch: Exception -> L16 Throwable -> L23
        r0.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L16 Throwable -> L23
    L18:
        InitLogger r6 = InitLogger.INSTANCE;     // Catch: Throwable -> L23
        String r7 = r0.toString();     // Catch: Throwable -> L23
        o.b(r7, "metric.toString()");     // Catch: Throwable -> L23
        r6.d("sendStartUpTimeAsync", r7);     // Catch: Throwable -> L23
        InitTaskDispatcher.INSTANCE.beforeSendMonitor();     // Catch: Throwable -> L23
        r1.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L23
        cosTimeList.clear();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L18
    L21:
        monitor-exit(this);
    }
}
