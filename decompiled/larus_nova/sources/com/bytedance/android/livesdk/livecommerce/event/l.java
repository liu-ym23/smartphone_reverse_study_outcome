package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends u0 {
    public l(String r100, RoomContextController r101) {
        Intrinsics.checkNotNullParameter(r100, "trackName");
        super(r101, "livesdk_" + r100 + "_click");
    }
}
