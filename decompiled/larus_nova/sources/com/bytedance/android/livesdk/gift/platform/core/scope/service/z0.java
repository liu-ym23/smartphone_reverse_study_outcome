package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f131862a;

    public z0(a1 r100) {
        this.f131862a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r102, "data_link_state") == false) goto L13;
        int r103 = ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).Qc().j(((Integer) this.f131862a.f131450c.get("data_link_state", 0)).intValue());
        if (this.f131862a.f131449b == r103) goto L11;
        JSONObject r104 = new JSONObject();
        r104.put("eventName", "live_gift_common_interactive_scene_change");
        r104.put("roomScene", a1.c());
        r104.put("interactiveScene", r103);
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).sendEventToAllJsBridges("H5_webcastNotification", r104);
    L11:
        this.f131862a.f131449b = r103;
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
