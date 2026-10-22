package com.bytedance.android.livesdk.commerce.coupon;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.common.data.DataHolder;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class d {

    @SerializedName("avatar")
    String avatar;

    @SerializedName("can_continue_apply")
    boolean canContinueApply;

    @SerializedName("channel_id")
    long channelId;

    @SerializedName("coupon_meta_id")
    String couponMetaId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_NAME)
    String couponName;

    @SerializedName("coupon_reset")
    boolean couponReset;

    @SerializedName("coupon_source")
    int couponSource;

    @SerializedName("coupon_status")
    boolean couponStatus;

    @SerializedName("coupon_string")
    String couponString;

    @SerializedName("credit")
    long credit;

    @SerializedName("discount")
    double discount;

    @SerializedName("end_apply_time")
    String endApplyTime;

    @SerializedName("expire_time")
    String expireTime;

    @SerializedName("expire_time_timestamp")
    long expireTimeStamp;

    @SerializedName("has_applied")
    long hasApplied;

    @SerializedName("has_available_goods")
    boolean hasAvailableGoods;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    long isShow;

    @SerializedName("kol_uid")
    long kolUid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG)
    int kolUserTag;

    @SerializedName("left_amount")
    long leftAmount;

    @SerializedName("live_coupon_status")
    int liveCouponStatus;

    @SerializedName("max_apply_times")
    long maxApplyTimes;

    @SerializedName("max_discount_limit")
    long maxDiscountLimit;

    @SerializedName("pay_type")
    long payType;

    @SerializedName("period_type")
    long periodType;

    @SerializedName("platform_sub_type")
    long platformSubType;

    @SerializedName("product_ids")
    List<Long> productIds;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    String shopId;

    @SerializedName("shop_logo")
    String shopLogo;

    @SerializedName("shop_name")
    String shopName;

    @SerializedName("start_apply_time")
    String startApplyTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    String startTime;

    @SerializedName("start_time_timestamp")
    long startTimeStamp;

    @SerializedName("status")
    long status;

    @SerializedName("threshold")
    long threshold;

    @SerializedName("total_amount")
    long totalAmount;

    @SerializedName("type")
    long type;

    @SerializedName("type_detail")
    String typeDetail;

    @SerializedName(DataHolder.TYPE_STRING)
    String typeString;

    @SerializedName("type_title")
    String typeTitle;

    @SerializedName("url")
    String url;

    @SerializedName("user_apply_times")
    long userApplyTimes;

    @SerializedName("valid_period")
    long validPeriod;

    @SerializedName("what_coupon")
    String whatCoupon;

    public d() {
    }
}
