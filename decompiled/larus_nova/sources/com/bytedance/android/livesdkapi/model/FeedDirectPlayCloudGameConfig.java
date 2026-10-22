package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/FeedDirectPlayCloudGameConfig;", "", "()V", "cancelSubscribeDialogUrl", "", "getCancelSubscribeDialogUrl", "()Ljava/lang/String;", "setCancelSubscribeDialogUrl", "(Ljava/lang/String;)V", "enableCalColorOnPageSelected", "", "getEnableCalColorOnPageSelected", "()Z", "setEnableCalColorOnPageSelected", "(Z)V", "enableDisplay", "getEnableDisplay", "setEnableDisplay", "enableReportCardRefreshEvent", "getEnableReportCardRefreshEvent", "setEnableReportCardRefreshEvent", "enableScale", "getEnableScale", "setEnableScale", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FeedDirectPlayCloudGameConfig {

    @SerializedName("cancel_subscribe_dialog_url")
    private String cancelSubscribeDialogUrl;

    @SerializedName("enable_cal_color_on_page_selected")
    private boolean enableCalColorOnPageSelected;

    @SerializedName("enable_display")
    private boolean enableDisplay;

    @SerializedName("enable_report_card_refresh_event")
    private boolean enableReportCardRefreshEvent;

    @SerializedName("enable_scale")
    private boolean enableScale;

    public FeedDirectPlayCloudGameConfig() {
        this.enableDisplay = true;
        this.enableScale = true;
        this.cancelSubscribeDialogUrl = "aweme://hunter_popup?surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Faweme_dissimilation_card%2Fcancel_subscribe%2Ftemplate.js&height_percent=100&width_percent=100&gravity=bottom&type=popup&channel=aweme_dissimilation_card&bundle=cancel_subscribe%2Ftemplate.js&status_font_dark=0&custom_env=default&mask_bg_color=00000057&is_common_subscribe=1&is_native_card=1";
        this.enableReportCardRefreshEvent = true;
    }

    public final String getCancelSubscribeDialogUrl() {
        return this.cancelSubscribeDialogUrl;
    }

    public final boolean getEnableCalColorOnPageSelected() {
        return this.enableCalColorOnPageSelected;
    }

    public final boolean getEnableDisplay() {
        return this.enableDisplay;
    }

    public final boolean getEnableReportCardRefreshEvent() {
        return this.enableReportCardRefreshEvent;
    }

    public final boolean getEnableScale() {
        return this.enableScale;
    }

    public final void setCancelSubscribeDialogUrl(String r100) {
        this.cancelSubscribeDialogUrl = r100;
    }

    public final void setEnableCalColorOnPageSelected(boolean r100) {
        this.enableCalColorOnPageSelected = r100;
    }

    public final void setEnableDisplay(boolean r100) {
        this.enableDisplay = r100;
    }

    public final void setEnableReportCardRefreshEvent(boolean r100) {
        this.enableReportCardRefreshEvent = r100;
    }

    public final void setEnableScale(boolean r100) {
        this.enableScale = r100;
    }
}
