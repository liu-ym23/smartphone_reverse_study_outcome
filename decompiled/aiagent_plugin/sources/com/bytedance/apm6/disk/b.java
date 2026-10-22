package com.bytedance.apm6.disk;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.util.e;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiskReportEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm6.perf.base.model.a {
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private double n;
    private JSONArray o;
    private JSONArray p;
    private JSONArray q;
    private JSONArray r;
    private int s;

    @Override // com.bytedance.apm6.perf.base.model.a
    public String a() {
        return "disk";
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return true;
    }

    public b(long r4, long r6, long r8, long r10, long r12, long r14, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.s = 262144;
        this.g = r4;
        this.h = r6;
        this.i = r8;
        this.j = r10;
        this.k = r12;
        this.l = r14;
        this.m = r16;
        this.n = r18;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        long r1 = this.g;     // Catch: Exception -> L28
        if (r1 <= 0) goto L6;
        r0.put("data", r1);     // Catch: Exception -> L28
    L6:
        long r2 = this.h;     // Catch: Exception -> L28
        if (r2 <= 0) goto L9;
        r0.put("cache", r2);     // Catch: Exception -> L28
    L9:
        long r3 = this.i;     // Catch: Exception -> L28
        if (r3 <= 0) goto L12;
        r0.put("total", r3);     // Catch: Exception -> L28
    L12:
        long r4 = this.j;     // Catch: Exception -> L28
        if (r4 <= 0) goto L15;
        r0.put("rom_free", r4);     // Catch: Exception -> L28
    L15:
        long r5 = this.k;     // Catch: Exception -> L28
        if (r5 <= 0) goto L18;
        r0.put("app_usage", r5);     // Catch: Exception -> L28
    L18:
        long r6 = this.l;     // Catch: Exception -> L28
        if (r6 <= 0) goto L21;
        r0.put("total_capacity", r6);     // Catch: Exception -> L28
    L21:
        long r7 = this.m;     // Catch: Exception -> L28
        if (r7 <= 0) goto L24;
        r0.put("free_capacity", r7);     // Catch: Exception -> L28
    L24:
        double r8 = this.n;     // Catch: Exception -> L28
        if (r8 <= 0.0d) goto L27;
        r0.put("app_occupied_rate", r8);     // Catch: Exception -> L28
    L27:
        return r0;
    }

    private static long a(JSONArray r2) {
        return r2.toString().getBytes("UTF-8").length;
    L5:
        return 0;
    }

    private JSONArray b(JSONArray r7) {
        if (r7 == null) goto L4;
        int r0 = 102400;
        int r1 = 0;
    L7:
        if (a(r7) <= this.s) goto L12;
        if (r1 > 10) goto L12;
        r7 = a(r7, r0);     // Catch: JSONException -> L13
    L11:
        r0 = r0 * 2;
        r1 = r1 + 1;
    L12:
        return r7;
    L4:
        return new JSONArray();
    }

    private JSONArray a(JSONArray r8, int r9) {
        JSONArray r0 = new JSONArray();
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L16;
        JSONObject r2 = r8.getJSONObject(r1);
        if (r2.getLong(MonitorConstants.SIZE) < r9) goto L15;
        JSONArray r4 = r2.optJSONArray("next_disk");
        if (r4 == null) goto L14;
        JSONArray r5 = a(r4, r9);
        if (r5.length() <= 0) goto L13;
        r2.put("next_disk", r5);
        goto L14
    L13:
        r2.remove("next_disk");
    L14:
        r0.put(r2);
    L15:
        r1 = r1 + 1;
        goto L4
    L16:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject e() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = this.o;     // Catch: Exception -> L20
        if (r1 == null) goto L6;
        r0.put("top_usage", r1);     // Catch: Exception -> L20
    L6:
        JSONArray r2 = this.p;     // Catch: Exception -> L20
        if (r2 == null) goto L9;
        r0.put("exception_folders", r2);     // Catch: Exception -> L20
    L9:
        JSONArray r3 = this.q;     // Catch: Exception -> L20
        if (r3 == null) goto L13;
        r0.put("outdated_files", r3);     // Catch: Exception -> L20
    L13:
        if (this.r == null) goto L18;
        int r4 = 0;
        r4 = r0.toString().getBytes("UTF-8").length;     // Catch: Exception -> L19
    L17:
        this.s = (262144 - r4) - 12288;     // Catch: Exception -> L20
        JSONArray r5 = b(this.r);     // Catch: Exception -> L20
        this.r = r5;     // Catch: Exception -> L20
        r0.put("disk_info", r5);     // Catch: Exception -> L20
    L18:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject c() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put(DBHelper.BATTERY_COL_SCENE, com.bytedance.apm6.perf.base.c.a().b());     // Catch: Throwable -> L4
        r2.put("process_name", com.bytedance.apm6.foundation.context.a.f());     // Catch: Throwable -> L4
        r2.put("is_front", false);     // Catch: Throwable -> L4
        r2.put("is_main_process", com.bytedance.apm6.foundation.context.a.e());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject d() {
        JSONObject r1 = com.bytedance.apm6.perf.base.c.a().c();
        e.a(r1, com.bytedance.apm6.perf.base.c.a().d());     // Catch: Exception -> L5
    L4:
        return r1;
    }
}
