package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f114471a = null;

    public g() {
    }

    static {
        f114471a = new g();
    }

    public final void a(DataCenter r100, Bundle r101) {
        if (r101 == null) goto L19;
        if (r100 == null) goto L19;
        Bundle r102 = com.bytedance.android.livesdk.chatroom.m0.a(r101);
        if (r102 == null) goto L19;
        Bundle r103 = r102.getBundle("copy_extra");
        if (Logger.debug() == false) goto L16;
        StringBuilder r104 = new StringBuilder("save:");
        if (r103 == null) goto L14;
        String r105 = r103.toString();
    L15:
        r104.append(r105);
        Logger.d("BackToRoomDataUtils", r104.toString());
        goto L16
    L14:
        r105 = "null";
    L16:
        if (r103 == null) goto L19;
        r103.remove(ILiveRoomPlayFragmentConstant.EXTRA_BACK_PRE_ROOM_EXTRA);
        r100.put("data_room_back_extra", r103);
    L19:
        if (r101 == null) goto L42;
        if (r100 == null) goto L45;
        Bundle r106 = r101.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_BACK_PRE_ROOM_EXTRA);
        if (r106 == null) goto L43;
        boolean r107 = false;
        if (r106.getBoolean("can_go_back", false) == false) goto L46;
        Bundle r108 = com.bytedance.android.livesdk.chatroom.m0.a(r101);
        if (r108 == null) goto L32;
        r107 = r108.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_BACK_PRE_ROOM_NOW, false);
    L32:
        if ("draw".equals(r101.getString("live.intent.extra.ENTER_TYPE")) == false) goto L35;
        r100.put("data_room_back", null);
    L39:
        if (r108 == null) goto L44;
        r100.put("data_back_to_pre_room_countdown_dismiss", Boolean.valueOf(r108.getBoolean("data_back_to_pre_room_countdown_dismiss", true)));
        return;
    L44:
        return;
    L35:
        if (tb1.c.f545229a == false) goto L39;
        if (r107 == false) goto L38;
        r106 = null;
    L38:
        r100.put("data_room_back", r106);
        goto L39
    L46:
        return;
    L43:
        return;
    L45:
        return;
    }
}
