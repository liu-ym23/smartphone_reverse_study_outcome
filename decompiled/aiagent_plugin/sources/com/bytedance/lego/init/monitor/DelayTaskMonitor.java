package com.bytedance.lego.init.monitor;

import android.os.Looper;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: DelayTaskMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelayTaskMonitor {
    public static final DelayTaskMonitor INSTANCE = null;
    private static final String MONITOR_DELAY = "delay_task_monitor";
    private static final String TAG = "DelayTaskMonitor";
    private static final String TASK_END = "_TASKEND";
    private static final String TASK_START = "_TASKSTART";
    private static final CopyOnWriteArrayList<m<String, Long>> cosTimeList = null;
    private static long onCreateEnd;

    static {
        INSTANCE = new DelayTaskMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        onCreateEnd = -1;
    }

    private DelayTaskMonitor() {
    }

    public final long getOnCreateEnd() {
        return onCreateEnd;
    }

    public final void setOnCreateEnd(long r1) {
        onCreateEnd = r1;
    }

    public final void monitorTaskStart(DelayTaskInfo r5, boolean r6) {
        o.d(r5, "taskInfo");
        if (onCreateEnd >= 0) goto L5;
        return;
    L5:
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - onCreateEnd);
    }

    public final void monitorTaskEnd(DelayTaskInfo r5, boolean r6) {
        o.d(r5, "taskInfo");
        if (onCreateEnd >= 0) goto L5;
        return;
    L5:
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - onCreateEnd);
    }

    public final void monitorCosTime(DelayTaskInfo r2, long r3, boolean r5) {
        o.d(r2, "taskInfo");
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void monitor(String r2, long r3, boolean r5) {
        o.d(r2, "name");
        addDuration(getMonitorTag(r2, r5), r3);
    }

    public final void monitorEvent(Category r4, String r5, JSONObject r6) {
        o.d(r4, "category");
        o.d(r5, "type");
        o.d(r6, "extraLog");
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        JSONObject r3 = new JSONObject();
        r3.put(r4.getValue(), r5);     // Catch: Exception -> L7
    L9:
        r6.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r6.put("isUIThread", o.a(Looper.getMainLooper(), Looper.myLooper()));
        r0.monitorEvent(MONITOR_DELAY, r3, new JSONObject(), r6);
        InitLogger.d$default(InitLogger.INSTANCE, null, r4.name() + ' ' + r5 + ' ' + r6.toString(), 1, null);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L11:
        DelayTaskMonitor r7 = (DelayTaskMonitor) ZeusTransformUtils.preCheckCast(this, DelayTaskMonitor.class, "com.obric.aiagent.plugin");
        InitLogger.INSTANCE.e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void sendDelayTaskMonitor() {
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L14;
        JSONObject r8 = new JSONObject();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(cosTimeList, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L10
    L7:
        if (r3.hasNext() == false) goto L12;
        m r4 = (m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        r8.put((String) ZeusTransformUtils.preCheckCast(r4.a(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L10
    L12:
        InitLogger.INSTANCE.d(TAG, "sendDelayTaskMonitor " + r8);
        r0.monitorEvent(MONITOR_DELAY, new JSONObject(), r8, new JSONObject());
        cosTimeList.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L14:
        DelayTaskMonitor r9 = (DelayTaskMonitor) ZeusTransformUtils.preCheckCast(this, DelayTaskMonitor.class, "com.obric.aiagent.plugin");
        InitLogger.INSTANCE.e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    private final String getMonitorTag(String r1, boolean r2) {
        if (r2 == false) goto L6;
        return InitMonitor.MAIN + r1;
    L6:
        return InitMonitor.ASYNC + r1;
    }

    private final String getTaskTag(DelayTaskInfo r1, boolean r2) {
        if (r2 == false) goto L6;
        return "Main:Task-" + r1.taskId;
    L6:
        return "Async:Task-" + r1.taskId;
    }

    private final String getTaskStartTag(DelayTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        return InitMonitor.MAIN + r2.taskId + TASK_START;
    L7:
        return InitMonitor.ASYNC + r2.taskId + TASK_START;
    }

    private final String getTaskEndTag(DelayTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        return InitMonitor.MAIN + r2.taskId + TASK_END;
    L7:
        return InitMonitor.ASYNC + r2.taskId + TASK_END;
    }

    private final void addDuration(String r2, long r3) {
        cosTimeList.add(new m(r2, Long.valueOf(r3)));
    }
}
