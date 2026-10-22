package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.n;
import d.o.o;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18553a = null;

    static {
        f18553a = new f();
    }

    private f() {
    }

    public final List<JSONObject> a(String r10) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        String r3 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (o.b(r3, "[", false, 2, null) == false) goto L35;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L26
        f r9 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        JSONArray r5 = new JSONArray(r3);     // Catch: Throwable -> L26
        List r6 = p.a();     // Catch: Throwable -> L26
        int r7 = r5.length();     // Catch: Throwable -> L26
    L15:
        if (r2 >= r7) goto L24;
        Object r8 = r5.opt(r2);     // Catch: Throwable -> L26
        if (r8 == null) goto L19;
        String r11 = r8.toString();     // Catch: Throwable -> L26
    L20:
        JSONObject r12 = r9.a(r11, "origin_tools_input[" + r2 + ']');     // Catch: Throwable -> L26
        if (r12 == null) goto L23;
        r6.add(r12);     // Catch: Throwable -> L26
    L23:
        r2 = r2 + 1;     // Catch: Throwable -> L26
        goto L15
    L19:
        r11 = null;
        goto L20
    L24:
        Object r13 = n.f(p.a(r6));     // Catch: Throwable -> L26
    L28:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L33;
        ILogDepend.Companion.w("ToolAuditLogger", "parse origin_tools_input array failed, size=" + r10.length() + ", reason=" + r14.getMessage());
        r13 = p.b();
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
    L26:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L28
    L35:
        return p.b(a(r3, "origin_tools_input"));
    L11:
        return p.b();
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JSONObject a(String r5, String r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
    L23:
        return null;
    L12:
        if (d.h.b.o.a(r5, "null") == true) goto L23;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L16
        f r4 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Object r7 = n.f(new JSONObject(r5));     // Catch: Throwable -> L16
    L18:
        Throwable r3 = n.c(r7);
        if (r3 != null) goto L22;
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        j.a(r9, r8);
        f r10 = f18553a;
        r10.a(r9, r8, "ext");
        r10.a(r9, r8, "step");
        return r9;
    L22:
        ILogDepend.Companion.w("ToolAuditLogger", "parse " + r6 + " object failed, size=" + r5.length() + ", reason=" + r3.getMessage());
    L16:
        th = move-exception;
        n.a r11 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L18
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final void a(JSONObject r3, JSONObject r4, String r5) {
        String r2 = r4.optString(r5, "");
        d.h.b.o.a(r2);
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L19;
        return;
    L19:
        n.a r6 = n.f38560a;     // Catch: Throwable -> L10
        Object r7 = n.f(new JSONObject(r2));     // Catch: Throwable -> L10
    L13:
        if (n.a(r7) == false) goto L15;
        j.a(r3, (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin"));
    L15:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L21;
        ILogDepend.Companion.w("ToolAuditLogger", "ignore invalid origin_tools_input." + r5 + ", size=" + r2.length() + ", reason=" + r8.getMessage());
        return;
    L21:
        return;
    L10:
        th = move-exception;
        n.a r1 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L13
    }
}
