package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum RoomTag extends Enum<RoomTag> {
    private static final /* synthetic */ RoomTag[] $VALUES = null;
    public static final RoomTag SCREEN_SHOT = null;

    @SerializedName("roomTag")
    public final String roomTag;

    static {
        RoomTag r100 = new RoomTag("SCREEN_SHOT", 0, "screen_shot");
        SCREEN_SHOT = r100;
        $VALUES = new RoomTag[]{r100};
    }

    public static RoomTag[] values() {
        return (RoomTag[]) $VALUES.clone();
    }

    public static RoomTag valueOf(String r100) {
        return (RoomTag) a.a(RoomTag.class, r100);
    }

    private RoomTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.roomTag = r102;
    }
}
