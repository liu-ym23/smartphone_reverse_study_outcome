package com.obric.funcall_impl.a;

import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.bean.OAppAction;
import com.obric.funcall_api.bean.AppActionRequest;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: EntityConverter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final IntentAppAction a(OAppAction r19) {
        o.e(r19, "<this>");
        OAppAction.b r0 = r19.getMpParams();
        Map<String, String> r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.b();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r11 = r3;
        String r4 = a(r19.getContent(), "check_llm_output_audit_info");
        long r5 = r19.getMessageId();
        long r7 = r19.getQuestionId();
        long r9 = r19.getCreateTime();
        int r13 = r19.getMessageType();
        if (r0 == null) goto L11;
        long r14 = r0.a();
    L12:
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        if (r0 == null) goto L15;
        r2 = r0.c();
    L15:
        if (r2 != null) goto L17;
        r2 = ao.b();
    L17:
        r1.putAll(r2);
        if (r4 == null) goto L20;
        r1.putIfAbsent("check_llm_output_audit_info", r4);
    L20:
        x r6 = x.f38692a;
        return new IntentAppAction(r5, r7, r9, r11, null, r13, r14, r1, 16, null);
    L11:
        r14 = -1;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    private static final String a(String r5, String r6) {
        Object r0 = null;
        if (r5 == null) goto L36;
        boolean r3 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L36;
        if (o.a(r5, "null") == false) goto L37;
        return null;
    L37:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L28
        Object r7 = new JSONObject(r5).opt(r6);     // Catch: Throwable -> L28
        if (r7 == null) goto L25;
        String r8 = r7.toString();     // Catch: Throwable -> L28
        if (r8 == null) goto L25;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
    L22:
        r3 = false;
    L23:
        if (r3 == false) goto L25;
    L26:
        Object r9 = n.f(r8);     // Catch: Throwable -> L28
    L31:
        if (n.b(r9) == true) goto L35;
        r0 = r9;
    L35:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L20:
        if (o.a(r8, "null") == true) goto L22;
    L25:
        r8 = null;
    L28:
        th = move-exception;
        n.a r10 = n.f38560a;
        r9 = n.f(d.o.a(th));
    L36:
        return null;
    }

    public static final OAppAction a(AppActionRequest r14) {
        o.e(r14, "<this>");
        String r0 = new Gson().toJson(new OAppAction.b(r14.getId(), r14.getQuestionId(), null, r14.getContent(), (Map) ZeusTransformUtils.preCheckCast(r14.getExt(), Map.class, "com.obric.aiagent.plugin"), 4, null));
        JSONObject r1 = new JSONObject();
        r1.put(MonitorConstants.CODE, 0);
        r1.put("msg", "success");
        r1.put("data", r0);
        return new OAppAction(2, r14.getMessageId(), r14.getQuestionId(), r14.getCreateTime(), r1.toString(), 1, 500);
    }
}
