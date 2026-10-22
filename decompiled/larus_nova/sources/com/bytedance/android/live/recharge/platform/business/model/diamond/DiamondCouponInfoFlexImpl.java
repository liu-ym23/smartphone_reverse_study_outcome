package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.DiamondCouponInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/DiamondCouponInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/d;", "", "couponId$delegate", "Ljava/lang/Object;", "getCouponId", "()Ljava/lang/String;", "couponId", "", "expiredTime$delegate", "getExpiredTime", "()Ljava/lang/Long;", "expiredTime", "title$delegate", "getTitle", "title", "subTitle$delegate", "getSubTitle", "subTitle", "discountAmount$delegate", "getDiscountAmount", "discountAmount", "discountAmountUtil$delegate", "getDiscountAmountUtil", "discountAmountUtil", "conditionTitle$delegate", "getConditionTitle", "conditionTitle", "", "isDisable$delegate", "isDisable", "()Z", "isSelected$delegate", "isSelected", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondCouponInfoFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("condition_title")
    protected String _$$conditionTitle;

    @SerializedName("coupon_id")
    protected String _$$couponId;

    @SerializedName("discount_amount")
    protected String _$$discountAmount;

    @SerializedName("discount_amount_util")
    protected String _$$discountAmountUtil;

    @SerializedName("expired_time")
    protected Long _$$expiredTime;

    @SerializedName("is_disable")
    protected boolean _$$isDisable;

    @SerializedName("is_selected")
    protected boolean _$$isSelected;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    public DiamondCouponInfoFlexImpl() {
        super(d.class);
        this._$$isDisable = false;
        this._$$isSelected = false;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getConditionTitle() {
        return this._$$conditionTitle;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getCouponId() {
        return this._$$couponId;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getDiscountAmount() {
        return this._$$discountAmount;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getDiscountAmountUtil() {
        return this._$$discountAmountUtil;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final Long getExpiredTime() {
        return this._$$expiredTime;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final boolean isDisable() {
        return this._$$isDisable;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.d
    public final boolean isSelected() {
        return this._$$isSelected;
    }

    public DiamondCouponInfoFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L23;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$couponId = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$expiredTime = Long.valueOf(r100.j());
        goto L3
    L9:
        if (r103 != 20) goto L11;
        this._$$isDisable = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L11:
        if (r103 != 21) goto L12;
        this._$$isSelected = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L12:
        switch(r103) {
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L15;
            case 15: goto L14;
            default: goto L13;
        };
    L14:
        this._$$conditionTitle = am3.h.c(r100);
        goto L3
    L15:
        this._$$discountAmountUtil = am3.h.c(r100);
        goto L3
    L16:
        this._$$discountAmount = am3.h.c(r100);
        goto L3
    L17:
        this._$$subTitle = am3.h.c(r100);
        goto L3
    L18:
        this._$$title = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L23:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L27;
        this._$$isDisable = false;
    L27:
        if ((r102 & 2) != 0) goto L56;
        this._$$isSelected = false;
        return;
    }
}
