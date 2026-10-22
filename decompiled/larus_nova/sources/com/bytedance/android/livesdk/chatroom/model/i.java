package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/i;", "", "", "audioChatEnable", "Z", "getAudioChatEnable", "()Z", "setAudioChatEnable", "(Z)V", "audioAutoPlay", "getAudioAutoPlay", "setAudioAutoPlay", "audioCommentShow", "getAudioCommentShow", "setAudioCommentShow", "", "chatSwitch", "I", "getChatSwitch", "()I", "setChatSwitch", "(I)V", "videoShareEnable", "getVideoShareEnable", "roomChannelSwitch", "getRoomChannelSwitch", "setRoomChannelSwitch", "trialUserChat", "getTrialUserChat", "setTrialUserChat", "Lcom/bytedance/android/livesdk/chatroom/model/c;", "anchorAsrConfig", "Lcom/bytedance/android/livesdk/chatroom/model/c;", "getAnchorAsrConfig", "()Lcom/bytedance/android/livesdk/chatroom/model/c;", "setAnchorAsrConfig", "(Lcom/bytedance/android/livesdk/chatroom/model/c;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("anchor_audio_chat")
    private c anchorAsrConfig;

    @SerializedName("auto_play")
    private boolean audioAutoPlay;

    @SerializedName("allow_audio_chat")
    private boolean audioChatEnable;

    @SerializedName("panel_show")
    private boolean audioCommentShow;

    @SerializedName("chat_switch")
    private int chatSwitch;

    @SerializedName("room_channel_switch")
    private int roomChannelSwitch;

    @SerializedName("trial_user_chat")
    private int trialUserChat;

    @SerializedName("allow_video_share")
    private final boolean videoShareEnable;

    public static final class a {
    }

    static {
    }

    public i() {
        this.audioChatEnable = true;
        this.audioAutoPlay = true;
        this.chatSwitch = 1;
    }
}
