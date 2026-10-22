package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/p;", "", "", "enablePreload", "Z", "getEnablePreload", "()Z", "setEnablePreload", "(Z)V", "enableCache", "getEnableCache", "setEnableCache", "", "functionPanelSchema", "Ljava/lang/String;", "getFunctionPanelSchema", "()Ljava/lang/String;", "setFunctionPanelSchema", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("enable_cache")
    private boolean enableCache;

    @SerializedName("enable_preload")
    private boolean enablePreload;

    @SerializedName("xplay_function_panel_schema")
    private String functionPanelSchema;

    public p() {
        this.enablePreload = true;
        this.enableCache = true;
        if (com.bytedance.android.gamecp.common.utils.q0.a() == false) goto L5;
        String r100 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fxplay_function_panel%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&xplay_background_color=%23161616fa&xplay_container_height=376&xplay_container_width=454&xplay_container_radius=12&settings_keys=gcp_xplay_download_refactor&mix_container_type=annie";
    L6:
        this.functionPanelSchema = r100;
        return;
    L5:
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getFontScale();
        r100 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fxplay_function_panel%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&xplay_background_color=%23161616fa&xplay_container_height=483&xplay_container_width=454&xplay_container_radius=12&settings_keys=gcp_xplay_download_refactor&enable_font_scale=1&mix_container_type=annie&font_scale=1.0";
        goto L6
    }
}
