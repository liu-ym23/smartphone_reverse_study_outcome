package com.bytedance.android.format.model;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.format.model.message.LiveMsgSugResp;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\rbcdefghijklmnB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010a\u001a\u00020\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R&\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u0016\u00101\u001a\u0002028\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00104\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010?\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R \u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR \u0010N\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010T\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010Z\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00108R\u0018\u0010]\u001a\u0004\u0018\u00010^8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`¨\u0006o"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom;", "Ljava/io/Serializable;", "()V", "avatarInfo", "Lcom/bytedance/android/format/model/FormatLiveRoom$AvatarInfo;", "getAvatarInfo", "()Lcom/bytedance/android/format/model/FormatLiveRoom$AvatarInfo;", "setAvatarInfo", "(Lcom/bytedance/android/format/model/FormatLiveRoom$AvatarInfo;)V", "characterInfo", "Lcom/bytedance/android/format/model/FormatLiveRoom$CharacterInfo;", "getCharacterInfo", "()Lcom/bytedance/android/format/model/FormatLiveRoom$CharacterInfo;", "setCharacterInfo", "(Lcom/bytedance/android/format/model/FormatLiveRoom$CharacterInfo;)V", "chatWithInterrupt", "", "getChatWithInterrupt", "()Ljava/lang/Boolean;", "setChatWithInterrupt", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "customConfig", "Lcom/bytedance/android/format/model/FormatLiveRoom$CustomConfig;", "getCustomConfig", "()Lcom/bytedance/android/format/model/FormatLiveRoom$CustomConfig;", "setCustomConfig", "(Lcom/bytedance/android/format/model/FormatLiveRoom$CustomConfig;)V", "enterTip", "", "getEnterTip", "()Ljava/lang/String;", "setEnterTip", "(Ljava/lang/String;)V", "enterTipLinks", "", "Lcom/bytedance/android/format/model/FormatLiveRoom$EnterTipLink;", "getEnterTipLinks", "()Ljava/util/List;", "setEnterTipLinks", "(Ljava/util/List;)V", "extra", "", "getExtra", "()Ljava/util/Map;", "playTimeLine", "Lcom/bytedance/android/format/model/FormatLiveRoom$TimelineEvent;", "getPlayTimeLine", "setPlayTimeLine", "playType", "", "getPlayType", "()I", "protocolType", "getProtocolType", "setProtocolType", "(I)V", "punishInfo", "Lcom/bytedance/android/format/model/UserPunishInfo;", "getPunishInfo", "()Lcom/bytedance/android/format/model/UserPunishInfo;", "setPunishInfo", "(Lcom/bytedance/android/format/model/UserPunishInfo;)V", "roomId", "getRoomId", "setRoomId", "rtcInfo", "Lcom/bytedance/android/format/model/FormatLiveRoom$RtcInfo;", "getRtcInfo", "()Lcom/bytedance/android/format/model/FormatLiveRoom$RtcInfo;", "setRtcInfo", "(Lcom/bytedance/android/format/model/FormatLiveRoom$RtcInfo;)V", "sliceItemInfo", "Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "getSliceItemInfo", "()Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "setSliceItemInfo", "(Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;)V", "stream_info", "Lcom/bytedance/android/format/model/FormatLiveRoom$StreamInfo;", "getStream_info", "()Lcom/bytedance/android/format/model/FormatLiveRoom$StreamInfo;", "setStream_info", "(Lcom/bytedance/android/format/model/FormatLiveRoom$StreamInfo;)V", "sugInfo", "Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "getSugInfo", "()Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "setSugInfo", "(Lcom/bytedance/android/format/model/message/LiveMsgSugResp;)V", "taskType", "getTaskType", "setTaskType", "userData", "Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "getUserData", "()Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "hasVoice", "AvatarInfo", "CharacterInfo", "CustomConfig", "DefaultQuality", "EnterTipLink", "PlayType", "ProtocolType", "RtcInfo", "SliceItemInfo", "StreamInfo", "TimeLineEventType", "TimelineEvent", "UserData", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatLiveRoom implements Serializable {

    @SerializedName("avatar_info")
    private AvatarInfo avatarInfo;

    @SerializedName("character_info")
    private CharacterInfo characterInfo;

    @SerializedName("chat_with_interrupt")
    private Boolean chatWithInterrupt;

    @SerializedName("custom_config")
    private CustomConfig customConfig;

    @SerializedName("enter_tip")
    private String enterTip;

    @SerializedName("enter_tip_links")
    private List<EnterTipLink> enterTipLinks;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("play_timeline")
    private List<TimelineEvent> playTimeLine;

    @SerializedName("play_type")
    private final int playType;

    @SerializedName("room_protocol_type")
    private int protocolType;

    @SerializedName("user_punish_info")
    private UserPunishInfo punishInfo;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("rtc_info")
    private RtcInfo rtcInfo;

    @SerializedName("slice_item_info")
    private SliceItemInfo sliceItemInfo;

    @SerializedName("stream_info")
    private StreamInfo stream_info;

    @SerializedName("ai_interactive_sug_info")
    private LiveMsgSugResp sugInfo;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private int taskType;

    @SerializedName("user_data")
    private final UserData userData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$AvatarInfo;", "Ljava/io/Serializable;", "()V", "avatarLarge", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarLarge", "()Lcom/bytedance/android/live/base/model/ImageModel;", "avatarMedium", "getAvatarMedium", "avatarThumb", "getAvatarThumb", "avatarUid", "", "getAvatarUid", "()J", "formatId", "getFormatId", "isFormatOpened", "", "()Z", "nickName", "", "getNickName", "()Ljava/lang/String;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AvatarInfo implements Serializable {

        @SerializedName("avatar_large")
        private final ImageModel avatarLarge;

        @SerializedName("avatar_medium")
        private final ImageModel avatarMedium;

        @SerializedName("avatar_thumb")
        private final ImageModel avatarThumb;

        @SerializedName("uid")
        private final long avatarUid;

        @SerializedName("format_id")
        private final long formatId;

        @SerializedName("is_format_opened")
        private final boolean isFormatOpened;

        @SerializedName("nick_name")
        private final String nickName;

        public AvatarInfo() {
        }

        public final ImageModel getAvatarLarge() {
            return this.avatarLarge;
        }

        public final ImageModel getAvatarMedium() {
            return this.avatarMedium;
        }

        public final ImageModel getAvatarThumb() {
            return this.avatarThumb;
        }

        public final long getAvatarUid() {
            return this.avatarUid;
        }

        public final long getFormatId() {
            return this.formatId;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final boolean isFormatOpened() {
            return this.isFormatOpened;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$CharacterInfo;", "Ljava/io/Serializable;", "()V", "actionId", "", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "enableHotLoad", "", "getEnableHotLoad", "()Z", "setEnableHotLoad", "(Z)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "gameChannel", "getGameChannel", "setGameChannel", "gameId", "getGameId", "setGameId", "roleAssetId", "getRoleAssetId", "setRoleAssetId", "sceneAssetId", "getSceneAssetId", "setSceneAssetId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CharacterInfo implements Serializable {

        @SerializedName("action_id")
        private String actionId;

        @SerializedName("enable_hot_load")
        private boolean enableHotLoad;

        @SerializedName("extra")
        private Map<String, String> extra;

        @SerializedName("game_channel")
        private String gameChannel;

        @SerializedName("game_id")
        private String gameId;

        @SerializedName("role_asset_id")
        private String roleAssetId;

        @SerializedName("scene_asset_id")
        private String sceneAssetId;

        public CharacterInfo() {
        }

        public final String getActionId() {
            return this.actionId;
        }

        public final boolean getEnableHotLoad() {
            return this.enableHotLoad;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getGameChannel() {
            return this.gameChannel;
        }

        public final String getGameId() {
            return this.gameId;
        }

        public final String getRoleAssetId() {
            return this.roleAssetId;
        }

        public final String getSceneAssetId() {
            return this.sceneAssetId;
        }

        public final void setActionId(String r100) {
            this.actionId = r100;
        }

        public final void setEnableHotLoad(boolean r100) {
            this.enableHotLoad = r100;
        }

        public final void setExtra(Map<String, String> r100) {
            this.extra = r100;
        }

        public final void setGameChannel(String r100) {
            this.gameChannel = r100;
        }

        public final void setGameId(String r100) {
            this.gameId = r100;
        }

        public final void setRoleAssetId(String r100) {
            this.roleAssetId = r100;
        }

        public final void setSceneAssetId(String r100) {
            this.sceneAssetId = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$CustomConfig;", "Ljava/io/Serializable;", "()V", "enableBgm", "", "getEnableBgm", "()Z", "setEnableBgm", "(Z)V", "enableMessageExpand", "getEnableMessageExpand", "setEnableMessageExpand", "messageHintStyle", "", "getMessageHintStyle", "()Ljava/lang/String;", "setMessageHintStyle", "(Ljava/lang/String;)V", "useVoiceInput", "getUseVoiceInput", "setUseVoiceInput", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CustomConfig implements Serializable {

        @SerializedName("enable_bgm")
        private boolean enableBgm;

        @SerializedName("enable_message_container_expand")
        private boolean enableMessageExpand;

        @SerializedName("message_hint_style")
        private String messageHintStyle;

        @SerializedName("voice_input")
        private boolean useVoiceInput;

        public CustomConfig() {
            this.messageHintStyle = "center";
        }

        public final boolean getEnableBgm() {
            return this.enableBgm;
        }

        public final boolean getEnableMessageExpand() {
            return this.enableMessageExpand;
        }

        public final String getMessageHintStyle() {
            return this.messageHintStyle;
        }

        public final boolean getUseVoiceInput() {
            return this.useVoiceInput;
        }

        public final void setEnableBgm(boolean r100) {
            this.enableBgm = r100;
        }

        public final void setEnableMessageExpand(boolean r100) {
            this.enableMessageExpand = r100;
        }

        public final void setMessageHintStyle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.messageHintStyle = r100;
        }

        public final void setUseVoiceInput(boolean r100) {
            this.useVoiceInput = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$DefaultQuality;", "Ljava/io/Serializable;", "()V", "fps", "", "getFps", "()I", "setFps", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "resolution", "getResolution", "setResolution", "sdkKey", "getSdkKey", "setSdkKey", "vBitRate", "getVBitRate", "setVBitRate", "vCodeC", "getVCodeC", "setVCodeC", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DefaultQuality implements Serializable {

        @SerializedName("fps")
        private int fps;

        @SerializedName("name")
        private String name;

        @SerializedName("resolution")
        private String resolution;

        @SerializedName("sdk_key")
        private String sdkKey;

        @SerializedName("v_bit_rate")
        private int vBitRate;

        @SerializedName("v_codec")
        private String vCodeC;

        public DefaultQuality() {
        }

        public final int getFps() {
            return this.fps;
        }

        public final String getName() {
            return this.name;
        }

        public final String getResolution() {
            return this.resolution;
        }

        public final String getSdkKey() {
            return this.sdkKey;
        }

        public final int getVBitRate() {
            return this.vBitRate;
        }

        public final String getVCodeC() {
            return this.vCodeC;
        }

        public final void setFps(int r100) {
            this.fps = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setResolution(String r100) {
            this.resolution = r100;
        }

        public final void setSdkKey(String r100) {
            this.sdkKey = r100;
        }

        public final void setVBitRate(int r100) {
            this.vBitRate = r100;
        }

        public final void setVCodeC(String r100) {
            this.vCodeC = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$EnterTipLink;", "Ljava/io/Serializable;", "()V", "link", "", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "originText", "getOriginText", "setOriginText", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EnterTipLink implements Serializable {

        @SerializedName("link")
        private String link;

        @SerializedName("origin_text")
        private String originText;

        public EnterTipLink() {
        }

        public final String getLink() {
            return this.link;
        }

        public final String getOriginText() {
            return this.originText;
        }

        public final void setLink(String r100) {
            this.link = r100;
        }

        public final void setOriginText(String r100) {
            this.originText = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$PlayType;", "", "", "type", "I", "getType", "()I", "Unknown", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V2", "V3", "V5", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Deprecated(message = "use FormatLivePlayType")
    public static final enum PlayType extends Enum<PlayType> {
        public static final PlayType Unknown = null;
        public static final PlayType V1 = null;
        public static final PlayType V2 = null;
        public static final PlayType V3 = null;
        public static final PlayType V5 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayType[] f51335a = null;
        private final int type;

        static {
            PlayType r100 = new PlayType("Unknown", 0, 0);
            Unknown = r100;
            PlayType r101 = new PlayType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1);
            V1 = r101;
            PlayType r102 = new PlayType("V2", 2, 2);
            V2 = r102;
            PlayType r103 = new PlayType("V3", 3, 3);
            V3 = r103;
            PlayType r104 = new PlayType("V5", 4, 5);
            V5 = r104;
            f51335a = new PlayType[]{r100, r101, r102, r103, r104};
        }

        public static PlayType valueOf(String r100) {
            return (PlayType) r27.a.a(PlayType.class, r100);
        }

        public static PlayType[] values() {
            return (PlayType[]) f51335a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public PlayType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$ProtocolType;", "", "", "type", "I", "getType", "()I", "UERTC", "RTMP", "EdgeRender", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ProtocolType extends Enum<ProtocolType> {
        public static final ProtocolType EdgeRender = null;
        public static final ProtocolType RTMP = null;
        public static final ProtocolType UERTC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProtocolType[] f51336a = null;
        private final int type;

        static {
            ProtocolType r100 = new ProtocolType("UERTC", 0, 0);
            UERTC = r100;
            ProtocolType r101 = new ProtocolType("RTMP", 1, 1);
            RTMP = r101;
            ProtocolType r102 = new ProtocolType("EdgeRender", 2, 2);
            EdgeRender = r102;
            f51336a = new ProtocolType[]{r100, r101, r102};
        }

        public static ProtocolType valueOf(String r100) {
            return (ProtocolType) r27.a.a(ProtocolType.class, r100);
        }

        public static ProtocolType[] values() {
            return (ProtocolType[]) f51336a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public ProtocolType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\b¨\u00067"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$RtcInfo;", "Ljava/io/Serializable;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "businessId", "getBusinessId", "setBusinessId", "clientUid", "getClientUid", "setClientUid", "extraConfig", "", "getExtraConfig", "()Ljava/util/Map;", "setExtraConfig", "(Ljava/util/Map;)V", "extraInfo", "getExtraInfo", "setExtraInfo", "noNeedPing", "", "getNoNeedPing", "()Z", "setNoNeedPing", "(Z)V", "pingIntervalMs", "", "getPingIntervalMs", "()Ljava/lang/Long;", "setPingIntervalMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "roomId", "getRoomId", "setRoomId", "rtcAbLabel", "getRtcAbLabel", "setRtcAbLabel", "serverUid", "getServerUid", "setServerUid", "token", "getToken", "setToken", "videoToken", "getVideoToken", "setVideoToken", "videoUid", "getVideoUid", "setVideoUid", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RtcInfo implements Serializable {

        @SerializedName("app_id")
        private String appId;

        @SerializedName(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID)
        private String businessId;

        @SerializedName("client_uid")
        private String clientUid;

        @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG)
        private Map<String, String> extraConfig;

        @SerializedName("extra_info")
        private String extraInfo;

        @SerializedName("no_need_ping")
        private boolean noNeedPing;

        @SerializedName("ping_interval_ms")
        private Long pingIntervalMs;

        @SerializedName("room_id")
        private String roomId;

        @SerializedName("rtc_ab_label")
        private String rtcAbLabel;

        @SerializedName("server_uid")
        private String serverUid;

        @SerializedName("token")
        private String token;

        @SerializedName("video_token")
        private String videoToken;

        @SerializedName("video_uid")
        private String videoUid;

        public RtcInfo() {
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getBusinessId() {
            return this.businessId;
        }

        public final String getClientUid() {
            return this.clientUid;
        }

        public final Map<String, String> getExtraConfig() {
            return this.extraConfig;
        }

        public final String getExtraInfo() {
            return this.extraInfo;
        }

        public final boolean getNoNeedPing() {
            return this.noNeedPing;
        }

        public final Long getPingIntervalMs() {
            return this.pingIntervalMs;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getRtcAbLabel() {
            return this.rtcAbLabel;
        }

        public final String getServerUid() {
            return this.serverUid;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getVideoToken() {
            return this.videoToken;
        }

        public final String getVideoUid() {
            return this.videoUid;
        }

        public final void setAppId(String r100) {
            this.appId = r100;
        }

        public final void setBusinessId(String r100) {
            this.businessId = r100;
        }

        public final void setClientUid(String r100) {
            this.clientUid = r100;
        }

        public final void setExtraConfig(Map<String, String> r100) {
            this.extraConfig = r100;
        }

        public final void setExtraInfo(String r100) {
            this.extraInfo = r100;
        }

        public final void setNoNeedPing(boolean r100) {
            this.noNeedPing = r100;
        }

        public final void setPingIntervalMs(Long r100) {
            this.pingIntervalMs = r100;
        }

        public final void setRoomId(String r100) {
            this.roomId = r100;
        }

        public final void setRtcAbLabel(String r100) {
            this.rtcAbLabel = r100;
        }

        public final void setServerUid(String r100) {
            this.serverUid = r100;
        }

        public final void setToken(String r100) {
            this.token = r100;
        }

        public final void setVideoToken(String r100) {
            this.videoToken = r100;
        }

        public final void setVideoUid(String r100) {
            this.videoUid = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001e\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "Ljava/io/Serializable;", "()V", "innerRequestId", "", "getInnerRequestId", "()Ljava/lang/String;", "setInnerRequestId", "(Ljava/lang/String;)V", "isScheduled", "", "()Z", "setScheduled", "(Z)V", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "recIndex", "getRecIndex", "setRecIndex", "resourceId", "getResourceId", "setResourceId", "sliceItemId", "getSliceItemId", "setSliceItemId", "sliceName", "getSliceName", "setSliceName", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "taskType", "", "getTaskType", "()I", "setTaskType", "(I)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SliceItemInfo implements Serializable {

        @SerializedName("inner_request_id")
        private String innerRequestId;

        @SerializedName("is_scheduled")
        private boolean isScheduled;

        @SerializedName("product_id")
        private long productId;

        @SerializedName("rec_index")
        private long recIndex;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("aweme_item_id")
        private long sliceItemId;

        @SerializedName("slice_name")
        private String sliceName;

        @SerializedName("start_time_ms")
        private long startTime;

        @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
        private int taskType;

        public SliceItemInfo() {
            this.resourceId = "";
            this.innerRequestId = "";
            this.sliceName = "";
        }

        public final String getInnerRequestId() {
            return this.innerRequestId;
        }

        public final long getProductId() {
            return this.productId;
        }

        public final long getRecIndex() {
            return this.recIndex;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final long getSliceItemId() {
            return this.sliceItemId;
        }

        public final String getSliceName() {
            return this.sliceName;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final int getTaskType() {
            return this.taskType;
        }

        public final boolean isScheduled() {
            return this.isScheduled;
        }

        public final void setInnerRequestId(String r100) {
            this.innerRequestId = r100;
        }

        public final void setProductId(long r100) {
            this.productId = r100;
        }

        public final void setRecIndex(long r100) {
            this.recIndex = r100;
        }

        public final void setResourceId(String r100) {
            this.resourceId = r100;
        }

        public final void setScheduled(boolean r100) {
            this.isScheduled = r100;
        }

        public final void setSliceItemId(long r100) {
            this.sliceItemId = r100;
        }

        public final void setSliceName(String r100) {
            this.sliceName = r100;
        }

        public final void setStartTime(long r100) {
            this.startTime = r100;
        }

        public final void setTaskType(int r100) {
            this.taskType = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$StreamInfo;", "Ljava/io/Serializable;", "()V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "defaultQuality", "Lcom/bytedance/android/format/model/FormatLiveRoom$DefaultQuality;", "getDefaultQuality", "()Lcom/bytedance/android/format/model/FormatLiveRoom$DefaultQuality;", "setDefaultQuality", "(Lcom/bytedance/android/format/model/FormatLiveRoom$DefaultQuality;)V", "streamData", "", "getStreamData", "()Ljava/lang/String;", "setStreamData", "(Ljava/lang/String;)V", "streamId", "getStreamId", "setStreamId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StreamInfo implements Serializable {

        @SerializedName("create_time")
        private int createTime;

        @SerializedName("default_quality")
        private DefaultQuality defaultQuality;

        @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
        private String streamData;

        @SerializedName("stream_id")
        private String streamId;

        public StreamInfo() {
        }

        public final int getCreateTime() {
            return this.createTime;
        }

        public final DefaultQuality getDefaultQuality() {
            return this.defaultQuality;
        }

        public final String getStreamData() {
            return this.streamData;
        }

        public final String getStreamId() {
            return this.streamId;
        }

        public final void setCreateTime(int r100) {
            this.createTime = r100;
        }

        public final void setDefaultQuality(DefaultQuality r100) {
            this.defaultQuality = r100;
        }

        public final void setStreamData(String r100) {
            this.streamData = r100;
        }

        public final void setStreamId(String r100) {
            this.streamId = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$TimeLineEventType;", "", "", "type", "I", "getType", "()I", "SpeakEnd", DSLType.Slice, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TimeLineEventType extends Enum<TimeLineEventType> {
        public static final TimeLineEventType Slice = null;
        public static final TimeLineEventType SpeakEnd = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeLineEventType[] f51337a = null;
        private final int type;

        static {
            TimeLineEventType r100 = new TimeLineEventType("SpeakEnd", 0, 0);
            SpeakEnd = r100;
            TimeLineEventType r101 = new TimeLineEventType(DSLType.Slice, 1, 1);
            Slice = r101;
            f51337a = new TimeLineEventType[]{r100, r101};
        }

        public static TimeLineEventType valueOf(String r100) {
            return (TimeLineEventType) r27.a.a(TimeLineEventType.class, r100);
        }

        public static TimeLineEventType[] values() {
            return (TimeLineEventType[]) f51337a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public TimeLineEventType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$TimelineEvent;", "Ljava/io/Serializable;", "()V", "eventType", "", "getEventType", "()I", "setEventType", "(I)V", "startTimestamp", "", "getStartTimestamp", "()J", "setStartTimestamp", "(J)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", VideoSurfaceTexture.KEY_TIME, "getTimeStamp", "setTimeStamp", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TimelineEvent implements Serializable {

        @SerializedName("event_type")
        private int eventType;

        @SerializedName("start_timestamp_ms")
        private long startTimestamp;

        @SerializedName("text")
        private String text;

        @SerializedName("timestamp_ms")
        private long timeStamp;

        public TimelineEvent() {
        }

        public final int getEventType() {
            return this.eventType;
        }

        public final long getStartTimestamp() {
            return this.startTimestamp;
        }

        public final String getText() {
            return this.text;
        }

        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public final void setEventType(int r100) {
            this.eventType = r100;
        }

        public final void setStartTimestamp(long r100) {
            this.startTimestamp = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setTimeStamp(long r100) {
            this.timeStamp = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "Ljava/io/Serializable;", "()V", "directCntStr", "", "getDirectCntStr", "()Ljava/lang/String;", "setDirectCntStr", "(Ljava/lang/String;)V", "onlineNum", "", "getOnlineNum", "()J", "setOnlineNum", "(J)V", "onlineNumStr", "getOnlineNumStr", "setOnlineNumStr", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserData implements Serializable {

        @SerializedName("display_cnt_str")
        private String directCntStr;

        @SerializedName("online_cnt")
        private long onlineNum;

        @SerializedName("online_cnt_str")
        private String onlineNumStr;

        public UserData() {
            this.onlineNumStr = "";
            this.directCntStr = "";
        }

        public final String getDirectCntStr() {
            return this.directCntStr;
        }

        public final long getOnlineNum() {
            return this.onlineNum;
        }

        public final String getOnlineNumStr() {
            return this.onlineNumStr;
        }

        public final void setDirectCntStr(String r100) {
            this.directCntStr = r100;
        }

        public final void setOnlineNum(long r100) {
            this.onlineNum = r100;
        }

        public final void setOnlineNumStr(String r100) {
            this.onlineNumStr = r100;
        }
    }

    public FormatLiveRoom() {
    }

    public final boolean hasVoice() {
        Map<String, String> r100 = this.extra;
        if (r100 == null) goto L13;
        String r101 = r100.get("voice_id");
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    public final AvatarInfo getAvatarInfo() {
        return this.avatarInfo;
    }

    public final CharacterInfo getCharacterInfo() {
        return this.characterInfo;
    }

    public final Boolean getChatWithInterrupt() {
        return this.chatWithInterrupt;
    }

    public final CustomConfig getCustomConfig() {
        return this.customConfig;
    }

    public final String getEnterTip() {
        return this.enterTip;
    }

    public final List<EnterTipLink> getEnterTipLinks() {
        return this.enterTipLinks;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final List<TimelineEvent> getPlayTimeLine() {
        return this.playTimeLine;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final int getProtocolType() {
        return this.protocolType;
    }

    public final UserPunishInfo getPunishInfo() {
        return this.punishInfo;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final RtcInfo getRtcInfo() {
        return this.rtcInfo;
    }

    public final SliceItemInfo getSliceItemInfo() {
        return this.sliceItemInfo;
    }

    public final StreamInfo getStream_info() {
        return this.stream_info;
    }

    public final LiveMsgSugResp getSugInfo() {
        return this.sugInfo;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final UserData getUserData() {
        return this.userData;
    }

    public final void setAvatarInfo(AvatarInfo r100) {
        this.avatarInfo = r100;
    }

    public final void setCharacterInfo(CharacterInfo r100) {
        this.characterInfo = r100;
    }

    public final void setChatWithInterrupt(Boolean r100) {
        this.chatWithInterrupt = r100;
    }

    public final void setCustomConfig(CustomConfig r100) {
        this.customConfig = r100;
    }

    public final void setEnterTip(String r100) {
        this.enterTip = r100;
    }

    public final void setEnterTipLinks(List<EnterTipLink> r100) {
        this.enterTipLinks = r100;
    }

    public final void setPlayTimeLine(List<TimelineEvent> r100) {
        this.playTimeLine = r100;
    }

    public final void setProtocolType(int r100) {
        this.protocolType = r100;
    }

    public final void setPunishInfo(UserPunishInfo r100) {
        this.punishInfo = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setRtcInfo(RtcInfo r100) {
        this.rtcInfo = r100;
    }

    public final void setSliceItemInfo(SliceItemInfo r100) {
        this.sliceItemInfo = r100;
    }

    public final void setStream_info(StreamInfo r100) {
        this.stream_info = r100;
    }

    public final void setSugInfo(LiveMsgSugResp r100) {
        this.sugInfo = r100;
    }

    public final void setTaskType(int r100) {
        this.taskType = r100;
    }
}
