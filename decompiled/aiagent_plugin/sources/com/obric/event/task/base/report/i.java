package com.obric.event.task.base.report;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.am;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskTechReporter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f32779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ActionReportSession> f32780b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<String, Boolean> f32781c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f32782d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f32783e;
    private static long f;

    /* JADX INFO: renamed from: lambda$2rCuz5qZn4zGdt9k5-Ze6458VI0, reason: not valid java name */
    public static /* synthetic */ x m942lambda$2rCuz5qZn4zGdt9k5Ze6458VI0(String r0, JSONObject r1) {
        return a(r0, r1);
    }

    private i() {
    }

    static {
        f32779a = new i();
        f32780b = new ConcurrentHashMap();
        f32781c = ConcurrentHashMap.newKeySet();
        f32782d = new ConcurrentHashMap();
        f32783e = "context_awareness_init";
    }

    public final synchronized void a() {
        monitor-enter(this);
        f32781c.clear();     // Catch: Throwable -> L6
        f32782d.clear();     // Catch: Throwable -> L6
        f32783e = "context_awareness_init";     // Catch: Throwable -> L6
        f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        a(this, "init", "obric_tech_event_task_condition_init", null, 4, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r7) {
        monitor-enter(this);
        d.h.b.o.e(r7, "step");     // Catch: Throwable -> L13
        if (f32780b.get("init") != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (d.h.b.o.a(f32783e, r7) == true) goto L11;
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        ((Map) ZeusTransformUtils.preCheckCast(f32782d, Map.class, "com.obric.aiagent.plugin")).put(f32783e, Long.valueOf(r0 - f));     // Catch: Throwable -> L13
        f32783e = r7;     // Catch: Throwable -> L13
        f = r0;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void b(String r2) {
        d.h.b.o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        f32781c.add(r2);
        return;
    }

    public static /* synthetic */ void a(i r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.a(r2, r3);
    }

    public final synchronized void a(String r14, Integer r15) {
        monitor-enter(this);
        int r0 = 1;
        if (r15 == null) goto L6;
        r0 = r15.intValue();     // Catch: Throwable -> L22
    L10:
        if (r0 != 0) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(f32782d, Map.class, "com.obric.aiagent.plugin")).put(f32783e, Long.valueOf(SystemClock.elapsedRealtime() - f));     // Catch: Throwable -> L22
    L12:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L22
        ConcurrentHashMap.KeySetView<String, Boolean> r3 = f32781c;     // Catch: Throwable -> L22
        d.h.b.o.c(r3, "initErrorList");     // Catch: Throwable -> L22
        r1.put("error_list", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L22
        if (r0 == 0) goto L15;
        r1.put("init_error_step", f32783e);     // Catch: Throwable -> L22
    L15:
        Iterator r2 = ((Map) ZeusTransformUtils.preCheckCast(f32782d, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L22
    L17:
        if (r2.hasNext() == false) goto L19;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        r1.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L22
        goto L17
    L19:
        x r5 = x.f38692a;     // Catch: Throwable -> L22
        a("init", r0, r14, r1);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        ConcurrentHashMap.KeySetView<String, Boolean> r16 = f32781c;     // Catch: Throwable -> L22
        d.h.b.o.c(r16, "initErrorList");     // Catch: Throwable -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L10;
        r0 = 0;
    L22:
        th = move-exception;
        throw th;
    }

    public final void a(String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        if (r5 != null) goto L5;
        String r2 = "";
    L6:
        r0.put(KnowledgeActivity.KEY_TASK_ID, r2);
        if (r6 != null) goto L9;
        String r3 = "";
    L10:
        r0.put("trigger_type", r3);
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r0.put("register_source", r7);
        a(a(r5, r6), "obric_tech_event_task_condition_register", r0);
        return;
    L9:
        r3 = r6;
        goto L10
    L5:
        r2 = r5;
        goto L6
    }

    public static /* synthetic */ void a(i r7, String r8, String r9, int r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r13 & 8) == 0) goto L9;
        r11 = null;
    L9:
        String r5 = r11;
        if ((r13 & 16) == 0) goto L12;
        int r6 = 0;
    L13:
        r7.a(r8, r9, r4, r5, r6);
        return;
    L12:
        r6 = r12;
        goto L13
    L5:
        r4 = r10;
        goto L7
    }

    public final void a(String r3, String r4, int r5, String r6, int r7) {
        if (f32780b.get("init") == null) goto L7;
        if (r5 == 0) goto L7;
        if (r6 == null) goto L7;
        a("register_task");
        b(r6);
    L7:
        String r8 = a(r3, r4);
        JSONObject r9 = new JSONObject();
        r9.put("retry_count", r7);
        x r10 = x.f38692a;
        a(r8, r5, r6, r9);
    }

    public final void a(String r6, int r7, String r8) {
        Integer r0 = b();
        JSONObject r1 = new JSONObject();
        if (r6 != null) goto L5;
        String r3 = "";
    L6:
        r1.put(KnowledgeActivity.KEY_TASK_ID, r3);
        r1.put(KnowledgeActivity.KEY_TASK_TYPE, r7);
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        r1.put("trigger_type", r8);
        if (r0 == null) goto L12;
        r1.put("network_status", ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L12:
        a(c(r6), "obric_tech_event_task_schedule", r1);
        return;
    L5:
        r3 = r6;
        goto L6
    }

    public static /* synthetic */ void a(i r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.b(r1, r2, r3);
    }

    public final void b(String r5, int r6, String r7) {
        Integer r0 = b();
        String r8 = c(r5);
        JSONObject r1 = new JSONObject();
        if (r0 == null) goto L5;
        r1.put("network_status", ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        x r2 = x.f38692a;
        a(r8, r6, r7, r1);
    }

    private final Integer b() {
        IFlowNetworkIDL r0 = am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        return Integer.valueOf(r0.getCurrentNetworkStatus());
    L10:
        return null;
    L11:
        return null;
    }

    static /* synthetic */ void a(i r0, String r1, String r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(final String r11, String r12, final JSONObject r13) {
        ConcurrentHashMap<String, ActionReportSession> r10 = f32780b;
        ActionReportSession r0 = (ActionReportSession) ZeusTransformUtils.preCheckCast(r10.remove(r11), ActionReportSession.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        ActionReportSession.a(r0, null, 1, null);
    L5:
        if (r13 != null) goto L7;
        r13 = new JSONObject();
    L7:
        ActionReportSession r3 = new ActionReportSession(r12, r13);
        ((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.aiagent.plugin")).put(r11, r3);
        ActionReportSession.a(r3, null, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, new $$Lambda$i$2rCuz5qZn4zGdt9k5Ze6458VI0(r11, r13), 1, null);
    }

    private static final x a(String r5, JSONObject r6) {
        if (f32780b.remove(r5) == null) goto L11;
        if (d.h.b.o.a(r5, "init") == false) goto L11;
        r6.put("init_error_step", f32783e);
        Iterator r7 = ((Map) ZeusTransformUtils.preCheckCast(f32782d, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r0.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue());
    L11:
        return x.f38692a;
    }

    private final void a(String r2, int r3, String r4, JSONObject r5) {
        ActionReportSession r1 = (ActionReportSession) ZeusTransformUtils.preCheckCast(f32780b.remove(r2), ActionReportSession.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3 != 0) goto L7;
        r1.a(r5);
        return;
    L7:
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r1.a(r3, r4, r5);
    }

    private final String a(String r2, String r3) {
        StringBuilder r1 = new StringBuilder().append("register_");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        StringBuilder r4 = r1.append(r2).append('_');
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        return r4.append(r3).toString();
    }

    private final String c(String r2) {
        StringBuilder r1 = new StringBuilder().append("schedule_");
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r1.append(r2).toString();
    }
}
