package com.bytedance.android.livesdk.gift.platform.business;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/GiftPluginType;", "", "TYPE_BANNER", "TYPE_RED_PACKET", "TYPE_POPULAR_BOX", "TYPE_GIFT_RELAY", "TYPE_PROP_POPULAR_CARD", "TYPE_GIFT_DOODLE", "TYPE_GAME_GIFT", "TYPE_BLIND_BOX", "TYPE_PERIOD_CARD", "TYPE_DEFAULT_BANNER", "TYPE_LYNX_BANNER", "TYPE_FAST_GIFT", "TYPE_AIRDROP_GIFT", "TYPE_INTERACT_GIFT", "TYPE_BIG_GIFT", "TYPE_MSGBOARD_GIFT", "TYPE_GOODS", "TYPE_DS", "TYPE_PK_PROP", "TYPE_RECHARGE_COUPON", "DEFAULT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPluginType extends Enum<GiftPluginType> {
    public static final GiftPluginType DEFAULT = null;
    public static final GiftPluginType TYPE_AIRDROP_GIFT = null;
    public static final GiftPluginType TYPE_BANNER = null;
    public static final GiftPluginType TYPE_BIG_GIFT = null;
    public static final GiftPluginType TYPE_BLIND_BOX = null;
    public static final GiftPluginType TYPE_DEFAULT_BANNER = null;
    public static final GiftPluginType TYPE_DS = null;
    public static final GiftPluginType TYPE_FAST_GIFT = null;
    public static final GiftPluginType TYPE_GAME_GIFT = null;
    public static final GiftPluginType TYPE_GIFT_DOODLE = null;
    public static final GiftPluginType TYPE_GIFT_RELAY = null;
    public static final GiftPluginType TYPE_GOODS = null;
    public static final GiftPluginType TYPE_INTERACT_GIFT = null;
    public static final GiftPluginType TYPE_LYNX_BANNER = null;
    public static final GiftPluginType TYPE_MSGBOARD_GIFT = null;
    public static final GiftPluginType TYPE_PERIOD_CARD = null;
    public static final GiftPluginType TYPE_PK_PROP = null;
    public static final GiftPluginType TYPE_POPULAR_BOX = null;
    public static final GiftPluginType TYPE_PROP_POPULAR_CARD = null;
    public static final GiftPluginType TYPE_RECHARGE_COUPON = null;
    public static final GiftPluginType TYPE_RED_PACKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftPluginType[] f126487a = null;

    static {
        GiftPluginType r100 = new GiftPluginType("TYPE_BANNER", 0);
        TYPE_BANNER = r100;
        GiftPluginType r101 = new GiftPluginType("TYPE_RED_PACKET", 1);
        TYPE_RED_PACKET = r101;
        GiftPluginType r102 = new GiftPluginType("TYPE_POPULAR_BOX", 2);
        TYPE_POPULAR_BOX = r102;
        GiftPluginType r103 = new GiftPluginType("TYPE_GIFT_RELAY", 3);
        TYPE_GIFT_RELAY = r103;
        GiftPluginType r104 = new GiftPluginType("TYPE_PROP_POPULAR_CARD", 4);
        TYPE_PROP_POPULAR_CARD = r104;
        GiftPluginType r105 = new GiftPluginType("TYPE_GIFT_DOODLE", 5);
        TYPE_GIFT_DOODLE = r105;
        GiftPluginType r106 = new GiftPluginType("TYPE_GAME_GIFT", 6);
        TYPE_GAME_GIFT = r106;
        GiftPluginType r107 = new GiftPluginType("TYPE_BLIND_BOX", 7);
        TYPE_BLIND_BOX = r107;
        GiftPluginType r108 = new GiftPluginType("TYPE_PERIOD_CARD", 8);
        TYPE_PERIOD_CARD = r108;
        GiftPluginType r109 = new GiftPluginType("TYPE_DEFAULT_BANNER", 9);
        TYPE_DEFAULT_BANNER = r109;
        GiftPluginType r110 = new GiftPluginType("TYPE_LYNX_BANNER", 10);
        TYPE_LYNX_BANNER = r110;
        GiftPluginType r111 = new GiftPluginType("TYPE_FAST_GIFT", 11);
        TYPE_FAST_GIFT = r111;
        GiftPluginType r112 = new GiftPluginType("TYPE_AIRDROP_GIFT", 12);
        TYPE_AIRDROP_GIFT = r112;
        GiftPluginType r113 = new GiftPluginType("TYPE_INTERACT_GIFT", 13);
        TYPE_INTERACT_GIFT = r113;
        GiftPluginType r114 = new GiftPluginType("TYPE_BIG_GIFT", 14);
        TYPE_BIG_GIFT = r114;
        GiftPluginType r115 = new GiftPluginType("TYPE_MSGBOARD_GIFT", 15);
        TYPE_MSGBOARD_GIFT = r115;
        GiftPluginType r116 = new GiftPluginType("TYPE_GOODS", 16);
        TYPE_GOODS = r116;
        GiftPluginType r117 = new GiftPluginType("TYPE_DS", 17);
        TYPE_DS = r117;
        GiftPluginType r118 = new GiftPluginType("TYPE_PK_PROP", 18);
        TYPE_PK_PROP = r118;
        GiftPluginType r119 = new GiftPluginType("TYPE_RECHARGE_COUPON", 19);
        TYPE_RECHARGE_COUPON = r119;
        GiftPluginType r120 = new GiftPluginType("DEFAULT", 20);
        DEFAULT = r120;
        f126487a = new GiftPluginType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
    }

    public static GiftPluginType valueOf(String r100) {
        return (GiftPluginType) r27.a.a(GiftPluginType.class, r100);
    }

    public static GiftPluginType[] values() {
        return (GiftPluginType[]) f126487a.clone();
    }

    public GiftPluginType(String r100, int r101) {
        super(r100, r101);
    }
}
