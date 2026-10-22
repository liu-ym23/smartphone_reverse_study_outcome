package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/message/UITranslation;", "getUiTranslation", "()Lcom/bytedance/android/livesdkapi/depend/message/UITranslation;", "setUiTranslation", "(Lcom/bytedance/android/livesdkapi/depend/message/UITranslation;)V", "getUiTranslation$annotations", "()V", "uiTranslation", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUiFeatureList", "()Ljava/util/List;", "setUiFeatureList", "(Ljava/util/List;)V", "getUiFeatureList$annotations", "uiFeatureList", "Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo;", "getAudioChatCycle", "()Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo;", "setAudioChatCycle", "(Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo;)V", "getAudioChatCycle$annotations", "audioChatCycle", "Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;", "getRealTimeChorusInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;", "setRealTimeChorusInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;)V", "getRealTimeChorusInfo$annotations", "realTimeChorusInfo", "Lcom/bytedance/android/livesdkapi/depend/message/VideoChatDynamic1V7Info;", "getVideoChatDynamic1V7Info", "()Lcom/bytedance/android/livesdkapi/depend/message/VideoChatDynamic1V7Info;", "setVideoChatDynamic1V7Info", "(Lcom/bytedance/android/livesdkapi/depend/message/VideoChatDynamic1V7Info;)V", "getVideoChatDynamic1V7Info$annotations", "videoChatDynamic1V7Info", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "getCrossRoomLinkmic", "()Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "setCrossRoomLinkmic", "(Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;)V", "getCrossRoomLinkmic$annotations", "crossRoomLinkmic", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ClientUIInfo extends c<ClientUIInfo> {
    public static final Companion Companion = null;
    public static final int UIFeature_AiSummary = 1001;
    public static final int UIFeature_Announcement = 1;
    public static final int UIFeature_CanvasEnlarge = 1002;
    public static final int UIFeature_ClassicTeamFight = 4;
    public static final int UIFeature_CustomizeStream = 8;
    public static final int UIFeature_FlexibleTeamFight = 3;
    public static final int UIFeature_None = 0;
    public static final int UIFeature_OrderSongStage = 5;
    public static final int UIFeature_StartWishStage = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo$Companion;", "", "()V", "UIFeature_AiSummary", "", "UIFeature_Announcement", "UIFeature_CanvasEnlarge", "UIFeature_ClassicTeamFight", "UIFeature_CustomizeStream", "UIFeature_FlexibleTeamFight", "UIFeature_None", "UIFeature_OrderSongStage", "UIFeature_StartWishStage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int UIFeature_AiSummary = 1001;
        public static final int UIFeature_Announcement = 1;
        public static final int UIFeature_CanvasEnlarge = 1002;
        public static final int UIFeature_ClassicTeamFight = 4;
        public static final int UIFeature_CustomizeStream = 8;
        public static final int UIFeature_FlexibleTeamFight = 3;
        public static final int UIFeature_None = 0;
        public static final int UIFeature_OrderSongStage = 5;
        public static final int UIFeature_StartWishStage = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "audio_chat_cycle")
        public static /* synthetic */ void getAudioChatCycle$annotations() {
        }

        @FieldName(name = "cross_room_linkmic")
        public static /* synthetic */ void getCrossRoomLinkmic$annotations() {
        }

        @FieldName(name = "real_time_chorus")
        public static /* synthetic */ void getRealTimeChorusInfo$annotations() {
        }

        @FieldName(name = "ui_feature_list")
        public static /* synthetic */ void getUiFeatureList$annotations() {
        }

        @FieldName(name = "ui_translation")
        public static /* synthetic */ void getUiTranslation$annotations() {
        }

        @FieldName(name = "video_chat_dynamic_1v7")
        public static /* synthetic */ void getVideoChatDynamic1V7Info$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "audio_chat_cycle")
    AudioChatCycleUIInfo getAudioChatCycle();

    @FieldName(name = "cross_room_linkmic")
    CrossRoomLinkmicUIInfo getCrossRoomLinkmic();

    @FieldName(name = "real_time_chorus")
    RealTimeChorusUIInfo getRealTimeChorusInfo();

    @FieldName(name = "ui_feature_list")
    List<Integer> getUiFeatureList();

    @FieldName(name = "ui_translation")
    UITranslation getUiTranslation();

    @FieldName(name = "video_chat_dynamic_1v7")
    VideoChatDynamic1V7Info getVideoChatDynamic1V7Info();

    @FieldName(name = "audio_chat_cycle#setter")
    void setAudioChatCycle(AudioChatCycleUIInfo r100);

    @FieldName(name = "cross_room_linkmic#setter")
    void setCrossRoomLinkmic(CrossRoomLinkmicUIInfo r100);

    @FieldName(name = "real_time_chorus#setter")
    void setRealTimeChorusInfo(RealTimeChorusUIInfo r100);

    @FieldName(name = "ui_feature_list#setter")
    void setUiFeatureList(List<Integer> r100);

    @FieldName(name = "ui_translation#setter")
    void setUiTranslation(UITranslation r100);

    @FieldName(name = "video_chat_dynamic_1v7#setter")
    void setVideoChatDynamic1V7Info(VideoChatDynamic1V7Info r100);
}
