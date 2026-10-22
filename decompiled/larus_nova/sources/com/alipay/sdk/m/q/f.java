package com.alipay.sdk.m.q;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class f extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.p.e.a("cashier", PullConfiguration.PROCESS_NAME_MAIN);
    }

    public f() {
    }
}
