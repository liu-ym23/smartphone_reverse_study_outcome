package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/e21;", "", "", "couponIconUrl", "Ljava/lang/String;", "getCouponIconUrl", "()Ljava/lang/String;", "setCouponIconUrl", "(Ljava/lang/String;)V", "couponEntryUrl", "getCouponEntryUrl", "setCouponEntryUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e21 {

    @SerializedName("ec_coupon_entry_url")
    private String couponEntryUrl;

    @SerializedName("ec_coupon_icon_url")
    private String couponIconUrl;

    public e21() {
        this.couponIconUrl = "aweme://lynxview/?channel=fe_lynx_commerce_webcast_entry_coupon&bundle=coupon_icon/template.js";
        this.couponEntryUrl = "aweme://lynxview/?channel=fe_lynx_commerce_webcast_entry_coupon&bundle=small_entry_coupon/template.js";
    }
}
