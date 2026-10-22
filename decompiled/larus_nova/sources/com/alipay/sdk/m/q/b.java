package com.alipay.sdk.m.q;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class b extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return true;
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.p.e.a("sdkConfig", "obtain");
    }

    public b() {
    }

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a r100, HashMap<String, String> r101, HashMap<String, String> r102) throws JSONException {
        if (r102 != null) goto L4;
        r102 = new HashMap();
    L4:
        r102.putAll(com.alipay.sdk.m.u.a.a(r100));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "cf " + r102);
        return super.a(r100, r101, r102);
    }
}
