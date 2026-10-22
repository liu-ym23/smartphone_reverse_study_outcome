package com.bytedance.android.livesdkapi.interact.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/data/LinkConstantKt;", "", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkConstantKt {
    public static final Companion Companion = null;
    public static final int ERROR_CODE_CONTINUE_ROOM_CLOSED = 31001;
    public static final int ERROR_CODE_LINKED_TOO_MUCH = 31101;
    public static final int ERROR_CODE_NO_ONLINE_ROOM = 10001;
    public static final int ERROR_LINK_PREPARE_REPLY_TIME_OUT = 4004470;
    public static final int ERROR_LINK_PRICE_OR_TIME_CHANGE = 4004090;
    public static final int ERROR_LINK_UNSILENCE_DOUBLE_CHECK = 4004468;
    public static final int ERROR_STRONG_REACH_APPLY_FAILED = 4004091;
    public static final int LAYOUT_AUDIENCE_INTERACT = 1;
    public static final int LAYOUT_KTV = 64;
    public static final int LAYOUT_RADIO_1V8 = 8;
    public static final int LAYOUT_VIDEO_TALK = 16;
    public static final int LIVE_CORE_DEFAULT_RESOLUTION_HEIGHT = 864;
    public static final int LIVE_CORE_DEFAULT_RESOLUTION_WIDTH = 480;
    public static final int OPT_DEFAULT_RESOLUTION = 16;
    public static final int SEI_STYLE_NORMAL = 0;
    public static final int SEI_VERSION_C_VIDEO_CAMERA = 12;
    public static final int SEI_VERSION_GAME_DYNAMIC_1V8 = 30;
    public static final int SEI_VERSION_GAME_FIX_1V8 = 35;
    public static final int SEI_VERSION_GROUP_LIVE_GAME = 37;
    public static final int SEI_VERSION_LINK_ROOM = 17;
    public static final int SEI_VERSION_LINK_ROOM_1V1 = 33;
    public static final int SEI_VERSION_LINK_ROOM_1V6 = 31;
    public static final int SEI_VERSION_LINK_ROOM_6V1 = 32;
    public static final int SEI_VERSION_LINK_ROOM_9V9 = 39;
    public static final int SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_16X9 = 23;
    public static final int SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_4X3 = 24;
    public static final int SEI_VERSION_RADIO = 3;
    public static final int SEI_VERSION_VIDEO_CAMERA = 8;
    public static final int SEI_VERSION_VIDEO_CAMERA_DYNAMIC = 15;
    public static final int SEI_VERSION_VIDEO_CAMERA_NEW = 10;
    public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V6_COMPACT = 26;
    public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8 = 25;
    public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8_COMPACT = 27;
    public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_FIX_LAYOUT_1V8 = 28;
    public static final int SUPPORT_VENDOR = 4;
    public static final String TAG = "ttlive_link";
    public static final int VENDOR_BYTE = 4;
    public static final String VOICE_CHAT = "voice_chat";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/data/LinkConstantKt$Companion;", "", "()V", "ERROR_CODE_CONTINUE_ROOM_CLOSED", "", "ERROR_CODE_LINKED_TOO_MUCH", "ERROR_CODE_NO_ONLINE_ROOM", "ERROR_LINK_PREPARE_REPLY_TIME_OUT", "ERROR_LINK_PRICE_OR_TIME_CHANGE", "ERROR_LINK_UNSILENCE_DOUBLE_CHECK", "ERROR_STRONG_REACH_APPLY_FAILED", "LAYOUT_AUDIENCE_INTERACT", "LAYOUT_KTV", "LAYOUT_RADIO_1V8", "LAYOUT_VIDEO_TALK", "LIVE_CORE_DEFAULT_RESOLUTION_HEIGHT", "LIVE_CORE_DEFAULT_RESOLUTION_WIDTH", "OPT_DEFAULT_RESOLUTION", "SEI_STYLE_NORMAL", "SEI_VERSION_C_VIDEO_CAMERA", "SEI_VERSION_GAME_DYNAMIC_1V8", "SEI_VERSION_GAME_FIX_1V8", "SEI_VERSION_GROUP_LIVE_GAME", "SEI_VERSION_LINK_ROOM", "SEI_VERSION_LINK_ROOM_1V1", "SEI_VERSION_LINK_ROOM_1V6", "SEI_VERSION_LINK_ROOM_6V1", "SEI_VERSION_LINK_ROOM_9V9", "SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_16X9", "SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_4X3", "SEI_VERSION_RADIO", "SEI_VERSION_VIDEO_CAMERA", "SEI_VERSION_VIDEO_CAMERA_DYNAMIC", "SEI_VERSION_VIDEO_CAMERA_NEW", "SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V6_COMPACT", "SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8", "SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8_COMPACT", "SEI_VERSION_VIDEO_EQUAL_CENTER_FIX_LAYOUT_1V8", "STREAM_BACKGROUND", "", "getSTREAM_BACKGROUND", "()Ljava/lang/String;", "setSTREAM_BACKGROUND", "(Ljava/lang/String;)V", "SUPPORT_VENDOR", "TAG", "VENDOR_BYTE", "VOICE_CHAT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ERROR_CODE_CONTINUE_ROOM_CLOSED = 31001;
        public static final int ERROR_CODE_LINKED_TOO_MUCH = 31101;
        public static final int ERROR_CODE_NO_ONLINE_ROOM = 10001;
        public static final int ERROR_LINK_PREPARE_REPLY_TIME_OUT = 4004470;
        public static final int ERROR_LINK_PRICE_OR_TIME_CHANGE = 4004090;
        public static final int ERROR_LINK_UNSILENCE_DOUBLE_CHECK = 4004468;
        public static final int ERROR_STRONG_REACH_APPLY_FAILED = 4004091;
        public static final int LAYOUT_AUDIENCE_INTERACT = 1;
        public static final int LAYOUT_KTV = 64;
        public static final int LAYOUT_RADIO_1V8 = 8;
        public static final int LAYOUT_VIDEO_TALK = 16;
        public static final int LIVE_CORE_DEFAULT_RESOLUTION_HEIGHT = 864;
        public static final int LIVE_CORE_DEFAULT_RESOLUTION_WIDTH = 480;
        public static final int OPT_DEFAULT_RESOLUTION = 16;
        public static final int SEI_STYLE_NORMAL = 0;
        public static final int SEI_VERSION_C_VIDEO_CAMERA = 12;
        public static final int SEI_VERSION_GAME_DYNAMIC_1V8 = 30;
        public static final int SEI_VERSION_GAME_FIX_1V8 = 35;
        public static final int SEI_VERSION_GROUP_LIVE_GAME = 37;
        public static final int SEI_VERSION_LINK_ROOM = 17;
        public static final int SEI_VERSION_LINK_ROOM_1V1 = 33;
        public static final int SEI_VERSION_LINK_ROOM_1V6 = 31;
        public static final int SEI_VERSION_LINK_ROOM_6V1 = 32;
        public static final int SEI_VERSION_LINK_ROOM_9V9 = 39;
        public static final int SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_16X9 = 23;
        public static final int SEI_VERSION_PC_LANDSCAPE_DYNAMIC_FLOAT_4X3 = 24;
        public static final int SEI_VERSION_RADIO = 3;
        public static final int SEI_VERSION_VIDEO_CAMERA = 8;
        public static final int SEI_VERSION_VIDEO_CAMERA_DYNAMIC = 15;
        public static final int SEI_VERSION_VIDEO_CAMERA_NEW = 10;
        public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V6_COMPACT = 26;
        public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8 = 25;
        public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_DYNAMIC_LAYOUT_1V8_COMPACT = 27;
        public static final int SEI_VERSION_VIDEO_EQUAL_CENTER_FIX_LAYOUT_1V8 = 28;
        private static String STREAM_BACKGROUND = null;
        public static final int SUPPORT_VENDOR = 4;
        public static final String TAG = "ttlive_link";
        public static final int VENDOR_BYTE = 4;
        public static final String VOICE_CHAT = "voice_chat";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            if (FlavorKt.isSaas() == false) goto L5;
            String r100 = "#1F212C";
        L6:
            STREAM_BACKGROUND = r100;
            return;
        L5:
            r100 = "#322542";
            goto L6
        }

        public final String getSTREAM_BACKGROUND() {
            return STREAM_BACKGROUND;
        }

        public final void setSTREAM_BACKGROUND(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            STREAM_BACKGROUND = r100;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
