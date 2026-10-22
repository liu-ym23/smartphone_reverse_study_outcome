package com.bytedance.apm.insight;

import H.f;
import J2.c;
import J2.d;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FlutterAgent {

    public interface IFlutterConfigListener {
        void onReady();

        void onRefresh(JSONObject jSONObject, boolean z10);
    }

    public static JSONObject getFlutterConfig() {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        d dVar = c.f865a;
        if (!dVar.e || (slardarConfigManagerImpl = dVar.d) == null) {
            return null;
        }
        return slardarConfigManagerImpl.getConfigJSON("dart_module");
    }

    public static void monitorFlutter(JSONObject jSONObject) {
        L0.d.f925a.b(new f(0, jSONObject));
    }

    public static void registerConfigListener(IFlutterConfigListener iFlutterConfigListener) {
        c.f865a.b();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(new a(iFlutterConfigListener));
    }
}
