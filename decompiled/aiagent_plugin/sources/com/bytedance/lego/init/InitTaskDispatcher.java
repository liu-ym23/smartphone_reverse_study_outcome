package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.lego.init.util.InitTaskExtendKt;
import com.bytedance.lego.init.util.InitTraceUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import d.h.b.y;
import d.h.b.z;
import d.j;
import d.m.h;
import d.t;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitTaskDispatcher implements Runnable {
    static final /* synthetic */ h[] $$delegatedProperties = null;
    public static final InitTaskDispatcher INSTANCE = null;
    private static final String TAG = "InitTaskDispatcher";
    private static final CopyOnWriteArrayList<ReadyTask> afterPrivacyTask = null;
    private static final List<InitPeriod> allPeriods = null;
    private static boolean asyncStarted;
    private static Thread dispatchThread;
    private static final f executor$delegate = null;
    private static boolean hasNoneTask;
    private static final CountDownLatch initTaskCountDownLatch = null;
    private static boolean inited;
    private static long lastUITaskEnd;
    private static final Handler mainHandler = null;
    private static final List<ReadyTask> nonUITaskList = null;
    private static final Object nonUITaskListLock = null;
    private static final List<InitPeriod> periodDoneList = null;
    private static final InitTaskManager taskManager = null;

    /* JADX INFO: renamed from: com.bytedance.lego.init.InitTaskDispatcher$startPrivacyTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitTaskDispatcher.kt */
    static final class AnonymousClass1 extends p implements a<x> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        @Override // d.h.a.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(InitTaskDispatcher.access$getAfterPrivacyTask$p(InitTaskDispatcher.INSTANCE), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            final ReadyTask r0 = (ReadyTask) ZeusTransformUtils.preCheckCast(r5.next(), ReadyTask.class, "com.obric.aiagent.plugin");
            if (r0.getInitTaskInfo().mustRunInMainThread == true) goto L7;
            InitTaskDispatcher.access$runTask(InitTaskDispatcher.INSTANCE, r0.getInitTaskInfo());
            goto L4
        L7:
            final CountDownLatch r2 = new CountDownLatch(1);
            InitTaskDispatcher.access$getMainHandler$p(InitTaskDispatcher.INSTANCE).post((Runnable) ZeusTransformUtils.preCheckCast(new InitTaskDispatcher$startPrivacyTask$1$1$1(r0, r2), Runnable.class, "com.obric.aiagent.plugin"));
            r2.await();
            goto L4
        }
    }

    private final ThreadPoolExecutor getExecutor() {
        f r2 = executor$delegate;
        h r0 = $$delegatedProperties[0];
        return (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2.b(), ThreadPoolExecutor.class, "com.obric.aiagent.plugin");
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(InitTaskDispatcher.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;")), h.class, "com.obric.aiagent.plugin")};
        INSTANCE = new InitTaskDispatcher();
        taskManager = new InitTaskManager();
        executor$delegate = g.a(j.f38507c, (a) ZeusTransformUtils.preCheckCast(InitTaskDispatcher$executor$2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
        initTaskCountDownLatch = new CountDownLatch(1);
        allPeriods = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        periodDoneList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        nonUITaskList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        nonUITaskListLock = new Object();
        afterPrivacyTask = new CopyOnWriteArrayList();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    private InitTaskDispatcher() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getAfterPrivacyTask$p(InitTaskDispatcher r0) {
        return afterPrivacyTask;
    }

    public static final /* synthetic */ CountDownLatch access$getInitTaskCountDownLatch$p(InitTaskDispatcher r0) {
        return initTaskCountDownLatch;
    }

    public static final /* synthetic */ boolean access$getInited$p(InitTaskDispatcher r0) {
        return inited;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(InitTaskDispatcher r0) {
        return mainHandler;
    }

    public static final /* synthetic */ InitTaskManager access$getTaskManager$p(InitTaskDispatcher r0) {
        return taskManager;
    }

    public static final /* synthetic */ void access$runTask(InitTaskDispatcher r0, InitTaskInfo r1) {
        r0.runTask(r1);
    }

    public static final /* synthetic */ void access$setInited$p(InitTaskDispatcher r0, boolean r1) {
        inited = r1;
    }

    public final boolean getHasNoneTask$initscheduler_release() {
        return hasNoneTask;
    }

    public final void setHasNoneTask$initscheduler_release(boolean r1) {
        hasNoneTask = r1;
    }

    public final void init() {
        if (inited == false) goto L5;
        return;
    L5:
        initInternal();
    }

    public final void onPeriod(InitPeriod r13, boolean r14) {
        o.d(r13, "period");
        long r0 = System.currentTimeMillis();
        if (r14 == false) goto L5;
        String r2 = "-END";
    L7:
        if (checkPeriod(r13, r14) == true) goto L9;
        return;
    L9:
        InitMonitor.INSTANCE.monitorStart(r13.name() + r2, true);
        InitTraceUtil.INSTANCE.beginSection("onPeriod-" + r13.name() + r2);
        if (inited == true) goto L13;
        InitLogger.d$default(InitLogger.INSTANCE, null, "wait init countdownlatch " + r13.name(), 1, null);
        long r7 = System.currentTimeMillis();
        initTaskCountDownLatch.await();
        InitMonitor.INSTANCE.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r7, true);
        InitLogger.INSTANCE.d("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r7));
    L13:
        if (hasNoneTask == false) goto L17;
        InitLogger.e$default(InitLogger.INSTANCE, null, "No task.", 1, null);
        return;
    L17:
        if (asyncStarted == true) goto L19;
        startAsyncTask();
    L19:
        InitLogger.d$default(InitLogger.INSTANCE, null, "onPeriod: " + r13.name() + r2, 1, null);
        takeTaskInMainThread(r13, r14);
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(r13.name() + r2, true);
        InitMonitor.INSTANCE.monitorCosTime("onPeriod-" + r13.name() + r2, System.currentTimeMillis() - r0, true);
        return;
    L5:
        r2 = "-START";
        goto L7
    }

    private final boolean checkPeriod(InitPeriod r7, boolean r8) {
        List<InitPeriod> r6 = allPeriods;
        if (r6.contains(r7) == false) goto L5;
        return false;
    L5:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r9.hasNext() == false) goto L14;
        Object r0 = r9.next();
        if (((InitPeriod) ZeusTransformUtils.preCheckCast(r0, InitPeriod.class, "com.obric.aiagent.plugin")).getValue() < r7.getValue()) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
    L16:
        if (((InitPeriod) ZeusTransformUtils.preCheckCast(r0, InitPeriod.class, "com.obric.aiagent.plugin")) == null) goto L18;
        return false;
    L18:
        if (r8 == false) goto L20;
        allPeriods.add(r7);
    L20:
        return true;
    L11:
        r4 = false;
        goto L12
    L14:
        r0 = null;
        goto L16
    }

    private final void startAsyncTask() {
        InitLogger.INSTANCE.d("InitTaskDispatcher", "startAsyncTask");
        InitTraceUtil.INSTANCE.beginSection("startAsyncTask");
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));
        dispatchThread = r0;
        if (r0 == null) goto L5;
        r0.start();
    L5:
        asyncStarted = true;
        InitTraceUtil.INSTANCE.endSection();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.bytedance.lego.init.model.InitTaskInfo] */
    /* JADX WARN: Type inference failed for: r5v23, types: [T, com.bytedance.lego.init.model.InitTaskInfo] */
    /* JADX WARN: Type inference failed for: r5v54, types: [T, com.bytedance.lego.init.model.InitTaskInfo] */
    private final void takeTaskInMainThread(InitPeriod r14, boolean r15) {
    L3:
        if (periodDoneList.contains(r14) == true) goto L111;
        final z.f r0 = new z.f();
        if (r15 == false) goto L59;
        r0.f38504a = taskManager.takeUiTaskIfExist(0);
        if (((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) != null) goto L33;
        ReadyTask r5 = (ReadyTask) ZeusTransformUtils.preCheckCast(null, ReadyTask.class, "com.obric.aiagent.plugin");
        Object r6 = nonUITaskListLock;
        monitor-enter(r6);
        Iterator<ReadyTask> r7 = nonUITaskList.iterator();     // Catch: Throwable -> L29
    L13:
        if (r7.hasNext() == false) goto L23;
        ReadyTask r8 = (ReadyTask) ZeusTransformUtils.preCheckCast(r7.next(), ReadyTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        InitTaskManager r9 = taskManager;     // Catch: Throwable -> L29
        String r10 = r8.getInitTaskInfo().taskId;     // Catch: Throwable -> L29
        o.b(r10, "runnable.initTaskInfo.taskId");     // Catch: Throwable -> L29
        float r11 = r9.getPriorityByTaskId(r10);     // Catch: Throwable -> L29
        if (r11 <= 0) goto L13;
        InitPeriod r12 = r8.getInitTaskInfo().endPeriod;     // Catch: Throwable -> L29
        o.b(r12, "runnable.initTaskInfo.endPeriod");     // Catch: Throwable -> L29
        if (r12.getValue() > r14.getValue()) goto L13;
        if (r11 <= r9.getPriorityByTaskId(r14.name() + Constants.END)) goto L13;
        r7.remove();     // Catch: Throwable -> L29
        if (INSTANCE.getExecutor().remove((Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.aiagent.plugin")) == false) goto L13;
        InitLogger.d$default(InitLogger.INSTANCE, null, "execute async-task:" + r8.getInitTaskInfo().taskId + " in UIThread.", 1, null);     // Catch: Throwable -> L29
        r5 = r8;
    L23:
        x r13 = x.f38692a;     // Catch: Throwable -> L29
        monitor-exit(r6);
        if (r5 == null) goto L27;
        r5.run();
        lastUITaskEnd = System.currentTimeMillis();
    L27:
        if (r5 != null) goto L33;
        r0.f38504a = taskManager.takeNonUiTaskMainThreadIfExist(r14);
    L29:
        th = move-exception;
        throw th;
    L33:
        if (((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) != null) goto L57;
        InitTaskDispatcher r16 = (InitTaskDispatcher) ZeusTransformUtils.preCheckCast(this, InitTaskDispatcher.class, "com.obric.aiagent.plugin");
        if ((System.currentTimeMillis() - lastUITaskEnd) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L55;
        InitLogger.d$default(InitLogger.INSTANCE, null, "UIThread wait timeout.", 1, null);
        INSTANCE.sendPeriodTimeoutException(r14);
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(taskManager.getTaskDependencyById(r14.name() + Constants.END), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L49
    L40:
        if (r17.hasNext() == false) goto L55;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        InitTaskManager r19 = taskManager;     // Catch: Exception -> L49
        InitTaskInfo r20 = r19.getInitTaskInfoById(r18);     // Catch: Exception -> L49
        if (r20 == null) goto L40;
        long r21 = System.currentTimeMillis() - r20.startTime;     // Catch: Exception -> L49
        if (r20.startTime <= 0) goto L40;
        if (r21 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L40;
        r19.onTaskComplete(r20);     // Catch: Exception -> L49
        INSTANCE.sendTaskTimeoutException(r20);     // Catch: Exception -> L49
        InitLogger.d$default(InitLogger.INSTANCE, null, "Task " + r20.taskId + " timeout, is forced to complete.", 1, null);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L54;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "letTimeoutTaskCompele");
        goto L55
    L54:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L55:
        x r1 = x.f38692a;
    L57:
        if (((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) == null) goto L3;
    L62:
        long r2 = System.currentTimeMillis();
        if (InitTaskExtendKt.isInternalTask((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) == false) goto L65;
    L73:
        InitTraceUtil.INSTANCE.beginTask((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin"));
        InitLogger.d$default(InitLogger.INSTANCE, null, ((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")).taskId + " complete directly. cos " + (System.currentTimeMillis() - r2) + "ms", 1, null);
        taskManager.onTaskComplete((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin"));
        InitTraceUtil.INSTANCE.endTask();
        if (InitTaskExtendKt.isInternalTask((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) == true) goto L76;
    L78:
        lastUITaskEnd = System.currentTimeMillis();
        goto L3
    L76:
        if (o.a(r14.name() + Constants.END, ((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")).taskId) == false) goto L78;
        InitMonitor.INSTANCE.monitorCosTime("wait: " + r14.name(), System.currentTimeMillis() - lastUITaskEnd, true);
        InitLogger.d$default(InitLogger.INSTANCE, null, "wait: " + r14.name() + ' ' + (System.currentTimeMillis() - lastUITaskEnd) + "ms.", 1, null);
        periodDoneList.add(r14);
        return;
    L65:
        if (InitTaskExtendKt.getSupportCurProcess((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")) == false) goto L73;
        if (((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")).afterPrivacyPopupWindow == true) goto L70;
    L72:
        runTask((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin"));
        goto L78
    L70:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L72;
        afterPrivacyTask.add(new InitTaskDispatcher$takeTaskInMainThread$runnable$1(r0));
        InitLogger.d$default(InitLogger.INSTANCE, null, ((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin")).taskId + " skip directly.", 1, null);
        taskManager.onTaskComplete((InitTaskInfo) ZeusTransformUtils.preCheckCast(r0.f38504a, InitTaskInfo.class, "com.obric.aiagent.plugin"));
        goto L78
    L59:
        ?? r3 = taskManager.takeUiTaskIfExist(0);
        if (r3 == 0) goto L112;
        r0.f38504a = r3;
        goto L62
    L112:
        return;
    }

    public final void beforeSendMonitor() {
        taskManager.beforeSendMonitor();
    }

    @Override // java.lang.Runnable
    public void run() {
    L2:
        InitTaskManager r0 = taskManager;
        final InitTaskInfo r3 = InitTaskManager.takeNonUiTaskIfExist$default(r0, null, 1, null);
        if (r3 == null) goto L23;
        if (InitTaskExtendKt.isInternalTask(r3) == true) goto L22;
        if (InitTaskExtendKt.getSupportCurProcess(r3) == false) goto L22;
        ReadyTask r4 = new InitTaskDispatcher$run$runnable$1(r3);
        if (r3.afterPrivacyPopupWindow == false) goto L14;
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L14;
        afterPrivacyTask.add(r4);
        InitLogger.d$default(InitLogger.INSTANCE, null, r3.taskId + " skip directly.", 1, null);
        r0.onTaskComplete(r3);
    L14:
        getExecutor().execute((Runnable) ZeusTransformUtils.preCheckCast(r4, Runnable.class, "com.obric.aiagent.plugin"));
        Object r1 = nonUITaskListLock;
        monitor-enter(r1);
        nonUITaskList.add(r4);     // Catch: Throwable -> L19
        monitor-exit(r1);
    L19:
        th = move-exception;
        throw th;
    L22:
        InitLogger.d$default(InitLogger.INSTANCE, null, r3.taskId + " complete directly.", 1, null);
        r0.onTaskComplete(r3);
        goto L2
    L23:
        InitLogger.v$default(InitLogger.INSTANCE, null, "异步调度线程 end.", 1, null);
    }

    private final void sendPeriodTimeoutException(InitPeriod r6) {
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L9
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(taskManager.getTaskDependencyById(r6.name() + Constants.END), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.append(((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")) + ' ');     // Catch: Exception -> L9
        goto L5
    L7:
        InitMonitor r2 = InitMonitor.INSTANCE;     // Catch: Exception -> L9
        Category r3 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L9
        String r7 = r6.name();     // Catch: Exception -> L9
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("dependencyTasks", r0.toString());     // Catch: Exception -> L9
        r2.monitorEvent(r3, r7, r4);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "sendPeriodTimeoutException");
    }

    private final void sendTaskTimeoutException(InitTaskInfo r6) {
        InitMonitor r5 = InitMonitor.INSTANCE;
        String r0 = r6.taskId;
        o.b(r0, "task.taskId");
        r5.onTaskTimeout(r0);
        InitMonitor r7 = InitMonitor.INSTANCE;
        Category r1 = Category.TASK_TIMEOUT_EXCEPTION;
        String r2 = r6.taskId;
        o.b(r2, "task.taskId");
        JSONObject r3 = new JSONObject();
        r3.put("startTime", r6.startTime);
        r3.put("curTime", System.currentTimeMillis());
        r7.monitorEvent(r1, r2, r3);
    }

    private final void runTask(InitTaskInfo r12) {
        boolean r0 = o.a(Looper.getMainLooper(), Looper.myLooper());
        InitLogger.v$default(InitLogger.INSTANCE, null, "TaskStart - " + r12 + "  isUIThread:" + r0, 1, null);
        long r1 = System.currentTimeMillis();
        r12.startTime = r1;
        InitMonitor.INSTANCE.monitorTaskStart(r12, r0);
        InitTraceUtil.INSTANCE.beginTask(r12);
    L11:
        e = move-exception;
        InitLogger r6 = InitLogger.INSTANCE;
        StringBuilder r7 = new StringBuilder().append("\nerror!error!error! ").append(r12.taskId).append(" run error.\n ");
        e.printStackTrace();
        r6.e("InitTaskDispatcher", r7.append(x.f38692a).append(" \n").toString());
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L15;
    L19:
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "RUN_TASK_EXCEPTION:" + r12.taskClassName);
        InitMonitor r8 = InitMonitor.INSTANCE;
        Category r9 = Category.RUN_TAK_EXCEPTION;
        String r10 = r12.taskClassName + ":" + e.getClass().getName();
        JSONObject r11 = new JSONObject();
        r11.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        r8.monitorEvent(r9, r10, r11);
    L20:
        InitTraceUtil.INSTANCE.endTask();
        InitMonitor.INSTANCE.monitorTaskEnd(r12, r0);
        long r5 = System.currentTimeMillis();
        r12.endTime = r5;
        InitMonitor.INSTANCE.monitorCosTime(r12, r5 - r1, r0);
        InitLogger.d$default(InitLogger.INSTANCE, null, "Task " + r12.taskId + " done. cos " + (System.currentTimeMillis() - r1) + "ms.", 1, null);
        taskManager.onTaskComplete(r12);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(e, ClassNotFoundException.class) == true) goto L19;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L4:
        if (r12.task == null) goto L6;
        r12.task.run();     // Catch: Exception -> L11
        goto L20
    L6:
        Object r13 = ZeusTransformUtils.forName(r12.taskClassName, "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
        if (r13 == null) goto L10;
        ((IInitTask) ZeusTransformUtils.preCheckCast(r13, IInitTask.class, "com.obric.aiagent.plugin")).run();     // Catch: Exception -> L11
        goto L20
    L10:
        throw new t("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L11
    }

    public final void startPrivacyTask() {
        InitLogger.d$default(InitLogger.INSTANCE, null, "startPrivacyTask", 1, null);
        InitSchedulerExecutorsKt.singleAsync((a) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, a.class, "com.obric.aiagent.plugin"));
    }

    private final void initInternal() {
        long r0 = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug() == false) goto L5;
        InitLogger.INSTANCE.v("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " start");
    L5:
        InitMonitor.INSTANCE.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        InitTraceUtil.INSTANCE.beginSection("InitTaskDispatcher.initInternal");
        InitTaskDispatcher r7 = INSTANCE;
        access$getTaskManager$p(r7).init();
        access$setInited$p(r7, true);
        access$getInitTaskCountDownLatch$p(r7).countDown();
        x r8 = x.f38692a;
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        InitMonitor.INSTANCE.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - r0, false);
        if (InitLogger.INSTANCE.isDebug() == false) goto L9;
        InitLogger.INSTANCE.d("InitTaskDispatcher", InitMonitor.TASKDISPATCHER_INIT + " done. cos: " + (System.currentTimeMillis() - r0) + "ms.");
        return;
    }
}
