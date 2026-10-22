package com.bytedance.bdtracker;

import com.stepos.pps.logpull.LogPullAuthActivity;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class o extends p {
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    @Override // com.bytedance.bdtracker.p
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", this.b);
        jSONObject.put("device_id", this.c);
        jSONObject.put("bd_did", this.d);
        jSONObject.put("install_id", this.e);
        jSONObject.put("os", this.f);
        jSONObject.put("caid", this.g);
        jSONObject.put("androidid", this.l);
        jSONObject.put("imei", this.m);
        jSONObject.put(LogPullAuthActivity.EXTRA_OAID, this.n);
        jSONObject.put("google_aid", this.o);
        jSONObject.put("ip", this.p);
        jSONObject.put("ua", this.q);
        jSONObject.put("device_model", this.r);
        jSONObject.put("os_version", this.s);
        jSONObject.put("is_new_user", this.h);
        jSONObject.put("exist_app_cache", this.i);
        jSONObject.put("app_version", this.j);
        jSONObject.put("channel", this.k);
        jSONObject.put(ExceptionManagerStepOS.PACKAGE, this.t);
        return jSONObject;
    }

    @Override // com.bytedance.bdtracker.p
    public void a(JSONObject jSONObject) {
    }
}
