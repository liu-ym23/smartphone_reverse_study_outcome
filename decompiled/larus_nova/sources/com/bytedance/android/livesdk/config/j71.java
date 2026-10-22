package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/j71;", "", "", "beforeManagerUrl", "Ljava/lang/String;", "getBeforeManagerUrl", "()Ljava/lang/String;", "setBeforeManagerUrl", "(Ljava/lang/String;)V", "beforePickingUrl", "getBeforePickingUrl", "setBeforePickingUrl", "managerUrl", "getManagerUrl", "setManagerUrl", "livingPickingUrl", "getLivingPickingUrl", "setLivingPickingUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j71 {

    @SerializedName("live_before_manager_promotions_url")
    private String beforeManagerUrl;

    @SerializedName("live_before_picking_promotions_url")
    private String beforePickingUrl;

    @SerializedName("live_living_picking_promotions_url")
    private String livingPickingUrl;

    @SerializedName("live_manager_promotions_url")
    private String managerUrl;

    public j71() {
        this.beforeManagerUrl = "sslocal://webcast_webview?url=https%3A%2F%2Flm.jinritemai.com%2Fviews%2Flive%2Fmerch_picked%3Fenter_from%3Dwebcast_before_living%26forbid_right_back%3D1%26room_id%3D0%26type%3Dfullscreen%26web_bg_color%3D%2523ffffff%26hide_nav_bar%3D1&type=fullscreen&web_bg_color=%23ffffff&hide_nav_bar=1&forbid_right_back=1";
        this.beforePickingUrl = "sslocal://webcast_webview?url=https%3A%2F%2Flm.jinritemai.com%2Fviews%2Flive%2Fmerch_picking%3Fenter_from%3Dwebcast_before_living%26forbid_right_back%3D1%26room_id%3D0%26type%3Dfullscreen%26web_bg_color%3D%2523ffffff%26hide_nav_bar%3D1&type=fullscreen&web_bg_color=%23ffffff&hide_nav_bar=1&forbid_right_back=1";
        this.managerUrl = "sslocal://webcast_webview?url=https%3A%2F%2Flm.jinritemai.com%2Fviews%2Flive%2Fmerch_picked%3Fenter_from%3Dwebcast_living%26forbid_right_back%3D1%26room_id%3D__live_commerce_roomid_placeholder__%26type%3Dfullscreen%26web_bg_color%3D%2523ffffff%26hide_nav_bar%3D1&type=fullscreen&web_bg_color=%23ffffff&hide_nav_bar=1&forbid_right_back=1";
        this.livingPickingUrl = "sslocal://webcast_webview?url=https%3A%2F%2Flm.jinritemai.com%2Fviews%2Flive%2Fmerch_picking%3Fenter_from%3Dwebcast_living%26forbid_right_back%3D1%26room_id%3D__live_commerce_roomid_placeholder__%26type%3Dfullscreen%26web_bg_color%3D%2523ffffff%26hide_nav_bar%3D1&type=fullscreen&web_bg_color=%23ffffff&hide_nav_bar=1&forbid_right_back=1";
    }
}
