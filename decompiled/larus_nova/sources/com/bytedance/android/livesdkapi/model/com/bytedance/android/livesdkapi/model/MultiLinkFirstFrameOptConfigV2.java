package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdkapi/model/MultiLinkFirstFrameOptConfigV2;", "", "()V", "chatMatchShakeRegisterOpt", "", "getChatMatchShakeRegisterOpt", "()Z", "dataMergeCenterAttachOpt", "getDataMergeCenterAttachOpt", "dynamicWidgetRegisterWindowListObserveOpt", "getDynamicWidgetRegisterWindowListObserveOpt", "interactiveSongHandlerOpt", "getInteractiveSongHandlerOpt", "landscapeSlideGuideWidgetLoadOpt", "getLandscapeSlideGuideWidgetLoadOpt", "totalEnable", "getTotalEnable", "videoTalkRoomGuestXmlOpt", "getVideoTalkRoomGuestXmlOpt", "isEnableChatMatchShakeRegisterOpt", "isEnableDataMergeCenterAttachOpt", "isEnableDynamicWidgetRegisterWindowListObserveOpt", "isEnableInteractiveSongHandlerOpt", "isEnableLandscapeSlideGuideWidgetLoadOpt", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkFirstFrameOptConfigV2 {

    @SerializedName("chat_match_shake_register_opt")
    private final boolean chatMatchShakeRegisterOpt;

    @SerializedName("data_merge_center_attach_opt")
    private final boolean dataMergeCenterAttachOpt;

    @SerializedName("dynamic_widget_register_window_list_observe_opt")
    private final boolean dynamicWidgetRegisterWindowListObserveOpt;

    @SerializedName("interactive_song_handler_opt")
    private final boolean interactiveSongHandlerOpt;

    @SerializedName("landscape_slide_guide_widget_load_opt")
    private final boolean landscapeSlideGuideWidgetLoadOpt;

    @SerializedName("total_enable")
    private final boolean totalEnable;

    @SerializedName("video_talk_room_guest_xml_opt")
    private final boolean videoTalkRoomGuestXmlOpt;

    public final boolean isEnableChatMatchShakeRegisterOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.chatMatchShakeRegisterOpt == false) goto L7;
        return true;
    }

    public final boolean isEnableDataMergeCenterAttachOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.dataMergeCenterAttachOpt == false) goto L7;
        return true;
    }

    public final boolean isEnableDynamicWidgetRegisterWindowListObserveOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.dynamicWidgetRegisterWindowListObserveOpt == false) goto L7;
        return true;
    }

    public final boolean isEnableInteractiveSongHandlerOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.interactiveSongHandlerOpt == false) goto L7;
        return true;
    }

    public final boolean isEnableLandscapeSlideGuideWidgetLoadOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.landscapeSlideGuideWidgetLoadOpt == false) goto L7;
        return true;
    }

    public MultiLinkFirstFrameOptConfigV2() {
        this.totalEnable = true;
        this.videoTalkRoomGuestXmlOpt = true;
        this.landscapeSlideGuideWidgetLoadOpt = true;
        this.chatMatchShakeRegisterOpt = true;
        this.interactiveSongHandlerOpt = true;
        this.dynamicWidgetRegisterWindowListObserveOpt = true;
        this.dataMergeCenterAttachOpt = true;
    }

    public final boolean getChatMatchShakeRegisterOpt() {
        return this.chatMatchShakeRegisterOpt;
    }

    public final boolean getDataMergeCenterAttachOpt() {
        return this.dataMergeCenterAttachOpt;
    }

    public final boolean getDynamicWidgetRegisterWindowListObserveOpt() {
        return this.dynamicWidgetRegisterWindowListObserveOpt;
    }

    public final boolean getInteractiveSongHandlerOpt() {
        return this.interactiveSongHandlerOpt;
    }

    public final boolean getLandscapeSlideGuideWidgetLoadOpt() {
        return this.landscapeSlideGuideWidgetLoadOpt;
    }

    public final boolean getTotalEnable() {
        return this.totalEnable;
    }

    public final boolean getVideoTalkRoomGuestXmlOpt() {
        return this.videoTalkRoomGuestXmlOpt;
    }
}
