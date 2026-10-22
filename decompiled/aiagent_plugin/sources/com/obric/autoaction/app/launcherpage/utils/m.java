package com.obric.autoaction.app.launcherpage.utils;

import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final boolean a(EventTask r1) {
        d.h.b.o.e(r1, "<this>");
        return ZeusTransformUtils.instanceOf(r1, ShortcutTask.class);
    }

    public static final boolean b(EventTask r1) {
        d.h.b.o.e(r1, "<this>");
        return ZeusTransformUtils.instanceOf(r1, ConditionTask.class);
    }

    public static final String a(ConditionTask r2) {
        d.h.b.o.e(r2, "<this>");
        Map<String, String> r3 = r2.getExt();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.get("obric_client_flow_local_message_id"), String.class, "com.obric.aiagent.plugin");
    }

    public static final String b(ConditionTask r2) {
        d.h.b.o.e(r2, "<this>");
        Map<String, String> r3 = r2.getExt();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.get("obric_client_flow_question_id"), String.class, "com.obric.aiagent.plugin");
    }

    public static final String a(ShortcutTask r2) {
        d.h.b.o.e(r2, "<this>");
        Map<String, String> r3 = r2.getExt();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.get("obric_client_source_message_id"), String.class, "com.obric.aiagent.plugin");
    }

    public static final ShortcutTask a(ShortcutTask r4, String r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "messageId");
        HashMap r0 = new HashMap();
        Map<String, String> r1 = r4.getExt();
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("obric_client_source_message_id", r5);
        r4.setExt((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        return r4;
    }
}
