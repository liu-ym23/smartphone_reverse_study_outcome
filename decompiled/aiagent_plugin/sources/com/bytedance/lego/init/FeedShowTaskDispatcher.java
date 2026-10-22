package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.FeedShowTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FeedShowTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedShowTaskDispatcher {
    public static final FeedShowTaskDispatcher INSTANCE = null;
    private static final String TAG = "FeedShowTaskDispatcher";
    private static final List<FeedShowTaskInfo> allFeedShowTask = null;
    private static volatile AtomicInteger completedTaskCount;
    private static boolean started;

    static {
        INSTANCE = new FeedShowTaskDispatcher();
        completedTaskCount = new AtomicInteger(0);
        allFeedShowTask = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    private FeedShowTaskDispatcher() {
    }

    public static final /* synthetic */ List access$getAllFeedShowTask$p(FeedShowTaskDispatcher r0) {
        return allFeedShowTask;
    }

    public static final /* synthetic */ void access$printAllFeedShowTasks(FeedShowTaskDispatcher r2, List r3) {
        r2.printAllFeedShowTasks((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$runTask(FeedShowTaskDispatcher r0, FeedShowTaskInfo r1, boolean r2) {
        r0.runTask(r1, r2);
    }

    public final synchronized void onFeedShow() {
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
        new Thread((Runnable) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Runnable.class, "com.obric.aiagent.plugin"), "A-FeedShowTaskDispatcher").start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private final void runTask(FeedShowTaskInfo r7, boolean r8) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L7
        FeedShowTaskMonitor.INSTANCE.monitorTaskStart(r7, r8);     // Catch: Exception -> L7
        InitLogger.INSTANCE.d(TAG, r7.taskId + " start. isUIThread: " + r8);     // Catch: Exception -> L7
        r7.task.run();     // Catch: Exception -> L7
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L7
        FeedShowTaskMonitor.INSTANCE.monitorTaskEnd(r7, r8);     // Catch: Exception -> L7
        long r4 = r3 - r1;     // Catch: Exception -> L7
        FeedShowTaskMonitor.INSTANCE.monitorCosTime(r7, r4, r8);     // Catch: Exception -> L7
        InitLogger.INSTANCE.d(TAG, r7.taskId + " end. cos " + r4 + " ms.");     // Catch: Exception -> L7
        if (completedTaskCount.incrementAndGet() != allFeedShowTask.size()) goto L16;
        sendMonitorData();     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        InitLogger.INSTANCE.e(TAG, "\nerror!error!error!  " + r7.taskId + " run error.\n");
        InitLogger r9 = InitLogger.INSTANCE;
        String r2 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        o.b(r2, "Log.getStackTraceString(e)");
        r9.e(TAG, r2);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "RUN_FEED_SHOW_TASK_EXCEPTION:" + r7.taskId);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void sendMonitorData() {
        InitLogger.INSTANCE.d(TAG, "sendMonitorData");     // Catch: Exception -> L4
        FeedShowTaskMonitor.INSTANCE.sendFeedShowTaskMonitor();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "DELAY_TASK_MONITOR_EXCEPTION");
    }

    private final void printAllFeedShowTasks(List<? extends FeedShowTaskInfo> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L13;
        StringBuilder r5 = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        FeedShowTaskInfo r1 = (FeedShowTaskInfo) ZeusTransformUtils.preCheckCast(r6.next(), FeedShowTaskInfo.class, "com.obric.aiagent.plugin");
        r5.append(new StringBuilder().append(r1).append('\n').toString());
        goto L8
    L10:
        InitLogger r7 = InitLogger.INSTANCE;
        String r8 = r5.toString();
        o.b(r8, "sb.toString()");
        r7.d(TAG, r8);
        return;
    }
}
