package com.bytedance.apm6.perf.base.model;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.monitor.b;
import com.bytedance.apm6.perf.base.c;
import com.bytedance.apm6.util.e;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfBaseEvent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f5439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f5440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f5441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f5442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f5443e;
    protected final String f;
    private JSONObject g;

    public abstract String a();

    public abstract JSONObject b();

    public abstract JSONObject d();

    @Override // com.bytedance.apm6.monitor.b
    public String g() {
        return "performance_monitor";
    }

    public a() {
        this.f5439a = "log_type";
        this.f5440b = "extra_status";
        this.f5441c = "extra_values";
        this.f5442d = "filters";
        this.f5443e = WsConstants.KEY_SERVICE;
        this.f = DBHelper.BATTERY_COL_SCENE;
    }

    @Override // com.bytedance.apm6.monitor.b
    public JSONObject i() {
    L16:
        return null;
    L3:
        if (this.g != null) goto L5;
        this.g = e();     // Catch: JSONException -> L16
    L5:
        this.g.put("log_type", "performance_monitor");     // Catch: JSONException -> L16
        this.g.put(WsConstants.KEY_SERVICE, a());     // Catch: JSONException -> L16
        JSONObject r0 = b();     // Catch: JSONException -> L16
        if (e.a(r0) == true) goto L8;
        this.g.put("extra_values", r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = c();     // Catch: JSONException -> L16
        if (e.a(r1) == true) goto L11;
        this.g.put("extra_status", r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = d();     // Catch: JSONException -> L16
        if (e.a(r2) == true) goto L14;
        this.g.put("filters", r2);     // Catch: JSONException -> L16
    L14:
        return this.g;
    }

    public JSONObject e() {
        return new JSONObject();
    }

    public JSONObject c() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put(DBHelper.BATTERY_COL_SCENE, c.a().b());     // Catch: Throwable -> L4
        r2.put("process_name", com.bytedance.apm6.foundation.context.a.f());     // Catch: Throwable -> L4
        r2.put("is_main_process", com.bytedance.apm6.foundation.context.a.e());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }
}
