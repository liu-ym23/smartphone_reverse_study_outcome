package com.bytedance.android.live.browser.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements k9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.w f64291a;

    public s(com.bytedance.android.live.browser.w r100) {
        this.f64291a = r100;
    }

    @Override // k9.c
    public final void a1(String r100, JSONObject r110) {
        com.bytedance.android.live.browser.w r101 = this.f64291a;
        if (r101 == null) goto L8;
        n30.a r102 = r101.getHybridMonitor();
        if (r102 == null) goto L9;
        r102.a(null, "hybrid_state_observe_monitor", r100, null, null, r110, false);
        return;
    L9:
        return;
    }
}
