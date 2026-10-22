package com.obric.aiagent.skill.ovirt.impl.h;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.skill.manager.api.al;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.n;
import d.o.k;
import d.o.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ShellEnvironmentDefaults.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21450a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f21451b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f21452c = null;

    private b() {
    }

    static {
        f21450a = new b();
        f21451b = new k("[A-Za-z_][A-Za-z0-9_]*");
        f21452c = ax.a("HOME");
    }

    public final Map<String, String> a() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(al.f19195a.a().H(), CharSequence.class, "com.obric.aiagent.plugin");
        if (o.d(r0) == false) goto L5;
        r0 = "NODE_USE_ENV_PROXY=1\nNPM_CONFIG_PREFIX=~/.npm-global";
    L5:
        Map<String, String> r1 = b((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L8;
        return r1;
    L8:
        return a("NODE_USE_ENV_PROXY=1\nNPM_CONFIG_PREFIX=~/.npm-global");
    }

    public final Map<String, String> a(String r2) {
        d.h.b.o.e(r2, "rawConfig");
        Map<String, String> r1 = b(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return ao.b();
    }

    private final Map<String, String> b(String r6) {
        String r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return ao.b();
    L7:
        if (o.b(r0, "{", false, 2, null) == false) goto L10;
        return c(r0);
    L10:
        return d(r6);
    }

    private final Map<String, String> c(String r7) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r8 = n.f(JsonParser.parseString(r7));     // Catch: Throwable -> L5
    L8:
        if (n.b(r8) == false) goto L10;
        r8 = null;
    L10:
        JsonElement r9 = (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, JsonObject.class) == false) goto L13;
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(r9, JsonObject.class, "com.obric.aiagent.plugin");
    L14:
        if (r10 != null) goto L16;
        return null;
    L16:
        Map r11 = ao.a();
        Set<Map.Entry<String, JsonElement>> r12 = r10.entrySet();
        d.h.b.o.c(r12, "entrySet(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r13.hasNext() == false) goto L46;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r2.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        b r5 = f21450a;
        if (r5.e(r3) == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, JsonPrimitive.class) == false) goto L28;
        JsonPrimitive r14 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r4, JsonPrimitive.class, "com.obric.aiagent.plugin");
    L29:
        if (r14 == null) goto L18;
        if (r14.isString() == true) goto L38;
        if (r14.isNumber() == true) goto L38;
        if (r14.isBoolean() == false) goto L18;
    L38:
        String r15 = r14.getAsString();
        if (r5.f(r15) == true) goto L42;
        r15 = null;
    L42:
        if (r15 == null) goto L18;
        r11.put(r3, r15);
        goto L18
    L28:
        r14 = null;
        goto L29
    L46:
        return ao.a(r11);
    L13:
        r10 = null;
    L5:
        th = move-exception;
        n.a r16 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L8
    }

    private final Map<String, String> d(String r13) {
        Map r12 = ao.a();
        Iterator<String> r14 = o.f((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).a();
    L4:
        if (r14.hasNext() == false) goto L25;
        String r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L4;
        String r5 = null;
        if (o.b(r0, "#", false, 2, null) == true) goto L4;
        int r2 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), '=', 0, false, 6, null);
        if (r2 <= 0) goto L4;
        String r3 = r0.substring(0, r2);
        d.h.b.o.c(r3, "substring(...)");
        String r4 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        b r6 = f21450a;
        if (r6.e(r4) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L4;
        String r1 = r0.substring(r2 + 1);
        d.h.b.o.c(r1, "substring(...)");
        if (r6.f(r1) == false) goto L21;
        r5 = r1;
    L21:
        if (r5 == null) goto L4;
        r12.put(r4, r5);
        goto L4
    L25:
        return ao.a(r12);
    }

    private final boolean e(String r8) {
        if (f21452c.contains(r8) == false) goto L5;
    L9:
        return false;
    L5:
        if (o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, false, 6, null) >= 0) goto L9;
        if (f21451b.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    }

    private final boolean f(String r7) {
        if (o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, false, 6, null) >= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
