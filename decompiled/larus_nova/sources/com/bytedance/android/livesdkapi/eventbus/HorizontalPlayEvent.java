package com.bytedance.android.livesdkapi.eventbus;

/* JADX INFO: loaded from: classes12.dex */
public class HorizontalPlayEvent {
    public static final String SOURCE_FOR_CHAT_CHANNEL_CREATE_REQUEST_LANDSCAPE = "source_for_chat_channel_create_request_landscape";
    public static final String SOURCE_FOR_CHAT_CHANNEL_INVITE_REQUEST_LANDSCAPE = "source_for_chat_channel_invite_request_landscape";
    public static final String SOURCE_FOR_CHAT_CHANNEL_PANEL_REQUEST_LANDSCAPE = "source_for_chat_channel_panel_request_landscape";
    public static final String SOURCE_FOR_JSB_FORCE_SWITCH_TO_PORTRAIT = "source_for_jsb_force_switch_to_portrait";
    public static final String SOURCE_FOR_LIVE_OPEN_PAID_PANEL = "source_for_live_open_paid_panel";
    public static final String SOURCE_FOR_LIVE_RECHARGE = "source_for_live_recharge";
    public static final String SOURCE_FOR_PLAYTOGETHER_REQUEST_LANDSCAPE = "source_for_playtogether_request_landscape";
    public static final String SOURCE_FOR_ROOM_CHANNEL_PANEL_REQUEST_LANDSCAPE = "source_for_room_channel_panel_request_landscape";
    public static final String SOURCE_FOR_SHARE_REQUEST_LANDSCAPE = "source_for_share_request_landscape";
    public static final String SOURCE_LANDSCAPE_MATCH_SHARE = "source_landscape_match_share";
    public static final String SOURCE_LANDSCAPE_VS_MSG_BOARD = "source_landscape_vs_msg_board";
    public static final String SOURCE_PORTRAIT_LINKMIC = "source_portrait_linkmic";
    public static final String SOURCE_VS_LYNX = "source_vs_lynx";
    public static final int TYPE_ROTATION_AUTO_LAND = 2;
    public static final int TYPE_ROTATION_AUTO_LAND_AND_PORT = 3;
    public static final int TYPE_ROTATION_MANUAL = 1;
    public static final int TYPE_ROTATION_OTHER = 0;
    public static final int TYPE_ROTATION_PREVIEW_ACTION = 4;
    public static final int WHAT_DISABLE_ANIMATION = 3;
    public static final int WHAT_ENABLE_ANIMATION = 4;
    public static final int WHAT_SWITCH_TO_HORIZONTAL = 2;
    public static final int WHAT_SWITCH_TO_PORTRAIT = 1;
    public Object extra;
    public Object rotateInnerReq;
    public int rotationType;
    public int screenOrientation;
    public String source;
    public int what;

    public HorizontalPlayEvent(int r100) {
        this.source = "";
        this.rotationType = 0;
        this.what = r100;
    }

    public HorizontalPlayEvent(int r100, int r101) {
        this.source = "";
        this.what = r100;
        this.rotationType = r101;
    }

    public HorizontalPlayEvent(int r100, String r101) {
        this.rotationType = 0;
        this.what = r100;
        this.source = r101;
    }

    public HorizontalPlayEvent(int r100, String r101, Object r102) {
        this.rotationType = 0;
        this.what = r100;
        this.source = r101;
        this.extra = r102;
    }

    public HorizontalPlayEvent(int r100, int r101, String r102) {
        this.what = r100;
        this.rotationType = r101;
        this.source = r102;
    }
}
