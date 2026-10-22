package com.bytedance.android.livesdk.room;

import com.bytedance.android.livesdk.room.state.LiveRoomNewState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157625a = null;

    static {
        int[] r100 = new int[LiveRoomNewState.values().length];
        f157625a = r100;
        r100[LiveRoomNewState.ROOM_CONTAINER_INIT.ordinal()] = 1;
        r100[LiveRoomNewState.ROOM_CONTAINER_FINISH.ordinal()] = 2;
        r100[LiveRoomNewState.ROOM_START_ENTER_ROOM.ordinal()] = 3;
        r100[LiveRoomNewState.ROOM_BEFORE_PRE_ENTER_ROOM.ordinal()] = 4;
        r100[LiveRoomNewState.ROOM_AFTER_PRE_ENTER_ROOM.ordinal()] = 5;
        r100[LiveRoomNewState.ROOM_START_ENTER_ROOM_FINISH.ordinal()] = 6;
        r100[LiveRoomNewState.ROOM_DATA_READY.ordinal()] = 7;
        r100[LiveRoomNewState.ROOM_WIDGET_LOAD_FINISH.ordinal()] = 8;
        r100[LiveRoomNewState.ROOM_WIDGET_LOAD_START.ordinal()] = 9;
        r100[LiveRoomNewState.ROOM_STREAM_READY.ordinal()] = 10;
        r100[LiveRoomNewState.ROOM_PLAYER_BIND_FINISH.ordinal()] = 11;
        r100[LiveRoomNewState.PRELOAD_ROOM_START_STOP.ordinal()] = 12;
        r100[LiveRoomNewState.PRELOAD_ROOM_STOP_FINISH.ordinal()] = 13;
        r100[LiveRoomNewState.ROOM_START_STOP.ordinal()] = 14;
        r100[LiveRoomNewState.ROOM_STOP_ROOM_FINISH.ordinal()] = 15;
        r100[LiveRoomNewState.ROOM_CONTAINER_STATE_CHANGED.ordinal()] = 16;
        r100[LiveRoomNewState.ROOM_STATE_CHANGE.ordinal()] = 17;
        r100[LiveRoomNewState.ROOM_START_LOAD_INTERACTION.ordinal()] = 18;
    }
}
