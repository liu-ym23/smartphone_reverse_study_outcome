package com.obric.agent.card.weather;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.agent.m;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.WeatherInfo;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: WeatherActionResultCardDataBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = "WeatherActionResultCardDataBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14293a = null;

    static {
        f14293a = new g();
    }

    private g() {
    }

    public final String a(Context r11, IntentAppAction r12, IntentResult<?> r13, String r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r12, Ext.KEY_REQUEST);
        o.e(r13, "intentResult");
        o.e(r14, "intentName");
        boolean r15 = o.a(r14, "Weather_Search");
        String r16 = null;
        if (r15 == true) goto L5;
    L23:
        return null;
    L5:
        if (r13.getRet() != 0) goto L23;
        Object r17 = r13.getEntity();
        if (ZeusTransformUtils.instanceOf(r17, WeatherInfo.class) == false) goto L10;
        WeatherInfo r8 = (WeatherInfo) ZeusTransformUtils.preCheckCast(r17, WeatherInfo.class, "com.obric.aiagent.plugin");
    L11:
        if (r8 != null) goto L13;
        return null;
    L13:
        JsonObject r18 = a(r12);
        String r19 = a(r18, "type");
        if (r19 != null) goto L16;
    L20:
        String r4 = "WEATHER";
    L22:
        return j.f14298a.a(r3, r4, a(r18, "time"), a(r18, "startTime"), a(r18, "endTime"), r8, String.valueOf(r12.getQuestionId()));
    L16:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        r16 = r19;
    L18:
        if (r16 == null) goto L20;
        r4 = r16;
        goto L22
    L10:
        r8 = null;
        goto L11
    }

    public final void a(Context r5, Gson r6, IntentAppAction r7, IntentAppAction r8, IntentResult<?> r9, String r10, d.h.a.a<String> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r6, "gson");
        o.e(r7, "result");
        o.e(r8, Ext.KEY_REQUEST);
        o.e(r9, "intentResult");
        o.e(r10, "intentName");
        o.e(r13, "fallbackContent");
        String r14 = a(r12, r8, r9, r10);
        if (r14 != null) goto L5;
        return;
    L5:
        Object r15 = null;
        n.a r16 = n.f38560a;     // Catch: Throwable -> L21
        g r4 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        com.obric.agent.b.a r17 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(r6.fromJson(r7.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r17 == null) goto L18;
        r17.d(r14);     // Catch: Throwable -> L21
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.c(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r18 != null) goto L11;
    L14:
        boolean r19 = true;
    L15:
        if (r19 == false) goto L17;
        r17.b(String.valueOf(r8.getMessageId()));     // Catch: Throwable -> L21
    L17:
        String r20 = r6.toJson(r17);     // Catch: Throwable -> L21
    L19:
        Object r21 = n.f(r20);     // Catch: Throwable -> L21
    L23:
        Throwable r22 = n.c(r21);
        if (r22 == null) goto L27;
        ILogDepend.Companion.e(TAG, "enrichIfNeeded parse result content failed", r22);
    L27:
        if (n.b(r21) == true) goto L30;
        r15 = r21;
    L30:
        String r23 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L33;
        r23 = (String) ZeusTransformUtils.preCheckCast(r13.invoke(), String.class, "com.obric.aiagent.plugin");
    L33:
        r7.setContent(r23);
        return;
    L11:
        if (d.o.o.d(r18) == true) goto L14;
        r19 = false;
        goto L15
    L18:
        r20 = null;
    L21:
        th = move-exception;
        n.a r24 = n.f38560a;
        r21 = n.f(d.o.a(th));
        goto L23
    }

    private final JsonObject a(IntentAppAction r7) {
        String r8 = m.f15194a.a(r7, "Weather_Search");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        Object r0 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L16
        g r6 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        JsonElement r9 = JsonParser.parseString(r8);     // Catch: Throwable -> L16
        if (r9.isJsonObject() == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L13;
        JsonObject r10 = r9.getAsJsonObject();     // Catch: Throwable -> L16
    L14:
        Object r11 = n.f(r10);     // Catch: Throwable -> L16
    L18:
        Throwable r3 = n.c(r11);
        if (r3 == null) goto L22;
        ILogDepend.Companion.e(TAG, "resolveInputParams failed: " + r8, r3);
    L22:
        if (n.b(r11) == true) goto L25;
        r0 = r11;
    L25:
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L28;
        return r12;
    L28:
        return new JsonObject();
    L13:
        r10 = null;
    L16:
        th = move-exception;
        n.a r4 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L18
    L5:
        return new JsonObject();
    }

    private final String a(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isJsonNull() == false) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return null;
    L15:
        return r0.getAsString();
    L7:
        if (r0.isJsonPrimitive() == false) goto L9;
        r3 = true;
        goto L10
    }
}
