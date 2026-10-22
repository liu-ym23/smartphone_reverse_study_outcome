package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketDressType;", "", "Name", "ShortTouchWaitingPng", "ShortTouchRushPng", "ShortTouchEmptyHideWebp", "ShortTouchEmptyMoreWebp", "EnterSkinPng", "TopCover", "BottomCoverPng", "BackGround", "Border", "ResultCard", "CountDownBg", "BlessIcon", "BlessWord", "SurpriseGift", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketDressType extends Enum<RedPacketDressType> {
    public static final RedPacketDressType BackGround = null;
    public static final RedPacketDressType BlessIcon = null;
    public static final RedPacketDressType BlessWord = null;
    public static final RedPacketDressType Border = null;
    public static final RedPacketDressType BottomCoverPng = null;
    public static final RedPacketDressType CountDownBg = null;
    public static final RedPacketDressType EnterSkinPng = null;
    public static final RedPacketDressType Name = null;
    public static final RedPacketDressType ResultCard = null;
    public static final RedPacketDressType ShortTouchEmptyHideWebp = null;
    public static final RedPacketDressType ShortTouchEmptyMoreWebp = null;
    public static final RedPacketDressType ShortTouchRushPng = null;
    public static final RedPacketDressType ShortTouchWaitingPng = null;
    public static final RedPacketDressType SurpriseGift = null;
    public static final RedPacketDressType TopCover = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketDressType[] f88493a = null;

    static {
        RedPacketDressType r100 = new RedPacketDressType("Name", 0);
        Name = r100;
        RedPacketDressType r101 = new RedPacketDressType("ShortTouchWaitingPng", 1);
        ShortTouchWaitingPng = r101;
        RedPacketDressType r102 = new RedPacketDressType("ShortTouchRushPng", 2);
        ShortTouchRushPng = r102;
        RedPacketDressType r103 = new RedPacketDressType("ShortTouchEmptyHideWebp", 3);
        ShortTouchEmptyHideWebp = r103;
        RedPacketDressType r104 = new RedPacketDressType("ShortTouchEmptyMoreWebp", 4);
        ShortTouchEmptyMoreWebp = r104;
        RedPacketDressType r105 = new RedPacketDressType("EnterSkinPng", 5);
        EnterSkinPng = r105;
        RedPacketDressType r106 = new RedPacketDressType("TopCover", 6);
        TopCover = r106;
        RedPacketDressType r107 = new RedPacketDressType("BottomCoverPng", 7);
        BottomCoverPng = r107;
        RedPacketDressType r108 = new RedPacketDressType("BackGround", 8);
        BackGround = r108;
        RedPacketDressType r109 = new RedPacketDressType("Border", 9);
        Border = r109;
        RedPacketDressType r110 = new RedPacketDressType("ResultCard", 10);
        ResultCard = r110;
        RedPacketDressType r111 = new RedPacketDressType("CountDownBg", 11);
        CountDownBg = r111;
        RedPacketDressType r112 = new RedPacketDressType("BlessIcon", 12);
        BlessIcon = r112;
        RedPacketDressType r113 = new RedPacketDressType("BlessWord", 13);
        BlessWord = r113;
        RedPacketDressType r114 = new RedPacketDressType("SurpriseGift", 14);
        SurpriseGift = r114;
        f88493a = new RedPacketDressType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public static RedPacketDressType valueOf(String r100) {
        return (RedPacketDressType) r27.a.a(RedPacketDressType.class, r100);
    }

    public static RedPacketDressType[] values() {
        return (RedPacketDressType[]) f88493a.clone();
    }

    public RedPacketDressType(String r100, int r101) {
        super(r100, r101);
    }
}
