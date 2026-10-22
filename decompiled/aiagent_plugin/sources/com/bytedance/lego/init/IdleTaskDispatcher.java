package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.model.IdleTaskInfo;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import com.bytedance.lego.init.util.InitLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: IdleTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdleTaskDispatcher {
    public static final IdleTaskDispatcher INSTANCE = null;
    public static final String TAG = "IdleTaskDispatcher";
    private static int allTaskSize;
    private static volatile boolean bootFinish;
    private static volatile AtomicInteger completedTaskCount;
    private static IdleTaskConfig idleTaskConfig;
    private static final ArrayList<IdleTaskInfo> nonUiTaskList = null;
    private static final Handler timeoutHandler = null;
    private static final IdleTaskDispatcher$uiIdleTaskHandler$1 uiIdleTaskHandler = null;
    private static final ArrayList<IdleTaskInfo> uiTaskList = null;

    /* JADX INFO: renamed from: com.bytedance.lego.init.IdleTaskDispatcher$asyncSendMonitorData$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdleTaskDispatcher.kt */
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
            InitLogger.INSTANCE.d(IdleTaskDispatcher.TAG, "asyncSendMonitorData");     // Catch: Throwable -> L4
            IdleTaskMonitor.INSTANCE.sendIdleTaskTaskMonitor();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            InitMonitor.INSTANCE.ensureNotReachHere(th, "IDLE_TASK_MONITOR_EXCEPTION");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lego.init.IdleTaskDispatcher$peekNonUITaskExecute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdleTaskDispatcher.kt */
    static final class C11031 extends p implements a<x> {
        final /* synthetic */ IdleTaskInfo $task;

        /* JADX INFO: renamed from: com.bytedance.lego.init.IdleTaskDispatcher$peekNonUITaskExecute$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IdleTaskDispatcher.kt */
        static final class C01961 extends p implements a<x> {
            public static final C01961 INSTANCE = null;

            static {
                INSTANCE = new C01961();
            }

            C01961() {
                super(0);
            }

            @Override // d.h.a.a
            public /* bridge */ /* synthetic */ x invoke() {
                invoke2();
                return x.f38692a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IdleTaskDispatcher.access$asyncSendMonitorData(IdleTaskDispatcher.INSTANCE);
            }
        }

        C11031(IdleTaskInfo r1) {
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
            BaseIdleTask r1 = this.$task.task;
            o.b(r1, "task.task");
            String r5 = this.$task.taskId;
            o.b(r5, "task.taskId");
            new IdleTaskProxy(r1, r5, false, (a) ZeusTransformUtils.preCheckCast(C01961.INSTANCE, a.class, "com.obric.aiagent.plugin")).run();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lego.init.IdleTaskDispatcher$peekUITaskExecute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdleTaskDispatcher.kt */
    static final class C11041 extends p implements a<x> {
        public static final C11041 INSTANCE = null;

        static {
            INSTANCE = new C11041();
        }

        C11041() {
            super(0);
        }

        @Override // d.h.a.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IdleTaskDispatcher.access$asyncSendMonitorData(IdleTaskDispatcher.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.lego.init.IdleTaskDispatcher$uiIdleTaskHandler$1] */
    static {
        INSTANCE = new IdleTaskDispatcher();
        idleTaskConfig = IdleTaskConfig.Companion.getDEFAULT_IDLETASK_CONFIG$initscheduler_release();
        uiTaskList = new ArrayList();
        nonUiTaskList = new ArrayList();
        completedTaskCount = new AtomicInteger(0);
        timeoutHandler = new Handler(Looper.getMainLooper());
        uiIdleTaskHandler = new IdleTaskDispatcher$uiIdleTaskHandler$1();
    }

    private IdleTaskDispatcher() {
    }

    public static final /* synthetic */ void access$asyncSendMonitorData(IdleTaskDispatcher r0) {
        r0.asyncSendMonitorData();
    }

    public static final /* synthetic */ boolean access$getBootFinish$p(IdleTaskDispatcher r0) {
        return bootFinish;
    }

    public static final /* synthetic */ boolean access$peekIdleTaskExecute(IdleTaskDispatcher r0) {
        return r0.peekIdleTaskExecute();
    }

    public static final /* synthetic */ void access$setBootFinish$p(IdleTaskDispatcher r0, boolean r1) {
        bootFinish = r1;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return idleTaskConfig;
    }

    public final void setIdleTaskConfig(IdleTaskConfig r1) {
        o.d(r1, "<set-?>");
        idleTaskConfig = r1;
    }

    public final ArrayList<IdleTaskInfo> getUiTaskList() {
        return uiTaskList;
    }

    public final ArrayList<IdleTaskInfo> getNonUiTaskList() {
        return nonUiTaskList;
    }

    public final void config(IdleTaskConfig r3) {
        o.d(r3, "config");
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L5;
        return;
    L5:
        bootFinish = false;
        idleTaskConfig = r3;
        if (r3.getAutoIdleTask() == false) goto L9;
        timeoutHandler.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(RunnableC11021.INSTANCE, Runnable.class, "com.obric.aiagent.plugin"), idleTaskConfig.getBootFinishTimeOut());
        return;
    }

    private final boolean peekIdleTaskExecute() {
        boolean r0 = peekUITaskExecute();
        if (r0 == false) goto L5;
        return r0;
    L5:
        return peekNonUITaskExecute();
    }

    private final boolean peekUITaskExecute() {
        int r9 = Math.min(uiTaskList.size(), idleTaskConfig.getUiThreadTaskNum());
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r9) goto L5;
        IdleTaskInfo r4 = uiTaskList.remove(0);
        o.b(r4, "uiTaskList.removeAt(0)");
        IdleTaskInfo r5 = (IdleTaskInfo) ZeusTransformUtils.preCheckCast(r4, IdleTaskInfo.class, "com.obric.aiagent.plugin");
        BaseIdleTask r6 = r5.task;
        o.b(r6, "task.task");
        String r7 = r5.taskId;
        o.b(r7, "task.taskId");
        new IdleTaskProxy(r6, r7, true, (a) ZeusTransformUtils.preCheckCast(C11041.INSTANCE, a.class, "com.obric.aiagent.plugin")).run();
        r2 = r2 + 1;
        r3 = true;
        goto L3
    L5:
        return r3;
    }

    private final boolean peekNonUITaskExecute() {
        int r5 = Math.min(nonUiTaskList.size(), idleTaskConfig.getNonUIThreadTaskNum());
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r5) goto L5;
        IdleTaskInfo r3 = nonUiTaskList.remove(0);
        o.b(r3, "nonUiTaskList.removeAt(0)");
        InitSchedulerExecutorsKt.singleAsync((a) ZeusTransformUtils.preCheckCast(new C11031((IdleTaskInfo) ZeusTransformUtils.preCheckCast(r3, IdleTaskInfo.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        r2 = true;
        goto L3
    L5:
        return r2;
    }

    public final void bootFinish() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (bootFinish == false) goto L8;
        return;
    L8:
        bootFinish = true;
        ArrayList<IdleTaskInfo> r4 = uiTaskList;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(TaskCollectorManager.getUiIdleTaskInfo(), Collection.class, "com.obric.aiagent.plugin"));
        ArrayList<IdleTaskInfo> r0 = nonUiTaskList;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(TaskCollectorManager.getNonUiIdleTaskInfo(), Collection.class, "com.obric.aiagent.plugin"));
        int r5 = r4.size() + r0.size();
        allTaskSize = r5;
        if (r5 != 0) goto L11;
        return;
    L11:
        Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(uiIdleTaskHandler, MessageQueue.IdleHandler.class, "com.obric.aiagent.plugin"));
    }

    private final void asyncSendMonitorData() {
        if (completedTaskCount.incrementAndGet() == allTaskSize) goto L5;
        return;
    L5:
        InitSchedulerExecutorsKt.singleAsync((a) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, a.class, "com.obric.aiagent.plugin"));
    }
}
