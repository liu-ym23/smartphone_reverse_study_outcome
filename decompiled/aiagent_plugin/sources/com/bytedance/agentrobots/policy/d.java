package com.bytedance.agentrobots.policy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.agentrobots.a.a.f;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RobotPolicyManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "RobotsPolicyManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f4048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f4049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f4051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentObserver f4052e;

    /* JADX INFO: compiled from: RobotPolicyManager.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4053a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4054b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4055c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f4056e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4057d;

        private static /* synthetic */ a[] b() {
            return new a[]{f4053a, f4054b, f4055c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f4056e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            f4053a = new a("None", 0, 0);
            f4054b = new a("App", 1, 1);
            f4055c = new a("Activity", 2, 2);
            f4056e = b();
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4057d = r3;
        }

        public int a() {
            return this.f4057d;
        }
    }

    /* JADX INFO: compiled from: RobotPolicyManager.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f4058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<String> f4059b;

        b(List<String> r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f4058a = r5;
            this.f4059b = r6;
        }
    }

    static /* synthetic */ void a(d r0) {
        r0.d();
    }

    static /* synthetic */ void a(d r0, String r1) {
        r0.c(r1);
    }

    static {
        f4048a = Uri.parse("content://com.obric.agentrobots.provider/policy");
    }

    private d(Context r3) {
        Context r4 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f4050c = r4;
        com.bytedance.agentrobots.b.c.a(r4);
        this.f4051d = new c(r4);
        final Handler r0 = new Handler(Looper.getMainLooper());
        this.f4052e = new RobotPolicyManager$1(this, r0);
    }

    public static d a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        a(TAG, "getInstance: context is null");
        return null;
    L7:
        if (f4049b != null) goto L19;
        monitor-enter(d.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (f4049b != null) goto L13;
        f4049b = new d(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(d.class);     // Catch: Throwable -> L15
    L19:
        return f4049b;
    }

    public static d a() {
        return f4049b;
    }

    public void a(String r3) {
        com.bytedance.agentrobots.b.a.b(this.f4050c);
        if (com.bytedance.agentrobots.d.a.b(this.f4050c) == true) goto L6;
        b(TAG, "Robots protocol is disabled, keep security-log-only session mode");
        return;
    L6:
        d();
        a(this.f4052e);
        if (TextUtils.isEmpty(r3) == false) goto L17;
        a(TAG, "startSession: sessionId is null or empty, skip setActiveSession");
        return;
    L17:
        f r2 = com.bytedance.agentrobots.a.a.b();     // Catch: Throwable -> L14
        if (r2 == null) goto L19;
        r2.b(r3);     // Catch: Throwable -> L14
        return;
    L19:
        return;
    L14:
        th = move-exception;
        a(TAG, "startSession: setActiveSession failed", th);
    }

    public void b() {
        com.bytedance.agentrobots.b.a.a();
        ZeusProviderTransform.unregisterContentObserver(this, this.f4052e, "com.obric.aiagent.plugin");
        this.f4051d.a();
        f r2 = com.bytedance.agentrobots.a.a.b();     // Catch: Throwable -> L7
        if (r2 == null) goto L12;
        r2.a();     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        a(TAG, "endSession: clearActiveSession failed", th);
    }

    private void d() {
        ContentResolver r2 = this.f4050c.getContentResolver();
        Cursor r1 = null;
        StringBuilder r3 = new StringBuilder().append("loadPolicies querying URI: ");     // Catch: Throwable -> L26 Exception -> L28
        Uri r4 = f4048a;     // Catch: Throwable -> L26 Exception -> L28
        c(TAG, r3.append(r4).toString());     // Catch: Throwable -> L26 Exception -> L28
        r1 = ZeusProviderTransform.query(r2, r4, null, null, null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26 Exception -> L28
        StringBuilder r5 = new StringBuilder().append("loadPolicies cursor=").append(r1);     // Catch: Throwable -> L26 Exception -> L28
        if (r1 == null) goto L6;
        String r6 = ", count=" + r1.getCount();     // Catch: Throwable -> L26 Exception -> L28
    L7:
        c(TAG, r5.append(r6).toString());     // Catch: Throwable -> L26 Exception -> L28
        if (r1 == null) goto L24;
        int r7 = 0;
    L11:
        if (r1.moveToNext() == false) goto L23;
        int r8 = r1.getColumnIndex("package_name");     // Catch: Throwable -> L26 Exception -> L28
        int r9 = r1.getColumnIndex("policy");     // Catch: Throwable -> L26 Exception -> L28
        if (r8 == (-1)) goto L11;
        if (r9 == (-1)) goto L11;
        String r10 = r1.getString(r8);     // Catch: Throwable -> L26 Exception -> L28
        String r11 = r1.getString(r9);     // Catch: Throwable -> L26 Exception -> L28
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (TextUtils.isEmpty(r11) == true) goto L11;
        this.f4051d.a(r10, new JSONObject(r11));     // Catch: JSONException -> L21 Throwable -> L26 Exception -> L28
        r7 = r7 + 1;
    L21:
        e = move-exception;
        b(TAG, "Error parsing policy JSON for " + r10, e);     // Catch: Throwable -> L26 Exception -> L28
        goto L11
    L23:
        c(TAG, "loadPolicies loadedCount=" + r7);     // Catch: Throwable -> L26 Exception -> L28
    L24:
        if (r1 == null) goto L52;
    L31:
        r1.close();
        return;
    L52:
        return;
    L6:
        r6 = "";
    L26:
        th = move-exception;
        if (r1 == null) goto L35;
        r1.close();
    L35:
        throw th;
    L28:
        e = move-exception;
        b(TAG, "Error loading policies", e);     // Catch: Throwable -> L26
        if (r1 != null) goto L31;
    }

    private void c(String r10) {
        Cursor r1 = null;
        r1 = ZeusProviderTransform.query(this.f4050c.getContentResolver(), f4048a, null, "package_name=?", new String[]{r10}, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16 Exception -> L18
        if (r1 != null) goto L7;
    L13:
        a(TAG, "loadPolicyForPackage [" + r10 + "] not found in DB, removing cache");     // Catch: Throwable -> L16 Exception -> L18
        this.f4051d.b(r10);     // Catch: Throwable -> L16 Exception -> L18
    L14:
        if (r1 == null) goto L28;
    L21:
        r1.close();
        return;
    L28:
        return;
    L7:
        if (r1.moveToFirst() == false) goto L13;
        int r3 = r1.getColumnIndex("policy");     // Catch: Throwable -> L16 Exception -> L18
        if (r3 == (-1)) goto L14;
        String r4 = r1.getString(r3);     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r4) == true) goto L14;
        this.f4051d.a(r10, new JSONObject(r4));     // Catch: Throwable -> L16 Exception -> L18
        c(TAG, "loadPolicyForPackage [" + r10 + "] loaded");     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = move-exception;
        b(TAG, "Error loading policy for package: " + r10, e);     // Catch: Throwable -> L16
        if (0 != 0) goto L21;
        return;
    L16:
        th = move-exception;
        if (0 == 0) goto L25;
        r1.close();
    L25:
        throw th;
    }

    public String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        JSONObject r3 = this.f4051d.a(r4);
        StringBuilder r5 = new StringBuilder().append("getRawPolicy [").append(r4).append("] cacheHit=");
        if (r3 == null) goto L8;
        boolean r0 = true;
    L9:
        c(TAG, r5.append(r0).toString());
        if (r3 != null) goto L13;
        return null;
    L13:
        return r3.toString();
    L8:
        r0 = false;
        goto L9
    }

    public Map<String, List<String>> c() {
        b r3 = e();
        if (r3 != null) goto L6;
        return null;
    L6:
        LinkedHashMap r0 = new LinkedHashMap(2);
        r0.put("restricted_packages", r3.f4058a);
        r0.put("saep_declared_packages", r3.f4059b);
        return Collections.unmodifiableMap(r0);
    }

    private b e() {
    L55:
        e = move-exception;
        b(TAG, "queryPackageClassification: Failed to query policies", e);
        return null;
    L4:
        if (com.bytedance.agentrobots.d.a.b(this.f4050c) == true) goto L7;
        a(TAG, "queryPackageClassification: Robots protocol is not enabled");     // Catch: Exception -> L55
        return null;
    L7:
        TreeSet r11 = new TreeSet();     // Catch: Exception -> L55
        TreeSet r12 = new TreeSet();     // Catch: Exception -> L55
        com.bytedance.agentrobots.policy.b.a r13 = com.bytedance.agentrobots.policy.b.a();     // Catch: Exception -> L55
        Cursor r4 = ZeusProviderTransform.query(this.f4050c.getContentResolver(), f4048a, new String[]{"package_name", "policy"}, null, null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L55
        if (r4 != null) goto L13;
        d(TAG, "queryPackageClassification: Provider returned a null cursor");     // Catch: Throwable -> L48
        if (r4 == null) goto L12;
        r4.close();     // Catch: Exception -> L55
    L12:
        return null;
    L13:
        int r1 = r4.getColumnIndex("package_name");     // Catch: Throwable -> L48
        int r0 = r4.getColumnIndex("policy");     // Catch: Throwable -> L48
        if (r1 < 0) goto L44;
        if (r0 < 0) goto L44;
    L18:
        if (r4.moveToNext() == false) goto L40;
        String r5 = r4.getString(r1);     // Catch: Throwable -> L48
        String r6 = r4.getString(r0);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r5) == true) goto L36;
        if (TextUtils.isEmpty(r6) == true) goto L36;
    L26:
        if (com.bytedance.agentrobots.policy.a.a(a(new JSONObject(r6), r13)) == true) goto L27;
        if (r11.contains(r5) == true) goto L18;
        r12.add(r5);     // Catch: Throwable -> L48
        goto L18
    L27:
        r11.add(r5);     // Catch: Throwable -> L48
        r12.remove(r5);     // Catch: Throwable -> L48
    L31:
        e = move-exception;
        b(TAG, "queryPackageClassification: Invalid policy for " + r5, e);     // Catch: Throwable -> L48
        if (r4 == null) goto L35;
        r4.close();     // Catch: Exception -> L55
    L35:
        return null;
    L36:
        d(TAG, "queryPackageClassification: Provider returned an incomplete row");     // Catch: Throwable -> L48
        if (r4 == null) goto L39;
        r4.close();     // Catch: Exception -> L55
    L39:
        return null;
    L40:
        if (r4 == null) goto L43;
        r4.close();     // Catch: Exception -> L55
    L43:
        return new b(a(r11), a(r12));
    L44:
        d(TAG, "queryPackageClassification: Provider result is missing required columns");     // Catch: Throwable -> L48
        if (r4 == null) goto L47;
        r4.close();     // Catch: Exception -> L55
    L47:
        return null;
    L48:
        th = move-exception;
        if (r4 != null) goto L60;
    L54:
        throw th;     // Catch: Exception -> L55
    L60:
        r4.close();     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L55
        goto L54
    }

    private static List<String> a(TreeSet<String> r1) {
        return Collections.unmodifiableList(new ArrayList(r1));
    }

    public String e(String r18, String r19) {
        JSONObject r7 = null;
        if (com.bytedance.agentrobots.d.a.b(this.f4050c) == true) goto L7;
        a(TAG, "Robots protocol is not enabled");
        return null;
    L7:
        if (TextUtils.isEmpty(r18) == false) goto L9;
    L49:
        return null;
    L9:
        if (TextUtils.isEmpty(r19) == true) goto L49;
        JSONObject r6 = this.f4051d.a(r18);
        StringBuilder r9 = new StringBuilder().append("acquireTargetPolicy [").append(r18).append("] cacheHit=");
        boolean r11 = false;
        if (r6 == null) goto L14;
        boolean r13 = true;
    L15:
        c(TAG, r9.append(r13).toString());
        if (r6 == null) goto L18;
        com.bytedance.agentrobots.policy.a.C0103a r8 = a(r6);
        if (r8.c() == false) goto L23;
        c(TAG, "acquireTargetPolicy [" + r18 + "] hit bypass_policy");
        return f();
    L23:
        JSONObject r10 = r8.b();
        StringBuilder r12 = new StringBuilder().append("acquireTargetPolicy [").append(r18).append("] effectivePolicyFound=");
        if (r10 == null) goto L26;
        r11 = true;
    L26:
        c(TAG, r12.append(r11).toString());
        if (r10 == null) goto L29;
        JSONObject r14 = r10.optJSONObject("app");
        JSONObject r15 = r10.optJSONObject("activities");
        JSONObject r16 = r10.optJSONObject("agent_intents");
        if (r15 == null) goto L33;
        JSONObject r17 = r15.optJSONObject(r19);
    L34:
        if (r17 == null) goto L37;
        r7 = r17.optJSONObject("page_scope");
    L37:
        if (r17 == null) goto L39;
        String r110 = r17.optString("name", "");
    L50:
        JSONObject r111 = new JSONObject();     // Catch: JSONException -> L46
        r111.put("has_policy", true);     // Catch: JSONException -> L46
        r111.put("name", r110);     // Catch: JSONException -> L46
        r111.put("global_disable", a("global_disable", r14, r7).a());     // Catch: JSONException -> L46
        r111.put("screenshot_disable", a("screenshot_disable", r14, r7).a());     // Catch: JSONException -> L46
        r111.put("input_disable", a("input_disable", r14, r7).a());     // Catch: JSONException -> L46
        if (r16 == null) goto L43;
        String r112 = r16.toString();     // Catch: JSONException -> L46
    L44:
        r111.put("intent_policy", r112);     // Catch: JSONException -> L46
        String r3 = r111.toString();     // Catch: JSONException -> L46
        c(TAG, "acquireTargetPolicy [" + r18 + "/" + r19 + "] resultReady");     // Catch: JSONException -> L46
        return r3;
    L43:
        r112 = "";
    L46:
        e = move-exception;
        b(TAG, "Error constructing policy JSON", e);
        return g();
    L39:
        r110 = "";
        goto L50
    L33:
        r17 = null;
        goto L34
    L29:
        return g();
    L18:
        return g();
    L14:
        r13 = false;
        goto L15
    }

    private com.bytedance.agentrobots.policy.a.C0103a a(JSONObject r2) {
        return a(r2, com.bytedance.agentrobots.policy.b.a());
    }

    private com.bytedance.agentrobots.policy.a.C0103a a(JSONObject r1, com.bytedance.agentrobots.policy.b.a r2) {
        if (r1 == null) goto L4;
        JSONArray r0 = r1.optJSONArray("oem_groups");
    L6:
        return com.bytedance.agentrobots.policy.a.a(r1, com.bytedance.agentrobots.policy.b.a(r0, r2));
    L4:
        r0 = null;
        goto L6
    }

    private String f() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L5
        r0.put("has_policy", true);     // Catch: JSONException -> L5
        r0.put("name", "");     // Catch: JSONException -> L5
        r0.put("global_disable", 0);     // Catch: JSONException -> L5
        r0.put("screenshot_disable", 0);     // Catch: JSONException -> L5
        r0.put("input_disable", 0);     // Catch: JSONException -> L5
        r0.put("intent_policy", "");     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        b(TAG, "Error constructing bypass policy JSON", e);
        return null;
    }

    private String g() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L5
        r0.put("has_policy", false);     // Catch: JSONException -> L5
        r0.put("name", "");     // Catch: JSONException -> L5
        r0.put("global_disable", 0);     // Catch: JSONException -> L5
        r0.put("screenshot_disable", 0);     // Catch: JSONException -> L5
        r0.put("input_disable", 0);     // Catch: JSONException -> L5
        r0.put("intent_policy", "");     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        b(TAG, "Error constructing default policy JSON", e);
        return null;
    }

    private boolean a(JSONObject r1, String r2) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.optBoolean(r2, false);
    }

    private a a(String r1, JSONObject r2, JSONObject r3) {
        if (a(r2, r1) == false) goto L7;
        return a.f4054b;
    L7:
        if (a(r3, r1) == false) goto L11;
        return a.f4055c;
    L11:
        return a.f4053a;
    }

    public void a(ContentObserver r5) {
        if (r5 != null) goto L10;
        return;
    L10:
        ContentResolver r4 = this.f4050c.getContentResolver();     // Catch: SecurityException -> L7
        Uri r1 = f4048a;     // Catch: SecurityException -> L7
        ZeusProviderTransform.registerContentObserver(r4, r1, true, r5, "com.obric.aiagent.plugin");     // Catch: SecurityException -> L7
        b(TAG, "ContentObserver registered for URI: " + r1);     // Catch: SecurityException -> L7
        return;
    L7:
        e = move-exception;
        b(TAG, "Failed to register ContentObserver", e);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
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
    public static int d(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
