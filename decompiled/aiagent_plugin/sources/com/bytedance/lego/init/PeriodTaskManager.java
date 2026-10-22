package com.bytedance.lego.init;

import androidx.lifecycle.i;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.lego.init.util.InitTraceUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PeriodTaskManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PeriodTaskManager {
    public static final PeriodTaskManager INSTANCE = null;
    private static final String TAG = "PeriodTaskManager";
    private static volatile boolean alreadyMainOnResume;
    private static volatile boolean alreadySplashOnResume;
    private static final Map<ExecutionPeriod, List<PeriodTaskInfo>> periodTaskMap = null;

    static {
        INSTANCE = new PeriodTaskManager();
        periodTaskMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private PeriodTaskManager() {
    }

    public static final /* synthetic */ void access$dispatchTasks(PeriodTaskManager r0, ExecutionPeriod r1, boolean r2) {
        r0.dispatchTasks(r1, r2);
    }

    public static final /* synthetic */ boolean access$getAlreadyMainOnResume$p(PeriodTaskManager r0) {
        return alreadyMainOnResume;
    }

    public static final /* synthetic */ boolean access$getAlreadySplashOnResume$p(PeriodTaskManager r0) {
        return alreadySplashOnResume;
    }

    public static final /* synthetic */ void access$setAlreadyMainOnResume$p(PeriodTaskManager r0, boolean r1) {
        alreadyMainOnResume = r1;
    }

    public static final /* synthetic */ void access$setAlreadySplashOnResume$p(PeriodTaskManager r0, boolean r1) {
        alreadySplashOnResume = r1;
    }

    public final void init() {
        List<PeriodTaskInfo> r0 = TaskCollectorManager.getAllPeriodTaskInfo();
        o.b(r0, "TaskCollectorManager.getAllPeriodTaskInfo()");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        PeriodTaskInfo r2 = (PeriodTaskInfo) ZeusTransformUtils.preCheckCast(r1.next(), PeriodTaskInfo.class, "com.obric.aiagent.plugin");
        Map<ExecutionPeriod, List<PeriodTaskInfo>> r3 = periodTaskMap;
        o.b(r2, "taskInfo");
        List<PeriodTaskInfo> r4 = (List) ZeusTransformUtils.preCheckCast(r3.get(r2.getExecutionPeriod()), List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L9;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        ExecutionPeriod r5 = r2.getExecutionPeriod();
        o.b(r5, "taskInfo.executionPeriod");
        r3.put(r5, r4);
        x r6 = x.f38692a;
    L9:
        if (r4 == null) goto L4;
        r4.add(r2);
        goto L4
    L11:
        printAllPeriodTasks();
    }

    public final void registerMain$initscheduler_release(i r3) {
        o.d(r3, "lifecycle");
        r3.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new PeriodTaskManager$registerMain$1(), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    }

    public final void registerSplash$initscheduler_release(i r3) {
        o.d(r3, "lifecycle");
        r3.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new PeriodTaskManager$registerSplash$1(), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void dispatchTasks$default(PeriodTaskManager r0, ExecutionPeriod r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.dispatchTasks(r1, r2);
    }

    private final void dispatchTasks(ExecutionPeriod r8, boolean r9) {
        List r7 = (List) ZeusTransformUtils.preCheckCast(periodTaskMap.get(r8), List.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L26;
        PeriodTaskInfo r11 = (PeriodTaskInfo) ZeusTransformUtils.preCheckCast(r10.next(), PeriodTaskInfo.class, "com.obric.aiagent.plugin");
        if (r11.getTask().mustRunInMainThread() == true) goto L9;
        InitScheduler.INSTANCE.getExecutorService$initscheduler_release().submit((Runnable) ZeusTransformUtils.preCheckCast(r11.getTask(), Runnable.class, "com.obric.aiagent.plugin"));
        InitLogger.INSTANCE.d(TAG, "ASYNC " + r11.getTaskId() + " submit.");
        if (r9 == false) goto L6;
        InitMonitor.INSTANCE.monitor(r11.getTaskId() + "-SUBMIT");
        goto L6
    L9:
        long r3 = System.currentTimeMillis();
        InitTraceUtil r1 = InitTraceUtil.INSTANCE;
        String r5 = r11.getTaskId();
        o.b(r5, "taskInfo.taskId");
        r1.beginSection(r5);
        r11.getTask().run();
        InitTraceUtil.INSTANCE.endSection();
        InitLogger.INSTANCE.d(TAG, "UIThread " + r11.getTaskId() + " done.");
        if (r9 == false) goto L6;
        InitMonitor.INSTANCE.monitorCosTime(r11, System.currentTimeMillis() - r3, true);
        goto L6
    L26:
        return;
    }

    private final void printAllPeriodTasks() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        StringBuilder r6 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator<Map.Entry<ExecutionPeriod, List<PeriodTaskInfo>>> r0 = periodTaskMap.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.getValue(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        r6.append(((ExecutionPeriod) ZeusTransformUtils.preCheckCast(r1.getKey(), ExecutionPeriod.class, "com.obric.aiagent.plugin")).name() + ": ");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getValue(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r6.append(((PeriodTaskInfo) ZeusTransformUtils.preCheckCast(r2.next(), PeriodTaskInfo.class, "com.obric.aiagent.plugin")).getTaskId() + ' ');
        goto L12
    L14:
        r6.append("\n");
        goto L7
    L15:
        InitLogger r3 = InitLogger.INSTANCE;
        String r7 = r6.toString();
        o.b(r7, "totalInfo.toString()");
        r3.d(TAG, r7);
    }
}
