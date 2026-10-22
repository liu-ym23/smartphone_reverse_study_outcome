package com.bytedance.android.livesdkapi.depend.live;

import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveBackRoomStack {
    public static final String JUMP_SOURCE_ALL = "all";
    public static final String JUMP_SOURCE_DAILY_RANK = "daily_rank";
    public static final String JUMP_SOURCE_LIVE_CHALLENGE = "live_challenge";
    public static final String JUMP_SOURCE_MIC_ROOM = "jump_source_mic_room";
    public static final String JUMP_SOURCE_ROOM_BACK = "room_back";
    public static final String JUMP_SOURCE_ROOM_NOTIFY = "room_notify";
    public static final String JUMP_SOURCE_SQUARE_DRAWER = "square_drawer";

    Bundle peekRoomInfo();

    Bundle popRoomInfo();

    void saveRoomInfo(long r100, String r101, Bundle r102);
}
