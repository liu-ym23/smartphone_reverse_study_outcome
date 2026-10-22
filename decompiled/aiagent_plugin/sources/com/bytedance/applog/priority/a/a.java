package com.bytedance.applog.priority.a;

import com.bytedance.applog.priority.PriorityCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: Common.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final void a(PriorityCallback r8, String r9, Map<h.a, ? extends JSONObject> r10, h.EnumC0139h r11, int r12) {
        PriorityCallback r13 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r8, PriorityCallback.class, "com.obric.aiagent.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        o.d(r13, "callback");
        o.d(r9, "stage");
        o.d(r14, "events");
        o.d(r11, "priorityName");
        Iterator r15 = r14.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        h.a r2 = (h.a) ZeusTransformUtils.preCheckCast(r0.getKey(), h.a.class, "com.obric.aiagent.plugin");
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.aiagent.plugin");
        a(r13, r9, r2.b().getType(), r5, r11, r12);
        goto L4
    }

    public static final void a(PriorityCallback r9, String r10, int r11, JSONObject r12, h.EnumC0139h r13, int r14) {
        PriorityCallback r0 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r9, PriorityCallback.class, "com.obric.aiagent.plugin");
        o.d(r0, "callback");
        o.d(r10, "stage");
        o.d(r12, "json");
        o.d(r13, "priorityName");
        r0.monitorStage(r10, r13.name(), r14, r11, r12.optString("event"), r12.optString("monitor_id"), r12.optLong("local_time_ms", System.currentTimeMillis()));
    }
}
