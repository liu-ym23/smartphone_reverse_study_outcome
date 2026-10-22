package com.bytedance.android.livesdk.chatroom;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILiveRoomListProvider f105565a;

    public static boolean a(Bundle r100) {
        if (com.bytedance.android.livesdk.config.m0.f120721a.getValue().enable() == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.getString("enter_method", "").equals("hourly_rank") == true) goto L23;
        if (r100.getString("enter_method", "").equals("regional_rank") == true) goto L23;
        if (r100.getString("enter_method", "").equals("anchor_recommend") == false) goto L15;
    L21:
        return true;
    L15:
        if (r100.getString("enter_method", "").equals("draw_cover") == true) goto L21;
        if (com.bytedance.android.livesdk.config.z0.f121728a.getValue().booleanValue() == true) goto L21;
        if (com.bytedance.android.livesdk.config.l0.f120642a.getValue().enableRoomNotify() == true) goto L21;
        return false;
    L23:
        return com.bytedance.android.livesdk.config.l0.f120642a.getValue().enableHourRank();
    }
}
