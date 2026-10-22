package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveLongPressPanelItemConfig;", "", "()V", "liveRecommendToFriendDetailTextInRoom", "", "getLiveRecommendToFriendDetailTextInRoom", "()Ljava/lang/String;", "setLiveRecommendToFriendDetailTextInRoom", "(Ljava/lang/String;)V", "liveRecommendToFriendDetailTextPreview", "getLiveRecommendToFriendDetailTextPreview", "setLiveRecommendToFriendDetailTextPreview", "liveRecommendToFriendIcon", "getLiveRecommendToFriendIcon", "setLiveRecommendToFriendIcon", "liveRecommendToFriendRecommendedIcon", "getLiveRecommendToFriendRecommendedIcon", "setLiveRecommendToFriendRecommendedIcon", "liveRecommendToFriendRecommendedText", "getLiveRecommendToFriendRecommendedText", "setLiveRecommendToFriendRecommendedText", "liveRecommendToFriendText", "getLiveRecommendToFriendText", "setLiveRecommendToFriendText", "liveShareLiveToDailyEnable", "", "getLiveShareLiveToDailyEnable", "()Z", "setLiveShareLiveToDailyEnable", "(Z)V", "liveShareLiveToDailyIcon", "getLiveShareLiveToDailyIcon", "setLiveShareLiveToDailyIcon", "liveShareLiveToDailyText", "getLiveShareLiveToDailyText", "setLiveShareLiveToDailyText", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLongPressPanelItemConfig {

    @SerializedName("live_recommend_to_friend_detail_text_in_room")
    private String liveRecommendToFriendDetailTextInRoom;

    @SerializedName("live_recommend_to_friend_detail_text_preview")
    private String liveRecommendToFriendDetailTextPreview;

    @SerializedName("live_recommend_to_friend_icon")
    private String liveRecommendToFriendIcon;

    @SerializedName("live_recommend_to_friend_recommended_icon")
    private String liveRecommendToFriendRecommendedIcon;

    @SerializedName("live_recommend_to_friend_recommended_text")
    private String liveRecommendToFriendRecommendedText;

    @SerializedName("live_recommend_to_friend_text")
    private String liveRecommendToFriendText;

    @SerializedName("live_share_live_to_daily_enable")
    private boolean liveShareLiveToDailyEnable;

    @SerializedName("live_share_live_to_daily_icon")
    private String liveShareLiveToDailyIcon;

    @SerializedName("live_share_live_to_daily_text")
    private String liveShareLiveToDailyText;

    public LiveLongPressPanelItemConfig() {
    }

    public final String getLiveRecommendToFriendDetailTextInRoom() {
        return this.liveRecommendToFriendDetailTextInRoom;
    }

    public final String getLiveRecommendToFriendDetailTextPreview() {
        return this.liveRecommendToFriendDetailTextPreview;
    }

    public final String getLiveRecommendToFriendIcon() {
        return this.liveRecommendToFriendIcon;
    }

    public final String getLiveRecommendToFriendRecommendedIcon() {
        return this.liveRecommendToFriendRecommendedIcon;
    }

    public final String getLiveRecommendToFriendRecommendedText() {
        return this.liveRecommendToFriendRecommendedText;
    }

    public final String getLiveRecommendToFriendText() {
        return this.liveRecommendToFriendText;
    }

    public final boolean getLiveShareLiveToDailyEnable() {
        return this.liveShareLiveToDailyEnable;
    }

    public final String getLiveShareLiveToDailyIcon() {
        return this.liveShareLiveToDailyIcon;
    }

    public final String getLiveShareLiveToDailyText() {
        return this.liveShareLiveToDailyText;
    }

    public final void setLiveRecommendToFriendDetailTextInRoom(String r100) {
        this.liveRecommendToFriendDetailTextInRoom = r100;
    }

    public final void setLiveRecommendToFriendDetailTextPreview(String r100) {
        this.liveRecommendToFriendDetailTextPreview = r100;
    }

    public final void setLiveRecommendToFriendIcon(String r100) {
        this.liveRecommendToFriendIcon = r100;
    }

    public final void setLiveRecommendToFriendRecommendedIcon(String r100) {
        this.liveRecommendToFriendRecommendedIcon = r100;
    }

    public final void setLiveRecommendToFriendRecommendedText(String r100) {
        this.liveRecommendToFriendRecommendedText = r100;
    }

    public final void setLiveRecommendToFriendText(String r100) {
        this.liveRecommendToFriendText = r100;
    }

    public final void setLiveShareLiveToDailyEnable(boolean r100) {
        this.liveShareLiveToDailyEnable = r100;
    }

    public final void setLiveShareLiveToDailyIcon(String r100) {
        this.liveShareLiveToDailyIcon = r100;
    }

    public final void setLiveShareLiveToDailyText(String r100) {
        this.liveShareLiveToDailyText = r100;
    }
}
