package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class k0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f142148a;

    public k0(int r100) {
        this.f142148a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        xs2.b.a().post(new zg1.v(this.f142148a, r100.optInt("type"), null));
        return null;
    }
}
