package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OaidSp.java */
/* JADX INFO: loaded from: classes4.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f37387a;

    r(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SharedPreferences r0 = r4.getSharedPreferences("device_register_oaid_refine", 0);
        this.f37387a = r0;
        a(r4, r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.o.c(com.ss.android.deviceregister.o.f37441a, "OaidSp#constructor", e);
    }

    void a(q r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f37387a.edit().putString("oaid", r2.b().toString()).apply();
    }

    q a() {
        return q.a(this.f37387a.getString("oaid", ""));
    }

    private void a(Context r5, SharedPreferences r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        SharedPreferences r7 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.class, "com.obric.aiagent.plugin");
        if (r7.getBoolean("migrated", false) == false) goto L5;
        return;
    L5:
        com.ss.android.deviceregister.o.c(com.ss.android.deviceregister.o.f37441a, "OaidSp#migrateDeprecatedSp");
        r7.edit().putBoolean("migrated", true).apply();
        q r8 = null;
        SharedPreferences r1 = r4.getSharedPreferences("device-register-oaid", 0);
        if (r1.contains("lastSuccessQueryOaid") == false) goto L8;
        q r9 = a(r1);
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidSp#migrateDeprecatedSp spHw");
        r1.edit().clear().apply();
    L12:
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidSp#migrateDeprecatedSp oaidModel=" + r9);
        if (r9 == null) goto L16;
        r7.edit().putString("oaid", r9.b().toString()).apply();
        return;
    L16:
        return;
    L8:
        SharedPreferences r10 = r4.getSharedPreferences("device-register-oaid-xiaomi", 0);
        if (r10.contains("lastSuccessQueryOaid") == false) goto L11;
        r8 = b(r10);
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidSp#migrateDeprecatedSp spXm");
    L11:
        r10.edit().clear().apply();
        r9 = r8;
        goto L12
    }

    private static q a(SharedPreferences r13) {
        SharedPreferences r14 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r13, SharedPreferences.class, "com.obric.aiagent.plugin");
        String r0 = r14.getString("lastSuccessQueryOaid", null);
        Integer r8 = Integer.valueOf(r14.getInt("queryHmsTimes", -1));
        if (TextUtils.isEmpty(r0) == true) goto L11;
        JSONObject r15 = new JSONObject(r0);     // Catch: JSONException -> L6
        String r3 = r15.optString(DbHelper.COL_ID);     // Catch: JSONException -> L6
        String r1 = r15.optString("is_track_limited");     // Catch: JSONException -> L6
        String r2 = r15.optString("take_ms");     // Catch: JSONException -> L6
        String r4 = r15.optString("time");     // Catch: JSONException -> L6
        String r5 = r15.optString("req_id");     // Catch: JSONException -> L6
        String r16 = r15.optString("hw_id_version_code");     // Catch: JSONException -> L6
        return new q(r3, r5, Boolean.valueOf(Boolean.parseBoolean(r1)), Long.valueOf(t.a(r2, -1)), Long.valueOf(t.a(r4, -1)), r8, Long.valueOf(t.a(r16, -1)));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }

    private static q b(SharedPreferences r13) {
        SharedPreferences r14 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r13, SharedPreferences.class, "com.obric.aiagent.plugin");
        String r0 = r14.getString("lastSuccessQueryOaid", null);
        Integer r8 = Integer.valueOf(r14.getInt("queryXiaomiTimes", -1));
        if (TextUtils.isEmpty(r0) == true) goto L11;
        JSONObject r15 = new JSONObject(r0);     // Catch: JSONException -> L6
        String r3 = r15.optString("oaid");     // Catch: JSONException -> L6
        String r4 = r15.optString("req_id");     // Catch: JSONException -> L6
        String r1 = r15.optString("last_success_query_oaid_time");     // Catch: JSONException -> L6
        return new q(r3, r4, null, Long.valueOf(t.a(r15.optString("take_ms"), -1)), Long.valueOf(t.a(r1, -1)), r8, null);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }
}
