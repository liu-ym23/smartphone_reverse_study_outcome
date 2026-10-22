package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/k;", "", "", "txPcLoginPanelSchema", "Ljava/lang/String;", "getTxPcLoginPanelSchema", "()Ljava/lang/String;", "setTxPcLoginPanelSchema", "(Ljava/lang/String;)V", "selectZonePanelSchema", "getSelectZonePanelSchema", "setSelectZonePanelSchema", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("select_zone_panel_schema")
    private String selectZonePanelSchema;

    @SerializedName("tx_pc_login_panel_schema")
    private String txPcLoginPanelSchema;

    public k() {
        this.txPcLoginPanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Ftx_pc_login_panel%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&mix_container_type=annie";
        this.selectZonePanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fselect_zone_panel%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&mix_container_type=annie";
    }
}
