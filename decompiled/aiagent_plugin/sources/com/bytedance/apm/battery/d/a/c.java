package com.bytedance.apm.battery.d.a;

import com.obric.capabilitykit.common.Ext;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4297a;

    public c() {
    }

    public String toString() {
        return "LocInfo{request=" + this.f4297a + ", startTime=" + this.f4295d + ", endTime=" + this.f4296e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.f4295d);     // Catch: Throwable -> L4
        r0.put("end_time", this.f4296e);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        r0.put(Ext.KEY_REQUEST, this.f4297a);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
