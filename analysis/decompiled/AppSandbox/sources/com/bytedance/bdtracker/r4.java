package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r4 extends e4 {
    public long s;
    public long t;
    public String u;

    @Override // com.bytedance.bdtracker.e4
    public e4 a(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
        return this;
    }

    @Override // com.bytedance.bdtracker.e4
    public List<String> b() {
        return null;
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(ContentValues contentValues) {
        d().error(4, this.a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.bdtracker.e4
    public String c() {
        return String.valueOf(this.s);
    }

    @Override // com.bytedance.bdtracker.e4
    public String f() {
        return "terminate";
    }

    @Override // com.bytedance.bdtracker.e4
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.c);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.e);
        jSONObject.put("stop_timestamp", this.t / 1000);
        jSONObject.put("duration", this.s / 1000);
        jSONObject.put("datetime", this.n);
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
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        if (!TextUtils.isEmpty(this.u)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.u, this.e)) {
                jSONObject.put("original_session_id", this.u);
            }
        }
        return jSONObject;
    }
}
