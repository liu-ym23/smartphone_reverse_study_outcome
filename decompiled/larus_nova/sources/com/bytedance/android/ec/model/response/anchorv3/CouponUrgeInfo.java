package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.open.SocialConstants;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CouponUrgeInfo;", "Ljava/io/Serializable;", "()V", "bgImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "couponId", "", "getCouponId", "()J", "couponMetaId", "getCouponMetaId", "couponType", "", "getCouponType", "()I", SocialConstants.PARAM_APP_DESC, "", "getDesc", "()Ljava/lang/String;", "descShort", "getDescShort", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime", "price", "getPrice", "showTimePerDay", "getShowTimePerDay", DyPayConstant.KEY_START_TIME, "getStartTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CouponUrgeInfo implements Serializable {

    @SerializedName("bg_img")
    private final ECUrlModel bgImg;

    @SerializedName("coupon_id")
    private final long couponId;

    @SerializedName("coupon_meta_id")
    private final long couponMetaId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private final int couponType;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("desc_short")
    private final String descShort;

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("credit")
    private final int price;

    @SerializedName("show_time_per_day")
    private final int showTimePerDay;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public CouponUrgeInfo() {
        this.desc = "";
        this.descShort = "";
        this.expireTime = 1;
    }

    public final ECUrlModel getBgImg() {
        return this.bgImg;
    }

    public final long getCouponId() {
        return this.couponId;
    }

    public final long getCouponMetaId() {
        return this.couponMetaId;
    }

    public final int getCouponType() {
        return this.couponType;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescShort() {
        return this.descShort;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getShowTimePerDay() {
        return this.showTimePerDay;
    }

    public final long getStartTime() {
        return this.startTime;
    }
}
