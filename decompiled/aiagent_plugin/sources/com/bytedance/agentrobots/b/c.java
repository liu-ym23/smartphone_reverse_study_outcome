package com.bytedance.agentrobots.b;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.agentrobots.a.a.e;
import com.bytedance.agentrobots.a.a.f;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RobotAuditLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = "RobotAuditLogger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f4008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4009b = null;

    static {
        f4009b = new String[]{"agent_uuid", "pkg_sha256", "agent_type", "trust_level", "package_name", "proof_signature", "log_source", DBHelper.COL_TIME, "agent_name"};
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        f4008a = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        return;
    }

    static int a(String r4, boolean r5) {
        if (com.bytedance.agentrobots.d.a.b(f4008a) == true) goto L7;
        a(TAG, "Robots protocol is disabled");
        return -10;
    L7:
        if (f4008a != null) goto L9;
        a(TAG, "writeAuditLog: context not initialized. Use writeAuditLog(context, json) or call initialize(context) first.");
    L9:
        if (r4 != null) goto L11;
    L49:
        a(TAG, "writeAuditLog: json is null or empty");
        return -1;
    L11:
        if (r4.isEmpty() == true) goto L49;
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L46
        int r6 = b(r1);
        if (r6 == 0) goto L17;
        return r6;
    L17:
        a(r1);
        if (r5 == true) goto L20;
    L51:
        r1.put("payload_encrypted", b.a(r1.optString("payload_encrypted")));     // Catch: JSONException -> L31
    L33:
        d.a(r1, "action_args");
        Bundle r7 = c(r1);     // Catch: Throwable -> L40 JSONException -> L43
        b(TAG, "writeAuditLog: SDK robots audit format validation passed, log_id=" + r1.optString("log_id", "") + ", instruction_id=" + r1.optString("instruction_id", "") + ", target_package=" + r1.optString("target_package", ""));     // Catch: Throwable -> L40 JSONException -> L43
        JSONObject r8 = a(r7);     // Catch: Throwable -> L40 JSONException -> L43
        f r9 = com.bytedance.agentrobots.a.a.b();     // Catch: Throwable -> L40 JSONException -> L43
        if (r9 != null) goto L38;
        return -6;
    L38:
        return a(r9.a(r8.toString()));
    L43:
        e = move-exception;
        a(TAG, "writeAuditLog: failed to build audit log", e);
        return -4;
    L40:
        th = move-exception;
        b(TAG, "writeAuditLog: unexpected error", th);
        return -100;
    L31:
        e = move-exception;
        a(TAG, "writeAuditLog: failed to clean payload_encrypted", e);
        goto L33
    L20:
        if (r1.has("payload_encrypted") == true) goto L22;
    L23:
        String r10 = b.b(r1);
        if (r10 == null) goto L33;
        r1.put("payload_encrypted", r10);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        a(TAG, "writeAuditLog: failed to put payload_encrypted", e);
        goto L33
    L22:
        if (r1.isNull("payload_encrypted") == false) goto L51;
    L46:
        e = move-exception;
        a(TAG, "writeAuditLog: failed to parse input json", e);
        return -2;
    }

    private static void a(JSONObject r4) {
        com.bytedance.agentrobots.policy.d r1 = com.bytedance.agentrobots.policy.d.a();     // Catch: Exception -> L17
        if (r1 != null) goto L7;
        c(TAG, "injectPolicy: manager is null, skipping");     // Catch: Exception -> L17
        return;
    L7:
        String r2 = r4.optString("target_package", "");     // Catch: Exception -> L17
        if (r2.isEmpty() == false) goto L11;
        c(TAG, "injectPolicy: targetPackage is empty, skipping");     // Catch: Exception -> L17
        return;
    L11:
        String r3 = r1.b(r2);     // Catch: Exception -> L17
        if (r3 != null) goto L15;
        c(TAG, "injectPolicy: policyJson is null, skipping");     // Catch: Exception -> L17
        return;
    L15:
        r4.put("policy", r3);     // Catch: Exception -> L17
        b(TAG, "injectPolicy: policy injected for " + r2);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        a(TAG, "injectPolicy: failed to inject policy, skipping", e);
    }

    private static int a(int r3) {
        e r0 = com.bytedance.agentrobots.a.a.d();
        if (r0 != null) goto L6;
        return -6;
    L6:
        if (r3 != r0.a()) goto L10;
        return 0;
    L10:
        if (r3 != r0.b()) goto L14;
        return -5;
    L14:
        if (r3 != r0.c()) goto L17;
        return -6;
    L17:
        if (r3 != r0.d()) goto L21;
        return -7;
    L21:
        if (r3 != r0.e()) goto L25;
        return -2;
    L25:
        if (r3 != r0.f()) goto L29;
        return -3;
    L29:
        if (r3 != r0.g()) goto L33;
        return -4;
    L33:
        if (r3 != r0.h()) goto L37;
        return -8;
    L37:
        if (r3 != r0.i()) goto L40;
        return -9;
    L40:
        return -100;
    }

    private static int b(JSONObject r6) {
        String[] r0 = f4009b;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        String r4 = r0[r3];
        if (r6.has(r4) == false) goto L12;
        if (r6.isNull(r4) == true) goto L12;
        if (r6.optString(r4).isEmpty() == true) goto L12;
        r3 = r3 + 1;
    L12:
        c(TAG, "validateRequiredFields: missing required field '" + r4 + "'");
        return -3;
    L14:
        return 0;
    }

    private static Bundle c(JSONObject r4) {
        Bundle r0 = new Bundle();
        r0.putString("log_source", r4.getString("log_source"));
        r0.putString(DBHelper.COL_TIME, r4.getString(DBHelper.COL_TIME));
        a(r0, "target_package", r4);
        a(r0, "target_activity", r4);
        a(r0, "intent_type", r4);
        r0.putString("agent_name", r4.getString("agent_name"));
        a(r0, "payload_encrypted", r4);
        a(r0, "envelope_app_id", r4);
        a(r0, "device_id", r4);
        a(r0, "uid", r4);
        a(r0, "execute_id", r4);
        a(r0, "doubao_message_id", r4);
        a(r0, "tool_name", r4);
        a(r0, "instruction_type", r4);
        JSONObject r1 = new JSONObject();
        r1.put("agent_uuid", r4.getString("agent_uuid"));
        r1.put("pkg_sha256", r4.getString("pkg_sha256"));
        r1.put("agent_type", r4.getString("agent_type"));
        r1.put("trust_level", r4.getString("trust_level"));
        r1.put("package_name", r4.getString("package_name"));
        r1.put("proof_signature", r4.getString("proof_signature"));
        a(r1, "agent_version", r4);
        a(r1, "agent_md5", r4);
        r0.putString("agent_identify", r1.toString());
        JSONObject r2 = new JSONObject();
        a(r2, "log_id", r4);
        a(r2, "action_args", r4);
        a(r2, "action_type", r4);
        a(r2, "instruction_id", r4);
        a(r2, "step_id", r4);
        a(r2, "error_code", r4);
        a(r2, "user_authorization_type", r4);
        a(r2, "risk_level", r4);
        a(r2, "policy", r4);
        a(r2, "reason_code", r4);
        a(r2, "duration_ms", r4);
        r0.putString("agent_decision", r2.toString());
        return r0;
    }

    private static JSONObject a(Bundle r5) {
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        r0.put(r2, r5.getString(r2));
        goto L4
    L6:
        return r0;
    }

    private static void a(JSONObject r1, String r2, JSONObject r3) {
        if (r3.has(r2) == true) goto L5;
        return;
    L5:
        if (r3.isNull(r2) == true) goto L9;
        r1.put(r2, r3.get(r2));
        return;
    }

    private static void a(Bundle r1, String r2, JSONObject r3) {
        if (r3.has(r2) == true) goto L5;
        return;
    L5:
        if (r3.isNull(r2) == true) goto L9;
        r1.putString(r2, r3.optString(r2));
        return;
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
        return Log.w(r1, r2);
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
