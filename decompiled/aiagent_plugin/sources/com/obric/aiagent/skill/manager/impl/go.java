package com.obric.aiagent.skill.manager.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningStateStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class go {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f20015a = null;

    public static final gp a(gj r4) {
        d.h.b.o.e(r4, "<this>");
        Object r1 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L15;
        return null;
    L15:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r5 = d.n.f((gp) ZeusTransformUtils.preCheckCast(f20015a.fromJson(r4.d(), gp.class), gp.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r5) == true) goto L14;
        r1 = r5;
    L14:
        return (gp) ZeusTransformUtils.preCheckCast(r1, gp.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L10
    }

    public static final JsonElement b(gj r1) {
        d.h.b.o.e(r1, "<this>");
        gf r2 = c(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a();
    }

    public static final gf c(gj r4) {
        d.h.b.o.e(r4, "<this>");
        String r1 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L46;
        return null;
    L46:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r5 = d.n.f((JsonElement) ZeusTransformUtils.preCheckCast(f20015a.fromJson(r4.e(), JsonElement.class), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r5) == false) goto L12;
        r5 = null;
    L12:
        JsonElement r6 = (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L15;
    L45:
        return null;
    L15:
        if (r6.isJsonObject() == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L45;
        JsonObject r7 = r6.getAsJsonObject();
        if (r7 == null) goto L45;
        JsonElement r2 = r7.get("signed_manifest");
        if (r2 == null) goto L44;
        if (r2.isJsonNull() == false) goto L27;
        r2 = null;
    L27:
        if (r2 != null) goto L29;
        return null;
    L29:
        JsonElement r8 = r7.get("signing_payload_base64");
        if (r8 == null) goto L48;
        if (r8.isJsonPrimitive() == true) goto L34;
    L36:
        boolean r3 = false;
    L37:
        if (r3 == true) goto L40;
        r8 = null;
    L40:
        if (r8 == null) goto L48;
        r1 = r8.getAsString();
        goto L48
    L34:
        if (r8.getAsJsonPrimitive().isString() == false) goto L36;
        r3 = true;
    L48:
        return new gf(r2, r1);
    L44:
        return new gf((JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin"), null);
    L7:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L10
    }

    public static final boolean d(gj r4) {
        d.h.b.o.e(r4, "<this>");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L24;
        return false;
    L24:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r5 = d.n.f((JsonElement) ZeusTransformUtils.preCheckCast(f20015a.fromJson(r4.e(), JsonElement.class), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L9:
        JsonElement r3 = null;
        if (d.n.b(r5) == false) goto L12;
        r5 = null;
    L12:
        JsonElement r6 = (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L15;
        return false;
    L15:
        if (r6.isJsonObject() == false) goto L17;
        r3 = r6;
    L17:
        if (r3 == null) goto L27;
        JsonObject r7 = r3.getAsJsonObject();
        if (r7 != null) goto L21;
        return false;
    L21:
        if (r7.has("signed_manifest") == true) goto L23;
        return false;
    L23:
        return true;
    L27:
        return false;
    L7:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L9
    }

    static {
        f20015a = new Gson();
    }
}
