package com.bytedance.android.livesdk.closeroom;

import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public final enum CloseRoomInterceptList extends Enum<CloseRoomInterceptList> {
    public static final CloseRoomInterceptList AUTH_REWARD = null;
    public static final CloseRoomInterceptList COIN_TASK = null;
    public static final CloseRoomInterceptList CSJ_COMMERCE = null;
    public static final CloseRoomInterceptList DEFAULT = null;
    public static final CloseRoomInterceptList EXPAND_COUPON = null;
    public static final CloseRoomInterceptList LINKING_REMAIN = null;
    public static final CloseRoomInterceptList MORE_LIVE = null;
    public static final CloseRoomInterceptList SLIDE_TASK = null;
    public static final CloseRoomInterceptList TICKET_EXPAND = null;
    public static final CloseRoomInterceptList UG_COUPON_REMAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseRoomInterceptList[] f119525a = null;

    static {
        CloseRoomInterceptList r100 = new CloseRoomInterceptList("DEFAULT", 0);
        DEFAULT = r100;
        CloseRoomInterceptList r101 = new CloseRoomInterceptList("MORE_LIVE", 1);
        MORE_LIVE = r101;
        CloseRoomInterceptList r102 = new CloseRoomInterceptList("LINKING_REMAIN", 2);
        LINKING_REMAIN = r102;
        CloseRoomInterceptList r103 = new CloseRoomInterceptList("COIN_TASK", 3);
        COIN_TASK = r103;
        CloseRoomInterceptList r104 = new CloseRoomInterceptList("SLIDE_TASK", 4);
        SLIDE_TASK = r104;
        CloseRoomInterceptList r105 = new CloseRoomInterceptList("UG_COUPON_REMAIN", 5);
        UG_COUPON_REMAIN = r105;
        CloseRoomInterceptList r110 = new CloseRoomInterceptList("EXPAND_COUPON", 6);
        EXPAND_COUPON = r110;
        CloseRoomInterceptList r111 = new CloseRoomInterceptList("CSJ_COMMERCE", 7);
        CSJ_COMMERCE = r111;
        CloseRoomInterceptList r112 = new CloseRoomInterceptList("AUTH_REWARD", 8);
        AUTH_REWARD = r112;
        CloseRoomInterceptList r113 = new CloseRoomInterceptList("TICKET_EXPAND", 9);
        TICKET_EXPAND = r113;
        f119525a = new CloseRoomInterceptList[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static CloseRoomInterceptList[] values() {
        return (CloseRoomInterceptList[]) f119525a.clone();
    }

    public static CloseRoomInterceptList valueOf(String r100) {
        return (CloseRoomInterceptList) a.a(CloseRoomInterceptList.class, r100);
    }

    public CloseRoomInterceptList(String r100, int r101) {
        super(r100, r101);
    }
}
