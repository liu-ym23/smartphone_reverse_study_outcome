package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/CloudGroupLiveBeInvitedDialogConfig;", "", "()V", "disableGiftMenu", "", "", "getDisableGiftMenu", "()Ljava/util/List;", "disablePK", "", "getDisablePK", "()Z", "enable", "getEnable", "schema", "getSchema", "()Ljava/lang/String;", "url", "getUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CloudGroupLiveBeInvitedDialogConfig {

    @SerializedName("disable_gift_menu")
    private final List<String> disableGiftMenu;

    @SerializedName("disable_pk")
    private final boolean disablePK;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("url")
    private final String url;

    public CloudGroupLiveBeInvitedDialogConfig() {
        this.enable = true;
        this.schema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&height_percent=100";
        this.url = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/cloud_collaborate_douyin/pages/invite_collaborate_panel/template.js";
        this.disablePK = true;
        this.disableGiftMenu = CollectionsKt.listOf("礼物菜单");
    }

    public final List<String> getDisableGiftMenu() {
        return this.disableGiftMenu;
    }

    public final boolean getDisablePK() {
        return this.disablePK;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUrl() {
        return this.url;
    }
}
