package com.bytedance.android.livesdk.interactivity.zdanmaku.attributes;

import kotlin.Metadata;
import nf6.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/attributes/DanmakuType;", "", "Lnf6/a;", "UnDefined", "Chat", "Carnival", "CarnivalEgg", "Gift", "Business", "Admin", "Normal", "Talent", "Official", "Privilege", "ChatChannel", "NotifyEffect", "RedPacketEgg", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DanmakuType extends Enum<DanmakuType> implements a {
    public static final DanmakuType Admin = null;
    public static final DanmakuType Business = null;
    public static final DanmakuType Carnival = null;
    public static final DanmakuType CarnivalEgg = null;
    public static final DanmakuType Chat = null;
    public static final DanmakuType ChatChannel = null;
    public static final DanmakuType Gift = null;
    public static final DanmakuType Normal = null;
    public static final DanmakuType NotifyEffect = null;
    public static final DanmakuType Official = null;
    public static final DanmakuType Privilege = null;
    public static final DanmakuType RedPacketEgg = null;
    public static final DanmakuType Talent = null;
    public static final DanmakuType UnDefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DanmakuType[] f141445a = null;

    static {
        DanmakuType r100 = new DanmakuType("UnDefined", 0);
        UnDefined = r100;
        DanmakuType r101 = new DanmakuType("Chat", 1);
        Chat = r101;
        DanmakuType r102 = new DanmakuType("Carnival", 2);
        Carnival = r102;
        DanmakuType r103 = new DanmakuType("CarnivalEgg", 3);
        CarnivalEgg = r103;
        DanmakuType r104 = new DanmakuType("Gift", 4);
        Gift = r104;
        DanmakuType r105 = new DanmakuType("Business", 5);
        Business = r105;
        DanmakuType r106 = new DanmakuType("Admin", 6);
        Admin = r106;
        DanmakuType r107 = new DanmakuType("Normal", 7);
        Normal = r107;
        DanmakuType r108 = new DanmakuType("Talent", 8);
        Talent = r108;
        DanmakuType r109 = new DanmakuType("Official", 9);
        Official = r109;
        DanmakuType r110 = new DanmakuType("Privilege", 10);
        Privilege = r110;
        DanmakuType r111 = new DanmakuType("ChatChannel", 11);
        ChatChannel = r111;
        DanmakuType r112 = new DanmakuType("NotifyEffect", 12);
        NotifyEffect = r112;
        DanmakuType r113 = new DanmakuType("RedPacketEgg", 13);
        RedPacketEgg = r113;
        f141445a = new DanmakuType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public static DanmakuType valueOf(String r100) {
        return (DanmakuType) r27.a.a(DanmakuType.class, r100);
    }

    public static DanmakuType[] values() {
        return (DanmakuType[]) f141445a.clone();
    }

    public DanmakuType(String r100, int r101) {
        super(r100, r101);
    }
}
