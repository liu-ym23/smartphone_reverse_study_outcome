package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class w extends c0 {
    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
        JSONObject r100 = new JSONObject();
        r100.put("anchorId", y());
        r100.put("roomId", B());
        Lazy r101 = LiveEventCenter.f147750b;
        LiveEventCenter.a.a().sendEvent("enter_room", r100);
        int r102 = ECSdk.f48106a;
        b93.c r103 = (b93.c) ECSdk.a(b93.c.class);
        if (r103 == null) goto L8;
        b93.b r104 = r103.b();
        if (r104 == null) goto L9;
        r104.sendEvent("enter_room", r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        JSONObject r100 = new JSONObject();
        r100.put("anchorId", y());
        r100.put("roomId", B());
        Lazy r101 = LiveEventCenter.f147750b;
        LiveEventCenter.a.a().sendEvent(ListenLiveStatus.END_EXIT_ROOM, r100);
        int r102 = ECSdk.f48106a;
        b93.c r103 = (b93.c) ECSdk.a(b93.c.class);
        if (r103 == null) goto L8;
        b93.b r104 = r103.b();
        if (r104 == null) goto L9;
        r104.sendEvent(ListenLiveStatus.END_EXIT_ROOM, r100);
        return;
    L9:
        return;
    }

    public w(RealRoomController$roomResources$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        super(r100);
    }
}
