package com.bytedance.bdtracker;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c2 extends p1 {
    public final Context e;

    public c2(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Net";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) {
        w1.a(jSONObject, "access", j5.a(this.e, true));
        return true;
    }
}
