package com.bytedance.bdtracker;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q1 extends p1 {
    public final u1 e;
    public final d f;

    public q1(d dVar, u1 u1Var) {
        super(true, false);
        this.f = dVar;
        this.e = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Build";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("platform", "Android");
        jSONObject.put("sdk_lib", "Android");
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        if (this.e.c.isCPUAbiEnabled()) {
            jSONObject.put("cpu_abi", Build.CPU_ABI);
        }
        jSONObject.put("sdk_target_version", 29);
        jSONObject.put("git_hash", "43ff8ba");
        if (!p5.c.b(new Object[0]).booleanValue() || !this.e.c.isHarmonyEnabled()) {
            jSONObject.put("os", "Android");
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            return true;
        }
        jSONObject.put("os", "Harmony");
        try {
            jSONObject.put("os_api", r5.a("hw_sc.build.os.apiversion"));
            jSONObject.put("os_version", r5.a("hw_sc.build.platform.version"));
            return true;
        } catch (Throwable th) {
            this.f.D.error("loadHarmonyInfo failed", th, new Object[0]);
            return true;
        }
    }
}
