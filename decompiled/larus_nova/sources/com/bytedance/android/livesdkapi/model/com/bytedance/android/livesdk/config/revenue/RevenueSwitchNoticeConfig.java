package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.revenue;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R \u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R \u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R \u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R \u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R \u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/revenue/RevenueSwitchNoticeConfig;", "", "()V", "boldRanges", "", "", "getBoldRanges", "()Ljava/util/List;", "setBoldRanges", "(Ljava/util/List;)V", "colorRanges", "getColorRanges", "setColorRanges", "fansSubTitle", "", "getFansSubTitle", "()Ljava/lang/String;", "setFansSubTitle", "(Ljava/lang/String;)V", "gapDay", "getGapDay", "()I", "setGapDay", "(I)V", "giftSubTitle", "getGiftSubTitle", "setGiftSubTitle", "noticePopupButtonText", "getNoticePopupButtonText", "setNoticePopupButtonText", "noticePopupMainText", "getNoticePopupMainText", "setNoticePopupMainText", "noticePopupSubText", "getNoticePopupSubText", "setNoticePopupSubText", "redEnvelopSubTitle", "getRedEnvelopSubTitle", "setRedEnvelopSubTitle", "settingPanelEntranceText", "getSettingPanelEntranceText", "setSettingPanelEntranceText", "vipSubTitle", "getVipSubTitle", "setVipSubTitle", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevenueSwitchNoticeConfig {

    @SerializedName("bold_ranges")
    private List<? extends List<Integer>> boldRanges;

    @SerializedName("color_ranges")
    private List<? extends List<Integer>> colorRanges;

    @SerializedName("fans_sub_title")
    private String fansSubTitle;

    @SerializedName("gap_day")
    private int gapDay;

    @SerializedName("gift_sub_title")
    private String giftSubTitle;

    @SerializedName("notice_popup_button_text")
    private String noticePopupButtonText;

    @SerializedName("notice_popup_main_text")
    private String noticePopupMainText;

    @SerializedName("notice_popup_sub_text")
    private String noticePopupSubText;

    @SerializedName("red_envelope_sub_title")
    private String redEnvelopSubTitle;

    @SerializedName("setting_panel_entrance_text")
    private String settingPanelEntranceText;

    @SerializedName("vip_sub_title")
    private String vipSubTitle;

    public RevenueSwitchNoticeConfig() {
        this.gapDay = 1;
        this.noticePopupMainText = "风险提示";
        this.noticePopupSubText = "该功能仅主播可使用，不会扣费，任何自称抖音客服来电，让您关闭或者注销功能、下载软件、共享屏幕，都是诈骗!";
        this.noticePopupButtonText = "我知道了";
        this.settingPanelEntranceText = "直播间收入功能";
        this.giftSubTitle = "关闭或者开启后，仅影响主播本场直播收礼";
        this.fansSubTitle = "关闭或者开启后，仅影响观众在本场直播加入粉丝团";
        this.redEnvelopSubTitle = "关闭或者开启后，仅影响观众在本场直播发放红包";
        this.vipSubTitle = "关闭或开启后，会员所有购买页面均受影响";
        this.colorRanges = CollectionsKt.listOf(new List[]{CollectionsKt.listOf(new Integer[]{17, 23}), CollectionsKt.listOf(new Integer[]{28, 52})});
    }

    public final List<List<Integer>> getBoldRanges() {
        return this.boldRanges;
    }

    public final List<List<Integer>> getColorRanges() {
        return this.colorRanges;
    }

    public final String getFansSubTitle() {
        return this.fansSubTitle;
    }

    public final int getGapDay() {
        return this.gapDay;
    }

    public final String getGiftSubTitle() {
        return this.giftSubTitle;
    }

    public final String getNoticePopupButtonText() {
        return this.noticePopupButtonText;
    }

    public final String getNoticePopupMainText() {
        return this.noticePopupMainText;
    }

    public final String getNoticePopupSubText() {
        return this.noticePopupSubText;
    }

    public final String getRedEnvelopSubTitle() {
        return this.redEnvelopSubTitle;
    }

    public final String getSettingPanelEntranceText() {
        return this.settingPanelEntranceText;
    }

    public final String getVipSubTitle() {
        return this.vipSubTitle;
    }

    public final void setBoldRanges(List<? extends List<Integer>> r100) {
        this.boldRanges = r100;
    }

    public final void setColorRanges(List<? extends List<Integer>> r100) {
        this.colorRanges = r100;
    }

    public final void setFansSubTitle(String r100) {
        this.fansSubTitle = r100;
    }

    public final void setGapDay(int r100) {
        this.gapDay = r100;
    }

    public final void setGiftSubTitle(String r100) {
        this.giftSubTitle = r100;
    }

    public final void setNoticePopupButtonText(String r100) {
        this.noticePopupButtonText = r100;
    }

    public final void setNoticePopupMainText(String r100) {
        this.noticePopupMainText = r100;
    }

    public final void setNoticePopupSubText(String r100) {
        this.noticePopupSubText = r100;
    }

    public final void setRedEnvelopSubTitle(String r100) {
        this.redEnvelopSubTitle = r100;
    }

    public final void setSettingPanelEntranceText(String r100) {
        this.settingPanelEntranceText = r100;
    }

    public final void setVipSubTitle(String r100) {
        this.vipSubTitle = r100;
    }
}
