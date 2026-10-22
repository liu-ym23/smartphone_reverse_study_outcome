package com.obric.autogui.database;

import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskMigrationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final EventTaskExecutionRecord a(com.obric.autogui.database.entity.a r16) {
        o.e(r16, "<this>");
        Map<String, String> r0 = r16.r();
        if (r0 == null) goto L6;
        Map r1 = ao.e(r0);
        if (r1 == null) goto L6;
    L7:
        Map r14 = r1;
        String r2 = r16.l();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r14.put("journalPath", r2);
        r14.put("termType", String.valueOf(r16.k()));
        r14.put("taskFlag", String.valueOf(r16.getType()));
        r14.put("key", r16.f());
        r14.put("sessionKey", r16.i());
        long r3 = r16.a();
        if (r16.b() == null) goto L13;
    L16:
        int r4 = 1;
    L18:
        return new EventTaskExecutionRecord(r3, r4, 1, r16.c(), r16.e(), r16.d(), r16.g(), r16.j(), r16.h(), r14, null);
    L13:
        if (r16.c() != null) goto L16;
        r4 = 0;
    L6:
        r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        goto L7
    }

    public static final com.obric.autogui.database.entity.a a(EventTaskExecutionRecord r29) {
        o.e(r29, "<this>");
        Map<String, String> r0 = r29.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("journalPath"), String.class, "com.obric.aiagent.plugin");
    L6:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        int r6 = 0;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L14:
        if ((!r5) == false) goto L16;
        String r27 = r1;
    L17:
        Map<String, String> r2 = r29.getExt();
        if (r2 == null) goto L24;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("termType"), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L24;
        Integer r7 = d.o.o.d(r3);
        if (r7 == null) goto L24;
        int r26 = r7.intValue();
    L25:
        Map<String, String> r8 = r29.getExt();
        if (r8 == null) goto L32;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get("taskFlag"), String.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L32;
        Integer r10 = d.o.o.d(r9);
        if (r10 == null) goto L32;
        r6 = r10.intValue();
    L32:
        int r19 = r6;
        Map<String, String> r11 = r29.getExt();
        if (r11 == null) goto L38;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.get("key"), String.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L38;
        String r18 = r12;
    L39:
        Map<String, String> r13 = r29.getExt();
        if (r13 == null) goto L45;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get("sessionKey"), String.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        String r24 = r14;
    L46:
        Map<String, String> r15 = r29.getExt();
        if (r15 == null) goto L50;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.get("o_omni_reply_unique_id"), String.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L50;
    L51:
        Map<String, String> r17 = r29.getExt();
        if (r17 == null) goto L55;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r17.get("o_omni_resource_id"), String.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L55;
    L56:
        Map<String, String> r21 = r29.getExt();
        if (r21 == null) goto L60;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L60;
    L61:
        Map<String, String> r23 = r29.getExt();
        if (r23 == null) goto L65;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r23.get("queryId"), String.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L65;
    L66:
        long r28 = r29.getId();
        String r110 = r29.getTaskId();
        long r111 = r29.getTriggerTime();
        long r112 = r29.getTriggerTime();
        String r30 = r29.getQuery();
        if (r30 != null) goto L69;
        String r113 = "";
    L70:
        com.obric.autogui.database.entity.a r31 = new com.obric.autogui.database.entity.a(r28, null, null, r110, r111, r112, r113, r18, r19, r29.getDuration(), "", r29.getResultMessage(), r24, r29.getResultCode(), r26, r27, true);
        r31.c(r16);
        r31.d(r20);
        r31.e(r22);
        r31.f(r25);
        r31.c(r29.getTaskMode());
        r31.a(r29.getExt());
        r31.g(r29.getComplexTaskModel());
        return r31;
    L69:
        r113 = r30;
    L65:
        r25 = "";
    L60:
        r22 = "";
    L55:
        r20 = "";
    L50:
        r16 = "";
    L45:
        r24 = "";
    L38:
        r18 = "";
    L24:
        r26 = 0;
        goto L25
    L16:
        r27 = null;
        goto L17
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }
}
