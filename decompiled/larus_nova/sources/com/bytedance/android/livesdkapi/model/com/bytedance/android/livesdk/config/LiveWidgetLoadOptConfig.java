package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveWidgetLoadOptConfig;", "", "()V", "backtrackLoadOpt", "", "getBacktrackLoadOpt", "()Z", "setBacktrackLoadOpt", "(Z)V", "ceremonyBorderWidgetLoadOpt", "getCeremonyBorderWidgetLoadOpt", "setCeremonyBorderWidgetLoadOpt", "endWidgetLoadOpt", "getEndWidgetLoadOpt", "setEndWidgetLoadOpt", "giftTouchWidgetLoadOpt", "getGiftTouchWidgetLoadOpt", "setGiftTouchWidgetLoadOpt", "recordLoadOpt", "getRecordLoadOpt", "setRecordLoadOpt", "removeCommonLottieAnimationWidget", "getRemoveCommonLottieAnimationWidget", "setRemoveCommonLottieAnimationWidget", "removeVSLiveDetail", "getRemoveVSLiveDetail", "setRemoveVSLiveDetail", "widgetReportOpt", "getWidgetReportOpt", "setWidgetReportOpt", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWidgetLoadOptConfig {

    @SerializedName("backtrack_load_opt")
    private boolean backtrackLoadOpt;

    @SerializedName("ceremonyborder_widget_load_opt")
    private boolean ceremonyBorderWidgetLoadOpt;

    @SerializedName("end_widget_load_opt")
    private boolean endWidgetLoadOpt;

    @SerializedName("gift_touch_widget_load_opt")
    private boolean giftTouchWidgetLoadOpt;

    @SerializedName("record_load_opt")
    private boolean recordLoadOpt;

    @SerializedName("remove_common_lottie_animation_widget")
    private boolean removeCommonLottieAnimationWidget;

    @SerializedName("remove_vs_live_detail_widget")
    private boolean removeVSLiveDetail;

    @SerializedName("remove_widget_report")
    private boolean widgetReportOpt;

    public LiveWidgetLoadOptConfig() {
    }

    public final boolean getBacktrackLoadOpt() {
        return this.backtrackLoadOpt;
    }

    public final boolean getCeremonyBorderWidgetLoadOpt() {
        return this.ceremonyBorderWidgetLoadOpt;
    }

    public final boolean getEndWidgetLoadOpt() {
        return this.endWidgetLoadOpt;
    }

    public final boolean getGiftTouchWidgetLoadOpt() {
        return this.giftTouchWidgetLoadOpt;
    }

    public final boolean getRecordLoadOpt() {
        return this.recordLoadOpt;
    }

    public final boolean getRemoveCommonLottieAnimationWidget() {
        return this.removeCommonLottieAnimationWidget;
    }

    public final boolean getRemoveVSLiveDetail() {
        return this.removeVSLiveDetail;
    }

    public final boolean getWidgetReportOpt() {
        return this.widgetReportOpt;
    }

    public final void setBacktrackLoadOpt(boolean r100) {
        this.backtrackLoadOpt = r100;
    }

    public final void setCeremonyBorderWidgetLoadOpt(boolean r100) {
        this.ceremonyBorderWidgetLoadOpt = r100;
    }

    public final void setEndWidgetLoadOpt(boolean r100) {
        this.endWidgetLoadOpt = r100;
    }

    public final void setGiftTouchWidgetLoadOpt(boolean r100) {
        this.giftTouchWidgetLoadOpt = r100;
    }

    public final void setRecordLoadOpt(boolean r100) {
        this.recordLoadOpt = r100;
    }

    public final void setRemoveCommonLottieAnimationWidget(boolean r100) {
        this.removeCommonLottieAnimationWidget = r100;
    }

    public final void setRemoveVSLiveDetail(boolean r100) {
        this.removeVSLiveDetail = r100;
    }

    public final void setWidgetReportOpt(boolean r100) {
        this.widgetReportOpt = r100;
    }
}
