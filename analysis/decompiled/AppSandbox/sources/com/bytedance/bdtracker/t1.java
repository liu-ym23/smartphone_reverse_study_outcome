package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t1 extends p1 {
    public final d e;
    public final u1 f;

    public t1(d dVar, Context context, u1 u1Var) {
        super(false, false);
        this.e = dVar;
        this.f = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Config";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 6170490);
        jSONObject.put("sdk_version_code", 16170089);
        jSONObject.put("sdk_version_name", "6.17.4");
        jSONObject.put("channel", this.f.c());
        jSONObject.put("not_request_sender", this.f.c.getNotReuqestSender() ? 1 : 0);
        w1.a(jSONObject, "aid", this.f.c.getAid());
        w1.a(jSONObject, "release_build", this.f.c.getReleaseBuild());
        w1.a(jSONObject, "user_agent", this.f.f.getString("user_agent", null));
        w1.a(jSONObject, "ab_sdk_version", this.f.d.getString("ab_sdk_version", ""));
        String language = this.f.c.getLanguage();
        if (TextUtils.isEmpty(language)) {
            language = this.f.f.getString("app_language", null);
        }
        w1.a(jSONObject, "app_language", language);
        String region = this.f.c.getRegion();
        if (TextUtils.isEmpty(region)) {
            region = this.f.f.getString("app_region", null);
        }
        if (TextUtils.isEmpty(region)) {
            region = Locale.getDefault().getCountry();
        }
        w1.a(jSONObject, "app_region", region);
        String string = this.f.d.getString("app_track", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject.put("app_track", new JSONObject(string));
            } catch (Throwable th) {
                this.e.D.error("JSON handle appTrack failed", th, new Object[0]);
            }
        }
        String string2 = this.f.d.getString("header_custom_info", null);
        if (string2 != null && string2.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                jSONObject2.remove("_debug_flag");
                jSONObject.put("custom", jSONObject2);
            } catch (Throwable th2) {
                this.e.D.error("JSON handle failed", th2, new Object[0]);
            }
        }
        String strG = this.f.g();
        if (!TextUtils.isEmpty(strG)) {
            w1.a(jSONObject, "user_unique_id", strG);
        }
        String strH = this.f.h();
        if (TextUtils.isEmpty(strH)) {
            return true;
        }
        w1.a(jSONObject, "user_unique_id_type", strH);
        return true;
    }
}
