package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/w;", "", "", "exitGuideSchema", "Ljava/lang/String;", "getExitGuideSchema", "()Ljava/lang/String;", "setExitGuideSchema", "(Ljava/lang/String;)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("exit_guide_schema")
    private String exitGuideSchema;

    public w() {
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getFontScale();
        this.exitGuideSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fexit_guide%2Ftemplate.js%3FinitialProps%3D%255B%2522setting%253Alive_gmcp_cg_exit_dialog_strategy_config%2522%255D&business_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&settings_keys=gcp_xplay_download_refactor&enable_font_scale=1&mix_container_type=annie&font_scale=1.0";
    }
}
