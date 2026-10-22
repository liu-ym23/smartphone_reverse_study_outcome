package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R6\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/g;", "Lvh7/c;", "", "getCouponInfo", "()Ljava/lang/String;", "getCouponInfo$annotations", "()V", "couponInfo", "getConfirmButtonUpperBubbleInfo", "getConfirmButtonUpperBubbleInfo$annotations", "confirmButtonUpperBubbleInfo", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/a;", "getCouponBarInfo", "()Lcom/bytedance/android/live/recharge/platform/business/model/diamond/a;", "getCouponBarInfo$annotations", "couponBarInfo", "getDiamondDesc", "getDiamondDesc$annotations", "diamondDesc", "getConfirmButtonDesc", "getConfirmButtonDesc$annotations", "confirmButtonDesc", "getPreCalcInfo", "getPreCalcInfo$annotations", "preCalcInfo", "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/i;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getEventMap", "()Ljava/util/Map;", "getEventMap$annotations", "eventMap", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "confirm_button_desc")
    String getConfirmButtonDesc();

    @FieldName(name = "confirm_button_upper_right_bubble_info")
    String getConfirmButtonUpperBubbleInfo();

    @FieldName(name = "coupon_bar_info")
    com.bytedance.android.live.recharge.platform.business.model.diamond.a getCouponBarInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO)
    String getCouponInfo();

    @FieldName(name = "diamond_desc")
    String getDiamondDesc();

    @FieldName(name = "event_map")
    Map<String, i> getEventMap();

    @FieldName(name = "pre_calc_info")
    String getPreCalcInfo();
}
