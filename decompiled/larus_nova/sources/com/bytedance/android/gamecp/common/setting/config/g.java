package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/g;", "", "", "enableLoadLynx", "Z", "getEnableLoadLynx", "()Z", "setEnableLoadLynx", "(Z)V", "", "loadingPageSchema", "Ljava/lang/String;", "getLoadingPageSchema", "()Ljava/lang/String;", "setLoadingPageSchema", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("enable_load_lynx")
    private boolean enableLoadLynx;

    @SerializedName("loading_page_schema")
    private String loadingPageSchema;

    public g() {
        this.enableLoadLynx = true;
        this.loadingPageSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Floading_page%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&bdhm_pid=instant_play_loading_page&enable_latch=1&mix_container_type=annie";
    }
}
