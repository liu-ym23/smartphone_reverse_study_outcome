package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b6 {
    public final String a;
    public final String b;
    public final Boolean c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;

    public b6(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.a = str;
        this.b = str2;
        this.c = bool;
        this.d = l;
        this.e = l2;
        this.f = num;
        this.g = l3;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        a6.a(map, "id", this.a);
        a6.a(map, "req_id", this.b);
        a6.a(map, "is_track_limited", String.valueOf(this.c));
        a6.a(map, "take_ms", String.valueOf(this.d));
        a6.a(map, "time", String.valueOf(this.e));
        a6.a(map, "query_times", String.valueOf(this.f));
        a6.a(map, "hw_id_version_code", String.valueOf(this.g));
        return map;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a6.a(jSONObject, "id", this.a);
        a6.a(jSONObject, "req_id", this.b);
        a6.a(jSONObject, "is_track_limited", this.c);
        a6.a(jSONObject, "take_ms", this.d);
        a6.a(jSONObject, "time", this.e);
        a6.a(jSONObject, "query_times", this.f);
        a6.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
