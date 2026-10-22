package com.alipay.sdk.m.q;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class d extends com.alipay.sdk.m.p.e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25722t = "log_v";

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a r100, String r101, JSONObject r102) {
        return r101;
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }

    public d() {
    }

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a r100) throws JSONException {
        HashMap<String, String> r101 = new HashMap();
        r101.put("api_name", "/sdk/log");
        r101.put("api_version", "1.0.0");
        HashMap<String, String> r102 = new HashMap();
        r102.put(f25722t, "1.0");
        return a(r100, r101, r102);
    }

    @Override // com.alipay.sdk.m.p.e
    public Map<String, String> a(boolean r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put(com.alipay.sdk.m.p.e.f25655c, String.valueOf(r100));
        r102.put(com.alipay.sdk.m.p.e.f25658f, "application/octet-stream");
        r102.put(com.alipay.sdk.m.p.e.f25661i, "CBC");
        return r102;
    }

    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a r100, Context r101, String r102) throws Throwable {
        return a(r100, r101, r102, com.alipay.sdk.m.l.a.f25456d, true);
    }
}
