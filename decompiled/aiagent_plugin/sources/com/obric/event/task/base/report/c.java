package com.obric.event.task.base.report;

import com.obric.eventkit.task.model.ConditionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ConditionTaskExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final String a(ConditionTask r2) {
        d.h.b.o.e(r2, "<this>");
        Map<String, String> r3 = r2.getExt();
        if (r3 == null) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("obric_client_task_create_from"), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "gui";
    }

    public static final String b(ConditionTask r2) {
        d.h.b.o.e(r2, "<this>");
        Map<String, String> r3 = r2.getExt();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.get("obric_client_task_create_origin_query"), String.class, "com.obric.aiagent.plugin");
    }
}
