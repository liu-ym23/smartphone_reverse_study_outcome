package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/d0;", "", "", "landscapeUrl", "Ljava/lang/String;", "getLandscapeUrl", "()Ljava/lang/String;", "setLandscapeUrl", "(Ljava/lang/String;)V", "portraitUrl", "getPortraitUrl", "setPortraitUrl", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("landscape_url")
    private String landscapeUrl;

    @SerializedName("portrait_url")
    private String portraitUrl;

    public d0() {
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = com.bytedance.android.gamecp.common.utils.h0.f57224a;
        String r102 = com.bytedance.android.gamecp.common.utils.h0.f57225b;
        r100.append(r102);
        r100.append("/obj/live-android/gamecp_xplay_landscape_loading_bg.png");
        this.landscapeUrl = r100.toString();
        this.portraitUrl = "https://" + r102 + "/obj/live-android/gamecp_xplay_portrait_loading_bg.png";
    }
}
