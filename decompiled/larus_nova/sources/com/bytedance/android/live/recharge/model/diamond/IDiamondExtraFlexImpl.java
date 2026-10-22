package com.bytedance.android.live.recharge.model.diamond;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.diamond.DiamondExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/recharge/model/diamond/IDiamondExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/model/diamond/e;", "", "couponInfo$delegate", "Ljava/lang/Object;", "getCouponInfo", "()Ljava/lang/String;", "couponInfo", "confirmButtonUpperBubbleInfo$delegate", "getConfirmButtonUpperBubbleInfo", "confirmButtonUpperBubbleInfo", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDiamondExtraFlexImpl extends FlexModelBase<e> implements e, h {

    @SerializedName("confirm_button_upper_right_bubble_info")
    protected String _$$confirmButtonUpperBubbleInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO)
    protected String _$$couponInfo;

    public IDiamondExtraFlexImpl() {
        super(e.class);
    }

    public IDiamondExtraFlexImpl(g r100) {
        super(e.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$couponInfo = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$confirmButtonUpperBubbleInfo = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.recharge.model.diamond.e
    public final String getConfirmButtonUpperBubbleInfo() {
        return this._$$confirmButtonUpperBubbleInfo;
    }

    @Override // com.bytedance.android.live.recharge.model.diamond.e
    public final String getCouponInfo() {
        return this._$$couponInfo;
    }
}
