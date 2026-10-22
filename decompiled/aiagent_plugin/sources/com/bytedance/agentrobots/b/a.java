package com.bytedance.agentrobots.b;

import android.content.Context;
import android.util.Log;
import com.bytedance.agentrobots.a.a.e;
import com.bytedance.agentrobots.a.a.f;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgentSecurityLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "AgentSecurityLogger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f3995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f3996b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f3997c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Context f3998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile EnumC0100a f3999e;

    /* JADX INFO: renamed from: com.bytedance.agentrobots.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentSecurityLogger.java */
    private static final enum EnumC0100a extends Enum<EnumC0100a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0100a f4000a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0100a f4001b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0100a f4002c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0100a f4003d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ EnumC0100a[] f4004e = null;

        private EnumC0100a(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ EnumC0100a[] a() {
            return new EnumC0100a[]{f4000a, f4001b, f4002c, f4003d};
        }

        public static EnumC0100a valueOf(String r2) {
            return (EnumC0100a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0100a.class, r2), EnumC0100a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0100a[] values() {
            return (EnumC0100a[]) ZeusTransformUtils.preCheckCast(f4004e.clone(), EnumC0100a[].class, "com.obric.aiagent.plugin");
        }

        static {
            f4000a = new EnumC0100a("RAW_AND_ENCRYPTED", 0);
            f4001b = new EnumC0100a("RAW_ONLY", 1);
            f4002c = new EnumC0100a("ENCRYPTED_ONLY", 2);
            f4003d = new EnumC0100a("DISABLED", 3);
            f4004e = a();
        }
    }

    static {
        f3995a = new String[]{"device_id", "uid", "agent_uuid"};
        f3996b = new String[]{"agent_name", "device_id", "uid", "agent_uuid"};
        f3997c = new String[]{"log_source", DBHelper.COL_TIME, "target_package", "target_activity", "intent_type", "agent_name", "execute_id", "log_id", "instruction_id", "step_id", "error_code", "agent_uuid", "uid", "device_id", "doubao_message_id", "tool_name", "instruction_type", "user_authorization_type", "risk_level", "reason_code", "action_type", "duration", "duration_ms"};
        f3999e = EnumC0100a.f4000a;
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        f3998d = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        c.a(r4);
        return;
    }

    public static void b(Context r2) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        f3999e = c(f3998d);
    }

    public static void a() {
        f3999e = c(f3998d);
    }

    public static int a(String r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        if (r10.isEmpty() == true) goto L77;
        JSONObject r1 = new JSONObject(r10);     // Catch: JSONException -> L64
        r1 = new JSONObject(r1.toString());     // Catch: JSONException -> L69
    L10:
        a(r1);
        b.c(r1);
        EnumC0100a r11 = b();
        boolean r3 = false;
        if (r11 != EnumC0100a.f4003d) goto L15;
        a(TAG, "writeAuditLog: security log disabled, skip");
        return 0;
    L15:
        if (r11 != EnumC0100a.f4000a) goto L17;
    L20:
        boolean r2 = true;
    L22:
        if (r11 != EnumC0100a.f4000a) goto L24;
    L27:
        boolean r5 = true;
    L28:
        if (r2 == false) goto L30;
        e(r1);
    L30:
        JSONObject r4 = null;
        if (r5 == false) goto L45;
        r4 = b(r1);
        if (r11 != EnumC0100a.f4002c) goto L35;
        String[] r6 = f3996b;
    L36:
        int r7 = a(r4, r6);
        if (r7 == 0) goto L39;
        return r7;
    L39:
        String r8 = b.b(r4);
        if (r8 != null) goto L42;
        return -4;
    L42:
        if (r8.isEmpty() == true) goto L76;
    L46:
        if (r4 == null) goto L48;
        JSONObject r9 = r4;
    L49:
        b(TAG, "writeAuditLog: SDK received audit log and format validation passed, payloadMode=" + r11 + ", log_id=" + r9.optString("log_id", "") + ", instruction_id=" + r9.optString("instruction_id", "") + ", target_package=" + r9.optString("target_package", ""));
        if (r11 == EnumC0100a.f4002c) goto L52;
        JSONObject r12 = c(r1);
        if (r11 == EnumC0100a.f4000a) goto L70;
    L59:
        String r0 = r12.toString();
        if (r11 != EnumC0100a.f4000a) goto L63;
        r3 = true;
    L63:
        return c.a(r0, r3);
    L70:
        r12.put("payload_encrypted", r8);     // Catch: JSONException -> L57
    L57:
        e = move-exception;
        a(TAG, "writeAuditLog: assemble view failed", e);
        goto L59
    L52:
        return b(r4, r8);
    L48:
        r9 = r1;
        goto L49
    L76:
        return -4;
    L35:
        r6 = f3995a;
        goto L36
    L45:
        r8 = null;
        goto L46
    L24:
        if (r11 == EnumC0100a.f4002c) goto L27;
        r5 = false;
        goto L28
    L17:
        if (r11 == EnumC0100a.f4001b) goto L20;
        r2 = false;
    L64:
        e = move-exception;
        a(TAG, "writeAuditLog: json parse error", e);
        return -2;
    L77:
        return -1;
    }

    public static int a(Context r2, String r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        return a(r3);
    }

    private static boolean a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return false;
    L5:
        if (r2.isNull(r3) == true) goto L14;
        Object r4 = r2.opt(r3);
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L10;
        return true;
    L10:
        return !((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).isEmpty();
    L14:
        return false;
    }

    private static void a(JSONObject r1) {
        c(r1, "agent_identify");
        c(r1, "agent_decision");
        d(r1);
    }

    private static JSONObject b(JSONObject r2) {
        r2 = new JSONObject(r2.toString());     // Catch: JSONException -> L6
    L4:
        r2.remove("agent_identify");
        r2.remove("agent_decision");
        return r2;
    }

    private static EnumC0100a b() {
        EnumC0100a r0 = c(f3998d);
        f3999e = r0;
        return r0;
    }

    private static EnumC0100a c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        boolean r0 = com.bytedance.agentrobots.d.a.b(r3);
        boolean r4 = com.bytedance.agentrobots.d.a.d(r3);
        if (r0 == false) goto L7;
        if (r4 == false) goto L7;
        return EnumC0100a.f4000a;
    L7:
        if (r0 == true) goto L9;
        if (r4 == false) goto L14;
        return EnumC0100a.f4002c;
    L14:
        return EnumC0100a.f4003d;
    L9:
        return EnumC0100a.f4001b;
    }

    private static JSONObject c(JSONObject r2) {
        r2 = new JSONObject(r2.toString());     // Catch: JSONException -> L6
    L4:
        r2.remove(DownloadConstants.QUERY_KEY);
        r2.remove(VDPlayerEffectProviderImpl.KEY_THOUGHT);
        d.a(r2, "action_args");
        return r2;
    }

    private static int a(JSONObject r5, String[] r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String r3 = r6[r2];
        if (a(r5, r3) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        c(TAG, "validateRequiredFields: missing required field '" + r3 + "'");
        return -3;
    L9:
        return 0;
    }

    private static int b(JSONObject r4, String r5) {
        if (r5 != null) goto L5;
    L18:
        return -4;
    L5:
        if (r5.isEmpty() == true) goto L18;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L13 JSONException -> L16
        a(r2, r4, f3997c);     // Catch: Throwable -> L13 JSONException -> L16
        r2.put("payload_mode", "encrypted_only");     // Catch: Throwable -> L13 JSONException -> L16
        r2.put("payload_raw_enabled", false);     // Catch: Throwable -> L13 JSONException -> L16
        r2.put("payload_encrypted", r5);     // Catch: Throwable -> L13 JSONException -> L16
        f r6 = com.bytedance.agentrobots.a.a.b();     // Catch: Throwable -> L13 JSONException -> L16
        if (r6 != null) goto L11;
        return -6;
    L11:
        return a(r6.a(r2.toString()));
    L16:
        e = move-exception;
        a(TAG, "writeEncryptedOnlyLog: assemble failed", e);
    L13:
        th = move-exception;
        b(TAG, "writeEncryptedOnlyLog: unexpected error", th);
        return -100;
    }

    private static void a(JSONObject r4, JSONObject r5, String[] r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = r6[r1];
        if (r5.has(r2) == false) goto L11;
        if (r5.isNull(r2) == true) goto L11;
        r4.put(r2, r5.get(r2));
    L11:
        r1 = r1 + 1;
        goto L5
    }

    private static void c(JSONObject r5, String r6) {
        if (r5.has(r6) == true) goto L5;
        return;
    L5:
        if (r5.isNull(r6) == true) goto L39;
        Object r0 = r5.opt(r6);     // Catch: Exception -> L27
        JSONObject r1 = null;
        if (ZeusTransformUtils.instanceOf(r0, JSONObject.class) == false) goto L12;
        r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        Iterator<String> r2 = r1.keys();     // Catch: Exception -> L27
    L19:
        if (r2.hasNext() == false) goto L40;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        if (r5.has(r3) == false) goto L25;
        if (r5.isNull(r3) == false) goto L19;
    L25:
        r5.put(r3, r1.get(r3));     // Catch: Exception -> L27
        goto L19
    L40:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L16;
        if (((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L16;
        r1 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L27
    L27:
        e = move-exception;
        a(TAG, "flattenObjectField failed for " + r6, e);
        return;
    }

    private static void d(JSONObject r3) {
        if (r3.has("action_args") == true) goto L5;
        return;
    L5:
        if (r3.isNull("action_args") == true) goto L19;
        Object r1 = r3.opt("action_args");
        if (ZeusTransformUtils.instanceOf(r1, JSONArray.class) == false) goto L10;
        return;
    L10:
        JSONArray r2 = new JSONArray();
        r2.put(r1);
        r3.put("action_args", r2);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        a(TAG, "normalizeActionArgs failed", e);
        return;
    }

    private static int a(int r4) {
        e r0 = com.bytedance.agentrobots.a.a.d();
        if (r0 != null) goto L8;
        if (r4 == 0) goto L6;
        return -6;
    L6:
        return 0;
    L8:
        if (r4 != r0.a()) goto L11;
        return 0;
    L11:
        if (r4 != r0.b()) goto L15;
        return -5;
    L15:
        if (r4 != r0.c()) goto L18;
        return -6;
    L18:
        if (r4 != r0.d()) goto L22;
        return -7;
    L22:
        if (r4 != r0.e()) goto L26;
        return -2;
    L26:
        if (r4 != r0.f()) goto L30;
        return -3;
    L30:
        if (r4 != r0.g()) goto L34;
        return -4;
    L34:
        if (r4 != r0.h()) goto L38;
        return -8;
    L38:
        if (r4 != r0.i()) goto L41;
        return -9;
    L41:
        return -100;
    }

    private static void e(JSONObject r4) {
        com.bytedance.agentrobots.policy.d r1 = com.bytedance.agentrobots.policy.d.a();     // Catch: Exception -> L14
        if (r1 != null) goto L6;
        return;
    L6:
        String r2 = r4.optString("target_package", "");     // Catch: Exception -> L14
        if (r2.isEmpty() == false) goto L9;
        return;
    L9:
        String r3 = r1.b(r2);     // Catch: Exception -> L14
        if (r3 != null) goto L12;
        return;
    L12:
        r4.put("policy", r3);     // Catch: Exception -> L14
        b(TAG, "injectPolicy: policy injected for " + r2);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        a(TAG, "injectPolicy: failed, skipping", e);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
