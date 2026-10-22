package com.bytedance.bdtracker;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s1 extends p1 {
    public final u1 e;

    public s1(u1 u1Var) {
        super(true, false);
        this.e = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Cdid";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        String strA = y5.a(this.e.f);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        jSONObject.put("cdid", strA);
        return true;
    }
}
