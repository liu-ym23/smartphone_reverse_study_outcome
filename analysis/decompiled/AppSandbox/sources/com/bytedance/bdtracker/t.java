package com.bytedance.bdtracker;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class t implements b.h {
    public final /* synthetic */ o4 a;

    public t(o4 o4Var) {
        this.a = o4Var;
    }

    @Override // com.bytedance.bdtracker.b.h
    public e4 a() {
        o4 o4Var = (o4) this.a.m321clone();
        JSONObject jSONObjectOptJSONObject = o4Var.h().optJSONObject(MetricsSQLiteCacheKt.METRICS_PARAMS);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        try {
            jSONObjectOptJSONObject.put("$page_duration", o4Var.s);
        } catch (Throwable th) {
            LoggerImpl.global().error("[Navigator] JSON handle failed", th, new Object[0]);
        }
        l4 l4Var = new l4("$bav2b_page_leave");
        l4Var.a(0L);
        l4Var.o = jSONObjectOptJSONObject;
        return l4Var;
    }
}
