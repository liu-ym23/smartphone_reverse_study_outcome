package com.bytedance.android.livesdk.room.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/RoomDataType;", "", "PRE_LOAD_BIND", "PRE_LOAD", "ALL_ROOM", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomDataType extends Enum<RoomDataType> {
    public static final RoomDataType ALL_ROOM = null;
    public static final RoomDataType PRE_LOAD = null;
    public static final RoomDataType PRE_LOAD_BIND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoomDataType[] f157820a = null;

    static {
        RoomDataType r100 = new RoomDataType("PRE_LOAD_BIND", 0);
        PRE_LOAD_BIND = r100;
        RoomDataType r101 = new RoomDataType("PRE_LOAD", 1);
        PRE_LOAD = r101;
        RoomDataType r102 = new RoomDataType("ALL_ROOM", 2);
        ALL_ROOM = r102;
        f157820a = new RoomDataType[]{r100, r101, r102};
    }

    public static RoomDataType valueOf(String r100) {
        return (RoomDataType) a.a(RoomDataType.class, r100);
    }

    public static RoomDataType[] values() {
        return (RoomDataType[]) f157820a.clone();
    }

    public RoomDataType(String r100, int r101) {
        super(r100, r101);
    }
}
