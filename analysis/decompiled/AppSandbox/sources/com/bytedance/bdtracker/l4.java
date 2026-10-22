package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.bdtracker.j5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l4 extends e4 {
    public String s;
    public boolean t;
    public String u;

    public l4() {
    }

    public l4(String str) {
        this.u = str;
    }

    public l4(String str, String str2, boolean z, String str3) {
        this.m = str;
        this.u = str2;
        this.t = z;
        this.s = str3;
        this.l = 0;
    }

    public l4(String str, String str2, boolean z, String str3, int i) {
        this.m = str;
        this.u = str2;
        this.t = z;
        this.s = str3;
        this.l = i;
    }

    public l4(String str, JSONObject jSONObject) {
        this.u = str;
        this.o = jSONObject;
    }

    public l4(String str, boolean z) {
        this.u = str;
        this.t = z;
    }

    @Override // com.bytedance.bdtracker.e4
    public int a(Cursor cursor) {
        super.a(cursor);
        this.u = cursor.getString(14);
        this.s = cursor.getString(15);
        this.t = cursor.getInt(16) == 1;
        return 17;
    }

    @Override // com.bytedance.bdtracker.e4
    public e4 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.u = jSONObject.optString("event", null);
        this.s = jSONObject.optString(MetricsSQLiteCacheKt.METRICS_PARAMS, null);
        this.t = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.bytedance.bdtracker.e4
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList("event", "varchar", MetricsSQLiteCacheKt.METRICS_PARAMS, "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("event", this.u);
        if (this.t && this.s == null) {
            try {
                k();
            } catch (Throwable th) {
                d().error(4, this.a, "Fill params failed", th, new Object[0]);
            }
        }
        contentValues.put(MetricsSQLiteCacheKt.METRICS_PARAMS, this.s);
        contentValues.put("is_bav", Integer.valueOf(this.t ? 1 : 0));
    }

    @Override // com.bytedance.bdtracker.e4
    public void b(JSONObject jSONObject) throws JSONException {
        super.b(jSONObject);
        jSONObject.put("event", this.u);
        if (this.t && this.s == null) {
            k();
        }
        jSONObject.put(MetricsSQLiteCacheKt.METRICS_PARAMS, this.s);
        jSONObject.put("is_bav", this.t);
    }

    @Override // com.bytedance.bdtracker.e4
    public String c() {
        return this.u;
    }

    @Override // com.bytedance.bdtracker.e4
    public String e() {
        return this.s;
    }

    @Override // com.bytedance.bdtracker.e4
    public String f() {
        return "eventv3";
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
        jSONObject.put("event", this.u);
        if (this.t) {
            jSONObject.put("is_bav", 1);
        }
        if (this.t && this.s == null) {
            k();
        }
        a(jSONObject, this.s);
        int i = this.k;
        if (i != j5.a.UNKNOWN.a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.n);
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        return jSONObject;
    }

    public void k() {
    }
}
