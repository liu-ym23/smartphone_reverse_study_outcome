package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements cf.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomParams f148638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f148639b;

    @Override // cf.t
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        LiveRoomParams r101 = this.f148638a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getFollowStatus();
    L6:
        r100.put("follow_status", r103);
        JSONObject r104 = this.f148639b;
        if (r104 == null) goto L9;
        r102 = r104.toString();
    L9:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r102);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r100.put("enter_from", "live");
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    @Override // cf.t
    public final void a(q83.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r100);
    }

    @Override // cf.t
    public final void b(q83.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r100);
    }

    public d(LiveRoomParams r100, JSONObject r101) {
        this.f148638a = r100;
        this.f148639b = r101;
    }
}
