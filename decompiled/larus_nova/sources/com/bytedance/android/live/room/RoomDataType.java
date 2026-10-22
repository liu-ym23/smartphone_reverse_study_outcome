package com.bytedance.android.live.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/RoomDataType;", "", "PRELOAD", "FULL", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomDataType extends Enum<RoomDataType> {
    public static final RoomDataType FULL = null;
    public static final RoomDataType PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoomDataType[] f98860a = null;

    static {
        RoomDataType r100 = new RoomDataType("PRELOAD", 0);
        PRELOAD = r100;
        RoomDataType r101 = new RoomDataType("FULL", 1);
        FULL = r101;
        f98860a = new RoomDataType[]{r100, r101};
    }

    public static RoomDataType valueOf(String r100) {
        return (RoomDataType) r27.a.a(RoomDataType.class, r100);
    }

    public static RoomDataType[] values() {
        return (RoomDataType[]) f98860a.clone();
    }

    public RoomDataType(String r100, int r101) {
        super(r100, r101);
    }
}
