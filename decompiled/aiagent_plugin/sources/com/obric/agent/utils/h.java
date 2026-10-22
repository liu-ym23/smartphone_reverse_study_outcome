package com.obric.agent.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientToolReportHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f16032a = null;

    static {
        f16032a = new h();
    }

    private h() {
    }

    public final g a(String r7) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r4 = null;
        if (r1 == false) goto L62;
        return null;
    L62:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L51
        h r6 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        String r8 = new JSONObject(r7).optString("Content");     // Catch: Throwable -> L51
        d.h.b.o.a(r8);     // Catch: Throwable -> L51
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r8 = null;
    L16:
        if (r8 != null) goto L18;
    L17:
        g r9 = null;
    L49:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L51
    L53:
        Throwable r11 = d.n.c(r10);
        if (r11 == null) goto L57;
        ILogDepend.Companion.w("ClientToolReportHelper", "parse client tool info failed", r11);
    L57:
        if (d.n.b(r10) == true) goto L61;
        r4 = r10;
    L61:
        return (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
    L18:
        JSONArray r12 = new JSONObject(r8).optJSONArray("jobs");     // Catch: Throwable -> L51
        if (r12 == null) goto L17;
        JSONObject r13 = r12.optJSONObject(0);     // Catch: Throwable -> L51
        if (r13 == null) goto L17;
        JSONArray r14 = r13.optJSONArray("actions");     // Catch: Throwable -> L51
        if (r14 == null) goto L17;
        JSONObject r15 = r14.optJSONObject(d.l.n.c(r14.length() - 1, 0));     // Catch: Throwable -> L51
        if (r15 == null) goto L17;
        JSONObject r3 = r15.optJSONObject("inputParams");     // Catch: Throwable -> L51
        if (r3 == null) goto L31;
        JSONObject r5 = r3.optJSONObject("ext");     // Catch: Throwable -> L51
        if (r5 == null) goto L31;
        String r16 = r5.optString("value");     // Catch: Throwable -> L51
    L32:
        String r17 = r6.a(r16, "tool_name");     // Catch: Throwable -> L51
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L36;
        r17 = null;
    L36:
        if (r17 != null) goto L48;
        r17 = r15.optString("actionName");     // Catch: Throwable -> L51
        d.h.b.o.a(r17);     // Catch: Throwable -> L51
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L41;
        r17 = null;
    L41:
        if (r17 != null) goto L48;
        String r18 = r15.optString("actionNaame");     // Catch: Throwable -> L51
        d.h.b.o.a(r18);     // Catch: Throwable -> L51
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L45;
        r17 = r18;
    L46:
        if (r17 != null) goto L48;
    L45:
        r17 = null;
    L48:
        r9 = new g(r17, r6.a(r16, "tool_id"));     // Catch: Throwable -> L51
    L31:
        r16 = null;
    L51:
        th = move-exception;
        d.n.a r19 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L53
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String a(String r8, String r9) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L37;
        return "";
    L37:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        h r7 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r10 = d.n.f(new JSONObject(r8).optString(r9));     // Catch: Throwable -> L14
    L16:
        String r5 = null;
        if (d.n.b(r10) == false) goto L19;
        r10 = null;
    L19:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == true) goto L28;
        return r11;
    L28:
        d.o.i r12 = d.o.k.a(new d.o.k("[\"']" + d.o.k.f38646a.a(r9) + "[\"']\\s*:\\s*[\"']([^\"']*)[\"']"), (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r12 == null) goto L33;
        List<String> r13 = r12.d();
        if (r13 == null) goto L33;
        r5 = (String) ZeusTransformUtils.preCheckCast(d.a.p.d(r13, 1), String.class, "com.obric.aiagent.plugin");
    L33:
        if (r5 != null) goto L36;
        return "";
    L36:
        return r5;
    L22:
        if (d.o.o.d(r3) == true) goto L25;
        r4 = false;
    L14:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L16
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
