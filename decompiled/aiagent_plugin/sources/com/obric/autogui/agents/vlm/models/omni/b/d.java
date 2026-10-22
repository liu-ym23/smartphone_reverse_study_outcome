package com.obric.autogui.agents.vlm.models.omni.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.agents.vlm.models.omni.intent.j;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniGuiToolTraceFieldBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f28224a = null;

    static {
        f28224a = new d();
    }

    private d() {
    }

    public final Map<String, Object> a(Map<f, Long> r4, Map<c, Long> r5, Map<String, ? extends Object> r6, Map<String, ? extends Object> r7, boolean r8) {
        Map<f, Long> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "points");
        o.e(r9, "detailDurations");
        o.e(r10, "actionFields");
        o.e(r11, "extFields");
        Map<String, Object> r12 = ao.a();
        r12.putAll(r10);
        r12.putAll(r11);
        r12.put("was_interrupted", Boolean.valueOf(r8));
        d r13 = f28224a;
        r13.a(r12, p.a(g.f28231a.a()), r3);
        if (r8 == true) goto L9;
        r13.a(r12, g.f28231a.b(), r3);
        Iterator r14 = r9.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        c r16 = (c) ZeusTransformUtils.preCheckCast(r15.getKey(), c.class, "com.obric.aiagent.plugin");
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r15.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r12.put(r16.a(), Long.valueOf(r1));
    L9:
        return ao.a(r12);
    }

    public final Map<String, Object> a(com.obric.autogui.agents.vlm.models.omni.intent.g r12) {
        o.e(r12, Ext.KEY_REQUEST);
        Map r11 = ao.a();
        JsonElement r0 = r12.d().get("action_list");
        JsonElement r1 = null;
        if (r0 != null) goto L5;
    L10:
        JsonArray r2 = null;
    L11:
        boolean r3 = false;
        if (r12.c() == null) goto L14;
        int r4 = 1;
    L18:
        if (r2 != null) goto L20;
    L37:
        JsonObject r6 = null;
    L39:
        if (r12.c() != null) goto L42;
        if (r4 == 1) goto L42;
        boolean r7 = true;
    L43:
        j r8 = r12.c();
        if (r8 == null) goto L47;
        String r9 = r8.a();
        if (r9 == null) goto L47;
    L65:
        j r5 = r12.c();
        if (r5 == null) goto L70;
        JsonArray r10 = r5.b();
        if (r10 == null) goto L70;
        r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin");
    L72:
        d r13 = f28224a;
        r11.put("action_type", r13.a(r9));
        if (r7 == false) goto L75;
        r11.put("action_types", r13.a(r2, r4));
    L75:
        r11.put("action_count", Integer.valueOf(r4));
        if (r1 == null) goto L78;
        r11.put("action_args", r13.a(r1));
    L78:
        r11.put("instruction_type", r13.a(r12.i()));
        String r14 = r12.e();
        if (r14 == null) goto L81;
        r11.put("prev_step_status", r13.a(r14));
    L81:
        r11.put("is_gui_idle", Boolean.valueOf(r12.k()));
        return ao.a(r11);
    L70:
        if (r6 == null) goto L72;
        r1 = r6.get("action_args");
    L47:
        if (r6 == null) goto L60;
        JsonElement r15 = r6.get("action_type");
        if (r15 == null) goto L60;
        if (r15.isJsonPrimitive() == true) goto L53;
    L55:
        if (r3 == true) goto L58;
        r15 = null;
    L58:
        if (r15 == null) goto L60;
        r9 = r15.getAsString();
    L61:
        if (r9 != null) goto L65;
        if (r7 == false) goto L64;
        r9 = "multi_action";
        goto L65
    L64:
        r9 = SensitiveType.UNKNOWN;
        goto L65
    L53:
        if (r15.getAsJsonPrimitive().isString() == false) goto L55;
        r3 = true;
    L60:
        r9 = null;
    L42:
        r7 = false;
        goto L43
    L20:
        if (r12.c() == null) goto L22;
    L24:
        boolean r16 = false;
    L25:
        if (r16 == false) goto L27;
        JsonArray r17 = r2;
    L28:
        if (r17 == null) goto L37;
        JsonElement r18 = (JsonElement) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L37;
        if (r18.isJsonObject() == true) goto L35;
        r18 = null;
    L35:
        if (r18 == null) goto L37;
        r6 = r18.getAsJsonObject();
        goto L39
    L27:
        r17 = null;
        goto L28
    L22:
        if (r2.size() != 1) goto L24;
        r16 = true;
        goto L25
    L14:
        if (r2 == null) goto L16;
        r4 = r2.size();
        goto L18
    L16:
        r4 = 0;
        goto L18
    L5:
        if (r0.isJsonArray() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r2 = r0.getAsJsonArray();
        goto L11
    }

    private final void a(Map<String, Object> r6, List<a> r7, Map<f, Long> r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Map<f, Long> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.aiagent.plugin");
        Long r3 = f28224a.a(r2, r10);
        if (r3 == null) goto L8;
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue();
        m r13 = s.a(r2.a(), Long.valueOf(r4));
    L9:
        if (r13 == null) goto L4;
        r1.add(r13);
        goto L4
    L8:
        r13 = null;
        goto L9
    L11:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r14.size() == r9.size()) goto L14;
        return;
    L14:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        m r16 = (m) ZeusTransformUtils.preCheckCast(r15.next(), m.class, "com.obric.aiagent.plugin");
        r5.put((String) ZeusTransformUtils.preCheckCast(r16.c(), String.class, "com.obric.aiagent.plugin"), Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16.d(), Number.class, "com.obric.aiagent.plugin")).longValue()));
        goto L16
    }

    private final Long a(a r5, Map<f, Long> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r4.get(r5.b()), Long.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        long r2 = r7.longValue();
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r4.get(r5.c()), Long.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        Long r9 = Long.valueOf(r8.longValue() - r2);
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L12;
        return null;
    L12:
        return r9;
    L9:
        r10 = false;
        goto L10
    L14:
        return null;
    L13:
        return null;
    }

    private final String a(JsonArray r6, int r7) {
        JsonArray r5 = new JsonArray();
        if (r6 == null) goto L29;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L29;
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r8.next(), JsonElement.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r2.isJsonObject() == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L27;
        JsonObject r3 = r2.getAsJsonObject();
        if (r3 == null) goto L27;
        JsonElement r9 = r3.get("action_type");
        if (r9 == null) goto L27;
        if (r9.isJsonPrimitive() == true) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L25;
        r9 = null;
    L25:
        if (r9 == null) goto L27;
        r4 = r9.getAsString();
        goto L27
    L19:
        if (r9.getAsJsonPrimitive().isString() == false) goto L21;
        r10 = true;
    L27:
        if (r4 == null) goto L6;
        r5.add(f28224a.a(r4));
    L29:
        String r11 = r5.toString();
        o.c(r11, "toString(...)");
        if (r11.length() > 1024) goto L32;
        return r11;
    L32:
        JsonObject r12 = new JsonObject();
        r12.addProperty("truncated", true);
        r12.addProperty("action_count", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7), Number.class, "com.obric.aiagent.plugin"));
        String r13 = r12.toString();
        o.c(r13, "toString(...)");
        return r13;
    }

    private final String a(JsonElement r2) {
        String r3 = r2.toString();
        o.c(r3, "toString(...)");
        return a(r3);
    }

    private final String a(String r1) {
        return d.o.o.e(r1, 1024);
    }
}
