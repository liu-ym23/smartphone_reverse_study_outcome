package com.obric.aiagent.executionengine.scheduler.impl.job;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.n;
import d.o.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "ToolAuditLogger";

    public static final /* synthetic */ b a(IMAppAction r0, IMAppAction r1, String r2) {
        return b(r0, r1, r2);
    }

    public static final /* synthetic */ AOAgentRobotsTools.TargetAppGrant a(IntentResult r0) {
        return b(r0);
    }

    public static final /* synthetic */ String a(a r0) {
        return e(r0);
    }

    public static final /* synthetic */ String a(IMAppAction r0) {
        return c(r0);
    }

    public static final /* synthetic */ String a(String r0) {
        return d(r0);
    }

    public static final /* synthetic */ String a(JSONObject r0, String... r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ void a(IntentExecutionRecord r0, IMAppAction r1, a r2, AOAgentRobotsTools.TargetAppGrant r3) {
        b(r0, r1, r2, r3);
    }

    public static final /* synthetic */ void a(JSONObject r0, String r1, String r2) {
        c(r0, r1, r2);
    }

    public static final /* synthetic */ void a(JSONObject r0, JSONObject r1) {
        b(r0, r1);
    }

    public static final /* synthetic */ boolean a(IntentExecutionRecord r0) {
        return f(r0);
    }

    public static final /* synthetic */ boolean a(String r0, String r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ boolean a(JSONObject r0) {
        return b(r0);
    }

    public static final /* synthetic */ String b(a r0) {
        return d(r0);
    }

    public static final /* synthetic */ Map b(String r0) {
        return c(r0);
    }

    public static final /* synthetic */ void b(JSONObject r0, String r1, String r2) {
        d(r0, r1, r2);
    }

    public static final /* synthetic */ String c(a r0) {
        return g(r0);
    }

    private static final void b(IntentExecutionRecord r36, IMAppAction r37, a r38, AOAgentRobotsTools.TargetAppGrant r39) {
        ComponentName r0 = b(r36);
        String r5 = a(r36, r38);
        String r15 = c(r36);
        String r13 = e(r38);
        String r16 = d(r38);
        String r12 = f(r38);
        String r14 = k(r38);
        String r21 = g(r38);
        String r6 = j(r38);
        if (r0 == null) goto L5;
        String r4 = r0.getPackageName();
    L6:
        String r7 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (r0 == null) goto L11;
        String r1 = r0.getClassName();
    L12:
        if (r1 != null) goto L14;
        String r8 = "";
    L15:
        Application r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        String r2 = r4;
    L19:
        if (r2 != null) goto L105;
        String r3 = null;
    L30:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L32;
        String r9 = r4;
    L33:
        if (r9 != null) goto L103;
        String r27 = null;
    L44:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L46;
        String r11 = r4;
    L47:
        if (r11 != null) goto L109;
        boolean r17 = false;
        String r25 = null;
    L66:
        ILogDepend.Companion r18 = ILogDepend.Companion;
        StringBuilder r19 = new StringBuilder().append("write tool audit: toolName=").append(r15).append(", actionType=");
        if (r5 != null) goto L69;
        String r110 = "";
    L70:
        StringBuilder r20 = r19.append(r110).append(", target=").append(r4).append('/').append(r8).append(", ret=").append(r36.getResult().getRet()).append(", executeId=");
        if (r12 != null) goto L73;
        String r111 = "";
    L74:
        StringBuilder r22 = r20.append(r111).append(", instructionId=");
        if (r13 != null) goto L77;
        String r112 = "";
    L78:
        StringBuilder r23 = r22.append(r112).append(", omniLogId=");
        if (r16 != null) goto L81;
        String r113 = "";
    L82:
        StringBuilder r24 = r23.append(r113).append(", referenceMsgId=");
        if (r21 != null) goto L85;
        String r114 = "";
    L86:
        StringBuilder r26 = r24.append(r114).append(", stepId=");
        if (r14 == null) goto L90;
        r7 = r14;
    L90:
        StringBuilder r28 = r26.append(r7).append(", hasActionArgs=");
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r29 != null) goto L93;
    L96:
        boolean r115 = true;
    L97:
        r18.i(TAG, r28.append(true ^ r115).toString());
        AOAgentRobotsTools r30 = AOAgentRobotsTools.INSTANCE;
        Context r116 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r31 = String.valueOf(r36.getResult().getRet());
        String r32 = r38.a(new String[]{"reason_code"});
        Long r117 = b(r37);
        String r210 = m(r38);
        String r211 = n(r38);
        String r212 = l(r38);
        String r213 = h(r38);
        String r214 = i(r38);
        String r215 = r38.a(new String[]{DownloadConstants.QUERY_KEY});
        String r33 = r38.a(new String[]{"check_user_input_audit_info"});
        String r34 = r38.a(new String[]{"check_llm_output_audit_info"});
        if (r3 == null) goto L100;
        List r35 = p.a(r3);
    L101:
        r30.writeToolAuditLog(r116, new AOAgentRobotsTools.ToolAuditLogParams(r4, r8, r31, r5, r6, r32, null, r117, null, r210, r12, r13, r14, r16, r15, r211, r212, r213, r214, r21, r215, r33, r34, r25, r35, r27, r39, 320, null));
        return;
    L100:
        r35 = null;
        goto L101
    L93:
        if (o.d(r29) == true) goto L96;
        r115 = r17;
        goto L97
    L85:
        r114 = r21;
        goto L86
    L81:
        r113 = r16;
        goto L82
    L77:
        r112 = r13;
        goto L78
    L73:
        r111 = r12;
        goto L74
    L69:
        r110 = r5;
        goto L70
    L109:
        n.a r118 = n.f38560a;     // Catch: Throwable -> L58
        if (Build.VERSION.SDK_INT < 33) goto L51;
        PackageInfo r40 = r10.getPackageManager().getPackageInfo(r11, PackageManager.PackageInfoFlags.of(0));     // Catch: Throwable -> L58
        r17 = false;
    L54:
        Object r41 = n.f(a(androidx.core.content.a.a.a(r40)));     // Catch: Throwable -> L56
    L62:
        if (n.b(r41) == false) goto L64;
        r41 = null;
    L64:
        r25 = (String) ZeusTransformUtils.preCheckCast(r41, String.class, "com.obric.aiagent.plugin");
    L56:
        th = th;
    L60:
        n.a r42 = n.f38560a;
        r41 = n.f(d.o.a(th));
        goto L62
    L51:
        PackageManager r43 = r10.getPackageManager();     // Catch: Throwable -> L58
        r17 = false;
        r40 = r43.getPackageInfo(r11, 0);     // Catch: Throwable -> L56
    L58:
        th = th;
        r17 = false;
        goto L60
    L46:
        r11 = null;
        goto L47
    L103:
        n.a r119 = n.f38560a;     // Catch: Throwable -> L36
        Object r44 = n.f(AOPackagesTools.INSTANCE.getAppApkMd5FromCacheOnly(r9));     // Catch: Throwable -> L36
    L39:
        if (n.b(r44) == false) goto L41;
        r44 = null;
    L41:
        r27 = (String) ZeusTransformUtils.preCheckCast(r44, String.class, "com.obric.aiagent.plugin");
    L36:
        th = move-exception;
        n.a r120 = n.f38560a;
        r44 = n.f(d.o.a(th));
        goto L39
    L32:
        r9 = null;
        goto L33
    L105:
        n.a r121 = n.f38560a;     // Catch: Throwable -> L22
        Object r45 = n.f(AOPackagesTools.INSTANCE.getAppSign((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), r2));     // Catch: Throwable -> L22
    L25:
        if (n.b(r45) == false) goto L27;
        r45 = null;
    L27:
        r3 = (String) ZeusTransformUtils.preCheckCast(r45, String.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        n.a r46 = n.f38560a;
        r45 = n.f(d.o.a(th));
        goto L25
    L18:
        r2 = null;
        goto L19
    L14:
        r8 = r1;
        goto L15
    L11:
        r1 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public static final String a(long r0) {
        return String.valueOf(r0);
    }

    private static final b b(IMAppAction r6, IMAppAction r7, String r8) {
        JSONObject r0 = new JSONObject();
        if (r8 == null) goto L5;
        d(r0, "instruction_id", r8);
    L5:
        IMAppActionExt r1 = r6.getExt();
        String r3 = null;
        if (r1 == null) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get("client_meta"), String.class, "com.obric.aiagent.plugin");
    L9:
        a(r0, r2);
        IMAppActionExt r4 = r7.getExt();
        if (r4 == null) goto L12;
        r3 = (String) ZeusTransformUtils.preCheckCast(r4.get("client_meta"), String.class, "com.obric.aiagent.plugin");
    L12:
        a(r0, r3);
        a(r0, (Map) ZeusTransformUtils.preCheckCast(r6.getExt(), Map.class, "com.obric.aiagent.plugin"));
        a(r0, (Map) ZeusTransformUtils.preCheckCast(r7.getExt(), Map.class, "com.obric.aiagent.plugin"));
        b(r0, r6.getContent());
        if (b(r0) == false) goto L15;
        c(r0, r8, b(r0, new String[]{"o_reference_msg_id"}));
    L15:
        a r9 = new a(r0);
        return new b(r9, o(r9), r8);
    L8:
        r2 = null;
        goto L9
    }

    private static final String d(a r1) {
        return r1.a(new String[]{"inner_log_id"});
    }

    private static final String e(a r1) {
        String r0 = r1.a(new String[]{"instruction_id"});
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.a(new String[]{"o_omni_task_id"});
    }

    private static final String f(a r1) {
        String r0 = r1.a(new String[]{"execute_id"});
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.a(new String[]{"o_execute_id"});
    }

    private static final String g(a r1) {
        return d(r1.a(new String[]{"o_reference_msg_id"}));
    }

    private static final Long b(IMAppAction r2) {
        IMAppActionExt r3 = r2.getExt();
        if (r3 == null) goto L7;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("app_cost"), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        return o.e(r4);
    L7:
        return null;
    }

    private static final String h(a r1) {
        return r1.a(new String[]{"doubao_message_id"});
    }

    private static final String i(a r1) {
        return r1.a(new String[]{"origin_tools_name"});
    }

    private static final AOAgentRobotsTools.TargetAppGrant b(IntentResult<?> r3) {
        ConcurrentHashMap<String, String> r4 = r3.getExt();
        if (r4 == null) goto L15;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(AOAgentRobotsTools.TARGET_APP_GRANT_EXT_KEY), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L15;
        AOAgentRobotsTools.TargetAppGrant r6 = AOAgentRobotsTools.INSTANCE.decodeTargetAppGrant(r5);
        if (r6 != null) goto L14;
        ILogDepend.Companion.w(TAG, "ignore invalid target_app_grant in final tool audit");
    L14:
        return r6;
    L15:
        return null;
    }

    private static final ComponentName b(IntentExecutionRecord r2) {
        Object r1 = null;
        if (d(r2) == false) goto L6;
        return null;
    L6:
        if (e(r2) == false) goto L8;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L15
        DisplayedAppInfo r4 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();     // Catch: Throwable -> L15
        if (r4 == null) goto L12;
        ComponentName r5 = r4.getTopActivity();     // Catch: Throwable -> L15
    L13:
        Object r6 = n.f(r5);     // Catch: Throwable -> L15
    L18:
        if (n.b(r6) == true) goto L22;
        r1 = r6;
    L22:
        return (ComponentName) ZeusTransformUtils.preCheckCast(r1, ComponentName.class, "com.obric.aiagent.plugin");
    L12:
        r5 = null;
    L15:
        th = move-exception;
        n.a r0 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L18
    L8:
        return new ComponentName(r2.getImplPackage(), r2.getImplClassName());
    }

    private static final String a(IntentExecutionRecord r0, a r1) {
        if (e(r0) == true) goto L6;
        return null;
    L6:
        String r2 = r1.a(new String[]{"action_type"});
        if (r2 == null) goto L9;
        return r2;
    L9:
        return r1.a();
    }

    private static final String j(a r1) {
        String r0 = r1.a(new String[]{"action_args"});
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.b();
    }

    private static final String k(a r1) {
        return r1.a(new String[]{"tool_id"});
    }

    private static final String c(IntentExecutionRecord r2) {
        String r3 = r2.getIntentName();
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    private static final boolean d(IntentExecutionRecord r2) {
        return o.a(r2.getIntentName(), "GUI_INIT", true);
    }

    private static final boolean e(IntentExecutionRecord r1) {
        return b(r1.getIntentName(), r1.getImplClassName());
    }

    private static final boolean f(IntentExecutionRecord r1) {
        if (e(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getResult().isFinal() == true) goto L7;
        return true;
    }

    private static final boolean b(String r3, String r4) {
        if (o.a(r3, "GUI_Action", true) == false) goto L5;
    L9:
        return true;
    L5:
        if (o.a(r3, "GUI_INIT", true) == true) goto L9;
        return o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("OmniGUI", CharSequence.class, "com.obric.aiagent.plugin"), true);
    }

    private static final String l(a r2) {
        String r3 = r2.a(new String[]{"o_omni_instruction_type", "instruction_type"});
        if (r3 == null) goto L8;
        if (e(r3) == false) goto L8;
        return r3;
    L8:
        return null;
    }

    private static final String m(a r1) {
        return r1.a(new String[]{"risk_level"});
    }

    private static final String n(a r1) {
        return d(r1.a(new String[]{"device_id"}));
    }

    private static final void a(JSONObject r3, String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L22;
        return;
    L22:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L13
        Object r5 = n.f(new JSONObject(r4));     // Catch: Throwable -> L13
    L16:
        if (n.a(r5) == false) goto L18;
        b(r3, (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
    L18:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L24;
        ILogDepend.Companion.w(TAG, "ignore invalid client_meta, size=" + r4.length() + ", reason=" + r6.getMessage());
        return;
    L24:
        return;
    L13:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L16
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private static final void c(JSONObject r5, String r6, String r7) {
        String r8 = d(r7);
        if (r8 != null) goto L5;
        return;
    L5:
        Map<String, String> r0 = i.f18560a.a(r6, r8);
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = r5.length();
        a(r5, r0);
        ILogDepend.Companion r2 = ILogDepend.Companion;
        StringBuilder r3 = new StringBuilder().append("merge message ext for tool audit: instructionId=");
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r2.i(TAG, r3.append(r6).append(", referenceMsgId=").append(r8).append(", extKeys=").append(r0.keySet().size()).append(", added=").append(r5.length() - r1).toString());
    }

    private static final void b(JSONObject r4, String r5) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(b(r4, new String[]{"check_llm_output_audit_info"}), CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        String r6 = c(r5, "check_llm_output_audit_info");
        if (r6 == null) goto L15;
        d(r4, "check_llm_output_audit_info", r6);
        return;
    L15:
        return;
    L5:
        if (o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private static final String c(String r11, String r12) {
        Object r0 = null;
        if (r11 != null) goto L5;
    L67:
        return null;
    L5:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L67;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L59
        String r13 = new JSONObject(r11).optString("Content");     // Catch: Throwable -> L59
        d.h.b.o.a(r13);     // Catch: Throwable -> L59
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
        r13 = null;
    L19:
        if (r13 != null) goto L21;
    L20:
        String r9 = null;
    L57:
        Object r14 = n.f(r9);     // Catch: Throwable -> L59
    L62:
        if (n.b(r14) == true) goto L66;
        r0 = r14;
    L66:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L21:
        JSONArray r15 = new JSONObject(r13).optJSONArray("jobs");     // Catch: Throwable -> L59
        if (r15 == null) goto L20;
        int r3 = r15.length();     // Catch: Throwable -> L59
        int r5 = 0;
    L25:
        if (r5 >= r3) goto L20;
        JSONObject r6 = r15.optJSONObject(r5);     // Catch: Throwable -> L59
        if (r6 == null) goto L56;
        JSONArray r7 = r6.optJSONArray("actions");     // Catch: Throwable -> L59
        if (r7 == null) goto L56;
        int r8 = r7.length();     // Catch: Throwable -> L59
        int r10 = 0;
    L32:
        if (r10 >= r8) goto L56;
        JSONObject r16 = r7.optJSONObject(r10);     // Catch: Throwable -> L59
        if (r16 == null) goto L55;
        JSONObject r17 = r16.optJSONObject("inputParams");     // Catch: Throwable -> L59
        if (r17 == null) goto L55;
        JSONObject r18 = r17.optJSONObject("ext");     // Catch: Throwable -> L59
        if (r18 == null) goto L55;
        String r19 = r18.optString("value");     // Catch: Throwable -> L59
        if (r19 == null) goto L55;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L45;
        r19 = null;
    L45:
        if (r19 == null) goto L55;
        r9 = b(new JSONObject(r19), new String[]{r12});     // Catch: Throwable -> L59
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        if (r110 != null) goto L49;
    L52:
        boolean r111 = true;
    L53:
        if (r111 == true) goto L55;
    L49:
        if (o.d(r110) == true) goto L52;
        r111 = false;
    L55:
        r10 = r10 + 1;     // Catch: Throwable -> L59
    L56:
        r5 = r5 + 1;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        n.a r112 = n.f38560a;
        r14 = n.f(d.o.a(th));
        goto L62
    L7:
        if (d.h.b.o.a(r11, "null") == true) goto L9;
        r1 = true;
        goto L10
    }

    private static final Map<String, String> c(final String r8) {
        IFlowMessageIDL r1 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r1 != null) goto L6;
        ILogDepend.Companion.w(TAG, "find message ext skipped: IPC unavailable, messageId=" + r8);
        return null;
    L6:
        final AtomicReference r3 = new AtomicReference();
        final CountDownLatch r4 = new CountDownLatch(1);
        n.a r5 = n.f38560a;     // Catch: Throwable -> L12
        r1.findMessagebyId(r8, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new ToolExecutionAuditLoggerKt$findMessageExtById$1$1(r3, r4, r8), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        if (r4.await(300, TimeUnit.MILLISECONDS) == true) goto L10;
        ILogDepend.Companion.w(TAG, "find message ext timeout: messageId=" + r8);     // Catch: Throwable -> L12
    L10:
        Object r2 = n.f(x.f38692a);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = n.c(r2);
        if (r6 == null) goto L18;
        ILogDepend.Companion.w(TAG, "find message ext exception: messageId=" + r8 + ", reason=" + r6.getMessage());
        r4.countDown();
    L18:
        return (Map) ZeusTransformUtils.preCheckCast(r3.get(), Map.class, "com.obric.aiagent.plugin");
    L12:
        th = move-exception;
        n.a r7 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L14
    }

    private static final String c(IMAppAction r12) {
        IMAppActionExt r0 = r12.getExt();
        Object r3 = null;
        if (r0 == null) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        ILogDepend.Companion.i(TAG, "audit instruction_id: " + r1);
        return r1;
    L13:
        String r2 = r12.getContent();
        if (r2 != null) goto L16;
    L62:
        return null;
    L16:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L62;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L54
        String r5 = new JSONObject(r2).optString("Content");     // Catch: Throwable -> L54
        d.h.b.o.a(r5);     // Catch: Throwable -> L54
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r5 = null;
    L25:
        if (r5 != null) goto L27;
    L26:
        String r10 = null;
    L52:
        Object r6 = n.f(r10);     // Catch: Throwable -> L54
    L56:
        Throwable r7 = n.c(r6);
        if (r7 != null) goto L59;
        r3 = r6;
    L61:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L59:
        ILogDepend.Companion.w(TAG, "parse request uniqueId failed: messageId=" + r12.getMessageId() + ", reason=" + r7.getMessage());
        goto L61
    L27:
        JSONArray r8 = new JSONObject(r5).optJSONArray("jobs");     // Catch: Throwable -> L54
        if (r8 == null) goto L26;
        int r9 = r8.length();     // Catch: Throwable -> L54
        int r11 = 0;
    L31:
        if (r11 >= r9) goto L26;
        JSONObject r13 = r8.optJSONObject(r11);     // Catch: Throwable -> L54
        if (r13 == null) goto L51;
        JSONArray r14 = r13.optJSONArray("actions");     // Catch: Throwable -> L54
        if (r14 == null) goto L51;
        int r15 = r14.length();     // Catch: Throwable -> L54
        int r16 = 0;
    L38:
        if (r16 >= r15) goto L51;
        JSONObject r17 = r14.optJSONObject(r16);     // Catch: Throwable -> L54
        if (r17 == null) goto L50;
        JSONObject r18 = r17.optJSONObject("inputParams");     // Catch: Throwable -> L54
        if (r18 == null) goto L50;
        JSONObject r19 = r18.optJSONObject("uniqueId");     // Catch: Throwable -> L54
        if (r19 == null) goto L50;
        String r110 = r19.optString("value");     // Catch: Throwable -> L54
        if (r110 == null) goto L50;
        r10 = d(r110);     // Catch: Throwable -> L54
        if (r10 != null) goto L52;
    L50:
        r16 = r16 + 1;     // Catch: Throwable -> L54
    L51:
        r11 = r11 + 1;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        n.a r20 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L56
    }

    private static final List<a> o(a r9) {
        String r1 = r9.a(new String[]{"origin_tools_input"});
        if (r1 != null) goto L8;
        JSONArray r0 = r9.c().optJSONArray("origin_tools_input");
        if (r0 == null) goto L7;
        r1 = r0.toString();
        goto L8
    L7:
        r1 = null;
    L8:
        List<JSONObject> r2 = f.f18553a.a(r1);
        if (r2.isEmpty() == true) goto L11;
        List<String> r10 = r9.a("origin_tools_name");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r5 = 0;
        Iterator r6 = r3.iterator();
    L14:
        if (r6.hasNext() == false) goto L30;
        Object r7 = r6.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L18;
        p.c();
    L18:
        JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(p.d(r10, r5), String.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L28;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
        r12 = null;
    L24:
        if (r12 == null) goto L28;
        if (c(r11, "origin_tool_name") == false) goto L28;
        r11.put("origin_tool_name", r12);
    L28:
        r4.add(new a(r11));
        r5 = r8;
        goto L14
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L11:
        return p.b();
    }

    private static final void b(JSONObject r4, JSONObject r5) {
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r1);
        if (c(r4, r1) == false) goto L4;
        r4.put(r1, r5.opt(r1));
        goto L4
    }

    private static final boolean c(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return true;
    L5:
        if (r2.isNull(r3) == true) goto L22;
        Object r4 = r2.opt(r3);
        if (r4 == null) goto L12;
        String r5 = r4.toString();
        if (r5 == null) goto L12;
        String r6 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L13:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L16;
        return true;
    L16:
        if (r7.length() == 0) goto L23;
        return false;
    L23:
        return true;
    L12:
        r6 = null;
        goto L13
    L22:
        return true;
    }

    private static final String b(JSONObject r6, String... r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        String r3 = null;
        if (r2 >= r0) goto L34;
        String r4 = r7[r2];
        if (r6.has(r4) == false) goto L33;
        if (r6.isNull(r4) == true) goto L33;
        Object r5 = r6.opt(r4);
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L13;
    L18:
        String r8 = r5.toString();
    L20:
        if (r8 == null) goto L22;
        r3 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L22:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L25;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == true) goto L33;
        if (d.h.b.o.a(r3, "null") == true) goto L33;
        return r3;
    L25:
        if (r9.length() == 0) goto L28;
        r10 = false;
        goto L29
    L13:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == true) goto L18;
        if (r5 == null) goto L17;
        r8 = r5.toString();
        goto L20
    L17:
        r8 = null;
    L33:
        r2 = r2 + 1;
        goto L3
    L34:
        return null;
    }

    private static final void d(JSONObject r2, String r3, String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (d.h.b.o.a(r4, "null") == false) goto L14;
        return;
    L14:
        if (c(r2, r3) == false) goto L18;
        r2.put(r3, r4);
        return;
    L18:
        return;
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private static final boolean b(JSONObject r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(b(r6, new String[]{"o_reference_msg_id"}), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(b(r6, new String[]{"inner_log_id", "omni_log_id", "log_id"}), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L30;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(b(r6, new String[]{"o_omni_task_id", "instruction_id"}), CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == false) goto L29;
        return true;
    L29:
        return false;
    L22:
        if (o.d(r7) == true) goto L25;
        r8 = false;
        goto L26
    L30:
        return true;
    L14:
        if (o.d(r2) == true) goto L17;
        r3 = false;
        goto L18
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private static final String d(String r3) {
        if (r3 == null) goto L15;
        boolean r2 = true;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L15;
        return r3;
    L7:
        if (d.h.b.o.a(r3, "0") == true) goto L11;
        if (d.h.b.o.a(r3, "null") == true) goto L11;
    L15:
        return null;
    }

    private static final boolean e(String r3) {
        String r4 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (d.h.b.o.a(r4, "null") == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private static final void a(JSONObject r6, Map<?, ?> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator r9 = r8.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L34;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r2 = r0.getKey();
        Object r1 = r0.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
        if (r3 == null) goto L7;
        boolean r4 = true;
        String r5 = null;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L7;
        if (r1 == null) goto L7;
        String r10 = r1.toString();
        if (r10 == null) goto L7;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
    L26:
        r4 = false;
    L27:
        if (r4 == false) goto L29;
        r5 = r10;
    L29:
        if (r5 == null) goto L7;
        if (c(r6, r3) == false) goto L7;
        r6.put(r3, r5);
        goto L7
    L24:
        if (d.h.b.o.a(r10, "null") == true) goto L26;
    }
}
