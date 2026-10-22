package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstallInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class am implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6116e;
    private String f;
    private String g;
    private String h;

    public am() {
        this.f6112a = "";
        this.f6113b = "";
    }

    public /* synthetic */ Object clone() {
        return j();
    }

    public String a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.f6113b;
    }

    public String d() {
        return this.f6114c;
    }

    public String e() {
        return this.f6115d;
    }

    public String f() {
        return this.f6112a;
    }

    public void a(String r1) {
        this.f6112a = r1;
    }

    public void b(String r1) {
        this.f6113b = r1;
    }

    public void c(String r1) {
        this.f6114c = r1;
    }

    public void d(String r1) {
        this.f6115d = r1;
    }

    public String g() {
        return this.f6116e;
    }

    public void e(String r1) {
        this.f6116e = r1;
    }

    public void f(String r1) {
        this.h = r1;
    }

    public String h() {
        return this.h;
    }

    JSONObject i() {
        JSONObject r0 = new JSONObject();
        r0.put("did", this.f6112a);     // Catch: JSONException -> L5
        r0.put(WsConstants.KEY_INSTALL_ID, this.f6113b);     // Catch: JSONException -> L5
        r0.put("openudid", this.f6114c);     // Catch: JSONException -> L5
        r0.put("cliend_udid", this.f6115d);     // Catch: JSONException -> L5
        r0.put("ssid", this.f6116e);     // Catch: JSONException -> L5
        r0.put("eDid", this.f);     // Catch: JSONException -> L5
        r0.put("eIid", this.g);     // Catch: JSONException -> L5
        r0.put("egdi", this.h);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    static am g(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L7
        am r5 = new am();     // Catch: JSONException -> L7
        r5.a(r1.optString("did", ""));     // Catch: JSONException -> L7
        r5.b(r1.optString(WsConstants.KEY_INSTALL_ID, ""));     // Catch: JSONException -> L7
        r5.c(r1.optString("openudid", ""));     // Catch: JSONException -> L7
        r5.d(r1.optString("cliend_udid", ""));     // Catch: JSONException -> L7
        r5.e(r1.optString("ssid", ""));     // Catch: JSONException -> L7
        r5.e(r1.optString("eDid", ""));     // Catch: JSONException -> L7
        r5.e(r1.optString("eIid", ""));     // Catch: JSONException -> L7
        r5.f(r1.optString("egdi", ""));     // Catch: JSONException -> L7
        t.a("aaa# parse install info " + r5);     // Catch: JSONException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String toString() {
        return "{d='" + this.f6112a + "', i='" + this.f6113b + "', o='" + this.f6114c + "', c='" + this.f6115d + "', s='" + this.f6116e + "', eDid='" + this.f + "', eIid='" + this.g + "', e='" + this.h + "'}";
    }

    public am j() {
        return (am) ZeusTransformUtils.preCheckCast(super.clone(), am.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        t.b("clone error", e);
        return null;
    }
}
