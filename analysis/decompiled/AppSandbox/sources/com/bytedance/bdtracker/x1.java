package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.util.HardwareUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x1 extends p1 {
    public final Context e;
    public final w1 f;
    public final u1 g;

    public x1(Context context, u1 u1Var, w1 w1Var) {
        super(false, false);
        this.e = context;
        this.f = w1Var;
        this.g = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "DeviceParams";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) {
        if (this.g.m()) {
            String operatorName = HardwareUtils.getOperatorName(this.e);
            if (r.d(operatorName)) {
                w1.a(jSONObject, "carrier", operatorName);
            }
        }
        w1.a(jSONObject, "clientudid", this.f.h.a());
        w1.a(jSONObject, "openudid", this.f.h.c());
        return true;
    }
}
