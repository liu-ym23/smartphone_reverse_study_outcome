package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/m;", "", "", "landscapeBgUrl", "Ljava/lang/String;", "getLandscapeBgUrl", "()Ljava/lang/String;", "setLandscapeBgUrl", "(Ljava/lang/String;)V", "landscapePadBgUrl", "getLandscapePadBgUrl", "setLandscapePadBgUrl", "portraitBgUrl", "getPortraitBgUrl", "setPortraitBgUrl", "portraitPadBgUrl", "getPortraitPadBgUrl", "setPortraitPadBgUrl", "", "hideLoadingDelay", "Ljava/lang/Long;", "getHideLoadingDelay", "()Ljava/lang/Long;", "setHideLoadingDelay", "(Ljava/lang/Long;)V", "showTipsDelay", "getShowTipsDelay", "setShowTipsDelay", "", "enableLoadingBgAnimation", "Z", "getEnableLoadingBgAnimation", "()Z", "setEnableLoadingBgAnimation", "(Z)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("enable_loading_bg_animation")
    private boolean enableLoadingBgAnimation;

    @SerializedName("hide_loading_delay")
    private Long hideLoadingDelay;

    @SerializedName("landscape_bg_url")
    private String landscapeBgUrl;

    @SerializedName("landscape_pad_bg_url")
    private String landscapePadBgUrl;

    @SerializedName("portrait_bg_url")
    private String portraitBgUrl;

    @SerializedName("portrait_pad_bg_url")
    private String portraitPadBgUrl;

    @SerializedName("show_tips_delay")
    private Long showTipsDelay;

    public m() {
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = com.bytedance.android.gamecp.common.utils.h0.f57224a;
        String r102 = com.bytedance.android.gamecp.common.utils.h0.f57225b;
        r100.append(r102);
        r100.append("/obj/live-android/cloud_game_launch_ani_landscape.webp");
        this.landscapeBgUrl = r100.toString();
        this.landscapePadBgUrl = "https://" + r102 + "/obj/live-android/cloud_game_launch_ani_landscape_pad.webp";
        this.portraitBgUrl = "https://" + r102 + "/obj/live-android/cloud_game_launch_ani_portrait.webp";
        this.portraitPadBgUrl = "https://" + r102 + "/obj/live-android/cloud_game_launch_ani_portrait_pad.webp";
        this.hideLoadingDelay = 3000L;
        this.showTipsDelay = 10000L;
        this.enableLoadingBgAnimation = true;
    }
}
