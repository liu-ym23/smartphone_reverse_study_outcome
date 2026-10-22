package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.r;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomInteractData;", "", "", "landscapeCommentStyle", "J", "getLandscapeCommentStyle", "()J", "setLandscapeCommentStyle", "(J)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "componentExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "getComponentExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "setComponentExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "selectedMessageInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "getSelectedMessageInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "setSelectedMessageInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "publicScreenSpeedConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "getPublicScreenSpeedConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "setPublicScreenSpeedConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;)V", "Lpy/r;", "roomIntroLabel", "Lpy/r;", "getRoomIntroLabel", "()Lpy/r;", "setRoomIntroLabel", "(Lpy/r;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/InputDefaultConfig;", "inputDefaultConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/InputDefaultConfig;", "getInputDefaultConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/InputDefaultConfig;", "setInputDefaultConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/InputDefaultConfig;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "lowPcuGuideData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "getLowPcuGuideData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "setLowPcuGuideData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/UserWorldChatInfo;", "squareInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/UserWorldChatInfo;", "getSquareInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/UserWorldChatInfo;", "setSquareInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/UserWorldChatInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/TopicCommentTip;", "topicTip", "Lcom/bytedance/android/livesdkapi/depend/model/live/TopicCommentTip;", "getTopicTip", "()Lcom/bytedance/android/livesdkapi/depend/model/live/TopicCommentTip;", "setTopicTip", "(Lcom/bytedance/android/livesdkapi/depend/model/live/TopicCommentTip;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomInteractData implements h {

    @SerializedName("vs_component_extra")
    protected IEpisodeExtraInfo componentExtra;

    @SerializedName("input_default_config")
    protected InputDefaultConfig inputDefaultConfig;

    @SerializedName("landscape_comment_style")
    protected long landscapeCommentStyle;

    @SerializedName("low_pcu_guide_info")
    protected LowPcuGuideData lowPcuGuideData;

    @SerializedName("public_screen_speed_conf")
    protected IPublicScreenSpeedConfig publicScreenSpeedConfig;

    @SerializedName("public_room_intro_label")
    protected r roomIntroLabel;

    @SerializedName("featured_public_screen_data")
    protected IPSSelectedMessageInfo selectedMessageInfo;

    @SerializedName("user_world_chat_info")
    protected UserWorldChatInfo squareInfo;

    @SerializedName("bottom_input_custom_topic")
    protected TopicCommentTip topicTip;

    public RoomInteractData() {
    }

    public final IEpisodeExtraInfo getComponentExtra() {
        return this.componentExtra;
    }

    public final InputDefaultConfig getInputDefaultConfig() {
        return this.inputDefaultConfig;
    }

    public final long getLandscapeCommentStyle() {
        return this.landscapeCommentStyle;
    }

    public final LowPcuGuideData getLowPcuGuideData() {
        return this.lowPcuGuideData;
    }

    public final IPublicScreenSpeedConfig getPublicScreenSpeedConfig() {
        return this.publicScreenSpeedConfig;
    }

    public final r getRoomIntroLabel() {
        return this.roomIntroLabel;
    }

    public final IPSSelectedMessageInfo getSelectedMessageInfo() {
        return this.selectedMessageInfo;
    }

    public final UserWorldChatInfo getSquareInfo() {
        return this.squareInfo;
    }

    public final TopicCommentTip getTopicTip() {
        return this.topicTip;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.IPSSelectedMessageInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.r] */
    public RoomInteractData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.topicTip = new TopicCommentTip(r100);
        goto L3
    L8:
        this.squareInfo = new UserWorldChatInfo(r100);
        goto L3
    L9:
        this.lowPcuGuideData = new LowPcuGuideData(r100);
        goto L3
    L10:
        this.inputDefaultConfig = new InputDefaultConfig(r100);
        goto L3
    L11:
        this.roomIntroLabel = f.a(r100, r.class);
        goto L3
    L12:
        this.publicScreenSpeedConfig = f.a(r100, IPublicScreenSpeedConfig.class);
        goto L3
    L13:
        this.selectedMessageInfo = f.a(r100, IPSSelectedMessageInfo.class);
        goto L3
    L14:
        this.componentExtra = f.a(r100, IEpisodeExtraInfo.class);
        goto L3
    L15:
        this.landscapeCommentStyle = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setComponentExtra(IEpisodeExtraInfo r100) {
        this.componentExtra = r100;
    }

    public final void setInputDefaultConfig(InputDefaultConfig r100) {
        this.inputDefaultConfig = r100;
    }

    public final void setLandscapeCommentStyle(long r100) {
        this.landscapeCommentStyle = r100;
    }

    public final void setLowPcuGuideData(LowPcuGuideData r100) {
        this.lowPcuGuideData = r100;
    }

    public final void setPublicScreenSpeedConfig(IPublicScreenSpeedConfig r100) {
        this.publicScreenSpeedConfig = r100;
    }

    public final void setRoomIntroLabel(r r100) {
        this.roomIntroLabel = r100;
    }

    public final void setSelectedMessageInfo(IPSSelectedMessageInfo r100) {
        this.selectedMessageInfo = r100;
    }

    public final void setSquareInfo(UserWorldChatInfo r100) {
        this.squareInfo = r100;
    }

    public final void setTopicTip(TopicCommentTip r100) {
        this.topicTip = r100;
    }
}
