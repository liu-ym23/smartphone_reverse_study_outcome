package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/coupon/f;", "", "", "couponIconUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setCouponIconUrl", "(Ljava/lang/String;)V", "couponEntryUrl", "b", "setCouponEntryUrl", "couponDialogUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCouponDialogUrl", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f151834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f151835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f151836c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f151837d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f151838e = null;

    @SerializedName("ec_coupon_dialog_url")
    private String couponDialogUrl;

    @SerializedName("ec_coupon_entry_url")
    private String couponEntryUrl;

    @SerializedName("ec_coupon_icon_url")
    private String couponIconUrl;

    public static final class a {
    }

    static {
        f151834a = new f();
        f151835b = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_short_touch_coupon/app/coupon_mini_icon/template.js?bd_hybrid_monitor_bid=ecom_marketing_live_short_touch";
        f151836c = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_short_touch_coupon/app/coupon_entry_view/template.js?bd_hybrid_monitor_bid=ecom_marketing_live_short_touch";
        f151837d = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_short_touch_coupon%2Fapp%2Fcoupon_dialog%2Ftemplate.js&load_taro=0&type=popup&horizontal_height_percent=100&horizontal_width_percent=100&height_percent=100&width_percent=100&open_animate=0&top_level=1&mask_alpha=0.5&show_dim=0";
        f151838e = "sslocal://webcast_lynxview?url=https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/fe_lynx_ecom_marketing/short_touch_coupon_dialog/template.js&load_taro=0&type=popup&horizontal_height_percent=100&horizontal_width_percent=100&height_percent=100&width_percent=100&open_animate=0&top_level=1&mask_alpha=0.5&show_dim=0";
    }

    public f() {
        this.couponIconUrl = f151835b;
        this.couponEntryUrl = f151836c;
        this.couponDialogUrl = f151837d;
    }

    public final String a() {
        return this.couponDialogUrl;
    }

    public final String b() {
        return this.couponEntryUrl;
    }

    public final String c() {
        return this.couponIconUrl;
    }
}
