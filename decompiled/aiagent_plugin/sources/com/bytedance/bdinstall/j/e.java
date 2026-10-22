package com.bytedance.bdinstall.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f6312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Map<String, com.bytedance.bdinstall.a.a.c>> f6313b;

    public static void a(an r7, JSONObject r8, JSONObject r9) {
        JSONObject r1 = new JSONObject();
        if (r9 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        JSONObject r2 = r8.optJSONObject("oaid");
        String r3 = null;
        if (r2 == null) goto L11;
        com.bytedance.bdinstall.oaid.m r4 = com.bytedance.bdinstall.oaid.m.a(r2.toString());
    L12:
        boolean r5 = TextUtils.isEmpty(r8.optString("install_id"));
        boolean r6 = TextUtils.isEmpty(r8.optString("device_id"));
        r1.put("reqeust_did_success", r10);     // Catch: JSONException -> L19
        r1.put("empty_iid", r5);     // Catch: JSONException -> L19
        r1.put("empty_did", r6);     // Catch: JSONException -> L19
        if (r4 == null) goto L17;
        r3 = r4.f6414a;     // Catch: JSONException -> L19
    L17:
        r1.put("dr_oaid", r3);     // Catch: JSONException -> L19
        r1.put("oaid_thread_switch_ts", com.bytedance.bdinstall.oaid.n.i() - com.bytedance.bdinstall.oaid.n.h());     // Catch: JSONException -> L19
        r1.put("oaid_file_load_ts", com.bytedance.bdinstall.oaid.n.j() - com.bytedance.bdinstall.oaid.n.i());     // Catch: JSONException -> L19
        r1.put("oaid_sys_call_ts", com.bytedance.bdinstall.oaid.n.k() - com.bytedance.bdinstall.oaid.n.j());     // Catch: JSONException -> L19
        r1.put("oaid_save_ts", com.bytedance.bdinstall.oaid.n.l() - com.bytedance.bdinstall.oaid.n.k());     // Catch: JSONException -> L19
        r1.put("dr_wait_oaid_realtime", com.bytedance.bdinstall.oaid.n.n() - com.bytedance.bdinstall.oaid.n.m());     // Catch: JSONException -> L19
        r1.put("dr_wait_oaid_estimate_time", com.bytedance.bdinstall.oaid.n.n() - com.bytedance.bdinstall.oaid.n.m());     // Catch: JSONException -> L19
        r1.put("support_oaid", r8.optBoolean("oaid_may_support"));     // Catch: JSONException -> L19
        r1.put("oaid_impl", com.bytedance.bdinstall.oaid.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).e());     // Catch: JSONException -> L19
    L21:
        if (r7 != null) goto L23;
    L25:
        com.bytedance.bdinstall.t.a("did_fetch_result, " + r1);
        return;
    L23:
        if (r7.E() == null) goto L25;
        r7.E().a("did_fetch_result", r1);
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L11:
        r4 = null;
        goto L12
    L5:
        if (TextUtils.isEmpty(r9.optString("device_id_str")) == true) goto L7;
        r10 = true;
        goto L8
    }

    private e() {
        this.f6313b = new ConcurrentHashMap();
    }

    public static e a() {
        if (f6312a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6312a != null) goto L9;
        f6312a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f6312a;
    }

    public void a(int r4) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        r0.put(a.C0146a.f6301b, new com.bytedance.bdinstall.b.c());
        r0.put(a.C0146a.f6302c, new com.bytedance.bdinstall.b.a());
        r0.put(a.C0146a.f6303d, new com.bytedance.bdinstall.b.b());
        this.f6313b.put(String.valueOf(r4), r0);
    }

    public com.bytedance.bdinstall.b.b b(int r4) {
        Map<String, com.bytedance.bdinstall.a.a.c> r0 = (Map) ZeusTransformUtils.preCheckCast(this.f6313b.get(String.valueOf(r4)), Map.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.f6313b.put(String.valueOf(r4), r0);
    L5:
        com.bytedance.bdinstall.b.b r3 = (com.bytedance.bdinstall.b.b) ZeusTransformUtils.preCheckCast(r0.get(a.C0146a.f6303d), com.bytedance.bdinstall.b.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        com.bytedance.bdinstall.b.b r5 = new com.bytedance.bdinstall.b.b();
        r0.put(a.C0146a.f6303d, r5);
        return r5;
    L9:
        return r3;
    }

    public com.bytedance.bdinstall.b.c c(int r4) {
        Map<String, com.bytedance.bdinstall.a.a.c> r0 = (Map) ZeusTransformUtils.preCheckCast(this.f6313b.get(String.valueOf(r4)), Map.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.f6313b.put(String.valueOf(r4), r0);
    L5:
        com.bytedance.bdinstall.b.c r3 = (com.bytedance.bdinstall.b.c) ZeusTransformUtils.preCheckCast(r0.get(a.C0146a.f6301b), com.bytedance.bdinstall.b.c.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        com.bytedance.bdinstall.b.c r5 = new com.bytedance.bdinstall.b.c();
        r0.put(a.C0146a.f6301b, r5);
        return r5;
    L9:
        return r3;
    }

    public com.bytedance.bdinstall.b.a d(int r4) {
        Map<String, com.bytedance.bdinstall.a.a.c> r0 = (Map) ZeusTransformUtils.preCheckCast(this.f6313b.get(String.valueOf(r4)), Map.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.f6313b.put(String.valueOf(r4), r0);
    L5:
        com.bytedance.bdinstall.b.a r3 = (com.bytedance.bdinstall.b.a) ZeusTransformUtils.preCheckCast(r0.get(a.C0146a.f6302c), com.bytedance.bdinstall.b.a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        com.bytedance.bdinstall.b.a r5 = new com.bytedance.bdinstall.b.a();
        r0.put(a.C0146a.f6302c, r5);
        return r5;
    L9:
        return r3;
    }

    public com.bytedance.bdinstall.b.d e(int r4) {
        Map<String, com.bytedance.bdinstall.a.a.c> r0 = (Map) ZeusTransformUtils.preCheckCast(this.f6313b.get(String.valueOf(r4)), Map.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.f6313b.put(String.valueOf(r4), r0);
    L5:
        com.bytedance.bdinstall.b.d r3 = (com.bytedance.bdinstall.b.d) ZeusTransformUtils.preCheckCast(r0.get(a.C0146a.f6300a), com.bytedance.bdinstall.b.d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        com.bytedance.bdinstall.b.d r5 = new com.bytedance.bdinstall.b.d();
        r0.put(a.C0146a.f6300a, r5);
        return r5;
    L9:
        return r3;
    }

    public static void a(an r2) {
        a().b(r2.a()).a(r2, a.C0146a.g);
    }

    public static void b(an r2) {
        a().c(r2.a()).a(r2, a.C0146a.f6304e);
    }

    public static void c(an r2) {
        a().d(r2.a()).a(r2, a.C0146a.f);
    }

    public static void d(an r2) {
        if (com.bytedance.bdinstall.i.f().c() == false) goto L6;
        a().e(r2.a()).a(r2, a.C0146a.h);
        return;
    }
}
