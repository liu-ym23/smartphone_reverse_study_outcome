package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.bytedance.crash.general.RomInfo;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.eventkit.task.model.LocationCondition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocationMonitorReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    private static final String TAG = "LocationMonitorReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f17154a = null;

    static {
        f17154a = new o();
    }

    private o() {
    }

    public final void a(f r9) {
        d.h.b.o.e(r9, "result");
        JSONObject r1 = new JSONObject();
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L13
        o r8 = (o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        p r3 = q.f17157a.a();     // Catch: Throwable -> L13
        r1.put(KnowledgeActivity.KEY_TASK_ID, r9.a());     // Catch: Throwable -> L13
        r1.put("feature_list", r8.a(r9.e()).toString());     // Catch: Throwable -> L13
        r1.put("before_point_count", r9.c());     // Catch: Throwable -> L13
        r1.put("after_point_count", r9.d());     // Catch: Throwable -> L13
        r1.put("location_mode", r8.a(r9.b()));     // Catch: Throwable -> L13
        r1.put("move_type", r8.b(r9.b()));     // Catch: Throwable -> L13
        r1.put("sample_window_minutes", r3.a() / 60000);     // Catch: Throwable -> L13
        r1.put("sample_interval_seconds", r3.b() / 1000);     // Catch: Throwable -> L13
        r1.put(RomInfo.KEY_ROM_OS_VERSION, r8.a());     // Catch: Throwable -> L13
        r8.a(r1, "error_risk", r9.h());     // Catch: Throwable -> L13
        r8.a(r1, "delay_risk", r9.i());     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, Float>> r4 = r9.f().a().entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r4.hasNext() == false) goto L7;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r8.a(r1, (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), (Float) ZeusTransformUtils.preCheckCast(r5.getValue(), Float.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        goto L5
    L7:
        Iterator<Map.Entry<String, Float>> r6 = r9.g().a().entrySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r8.a(r1, (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin"), (Float) ZeusTransformUtils.preCheckCast(r7.getValue(), Float.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        goto L9
    L11:
        r8.a(r1, "sample_uniformity", r8.a(r9.e(), r3));     // Catch: Throwable -> L13
        d.n.f(r1.put("trigger_result", r9.j()));     // Catch: Throwable -> L13
    L15:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "report taskId=" + r9.a() + " triggerResult=" + r9.j() + " before=" + r9.c() + " after=" + r9.d() + ", params=" + r1);
        IAppLog r10 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L23;
        r10.reportToFlow("obric_condition_task_location_trigger_monitor", r1);
        return;
    L23:
        return;
    L13:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L15
    }

    private final JSONArray a(List<i> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        JSONArray r8 = new JSONArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r9.next(), i.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("time_delta", r1.a());
        r2.put("speed", Float.valueOf(r1.b()));
        r2.put("accuracy", Float.valueOf(r1.c()));
        o r3 = f17154a;
        r3.a(r2, "distance_delta", r1.d());
        r3.a(r2, "distance_boundary", r1.e());
        Boolean r4 = r1.f();
        if (r4 == null) goto L8;
        r2.put("should_trigger", r4.booleanValue());
    L8:
        r2.put("provider", r1.g());
        r8.put(r2);
        goto L4
    L9:
        return r8;
    }

    private final Float a(List<i> r9, p r10) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(Long.valueOf(((i) ZeusTransformUtils.preCheckCast(r12.next(), i.class, "com.obric.aiagent.plugin")).a()));
        goto L4
    L6:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L7:
        Long r3 = null;
        if (r15.hasNext() == false) goto L17;
        d.m r2 = (d.m) ZeusTransformUtils.preCheckCast(r15.next(), d.m.class, "com.obric.aiagent.plugin");
        Long r4 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2.d(), Number.class, "com.obric.aiagent.plugin")).longValue() - ((Number) ZeusTransformUtils.preCheckCast(r2.c(), Number.class, "com.obric.aiagent.plugin")).longValue());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        r3 = r4;
    L15:
        if (r3 == null) goto L7;
        r14.add(r3);
        goto L7
    L12:
        r5 = false;
        goto L13
    L17:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        if (r16.isEmpty() == false) goto L20;
        return null;
    L20:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r19 = r17.iterator();
    L22:
        if (r19.hasNext() == false) goto L25;
        r18.add(Float.valueOf(Math.abs(((Number) ZeusTransformUtils.preCheckCast(r19.next(), Number.class, "com.obric.aiagent.plugin")).longValue() - r10.b()) / r10.b()));
        goto L22
    L25:
        return Float.valueOf(d.l.n.a(1.0f - ((float) d.a.p.A((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"))), 0.0f, 1.0f));
    }

    private final void a(JSONObject r2, String r3, Float r4) {
        if (r4 == null) goto L5;
        r2.put(r3, Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue()));
        return;
    }

    private final String a() {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        o r5 = (o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = d.n.f(ObricProductSdk.INSTANCE.platformService().romInfo().getOSVersion());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r6);
        if (r2 == null) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "get rom version failed " + r2.getMessage());
    L11:
        if (d.n.b(r6) == false) goto L14;
        r6 = "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    private final int a(LocationCondition r2) {
        if (d.h.b.o.a(r2.getMode(), "geo_radius") == false) goto L6;
        return 1;
    L6:
        if (d.h.b.o.a(r2.getAddrType(), "home") == false) goto L9;
        return 2;
    L9:
        if (d.h.b.o.a(r2.getAddrType(), "company") == false) goto L11;
        return 3;
    L11:
        return 4;
    }

    private final int b(LocationCondition r1) {
        if (d.h.b.o.a(r1.getType(), "inside") == false) goto L5;
        return 1;
    L5:
        return 2;
    }
}
