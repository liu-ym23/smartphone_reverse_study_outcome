package com.bytedance.android.live.gift;

import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final enum GiftType extends Enum<GiftType> {
    public static final GiftType BLIND_BOX = null;
    public static final GiftType FREE_CELL = null;
    public static final GiftType GAME = null;
    public static final GiftType GOLDEN_BEAN_CELL = null;
    public static final GiftType INTERACT_GIFT = null;
    public static final GiftType MEMBER_GIFT = null;
    public static final GiftType MIDDLE_GIFT = null;
    public static final GiftType MULTI_INTERACT = null;
    public static final GiftType NORMAL_GIFT = null;
    public static final GiftType SPECIAL_GIFT = null;
    public static final GiftType STICKER_GIFT = null;
    public static final GiftType TASK_GIFT = null;
    public static final GiftType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftType[] f69003a = null;

    static {
        GiftType r100 = new GiftType("UNKNOWN", 0);
        UNKNOWN = r100;
        GiftType r101 = new GiftType("NORMAL_GIFT", 1);
        NORMAL_GIFT = r101;
        GiftType r102 = new GiftType("TASK_GIFT", 2);
        TASK_GIFT = r102;
        GiftType r103 = new GiftType("STICKER_GIFT", 3);
        STICKER_GIFT = r103;
        GiftType r104 = new GiftType("MIDDLE_GIFT", 4);
        MIDDLE_GIFT = r104;
        GiftType r105 = new GiftType("SPECIAL_GIFT", 5);
        SPECIAL_GIFT = r105;
        GiftType r110 = new GiftType("FREE_CELL", 6);
        FREE_CELL = r110;
        GiftType r111 = new GiftType("GOLDEN_BEAN_CELL", 7);
        GOLDEN_BEAN_CELL = r111;
        GiftType r112 = new GiftType("GAME", 8);
        GAME = r112;
        GiftType r113 = new GiftType("BLIND_BOX", 9);
        BLIND_BOX = r113;
        GiftType r114 = new GiftType("INTERACT_GIFT", 10);
        INTERACT_GIFT = r114;
        GiftType r115 = new GiftType("MULTI_INTERACT", 11);
        MULTI_INTERACT = r115;
        GiftType r106 = new GiftType("MEMBER_GIFT", 12);
        MEMBER_GIFT = r106;
        f69003a = new GiftType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static GiftType[] values() {
        return (GiftType[]) f69003a.clone();
    }

    public static GiftType valueOf(String r100) {
        return (GiftType) a.a(GiftType.class, r100);
    }

    public GiftType(String r100, int r101) {
        super(r100, r101);
    }
}
