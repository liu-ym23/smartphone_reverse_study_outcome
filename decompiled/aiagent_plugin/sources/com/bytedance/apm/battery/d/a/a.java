package com.bytedance.apm.battery.d.a;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlarmInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4294c;

    public a() {
    }

    public long a() {
        int r0 = this.f4292a;
        if (r0 == 1) goto L9;
        if (r0 == 0) goto L9;
        return (this.f4295d + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.f4295d;
    }

    public boolean b() {
        int r1 = this.f4292a;
        if (r1 == 2) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.f4292a + ", interval=" + this.f4293b + ", intentInfo=" + this.f4294c + ", startTime=" + this.f4295d + ", endTime=" + this.f4296e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.f4295d);     // Catch: Throwable -> L4
        r0.put("end_time", this.f4296e);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        r0.put("interval", this.f4293b);     // Catch: Throwable -> L4
        r0.put("type", this.f4292a);     // Catch: Throwable -> L4
        r0.put("intent_info", this.f4294c);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
