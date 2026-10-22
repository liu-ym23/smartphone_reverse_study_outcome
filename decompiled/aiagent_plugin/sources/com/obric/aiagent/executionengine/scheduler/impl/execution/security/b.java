package com.obric.aiagent.executionengine.scheduler.impl.execution.security;

import android.content.Context;
import com.bytedance.a.c;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import d.h.b.o;
import d.o.d;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PolicyLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "PolicyLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f18457b = null;

    private b() {
    }

    static {
        f18456a = new b();
        f18457b = new Gson();
    }

    public final Map<String, IntentExecutePolicyGroup> a() {
        Map<String, IntentExecutePolicyGroup> r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        ILogDepend.Companion.i(TAG, "loadFromCloud failed, start loadFromAssets");
        Map<String, IntentExecutePolicyGroup> r3 = c();
        if (r3 == null) goto L8;
        return r3;
    L8:
        ILogDepend.Companion.e(TAG, "loadFromAssets failed");
        return ao.b();
    }

    private final Map<String, IntentExecutePolicyGroup> b() {
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r0 == null) goto L5;
        String r1 = r0.getObricCloudConfig("obric_appintent_lockscreen_execute_config");
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        return null;
    L16:
        return a(r1, true);
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final Map<String, IntentExecutePolicyGroup> c() {
        InputStream r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getAssets().open("security_policies/intent_execute.json");
        b r0 = f18456a;
        o.a(r2);
        return r0.a(d.o.o.a(d.f.b.a(r2)), false);
    }

    private final Map<String, IntentExecutePolicyGroup> a(String r4, boolean r5) {
        IntentExecutePolicy r6 = (IntentExecutePolicy) ZeusTransformUtils.preCheckCast(f18457b.fromJson(r4, IntentExecutePolicy.class), IntentExecutePolicy.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        String r1 = r6.getContent().toString();     // Catch: Throwable -> L15
        o.c(r1, "toString(...)");     // Catch: Throwable -> L15
        if (r5 == false) goto L10;
        if (a(r1, r6.getSignature()) == true) goto L10;
        ILogDepend.Companion.e(TAG, "checkSignature failed");     // Catch: Throwable -> L15
        return null;
    L10:
        if (r6.getVersion() == 1) goto L12;
        ILogDepend.Companion.e(TAG, "unknown version " + r6.getVersion());     // Catch: Throwable -> L15
        return null;
    L12:
        return a(r1);
    L15:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "loadInternal failed", th);
        return null;
    }

    private final Map<String, IntentExecutePolicyGroup> a(String r3) {
        V1IntentExecutePolicyContent r2 = (V1IntentExecutePolicyContent) ZeusTransformUtils.preCheckCast(f18457b.fromJson(r3, V1IntentExecutePolicyContent.class), V1IntentExecutePolicyContent.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getVersion(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L16;
        if (o.a(r2.getVersion(), IAppContext.Companion.getVersionName()) == true) goto L16;
        ILogDepend.Companion.e(TAG, "policy version " + r2.getVersion() + " not match, app version is " + IAppContext.Companion.getVersionName());
        return null;
    L16:
        return r2.getPolicies();
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    private final String b(String r1) {
        JsonElement r2 = JsonParser.parseString(r1);
        o.a(r2);
        String r0 = a(r2).toString();
        o.c(r0, "toString(...)");
        return r0;
    }

    private final JsonElement a(JsonElement r6) {
        if (r6.isJsonNull() == false) goto L5;
        return r6;
    L5:
        if (r6.isJsonPrimitive() == false) goto L8;
        return r6;
    L8:
        if (r6.isJsonArray() == false) goto L15;
        JsonArray r5 = new JsonArray();
        JsonArray r7 = r6.getAsJsonArray();
        o.c(r7, "getAsJsonArray(...)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L30;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r8.next(), JsonElement.class, "com.obric.aiagent.plugin");
        b r2 = f18456a;
        o.a(r0);
        r5.add(r2.a(r0));
        goto L11
    L30:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
    L15:
        if (r6.isJsonObject() == false) goto L31;
        JsonObject r9 = r6.getAsJsonObject();
        TreeMap r1 = new TreeMap();
        Iterator<Map.Entry<String, JsonElement>> r10 = r9.entrySet().iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r3);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r11 = (JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
        o.a(r11);
        r12.put(r4, a(r11));
        goto L18
    L20:
        JsonObject r13 = new JsonObject();
        Iterator r14 = ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L22:
        if (r14.hasNext() == false) goto L25;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r13.add((String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r15.getValue(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L22
    L25:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin");
    L31:
        return r6;
    }

    private final boolean a(String r5, String r6) {
        if (r5 == null) goto L16;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L17;
        c r4 = new c();
        byte[] r7 = b(r5).getBytes(d.f38623b);
        o.c(r7, "getBytes(...)");
        if (r4.a(r7, com.bytedance.a.d.a(r6), 1) == 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    L16:
        return false;
    }
}
