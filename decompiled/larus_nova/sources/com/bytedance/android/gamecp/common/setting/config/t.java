package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/t;", "", "", "enjoyCardSchema", "Ljava/lang/String;", "getEnjoyCardSchema", "()Ljava/lang/String;", "setEnjoyCardSchema", "(Ljava/lang/String;)V", "", "enableFallBackEnjoyCardRequest", "Z", "getEnableFallBackEnjoyCardRequest", "()Z", "setEnableFallBackEnjoyCardRequest", "(Z)V", "", "adShowSucDelayCheckTime", "J", "getAdShowSucDelayCheckTime", "()J", "setAdShowSucDelayCheckTime", "(J)V", "adModalIconUrl", "getAdModalIconUrl", "setAdModalIconUrl", "enableBenefitPageLmmProtect", "getEnableBenefitPageLmmProtect", "setEnableBenefitPageLmmProtect", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("ad_modal_icon_url")
    private String adModalIconUrl;

    @SerializedName("ad_show_suc_delay_check_time")
    private long adShowSucDelayCheckTime;

    @SerializedName("enable_benefit_page_lmm_protect")
    private boolean enableBenefitPageLmmProtect;

    @SerializedName("enable_fallback_enjoy_card_request")
    private boolean enableFallBackEnjoyCardRequest;

    @SerializedName("enjoy_card_schema")
    private String enjoyCardSchema;

    public t() {
        String r100 = "https://" + com.bytedance.android.gamecp.common.utils.h0.f57225b + "/obj/live-android/live_gmcp_xplay_ad_transparent_modal_icon.png";
        this.enjoyCardSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Funlimited_play_card%2Ftemplate.js&business_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&mix_container_type=annie";
        this.enableFallBackEnjoyCardRequest = true;
        this.adShowSucDelayCheckTime = 1500;
        this.adModalIconUrl = r100;
        this.enableBenefitPageLmmProtect = false;
    }
}
