package com.bytedance.android.gamecp.common.monitor;

import bw.k;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import yr.b;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f56540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveTracingMonitor.EventModule f56541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f56542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f56543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f56544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56548i;

    public final void a() {
        if (this.f56545f == false) goto L6;
        HashMap r100 = new HashMap();
        r100.put("service_name", this.f56540a);
        b(this.f56543d, r100);
        b(this.f56544e, r100);
        b(this.f56542c, r100);
        b.b(4, LiveMonitor.ALOG_TAG, r100.toString());
    L6:
        if (this.f56547h == true) goto L11;
        if (cs.a.a() == false) goto L11;
        return;
    L11:
        if (this.f56542c != null) goto L14;
        this.f56542c = new JSONObject();
    L14:
        if (this.f56548i == false) goto L47;
        JSONObject r101 = new JSONObject();
        JSONObject r102 = this.f56543d;
        int r103 = 0;
        if (r102 == null) goto L54;
        r103 = r102.optInt("status_code", 0);
    L54:
        r101.put("status", r103);     // Catch: JSONException -> L21
    L23:
        JSONObject r104 = this.f56544e;
        long r105 = -1;
        if (r104 == null) goto L28;
        r105 = r104.optLong("latency", -1);
    L28:
        if (r105 <= 0) goto L38;
        JSONObject r106 = new JSONObject();
        r106.put("duration", r105);     // Catch: JSONException -> L32
    L58:
        r101.put("value", r106);     // Catch: JSONException -> L36
        r101.put("extra", this.f56542c);     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        String r107 = this.f56540a;
        JSONObject r108 = this.f56543d;
        JSONObject r109 = this.f56544e;
        if (com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService() == null) goto L49;
        if (r107.startsWith("ttlive_") == true) goto L44;
        r107 = "ttlive_".concat(r107);
    L44:
        LiveTracingMonitor.d(r101, "tag", "ttlive_sdk");
        LiveTracingMonitor.d(r101, "ttlive_sdk_version", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveSdkVersion());
        k r110 = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();
        if (r110 == null) goto L49;
        r110.monitorEvent(r107, r108, r109, r101);
    L49:
        if (this.f56546g == true) goto L51;
        return;
    L51:
        if (cs.a.a() == false) goto L61;
        Objects.toString(this.f56543d);
        Objects.toString(this.f56542c);
        Objects.toString(this.f56541b);
        Objects.toString(this.f56544e);
        return;
    L61:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L47:
        LiveTracingMonitor.a(this.f56540a, this.f56541b, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.f56543d, this.f56544e, this.f56542c);
        goto L49
    }

    public a() {
    }

    public static void b(JSONObject r100, Map r101) {
        if (r100 == null) goto L10;
        Iterator<String> r102 = r100.keys();
    L5:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        ((HashMap) r101).put(r103, r104);
        goto L5
    L14:
        return;
    }
}
