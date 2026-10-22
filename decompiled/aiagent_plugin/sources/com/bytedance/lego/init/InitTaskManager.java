package com.bytedance.lego.init;

import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitTaskManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitTaskManager {
    private final String TAG;
    private AtomicInteger completedTaskCount;
    private final PriorityBlockingQueue<InitTaskInfo> nonUiReadyQueue;
    private final Object readWriteLock;
    private Map<String, InitTaskInfo> taskIndex;
    private final PriorityBlockingQueue<InitTaskInfo> uiReadyQueue;
    private final ArrayList<InitTaskInfo> unDispatchTask;

    public InitTaskManager() {
        this.taskIndex = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.unDispatchTask = new ArrayList();
        this.uiReadyQueue = new PriorityBlockingQueue();
        this.nonUiReadyQueue = new PriorityBlockingQueue();
        this.readWriteLock = new Object();
        this.completedTaskCount = new AtomicInteger(0);
        this.TAG = "InitTaskManager";
    }

    public final void init() {
        long r0 = System.currentTimeMillis();
        Map<String, InitTaskInfo> r2 = TaskCollectorManager.getInitTaskIndexs();
        o.b(r2, "TaskCollectorManager.getInitTaskIndexs()");
        this.taskIndex = r2;
        InitLogger.d$default(InitLogger.INSTANCE, null, "collect cos: " + (System.currentTimeMillis() - r0) + "ms  size: " + this.taskIndex.size(), 1, null);
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r0, false);
        this.unDispatchTask.addAll(this.taskIndex.values());
        initReadyQueue();
        InitTaskDispatcher.INSTANCE.setHasNoneTask$initscheduler_release(this.taskIndex.isEmpty());
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r0, false);
    }

    public static /* synthetic */ InitTaskInfo takeUiTaskIfExist$default(InitTaskManager r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 5;
    L6:
        return r0.takeUiTaskIfExist(r1);
    }

    public final InitTaskInfo takeUiTaskIfExist(long r2) {
        return (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.uiReadyQueue.poll(r2, TimeUnit.MILLISECONDS), InitTaskInfo.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ InitTaskInfo takeNonUiTaskIfExist$default(InitTaskManager r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.aiagent.plugin");
    L6:
        return r0.takeNonUiTaskIfExist(r1);
    }

    public final InitTaskInfo takeNonUiTaskIfExist(Long r4) {
        if (hasNonUiTask() == true) goto L7;
        return null;
    L7:
        if (r4 == null) goto L11;
        return (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.nonUiReadyQueue.poll(r4.longValue(), TimeUnit.MILLISECONDS), InitTaskInfo.class, "com.obric.aiagent.plugin");
    L11:
        return (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.nonUiReadyQueue.take(), InitTaskInfo.class, "com.obric.aiagent.plugin");
    }

    public final InitTaskInfo takeNonUiTaskMainThreadIfExist(InitPeriod r5) {
        o.d(r5, "period");
        if (hasNonUiTask() == true) goto L5;
        return null;
    L5:
        Iterator<InitTaskInfo> r4 = this.nonUiReadyQueue.iterator();
        o.b(r4, "nonUiReadyQueue.iterator()");
    L7:
        if (r4.hasNext() == false) goto L12;
        InitTaskInfo r0 = (InitTaskInfo) ZeusTransformUtils.preCheckCast(r4.next(), InitTaskInfo.class, "com.obric.aiagent.plugin");
        InitPeriod r2 = r0.endPeriod;
        o.b(r2, "next.endPeriod");
        if (r2.getValue() > r5.getValue()) goto L7;
        r4.remove();
        return r0;
    L12:
        return null;
    }

    private final boolean hasNonUiTask() {
        Object r0 = this.readWriteLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.nonUiReadyQueue, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
        monitor-exit(r0);
        return true;
    L9:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.unDispatchTask, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L19
    L11:
        if (r5.hasNext() == false) goto L17;
        if (((InitTaskInfo) ZeusTransformUtils.preCheckCast(r5.next(), InitTaskInfo.class, "com.obric.aiagent.plugin")).mustRunInMainThread == true) goto L11;
        monitor-exit(r0);
        return true;
    L17:
        monitor-exit(r0);
        return false;
    }

    public final void onTaskComplete(InitTaskInfo r6) {
        o.d(r6, "task");
        Object r0 = this.readWriteLock;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r6.isCompleted == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r6.isCompleted = true;     // Catch: Throwable -> L30
        this.completedTaskCount.getAndIncrement();     // Catch: Throwable -> L30
        List<String> r1 = r6.child;     // Catch: Throwable -> L30
        if (r1 == null) goto L28;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L30
    L13:
        if (r2.hasNext() == false) goto L27;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        InitTaskInfo r4 = (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.taskIndex.get(r3), InitTaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r4 == null) goto L13;
        if (this.unDispatchTask.contains(r4) == false) goto L13;
        List<String> r5 = r4.dependencies;     // Catch: Throwable -> L30
        if (r5 == null) goto L23;
        r5.remove(r6.taskId);     // Catch: Throwable -> L30
    L23:
        if (r4.dependencies == null) goto L26;
        if (r4.dependencies.isEmpty() == false) goto L13;
    L26:
        letTaskReady(r4);     // Catch: Throwable -> L30
        goto L13
    L27:
        x r7 = x.f38692a;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final void beforeSendMonitor() {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.completedTaskCount.get() == this.taskIndex.size()) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L11
        r1.put("count", this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L11
        r1.put("undispatchCount", this.unDispatchTask.size());     // Catch: Exception -> L11
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.unDispatchTask, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.put(((InitTaskInfo) ZeusTransformUtils.preCheckCast(r2.next(), InitTaskInfo.class, "com.obric.aiagent.plugin")).taskId, "task");     // Catch: Exception -> L11
        goto L7
    L9:
        InitMonitor r0 = InitMonitor.INSTANCE;     // Catch: Exception -> L11
        Category r3 = Category.TASK_COUNT_EXCEPTION;     // Catch: Exception -> L11
        String r5 = String.valueOf(this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L11
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L11
        r4.put("task_count_exception", r1);     // Catch: Exception -> L11
        r0.monitorEvent(r3, r5, r4);     // Catch: Exception -> L11
        return;
    }

    public final InitTaskInfo getInitTaskInfoById(String r2) {
        o.d(r2, DBDefinition.TASK_ID);
        return (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.taskIndex.get(r2), InitTaskInfo.class, "com.obric.aiagent.plugin");
    }

    public final List<String> getTaskDependencyById(String r4) {
        o.d(r4, DBDefinition.TASK_ID);
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Object r1 = this.readWriteLock;
        monitor-enter(r1);
        InitTaskInfo r3 = (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.taskIndex.get(r4), InitTaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        List<String> r5 = r3.dependencies;     // Catch: Throwable -> L9
        o.b(r5, "it.dependencies");     // Catch: Throwable -> L9
        Boolean.valueOf(r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public final float getPriorityByTaskId(String r2) {
        o.d(r2, DBDefinition.TASK_ID);
        InitTaskInfo r1 = (InitTaskInfo) ZeusTransformUtils.preCheckCast(this.taskIndex.get(r2), InitTaskInfo.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return -1.0f;
    L7:
        return r1.realPriority;
    }

    private final void initReadyQueue() {
        Collection<InitTaskInfo> r0 = this.taskIndex.values();
        if (r0 == null) goto L12;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        InitTaskInfo r2 = (InitTaskInfo) ZeusTransformUtils.preCheckCast(r1.next(), InitTaskInfo.class, "com.obric.aiagent.plugin");
        if (r2.dependencies == null) goto L11;
        if (r2.dependencies.isEmpty() == false) goto L6;
    L11:
        letTaskReady(r2);
        goto L6
    L19:
        return;
    }

    private final void letTaskReady(InitTaskInfo r5) {
        InitLogger.INSTANCE.d(this.TAG, "letTaskReady: " + r5.taskId);
        if (r5.mustRunInMainThread == false) goto L5;
        this.uiReadyQueue.add(r5);
    L6:
        this.unDispatchTask.remove(r5);
        return;
    L5:
        this.nonUiReadyQueue.add(r5);
        goto L6
    }
}
