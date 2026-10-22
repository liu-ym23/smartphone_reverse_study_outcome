package android.ss.com.vboost;

import com.byted.cast.common.api.FirewallError;
import com.byted.cast.common.api.IPlayerListener;
import com.byted.cast.sdk.RTCEngine;

/* JADX INFO: loaded from: classes2.dex */
public final enum CustomScene extends Enum<CustomScene> {
    private static final /* synthetic */ CustomScene[] $VALUES = null;
    private static final int CLASS_BASE = 100000;
    public static final CustomScene COMMON_APP_START = null;
    public static final CustomScene COMMON_CAMERA_START = null;
    private static final int COMMON_CLASS = 1;
    public static final CustomScene COMMON_TAB_SWITCH = null;
    public static final CustomScene COMMON_WINDOW_SWITCH = null;
    private static final int DC_CLASS = 5;
    public static final CustomScene DC_SCROLL_HOME = null;
    public static final CustomScene DC_SCROLL_MOMENTS = null;
    public static final CustomScene DC_TAB_SWITCH = null;
    public static final CustomScene DC_VIDEO_FIRST_DRAW = null;
    public static final CustomScene DY_15S_CAPTURE_START = null;
    private static final int DY_CLASS = 2;
    public static final CustomScene DY_COMMENT_LOAD = null;
    public static final CustomScene DY_CONCURRENT_UPLOAD_COMPILE = null;
    public static final CustomScene DY_FEED_SCROLL = null;
    public static final CustomScene DY_GO_DUET = null;
    public static final CustomScene DY_GO_REACTION = null;
    public static final CustomScene DY_LIVING_ENTER_GIFT_PANEL = null;
    public static final CustomScene DY_LIVING_ENTER_GOODS_LIST = null;
    public static final CustomScene DY_LIVING_SCROLL = null;
    public static final CustomScene DY_TAB_FAMILIAR_LOAD = null;
    public static final CustomScene DY_TAB_FOLLOW_LOAD = null;
    public static final CustomScene DY_TAB_HOME_LOAD = null;
    public static final CustomScene DY_TAB_LIVING_LOAD = null;
    public static final CustomScene DY_TAB_MUSIC = null;
    public static final CustomScene DY_TAB_NEARBY_LOAD = null;
    public static final CustomScene DY_TAB_NOTIFICATION_LOAD = null;
    public static final CustomScene DY_TAB_PUBLISH_LOAD = null;
    public static final CustomScene DY_TAB_SEARCH_LOAD = null;
    public static final CustomScene DY_TAB_USER_LOAD = null;
    private static final int LAST_COMMON_SCENE_ID = 0;
    private static final int LAST_DC_SCENE_ID = 0;
    private static final int LAST_DY_SCENE_ID = 0;
    private static final int LAST_SCENE_ID = 0;
    private static final int LAST_TL_SCENE_ID = 0;
    private static final int LAST_TO_SCENE_ID = 0;
    private static final int LAST_TT_SCENE_ID = 0;
    public static final int MAX_CLASS = 0;
    private static final int TL_CLASS = 4;
    public static final CustomScene TL_CLICK_NEWS = null;
    public static final CustomScene TL_FIRST_FRAME_DRAW = null;
    public static final CustomScene TL_SCROLL_NEWS = null;
    public static final CustomScene TL_TAB_SWITCH = null;
    private static final int TO_CLASS = 3;
    public static final CustomScene TO_CLICK_NEWS = null;
    public static final CustomScene TO_FIRST_FRAME_DRAW = null;
    public static final CustomScene TO_SCROLL_NEWS = null;
    public static final CustomScene TO_TAB_SWITCH = null;
    public static final CustomScene TO_VIDEO_FIRST_FRAME = null;
    public static final CustomScene TT_15S_CAPTURE_START = null;
    private static final int TT_CLASS = 6;
    public static final CustomScene TT_COMMENT_LOAD = null;
    public static final CustomScene TT_CONCURRENT_UPLOAD_COMPILE = null;
    public static final CustomScene TT_FEED_SCROLL = null;
    public static final CustomScene TT_GO_DUET = null;
    public static final CustomScene TT_GO_REACTION = null;
    public static final CustomScene TT_LIVING_ENTER_GIFT_PANEL = null;
    public static final CustomScene TT_LIVING_ENTER_GOODS_LIST = null;
    public static final CustomScene TT_LIVING_SCROLL = null;
    public static final CustomScene TT_TAB_FAMILIAR_LOAD = null;
    public static final CustomScene TT_TAB_FOLLOW_LOAD = null;
    public static final CustomScene TT_TAB_HOME_LOAD = null;
    public static final CustomScene TT_TAB_LIVING_LOAD = null;
    public static final CustomScene TT_TAB_MUSIC = null;
    public static final CustomScene TT_TAB_NEARBY_LOAD = null;
    public static final CustomScene TT_TAB_NOTIFICATION_LOAD = null;
    public static final CustomScene TT_TAB_PUBLISH_LOAD = null;
    public static final CustomScene TT_TAB_SEARCH_LOAD = null;
    public static final CustomScene TT_TAB_USER_LOAD = null;
    private String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f4598id;

    static {
        CustomScene r100 = new CustomScene("COMMON_APP_START", 0, 100001, "common_app_start");
        COMMON_APP_START = r100;
        CustomScene r101 = new CustomScene("COMMON_CAMERA_START", 1, 100002, "common_camera_start");
        COMMON_CAMERA_START = r101;
        CustomScene r102 = new CustomScene("COMMON_WINDOW_SWITCH", 2, 100003, "common_window_switch");
        COMMON_WINDOW_SWITCH = r102;
        CustomScene r103 = new CustomScene("COMMON_TAB_SWITCH", 3, 100004, "common_tab_switch");
        COMMON_TAB_SWITCH = r103;
        CustomScene r104 = new CustomScene("DY_GO_DUET", 4, 200001, "dy_go_duet");
        DY_GO_DUET = r104;
        CustomScene r105 = new CustomScene("DY_GO_REACTION", 5, 200002, "dy_go_reaction");
        DY_GO_REACTION = r105;
        CustomScene r106 = new CustomScene("DY_TAB_LIVING_LOAD", 6, 200003, "dy_tab_living_load");
        DY_TAB_LIVING_LOAD = r106;
        CustomScene r110 = new CustomScene("DY_TAB_NEARBY_LOAD", 7, 200004, "dy_tab_nearby_load");
        DY_TAB_NEARBY_LOAD = r110;
        CustomScene r111 = new CustomScene("DY_TAB_FOLLOW_LOAD", 8, 200005, "dy_tab_follow_load");
        DY_TAB_FOLLOW_LOAD = r111;
        CustomScene r112 = new CustomScene("DY_TAB_SEARCH_LOAD", 9, 200006, "dy_tab_search_load");
        DY_TAB_SEARCH_LOAD = r112;
        CustomScene r113 = new CustomScene("DY_TAB_HOME_LOAD", 10, 200007, "dy_tab_home_load");
        DY_TAB_HOME_LOAD = r113;
        CustomScene r107 = new CustomScene("DY_TAB_FAMILIAR_LOAD", 11, 200008, "dy_tab_familiar_load");
        DY_TAB_FAMILIAR_LOAD = r107;
        CustomScene r108 = new CustomScene("DY_TAB_PUBLISH_LOAD", 12, 200009, "dy_tab_publish_load");
        DY_TAB_PUBLISH_LOAD = r108;
        CustomScene r109 = new CustomScene("DY_TAB_NOTIFICATION_LOAD", 13, 200010, "dy_tab_notification_load");
        DY_TAB_NOTIFICATION_LOAD = r109;
        CustomScene r114 = new CustomScene("DY_TAB_USER_LOAD", 14, 200011, "dy_tab_user_load");
        DY_TAB_USER_LOAD = r114;
        CustomScene r115 = new CustomScene("DY_CONCURRENT_UPLOAD_COMPILE", 15, 200012, "dy_concurrent_upload_compile");
        DY_CONCURRENT_UPLOAD_COMPILE = r115;
        CustomScene r116 = new CustomScene("DY_FEED_SCROLL", 16, 200013, "dy_feed_scroll");
        DY_FEED_SCROLL = r116;
        CustomScene r117 = new CustomScene("DY_COMMENT_LOAD", 17, 200014, "dy_comment_load");
        DY_COMMENT_LOAD = r117;
        CustomScene r118 = new CustomScene("DY_TAB_MUSIC", 18, 200015, "dy_tab_music");
        DY_TAB_MUSIC = r118;
        CustomScene r119 = new CustomScene("DY_15S_CAPTURE_START", 19, 200016, "dy_15s_capture_start");
        DY_15S_CAPTURE_START = r119;
        CustomScene r120 = new CustomScene("DY_LIVING_SCROLL", 20, 200017, "dy_living_scroll");
        DY_LIVING_SCROLL = r120;
        CustomScene r121 = new CustomScene("DY_LIVING_ENTER_GIFT_PANEL", 21, 200018, "dy_living_enter_gift_panel");
        DY_LIVING_ENTER_GIFT_PANEL = r121;
        CustomScene r122 = new CustomScene("DY_LIVING_ENTER_GOODS_LIST", 22, 200019, "dy_living_enter_goods_list");
        DY_LIVING_ENTER_GOODS_LIST = r122;
        CustomScene r123 = new CustomScene("TO_FIRST_FRAME_DRAW", 23, IPlayerListener.CONFERENCE_PINCODE_CONVERTTODEV_ERROR, "to_first_frame_draw");
        TO_FIRST_FRAME_DRAW = r123;
        CustomScene r124 = new CustomScene("TO_TAB_SWITCH", 24, 300002, "to_tab_switch");
        TO_TAB_SWITCH = r124;
        CustomScene r125 = new CustomScene("TO_CLICK_NEWS", 25, IPlayerListener.INFO_SCREENSHOT_COMPLATION, "to_click_news");
        TO_CLICK_NEWS = r125;
        CustomScene r126 = new CustomScene("TO_SCROLL_NEWS", 26, IPlayerListener.INFO_SCREENSHOT_FAILED, "to_scroll_news");
        TO_SCROLL_NEWS = r126;
        CustomScene r127 = new CustomScene("TO_VIDEO_FIRST_FRAME", 27, IPlayerListener.INFO_MIRROR_STATE, "to_video_first_frame");
        TO_VIDEO_FIRST_FRAME = r127;
        CustomScene r128 = new CustomScene("TL_FIRST_FRAME_DRAW", 28, 400001, "tl_first_frame_draw");
        TL_FIRST_FRAME_DRAW = r128;
        CustomScene r129 = new CustomScene("TL_TAB_SWITCH", 29, 400002, "tl_tab_switch");
        TL_TAB_SWITCH = r129;
        CustomScene r130 = new CustomScene("TL_CLICK_NEWS", 30, RTCEngine.INFO_SET_BITRATE_KPS, "tl_click_news");
        TL_CLICK_NEWS = r130;
        CustomScene r131 = new CustomScene("TL_SCROLL_NEWS", 31, 400004, "tl_scroll_news");
        TL_SCROLL_NEWS = r131;
        CustomScene r132 = new CustomScene("DC_SCROLL_HOME", 32, 500001, "dc_scroll_home");
        DC_SCROLL_HOME = r132;
        CustomScene r133 = new CustomScene("DC_TAB_SWITCH", 33, 500002, "dc_tab_switch");
        DC_TAB_SWITCH = r133;
        CustomScene r134 = new CustomScene("DC_SCROLL_MOMENTS", 34, 500003, "dc_scroll_moments");
        DC_SCROLL_MOMENTS = r134;
        CustomScene r135 = new CustomScene("DC_VIDEO_FIRST_DRAW", 35, 500004, "dc_video_first_draw");
        DC_VIDEO_FIRST_DRAW = r135;
        CustomScene r136 = new CustomScene("TT_GO_DUET", 36, FirewallError.FIREWALL_ERROR_SYS_ERROR, "tt_go_duet");
        TT_GO_DUET = r136;
        CustomScene r137 = new CustomScene("TT_GO_REACTION", 37, FirewallError.FIREWALL_ERROR_NOT_INSTALLED, "tt_go_reaction");
        TT_GO_REACTION = r137;
        CustomScene r138 = new CustomScene("TT_TAB_LIVING_LOAD", 38, FirewallError.FIREWALL_ERROR_NOT_RUNNING, "tt_tab_living_load");
        TT_TAB_LIVING_LOAD = r138;
        CustomScene r139 = new CustomScene("TT_TAB_NEARBY_LOAD", 39, FirewallError.FIREWALL_ERROR_MULTI_DIFF_ACTIVE, "tt_tab_nearby_load");
        TT_TAB_NEARBY_LOAD = r139;
        CustomScene r140 = new CustomScene("TT_TAB_FOLLOW_LOAD", 40, FirewallError.FIREWALL_ERROR_ALL_IN_BLOCKED, "tt_tab_follow_load");
        TT_TAB_FOLLOW_LOAD = r140;
        CustomScene r141 = new CustomScene("TT_TAB_SEARCH_LOAD", 41, FirewallError.FIREWALL_ERROR_BONJOUR_ALL_IN_BLOCKED, "tt_tab_search_load");
        TT_TAB_SEARCH_LOAD = r141;
        CustomScene r142 = new CustomScene("TT_TAB_HOME_LOAD", 42, FirewallError.FIREWALL_ERROR_BONJOUR_ALL_OUT_BLOCKED, "tt_tab_home_load");
        TT_TAB_HOME_LOAD = r142;
        CustomScene r143 = new CustomScene("TT_TAB_FAMILIAR_LOAD", 43, FirewallError.FIREWALL_ERROR_BONJOUR_UDP_IN_BLOCKED, "tt_tab_familiar_load");
        TT_TAB_FAMILIAR_LOAD = r143;
        CustomScene r144 = new CustomScene("TT_TAB_PUBLISH_LOAD", 44, FirewallError.FIREWALL_ERROR_BONJOUR_UDP_OUT_BLOCKED, "tt_tab_publish_load");
        TT_TAB_PUBLISH_LOAD = r144;
        CustomScene r145 = new CustomScene("TT_TAB_NOTIFICATION_LOAD", 45, FirewallError.FIREWALL_ERROR_BONJOUR_TCP_IN_BLOCKED, "tt_tab_notification_load");
        TT_TAB_NOTIFICATION_LOAD = r145;
        CustomScene r146 = new CustomScene("TT_TAB_USER_LOAD", 46, FirewallError.FIREWALL_ERROR_BONJOUR_TCP_OUT_BLOCKED, "tt_tab_user_load");
        TT_TAB_USER_LOAD = r146;
        CustomScene r147 = new CustomScene("TT_CONCURRENT_UPLOAD_COMPILE", 47, FirewallError.FIREWALL_ERROR_BONJOUR_MIX_BLOCKED, "tt_concurrent_upload_compile");
        TT_CONCURRENT_UPLOAD_COMPILE = r147;
        CustomScene r148 = new CustomScene("TT_FEED_SCROLL", 48, FirewallError.FIREWALL_ERROR_MEDIASDK_ALL_IN_BLOCKED, "tt_feed_scroll");
        TT_FEED_SCROLL = r148;
        CustomScene r149 = new CustomScene("TT_COMMENT_LOAD", 49, FirewallError.FIREWALL_ERROR_MEDIASDK_ALL_OUT_BLOCKED, "tt_comment_load");
        TT_COMMENT_LOAD = r149;
        CustomScene r150 = new CustomScene("TT_TAB_MUSIC", 50, FirewallError.FIREWALL_ERROR_MEDIASDK_UDP_IN_BLOCKED, "tt_tab_music");
        TT_TAB_MUSIC = r150;
        CustomScene r151 = new CustomScene("TT_15S_CAPTURE_START", 51, FirewallError.FIREWALL_ERROR_MEDIASDK_UDP_OUT_BLOCKED, "tt_15s_capture_start");
        TT_15S_CAPTURE_START = r151;
        CustomScene r152 = new CustomScene("TT_LIVING_SCROLL", 52, FirewallError.FIREWALL_ERROR_MEDIASDK_TCP_IN_BLOCKED, "tt_living_scroll");
        TT_LIVING_SCROLL = r152;
        CustomScene r153 = new CustomScene("TT_LIVING_ENTER_GIFT_PANEL", 53, FirewallError.FIREWALL_ERROR_MEDIASDK_TCP_OUT_BLOCKED, "tt_living_enter_gift_panel");
        TT_LIVING_ENTER_GIFT_PANEL = r153;
        CustomScene r154 = new CustomScene("TT_LIVING_ENTER_GOODS_LIST", 54, FirewallError.FIREWALL_ERROR_MEDIASDK_MIX_BLOCKED, "tt_living_enter_goods_list");
        TT_LIVING_ENTER_GOODS_LIST = r154;
        $VALUES = new CustomScene[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154};
        LAST_COMMON_SCENE_ID = r103.f4598id;
        LAST_DY_SCENE_ID = r122.f4598id;
        LAST_TO_SCENE_ID = r127.f4598id;
        LAST_TL_SCENE_ID = r131.f4598id;
        LAST_DC_SCENE_ID = r135.f4598id;
        int r155 = r154.f4598id;
        LAST_TT_SCENE_ID = r155;
        LAST_SCENE_ID = r155;
        MAX_CLASS = r155 / 100000;
    }

    private CustomScene(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f4598id = r102;
        this.desc = r103;
    }

    private static int getSceneClass(int r100) {
        return r100 / 100000;
    }

    private static int getSceneNum(int r100) {
        return r100 % 100000;
    }

    private static boolean isValidClass(int r100) {
        if (r100 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r100 > MAX_CLASS) goto L6;
        return true;
    }

    public static boolean isValidId(int r100) {
        int r101 = getSceneClass(r100);
        int r102 = getSceneNum(r100);
        if (isValidClass(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidNum(r101, r102) == false) goto L7;
        return true;
    }

    private static boolean isValidNum(int r100, int r101) {
        switch(r100) {
            case 1: goto L35;
            case 2: goto L29;
            case 3: goto L23;
            case 4: goto L17;
            case 5: goto L11;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        if (r101 > 0) goto L7;
    L9:
        return false;
    L7:
        if (r101 > (LAST_TT_SCENE_ID % 100000)) goto L9;
        return true;
    L11:
        if (r101 > 0) goto L13;
    L15:
        return false;
    L13:
        if (r101 > (LAST_DC_SCENE_ID % 100000)) goto L15;
        return true;
    L17:
        if (r101 > 0) goto L19;
    L21:
        return false;
    L19:
        if (r101 > (LAST_TL_SCENE_ID % 100000)) goto L21;
        return true;
    L23:
        if (r101 > 0) goto L25;
    L27:
        return false;
    L25:
        if (r101 > (LAST_TO_SCENE_ID % 100000)) goto L27;
        return true;
    L29:
        if (r101 > 0) goto L31;
    L33:
        return false;
    L31:
        if (r101 > (LAST_DY_SCENE_ID % 100000)) goto L33;
        return true;
    L35:
        if (r101 > 0) goto L37;
    L39:
        return false;
    L37:
        if (r101 > (LAST_COMMON_SCENE_ID % 100000)) goto L39;
        return true;
    }

    public static CustomScene valueOf(String r100) {
        return (CustomScene) r27.a.a(CustomScene.class, r100);
    }

    public static CustomScene[] values() {
        return (CustomScene[]) $VALUES.clone();
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.f4598id;
    }
}
