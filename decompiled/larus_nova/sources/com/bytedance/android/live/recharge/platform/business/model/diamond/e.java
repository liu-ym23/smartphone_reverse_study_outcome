package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;", "Lvh7/c;", "", "getId", "()J", "getId$annotations", "()V", "id", "", "getMinPrice", "()I", "getMinPrice$annotations", "minPrice", "getMaxPrice", "getMaxPrice$annotations", "maxPrice", "", "getDiamondCountRate", "()F", "getDiamondCountRate$annotations", "diamondCountRate", "getRewardDiamondCount", "getRewardDiamondCount$annotations", "rewardDiamondCount", "", "getDescribe", "()Ljava/lang/String;", "getDescribe$annotations", "describe", "getCouponId", "getCouponId$annotations", "couponId", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "coupon_id")
    String getCouponId();

    @FieldName(name = "describe")
    String getDescribe();

    @FieldName(name = "diamond_count_rate")
    float getDiamondCountRate();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "price_max")
    int getMaxPrice();

    @FieldName(name = "price_min")
    int getMinPrice();

    @FieldName(name = "giving_count")
    int getRewardDiamondCount();
}
