package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.DelayTime;
import com.bytedance.lego.init.monitor.DelayTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.DelayTaskExtendKt;
import com.bytedance.lego.init.util.InitLogger;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DelayTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelayTaskDispatcher {
    public static final DelayTaskDispatcher INSTANCE = null;
    private static final int MSG_10min = 1008;
    private static final int MSG_15min = 1009;
    private static final int MSG_15s = 1003;
    private static final int MSG_2min = 1006;
    private static final int MSG_30s = 1004;
    private static final int MSG_5min = 1007;
    private static final int MSG_5s = 1001;
    private static final int MSG_60s = 1005;
    private static final int MSG_8s = 1002;
    private static final String TAG = "DelayTaskDispatcher";
    private static volatile int allDelayTaskCount;
    private static volatile AtomicInteger completedTaskCount;
    private static final Map<DelayTime, PriorityQueue<DelayTaskInfo>> delayTaskMap = null;
    private static volatile boolean inited;
    private static final Handler mainHandler = null;
    private static long onCreateEndTime;
    private static boolean started;

    /* JADX INFO: renamed from: com.bytedance.lego.init.DelayTaskDispatcher$dispatchTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: DelayTaskDispatcher.kt */
    static final class AnonymousClass1 extends p implements a<x> {
        final /* synthetic */ DelayTaskInfo $task;

        AnonymousClass1(DelayTaskInfo r1) {
            this.$task = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$task.mustRunInMainThread == true) goto L5;
            DelayTaskDispatcher r0 = DelayTaskDispatcher.INSTANCE;
            DelayTaskInfo r3 = this.$task;
            o.b(r3, "task");
            DelayTaskDispatcher.access$runTask(r0, r3, false);
            return;
        L5:
            DelayTaskDispatcher.INSTANCE.getMainHandler().post((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC01951(this), Runnable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lego.init.DelayTaskDispatcher$sendMonitorData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DelayTaskDispatcher.kt */
    static final class C11011 extends p implements a<x> {
        public static final C11011 INSTANCE = null;

        static {
            INSTANCE = new C11011();
        }

        C11011() {
            super(0);
        }

        @Override // d.h.a.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DelayTaskMonitor.INSTANCE.sendDelayTaskMonitor();
        }
    }

    static {
        INSTANCE = new DelayTaskDispatcher();
        delayTaskMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        completedTaskCount = new AtomicInteger(0);
        onCreateEndTime = -1;
        mainHandler = new Handler(Looper.getMainLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(DelayTaskDispatcher$mainHandler$1.INSTANCE, Handler.Callback.class, "com.obric.aiagent.plugin"));
    }

    private DelayTaskDispatcher() {
    }

    public static final /* synthetic */ void access$dispatchTask(DelayTaskDispatcher r0, PriorityQueue r1) {
        r0.dispatchTask(r1);
    }

    public static final /* synthetic */ Map access$getDelayTaskMap$p(DelayTaskDispatcher r0) {
        return delayTaskMap;
    }

    public static final /* synthetic */ long access$getOnCreateEndTime$p(DelayTaskDispatcher r2) {
        return onCreateEndTime;
    }

    public static final /* synthetic */ void access$initDelayTasks(DelayTaskDispatcher r0) {
        r0.initDelayTasks();
    }

    public static final /* synthetic */ void access$runTask(DelayTaskDispatcher r0, DelayTaskInfo r1, boolean r2) {
        r0.runTask(r1, r2);
    }

    public static final /* synthetic */ void access$setOnCreateEndTime$p(DelayTaskDispatcher r0, long r1) {
        onCreateEndTime = r1;
    }

    public final Handler getMainHandler() {
        return mainHandler;
    }

    public final synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (started == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        started = true;     // Catch: Throwable -> L11
        onCreateEndTime = System.currentTimeMillis();     // Catch: Throwable -> L11
        InitLogger.INSTANCE.d(TAG, "start, curTime: " + onCreateEndTime);     // Catch: Throwable -> L11
        DelayTaskMonitor.INSTANCE.setOnCreateEnd(onCreateEndTime);     // Catch: Throwable -> L11
        Handler r0 = mainHandler;     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1001, 5000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1002, 8000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1003, 15000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1004, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1005, 60000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1006, 120000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1007, 300000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1008, 600000);     // Catch: Throwable -> L11
        r0.sendEmptyMessageDelayed(1009, 900000);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private final void initDelayTasks() {
        if (inited == false) goto L5;
        return;
    L5:
        inited = true;
        InitLogger.INSTANCE.d(TAG, "initDelayTasks, curTimeFromCreateEnd: " + (System.currentTimeMillis() - onCreateEndTime));
        long r1 = System.currentTimeMillis();
        List<DelayTaskInfo> r4 = TaskCollectorManager.getAllDelayTaskInfo();
        if (r4 == null) goto L21;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L21;
        DelayTaskInfo r7 = (DelayTaskInfo) ZeusTransformUtils.preCheckCast(r5.next(), DelayTaskInfo.class, "com.obric.aiagent.plugin");
        o.b(r7, "delayTaskInfo");
        if (DelayTaskExtendKt.getSupportCurProcess(r7) == false) goto L9;
        Map<DelayTime, PriorityQueue<DelayTaskInfo>> r8 = delayTaskMap;
        if (((PriorityQueue) ZeusTransformUtils.preCheckCast(r8.get(r7.delayTime), PriorityQueue.class, "com.obric.aiagent.plugin")) != null) goto L17;
        DelayTime r9 = r7.delayTime;
        o.b(r9, "delayTaskInfo.delayTime");
        r8.put(r9, new PriorityQueue());
        x r10 = x.f38692a;
    L17:
        PriorityQueue r11 = (PriorityQueue) ZeusTransformUtils.preCheckCast(r8.get(r7.delayTime), PriorityQueue.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        r11.add(r7);
    L20:
        allDelayTaskCount++;
    L21:
        long r6 = System.currentTimeMillis();
        printAllDelayTasks(r4);
        long r12 = r6 - r1;
        InitLogger.INSTANCE.d(TAG, "init cos: " + r12);
        DelayTaskMonitor.INSTANCE.monitor("DelayTaskDispatcher.initDelayTasks", r12, false);
    }

    private final void dispatchTask(PriorityQueue<DelayTaskInfo> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        InitSchedulerExecutorsKt.singleAsync((a) ZeusTransformUtils.preCheckCast(new AnonymousClass1((DelayTaskInfo) ZeusTransformUtils.preCheckCast(r3.poll(), DelayTaskInfo.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void runTask(DelayTaskInfo r9, boolean r10) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L7
        DelayTaskMonitor.INSTANCE.monitorTaskStart(r9, r10);     // Catch: Exception -> L7
        InitLogger.INSTANCE.d(TAG, r9.taskId + " start. startTimeFromOnCreateEnd: " + (r1 - onCreateEndTime));     // Catch: Exception -> L7
        InitLogger.INSTANCE.d(TAG, r9.taskId + " run. isUIThread: " + r10);     // Catch: Exception -> L7
        r9.task.run();     // Catch: Exception -> L7
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L7
        DelayTaskMonitor.INSTANCE.monitorTaskEnd(r9, r10);     // Catch: Exception -> L7
        long r2 = r3 - r1;     // Catch: Exception -> L7
        DelayTaskMonitor.INSTANCE.monitorCosTime(r9, r2, r10);     // Catch: Exception -> L7
        InitLogger.INSTANCE.d(TAG, r9.taskId + " end. endTimeFromOnCreateEnd: " + (r3 - onCreateEndTime) + ", cos " + r2 + " ms.");     // Catch: Exception -> L7
        if (completedTaskCount.incrementAndGet() != allDelayTaskCount) goto L16;
        sendMonitorData();     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        InitLogger.INSTANCE.e(TAG, "\nerror!error!error!  " + r9.taskId + " run error.\n");
        InitLogger r11 = InitLogger.INSTANCE;
        String r4 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        o.b(r4, "Log.getStackTraceString(e)");
        r11.e(TAG, r4);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "RUN_DELAY_TASK_EXCEPTION:" + r9.taskId);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void sendMonitorData() {
        InitLogger.INSTANCE.d(TAG, "sendMonitorData");     // Catch: Exception -> L5
        InitSchedulerExecutorsKt.singleAsync((a) ZeusTransformUtils.preCheckCast(C11011.INSTANCE, a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "DELAY_TASK_MONITOR_EXCEPTION");
    }

    private final void printAllDelayTasks(List<? extends DelayTaskInfo> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L19;
        StringBuilder r5 = new StringBuilder("\n-------------------------   AllDelayTasks   ------------------------\n");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        DelayTaskInfo r1 = (DelayTaskInfo) ZeusTransformUtils.preCheckCast(r6.next(), DelayTaskInfo.class, "com.obric.aiagent.plugin");
        if (DelayTaskExtendKt.getSupportCurProcess(r1) == false) goto L8;
        r5.append(new StringBuilder().append(r1).append('\n').toString());
        goto L8
    L12:
        InitLogger r7 = InitLogger.INSTANCE;
        String r8 = r5.toString();
        o.b(r8, "sb.toString()");
        r7.d(TAG, r8);
        return;
    }
}
