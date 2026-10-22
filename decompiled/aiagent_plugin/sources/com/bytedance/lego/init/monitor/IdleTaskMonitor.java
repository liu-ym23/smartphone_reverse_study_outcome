package com.bytedance.lego.init.monitor;

import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.services.apm.api.IApmAgent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.y;
import d.m.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: IdleTaskMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdleTaskMonitor {
    static final /* synthetic */ h[] $$delegatedProperties = null;
    private static final String ASYNC = "Async:";
    public static final IdleTaskMonitor INSTANCE = null;
    private static final String MAIN = "Main:";
    private static final String MONITOR_DELAY = "idle_task_monitor";
    private static final String TAG = "IdleTaskMonitor";
    private static final String TASK_END_SUFFIX = "##TASKEND";
    private static final String TASK_START_SUFFIX = "##TASKSTART";
    private static long applicationStartTime;
    private static final f iApmAgent$delegate = null;
    private static final CopyOnWriteArrayList<Pair<String, Long>> idleTaskCostTimeList = null;

    private final IApmAgent getIApmAgent() {
        f r2 = iApmAgent$delegate;
        h r0 = $$delegatedProperties[0];
        return (IApmAgent) ZeusTransformUtils.preCheckCast(r2.b(), IApmAgent.class, "com.obric.aiagent.plugin");
    }

    private final String preTag(boolean r1) {
        if (r1 == false) goto L4;
        return "Main:";
    L4:
        return "Async:";
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(IdleTaskMonitor.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;")), h.class, "com.obric.aiagent.plugin")};
        INSTANCE = new IdleTaskMonitor();
        idleTaskCostTimeList = new CopyOnWriteArrayList();
        iApmAgent$delegate = g.a((a) ZeusTransformUtils.preCheckCast(IdleTaskMonitor$iApmAgent$2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
        applicationStartTime = -1;
    }

    private IdleTaskMonitor() {
    }

    public final void setApplicationStartTime(long r1) {
        applicationStartTime = r1;
    }

    public final void monitorTaskStart(String r5, boolean r6) {
        o.d(r5, DBDefinition.TASK_ID);
        if (checkCreateEndTimeValid() == true) goto L5;
        return;
    L5:
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - applicationStartTime);
    }

    public final void monitorTaskEnd(String r5, boolean r6) {
        o.d(r5, DBDefinition.TASK_ID);
        if (checkCreateEndTimeValid() == true) goto L5;
        return;
    L5:
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - applicationStartTime);
    }

    public final void monitorCostTime(String r2, long r3, boolean r5) {
        o.d(r2, DBDefinition.TASK_ID);
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void sendIdleTaskTaskMonitor() {
        if (getIApmAgent() == null) goto L15;
        JSONObject r0 = new JSONObject();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(idleTaskCostTimeList, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L17
    L7:
        if (r3.hasNext() == false) goto L10;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Object r6 = r4.second;     // Catch: Throwable -> L17
        o.b(r6, "it.second");     // Catch: Throwable -> L17
        r0.put(r5, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L17
    L10:
        InitLogger.INSTANCE.d(TAG, "sendIdleTaskMonitor " + r0);
        JSONObject r1 = new JSONObject();
        r1.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        IApmAgent r8 = getIApmAgent();
        if (r8 == null) goto L13;
        r8.monitorEvent(MONITOR_DELAY, r1, r0, new JSONObject());
    L13:
        idleTaskCostTimeList.clear();
        return;
    L15:
        IdleTaskMonitor r9 = (IdleTaskMonitor) ZeusTransformUtils.preCheckCast(this, IdleTaskMonitor.class, "com.obric.aiagent.plugin");
        InitLogger.INSTANCE.e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    private final boolean checkCreateEndTimeValid() {
        if (applicationStartTime <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String getTaskStartTag(String r2, boolean r3) {
        return preTag(r3) + r2 + "##TASKSTART";
    }

    private final String getTaskEndTag(String r2, boolean r3) {
        return preTag(r3) + r2 + "##TASKEND";
    }

    private final String getTaskTag(String r2, boolean r3) {
        return preTag(r3) + "Task-" + r2;
    }

    private final void addDuration(String r2, long r3) {
        idleTaskCostTimeList.add(new Pair(r2, Long.valueOf(r3)));
    }
}
