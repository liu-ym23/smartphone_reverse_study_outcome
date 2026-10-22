package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f97123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f97124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f97125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f97126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f97127e;

    public final void b() {
        if (this.f97124b != 0) goto L5;
        return;
    L5:
        if (this.f97125c == 0) goto L13;
        long r100 = System.currentTimeMillis();
        this.f97126d = r100;
        this.f97123a.put("draw_time", r100 - this.f97125c);
        long r101 = this.f97126d - this.f97124b;
        if (this.f97127e != 0) goto L12;
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_pk_performance_fetch_invite_list_time", 0, r101, this.f97123a);
        this.f97124b = 0;
        this.f97125c = 0;
        return;
    L12:
        return;
    }

    public m() {
        this.f97123a = new JSONObject();
    }

    public final void c() {
        this.f97124b = System.currentTimeMillis();
    }

    public final void a(int r100) {
        long r101 = System.currentTimeMillis();
        this.f97125c = r101;
        long r102 = this.f97124b;
        if (r102 != 0) goto L5;
        return;
    L5:
        this.f97123a.put("reqeust_time", r101 - r102);
        this.f97127e = r100;
        if (r100 != 1) goto L9;
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_pk_performance_fetch_invite_list_time", 1, this.f97123a);
        this.f97124b = 0;
        return;
    }
}
