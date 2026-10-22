package com.bytedance.apm.insight;

import com.bytedance.apm.insight.FlutterAgent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements C.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlutterAgent.IFlutterConfigListener f2244a;

    public a(FlutterAgent.IFlutterConfigListener iFlutterConfigListener) {
        this.f2244a = iFlutterConfigListener;
    }

    @Override // C.a
    public final void onReady() {
        FlutterAgent.IFlutterConfigListener iFlutterConfigListener = this.f2244a;
        if (iFlutterConfigListener != null) {
            iFlutterConfigListener.onReady();
        }
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObject2;
        FlutterAgent.IFlutterConfigListener iFlutterConfigListener = this.f2244a;
        if (iFlutterConfigListener != null) {
            if (jSONObject != null) {
                try {
                    jSONObject2 = jSONObject.getJSONObject("dart_module");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                jSONObject2 = null;
            }
            iFlutterConfigListener.onRefresh(jSONObject2, z10);
        }
    }
}
