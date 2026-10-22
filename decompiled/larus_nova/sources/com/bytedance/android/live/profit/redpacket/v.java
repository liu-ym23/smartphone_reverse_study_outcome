package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Action;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class v implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f88762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zy0.c f88763b;

    public v(JSONObject r100, zy0.b r101) {
        this.f88762a = r100;
        this.f88763b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f88762a.put("count_down", 0);
        xy0.a<?> r100 = this.f88763b.g();
        if (r100 == null) goto L5;
        r100.sendJsEvent("H5_webcastNotification", this.f88762a);
    L5:
        int r101 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", "anim native is ready, ts: " + System.currentTimeMillis());
    }
}
