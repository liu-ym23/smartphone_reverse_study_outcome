package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/q;", "", "", "isInnerWhite", "Z", "()Z", "setInnerWhite", "(Z)V", "isExternalWhite", "setExternalWhite", "", "dataPanelSchema", "Ljava/lang/String;", "getDataPanelSchema", "()Ljava/lang/String;", "setDataPanelSchema", "(Ljava/lang/String;)V", "menuPanelSchema", "getMenuPanelSchema", "setMenuPanelSchema", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("resident_schema")
    private String dataPanelSchema;

    @SerializedName("isExternalWhite")
    private boolean isExternalWhite;

    @SerializedName("isInternalWhite")
    private boolean isInnerWhite;

    @SerializedName("menu_schema")
    private String menuPanelSchema;

    public q() {
        this.dataPanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fxplay_debug_panel_resident%2Ftemplate.js";
        this.menuPanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fxplay_debug_panel_menu%2Ftemplate.js";
    }
}
