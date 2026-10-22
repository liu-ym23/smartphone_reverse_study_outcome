package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/v0;", "", "", "enableDisplay", "Z", "getEnableDisplay", "()Z", "setEnableDisplay", "(Z)V", "enableScale", "getEnableScale", "setEnableScale", "", "cancelSubscribeDialogUrl", "Ljava/lang/String;", "getCancelSubscribeDialogUrl", "()Ljava/lang/String;", "setCancelSubscribeDialogUrl", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("cancel_subscribe_dialog_url")
    private String cancelSubscribeDialogUrl;

    @SerializedName("enable_display")
    private boolean enableDisplay;

    @SerializedName("enable_scale")
    private boolean enableScale;

    public v0() {
        this.enableDisplay = true;
        this.enableScale = true;
        this.cancelSubscribeDialogUrl = "aweme://hunter_popup?surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Faweme_dissimilation_card%2Fcancel_subscribe%2Ftemplate.js&height_percent=100&width_percent=100&gravity=bottom&type=popup&channel=aweme_dissimilation_card&bundle=cancel_subscribe%2Ftemplate.js&status_font_dark=0&custom_env=default&mask_bg_color=00000057&is_common_subscribe=1&is_native_card=1";
    }
}
