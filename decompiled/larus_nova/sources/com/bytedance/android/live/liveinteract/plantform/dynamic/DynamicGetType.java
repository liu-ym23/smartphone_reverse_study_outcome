package com.bytedance.android.live.liveinteract.plantform.dynamic;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamic/DynamicGetType;", "", UserProfileEvent.POSITION_NONE, "LINKMIC", "PLAYMODE", "SEAT", "GET_DATA", "COMMON_GET_DATA", "DRESS", "FRAME_INFO", "ENTER_INFO", "ROOM", "TEAM_FIGHT", "CREATE_CHECK", "LIVE_STREAM_DELAY_TIME", "CHANNEL_INFO", "LINK_SERVICE", "KTV_ORDER_INFO", "INTERACT_PANEL_CONFIG", "SETTING_PANEL_CONFIG", "SUBTITLE", "CHORUS", "KARAOKE", "AVATAR", "INTERACTIVE_ORDER_SONG", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicGetType extends Enum<DynamicGetType> {
    public static final DynamicGetType AVATAR = null;
    public static final DynamicGetType CHANNEL_INFO = null;
    public static final DynamicGetType CHORUS = null;
    public static final DynamicGetType COMMON_GET_DATA = null;
    public static final DynamicGetType CREATE_CHECK = null;
    public static final DynamicGetType DRESS = null;
    public static final DynamicGetType ENTER_INFO = null;
    public static final DynamicGetType FRAME_INFO = null;
    public static final DynamicGetType GET_DATA = null;
    public static final DynamicGetType INTERACTIVE_ORDER_SONG = null;
    public static final DynamicGetType INTERACT_PANEL_CONFIG = null;
    public static final DynamicGetType KARAOKE = null;
    public static final DynamicGetType KTV_ORDER_INFO = null;
    public static final DynamicGetType LINKMIC = null;
    public static final DynamicGetType LINK_SERVICE = null;
    public static final DynamicGetType LIVE_STREAM_DELAY_TIME = null;
    public static final DynamicGetType NONE = null;
    public static final DynamicGetType PLAYMODE = null;
    public static final DynamicGetType ROOM = null;
    public static final DynamicGetType SEAT = null;
    public static final DynamicGetType SETTING_PANEL_CONFIG = null;
    public static final DynamicGetType SUBTITLE = null;
    public static final DynamicGetType TEAM_FIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicGetType[] f76789a = null;

    static {
        DynamicGetType r100 = new DynamicGetType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        DynamicGetType r101 = new DynamicGetType("LINKMIC", 1);
        LINKMIC = r101;
        DynamicGetType r102 = new DynamicGetType("PLAYMODE", 2);
        PLAYMODE = r102;
        DynamicGetType r103 = new DynamicGetType("SEAT", 3);
        SEAT = r103;
        DynamicGetType r104 = new DynamicGetType("GET_DATA", 4);
        GET_DATA = r104;
        DynamicGetType r105 = new DynamicGetType("COMMON_GET_DATA", 5);
        COMMON_GET_DATA = r105;
        DynamicGetType r106 = new DynamicGetType("DRESS", 6);
        DRESS = r106;
        DynamicGetType r107 = new DynamicGetType("FRAME_INFO", 7);
        FRAME_INFO = r107;
        DynamicGetType r108 = new DynamicGetType("ENTER_INFO", 8);
        ENTER_INFO = r108;
        DynamicGetType r109 = new DynamicGetType("ROOM", 9);
        ROOM = r109;
        DynamicGetType r110 = new DynamicGetType("TEAM_FIGHT", 10);
        TEAM_FIGHT = r110;
        DynamicGetType r111 = new DynamicGetType("CREATE_CHECK", 11);
        CREATE_CHECK = r111;
        DynamicGetType r112 = new DynamicGetType("LIVE_STREAM_DELAY_TIME", 12);
        LIVE_STREAM_DELAY_TIME = r112;
        DynamicGetType r113 = new DynamicGetType("CHANNEL_INFO", 13);
        CHANNEL_INFO = r113;
        DynamicGetType r114 = new DynamicGetType("LINK_SERVICE", 14);
        LINK_SERVICE = r114;
        DynamicGetType r115 = new DynamicGetType("KTV_ORDER_INFO", 15);
        KTV_ORDER_INFO = r115;
        DynamicGetType r116 = new DynamicGetType("INTERACT_PANEL_CONFIG", 16);
        INTERACT_PANEL_CONFIG = r116;
        DynamicGetType r117 = new DynamicGetType("SETTING_PANEL_CONFIG", 17);
        SETTING_PANEL_CONFIG = r117;
        DynamicGetType r118 = new DynamicGetType("SUBTITLE", 18);
        SUBTITLE = r118;
        DynamicGetType r119 = new DynamicGetType("CHORUS", 19);
        CHORUS = r119;
        DynamicGetType r120 = new DynamicGetType("KARAOKE", 20);
        KARAOKE = r120;
        DynamicGetType r121 = new DynamicGetType("AVATAR", 21);
        AVATAR = r121;
        DynamicGetType r122 = new DynamicGetType("INTERACTIVE_ORDER_SONG", 22);
        INTERACTIVE_ORDER_SONG = r122;
        f76789a = new DynamicGetType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122};
    }

    public static DynamicGetType valueOf(String r100) {
        return (DynamicGetType) a.a(DynamicGetType.class, r100);
    }

    public static DynamicGetType[] values() {
        return (DynamicGetType[]) f76789a.clone();
    }

    public DynamicGetType(String r100, int r101) {
        super(r100, r101);
    }
}
