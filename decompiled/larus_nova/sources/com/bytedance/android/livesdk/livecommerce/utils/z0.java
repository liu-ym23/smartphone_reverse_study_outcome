package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class z0 extends a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f153128c;

    public z0(boolean r100, boolean r101) {
        super(NewBroadcastMonitor.STAGE.TOOLBAR);
        this.f153128c = r100;
        JSONObject r102 = this.f153061a;
        if (r100 == false) goto L5;
        String r103 = "show";
    L6:
        r102.put("callback_type", r103);
        r102.put("on_enter", r101 ? 1 : 0);
        return;
    L5:
        r103 = "hide";
        goto L6
    }
}
