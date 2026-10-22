package com.obric.agent.trace.omni;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniTaskAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f15693a = null;

    static {
        f15693a = new l();
    }

    private l() {
    }

    public final void a(a r29, Map<String, String> r30, t r31) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r29, "snapshot");
        d.h.b.o.e(r2, "reportParams");
        JSONObject r3 = a(r29, r2);
        List r4 = (List) ZeusTransformUtils.preCheckCast(r29.b().get("instruction_id"), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        Object r5 = d.a.p.n(r4);
        if (r5 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L10;
    L11:
        String r6 = a((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        if (r6 != null) goto L14;
        r6 = a(r3.optString("instruction_id"));
    L14:
        String r14 = r6;
        String r18 = a(r3.optString("device_id"));
        if (r31 == null) goto L17;
        String r7 = r31.d();
    L18:
        String r8 = a(r7);
        if (r8 != null) goto L21;
        r8 = a(r3.optString("execute_id"));
    L21:
        String r13 = r8;
        String r9 = r3.optString("log_id");
        d.h.b.o.a(r9);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L24;
        String r16 = r9;
    L25:
        String r10 = r3.optString("error_code");
        d.h.b.o.a(r10);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L29;
        r10 = null;
    L29:
        String r11 = "";
        if (r10 != null) goto L32;
        String r12 = "";
    L33:
        String r15 = r3.optString("all_duration");
        d.h.b.o.c(r15, "optString(...)");
        Long r17 = d.o.o.e(r15);
        String r19 = r3.optString("target_package");
        d.h.b.o.a(r19);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L37;
        r19 = null;
    L37:
        if (r19 != null) goto L39;
        String r20 = "";
    L40:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r29.b().get("task_end"), List.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L48;
        Object r22 = d.a.p.n(r21);
        if (r22 == null) goto L48;
        if (ZeusTransformUtils.instanceOf(r22, Long.class) == false) goto L48;
    L49:
        Long r23 = (Long) ZeusTransformUtils.preCheckCast(r22, Long.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L52;
        String r110 = r23.toString();
    L53:
        String r24 = r3.optString("last_tool_name");
        d.h.b.o.a(r24);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L56;
        String r111 = r24;
    L57:
        String r25 = c(r3);
        String r112 = r3.optString(DownloadConstants.QUERY_KEY);
        d.h.b.o.a(r112);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L60;
        String r113 = r112;
    L61:
        String r26 = a(r3.optString("doubao_message_id"));
        String r27 = a(r3.optString("o_reference_msg_id"));
        ILogDepend.Companion r114 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("write task audit: messageId=").append(r29.a()).append(", instructionId=").append(r14).append(", executeId=").append(r13).append(", omniLogId=");
        if (r16 != null) goto L64;
        String r28 = "";
    L65:
        StringBuilder r32 = r1.append(r28).append(", referenceMsgId=");
        if (r27 == null) goto L69;
        r11 = r27;
    L69:
        StringBuilder r33 = r32.append(r11).append(", instructionType=").append(r25).append(", hasQuery=");
        CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.aiagent.plugin");
        if (r34 != null) goto L72;
    L75:
        boolean r35 = true;
    L76:
        r114.i("OmniTaskAuditLogger", r33.append(!r35).append(", errCode=").append(r12).append(", params=").append(r3.length()).toString());
        AOAgentRobotsTools r36 = AOAgentRobotsTools.INSTANCE;
        Context r37 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r38 = r3.optString("finish_reason");
        d.h.b.o.a(r38);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L79;
        String r115 = r38;
    L80:
        String r0 = b(r3);
        String r39 = r3.optString("check_user_input_audit_info");
        d.h.b.o.a(r39);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r39, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L83;
        String r210 = r39;
    L84:
        String r40 = r3.optString("check_llm_output_audit_info");
        d.h.b.o.a(r40);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r40, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L87;
        String r211 = r40;
    L88:
        r36.writeTaskFinishAuditLogAsync(r37, new AOAgentRobotsTools.TaskFinishAuditLogParams(r20, r12, r115, r17, r0, r13, r14, r110, r16, r111, r18, r25, r26, r27, r113, r210, r211, null, UiType.FLAG_PHONE_CARD, null));
        return;
    L87:
        r211 = null;
        goto L88
    L83:
        r210 = null;
        goto L84
    L79:
        r115 = null;
        goto L80
    L72:
        if (d.o.o.d(r34) == true) goto L75;
        r35 = false;
        goto L76
    L64:
        r28 = r16;
        goto L65
    L60:
        r113 = null;
        goto L61
    L56:
        r111 = null;
        goto L57
    L52:
        r110 = null;
    L48:
        r22 = null;
        goto L49
    L39:
        r20 = r19;
        goto L40
    L32:
        r12 = r10;
        goto L33
    L24:
        r16 = null;
        goto L25
    L17:
        r7 = null;
    L10:
        r5 = null;
        goto L11
    }

    private final JSONObject a(a r7, Map<String, String> r8) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getFlowDid();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r9.put("device_id", r3);
        r9.put("doubao_message_id", r7.a());
        l r4 = f15693a;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r7.b().get("instruction_type"), List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        Object r10 = d.a.p.n(r5);
        if (r10 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L16;
    L17:
        r4.a(r9, "instruction_type", (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin"));
        List r11 = (List) ZeusTransformUtils.preCheckCast(r7.b().get("instruction_entry"), List.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L25;
        Object r12 = d.a.p.n(r11);
        if (r12 == null) goto L25;
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L25;
        r2 = r12;
    L25:
        r4.a(r9, "instruction_entry", (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));
        Iterator r13 = r6.entrySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r9.put((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L27
    L29:
        f15693a.a(r9);
        r9.put("log_type", "task");
        return r9;
    L16:
        r10 = null;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    private final void a(JSONObject r3) {
        a(r3, "log_id", r3.optString("inner_log_id"));
        a(r3, "execute_id", r3.optString("o_execute_id"));
    }

    private final void a(JSONObject r4, String r5, String r6) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return;
    L11:
        if (d.h.b.o.a(r6, "null") == false) goto L14;
        return;
    L14:
        if (r4.has(r5) == true) goto L16;
    L21:
        r4.put(r5, r6);
        return;
    L16:
        if (r4.isNull(r5) == true) goto L21;
        String r1 = r4.optString(r5);
        d.h.b.o.c(r1, "optString(...)");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L21;
        if (d.h.b.o.a(r4.optString(r5), "null") == true) goto L21;
        return;
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r7 = false;
        goto L9
    }

    private final String b(JSONObject r2) {
        return b(r2.optString("risk_level"));
    }

    private final String c(JSONObject r2) {
        String r0 = b(r2.optString("o_omni_instruction_type"));
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b(r2.optString("instruction_type"));
    }

    private final String a(String r3) {
        if (r3 == null) goto L15;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L15;
        return r3;
    L7:
        if (d.h.b.o.a(r3, "0") == true) goto L11;
        if (d.h.b.o.a(r3, "null") == true) goto L11;
    L15:
        return null;
    }

    private final String b(String r3) {
        if (r3 == null) goto L13;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L13;
        return r3;
    L7:
        if (d.h.b.o.a(r3, "null") == true) goto L9;
    L13:
        return null;
    }
}
