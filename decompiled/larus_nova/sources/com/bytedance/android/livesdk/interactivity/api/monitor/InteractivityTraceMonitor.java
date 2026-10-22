package com.bytedance.android.livesdk.interactivity.api.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
public final class InteractivityTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133301a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b)\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/InteractivityTraceMonitor$Event;", "", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "businessType", "getBusinessType", "productId", "getProductId", "", "needRoomCommonParams", "Z", "getNeedRoomCommonParams", "()Z", "ChatChannelCreate", "ChatChannelDelete", "ChatChannelInvite", "ChatChannelJoin", "ChatChannelTryCreate", "ChatChannelQuit", "ChatChannelDissolve", "ChatChannelComment", "ChatChannelSettingSet", "ChatChannelSettingUpdate", "ChatChannelCreateMessage", "ChatChannelSecretMessageSend", "ReceiveOpenCommentPanelEvent", "InputPanelRequestShow", "InputPanelShow", "InputPanelKeyboardLog", "CostConfirmWindowShow", "CostConfirmWindowClick", "DanmakuSwitchClick", "SendIntercept", "InputAIParamLog", "RichContentEngineError", "PublicScreenContextEmpty", "FirstMessageShowDelay", "PublicScreenVisibilityChange", "PublicScreenAdjustLayout", "PublicScreenAudioPlayEvent", "PublicScreenMaskEvent", "PublicScreenTopMsgEvent", "PublicScreenHistoryMsgFailEvent", "PublicScreenLiftUpEvent", "PublicScreenSelfGiftEvent", "PrivilegeDanmakuShow", "CarnivalModelDownload", "CarnivalOpenContour", "CarnivalReceiveSei", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event CarnivalModelDownload = null;
        public static final Event CarnivalOpenContour = null;
        public static final Event CarnivalReceiveSei = null;
        public static final Event ChatChannelComment = null;
        public static final Event ChatChannelCreate = null;
        public static final Event ChatChannelCreateMessage = null;
        public static final Event ChatChannelDelete = null;
        public static final Event ChatChannelDissolve = null;
        public static final Event ChatChannelInvite = null;
        public static final Event ChatChannelJoin = null;
        public static final Event ChatChannelQuit = null;
        public static final Event ChatChannelSecretMessageSend = null;
        public static final Event ChatChannelSettingSet = null;
        public static final Event ChatChannelSettingUpdate = null;
        public static final Event ChatChannelTryCreate = null;
        public static final Event CostConfirmWindowClick = null;
        public static final Event CostConfirmWindowShow = null;
        public static final Event DanmakuSwitchClick = null;
        public static final Event FirstMessageShowDelay = null;
        public static final Event InputAIParamLog = null;
        public static final Event InputPanelKeyboardLog = null;
        public static final Event InputPanelRequestShow = null;
        public static final Event InputPanelShow = null;
        public static final Event PrivilegeDanmakuShow = null;
        public static final Event PublicScreenAdjustLayout = null;
        public static final Event PublicScreenAudioPlayEvent = null;
        public static final Event PublicScreenContextEmpty = null;
        public static final Event PublicScreenHistoryMsgFailEvent = null;
        public static final Event PublicScreenLiftUpEvent = null;
        public static final Event PublicScreenMaskEvent = null;
        public static final Event PublicScreenSelfGiftEvent = null;
        public static final Event PublicScreenTopMsgEvent = null;
        public static final Event PublicScreenVisibilityChange = null;
        public static final Event ReceiveOpenCommentPanelEvent = null;
        public static final Event RichContentEngineError = null;
        public static final Event SendIntercept = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f133302a = null;
        private final String businessType;
        private final String eventType;
        private final boolean needRoomCommonParams;
        private final String productId;

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f133302a.clone();
        }

        static {
            Event r100 = new Event("ChatChannelCreate", 0, "ttlive_chat_channel_create", "chat_channel", "webcast_client_community", true);
            ChatChannelCreate = r100;
            Event r101 = new Event("ChatChannelDelete", 1, "ttlive_chat_channel_delete", "chat_channel", "webcast_client_community", true);
            ChatChannelDelete = r101;
            Event r102 = new Event("ChatChannelInvite", 2, "ttlive_chat_channel_invite", "chat_channel", "webcast_client_community", true);
            ChatChannelInvite = r102;
            Event r103 = new Event("ChatChannelJoin", 3, "ttlive_chat_channel_join", "chat_channel", "webcast_client_community", true);
            ChatChannelJoin = r103;
            Event r104 = new Event("ChatChannelTryCreate", 4, "ttlive_chat_channel_try_create", "chat_channel", "webcast_client_community", true);
            ChatChannelTryCreate = r104;
            Event r105 = new Event("ChatChannelQuit", 5, "ttlive_chat_channel_quit", "chat_channel", "webcast_client_community", true);
            ChatChannelQuit = r105;
            Event r106 = new Event("ChatChannelDissolve", 6, "ttlive_chat_channel_dissolve", "chat_channel", "webcast_client_community", true);
            ChatChannelDissolve = r106;
            Event r107 = new Event("ChatChannelComment", 7, "ttlive_chat_channel_comment", "chat_channel", "webcast_client_community", true);
            ChatChannelComment = r107;
            Event r108 = new Event("ChatChannelSettingSet", 8, "ttlive_chat_channel_setting_set", "chat_channel", "webcast_client_community", true);
            ChatChannelSettingSet = r108;
            Event r109 = new Event("ChatChannelSettingUpdate", 9, "ttlive_chat_channel_setting_update", "chat_channel", "webcast_client_community", true);
            ChatChannelSettingUpdate = r109;
            Event r110 = new Event("ChatChannelCreateMessage", 10, "ttlive_chat_channel_receive_create_message", "chat_channel", "webcast_client_community", true);
            ChatChannelCreateMessage = r110;
            Event r111 = new Event("ChatChannelSecretMessageSend", 11, "ttlive_chat_channel_secret_message_send", "chat_channel", "webcast_client_community", true);
            ChatChannelSecretMessageSend = r111;
            Event r112 = new Event("ReceiveOpenCommentPanelEvent", 12, "ttlive_input_panel_receive_lottery_jsb_event", "input_panel", "webcast_client_community", true);
            ReceiveOpenCommentPanelEvent = r112;
            Event r113 = new Event("InputPanelRequestShow", 13, "ttlive_input_panel_request_show_event", "input_panel", "webcast_client_community", true);
            InputPanelRequestShow = r113;
            Event r114 = new Event("InputPanelShow", 14, "ttlive_input_panel_show", "input_panel", "webcast_client_community", true);
            InputPanelShow = r114;
            Event r115 = new Event("InputPanelKeyboardLog", 15, "ttlive_input_panel_keyboard_log", "input_panel", "webcast_client_community", true);
            InputPanelKeyboardLog = r115;
            Event r116 = new Event("CostConfirmWindowShow", 16, "ttlive_input_panel_danmaku_cost_tip_show", "input_panel", "webcast_client_community", true);
            CostConfirmWindowShow = r116;
            Event r117 = new Event("CostConfirmWindowClick", 17, "ttlive_input_panel_danmaku_cost_tip_click", "input_panel", "webcast_client_community", true);
            CostConfirmWindowClick = r117;
            Event r118 = new Event("DanmakuSwitchClick", 18, "ttlive_input_panel_danmaku_switch_click", "input_panel", "webcast_client_community", true);
            DanmakuSwitchClick = r118;
            Event r119 = new Event("SendIntercept", 19, "ttlive_input_panel_send_intercept", "input_panel", "webcast_client_community", true);
            SendIntercept = r119;
            Event r120 = new Event("InputAIParamLog", 20, "ttlive_input_panel_ai_param_log", "input_panel", "webcast_client_community", true);
            InputAIParamLog = r120;
            Event r121 = new Event("RichContentEngineError", 21, "ttlive_public_screen_rich_content_engine_error", "public_screen", "webcast_client_community", true);
            RichContentEngineError = r121;
            Event r122 = new Event("PublicScreenContextEmpty", 22, "ttlive_public_screen_context_empty_error", "public_screen", "webcast_client_community", true);
            PublicScreenContextEmpty = r122;
            Event r123 = new Event("FirstMessageShowDelay", 23, "ttlive_public_screen_first_message_show_delay", "public_screen", "webcast_client_community", true);
            FirstMessageShowDelay = r123;
            Event r124 = new Event("PublicScreenVisibilityChange", 24, "ttlive_public_screen_visibility_change", "public_screen", "webcast_client_community", true);
            PublicScreenVisibilityChange = r124;
            Event r125 = new Event("PublicScreenAdjustLayout", 25, "ttlive_public_screen_adjust_layout", "public_screen", "webcast_client_community", true);
            PublicScreenAdjustLayout = r125;
            Event r126 = new Event("PublicScreenAudioPlayEvent", 26, "ttlive_public_screen_audio_comment_play", "public_screen", "webcast_client_community", true);
            PublicScreenAudioPlayEvent = r126;
            Event r127 = new Event("PublicScreenMaskEvent", 27, "ttlive_public_screen_mask_event_record", "public_screen", "webcast_client_community", true);
            PublicScreenMaskEvent = r127;
            Event r128 = new Event("PublicScreenTopMsgEvent", 28, "ttlive_public_screen_top_msg_backend_event", "public_screen", "webcast_client_community", true);
            PublicScreenTopMsgEvent = r128;
            Event r129 = new Event("PublicScreenHistoryMsgFailEvent", 29, "ttlive_public_screen_history_msg_fetch_error", "public_screen", "webcast_client_community", true);
            PublicScreenHistoryMsgFailEvent = r129;
            Event r130 = new Event("PublicScreenLiftUpEvent", 30, "ttlive_public_screen_lift_up_event", "public_screen", "webcast_client_community", true);
            PublicScreenLiftUpEvent = r130;
            Event r131 = new Event("PublicScreenSelfGiftEvent", 31, "ttlive_public_screen_self_gift_event_receive", "public_screen", "webcast_client_community", true);
            PublicScreenSelfGiftEvent = r131;
            Event r132 = new Event("PrivilegeDanmakuShow", 32, "ttlive_danmaku_privilege_message_summary", "danmaku", "webcast_client_community", true);
            PrivilegeDanmakuShow = r132;
            Event r133 = new Event("CarnivalModelDownload", 33, "ttlive_danmaku_carnival_model_download", "danmaku", "webcast_client_community", true);
            CarnivalModelDownload = r133;
            Event r134 = new Event("CarnivalOpenContour", 34, "ttlive_danmaku_carnival_open_contour", "danmaku", "webcast_client_community", true);
            CarnivalOpenContour = r134;
            Event r135 = new Event("CarnivalReceiveSei", 35, "ttlive_danmaku_carnival_receive_sei", "danmaku", "webcast_client_community", true);
            CarnivalReceiveSei = r135;
            f133302a = new Event[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135};
        }

        public final String getBusinessType() {
            return this.businessType;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final boolean getNeedRoomCommonParams() {
            return this.needRoomCommonParams;
        }

        public final String getProductId() {
            return this.productId;
        }

        public Event(String r100, int r101, String r102, String r103, String r104, boolean r105) {
            super(r100, r101);
            this.eventType = r102;
            this.businessType = r103;
            this.productId = r104;
            this.needRoomCommonParams = r105;
        }

        public /* synthetic */ Event(String r100, int r101, String r110, String r111, String r112, boolean r113, int r114, DefaultConstructorMarker r115) {
            if ((r114 & 8) == 0) goto L5;
            boolean r102 = true;
        L6:
            this(r100, r101, r110, r111, r112, r102);
            return;
        L5:
            r102 = r113;
            goto L6
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f133303a = 0;

        static {
        }
    }

    static {
    }
}
