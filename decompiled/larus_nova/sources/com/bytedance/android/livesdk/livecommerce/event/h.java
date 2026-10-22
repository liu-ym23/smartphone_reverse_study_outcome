package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends ECEventV3 {
    public h(String r100, String r101, RoomContextController r102) {
        Intrinsics.checkNotNullParameter(r100, "apiPath");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "controller");
        super(r102, "livesdk_api_request_success_event");
        f("api_path", r100);
        f("room_id", r101);
    }
}
