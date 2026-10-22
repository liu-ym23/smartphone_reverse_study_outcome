package com.bytedance.bdtracker;

import com.bytedance.applog.log.EventBus;
import com.stepos.cloudsdk.Constants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v1 implements EventBus.DataFetcher {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ u1 b;

    public v1(u1 u1Var, JSONObject jSONObject) {
        this.b = u1Var;
        this.a = jSONObject;
    }

    @Override // com.bytedance.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        r.c(this.a, jSONObject2);
        try {
            jSONObject.put("appId", this.b.b.m);
            jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
