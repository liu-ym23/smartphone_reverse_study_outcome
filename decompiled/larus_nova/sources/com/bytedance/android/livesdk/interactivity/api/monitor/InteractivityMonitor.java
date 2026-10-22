package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class InteractivityMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133299a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bG\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bR¨\u0006S"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/InteractivityMonitor$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "PublicScreenMessage", "PublicScreenShowStatus", "PublicScreenHeightError", "PublicScreenRenderError", "PublicScreenMessageActionTypeUnexpected", "PublicScreenRoomExposureError", "PublicScreenRealtimeExposureError", "PublicScreenFirstShowError", "PublicScreenNoMessageShowError", "HighLevelNoMessageShowError", "CommentUserSend", "CommentUserSendSelfShow", "CommentDisable", "CommentIntercept", "AudioTransferError", "DiggDisable", "ProfileDiggDisable", "PinControlStatus", "PinShowStatus", "PinRequest", "PinReview", "IMFirstMessageEmpty", "FirstHistoryMessageEmpty", "FirstRealtimeMessageEmpty", "DanmakuShowLatency", "ChatChannelCreate", "ChatChannelInvite", "ChatChannelJoin", "ChatChannelQuit", "ChatChannelDissolve", "ChatChannelComment", "ChatChannelSettingSet", "ChatChannelSettingUpdate", "ChatChannelCreateShowCost", "ChatChannelInviteShowCost", "SpeechEngineInstallPlugin", "SpeechEngineLoadPlugin", "SpeechEngineInit", "SpeechEngineStart", "SpeechEngineError", "AnchorAsrInterrupted", "AnchorAsrMatch", "AnchorAsrSendComment", "ImageRecognition", "ImageRecognitionRequest", "Degrade", "ReceiveOpenCommentPanelEvent", "InputPanelRequestShow", "InputPanelShow", "InputPanelKeyboardLog", "CostConfirmWindowShow", "CostConfirmWindowClick", "DanmakuSwitchClick", "PublicScreenVisibilityChange", "AICloneInit", "AICloneInitFailed", "AIAutoReplyMessageReceive", "AIAutoReplyMessageShowStatus", "AIAutoReplyTrackReport", "AIBootMessageReceive", "AIBootMessageShowFailed", "PersonalizedStrategyResult", "PersonalizedChannelUplinkNotify", "PersonalizedChannelChange", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event AIAutoReplyMessageReceive = null;
        public static final Event AIAutoReplyMessageShowStatus = null;
        public static final Event AIAutoReplyTrackReport = null;
        public static final Event AIBootMessageReceive = null;
        public static final Event AIBootMessageShowFailed = null;
        public static final Event AICloneInit = null;
        public static final Event AICloneInitFailed = null;
        public static final Event AnchorAsrInterrupted = null;
        public static final Event AnchorAsrMatch = null;
        public static final Event AnchorAsrSendComment = null;
        public static final Event AudioTransferError = null;
        public static final Event ChatChannelComment = null;
        public static final Event ChatChannelCreate = null;
        public static final Event ChatChannelCreateShowCost = null;
        public static final Event ChatChannelDissolve = null;
        public static final Event ChatChannelInvite = null;
        public static final Event ChatChannelInviteShowCost = null;
        public static final Event ChatChannelJoin = null;
        public static final Event ChatChannelQuit = null;
        public static final Event ChatChannelSettingSet = null;
        public static final Event ChatChannelSettingUpdate = null;
        public static final Event CommentDisable = null;
        public static final Event CommentIntercept = null;
        public static final Event CommentUserSend = null;
        public static final Event CommentUserSendSelfShow = null;
        public static final Event CostConfirmWindowClick = null;
        public static final Event CostConfirmWindowShow = null;
        public static final Event DanmakuShowLatency = null;
        public static final Event DanmakuSwitchClick = null;
        public static final Event Degrade = null;
        public static final Event DiggDisable = null;
        public static final Event FirstHistoryMessageEmpty = null;
        public static final Event FirstRealtimeMessageEmpty = null;
        public static final Event HighLevelNoMessageShowError = null;
        public static final Event IMFirstMessageEmpty = null;
        public static final Event ImageRecognition = null;
        public static final Event ImageRecognitionRequest = null;
        public static final Event InputPanelKeyboardLog = null;
        public static final Event InputPanelRequestShow = null;
        public static final Event InputPanelShow = null;
        public static final Event PersonalizedChannelChange = null;
        public static final Event PersonalizedChannelUplinkNotify = null;
        public static final Event PersonalizedStrategyResult = null;
        public static final Event PinControlStatus = null;
        public static final Event PinRequest = null;
        public static final Event PinReview = null;
        public static final Event PinShowStatus = null;
        public static final Event ProfileDiggDisable = null;
        public static final Event PublicScreenFirstShowError = null;
        public static final Event PublicScreenHeightError = null;
        public static final Event PublicScreenMessage = null;
        public static final Event PublicScreenMessageActionTypeUnexpected = null;
        public static final Event PublicScreenNoMessageShowError = null;
        public static final Event PublicScreenRealtimeExposureError = null;
        public static final Event PublicScreenRenderError = null;
        public static final Event PublicScreenRoomExposureError = null;
        public static final Event PublicScreenShowStatus = null;
        public static final Event PublicScreenVisibilityChange = null;
        public static final Event ReceiveOpenCommentPanelEvent = null;
        public static final Event SpeechEngineError = null;
        public static final Event SpeechEngineInit = null;
        public static final Event SpeechEngineInstallPlugin = null;
        public static final Event SpeechEngineLoadPlugin = null;
        public static final Event SpeechEngineStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f133300a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f133300a.clone();
        }

        static {
            LiveTracingMonitor.EventModule r110 = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
            Event r100 = new Event("PublicScreenMessage", 0, "ttlive_text_message_apm", r110, true, false);
            PublicScreenMessage = r100;
            boolean r111 = false;
            int r112 = 8;
            DefaultConstructorMarker r113 = null;
            Event r101 = new Event("PublicScreenShowStatus", 1, "ttlive_public_screen_show_status", r110, true, r111, r112, r113);
            PublicScreenShowStatus = r101;
            boolean r114 = false;
            Event r102 = new Event("PublicScreenHeightError", 2, "ttlive_public_screen_height_error", r110, r114, r111, r112, r113);
            PublicScreenHeightError = r102;
            Event r103 = new Event("PublicScreenRenderError", 3, "ttlive_public_screen_render_error", r110, r114, r111, r112, r113);
            PublicScreenRenderError = r103;
            Event r104 = new Event("PublicScreenMessageActionTypeUnexpected", 4, "ttlive_public_screen_message_action_unexpected", r110, r114, r111, r112, r113);
            PublicScreenMessageActionTypeUnexpected = r104;
            boolean r115 = true;
            Event r105 = new Event("PublicScreenRoomExposureError", 5, "ttlive_public_screen_room_exposure_error", r110, r115, r111, r112, r113);
            PublicScreenRoomExposureError = r105;
            Event r106 = new Event("PublicScreenRealtimeExposureError", 6, "ttlive_public_screen_realtime_exposure_error", r110, r115, r111, r112, r113);
            PublicScreenRealtimeExposureError = r106;
            Event r107 = new Event("PublicScreenFirstShowError", 7, "ttlive_public_screen_first_show_error", r110, r115, r111, r112, r113);
            PublicScreenFirstShowError = r107;
            Event r108 = new Event("PublicScreenNoMessageShowError", 8, "ttlive_public_screen_no_message_show_error", r110, r115, r111, r112, r113);
            PublicScreenNoMessageShowError = r108;
            Event r109 = new Event("HighLevelNoMessageShowError", 9, "ttlive_high_level_no_message_show_error", r110, r115, r111, r112, r113);
            HighLevelNoMessageShowError = r109;
            boolean r116 = false;
            boolean r117 = false;
            int r118 = 8;
            DefaultConstructorMarker r119 = null;
            Event r120 = new Event("CommentUserSend", 10, "ttlive_comment_user_send_all", LiveTracingMonitor.EventModule.ROOM_APM, r116, r117, r118, r119);
            CommentUserSend = r120;
            LiveTracingMonitor.EventModule r121 = LiveTracingMonitor.EventModule.COMMENT;
            Event r122 = new Event("CommentUserSendSelfShow", 11, "ttlive_comment_user_send_self_show", r121, r116, r117, r118, r119);
            CommentUserSendSelfShow = r122;
            boolean r123 = true;
            boolean r124 = false;
            int r125 = 8;
            DefaultConstructorMarker r126 = null;
            Event r127 = new Event("CommentDisable", 12, "ttlive_comment_disable", r121, r123, r124, r125, r126);
            CommentDisable = r127;
            Event r128 = new Event("CommentIntercept", 13, "ttlive_comment_intercept", r121, r123, r124, r125, r126);
            CommentIntercept = r128;
            boolean r129 = true;
            boolean r130 = false;
            int r131 = 8;
            DefaultConstructorMarker r132 = null;
            Event r133 = new Event("AudioTransferError", 14, "ttlive_audio_transfer_error", LiveTracingMonitor.EventModule.AUDIO, r129, r130, r131, r132);
            AudioTransferError = r133;
            LiveTracingMonitor.EventModule r134 = LiveTracingMonitor.EventModule.DIGG;
            Event r135 = new Event("DiggDisable", 15, "ttlive_digg_disable", r134, r129, r130, r131, r132);
            DiggDisable = r135;
            Event r136 = new Event("ProfileDiggDisable", 16, "ttlive_profile_digg_disable", r134, r123, r124, r125, r126);
            ProfileDiggDisable = r136;
            LiveTracingMonitor.EventModule r137 = LiveTracingMonitor.EventModule.PIN_COMMENT;
            Event r138 = new Event("PinControlStatus", 17, "ttlive_pin_control_status", r137, false, false, 8, null);
            PinControlStatus = r138;
            boolean r139 = false;
            Event r140 = new Event("PinShowStatus", 18, "ttlive_pin_show_status", r137, r139, r124, r125, r126);
            PinShowStatus = r140;
            Event r141 = new Event("PinRequest", 19, "ttlive_pin_request", r137, r139, r124, r125, r126);
            PinRequest = r141;
            Event r142 = new Event("PinReview", 20, "ttlive_pin_review", r137, r139, r124, r125, r126);
            PinReview = r142;
            LiveTracingMonitor.EventModule r143 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
            Event r144 = new Event("IMFirstMessageEmpty", 21, "ttlive_im_first_message_empty", r143, true, false, 8, null);
            IMFirstMessageEmpty = r144;
            boolean r145 = true;
            Event r146 = new Event("FirstHistoryMessageEmpty", 22, "ttlive_first_history_message_empty", r143, r145, r124, r125, r126);
            FirstHistoryMessageEmpty = r146;
            Event r147 = new Event("FirstRealtimeMessageEmpty", 23, "ttlive_first_realtime_message_empty", r143, r145, r124, r125, r126);
            FirstRealtimeMessageEmpty = r147;
            Event r148 = new Event("DanmakuShowLatency", 24, "ttlive_danmaku_show_latency", LiveTracingMonitor.EventModule.DANMAKU, false, false, 8, null);
            DanmakuShowLatency = r148;
            LiveTracingMonitor.EventModule r149 = LiveTracingMonitor.EventModule.CHAT_CHANNEL;
            Event r150 = new Event("ChatChannelCreate", 25, "ttlive_chat_channel_create", r149, true, true);
            ChatChannelCreate = r150;
            Event r151 = new Event("ChatChannelInvite", 26, "ttlive_chat_channel_invite", r149, true, true);
            ChatChannelInvite = r151;
            Event r152 = new Event("ChatChannelJoin", 27, "ttlive_chat_channel_join", r149, true, true);
            ChatChannelJoin = r152;
            Event r153 = new Event("ChatChannelQuit", 28, "ttlive_chat_channel_quit", r149, true, true);
            ChatChannelQuit = r153;
            Event r154 = new Event("ChatChannelDissolve", 29, "ttlive_chat_channel_dissolve", r149, true, true);
            ChatChannelDissolve = r154;
            Event r155 = new Event("ChatChannelComment", 30, "ttlive_chat_channel_comment", r149, true, true);
            ChatChannelComment = r155;
            Event r156 = new Event("ChatChannelSettingSet", 31, "ttlive_chat_channel_setting_set", r149, true, true);
            ChatChannelSettingSet = r156;
            Event r157 = new Event("ChatChannelSettingUpdate", 32, "ttlive_chat_channel_setting_update", r149, true, true);
            ChatChannelSettingUpdate = r157;
            Event r158 = new Event("ChatChannelCreateShowCost", 33, "ttlive_chat_channel_create_show", r149, true, true);
            ChatChannelCreateShowCost = r158;
            Event r159 = new Event("ChatChannelInviteShowCost", 34, "ttlive_chat_channel_invite_show", r149, true, true);
            ChatChannelInviteShowCost = r159;
            LiveTracingMonitor.EventModule r160 = LiveTracingMonitor.EventModule.ANCHOR_ASR;
            Event r161 = new Event("SpeechEngineInstallPlugin", 35, "ttlive_speech_engine_install_plugin", r160, true, true);
            SpeechEngineInstallPlugin = r161;
            Event r162 = new Event("SpeechEngineLoadPlugin", 36, "ttlive_speech_engine_load_plugin", r160, true, true);
            SpeechEngineLoadPlugin = r162;
            Event r163 = new Event("SpeechEngineInit", 37, "ttlive_speech_engine_init", r160, true, true);
            SpeechEngineInit = r163;
            Event r164 = new Event("SpeechEngineStart", 38, "ttlive_speech_engine_start", r160, true, true);
            SpeechEngineStart = r164;
            Event r165 = new Event("SpeechEngineError", 39, "ttlive_speech_engine_error", r160, true, true);
            SpeechEngineError = r165;
            Event r166 = new Event("AnchorAsrInterrupted", 40, "ttlive_anchor_asr_interrupted", r160, true, true);
            AnchorAsrInterrupted = r166;
            Event r167 = new Event("AnchorAsrMatch", 41, "ttlive_anchor_asr_match", r160, true, true);
            AnchorAsrMatch = r167;
            Event r168 = new Event("AnchorAsrSendComment", 42, "ttlive_anchor_asr_send_comment", r160, true, true);
            AnchorAsrSendComment = r168;
            LiveTracingMonitor.EventModule r169 = LiveTracingMonitor.EventModule.IMAGE_RECOGNITION;
            Event r170 = new Event("ImageRecognition", 43, "ttlive_image_recognition", r169, true, true);
            ImageRecognition = r170;
            Event r171 = new Event("ImageRecognitionRequest", 44, "ttlive_image_recognition_request", r169, true, true);
            ImageRecognitionRequest = r171;
            Event r172 = new Event("Degrade", 45, "ttlive_interactivity_degrade_happen", LiveTracingMonitor.EventModule.INTERACTIVITY_DEGRADE, true, true);
            Degrade = r172;
            LiveTracingMonitor.EventModule r173 = LiveTracingMonitor.EventModule.INPUT_PANEL;
            Event r174 = new Event("ReceiveOpenCommentPanelEvent", 46, "ttlive_input_panel_receive_lottery_jsb_event", r173, true, true);
            ReceiveOpenCommentPanelEvent = r174;
            Event r175 = new Event("InputPanelRequestShow", 47, "ttlive_input_panel_request_show_event", r173, true, true);
            InputPanelRequestShow = r175;
            Event r176 = new Event("InputPanelShow", 48, "ttlive_input_panel_show", r173, true, true);
            InputPanelShow = r176;
            Event r177 = new Event("InputPanelKeyboardLog", 49, "ttlive_input_panel_keyboard_log", r173, true, true);
            InputPanelKeyboardLog = r177;
            Event r178 = new Event("CostConfirmWindowShow", 50, "ttlive_input_panel_danmaku_cost_tip_show", r173, true, true);
            CostConfirmWindowShow = r178;
            Event r179 = new Event("CostConfirmWindowClick", 51, "ttlive_input_panel_danmaku_cost_tip_click", r173, true, true);
            CostConfirmWindowClick = r179;
            Event r180 = new Event("DanmakuSwitchClick", 52, "ttlive_input_panel_danmaku_switch_click", r173, true, true);
            DanmakuSwitchClick = r180;
            Event r181 = new Event("PublicScreenVisibilityChange", 53, "ttlive_public_screen_visibility_change", r110, true, true);
            PublicScreenVisibilityChange = r181;
            LiveTracingMonitor.EventModule r182 = LiveTracingMonitor.EventModule.AI_CLONE;
            Event r183 = new Event("AICloneInit", 54, "ttlive_ai_clone_init", r182, true, true);
            AICloneInit = r183;
            Event r184 = new Event("AICloneInitFailed", 55, "ttlive_ai_clone_init_failed", r182, true, true);
            AICloneInitFailed = r184;
            Event r185 = new Event("AIAutoReplyMessageReceive", 56, "ttlive_ai_auto_reply_message_receive", r182, true, true);
            AIAutoReplyMessageReceive = r185;
            Event r186 = new Event("AIAutoReplyMessageShowStatus", 57, "ttlive_ai_auto_reply_message_show_status", r182, true, true);
            AIAutoReplyMessageShowStatus = r186;
            Event r187 = new Event("AIAutoReplyTrackReport", 58, "ttlive_ai_auto_reply_message_track_report", r182, true, true);
            AIAutoReplyTrackReport = r187;
            Event r188 = new Event("AIBootMessageReceive", 59, "ttlive_ai_boot_message_receive", r182, true, true);
            AIBootMessageReceive = r188;
            Event r189 = new Event("AIBootMessageShowFailed", 60, "ttlive_ai_boot_message_show_failed", r182, true, true);
            AIBootMessageShowFailed = r189;
            LiveTracingMonitor.EventModule r190 = LiveTracingMonitor.EventModule.PERSONALIZED_CHANNEL;
            Event r191 = new Event("PersonalizedStrategyResult", 61, "ttlive_personalized_strategy_change", r190, true, true);
            PersonalizedStrategyResult = r191;
            Event r192 = new Event("PersonalizedChannelUplinkNotify", 62, "ttlive_personalized_channel_uplink_notify", r190, true, true);
            PersonalizedChannelUplinkNotify = r192;
            Event r193 = new Event("PersonalizedChannelChange", 63, "ttlive_personalized_channel_change", r190, true, true);
            PersonalizedChannelChange = r193;
            f133300a = new Event[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r120, r122, r127, r128, r133, r135, r136, r138, r140, r141, r142, r144, r146, r147, r148, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r161, r162, r163, r164, r165, r166, r167, r168, r170, r171, r172, r174, r175, r176, r177, r178, r179, r180, r181, r183, r184, r185, r186, r187, r188, r189, r191, r192, r193};
        }

        public final LiveTracingMonitor.EventModule getEventModule() {
            return this.eventModule;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final boolean getExtraALog() {
            return this.extraALog;
        }

        public final boolean getReportInLocalTest() {
            return this.reportInLocalTest;
        }

        public Event(String r100, int r101, String r102, LiveTracingMonitor.EventModule r103, boolean r104, boolean r105) {
            super(r100, r101);
            this.eventName = r102;
            this.eventModule = r103;
            this.extraALog = r104;
            this.reportInLocalTest = r105;
        }

        public /* synthetic */ Event(String r100, int r101, String r110, LiveTracingMonitor.EventModule r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
            if ((r114 & 4) == 0) goto L5;
            boolean r102 = false;
        L7:
            if ((r114 & 8) == 0) goto L9;
            boolean r103 = true;
        L10:
            this(r100, r101, r110, r111, r102, r103);
            return;
        L9:
            r103 = r113;
            goto L10
        L5:
            r102 = r112;
            goto L7
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(Event r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        c(r100, r101, 1, null, 24);
    }

    @JvmStatic
    public static final LiveMonitor.a a(Event r100, IRoom r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        LiveMonitor.a r103 = new LiveMonitor.a(r100.getEventName(), r100.getEventModule());
        if (r101 == null) goto L33;
        LiveMode r104 = r101.getStreamType();
        int r105 = h1.f66189a;
        r103.e("category_1", i1.a(r104));
        String r106 = r101.getOwnerUserIdString();
        boolean r107 = false;
        if (r106 == null) goto L29;
        IMiddlewareUserService r108 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r108 == null) goto L29;
        com.bytedance.android.livesdk.user.e r109 = r108.user();
        if (r109 == null) goto L29;
        String r110 = r109.n();
        if (r110 == null) goto L29;
        if (r106.length() <= 0) goto L17;
        boolean r111 = true;
    L18:
        if (r111 == false) goto L29;
        if (r110.length() <= 0) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == false) goto L29;
        if ((!Intrinsics.areEqual("0", r110)) == false) goto L29;
        if (Intrinsics.areEqual(r106, r110) == false) goto L29;
        r107 = true;
        goto L29
    L22:
        r112 = false;
        goto L23
    L17:
        r111 = false;
    L29:
        if (r107 == false) goto L31;
        String r113 = "anchor";
    L32:
        r103.e("category_2", r113);
        r103.i("room_id", String.valueOf(r101.getRoomId()));
        r103.i("anchor_id", r101.getOwnerUserIdString());
        goto L33
    L31:
        r113 = SourceType.DEFAULT;
    L33:
        if (r102 == null) goto L35;
        r103.i(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r102);
    L35:
        r103.f64903f = r100.getExtraALog();
        r103.f64905h = r100.getReportInLocalTest();
        return r103;
    }

    public static void c(Event r100, IRoom r101, Integer r102, String r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "event");
        LiveMonitor.a r105 = a(r100, r101, null);
        if (r102 == null) goto L8;
        r102.intValue();
        r105.l(r102.intValue());
    L8:
        if (r103 == null) goto L10;
        r105.e("status", r103);
    L10:
        r105.a().report();
    }
}
