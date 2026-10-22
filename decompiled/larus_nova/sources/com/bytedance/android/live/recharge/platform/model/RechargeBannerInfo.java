package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010 \u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010#\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u000fR\u001a\u0010&\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\nR\u001a\u0010)\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\nR\u001c\u0010,\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010\u000fR\u001c\u0010/\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b-\u0010\u000fR\u001a\u00102\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0006\u001a\u0004\b0\u0010\nR\u001c\u00105\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0006\u001a\u0004\b3\u0010\u000fR\u001a\u0010:\u001a\u0002068&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/RechargeBannerInfo;", "Lvh7/c;", "", "getBannerType", "()I", "getBannerType$annotations", "()V", "bannerType", "", "getBannerId", "()J", "getBannerId$annotations", "bannerId", "", "getBannerTopDescText", "()Ljava/lang/String;", "getBannerTopDescText$annotations", "bannerTopDescText", "getBannerTopDescColor", "getBannerTopDescColor$annotations", "bannerTopDescColor", "getBannerBottomDescText", "getBannerBottomDescText$annotations", "bannerBottomDescText", "getBannerBottomDescColor", "getBannerBottomDescColor$annotations", "bannerBottomDescColor", "getBannerIconImage", "getBannerIconImage$annotations", "bannerIconImage", "getBannerBgImage", "getBannerBgImage$annotations", "bannerBgImage", "getSchemeUrl", "getSchemeUrl$annotations", "schemeUrl", "getCurrentProgress", "getCurrentProgress$annotations", "currentProgress", "getTotalProgress", "getTotalProgress$annotations", "totalProgress", "getProgressBgColor", "getProgressBgColor$annotations", "progressBgColor", "getProgressIndicatorColor", "getProgressIndicatorColor$annotations", "progressIndicatorColor", "getValidEndTime", "getValidEndTime$annotations", "validEndTime", "getBannerGuideDescIcon", "getBannerGuideDescIcon$annotations", "bannerGuideDescIcon", "", "getScreenShield", "()Z", "getScreenShield$annotations", "screenShield", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface RechargeBannerInfo extends vh7.c<RechargeBannerInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "banner_bg_img")
    String getBannerBgImage();

    @FieldName(name = "banner_bottom_desc_color")
    String getBannerBottomDescColor();

    @FieldName(name = "banner_bottom_desc_text")
    String getBannerBottomDescText();

    @FieldName(name = "banner_guide_desc_img")
    String getBannerGuideDescIcon();

    @FieldName(name = "banner_icon_img")
    String getBannerIconImage();

    @FieldName(name = "banner_id")
    long getBannerId();

    @FieldName(name = "banner_top_desc_color")
    String getBannerTopDescColor();

    @FieldName(name = "banner_top_desc_text")
    String getBannerTopDescText();

    @FieldName(name = "banner_type")
    int getBannerType();

    @FieldName(name = "current_cnt")
    long getCurrentProgress();

    @FieldName(name = "progress_bg_color")
    String getProgressBgColor();

    @FieldName(name = "progress_indicator_color")
    String getProgressIndicatorColor();

    @FieldName(name = "scheme_url")
    String getSchemeUrl();

    @FieldName(name = "screen_shield")
    boolean getScreenShield();

    @FieldName(name = "total_progress")
    long getTotalProgress();

    @FieldName(name = "valid_end_time")
    long getValidEndTime();
}
