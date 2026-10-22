package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: classes11.dex */
public final class p1 {
    public static String a(IRoom r100) {
        Room r101 = (Room) r100;
        if (r101 == null) goto L9;
        RoomViewStats r102 = r101.viewStats;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getDisplayShort();
    L9:
        return null;
    }

    public static String b(IRoom r100) {
        Room r101 = (Room) r100;
        if (r101 != null) goto L5;
    L7:
        return "0";
    L5:
        if (r101.getStats() == null) goto L7;
        return r101.getStats().getTopRightStr();
    }

    public static boolean c(IRoom r100) {
        Room r101 = (Room) r100;
        if (r101 != null) goto L6;
        return false;
    L6:
        RoomViewStats r102 = r101.viewStats;
        if (r102 != null) goto L11;
        return true;
    L11:
        return r102.isHidden();
    }
}
