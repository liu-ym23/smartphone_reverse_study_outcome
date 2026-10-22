package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f139364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f139365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f139366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f139367d;

    public final void a() {
        if (this.f139366c > 0) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f139366c;
        JSONObject r101 = new JSONObject();
        r101.put("use_preload_v3", r42.g.c());
        r101.put("use_self_api", true);
        r101.put("history_fetch_success", this.f139364a);
        String r102 = this.f139365b;
        if (r102 == null) goto L8;
        r101.put("history_fetch_failed_reason", r102);
    L8:
        JSONObject r103 = new JSONObject();
        r103.put("use_time", r100);
        JSONObject r110 = new JSONObject();
        r110.put("room_id", this.f139367d);
        LiveTracingMonitor.k("ttlive_public_screen_first_fetch_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r100, r101, r103, r110);
    }

    public a(long r100) {
        this.f139367d = r100;
    }
}
