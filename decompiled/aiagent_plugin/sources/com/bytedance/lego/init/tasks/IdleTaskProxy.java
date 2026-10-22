package com.bytedance.lego.init.tasks;

import android.util.Log;
import com.bytedance.lego.init.IdleTaskDispatcher;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IdleTaskProxy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdleTaskProxy implements BaseIdleTask {
    private final a<x> executeFinish;
    private final BaseIdleTask origin;
    private final String taskId;
    private final boolean uiThread;

    public IdleTaskProxy(BaseIdleTask r3, String r4, boolean r5, a<x> r6) {
        BaseIdleTask r7 = (BaseIdleTask) ZeusTransformUtils.wrapperContextForParams(r3, BaseIdleTask.class, "com.obric.aiagent.plugin");
        a<x> r8 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        o.d(r7, "origin");
        o.d(r4, DBDefinition.TASK_ID);
        o.d(r8, "executeFinish");
        this.origin = r7;
        this.taskId = r4;
        this.uiThread = r5;
        this.executeFinish = r8;
    }

    public final a<x> getExecuteFinish() {
        return this.executeFinish;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final boolean getUiThread() {
        return this.uiThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L5
        IdleTaskMonitor.INSTANCE.monitorTaskStart(this.taskId, this.uiThread);     // Catch: Throwable -> L5
        this.origin.run();     // Catch: Throwable -> L5
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L5
        IdleTaskMonitor.INSTANCE.monitorTaskEnd(this.taskId, this.uiThread);     // Catch: Throwable -> L5
        long r4 = r3 - r1;     // Catch: Throwable -> L5
        IdleTaskMonitor.INSTANCE.monitorCostTime(this.taskId, r4, this.uiThread);     // Catch: Throwable -> L5
        InitLogger.INSTANCE.d(IdleTaskDispatcher.TAG, this.taskId + " end. cos " + r4 + " ms.");     // Catch: Throwable -> L5
    L9:
        this.executeFinish.invoke();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        InitLogger.INSTANCE.e(IdleTaskDispatcher.TAG, "\nerror!error!error!  " + this.taskId + " run error.\n");
        InitLogger r2 = InitLogger.INSTANCE;
        String r5 = Log.getStackTraceString(th);
        o.b(r5, "Log.getStackTraceString(e)");
        r2.e(IdleTaskDispatcher.TAG, r5);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L11;
        InitMonitor.INSTANCE.ensureNotReachHere(th, "RUN_IDLE_TASK_EXCEPTION:" + this.taskId);
        goto L9
    L11:
        throw th;
    }
}
