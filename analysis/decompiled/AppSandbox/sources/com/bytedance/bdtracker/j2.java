package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.util.HardwareUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j2 extends p1 {
    public final Context e;
    public final u1 f;

    public j2(u1 u1Var, Context context) {
        super(true, false);
        this.e = context;
        this.f = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "SimCountry";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) {
        if (!this.f.m()) {
            return true;
        }
        w1.a(jSONObject, "sim_region", HardwareUtils.getSimCountryIso(this.e));
        return true;
    }
}
