package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/m51;", "", "", "detailPage", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDetailPage", "(Ljava/lang/String;)V", "thresholdPage", "d", "setThresholdPage", "beforeLiveMountPage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBeforeLiveMountPage", "gamePanelPage", "c", "setGamePanelPage", "xPlayPanelPage", "e", "setXPlayPanelPage", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m51 {

    @SerializedName("before_live_mount_page")
    private String beforeLiveMountPage;

    @SerializedName("detail_page")
    private String detailPage;

    @SerializedName("game_panel_page")
    private String gamePanelPage;

    @SerializedName("threshold_page")
    private String thresholdPage;

    @SerializedName("xplay_panel_page")
    private String xPlayPanelPage;

    public static final class a {
    }

    static {
    }

    public m51() {
        this.detailPage = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Fdetail%2Fwebcast%2Fmicro_game_detail_webcast%2Fpages%2Fdetail%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&enable_prefetch=1&width_percent=100&height_percent=100&gravity=bottom&containerKey=annie_x_live&engine_type=new&mix_container_type=annie&type=popup&pad_adapter=width_percent&rate_height=100&pad_use_phone_size=1";
        this.thresholdPage = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Fdetail%2Fwebcast%2Fmicro_game_detail_webcast%2Fpages%2Fthreshold%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&enable_prefetch=1&width_percent=100&height_percent=100&gravity=bottom&containerKey=annie_x_live&engine_type=new&mix_container_type=annie&type=popup&pad_adapter=width_percent&rate_height=100&pad_use_phone_size=1";
    }

    public final String a() {
        return this.beforeLiveMountPage;
    }

    public final String b() {
        return this.detailPage;
    }

    public final String c() {
        return this.gamePanelPage;
    }

    public final String d() {
        return this.thresholdPage;
    }

    public final String e() {
        return this.xPlayPanelPage;
    }
}
