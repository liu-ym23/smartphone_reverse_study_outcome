package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GroupLiveGameConfig;", "", "()V", "channel", "", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "gameSelectPageScheme", "getGameSelectPageScheme", "setGameSelectPageScheme", "inviteInterceptIntervalInMills", "", "getInviteInterceptIntervalInMills", "()J", "setInviteInterceptIntervalInMills", "(J)V", "livePublicScreenHeightPad", "", "getLivePublicScreenHeightPad", "()I", "setLivePublicScreenHeightPad", "(I)V", "livePublicScreenHeightPhone", "getLivePublicScreenHeightPhone", "setLivePublicScreenHeightPhone", "offlineDetectEnable", "", "getOfflineDetectEnable", "()Z", "setOfflineDetectEnable", "(Z)V", "onlineDetectIntervalInMills", "getOnlineDetectIntervalInMills", "setOnlineDetectIntervalInMills", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveGameConfig {

    @SerializedName("channel")
    private String channel;

    @SerializedName("game_select_page_scheme")
    private String gameSelectPageScheme;

    @SerializedName("invite_intercept_interval_in_mills")
    private long inviteInterceptIntervalInMills;

    @SerializedName("live_public_screen_height_pad")
    private int livePublicScreenHeightPad;

    @SerializedName("live_public_screen_height_phone")
    private int livePublicScreenHeightPhone;

    @SerializedName("offline_detect_enable")
    private boolean offlineDetectEnable;

    @SerializedName("online_detect_interval_in_mills")
    private long onlineDetectIntervalInMills;

    public GroupLiveGameConfig() {
        this.gameSelectPageScheme = "aweme://hunter_popup?bundle=popup_chat_games_list/template.js&channel=im_commerce_reactlynx&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Ffe%2Fdouyin%2Fim%2Fim_commerce_reactlynx%2Fpopup_chat_games_list%2Ftemplate.js&loader_name=forest&need_im_data=1&bullet_storage_keys=msg_card_user_avatar_map,im_chat_game_list_CONVERSATION_SHORT_ID&conversation_short_id=CONVERSATION_SHORT_ID&ab_params=live_play_im&enable_prefetch=1";
        this.offlineDetectEnable = true;
        this.inviteInterceptIntervalInMills = 60000;
        this.onlineDetectIntervalInMills = 300000;
        this.livePublicScreenHeightPhone = 90;
        this.livePublicScreenHeightPad = 150;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getGameSelectPageScheme() {
        return this.gameSelectPageScheme;
    }

    public final long getInviteInterceptIntervalInMills() {
        return this.inviteInterceptIntervalInMills;
    }

    public final int getLivePublicScreenHeightPad() {
        return this.livePublicScreenHeightPad;
    }

    public final int getLivePublicScreenHeightPhone() {
        return this.livePublicScreenHeightPhone;
    }

    public final boolean getOfflineDetectEnable() {
        return this.offlineDetectEnable;
    }

    public final long getOnlineDetectIntervalInMills() {
        return this.onlineDetectIntervalInMills;
    }

    public final void setChannel(String r100) {
        this.channel = r100;
    }

    public final void setGameSelectPageScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameSelectPageScheme = r100;
    }

    public final void setInviteInterceptIntervalInMills(long r100) {
        this.inviteInterceptIntervalInMills = r100;
    }

    public final void setLivePublicScreenHeightPad(int r100) {
        this.livePublicScreenHeightPad = r100;
    }

    public final void setLivePublicScreenHeightPhone(int r100) {
        this.livePublicScreenHeightPhone = r100;
    }

    public final void setOfflineDetectEnable(boolean r100) {
        this.offlineDetectEnable = r100;
    }

    public final void setOnlineDetectIntervalInMills(long r100) {
        this.onlineDetectIntervalInMills = r100;
    }
}
