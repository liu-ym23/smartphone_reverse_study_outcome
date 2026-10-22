package com.baidu.mapapi.map;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes39.dex */
public final enum EncodePointType extends Enum<EncodePointType> {
    public static final EncodePointType AOI = null;
    public static final EncodePointType BUILDINGINFO = null;
    public static final EncodePointType NONE = null;
    public static final EncodePointType RECOGNIZE_AOI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ EncodePointType[] f30868a = null;

    static {
        EncodePointType r100 = new EncodePointType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        EncodePointType r101 = new EncodePointType("BUILDINGINFO", 1);
        BUILDINGINFO = r101;
        EncodePointType r102 = new EncodePointType("AOI", 2);
        AOI = r102;
        EncodePointType r103 = new EncodePointType("RECOGNIZE_AOI", 3);
        RECOGNIZE_AOI = r103;
        f30868a = new EncodePointType[]{r100, r101, r102, r103};
    }

    public static EncodePointType[] values() {
        return (EncodePointType[]) f30868a.clone();
    }

    public static EncodePointType valueOf(String r100) {
        return (EncodePointType) r27.a.a(EncodePointType.class, r100);
    }

    private EncodePointType(String r100, int r101) {
        super(r100, r101);
    }
}
