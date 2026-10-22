package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/w1;", "", "", "noBeautySwitchGuidePopup", "Ljava/lang/Boolean;", "getNoBeautySwitchGuidePopup", "()Ljava/lang/Boolean;", "setNoBeautySwitchGuidePopup", "(Ljava/lang/Boolean;)V", "enableCommodityNoFilter", "b", "setEnableCommodityNoFilter", "enableNoFilterLabel", "getEnableNoFilterLabel", "setEnableNoFilterLabel", "enableAreaFilter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableAreaFilter", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w1 {

    @SerializedName("enable_area_filter")
    private Boolean enableAreaFilter;

    @SerializedName("enable_commodity_no_filter_mode")
    private Boolean enableCommodityNoFilter;

    @SerializedName("enable_no_filter_label")
    private Boolean enableNoFilterLabel;

    @SerializedName("no_beauty_switch_guide_popup")
    private Boolean noBeautySwitchGuidePopup;

    public w1() {
        Boolean r100 = Boolean.TRUE;
        this.noBeautySwitchGuidePopup = r100;
        this.enableCommodityNoFilter = r100;
        Boolean r101 = Boolean.FALSE;
        this.enableNoFilterLabel = r101;
        this.enableAreaFilter = r101;
    }

    public final Boolean a() {
        return this.enableAreaFilter;
    }

    public final Boolean b() {
        return this.enableCommodityNoFilter;
    }
}
