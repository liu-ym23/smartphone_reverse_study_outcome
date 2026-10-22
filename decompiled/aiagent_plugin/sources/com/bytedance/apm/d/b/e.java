package com.bytedance.apm.d.b;

import android.text.TextUtils;
import com.bytedance.apm.util.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfData.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f4561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f4562e;
    public JSONObject f;
    public JSONObject g;

    @Override // com.bytedance.apm.d.b
    public String b() {
        return "performance_monitor";
    }

    @Override // com.bytedance.apm.d.b
    public boolean d() {
        return true;
    }

    public e() {
    }

    public e a(String r1) {
        this.f4558a = r1;
        return this;
    }

    public e b(JSONObject r1) {
        this.f4561d = r1;
        return this;
    }

    public e c(JSONObject r1) {
        this.f4562e = r1;
        return this;
    }

    public e d(JSONObject r1) {
        this.f = r1;
        return this;
    }

    public e e(JSONObject r1) {
        this.g = r1;
        return this;
    }

    public e(String r1, String r2, boolean r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f4558a = r1;
        this.f4559b = r2;
        this.f4560c = r3;
        this.f4561d = r4;
        this.f4562e = r5;
        this.g = r6;
    }

    public e(String r8, String r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        this(r8, r9, false, r10, r11, r12);
    }

    public e(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        this(r8, "", false, r9, r10, r11);
    }

    @Override // com.bytedance.apm.d.b
    public JSONObject a() {
    L24:
        return null;
    L3:
        if (this.g != null) goto L5;
        this.g = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.g.put("log_type", "performance_monitor");     // Catch: JSONException -> L24
        this.g.put(WsConstants.KEY_SERVICE, this.f4558a);     // Catch: JSONException -> L24
        if (i.c(this.f4561d) == true) goto L9;
        this.g.put("extra_values", this.f4561d);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.f4558a) == false) goto L17;
        if (TextUtils.equals("from", this.g.optString("monitor-plugin")) == false) goto L17;
        if (this.f4562e != null) goto L15;
        this.f4562e = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f4562e.put("start_mode", com.bytedance.apm.c.h());     // Catch: JSONException -> L24
    L17:
        if (i.c(this.f4562e) == true) goto L20;
        this.g.put("extra_status", this.f4562e);     // Catch: JSONException -> L24
    L20:
        if (i.c(this.f) == true) goto L22;
        this.g.put("filters", this.f);     // Catch: JSONException -> L24
    L22:
        return this.g;
    }

    @Override // com.bytedance.apm.d.b
    public boolean a(JSONObject r5) {
        if ("fps".equals(this.f4558a) == false) goto L5;
    L34:
        boolean r6 = com.bytedance.apm.m.c.a(this.f4558a, this.f4559b);
    L36:
        if (this.f4560c == true) goto L39;
        if (r6 == true) goto L39;
        return false;
    L39:
        return true;
    L5:
        if ("fps_drop".equals(this.f4558a) == true) goto L34;
        if ("temperature".equals(this.f4558a) == false) goto L11;
        r6 = com.bytedance.apm.m.c.e(this.f4558a);
        goto L36
    L11:
        if (Scraps.BATTERY.equals(this.f4558a) == false) goto L14;
    L12:
        r6 = true;
        goto L36
    L14:
        if ("start".equals(this.f4558a) == false) goto L22;
        if (com.bytedance.apm.m.c.d(this.f4558a) == true) goto L12;
        if (com.bytedance.apm.m.c.c(this.f4559b) == true) goto L12;
        r6 = false;
        goto L36
    L22:
        if ("start_trace".equals(this.f4558a) == false) goto L33;
        if (r5 != null) goto L25;
    L32:
        r6 = com.bytedance.apm.m.c.d(this.f4558a);
        goto L36
    L25:
        if (com.bytedance.apm.m.c.e("enable_perf_data_collect") == true) goto L28;
        r5.remove("perf_data");
    L28:
        if (com.bytedance.apm.m.c.d(this.f4558a) == true) goto L32;
        JSONObject r7 = r5.optJSONObject("trace");
        if (r7 == null) goto L32;
        r7.remove("spans");
        goto L32
    L33:
        r6 = com.bytedance.apm.m.c.d(this.f4558a);
        goto L36
    }

    @Override // com.bytedance.apm.d.b
    public String c() {
        return this.f4558a;
    }

    public boolean e() {
        return TextUtils.equals(this.f4558a, "memory");
    }
}
