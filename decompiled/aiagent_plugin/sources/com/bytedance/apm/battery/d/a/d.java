package com.bytedance.apm.battery.d.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: WakeLockInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4299b;

    public d() {
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.f4298a + ", tag=" + this.f4299b + ", startTime=" + this.f4295d + ", endTime=" + this.f4296e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("flags", this.f4298a);     // Catch: Throwable -> L4
        r0.put("tag", this.f4299b);     // Catch: Throwable -> L4
        r0.put("start_time", this.f4295d);     // Catch: Throwable -> L4
        r0.put("end_time", this.f4296e);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
