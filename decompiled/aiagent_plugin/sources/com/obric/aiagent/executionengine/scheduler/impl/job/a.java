package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f18458a;

    public a(JSONObject r2) {
        o.e(r2, "json");
        this.f18458a = r2;
    }

    public final String a(String... r7) {
        o.e(r7, "keys");
        int r0 = r7.length;
        int r2 = 0;
    L3:
        String r3 = null;
        if (r2 >= r0) goto L34;
        String r4 = r7[r2];
        if (this.f18458a.has(r4) == false) goto L33;
        if (this.f18458a.isNull(r4) == true) goto L33;
        Object r5 = this.f18458a.opt(r4);
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L13;
    L18:
        String r6 = r5.toString();
    L20:
        if (r6 == null) goto L22;
        r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L22:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L33;
        if (o.a(r3, "null") == true) goto L33;
        return r3;
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
        goto L29
    L13:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == true) goto L18;
        if (r5 == null) goto L17;
        r6 = r5.toString();
        goto L20
    L17:
        r6 = null;
    L33:
        r2 = r2 + 1;
        goto L3
    L34:
        return null;
    }

    public final List<String> a(String r6) {
        o.e(r6, "key");
        JSONArray r5 = this.f18458a.optJSONArray(r6);
        if (r5 == null) goto L5;
        List r7 = p.a();
        int r0 = 0;
        int r1 = r5.length();
    L7:
        if (r0 >= r1) goto L20;
        Object r2 = r5.opt(r0);
        if (r2 == null) goto L18;
        String r3 = r2.toString();
        if (r3 == null) goto L18;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L18;
        r7.add(r3);
    L18:
        r0 = r0 + 1;
        goto L7
    L20:
        return p.a(r7);
    L5:
        return p.b();
    }

    public final String a() {
        JSONArray r7 = this.f18458a.optJSONArray("action_list");
        if (r7 != null) goto L5;
        return null;
    L5:
        JSONArray r1 = new JSONArray();
        int r2 = r7.length();
        boolean r3 = false;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        JSONObject r5 = r7.optJSONObject(r4);
        if (r5 == null) goto L12;
        String r6 = j.a(r5, new String[]{"action_type"});
        if (r6 == null) goto L12;
        r1.put(r6);
    L12:
        r4 = r4 + 1;
        goto L6
    L14:
        if (r1.length() <= 0) goto L16;
        r3 = true;
    L16:
        if (r3 == true) goto L19;
        r1 = null;
    L19:
        if (r1 != null) goto L21;
        return null;
    L21:
        return r1.toString();
    }

    public final String b() {
        JSONArray r7 = this.f18458a.optJSONArray("action_list");
        if (r7 != null) goto L5;
        return null;
    L5:
        JSONArray r1 = new JSONArray();
        int r2 = r7.length();
        boolean r3 = false;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        JSONObject r5 = r7.optJSONObject(r4);
        if (r5 == null) goto L12;
        JSONArray r6 = r5.optJSONArray("action_args");
        if (r6 == null) goto L12;
        r1.put(r6);
    L12:
        r4 = r4 + 1;
        goto L6
    L14:
        if (r1.length() <= 0) goto L16;
        r3 = true;
    L16:
        if (r3 == true) goto L19;
        r1 = null;
    L19:
        if (r1 != null) goto L21;
        return null;
    L21:
        return r1.toString();
    }

    public final JSONObject c() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r2 = n.f(new JSONObject(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f18458a.toString()));     // Catch: Throwable -> L5
    L7:
        JSONObject r3 = this.f18458a;
        if (n.b(r2) == false) goto L11;
        r2 = r3;
    L11:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L7
    }
}
