package com.obric.agent;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.common.Ext;
import com.obric.funcall_api.bean.AppAction;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IntentActionInputResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f15194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f15195b = null;

    public static /* synthetic */ d.n.j lambda$vNRY5FUFf4P06yNmQMLxaKwuFNo(com.obric.agent.dm.f r0) {
        return a(r0);
    }

    private m() {
    }

    static {
        f15194a = new m();
        f15195b = new Gson();
    }

    public final String a(IntentAppAction r2, String r3) {
        d.h.b.o.e(r2, Ext.KEY_REQUEST);
        d.h.b.o.e(r3, "intentName");
        String r0 = b(r2, r3);
        if (r0 != null) goto L8;
        String r1 = c(r2, r3);
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L8:
        return r0;
    }

    private final String b(IntentAppAction r4, String r5) {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
        m r3 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        AppAction r6 = r4.getAction();     // Catch: Throwable -> L18
        if (r6 != null) goto L6;
    L15:
        String r7 = null;
    L16:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L18
    L21:
        if (d.n.b(r8) == true) goto L25;
        r1 = r8;
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L6:
        if (d.h.b.o.a(r6.getAction(), r5) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L15;
        r7 = r6.getParams();     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
    L18:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L21
    }

    private final String c(IntentAppAction r5, String r6) {
        String r7 = r5.getContent();
        Object r0 = null;
        if (r7 != null) goto L5;
    L54:
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L54;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L46
        m r4 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        JsonElement r8 = JsonParser.parseString(r7);     // Catch: Throwable -> L46
        if (r8.isJsonObject() == true) goto L14;
        r8 = null;
    L14:
        if (r8 == null) goto L43;
        JsonObject r9 = r8.getAsJsonObject();     // Catch: Throwable -> L46
        if (r9 == null) goto L43;
        JsonElement r10 = r9.get("Content");     // Catch: Throwable -> L46
        if (r10 == null) goto L43;
        com.obric.agent.dm.e r11 = r4.a(r10);     // Catch: Throwable -> L46
        if (r11 == null) goto L43;
        List<com.obric.agent.dm.f> r12 = r11.a();     // Catch: Throwable -> L46
        if (r12 != null) goto L25;
        r12 = d.a.p.b();     // Catch: Throwable -> L46
    L25:
        Iterator r13 = d.n.m.c(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$m$vNRY5FUFf4P06yNmQMLxaKwuFNo.INSTANCE).a();     // Catch: Throwable -> L46
    L27:
        if (r13.hasNext() == false) goto L31;
        Object r2 = r13.next();     // Catch: Throwable -> L46
        if (d.h.b.o.a(((com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(r2, com.obric.agent.dm.b.class, "com.obric.aiagent.plugin")).a(), r6) == false) goto L27;
    L32:
        com.obric.agent.dm.b r14 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(r2, com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (r14 == null) goto L43;
        JsonObject r15 = r14.c();     // Catch: Throwable -> L46
        if (r15 == null) goto L40;
        JsonObject r16 = r4.a(r15);     // Catch: Throwable -> L46
        if (r16 == null) goto L40;
        String r17 = r16.toString();     // Catch: Throwable -> L46
    L41:
        if (r17 != null) goto L44;
        r17 = "";
    L44:
        Object r18 = d.n.f(r17);     // Catch: Throwable -> L46
    L49:
        if (d.n.b(r18) == true) goto L53;
        r0 = r18;
    L53:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L40:
        r17 = null;
        goto L41
    L31:
        r2 = null;
    L43:
        r17 = null;
    L46:
        th = move-exception;
        d.n.a r19 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
        goto L49
    }

    private static final d.n.j a(com.obric.agent.dm.f r2) {
        d.h.b.o.e(r2, "it");
        List<com.obric.agent.dm.b> r3 = r2.a();
        if (r3 != null) goto L6;
        r3 = d.a.p.b();
    L6:
        return d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.agent.dm.e a(JsonElement r3) {
        if (r3.isJsonObject() == false) goto L6;
        return (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(f15195b.fromJson(r3, com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r3.isJsonPrimitive() == true) goto L8;
    L10:
        return null;
    L8:
        if (r3.getAsJsonPrimitive().isString() == false) goto L10;
        return (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(f15195b.fromJson(r3.getAsString(), com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
    }

    private final JsonObject a(JsonObject r5) {
        JsonObject r4 = r5.deepCopy();
        Set<Map.Entry<String, JsonElement>> r6 = r5.entrySet();
        d.h.b.o.c(r6, "entrySet(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r1.isJsonObject() == false) goto L4;
        JsonElement r3 = r1.getAsJsonObject().get("value");
        if (r3 == null) goto L4;
        r4.add(r2, r3);
        goto L4
    L10:
        d.h.b.o.c(r4, "apply(...)");
        return r4;
    }
}
