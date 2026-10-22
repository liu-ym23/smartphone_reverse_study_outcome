package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f61062a = 0;

    static {
    }

    public static GameCastStrategy a(boolean r100, DataCenter r101) {
        GameCastStrategy r102 = GameCastStrategy.NONE;
        if (r100 == false) goto L18;
        if (r101 == null) goto L21;
        int r103 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a();
        if (r103 == SupportLiveScene.VIDEO_SINGLE_BROADCAST.getValue()) goto L17;
        if (r103 == SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue()) goto L17;
        if (r103 == SupportLiveScene.VIDEO_LINK_ROOM.getValue()) goto L17;
        if (r103 == SupportLiveScene.VIDEO_CHAT_ROOM.getValue()) goto L20;
        return r102;
    L20:
        return GameCastStrategy.VIDEO_CHATROOM;
    L17:
        return GameCastStrategy.VIDEO_SINGLE;
    L21:
        return r102;
    L18:
        return r102;
    }
}
