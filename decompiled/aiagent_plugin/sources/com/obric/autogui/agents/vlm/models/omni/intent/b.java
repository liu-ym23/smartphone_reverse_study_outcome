package com.obric.autogui.agents.vlm.models.omni.intent;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.n;
import d.o.o;

/* JADX INFO: compiled from: OmniGUIIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ String a(JsonObject r0, String r1) {
        return c(r0, r1);
    }

    public static final /* synthetic */ Boolean b(JsonObject r0, String r1) {
        return d(r0, r1);
    }

    private static final String c(JsonObject r3, String r4) {
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L23
        JsonElement r5 = r3.get(r4);     // Catch: Throwable -> L23
        if (r5 != null) goto L6;
    L20:
        String r6 = null;
    L21:
        Object r7 = n.f(r6);     // Catch: Throwable -> L23
    L26:
        if (n.b(r7) == true) goto L30;
        r1 = r7;
    L30:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L6:
        if (r5.isJsonNull() == false) goto L9;
        r5 = null;
    L9:
        if (r5 == null) goto L20;
        String r8 = r5.getAsString();     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        r6 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L23
        if (r6 == null) goto L20;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L20;
    L17:
        r9 = false;
    L23:
        th = move-exception;
        n.a r10 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L26
    }

    private static final Boolean d(JsonObject r2, String r3) {
        Object r0 = null;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L14
        JsonElement r4 = r2.get(r3);     // Catch: Throwable -> L14
        if (r4 != null) goto L6;
    L11:
        Boolean r5 = null;
    L12:
        Object r6 = n.f(r5);     // Catch: Throwable -> L14
    L17:
        if (n.b(r6) == true) goto L21;
        r0 = r6;
    L21:
        return (Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin");
    L6:
        if (r4.isJsonNull() == false) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L11;
        r5 = Boolean.valueOf(r4.getAsBoolean());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L17
    }

    public static final int a(g r1) {
        d.h.b.o.e(r1, "<this>");
        return a(r1.c(), r1.d());
    }

    public static final String b(g r1) {
        d.h.b.o.e(r1, "<this>");
        return b(r1.c(), r1.d());
    }

    public static final int a(j r2, JsonObject r3) {
        d.h.b.o.e(r3, "stepJson");
        JsonElement r4 = r3.get("action_list");
        Integer r0 = null;
        if (r4 != null) goto L5;
    L12:
        if (r0 != null) goto L18;
        if (r2 == null) goto L16;
        return 1;
    L16:
        return 0;
    L18:
        return r0.intValue();
    L5:
        if (r4.isJsonArray() == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        JsonArray r5 = r4.getAsJsonArray();
        if (r5 == null) goto L12;
        r0 = Integer.valueOf(r5.size());
        goto L12
    }

    public static final String b(j r4, JsonObject r5) {
        d.h.b.o.e(r5, "stepJson");
        JsonElement r6 = r5.get("action_list");
        String r0 = null;
        if (r6 != null) goto L5;
    L10:
        JsonArray r7 = null;
    L12:
        if (r7 != null) goto L14;
        if (r4 == null) goto L62;
        String r8 = r4.a();
        if (r8 != null) goto L50;
        return SensitiveType.UNKNOWN;
    L50:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L52;
        r0 = r8;
    L52:
        if (r0 != null) goto L54;
        return SensitiveType.UNKNOWN;
    L54:
        return r0;
    L62:
        return SensitiveType.UNKNOWN;
    L14:
        if (r7.size() <= 1) goto L17;
        return "multi_action";
    L17:
        JsonElement r9 = (JsonElement) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L20;
        return SensitiveType.UNKNOWN;
    L20:
        if (r9.isJsonObject() == true) goto L23;
        r9 = null;
    L23:
        if (r9 == null) goto L56;
        JsonObject r10 = r9.getAsJsonObject();
        if (r10 == null) goto L57;
        JsonElement r11 = r10.get("action_type");
        if (r11 != null) goto L29;
        return SensitiveType.UNKNOWN;
    L29:
        if (r11.isJsonPrimitive() == true) goto L31;
    L33:
        boolean r12 = false;
    L34:
        if (r12 == true) goto L37;
        r11 = null;
    L37:
        if (r11 == null) goto L59;
        String r13 = r11.getAsString();
        if (r13 != null) goto L41;
        return SensitiveType.UNKNOWN;
    L41:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L43;
        r0 = r13;
    L43:
        if (r0 != null) goto L45;
        return SensitiveType.UNKNOWN;
    L45:
        return r0;
    L59:
        return SensitiveType.UNKNOWN;
    L31:
        if (r11.getAsJsonPrimitive().isString() == false) goto L33;
        r12 = true;
        goto L34
    L57:
        return SensitiveType.UNKNOWN;
    L56:
        return SensitiveType.UNKNOWN;
    L5:
        if (r6.isJsonArray() == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        r7 = r6.getAsJsonArray();
        goto L12
    }
}
