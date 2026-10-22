package com.bytedance.applog.monitor.v3;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: StageEventBasic.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f5804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5805e;
    public int f;

    public h(String r9, String r10, long r11, i r13) {
        this(null, -1, r9, r10, r11, r13);
    }

    public h(JSONObject r10) {
        this(r10.optString("priority_name"), r10.optInt("group_id", -1), r10.optString("event_name"), r10.optString("monitor_id"), r10.optLong("local_time_ms"), i.a(r10.optString("type")));
    }

    public h(String r2, int r3, String r4, String r5, long r6, i r8) {
        this.f = -1;
        this.f5805e = r2;
        this.f = r3;
        this.f5801a = r4;
        this.f5802b = r5;
        this.f5803c = r6;
        this.f5804d = r8;
    }

    public void a(h r5) {
        if (TextUtils.equals(this.f5802b, r5.f5802b) == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f5805e) == false) goto L11;
        if (TextUtils.isEmpty(r5.f5805e) == true) goto L11;
        this.f5805e = r5.f5805e;
    L11:
        if (this.f >= 0) goto L16;
        int r0 = r5.f;
        if (r0 < 0) goto L16;
        this.f = r0;
    L16:
        if (TextUtils.isEmpty(this.f5801a) == false) goto L21;
        if (TextUtils.isEmpty(r5.f5801a) == true) goto L21;
        this.f5801a = r5.f5801a;
    L21:
        if (this.f5803c > 0) goto L26;
        long r1 = r5.f5803c;
        if (r1 <= 0) goto L26;
        this.f5803c = r1;
    L26:
        if (this.f5804d != null) goto L31;
        i r6 = r5.f5804d;
        if (r6 == null) goto L32;
        this.f5804d = r6;
        return;
    L32:
        return;
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("event_name", this.f5801a);     // Catch: Throwable -> L18
        r0.put("monitor_id", this.f5802b);     // Catch: Throwable -> L18
        i r1 = this.f5804d;     // Catch: Throwable -> L18
        if (r1 == null) goto L6;
        r0.put("type", r1.name());     // Catch: Throwable -> L18
    L6:
        long r2 = this.f5803c;     // Catch: Throwable -> L18
        if (r2 <= 0) goto L9;
        r0.put("local_time_ms", r2);     // Catch: Throwable -> L18
    L9:
        String r3 = this.f5805e;     // Catch: Throwable -> L18
        if (r3 != null) goto L12;
    L14:
        int r5 = this.f;     // Catch: Throwable -> L18
        if (r5 < 0) goto L17;
        r0.put("group_id", r5);     // Catch: Throwable -> L18
        goto L17
    L12:
        if (r3.isEmpty() == true) goto L14;
        r0.put("priority_name", this.f5805e);     // Catch: Throwable -> L18
    L17:
        return r0;
    }
}
