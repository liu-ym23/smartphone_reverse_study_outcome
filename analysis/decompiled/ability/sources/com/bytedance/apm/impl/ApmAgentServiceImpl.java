package com.bytedance.apm.impl;

import B0.f;
import H.a;
import H.c;
import H.e;
import H.h;
import L0.d;
import S0.b;
import android.content.Context;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String str, JSONObject jSONObject) {
        d.f925a.b(new c(1, str, b.K0(jSONObject)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        d.f925a.b(new a(str, jSONObject, b.K0(jSONObject2)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(B.a aVar) {
        String str = aVar.f170a;
        JSONObject jSONObject = aVar.b;
        boolean z10 = aVar.c;
        f fVar = new f();
        fVar.f177a = str;
        fVar.c = jSONObject;
        fVar.b = z10;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject2.isNull("timestamp")) {
            try {
                jSONObject2.put("timestamp", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        d.f925a.b(new A.a(3, fVar, false, jSONObject2));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String str, JSONObject jSONObject) {
        d.f925a.b(new c(0, str, b.K0(jSONObject)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String str, JSONObject jSONObject) {
        d.f925a.b(new c(1, str, b.K0(jSONObject)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        d.f925a.b(new H.b(str, i, jSONObject, b.K0(jSONObject2)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context context, long j5, long j6, boolean z10) {
        d.f925a.c(new H.d(h.f711a, j5, j6, z10));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        d.f925a.b(new e(str, jSONObject, jSONObject2, b.K0(jSONObject3)));
    }
}
