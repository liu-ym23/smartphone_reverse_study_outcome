package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.j5;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s4 extends e4 {
    public static final JSONObject s;

    static {
        JSONObject jSONObject = new JSONObject();
        s = jSONObject;
        try {
            jSONObject.put("_staging_flag", 1);
            jSONObject.put("params_for_special", "applog_trace");
        } catch (Throwable th) {
            LoggerImpl.global().error(4, Collections.singletonList("trace"), "JSON handle failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.bdtracker.e4
    public String f() {
        return "trace";
    }

    @Override // com.bytedance.bdtracker.e4
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.c);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.e);
        long j = this.f;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.g) ? JSONObject.NULL : this.g);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("$user_unique_id_type", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("ssid", this.i);
        }
        jSONObject.put("event", "rangersapplog_trace");
        a(jSONObject, s);
        int i = this.k;
        if (i != j5.a.UNKNOWN.a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.n);
        return jSONObject;
    }
}
